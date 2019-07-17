package com.himamis.retex.renderer.a;

public class am
{
  private static am[] e;
  private static final int[][][] f;
  private final float a;
  private final float b;
  private final float c;
  private final String d;

  static
  {
    ao localao = new ao();
    e = localao.a();
    f = localao.b();
  }

  public am(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramString;
  }

  public static i a(int paramInt1, int paramInt2, dp paramdp)
  {
    if (paramInt1 > 7)
      paramInt1 = 0;
    if (paramInt2 > 7)
      paramInt2 = 0;
    int i = f[paramInt1][paramInt2][(paramdp.j() / 2)];
    return e[i].a(paramdp);
  }

  private i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    float f1 = localdq.a(paramdp.j(), localdq.c());
    return new an(f1 * (this.a / 18.0F), f1 * (this.b / 18.0F), f1 * (this.c / 18.0F));
  }

  public String a()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.am
 * JD-Core Version:    0.6.0
 */