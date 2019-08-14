package org.a.a.a.b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.a.a.a.a.a;

public class d
  implements ThreadFactory
{
  private final AtomicLong a;
  private final ThreadFactory b;
  private final Thread.UncaughtExceptionHandler c;
  private final String d;
  private final Integer e;
  private final Boolean f;

  private d(a parama)
  {
    if (a.a(parama) == null);
    for (this.b = Executors.defaultThreadFactory(); ; this.b = a.a(parama))
    {
      this.d = a.b(parama);
      this.e = a.c(parama);
      this.f = a.d(parama);
      this.c = a.e(parama);
      this.a = new AtomicLong();
      return;
    }
  }

  private void a(Thread paramThread)
  {
    if (b() != null)
    {
      Long localLong = Long.valueOf(this.a.incrementAndGet());
      paramThread.setName(String.format(b(), new Object[] { localLong }));
    }
    if (e() != null)
      paramThread.setUncaughtExceptionHandler(e());
    if (d() != null)
      paramThread.setPriority(d().intValue());
    if (c() != null)
      paramThread.setDaemon(c().booleanValue());
  }

  public final ThreadFactory a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.d;
  }

  public final Boolean c()
  {
    return this.f;
  }

  public final Integer d()
  {
    return this.e;
  }

  public final Thread.UncaughtExceptionHandler e()
  {
    return this.c;
  }

  public long f()
  {
    return this.a.get();
  }

  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = a().newThread(paramRunnable);
    a(localThread);
    return localThread;
  }

  public static class a
    implements a<d>
  {
    private ThreadFactory a;
    private Thread.UncaughtExceptionHandler b;
    private String c;
    private Integer d;
    private Boolean e;

    public a a(int paramInt)
    {
      this.d = Integer.valueOf(paramInt);
      return this;
    }

    public a a(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("Naming pattern must not be null!");
      this.c = paramString;
      return this;
    }

    public a a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      if (paramUncaughtExceptionHandler == null)
        throw new NullPointerException("Uncaught exception handler must not be null!");
      this.b = paramUncaughtExceptionHandler;
      return this;
    }

    public a a(ThreadFactory paramThreadFactory)
    {
      if (paramThreadFactory == null)
        throw new NullPointerException("Wrapped ThreadFactory must not be null!");
      this.a = paramThreadFactory;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.e = Boolean.valueOf(paramBoolean);
      return this;
    }

    public void b()
    {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
    }

    public d c()
    {
      d locald = new d(this, null);
      b();
      return locald;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.d
 * JD-Core Version:    0.6.0
 */