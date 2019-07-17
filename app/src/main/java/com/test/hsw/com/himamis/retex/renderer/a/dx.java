package com.himamis.retex.renderer.a;

public class dx extends d
{
  private d a;

  public dx(d paramd)
  {
    this.a = paramd;
  }

  public i a(dp paramdp)
  {
    i locali = dm.b("bigcirc").a(paramdp);
    locali.d(-0.07F * cu.a(1, paramdp));
    at localat = new at(this.a.a(paramdp), locali.c(), 2);
    localat.a(new dk(-localat.c(), 0.0F, 0.0F, 0.0F));
    localat.a(locali);
    return localat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dx
 * JD-Core Version:    0.6.0
 */