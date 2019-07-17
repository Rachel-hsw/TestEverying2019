package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.b.c.a;
import com.withustudy.koudaizikao.entity.UserBrushSummary;
import com.withustudy.koudaizikao.entity.UserMockSummary;
import com.withustudy.koudaizikao.entity.req.UserInfo;
import java.text.DecimalFormat;
import java.util.List;

public class d extends BaseAdapter
{
  private Context a;
  private List b;
  private int c = -1;
  private int d;

  public d(int paramInt, Context paramContext, List paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = paramInt;
  }

  private void a(ImageView paramImageView, String paramString)
  {
    com.a.a.b.c localc = new c.a().b(2130837854).c(2130837862).d(2130837862).b(true).c(true).a(new com.a.a.b.c.c(1000)).d();
    com.a.a.b.d.a().a(paramString, paramImageView, localc);
  }

  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > -1 + this.b.size()))
      return;
    this.c = paramInt;
  }

  public void a(List paramList)
  {
    this.b = paramList;
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
      paramView = LayoutInflater.from(this.a).inflate(2130903195, null);
      locala = new a();
      locala.a = ((LinearLayout)paramView.findViewById(2131297267));
      locala.b = ((ImageView)paramView.findViewById(2131297269));
      locala.c = ((TextView)paramView.findViewById(2131297270));
      locala.d = ((TextView)paramView.findViewById(2131297268));
      locala.e = ((TextView)paramView.findViewById(2131297271));
      locala.f = ((TextView)paramView.findViewById(2131297272));
      locala.g = ((TextView)paramView.findViewById(2131297273));
      locala.h = ((TextView)paramView.findViewById(2131297274));
      paramView.setTag(locala);
      switch (this.d)
      {
      default:
        if (paramInt != 0)
          break;
        locala.d.setBackgroundResource(2130837994);
        locala.d.setText(null);
      case 0:
      case 1:
      }
    }
    while (true)
    {
      if (this.c == -1)
        break label1012;
      if (this.c != paramInt)
        break label792;
      locala.a.setBackgroundColor(this.a.getResources().getColor(2131034212));
      locala.d.setTextColor(Color.parseColor("#ffffff"));
      locala.c.setTextColor(Color.parseColor("#ffffff"));
      locala.e.setTextColor(Color.parseColor("#ffffff"));
      locala.f.setTextColor(Color.parseColor("#ffffff"));
      locala.g.setTextColor(Color.parseColor("#ffffff"));
      locala.h.setTextColor(Color.parseColor("#ffffff"));
      return paramView;
      locala = (a)paramView.getTag();
      break;
      UserBrushSummary localUserBrushSummary = (UserBrushSummary)this.b.get(paramInt);
      locala.e.setVisibility(0);
      locala.g.setVisibility(0);
      UserInfo localUserInfo2 = localUserBrushSummary.getUserInfo();
      String str4 = localUserInfo2.getHeadPic();
      String str5 = localUserInfo2.getNickname();
      if ((str4 == null) || (str4.equals("")))
        a(locala.b, "drawable://2130837862");
      while (true)
      {
        locala.c.setText(str5);
        locala.f.setText(localUserBrushSummary.getBrushNum() + "道");
        String str6 = new DecimalFormat("#.##").format(100.0D * localUserBrushSummary.getCorrectRate());
        locala.h.setText(str6 + "%");
        break;
        a(locala.b, str4);
      }
      UserMockSummary localUserMockSummary = (UserMockSummary)this.b.get(paramInt);
      UserInfo localUserInfo1 = localUserMockSummary.getUserInfo();
      String str1 = localUserInfo1.getHeadPic();
      String str2 = localUserInfo1.getNickname();
      locala.e.setVisibility(4);
      locala.g.setVisibility(4);
      double d1 = localUserMockSummary.getScore();
      String str3 = new DecimalFormat("#").format(d1);
      locala.f.setText(str3 + "分");
      locala.c.setText(str2);
      if ((str1 == null) || (str1.equals("")))
        a(locala.b, "drawable://2130837862");
      while (true)
      {
        long l = localUserMockSummary.getCostTime();
        locala.h.setText(l + "分钟");
        break;
        a(locala.b, str1);
      }
      if (paramInt == 1)
      {
        locala.d.setBackgroundResource(2130837995);
        locala.d.setText(null);
        continue;
      }
      if (paramInt == 2)
      {
        locala.d.setBackgroundResource(2130837996);
        locala.d.setText(null);
        continue;
      }
      locala.d.setBackgroundResource(2131034189);
      locala.d.setText(String.valueOf(paramInt + 1));
    }
    label792: locala.a.setBackgroundColor(Color.parseColor("#ffffff"));
    if (paramInt < 3)
    {
      locala.d.setTextColor(this.a.getResources().getColor(2131034212));
      locala.c.setTextColor(this.a.getResources().getColor(2131034212));
      locala.e.setTextColor(Color.parseColor("#999999"));
      locala.f.setTextColor(this.a.getResources().getColor(2131034212));
      locala.g.setTextColor(Color.parseColor("#999999"));
      locala.h.setTextColor(this.a.getResources().getColor(2131034212));
      return paramView;
    }
    locala.d.setTextColor(this.a.getResources().getColor(2131034212));
    locala.c.setTextColor(Color.parseColor("#999999"));
    locala.e.setTextColor(Color.parseColor("#999999"));
    locala.f.setTextColor(Color.parseColor("#7b7b7b"));
    locala.g.setTextColor(Color.parseColor("#999999"));
    locala.h.setTextColor(Color.parseColor("#7b7b7b"));
    return paramView;
    label1012: locala.a.setBackgroundColor(Color.parseColor("#ffffff"));
    if (paramInt < 3)
    {
      locala.d.setTextColor(this.a.getResources().getColor(2131034212));
      locala.c.setTextColor(this.a.getResources().getColor(2131034212));
      locala.e.setTextColor(Color.parseColor("#999999"));
      locala.f.setTextColor(this.a.getResources().getColor(2131034212));
      locala.g.setTextColor(Color.parseColor("#999999"));
      locala.h.setTextColor(this.a.getResources().getColor(2131034212));
      return paramView;
    }
    locala.d.setTextColor(this.a.getResources().getColor(2131034212));
    locala.c.setTextColor(Color.parseColor("#999999"));
    locala.e.setTextColor(Color.parseColor("#999999"));
    locala.f.setTextColor(Color.parseColor("#7b7b7b"));
    locala.g.setTextColor(Color.parseColor("#999999"));
    locala.h.setTextColor(Color.parseColor("#7b7b7b"));
    return paramView;
  }

  class a
  {
    public LinearLayout a;
    public ImageView b;
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
 * Qualified Name:     com.withustudy.koudaizikao.b.d
 * JD-Core Version:    0.6.0
 */