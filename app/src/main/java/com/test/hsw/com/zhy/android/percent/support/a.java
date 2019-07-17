package com.zhy.android.percent.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.a.a.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  private static final String a = "PercentLayout";
  private static int c = 0;
  private static int d = 0;
  private static final String e = "^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)%([s]?[wh]?)$";
  private final ViewGroup b;

  public a(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
    d();
  }

  private static a.a.b a(TypedArray paramTypedArray, int paramInt, boolean paramBoolean)
  {
    return a(paramTypedArray.getString(paramInt), paramBoolean);
  }

  private static a.a.b a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return null;
    Matcher localMatcher = Pattern.compile("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)%([s]?[wh]?)$").matcher(paramString);
    if (!localMatcher.matches())
      throw new RuntimeException("the value of layout_xxxPercent invalid! ==>" + paramString);
    int i = paramString.length();
    String str = localMatcher.group(1);
    paramString.substring(i - 1);
    float f1 = Float.parseFloat(str) / 100.0F;
    a.a.b localb = new a.a.b();
    localb.a = f1;
    if (paramString.endsWith("sw"))
    {
      localb.b = a.a.a.c;
      return localb;
    }
    if (paramString.endsWith("sh"))
    {
      localb.b = a.a.a.d;
      return localb;
    }
    if (paramString.endsWith("%"))
    {
      if (paramBoolean)
      {
        localb.b = a.a.a.a;
        return localb;
      }
      localb.b = a.a.a.b;
      return localb;
    }
    if (paramString.endsWith("w"))
    {
      localb.b = a.a.a.a;
      return localb;
    }
    if (paramString.endsWith("h"))
    {
      localb.b = a.a.a.b;
      return localb;
    }
    throw new IllegalArgumentException("the " + paramString + " must be endWith [%|w|h|sw|sh]");
  }

  public static a a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.PercentLayout_Layout);
    a locala = e(localTypedArray, c(localTypedArray, b(localTypedArray, d(localTypedArray, a(localTypedArray, null)))));
    localTypedArray.recycle();
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "constructed: " + locala);
    return locala;
  }

  private static a a(TypedArray paramTypedArray, a parama)
  {
    a.a.b localb1 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_widthPercent, true);
    if (localb1 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent width: " + localb1.a);
      parama = a(parama);
      parama.a = localb1;
    }
    a.a.b localb2 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_heightPercent, false);
    if (localb2 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent height: " + localb2.a);
      parama = a(parama);
      parama.b = localb2;
    }
    return parama;
  }

  @NonNull
  private static a a(a parama)
  {
    if (parama != null)
      return parama;
    return new a();
  }

  private void a(int paramInt1, int paramInt2, View paramView, a parama)
  {
    int i = paramView.getPaddingLeft();
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingTop();
    int m = paramView.getPaddingBottom();
    a.a.b localb1 = parama.n;
    if (localb1 != null)
      i = (int)(b(paramInt1, paramInt2, localb1.b) * localb1.a);
    a.a.b localb2 = parama.o;
    if (localb2 != null)
      j = (int)(b(paramInt1, paramInt2, localb2.b) * localb2.a);
    a.a.b localb3 = parama.p;
    if (localb3 != null)
      k = (int)(b(paramInt1, paramInt2, localb3.b) * localb3.a);
    a.a.b localb4 = parama.q;
    if (localb4 != null)
      m = (int)(b(paramInt1, paramInt2, localb4.b) * localb4.a);
    paramView.setPadding(i, k, j, m);
  }

  public static void a(ViewGroup.LayoutParams paramLayoutParams, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    paramLayoutParams.width = paramTypedArray.getLayoutDimension(paramInt1, 0);
    paramLayoutParams.height = paramTypedArray.getLayoutDimension(paramInt2, 0);
  }

  private void a(String paramString, int paramInt1, int paramInt2, View paramView, Class paramClass, a.a.b paramb)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", paramString + " ==> " + paramb);
    if (paramb != null)
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = paramClass.getMethod(paramString, arrayOfClass);
      localMethod.setAccessible(true);
      int i = b(paramInt1, paramInt2, paramb.b);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf((int)(i * paramb.a));
      localMethod.invoke(paramView, arrayOfObject);
    }
  }

  private static boolean a(View paramView, a parama)
  {
    int i = 0xFF000000 & ViewCompat.getMeasuredWidthAndState(paramView);
    if ((parama == null) || (parama.a == null));
    do
      return false;
    while ((i != 16777216) || (parama.a.a < 0.0F) || (parama.r.width != -2));
    return true;
  }

  private static int b(int paramInt1, int paramInt2, a.a.a parama)
  {
    switch (c()[parama.ordinal()])
    {
    default:
      paramInt2 = 0;
    case 2:
      return paramInt2;
    case 1:
      return paramInt1;
    case 3:
      return c;
    case 4:
    }
    return d;
  }

  private static a b(TypedArray paramTypedArray, a parama)
  {
    a.a.b localb = a(paramTypedArray, a.l.PercentLayout_Layout_layout_textSizePercent, false);
    if (localb != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent text size: " + localb.a);
      parama = a(parama);
      parama.i = localb;
    }
    return parama;
  }

  private void b(int paramInt1, int paramInt2, View paramView, a parama)
  {
    try
    {
      Class localClass = paramView.getClass();
      a("setMaxWidth", paramInt1, paramInt2, paramView, localClass, parama.j);
      a("setMaxHeight", paramInt1, paramInt2, paramView, localClass, parama.k);
      a("setMinWidth", paramInt1, paramInt2, paramView, localClass, parama.l);
      a("setMinHeight", paramInt1, paramInt2, paramView, localClass, parama.m);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }

  private static boolean b(View paramView, a parama)
  {
    int i = 0xFF000000 & ViewCompat.getMeasuredHeightAndState(paramView);
    if ((parama == null) || (parama.b == null));
    do
      return false;
    while ((i != 16777216) || (parama.b.a < 0.0F) || (parama.r.height != -2));
    return true;
  }

  private static a c(TypedArray paramTypedArray, a parama)
  {
    a.a.b localb1 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_maxWidthPercent, true);
    if (localb1 != null)
    {
      parama = a(parama);
      parama.j = localb1;
    }
    a.a.b localb2 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_maxHeightPercent, false);
    if (localb2 != null)
    {
      parama = a(parama);
      parama.k = localb2;
    }
    a.a.b localb3 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_minWidthPercent, true);
    if (localb3 != null)
    {
      parama = a(parama);
      parama.l = localb3;
    }
    a.a.b localb4 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_minHeightPercent, false);
    if (localb4 != null)
    {
      parama = a(parama);
      parama.m = localb4;
    }
    return parama;
  }

  private void c(int paramInt1, int paramInt2, View paramView, a parama)
  {
    a.a.b localb = parama.i;
    if (localb == null);
    float f1;
    do
    {
      return;
      f1 = (int)(b(paramInt1, paramInt2, localb.b) * localb.a);
    }
    while (!(paramView instanceof TextView));
    ((TextView)paramView).setTextSize(0, f1);
  }

  private static a d(TypedArray paramTypedArray, a parama)
  {
    a.a.b localb1 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginPercent, true);
    if (localb1 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent margin: " + localb1.a);
      parama = a(parama);
      parama.c = localb1;
      parama.d = localb1;
      parama.e = localb1;
      parama.f = localb1;
    }
    a.a.b localb2 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginLeftPercent, true);
    if (localb2 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent left margin: " + localb2.a);
      parama = a(parama);
      parama.c = localb2;
    }
    a.a.b localb3 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginTopPercent, false);
    if (localb3 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent top margin: " + localb3.a);
      parama = a(parama);
      parama.d = localb3;
    }
    a.a.b localb4 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginRightPercent, true);
    if (localb4 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent right margin: " + localb4.a);
      parama = a(parama);
      parama.e = localb4;
    }
    a.a.b localb5 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginBottomPercent, false);
    if (localb5 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent bottom margin: " + localb5.a);
      parama = a(parama);
      parama.f = localb5;
    }
    a.a.b localb6 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginStartPercent, true);
    if (localb6 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent start margin: " + localb6.a);
      parama = a(parama);
      parama.g = localb6;
    }
    a.a.b localb7 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_marginEndPercent, true);
    if (localb7 != null)
    {
      if (Log.isLoggable("PercentLayout", 2))
        Log.v("PercentLayout", "percent end margin: " + localb7.a);
      parama = a(parama);
      parama.h = localb7;
    }
    return parama;
  }

  private void d()
  {
    WindowManager localWindowManager = (WindowManager)this.b.getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    c = localDisplayMetrics.widthPixels;
    d = localDisplayMetrics.heightPixels;
  }

  private static a e(TypedArray paramTypedArray, a parama)
  {
    a.a.b localb1 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_paddingPercent, true);
    if (localb1 != null)
    {
      parama = a(parama);
      parama.n = localb1;
      parama.o = localb1;
      parama.q = localb1;
      parama.p = localb1;
    }
    a.a.b localb2 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_paddingLeftPercent, true);
    if (localb2 != null)
    {
      parama = a(parama);
      parama.n = localb2;
    }
    a.a.b localb3 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_paddingRightPercent, true);
    if (localb3 != null)
    {
      parama = a(parama);
      parama.o = localb3;
    }
    a.a.b localb4 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_paddingTopPercent, true);
    if (localb4 != null)
    {
      parama = a(parama);
      parama.p = localb4;
    }
    a.a.b localb5 = a(paramTypedArray, a.l.PercentLayout_Layout_layout_paddingBottomPercent, true);
    if (localb5 != null)
    {
      parama = a(parama);
      parama.q = localb5;
    }
    return parama;
  }

  public void a()
  {
    int i = this.b.getChildCount();
    int j = 0;
    if (j >= i)
      return;
    View localView = this.b.getChildAt(j);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "should restore " + localView + " " + localLayoutParams);
    a locala;
    if ((localLayoutParams instanceof b))
    {
      locala = ((b)localLayoutParams).a();
      if (Log.isLoggable("PercentLayout", 3))
        Log.d("PercentLayout", "using " + locala);
      if (locala != null)
      {
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          break label156;
        locala.a((ViewGroup.MarginLayoutParams)localLayoutParams);
      }
    }
    while (true)
    {
      j++;
      break;
      label156: locala.a(localLayoutParams);
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "adjustChildren: " + this.b + " widthMeasureSpec: " + View.MeasureSpec.toString(paramInt1) + " heightMeasureSpec: " + View.MeasureSpec.toString(paramInt2));
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "widthHint = " + i + " , heightHint = " + j);
    int k = this.b.getChildCount();
    int m = 0;
    if (m >= k)
      return;
    View localView = this.b.getChildAt(m);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "should adjust " + localView + " " + localLayoutParams);
    a locala;
    if ((localLayoutParams instanceof b))
    {
      locala = ((b)localLayoutParams).a();
      if (Log.isLoggable("PercentLayout", 3))
        Log.d("PercentLayout", "using " + locala);
      if (locala != null)
      {
        c(i, j, localView, locala);
        a(i, j, localView, locala);
        b(i, j, localView, locala);
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          break label315;
        locala.a((ViewGroup.MarginLayoutParams)localLayoutParams, i, j);
      }
    }
    while (true)
    {
      m++;
      break;
      label315: locala.a(localLayoutParams, i, j);
    }
  }

  public boolean b()
  {
    int i = this.b.getChildCount();
    int j = 0;
    boolean bool1 = false;
    if (j >= i)
    {
      if (Log.isLoggable("PercentLayout", 3))
        Log.d("PercentLayout", "should trigger second measure pass: " + bool1);
      return bool1;
    }
    View localView = this.b.getChildAt(j);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (Log.isLoggable("PercentLayout", 3))
      Log.d("PercentLayout", "should handle measured state too small " + localView + " " + localLayoutParams);
    a locala;
    if ((localLayoutParams instanceof b))
    {
      locala = ((b)localLayoutParams).a();
      if (locala != null)
      {
        if (!a(localView, locala))
          break label188;
        localLayoutParams.width = -2;
      }
    }
    label188: for (boolean bool2 = true; ; bool2 = bool1)
    {
      if (b(localView, locala))
        localLayoutParams.height = -2;
      for (bool1 = true; ; bool1 = bool2)
      {
        j++;
        break;
      }
    }
  }

  public static class a
  {
    public b a;
    public b b;
    public b c;
    public b d;
    public b e;
    public b f;
    public b g;
    public b h;
    public b i;
    public b j;
    public b k;
    public b l;
    public b m;
    public b n;
    public b o;
    public b p;
    public b q;
    final ViewGroup.MarginLayoutParams r = new ViewGroup.MarginLayoutParams(0, 0);

    public void a(ViewGroup.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.width = this.r.width;
      paramLayoutParams.height = this.r.height;
    }

    public void a(ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
    {
      this.r.width = paramLayoutParams.width;
      this.r.height = paramLayoutParams.height;
      if (this.a != null)
        paramLayoutParams.width = (int)(a.a(paramInt1, paramInt2, this.a.b) * this.a.a);
      if (this.b != null)
        paramLayoutParams.height = (int)(a.a(paramInt1, paramInt2, this.b.b) * this.b.a);
      if (Log.isLoggable("PercentLayout", 3))
        Log.d("PercentLayout", "after fillLayoutParams: (" + paramLayoutParams.width + ", " + paramLayoutParams.height + ")");
    }

    public void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      a(paramMarginLayoutParams);
      paramMarginLayoutParams.leftMargin = this.r.leftMargin;
      paramMarginLayoutParams.topMargin = this.r.topMargin;
      paramMarginLayoutParams.rightMargin = this.r.rightMargin;
      paramMarginLayoutParams.bottomMargin = this.r.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(this.r));
      MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.r));
    }

    public void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2)
    {
      a(paramMarginLayoutParams, paramInt1, paramInt2);
      this.r.leftMargin = paramMarginLayoutParams.leftMargin;
      this.r.topMargin = paramMarginLayoutParams.topMargin;
      this.r.rightMargin = paramMarginLayoutParams.rightMargin;
      this.r.bottomMargin = paramMarginLayoutParams.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(this.r, MarginLayoutParamsCompat.getMarginStart(paramMarginLayoutParams));
      MarginLayoutParamsCompat.setMarginEnd(this.r, MarginLayoutParamsCompat.getMarginEnd(paramMarginLayoutParams));
      if (this.c != null)
        paramMarginLayoutParams.leftMargin = (int)(a.a(paramInt1, paramInt2, this.c.b) * this.c.a);
      if (this.d != null)
        paramMarginLayoutParams.topMargin = (int)(a.a(paramInt1, paramInt2, this.d.b) * this.d.a);
      if (this.e != null)
        paramMarginLayoutParams.rightMargin = (int)(a.a(paramInt1, paramInt2, this.e.b) * this.e.a);
      if (this.f != null)
        paramMarginLayoutParams.bottomMargin = (int)(a.a(paramInt1, paramInt2, this.f.b) * this.f.a);
      if (this.g != null)
        MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, (int)(a.a(paramInt1, paramInt2, this.g.b) * this.g.a));
      if (this.h != null)
        MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, (int)(a.a(paramInt1, paramInt2, this.h.b) * this.h.a));
      if (Log.isLoggable("PercentLayout", 3))
        Log.d("PercentLayout", "after fillMarginLayoutParams: (" + paramMarginLayoutParams.width + ", " + paramMarginLayoutParams.height + ")");
    }

    public String toString()
    {
      return "PercentLayoutInfo{widthPercent=" + this.a + ", heightPercent=" + this.b + ", leftMarginPercent=" + this.c + ", topMarginPercent=" + this.d + ", rightMarginPercent=" + this.e + ", bottomMarginPercent=" + this.f + ", startMarginPercent=" + this.g + ", endMarginPercent=" + this.h + ", textSizePercent=" + this.i + ", maxWidthPercent=" + this.j + ", maxHeightPercent=" + this.k + ", minWidthPercent=" + this.l + ", minHeightPercent=" + this.m + ", paddingLeftPercent=" + this.n + ", paddingRightPercent=" + this.o + ", paddingTopPercent=" + this.p + ", paddingBottomPercent=" + this.q + ", mPreservedParams=" + this.r + '}';
    }

    private static enum a
    {
      public static final String e = "%";
      public static final String f = "w";
      public static final String g = "h";
      public static final String h = "sw";
      public static final String i = "sh";

      static
      {
        a[] arrayOfa = new a[4];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        j = arrayOfa;
      }
    }

    public static class b
    {
      public float a = -1.0F;
      public a.a.a b;

      public b()
      {
      }

      public b(float paramFloat, a.a.a parama)
      {
        this.a = paramFloat;
        this.b = parama;
      }

      public String toString()
      {
        return "PercentVal{percent=" + this.a + ", basemode=" + this.b.name() + '}';
      }
    }
  }

  public static abstract interface b
  {
    public abstract a.a a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.zhy.android.percent.support.a
 * JD-Core Version:    0.6.0
 */