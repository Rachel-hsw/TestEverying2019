package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.withustudy.koudaizikao.custom.MarqueeTextView;
import com.withustudy.koudaizikao.entity.Subject;
import java.util.List;

public class h extends BaseAdapter
{
  private List<Subject> a;
  private Context b;
  private int[] c;

  public h(List<Subject> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = new int[paramList.size()];
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return;
      this.c[i] = 0;
    }
  }

  public void a(int paramInt)
  {
    if (this.c[paramInt] == 0)
    {
      this.c[paramInt] = 1;
      return;
    }
    this.c[paramInt] = 0;
  }

  public void a(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
  }

  public int[] a()
  {
    return this.c;
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
    MarqueeTextView localMarqueeTextView1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130903185, null);
      MarqueeTextView localMarqueeTextView2 = (MarqueeTextView)paramView.findViewById(2131297177);
      paramView.setTag(localMarqueeTextView2);
      localMarqueeTextView1 = localMarqueeTextView2;
      if (this.c[paramInt] != 0)
        break label100;
      localMarqueeTextView1.setBackgroundResource(2130837734);
      localMarqueeTextView1.setTextColor(Color.parseColor("#999999"));
    }
    while (true)
    {
      localMarqueeTextView1.setText(((Subject)this.a.get(paramInt)).getName());
      return paramView;
      localMarqueeTextView1 = (MarqueeTextView)paramView.getTag();
      break;
      label100: localMarqueeTextView1.setBackgroundResource(2130837733);
      localMarqueeTextView1.setTextColor(this.b.getResources().getColor(2131034212));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.h
 * JD-Core Version:    0.6.0
 */