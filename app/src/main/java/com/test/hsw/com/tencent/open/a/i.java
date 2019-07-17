package com.tencent.open.a;

public abstract class i
{
  private volatile int a = c.b;
  private volatile boolean b = true;
  private h c = h.a;

  public i()
  {
    this(c.b, true, h.a);
  }

  public i(int paramInt, boolean paramBoolean, h paramh)
  {
    a(paramInt);
    a(paramBoolean);
    a(paramh);
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  protected abstract void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable);

  public void a(h paramh)
  {
    this.c = paramh;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void b(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((d()) && (d.a.a(this.a, paramInt)))
      a(paramInt, paramThread, paramLong, paramString1, paramString2, paramThrowable);
  }

  public boolean d()
  {
    return this.b;
  }

  public h e()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.i
 * JD-Core Version:    0.6.0
 */