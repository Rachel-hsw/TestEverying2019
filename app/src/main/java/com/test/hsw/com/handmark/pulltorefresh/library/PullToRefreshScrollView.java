package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView>
{
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }

  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }

  protected ScrollView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new a(paramContext, paramAttributeSet); ; localObject = new ScrollView(paramContext, paramAttributeSet))
    {
      ((ScrollView)localObject).setId(j.e.scrollview);
      return localObject;
    }
  }

  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.a;
  }

  protected boolean m()
  {
    return ((ScrollView)this.n).getScrollY() == 0;
  }

  protected boolean n()
  {
    View localView = ((ScrollView)this.n).getChildAt(0);
    if (localView != null)
      return ((ScrollView)this.n).getScrollY() >= localView.getHeight() - getHeight();
    return false;
  }

  @TargetApi(9)
  final class a extends ScrollView
  {
    public a(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    private int a()
    {
      int i = getChildCount();
      int j = 0;
      if (i > 0)
        j = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
      return j;
    }

    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshScrollView
 * JD-Core Version:    0.6.0
 */