package org.a.a.a.b;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class m
{
  public static final int a = 0;
  private static final int b = 1;
  private final ScheduledExecutorService c;
  private final long d;
  private final TimeUnit e;
  private final boolean f;
  private ScheduledFuture<?> g;
  private long h;
  private long i;
  private int j;
  private int k;
  private int l;
  private boolean m;

  public m(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    this(null, paramLong, paramTimeUnit, paramInt);
  }

  public m(ScheduledExecutorService paramScheduledExecutorService, long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("Time period must be greater 0!");
    this.d = paramLong;
    this.e = paramTimeUnit;
    if (paramScheduledExecutorService != null)
      this.c = paramScheduledExecutorService;
    for (this.f = false; ; this.f = true)
    {
      a(paramInt);
      return;
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
      localScheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
      localScheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
      this.c = localScheduledThreadPoolExecutor;
    }
  }

  public final int a()
  {
    monitorenter;
    try
    {
      int n = this.j;
      monitorexit;
      return n;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void a(int paramInt)
  {
    monitorenter;
    try
    {
      this.j = paramInt;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    monitorenter;
    try
    {
      if (!this.m)
      {
        if (this.f)
          k().shutdownNow();
        if (this.g != null)
          this.g.cancel(false);
        this.m = true;
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      boolean bool = this.m;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void d()
    throws InterruptedException
  {
    monitorenter;
    try
    {
      if (c())
        throw new IllegalStateException("TimedSemaphore is shut down!");
    }
    finally
    {
      monitorexit;
    }
    if (this.g == null)
      this.g = l();
    if (a() > 0)
      if (this.k < a())
        break label93;
    while (true)
    {
      if (n == 0)
        wait();
      while (true)
      {
        if (n == 0)
          break label91;
        monitorexit;
        return;
        n = 0;
        break;
        this.k = (1 + this.k);
      }
      label91: break;
      label93: int n = 1;
    }
  }

  public int e()
  {
    monitorenter;
    try
    {
      int n = this.l;
      monitorexit;
      return n;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int f()
  {
    monitorenter;
    try
    {
      int n = this.k;
      monitorexit;
      return n;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int g()
  {
    monitorenter;
    try
    {
      int n = a();
      int i1 = f();
      int i2 = n - i1;
      monitorexit;
      return i2;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public double h()
  {
    monitorenter;
    try
    {
      long l1 = this.i;
      double d2;
      if (l1 == 0L)
        d2 = 0.0D;
      while (true)
      {
        return d2;
        double d1 = this.h;
        long l2 = this.i;
        d2 = d1 / l2;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public long i()
  {
    return this.d;
  }

  public TimeUnit j()
  {
    return this.e;
  }

  protected ScheduledExecutorService k()
  {
    return this.c;
  }

  protected ScheduledFuture<?> l()
  {
    return k().scheduleAtFixedRate(new n(this), i(), i(), j());
  }

  void m()
  {
    monitorenter;
    try
    {
      this.l = this.k;
      this.h += this.k;
      this.i = (1L + this.i);
      this.k = 0;
      notifyAll();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.m
 * JD-Core Version:    0.6.0
 */