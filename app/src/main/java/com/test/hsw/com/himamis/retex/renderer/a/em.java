package com.himamis.retex.renderer.a;

public class em extends d
{
  private d a;
  private d b;
  private boolean f;

  public em(d paramd1, d paramd2, boolean paramBoolean)
  {
    this.a = paramd1;
    this.b = paramd2;
    this.f = paramBoolean;
  }

  public i a(dp paramdp)
  {
    paramdp.m();
    paramdp.j();
    Object localObject1;
    if (this.a != null)
    {
      localObject1 = this.a.a(paramdp.r());
      if (this.b == null)
        break label319;
    }
    label319: for (Object localObject2 = this.b.a(paramdp.q()); ; localObject2 = new dk(0.0F, 0.0F, 0.0F, 0.0F))
    {
      i locali1 = new cu(0, 1.5F, 0.0F, 0.0F).a(paramdp.r());
      i locali2 = new cu(0, 1.5F, 0.0F, 0.0F).a(paramdp.q());
      i locali3 = new cu(5, 0.0F, 2.0F, 0.0F).a(paramdp);
      float f1 = Math.max(((i)localObject1).c() + 2.0F * locali1.c(), ((i)localObject2).c() + 2.0F * locali2.c());
      i locali4 = en.a(this.f, paramdp, f1);
      at localat1 = new at((i)localObject1, f1, 2);
      at localat2 = new at((i)localObject2, f1, 2);
      ej localej = new ej();
      localej.a(localat1);
      localej.a(locali3);
      localej.a(locali4);
      localej.a(locali3);
      localej.a(localat2);
      float f2 = localej.e() + localej.f();
      float f3 = locali3.e() + locali3.f() + localat2.e() + localat2.f();
      localej.b(f3);
      localej.c(f2 - f3);
      return new at(localej, localej.c() + 2.0F * locali3.e(), 2);
      localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.em
 * JD-Core Version:    0.6.0
 */