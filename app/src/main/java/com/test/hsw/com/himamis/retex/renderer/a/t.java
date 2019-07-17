package com.himamis.retex.renderer.a;

public class t extends d
{
  private d a;
  private cl b;
  private cl f;

  public t(d paramd1, d paramd2, d paramd3)
  {
    if ((paramd1 instanceof t))
    {
      t localt = (t)paramd1;
      this.a = localt.a;
      localt.b.a(paramd3);
      localt.f.a(paramd2);
      this.b = localt.b;
      this.f = localt.f;
      return;
    }
    if (paramd1 == null);
    for (this.a = new bx(new n('M', "mathnormal"), false, true, true); ; this.a = paramd1)
    {
      this.b = new cl(paramd3);
      this.f = new cl(paramd2);
      return;
    }
  }

  public i a(dp paramdp)
  {
    return new cp(this.a, this.f, this.b).a(paramdp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.t
 * JD-Core Version:    0.6.0
 */