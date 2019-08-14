package com.handmark.pulltorefresh.library;

import android.view.View;
import android.view.animation.Interpolator;

public abstract interface b<T extends View>
{
  public abstract a a(boolean paramBoolean1, boolean paramBoolean2);

  public abstract boolean a();

  public abstract boolean b();

  public abstract boolean c();

  public abstract boolean d();

  public abstract boolean e();

  public abstract void f();

  public abstract void g();

  public abstract PullToRefreshBase.b getCurrentMode();

  public abstract boolean getFilterTouchEvents();

  public abstract a getLoadingLayoutProxy();

  public abstract PullToRefreshBase.b getMode();

  public abstract T getRefreshableView();

  public abstract boolean getShowViewWhileRefreshing();

  public abstract PullToRefreshBase.j getState();

  public abstract void setFilterTouchEvents(boolean paramBoolean);

  public abstract void setMode(PullToRefreshBase.b paramb);

  public abstract void setOnPullEventListener(PullToRefreshBase.d<T> paramd);

  public abstract void setOnRefreshListener(PullToRefreshBase.e<T> parame);

  public abstract void setOnRefreshListener(PullToRefreshBase.f<T> paramf);

  public abstract void setPullToRefreshOverScrollEnabled(boolean paramBoolean);

  public abstract void setRefreshing(boolean paramBoolean);

  public abstract void setScrollAnimationInterpolator(Interpolator paramInterpolator);

  public abstract void setScrollingWhileRefreshingEnabled(boolean paramBoolean);

  public abstract void setShowViewWhileRefreshing(boolean paramBoolean);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.b
 * JD-Core Version:    0.6.0
 */