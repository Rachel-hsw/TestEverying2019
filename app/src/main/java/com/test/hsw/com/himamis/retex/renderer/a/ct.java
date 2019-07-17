package com.himamis.retex.renderer.a;

public class ct extends d
{
  private d a;
  private boolean b = true;
  private boolean f = true;

  public ct(d paramd, String paramString)
  {
    this.a = paramd;
    if ("t".equals(paramString))
      this.f = false;
    do
      return;
    while (!"b".equals(paramString));
    this.b = false;
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    if (this.b)
      locali.c(0.0F);
    if (this.f)
      locali.b(0.0F);
    return locali;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ct
 * JD-Core Version:    0.6.0
 */