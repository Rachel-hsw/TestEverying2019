package com.umeng.message.b;

import android.annotation.SuppressLint;
import android.net.LocalServerSocket;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ax extends av
{
  private static final String b = "local_socket_lock_";
  private static final String c = "LocalSocket2DistributedLock";
  private String d;
  private LocalServerSocket e = null;

  public ax(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "local_socket_lock_";
      arrayOfObject1[1] = e();
      this.d = String.format("%s_%s", arrayOfObject1);
      return;
    }
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = paramString;
    arrayOfObject2[1] = e();
    this.d = String.format("%s_%s", arrayOfObject2);
  }

  @SuppressLint({"SimpleDateFormat"})
  private static final String e()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "none";
  }

  protected void a()
  {
    a(2147483647L, TimeUnit.SECONDS);
  }

  protected boolean a(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      LocalServerSocket localLocalServerSocket = this.e;
      int i = 0;
      if (localLocalServerSocket == null)
      {
        this.e = new LocalServerSocket(this.d);
        i = 1;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LocalSocket2DistributedLock", "doTryLock", localThrowable);
    }
    return false;
  }

  protected void b()
  {
    try
    {
      if (this.e != null)
        this.e.close();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected boolean c()
  {
    return a(0L, TimeUnit.SECONDS);
  }

  protected void d()
    throws InterruptedException
  {
    a(2147483647L, TimeUnit.SECONDS);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ax
 * JD-Core Version:    0.6.0
 */