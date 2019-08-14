package com.himamis.retex.renderer.android.b;

import android.graphics.RectF;

public class e
  implements com.himamis.retex.renderer.a.g.b.e
{
  private RectF a = new RectF();
  private double b;
  private double c;

  public e(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    this.b = paramDouble5;
    this.c = paramDouble6;
  }

  public double a()
  {
    return this.b;
  }

  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    float f1 = (float)paramDouble1;
    float f2 = (float)paramDouble2;
    float f3 = f1 + (float)paramDouble3;
    float f4 = f2 + (float)paramDouble4;
    this.a.set(f1, f2, f3, f4);
  }

  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    this.b = paramDouble5;
    this.c = paramDouble6;
  }

  public double b()
  {
    return this.c;
  }

  public double c()
  {
    return this.a.left;
  }

  public double d()
  {
    return this.a.top;
  }

  public double e()
  {
    return this.a.right - this.a.left;
  }

  public double f()
  {
    return this.a.bottom - this.a.top;
  }

  public RectF g()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.b.e
 * JD-Core Version:    0.6.0
 */