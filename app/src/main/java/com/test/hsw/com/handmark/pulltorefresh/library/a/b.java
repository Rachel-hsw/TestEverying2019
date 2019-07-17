package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.h;
import com.handmark.pulltorefresh.library.j.d;

@SuppressLint({"ViewConstructor"})
public class b extends d
{
  static final int a = 150;
  private final Animation h;
  private final Animation i;

  public b(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
  {
    super(paramContext, paramb, paramh, paramTypedArray);
    if (paramb == PullToRefreshBase.b.b);
    int m;
    for (int k = -180; ; m = 180)
    {
      this.h = new RotateAnimation(0.0F, k, 1, 0.5F, 1, 0.5F);
      this.h.setInterpolator(c);
      this.h.setDuration(150L);
      this.h.setFillAfter(true);
      this.i = new RotateAnimation(k, 0.0F, 1, 0.5F, 1, 0.5F);
      this.i.setInterpolator(c);
      this.i.setDuration(150L);
      this.i.setFillAfter(true);
      return;
    }
  }

  private float getDrawableRotationAngle()
  {
    switch (e()[this.f.ordinal()])
    {
    default:
    case 3:
    case 2:
    }
    do
    {
      return 0.0F;
      if (this.g == PullToRefreshBase.h.b)
        return 90.0F;
      return 180.0F;
    }
    while (this.g != PullToRefreshBase.h.b);
    return 270.0F;
  }

  protected void a()
  {
    if (this.h == this.d.getAnimation())
      this.d.startAnimation(this.i);
  }

  protected void a(float paramFloat)
  {
  }

  protected void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int k = paramDrawable.getIntrinsicHeight();
      int m = paramDrawable.getIntrinsicWidth();
      ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
      int n = Math.max(k, m);
      localLayoutParams.height = n;
      localLayoutParams.width = n;
      this.d.requestLayout();
      this.d.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((localLayoutParams.width - m) / 2.0F, (localLayoutParams.height - k) / 2.0F);
      localMatrix.postRotate(getDrawableRotationAngle(), localLayoutParams.width / 2.0F, localLayoutParams.height / 2.0F);
      this.d.setImageMatrix(localMatrix);
    }
  }

  protected void b()
  {
    this.d.clearAnimation();
    this.d.setVisibility(4);
    this.e.setVisibility(0);
  }

  protected void c()
  {
    this.d.startAnimation(this.h);
  }

  protected void d()
  {
    this.d.clearAnimation();
    this.e.setVisibility(8);
    this.d.setVisibility(0);
  }

  protected int getDefaultDrawableResId()
  {
    return j.d.default_ptr_flip;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.a.b
 * JD-Core Version:    0.6.0
 */