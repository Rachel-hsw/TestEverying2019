package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.a;
import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.c;
import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.d;

public class al extends i
{
  private static b o;
  private static b p;
  private final a q;

  public al(float paramFloat1, float paramFloat2)
  {
    this.h = 0.0F;
    this.g = paramFloat2;
    this.f = paramFloat1;
    this.i = 0.0F;
    o = this.c.a(102, 102, 102);
    p = this.c.a(153, 153, 255);
    this.q = this.c.a(3.8F, 0, 0, 4.0F);
  }

  private static void d(c paramc, float paramFloat1, float paramFloat2)
  {
    paramc.a(p);
    paramc.a(paramFloat1, paramFloat2);
    paramc.b(0, 0, 8, 8, 0, 360);
    paramc.a(s.b);
    paramc.a(0, 0, 8, 8, 0, 360);
    paramc.a(-paramFloat1, -paramFloat2);
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    paramc.g();
    b localb = paramc.b();
    j localj = paramc.a();
    paramc.a(paramFloat1 + 0.25F * this.g / 2.15F, paramFloat2 - 0.8139535F * this.g);
    paramc.a(o);
    paramc.a(this.q);
    paramc.b(0.05F * this.g / 2.15F, 0.05F * this.g / 2.15F);
    paramc.a(-0.453785605518526D, 20.5D, 17.5D);
    paramc.a(0, 0, 43, 32, 0, 360);
    paramc.a(0.453785605518526D, 20.5D, 17.5D);
    paramc.a(localj);
    d(paramc, 16.0F, -5.0F);
    d(paramc, -1.0F, 7.0F);
    d(paramc, 5.0F, 28.0F);
    d(paramc, 27.0F, 24.0F);
    d(paramc, 36.0F, 3.0F);
    paramc.a(localj);
    paramc.h();
    paramc.a(localb);
  }

  public int h()
  {
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.al
 * JD-Core Version:    0.6.0
 */