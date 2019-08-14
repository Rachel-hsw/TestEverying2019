package com.himamis.retex.renderer.android.c;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;

public class a
  implements com.himamis.retex.renderer.a.g.c.a
{
  private float g;
  private float h;
  private int i;
  private int j;

  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.i = paramInt1;
    this.j = paramInt2;
  }

  public a(float paramFloat1, float paramFloat2, Paint.Cap paramCap, Paint.Join paramJoin)
  {
    this(paramFloat1, paramFloat2, a(paramCap), a(paramJoin));
  }

  private static int a(Paint.Cap paramCap)
  {
    switch (h()[paramCap.ordinal()])
    {
    case 1:
    default:
      return 0;
    case 2:
      return 1;
    case 3:
    }
    return 2;
  }

  private static int a(Paint.Join paramJoin)
  {
    switch (i()[paramJoin.ordinal()])
    {
    case 1:
    default:
      return 2;
    case 2:
      return 0;
    case 3:
    }
    return 1;
  }

  public float a()
  {
    return this.g;
  }

  public float b()
  {
    return this.h;
  }

  public int c()
  {
    return this.i;
  }

  public int d()
  {
    return this.j;
  }

  public Object e()
  {
    return null;
  }

  public Paint.Cap f()
  {
    switch (this.i)
    {
    default:
      return Paint.Cap.BUTT;
    case 0:
      return Paint.Cap.BUTT;
    case 1:
      return Paint.Cap.ROUND;
    case 2:
    }
    return Paint.Cap.SQUARE;
  }

  public Paint.Join g()
  {
    switch (this.j)
    {
    default:
      return Paint.Join.BEVEL;
    case 2:
      return Paint.Join.BEVEL;
    case 0:
      return Paint.Join.MITER;
    case 1:
    }
    return Paint.Join.ROUND;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.a
 * JD-Core Version:    0.6.0
 */