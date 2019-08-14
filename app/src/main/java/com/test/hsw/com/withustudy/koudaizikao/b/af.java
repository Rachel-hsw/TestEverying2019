package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.d.a;
import com.withustudy.koudaizikao.entity.New_course_ids;
import com.withustudy.koudaizikao.entity.VideoCourse;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class af extends BaseAdapter
{
  private Context a;
  private List<VideoCourse> b;
  private int c = 0;
  private List<New_course_ids> d;

  public af(Context paramContext, List<VideoCourse> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }

  public af(Context paramContext, List<VideoCourse> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
  }

  public af(Context paramContext, List<VideoCourse> paramList, List<New_course_ids> paramList1)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = paramList1;
  }

  public void a(List<New_course_ids> paramList)
  {
    this.d = paramList;
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
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903209, null);
      locala = new a();
      locala.b = ((ImageView)paramView.findViewById(2131297326));
      locala.a = ((ImageView)paramView.findViewById(2131297325));
      locala.c = ((ImageView)paramView.findViewById(2131297327));
      locala.d = ((TextView)paramView.findViewById(2131297328));
      locala.e = ((TextView)paramView.findViewById(2131297329));
      locala.f = ((TextView)paramView.findViewById(2131297334));
      locala.g = ((TextView)paramView.findViewById(2131297330));
      locala.h = ((TextView)paramView.findViewById(2131297332));
      locala.i = ((TextView)paramView.findViewById(2131297331));
      locala.j = ((TextView)paramView.findViewById(2131297333));
      locala.k = ((TextView)paramView.findViewById(2131297335));
      locala.l = ((TextView)paramView.findViewById(2131297336));
      paramView.setTag(locala);
      if ((((VideoCourse)this.b.get(paramInt)).getPic_url() == null) || (((VideoCourse)this.b.get(paramInt)).getPic_url().equals("")))
        break label791;
      e.a(this.a).a(((VideoCourse)this.b.get(paramInt)).getPic_url(), locala.b);
      label276: if (((VideoCourse)this.b.get(paramInt)).getCategory() != 0)
        break label832;
      locala.d.setText("直播课");
      locala.d.setTextColor(Color.parseColor("#ed3d3d"));
      locala.k.setText(String.valueOf(((VideoCourse)this.b.get(paramInt)).getCourse_hour()) + "个课时");
      String str2 = ((VideoCourse)this.b.get(paramInt)).getPlay_status();
      if (!str2.equals("已结课"))
        break label805;
      locala.f.setText("直播回放");
      label401: locala.f.setTextColor(Color.parseColor((String)a.g.get(str2)));
      label423: locala.e.setText(((VideoCourse)this.b.get(paramInt)).getCourse_name());
      locala.g.setText(((VideoCourse)this.b.get(paramInt)).getTag());
      if (((VideoCourse)this.b.get(paramInt)).getOriginal_price() != 0.0F)
        break label983;
      locala.h.setVisibility(8);
      label502: locala.i.setText("￥" + String.valueOf(((VideoCourse)this.b.get(paramInt)).getPrice()));
      if ((((VideoCourse)this.b.get(paramInt)).getDiscount() == null) || (((VideoCourse)this.b.get(paramInt)).getDiscount().equals("")))
        break label1035;
      locala.j.setVisibility(0);
      locala.j.setText(((VideoCourse)this.b.get(paramInt)).getDiscount());
      label620: locala.l.setText("已售" + String.valueOf(((VideoCourse)this.b.get(paramInt)).getSold_num()));
      if (this.c != 0)
        break label1071;
      if (((VideoCourse)this.b.get(paramInt)).getBuy_status() != 0)
        break label1048;
      locala.c.setVisibility(8);
    }
    while (true)
    {
      if ((this.d == null) || (this.d.size() <= 0))
        break label1106;
      String str1 = ((VideoCourse)this.b.get(paramInt)).getCourse_id();
      Boolean localBoolean = (Boolean)((MainActivity)this.a).newCourseIsClick.get(str1);
      if ((localBoolean == null) || (localBoolean.booleanValue()))
        break label1094;
      locala.a.setVisibility(0);
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label791: locala.b.setImageResource(2130837870);
      break label276;
      label805: locala.f.setText(((VideoCourse)this.b.get(paramInt)).getPlay_status());
      break label401;
      label832: locala.d.setText("视频课");
      locala.d.setTextColor(this.a.getResources().getColor(2131034212));
      locala.k.setText(String.valueOf(((VideoCourse)this.b.get(paramInt)).getVideo_num()) + "个视频");
      if (((VideoCourse)this.b.get(paramInt)).getBuy_status() != 0)
      {
        locala.f.setText(((VideoCourse)this.b.get(paramInt)).getPlay_status());
        locala.f.setTextColor(Color.parseColor("#32c605"));
        break label423;
      }
      locala.f.setText("");
      break label423;
      label983: locala.h.setVisibility(0);
      locala.h.getPaint().setFlags(16);
      locala.h.setText(String.valueOf(((VideoCourse)this.b.get(paramInt)).getOriginal_price()));
      break label502;
      label1035: locala.j.setVisibility(8);
      break label620;
      label1048: locala.c.setBackgroundResource(2130838202);
      locala.c.setVisibility(0);
      continue;
      label1071: locala.c.setBackgroundResource(2130838114);
      locala.c.setVisibility(0);
    }
    label1094: locala.a.setVisibility(8);
    return paramView;
    label1106: locala.a.setVisibility(8);
    return paramView;
  }

  class a
  {
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.af
 * JD-Core Version:    0.6.0
 */