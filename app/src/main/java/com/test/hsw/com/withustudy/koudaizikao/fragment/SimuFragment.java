package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.umeng.socialize.bean.p;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.ActivitySimuResult;
import com.withustudy.koudaizikao.activity.BrushRankingActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.Map;

public class SimuFragment extends AbsBaseFragment
  implements View.OnClickListener
{
  private static final int u = 2;
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private ImageButton e;
  private ImageButton f;
  private ImageButton g;
  private ImageView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private LinearLayout l;
  private RelativeLayout m;
  private ImageButton n;
  private ImageButton o;
  private ImageButton p;
  private ImageButton q;
  private LinearLayout r;
  private MyListView s;
  private ActivitySimuResult t;
  private Handler v = new w(this);
  private VideoAllContent w;

  private void d()
  {
    try
    {
      switch (this.t.m)
      {
      case 0:
        this.j.setBackgroundResource(2130838228);
        this.k.setText("不太理想！ 要努力啦~~");
        return;
      case 1:
        this.j.setBackgroundResource(2130838229);
        this.k.setText("及格万岁！ 再接再厉~~");
        return;
      case 2:
        this.k.setText("棒棒哒！继续加油~~");
        this.j.setBackgroundResource(2130838227);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void e()
  {
    switch (this.t.b)
    {
    default:
      return;
    case 16:
    }
    this.l.setVisibility(8);
    this.r.setVisibility(8);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2130903269, null);
  }

  public void a()
  {
    this.B.a(true);
    a locala = c.b().r();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = this.t.c;
    locala.a(this, arrayOfString, 2, this.t);
  }

  public void a(View paramView)
  {
    this.r = ((LinearLayout)paramView.findViewById(2131297512));
    this.l = ((LinearLayout)paramView.findViewById(2131297516));
    this.h = ((ImageView)paramView.findViewById(2131297504));
    this.s = ((MyListView)paramView.findViewById(2131297518));
    this.i = ((TextView)paramView.findViewById(2131297505));
    this.d = ((TextView)paramView.findViewById(2131297506));
    this.b = ((TextView)paramView.findViewById(2131297511));
    this.m = ((RelativeLayout)paramView.findViewById(2131297507));
    this.j = ((ImageView)paramView.findViewById(2131297508));
    this.k = ((TextView)paramView.findViewById(2131297509));
    this.a = ((TextView)paramView.findViewById(2131297510));
    this.c = ((TextView)paramView.findViewById(2131297513));
    this.e = ((ImageButton)paramView.findViewById(2131297514));
    this.g = ((ImageButton)paramView.findViewById(2131297515));
    this.f = ((ImageButton)paramView.findViewById(2131297517));
    this.q = ((ImageButton)paramView.findViewById(2131297522));
    this.p = ((ImageButton)paramView.findViewById(2131297521));
    this.o = ((ImageButton)paramView.findViewById(2131297520));
    this.n = ((ImageButton)paramView.findViewById(2131297519));
  }

  public void b()
  {
  }

  public void c()
  {
    this.m.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.s.setOnItemClickListener(new y(this));
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.t = ((ActivitySimuResult)paramActivity);
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131297520:
        g.b(this.y, "test_con_share");
        if (this.t.w != null)
        {
          this.t.share(p.j, this.t.w, "口袋自考", "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
          return;
        }
        this.t.share(p.j, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131297519:
        g.b(this.y, "test_con_share");
        if (this.t.w != null)
        {
          this.t.share(p.i, this.t.w, "口袋自考", "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
          return;
        }
        this.t.share(p.i, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131297522:
        g.b(this.y, "test_con_share");
        if (this.t.x != null)
        {
          this.t.share(p.e, this.t.x, "口袋自考", "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
          return;
        }
        this.t.share(p.e, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131297521:
        g.b(this.y, "test_con_share");
        if (this.t.w != null)
        {
          this.t.share(p.g, this.t.w, "口袋自考", "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
          return;
        }
        this.t.share(p.g, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131297507:
        g.b(this.y, "test_close_con");
        this.t.setResult(102);
        a(0, 0);
        return;
      case 2131297514:
        g.b(this.y, "test_con_show_paper");
        this.t.setResult(100);
        a(0, 0);
        return;
      case 2131297517:
        g.b(this.y, "test_con_rank");
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("subjectId", this.t.c);
        localBundle.putString("subjectName", this.t.d);
        a(BrushRankingActivity.class, 2130968591, 2130968589, false, localBundle);
        return;
      case 2131297515:
        g.b(this.y, "test_con_explain_error");
        this.t.setResult(101);
        a(0, 0);
      case 2131297508:
      case 2131297509:
      case 2131297510:
      case 2131297511:
      case 2131297512:
      case 2131297513:
      case 2131297516:
      case 2131297518:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
      return;
    case 2:
    }
    this.B.b();
    h.a("response", paramString1);
    try
    {
      this.w = ((VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class));
      this.v.sendEmptyMessage(2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.SimuFragment
 * JD-Core Version:    0.6.0
 */