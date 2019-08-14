package com.umeng.socialize.view.wigets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.utils.i;
import java.lang.reflect.Array;

public class b extends ViewGroup
{
  private static final int a = 3;
  private static final int b = 1;
  private static final int c = 2;
  private int d = 4;
  private int e = 0;
  private int[][] f = (int[][])null;
  private a g;
  private int h;
  private int i;
  private int j = 0;
  private int k = -1;
  private int l = 2;
  private Context m = null;

  public b(Context paramContext)
  {
    super(paramContext);
    this.j = paramContext.getResources().getColor(com.umeng.socialize.common.b.a(paramContext, b.a.f, "umeng_socialize_grid_divider_line"));
    this.m = paramContext;
  }

  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext.getResources().getColor(com.umeng.socialize.common.b.a(paramContext, b.a.f, "umeng_socialize_grid_divider_line"));
    this.m = paramContext;
  }

  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = paramContext.getResources().getColor(com.umeng.socialize.common.b.a(paramContext, b.a.f, "umeng_socialize_grid_divider_line"));
    this.m = paramContext;
  }

  private void b()
  {
    if ((this.m == null) || (this.g == null))
    {
      int[] arrayOfInt1 = { 4, 2 };
      this.f = ((int[][])Array.newInstance(Integer.TYPE, arrayOfInt1));
      return;
    }
    if (this.m.getResources().getConfiguration().orientation == 2)
      this.d = 6;
    int n = this.g.a();
    this.e = (this.g.a() / this.d);
    if (n % this.d > 0)
      this.e = (1 + this.e);
    i.c("", "###### row = " + this.e + ", column = " + this.d);
    int[] arrayOfInt2 = { this.d, this.e };
    this.f = ((int[][])Array.newInstance(Integer.TYPE, arrayOfInt2));
  }

  public a a()
  {
    return this.g;
  }

  public void a(int paramInt)
  {
    int n = this.f.length;
    int i1 = this.f[0].length;
    int i2 = n * i1;
    if (paramInt > i2)
      paramInt = i2;
    int i3 = paramInt % n;
    int i4;
    int i5;
    int i6;
    int i7;
    if (i3 > 0)
    {
      i4 = n - i3;
      i5 = i2 - paramInt - i4;
      i6 = i5 + paramInt;
      i7 = 0;
    }
    int i9;
    for (int i8 = 0; ; i8 = i9)
    {
      if (i7 >= i1)
        return;
      i9 = i8;
      int i10 = 0;
      label78: if (i10 < n)
      {
        if ((i9 >= i5) && (i9 < i6))
          this.f[i10][i7] = 1;
        while (true)
        {
          i9++;
          i10++;
          break label78;
          i4 = 0;
          break;
          if (i9 >= i6)
          {
            this.f[i10][i7] = 2;
            continue;
          }
          this.f[i10][i7] = 3;
        }
      }
      i7++;
    }
  }

  public void a(a parama)
  {
    this.g = parama;
    b();
    requestLayout();
  }

  public void b(int paramInt)
  {
    this.j = paramInt;
  }

  public void c(int paramInt)
  {
    this.k = paramInt;
  }

  public void d(int paramInt)
  {
    this.l = paramInt;
  }

  public int e(int paramInt)
  {
    return (paramInt - (-1 + this.d) * this.l) / this.d * this.e + (-1 + this.e) * this.l;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.g == null)
      return;
    Context localContext = getContext();
    a(this.g.a());
    removeAllViews();
    int n = this.f.length;
    int i1 = this.f[0].length;
    int i2 = (this.i - (n - 1) * this.l) / n;
    int i3 = (this.h - (i1 - 1) * this.l) / i1;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    label95: int i8;
    int i9;
    label109: ViewGroup.LayoutParams localLayoutParams;
    label180: int i15;
    label192: View localView3;
    int i20;
    label352: int i13;
    if (i5 < i1)
    {
      i8 = 0;
      i9 = i4;
      if (i8 < n)
      {
        if (this.f[i8][i5] != 1)
          break label554;
        a locala = this.g;
        int i14 = i9 + 1;
        View localView2 = locala.a(i9, this);
        localLayoutParams = localView2.getLayoutParams();
        if (localLayoutParams == null)
        {
          localView2.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
          if (i8 != n - 1)
            break label414;
          i15 = 1;
          int i16 = i7 + i8 * i2;
          int i17 = i16 + i2;
          int i18 = i6 + i5 * i3;
          int i19 = i18 + i3;
          addView(localView2);
          measureChild(localView2, i2, i3);
          localView2.layout(i16, i18, i17, i19);
          if ((i15 == 0) && (this.f[(i8 + 1)][i5] == 2))
          {
            View localView4 = new View(localContext);
            localView4.setBackgroundColor(this.k);
            addView(localView4);
            localView4.layout(i16 + i2, i18, paramInt3, i19);
          }
          localView3 = new View(localContext);
          if (i15 != 0)
            break label420;
          localView3.setBackgroundColor(this.j);
          i20 = i7 + this.l;
          addView(localView3);
          localView3.layout(i16 + i2, i18, i17 + this.l, i19);
          i13 = i20;
          i9 = i14;
        }
      }
    }
    while (true)
    {
      i8++;
      i7 = i13;
      break label109;
      localLayoutParams.height = i3;
      localLayoutParams.width = i2;
      break label180;
      label414: i15 = 0;
      break label192;
      label420: localView3.setBackgroundColor(this.k);
      i20 = 0;
      break label352;
      int i10;
      if (i5 > 0)
        if (this.f[0][(i5 - 1)] == 1)
          i10 = 1;
      while (true)
      {
        if (i10 != 0)
        {
          View localView1 = new View(localContext);
          localView1.setBackgroundColor(this.j);
          addView(localView1);
          int i11 = i6 + i5 * i3;
          localView1.layout(paramInt1, i11 - this.l, paramInt3, i11);
        }
        int i12 = i6 + this.l;
        i5++;
        i6 = i12;
        i4 = i9;
        i7 = 0;
        break label95;
        break;
        i10 = 0;
        continue;
        i10 = 0;
      }
      label554: i13 = i7;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.h = View.MeasureSpec.getSize(paramInt2);
    this.i = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(this.i, this.h);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.wigets.b
 * JD-Core Version:    0.6.0
 */