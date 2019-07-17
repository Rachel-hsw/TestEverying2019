package com.himamis.retex.renderer.a;

public class f extends d
{
  protected d a = null;
  private d b = null;
  private d f = null;
  private boolean g = false;
  private boolean h = false;

  public f(d paramd1, d paramd2, d paramd3)
  {
    this.a = paramd1;
    this.b = paramd2;
    this.f = paramd3;
    this.c = 1;
  }

  public f(d paramd1, d paramd2, d paramd3, boolean paramBoolean)
  {
    this(paramd1, paramd2, paramd3);
    this.h = paramBoolean;
    this.g = true;
  }

  private static i a(i parami, float paramFloat)
  {
    if ((parami != null) && (Math.abs(paramFloat - parami.c()) > 1.0E-007F))
      parami = new at(parami, paramFloat, 2);
    return parami;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    d locald1 = this.a;
    d locald4;
    cl localcl;
    if ((this.a instanceof ea))
    {
      locald4 = ((ea)this.a).d();
      if (((locald4 instanceof cl)) && (((cl)locald4).b) && (this.a.d != 2))
      {
        this.a = ((cl)locald4).d();
        localcl = (cl)locald4;
      }
    }
    while (((this.g) && (!this.h)) || ((!this.g) && (i >= 2)) || (this.a.d == 1) || ((this.a.d == 0) && (i >= 2)))
    {
      if (localcl != null)
      {
        localcl.a(new cp(this.a, this.b, this.f));
        i locali1 = localcl.a(paramdp);
        localcl.d();
        localcl.a(this.a);
        this.a = locald1;
        return locali1;
        this.a = locald4;
        localcl = null;
        continue;
      }
      return new cp(this.a, this.b, this.f).a(paramdp);
    }
    Object localObject2;
    float f1;
    i locali2;
    if (((this.a instanceof dm)) && (this.a.c == 1))
    {
      m localm = localdq.a(((dm)this.a).i(), i);
      localObject2 = this.a.a(paramdp);
      f1 = localm.f();
      d locald2 = this.f;
      locali2 = null;
      if (locald2 != null)
        locali2 = this.f.a(paramdp.r());
      if (this.b == null)
        break label791;
    }
    label778: label788: label791: for (i locali3 = this.b.a(paramdp.q()); ; locali3 = null)
    {
      float f2;
      label348: float f3;
      float f4;
      if (locali2 == null)
      {
        f2 = 0.0F;
        f3 = Math.max(f2, ((i)localObject2).c());
        if (locali3 != null)
          break label778;
        f4 = 0.0F;
      }
      ej localej;
      while (true)
      {
        float f5 = Math.max(f3, f4);
        i locali4 = a(locali2, f5);
        i locali5 = a((i)localObject2, f5);
        i locali6 = a(locali3, f5);
        localej = new ej();
        float f6 = localdq.g(i);
        d locald3 = this.f;
        float f7 = 0.0F;
        if (locald3 != null)
        {
          localej.a(new dk(0.0F, f6, 0.0F, 0.0F));
          locali4.d(f1 / 2.0F);
          localej.a(locali4);
          f7 = Math.max(localdq.c(i), localdq.e(i) - locali4.f());
          localej.a(new dk(0.0F, f7, 0.0F, 0.0F));
          (localej.e() + localej.f());
        }
        localej.a(locali5);
        if (this.b != null)
        {
          localej.a(new dk(0.0F, Math.max(localdq.d(i), localdq.f(i) - locali6.e()), 0.0F, 0.0F));
          locali6.d(-f1 / 2.0F);
          localej.a(locali6);
          localej.a(new dk(0.0F, f6, 0.0F, 0.0F));
        }
        float f8 = locali5.e();
        float f9 = localej.e() + localej.f();
        if (locali4 != null)
          f8 += f7 + f6 + locali4.e() + locali4.f();
        localej.c(f8);
        localej.b(f9 - f8);
        if (localcl == null)
          break label788;
        at localat = new at(localcl.a(paramdp));
        localcl.a(this.a);
        localat.a(localej);
        this.a = locald1;
        return localat;
        if (this.a == null);
        for (Object localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F); ; localObject1 = this.a.a(paramdp))
        {
          localObject2 = new at((i)localObject1);
          f1 = 0.0F;
          break;
        }
        f2 = locali2.c();
        break label348;
        f4 = locali3.c();
      }
      return localej;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.f
 * JD-Core Version:    0.6.0
 */