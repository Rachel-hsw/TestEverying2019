package com.himamis.retex.renderer.a;

public class cd extends d
{
  private d a;
  private int b;
  private int f;
  private int g;
  private float h;
  private float i;
  private float j;

  public cd(d paramd, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    this.a = paramd;
    this.b = paramInt1;
    this.h = paramFloat1;
    this.f = paramInt2;
    this.i = paramFloat2;
    this.g = paramInt3;
    this.j = paramFloat3;
  }

  public int a()
  {
    return this.a.a();
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    if (this.b == -1)
      locali.d(0.0F);
    while (this.f == -1)
    {
      return locali;
      locali.d(-this.h * cu.a(this.b, paramdp));
    }
    at localat = new at(locali);
    localat.c(this.i * cu.a(this.f, paramdp));
    if (this.g == -1)
      localat.b(0.0F);
    while (true)
    {
      return localat;
      localat.b(this.j * cu.a(this.g, paramdp));
    }
  }

  public int b()
  {
    return this.a.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cd
 * JD-Core Version:    0.6.0
 */