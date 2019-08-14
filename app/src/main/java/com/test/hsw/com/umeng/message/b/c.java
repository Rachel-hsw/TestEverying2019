package com.umeng.message.b;

import java.io.IOException;

class c extends ac
{
  private static c a;
  private boolean c;
  private c d;
  private long e;

  private static void a(c paramc, long paramLong)
  {
    monitorenter;
    try
    {
      if (a == null)
      {
        a = new c();
        new a().start();
      }
      long l1 = System.nanoTime();
      paramc.e = (l1 + paramLong);
      long l2 = paramc.a(l1);
      for (c localc = a; ; localc = localc.d)
      {
        if ((localc.d != null) && (l2 >= localc.d.a(l1)))
          continue;
        paramc.d = localc.d;
        localc.d = paramc;
        if (localc == a)
          c.class.notify();
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static boolean a(c paramc)
  {
    monitorenter;
    try
    {
      c localc = a;
      if (localc != null)
        if (localc.d == paramc)
        {
          localc.d = paramc.d;
          paramc.d = null;
        }
      for (int i = 0; ; i = 1)
      {
        return i;
        localc = localc.d;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static c d()
    throws InterruptedException
  {
    Object localObject1 = null;
    monitorenter;
    while (true)
    {
      c localc;
      try
      {
        localc = a.d;
        if (localc != null)
          continue;
        c.class.wait();
        return localObject1;
        long l1 = localc.a(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          c.class.wait(l2, (int)(l1 - 1000000L * l2));
          localObject1 = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      a.d = localc.d;
      localc.d = null;
      localObject1 = localc;
    }
  }

  protected long a(long paramLong)
  {
    return this.e - paramLong;
  }

  public final void a()
  {
    if (this.c)
      throw new IllegalStateException("Unbalanced enter/exit");
    long l = e();
    if (l == -1L)
      return;
    this.c = true;
    a(this, l);
  }

  public final void a(boolean paramBoolean)
    throws IOException
  {
    if ((b()) && (paramBoolean))
      throw new IOException("timeout");
  }

  public final boolean b()
  {
    if (!this.c)
      return false;
    this.c = false;
    return a(this);
  }

  protected void c()
  {
  }

  static final class a extends Thread
  {
    public a()
    {
      super();
      setDaemon(true);
    }

    public void run()
    {
      while (true)
        try
        {
          c localc = c.d();
          if (localc == null)
            continue;
          localc.c();
          continue;
        }
        catch (InterruptedException localInterruptedException)
        {
        }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.c
 * JD-Core Version:    0.6.0
 */