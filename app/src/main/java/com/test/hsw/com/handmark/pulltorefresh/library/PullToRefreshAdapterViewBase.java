package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.a.a;
import com.handmark.pulltorefresh.library.a.c;
import com.handmark.pulltorefresh.library.a.d;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private boolean o;
  private AbsListView.OnScrollListener p;
  private PullToRefreshBase.c q;
  private View r;
  private c s;
  private c t;
  private boolean u;
  private boolean v = true;

  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.n).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.n).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
    ((AbsListView)this.n).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
    ((AbsListView)this.n).setOnScrollListener(this);
  }

  private void A()
  {
    if (this.s != null)
    {
      if ((d()) || (!m()))
        break label77;
      if (!this.s.a())
        this.s.c();
    }
    label77: 
    do
      while (true)
      {
        if (this.t != null)
        {
          if ((d()) || (!n()))
            break;
          if (!this.t.a())
            this.t.c();
        }
        return;
        if (!this.s.a())
          continue;
        this.s.b();
      }
    while (!this.t.a());
    this.t.b();
  }

  private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout.LayoutParams localLayoutParams = null;
    if (paramLayoutParams != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
        localLayoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
    }
    else
    {
      return localLayoutParams;
    }
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }

  private boolean getShowIndicatorInternal()
  {
    return (this.u) && (b());
  }

  private void w()
  {
    PullToRefreshBase.b localb = getMode();
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    if ((localb.c()) && (this.s == null))
    {
      this.s = new c(getContext(), PullToRefreshBase.b.b);
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams2.rightMargin = getResources().getDimensionPixelSize(j.c.indicator_right_padding);
      localLayoutParams2.gravity = 53;
      localFrameLayout.addView(this.s, localLayoutParams2);
    }
    do
      while ((localb.d()) && (this.t == null))
      {
        this.t = new c(getContext(), PullToRefreshBase.b.c);
        FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams1.rightMargin = getResources().getDimensionPixelSize(j.c.indicator_right_padding);
        localLayoutParams1.gravity = 85;
        localFrameLayout.addView(this.t, localLayoutParams1);
        return;
        if ((localb.c()) || (this.s == null))
          continue;
        localFrameLayout.removeView(this.s);
        this.s = null;
      }
    while ((localb.d()) || (this.t == null));
    localFrameLayout.removeView(this.t);
    this.t = null;
  }

  private boolean x()
  {
    Adapter localAdapter = ((AbsListView)this.n).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
      return true;
    }
    if (((AbsListView)this.n).getFirstVisiblePosition() <= 1)
    {
      View localView = ((AbsListView)this.n).getChildAt(0);
      if (localView != null)
        return localView.getTop() >= ((AbsListView)this.n).getTop();
    }
    return false;
  }

  private boolean y()
  {
    Adapter localAdapter = ((AbsListView)this.n).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
      return true;
    }
    int i = -1 + ((AbsListView)this.n).getCount();
    int j = ((AbsListView)this.n).getLastVisiblePosition();
    Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + i + " Last Visible Pos: " + j);
    if (j >= i - 1)
    {
      int k = j - ((AbsListView)this.n).getFirstVisiblePosition();
      View localView = ((AbsListView)this.n).getChildAt(k);
      if (localView != null)
        return localView.getBottom() <= ((AbsListView)this.n).getBottom();
    }
    return false;
  }

  private void z()
  {
    if (this.s != null)
    {
      getRefreshableViewWrapper().removeView(this.s);
      this.s = null;
    }
    if (this.t != null)
    {
      getRefreshableViewWrapper().removeView(this.t);
      this.t = null;
    }
  }

  protected void a(TypedArray paramTypedArray)
  {
    int i = j.h.PullToRefresh_ptrShowIndicator;
    if (c());
    for (boolean bool = false; ; bool = true)
    {
      this.u = paramTypedArray.getBoolean(i, bool);
      return;
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (getShowIndicatorInternal())
      A();
  }

  public boolean getShowIndicator()
  {
    return this.u;
  }

  public boolean h()
  {
    return getHeaderLayout().isShown();
  }

  public boolean i()
  {
    return getFooterLayout().isShown();
  }

  protected void j()
  {
    super.j();
    if (getShowIndicatorInternal());
    switch (p()[getCurrentMode().ordinal()])
    {
    default:
      return;
    case 3:
      this.t.e();
      return;
    case 2:
    }
    this.s.e();
  }

  protected void k()
  {
    super.k();
    if (getShowIndicatorInternal());
    switch (p()[getCurrentMode().ordinal()])
    {
    default:
      return;
    case 3:
      this.t.d();
      return;
    case 2:
    }
    this.s.d();
  }

  protected void l()
  {
    super.l();
    if (getShowIndicatorInternal())
      A();
  }

  protected boolean m()
  {
    return x();
  }

  protected boolean n()
  {
    return y();
  }

  protected void o()
  {
    super.o();
    if (getShowIndicatorInternal())
    {
      w();
      return;
    }
    z();
  }

  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("PullToRefresh", "First Visible: " + paramInt1 + ". Visible Count: " + paramInt2 + ". Total Items:" + paramInt3);
    if (this.q != null)
      if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1))
        break label108;
    label108: for (boolean bool = true; ; bool = false)
    {
      this.o = bool;
      if (getShowIndicatorInternal())
        A();
      if (this.p != null)
        this.p.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
    }
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.r != null) && (!this.v))
      this.r.scrollTo(-paramInt1, -paramInt2);
  }

  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.q != null) && (this.o))
      this.q.a();
    if (this.p != null)
      this.p.onScrollStateChanged(paramAbsListView, paramInt);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.n).setAdapter(paramListAdapter);
  }

  public final void setEmptyView(View paramView)
  {
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    if (paramView != null)
    {
      paramView.setClickable(true);
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(paramView);
      FrameLayout.LayoutParams localLayoutParams = a(paramView.getLayoutParams());
      if (localLayoutParams != null)
        localFrameLayout.addView(paramView, localLayoutParams);
    }
    else
    {
      if (!(this.n instanceof a))
        break label96;
      ((a)this.n).setEmptyViewInternal(paramView);
    }
    while (true)
    {
      this.r = paramView;
      return;
      localFrameLayout.addView(paramView);
      break;
      label96: ((AbsListView)this.n).setEmptyView(paramView);
    }
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.n).setOnItemClickListener(paramOnItemClickListener);
  }

  public final void setOnLastItemVisibleListener(PullToRefreshBase.c paramc)
  {
    this.q = paramc;
  }

  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.p = paramOnScrollListener;
  }

  public final void setScrollEmptyView(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public void setShowIndicator(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (getShowIndicatorInternal())
    {
      w();
      return;
    }
    z();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase
 * JD-Core Version:    0.6.0
 */