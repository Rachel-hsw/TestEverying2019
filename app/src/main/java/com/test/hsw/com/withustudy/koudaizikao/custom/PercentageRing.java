package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.withustudy.koudaizikao.R.styleable;

public class PercentageRing extends View
{
  private Paint a;
  private Paint b;
  private Paint c;
  private Paint d;
  private int e;
  private int f;
  private float g;
  private RectF h;
  private float i;
  private float j;
  private float k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;

  public PercentageRing(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.l = paramInt;
    this.m = getResources().getColor(2131034112);
    this.n = getResources().getColor(2131034190);
    this.p = getResources().getColor(2131034191);
    a(paramContext);
  }

  public PercentageRing(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PercentageRing);
    this.m = localTypedArray.getColor(1, -5262117);
    this.n = localTypedArray.getColor(2, -9875295);
    this.l = localTypedArray.getInt(0, 60);
    this.p = localTypedArray.getColor(3, -1);
    localTypedArray.recycle();
    a(paramContext);
  }

  public PercentageRing(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824)
      return i2;
    int i3 = (int)(2.0D * (1.075D * this.l));
    if (i1 == -2147483648)
      return Math.min(i3, i2);
    return i3;
  }

  private void a(Context paramContext)
  {
    this.i = -90.0F;
    this.g = 0.0F;
    this.k = 0.0F;
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColor(this.m);
    this.a.setStyle(Paint.Style.FILL);
    this.b = new Paint();
    this.b.setColor(this.p);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setStrokeWidth((float)(0.025D * this.l));
    this.b.setTextSize(this.l / 2);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.c = new Paint();
    this.c.setColor(this.p);
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setStrokeWidth((float)(0.025D * this.l));
    this.c.setTextSize(this.l / 8);
    this.c.setTextAlign(Paint.Align.CENTER);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setColor(this.n);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeWidth((float)(0.075D * this.l));
    this.o = (int)this.b.getTextSize();
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.b.setTextSize(paramInt1);
    this.c.setTextSize(paramInt2);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawCircle(this.e, this.f, this.l, this.a);
    paramCanvas.drawArc(this.h, this.i, this.g, false, this.d);
    paramCanvas.drawText(String.valueOf(this.k) + "%", this.e, this.f + this.o / 10, this.b);
    paramCanvas.drawText("正确率", this.e, this.f + (float)(this.o / 1.35D), this.c);
    if (this.k < this.j)
    {
      this.k = (1.0F + this.k);
      this.g = (float)(3.6D + this.g);
      postInvalidateDelayed(10L);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), a(paramInt1));
    this.e = (getMeasuredWidth() / 2);
    this.f = (getMeasuredHeight() / 2);
    if (this.l > this.e)
    {
      this.l = this.e;
      this.l = (int)(this.e - 0.075D * this.l);
      this.b.setStrokeWidth((float)(0.025D * this.l));
      this.c.setStrokeWidth((float)(0.025D * this.l));
      this.b.setTextSize(this.l / 2);
      this.c.setTextSize(this.l / 8);
      this.d.setStrokeWidth((float)(0.075D * this.l));
      this.o = (int)this.b.getTextSize();
    }
    this.h = new RectF(this.e - this.l, this.f - this.l, this.e + this.l, this.f + this.l);
  }

  public void setRadius(int paramInt)
  {
    this.l = paramInt;
  }

  public void setTargetPercent(int paramInt)
  {
    this.j = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.PercentageRing
 * JD-Core Version:    0.6.0
 */