package com.himamis.retex.renderer.a;

public class l extends d
{
  private d a;

  public l(d paramd)
  {
    this.a = paramd;
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    ej localej = new ej();
    localej.a(locali);
    m localm = paramdp.m().a("jlatexmathcedilla", paramdp.j());
    float f1 = localm.f();
    o localo = new o(localm);
    Object localObject;
    if (Math.abs(f1) > 1.0E-007F)
    {
      localObject = new at(new dk(-f1, 0.0F, 0.0F, 0.0F));
      ((i)localObject).a(localo);
    }
    while (true)
    {
      at localat = new at((i)localObject, locali.c(), 2);
      localej.a(new dk(0.0F, -(0.4F * cu.a(5, paramdp)), 0.0F, 0.0F));
      localej.a(localat);
      float f2 = localej.e() + localej.f();
      localej.c(locali.e());
      localej.b(f2 - locali.e());
      return localej;
      localObject = localo;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.l
 * JD-Core Version:    0.6.0
 */