package com.umeng.message.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class ac
{
  public static final ac b = new ad();
  private long a;
  private long c = -1L;
  private long d = -1L;

  public ac a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("timeout <= 0: " + paramLong);
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }

  public ac b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    this.a = System.nanoTime();
    this.c = paramTimeUnit.toNanos(paramLong);
    return this;
  }

  public long e()
  {
    return this.d;
  }

  public ac f()
  {
    this.c = -1L;
    this.d = -1L;
    return this;
  }

  public void g()
    throws IOException
  {
    if (Thread.interrupted())
      throw new InterruptedIOException();
    if ((this.c != -1L) && (System.nanoTime() - this.a > this.c))
      throw new IOException("deadline reached");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ac
 * JD-Core Version:    0.6.0
 */