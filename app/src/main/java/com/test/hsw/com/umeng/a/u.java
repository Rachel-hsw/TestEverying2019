package com.umeng.a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class u
{
  private static List<WeakReference<ScheduledFuture<?>>> a = new ArrayList();
  private static ExecutorService b = Executors.newSingleThreadExecutor();
  private static long c = 5L;
  private static ScheduledExecutorService d = Executors.newSingleThreadScheduledExecutor();

  public static void a()
  {
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        ScheduledFuture localScheduledFuture = (ScheduledFuture)((WeakReference)localIterator.next()).get();
        if (localScheduledFuture == null)
          continue;
        localScheduledFuture.cancel(false);
      }
      a.clear();
      if (!b.isShutdown())
        b.shutdown();
      if (!d.isShutdown())
        d.shutdown();
      b.awaitTermination(c, TimeUnit.SECONDS);
      d.awaitTermination(c, TimeUnit.SECONDS);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Runnable paramRunnable)
  {
    if (b.isShutdown())
      b = Executors.newSingleThreadExecutor();
    b.execute(paramRunnable);
  }

  public static void a(Runnable paramRunnable, long paramLong)
  {
    monitorenter;
    try
    {
      if (d.isShutdown())
        d = Executors.newSingleThreadScheduledExecutor();
      a.add(new WeakReference(d.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS)));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void b(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      if (d.isShutdown())
        d = Executors.newSingleThreadScheduledExecutor();
      d.execute(paramRunnable);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public static void c(Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	com/umeng/a/u:d	Ljava/util/concurrent/ScheduledExecutorService;
    //   6: invokeinterface 84 1 0
    //   11: ifeq +9 -> 20
    //   14: invokestatic 38	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   17: putstatic 40	com/umeng/a/u:d	Ljava/util/concurrent/ScheduledExecutorService;
    //   20: getstatic 40	com/umeng/a/u:d	Ljava/util/concurrent/ScheduledExecutorService;
    //   23: aload_0
    //   24: invokeinterface 120 2 0
    //   29: astore_2
    //   30: aload_2
    //   31: ldc2_w 31
    //   34: getstatic 91	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   37: invokeinterface 125 4 0
    //   42: pop
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_3
    //   54: goto -11 -> 43
    //
    // Exception table:
    //   from	to	target	type
    //   3	20	47	finally
    //   20	30	47	finally
    //   30	43	47	finally
    //   30	43	53	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.u
 * JD-Core Version:    0.6.0
 */