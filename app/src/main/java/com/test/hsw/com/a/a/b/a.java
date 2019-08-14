package com.a.a.b;

import android.content.Context;
import com.a.a.a.b.a.f;
import com.a.a.b.c.e;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  public static com.a.a.a.a.b a(Context paramContext, com.a.a.a.a.b.a parama, long paramLong, int paramInt)
  {
    File localFile1 = b(paramContext);
    if ((paramLong > 0L) || (paramInt > 0))
    {
      File localFile2 = com.a.a.c.g.b(paramContext);
      try
      {
        com.a.a.a.a.a.a.d locald = new com.a.a.a.a.a.a.d(localFile2, localFile1, parama, paramLong, paramInt);
        return locald;
      }
      catch (IOException localIOException)
      {
        com.a.a.c.d.a(localIOException);
      }
    }
    return new com.a.a.a.a.a.c(com.a.a.c.g.a(paramContext), localFile1, parama);
  }

  public static com.a.a.a.b.c a(int paramInt)
  {
    if (paramInt == 0)
      paramInt = (int)(Runtime.getRuntime().maxMemory() / 8L);
    return new f(paramInt);
  }

  public static com.a.a.b.b.b a(boolean paramBoolean)
  {
    return new com.a.a.b.b.a(paramBoolean);
  }

  public static com.a.a.b.d.b a(Context paramContext)
  {
    return new com.a.a.b.d.a(paramContext);
  }

  public static Executor a()
  {
    return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
  }

  public static Executor a(int paramInt1, int paramInt2, com.a.a.b.a.g paramg)
  {
    int i;
    if (paramg == com.a.a.b.a.g.b)
    {
      i = 1;
      if (i == 0)
        break label56;
    }
    label56: for (Object localObject = new com.a.a.b.a.a.c(); ; localObject = new LinkedBlockingQueue())
    {
      BlockingQueue localBlockingQueue = (BlockingQueue)localObject;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, localBlockingQueue, a(paramInt2, "uil-pool-"));
      i = 0;
      break;
    }
  }

  private static ThreadFactory a(int paramInt, String paramString)
  {
    return new a(paramInt, paramString);
  }

  public static com.a.a.a.a.b.a b()
  {
    return new com.a.a.a.a.b.b();
  }

  private static File b(Context paramContext)
  {
    Object localObject = com.a.a.c.g.a(paramContext, false);
    File localFile = new File((File)localObject, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir()))
      localObject = localFile;
    return (File)localObject;
  }

  public static com.a.a.b.c.a c()
  {
    return new e();
  }

  private static class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;

    a(int paramInt, String paramString)
    {
      this.e = paramInt;
      this.b = Thread.currentThread().getThreadGroup();
      this.d = (paramString + a.getAndIncrement() + "-thread-");
    }

    public Thread newThread(Runnable paramRunnable)
    {
      Thread localThread = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (localThread.isDaemon())
        localThread.setDaemon(false);
      localThread.setPriority(this.e);
      return localThread;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.a
 * JD-Core Version:    0.6.0
 */