package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class c extends Thread
{
  private static final boolean a = y.b;
  private final BlockingQueue<o<?>> b;
  private final BlockingQueue<o<?>> c;
  private final b d;
  private final t e;
  private volatile boolean f = false;

  public c(BlockingQueue<o<?>> paramBlockingQueue1, BlockingQueue<o<?>> paramBlockingQueue2, b paramb, t paramt)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramb;
    this.e = paramt;
  }

  public void a()
  {
    this.f = true;
    interrupt();
  }

  public void run()
  {
    if (a)
      y.a("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    this.d.a();
    while (true)
    {
      o localo;
      try
      {
        localo = (o)this.b.take();
        localo.a("cache-queue-take");
        if (!localo.p())
          break label73;
        localo.b("cache-discard-canceled");
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      if (this.f)
      {
        return;
        label73: b.a locala = this.d.a(localo.m());
        if (locala == null)
        {
          localo.a("cache-miss");
          this.c.put(localo);
          continue;
        }
        if (locala.a())
        {
          localo.a("cache-hit-expired");
          localo.a(locala);
          this.c.put(localo);
          continue;
        }
        localo.a("cache-hit");
        s locals = localo.a(new l(locala.a, locala.g));
        localo.a("cache-hit-parsed");
        if (!locala.b())
        {
          this.e.a(localo, locals);
          continue;
        }
        localo.a("cache-hit-refresh-needed");
        localo.a(locala);
        locals.d = true;
        this.e.a(localo, locals, new d(this, localo));
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.c
 * JD-Core Version:    0.6.0
 */