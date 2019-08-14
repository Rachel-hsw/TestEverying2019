package com.himamis.retex.renderer.a;

public class bj extends cn
{
  private float b;

  public bj(d paramd, float paramFloat)
  {
    super(paramd, paramFloat, paramFloat);
    this.b = paramFloat;
  }

  public i a(dp paramdp)
  {
    dp localdp = paramdp.d();
    float f = localdp.c();
    localdp.a(this.b);
    return new co(this.a.a(localdp), this.b / f);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bj
 * JD-Core Version:    0.6.0
 */