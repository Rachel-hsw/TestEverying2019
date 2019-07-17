package org.a.a.a.i;

public class g
{
  private static final long a = 1000000L;
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 10;
  private static final int g = 11;
  private int h = 0;
  private int i = 10;
  private long j;
  private long k;
  private long l;

  public void a()
  {
    if (this.h == 2)
      throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
    if (this.h != 0)
      throw new IllegalStateException("Stopwatch already started. ");
    this.j = System.nanoTime();
    this.k = System.currentTimeMillis();
    this.h = 1;
  }

  public void b()
  {
    if ((this.h != 1) && (this.h != 3))
      throw new IllegalStateException("Stopwatch is not running. ");
    if (this.h == 1)
      this.l = System.nanoTime();
    this.h = 2;
  }

  public void c()
  {
    this.h = 0;
    this.i = 10;
  }

  public void d()
  {
    if (this.h != 1)
      throw new IllegalStateException("Stopwatch is not running. ");
    this.l = System.nanoTime();
    this.i = 11;
  }

  public void e()
  {
    if (this.i != 11)
      throw new IllegalStateException("Stopwatch has not been split. ");
    this.i = 10;
  }

  public void f()
  {
    if (this.h != 1)
      throw new IllegalStateException("Stopwatch must be running to suspend. ");
    this.l = System.nanoTime();
    this.h = 3;
  }

  public void g()
  {
    if (this.h != 3)
      throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    this.j += System.nanoTime() - this.l;
    this.h = 1;
  }

  public long h()
  {
    return i() / 1000000L;
  }

  public long i()
  {
    if ((this.h == 2) || (this.h == 3))
      return this.l - this.j;
    if (this.h == 0)
      return 0L;
    if (this.h == 1)
      return System.nanoTime() - this.j;
    throw new RuntimeException("Illegal running state has occured. ");
  }

  public long j()
  {
    return k() / 1000000L;
  }

  public long k()
  {
    if (this.i != 11)
      throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    return this.l - this.j;
  }

  public long l()
  {
    if (this.h == 0)
      throw new IllegalStateException("Stopwatch has not been started");
    return this.k;
  }

  public String m()
  {
    return c.a(j());
  }

  public String toString()
  {
    return c.a(h());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.g
 * JD-Core Version:    0.6.0
 */