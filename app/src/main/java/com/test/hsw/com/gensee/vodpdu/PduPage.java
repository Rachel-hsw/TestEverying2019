package com.gensee.vodpdu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.gensee.common.GenseeConstant;
import com.gensee.utils.GenseeLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PduPage extends PduBase
{
  public static final int SHOW_ADAPT = 2;
  public static final int SHOW_NONE = 0;
  public static final int SHOW_SOURCE = 1;
  private static final String TAG = "PduPage";
  private String aniCfg;
  private int aniStep;
  private List<AbsAnno> annos = new ArrayList(0);
  private long blockHandle;
  private byte[] data;
  private long docId;
  private String fullText;
  private char imgBitCount;
  private int imgHeight;
  private int imgWidth;
  private String linkUrl;
  private Matrix matrix = new Matrix();
  private long pageId;
  private String pageName;
  private SoftReference<Bitmap> reference;
  private int showMode = 0;
  private boolean speedUp;
  private long startTs;
  private long stopTs;
  private String thumbData;
  private String titleText;
  private List<AbsAnno> vodAnnos;

  private String getPageFileName()
  {
    return getDocId() + '_' + getPageId() + ".png";
  }

  public static void onPageContent(InputStream paramInputStream, PduPage paramPduPage, boolean paramBoolean)
  {
    if ((paramPduPage == null) || (paramInputStream == null))
      return;
    monitorenter;
    try
    {
      paramPduPage.onContent(paramInputStream, paramBoolean);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void saveBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 110	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   5: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: ifne +12 -> 20
    //   11: ldc 15
    //   13: ldc 118
    //   15: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: return
    //   20: new 126	java/io/File
    //   23: dup
    //   24: getstatic 131	com/gensee/common/GenseeConstant:FILE_VOD_DIR	Ljava/lang/String;
    //   27: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 138	java/io/File:exists	()Z
    //   35: ifne +16 -> 51
    //   38: aload_3
    //   39: invokevirtual 141	java/io/File:mkdir	()Z
    //   42: ifne +9 -> 51
    //   45: ldc 143
    //   47: invokestatic 147	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;)V
    //   50: return
    //   51: new 126	java/io/File
    //   54: dup
    //   55: aload_3
    //   56: aload_0
    //   57: invokespecial 149	com/gensee/vodpdu/PduPage:getPageFileName	()Ljava/lang/String;
    //   60: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 138	java/io/File:exists	()Z
    //   70: ifne -51 -> 19
    //   73: aload 4
    //   75: invokevirtual 155	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: new 157	java/io/FileOutputStream
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: astore 6
    //   90: aload_1
    //   91: getstatic 166	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   94: bipush 80
    //   96: aload 6
    //   98: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   101: pop
    //   102: aload 6
    //   104: ifnull +13 -> 117
    //   107: aload 6
    //   109: invokevirtual 177	java/io/OutputStream:flush	()V
    //   112: aload 6
    //   114: invokevirtual 180	java/io/OutputStream:close	()V
    //   117: iload_2
    //   118: ifeq +64 -> 182
    //   121: aload_1
    //   122: invokevirtual 183	android/graphics/Bitmap:recycle	()V
    //   125: return
    //   126: astore 5
    //   128: aload 5
    //   130: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   133: goto -54 -> 79
    //   136: astore 7
    //   138: aconst_null
    //   139: astore 6
    //   141: aload 7
    //   143: invokevirtual 187	java/io/FileNotFoundException:printStackTrace	()V
    //   146: goto -44 -> 102
    //   149: astore 10
    //   151: aconst_null
    //   152: astore 6
    //   154: aload 10
    //   156: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   159: goto -57 -> 102
    //   162: astore 8
    //   164: aload 8
    //   166: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   169: goto -57 -> 112
    //   172: astore 9
    //   174: aload 9
    //   176: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   179: goto -62 -> 117
    //   182: aload_0
    //   183: new 189	java/lang/ref/SoftReference
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 192	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   191: putfield 194	com/gensee/vodpdu/PduPage:reference	Ljava/lang/ref/SoftReference;
    //   194: return
    //   195: astore 10
    //   197: goto -43 -> 154
    //   200: astore 7
    //   202: goto -61 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   73	79	126	java/io/IOException
    //   79	90	136	java/io/FileNotFoundException
    //   79	90	149	java/io/IOException
    //   107	112	162	java/io/IOException
    //   112	117	172	java/io/IOException
    //   90	102	195	java/io/IOException
    //   90	102	200	java/io/FileNotFoundException
  }

  public boolean addAllAnno(List<AbsAnno> paramList)
  {
    synchronized (this.annos)
    {
      this.annos.clear();
      if (paramList != null)
      {
        boolean bool = this.annos.addAll(paramList);
        return bool;
      }
      return false;
    }
  }

  public boolean addAnno(AbsAnno paramAbsAnno)
  {
    synchronized (this.annos)
    {
      int i = this.annos.indexOf(paramAbsAnno);
      if (i == -1)
      {
        boolean bool = this.annos.add(paramAbsAnno);
        return bool;
      }
      try
      {
        this.annos.remove(i);
        this.annos.add(i, paramAbsAnno);
        return true;
      }
      catch (Exception localException)
      {
        GenseeLog.e("PduPage", localException);
        return false;
      }
    }
  }

  public boolean changePoint(AbsAnno paramAbsAnno)
  {
    int i;
    int j;
    int k;
    synchronized (this.annos)
    {
      i = this.annos.size();
      j = 0;
      break label116;
      if ((k >= 0) && (k < i))
        this.annos.remove(k);
      boolean bool = this.annos.add(paramAbsAnno);
      return bool;
      label65: AbsAnno localAbsAnno = (AbsAnno)this.annos.get(j);
      if (localAbsAnno != null)
        if (localAbsAnno.getType() != 2050)
          if (localAbsAnno.getType() != 2057)
            break label136;
    }
    while (true)
    {
      label116: if (j < i)
        break label65;
      k = -1;
      break;
      k = j;
      break;
      label136: j++;
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
    int i;
    Object localObject2;
    synchronized (this.annos)
    {
      i = -1 + this.annos.size();
      break label92;
      while ((localObject2 != null) && (this.annos.remove(localObject2)))
      {
        return localObject2;
        label47: localObject2 = (AbsAnno)this.annos.get(i);
        if (localObject2 == null)
          break label103;
        if (((AbsAnno)localObject2).contain(paramFloat1, paramFloat2))
          continue;
        break label103;
      }
      return null;
    }
    while (true)
    {
      label92: if (i >= 0)
        break label47;
      localObject2 = null;
      break;
      label103: i--;
    }
  }

  public void clear()
  {
    this.annos.clear();
    this.annos = null;
    this.matrix = null;
    this.showMode = 0;
    recycle();
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
    {
      GenseeLog.e("PduPage", "drawAnno canvas is null!");
      return;
    }
    while (true)
    {
      Iterator localIterator;
      synchronized (this.annos)
      {
        localIterator = this.annos.iterator();
        if (!localIterator.hasNext())
          return;
      }
      AbsAnno localAbsAnno = (AbsAnno)localIterator.next();
      if (localAbsAnno == null)
        continue;
      localAbsAnno.draw(paramCanvas, this.matrix);
    }
  }

  public void drawBitmap(Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      if (getBitmap() != null)
        paramCanvas.drawBitmap((Bitmap)this.reference.get(), this.matrix, new Paint());
    }
    else
      return;
    paramCanvas.drawColor(-1);
    GenseeLog.e("PduPage", "drawBitmap canvas =" + paramCanvas + " reference=" + this.reference);
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
      if (this.pageId != localPduPage.pageId)
        return false;
    }
    while (this.startTs == localPduPage.startTs);
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

  public Bitmap getBitmap()
  {
    if ((this.reference != null) && (this.reference.get() == null))
    {
      this.reference.clear();
      this.reference = null;
    }
    if (this.reference == null)
    {
      String str = GenseeConstant.FILE_VOD_DIR + getPageFileName();
      if (new File(str).exists())
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(str);
        if (localBitmap2 != null)
        {
          this.imgWidth = localBitmap2.getWidth();
          this.imgHeight = localBitmap2.getHeight();
          this.reference = new SoftReference(localBitmap2);
        }
      }
    }
    SoftReference localSoftReference = this.reference;
    Bitmap localBitmap1 = null;
    if (localSoftReference != null)
      localBitmap1 = (Bitmap)this.reference.get();
    return localBitmap1;
  }

  public int getBitmapH()
  {
    return this.imgHeight;
  }

  public int getBitmapW()
  {
    return this.imgWidth;
  }

  public long getBlockHandle()
  {
    return this.blockHandle;
  }

  public long getDocId()
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

  public int getImgHeight()
  {
    return this.imgHeight;
  }

  public int getImgWidth()
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

  public long getPageId()
  {
    return this.pageId;
  }

  public String getPageName()
  {
    return this.pageName;
  }

  public int getShowMode()
  {
    return this.showMode;
  }

  public long getStartTs()
  {
    return this.startTs;
  }

  public long getStopTs()
  {
    return this.stopTs;
  }

  public String getThumbData()
  {
    return this.thumbData;
  }

  public String getTitleText()
  {
    return this.titleText;
  }

  public List<AbsAnno> getVodAnnos()
  {
    return this.vodAnnos;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 + (int)(this.docId ^ this.docId >>> 32)) + (int)(this.pageId ^ this.pageId >>> 32)) + (int)(this.startTs ^ this.startTs >>> 32);
  }

  public void initBitmap()
  {
    getBitmap();
  }

  public void initBitmap(int paramInt1, int paramInt2)
  {
    getBitmap();
  }

  public boolean isPrepare()
  {
    if (new File(GenseeConstant.FILE_VOD_DIR + getPageFileName()).exists());
    do
      return true;
    while (getBitmap() != null);
    return false;
  }

  public boolean isSpeedUp()
  {
    return this.speedUp;
  }

  public void onContent(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.imgWidth = paramBitmap.getWidth();
      this.imgHeight = paramBitmap.getHeight();
      saveBitmap(paramBitmap, false);
    }
  }

  public void onContent(InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramInputStream == null);
    while (true)
    {
      return;
      byte[] arrayOfByte1 = new byte[512];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        k = paramInputStream.read(arrayOfByte1);
        if (k <= 0)
        {
          localOptions = new BitmapFactory.Options();
          localOptions.inSampleSize = 1;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        }
      }
      catch (IOException localIOException2)
      {
        try
        {
          BitmapFactory.Options localOptions;
          byte[] arrayOfByte2;
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          if (arrayOfByte2 == null)
            continue;
          localBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, arrayOfByte2.length, localOptions);
          if (localBitmap1 == null)
            continue;
          i = localBitmap1.getWidth();
          j = localBitmap1.getHeight();
          if ((this.imgWidth * this.imgHeight < 1638400) && ((i != this.imgWidth) || (j != this.imgHeight)))
          {
            float f1 = this.imgWidth / i;
            float f2 = this.imgHeight / j;
            localMatrix = new Matrix();
            localMatrix.postScale(f1, f2);
          }
        }
        catch (IOException localIOException2)
        {
          Bitmap localBitmap1;
          int i;
          int j;
          try
          {
            while (true)
            {
              int k;
              Matrix localMatrix;
              Bitmap localBitmap3 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j, localMatrix, true);
              localBitmap2 = localBitmap3;
              if (localBitmap2 == null)
                break;
              saveBitmap(localBitmap2, paramBoolean);
              return;
              localByteArrayOutputStream.write(arrayOfByte1, 0, k);
              continue;
              localIOException1 = localIOException1;
              localIOException1.printStackTrace();
            }
            localIOException2 = localIOException2;
            localIOException2.printStackTrace();
          }
          catch (Exception localException)
          {
            while (true)
            {
              GenseeLog.e("PduPage", localException);
              Bitmap localBitmap2 = null;
            }
          }
          this.imgWidth = i;
          this.imgHeight = j;
          saveBitmap(localBitmap1, paramBoolean);
        }
      }
    }
  }

  public void onContent(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    onContent(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length));
  }

  public void recycle()
  {
    SoftReference localSoftReference = this.reference;
    this.reference = null;
    if (localSoftReference != null)
    {
      Bitmap localBitmap = (Bitmap)localSoftReference.get();
      if (localBitmap != null)
        localBitmap.recycle();
      localSoftReference.clear();
    }
  }

  public void setAniCfg(String paramString)
  {
    this.aniCfg = paramString;
  }

  public void setAniStep(int paramInt)
  {
    this.aniStep = paramInt;
  }

  public void setBlockHandle(long paramLong)
  {
    this.blockHandle = paramLong;
  }

  public void setDocId(long paramLong)
  {
    this.docId = paramLong;
  }

  public void setFullText(String paramString)
  {
    this.fullText = paramString;
  }

  public void setImgBitCount(char paramChar)
  {
    this.imgBitCount = paramChar;
  }

  public void setImgHeight(int paramInt)
  {
    this.imgHeight = paramInt;
  }

  public void setImgWidth(int paramInt)
  {
    this.imgWidth = paramInt;
  }

  public void setLinkUrl(String paramString)
  {
    this.linkUrl = paramString;
  }

  public void setPageId(long paramLong)
  {
    this.pageId = paramLong;
  }

  public void setPageName(String paramString)
  {
    this.pageName = paramString;
  }

  public void setShowMode(int paramInt)
  {
    this.showMode = paramInt;
  }

  public void setSpeedUp(boolean paramBoolean)
  {
    this.speedUp = paramBoolean;
  }

  public void setStartTs(long paramLong)
  {
    this.startTs = paramLong;
  }

  public void setStopTs(long paramLong)
  {
    this.stopTs = paramLong;
  }

  public void setThumbData(String paramString)
  {
    this.thumbData = paramString;
  }

  public void setTitleText(String paramString)
  {
    this.titleText = paramString;
  }

  public void setVodAnnos(List<AbsAnno> paramList)
  {
    this.vodAnnos = paramList;
  }

  public int showAnnoSize()
  {
    synchronized (this.annos)
    {
      int i = this.annos.size();
      return i;
    }
  }

  public String toString()
  {
    return "PduPage [pageName=" + this.pageName + ", pageId=" + this.pageId + ", docId=" + this.docId + ", imgBitCount=" + this.imgBitCount + ", imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", blockHandle=" + this.blockHandle + ", thumbData=" + this.thumbData + ", fullText=" + this.fullText + ", titleText=" + this.titleText + ", linkUrl=" + this.linkUrl + ", aniCfg=" + this.aniCfg + ", aniStep=" + this.aniStep + ", startTs=" + this.startTs + ", stopTs=" + this.stopTs + ", speedUp=" + this.speedUp + ", annos=" + this.annos + ", docBitmap=" + this.reference + ", matrix=" + this.matrix + ", data=" + Arrays.toString(this.data) + ", showMode=" + this.showMode + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.PduPage
 * JD-Core Version:    0.6.0
 */