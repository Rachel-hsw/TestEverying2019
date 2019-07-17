package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import com.withustudy.koudaizikao.R.styleable;

public class SwipyRefreshLayout extends ViewGroup
{
  private static final int[] M;
  public static final int a = 0;
  public static final int b = 1;
  private static final float e = 0.6F;
  private static final int f = 120;
  private static final String g = SwipyRefreshLayout.class.getSimpleName();
  private static final int h = 255;
  private static final int i = 76;
  private static final int j = 40;
  private static final int k = 56;
  private static final float l = 2.0F;
  private static final int m = -1;
  private static final float n = 0.5F;
  private static final float o = 0.8F;
  private static final int p = 150;
  private static final int q = 300;
  private static final int r = 200;
  private static final int s = 200;
  private static final int t = -328966;
  private static final int u = 64;
  private int A;
  private float B = -1.0F;
  private int C;
  private int D;
  private boolean E = false;
  private float F;
  private float G;
  private boolean H;
  private int I = -1;
  private boolean J;
  private boolean K;
  private final DecelerateInterpolator L;
  private a N;
  private int O = -1;
  private float P;
  private b Q;
  private Animation R;
  private Animation S;
  private Animation T;
  private Animation U;
  private Animation V;
  private float W;
  private boolean aa;
  private int ab;
  private int ac;
  private boolean ad;
  private Animation.AnimationListener ae = new h(this);
  private final Animation af = new i(this);
  private final Animation ag = new j(this);
  protected int c;
  protected int d;
  private View v;
  private p w;
  private boolean x;
  private a y;
  private boolean z = false;

  static
  {
    M = new int[] { 16842766 };
  }

  public SwipyRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SwipyRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.A = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.C = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.L = new DecelerateInterpolator(2.0F);
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, M);
    setEnabled(localTypedArray1.getBoolean(0, true));
    localTypedArray1.recycle();
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwipyRefreshLayout);
    p localp = p.a(localTypedArray2.getInt(0, 0));
    if (localp != p.c)
      this.w = localp;
    for (this.x = false; ; this.x = true)
    {
      localTypedArray2.recycle();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.ab = (int)(40.0F * localDisplayMetrics.density);
      this.ac = (int)(40.0F * localDisplayMetrics.density);
      e();
      ViewCompat.setChildrenDrawingOrderEnabled(this, true);
      this.W = (64.0F * localDisplayMetrics.density);
      return;
      this.w = p.a;
    }
  }

  private float a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (i1 < 0)
      return -1.0F;
    return MotionEventCompat.getY(paramMotionEvent, i1);
  }

  private Animation a(int paramInt1, int paramInt2)
  {
    if ((this.J) && (f()))
      return null;
    m localm = new m(this, paramInt1, paramInt2);
    localm.setDuration(300L);
    this.N.a(null);
    this.N.clearAnimation();
    this.N.startAnimation(localm);
    return localm;
  }

  private void a(float paramFloat)
  {
    a(this.c + (int)(paramFloat * (this.d - this.c)) - this.N.getTop(), false);
  }

  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.c = paramInt;
    this.af.reset();
    this.af.setDuration(200L);
    this.af.setInterpolator(this.L);
    if (paramAnimationListener != null)
      this.N.a(paramAnimationListener);
    this.N.clearAnimation();
    this.N.startAnimation(this.af);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    this.N.bringToFront();
    this.N.offsetTopAndBottom(paramInt);
    this.D = this.N.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11))
      invalidate();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.I)
      if (i1 != 0)
        break label33;
    label33: for (int i2 = 1; ; i2 = 0)
    {
      this.I = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      return;
    }
  }

  private void a(Animation.AnimationListener paramAnimationListener)
  {
    this.N.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
      this.Q.setAlpha(255);
    this.R = new k(this);
    this.R.setDuration(this.C);
    if (paramAnimationListener != null)
      this.N.a(paramAnimationListener);
    this.N.clearAnimation();
    this.N.startAnimation(this.R);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.z != paramBoolean1)
    {
      this.aa = paramBoolean2;
      i();
      this.z = paramBoolean1;
      if (this.z)
        a(this.D, this.ae);
    }
    else
    {
      return;
    }
    b(this.ae);
  }

  private boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }

  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.J)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.c = paramInt;
    this.ag.reset();
    this.ag.setDuration(200L);
    this.ag.setInterpolator(this.L);
    if (paramAnimationListener != null)
      this.N.a(paramAnimationListener);
    this.N.clearAnimation();
    this.N.startAnimation(this.ag);
  }

  private void b(Animation.AnimationListener paramAnimationListener)
  {
    this.S = new l(this);
    this.S.setDuration(150L);
    this.N.a(paramAnimationListener);
    this.N.clearAnimation();
    this.N.startAnimation(this.S);
  }

  @SuppressLint({"NewApi"})
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.c = paramInt;
    if (f());
    for (this.P = this.Q.getAlpha(); ; this.P = ViewCompat.getScaleX(this.N))
    {
      this.V = new o(this);
      this.V.setDuration(150L);
      if (paramAnimationListener != null)
        this.N.a(paramAnimationListener);
      this.N.clearAnimation();
      this.N.startAnimation(this.V);
      return;
    }
  }

  private void e()
  {
    this.N = new a(getContext(), -328966, 20.0F);
    this.Q = new b(getContext(), this);
    this.Q.b(-328966);
    this.N.setImageDrawable(this.Q);
    this.N.setVisibility(8);
    addView(this.N);
  }

  private boolean f()
  {
    return Build.VERSION.SDK_INT < 11;
  }

  @SuppressLint({"NewApi"})
  private void g()
  {
    this.T = a(this.Q.getAlpha(), 76);
  }

  @SuppressLint({"NewApi"})
  private void h()
  {
    this.U = a(this.Q.getAlpha(), 255);
  }

  private void i()
  {
    if (this.v == null);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= getChildCount());
      while (true)
      {
        if ((this.B == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0))
        {
          DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
          this.B = (int)Math.min(0.6F * ((View)getParent()).getHeight(), 120.0F * localDisplayMetrics.density);
        }
        return;
        View localView = getChildAt(i1);
        if (localView.equals(this.N))
          break;
        this.v = localView;
      }
    }
  }

  private void setAnimationProgress(float paramFloat)
  {
    if (f())
    {
      setColorViewAlpha((int)(255.0F * paramFloat));
      return;
    }
    ViewCompat.setScaleX(this.N, paramFloat);
    ViewCompat.setScaleY(this.N, paramFloat);
  }

  private void setColorViewAlpha(int paramInt)
  {
    this.N.getBackground().setAlpha(paramInt);
    this.Q.setAlpha(paramInt);
  }

  private void setRawDirection(p paramp)
  {
    if (this.w == paramp)
      return;
    this.w = paramp;
    switch (d()[this.w.ordinal()])
    {
    default:
      int i2 = -this.N.getMeasuredHeight();
      this.d = i2;
      this.D = i2;
      return;
    case 2:
    }
    int i1 = getMeasuredHeight();
    this.d = i1;
    this.D = i1;
  }

  public boolean a()
  {
    return this.z;
  }

  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      if ((this.v instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.v;
        return (localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()));
      }
      return this.v.getScrollY() > 0;
    }
    return ViewCompat.canScrollVertically(this.v, -1);
  }

  public boolean c()
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      if ((this.v instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.v;
        try
        {
          if ((localAbsListView.getCount() > 0) && (1 + localAbsListView.getLastVisiblePosition() == localAbsListView.getCount()))
          {
            int i1 = localAbsListView.getChildAt(localAbsListView.getLastVisiblePosition() - localAbsListView.getFirstVisiblePosition()).getBottom();
            int i2 = localAbsListView.getPaddingBottom();
            return i1 == i2;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        return true;
      }
      return true;
    }
    return ViewCompat.canScrollVertically(this.v, 1);
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.O < 0);
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1)
        return this.O;
    }
    while (paramInt2 < this.O);
    return paramInt2 + 1;
  }

  public p getDirection()
  {
    if (this.x)
      return p.c;
    return this.w;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    i();
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((this.K) && (i1 == 0))
      this.K = false;
    switch (d()[this.w.ordinal()])
    {
    default:
      if ((isEnabled()) && (!this.K) && ((this.x) || (!b())) && (!this.z))
        break;
    case 2:
      do
        return false;
      while ((!isEnabled()) || (this.K) || ((!this.x) && (c())) || (this.z));
    }
    switch (i1)
    {
    case 4:
    case 5:
    default:
    case 0:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    while (true)
    {
      return this.H;
      a(this.d - this.N.getTop(), true);
      this.I = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.H = false;
      float f3 = a(paramMotionEvent, this.I);
      if (f3 == -1.0F)
        break;
      this.G = f3;
      if (this.I == -1)
        break;
      float f1 = a(paramMotionEvent, this.I);
      if (f1 == -1.0F)
        break;
      if (this.x)
      {
        if (f1 > this.G)
          setRawDirection(p.a);
        while (((this.w == p.b) && (c())) || ((this.w == p.a) && (b())))
        {
          this.G = f1;
          return false;
          if (f1 >= this.G)
            continue;
          setRawDirection(p.b);
        }
      }
      float f2;
      switch (d()[this.w.ordinal()])
      {
      default:
        f2 = f1 - this.G;
        if ((f2 <= this.A) || (this.H))
          continue;
        switch (d()[this.w.ordinal()])
        {
        default:
        case 2:
        }
      case 2:
        label380: for (this.F = (this.G + this.A); ; this.F = (this.G - this.A))
        {
          this.H = true;
          this.Q.setAlpha(76);
          break;
          f2 = this.G - f1;
          break label380;
        }
        a(paramMotionEvent);
        continue;
        this.H = false;
        this.I = -1;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getMeasuredWidth();
    int i2 = getMeasuredHeight();
    if (getChildCount() == 0);
    do
    {
      return;
      if (this.v != null)
        continue;
      i();
    }
    while (this.v == null);
    View localView = this.v;
    int i3 = getPaddingLeft();
    int i4 = getPaddingTop();
    int i5 = i1 - getPaddingLeft() - getPaddingRight();
    int i6 = i2 - getPaddingTop() - getPaddingBottom();
    localView.layout(i3, i4, i5 + i3, i6 + i4);
    int i7 = this.N.getMeasuredWidth();
    int i8 = this.N.getMeasuredHeight();
    this.N.layout(i1 / 2 - i7 / 2, this.D, i1 / 2 + i7 / 2, i8 + this.D);
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.v == null)
      i();
    if (this.v == null)
      return;
    this.v.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.N.measure(View.MeasureSpec.makeMeasureSpec(this.ab, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ac, 1073741824));
    if ((!this.ad) && (!this.E))
      this.E = true;
    switch (d()[this.w.ordinal()])
    {
    default:
      int i3 = -this.N.getMeasuredHeight();
      this.d = i3;
      this.D = i3;
      label170: this.O = -1;
    case 2:
    }
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      if (getChildAt(i1) != this.N)
        continue;
      this.O = i1;
      return;
      int i2 = getMeasuredHeight();
      this.d = i2;
      this.D = i2;
      break label170;
    }
  }

  @SuppressLint({"NewApi"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((this.K) && (i1 == 0))
      this.K = false;
    switch (d()[this.w.ordinal()])
    {
    default:
      if ((isEnabled()) && (!this.K) && (!b()) && (!this.z))
        break;
      return false;
    case 2:
      if ((isEnabled()) && (!this.K) && (!c()) && (!this.z))
        break;
      return false;
    }
    switch (i1)
    {
    case 4:
    default:
    case 0:
    case 2:
    case 5:
    case 6:
      while (true)
      {
        return true;
        this.I = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.H = false;
        continue;
        int i2 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.I);
        if (i2 < 0)
          return false;
        float f3 = MotionEventCompat.getY(paramMotionEvent, i2);
        float f4;
        switch (d()[this.w.ordinal()])
        {
        default:
          f4 = 0.5F * (f3 - this.F);
        case 2:
        }
        float f5;
        while (this.H)
        {
          this.Q.a(true);
          f5 = f4 / this.B;
          if (f5 >= 0.0F)
            break label288;
          return false;
          f4 = 0.5F * (this.F - f3);
        }
        label288: float f6 = Math.min(1.0F, Math.abs(f5));
        float f7 = 5.0F * (float)Math.max(f6 - 0.4D, 0.0D) / 3.0F;
        float f8 = Math.abs(f4) - this.B;
        float f9;
        label352: float f11;
        float f12;
        int i3;
        if (this.ad)
        {
          f9 = this.W - this.d;
          float f10 = Math.max(0.0F, Math.min(f8, 2.0F * f9) / f9);
          f11 = 2.0F * (float)(f10 / 4.0F - Math.pow(f10 / 4.0F, 2.0D));
          f12 = 2.0F * (f9 * f11);
          if (this.w != p.a)
            break label615;
          i3 = this.d + (int)(f12 + f9 * f6);
          label431: if (this.N.getVisibility() != 0)
            this.N.setVisibility(0);
          if (!this.J)
          {
            ViewCompat.setScaleX(this.N, 1.0F);
            ViewCompat.setScaleY(this.N, 1.0F);
          }
          if (f4 >= this.B)
            break label634;
          if (this.J)
            setAnimationProgress(f4 / this.B);
          if ((this.Q.getAlpha() > 76) && (!a(this.T)))
            g();
          float f14 = 0.8F * f7;
          this.Q.a(0.0F, Math.min(0.8F, f14));
          this.Q.a(Math.min(1.0F, f7));
        }
        while (true)
        {
          float f13 = 0.5F * (-0.25F + 0.4F * f7 + 2.0F * f11);
          this.Q.b(f13);
          a(i3 - this.D, true);
          break;
          f9 = this.W;
          break label352;
          label615: i3 = this.d - (int)(f12 + f9 * f6);
          break label431;
          label634: if ((this.Q.getAlpha() >= 255) || (a(this.U)))
            continue;
          h();
        }
        this.I = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
        continue;
        a(paramMotionEvent);
      }
    case 1:
    case 3:
    }
    if (this.I == -1)
      return false;
    float f1 = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.I));
    float f2;
    switch (d()[this.w.ordinal()])
    {
    default:
      f2 = 0.5F * (f1 - this.F);
      this.H = false;
      if (f2 <= this.B)
        break;
      a(true, true);
    case 2:
    }
    while (true)
    {
      this.I = -1;
      return false;
      f2 = 0.5F * (this.F - f1);
      break;
      this.z = false;
      this.Q.a(0.0F, 0.0F);
      boolean bool = this.J;
      n localn = null;
      if (!bool)
        localn = new n(this);
      b(this.D, localn);
      this.Q.a(false);
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
  }

  @Deprecated
  public void setColorScheme(int[] paramArrayOfInt)
  {
    setColorSchemeResources(paramArrayOfInt);
  }

  public void setColorSchemeColors(int[] paramArrayOfInt)
  {
    i();
    this.Q.a(paramArrayOfInt);
  }

  public void setColorSchemeResources(int[] paramArrayOfInt)
  {
    Resources localResources = getResources();
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramArrayOfInt.length)
      {
        setColorSchemeColors(arrayOfInt);
        return;
      }
      arrayOfInt[i1] = localResources.getColor(paramArrayOfInt[i1]);
    }
  }

  public void setDirection(p paramp)
  {
    if (paramp == p.c)
      this.x = true;
    while (true)
      switch (d()[this.w.ordinal()])
      {
      default:
        int i2 = -this.N.getMeasuredHeight();
        this.d = i2;
        this.D = i2;
        return;
        this.x = false;
        this.w = paramp;
      case 2:
      }
    int i1 = getMeasuredHeight();
    this.d = i1;
    this.D = i1;
  }

  public void setDistanceToTriggerSync(int paramInt)
  {
    this.B = paramInt;
  }

  public void setOnRefreshListener(a parama)
  {
    this.y = parama;
  }

  public void setProgressBackgroundColor(int paramInt)
  {
    this.N.setBackgroundColor(paramInt);
    this.Q.b(getResources().getColor(paramInt));
  }

  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.z != paramBoolean))
    {
      this.z = paramBoolean;
      int i1;
      if (!this.ad)
        switch (d()[this.w.ordinal()])
        {
        default:
          i1 = (int)(this.W - Math.abs(this.d));
        case 2:
        }
      while (true)
      {
        a(i1 - this.D, true);
        this.aa = false;
        a(this.ae);
        return;
        i1 = getMeasuredHeight() - (int)this.W;
        continue;
        i1 = (int)this.W;
      }
    }
    a(paramBoolean, false);
  }

  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
      return;
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i2;
    if (paramInt == 0)
    {
      i2 = (int)(56.0F * localDisplayMetrics.density);
      this.ab = i2;
    }
    int i1;
    for (this.ac = i2; ; this.ac = i1)
    {
      this.N.setImageDrawable(null);
      this.Q.a(paramInt);
      this.N.setImageDrawable(this.Q);
      return;
      i1 = (int)(40.0F * localDisplayMetrics.density);
      this.ab = i1;
    }
  }

  public static abstract interface a
  {
    public abstract void a(p paramp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout
 * JD-Core Version:    0.6.0
 */