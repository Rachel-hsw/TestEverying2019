package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ae extends BaseAdapter
{
  private List<Integer> a;
  private Context b;

  public ae(List<Integer> paramList, Context paramContext)
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
      locala = new a();
      paramView = LayoutInflater.from(this.b).inflate(2130903208, null);
      locala.a = ((ImageView)paramView.findViewById(2131297317));
      locala.b = ((TextView)paramView.findViewById(2131297318));
      locala.c = ((TextView)paramView.findViewById(2131297319));
      locala.d = ((TextView)paramView.findViewById(2131297320));
      locala.e = ((TextView)paramView.findViewById(2131297321));
      locala.f = ((TextView)paramView.findViewById(2131297322));
      locala.g = ((TextView)paramView.findViewById(2131297323));
      locala.h = ((TextView)paramView.findViewById(2131297324));
      paramView.setTag(locala);
      if (((Integer)this.a.get(paramInt)).intValue() < 60)
        break label300;
      locala.a.setBackgroundResource(2130838069);
      locala.b.setTextColor(Color.parseColor("#00FF00"));
    }
    while (true)
    {
      locala.b.setText(this.a.get(paramInt) + "分");
      locala.c.setText("耗时12分钟");
      locala.d.setText("2015年8月1日");
      locala.e.setText("单选：24/25       单选：24/25");
      locala.f.setText("单选：24/25       单选：24/25");
      locala.g.setText("单选：24/25       单选：24/25");
      locala.h.setText("上次复习时间：2015年8月1日");
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label300: locala.a.setBackgroundResource(2130838069);
      locala.b.setTextColor(Color.parseColor("#FF0000"));
    }
  }

  class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ae
 * JD-Core Version:    0.6.0
 */