package com.umeng.socialize.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.umeng.socialize.media.UMImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class a
{
  public static final String a = "umeng_cache";
  public static String b = "/mnt/sdcard/";
  public static final int c = 3145728;
  private static final String d = a.class.getName();
  private static final int e = 1048576;
  private static final int f = 40;
  private static final int g = 10;

  static
  {
    a();
  }

  // ERROR //
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 50	com/umeng/socialize/utils/a:d	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore 7
    //   15: aload 7
    //   17: astore 4
    //   19: aload 4
    //   21: aconst_null
    //   22: aload_0
    //   23: iload_1
    //   24: iload_2
    //   25: invokestatic 53	com/umeng/socialize/utils/a:c	(Ljava/lang/String;II)Landroid/graphics/BitmapFactory$Options;
    //   28: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore 8
    //   33: aload 4
    //   35: invokestatic 62	com/umeng/socialize/utils/a:a	(Ljava/io/InputStream;)V
    //   38: aload 8
    //   40: areturn
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 4
    //   46: aload 6
    //   48: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   51: aload 4
    //   53: invokestatic 62	com/umeng/socialize/utils/a:a	(Ljava/io/InputStream;)V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_3
    //   59: aconst_null
    //   60: astore 4
    //   62: aload_3
    //   63: astore 5
    //   65: aload 4
    //   67: invokestatic 62	com/umeng/socialize/utils/a:a	(Ljava/io/InputStream;)V
    //   70: aload 5
    //   72: athrow
    //   73: astore 5
    //   75: goto -10 -> 65
    //   78: astore 6
    //   80: goto -34 -> 46
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	41	java/lang/Exception
    //   9	15	58	finally
    //   19	33	73	finally
    //   46	51	73	finally
    //   19	33	78	java/lang/Exception
  }

  public static BitmapFactory.Options a(byte[] paramArrayOfByte)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int i = (int)Math.ceil(localOptions.outWidth / UMImage.h);
    int j = (int)Math.ceil(localOptions.outHeight / UMImage.i);
    if ((j > 1) && (i > 1))
      if (j > i)
        localOptions.inSampleSize = j;
    while (true)
    {
      localOptions.inJustDecodeBounds = false;
      return localOptions;
      localOptions.inSampleSize = i;
      continue;
      if (j > 2)
      {
        localOptions.inSampleSize = j;
        continue;
      }
      if (i <= 2)
        continue;
      localOptions.inSampleSize = i;
    }
  }

  public static void a()
  {
    if (Environment.getExternalStorageState().equals("mounted"))
      b = Environment.getExternalStorageDirectory().getPath() + File.separator + "umeng_cache" + File.separator;
    while (true)
    {
      File localFile = new File(b);
      if (!localFile.exists())
        localFile.mkdir();
      try
      {
        e(b);
        System.gc();
        return;
        b = Environment.getDataDirectory().getPath() + File.separator + "umeng_cache" + File.separator;
      }
      catch (Exception localException)
      {
        while (true)
          i.c("BitmapUtils", "清除缓存抛出异常 ： " + localException.toString());
      }
    }
  }

  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      i.c(d, localException.toString());
    }
  }

  public static void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c(paramString)));
      int i = 100;
      if (paramBitmap.getRowBytes() * paramBitmap.getHeight() > 3145728)
        i = 80;
      paramBitmap.compress(Bitmap.CompressFormat.PNG, i, localBufferedOutputStream);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  // ERROR //
  private static void a(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 175	java/io/FileOutputStream
    //   3: dup
    //   4: new 122	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore_2
    //   16: sipush 1024
    //   19: newarray byte
    //   21: astore 9
    //   23: aload_1
    //   24: aload 9
    //   26: invokevirtual 217	java/io/InputStream:read	([B)I
    //   29: istore 10
    //   31: iload 10
    //   33: iconst_m1
    //   34: if_icmpeq +31 -> 65
    //   37: aload_2
    //   38: aload 9
    //   40: iconst_0
    //   41: iload 10
    //   43: invokevirtual 221	java/io/FileOutputStream:write	([BII)V
    //   46: goto -23 -> 23
    //   49: astore 7
    //   51: aload 7
    //   53: invokevirtual 222	java/io/FileNotFoundException:printStackTrace	()V
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   64: return
    //   65: aload_2
    //   66: invokevirtual 224	java/io/FileOutputStream:flush	()V
    //   69: aload_2
    //   70: ifnull -6 -> 64
    //   73: aload_2
    //   74: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   77: return
    //   78: astore 11
    //   80: return
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_3
    //   85: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   88: aload_2
    //   89: ifnull -25 -> 64
    //   92: aload_2
    //   93: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore 6
    //   99: return
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   112: aload 4
    //   114: athrow
    //   115: astore 8
    //   117: return
    //   118: astore 5
    //   120: goto -8 -> 112
    //   123: astore 4
    //   125: goto -21 -> 104
    //   128: astore_3
    //   129: goto -45 -> 84
    //   132: astore 7
    //   134: aconst_null
    //   135: astore_2
    //   136: goto -85 -> 51
    //
    // Exception table:
    //   from	to	target	type
    //   16	23	49	java/io/FileNotFoundException
    //   23	31	49	java/io/FileNotFoundException
    //   37	46	49	java/io/FileNotFoundException
    //   65	69	49	java/io/FileNotFoundException
    //   73	77	78	java/io/IOException
    //   0	16	81	java/io/IOException
    //   92	96	97	java/io/IOException
    //   0	16	100	finally
    //   60	64	115	java/io/IOException
    //   108	112	118	java/io/IOException
    //   16	23	123	finally
    //   23	31	123	finally
    //   37	46	123	finally
    //   51	56	123	finally
    //   65	69	123	finally
    //   84	88	123	finally
    //   16	23	128	java/io/IOException
    //   23	31	128	java/io/IOException
    //   37	46	128	java/io/IOException
    //   65	69	128	java/io/IOException
    //   0	16	132	java/io/FileNotFoundException
  }

  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
      return false;
    while (!new File(c(paramString)).exists());
    return true;
  }

  public static boolean a(String paramString, int paramInt)
  {
    File localFile = new File(c(paramString));
    return (localFile.exists()) && (localFile.length() >= paramInt);
  }

  // ERROR //
  public static byte[] a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: aload_0
    //   7: invokevirtual 235	android/graphics/Bitmap:isRecycled	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 33	com/umeng/socialize/utils/a:d	Ljava/lang/String;
    //   16: ldc 237
    //   18: invokestatic 165	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_1
    //   22: areturn
    //   23: new 239	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 240	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_2
    //   31: aload_0
    //   32: getstatic 243	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   35: bipush 100
    //   37: aload_2
    //   38: invokevirtual 201	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload_2
    //   43: invokevirtual 247	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   46: astore 8
    //   48: aload 8
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull -31 -> 21
    //   55: aload_2
    //   56: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   59: aload_1
    //   60: areturn
    //   61: astore 9
    //   63: aload_1
    //   64: areturn
    //   65: astore_3
    //   66: aconst_null
    //   67: astore_2
    //   68: getstatic 33	com/umeng/socialize/utils/a:d	Ljava/lang/String;
    //   71: aload_3
    //   72: invokevirtual 160	java/lang/Exception:toString	()Ljava/lang/String;
    //   75: invokestatic 250	com/umeng/socialize/utils/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_2
    //   81: ifnull -60 -> 21
    //   84: aload_2
    //   85: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore 6
    //   92: aconst_null
    //   93: areturn
    //   94: astore 10
    //   96: aconst_null
    //   97: astore_2
    //   98: aload 10
    //   100: astore 4
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   110: aload 4
    //   112: athrow
    //   113: astore 5
    //   115: goto -5 -> 110
    //   118: astore 4
    //   120: goto -18 -> 102
    //   123: astore_3
    //   124: goto -56 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   55	59	61	java/io/IOException
    //   23	31	65	java/lang/Exception
    //   84	88	90	java/io/IOException
    //   23	31	94	finally
    //   106	110	113	java/io/IOException
    //   31	48	118	finally
    //   68	78	118	finally
    //   31	48	123	java/lang/Exception
  }

  public static Bitmap b(String paramString)
  {
    InputStream localInputStream = d(paramString);
    if (localInputStream == null)
      return null;
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, null);
    a(localInputStream);
    return localBitmap;
  }

  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    InputStream localInputStream = d(paramString);
    if (localInputStream == null)
      return null;
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, c(paramString, paramInt1, paramInt2));
    a(localInputStream);
    return localBitmap;
  }

  public static void b()
  {
    a();
  }

  private static int c()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return (int)(localStatFs.getAvailableBlocks() * localStatFs.getBlockSize() / 1048576.0D);
  }

  private static BitmapFactory.Options c(String paramString, int paramInt1, int paramInt2)
  {
    InputStream localInputStream = d(paramString);
    if (localInputStream == null)
      return null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(localInputStream, null, localOptions);
      int i = (int)Math.ceil(localOptions.outHeight / paramInt2);
      int j = (int)Math.ceil(localOptions.outWidth / paramInt1);
      if ((i > 1) && (j > 1))
        if (i <= j)
          break label101;
      label101: for (localOptions.inSampleSize = i; ; localOptions.inSampleSize = j)
      {
        localOptions.inJustDecodeBounds = false;
        a(localInputStream);
        return localOptions;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    do
      return paramString;
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    return b + com.umeng.socialize.b.b.a.c(paramString);
  }

  // ERROR //
  private static InputStream d(String paramString)
  {
    // Byte code:
    //   0: invokestatic 279	com/umeng/socialize/bean/ax:b	()Lcom/umeng/socialize/bean/ax;
    //   3: invokevirtual 282	com/umeng/socialize/bean/ax:u	()Z
    //   6: ifeq +81 -> 87
    //   9: new 284	java/io/FileInputStream
    //   12: dup
    //   13: new 122	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokestatic 178	com/umeng/socialize/utils/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +10 -> 39
    //   32: aload_3
    //   33: invokevirtual 288	java/io/InputStream:available	()I
    //   36: ifgt +44 -> 80
    //   39: new 290	java/net/URL
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 291	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 295	java/net/URL:openStream	()Ljava/io/InputStream;
    //   50: astore 5
    //   52: aload_0
    //   53: invokestatic 178	com/umeng/socialize/utils/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   56: aload 5
    //   58: invokestatic 297	com/umeng/socialize/utils/a:a	(Ljava/lang/String;Ljava/io/InputStream;)V
    //   61: new 284	java/io/FileInputStream
    //   64: dup
    //   65: new 122	java/io/File
    //   68: dup
    //   69: aload_0
    //   70: invokestatic 178	com/umeng/socialize/utils/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: astore_3
    //   80: aload_3
    //   81: areturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   87: aconst_null
    //   88: astore_3
    //   89: goto -61 -> 28
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_2
    //   96: astore 4
    //   98: ldc_w 299
    //   101: new 115	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 301
    //   111: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 4
    //   116: invokevirtual 160	java/lang/Exception:toString	()Ljava/lang/String;
    //   119: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 250	com/umeng/socialize/utils/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: areturn
    //   130: astore 4
    //   132: goto -34 -> 98
    //   135: astore 6
    //   137: aload 5
    //   139: astore_3
    //   140: aload 6
    //   142: astore 4
    //   144: goto -46 -> 98
    //
    // Exception table:
    //   from	to	target	type
    //   0	28	82	java/lang/Exception
    //   83	87	92	java/lang/Exception
    //   32	39	130	java/lang/Exception
    //   39	52	130	java/lang/Exception
    //   52	80	135	java/lang/Exception
  }

  private static void e(String paramString)
  {
    int i = 0;
    File[] arrayOfFile = new File(paramString).listFiles();
    if (arrayOfFile.length == 0);
    while (true)
    {
      return;
      int j = 0;
      int k = 0;
      while (j < arrayOfFile.length)
      {
        k = (int)(k + arrayOfFile[j].length());
        j++;
      }
      if ((k <= 10485760) && (40 <= c()))
        continue;
      int m = (int)(1.0D + 0.4D * arrayOfFile.length);
      Arrays.sort(arrayOfFile, new a(null));
      while (i < m)
      {
        arrayOfFile[i].delete();
        i++;
      }
    }
  }

  private static class a
    implements Comparator<File>
  {
    public int a(File paramFile1, File paramFile2)
    {
      if (paramFile1.lastModified() > paramFile2.lastModified())
        return 1;
      if (paramFile1.lastModified() == paramFile2.lastModified())
        return 0;
      return -1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.a
 * JD-Core Version:    0.6.0
 */