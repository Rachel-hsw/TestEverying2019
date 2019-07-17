package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.c;
import com.himamis.retex.renderer.a.g.c.e;
import com.himamis.retex.renderer.a.g.c.f;
import com.himamis.retex.renderer.a.g.c.h;

public class du
  implements f
{
  public static float a;
  public static float b;
  private static final b d = s.b;
  public boolean c = false;
  private i e;
  private final float f;
  private h g = new h(0, 0, 0, 0);
  private b h = null;

  static
  {
    a = -1.0F;
    b = 0.0F;
  }

  protected du(i parami, float paramFloat)
  {
    this(parami, paramFloat, false);
  }

  protected du(i parami, float paramFloat, boolean paramBoolean)
  {
    this.e = parami;
    if (a != -1.0F)
      paramFloat = a;
    if (b != 0.0F);
    for (this.f = (paramFloat * Math.abs(b)); ; this.f = paramFloat)
    {
      if (!paramBoolean)
      {
        h localh1 = this.g;
        localh1.a += (int)(0.18F * paramFloat);
        h localh2 = this.g;
        localh2.c += (int)(0.18F * paramFloat);
        h localh3 = this.g;
        localh3.b += (int)(0.18F * paramFloat);
        h localh4 = this.g;
        localh4.d += (int)(0.18F * paramFloat);
      }
      return;
    }
  }

  public h a()
  {
    return this.g;
  }

  public void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 - d();
    if (f1 > 0.0F)
      this.e = new at(this.e, f1 + this.e.c(), paramInt2);
  }

  public void a(b paramb)
  {
    this.h = paramb;
  }

  public void a(e parame, c paramc, int paramInt1, int paramInt2)
  {
    paramc.g();
    b localb = paramc.b();
    paramc.a(1, 1);
    paramc.a(2, 2);
    paramc.a(3, 3);
    paramc.b(this.f, this.f);
    if (this.h != null)
      paramc.a(this.h);
    while (true)
    {
      this.e.a(paramc, (paramInt1 + this.g.b) / this.f, (paramInt2 + this.g.a) / this.f + this.e.e());
      paramc.h();
      paramc.a(localb);
      return;
      if (parame != null)
      {
        paramc.a(parame.a());
        continue;
      }
      paramc.a(d);
    }
  }

  public void a(h paramh)
  {
    a(paramh, false);
  }

  public void a(h paramh, boolean paramBoolean)
  {
    this.g = paramh;
    if (!paramBoolean)
    {
      h localh1 = this.g;
      localh1.a += (int)(0.18F * this.f);
      h localh2 = this.g;
      localh2.c += (int)(0.18F * this.f);
      h localh3 = this.g;
      localh3.b += (int)(0.18F * this.f);
      h localh4 = this.g;
      localh4.d += (int)(0.18F * this.f);
    }
  }

  public int b()
  {
    return (int)(0.99D + this.e.e() * this.f + this.g.a) + (int)(0.99D + this.e.f() * this.f + this.g.c);
  }

  public void b(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 - b();
    if (f1 > 0.0F)
      this.e = new ej(this.e, f1, paramInt2);
  }

  public int c()
  {
    return (int)(0.99D + this.e.f() * this.f + this.g.c);
  }

  public int d()
  {
    return (int)(0.99D + this.e.c() * this.f + this.g.b + this.g.d);
  }

  public float e()
  {
    return (this.e.e() + this.e.f()) * this.f;
  }

  public float f()
  {
    return this.e.f() * this.f;
  }

  public float g()
  {
    return this.e.c() * this.f;
  }

  public float h()
  {
    return (float)((0.99D + this.e.e() * this.f + this.g.a) / (0.99D + (this.e.e() + this.e.f()) * this.f + this.g.a + this.g.c));
  }

  public i i()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.du
 * JD-Core Version:    0.6.0
 */