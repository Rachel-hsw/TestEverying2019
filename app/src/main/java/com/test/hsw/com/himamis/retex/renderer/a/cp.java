package com.himamis.retex.renderer.a;

public class cp extends d
{
  private static final cu a = new cu(3, 0.5F, 0.0F, 0.0F);
  private final d b;
  private final d f;
  private final d g;
  private int h = 0;

  public cp(d paramd1, d paramd2, d paramd3)
  {
    this.b = paramd1;
    this.f = paramd2;
    this.g = paramd3;
  }

  public cp(d paramd1, d paramd2, d paramd3, boolean paramBoolean)
  {
    this(paramd1, paramd2, paramd3);
    if (!paramBoolean)
      this.h = 1;
  }

  public int a()
  {
    return this.b.a();
  }

  public i a(dp paramdp)
  {
    if (this.b == null);
    Object localObject2;
    for (Object localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F); ; localObject1 = this.b.a(paramdp))
    {
      localObject2 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      if ((this.f != null) || (this.g != null))
        break;
      return localObject1;
    }
    dq localdq = paramdp.m();
    int i = paramdp.j();
    if ((this.b.d == 2) || ((this.b.d == 0) && (i == 0)))
    {
      ed localed = new ed(new ed(this.b, this.f, 3, 0.3F, true, false), this.g, 3, 3.0F, true, true);
      return localed.a(paramdp);
    }
    at localat1 = new at((i)localObject1);
    int j = ((i)localObject1).h();
    if (j == -1)
      j = localdq.c();
    dp localdp1 = paramdp.q();
    dp localdp2 = paramdp.r();
    float f1 = 0.0F;
    float f2;
    float f3;
    if ((this.b instanceof a))
    {
      i locali4 = ((a)this.b).a.a(paramdp.e());
      f2 = locali4.e() - localdq.u(localdp2.j());
      f3 = locali4.f() + localdq.q(localdp1.j());
    }
    float f12;
    while (true)
      if (this.g == null)
      {
        i locali3 = this.f.a(localdp1);
        locali3.d(Math.max(Math.max(f3, localdq.o(i)), locali3.e() - 4.0F * Math.abs(localdq.b(i, j)) / 5.0F));
        localat1.a(locali3);
        localat1.a((i)localObject2);
        return localat1;
        if (((this.b instanceof dm)) && (this.b.c == 1))
        {
          m localm = localdq.a(((dm)this.b).i(), i);
          if ((i < 2) && (localdq.a(localm)))
            localm = localdq.b(localm, i);
          o localo = new o(localm);
          localo.d(-(localo.e() + localo.f()) / 2.0F - paramdp.m().b(paramdp.j()));
          localat1 = new at(localo);
          f1 = localm.f();
          localObject2 = new cu(2).a(paramdp);
          if ((f1 > 1.0E-007F) && (this.f == null))
            localat1.a(new dk(f1, 0.0F, 0.0F, 0.0F));
          f2 = localat1.e() - localdq.u(localdp2.j());
          f3 = localat1.f() + localdq.q(localdp1.j());
          continue;
        }
        if (!(this.b instanceof q))
          break;
        p localp = ((q)this.b).a(localdq);
        if ((((q)this.b).g()) && (localdq.w(localp.b)))
          break label1201;
        f12 = localdq.a(localp, i).f();
      }
    while (true)
    {
      if ((f12 > 1.0E-007F) && (this.f == null))
      {
        localat1.a(new dk(f12, 0.0F, 0.0F, 0.0F));
        f3 = 0.0F;
        f2 = 0.0F;
        f1 = 0.0F;
        break;
        f2 = ((i)localObject1).e() - localdq.u(localdp2.j());
        f3 = ((i)localObject1).f() + localdq.q(localdp1.j());
        f1 = 0.0F;
        break;
        i locali1 = this.g.a(localdp2);
        float f4 = locali1.c();
        if ((this.f != null) && (this.h == 1))
          f4 = Math.max(f4, this.f.a(localdp1).c());
        at localat2 = new at(locali1, f4, this.h);
        localat2.a(a.a(paramdp));
        float f5;
        if (i == 0)
          f5 = localdq.r(i);
        float f6;
        while (true)
        {
          f6 = Math.max(Math.max(f2, f5), locali1.f() + Math.abs(localdq.b(i, j)) / 4.0F);
          if (this.f != null)
            break;
          localat2.d(-f6);
          localat1.a(localat2);
          localat1.a((i)localObject2);
          return localat1;
          if (paramdp.e().j() == i)
          {
            f5 = localdq.t(i);
            continue;
          }
          f5 = localdq.s(i);
        }
        i locali2 = this.f.a(localdp1);
        at localat3 = new at(locali2, f4, this.h);
        localat3.a(a.a(paramdp));
        float f7 = Math.max(f3, localdq.p(i));
        float f8 = localdq.h(i);
        float f9 = f7 + (f6 - locali1.f()) - locali2.e();
        float f10;
        if (f9 < 4.0F * f8)
        {
          f6 += f8 * 4.0F - f9;
          float f11 = 4.0F * Math.abs(localdq.b(i, j)) / 5.0F - (f6 - locali1.f());
          if (f11 > 0.0F)
          {
            f10 = f6 + f11;
            f7 -= f11;
          }
        }
        while (true)
        {
          ej localej = new ej();
          localat2.d(f1);
          localej.a(localat2);
          localej.a(new dk(0.0F, f7 + (f10 - locali1.f()) - locali2.e(), 0.0F, 0.0F));
          localej.a(localat3);
          localej.c(f10 + locali1.e());
          localej.b(f7 + locali2.f());
          localat1.a(localej);
          break;
          f10 = f6;
        }
      }
      f1 = f12;
      f3 = 0.0F;
      f2 = 0.0F;
      break;
      label1201: f12 = 0.0F;
    }
  }

  public int b()
  {
    return this.b.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cp
 * JD-Core Version:    0.6.0
 */