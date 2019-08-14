package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class b extends Drawable
  implements Animatable
{
  static final int a = 0;
  static final int b = 1;
  private static final Interpolator c = new LinearInterpolator();
  private static final Interpolator d = new a(null);
  private static final Interpolator e = new d(null);
  private static final Interpolator f = new AccelerateDecelerateInterpolator();
  private static final int g = 40;
  private static final float h = 8.75F;
  private static final float i = 2.5F;
  private static final int j = 56;
  private static final float k = 12.5F;
  private static final float l = 3.0F;
  private static final int n = 1333;
  private static final float o = 5.0F;
  private static final int s = 10;
  private static final int t = 5;
  private static final float u = 5.0F;
  private static final int v = 12;
  private static final int w = 6;
  private static final float x = 0.8F;
  private Animation A;
  private float B;
  private double C;
  private double D;
  private Animation E;
  private final Drawable.Callback F = new c(this);
  private final int[] m = { -3591113, -13149199, -536002, -13327536 };
  private final ArrayList<Animation> p = new ArrayList();
  private final c q;
  private float r;
  private Resources y;
  private View z;

  public b(Context paramContext, View paramView)
  {
    this.z = paramView;
    this.y = paramContext.getResources();
    this.q = new c(this.F);
    this.q.a(this.m);
    a(1);
    d();
  }

  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    c localc = this.q;
    float f1 = this.y.getDisplayMetrics().density;
    this.C = (paramDouble1 * f1);
    this.D = (paramDouble2 * f1);
    localc.a(f1 * (float)paramDouble4);
    localc.a(paramDouble3 * f1);
    localc.b(0);
    localc.a(paramFloat1 * f1, f1 * paramFloat2);
    localc.a((int)this.C, (int)this.D);
  }

  private float c()
  {
    return this.r;
  }

  private void d()
  {
    c localc = this.q;
    d locald = new d(this, localc);
    locald.setInterpolator(f);
    locald.setDuration(666L);
    locald.setAnimationListener(new e(this, localc));
    f localf = new f(this, localc);
    localf.setRepeatCount(-1);
    localf.setRepeatMode(1);
    localf.setInterpolator(c);
    localf.setDuration(1333L);
    localf.setAnimationListener(new g(this, localc));
    this.E = locald;
    this.A = localf;
  }

  public void a(float paramFloat)
  {
    this.q.e(paramFloat);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.q.b(paramFloat1);
    this.q.c(paramFloat2);
  }

  public void a(@b int paramInt)
  {
    if (paramInt == 0)
    {
      a(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    }
    a(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }

  public void a(boolean paramBoolean)
  {
    this.q.a(paramBoolean);
  }

  public void a(int[] paramArrayOfInt)
  {
    this.q.a(paramArrayOfInt);
    this.q.b(0);
  }

  public void b(float paramFloat)
  {
    this.q.d(paramFloat);
  }

  public void b(int paramInt)
  {
    this.q.a(paramInt);
  }

  void c(float paramFloat)
  {
    this.r = paramFloat;
    invalidateSelf();
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.r, localRect.exactCenterX(), localRect.exactCenterY());
    this.q.a(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }

  public int getAlpha()
  {
    return this.q.b();
  }

  public int getIntrinsicHeight()
  {
    return (int)this.D;
  }

  public int getIntrinsicWidth()
  {
    return (int)this.C;
  }

  public int getOpacity()
  {
    return -3;
  }

  public boolean isRunning()
  {
    ArrayList localArrayList = this.p;
    int i1 = localArrayList.size();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return false;
      Animation localAnimation = (Animation)localArrayList.get(i2);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded()))
        return true;
    }
  }

  public void setAlpha(int paramInt)
  {
    this.q.c(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.q.a(paramColorFilter);
  }

  public void start()
  {
    this.A.reset();
    this.q.l();
    if (this.q.g() != this.q.d())
    {
      this.z.startAnimation(this.E);
      return;
    }
    this.q.b(0);
    this.q.m();
    this.z.startAnimation(this.A);
  }

  public void stop()
  {
    this.z.clearAnimation();
    c(0.0F);
    this.q.a(false);
    this.q.b(0);
    this.q.m();
  }

  private static class a extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.max(0.0F, 2.0F * (paramFloat - 0.5F)));
    }
  }

  @Retention(RetentionPolicy.CLASS)
  public static @interface b
  {
  }

  private static class c
  {
    private final RectF a = new RectF();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Drawable.Callback d;
    private float e = 0.0F;
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 5.0F;
    private float i = 2.5F;
    private int[] j;
    private int k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private Path p;
    private float q;
    private double r;
    private int s;
    private int t;
    private int u;
    private final Paint v = new Paint();
    private int w;

    public c(Drawable.Callback paramCallback)
    {
      this.d = paramCallback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }

    private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Rect paramRect)
    {
      if (this.o)
      {
        if (this.p != null)
          break label214;
        this.p = new Path();
        this.p.setFillType(Path.FillType.EVEN_ODD);
      }
      while (true)
      {
        float f1 = (int)this.i / 2 * this.q;
        float f2 = (float)(this.r * Math.cos(0.0D) + paramRect.exactCenterX());
        float f3 = (float)(this.r * Math.sin(0.0D) + paramRect.exactCenterY());
        this.p.moveTo(0.0F, 0.0F);
        this.p.lineTo(this.s * this.q, 0.0F);
        this.p.lineTo(this.s * this.q / 2.0F, this.t * this.q);
        this.p.offset(f2 - f1, f3);
        this.p.close();
        this.c.setColor(this.j[this.k]);
        paramCanvas.rotate(paramFloat1 + paramFloat2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
        paramCanvas.drawPath(this.p, this.c);
        return;
        label214: this.p.reset();
      }
    }

    private void n()
    {
      this.d.invalidateDrawable(null);
    }

    public void a()
    {
      this.k = ((1 + this.k) % this.j.length);
    }

    public void a(double paramDouble)
    {
      this.r = paramDouble;
    }

    public void a(float paramFloat)
    {
      this.h = paramFloat;
      this.b.setStrokeWidth(paramFloat);
      n();
    }

    public void a(float paramFloat1, float paramFloat2)
    {
      this.s = (int)paramFloat1;
      this.t = (int)paramFloat2;
    }

    public void a(int paramInt)
    {
      this.w = paramInt;
    }

    public void a(int paramInt1, int paramInt2)
    {
      float f1 = Math.min(paramInt1, paramInt2);
      float f2;
      if ((this.r <= 0.0D) || (f1 < 0.0F))
        f2 = (float)Math.ceil(this.h / 2.0F);
      while (true)
      {
        this.i = f2;
        return;
        f2 = (float)(f1 / 2.0F - this.r);
      }
    }

    public void a(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = this.a;
      localRectF.set(paramRect);
      localRectF.inset(this.i, this.i);
      float f1 = 360.0F * (this.e + this.g);
      float f2 = 360.0F * (this.f + this.g) - f1;
      this.b.setColor(this.j[this.k]);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      a(paramCanvas, f1, f2, paramRect);
      if (this.u < 255)
      {
        this.v.setColor(this.w);
        this.v.setAlpha(255 - this.u);
        paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.v);
      }
    }

    public void a(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
      n();
    }

    public void a(boolean paramBoolean)
    {
      if (this.o != paramBoolean)
      {
        this.o = paramBoolean;
        n();
      }
    }

    public void a(@NonNull int[] paramArrayOfInt)
    {
      this.j = paramArrayOfInt;
      b(0);
    }

    public int b()
    {
      return this.u;
    }

    public void b(float paramFloat)
    {
      this.e = paramFloat;
      n();
    }

    public void b(int paramInt)
    {
      this.k = paramInt;
    }

    public float c()
    {
      return this.h;
    }

    public void c(float paramFloat)
    {
      this.f = paramFloat;
      n();
    }

    public void c(int paramInt)
    {
      this.u = paramInt;
    }

    public float d()
    {
      return this.e;
    }

    public void d(float paramFloat)
    {
      this.g = paramFloat;
      n();
    }

    public float e()
    {
      return this.l;
    }

    public void e(float paramFloat)
    {
      if (paramFloat != this.q)
      {
        this.q = paramFloat;
        n();
      }
    }

    public float f()
    {
      return this.m;
    }

    public float g()
    {
      return this.f;
    }

    public float h()
    {
      return this.g;
    }

    public float i()
    {
      return this.i;
    }

    public double j()
    {
      return this.r;
    }

    public float k()
    {
      return this.n;
    }

    public void l()
    {
      this.l = this.e;
      this.m = this.f;
      this.n = this.g;
    }

    public void m()
    {
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      b(0.0F);
      c(0.0F);
      d(0.0F);
    }
  }

  private static class d extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.b
 * JD-Core Version:    0.6.0
 */