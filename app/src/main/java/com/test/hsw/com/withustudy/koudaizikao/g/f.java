package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class f
{
  public static final String a = "sdcard_not_exists";
  public static final String b = "file_not_exists";
  public static String c = "";
  public static String d;
  private static f f;
  private static final String g = "KouDaiZiKao";
  private static final String h = "/";
  private static final String i = "/KouDaiZiKao/";
  private Context e;

  private f(Context paramContext)
  {
    this.e = paramContext;
    d = c();
    c = d();
  }

  public static f a(Context paramContext)
  {
    if (f == null)
      monitorenter;
    try
    {
      if (f == null)
        f = new f(paramContext);
      return f;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public File a(File paramFile, Bitmap paramBitmap)
  {
    try
    {
      localFileOutputStream = new FileOutputStream(paramFile);
      long l = paramBitmap.getHeight() * paramBitmap.getWidth();
      if (l <= 204800L)
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      while (true)
      {
        localFileOutputStream.flush();
        localFileOutputStream.close();
        paramBitmap.recycle();
        return paramFile;
        if ((l <= 204800L) || (l <= 1536000L))
          break;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 40, localFileOutputStream);
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        FileOutputStream localFileOutputStream;
        Toast.makeText(this.e, "FileNotFound", 0).show();
        localIOException.printStackTrace();
        return null;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 20, localFileOutputStream);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        Toast.makeText(this.e, "图片过大，小袋内存不够用啦!", 0).show();
        localOutOfMemoryError.printStackTrace();
      }
    }
  }

  public File a(File paramFile, String paramString)
  {
    try
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      l = localOptions.outWidth * localOptions.outHeight;
      if (l <= 409600L);
      for (localOptions.inSampleSize = 1; ; localOptions.inSampleSize = 2)
      {
        localOptions.inJustDecodeBounds = false;
        Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        localBitmap.recycle();
        return paramFile;
        if ((l <= 409600L) || (l > 1024000L))
          break;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        long l;
        Toast.makeText(this.e, "FileNotFound", 0).show();
        localIOException.printStackTrace();
        return null;
        if ((l <= 1024000L) || (l > 2048000L))
          break;
        localOptions.inSampleSize = 4;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        BitmapFactory.Options localOptions;
        Toast.makeText(this.e, "图片过大，小袋内存不够用啦!", 0).show();
        localOutOfMemoryError.printStackTrace();
        continue;
        localOptions.inSampleSize = 8;
      }
    }
  }

  public File a(String paramString)
  {
    File localFile = new File(b() + paramString);
    try
    {
      if (localFile.exists())
      {
        localFile.delete();
        localFile.createNewFile();
        return localFile;
      }
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localFile;
  }

  public String a()
  {
    if (Environment.getExternalStorageState().equals("mounted"))
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    return "sdcard_not_exists";
  }

  public void a(File paramFile)
  {
    if (paramFile.exists())
      paramFile.delete();
  }

  public File b(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
        localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localFile;
  }

  public String b()
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      File localFile = new File(a() + "/KouDaiZiKao/");
      if (!localFile.exists())
        localFile.mkdirs();
      return localFile.getAbsolutePath() + "/";
    }
    return this.e.getFilesDir().getAbsolutePath() + "/";
  }

  public String c()
  {
    File localFile = new File(b() + "Video");
    if (!localFile.exists())
      localFile.mkdirs();
    return localFile.getAbsolutePath() + "/";
  }

  public String c(String paramString)
  {
    if (d(b() + paramString))
      return b() + paramString;
    return "file_not_exists";
  }

  public String d()
  {
    File localFile = new File(b() + "JiangYi");
    if (!localFile.exists())
      localFile.mkdirs();
    return localFile.getAbsolutePath() + "/";
  }

  public boolean d(String paramString)
  {
    return new File(paramString).exists();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.f
 * JD-Core Version:    0.6.0
 */