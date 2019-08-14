package com.himamis.retex.renderer.android.b;

import android.graphics.PointF;

public class b
  implements com.himamis.retex.renderer.a.g.b.b
{
  private PointF a = new PointF();
  private PointF b = new PointF();

  public b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  public PointF a()
  {
    return this.a;
  }

  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a.set((float)paramDouble1, (float)paramDouble2);
    this.b.set((float)paramDouble3, (float)paramDouble4);
  }

  public PointF b()
  {
    return this.b;
  }

  public double c()
  {
    return this.a.x;
  }

  public double d()
  {
    return this.a.y;
  }

  public double e()
  {
    return this.b.x;
  }

  public double f()
  {
    return this.b.y;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.b.b
 * JD-Core Version:    0.6.0
 */