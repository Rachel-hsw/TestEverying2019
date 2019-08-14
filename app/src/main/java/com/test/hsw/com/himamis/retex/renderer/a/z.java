package com.himamis.retex.renderer.a;

public class z
{
  private d a;
  private boolean b = false;
  private int c = -1;

  public z(d paramd)
  {
    this.a = paramd;
  }

  public int a()
  {
    return this.c;
  }

  public i a(dp paramdp)
  {
    if (this.b)
      ((q)this.a).e();
    i locali = this.a.a(paramdp);
    if (this.b)
      ((q)this.a).f();
    return locali;
  }

  public p a(dq paramdq)
  {
    return ((q)this.a).a(paramdq);
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(ag paramag)
  {
    this.b = false;
    this.c = -1;
    this.a = paramag;
  }

  public void a(z paramz)
  {
    if ((this.a instanceof ck))
      ((ck)this.a).a(paramz);
  }

  public int b()
  {
    if (this.c >= 0)
      return this.c;
    return this.a.a();
  }

  public int c()
  {
    if (this.c >= 0)
      return this.c;
    return this.a.b();
  }

  public boolean d()
  {
    return this.a instanceof q;
  }

  public void e()
  {
    this.b = true;
  }

  public boolean f()
  {
    return this.a instanceof cu;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.z
 * JD-Core Version:    0.6.0
 */