package com.umeng.message.b;

public class cp
{
  private static final String a = "ThreadUtil";
  private static int b;

  private static final int a()
  {
    monitorenter;
    try
    {
      int i = b;
      b = i + 1;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static final void a(Runnable paramRunnable)
  {
    if (paramRunnable != null);
    try
    {
      new Thread(paramRunnable, "agoo-thread-" + a()).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e("ThreadUtil", "startTread", localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cp
 * JD-Core Version:    0.6.0
 */