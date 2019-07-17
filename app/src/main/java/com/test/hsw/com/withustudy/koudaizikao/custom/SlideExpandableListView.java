package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

class SlideExpandableListView extends ListView
{
  private n a;

  public SlideExpandableListView(Context paramContext)
  {
    super(paramContext);
  }

  public SlideExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SlideExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a()
  {
    setOnItemClickListener(new o(this));
  }

  public void a(ListAdapter paramListAdapter, int paramInt1, int paramInt2)
  {
    this.a = new n(paramListAdapter, paramInt1, paramInt2);
    super.setAdapter(this.a);
  }

  public boolean b()
  {
    if (this.a != null)
      return this.a.d();
    return false;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof AbstractSlideExpandableListAdapter.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    AbstractSlideExpandableListAdapter.SavedState localSavedState = (AbstractSlideExpandableListAdapter.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.a.a(localSavedState);
  }

  public Parcelable onSaveInstanceState()
  {
    return this.a.a(super.onSaveInstanceState());
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.a = new n(paramListAdapter);
    super.setAdapter(this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.SlideExpandableListView
 * JD-Core Version:    0.6.0
 */