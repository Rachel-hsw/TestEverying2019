package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.a.a;
import com.himamis.retex.renderer.a.g.c.c;

public class o extends i
{
  private final p o;
  private final float p;
  private final char[] q = new char[1];

  public o(m paramm)
  {
    this.o = paramm.a();
    this.p = paramm.i().e();
    this.f = paramm.e();
    this.g = paramm.g();
    this.h = paramm.h();
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    paramc.g();
    paramc.a(paramFloat1, paramFloat2);
    a locala = ah.f(this.o.b);
    if (this.p != 1.0F)
      paramc.b(this.p, this.p);
    if (paramc.d() != locala)
      paramc.a(locala);
    this.q[0] = this.o.a;
    paramc.a(this.q, 0, 1, 0, 0);
    paramc.h();
  }

  public int h()
  {
    return this.o.b;
  }

  public String toString()
  {
    return super.toString() + "=" + this.o.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.o
 * JD-Core Version:    0.6.0
 */