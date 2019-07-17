package com.himamis.retex.renderer.a;

public class cm extends d
{
  private int a;
  private int b;
  private int f;
  private float g;
  private float h;
  private float i;
  private cu j;
  private cu k;
  private cu l;

  public cm(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.i = paramFloat3;
  }

  public i a(dp paramdp)
  {
    return new au(this.h * cu.a(this.b, paramdp), this.g * cu.a(this.a, paramdp), this.i * cu.a(this.f, paramdp));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cm
 * JD-Core Version:    0.6.0
 */