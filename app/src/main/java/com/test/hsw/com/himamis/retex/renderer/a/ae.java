package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.b.b;
import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.c.k;
import com.himamis.retex.renderer.a.g.d;

public class ae extends i
{
  private int o;
  private boolean p;
  private float q;
  private float r;
  private b s;

  public ae(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.o = paramInt;
    this.f = (paramInt * (paramFloat2 + paramFloat3) + 2.0F * paramFloat3);
    this.g = paramFloat1;
    this.h = 0.0F;
    this.p = paramBoolean;
    this.q = paramFloat3;
    this.r = paramFloat2;
    this.s = this.b.a();
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    k localk = paramc.c();
    paramc.g();
    j localj = paramc.a();
    double d1 = localk.d();
    double d2 = localk.e();
    double d3;
    if (d1 == d2)
    {
      paramc.b(1.0D / d1, 1.0D / d2);
      d3 = d1;
    }
    while (true)
    {
      paramc.a(this.c.a((float)(d3 * this.r), 0, 0));
      float f1 = this.r / 2.0F;
      float f2 = (float)(d3 * (paramFloat1 + this.q) + d3 * (this.q / 2.0F));
      int i = (int)Math.round(d3 * (this.q + this.r));
      int j = 0;
      float f3 = f2;
      while (true)
      {
        if (j >= this.o)
        {
          if (this.p)
          {
            this.s.a(d3 * (paramFloat1 + this.q), d3 * (paramFloat2 - this.g / 2.0F), f3 - d3 * this.q / 2.0D, d3 * (paramFloat2 - this.g / 2.0F));
            paramc.a(this.s);
          }
          paramc.h();
          paramc.a(localj);
          return;
        }
        this.s.a(f3 + d3 * f1, d3 * (paramFloat2 - this.g), f3 + d3 * f1, d3 * paramFloat2);
        paramc.a(this.s);
        float f4 = f3 + i;
        j++;
        f3 = f4;
      }
      d3 = 1.0D;
    }
  }

  public int h()
  {
    return -1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ae
 * JD-Core Version:    0.6.0
 */