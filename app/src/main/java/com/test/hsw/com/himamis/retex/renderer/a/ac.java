package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;

public class ac extends d
{
  public float a = 0.65F;
  protected final d b;
  protected b f = null;
  protected b g = null;

  public ac(d paramd)
  {
    if (paramd == null)
    {
      this.b = new cl();
      return;
    }
    this.b = paramd;
    this.c = paramd.c;
  }

  public ac(d paramd, b paramb1, b paramb2)
  {
    this(paramd);
    this.f = paramb1;
    this.g = paramb2;
  }

  public i a(dp paramdp)
  {
    i locali = this.b.a(paramdp);
    float f1 = paramdp.m().h(paramdp.j());
    float f2 = this.a * cu.a(0, paramdp);
    if (this.f == null)
      return new aj(locali, f1, f2);
    paramdp.a = true;
    return new aj(locali, f1, f2, this.g, this.f);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ac
 * JD-Core Version:    0.6.0
 */