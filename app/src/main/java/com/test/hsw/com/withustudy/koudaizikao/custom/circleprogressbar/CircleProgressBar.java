package com.withustudy.koudaizikao.custom.circleprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.withustudy.koudaizikao.R.styleable;

public class CircleProgressBar extends View
{
  private static final String a = "instance_state";
  private static final String b = "state_current_progress";
  private static final String c = "state_angle_step";
  private static final String d = "state_need_show_text";
  private static final String e = "state_need_anim";
  private static final float f = 100.0F;
  private static Handler g = new Handler(Looper.getMainLooper());
  private int A = 0;
  private int[] B;
  private a C;
  private b D;
  private float E = 0.0F;
  private Context h;
  private int i = Color.parseColor("#ffeeeaff");
  private int j = Color.parseColor("#7df5f5f5");
  private int k = Color.parseColor("#0dfb7d");
  private int l;
  private int m = 10;
  private int n = -90;
  private int o = 360;
  private boolean p = true;
  private boolean q = true;
  private RectF r;
  private RectF s;
  private RectF t;
  private Paint u;
  private Paint v;
  private Paint w;
  private Paint x;
  private int y = 0;
  private int z;

  public CircleProgressBar(Context paramContext)
  {
    super(paramContext);
    this.h = paramContext;
    c();
  }

  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext;
    a(paramAttributeSet);
    c();
  }

  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.s.centerX(), this.s.centerY(), this.s.height() / 2.0F, this.u);
  }

  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 1;
    TypedArray localTypedArray = this.h.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressBar);
    this.i = localTypedArray.getColor(0, this.i);
    this.k = localTypedArray.getColor(i1, this.k);
    this.j = localTypedArray.getColor(2, this.j);
    this.l = localTypedArray.getColor(3, this.l);
    this.m = localTypedArray.getInt(4, this.m);
    this.n = localTypedArray.getInt(5, this.n);
    this.o = localTypedArray.getInt(8, this.o);
    this.q = localTypedArray.getBoolean(7, this.q);
    this.p = localTypedArray.getBoolean(6, this.p);
    if ((this.o % 360 == 0) && (this.p))
    {
      this.p = i1;
      if (this.l != 0)
        break label186;
    }
    label186: for (int i2 = this.k; ; i2 = this.l)
    {
      this.l = i2;
      localTypedArray.recycle();
      return;
      i1 = 0;
      break;
    }
  }

  private void b(Canvas paramCanvas)
  {
    if (!this.q)
      return;
    String str = String.valueOf(this.A);
    int i1 = (int)((this.z - 2 * this.m) / 2.5D);
    this.x.setTextSize(130.0F);
    Paint.FontMetrics localFontMetrics = this.x.getFontMetrics();
    float f1 = (float)Math.ceil(localFontMetrics.descent - localFontMetrics.top);
    float f2 = this.x.measureText(str);
    float f3 = (this.z - f2) / 2.0F;
    float f4 = (this.z - f1) / 2.0F + i1;
    paramCanvas.drawText(str + "%", f3 - 10.0F, f4 - 100.0F, this.x);
    this.x.setTextSize(50.0F);
    if (this.E == 0.0F)
      this.E = f3;
    paramCanvas.drawText("正确率", this.E - 18.0F, f4 - 30.0F, this.x);
  }

  private void c()
  {
    d();
    e();
    f();
    g();
    h();
    i();
  }

  private void c(Canvas paramCanvas)
  {
    int i1 = this.y + this.n;
    int i2 = (int)(this.A / 100.0F * this.o);
    paramCanvas.drawArc(this.s, i1, i2, false, this.w);
  }

  private void d()
  {
    this.u = new Paint();
    this.u.setAntiAlias(true);
    this.u.setColor(this.i);
  }

  private void d(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.t, this.n, this.o, false, this.v);
  }

  private void e()
  {
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setStyle(Paint.Style.STROKE);
    this.v.setStrokeWidth(this.m);
    this.v.setColor(this.j);
  }

  private void f()
  {
    this.w = new Paint();
    this.w.setAntiAlias(true);
    this.w.setDither(true);
    this.w.setStyle(Paint.Style.STROKE);
    this.w.setStrokeCap(Paint.Cap.ROUND);
    this.w.setStrokeWidth(this.m);
    this.w.setColor(this.k);
  }

  private void g()
  {
    this.x = new Paint();
    this.x.setAntiAlias(true);
    this.x.setColor(this.l);
  }

  private void h()
  {
    this.t = new RectF();
    this.s = new RectF();
    this.r = new RectF();
  }

  private void i()
  {
    if (this.p)
      this.C = new a(null);
  }

  private void j()
  {
    int[] arrayOfInt = this.B;
    LinearGradient localLinearGradient = null;
    if (arrayOfInt != null)
    {
      int i1 = this.B.length;
      localLinearGradient = null;
      if (i1 != 0)
      {
        float f1 = this.z - this.m / 2;
        localLinearGradient = new LinearGradient(0.0F, 0.0F, f1, f1, this.B, null, Shader.TileMode.CLAMP);
      }
    }
    if (localLinearGradient != null)
      setShader(localLinearGradient);
  }

  private void k()
  {
    if (this.C != null)
      g.removeCallbacks(this.C);
    if (this.p)
      g.post(this.C);
  }

  private void setShader(Shader paramShader)
  {
    this.w.setShader(paramShader);
    if ((this.l != this.k) || (!this.q))
      return;
    this.x.setShader(paramShader);
  }

  public void a()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.C != null)
      g.removeCallbacks(this.C);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    d(paramCanvas);
    c(paramCanvas);
    b(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.z = Math.min(getWidth(), getHeight());
      int i1 = this.m / 2;
      int i2 = this.m / 2;
      int i3 = this.z - this.m / 2;
      int i4 = this.z - this.m / 2;
      this.t.set(i1, i2, i3, i4);
      this.s.set(i1, i2, i3, i4);
      this.r.set(this.m / 2, this.m / 2, this.z - this.m / 2, this.z - this.m / 2);
      j();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    k();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.A = localBundle.getInt("state_current_progress");
      this.y = localBundle.getInt("state_angle_step");
      this.p = localBundle.getBoolean("state_need_anim");
      this.q = localBundle.getBoolean("state_need_show_text");
      super.onRestoreInstanceState(localBundle.getParcelable("instance_state"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instance_state", super.onSaveInstanceState());
    localBundle.putInt("state_current_progress", this.A);
    localBundle.putInt("state_angle_step", this.y);
    localBundle.putBoolean("state_need_show_text", this.q);
    localBundle.putBoolean("state_need_anim", this.p);
    return localBundle;
  }

  public void setColorScheme(int[] paramArrayOfInt)
  {
    this.B = paramArrayOfInt;
  }

  public void setLoadingCallBack(b paramb)
  {
    this.D = paramb;
  }

  public void setProgress(int paramInt)
  {
    if (paramInt > 100.0F)
      paramInt = 100;
    this.A = paramInt;
    if (!this.p)
      a();
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    private void a()
    {
      CircleProgressBar localCircleProgressBar = CircleProgressBar.this;
      CircleProgressBar.b(localCircleProgressBar, 2 + CircleProgressBar.c(localCircleProgressBar));
      CircleProgressBar.this.invalidate();
    }

    public void run()
    {
      if (CircleProgressBar.a(CircleProgressBar.this) >= 100.0F)
      {
        CircleProgressBar.a(CircleProgressBar.this, 100);
        a();
        CircleProgressBar.b().removeCallbacks(this);
        if (CircleProgressBar.b(CircleProgressBar.this) != null)
          CircleProgressBar.b(CircleProgressBar.this).a(CircleProgressBar.this);
        return;
      }
      a();
      CircleProgressBar.b().postDelayed(this, 12L);
    }
  }

  public static abstract interface b
  {
    public abstract void a(View paramView);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.circleprogressbar.CircleProgressBar
 * JD-Core Version:    0.6.0
 */