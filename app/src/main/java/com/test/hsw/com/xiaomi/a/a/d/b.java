package com.xiaomi.a.a.d;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.a.a.c.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class b
{
  private a a;
  private Handler b = null;
  private volatile boolean c = false;
  private final boolean d;
  private int e = 0;
  private volatile b f;

  public b()
  {
    this(false);
  }

  public b(boolean paramBoolean)
  {
    this(paramBoolean, 0);
  }

  public b(boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.e = paramInt;
  }

  private void a()
  {
    monitorenter;
    try
    {
      this.a = null;
      this.c = true;
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

  public void a(b paramb)
  {
    monitorenter;
    try
    {
      if (this.a == null)
      {
        this.a = new a();
        this.a.setDaemon(this.d);
        this.c = false;
        this.a.start();
      }
      this.a.a(paramb);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(b paramb, long paramLong)
  {
    this.b.postDelayed(new d(this, paramb), paramLong);
  }

  private class a extends Thread
  {
    private final LinkedBlockingQueue<b.b> b = new LinkedBlockingQueue();

    public a()
    {
      super();
    }

    public void a(b.b paramb)
    {
      this.b.add(paramb);
    }

    public void run()
    {
      int i;
      if (b.a(b.this) > 0)
        i = b.a(b.this);
      while (!b.b(b.this))
      {
        try
        {
          b.a(b.this, (b.b)this.b.poll(i, TimeUnit.SECONDS));
          if (b.c(b.this) == null)
            break label153;
          Message localMessage1 = b.d(b.this).obtainMessage(0, b.c(b.this));
          b.d(b.this).sendMessage(localMessage1);
          b.c(b.this).b();
          Message localMessage2 = b.d(b.this).obtainMessage(1, b.c(b.this));
          b.d(b.this).sendMessage(localMessage2);
        }
        catch (InterruptedException localInterruptedException)
        {
          c.a(localInterruptedException);
        }
        continue;
        int j = 1;
        continue;
        label153: if (b.a(b.this) <= 0)
          continue;
        b.e(b.this);
      }
    }
  }

  public static abstract class b
  {
    public void a()
    {
    }

    public abstract void b();

    public void c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.d.b
 * JD-Core Version:    0.6.0
 */