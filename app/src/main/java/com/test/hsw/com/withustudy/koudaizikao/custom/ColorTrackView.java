package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.withustudy.koudaizikao.R.styleable;

public class ColorTrackView extends View
{
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final String r = "key_progress";
  private static final String s = "key_default_state";
  private int a;
  private int b;
  private int c = 0;
  private String h = "口袋自考";
  private Paint i;
  private int j = b(16.0F);
  private int k = getResources().getColor(2131034234);
  private int l = getResources().getColor(2131034233);
  private Rect m = new Rect();
  private int n;
  private int o;
  private float p;
  private boolean q = false;
  private boolean t = false;

  public ColorTrackView(Context paramContext)
  {
    super(paramContext, null);
  }

  public ColorTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }

  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3 = 0;
    switch (i1)
    {
    default:
    case 1073741824:
    case 0:
    case -2147483648:
    }
    while (true)
    {
      if (i1 == -2147483648)
        i3 = Math.min(i3, i2);
      return i3;
      i3 = i2;
      continue;
      i3 = this.m.height() + (getPaddingTop() + getPaddingBottom());
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.i = new Paint(1);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ColorTrackView);
    this.h = localTypedArray.getString(0);
    this.j = localTypedArray.getDimensionPixelSize(1, this.j);
    this.k = localTypedArray.getColor(2, this.k);
    this.l = localTypedArray.getColor(3, this.l);
    this.p = localTypedArray.getFloat(4, 0.0F);
    this.c = localTypedArray.getInt(5, this.c);
    localTypedArray.recycle();
    this.i.setTextSize(this.j);
  }

  private void a(Canvas paramCanvas, int paramInt)
  {
    a(paramCanvas, this.l, this.a, (int)(this.a + this.p * this.n));
  }

  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i.setColor(paramInt1);
    if (this.q)
    {
      this.i.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRect(paramInt2, 0.0F, paramInt3, getMeasuredHeight(), this.i);
    }
    paramCanvas.save(2);
    paramCanvas.clipRect(paramInt2, 0, paramInt3, getMeasuredHeight());
    paramCanvas.drawText(this.h, this.a, getMeasuredHeight() / 2 - (this.i.descent() + this.i.ascent()) / 2.0F, this.i);
    paramCanvas.restore();
  }

  private int b(float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, getResources().getDisplayMetrics());
  }

  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3 = 0;
    switch (i1)
    {
    default:
    case 1073741824:
    case 0:
    case -2147483648:
    }
    while (true)
    {
      if (i1 == -2147483648)
        i3 = Math.min(i3, i2);
      return i3;
      i3 = i2;
      continue;
      i3 = this.n + (getPaddingLeft() + getPaddingRight());
    }
  }

  private void b()
  {
    this.n = (int)this.i.measureText(this.h);
    Paint.FontMetrics localFontMetrics = this.i.getFontMetrics();
    this.o = (int)Math.ceil(localFontMetrics.descent - localFontMetrics.top);
    this.i.getTextBounds(this.h, 0, this.h.length(), this.m);
    this.o = this.m.height();
  }

  private void b(Canvas paramCanvas, int paramInt)
  {
    a(paramCanvas, this.k, (int)(this.a + this.p * this.n), this.a + this.n);
  }

  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i.setColor(paramInt1);
    if (this.q)
    {
      this.i.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRect(0.0F, paramInt2, getMeasuredWidth(), paramInt3, this.i);
    }
    paramCanvas.save(2);
    paramCanvas.clipRect(0, paramInt2, getMeasuredWidth(), paramInt3);
    paramCanvas.drawText(this.h, this.a, getMeasuredHeight() / 2 - (this.i.descent() + this.i.ascent()) / 2.0F, this.i);
    paramCanvas.restore();
  }

  private void c(Canvas paramCanvas, int paramInt)
  {
    a(paramCanvas, this.l, (int)(this.a + (1.0F - this.p) * this.n), this.a + this.n);
  }

  private void d(Canvas paramCanvas, int paramInt)
  {
    a(paramCanvas, this.k, this.a, (int)(this.a + (1.0F - this.p) * this.n));
  }

  private void e(Canvas paramCanvas, int paramInt)
  {
    b(paramCanvas, this.l, this.b, (int)(this.b + this.p * this.o));
  }

  private void f(Canvas paramCanvas, int paramInt)
  {
    b(paramCanvas, this.k, (int)(this.b + this.p * this.o), this.b + this.o);
  }

  private void g(Canvas paramCanvas, int paramInt)
  {
    b(paramCanvas, this.l, (int)(this.b + (1.0F - this.p) * this.o), this.b + this.o);
  }

  private void h(Canvas paramCanvas, int paramInt)
  {
    b(paramCanvas, this.k, this.b, (int)(this.b + (1.0F - this.p) * this.o));
  }

  public void a()
  {
    int i1 = this.k;
    this.k = this.l;
    this.l = i1;
  }

  public float getProgress()
  {
    return this.p;
  }

  public int getTextChangeColor()
  {
    return this.l;
  }

  public int getTextOriginColor()
  {
    return this.k;
  }

  public float getTextSize()
  {
    return this.j;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = (int)(this.p * this.n + this.a);
    int i2 = (int)(this.p * this.o + this.b);
    if (this.c == 0)
    {
      a(paramCanvas, i1);
      b(paramCanvas, i1);
      return;
    }
    if (this.c == 1)
    {
      d(paramCanvas, i1);
      c(paramCanvas, i1);
      return;
    }
    if (this.c == 2)
    {
      f(paramCanvas, i2);
      e(paramCanvas, i2);
      return;
    }
    h(paramCanvas, i2);
    g(paramCanvas, i2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    setMeasuredDimension(b(paramInt1), a(paramInt2));
    this.a = (getMeasuredWidth() / 2 - this.n / 2);
    this.b = (getMeasuredHeight() / 2 - this.o / 2);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.p = localBundle.getFloat("key_progress");
      super.onRestoreInstanceState(localBundle.getParcelable("key_default_state"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("key_progress", this.p);
    localBundle.putParcelable("key_default_state", super.onSaveInstanceState());
    return localBundle;
  }

  public void setDirection(int paramInt)
  {
    this.c = paramInt;
  }

  public void setProgress(float paramFloat)
  {
    this.p = paramFloat;
    invalidate();
  }

  public void setText(String paramString)
  {
    this.h = paramString;
    requestLayout();
    invalidate();
  }

  public void setTextChangeColor(int paramInt)
  {
    this.l = paramInt;
    invalidate();
  }

  public void setTextColor(int paramInt)
  {
    this.t = true;
    invalidate();
  }

  public void setTextOriginColor(int paramInt)
  {
    this.k = paramInt;
    invalidate();
  }

  public void setTextSize(int paramInt)
  {
    this.j = paramInt;
    if (this.i == null)
    {
      this.i = new Paint(1);
      this.i.setTextSize(paramInt);
    }
    this.i.setTextSize(paramInt);
    requestLayout();
    invalidate();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      e = arrayOfa;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.ColorTrackView
 * JD-Core Version:    0.6.0
 */