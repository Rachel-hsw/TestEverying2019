package com.withustudy.koudaizikao.custom.test;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class a extends View
{
  public TextView a;
  public float b;
  float c;
  RectF d;
  int e = 0;
  private Paint f;
  private Paint g;
  private float h;
  private int i = 0;
  private MasterLayout j;

  public a(Context paramContext, AttributeSet paramAttributeSet, MasterLayout paramMasterLayout)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramMasterLayout;
    b();
  }

  public a(Context paramContext, MasterLayout paramMasterLayout)
  {
    super(paramContext);
    this.j = paramMasterLayout;
    b();
  }

  private void b()
  {
    this.f = new Paint();
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.e = (int)Math.sqrt(0.0217D * (localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels));
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setColor(Color.rgb(0, 161, 234));
    this.f.setStrokeWidth(7.0F);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setColor(0);
    float f1 = (float)(0.05D * this.e);
    float f2 = (float)(0.95D * this.e);
    this.d = new RectF(f1, (float)(0.05D * this.e), f2, (float)(0.95D * this.e));
  }

  public void a()
  {
    this.c = 0.0F;
    this.h = -90.0F;
    this.i = 1;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.d, this.h, this.c, false, this.f);
    this.h = -90.0F;
    if ((this.c < 360.0F) && (this.i == 0))
    {
      invalidate();
      return;
    }
    if (this.i == 1)
    {
      this.c = 0.0F;
      this.h = -90.0F;
      this.i = 0;
      invalidate();
      return;
    }
    this.c = 0.0F;
    this.h = -90.0F;
    this.j.c();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = this.e;
    int m = this.e;
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    if (n == 1073741824)
      if (i2 != 1073741824)
        break label82;
    while (true)
    {
      setMeasuredDimension(i1, i3);
      return;
      if (n == -2147483648)
      {
        i1 = Math.min(k, i1);
        break;
      }
      i1 = k;
      break;
      label82: if (i2 == -2147483648)
      {
        i3 = Math.min(m, i3);
        continue;
      }
      i3 = m;
    }
  }

  public void setupprogress(int paramInt)
  {
    this.c = (float)(3.6D * paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.test.a
 * JD-Core Version:    0.6.0
 */