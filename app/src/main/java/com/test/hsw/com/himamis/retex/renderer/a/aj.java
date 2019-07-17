package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.j;

public class aj extends i
{
  protected i o;
  protected float p;
  protected float q;
  private b r;
  private b s;
  private com.himamis.retex.renderer.a.g.b.d t;

  public aj(i parami, float paramFloat1, float paramFloat2)
  {
    this.o = parami;
    this.f = (parami.f + 2.0F * paramFloat1 + 2.0F * paramFloat2);
    this.g = (paramFloat2 + (paramFloat1 + parami.g));
    this.h = (paramFloat2 + (paramFloat1 + parami.h));
    this.i = parami.i;
    this.p = paramFloat1;
    this.q = paramFloat2;
    this.t = this.b.a(0.0D, 0.0D, 0.0D, 0.0D);
  }

  public aj(i parami, float paramFloat1, float paramFloat2, b paramb1, b paramb2)
  {
    this(parami, paramFloat1, paramFloat2);
    this.r = paramb1;
    this.s = paramb2;
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    j localj = paramc.a();
    paramc.a(this.c.a(this.p, 0, 0));
    float f = this.p / 2.0F;
    if (this.s != null)
    {
      b localb2 = paramc.b();
      paramc.a(this.s);
      this.t.a(paramFloat1 + f, f + (paramFloat2 - this.g), this.f - this.p, this.g + this.h - this.p);
      paramc.a(this.t);
      paramc.a(localb2);
    }
    if (this.r != null)
    {
      b localb1 = paramc.b();
      paramc.a(this.r);
      this.t.a(paramFloat1 + f, f + (paramFloat2 - this.g), this.f - this.p, this.g + this.h - this.p);
      paramc.b(this.t);
      paramc.a(localb1);
    }
    while (true)
    {
      paramc.a(localj);
      this.o.a(paramc, paramFloat1 + this.q + this.p, paramFloat2);
      return;
      this.t.a(paramFloat1 + f, f + (paramFloat2 - this.g), this.f - this.p, this.g + this.h - this.p);
      paramc.b(this.t);
    }
  }

  public int h()
  {
    return this.o.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.aj
 * JD-Core Version:    0.6.0
 */