package com.himamis.retex.renderer.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.himamis.retex.renderer.a.dr;
import com.himamis.retex.renderer.a.dr.b;
import com.himamis.retex.renderer.a.du;
import com.himamis.retex.renderer.a.e.n;
import com.himamis.retex.renderer.a.g.a;
import com.himamis.retex.renderer.a.g.c.h;
import com.himamis.retex.renderer.android.c.c;
import com.withustudy.koudaizikao.R.styleable;

public class LaTeXView extends View
{
  private dr a;
  private du b;
  private dr.b c;
  private c d;
  private String e = "";
  private float f = 15.0F;
  private int g = 0;
  private com.himamis.retex.renderer.a.g.c.b h = new com.himamis.retex.renderer.android.c.b(-16777216);
  private int i = 0;
  private int j = 0;
  private float k;
  private Paint l;

  public LaTeXView(Context paramContext)
  {
    super(paramContext);
    a();
    this.k = paramContext.getResources().getDisplayMetrics().scaledDensity;
    b();
    c();
  }

  public LaTeXView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    this.k = paramContext.getResources().getDisplayMetrics().scaledDensity;
    b();
    a(paramContext, paramAttributeSet, 0);
  }

  public LaTeXView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    this.k = paramContext.getResources().getDisplayMetrics().scaledDensity;
    b();
    a(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    this.l = new Paint();
    this.l.setColor(getResources().getColor(2131034195));
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.LaTeXView, paramInt, 0);
    try
    {
      this.e = localTypedArray.getString(0);
      this.f = localTypedArray.getFloat(1, 15.0F);
      this.g = localTypedArray.getInteger(2, 0);
      this.j = localTypedArray.getInteger(3, 0);
      this.i = localTypedArray.getColor(5, 0);
      this.h = new com.himamis.retex.renderer.android.c.b(localTypedArray.getColor(4, -16777216));
      localTypedArray.recycle();
      c();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
    throw localObject;
  }

  private void b()
  {
    if (a.a == null)
      a.a = new b(getContext().getAssets());
  }

  private void c()
  {
    if (this.a == null);
    try
    {
      this.a = new dr(this.e);
      if (this.c == null)
      {
        dr localdr = this.a;
        localdr.getClass();
        this.c = new dr.b(localdr);
      }
      if (this.b == null)
      {
        this.c.a(this.f * this.k).a(this.g).b(this.j);
        this.b = this.c.a();
      }
      this.b.a(new h(getPaddingTop(), getPaddingLeft(), getPaddingBottom(), getPaddingRight()));
      return;
    }
    catch (n localn)
    {
      while (true)
        this.a = dr.b(this.e);
    }
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    float f1 = paramConfiguration.fontScale;
    if (Math.abs(this.k - f1) > 0.001D)
    {
      this.k = paramConfiguration.fontScale;
      this.b = null;
      c();
      invalidate();
      requestLayout();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null)
      return;
    if (this.d == null)
      this.d = new c();
    paramCanvas.drawColor(this.i);
    this.d.a(paramCanvas);
    this.b.a(this.h);
    this.b.a(null, this.d, 0, 0);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = this.b.d();
    int n = this.b.b();
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
      if (i3 != 1073741824)
        break label91;
    while (true)
    {
      setMeasuredDimension(i2, i4);
      return;
      if (i1 == -2147483648)
      {
        i2 = Math.min(m, i2);
        break;
      }
      i2 = m;
      break;
      label91: if (i3 == -2147483648)
      {
        i4 = Math.min(n, i4);
        continue;
      }
      i4 = n;
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    this.i = paramInt;
    invalidate();
  }

  public void setForegroundColor(int paramInt)
  {
    this.h = new com.himamis.retex.renderer.android.c.b(paramInt);
    invalidate();
  }

  public void setLatexText(String paramString)
  {
    this.e = paramString;
    this.a = null;
    this.c = null;
    this.b = null;
    c();
    invalidate();
    requestLayout();
  }

  public void setSize(float paramFloat)
  {
    if (Math.abs(this.f - paramFloat) > 0.01D)
    {
      this.f = paramFloat;
      this.b = null;
      c();
      invalidate();
      requestLayout();
    }
  }

  public void setStyle(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      this.b = null;
      c();
      invalidate();
      requestLayout();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.LaTeXView
 * JD-Core Version:    0.6.0
 */