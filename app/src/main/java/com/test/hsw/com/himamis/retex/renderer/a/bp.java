package com.himamis.retex.renderer.a;

public class bp extends d
{
  private static final dm a = dm.b("ogonek");
  private d b;

  public bp(d paramd)
  {
    this.b = paramd;
  }

  public i a(dp paramdp)
  {
    i locali = this.b.a(paramdp);
    ej localej = new ej();
    localej.a(locali);
    m localm = paramdp.m().a("ogonek", paramdp.j());
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
      at localat = new at((i)localObject, locali.c(), 1);
      localej.a(new dk(0.0F, -localo.e(), 0.0F, 0.0F));
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
 * Qualified Name:     com.himamis.retex.renderer.a.bp
 * JD-Core Version:    0.6.0
 */