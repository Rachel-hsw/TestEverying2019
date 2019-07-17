package com.gensee.view.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

public abstract class XListView extends ListView
  implements AbsListView.OnScrollListener
{
  private static final float OFFSET_RADIO = 1.8F;
  private static final int PULL_LOAD_MORE_DELTA = 50;
  private static final int SCROLLBACK_FOOTER = 1;
  private static final int SCROLLBACK_HEADER = 0;
  private static final int SCROLL_DURATION = 400;
  private boolean mEnablePullLoad;
  private boolean mEnablePullRefresh = true;
  private XListViewFooter mFooterView;
  private TextView mHeaderTimeView;
  private XListViewHeader mHeaderView;
  private RelativeLayout mHeaderViewContent;
  private int mHeaderViewHeight;
  private boolean mIsFooterReady = false;
  private float mLastY = -1.0F;
  private IXListViewListener mListViewListener;
  private boolean mPullLoading;
  private boolean mPullRefreshing = false;
  private int mScrollBack;
  private AbsListView.OnScrollListener mScrollListener;
  private Scroller mScroller;
  private int mTotalItemCount;

  public XListView(Context paramContext)
  {
    super(paramContext);
    initWithContext(paramContext);
  }

  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initWithContext(paramContext);
  }

  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initWithContext(paramContext);
  }

  private void initWithContext(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
    super.setOnScrollListener(this);
    this.mHeaderView = getHeaderView(paramContext);
    this.mHeaderViewContent = ((RelativeLayout)this.mHeaderView.findViewById(getHeadContentTvId()));
    this.mHeaderTimeView = ((TextView)this.mHeaderView.findViewById(getHeadTimeTvId()));
    addHeaderView(this.mHeaderView);
    this.mFooterView = getFooterView(paramContext);
    this.mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new XListView.1(this));
  }

  private void invokeOnScrolling()
  {
    if ((this.mScrollListener instanceof OnXScrollListener))
      ((OnXScrollListener)this.mScrollListener).onXScrolling(this);
  }

  private void resetFooterHeight()
  {
    int i = this.mFooterView.getBottomMargin();
    if (i > 0)
    {
      this.mScrollBack = 1;
      this.mScroller.startScroll(0, i, 0, -i, 400);
      invalidate();
    }
  }

  private void resetHeaderHeight()
  {
    int i = this.mHeaderView.getVisiableHeight();
    if (i == 0);
    do
      return;
    while ((this.mPullRefreshing) && (i <= this.mHeaderViewHeight));
    if ((this.mPullRefreshing) && (i > this.mHeaderViewHeight));
    for (int j = this.mHeaderViewHeight; ; j = 0)
    {
      this.mScrollBack = 0;
      this.mScroller.startScroll(0, i, 0, j - i, 400);
      invalidate();
      return;
    }
  }

  private void startLoadMore()
  {
    this.mPullLoading = true;
    if (this.mFooterView != null)
      this.mFooterView.setState(2);
    if (this.mListViewListener != null)
      this.mListViewListener.onLoadMore();
  }

  private void updateFooterHeight(float paramFloat)
  {
    int i = this.mFooterView.getBottomMargin() + (int)paramFloat;
    if ((this.mEnablePullLoad) && (!this.mPullLoading))
    {
      if (i <= 50)
        break label48;
      this.mFooterView.setState(1);
    }
    while (true)
    {
      this.mFooterView.setBottomMargin(i);
      return;
      label48: this.mFooterView.setState(0);
    }
  }

  private void updateHeaderHeight(float paramFloat)
  {
    this.mHeaderView.setVisiableHeight((int)paramFloat + this.mHeaderView.getVisiableHeight());
    if ((this.mEnablePullRefresh) && (!this.mPullRefreshing))
    {
      if (this.mHeaderView.getVisiableHeight() <= this.mHeaderViewHeight)
        break label59;
      this.mHeaderView.setState(1);
    }
    while (true)
    {
      setSelection(0);
      return;
      label59: this.mHeaderView.setState(0);
    }
  }

  public void addFootView()
  {
    if (getFooterViewsCount() >= 1);
    do
      return;
    while (this.mFooterView == null);
    addFooterView(this.mFooterView);
  }

  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      if (this.mScrollBack != 0)
        break label44;
      this.mHeaderView.setVisiableHeight(this.mScroller.getCurrY());
    }
    while (true)
    {
      postInvalidate();
      invokeOnScrolling();
      super.computeScroll();
      return;
      label44: this.mFooterView.setBottomMargin(this.mScroller.getCurrY());
    }
  }

  protected abstract XListViewFooter getFooterView(Context paramContext);

  protected abstract int getHeadContentTvId();

  protected abstract int getHeadTimeTvId();

  protected abstract XListViewHeader getHeaderView(Context paramContext);

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalItemCount = paramInt3;
    if (this.mScrollListener != null)
      this.mScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mScrollListener != null)
      this.mScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLastY == -1.0F)
      this.mLastY = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
      this.mLastY = -1.0F;
      if (getFirstVisiblePosition() != 0)
        break;
      if ((this.mEnablePullRefresh) && (this.mHeaderView.getVisiableHeight() > this.mHeaderViewHeight))
      {
        this.mPullRefreshing = true;
        this.mHeaderView.setState(2);
        if (this.mListViewListener != null)
          this.mListViewListener.onRefresh();
      }
      resetHeaderHeight();
    case 0:
    case 2:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mLastY = paramMotionEvent.getRawY();
      continue;
      float f = paramMotionEvent.getRawY() - this.mLastY;
      this.mLastY = paramMotionEvent.getRawY();
      if ((getFirstVisiblePosition() == 0) && ((this.mHeaderView.getVisiableHeight() > 0) || (f > 0.0F)))
      {
        updateHeaderHeight(f / 1.8F);
        invokeOnScrolling();
        continue;
      }
      if ((getLastVisiblePosition() != -1 + this.mTotalItemCount) || ((this.mFooterView.getBottomMargin() <= 0) && (f >= 0.0F)))
        continue;
      updateFooterHeight(-f / 1.8F);
      continue;
      if (getLastVisiblePosition() != -1 + this.mTotalItemCount)
        continue;
      if ((this.mEnablePullLoad) && (this.mFooterView.getBottomMargin() > 50) && (!this.mPullLoading))
        startLoadMore();
      resetFooterHeight();
    }
  }

  public void removeFootView()
  {
    if (getFooterViewsCount() <= 0);
    do
      return;
    while (this.mFooterView == null);
    removeFooterView(this.mFooterView);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }

  public void setPullLoadEnable(boolean paramBoolean)
  {
    this.mEnablePullLoad = paramBoolean;
    if (!this.mEnablePullLoad)
    {
      this.mFooterView.hide();
      this.mFooterView.setOnClickListener(null);
      return;
    }
    this.mPullLoading = false;
    this.mFooterView.show();
    this.mFooterView.setState(0);
    this.mFooterView.setOnClickListener(new XListView.2(this));
  }

  public void setPullRefreshEnable(boolean paramBoolean)
  {
    this.mEnablePullRefresh = paramBoolean;
    if (!this.mEnablePullRefresh)
    {
      this.mHeaderViewContent.setVisibility(4);
      return;
    }
    this.mHeaderViewContent.setVisibility(0);
  }

  public void setRefreshTime(String paramString)
  {
    this.mHeaderTimeView.setText(paramString);
  }

  public void setXListViewListener(IXListViewListener paramIXListViewListener)
  {
    this.mListViewListener = paramIXListViewListener;
  }

  public void stopLoadMore()
  {
    if (this.mPullLoading)
    {
      this.mPullLoading = false;
      this.mFooterView.setState(0);
    }
  }

  public void stopRefresh()
  {
    if (this.mPullRefreshing)
    {
      this.mPullRefreshing = false;
      resetHeaderHeight();
    }
  }

  public static abstract interface IXListViewListener
  {
    public abstract void onLoadMore();

    public abstract void onRefresh();
  }

  public static abstract interface OnXScrollListener extends AbsListView.OnScrollListener
  {
    public abstract void onXScrolling(View paramView);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.xlistview.XListView
 * JD-Core Version:    0.6.0
 */