package b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class ac
{
  public static final ac b = new ad();
  private boolean a;
  private long c;
  private long d;

  public ac a(long paramLong)
  {
    this.a = true;
    this.c = paramLong;
    return this;
  }

  public ac a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }

  public final ac b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    return a(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
  }

  public long f()
  {
    return this.d;
  }

  public boolean g()
  {
    return this.a;
  }

  public long h()
  {
    if (!this.a)
      throw new IllegalStateException("No deadline");
    return this.c;
  }

  public ac i()
  {
    this.d = 0L;
    return this;
  }

  public ac j()
  {
    this.a = false;
    return this;
  }

  public void k()
    throws IOException
  {
    if (Thread.interrupted())
      throw new InterruptedIOException();
    if ((this.a) && (System.nanoTime() > this.c))
      throw new IOException("deadline reached");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.ac
 * JD-Core Version:    0.6.0
 */