package com.himamis.retex.renderer.a;

public class dj extends d
{
  private d a;

  public dj(d paramd)
  {
    this.a = paramd;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    float f1 = localdq.b(i);
    float f2 = localdq.h(i);
    i locali = this.a.a(paramdp);
    au localau = new au(f2, locali.c(), f2 + -f1, false);
    at localat = new at();
    localat.a(locali);
    localat.a(new dk(-locali.c(), 0.0F, 0.0F, 0.0F));
    localat.a(localau);
    return localat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dj
 * JD-Core Version:    0.6.0
 */