package b;

import java.io.IOException;
import java.io.InterruptedIOException;

public class a extends ac
{
  private static a a;
  private boolean c;
  private a d;
  private long e;

  private static void a(a parama, long paramLong, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (a != null)
          continue;
        a = new a();
        new a().start();
        long l1 = System.nanoTime();
        if ((paramLong == 0L) || (!paramBoolean))
          continue;
        parama.e = (l1 + Math.min(paramLong, parama.h() - l1));
        long l2 = parama.b(l1);
        locala = a;
        if ((locala.d != null) && (l2 >= locala.d.b(l1)))
          break label183;
        parama.d = locala.d;
        locala.d = parama;
        if (locala != a)
          continue;
        a.class.notify();
        return;
        if (paramLong != 0L)
        {
          long l3 = l1 + paramLong;
          parama.e = l3;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (paramBoolean)
      {
        parama.e = parama.h();
        continue;
      }
      throw new AssertionError();
      label183: a locala = locala.d;
    }
  }

  private static boolean a(a parama)
  {
    monitorenter;
    try
    {
      a locala = a;
      if (locala != null)
        if (locala.d == parama)
        {
          locala.d = parama.d;
          parama.d = null;
        }
      for (int i = 0; ; i = 1)
      {
        return i;
        locala = locala.d;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private long b(long paramLong)
  {
    return this.e - paramLong;
  }

  private static a b()
    throws InterruptedException
  {
    Object localObject1 = null;
    monitorenter;
    while (true)
    {
      a locala;
      try
      {
        locala = a.d;
        if (locala != null)
          continue;
        a.class.wait();
        return localObject1;
        long l1 = locala.b(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          a.class.wait(l2, (int)(l1 - 1000000L * l2));
          localObject1 = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      a.d = locala.d;
      locala.d = null;
      localObject1 = locala;
    }
  }

  public final aa a(aa paramaa)
  {
    return new b(this, paramaa);
  }

  public final ab a(ab paramab)
  {
    return new c(this, paramab);
  }

  final IOException a(IOException paramIOException)
    throws IOException
  {
    if (!d())
      return paramIOException;
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    localInterruptedIOException.initCause(paramIOException);
    return localInterruptedIOException;
  }

  protected void a()
  {
  }

  final void a(boolean paramBoolean)
    throws IOException
  {
    if ((d()) && (paramBoolean))
      throw new InterruptedIOException("timeout");
  }

  public final void c()
  {
    if (this.c)
      throw new IllegalStateException("Unbalanced enter/exit");
    long l = f();
    boolean bool = g();
    if ((l == 0L) && (!bool))
      return;
    this.c = true;
    a(this, l, bool);
  }

  public final boolean d()
  {
    if (!this.c)
      return false;
    this.c = false;
    return a(this);
  }

  private static final class a extends Thread
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
          a locala = a.e();
          if (locala == null)
            continue;
          locala.a();
          continue;
        }
        catch (InterruptedException localInterruptedException)
        {
        }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.6.0
 */