package com.handmark.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.h;
import com.handmark.pulltorefresh.library.j.d;
import com.handmark.pulltorefresh.library.j.h;

public class e extends d
{
  static final int a = 1200;
  private final Animation h;
  private final Matrix i;
  private float j;
  private float k;
  private final boolean l;

  public e(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
  {
    super(paramContext, paramb, paramh, paramTypedArray);
    this.l = paramTypedArray.getBoolean(j.h.PullToRefresh_ptrRotateDrawableWhilePulling, true);
    this.d.setScaleType(ImageView.ScaleType.MATRIX);
    this.i = new Matrix();
    this.d.setImageMatrix(this.i);
    this.h = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.h.setInterpolator(c);
    this.h.setDuration(1200L);
    this.h.setRepeatCount(-1);
    this.h.setRepeatMode(1);
  }

  private void e()
  {
    if (this.i != null)
    {
      this.i.reset();
      this.d.setImageMatrix(this.i);
    }
  }

  protected void a()
  {
  }

  protected void a(float paramFloat)
  {
    float f;
    if (this.l)
      f = 90.0F * paramFloat;
    while (true)
    {
      this.i.setRotate(f, this.j, this.k);
      this.d.setImageMatrix(this.i);
      return;
      f = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F));
    }
  }

  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.j = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.k = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }

  protected void b()
  {
    this.d.startAnimation(this.h);
  }

  protected void c()
  {
  }

  protected void d()
  {
    this.d.clearAnimation();
    e();
  }

  protected int getDefaultDrawableResId()
  {
    return j.d.default_ptr_rotate;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.a.e
 * JD-Core Version:    0.6.0
 */