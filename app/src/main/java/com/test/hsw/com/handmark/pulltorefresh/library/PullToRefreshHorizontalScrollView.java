package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView>
{
  public PullToRefreshHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }

  protected HorizontalScrollView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new a(paramContext, paramAttributeSet); ; localObject = new HorizontalScrollView(paramContext, paramAttributeSet))
    {
      ((HorizontalScrollView)localObject).setId(j.e.scrollview);
      return localObject;
    }
  }

  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.b;
  }

  protected boolean m()
  {
    return ((HorizontalScrollView)this.n).getScrollX() == 0;
  }

  protected boolean n()
  {
    View localView = ((HorizontalScrollView)this.n).getChildAt(0);
    if (localView != null)
      return ((HorizontalScrollView)this.n).getScrollX() >= localView.getWidth() - getWidth();
    return false;
  }

  @TargetApi(9)
  final class a extends HorizontalScrollView
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
        j = Math.max(0, getChildAt(0).getWidth() - (getWidth() - getPaddingLeft() - getPaddingRight()));
      return j;
    }

    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshHorizontalScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshHorizontalScrollView
 * JD-Core Version:    0.6.0
 */