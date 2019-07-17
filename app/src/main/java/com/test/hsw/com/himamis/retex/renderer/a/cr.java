package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.c.k;

public class cr extends aj
{
  private float r;
  private com.himamis.retex.renderer.a.g.b.d s;

  public cr(aj paramaj, float paramFloat)
  {
    super(paramaj.o, paramaj.p, paramaj.q);
    this.r = paramFloat;
    this.h = (paramFloat + this.h);
    this.f = (paramFloat + this.f);
    this.s = this.b.a(0.0D, 0.0D, 0.0D, 0.0D);
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    float f1 = this.p / 2.0F;
    this.o.a(paramc, paramFloat1 + this.q + this.p, paramFloat2);
    j localj = paramc.a();
    paramc.a(this.c.a(this.p, 0, 0));
    this.s.a(paramFloat1 + f1, f1 + (paramFloat2 - this.g), this.f - this.r - this.p, this.g + this.h - this.r - this.p);
    paramc.b(this.s);
    float f2 = (float)Math.abs(1.0D / paramc.c().d());
    paramc.a(this.c.a(f2, 0, 0));
    this.s.a(paramFloat1 + this.r - f2, paramFloat2 + this.h - this.r - f2, this.f - this.r, this.r);
    paramc.a(this.s);
    this.s.a(paramFloat1 + this.f - this.r - f2, f1 + (paramFloat2 - this.g) + this.r, this.r, this.h + this.g - 2.0F * this.r - f1);
    paramc.a(this.s);
    paramc.a(localj);
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cr
 * JD-Core Version:    0.6.0
 */