package com.himamis.retex.renderer.a;

public class aw extends d
{
  public i a(dp paramdp)
  {
    float f = dr.f("ldots").u.a(paramdp).c();
    i locali1 = dm.b("ldotp").a(paramdp);
    at localat1 = new at(locali1, f, 1);
    at localat2 = new at(locali1, f, 2);
    at localat3 = new at(locali1, f, 0);
    i locali2 = new cu(5, 0.0F, 4.0F, 0.0F).a(paramdp);
    ej localej = new ej();
    localej.a(localat1);
    localej.a(locali2);
    localej.a(localat2);
    localej.a(locali2);
    localej.a(localat3);
    localej.c(localej.e() + localej.f());
    localej.b(0.0F);
    return localej;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.aw
 * JD-Core Version:    0.6.0
 */