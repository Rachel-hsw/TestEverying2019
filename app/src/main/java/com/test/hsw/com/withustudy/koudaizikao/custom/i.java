package com.withustudy.koudaizikao.custom;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class i extends Animation
{
  public static final int a = 1;
  public static final int b;
  private View c;
  private int d;
  private int e;
  private LinearLayout.LayoutParams f;

  public i(View paramView, int paramInt)
  {
    this.c = paramView;
    this.d = this.c.getMeasuredHeight();
    this.f = ((LinearLayout.LayoutParams)paramView.getLayoutParams());
    this.e = paramInt;
    if (this.e == 0);
    for (this.f.bottomMargin = (-this.d); ; this.f.bottomMargin = 0)
    {
      paramView.setVisibility(0);
      return;
    }
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      if (this.e == 0);
      for (this.f.bottomMargin = (-this.d + (int)(paramFloat * this.d)); ; this.f.bottomMargin = (-(int)(paramFloat * this.d)))
      {
        Log.d("ExpandCollapseAnimation", "anim height " + this.f.bottomMargin);
        this.c.requestLayout();
        return;
      }
    }
    if (this.e == 0)
    {
      this.f.bottomMargin = 0;
      this.c.requestLayout();
      return;
    }
    this.f.bottomMargin = (-this.d);
    this.c.setVisibility(8);
    this.c.requestLayout();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.i
 * JD-Core Version:    0.6.0
 */