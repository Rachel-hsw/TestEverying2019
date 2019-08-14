package com.withustudy.koudaizikao.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class a<T> extends BaseAdapter
{
  protected LayoutInflater a;
  protected Context b;
  protected List<T> c;
  protected final int d;

  public a(Context paramContext, List<T> paramList, int paramInt)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(this.b);
    this.c = paramList;
    this.d = paramInt;
  }

  private b a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return b.a(this.b, paramView, paramViewGroup, this.d, paramInt);
  }

  public abstract void a(b paramb, T paramT);

  public int getCount()
  {
    return this.c.size();
  }

  public T getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb = a(paramInt, paramView, paramViewGroup);
    a(localb, getItem(paramInt));
    return localb.a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.c.a
 * JD-Core Version:    0.6.0
 */