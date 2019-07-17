package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.withustudy.koudaizikao.custom.MarqueeTextView;
import com.withustudy.koudaizikao.entity.Major;
import java.util.List;

public class f extends BaseAdapter
{
  private Context a;
  private List<Major> b;
  private int c;

  public f(Context paramContext, List<Major> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    MarqueeTextView localMarqueeTextView1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903183, null);
      MarqueeTextView localMarqueeTextView2 = (MarqueeTextView)paramView.findViewById(2131297175);
      paramView.setTag(localMarqueeTextView2);
      localMarqueeTextView1 = localMarqueeTextView2;
      if (paramInt != this.c)
        break label106;
      localMarqueeTextView1.setBackgroundResource(2130837733);
      localMarqueeTextView1.setTextColor(this.a.getResources().getColor(2131034212));
    }
    while (true)
    {
      localMarqueeTextView1.setText(((Major)this.b.get(paramInt)).getMajorName());
      return paramView;
      localMarqueeTextView1 = (MarqueeTextView)paramView.getTag();
      break;
      label106: localMarqueeTextView1.setBackgroundResource(2130837734);
      localMarqueeTextView1.setTextColor(Color.parseColor("#999999"));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.f
 * JD-Core Version:    0.6.0
 */