package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.a.a;

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView>
{
  public PullToRefreshExpandableListView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }

  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }

  protected ExpandableListView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new b(paramContext, paramAttributeSet); ; localObject = new a(paramContext, paramAttributeSet))
    {
      ((ExpandableListView)localObject).setId(16908298);
      return localObject;
    }
  }

  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.a;
  }

  class a extends ExpandableListView
    implements a
  {
    public a(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    public void setEmptyView(View paramView)
    {
      PullToRefreshExpandableListView.this.setEmptyView(paramView);
    }

    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }

  @TargetApi(9)
  final class b extends PullToRefreshExpandableListView.a
  {
    public b(Context paramAttributeSet, AttributeSet arg3)
    {
      super(paramAttributeSet, localAttributeSet);
    }

    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshExpandableListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshExpandableListView
 * JD-Core Version:    0.6.0
 */