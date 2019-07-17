package com.himamis.retex.renderer.android.b;

import android.graphics.PointF;

public class c
  implements com.himamis.retex.renderer.a.g.b.c
{
  private PointF a;

  public c(double paramDouble1, double paramDouble2)
  {
    this.a = new PointF((float)paramDouble1, (float)paramDouble2);
  }

  public double a()
  {
    return this.a.x;
  }

  public void a(double paramDouble)
  {
    this.a.x = (float)paramDouble;
  }

  public double b()
  {
    return this.a.y;
  }

  public void b(double paramDouble)
  {
    this.a.y = (float)paramDouble;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.b.c
 * JD-Core Version:    0.6.0
 */