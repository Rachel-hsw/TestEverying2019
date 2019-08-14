package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;

public class ActionSlideExpandableListView extends SlideExpandableListView
{
  private a a;
  private int[] b = null;

  public ActionSlideExpandableListView(Context paramContext)
  {
    super(paramContext);
  }

  public ActionSlideExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ActionSlideExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(a parama, int[] paramArrayOfInt)
  {
    this.a = parama;
    this.b = paramArrayOfInt;
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(new e(this, paramListAdapter));
  }

  public static abstract interface a
  {
    public abstract void a(View paramView1, View paramView2, int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.ActionSlideExpandableListView
 * JD-Core Version:    0.6.0
 */