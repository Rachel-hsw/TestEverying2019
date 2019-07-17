package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

class p extends LinearLayout
{
  private static final int a = 2;
  private static final byte b = 38;
  private static final int c = 8;
  private static final int d = -13388315;
  private static final int e = 1;
  private static final byte f = 32;
  private static final float g = 0.5F;
  private final int h;
  private final Paint i;
  private final int j;
  private final Paint k;
  private final int l;
  private final Paint m;
  private final float n;
  private int o;
  private float p;
  private SlidingTabLayout.c q;
  private final a r;

  p(Context paramContext)
  {
    this(paramContext, null);
  }

  p(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    float f1 = getResources().getDisplayMetrics().density;
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842800, localTypedValue, true);
    int i1 = localTypedValue.data;
    this.l = a(i1, 38);
    this.r = new a(null);
    this.r.a(new int[] { -13388315 });
    a locala = this.r;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = a(i1, 32);
    locala.b(arrayOfInt);
    this.h = (int)(0.0F * (2.0F * f1));
    this.i = new Paint();
    this.i.setColor(this.l);
    this.j = (int)(0.2D * (8.0F * f1));
    this.k = new Paint();
    this.n = 0.5F;
    this.m = new Paint();
    this.m.setStrokeWidth((int)(0.0F * (f1 * 1.0F)));
  }

  private static int a(int paramInt, byte paramByte)
  {
    return Color.argb(paramByte, Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }

  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = paramFloat * Color.red(paramInt1) + f1 * Color.red(paramInt2);
    float f3 = paramFloat * Color.green(paramInt1) + f1 * Color.green(paramInt2);
    float f4 = paramFloat * Color.blue(paramInt1) + f1 * Color.blue(paramInt2);
    return Color.rgb((int)f2, (int)f3, (int)f4);
  }

  void a(int paramInt, float paramFloat)
  {
    this.o = paramInt;
    this.p = paramFloat;
    invalidate();
  }

  void a(SlidingTabLayout.c paramc)
  {
    this.q = paramc;
    invalidate();
  }

  void a(int[] paramArrayOfInt)
  {
    this.q = null;
    this.r.a(paramArrayOfInt);
    invalidate();
  }

  void b(int[] paramArrayOfInt)
  {
    this.q = null;
    this.r.b(paramArrayOfInt);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = getHeight();
    int i2 = getChildCount();
    int i3 = (int)(Math.min(Math.max(0.0F, this.n), 1.0F) * i1);
    Object localObject;
    int i6;
    int i7;
    int i8;
    int i12;
    int i9;
    if (this.q != null)
    {
      localObject = this.q;
      if (i2 > 0)
      {
        View localView2 = getChildAt(this.o);
        i6 = localView2.getLeft();
        i7 = localView2.getRight();
        i8 = ((SlidingTabLayout.c)localObject).a(this.o);
        if ((this.p <= 0.0F) || (this.o >= -1 + getChildCount()))
          break label348;
        int i11 = ((SlidingTabLayout.c)localObject).a(1 + this.o);
        if (i8 != i11)
          i8 = a(i11, i8, this.p);
        View localView3 = getChildAt(1 + this.o);
        i12 = (int)(this.p * localView3.getLeft() + (1.0F - this.p) * i6);
        i9 = (int)(this.p * localView3.getRight() + (1.0F - this.p) * i7);
      }
    }
    for (int i10 = i12; ; i10 = i6)
    {
      this.k.setColor(i8);
      paramCanvas.drawRect(i10, i1 - this.j, i9, i1, this.k);
      paramCanvas.drawRect(0.0F, i1 - this.h, getWidth(), i1, this.i);
      int i4 = (i1 - i3) / 2;
      for (int i5 = 0; ; i5++)
      {
        if (i5 >= i2 - 1)
        {
          return;
          localObject = this.r;
          break;
        }
        View localView1 = getChildAt(i5);
        this.m.setColor(((SlidingTabLayout.c)localObject).b(i5));
        paramCanvas.drawLine(localView1.getRight(), i4, localView1.getRight(), i4 + i3, this.m);
      }
      label348: i9 = i7;
    }
  }

  private static class a
    implements SlidingTabLayout.c
  {
    private int[] a;
    private int[] b;

    public final int a(int paramInt)
    {
      return this.a[(paramInt % this.a.length)];
    }

    void a(int[] paramArrayOfInt)
    {
      this.a = paramArrayOfInt;
    }

    public final int b(int paramInt)
    {
      return this.b[(paramInt % this.b.length)];
    }

    void b(int[] paramArrayOfInt)
    {
      this.b = paramArrayOfInt;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.p
 * JD-Core Version:    0.6.0
 */