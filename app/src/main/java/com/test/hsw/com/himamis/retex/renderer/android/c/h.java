package com.himamis.retex.renderer.android.c;

import android.graphics.Matrix;
import com.himamis.retex.renderer.a.g.c.k;

public class h extends Matrix
  implements k
{
  private float[] a = new float[9];

  public h()
  {
  }

  public h(Matrix paramMatrix)
  {
    this();
    set(paramMatrix);
  }

  public Object a()
  {
    return this;
  }

  public void a(double paramDouble1, double paramDouble2)
  {
    setScale((float)paramDouble1, (float)paramDouble2);
  }

  public double b()
  {
    getValues(this.a);
    return this.a[2];
  }

  public void b(double paramDouble1, double paramDouble2)
  {
    setTranslate((float)paramDouble1, (float)paramDouble2);
  }

  public double c()
  {
    getValues(this.a);
    return this.a[5];
  }

  public void c(double paramDouble1, double paramDouble2)
  {
    setSkew((float)paramDouble1, (float)paramDouble2);
  }

  public double d()
  {
    getValues(this.a);
    return this.a[0];
  }

  public double e()
  {
    getValues(this.a);
    return this.a[4];
  }

  public double f()
  {
    getValues(this.a);
    return this.a[1];
  }

  public double g()
  {
    getValues(this.a);
    return this.a[3];
  }

  public k h()
  {
    return new h(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.h
 * JD-Core Version:    0.6.0
 */