package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.withustudy.koudaizikao.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  List<a> e = new ArrayList();
  private boolean f;
  private final LayoutConfiguration g;
  private TextView h;

  public FlowLayout(Context paramContext)
  {
    super(paramContext);
    this.g = new LayoutConfiguration(paramContext, null);
  }

  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = new LayoutConfiguration(paramContext, paramAttributeSet);
  }

  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = new LayoutConfiguration(paramContext, paramAttributeSet);
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    case 0:
    default:
      return paramInt3;
    case -2147483648:
      return Math.min(paramInt3, paramInt2);
    case 1073741824:
    }
    return paramInt2;
  }

  private int a(LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.a())
      return paramLayoutParams.b;
    return this.g.d();
  }

  private Paint a(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt);
    localPaint.setStrokeWidth(2.0F);
    return localPaint;
  }

  private void a(Canvas paramCanvas, View paramView)
  {
    if (!this.g.b());
    Paint localPaint2;
    LayoutParams localLayoutParams;
    do
    {
      return;
      Paint localPaint1 = a(-256);
      localPaint2 = a(-65536);
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.rightMargin > 0)
      {
        float f11 = paramView.getRight();
        float f12 = paramView.getTop() + paramView.getHeight() / 2.0F;
        paramCanvas.drawLine(f11, f12, f11 + localLayoutParams.rightMargin, f12, localPaint1);
        paramCanvas.drawLine(f11 + localLayoutParams.rightMargin - 4.0F, f12 - 4.0F, f11 + localLayoutParams.rightMargin, f12, localPaint1);
        paramCanvas.drawLine(f11 + localLayoutParams.rightMargin - 4.0F, f12 + 4.0F, f11 + localLayoutParams.rightMargin, f12, localPaint1);
      }
      if (localLayoutParams.leftMargin > 0)
      {
        float f9 = paramView.getLeft();
        float f10 = paramView.getTop() + paramView.getHeight() / 2.0F;
        paramCanvas.drawLine(f9, f10, f9 - localLayoutParams.leftMargin, f10, localPaint1);
        paramCanvas.drawLine(4.0F + (f9 - localLayoutParams.leftMargin), f10 - 4.0F, f9 - localLayoutParams.leftMargin, f10, localPaint1);
        paramCanvas.drawLine(4.0F + (f9 - localLayoutParams.leftMargin), f10 + 4.0F, f9 - localLayoutParams.leftMargin, f10, localPaint1);
      }
      if (localLayoutParams.bottomMargin > 0)
      {
        float f7 = paramView.getLeft() + paramView.getWidth() / 2.0F;
        float f8 = paramView.getBottom();
        paramCanvas.drawLine(f7, f8, f7, f8 + localLayoutParams.bottomMargin, localPaint1);
        paramCanvas.drawLine(f7 - 4.0F, f8 + localLayoutParams.bottomMargin - 4.0F, f7, f8 + localLayoutParams.bottomMargin, localPaint1);
        paramCanvas.drawLine(f7 + 4.0F, f8 + localLayoutParams.bottomMargin - 4.0F, f7, f8 + localLayoutParams.bottomMargin, localPaint1);
      }
      if (localLayoutParams.topMargin <= 0)
        continue;
      float f5 = paramView.getLeft() + paramView.getWidth() / 2.0F;
      float f6 = paramView.getTop();
      paramCanvas.drawLine(f5, f6, f5, f6 - localLayoutParams.topMargin, localPaint1);
      paramCanvas.drawLine(f5 - 4.0F, 4.0F + (f6 - localLayoutParams.topMargin), f5, f6 - localLayoutParams.topMargin, localPaint1);
      paramCanvas.drawLine(f5 + 4.0F, 4.0F + (f6 - localLayoutParams.topMargin), f5, f6 - localLayoutParams.topMargin, localPaint1);
    }
    while (!localLayoutParams.a);
    if (this.g.a() == 0)
    {
      float f3 = paramView.getLeft();
      float f4 = paramView.getTop() + paramView.getHeight() / 2.0F;
      paramCanvas.drawLine(f3, f4 - 6.0F, f3, f4 + 6.0F, localPaint2);
      return;
    }
    float f1 = paramView.getLeft() + paramView.getWidth() / 2.0F;
    float f2 = paramView.getTop();
    paramCanvas.drawLine(f1 - 6.0F, f2, 6.0F + f1, f2, localPaint2);
  }

  private void a(a parama)
  {
    List localList = parama.e();
    int i = localList.size();
    int j = 0;
    if (j >= i)
      return;
    View localView = (View)localList.get(j);
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    if (this.g.a() == 0)
    {
      localLayoutParams.a(getPaddingLeft() + parama.d() + localLayoutParams.c(), getPaddingTop() + parama.a() + localLayoutParams.f());
      localView.measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.d(), 1073741824), View.MeasureSpec.makeMeasureSpec(localLayoutParams.e(), 1073741824));
    }
    while (true)
    {
      j++;
      break;
      localLayoutParams.a(getPaddingLeft() + parama.a() + localLayoutParams.f(), getPaddingTop() + parama.d() + localLayoutParams.c());
      localView.measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.e(), 1073741824), View.MeasureSpec.makeMeasureSpec(localLayoutParams.d(), 1073741824));
    }
  }

  private void a(List<a> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (j >= i)
      return;
    a locala = (a)paramList.get(j);
    locala.c(k);
    int m = k + locala.b();
    List localList = locala.e();
    int n = localList.size();
    int i1 = 0;
    int i2 = 0;
    while (true)
    {
      if (i1 >= n)
      {
        j++;
        k = m;
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)((View)localList.get(i1)).getLayoutParams();
      localLayoutParams.a(i2);
      i2 += localLayoutParams.d() + localLayoutParams.g();
      i1++;
    }
  }

  private void a(List<a> paramList, int paramInt1, int paramInt2)
  {
    int i = paramList.size();
    if (i <= 0);
    while (true)
    {
      return;
      a locala1 = (a)paramList.get(i - 1);
      int j = paramInt2 - (locala1.b() + locala1.a());
      int k = 0;
      int m = 0;
      while (k < i)
      {
        a locala2 = (a)paramList.get(k);
        int n = getGravity();
        int i1 = Math.round(1 * j / i);
        int i2 = locala2.c();
        int i3 = locala2.b();
        Rect localRect1 = new Rect();
        localRect1.top = m;
        localRect1.left = 0;
        localRect1.right = paramInt1;
        localRect1.bottom = (m + (i3 + i1));
        Rect localRect2 = new Rect();
        Gravity.apply(n, i2, i3, localRect1, localRect2);
        m += i1;
        locala2.d(localRect2.left);
        locala2.c(localRect2.top);
        locala2.b(localRect2.width());
        locala2.a(localRect2.height());
        k++;
      }
    }
  }

  private float b(LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.b())
      return paramLayoutParams.c;
    return this.g.c();
  }

  private void b(a parama)
  {
    List localList = parama.e();
    int i = localList.size();
    if (i <= 0)
      return;
    int j = 0;
    float f1 = 0.0F;
    while (true)
    {
      if (j >= i)
      {
        LayoutParams localLayoutParams1 = (LayoutParams)((View)localList.get(i - 1)).getLayoutParams();
        int k = parama.c() - (localLayoutParams1.d() + localLayoutParams1.c());
        int m = 0;
        int n = 0;
        while (m < i)
        {
          LayoutParams localLayoutParams2 = (LayoutParams)((View)localList.get(m)).getLayoutParams();
          float f3 = b(localLayoutParams2);
          int i1 = a(localLayoutParams2);
          int i2 = Math.round(f3 * k / f1);
          int i3 = localLayoutParams2.d() + localLayoutParams2.g();
          int i4 = localLayoutParams2.e() + localLayoutParams2.h();
          Rect localRect1 = new Rect();
          localRect1.top = 0;
          localRect1.left = n;
          localRect1.right = (n + (i3 + i2));
          localRect1.bottom = parama.b();
          Rect localRect2 = new Rect();
          Gravity.apply(i1, i3, i4, localRect1, localRect2);
          n += i2;
          localLayoutParams2.a(localRect2.left + localLayoutParams2.c());
          localLayoutParams2.d(localRect2.top);
          localLayoutParams2.b(localRect2.width() - localLayoutParams2.g());
          localLayoutParams2.c(localRect2.height() - localLayoutParams2.h());
          m++;
        }
        break;
      }
      float f2 = f1 + b((LayoutParams)((View)localList.get(j)).getLayoutParams());
      j++;
      f1 = f2;
    }
  }

  protected LayoutParams a()
  {
    return new LayoutParams(-2, -2);
  }

  public LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }

  public boolean b()
  {
    return this.g.b();
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    a(paramCanvas, paramView);
    return bool;
  }

  public int getGravity()
  {
    return this.g.d();
  }

  public int getLayoutDirection()
  {
    if (this.g == null)
      return 0;
    return this.g.e();
  }

  public int getOrientation()
  {
    return this.g.a();
  }

  public float getWeightDefault()
  {
    return this.g.c();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localView.layout(LayoutParams.a(localLayoutParams) + localLayoutParams.leftMargin, LayoutParams.b(localLayoutParams) + localLayoutParams.topMargin, LayoutParams.a(localLayoutParams) + localLayoutParams.leftMargin + localView.getMeasuredWidth(), LayoutParams.b(localLayoutParams) + localLayoutParams.topMargin + localView.getMeasuredHeight());
    }
  }

  @SuppressLint({"DrawAllocation"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingRight() - getPaddingLeft();
    int j = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int n;
    int i1;
    label70: int i2;
    label84: Object localObject1;
    int i3;
    if (this.g.a() == 0)
    {
      n = i;
      if (this.g.a() != 0)
        break label328;
      i1 = j;
      if (this.g.a() != 0)
        break label334;
      i2 = k;
      if (this.g.a() == 0);
      this.e.clear();
      localObject1 = new a(n, this.g);
      this.e.add(localObject1);
      i3 = getChildCount();
    }
    int i14;
    int i17;
    int i18;
    label192: int i19;
    int i22;
    label251: int i23;
    int i24;
    int i25;
    int i26;
    label304: label328: label334: View localView;
    label359: for (int i4 = 0; ; i4++)
    {
      if (i4 >= i3)
      {
        removeAllViews();
        i14 = 0;
        if (i14 < this.e.size())
          break label1186;
        a(this.e);
        int i16 = this.e.size();
        i17 = 0;
        i18 = 0;
        if (i18 < i16)
          break label1248;
        i19 = ((a)localObject1).a() + ((a)localObject1).b();
        int i20 = a(i2, n, i17);
        int i21 = a(m, i1, i19);
        a(this.e, i20, i21);
        i22 = 0;
        if (i22 < i16)
          break label1278;
        i23 = getPaddingLeft() + getPaddingRight();
        i24 = getPaddingBottom() + getPaddingTop();
        if (this.g.a() != 0)
          break label1312;
        i25 = i23 + i17;
        i26 = i24 + i19;
        setMeasuredDimension(resolveSize(i25, paramInt1), resolveSize(i26, paramInt2));
        return;
        n = j;
        break;
        i1 = i;
        break label70;
        i2 = m;
        break label84;
      }
      localView = getChildAt(i4);
      if (localView.getVisibility() != 8)
        break label365;
    }
    label365: LayoutParams localLayoutParams1 = (LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams1.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutParams1.height));
    localLayoutParams1.e(this.g.a());
    label458: int i6;
    label488: TextView localTextView;
    String str1;
    int i8;
    float f1;
    int i9;
    label543: label552: int i11;
    label650: int i12;
    int i13;
    LayoutParams localLayoutParams2;
    Object localObject2;
    if (this.g.a() == 0)
    {
      localLayoutParams1.b(localView.getMeasuredWidth());
      localLayoutParams1.c(localView.getMeasuredHeight());
      int i5 = ((a)localObject1).b(localView);
      if ((localLayoutParams1.a) || ((i2 != 0) && (i5 < 0)))
        break label963;
      i6 = 0;
      if (i6 == 0)
        break label1336;
      if (!(localView instanceof TextView))
        break label1082;
      localTextView = (TextView)localView;
      str1 = localTextView.getText().toString();
      int i7 = Math.abs(i5);
      i8 = localView.getMeasuredWidth() - i7;
      f1 = 0.0F;
      i9 = 0;
      if (f1 <= i8)
        break label969;
      int i10 = i9 - 1;
      if (i10 < 0)
        i10 = 0;
      localTextView.setText(str1.substring(0, i10));
      measureChild(localTextView, View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt2);
      i11 = localTextView.getMeasuredHeight();
      this.h = new TextView(getContext());
      if (!this.f)
        break label1016;
      this.h.setTextSize(2, 15.0F);
      this.h.setTextColor(getResources().getColor(2131034225));
      this.h.setText(str1.substring(i10));
      addView(this.h);
      measureChild(this.h, View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt2);
      i12 = this.h.getMeasuredWidth();
      i13 = this.h.getMeasuredHeight();
      localLayoutParams2 = new LayoutParams(i12, i13);
      localLayoutParams2.a = false;
      localLayoutParams2.bottomMargin = localLayoutParams1.bottomMargin;
      localLayoutParams2.topMargin = localLayoutParams1.topMargin;
      localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
      localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
      this.h.setLayoutParams(localLayoutParams2);
      if (this.g.a() != 0)
        break label1047;
      localLayoutParams1.b(i8);
      localLayoutParams1.c(i11);
      localLayoutParams2.b(i12);
      localLayoutParams2.c(i13);
      localObject2 = localObject1;
    }
    while (true)
    {
      label816: if ((this.g.a() == 0) && (this.g.e() == 1))
      {
        ((a)localObject2).a(0, localView);
        label845: if (this.h == null)
          break label1329;
        localObject1 = new a(n, this.g);
        if ((this.g.a() != 1) || (this.g.e() != 1))
          break label1159;
        this.e.add(0, localObject1);
        if ((this.g.a() != 0) || (this.g.e() != 1))
          break label1174;
        ((a)localObject1).a(0, this.h);
      }
      while (true)
      {
        label901: this.h = null;
        break;
        localLayoutParams1.b(localView.getMeasuredHeight());
        localLayoutParams1.c(localView.getMeasuredWidth());
        break label458;
        label963: i6 = 1;
        break label488;
        label969: i9++;
        if (i9 > -1 + str1.length())
          break label552;
        String str2 = str1.substring(0, i9);
        localTextView.setText(str2);
        f1 = localTextView.getPaint().measureText(str2);
        break label543;
        label1016: this.h.setTextSize(2, 17.0F);
        this.h.setTextColor(getResources().getColor(2131034226));
        break label650;
        label1047: localLayoutParams1.b(i8);
        localLayoutParams1.c(i11);
        localLayoutParams2.b(i13);
        localLayoutParams2.c(i12);
        localObject2 = localObject1;
        break label816;
        label1082: localObject2 = new a(n, this.g);
        if ((this.g.a() == 1) && (this.g.e() == 1))
        {
          this.e.add(0, localObject2);
          break label816;
        }
        this.e.add(localObject2);
        break label816;
        ((a)localObject2).a(localView);
        break label845;
        label1159: this.e.add(localObject1);
        break label901;
        label1174: ((a)localObject1).a(this.h);
      }
      label1186: List localList = ((a)this.e.get(i14)).e();
      for (int i15 = 0; ; i15++)
      {
        if (i15 >= localList.size())
        {
          i14++;
          break;
        }
        addView((View)localList.get(i15));
      }
      label1248: i17 = Math.max(i17, ((a)this.e.get(i18)).c());
      i18++;
      break label192;
      label1278: a locala = (a)this.e.get(i22);
      b(locala);
      a(locala);
      i22++;
      break label251;
      label1312: i25 = i23 + i19;
      i26 = i24 + i17;
      break label304;
      label1329: localObject1 = localObject2;
      break label359;
      label1336: localObject2 = localObject1;
    }
  }

  public void setDebugDraw(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
    invalidate();
  }

  public void setGravity(int paramInt)
  {
    this.g.b(paramInt);
    requestLayout();
  }

  public void setLayoutDirection(int paramInt)
  {
    this.g.c(paramInt);
    requestLayout();
  }

  public void setOption(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void setOrientation(int paramInt)
  {
    this.g.a(paramInt);
    requestLayout();
  }

  public void setWeightDefault(float paramFloat)
  {
    this.g.a(paramFloat);
    requestLayout();
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    public boolean a = false;

    @ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=0, to="NONE"), @android.view.ViewDebug.IntToString(from=48, to="TOP"), @android.view.ViewDebug.IntToString(from=80, to="BOTTOM"), @android.view.ViewDebug.IntToString(from=3, to="LEFT"), @android.view.ViewDebug.IntToString(from=5, to="RIGHT"), @android.view.ViewDebug.IntToString(from=16, to="CENTER_VERTICAL"), @android.view.ViewDebug.IntToString(from=112, to="FILL_VERTICAL"), @android.view.ViewDebug.IntToString(from=1, to="CENTER_HORIZONTAL"), @android.view.ViewDebug.IntToString(from=7, to="FILL_HORIZONTAL"), @android.view.ViewDebug.IntToString(from=17, to="CENTER"), @android.view.ViewDebug.IntToString(from=119, to="FILL")})
    public int b = 0;
    public float c = -1.0F;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      a(paramContext, paramAttributeSet);
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout_LayoutParams);
      try
      {
        this.a = localTypedArray.getBoolean(1, false);
        this.b = localTypedArray.getInt(0, 0);
        this.c = localTypedArray.getFloat(2, -1.0F);
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
      throw localObject;
    }

    void a(int paramInt)
    {
      this.f = paramInt;
    }

    void a(int paramInt1, int paramInt2)
    {
      this.j = paramInt1;
      this.k = paramInt2;
    }

    public boolean a()
    {
      return this.b != 0;
    }

    void b(int paramInt)
    {
      this.g = paramInt;
    }

    public boolean b()
    {
      return this.c >= 0.0F;
    }

    int c()
    {
      return this.f;
    }

    void c(int paramInt)
    {
      this.h = paramInt;
    }

    int d()
    {
      return this.g;
    }

    void d(int paramInt)
    {
      this.i = paramInt;
    }

    int e()
    {
      return this.h;
    }

    void e(int paramInt)
    {
      if (paramInt == 0)
      {
        this.d = (this.leftMargin + this.rightMargin);
        this.e = (this.topMargin + this.bottomMargin);
        return;
      }
      this.d = (this.topMargin + this.bottomMargin);
      this.e = (this.leftMargin + this.rightMargin);
    }

    int f()
    {
      return this.i;
    }

    int g()
    {
      return this.d;
    }

    int h()
    {
      return this.e;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.example.test.FlowLayout
 * JD-Core Version:    0.6.0
 */