package com.himamis.retex.renderer.a;

public class e extends d
{
  public dm a;
  private int b;

  public e(dm paramdm, int paramInt)
  {
    this.a = paramdm;
    this.b = paramInt;
  }

  public i a(dp paramdp)
  {
    i locali = x.a(this.a, paramdp, this.b);
    at localat = new at();
    float f1 = locali.e();
    float f2 = f1 + locali.f();
    float f3 = paramdp.m().b(paramdp.j());
    locali.d(f1 + -f2 / 2.0F - f3);
    localat.a(locali);
    return localat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.e
 * JD-Core Version:    0.6.0
 */