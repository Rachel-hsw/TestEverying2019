package com.withustudy.koudaizikao.b;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.withustudy.koudaizikao.g.f;
import com.withustudy.koudaizikao.g.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import koudai.db.CourseJiangYiInforDao;
import koudai.db.b;

class al
  implements Runnable
{
  al(ah paramah, String paramString, int paramInt)
  {
  }

  public void run()
  {
    try
    {
      URL localURL = new URL(this.b);
      h.a("url =" + localURL);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
      i = localHttpURLConnection.getContentLength();
      if (i < 0)
      {
        this.a.b.obtainMessage(1).sendToTarget();
        return;
      }
      b localb = new b();
      localb.b(this.b);
      localb.b(Integer.valueOf(i));
      File localFile = f.a(ah.b(this.a)).b(f.c + ah.a(this.a, this.b));
      localb.a(localFile.getAbsolutePath());
      this.a.a.a.setMax(i);
      this.a.a.a.setProgress(0);
      localb.a(Integer.valueOf(0));
      ah.c(this.a).c(localb);
      localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile.setLength(i);
      try
      {
        InputStream localInputStream = localHttpURLConnection.getInputStream();
        arrayOfByte = new byte[1024];
        localRandomAccessFile.seek(0L);
        j = localInputStream.read(arrayOfByte);
        if (j == -1)
        {
          localInputStream.close();
          localRandomAccessFile.close();
          return;
        }
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
      {
        int i;
        RandomAccessFile localRandomAccessFile;
        byte[] arrayOfByte;
        int j;
        localMalformedURLException.printStackTrace();
        return;
        localRandomAccessFile.write(arrayOfByte, 0, j);
        ah.a(this.a, this.c, this.b, i, j);
      }
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.al
 * JD-Core Version:    0.6.0
 */