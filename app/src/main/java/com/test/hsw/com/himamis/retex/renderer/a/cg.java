package com.himamis.retex.renderer.a;

public class cg extends d
{
  private d a;
  private int b;
  private int f;
  private float g;
  private float h;
  private boolean i;

  public cg(d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.c = paramd.c;
    this.a = paramd;
    this.i = paramBoolean;
    if (paramString1 == null)
      paramString1 = "";
    float[] arrayOfFloat1 = cu.b(paramString1);
    if (paramString2 == null)
      paramString2 = "";
    float[] arrayOfFloat2 = cu.b(paramString2);
    if (arrayOfFloat1.length != 2)
      this.b = -1;
    while (arrayOfFloat2.length != 2)
    {
      this.f = -1;
      return;
      this.b = (int)arrayOfFloat1[0];
      this.g = arrayOfFloat1[1];
    }
    this.f = (int)arrayOfFloat2[0];
    this.h = arrayOfFloat2[1];
  }

  public int a()
  {
    return this.a.a();
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    if ((this.b == -1) && (this.f == -1))
      return locali;
    double d2;
    double d1;
    if ((this.b != -1) && (this.f != -1))
    {
      d2 = this.g * cu.a(this.b, paramdp) / locali.f;
      d1 = this.h * cu.a(this.f, paramdp) / locali.g;
      if (this.i)
      {
        d1 = Math.min(d2, d1);
        d2 = d1;
      }
    }
    while (true)
    {
      return new co(locali, d2, d1);
      if ((this.b != -1) && (this.f == -1))
      {
        d1 = this.g * cu.a(this.b, paramdp) / locali.f;
        d2 = d1;
        continue;
      }
      d1 = this.h * cu.a(this.f, paramdp) / locali.g;
      d2 = d1;
    }
  }

  public int b()
  {
    return this.a.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cg
 * JD-Core Version:    0.6.0
 */