package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;

public class cf extends i
{
  private i o;

  public cf(i parami)
  {
    this.o = parami;
    this.f = parami.f;
    this.g = parami.g;
    this.h = parami.h;
    this.i = parami.i;
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    paramc.a(paramFloat1, paramFloat2);
    paramc.b(-1.0D, 1.0D);
    this.o.a(paramc, -this.f, 0.0F);
    paramc.b(-1.0D, 1.0D);
    paramc.a(-paramFloat1, -paramFloat2);
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cf
 * JD-Core Version:    0.6.0
 */