package com.gensee.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.gensee.common.PlayerWork;
import com.gensee.download.db.VodDataBaseManager;
import com.gensee.utils.GenseeLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class VodDownLoadManager extends PlayerWork
  implements VodDownLoadImpl.VodDownLoadImplInterface
{
  public static final String DEF_SAVE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "GSVod" + File.separator + "DownLoad" + File.separator;
  private String UUID;
  private Context context;
  private AtomicBoolean isAutoDownloading = new AtomicBoolean(true);
  private ReentrantReadWriteLock lock;
  private VodDownLoadEntity mCurDownloadEntity;
  private String saveDir;
  private VodDataBaseManager vodDataBaseManager;
  private VodDownLoadImpl vodDownLoadImpl;
  private VodDownLoadJni vodDownLoadJni;
  private List<VodDownLoadEntity> vodDownLoadList;

  public VodDownLoadManager(Context paramContext, String paramString1, VodDownLoadCallback paramVodDownLoadCallback, String paramString2)
  {
    GenseeLog.i("VodDownLoadManager Create UUID = " + paramString1);
    this.vodDownLoadList = new ArrayList();
    this.context = paramContext.getApplicationContext();
    this.lock = new ReentrantReadWriteLock();
    this.vodDataBaseManager = new VodDataBaseManager(paramContext);
    this.vodDownLoadJni = new VodDownLoadJni();
    this.vodDownLoadImpl = new VodDownLoadImpl(paramVodDownLoadCallback, this);
    this.UUID = paramString1;
    this.saveDir = paramString2;
    this.isAutoDownloading.set(true);
  }

  private VodDownLoadEntity _getVodByDownLoadId(String paramString)
  {
    Iterator localIterator = this.vodDownLoadList.iterator();
    VodDownLoadEntity localVodDownLoadEntity;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localVodDownLoadEntity = (VodDownLoadEntity)localIterator.next();
    }
    while (!localVodDownLoadEntity.getDownLoadId().equals(paramString));
    return localVodDownLoadEntity;
  }

  private boolean _isDownloadingTask()
  {
    Iterator localIterator = this.vodDownLoadList.iterator();
    do
      if (!localIterator.hasNext())
        return false;
    while (!((VodDownLoadEntity)localIterator.next()).isDownloading());
    return true;
  }

  private VodDownLoadEntity _nextVodDownloading()
  {
    this.lock.readLock().lock();
    while (true)
    {
      Object localObject2;
      try
      {
        Iterator localIterator1 = this.vodDownLoadList.iterator();
        if (localIterator1.hasNext())
          continue;
        int i = 0;
        localObject2 = null;
        if (i == 0)
        {
          Iterator localIterator2 = this.vodDownLoadList.iterator();
          boolean bool = localIterator2.hasNext();
          if (bool)
            continue;
          localObject3 = localObject2;
          return localObject3;
          VodDownLoadEntity localVodDownLoadEntity = (VodDownLoadEntity)localIterator1.next();
          if (("".equals(localVodDownLoadEntity.getDownLoadUrl())) || (localVodDownLoadEntity.getnStatus() != VodDownLoadStatus.STOP.getStatus()) || (localVodDownLoadEntity.getnStopStatus() != 0))
            continue;
          localObject2 = localVodDownLoadEntity;
          i = 1;
          continue;
          localObject3 = (VodDownLoadEntity)localIterator2.next();
          if (("".equals(((VodDownLoadEntity)localObject3).getDownLoadUrl())) || (((VodDownLoadEntity)localObject3).getnStatus() != VodDownLoadStatus.WAIT.getStatus()))
            continue;
          int j = ((VodDownLoadEntity)localObject3).getnStopStatus();
          if (j != 0)
            continue;
          continue;
        }
      }
      finally
      {
        this.lock.readLock().unlock();
      }
      Object localObject3 = localObject2;
    }
  }

  private void _setVodDownLoadStatus(String paramString, int paramInt)
  {
    VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
    if (localVodDownLoadEntity != null)
    {
      localVodDownLoadEntity.setnStatus(paramInt);
      this.vodDataBaseManager.updateByDownLoadId(localVodDownLoadEntity);
    }
  }

  private int _start(String paramString)
  {
    VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
    int i;
    if (localVodDownLoadEntity == null)
      i = -201;
    VodDownLoadImpl localVodDownLoadImpl;
    do
    {
      return i;
      if ((localVodDownLoadEntity.getDownLoadUrl() == null) || ("".equals(localVodDownLoadEntity.getDownLoadUrl())))
        return 6;
      localVodDownLoadEntity.setnStopStatus(0);
      this.vodDataBaseManager.updateByDownLoadId(localVodDownLoadEntity);
      if (this.mCurDownloadEntity != null)
        return 2;
      if (!SDCardUtil.isExistSDCard())
        return 3;
      File localFile = new File(getSaveDir());
      if ((!localFile.exists()) && (!localFile.mkdirs()))
        return 9;
      if (!initDownLoadService(localVodDownLoadEntity))
        return 8;
      checkDownloadDir(paramString);
      this.mCurDownloadEntity = localVodDownLoadEntity;
      addTask(new VodDownLoadManager.4(this, paramString, localVodDownLoadEntity));
      localVodDownLoadImpl = this.vodDownLoadImpl;
      i = 0;
    }
    while (localVodDownLoadImpl == null);
    _setVodDownLoadStatus(paramString, VodDownLoadStatus.BEGIN.getStatus());
    return 0;
  }

  private void _stop(String paramString)
  {
    if ((this.mCurDownloadEntity != null) && (paramString != null) && (paramString.equals(this.mCurDownloadEntity.getDownLoadId())))
    {
      GenseeLog.i("VodDownLoadManager stopDownLoading = " + paramString);
      addTask(new VodDownLoadManager.5(this, paramString));
      return;
    }
    GenseeLog.i("not current downloading VodDownLoadManager stopDownLoading = " + paramString);
  }

  private void checkDownloadDir(String paramString)
  {
    int i = 1;
    File localFile = new File(getSaveDir() + this.UUID + File.separator + paramString + File.separator);
    if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.listFiles().length <= i))
      i = 0;
    if (i == 0)
    {
      deleteFile(localFile);
      GenseeLog.i("VodDownLoadManager checkDownloadDir deleteFile downLoadId = " + paramString);
    }
  }

  private void deleteFile(File paramFile)
  {
    if (paramFile.isFile())
      paramFile.delete();
    do
      return;
    while (!paramFile.isDirectory());
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfFile.length)
      {
        paramFile.delete();
        return;
      }
      deleteFile(arrayOfFile[i]);
    }
  }

  private boolean initDownLoadService(VodDownLoadEntity paramVodDownLoadEntity)
  {
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences("gsol", 0);
    long l1 = localSharedPreferences.getLong("siteId", 0L);
    long l2 = localSharedPreferences.getLong("userId", 0L);
    String str1 = localSharedPreferences.getString("userName", "");
    String str2 = localSharedPreferences.getString("albAddress", "");
    if (paramVodDownLoadEntity.getSiteId() <= 0L)
    {
      if (paramVodDownLoadEntity.getUserId() > 0L)
        break label258;
      label79: if (!"".equals(paramVodDownLoadEntity.getNickName()))
        break label267;
      label91: if (!"".equals(paramVodDownLoadEntity.getConnectSvr()))
        break label276;
    }
    while (true)
    {
      if ((str2 != null) && (!"".equals(str2)) && (!str2.contains("http://")))
        str2 = "http://" + str2;
      GenseeLog.i("VodDownLoadManagerinitDownLoadService downLoadId = " + paramVodDownLoadEntity.getDownLoadId() + " siteId = " + l1 + " userId = " + l2 + " nickName = " + str1 + " connectSvr = " + str2);
      if ((l1 > 0L) && (l2 > 0L) && (!"".equals(str1)) && (!"".equals(str2)))
        break label285;
      return false;
      l1 = paramVodDownLoadEntity.getSiteId();
      break;
      label258: l2 = paramVodDownLoadEntity.getUserId();
      break label79;
      label267: str1 = paramVodDownLoadEntity.getNickName();
      break label91;
      label276: str2 = paramVodDownLoadEntity.getConnectSvr();
    }
    label285: return addTask(new VodDownLoadManager.2(this, l1, l2, str1, str2));
  }

  private void releaseDownLoadService()
  {
    GenseeLog.i("VodDownLoadManager releaseDownLoadService");
    this.mCurDownloadEntity = null;
    addTask(new VodDownLoadManager.1(this));
  }

  public int add(VodDownLoadEntity paramVodDownLoadEntity)
  {
    int i = 0;
    this.lock.writeLock().lock();
    paramVodDownLoadEntity.setUUID(this.UUID);
    try
    {
      if (_getVodByDownLoadId(paramVodDownLoadEntity.getDownLoadId()) == null)
      {
        this.vodDownLoadList.add(paramVodDownLoadEntity);
        this.vodDataBaseManager.insert(paramVodDownLoadEntity);
        GenseeLog.i("VodDownLoadManager add _start = " + 0 + " downloadId = " + paramVodDownLoadEntity.getDownLoadId());
        return i;
      }
      i = 1;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }

  public void autoStart()
  {
    VodDownLoadEntity localVodDownLoadEntity = _nextVodDownloading();
    if (localVodDownLoadEntity != null)
      start(localVodDownLoadEntity.getDownLoadId());
  }

  public void delete(String paramString)
  {
    GenseeLog.i("VodDownLoadManager delete downLoadId = " + paramString);
    this.lock.writeLock().lock();
    try
    {
      Iterator localIterator = this.vodDownLoadList.iterator();
      boolean bool = localIterator.hasNext();
      if (!bool);
      while (true)
      {
        return;
        VodDownLoadEntity localVodDownLoadEntity = (VodDownLoadEntity)localIterator.next();
        if (!localVodDownLoadEntity.getDownLoadId().equals(paramString))
          break;
        if (localVodDownLoadEntity.isDownloading())
          _stop(paramString);
        this.vodDownLoadList.remove(localVodDownLoadEntity);
        this.vodDataBaseManager.removeByDownLoadId(localVodDownLoadEntity.getUUID(), paramString);
        deleteFile(new File(getSaveDir() + this.UUID + File.separator + paramString + File.separator));
      }
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public void delete(List<String> paramList)
  {
    GenseeLog.i("VodDownLoadManager deletelist = " + paramList.toString());
    this.lock.writeLock().lock();
    while (true)
    {
      Iterator localIterator3;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator1 = paramList.iterator();
        if (localIterator1.hasNext())
          continue;
        this.vodDownLoadList.removeAll(localArrayList);
        this.vodDataBaseManager.removeByDownLoadIds(this.UUID, paramList);
        localIterator3 = localArrayList.iterator();
        boolean bool = localIterator3.hasNext();
        if (!bool)
        {
          return;
          String str = (String)localIterator1.next();
          Iterator localIterator2 = this.vodDownLoadList.iterator();
          if (!localIterator2.hasNext())
            continue;
          VodDownLoadEntity localVodDownLoadEntity1 = (VodDownLoadEntity)localIterator2.next();
          if (!localVodDownLoadEntity1.getDownLoadId().equals(str))
            continue;
          localArrayList.add(localVodDownLoadEntity1);
          if (!localVodDownLoadEntity1.isDownloading())
            continue;
          _stop(str);
          continue;
          continue;
        }
      }
      finally
      {
        this.lock.writeLock().unlock();
      }
      VodDownLoadEntity localVodDownLoadEntity2 = (VodDownLoadEntity)localIterator3.next();
      deleteFile(new File(getSaveDir() + this.UUID + File.separator + localVodDownLoadEntity2.getDownLoadId() + File.separator));
    }
  }

  public VodDownLoadEntity getCurrentDownloadingEntity()
  {
    return this.mCurDownloadEntity;
  }

  public boolean getIsAutoDownloading()
  {
    return this.isAutoDownloading.get();
  }

  public String getPlayUrl(String paramString)
  {
    return getSaveDir() + this.UUID + File.separator + paramString + File.separator + "record.xml";
  }

  public String getSaveDir()
  {
    if ((this.saveDir == null) || ("".equals(this.saveDir)))
      return DEF_SAVE_DIR;
    return this.saveDir;
  }

  public VodDownLoadEntity getVodByDownLoadId(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      Iterator localIterator = this.vodDownLoadList.iterator();
      boolean bool1 = localIterator.hasNext();
      VodDownLoadEntity localVodDownLoadEntity2;
      if (!bool1)
        localVodDownLoadEntity2 = null;
      while (true)
      {
        return localVodDownLoadEntity2;
        VodDownLoadEntity localVodDownLoadEntity1 = (VodDownLoadEntity)localIterator.next();
        boolean bool2 = localVodDownLoadEntity1.getDownLoadId().equals(paramString);
        if (!bool2)
          break;
        try
        {
          localVodDownLoadEntity2 = (VodDownLoadEntity)localVodDownLoadEntity1.clone();
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          localCloneNotSupportedException.printStackTrace();
          localVodDownLoadEntity2 = null;
        }
      }
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public List<VodDownLoadEntity> getVodDownLoadList()
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.writeLock().lock();
    try
    {
      if (this.vodDownLoadList.size() <= 0)
        this.vodDownLoadList.addAll(this.vodDataBaseManager.queryByUUID(this.UUID));
      Iterator localIterator = this.vodDownLoadList.iterator();
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
          return localArrayList;
        VodDownLoadEntity localVodDownLoadEntity = (VodDownLoadEntity)localIterator.next();
        try
        {
          localArrayList.add((VodDownLoadEntity)localVodDownLoadEntity.clone());
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          localCloneNotSupportedException.printStackTrace();
        }
      }
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public int getVodDownLoadStatusByDlId(String paramString)
  {
    int i = VodDownLoadStatus.WAIT.getStatus();
    this.lock.readLock().lock();
    try
    {
      VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
      if (localVodDownLoadEntity != null)
      {
        int j = localVodDownLoadEntity.getnStatus();
        i = j;
      }
      return i;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public boolean isDownloadingByDlId(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
      int i = 0;
      if (localVodDownLoadEntity != null)
        if (localVodDownLoadEntity.getnStatus() != VodDownLoadStatus.BEGIN.getStatus())
        {
          int j = localVodDownLoadEntity.getnStatus();
          int k = VodDownLoadStatus.START.getStatus();
          i = 0;
          if (j != k);
        }
        else
        {
          i = 1;
        }
      return i;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public boolean isDownloadingTask()
  {
    this.lock.readLock().lock();
    try
    {
      boolean bool = _isDownloadingTask();
      return bool;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public void nextVodDownloading()
  {
    if (!this.isAutoDownloading.get());
    VodDownLoadEntity localVodDownLoadEntity;
    do
    {
      return;
      localVodDownLoadEntity = _nextVodDownloading();
    }
    while (localVodDownLoadEntity == null);
    GenseeLog.i("VodDownLoadManager nextVodDownloading downloadId = " + localVodDownLoadEntity.getDownLoadId());
    start(localVodDownLoadEntity.getDownLoadId());
  }

  public void release()
  {
    GenseeLog.i("VodDownLoadManager release()");
    if (this.mCurDownloadEntity != null)
    {
      _stop(this.mCurDownloadEntity.getDownLoadId());
      _setVodDownLoadStatus(this.mCurDownloadEntity.getDownLoadId(), VodDownLoadStatus.STOP.getStatus());
      this.mCurDownloadEntity = null;
    }
    this.vodDownLoadList.clear();
    addTask(new VodDownLoadManager.3(this));
  }

  public void releaseDownloading()
  {
    releaseDownLoadService();
  }

  public void setIsAutoDownloading(boolean paramBoolean)
  {
    this.isAutoDownloading.set(paramBoolean);
  }

  public void setVodDownLoadStatus(String paramString, int paramInt)
  {
    this.lock.writeLock().lock();
    try
    {
      _setVodDownLoadStatus(paramString, paramInt);
      return;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public void setVodDownLoadStopStatus(String paramString, int paramInt)
  {
    this.lock.writeLock().lock();
    try
    {
      VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
      if (localVodDownLoadEntity != null)
      {
        localVodDownLoadEntity.setnStopStatus(paramInt);
        this.vodDataBaseManager.updateByDownLoadId(localVodDownLoadEntity);
      }
      return;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public int start(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      int i = _start(paramString);
      GenseeLog.i("VodDownLoadManager start _start = " + i + " downloadId = " + paramString);
      this.lock.readLock().unlock();
      if ((i == 0) && (this.vodDownLoadImpl != null))
        this.vodDownLoadImpl.onBegin(paramString);
      return i;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public void stop(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      _stop(paramString);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    throw localObject;
  }

  public void stopDownLoading(String paramString)
  {
    GenseeLog.i("VodDownLoadManager stopDownLoading downLoadId = " + paramString);
    addTask(new VodDownLoadManager.6(this, paramString));
  }

  public void updateVdUrl(String paramString1, String paramString2)
  {
    this.lock.writeLock().lock();
    try
    {
      Iterator localIterator = this.vodDownLoadList.iterator();
      VodDownLoadEntity localVodDownLoadEntity;
      if (!localIterator.hasNext())
        localVodDownLoadEntity = null;
      while (true)
      {
        if (localVodDownLoadEntity != null)
        {
          localVodDownLoadEntity.setDownLoadUrl(paramString2);
          this.vodDataBaseManager.updateByDownLoadId(localVodDownLoadEntity);
        }
        return;
        localVodDownLoadEntity = (VodDownLoadEntity)localIterator.next();
        boolean bool = localVodDownLoadEntity.getDownLoadId().equals(paramString1);
        if (!bool)
          break;
      }
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public void updateVodDownLoadProgress(String paramString, int paramInt)
  {
    this.lock.writeLock().lock();
    try
    {
      VodDownLoadEntity localVodDownLoadEntity = _getVodByDownLoadId(paramString);
      if (localVodDownLoadEntity != null)
      {
        localVodDownLoadEntity.setnPercent(paramInt);
        this.vodDataBaseManager.updateByDownLoadId(localVodDownLoadEntity);
      }
      return;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
    throw localObject;
  }

  public void updateVodDownLoadStatus(String paramString, int paramInt)
  {
    setVodDownLoadStatus(paramString, paramInt);
  }

  public void updateVodDownLoadStopStatus(String paramString, int paramInt)
  {
    setVodDownLoadStopStatus(paramString, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadManager
 * JD-Core Version:    0.6.0
 */