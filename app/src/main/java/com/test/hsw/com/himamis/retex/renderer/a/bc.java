package com.himamis.retex.renderer.a;

public class bc extends d
{
  private d a;
  private char b;

  public bc(d paramd, char paramChar)
  {
    this.a = paramd;
    this.b = paramChar;
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    ej localej = new ej();
    localej.a(locali);
    localej.a(0.0F);
    switch (this.b)
    {
    default:
      locali.d(-locali.c() / 2.0F);
      return localej;
    case 'l':
      locali.d(-locali.c());
      return localej;
    case 'r':
    }
    locali.d(0.0F);
    return localej;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bc
 * JD-Core Version:    0.6.0
 */