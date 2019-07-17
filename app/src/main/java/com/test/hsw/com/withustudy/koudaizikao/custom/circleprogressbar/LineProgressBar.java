package com.withustudy.koudaizikao.custom.circleprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.withustudy.koudaizikao.R.styleable;

public class LineProgressBar extends View
{
  private static final String a = "instance_state";
  private static final String b = "state_current_progress";
  private static final String c = "state_need_show_text";
  private static final String d = "state_need_anim";
  private static final String e = "state_orientation";
  private static final float f = 100.0F;
  private int g = -16777216;
  private Bitmap h;
  private Bitmap i;
  private int j = -65536;
  private int k = -1;
  private boolean l = true;
  private boolean m = false;
  private float n = -1.0F;
  private float o = -1.0F;
  private a p = a.a;
  private Context q;
  private Paint r;
  private Paint s;
  private Paint t;
  private int u = 0;
  private int v;
  private int w;

  public LineProgressBar(Context paramContext)
  {
    super(paramContext);
    this.q = paramContext;
    b();
  }

  public LineProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.q = paramContext;
    a(paramAttributeSet);
    b();
  }

  private Bitmap a(Bitmap paramBitmap)
  {
    return Bitmap.createScaledBitmap(paramBitmap, (int)this.n, (int)this.o, false);
  }

  private Paint a(Bitmap paramBitmap, int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setStyle(Paint.Style.FILL);
    if (paramBitmap != null)
    {
      localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      return localPaint;
    }
    localPaint.setColor(paramInt);
    return localPaint;
  }

  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.r);
  }

  private void a(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = this.q.obtainStyledAttributes(paramAttributeSet, R.styleable.LineProgressBar);
    this.g = localTypedArray.getColor(0, this.g);
    this.j = localTypedArray.getColor(3, this.j);
    this.k = localTypedArray.getColor(4, this.k);
    this.l = localTypedArray.getBoolean(5, this.l);
    this.m = localTypedArray.getBoolean(6, this.m);
    this.n = localTypedArray.getDimension(7, this.n);
    this.o = localTypedArray.getDimension(8, this.o);
    int i1 = localTypedArray.getInteger(9, a.a.a());
    BitmapDrawable localBitmapDrawable1 = (BitmapDrawable)localTypedArray.getDrawable(1);
    BitmapDrawable localBitmapDrawable2 = (BitmapDrawable)localTypedArray.getDrawable(2);
    localTypedArray.recycle();
    a locala;
    if (i1 == a.a.a())
    {
      locala = a.a;
      this.p = locala;
      if (localBitmapDrawable1 == null)
        break label216;
    }
    label216: for (Bitmap localBitmap1 = localBitmapDrawable1.getBitmap(); ; localBitmap1 = null)
    {
      this.h = localBitmap1;
      Bitmap localBitmap2 = null;
      if (localBitmapDrawable2 != null)
        localBitmap2 = localBitmapDrawable2.getBitmap();
      this.i = localBitmap2;
      f();
      return;
      locala = a.b;
      break;
    }
  }

  private void b()
  {
    c();
    d();
    e();
  }

  private void b(Canvas paramCanvas)
  {
    float f1 = this.u / 100.0F;
    int i1;
    float f2;
    float f3;
    label47: float f4;
    if (this.p == a.b)
    {
      i1 = getHeight();
      f2 = i1;
      if (this.p != a.a)
        break label89;
      f3 = f1 * getWidth();
      if (this.p != a.b)
        break label99;
      f4 = getHeight() * (1.0F - f1);
    }
    while (true)
    {
      paramCanvas.drawRect(0.0F, f2, f3, f4, this.s);
      return;
      i1 = 0;
      break;
      label89: f3 = getWidth();
      break label47;
      label99: f4 = getHeight();
    }
  }

  private void c()
  {
    this.r = a(this.i, this.g);
  }

  private void c(Canvas paramCanvas)
  {
    if ((this.h != null) || (!this.l))
      return;
    String str = String.valueOf(this.u);
    int i1 = (int)(this.v / 2.5D);
    this.t.setTextSize(i1);
    Paint.FontMetrics localFontMetrics = this.t.getFontMetrics();
    float f1 = (float)Math.ceil(localFontMetrics.descent - localFontMetrics.top);
    float f2 = this.t.measureText(str);
    paramCanvas.drawText(str, (this.w - f2) / 2.0F, (this.v - f1) / 2.0F + i1, this.t);
  }

  private void d()
  {
    this.s = a(this.h, this.j);
  }

  private void e()
  {
    this.t = new Paint();
    this.t.setAntiAlias(true);
    this.t.setColor(this.k);
  }

  private void f()
  {
    if ((this.h == null) || (this.n == -1.0F) || (this.o == -1.0F))
      return;
    this.h = a(this.h);
    if (this.i == null);
    for (Bitmap localBitmap = null; ; localBitmap = a(this.i))
    {
      this.i = localBitmap;
      return;
    }
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

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean)
      return;
    this.w = getWidth();
    int i1 = getHeight();
    if (this.h != null)
    {
      this.w = Math.max(this.w, this.h.getWidth());
      i1 = Math.max(i1, this.h.getHeight());
    }
    this.v = Math.min(this.w, i1);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.h != null)
      setMeasuredDimension(this.h.getWidth(), this.h.getHeight());
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.u = localBundle.getInt("state_current_progress");
      this.m = localBundle.getBoolean("state_need_anim");
      this.l = localBundle.getBoolean("state_need_show_text");
      if (localBundle.getInt("state_orientation", 0) == a.b.a());
      for (a locala = a.b; ; locala = a.a)
      {
        this.p = locala;
        super.onRestoreInstanceState(localBundle.getParcelable("instance_state"));
        return;
      }
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instance_state", super.onSaveInstanceState());
    localBundle.putInt("state_current_progress", this.u);
    localBundle.putBoolean("state_need_show_text", this.l);
    localBundle.putBoolean("state_need_anim", this.m);
    localBundle.putInt("state_orientation", this.p.a());
    return localBundle;
  }

  public void setProgress(int paramInt)
  {
    if (paramInt > 100.0F)
      paramInt = 100;
    this.u = paramInt;
    if (!this.m)
      a();
  }

  private static enum a
  {
    private int c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      d = arrayOfa;
    }

    private a(int arg3)
    {
      int j;
      this.c = j;
    }

    public int a()
    {
      return this.c;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.circleprogressbar.LineProgressBar
 * JD-Core Version:    0.6.0
 */