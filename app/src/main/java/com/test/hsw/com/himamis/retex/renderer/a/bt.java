package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;

public class bt extends i
{
  private final i o;
  private final i p;
  private final i q;
  private final float r;
  private final boolean s;

  public bt(i parami1, i parami2, i parami3, float paramFloat, boolean paramBoolean)
  {
    this.o = parami1;
    this.p = parami2;
    this.q = parami3;
    this.r = paramFloat;
    this.s = paramBoolean;
    this.f = parami1.c();
    float f1 = parami1.g;
    float f2;
    float f4;
    label86: float f5;
    float f6;
    if (paramBoolean)
    {
      f2 = parami2.c();
      float f3 = f1 + f2;
      if ((!paramBoolean) || (parami3 == null))
        break label161;
      f4 = paramFloat + (parami3.g + parami3.h);
      this.g = (f4 + f3);
      f5 = parami1.h;
      if (!paramBoolean)
        break label167;
      f6 = 0.0F;
    }
    while (true)
    {
      float f7 = f6 + f5;
      float f8 = 0.0F;
      if (!paramBoolean)
      {
        f8 = 0.0F;
        if (parami3 != null)
          f8 = paramFloat + (parami3.g + parami3.h);
      }
      this.h = (f7 + f8);
      return;
      f2 = 0.0F;
      break;
      label161: f4 = 0.0F;
      break label86;
      label167: f6 = parami2.c();
    }
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    this.o.a(paramc, paramFloat1, paramFloat2);
    float f1 = paramFloat2 - this.o.g - this.p.c();
    this.p.b(this.p.e() + this.p.f());
    this.p.c(0.0F);
    if (this.s)
    {
      double d3 = paramFloat1 + 0.75D * (this.p.g + this.p.h);
      double d4 = f1;
      paramc.g();
      paramc.a(d3, d4);
      paramc.a(1.570796326794897D);
      this.p.a(paramc, 0.0F, 0.0F);
      paramc.h();
      if (this.q != null)
        this.q.a(paramc, paramFloat1, f1 - this.r - this.q.h);
    }
    float f2 = paramFloat2 + this.o.h;
    if (!this.s)
    {
      double d1 = paramFloat1 + 0.75D * (this.p.e() + this.p.h);
      double d2 = f2;
      paramc.g();
      paramc.a(d1, d2);
      paramc.a(1.570796326794897D);
      this.p.a(paramc, 0.0F, 0.0F);
      paramc.h();
      float f3 = f2 + this.p.c();
      if (this.q != null)
        this.q.a(paramc, paramFloat1, f3 + this.r + this.q.g);
    }
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bt
 * JD-Core Version:    0.6.0
 */