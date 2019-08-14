package com.himamis.retex.renderer.a;

public class dn extends d
{
  private boolean a;

  public dn(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public i a(dp paramdp)
  {
    m localm = paramdp.m().a("bar", paramdp.j());
    float f = localm.f();
    dq localdq = paramdp.m();
    char c;
    o localo1;
    o localo2;
    Object localObject;
    if (this.a)
    {
      c = 'T';
      localo1 = new o(localdq.a(c, "mathnormal", paramdp.j()));
      localo2 = new o(localm);
      if (Math.abs(f) <= 1.0E-007F)
        break label183;
      localObject = new at(new dk(-f, 0.0F, 0.0F, 0.0F));
      ((i)localObject).a(localo2);
    }
    while (true)
    {
      at localat = new at((i)localObject, localo1.c(), 2);
      ej localej = new ej();
      localej.a(localo1);
      localej.a(new dk(0.0F, -0.5F * localo1.e(), 0.0F, 0.0F));
      localej.a(localat);
      return localej;
      c = 't';
      break;
      label183: localObject = localo2;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dn
 * JD-Core Version:    0.6.0
 */