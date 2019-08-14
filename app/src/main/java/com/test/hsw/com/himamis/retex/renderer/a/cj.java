package com.himamis.retex.renderer.a;

public class cj extends i
{
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  public static final int s = 4;
  public static final int t = 5;
  public static final int u = 6;
  public static final int v = 7;
  public static final int w = 8;
  public static final int x = 9;
  public static final int y = 10;
  public static final int z = 11;
  protected double A = 0.0D;
  private i B;
  private float C;
  private float D;
  private float E;
  private float F;
  private float G;
  private float H;

  public cj(i parami, double paramDouble, float paramFloat1, float paramFloat2)
  {
    this.B = parami;
    this.A = (3.141592653589793D * paramDouble / 180.0D);
    this.g = parami.g;
    this.h = parami.h;
    this.f = parami.f;
    double d1 = Math.sin(this.A);
    double d2 = Math.cos(this.A);
    this.G = (float)(paramFloat1 * (1.0D - d2) + d1 * paramFloat2);
    this.H = (float)(paramFloat2 * (1.0D - d2) - d1 * paramFloat1);
    this.C = ((float)Math.max(d1 * -this.g, Math.max(d1 * this.h, Math.max(d2 * this.f + d1 * this.h, d2 * this.f - d1 * this.g))) + this.G);
    this.D = ((float)Math.min(d1 * -this.g, Math.min(d1 * this.h, Math.min(d2 * this.f + d1 * this.h, d2 * this.f - d1 * this.g))) + this.G);
    this.E = (float)Math.max(d2 * this.g, Math.max(d2 * -this.h, Math.max(d1 * this.f - d2 * this.h, d1 * this.f + d2 * this.g)));
    this.F = (float)Math.min(d2 * this.g, Math.min(d2 * -this.h, Math.min(d1 * this.f - d2 * this.h, d1 * this.f + d2 * this.g)));
    this.f = (this.C - this.D);
    this.g = (this.E + this.H);
    this.h = (-this.F - this.H);
  }

  public cj(i parami, double paramDouble, int paramInt)
  {
    this(parami, paramDouble, a(parami, paramInt));
  }

  public cj(i parami, double paramDouble, com.himamis.retex.renderer.a.g.b.c paramc)
  {
    this(parami, paramDouble, (float)paramc.a(), (float)paramc.b());
  }

  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    do
    {
      do
      {
        return 6;
        if (paramString.length() == 1)
          paramString = paramString + "c";
        if ((paramString.equals("bl")) || (paramString.equals("lb")))
          return 0;
        if ((paramString.equals("bc")) || (paramString.equals("cb")))
          return 1;
        if ((paramString.equals("br")) || (paramString.equals("rb")))
          return 2;
        if ((paramString.equals("cl")) || (paramString.equals("lc")))
          return 9;
        if (paramString.equals("cc"))
          return 10;
        if ((paramString.equals("cr")) || (paramString.equals("cr")))
          return 11;
        if ((paramString.equals("tl")) || (paramString.equals("lt")))
          return 3;
        if ((paramString.equals("tc")) || (paramString.equals("ct")))
          return 4;
        if ((paramString.equals("tr")) || (paramString.equals("rt")))
          return 5;
      }
      while ((paramString.equals("Bl")) || (paramString.equals("lB")));
      if ((paramString.equals("Bc")) || (paramString.equals("cB")))
        return 8;
    }
    while ((!paramString.equals("Br")) && (!paramString.equals("rB")));
    return 7;
  }

  private static com.himamis.retex.renderer.a.g.b.c a(i parami, int paramInt)
  {
    com.himamis.retex.renderer.a.g.b.c localc = new com.himamis.retex.renderer.a.g.c().a(0.0D, -parami.h);
    switch (paramInt)
    {
    default:
      return localc;
    case 0:
      localc.a(0.0D);
      localc.b(-parami.h);
      return localc;
    case 2:
      localc.a(parami.f);
      localc.b(-parami.h);
      return localc;
    case 1:
      localc.a(parami.f / 2.0F);
      localc.b(-parami.h);
      return localc;
    case 3:
      localc.a(0.0D);
      localc.b(parami.g);
      return localc;
    case 5:
      localc.a(parami.f);
      localc.b(parami.g);
      return localc;
    case 4:
      localc.a(parami.f / 2.0F);
      localc.b(parami.g);
      return localc;
    case 6:
      localc.a(0.0D);
      localc.b(0.0D);
      return localc;
    case 7:
      localc.a(parami.f);
      localc.b(0.0D);
      return localc;
    case 8:
      localc.a(parami.f / 2.0F);
      localc.b(0.0D);
      return localc;
    case 9:
      localc.a(0.0D);
      localc.b((parami.g - parami.h) / 2.0F);
      return localc;
    case 11:
      localc.a(parami.f);
      localc.b((parami.g - parami.h) / 2.0F);
      return localc;
    case 10:
    }
    localc.a(parami.f / 2.0F);
    localc.b((parami.g - parami.h) / 2.0F);
    return localc;
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    this.B.a(paramc, paramFloat1, paramFloat2, true);
    float f1 = paramFloat2 - this.H;
    float f2 = paramFloat1 + (this.G - this.D);
    paramc.a(-this.A, f2, f1);
    this.B.a(paramc, f2, f1);
    this.B.a(paramc, f2, f1, true);
    paramc.a(this.A, f2, f1);
  }

  public int h()
  {
    return this.B.h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cj
 * JD-Core Version:    0.6.0
 */