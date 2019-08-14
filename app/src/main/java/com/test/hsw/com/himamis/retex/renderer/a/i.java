package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.c.k;
import com.himamis.retex.renderer.a.g.d;
import java.util.LinkedList;

public abstract class i
{
  public static boolean a = false;
  protected final com.himamis.retex.renderer.a.g.c b;
  protected final d c;
  protected b d;
  protected b e;
  protected float f = 0.0F;
  protected float g = 0.0F;
  protected float h = 0.0F;
  protected float i = 0.0F;
  protected int j = -1;
  protected LinkedList<i> k = new LinkedList();
  protected i l;
  protected i m;
  protected b n;
  private b o;

  protected i()
  {
    this(null, null);
  }

  protected i(b paramb1, b paramb2)
  {
    this.d = paramb1;
    this.e = paramb2;
    this.b = new com.himamis.retex.renderer.a.g.c();
    this.c = new d();
  }

  public i a()
  {
    return this.l;
  }

  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void a(int paramInt, i parami)
  {
    this.k.add(paramInt, parami);
    parami.l = this;
    parami.m = this.m;
  }

  protected void a(com.himamis.retex.renderer.a.g.c.c paramc)
  {
    paramc.a(this.o);
  }

  public abstract void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2);

  protected void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    j localj;
    b localb1;
    if (a)
    {
      localj = paramc.a();
      if (this.n != null)
      {
        b localb2 = paramc.b();
        paramc.a(this.n);
        paramc.a(this.b.a(paramFloat1, paramFloat2 - this.g, this.f, this.g + this.h));
        paramc.a(localb2);
      }
      paramc.a(this.c.a((float)Math.abs(1.0D / paramc.c().d()), 0, 0));
      if (this.f < 0.0F)
      {
        paramFloat1 += this.f;
        this.f = (-this.f);
      }
      paramc.b(this.b.a(paramFloat1, paramFloat2 - this.g, this.f, this.g + this.h));
      if (paramBoolean)
      {
        localb1 = paramc.b();
        paramc.a(s.a);
        if (this.h <= 0.0F)
          break label280;
        paramc.a(this.b.a(paramFloat1, paramFloat2, this.f, this.h));
        paramc.a(localb1);
        paramc.b(this.b.a(paramFloat1, paramFloat2, this.f, this.h));
      }
    }
    while (true)
    {
      paramc.a(localj);
      return;
      label280: if (this.h < 0.0F)
      {
        paramc.a(this.b.a(paramFloat1, paramFloat2 + this.h, this.f, -this.h));
        paramc.a(localb1);
        paramc.b(this.b.a(paramFloat1, paramFloat2 + this.h, this.f, -this.h));
        continue;
      }
      paramc.a(localb1);
    }
  }

  public void a(i parami)
  {
    this.k.add(parami);
    parami.l = this;
    parami.m = this.m;
  }

  public i b()
  {
    return this.m;
  }

  public void b(float paramFloat)
  {
    this.h = paramFloat;
  }

  protected void b(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    this.o = paramc.b();
    if (this.e != null)
      paramc.a(this.e);
    if (this.d == null)
      paramc.a(this.o);
    while (true)
    {
      c(paramc, paramFloat1, paramFloat2);
      return;
      paramc.a(this.d);
    }
  }

  public void b(i parami)
  {
    this.l = parami;
  }

  public float c()
  {
    return this.f;
  }

  public void c(float paramFloat)
  {
    this.g = paramFloat;
  }

  protected void c(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    if (a)
      a(paramc, paramFloat1, paramFloat2, true);
  }

  public void c(i parami)
  {
    this.m = parami;
  }

  public void d()
  {
    this.f = (-this.f);
  }

  public void d(float paramFloat)
  {
    this.i = paramFloat;
  }

  public float e()
  {
    return this.g;
  }

  public float f()
  {
    return this.h;
  }

  public float g()
  {
    return this.i;
  }

  public abstract int h();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.i
 * JD-Core Version:    0.6.0
 */