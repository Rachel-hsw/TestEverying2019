package com.gensee.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool
{
  public static ThreadPool threadPool;
  private ExecutorService pool = Executors.newSingleThreadExecutor();

  public static ThreadPool getInstance()
  {
    if (threadPool == null)
      threadPool = new ThreadPool();
    return threadPool;
  }

  public void execute(Runnable paramRunnable)
  {
    if (this.pool != null)
      this.pool.submit(paramRunnable);
  }

  public void shutDown()
  {
    if (this.pool != null)
    {
      this.pool.shutdown();
      this.pool = null;
    }
    threadPool = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.ThreadPool
 * JD-Core Version:    0.6.0
 */