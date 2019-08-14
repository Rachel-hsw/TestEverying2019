package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class a extends ImageView
{
  private static final int a = 503316480;
  private static final int b = 1023410176;
  private static final float c = 0.0F;
  private static final float d = 1.75F;
  private static final float e = 3.5F;
  private static final int f = 4;
  private Animation.AnimationListener g;
  private int h;

  public a(Context paramContext, int paramInt, float paramFloat)
  {
    super(paramContext);
    float f1 = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(2.0F * (paramFloat * f1));
    int j = (int)(1.75F * f1);
    int k = (int)(0.0F * f1);
    this.h = (int)(3.5F * f1);
    ShapeDrawable localShapeDrawable;
    if (a())
    {
      localShapeDrawable = new ShapeDrawable(new OvalShape());
      ViewCompat.setElevation(this, f1 * 4.0F);
    }
    while (true)
    {
      localShapeDrawable.getPaint().setColor(paramInt);
      setBackgroundDrawable(localShapeDrawable);
      return;
      localShapeDrawable = new ShapeDrawable(new a(this.h, i));
      ViewCompat.setLayerType(this, 1, localShapeDrawable.getPaint());
      localShapeDrawable.getPaint().setShadowLayer(this.h, k, j, 503316480);
      int m = this.h;
      setPadding(m, m, m, m);
    }
  }

  private boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }

  public void a(Animation.AnimationListener paramAnimationListener)
  {
    this.g = paramAnimationListener;
  }

  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.g != null)
      this.g.onAnimationEnd(getAnimation());
  }

  public void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.g != null)
      this.g.onAnimationStart(getAnimation());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a())
      setMeasuredDimension(getMeasuredWidth() + 2 * this.h, getMeasuredHeight() + 2 * this.h);
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable))
    {
      Resources localResources = getResources();
      ((ShapeDrawable)getBackground()).getPaint().setColor(localResources.getColor(paramInt));
    }
  }

  private class a extends OvalShape
  {
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;

    public a(int paramInt1, int arg3)
    {
      this.c = paramInt1;
      int i;
      this.e = i;
      float f1 = this.e / 2;
      float f2 = this.e / 2;
      float f3 = this.c;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = 1023410176;
      this.b = new RadialGradient(f1, f2, f3, arrayOfInt, null, Shader.TileMode.CLAMP);
      this.d.setShader(this.b);
    }

    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = a.this.getWidth();
      int j = a.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2 + this.c, this.d);
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2, paramPaint);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.a
 * JD-Core Version:    0.6.0
 */