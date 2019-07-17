package com.zhy.android.percent.support;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;

public class PercentLinearLayout extends LinearLayout
{
  private static final String a = "PercentLinearLayout";
  private a b = new a(this);

  public PercentLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int getScreenHeight()
  {
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }

  public LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.a();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.makeMeasureSpec(i, j);
    int m = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getMode(paramInt1));
    Context localContext;
    if ((j == 0) && (getParent() != null) && ((getParent() instanceof ScrollView)))
    {
      localContext = getContext();
      if (!(localContext instanceof Activity))
        break label126;
    }
    label126: for (int n = ((Activity)localContext).findViewById(16908290).getMeasuredHeight(); ; n = getScreenHeight())
    {
      k = View.MeasureSpec.makeMeasureSpec(n, j);
      this.b.a(m, k);
      super.onMeasure(paramInt1, paramInt2);
      if (this.b.b())
        super.onMeasure(paramInt1, paramInt2);
      return;
    }
  }

  public static class LayoutParams extends LinearLayout.LayoutParams
    implements a.b
  {
    private a.a a;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
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
 * Qualified Name:     com.zhy.android.percent.support.PercentLinearLayout
 * JD-Core Version:    0.6.0
 */