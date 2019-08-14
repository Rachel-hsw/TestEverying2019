package com.squareup.a.a.b;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class n
{
  private final CountDownLatch a = new CountDownLatch(1);
  private long b = -1L;
  private long c = -1L;

  public long a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (this.a.await(paramLong, paramTimeUnit))
      return this.c - this.b;
    return -2L;
  }

  void a()
  {
    if (this.b != -1L)
      throw new IllegalStateException();
    this.b = System.nanoTime();
  }

  void b()
  {
    if ((this.c != -1L) || (this.b == -1L))
      throw new IllegalStateException();
    this.c = System.nanoTime();
    this.a.countDown();
  }

  void c()
  {
    if ((this.c != -1L) || (this.b == -1L))
      throw new IllegalStateException();
    this.c = (this.b - 1L);
    this.a.countDown();
  }

  public long d()
    throws InterruptedException
  {
    this.a.await();
    return this.c - this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.n
 * JD-Core Version:    0.6.0
 */