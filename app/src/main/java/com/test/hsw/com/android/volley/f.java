package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class f
  implements t
{
  private final Executor a;

  public f(Handler paramHandler)
  {
    this.a = new g(this, paramHandler);
  }

  public f(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }

  public void a(o<?> paramo, s<?> params)
  {
    a(paramo, params, null);
  }

  public void a(o<?> paramo, s<?> params, Runnable paramRunnable)
  {
    paramo.z();
    paramo.a("post-response");
    this.a.execute(new a(paramo, params, paramRunnable));
  }

  public void a(o<?> paramo, x paramx)
  {
    paramo.a("post-error");
    s locals = s.a(paramx);
    this.a.execute(new a(paramo, locals, null));
  }

  private class a
    implements Runnable
  {
    private final o b;
    private final s c;
    private final Runnable d;

    public a(o params, s paramRunnable, Runnable arg4)
    {
      this.b = params;
      this.c = paramRunnable;
      Object localObject;
      this.d = localObject;
    }

    public void run()
    {
      if (this.b.p())
        this.b.b("canceled-at-delivery");
      label97: label107: 
      while (true)
      {
        return;
        if (this.c.a())
        {
          this.b.a(this.c.a);
          if (!this.c.d)
            break label97;
          this.b.a("intermediate-response");
        }
        while (true)
        {
          if (this.d == null)
            break label107;
          this.d.run();
          return;
          this.b.b(this.c.c);
          break;
          this.b.b("done");
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.f
 * JD-Core Version:    0.6.0
 */