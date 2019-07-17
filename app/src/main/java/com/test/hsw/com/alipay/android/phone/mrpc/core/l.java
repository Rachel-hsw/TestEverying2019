package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class l
  implements ab
{
  private static l b = null;
  private static final ThreadFactory i = new n();
  Context a;
  private ThreadPoolExecutor c;
  private b d;
  private long e;
  private long f;
  private long g;
  private int h;

  private l(Context paramContext)
  {
    this.a = paramContext;
    this.d = b.a("android");
    this.c = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
    try
    {
      this.c.allowCoreThreadTimeOut(true);
      label66: CookieSyncManager.createInstance(this.a);
      CookieManager.getInstance().setAcceptCookie(true);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }

  public static final l a(Context paramContext)
  {
    if (b != null)
      return b;
    return b(paramContext);
  }

  private static final l b(Context paramContext)
  {
    monitorenter;
    try
    {
      l locall;
      if (b != null)
        locall = b;
      while (true)
      {
        return locall;
        locall = new l(paramContext);
        b = locall;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final b a()
  {
    return this.d;
  }

  public final Future<u> a(t paramt)
  {
    long l1 = 0L;
    String str;
    Object[] arrayOfObject;
    long l2;
    if (s.a(this.a))
    {
      str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
      arrayOfObject = new Object[9];
      arrayOfObject[0] = Integer.valueOf(this.c.getActiveCount());
      arrayOfObject[1] = Long.valueOf(this.c.getCompletedTaskCount());
      arrayOfObject[2] = Long.valueOf(this.c.getTaskCount());
      if (this.g != l1)
        break label218;
      l2 = l1;
      arrayOfObject[3] = Long.valueOf(l2);
      if (this.h != 0)
        break label239;
    }
    while (true)
    {
      arrayOfObject[4] = Long.valueOf(l1);
      arrayOfObject[5] = Long.valueOf(this.e);
      arrayOfObject[6] = Long.valueOf(this.f);
      arrayOfObject[7] = Long.valueOf(this.g);
      arrayOfObject[8] = Integer.valueOf(this.h);
      String.format(str, arrayOfObject);
      q localq = new q(this, (o)paramt);
      m localm = new m(this, localq, localq);
      this.c.execute(localm);
      return localm;
      label218: l2 = 1000L * this.e / this.g >> 10;
      break;
      label239: l1 = this.f / this.h;
    }
  }

  public final void a(long paramLong)
  {
    this.e = (paramLong + this.e);
  }

  public final void b(long paramLong)
  {
    this.f = (paramLong + this.f);
    this.h = (1 + this.h);
  }

  public final void c(long paramLong)
  {
    this.g = (paramLong + this.g);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.l
 * JD-Core Version:    0.6.0
 */