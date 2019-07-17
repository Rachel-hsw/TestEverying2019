package com.withustudy.koudaizikao.custom;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public abstract class s extends BaseAdapter
  implements WrapperListAdapter
{
  protected ListAdapter b;

  public s(ListAdapter paramListAdapter)
  {
    this.b = paramListAdapter;
  }

  public boolean areAllItemsEnabled()
  {
    return this.b.areAllItemsEnabled();
  }

  public int getCount()
  {
    return this.b.getCount();
  }

  public Object getItem(int paramInt)
  {
    return this.b.getItem(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.b.getItemId(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return this.b.getItemViewType(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.b.getView(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return this.b.getViewTypeCount();
  }

  public ListAdapter getWrappedAdapter()
  {
    return this.b;
  }

  public boolean hasStableIds()
  {
    return this.b.hasStableIds();
  }

  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    return this.b.isEnabled(paramInt);
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.b.registerDataSetObserver(paramDataSetObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.b.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.s
 * JD-Core Version:    0.6.0
 */