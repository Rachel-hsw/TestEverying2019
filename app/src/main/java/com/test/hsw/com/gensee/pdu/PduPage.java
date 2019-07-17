package com.gensee.pdu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Environment;
import com.gensee.utils.GenseeLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PduPage extends PduBase
{
  public static final int ANNO_FAILURE = -1;
  public static final int ANNO_REPLACE = 1;
  public static final int ANNO_SUCCESS = 0;
  public static final String FILE_DIR = Environment.getExternalStorageDirectory().getPath() + "/gensee/rtsdk/";
  public static final int PLAYER_SDK_TYPE = 1;
  public static final int RT_SDK_TYPE = 0;
  public static final int SHOW_ADAPT = 2;
  public static final int SHOW_NONE = 0;
  public static final int SHOW_SOURCE = 1;
  private static final String TAG = "PduPage";
  public static final int VOD_SDK_TYPE = 2;
  private static String fileDir;
  private String aniCfg;
  private int aniStep;
  private String animationPath = null;
  private List<AbsAnno> annos = new ArrayList(0);
  private boolean bRefreshAnnos = false;
  private int docId;
  private String fullText;
  private char imgBitCount;
  private short imgHeight;
  private short imgWidth;
  private String linkUrl;
  private Matrix matrix = new Matrix();
  private int nSdkType = 0;
  private int pageId;
  private String pageName;
  private String path = null;
  private SoftReference<Bitmap> reference;
  private int showMode = 0;
  private String thumbData;
  private String titleText;

  private Bitmap cropImg(Bitmap paramBitmap)
  {
    int i;
    int j;
    Matrix localMatrix;
    if (paramBitmap != null)
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((this.imgWidth > 3000) || (this.imgHeight > 3000))
      {
        GenseeLog.w("PduPage pageWidth = " + this.imgWidth + " bw = " + i + " bh = " + j + " pageHeight = " + this.imgHeight);
        this.imgWidth = (short)i;
        this.imgHeight = (short)j;
      }
      do
        return paramBitmap;
      while ((i == this.imgWidth) && (j == this.imgHeight));
      float f1 = this.imgWidth / i;
      float f2 = this.imgHeight / j;
      localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
    }
    while (true)
    {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        localBitmap1 = localBitmap2;
        paramBitmap.recycle();
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        GenseeLog.e("PduPage", localOutOfMemoryError.toString());
        localBitmap1 = null;
        continue;
      }
      Bitmap localBitmap1 = null;
    }
  }

  public static String getFileDir()
  {
    if (fileDir == null)
      return FILE_DIR;
    return fileDir;
  }

  private String getPageFileName()
  {
    return getDocId() + '_' + getPageId() + ".png";
  }

  private String getPageSwfFileName()
  {
    return getDocId() + '_' + getPageId() + ".swf";
  }

  private String getPageSwfFilePath()
  {
    return getFileDir() + getPageSwfFileName();
  }

  private String getPageSwfXmlFileName()
  {
    return getDocId() + '_' + getPageId() + ".xml";
  }

  private String getPageSwfXmlFilePath()
  {
    return getFileDir() + getPageSwfXmlFileName();
  }

  // ERROR //
  private void saveBitmap(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 64	java/io/File
    //   3: dup
    //   4: invokestatic 184	com/gensee/pdu/PduPage:getFileDir	()Ljava/lang/String;
    //   7: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 203	java/io/File:exists	()Z
    //   15: ifne +47 -> 62
    //   18: aload_2
    //   19: invokevirtual 206	java/io/File:mkdirs	()Z
    //   22: istore 11
    //   24: ldc 22
    //   26: new 56	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 208
    //   32: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload 11
    //   37: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: invokestatic 184	com/gensee/pdu/PduPage:getFileDir	()Ljava/lang/String;
    //   43: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 214	com/gensee/utils/GenseeLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iload 11
    //   54: ifne +8 -> 62
    //   57: ldc 216
    //   59: invokestatic 146	com/gensee/utils/GenseeLog:w	(Ljava/lang/String;)V
    //   62: new 64	java/io/File
    //   65: dup
    //   66: aload_2
    //   67: aload_0
    //   68: invokespecial 218	com/gensee/pdu/PduPage:getPageFileName	()Ljava/lang/String;
    //   71: invokespecial 221	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 224	java/io/File:createNewFile	()Z
    //   79: pop
    //   80: new 226	java/io/FileOutputStream
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 229	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: astore 5
    //   90: aload_1
    //   91: getstatic 235	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   94: bipush 80
    //   96: aload 5
    //   98: invokevirtual 239	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   101: pop
    //   102: aload 5
    //   104: ifnull +13 -> 117
    //   107: aload 5
    //   109: invokevirtual 244	java/io/OutputStream:flush	()V
    //   112: aload 5
    //   114: invokevirtual 247	java/io/OutputStream:close	()V
    //   117: return
    //   118: astore 4
    //   120: aload 4
    //   122: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   125: goto -45 -> 80
    //   128: astore 6
    //   130: aconst_null
    //   131: astore 5
    //   133: aload 6
    //   135: invokevirtual 251	java/io/FileNotFoundException:printStackTrace	()V
    //   138: goto -36 -> 102
    //   141: astore 7
    //   143: aload 7
    //   145: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   148: goto -36 -> 112
    //   151: astore 8
    //   153: aload 8
    //   155: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   158: return
    //   159: astore 6
    //   161: goto -28 -> 133
    //
    // Exception table:
    //   from	to	target	type
    //   75	80	118	java/io/IOException
    //   80	90	128	java/io/FileNotFoundException
    //   107	112	141	java/io/IOException
    //   112	117	151	java/io/IOException
    //   90	102	159	java/io/FileNotFoundException
  }

  public static void setFileDir(String paramString)
  {
    fileDir = paramString;
  }

  // ERROR //
  private void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 224	java/io/File:createNewFile	()Z
    //   6: pop
    //   7: new 258	java/io/BufferedOutputStream
    //   10: dup
    //   11: new 226	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 229	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 261	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 7
    //   24: aload 7
    //   26: aload_2
    //   27: invokevirtual 265	java/io/BufferedOutputStream:write	([B)V
    //   30: aload 7
    //   32: invokevirtual 266	java/io/BufferedOutputStream:flush	()V
    //   35: aload 7
    //   37: ifnull +8 -> 45
    //   40: aload 7
    //   42: invokevirtual 267	java/io/BufferedOutputStream:close	()V
    //   45: return
    //   46: astore 6
    //   48: aconst_null
    //   49: astore 7
    //   51: aload 6
    //   53: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   56: aload 7
    //   58: ifnull -13 -> 45
    //   61: aload 7
    //   63: invokevirtual 267	java/io/BufferedOutputStream:close	()V
    //   66: return
    //   67: astore 8
    //   69: aload 8
    //   71: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   74: return
    //   75: astore 4
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 267	java/io/BufferedOutputStream:close	()V
    //   85: aload 4
    //   87: athrow
    //   88: astore 5
    //   90: aload 5
    //   92: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   95: goto -10 -> 85
    //   98: astore 10
    //   100: aload 10
    //   102: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore 4
    //   108: aload 7
    //   110: astore_3
    //   111: goto -34 -> 77
    //   114: astore 6
    //   116: goto -65 -> 51
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	46	java/lang/Exception
    //   61	66	67	java/io/IOException
    //   2	24	75	finally
    //   81	85	88	java/io/IOException
    //   40	45	98	java/io/IOException
    //   24	35	106	finally
    //   51	56	106	finally
    //   24	35	114	java/lang/Exception
  }

  public int addAnno(AbsAnno paramAbsAnno, boolean paramBoolean)
  {
    int i;
    synchronized (this.annos)
    {
      i = this.annos.indexOf(paramAbsAnno);
      if (i == -1)
      {
        if (this.annos.size() > 0)
        {
          AbsAnno localAbsAnno = (AbsAnno)this.annos.get(-1 + this.annos.size());
          if ((localAbsAnno instanceof AnnoFreepenEx))
          {
            int k = ((AnnoFreepenEx)localAbsAnno).getStepType();
            if ((k != 3) && (k != 0))
              ((AnnoFreepenEx)localAbsAnno).setStepType(3);
          }
        }
        if (this.annos.add(paramAbsAnno))
        {
          j = 0;
          return j;
        }
        int j = -1;
      }
    }
    try
    {
      if (16 == paramAbsAnno.getType())
      {
        boolean bool = ((AnnoFreepenEx)this.annos.get(i)).appendEX((AnnoFreepenEx)paramAbsAnno);
        if (bool);
        for (int m = 0; ; m = -1)
        {
          monitorexit;
          return m;
          localObject = finally;
          monitorexit;
          throw localObject;
        }
      }
      ((AbsAnno)this.annos.remove(i)).clean();
      this.annos.add(i, paramAbsAnno);
      monitorexit;
      return 1;
    }
    catch (Exception localException)
    {
      GenseeLog.e("PduPage", localException.toString());
      monitorexit;
    }
    return -1;
  }

  public boolean changePoint(AbsAnno paramAbsAnno)
  {
    int j;
    int k;
    synchronized (this.annos)
    {
      int i = this.annos.size();
      j = i - 1;
      break label116;
      if ((k >= 0) && (k < i))
        this.annos.remove(k);
      boolean bool = this.annos.add(paramAbsAnno);
      return bool;
      label68: AbsAnno localAbsAnno = (AbsAnno)this.annos.get(j);
      if (localAbsAnno != null)
        if (localAbsAnno.getType() != 1)
          if (localAbsAnno.getType() != 9)
            break label134;
    }
    while (true)
    {
      label116: if (j >= 0)
        break label68;
      k = -1;
      break;
      k = j;
      break;
      label134: j--;
    }
  }

  public boolean cleanAllAnno()
  {
    synchronized (this.annos)
    {
      this.annos.clear();
      return true;
    }
  }

  public AbsAnno cleanAnno(float paramFloat1, float paramFloat2)
  {
    while (true)
    {
      int i;
      synchronized (this.annos)
      {
        i = -1 + this.annos.size();
        if (i < 0)
          return null;
        AbsAnno localAbsAnno = (AbsAnno)this.annos.get(i);
        if ((localAbsAnno != null) && (localAbsAnno.contain(paramFloat1, paramFloat2)))
          return localAbsAnno;
      }
      i--;
    }
  }

  public AbsAnno cleanLastOwnAnno(long paramLong)
  {
    while (true)
    {
      int i;
      synchronized (this.annos)
      {
        i = -1 + this.annos.size();
        if (i < 0)
          return null;
        AbsAnno localAbsAnno = (AbsAnno)this.annos.get(i);
        if ((localAbsAnno != null) && (localAbsAnno.getOwner() == paramLong))
          return localAbsAnno;
      }
      i--;
    }
  }

  public void cleanUndoAnno(long paramLong)
  {
    synchronized (this.annos)
    {
      Iterator localIterator = this.annos.iterator();
      AbsAnno localAbsAnno;
      do
      {
        if (!localIterator.hasNext())
          return;
        localAbsAnno = (AbsAnno)localIterator.next();
      }
      while ((localAbsAnno == null) || (localAbsAnno.getOwner() != paramLong));
      localAbsAnno.setOwner(0L);
    }
  }

  public void clear()
  {
    Iterator localIterator = this.annos.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.annos.clear();
        this.matrix.reset();
        this.showMode = 0;
        recycle();
        return;
      }
      ((AbsAnno)localIterator.next()).clean();
    }
  }

  public boolean delAnno(AbsAnno paramAbsAnno)
  {
    while (true)
    {
      Iterator localIterator;
      synchronized (this.annos)
      {
        if (0L != ((AnnoCleaner)paramAbsAnno).getRemovedId())
          continue;
        this.annos.clear();
        return true;
        localIterator = this.annos.iterator();
        if (!localIterator.hasNext())
        {
          localObject2 = null;
          boolean bool = this.annos.remove(localObject2);
          return bool;
        }
      }
      Object localObject2 = (AbsAnno)localIterator.next();
      if (localObject2 == null)
        continue;
      long l1 = ((AbsAnno)localObject2).getId();
      long l2 = ((AnnoCleaner)paramAbsAnno).getRemovedId();
      if (l1 != l2)
        continue;
    }
  }

  public void drawAnno(Canvas paramCanvas)
  {
    if (paramCanvas == null)
      GenseeLog.e("PduPage", "drawAnno canvas is null!");
    while (true)
    {
      return;
      synchronized (this.annos)
      {
        try
        {
          localCopyOnWriteArrayList = new CopyOnWriteArrayList(this.annos);
          if (localCopyOnWriteArrayList == null)
            continue;
          Iterator localIterator = localCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            AbsAnno localAbsAnno = (AbsAnno)localIterator.next();
            if (localAbsAnno == null)
              continue;
            localAbsAnno.draw(paramCanvas, this.matrix);
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            localException.printStackTrace();
            CopyOnWriteArrayList localCopyOnWriteArrayList = null;
          }
        }
      }
    }
  }

  public void drawBitmap(Canvas paramCanvas, Context paramContext, int paramInt)
  {
    if (paramCanvas == null)
      return;
    monitorenter;
    Bitmap localBitmap;
    try
    {
      localBitmap = getBitmap();
      paramCanvas.drawColor(paramInt);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        GenseeLog.e("PduPage", "drawBitmap canvas =" + paramCanvas + " reference = " + this.reference);
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    paramCanvas.drawBitmap(localBitmap, this.matrix, new Paint());
    monitorexit;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PduPage localPduPage;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localPduPage = (PduPage)paramObject;
      if (this.docId != localPduPage.docId)
        return false;
    }
    while (this.pageId == localPduPage.pageId);
    return false;
  }

  public String getAniCfg()
  {
    return this.aniCfg;
  }

  public int getAniStep()
  {
    return this.aniStep;
  }

  public String getAnimationPath()
  {
    if (this.nSdkType == 0)
      return getPageSwfXmlFilePath();
    return this.animationPath;
  }

  protected AbsAnno[] getAnnos()
  {
    if (this.annos.size() > 0)
    {
      AbsAnno[] arrayOfAbsAnno = new AbsAnno[this.annos.size()];
      return (AbsAnno[])this.annos.toArray(arrayOfAbsAnno);
    }
    return null;
  }

  public Bitmap getBitmap()
  {
    if (((this.reference != null) && (this.reference.get() != null)) || (this.path != null));
    while (true)
    {
      try
      {
        Bitmap localBitmap3 = BitmapFactory.decodeFile(this.path);
        localBitmap2 = localBitmap3;
        localObject = cropImg(localBitmap2);
        if (localObject == null)
          continue;
        this.reference = new SoftReference(localObject);
        if (this.reference != null)
          break;
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        GenseeLog.e("PduPage", localOutOfMemoryError2.toString());
        Bitmap localBitmap2 = null;
        continue;
      }
      File localFile = new File(getFileDir() + getPageFileName());
      if (localFile.exists())
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeFile(localFile.getPath());
          localObject = localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          GenseeLog.e("PduPage", localOutOfMemoryError1.toString());
        }
      Object localObject = null;
    }
    return (Bitmap)(Bitmap)this.reference.get();
  }

  public int getBitmapH()
  {
    return this.imgHeight;
  }

  public int getBitmapW()
  {
    return this.imgWidth;
  }

  public int getDocId()
  {
    return this.docId;
  }

  public String getFullText()
  {
    return this.fullText;
  }

  public char getImgBitCount()
  {
    return this.imgBitCount;
  }

  public short getImgHeight()
  {
    return this.imgHeight;
  }

  public short getImgWidth()
  {
    return this.imgWidth;
  }

  public String getLinkUrl()
  {
    return this.linkUrl;
  }

  public Matrix getMatrix()
  {
    return this.matrix;
  }

  public int getPageId()
  {
    return this.pageId;
  }

  public String getPageName()
  {
    return this.pageName;
  }

  public String getPath()
  {
    if (this.nSdkType == 0)
      return getPageSwfFilePath();
    return this.path;
  }

  public int getShowMode()
  {
    return this.showMode;
  }

  public String getThumbData()
  {
    return this.thumbData;
  }

  public String getTitleText()
  {
    return this.titleText;
  }

  public int hashCode()
  {
    return 31 * (31 + this.docId) + this.pageId;
  }

  public void initBitmap()
  {
  }

  public void initBitmap(int paramInt1, int paramInt2)
  {
    getBitmap();
  }

  public boolean isGlPrepare()
  {
    if (!isSwfPrepare());
    do
      return false;
    while (!new File(getPageSwfXmlFilePath()).exists());
    return true;
  }

  public boolean isPrepare()
  {
    if (isSwfPrepare());
    do
      return true;
    while ((new File(getFileDir() + getPageFileName()).exists()) || (getBitmap() != null));
    return false;
  }

  public boolean isRefreshAnnos()
  {
    return this.bRefreshAnnos;
  }

  public boolean isSwfPrepare()
  {
    String str = getPath();
    if (str == null)
      return false;
    return new File(str).exists();
  }

  public void onContent(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    this.docId = paramInt;
    if (new File(getFileDir() + getPageFileName()).exists());
    do
      return;
    while ((this.reference != null) && (this.reference.get() != null));
    try
    {
      Bitmap localBitmap3 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      localBitmap1 = localBitmap3;
      localBitmap2 = cropImg(localBitmap1);
      if (localBitmap2 != null)
      {
        saveBitmap(localBitmap2);
        if (!paramBoolean)
        {
          recycle();
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap2;
      while (true)
      {
        GenseeLog.e("PduPage", localOutOfMemoryError.toString());
        Bitmap localBitmap1 = null;
      }
      this.reference = new SoftReference(localBitmap2);
      return;
    }
    GenseeLog.w("onContent page  decode fail");
  }

  public void onGlContent(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    this.docId = paramInt;
    File localFile1 = new File(getFileDir());
    if ((!localFile1.exists()) && (!localFile1.mkdirs()))
      GenseeLog.w("onGlContent save page make dir fail");
    File localFile2 = new File(getPageSwfFilePath());
    if (!localFile2.exists())
      writeToFile(localFile2, paramArrayOfByte);
    if ((this.aniCfg == null) || ("".equals(this.aniCfg)));
    File localFile3;
    do
    {
      return;
      localFile3 = new File(getPageSwfXmlFilePath());
    }
    while (localFile3.exists());
    writeToFile(localFile3, this.aniCfg.getBytes());
  }

  public void recycle()
  {
    monitorenter;
    try
    {
      if (this.reference != null)
      {
        Bitmap localBitmap = (Bitmap)this.reference.get();
        GenseeLog.d("PduPage", "recycle Bitmap = " + localBitmap);
        if (localBitmap != null)
          localBitmap.recycle();
        this.reference.clear();
        this.reference = null;
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void setAniCfg(String paramString)
  {
    this.aniCfg = paramString;
  }

  public void setAniStep(int paramInt)
  {
    this.aniStep = paramInt;
  }

  public void setAnimationPath(String paramString)
  {
    this.animationPath = paramString;
  }

  protected void setAnnos(AbsAnno[] paramArrayOfAbsAnno)
  {
    if (paramArrayOfAbsAnno != null)
    {
      List localList = this.annos;
      monitorenter;
      int i = 0;
      try
      {
        while (true)
        {
          if (i >= paramArrayOfAbsAnno.length)
            return;
          this.annos.add(paramArrayOfAbsAnno[i]);
          i++;
        }
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public void setDocId(int paramInt)
  {
    this.docId = paramInt;
  }

  public void setFullText(String paramString)
  {
    this.fullText = paramString;
  }

  public void setImgBitCount(char paramChar)
  {
    this.imgBitCount = paramChar;
  }

  public void setImgHeight(short paramShort)
  {
    this.imgHeight = paramShort;
  }

  public void setImgWidth(short paramShort)
  {
    this.imgWidth = paramShort;
  }

  public void setLinkUrl(String paramString)
  {
    this.linkUrl = paramString;
  }

  public void setPageId(int paramInt)
  {
    this.pageId = paramInt;
  }

  public void setPageName(String paramString)
  {
    this.pageName = paramString;
  }

  public void setPath(String paramString)
  {
    this.path = paramString;
  }

  public void setRefreshAnnos(boolean paramBoolean)
  {
    this.bRefreshAnnos = paramBoolean;
  }

  public void setSdkType(int paramInt)
  {
    this.nSdkType = paramInt;
  }

  public void setShowMode(int paramInt)
  {
    this.showMode = paramInt;
  }

  public void setThumbData(String paramString)
  {
    this.thumbData = paramString;
  }

  public void setTitleText(String paramString)
  {
    this.titleText = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PudPage [pageName=").append(this.pageName).append(", pageId=").append(this.pageId).append(", docId=").append(this.docId).append(" w = ").append(this.imgWidth).append(" h = ").append(this.imgHeight).append(" annos =");
    if (this.annos == null);
    for (int i = 0; ; i = this.annos.size())
      return i + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.PduPage
 * JD-Core Version:    0.6.0
 */