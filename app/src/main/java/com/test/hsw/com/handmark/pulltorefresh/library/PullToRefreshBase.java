package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout
  implements b<T>
{
  static final boolean a = true;
  static final boolean b = false;
  static final String c = "PullToRefresh";
  static final float d = 2.0F;
  public static final int e = 200;
  public static final int f = 325;
  static final int g = 225;
  static final String h = "ptr_state";
  static final String i = "ptr_mode";
  static final String j = "ptr_current_mode";
  static final String k = "ptr_disable_scrolling";
  static final String l = "ptr_show_refreshing_view";
  static final String m = "ptr_super";
  private boolean A = true;
  private boolean B = true;
  private boolean C = true;
  private Interpolator D;
  private a E = a.a();
  private com.handmark.pulltorefresh.library.a.d F;
  private com.handmark.pulltorefresh.library.a.d G;
  private e<T> H;
  private f<T> I;
  private d<T> J;
  private PullToRefreshBase<T>.i K;
  T n;
  private int o;
  private float p;
  private float q;
  private float r;
  private float s;
  private boolean t = false;
  private j u = j.a;
  private b v = b.a();
  private b w;
  private FrameLayout x;
  private boolean y = true;
  private boolean z = false;

  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    b(paramContext, null);
  }

  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }

  public PullToRefreshBase(Context paramContext, b paramb)
  {
    super(paramContext);
    this.v = paramb;
    b(paramContext, null);
  }

  public PullToRefreshBase(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.v = paramb;
    this.E = parama;
    b(paramContext, null);
  }

  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }

  private final void a(int paramInt, long paramLong1, long paramLong2, g paramg)
  {
    if (this.K != null)
      this.K.a();
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
    case 2:
    }
    for (int i1 = getScrollY(); ; i1 = getScrollX())
    {
      if (i1 != paramInt)
      {
        if (this.D == null)
          this.D = new DecelerateInterpolator();
        this.K = new i(i1, paramInt, paramLong1, paramg);
        if (paramLong2 <= 0L)
          break;
        postDelayed(this.K, paramLong2);
      }
      return;
    }
    post(this.K);
  }

  private void a(Context paramContext, T paramT)
  {
    this.x = new FrameLayout(paramContext);
    this.x.addView(paramT, -1, -1);
    a(this.x, new LinearLayout.LayoutParams(-1, -1));
  }

  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      setOrientation(1);
      setGravity(17);
      this.o = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, j.h.PullToRefresh);
      if (localTypedArray.hasValue(j.h.PullToRefresh_ptrMode))
        this.v = b.a(localTypedArray.getInteger(j.h.PullToRefresh_ptrMode, 0));
      if (localTypedArray.hasValue(j.h.PullToRefresh_ptrAnimationStyle))
        this.E = a.a(localTypedArray.getInteger(j.h.PullToRefresh_ptrAnimationStyle, 0));
      this.n = a(paramContext, paramAttributeSet);
      a(paramContext, this.n);
      this.F = a(paramContext, b.b, localTypedArray);
      this.G = a(paramContext, b.c, localTypedArray);
      if (localTypedArray.hasValue(j.h.PullToRefresh_ptrRefreshableViewBackground))
      {
        Drawable localDrawable2 = localTypedArray.getDrawable(j.h.PullToRefresh_ptrRefreshableViewBackground);
        if (localDrawable2 == null)
          break;
        this.n.setBackgroundDrawable(localDrawable2);
      }
    case 2:
    }
    while (true)
    {
      if (localTypedArray.hasValue(j.h.PullToRefresh_ptrOverScroll))
        this.B = localTypedArray.getBoolean(j.h.PullToRefresh_ptrOverScroll, true);
      if (localTypedArray.hasValue(j.h.PullToRefresh_ptrScrollingWhileRefreshingEnabled))
        this.z = localTypedArray.getBoolean(j.h.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
      a(localTypedArray);
      localTypedArray.recycle();
      o();
      return;
      setOrientation(0);
      break;
      if (!localTypedArray.hasValue(j.h.PullToRefresh_ptrAdapterViewBackground))
        continue;
      com.handmark.pulltorefresh.library.a.f.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
      Drawable localDrawable1 = localTypedArray.getDrawable(j.h.PullToRefresh_ptrAdapterViewBackground);
      if (localDrawable1 == null)
        continue;
      this.n.setBackgroundDrawable(localDrawable1);
    }
  }

  private final void c(int paramInt)
  {
    a(paramInt, 200L, 0L, new g(this));
  }

  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
  {
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      return new LinearLayout.LayoutParams(-1, -2);
    case 2:
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }

  private int getMaximumPullScroll()
  {
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      return Math.round(getHeight() / 2.0F);
    case 2:
    }
    return Math.round(getWidth() / 2.0F);
  }

  private void h()
  {
    if (this.H != null)
      this.H.a(this);
    do
    {
      do
        return;
      while (this.I == null);
      if (this.w != b.b)
        continue;
      this.I.a(this);
      return;
    }
    while (this.w != b.c);
    this.I.b(this);
  }

  private boolean i()
  {
    switch (v()[this.v.ordinal()])
    {
    default:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return false;
      return m();
      return n();
    }
    while ((!n()) && (!m()));
    return true;
  }

  private void p()
  {
    float f1;
    float f2;
    int i1;
    int i2;
    label87: float f3;
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      f1 = this.s;
      f2 = this.q;
      switch (v()[this.w.ordinal()])
      {
      default:
        i1 = Math.round(Math.min(f1 - f2, 0.0F) / 2.0F);
        i2 = getHeaderSize();
        setHeaderScroll(i1);
        if ((i1 != 0) && (!d()))
        {
          f3 = Math.abs(i1) / i2;
          switch (v()[this.w.ordinal()])
          {
          default:
            this.F.b(f3);
            label153: if ((this.u != j.b) && (i2 >= Math.abs(i1)))
              a(j.b, new boolean[0]);
          case 3:
          }
        }
      case 3:
      }
    case 2:
    }
    do
    {
      return;
      f1 = this.r;
      f2 = this.p;
      break;
      i1 = Math.round(Math.max(f1 - f2, 0.0F) / 2.0F);
      i2 = getFooterSize();
      break label87;
      this.G.b(f3);
      break label153;
    }
    while ((this.u != j.b) || (i2 >= Math.abs(i1)));
    a(j.c, new boolean[0]);
  }

  protected abstract T a(Context paramContext, AttributeSet paramAttributeSet);

  protected com.handmark.pulltorefresh.library.a.d a(Context paramContext, b paramb, TypedArray paramTypedArray)
  {
    com.handmark.pulltorefresh.library.a.d locald = this.E.a(paramContext, paramb, getPullToRefreshScrollDirection(), paramTypedArray);
    locald.setVisibility(4);
    return locald;
  }

  public final a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramBoolean1, paramBoolean2);
  }

  protected final void a(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDuration());
  }

  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.x.getLayoutParams();
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
    case 2:
    case 1:
    }
    do
    {
      do
        return;
      while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.x.requestLayout();
      return;
    }
    while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.x.requestLayout();
  }

  protected final void a(int paramInt, g paramg)
  {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramg);
  }

  protected void a(TypedArray paramTypedArray)
  {
  }

  public void a(Drawable paramDrawable, b paramb)
  {
    a(paramb.c(), paramb.d()).setLoadingDrawable(paramDrawable);
  }

  protected void a(Bundle paramBundle)
  {
  }

  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }

  final void a(j paramj, boolean[] paramArrayOfBoolean)
  {
    this.u = paramj;
    Log.d("PullToRefresh", "State: " + this.u.name());
    switch (u()[this.u.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      if (this.J != null)
        this.J.a(this, this.u, this.w);
      return;
      l();
      continue;
      j();
      continue;
      k();
      continue;
      a(paramArrayOfBoolean[0]);
    }
  }

  public void a(CharSequence paramCharSequence, b paramb)
  {
    a(paramb.c(), paramb.d()).setPullLabel(paramCharSequence);
  }

  protected void a(boolean paramBoolean)
  {
    if (this.v.c())
      this.F.h();
    if (this.v.d())
      this.G.h();
    if (paramBoolean)
    {
      if (this.y)
      {
        e locale = new e(this);
        switch (v()[this.w.ordinal()])
        {
        case 4:
        default:
          a(-getHeaderSize(), locale);
          return;
        case 3:
        case 5:
        }
        a(getFooterSize(), locale);
        return;
      }
      a(0);
      return;
    }
    h();
  }

  public final boolean a()
  {
    if ((this.v.c()) && (m()))
    {
      c(2 * -getHeaderSize());
      return true;
    }
    if ((this.v.d()) && (n()))
    {
      c(2 * getFooterSize());
      return true;
    }
    return false;
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Log.d("PullToRefresh", "addView: " + paramView.getClass().getSimpleName());
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }

  protected c b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = new c();
    if ((paramBoolean1) && (this.v.c()))
      localc.a(this.F);
    if ((paramBoolean2) && (this.v.d()))
      localc.a(this.G);
    return localc;
  }

  protected final void b(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDurationLonger());
  }

  protected void b(Bundle paramBundle)
  {
  }

  public void b(CharSequence paramCharSequence, b paramb)
  {
    a(paramb.c(), paramb.d()).setRefreshingLabel(paramCharSequence);
  }

  public final boolean b()
  {
    return this.v.b();
  }

  public void c(CharSequence paramCharSequence, b paramb)
  {
    a(paramb.c(), paramb.d()).setReleaseLabel(paramCharSequence);
  }

  public final boolean c()
  {
    return (Build.VERSION.SDK_INT >= 9) && (this.B) && (d.a(this.n));
  }

  public final boolean d()
  {
    return (this.u == j.d) || (this.u == j.e);
  }

  public final boolean e()
  {
    return this.z;
  }

  public final void f()
  {
    if (d())
      a(j.a, new boolean[0]);
  }

  public final void g()
  {
    setRefreshing(true);
  }

  public final b getCurrentMode()
  {
    return this.w;
  }

  public final boolean getFilterTouchEvents()
  {
    return this.A;
  }

  protected final com.handmark.pulltorefresh.library.a.d getFooterLayout()
  {
    return this.G;
  }

  protected final int getFooterSize()
  {
    return this.G.getContentSize();
  }

  protected final com.handmark.pulltorefresh.library.a.d getHeaderLayout()
  {
    return this.F;
  }

  protected final int getHeaderSize()
  {
    return this.F.getContentSize();
  }

  public final a getLoadingLayoutProxy()
  {
    return a(true, true);
  }

  public final b getMode()
  {
    return this.v;
  }

  public abstract h getPullToRefreshScrollDirection();

  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }

  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }

  public final T getRefreshableView()
  {
    return this.n;
  }

  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.x;
  }

  public final boolean getShowViewWhileRefreshing()
  {
    return this.y;
  }

  public final j getState()
  {
    return this.u;
  }

  protected void j()
  {
    switch (v()[this.w.ordinal()])
    {
    default:
      return;
    case 3:
      this.G.g();
      return;
    case 2:
    }
    this.F.g();
  }

  protected void k()
  {
    switch (v()[this.w.ordinal()])
    {
    default:
      return;
    case 3:
      this.G.i();
      return;
    case 2:
    }
    this.F.i();
  }

  protected void l()
  {
    this.t = false;
    this.C = true;
    this.F.j();
    this.G.j();
    a(0);
  }

  protected abstract boolean m();

  protected abstract boolean n();

  protected void o()
  {
    LinearLayout.LayoutParams localLayoutParams = getLoadingLayoutLayoutParams();
    if (this == this.F.getParent())
      removeView(this.F);
    if (this.v.c())
      a(this.F, 0, localLayoutParams);
    if (this == this.G.getParent())
      removeView(this.G);
    if (this.v.d())
      a(this.G, localLayoutParams);
    s();
    if (this.v != b.d);
    for (b localb = this.v; ; localb = b.b)
    {
      this.w = localb;
      return;
    }
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b())
      return false;
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.t = false;
      return false;
    }
    if ((i1 != 0) && (this.t))
      return true;
    switch (i1)
    {
    case 1:
    default:
    case 2:
    case 0:
    }
    while (true)
    {
      return this.t;
      if ((!this.z) && (d()))
        return true;
      if (!i())
        continue;
      float f3 = paramMotionEvent.getY();
      float f4 = paramMotionEvent.getX();
      float f5;
      float f6;
      switch (t()[getPullToRefreshScrollDirection().ordinal()])
      {
      default:
        f5 = f3 - this.q;
        f6 = f4 - this.p;
      case 2:
      }
      while (true)
      {
        float f7 = Math.abs(f5);
        if ((f7 <= this.o) || ((this.A) && (f7 <= Math.abs(f6))))
          break;
        if ((!this.v.c()) || (f5 < 1.0F) || (!m()))
          break label276;
        this.q = f3;
        this.p = f4;
        this.t = true;
        if (this.v != b.d)
          break;
        this.w = b.b;
        break;
        f5 = f4 - this.p;
        f6 = f3 - this.q;
      }
      label276: if ((!this.v.d()) || (f5 > -1.0F) || (!n()))
        continue;
      this.q = f3;
      this.p = f4;
      this.t = true;
      if (this.v != b.d)
        continue;
      this.w = b.c;
      continue;
      if (!i())
        continue;
      float f1 = paramMotionEvent.getY();
      this.s = f1;
      this.q = f1;
      float f2 = paramMotionEvent.getX();
      this.r = f2;
      this.p = f2;
      this.t = false;
    }
  }

  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      setMode(b.a(localBundle.getInt("ptr_mode", 0)));
      this.w = b.a(localBundle.getInt("ptr_current_mode", 0));
      this.z = localBundle.getBoolean("ptr_disable_scrolling", false);
      this.y = localBundle.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(localBundle.getParcelable("ptr_super"));
      j localj = j.a(localBundle.getInt("ptr_state", 0));
      if ((localj == j.d) || (localj == j.e))
        a(localj, new boolean[] { true });
      a(localBundle);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    localBundle.putInt("ptr_state", this.u.a());
    localBundle.putInt("ptr_mode", this.v.e());
    localBundle.putInt("ptr_current_mode", this.w.e());
    localBundle.putBoolean("ptr_disable_scrolling", this.z);
    localBundle.putBoolean("ptr_show_refreshing_view", this.y);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }

  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    Log.d("PullToRefresh", String.format("onSizeChanged. W: %d, H: %d", arrayOfObject));
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    s();
    a(paramInt1, paramInt2);
    post(new f(this));
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b());
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!this.z) && (d()))
              return true;
          }
          while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default:
            return false;
          case 0:
          case 2:
          case 1:
          case 3:
          }
        }
        while (!i());
        float f1 = paramMotionEvent.getY();
        this.s = f1;
        this.q = f1;
        float f2 = paramMotionEvent.getX();
        this.r = f2;
        this.p = f2;
        return true;
      }
      while (!this.t);
      this.q = paramMotionEvent.getY();
      this.p = paramMotionEvent.getX();
      p();
      return true;
    }
    while (!this.t);
    this.t = false;
    if ((this.u == j.c) && ((this.H != null) || (this.I != null)))
    {
      a(j.d, new boolean[] { true });
      return true;
    }
    if (d())
    {
      a(0);
      return true;
    }
    a(j.a, new boolean[0]);
    return true;
  }

  public final boolean q()
  {
    return !e();
  }

  protected final void r()
  {
    this.C = false;
  }

  protected final void s()
  {
    int i1 = (int)(1.2F * getMaximumPullScroll());
    int i2 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i4 = getPaddingRight();
    int i5 = getPaddingBottom();
    int i10;
    int i7;
    int i9;
    int i8;
    switch (t()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      i10 = i5;
      i7 = i4;
      i9 = i3;
      i8 = i2;
    case 2:
    case 1:
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(i8);
      arrayOfObject[1] = Integer.valueOf(i9);
      arrayOfObject[2] = Integer.valueOf(i7);
      arrayOfObject[3] = Integer.valueOf(i10);
      Log.d("PullToRefresh", String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", arrayOfObject));
      setPadding(i8, i9, i7, i10);
      return;
      if (this.v.c())
        this.F.setWidth(i1);
      for (int i12 = -i1; ; i12 = 0)
      {
        if (!this.v.d())
          break label215;
        this.G.setWidth(i1);
        i7 = -i1;
        i9 = i3;
        i8 = i12;
        i10 = i5;
        break;
      }
      label215: i9 = i3;
      i8 = i12;
      i10 = i5;
      i7 = 0;
      continue;
      if (this.v.c())
        this.F.setHeight(i1);
      for (int i6 = -i1; ; i6 = 0)
      {
        if (!this.v.d())
          break label300;
        this.G.setHeight(i1);
        int i11 = -i1;
        i8 = i2;
        i9 = i6;
        i10 = i11;
        i7 = i4;
        break;
      }
      label300: i7 = i4;
      i8 = i2;
      i9 = i6;
      i10 = 0;
    }
  }

  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      setScrollingWhileRefreshingEnabled(bool);
      return;
    }
  }

  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  protected final void setHeaderScroll(int paramInt)
  {
    Log.d("PullToRefresh", "setHeaderScroll: " + paramInt);
    int i1 = getMaximumPullScroll();
    int i2 = Math.min(i1, Math.max(-i1, paramInt));
    if (this.C)
    {
      if (i2 >= 0)
        break label93;
      this.F.setVisibility(0);
    }
    while (true)
      switch (t()[getPullToRefreshScrollDirection().ordinal()])
      {
      default:
        return;
        label93: if (i2 > 0)
        {
          this.G.setVisibility(0);
          continue;
        }
        this.F.setVisibility(4);
        this.G.setVisibility(4);
      case 1:
      case 2:
      }
    scrollTo(0, i2);
    return;
    scrollTo(i2, 0);
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }

  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }

  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }

  public final void setMode(b paramb)
  {
    if (paramb != this.v)
    {
      Log.d("PullToRefresh", "Setting mode to: " + paramb);
      this.v = paramb;
      o();
    }
  }

  public void setOnPullEventListener(d<T> paramd)
  {
    this.J = paramd;
  }

  public final void setOnRefreshListener(e<T> parame)
  {
    this.H = parame;
    this.I = null;
  }

  public final void setOnRefreshListener(f<T> paramf)
  {
    this.I = paramf;
    this.H = null;
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }

  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean);
    for (b localb = b.a(); ; localb = b.a)
    {
      setMode(localb);
      return;
    }
  }

  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }

  public final void setRefreshing(boolean paramBoolean)
  {
    if (!d())
      a(j.e, new boolean[] { paramBoolean });
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    c(paramCharSequence, b.d);
  }

  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.D = paramInterpolator;
  }

  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      d = arrayOfa;
    }

    static a a()
    {
      return a;
    }

    static a a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return a;
      case 1:
      }
      return b;
    }

    com.handmark.pulltorefresh.library.a.d a(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
    {
      switch (b()[ordinal()])
      {
      default:
        return new com.handmark.pulltorefresh.library.a.e(paramContext, paramb, paramh, paramTypedArray);
      case 2:
      }
      return new com.handmark.pulltorefresh.library.a.b(paramContext, paramb, paramh, paramTypedArray);
    }
  }

  public static enum b
  {
    public static b f;
    public static b g;
    private int h;

    static
    {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      i = arrayOfb;
      f = b;
      g = c;
    }

    private b(int arg3)
    {
      int k;
      this.h = k;
    }

    static b a()
    {
      return b;
    }

    static b a(int paramInt)
    {
      b[] arrayOfb = values();
      int j = arrayOfb.length;
      for (int k = 0; ; k++)
      {
        b localb;
        if (k >= j)
          localb = a();
        do
        {
          return localb;
          localb = arrayOfb[k];
        }
        while (paramInt == localb.e());
      }
    }

    boolean b()
    {
      return (this != a) && (this != e);
    }

    public boolean c()
    {
      return (this == b) || (this == d);
    }

    public boolean d()
    {
      return (this == c) || (this == d) || (this == e);
    }

    int e()
    {
      return this.h;
    }
  }

  public static abstract interface c
  {
    public abstract void a();
  }

  public static abstract interface d<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.j paramj, PullToRefreshBase.b paramb);
  }

  public static abstract interface e<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);
  }

  public static abstract interface f<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);

    public abstract void b(PullToRefreshBase<V> paramPullToRefreshBase);
  }

  static abstract interface g
  {
    public abstract void a();
  }

  public static enum h
  {
    static
    {
      h[] arrayOfh = new h[2];
      arrayOfh[0] = a;
      arrayOfh[1] = b;
      c = arrayOfh;
    }
  }

  final class i
    implements Runnable
  {
    private final Interpolator b;
    private final int c;
    private final int d;
    private final long e;
    private PullToRefreshBase.g f;
    private boolean g = true;
    private long h = -1L;
    private int i = -1;

    public i(int paramInt1, int paramLong, long arg4, PullToRefreshBase.g arg6)
    {
      this.d = paramInt1;
      this.c = paramLong;
      this.b = PullToRefreshBase.a(PullToRefreshBase.this);
      this.e = ???;
      Object localObject;
      this.f = localObject;
    }

    public void a()
    {
      this.g = false;
      PullToRefreshBase.this.removeCallbacks(this);
    }

    public void run()
    {
      if (this.h == -1L)
      {
        this.h = System.currentTimeMillis();
        if ((!this.g) || (this.c == this.i))
          break label126;
        com.handmark.pulltorefresh.library.a.g.a(PullToRefreshBase.this, this);
      }
      label126: 
      do
      {
        return;
        long l = Math.max(Math.min(1000L * (System.currentTimeMillis() - this.h) / this.e, 1000L), 0L);
        int j = Math.round((this.d - this.c) * this.b.getInterpolation((float)l / 1000.0F));
        this.i = (this.d - j);
        PullToRefreshBase.this.setHeaderScroll(this.i);
        break;
      }
      while (this.f == null);
      this.f.a();
    }
  }

  public static enum j
  {
    private int g;

    static
    {
      j[] arrayOfj = new j[6];
      arrayOfj[0] = a;
      arrayOfj[1] = b;
      arrayOfj[2] = c;
      arrayOfj[3] = d;
      arrayOfj[4] = e;
      arrayOfj[5] = f;
      h = arrayOfj;
    }

    private j(int arg3)
    {
      int j;
      this.g = j;
    }

    static j a(int paramInt)
    {
      j[] arrayOfj = values();
      int i = arrayOfj.length;
      for (int j = 0; ; j++)
      {
        j localj;
        if (j >= i)
          localj = a;
        do
        {
          return localj;
          localj = arrayOfj[j];
        }
        while (paramInt == localj.a());
      }
    }

    int a()
    {
      return this.g;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshBase
 * JD-Core Version:    0.6.0
 */