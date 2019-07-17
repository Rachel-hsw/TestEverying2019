package com.himamis.retex.renderer.a;

public class bo extends d
{
  private static final String a = "sqrt";
  private static final float b = 0.55F;
  private final d f;
  private final d g;

  public bo(d paramd1, d paramd2)
  {
    if (paramd1 == null)
      paramd1 = new aa();
    this.f = paramd1;
    if (paramd2 == null)
      paramd2 = new aa();
    this.g = paramd2;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    float f1 = localdq.h(i);
    float f2;
    if (i < 2)
      f2 = localdq.b(i, localdq.a("sqrt", i).d());
    at localat2;
    while (true)
    {
      float f3 = f1 + Math.abs(f2) / 4.0F;
      at localat1 = new at(this.f.a(paramdp.e()));
      localat1.a(new cu(5, 1.0F, 0.0F, 0.0F).a(paramdp.e()));
      float f4 = localat1.e() + localat1.f();
      i locali1 = x.a("sqrt", paramdp, f1 + (f4 + f3));
      float f5 = f3 + (locali1.f() - (f4 + f3)) / 2.0F;
      locali1.d(-(f5 + localat1.e()));
      bs localbs = new bs(localat1, f5, locali1.e());
      localbs.d(-(f1 + (f5 + localat1.e())));
      localat2 = new at(locali1);
      localat2.a(localbs);
      if (this.g != null)
        break;
      return localat2;
      f2 = f1;
    }
    i locali2 = this.g.a(paramdp.p());
    float f6 = 0.55F * (localat2.e() + localat2.f());
    locali2.d(localat2.f() - locali2.f() - f6);
    i locali3 = new cu(5, -10.0F, 0.0F, 0.0F).a(paramdp);
    at localat3 = new at();
    float f7 = locali2.c() + locali3.c();
    if (f7 < 0.0F)
      localat3.a(new dk(-f7, 0.0F, 0.0F, 0.0F));
    localat3.a(locali2);
    localat3.a(locali3);
    localat3.a(localat2);
    return localat3;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bo
 * JD-Core Version:    0.6.0
 */