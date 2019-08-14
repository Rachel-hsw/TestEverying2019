package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.j.a;
import com.handmark.pulltorefresh.library.j.c;
import com.handmark.pulltorefresh.library.j.d;

@SuppressLint({"ViewConstructor"})
public class c extends FrameLayout
  implements Animation.AnimationListener
{
  static final int a = 150;
  private Animation b;
  private Animation c;
  private ImageView d;
  private final Animation e;
  private final Animation f;

  public c(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext);
    this.d = new ImageView(paramContext);
    Drawable localDrawable = getResources().getDrawable(j.d.indicator_arrow);
    this.d.setImageDrawable(localDrawable);
    int i = getResources().getDimensionPixelSize(j.c.indicator_internal_padding);
    this.d.setPadding(i, i, i, i);
    addView(this.d);
    int j;
    int k;
    switch (f()[paramb.ordinal()])
    {
    default:
      j = j.a.slide_in_from_top;
      k = j.a.slide_out_to_top;
      setBackgroundResource(j.d.indicator_bg_top);
    case 3:
    }
    while (true)
    {
      this.b = AnimationUtils.loadAnimation(paramContext, j);
      this.b.setAnimationListener(this);
      this.c = AnimationUtils.loadAnimation(paramContext, k);
      this.c.setAnimationListener(this);
      LinearInterpolator localLinearInterpolator = new LinearInterpolator();
      this.e = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.e.setInterpolator(localLinearInterpolator);
      this.e.setDuration(150L);
      this.e.setFillAfter(true);
      this.f = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.f.setInterpolator(localLinearInterpolator);
      this.f.setDuration(150L);
      this.f.setFillAfter(true);
      return;
      j = j.a.slide_in_from_bottom;
      k = j.a.slide_out_to_bottom;
      setBackgroundResource(j.d.indicator_bg_bottom);
      this.d.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
      this.d.setImageMatrix(localMatrix);
    }
  }

  public final boolean a()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
      if (this.b != localAnimation);
    do
    {
      return true;
      return false;
    }
    while (getVisibility() == 0);
    return false;
  }

  public void b()
  {
    startAnimation(this.c);
  }

  public void c()
  {
    this.d.clearAnimation();
    startAnimation(this.b);
  }

  public void d()
  {
    this.d.startAnimation(this.e);
  }

  public void e()
  {
    this.d.startAnimation(this.f);
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.c)
    {
      this.d.clearAnimation();
      setVisibility(8);
    }
    while (true)
    {
      clearAnimation();
      return;
      if (paramAnimation != this.b)
        continue;
      setVisibility(0);
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.a.c
 * JD-Core Version:    0.6.0
 */