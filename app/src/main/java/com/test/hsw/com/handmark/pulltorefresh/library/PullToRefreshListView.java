package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.a.a;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView>
{
  private com.handmark.pulltorefresh.library.a.d o;
  private com.handmark.pulltorefresh.library.a.d p;
  private FrameLayout q;
  private boolean r;

  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshListView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }

  public PullToRefreshListView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }

  protected void a(TypedArray paramTypedArray)
  {
    super.a(paramTypedArray);
    this.r = paramTypedArray.getBoolean(j.h.PullToRefresh_ptrListViewExtrasEnabled, true);
    if (this.r)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      this.o = a(getContext(), PullToRefreshBase.b.b, paramTypedArray);
      this.o.setVisibility(8);
      localFrameLayout.addView(this.o, localLayoutParams);
      ((ListView)this.n).addHeaderView(localFrameLayout, null, false);
      this.q = new FrameLayout(getContext());
      this.p = a(getContext(), PullToRefreshBase.b.c, paramTypedArray);
      this.p.setVisibility(8);
      this.q.addView(this.p, localLayoutParams);
      if (!paramTypedArray.hasValue(j.h.PullToRefresh_ptrScrollingWhileRefreshingEnabled))
        setScrollingWhileRefreshingEnabled(true);
    }
  }

  protected void a(boolean paramBoolean)
  {
    ListAdapter localListAdapter = ((ListView)this.n).getAdapter();
    if ((!this.r) || (!getShowViewWhileRefreshing()) || (localListAdapter == null) || (localListAdapter.isEmpty()))
    {
      super.a(paramBoolean);
      return;
    }
    super.a(false);
    int j;
    com.handmark.pulltorefresh.library.a.d locald1;
    com.handmark.pulltorefresh.library.a.d locald2;
    com.handmark.pulltorefresh.library.a.d locald3;
    int i;
    switch (w()[getCurrentMode().ordinal()])
    {
    case 4:
    default:
      com.handmark.pulltorefresh.library.a.d locald4 = getHeaderLayout();
      com.handmark.pulltorefresh.library.a.d locald5 = this.o;
      com.handmark.pulltorefresh.library.a.d locald6 = this.p;
      j = getScrollY() + getHeaderSize();
      locald1 = locald4;
      locald2 = locald5;
      locald3 = locald6;
      i = 0;
    case 3:
    case 5:
    }
    while (true)
    {
      locald1.j();
      locald1.f();
      locald3.setVisibility(8);
      locald2.setVisibility(0);
      locald2.h();
      if (!paramBoolean)
        break;
      r();
      setHeaderScroll(j);
      ((ListView)this.n).setSelection(i);
      a(0);
      return;
      locald1 = getFooterLayout();
      locald2 = this.p;
      locald3 = this.o;
      i = -1 + ((ListView)this.n).getCount();
      j = getScrollY() - getFooterSize();
    }
  }

  protected ListView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9)
      return new b(paramContext, paramAttributeSet);
    return new a(paramContext, paramAttributeSet);
  }

  protected c b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = super.b(paramBoolean1, paramBoolean2);
    if (this.r)
    {
      PullToRefreshBase.b localb = getMode();
      if ((paramBoolean1) && (localb.c()))
        localc.a(this.o);
      if ((paramBoolean2) && (localb.d()))
        localc.a(this.p);
    }
    return localc;
  }

  protected ListView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    ListView localListView = b(paramContext, paramAttributeSet);
    localListView.setId(16908298);
    return localListView;
  }

  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.a;
  }

  protected void l()
  {
    int i = 0;
    int j = 1;
    if (!this.r)
    {
      super.l();
      return;
    }
    com.handmark.pulltorefresh.library.a.d locald3;
    com.handmark.pulltorefresh.library.a.d locald4;
    int i2;
    switch (w()[getCurrentMode().ordinal()])
    {
    case 4:
    default:
      locald3 = getHeaderLayout();
      locald4 = this.o;
      i2 = -getHeaderSize();
      if (Math.abs(((ListView)this.n).getFirstVisiblePosition() - 0) > j)
        break;
    case 3:
    case 5:
    }
    while (true)
    {
      int n = j;
      int i1 = i2;
      Object localObject1 = locald4;
      Object localObject2 = locald3;
      if (((com.handmark.pulltorefresh.library.a.d)localObject1).getVisibility() == 0)
      {
        ((com.handmark.pulltorefresh.library.a.d)localObject2).k();
        ((com.handmark.pulltorefresh.library.a.d)localObject1).setVisibility(8);
        if ((n != 0) && (getState() != PullToRefreshBase.j.e))
        {
          ((ListView)this.n).setSelection(i);
          setHeaderScroll(i1);
        }
      }
      super.l();
      return;
      com.handmark.pulltorefresh.library.a.d locald1 = getFooterLayout();
      com.handmark.pulltorefresh.library.a.d locald2 = this.p;
      int k = -1 + ((ListView)this.n).getCount();
      int m = getFooterSize();
      if (Math.abs(((ListView)this.n).getLastVisiblePosition() - k) <= j);
      for (n = j; ; n = 0)
      {
        i = k;
        i1 = m;
        localObject1 = locald2;
        localObject2 = locald1;
        break;
      }
      j = 0;
    }
  }

  protected class a extends ListView
    implements a
  {
    private boolean b = false;

    public a(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
      }
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
      }
      return false;
    }

    public void setAdapter(ListAdapter paramListAdapter)
    {
      if ((PullToRefreshListView.a(PullToRefreshListView.this) != null) && (!this.b))
      {
        addFooterView(PullToRefreshListView.a(PullToRefreshListView.this), null, false);
        this.b = true;
      }
      super.setAdapter(paramListAdapter);
    }

    public void setEmptyView(View paramView)
    {
      PullToRefreshListView.this.setEmptyView(paramView);
    }

    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }

  @TargetApi(9)
  final class b extends PullToRefreshListView.a
  {
    public b(Context paramAttributeSet, AttributeSet arg3)
    {
      super(paramAttributeSet, localAttributeSet);
    }

    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshListView
 * JD-Core Version:    0.6.0
 */