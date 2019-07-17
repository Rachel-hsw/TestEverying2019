package com.himamis.retex.renderer.a;

public class ar extends bk
{
  private static final d l = dm.b("ldotp");
  private static final d m = new cu(1);
  private float n;

  public ar(int paramInt, float paramFloat)
  {
    super(paramInt, "c", l);
    this.n = paramFloat;
  }

  public i a(dp paramdp)
  {
    dk localdk = new dk(this.n * m.a(paramdp).c(), 0.0F, 0.0F, 0.0F);
    at localat1 = new at(localdk);
    localat1.a(l.a(paramdp));
    localat1.a(localdk);
    at localat2;
    if (this.f != 0.0F)
    {
      localat1.c();
      localat2 = new at(localat1);
    }
    while (true)
    {
      if (localat2.c() >= this.f)
      {
        localat1 = new at(localat2, this.f, 2);
        localat1.j = 12;
        return localat1;
      }
      localat2.a(localat1);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ar
 * JD-Core Version:    0.6.0
 */