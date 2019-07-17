package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.b.e;
import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.d;

public class br extends aj
{
  private e r = this.b.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

  public br(aj paramaj)
  {
    super(paramaj.o, paramaj.p, paramaj.q);
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    this.o.a(paramc, paramFloat1 + this.q + this.p, paramFloat2);
    j localj = paramc.a();
    paramc.a(this.c.a(this.p, 0, 0));
    float f1 = this.p / 2.0F;
    float f2 = 0.5F * Math.min(this.f - this.p, this.g + this.h - this.p);
    this.r.a(paramFloat1 + f1, f1 + (paramFloat2 - this.g), this.f - this.p, this.g + this.h - this.p, f2, f2);
    paramc.a(this.r);
    paramc.a(localj);
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.br
 * JD-Core Version:    0.6.0
 */