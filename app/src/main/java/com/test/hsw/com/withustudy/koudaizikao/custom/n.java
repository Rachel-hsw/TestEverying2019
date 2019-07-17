package com.withustudy.koudaizikao.custom;

import android.view.View;
import android.widget.ListAdapter;

public class n extends AbstractSlideExpandableListAdapter
{
  private int a;
  private int c;

  public n(ListAdapter paramListAdapter)
  {
    this(paramListAdapter, 2131296268, 2131296269);
  }

  public n(ListAdapter paramListAdapter, int paramInt1, int paramInt2)
  {
    super(paramListAdapter);
    this.a = paramInt1;
    this.c = paramInt2;
  }

  public View a(View paramView)
  {
    return paramView.findViewById(this.a);
  }

  public View b(View paramView)
  {
    return paramView.findViewById(this.c);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.n
 * JD-Core Version:    0.6.0
 */