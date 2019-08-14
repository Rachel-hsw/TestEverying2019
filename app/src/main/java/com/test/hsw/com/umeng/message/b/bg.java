package com.umeng.message.b;

class bg
{
  private boolean a = false;
  private String b;

  bg(boolean paramBoolean, String paramString)
  {
    this.a = paramBoolean;
    this.b = paramString;
  }

  long a()
  {
    if (this.a)
      return 20000L;
    return 300000L;
  }

  long a(long paramLong)
  {
    long l = cl.a(paramLong, this.b);
    if (l <= 2000L)
      return 2000L;
    return l;
  }

  long b()
  {
    if (this.a)
      return 20000L;
    return 120000L;
  }

  long c()
  {
    if (this.a)
      return 1000L;
    return 2000L;
  }

  long d()
  {
    if (this.a)
      return a(10000L);
    return a(2000L);
  }

  long e()
  {
    if (this.a)
      return a(5000L);
    return a(15000L);
  }

  long f()
  {
    if (this.a)
      return a(2000L);
    return a(2000L);
  }

  public long g()
  {
    if (this.a)
      return 5000L;
    return 40000L;
  }

  long h()
  {
    if (this.a)
      return 10000L;
    return 2000L;
  }

  long i()
  {
    if (this.a)
      return 600000L;
    return 1800000L;
  }

  long j()
  {
    if (this.a)
      return 30000L;
    return 60000L;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bg
 * JD-Core Version:    0.6.0
 */