package com.himamis.retex.renderer.a;

public class dy extends d
{
  private String a;
  private d b;

  public dy(d paramd, String paramString)
  {
    this.a = paramString;
    this.b = paramd;
  }

  public i a(dp paramdp)
  {
    String str = paramdp.k();
    paramdp.a(this.a);
    i locali = this.b.a(paramdp);
    paramdp.a(str);
    return locali;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dy
 * JD-Core Version:    0.6.0
 */