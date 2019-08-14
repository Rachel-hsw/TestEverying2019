package com.android.http;

import android.os.Handler;
import com.withustudy.koudaizikao.g.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class r extends Thread
{
  public static boolean a = false;
  public static int b;
  public static int c;
  private final String d = "http://kdzikao.com/download/android/kdzikao.apk";
  private Handler e;
  private File f;

  public r(Handler paramHandler, File paramFile)
  {
    this.e = paramHandler;
    this.f = paramFile;
  }

  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://kdzikao.com/download/android/kdzikao.apk").openConnection();
      localHttpURLConnection.connect();
      b = localHttpURLConnection.getContentLength();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(this.f);
      byte[] arrayOfByte = new byte[1024];
      c = 0;
      a = true;
      while (true)
      {
        int i = localInputStream.read(arrayOfByte);
        c = i + c;
        this.e.sendEmptyMessage(2);
        if (i <= 0)
        {
          this.e.sendEmptyMessage(1);
          a = false;
          localFileOutputStream.close();
          localInputStream.close();
          return;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      h.a(localMalformedURLException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      h.a(localIOException.getMessage());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.r
 * JD-Core Version:    0.6.0
 */