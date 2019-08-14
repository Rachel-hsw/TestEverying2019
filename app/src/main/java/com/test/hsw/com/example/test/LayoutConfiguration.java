package com.example.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.withustudy.koudaizikao.R.styleable;

class LayoutConfiguration
{
  private int a = 0;
  private boolean b = false;
  private float c = 0.0F;
  private int d = 179;
  private int e = 0;

  public LayoutConfiguration(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout);
    try
    {
      a(localTypedArray.getInteger(1, 0));
      a(localTypedArray.getBoolean(3, false));
      a(localTypedArray.getFloat(4, 0.0F));
      b(localTypedArray.getInteger(0, 0));
      c(localTypedArray.getInteger(2, 0));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
    throw localObject;
  }

  public int a()
  {
    return this.a;
  }

  public void a(float paramFloat)
  {
    this.c = Math.max(0.0F, paramFloat);
  }

  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.a = paramInt;
      return;
    }
    this.a = 0;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void b(int paramInt)
  {
    if ((paramInt & 0x7) == 0);
    for (int i = paramInt | 0x3; ; i = paramInt)
    {
      if ((i & 0x70) == 0)
        i |= 48;
      this.d = i;
      return;
    }
  }

  public boolean b()
  {
    return this.b;
  }

  public float c()
  {
    return this.c;
  }

  public void c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.e = paramInt;
      return;
    }
    this.e = 0;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.example.test.LayoutConfiguration
 * JD-Core Version:    0.6.0
 */