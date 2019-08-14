package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.b.c.a;
import com.a.a.b.d;
import com.android.http.e;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.req.ExerciseIdList;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;
import java.util.Map;

public class SimulationInitActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  public static final int a = 3;
  public static HashMap<Integer, String> b = new bk();
  private RelativeLayout c;
  private Button d;
  private Button e;
  private Button f;
  private TextView g;
  private TextView h;
  private Button i;
  private int j = 1;
  private LinearLayout k;
  private String l;
  private Bundle m;
  private String n;
  private ImageView o;
  private ExerciseIdList p;

  private void a()
  {
    this.d.setTextColor(getResources().getColor(2131034212));
    this.e.setTextColor(getResources().getColor(2131034212));
    this.f.setTextColor(getResources().getColor(2131034212));
    this.d.setBackgroundResource(2131034189);
    this.e.setBackgroundResource(2131034189);
    this.f.setBackgroundResource(2131034189);
  }

  private void a(int paramInt)
  {
    this.j = paramInt;
    a();
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.d.setTextColor(getResources().getColor(2131034112));
      this.d.setBackgroundResource(2130837610);
      return;
    case 1:
      this.e.setTextColor(getResources().getColor(2131034112));
      this.e.setBackgroundResource(2130837610);
      return;
    case 2:
    }
    this.f.setTextColor(getResources().getColor(2131034112));
    this.f.setBackgroundResource(2130837610);
  }

  private void a(ImageView paramImageView, String paramString)
  {
    com.a.a.b.c localc = new c.a().b(2130837854).c(2130837862).d(2130837862).b(true).c(true).a(new com.a.a.b.c.c(110)).d();
    d.a().a(paramString, paramImageView, localc);
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.h.setText(this.mSP.v());
    this.g.setText(this.n);
    String str = this.mSP.u();
    if ((str == null) || (str.equals("")))
    {
      a(this.o, "drawable://2130837862");
      return;
    }
    this.mFileDownLoad.a(str, this.o, 1000);
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }

  protected void initView()
  {
    try
    {
      this.m = getIntent().getExtras();
      this.l = this.m.getString("subjectId");
      this.n = this.m.getString("subjectName");
      label37: this.c = ((RelativeLayout)findViewById(2131296710));
      this.o = ((ImageView)findViewById(2131296703));
      this.d = ((Button)findViewById(2131296707));
      this.e = ((Button)findViewById(2131296708));
      this.f = ((Button)findViewById(2131296709));
      this.g = ((TextView)findViewById(2131296705));
      this.h = ((TextView)findViewById(2131296704));
      this.i = ((Button)findViewById(2131296702));
      this.k = ((LinearLayout)findViewById(2131296706));
      return;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296703:
    case 2131296704:
    case 2131296705:
    case 2131296706:
    default:
      return;
    case 2131296710:
      g.b(this.mContext, "test_start");
      Toast.makeText(getApplicationContext(), "开始考试", 0).show();
      Bundle localBundle = new Bundle();
      localBundle.putInt("FromPage", 3);
      localBundle.putString("level", (String)b.get(Integer.valueOf(this.j)));
      localBundle.putString("subjectId", this.l);
      localBundle.putString("subjectName", this.n);
      startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
      finish(0, 0);
      return;
    case 2131296707:
      g.b(this.mContext, "test_low_difficult");
      a(0);
      return;
    case 2131296708:
      g.b(this.mContext, "test_middle_difficult");
      a(1);
      return;
    case 2131296709:
      g.b(this.mContext, "test_hight_difficult");
      a(2);
      return;
    case 2131296702:
    }
    finish();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    if (paramString1 != null)
    {
      this.p = ((ExerciseIdList)new Gson().fromJson(paramString1, ExerciseIdList.class));
      if (this.p != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("FromPage", 3);
        localBundle.putString("level", (String)b.get(Integer.valueOf(this.j)));
        localBundle.putString("subjectId", this.l);
        startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
        return;
      }
      h.a("模拟考id集合解析异常");
      return;
    }
    h.a("模拟考id集为null");
  }

  protected void setContentView()
  {
    setContentView(2130903112);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SimulationInitActivity
 * JD-Core Version:    0.6.0
 */