package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;

public class co extends i
{
  private i o;
  private double p;
  private double q;
  private float r = 1.0F;

  public co(i parami, double paramDouble1, double paramDouble2)
  {
    this.o = parami;
    if ((Double.isNaN(paramDouble1)) || (Double.isInfinite(paramDouble1)))
      paramDouble1 = 0.0D;
    this.p = paramDouble1;
    if ((Double.isNaN(paramDouble2)) || (Double.isInfinite(paramDouble2)))
      paramDouble2 = 0.0D;
    this.q = paramDouble2;
    this.f = (parami.f * (float)Math.abs(this.p));
    float f1;
    float f2;
    if (this.q > 0.0D)
    {
      f1 = parami.g * (float)this.q;
      this.g = f1;
      if (this.q <= 0.0D)
        break label162;
      f2 = parami.h * (float)this.q;
    }
    while (true)
    {
      this.h = f2;
      this.i = (parami.i * (float)this.q);
      return;
      f1 = -parami.h * (float)this.q;
      break;
      label162: f2 = -parami.g * (float)this.q;
    }
  }

  public co(i parami, float paramFloat)
  {
    this(parami, paramFloat, paramFloat);
    this.r = paramFloat;
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    float f;
    if ((this.p != 0.0D) && (this.q != 0.0D))
    {
      if (this.p >= 0.0D)
        break label111;
      f = this.f;
    }
    while (true)
    {
      paramc.a(paramFloat1 + f, paramFloat2);
      paramc.b(this.p, this.q);
      this.o.a(paramc, 0.0F, 0.0F);
      paramc.b(1.0D / this.p, 1.0D / this.q);
      paramc.a(-paramFloat1 - f, -paramFloat2);
      return;
      label111: f = 0.0F;
    }
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.co
 * JD-Core Version:    0.6.0
 */