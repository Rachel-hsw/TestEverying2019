package com.himamis.retex.renderer.a;

public class en
{
  private static final d a = dm.b("minus");
  private static final d b = dm.b("leftarrow");
  private static final d c = dm.b("rightarrow");

  public static i a(dp paramdp, float paramFloat)
  {
    float f1 = 0.0F;
    paramdp.m();
    paramdp.j();
    i locali1 = b.a(paramdp);
    i locali2 = c.a(paramdp);
    float f2 = locali1.c() + locali2.c();
    if (paramFloat < f2)
    {
      at localat1 = new at(locali1);
      localat1.a(new dk(-Math.min(f2 - paramFloat, locali1.c()), 0.0F, 0.0F, 0.0F));
      localat1.a(locali2);
      return localat1;
    }
    i locali3 = new ct(a, "").a(paramdp);
    i locali4 = new cu(5, -3.4F, 0.0F, 0.0F).a(paramdp);
    float f3 = locali3.c() + locali4.c();
    float f4 = f2 + 2.0F * locali4.c();
    at localat2 = new at();
    while (true)
    {
      if (f1 >= paramFloat - f4 - f3)
      {
        localat2.a(new co(locali3, (paramFloat - f4 - f1) / locali3.c(), 1.0D));
        localat2.a(0, locali4);
        localat2.a(0, locali1);
        localat2.a(locali4);
        localat2.a(locali2);
        return localat2;
      }
      localat2.a(locali3);
      localat2.a(locali4);
      f1 += f3;
    }
  }

  public static i a(boolean paramBoolean, dp paramdp, float paramFloat)
  {
    paramdp.m();
    paramdp.j();
    if (paramBoolean);
    float f1;
    float f2;
    float f3;
    for (i locali1 = b.a(paramdp); ; locali1 = c.a(paramdp))
    {
      f1 = locali1.e();
      f2 = locali1.f();
      f3 = locali1.c();
      if (paramFloat > f3)
        break;
      locali1.b(f2 / 2.0F);
      return locali1;
    }
    i locali2 = new ct(a, "").a(paramdp);
    i locali3 = new cu(5, -4.0F, 0.0F, 0.0F).a(paramdp);
    float f4 = locali2.c() + locali3.c();
    float f5 = f3 + locali3.c();
    at localat = new at();
    float f6 = 0.0F;
    float f7;
    if (f6 >= paramFloat - f5 - f4)
    {
      f7 = (paramFloat - f5 - f6) / locali2.c();
      localat.a(new cu(5, -2.0F * f7, 0.0F, 0.0F).a(paramdp));
      localat.a(new cn(a, f7, 1.0D).a(paramdp));
      if (!paramBoolean)
        break label298;
      localat.a(0, new cu(5, -3.5F, 0.0F, 0.0F).a(paramdp));
      localat.a(0, locali1);
    }
    while (true)
    {
      localat.b(f2 / 2.0F);
      localat.c(f1);
      return localat;
      localat.a(locali2);
      localat.a(locali3);
      f6 += f4;
      break;
      label298: localat.a(new cu(5, -2.0F * f7 - 2.0F, 0.0F, 0.0F).a(paramdp));
      localat.a(locali1);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.en
 * JD-Core Version:    0.6.0
 */