package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.b.d;
import com.himamis.retex.renderer.a.g.c.b;

public class au extends i
{
  private b o = null;
  private float p = 0.0F;
  private d q;

  public au(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.g = paramFloat1;
    this.f = paramFloat2;
    this.i = paramFloat3;
    this.q = this.b.a(0.0D, 0.0D, 0.0D, 0.0D);
  }

  public au(float paramFloat1, float paramFloat2, float paramFloat3, b paramb)
  {
    this.g = paramFloat1;
    this.f = paramFloat2;
    this.o = paramb;
    this.i = paramFloat3;
    this.q = this.b.a(0.0D, 0.0D, 0.0D, 0.0D);
  }

  public au(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.g = paramFloat1;
    this.f = paramFloat2;
    if (paramBoolean)
      this.i = paramFloat3;
    while (true)
    {
      this.q = this.b.a(0.0D, 0.0D, 0.0D, 0.0D);
      return;
      this.i = 0.0F;
      this.p = paramFloat3;
    }
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    b localb = paramc.b();
    if (this.o != null)
      paramc.a(this.o);
    if (this.p == 0.0F)
      this.q.a(paramFloat1, paramFloat2 - this.g, this.f, this.g);
    while (true)
    {
      paramc.a(this.q);
      paramc.a(localb);
      return;
      this.q.a(paramFloat1, paramFloat2 - this.g + this.p, this.f, this.g);
    }
  }

  public int h()
  {
    return -1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.au
 * JD-Core Version:    0.6.0
 */