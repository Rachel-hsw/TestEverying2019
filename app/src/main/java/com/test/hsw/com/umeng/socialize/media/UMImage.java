package com.umeng.socialize.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.umeng.socialize.b.b.d;
import com.umeng.socialize.b.b.e;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UMImage extends BaseMediaObject
{
  public static final Parcelable.Creator<UMImage> CREATOR;
  public static int h = 0;
  public static int i = 0;
  private static final String j = UMImage.class.getName();
  private static final String k = "/umeng_cache/";
  private File l;
  private String m = "";
  private boolean n = false;
  private SoftReference<byte[]> o = null;
  private float p = 2048.0F;
  private Lock q = new ReentrantLock();
  private Condition r = this.q.newCondition();

  static
  {
    h = 768;
    i = 1024;
    CREATOR = new n();
  }

  public UMImage(Context paramContext, int paramInt)
  {
    super("");
    a(paramContext);
    try
    {
      a(paramContext.getResources().openRawResourceFd(paramInt).createInputStream());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      q();
    }
  }

  public UMImage(Context paramContext, Bitmap paramBitmap)
  {
    super("");
    a(paramContext);
    a(paramBitmap);
  }

  public UMImage(Context paramContext, File paramFile)
  {
    super("");
    a(paramContext);
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = paramFile.getAbsolutePath();
      if ((str != null) && (str.startsWith("/data/data")))
      {
        a(BitmapFactory.decodeFile(str));
        return;
      }
    }
    a(paramFile);
  }

  public UMImage(Context paramContext, String paramString)
  {
    super(paramString);
    a(paramContext);
    if ((!TextUtils.isEmpty(paramString)) && (!d.b(paramString)))
    {
      a(null);
      a(new File(paramString));
      return;
    }
    a(paramString);
  }

  public UMImage(Context paramContext, byte[] paramArrayOfByte)
  {
    super("");
    a(paramContext);
    a(paramArrayOfByte);
  }

  protected UMImage(Parcel paramParcel)
  {
    super(paramParcel);
    this.l = new File(paramParcel.readString());
    this.m = paramParcel.readString();
  }

  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return;
    new Thread(new l(this, paramBitmap)).start();
  }

  private void a(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return;
    new j(this, paramInputStream).start();
  }

  private void a(byte[] paramArrayOfByte)
  {
    new Thread(new k(this, paramArrayOfByte)).start();
  }

  private byte[] a(File paramFile)
  {
    byte[] arrayOfByte;
    if ((paramFile == null) || (!paramFile.exists()))
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = b(paramFile);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
        break;
      String str = com.umeng.socialize.common.a.a(arrayOfByte);
      if (!com.umeng.socialize.common.a.m[1].equals(str))
        return b(arrayOfByte);
    }
    return null;
  }

  // ERROR //
  private static File b(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 222	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 224	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 227	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 230	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 233	java/io/BufferedOutputStream:write	([B)V
    //   23: aload_3
    //   24: ifnull +7 -> 31
    //   27: aload_3
    //   28: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   42: aload_3
    //   43: ifnull -12 -> 31
    //   46: aload_3
    //   47: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore 7
    //   54: aload_1
    //   55: areturn
    //   56: astore 5
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   66: aload 5
    //   68: athrow
    //   69: astore 8
    //   71: aload_1
    //   72: areturn
    //   73: astore 6
    //   75: goto -9 -> 66
    //   78: astore 5
    //   80: aload_3
    //   81: astore_2
    //   82: goto -24 -> 58
    //   85: astore 4
    //   87: goto -50 -> 37
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	33	java/lang/Exception
    //   46	50	52	java/io/IOException
    //   2	18	56	finally
    //   27	31	69	java/io/IOException
    //   62	66	73	java/io/IOException
    //   18	23	78	finally
    //   37	42	78	finally
    //   18	23	85	java/lang/Exception
  }

  // ERROR //
  private static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: new 238	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 241	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 242	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_2
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore 8
    //   24: aload_1
    //   25: aload 8
    //   27: invokevirtual 248	java/io/InputStream:read	([B)I
    //   30: istore 9
    //   32: iload 9
    //   34: iconst_m1
    //   35: if_icmpeq +49 -> 84
    //   38: aload_2
    //   39: aload 8
    //   41: iconst_0
    //   42: iload 9
    //   44: invokevirtual 251	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -23 -> 24
    //   50: astore 5
    //   52: getstatic 40	com/umeng/socialize/media/UMImage:j	Ljava/lang/String;
    //   55: ldc 56
    //   57: aload 5
    //   59: invokestatic 256	com/umeng/socialize/utils/i:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 257	java/io/InputStream:close	()V
    //   70: aconst_null
    //   71: astore 6
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   81: aload 6
    //   83: areturn
    //   84: aload_2
    //   85: invokevirtual 262	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore 10
    //   90: aload 10
    //   92: astore 6
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 257	java/io/InputStream:close	()V
    //   102: aload_2
    //   103: ifnull -22 -> 81
    //   106: aload_2
    //   107: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   110: aload 6
    //   112: areturn
    //   113: astore 11
    //   115: aload 6
    //   117: areturn
    //   118: astore 13
    //   120: aconst_null
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: aload 13
    //   126: astore_3
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 257	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   143: aload_3
    //   144: athrow
    //   145: astore 4
    //   147: goto -4 -> 143
    //   150: astore 12
    //   152: aload 12
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -30 -> 127
    //   160: astore_3
    //   161: goto -34 -> 127
    //   164: astore 7
    //   166: aconst_null
    //   167: areturn
    //   168: astore 5
    //   170: aconst_null
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -122 -> 52
    //   177: astore 5
    //   179: aconst_null
    //   180: astore_2
    //   181: goto -129 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   17	24	50	java/lang/Exception
    //   24	32	50	java/lang/Exception
    //   38	47	50	java/lang/Exception
    //   84	90	50	java/lang/Exception
    //   98	102	113	java/io/IOException
    //   106	110	113	java/io/IOException
    //   0	9	118	finally
    //   131	135	145	java/io/IOException
    //   139	143	145	java/io/IOException
    //   9	17	150	finally
    //   17	24	160	finally
    //   24	32	160	finally
    //   38	47	160	finally
    //   52	62	160	finally
    //   84	90	160	finally
    //   66	70	164	java/io/IOException
    //   77	81	164	java/io/IOException
    //   0	9	168	java/lang/Exception
    //   9	17	177	java/lang/Exception
  }

  // ERROR //
  private static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 267	com/umeng/socialize/utils/a:a	([B)Landroid/graphics/BitmapFactory$Options;
    //   4: astore 8
    //   6: aload_0
    //   7: iconst_0
    //   8: aload_0
    //   9: arraylength
    //   10: aload 8
    //   12: invokestatic 271	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   15: astore 9
    //   17: new 241	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 242	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore_2
    //   25: aload 9
    //   27: ifnull +23 -> 50
    //   30: aload 9
    //   32: getstatic 277	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   35: bipush 100
    //   37: aload_2
    //   38: invokevirtual 283	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload 9
    //   44: invokevirtual 286	android/graphics/Bitmap:recycle	()V
    //   47: invokestatic 291	java/lang/System:gc	()V
    //   50: aload_2
    //   51: invokevirtual 262	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   54: astore 11
    //   56: aload 11
    //   58: astore 6
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   68: aload 6
    //   70: areturn
    //   71: astore 5
    //   73: aconst_null
    //   74: astore_2
    //   75: aconst_null
    //   76: astore 6
    //   78: aload_2
    //   79: ifnull -11 -> 68
    //   82: aload_2
    //   83: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore 7
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_1
    //   96: astore_3
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_3
    //   106: athrow
    //   107: astore 12
    //   109: aload 6
    //   111: areturn
    //   112: astore 4
    //   114: goto -9 -> 105
    //   117: astore_3
    //   118: goto -21 -> 97
    //   121: astore 10
    //   123: goto -48 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   0	25	71	java/lang/Exception
    //   82	86	88	java/io/IOException
    //   0	25	92	finally
    //   64	68	107	java/io/IOException
    //   101	105	112	java/io/IOException
    //   30	50	117	finally
    //   50	56	117	finally
    //   30	50	121	java/lang/Exception
    //   50	56	121	java/lang/Exception
  }

  private File e(String paramString)
    throws IOException
  {
    com.umeng.socialize.utils.a.b();
    File localFile = new File(j(), paramString);
    if (localFile.exists())
      localFile.delete();
    localFile.createNewFile();
    return localFile;
  }

  private void q()
  {
    this.n = true;
    r();
  }

  private void r()
  {
    this.q.lock();
    this.r.signal();
    this.q.unlock();
    i.c(j, "*********  UMImage序列化完成");
  }

  private byte[] s()
  {
    if ((this.o != null) && (this.o.get() != null) && (((byte[])this.o.get()).length > 0))
    {
      i.c(j, "### 从缓存中获取图片数据 ");
      localObject1 = (byte[])this.o.get();
      return localObject1;
    }
    Object localObject1 = new byte[0];
    if (b());
    while (true)
    {
      try
      {
        String str = a();
        if ((TextUtils.isEmpty(str)) || ((!str.endsWith(".png")) && (!str.endsWith("jpeg")) && (!str.endsWith("jpg")) && (!str.endsWith("gif"))))
          break;
        Bitmap localBitmap = com.umeng.socialize.utils.a.a(str, 150, 150);
        if (localBitmap == null)
          continue;
        byte[] arrayOfByte = com.umeng.socialize.utils.a.a(localBitmap);
        localObject1 = arrayOfByte;
        if ((localObject1 == null) || (localObject1.length <= 0))
          break;
        this.o = new SoftReference(localObject1);
        i.c(j, "### 首次生成图片二进制数据");
        return localObject1;
        localObject1 = d.a(str);
        com.umeng.socialize.utils.a.a(str, BitmapFactory.decodeByteArray(localObject1, 0, localObject1.length));
        continue;
      }
      catch (Exception localException)
      {
        Object localObject2 = localObject1;
        i.e(j, "get image data from network failed.", localException);
        localObject1 = localObject2;
        continue;
      }
      boolean bool = this.n;
      int i1 = 0;
      if (bool)
      {
        File localFile = this.l;
        i1 = 0;
        if (localFile != null)
        {
          localObject1 = a(this.l);
          continue;
        }
      }
      try
      {
        label261: Thread.sleep(100L);
        while (true)
        {
          i1++;
          if (i1 >= 30)
            break;
          if ((!this.n) || (this.l == null))
            break label261;
          localObject1 = a(this.l);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          localInterruptedException.printStackTrace();
      }
    }
  }

  public void a(float paramFloat)
  {
    this.p = paramFloat;
  }

  protected void a(Context paramContext)
  {
    try
    {
      this.m = paramContext.getCacheDir().getCanonicalPath();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
    if (paramFetchMediaDataListener == null)
      return;
    paramFetchMediaDataListener.a();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      new m(this, paramFetchMediaDataListener).execute(new Void[0]);
      return;
    }
    paramFetchMediaDataListener.a(s());
  }

  protected void a(Object paramObject)
  {
    this.n = false;
    if ((paramObject instanceof Bitmap))
      a((Bitmap)paramObject);
    do
    {
      return;
      if ((paramObject instanceof byte[]))
      {
        a((byte[])(byte[])paramObject);
        return;
      }
      if ((paramObject instanceof File))
      {
        File localFile = (File)paramObject;
        if ((localFile == null) || (!localFile.exists()))
          i.b(j, "the image file is no exist..");
        this.l = localFile;
        q();
        return;
      }
      if ((paramObject instanceof BitmapDrawable))
        try
        {
          a(((BitmapDrawable)paramObject).getBitmap());
          return;
        }
        catch (Exception localException)
        {
          i.b(j, "Sorry cannot setImage..[" + localException.toString() + "]");
          return;
        }
      if (!(paramObject instanceof InputStream))
        continue;
      a((InputStream)paramObject);
      return;
    }
    while (!(paramObject instanceof String));
    this.n = true;
  }

  public final Map<String, Object> c_()
  {
    HashMap localHashMap = new HashMap();
    if (b())
    {
      localHashMap.put(e.y, this.a);
      localHashMap.put(e.z, g());
    }
    return localHashMap;
  }

  public Object clone()
    throws CloneNotSupportedException
  {
    UMImage localUMImage = (UMImage)super.clone();
    if (this.o != null)
      localUMImage.o = new SoftReference(this.o.get());
    return super.clone();
  }

  public byte[] d_()
  {
    return s();
  }

  public UMediaObject.a g()
  {
    return UMediaObject.a.a;
  }

  public boolean h()
  {
    return true;
  }

  public File i()
  {
    return this.l;
  }

  public File j()
    throws IOException
  {
    if (c.a());
    for (String str = Environment.getExternalStorageDirectory().getCanonicalPath(); ; str = this.m)
    {
      File localFile = new File(str + "/umeng_cache/");
      if ((localFile != null) && (!localFile.exists()))
        localFile.mkdirs();
      return localFile;
      if (TextUtils.isEmpty(this.m))
        break;
    }
    throw new IOException("dirpath is unknow");
  }

  public String k()
  {
    if ((this.l != null) && ((this.l instanceof File)))
      return this.l.getAbsolutePath();
    return "";
  }

  public float l()
  {
    return this.p;
  }

  public String m()
  {
    return com.umeng.socialize.b.b.a.c(String.valueOf(System.currentTimeMillis()));
  }

  public boolean n()
  {
    return this.n;
  }

  public void o()
  {
    try
    {
      this.q.lock();
      while (!this.n)
        this.r.await(2L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
      return;
    }
    finally
    {
      this.q.unlock();
    }
    throw localObject;
  }

  public String toString()
  {
    return "UMImage [fileObj=" + this.l + ", sandCache=" + this.m + ", isSerialized=" + this.n + "media_url=" + this.a + ", qzone_title=" + this.b + ", qzone_thumb=" + this.c + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.l != null)
      paramParcel.writeString(this.l.getAbsolutePath());
    while (true)
    {
      paramParcel.writeString(this.m);
      return;
      paramParcel.writeString("");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMImage
 * JD-Core Version:    0.6.0
 */