package com.himamis.retex.renderer.a;

public class ei extends d
{
  public i a(dp paramdp)
  {
    i locali1 = dm.b("ldotp").a(paramdp);
    ej localej = new ej(locali1, 0.0F, 4);
    i locali2 = new cu(5, 0.0F, 4.0F, 0.0F).a(paramdp);
    localej.a(locali2);
    localej.a(locali1);
    localej.a(locali2);
    localej.a(locali1);
    float f1 = localej.f();
    float f2 = localej.e();
    localej.b(0.0F);
    localej.c(f1 + f2);
    return localej;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ei
 * JD-Core Version:    0.6.0
 */