package com.a.a.b.f;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.a.a.b.d;

public class c
  implements AbsListView.OnScrollListener
{
  private d a;
  private final boolean b;
  private final boolean c;
  private final AbsListView.OnScrollListener d;

  public c(d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramd, paramBoolean1, paramBoolean2, null);
  }

  public c(d paramd, boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a = paramd;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramOnScrollListener;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null)
      this.d.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      if (this.d != null)
        this.d.onScrollStateChanged(paramAbsListView, paramInt);
      return;
      this.a.j();
      continue;
      if (!this.b)
        continue;
      this.a.i();
      continue;
      if (!this.c)
        continue;
      this.a.i();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.f.c
 * JD-Core Version:    0.6.0
 */