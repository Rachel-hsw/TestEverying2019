package com.gensee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AbstractAdapter extends BaseAdapter
{
  protected Context context;

  public AbstractAdapter(Context paramContext)
  {
    this.context = paramContext;
  }

  protected abstract View createView(LayoutInflater paramLayoutInflater);

  protected abstract AbstractViewHolder createViewHolder(View paramView);

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbstractViewHolder localAbstractViewHolder;
    if (paramView == null)
    {
      paramView = createView(LayoutInflater.from(paramViewGroup.getContext()));
      localAbstractViewHolder = createViewHolder(paramView);
      paramView.setTag(localAbstractViewHolder);
    }
    while (true)
    {
      localAbstractViewHolder.init(paramInt);
      return paramView;
      localAbstractViewHolder = (AbstractViewHolder)paramView.getTag();
    }
  }

  protected abstract class AbstractViewHolder
  {
    protected AbstractViewHolder()
    {
    }

    public abstract void init(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.adapter.AbstractAdapter
 * JD-Core Version:    0.6.0
 */