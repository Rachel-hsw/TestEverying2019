package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.Video;
import java.util.List;

public class r extends BaseAdapter
{
  private List<Video> a;
  private Context b;

  public r(List<Video> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }

  private void a(a parama, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      parama.a.setBackgroundColor(Color.parseColor("#00b8e5"));
      parama.c.setTextColor(Color.parseColor("#ffffff"));
      parama.b.setTextColor(Color.parseColor("#ffffff"));
      parama.d.setTextColor(Color.parseColor("#ffffff"));
      return;
    }
    parama.a.setBackgroundColor(Color.parseColor("#f7f8f8"));
    parama.c.setTextColor(Color.parseColor("#999999"));
    parama.b.setTextColor(Color.parseColor("#999999"));
    parama.d.setTextColor(Color.parseColor("#999999"));
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
      paramView = LayoutInflater.from(this.b).inflate(2130903205, null);
      locala = new a();
      locala.a = ((RelativeLayout)paramView.findViewById(2131297307));
      locala.b = ((TextView)paramView.findViewById(2131297308));
      locala.c = ((TextView)paramView.findViewById(2131297309));
      locala.d = ((TextView)paramView.findViewById(2131297310));
      paramView.setTag(locala);
      if (!((Video)this.a.get(paramInt)).getPlay_status().equals("直播中"))
        break label207;
      a(locala, true);
    }
    while (true)
    {
      locala.c.setText(((Video)this.a.get(paramInt)).getVideo_name());
      locala.b.setText(((Video)this.a.get(paramInt)).getLive_time());
      locala.d.setText(((Video)this.a.get(paramInt)).getPlay_status());
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label207: a(locala, false);
    }
  }

  class a
  {
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public TextView d;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.r
 * JD-Core Version:    0.6.0
 */