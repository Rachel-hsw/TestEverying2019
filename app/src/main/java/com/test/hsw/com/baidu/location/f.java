package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.a.a;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

public class f extends Service
  implements com.baidu.location.b.f
{
  public static boolean isServing = false;
  private static final String l4 = "app.jar";
  public static Context mC;
  public static String replaceFileName = "repll.jar";
  LLSInterface l3 = null;
  LLSInterface l5 = null;
  LLSInterface l6 = null;

  static
  {
    mC = null;
    isServing = false;
  }

  private boolean jdMethod_do(File paramFile)
  {
    int i = 0;
    String str1 = e.int + "/grtcf.dat";
    try
    {
      File localFile = new File(str1);
      boolean bool1 = localFile.exists();
      i = 0;
      if (bool1)
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(200L);
        boolean bool2 = localRandomAccessFile.readBoolean();
        i = 0;
        if (bool2)
        {
          boolean bool3 = localRandomAccessFile.readBoolean();
          i = 0;
          if (bool3)
          {
            int j = localRandomAccessFile.readInt();
            i = 0;
            if (j != 0)
            {
              byte[] arrayOfByte = new byte[j];
              localRandomAccessFile.read(arrayOfByte, 0, j);
              String str2 = new String(arrayOfByte);
              String str3 = k.jdMethod_if(paramFile);
              i = 0;
              if (str2 != null)
              {
                i = 0;
                if (str3 != null)
                {
                  boolean bool4 = str3.equals(str2);
                  i = 0;
                  if (bool4)
                    i = 1;
                }
              }
            }
          }
        }
        localRandomAccessFile.close();
      }
      return i;
    }
    catch (Exception localException)
    {
    }
    return i;
  }

  public static float getFrameVersion()
  {
    return 6.13F;
  }

  public static String getJarFileName()
  {
    return "app.jar";
  }

  public static Context getServiceContext()
  {
    return mC;
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.l6.onBind(paramIntent);
  }

  public void onCreate()
  {
    mC = getApplicationContext();
    System.currentTimeMillis();
    this.l5 = new a();
    try
    {
      File localFile1 = new File(k.ai() + File.separator + replaceFileName);
      File localFile2 = new File(k.ai() + File.separator + "app.jar");
      if (localFile1.exists())
      {
        if (localFile2.exists())
          localFile2.delete();
        localFile1.renameTo(localFile2);
      }
      if (localFile2.exists())
        this.l3 = ((LLSInterface)new DexClassLoader(k.ai() + File.separator + "app.jar", k.ai(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance());
      if ((this.l3 != null) && (this.l3.getVersion() >= this.l5.getVersion()) && (jdMethod_do(new File(k.ai() + File.separator + "app.jar"))))
      {
        this.l6 = this.l3;
        this.l5 = null;
        isServing = true;
        this.l6.onCreate(this);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.l3 = null;
        continue;
        this.l6 = this.l5;
        this.l3 = null;
      }
    }
  }

  public void onDestroy()
  {
    isServing = false;
    this.l6.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.l6.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return this.l6.onUnBind(paramIntent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.f
 * JD-Core Version:    0.6.0
 */