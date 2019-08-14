package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Province;
import java.util.List;

public class g extends BaseAdapter
{
  private Context a;
  private List<Province> b;
  private int c;

  public g(Context paramContext, List<Province> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
  }

  public int a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903184, null);
      localTextView2 = (TextView)paramView.findViewById(2131297176);
      paramView.setTag(localTextView2);
    }
    for (TextView localTextView1 = localTextView2; ; localTextView1 = (TextView)paramView.getTag())
    {
      localTextView1.setLayoutParams(new AbsListView.LayoutParams((int)(f.a(this.a).y() - 159.0F * f.a(this.a).z() / 160.0F) / 4, (int)(f.a(this.a).y() - 159.0F * f.a(this.a).z() / 160.0F) / 4));
      String str = ((Province)this.b.get(paramInt)).getProvName();
      localTextView1.setText(str.substring(0, -1 + str.length()));
      if (paramInt != this.c)
        break;
      localTextView1.setBackgroundResource(2130837736);
      localTextView1.setTextColor(this.a.getResources().getColor(2131034212));
      return paramView;
    }
    localTextView1.setBackgroundResource(2130837737);
    localTextView1.setTextColor(Color.parseColor("#999999"));
    return paramView;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.g
 * JD-Core Version:    0.6.0
 */