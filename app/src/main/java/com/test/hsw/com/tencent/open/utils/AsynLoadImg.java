package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynLoadImg
{
  private static String c;
  private String a;
  private AsynLoadImgBack b;
  private long d;
  private Handler e;
  private Runnable f = new AsynLoadImg.2(this);

  public AsynLoadImg(Activity paramActivity)
  {
    this.e = new AsynLoadImg.1(this, paramActivity.getMainLooper());
  }

  public static Bitmap getbitmap(String paramString)
  {
    f.a("AsynLoadImg", "getbitmap:" + paramString);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      f.a("AsynLoadImg", "image download finished." + paramString);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      f.a("AsynLoadImg", "getbitmap bmp fail---");
    }
    return null;
  }

  public void save(String paramString, AsynLoadImgBack paramAsynLoadImgBack)
  {
    f.a("AsynLoadImg", "--save---");
    if ((paramString == null) || (paramString.equals("")))
    {
      paramAsynLoadImgBack.saved(1, null);
      return;
    }
    if (!Util.hasSDCard())
    {
      paramAsynLoadImgBack.saved(2, null);
      return;
    }
    c = Environment.getExternalStorageDirectory() + "/tmp/";
    this.d = System.currentTimeMillis();
    this.a = paramString;
    this.b = paramAsynLoadImgBack;
    new Thread(this.f).start();
  }

  // ERROR //
  public boolean saveFile(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: getstatic 46	com/tencent/open/utils/AsynLoadImg:c	Ljava/lang/String;
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 169	java/io/File
    //   10: dup
    //   11: aload_3
    //   12: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 173	java/io/File:exists	()Z
    //   22: istore 11
    //   24: aconst_null
    //   25: astore 4
    //   27: iload 11
    //   29: ifne +9 -> 38
    //   32: aload 5
    //   34: invokevirtual 176	java/io/File:mkdir	()Z
    //   37: pop
    //   38: new 61	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   45: aload_3
    //   46: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 13
    //   58: ldc 59
    //   60: new 61	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   67: ldc 178
    //   69: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 76	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: new 180	java/io/BufferedOutputStream
    //   85: dup
    //   86: new 182	java/io/FileOutputStream
    //   89: dup
    //   90: new 169	java/io/File
    //   93: dup
    //   94: aload 13
    //   96: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 185	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: invokespecial 188	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   105: astore 14
    //   107: aload_1
    //   108: getstatic 194	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   111: bipush 80
    //   113: aload 14
    //   115: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   118: pop
    //   119: aload 14
    //   121: invokevirtual 203	java/io/BufferedOutputStream:flush	()V
    //   124: aload 14
    //   126: ifnull +8 -> 134
    //   129: aload 14
    //   131: invokevirtual 204	java/io/BufferedOutputStream:close	()V
    //   134: iconst_1
    //   135: istore 9
    //   137: iload 9
    //   139: ireturn
    //   140: astore 16
    //   142: aload 16
    //   144: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   147: goto -13 -> 134
    //   150: astore 8
    //   152: aload 8
    //   154: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   157: ldc 59
    //   159: ldc 206
    //   161: invokestatic 76	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iconst_0
    //   165: istore 9
    //   167: aload 4
    //   169: ifnull -32 -> 137
    //   172: aload 4
    //   174: invokevirtual 204	java/io/BufferedOutputStream:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore 10
    //   181: aload 10
    //   183: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore 6
    //   190: aload 4
    //   192: ifnull +8 -> 200
    //   195: aload 4
    //   197: invokevirtual 204	java/io/BufferedOutputStream:close	()V
    //   200: aload 6
    //   202: athrow
    //   203: astore 7
    //   205: aload 7
    //   207: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   210: goto -10 -> 200
    //   213: astore 6
    //   215: aload 14
    //   217: astore 4
    //   219: goto -29 -> 190
    //   222: astore 8
    //   224: aload 14
    //   226: astore 4
    //   228: goto -76 -> 152
    //
    // Exception table:
    //   from	to	target	type
    //   129	134	140	java/io/IOException
    //   7	24	150	java/io/IOException
    //   32	38	150	java/io/IOException
    //   38	107	150	java/io/IOException
    //   172	177	179	java/io/IOException
    //   7	24	188	finally
    //   32	38	188	finally
    //   38	107	188	finally
    //   152	164	188	finally
    //   195	200	203	java/io/IOException
    //   107	124	213	finally
    //   107	124	222	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.AsynLoadImg
 * JD-Core Version:    0.6.0
 */