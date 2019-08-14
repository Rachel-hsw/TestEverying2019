package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.Video;
import java.util.List;

public class an extends BaseAdapter
{
  private List<Video> a;
  private Context b;

  public an(List<Video> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130903218, null);
      locala = new a();
      locala.a = ((TextView)paramView.findViewById(2131297374));
      locala.b = ((TextView)paramView.findViewById(2131297375));
      locala.c = ((TextView)paramView.findViewById(2131297376));
      paramView.setTag(locala);
    }
    while (true)
    {
      locala.a.setText(String.valueOf(paramInt + 1));
      locala.b.setText(((Video)this.a.get(paramInt)).getVideo_name());
      locala.c.setText(((Video)this.a.get(paramInt)).getLive_time());
      return paramView;
      locala = (a)paramView.getTag();
    }
  }

  class a
  {
    public TextView a;
    public TextView b;
    public TextView c;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.an
 * JD-Core Version:    0.6.0
 */