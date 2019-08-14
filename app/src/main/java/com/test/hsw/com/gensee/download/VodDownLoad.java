package com.gensee.download;

import android.content.Context;
import com.gensee.common.PlayerWork;
import com.gensee.entity.VodParam;
import com.gensee.vod.VodMr;
import java.util.List;

public class VodDownLoad extends PlayerWork
{
  private static VodDownLoad vodDownLoad = null;
  private VodDownLoadManager vodDownLoadManager;

  private VodDownLoad(Context paramContext, String paramString1, VodDownLoadCallback paramVodDownLoadCallback, String paramString2)
  {
    this.vodDownLoadManager = new VodDownLoadManager(paramContext.getApplicationContext(), paramString1, paramVodDownLoadCallback, paramString2);
  }

  public static VodDownLoad initVodDownLoad(Context paramContext, VodDownLoadCallback paramVodDownLoadCallback, String paramString)
  {
    return initVodDownLoad(paramContext, "0", paramVodDownLoadCallback, paramString);
  }

  public static VodDownLoad initVodDownLoad(Context paramContext, String paramString1, VodDownLoadCallback paramVodDownLoadCallback, String paramString2)
  {
    VodMr.getIns().initCachDir(paramContext);
    startHeartbeat(true);
    monitorenter;
    while (true)
    {
      try
      {
        if (vodDownLoad != null)
          continue;
        if ((paramString1 != null) && (!"".equals(paramString1)))
        {
          vodDownLoad = new VodDownLoad(paramContext, paramString1, paramVodDownLoadCallback, paramString2);
          return vodDownLoad;
        }
      }
      finally
      {
        monitorexit;
      }
      paramString1 = "0";
    }
  }

  private void release()
  {
    this.vodDownLoadManager.release();
    vodDownLoad = null;
  }

  public static void releaseVodDownLoad()
  {
    monitorenter;
    try
    {
      if (vodDownLoad != null)
        vodDownLoad.release();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int add(VodParam paramVodParam)
  {
    if (paramVodParam == null)
      return 5;
    VodDownLoadEntity localVodDownLoadEntity = new VodDownLoadEntity();
    localVodDownLoadEntity.setDownLoadId(paramVodParam.getVodId());
    localVodDownLoadEntity.setDownLoadUrl(paramVodParam.getXmlUrl());
    localVodDownLoadEntity.setVodSubject(paramVodParam.getVodSubject());
    localVodDownLoadEntity.setUserId(Long.parseLong(paramVodParam.getUserId()));
    localVodDownLoadEntity.setConnectSvr(paramVodParam.getConnectSvr());
    localVodDownLoadEntity.setNickName(paramVodParam.getNickName());
    localVodDownLoadEntity.setSiteId(Long.parseLong(paramVodParam.getSiteId()));
    localVodDownLoadEntity.setnLength(paramVodParam.getStorage());
    return this.vodDownLoadManager.add(localVodDownLoadEntity);
  }

  public void autoStart()
  {
    this.vodDownLoadManager.getVodDownLoadList();
    this.vodDownLoadManager.autoStart();
  }

  public void delete(String paramString)
  {
    this.vodDownLoadManager.delete(paramString);
  }

  public void delete(List<String> paramList)
  {
    this.vodDownLoadManager.delete(paramList);
  }

  public int download(String paramString)
  {
    VodParam localVodParam = VodMr.getIns().getVodObjById(paramString);
    if (localVodParam != null)
      add(localVodParam);
    return start(paramString);
  }

  public VodDownLoadEntity getCurrentDownloadingEntity()
  {
    return this.vodDownLoadManager.getCurrentDownloadingEntity();
  }

  public String getPlayUrl(String paramString)
  {
    return this.vodDownLoadManager.getPlayUrl(paramString);
  }

  public VodDownLoadEntity getVdlByDlId(String paramString)
  {
    return this.vodDownLoadManager.getVodByDownLoadId(paramString);
  }

  public List<VodDownLoadEntity> getVdlList()
  {
    return this.vodDownLoadManager.getVodDownLoadList();
  }

  public boolean hasDownloadingTask()
  {
    return this.vodDownLoadManager.isDownloadingTask();
  }

  public boolean isAutoDownloading()
  {
    return this.vodDownLoadManager.getIsAutoDownloading();
  }

  public boolean isDownloading(String paramString)
  {
    return this.vodDownLoadManager.isDownloadingByDlId(paramString);
  }

  public void setAutoDownloadNext(boolean paramBoolean)
  {
    this.vodDownLoadManager.setIsAutoDownloading(paramBoolean);
  }

  public void setStopStatus(String paramString, int paramInt)
  {
    this.vodDownLoadManager.setVodDownLoadStopStatus(paramString, paramInt);
  }

  public int start(String paramString)
  {
    return this.vodDownLoadManager.start(paramString);
  }

  public void stop(String paramString)
  {
    this.vodDownLoadManager.stop(paramString);
  }

  public void updateVdUrl(String paramString1, String paramString2)
  {
    this.vodDownLoadManager.updateVdUrl(paramString1, paramString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoad
 * JD-Core Version:    0.6.0
 */