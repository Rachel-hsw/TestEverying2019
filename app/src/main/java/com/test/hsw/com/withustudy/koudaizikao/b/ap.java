package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

public class ap extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  private List<Object> c;
  private Context d;

  public ap(List<Object> paramList, Context paramContext)
  {
    this.c = paramList;
    this.d = paramContext;
  }

  public int getCount()
  {
    return this.c.size();
  }

  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt % 4 == 0)
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
      switch (i)
      {
      default:
      case 0:
      case 1:
      }
    while (true)
    {
      switch (i)
      {
      case 0:
      case 1:
      }
      return paramView;
      paramView = LayoutInflater.from(this.d).inflate(2130903219, null);
      paramView.setTag(new a());
      continue;
      paramView = LayoutInflater.from(this.d).inflate(2130903220, null);
      paramView.setTag(new b());
      continue;
      switch (i)
      {
      default:
        break;
      case 0:
        ((a)paramView.getTag());
        break;
      case 1:
        ((b)paramView.getTag());
      }
    }
  }

  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }

  class a
  {
    public TextView a;
    public TextView b;

    a()
    {
    }
  }

  class b
  {
    public TextView a;
    public TextView b;
    public RelativeLayout c;
    public TextView d;
    public Button e;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ap
 * JD-Core Version:    0.6.0
 */