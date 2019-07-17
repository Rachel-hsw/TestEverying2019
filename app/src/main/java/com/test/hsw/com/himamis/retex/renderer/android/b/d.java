package com.himamis.retex.renderer.android.b;

import android.graphics.Rect;
import android.graphics.RectF;

public class d
  implements com.himamis.retex.renderer.a.g.b.d
{
  private RectF a = new RectF();

  public d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  public d(Rect paramRect)
  {
    this.a.set(paramRect);
  }

  public RectF a()
  {
    return this.a;
  }

  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    float f1 = (float)paramDouble1;
    float f2 = (float)paramDouble2;
    float f3 = f1 + (float)paramDouble3;
    float f4 = f2 + (float)paramDouble4;
    this.a.set(f1, f2, f3, f4);
  }

  public double b()
  {
    return this.a.left;
  }

  public double c()
  {
    return this.a.top;
  }

  public double d()
  {
    return this.a.width();
  }

  public double e()
  {
    return this.a.height();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.b.d
 * JD-Core Version:    0.6.0
 */