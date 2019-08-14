package com.example.test;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class a
{
  private final List<View> a = new ArrayList();
  private final LayoutConfiguration b;
  private final int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  private int i = 0;

  public a(int paramInt, LayoutConfiguration paramLayoutConfiguration)
  {
    this.c = paramInt;
    this.b = paramLayoutConfiguration;
  }

  public int a()
  {
    return this.h;
  }

  public void a(int paramInt)
  {
    int j = this.g - this.e;
    this.g = paramInt;
    this.e = (paramInt - j);
  }

  public void a(int paramInt, View paramView)
  {
    FlowLayout.LayoutParams localLayoutParams = (FlowLayout.LayoutParams)paramView.getLayoutParams();
    this.a.add(paramInt, paramView);
    this.d = (this.f + localLayoutParams.d());
    this.f = (this.d + localLayoutParams.g());
    this.g = Math.max(this.g, localLayoutParams.e() + localLayoutParams.h());
    this.e = Math.max(this.e, localLayoutParams.e());
  }

  public void a(View paramView)
  {
    a(this.a.size(), paramView);
  }

  public int b()
  {
    return this.g;
  }

  public int b(View paramView)
  {
    if (this.b.a() == 0);
    for (int j = paramView.getMeasuredWidth(); ; j = paramView.getMeasuredHeight())
      return this.c - (j + this.f);
  }

  public void b(int paramInt)
  {
    int j = this.f - this.d;
    this.d = paramInt;
    this.f = (j + paramInt);
  }

  public int c()
  {
    return this.d;
  }

  public void c(int paramInt)
  {
    this.h = (paramInt + this.h);
  }

  public int d()
  {
    return this.i;
  }

  public void d(int paramInt)
  {
    this.i = (paramInt + this.i);
  }

  public List<View> e()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.example.test.a
 * JD-Core Version:    0.6.0
 */