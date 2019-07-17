package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadManager
{
  public static final boolean DEBUG_THREAD;
  public static final Executor NETWORK_EXECUTOR = a();
  private static Handler a;
  private static HandlerThread b;
  private static Handler c;
  private static HandlerThread d;

  private static Executor a()
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 11)
      localObject1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    while (true)
    {
      if ((localObject1 instanceof ThreadPoolExecutor))
        ((ThreadPoolExecutor)localObject1).setCorePoolSize(3);
      return localObject1;
      try
      {
        Field localField = AsyncTask.class.getDeclaredField("sExecutor");
        localField.setAccessible(true);
        localObject2 = (Executor)localField.get(null);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        while (true)
          Object localObject2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      }
    }
  }

  public static void executeOnNetWorkThread(Runnable paramRunnable)
  {
    try
    {
      NETWORK_EXECUTOR.execute(paramRunnable);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
    }
  }

  public static void executeOnSubThread(Runnable paramRunnable)
  {
    getSubThreadHandler().post(paramRunnable);
  }

  public static Handler getFileThreadHandler()
  {
    if (c == null)
      monitorenter;
    try
    {
      d = new HandlerThread("QQ_FILE_RW");
      d.start();
      c = new Handler(d.getLooper());
      return c;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static Looper getFileThreadLooper()
  {
    return getFileThreadHandler().getLooper();
  }

  public static Thread getSubThread()
  {
    if (b == null)
      getSubThreadHandler();
    return b;
  }

  public static Handler getSubThreadHandler()
  {
    if (a == null)
      monitorenter;
    try
    {
      b = new HandlerThread("QQ_SUB");
      b.start();
      a = new Handler(b.getLooper());
      return a;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static Looper getSubThreadLooper()
  {
    return getSubThreadHandler().getLooper();
  }

  public static void init()
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.ThreadManager
 * JD-Core Version:    0.6.0
 */