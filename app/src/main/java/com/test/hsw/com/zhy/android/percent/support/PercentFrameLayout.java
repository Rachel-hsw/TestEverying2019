package com.zhy.android.percent.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PercentFrameLayout extends FrameLayout
{
  private final a a = new a(this);

  public PercentFrameLayout(Context paramContext)
  {
    super(paramContext);
  }

  public PercentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PercentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    if (this.a.b())
      super.onMeasure(paramInt1, paramInt2);
  }

  public static class LayoutParams extends FrameLayout.LayoutParams
    implements a.b
  {
    private a.a a;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.a = a.a(paramContext, paramAttributeSet);
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      this(paramLayoutParams);
      this.a = paramLayoutParams.a;
    }

    public a.a a()
    {
      return this.a;
    }

    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      a.a(this, paramTypedArray, paramInt1, paramInt2);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.zhy.android.percent.support.PercentFrameLayout
 * JD-Core Version:    0.6.0
 */