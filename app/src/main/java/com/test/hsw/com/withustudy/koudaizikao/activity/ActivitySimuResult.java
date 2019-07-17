package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.MockPushState;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.Scholarship;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.req.ReqScoBean;
import com.withustudy.koudaizikao.fragment.ScoFragment;
import com.withustudy.koudaizikao.fragment.SimuFragment;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitySimuResult extends AbsBaseActivity
{
  private static final int E = 101;
  public static final int k = 17;
  private int A;
  private a B;
  private MockPushState C;
  private FrameLayout D;
  private UrlShortBean F;
  private RspSco G;
  private Urls H;
  private Handler I = new j(this);
  public double a;
  public int b;
  public String c;
  public String d;
  public HashMap<Integer, String> e;
  public int f;
  public String g;
  public int h;
  public HashMap<Integer, Boolean> i;
  public int j;
  public int l;
  public int m = 0;
  public int n;
  public int o;
  public int p;
  public String q = "";
  public int r = 0;
  public boolean s = false;
  public String t;
  public String u;
  public Urls v;
  public String w;
  public String x;
  private final int y = 5;
  private Bundle z;

  private void b()
  {
    this.B = new a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.update_simu_ui");
    registerReceiver(this.B, localIntentFilter);
  }

  public void a()
  {
    try
    {
      if (this.s)
      {
        ReqScoBean localReqScoBean = new ReqScoBean();
        localReqScoBean.setActivityId(this.q);
        localReqScoBean.setUid(this.mSP.i());
        localReqScoBean.setAmount(this.r);
        c.b().m().a(this, localReqScoBean, 5);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.s = paramBoolean;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = this.mSP.i();
      try
      {
        if (this.d != null)
          str1 = URLEncoder.encode(this.d, "utf-8");
        str2 = URLEncoder.encode(this.mSP.v(), "utf-8");
        str3 = URLEncoder.encode(new DecimalFormat("0.0").format(this.a), "utf-8");
        str4 = URLEncoder.encode(this.g, "utf-8");
        String str8 = URLEncoder.encode(this.f, "utf-8");
        str6 = str8;
        String str7 = "?subjectname=" + str1 + "$$$name=" + str2 + "$$$source=" + str3 + "$$$time=" + str6 + "$$$level=" + str4 + "$$$uid=" + str5 + "$$$activityId=" + paramString;
        a locala = c.b().at();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("http://share.kdzikao.com/Simulationtest/share.page" + str7);
        locala.a(this, arrayOfString, 101, this);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
        {
          localUnsupportedEncodingException.printStackTrace();
          String str6 = "";
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  protected void bindData()
  {
    if (this.A != 0)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131296691, new SimuFragment());
      localFragmentTransaction.commit();
    }
    do
      return;
    while (this.n == 0);
    this.mProTools.a(true);
  }

  protected void initData()
  {
    try
    {
      this.z = getIntent().getExtras();
      this.d = this.z.getString("subjectName");
      this.t = this.z.getString("formateSecond");
      this.a = this.z.getDouble("statisticsSocre");
      this.g = this.z.getString("level");
      this.j = this.z.getInt("count");
      this.b = this.z.getInt("FromPage");
      this.c = this.z.getString("subjectId");
      this.f = this.z.getInt("time");
      this.n = this.z.getInt("doneCount");
      this.o = this.z.getInt("errorCount");
      this.p = this.z.getInt("rightCount");
      this.A = this.z.getInt("resultCode");
      this.m = this.z.getInt("userLevel");
      this.u = new DecimalFormat("#").format(this.a);
      if (this.n == 0)
      {
        h.a("doneCount==0");
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(2131296691, new SimuFragment());
        localFragmentTransaction.commit();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
  }

  protected void initView()
  {
    this.D = ((FrameLayout)findViewById(2131296691));
    b();
  }

  public void onBackPressed()
  {
    g.b(this.mContext, "test_close_con");
    setResult(102);
    finish(0, 0);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.B != null)
    {
      unregisterReceiver(this.B);
      this.B = null;
    }
    this.mProTools.b();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = c.a();
        switch (paramInt)
        {
        case 101:
          this.F = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
          if (this.F != null)
          {
            List localList = this.F.getUrls();
            if ((localList == null) || (localList.size() <= 0))
              return;
            this.v = ((Urls)localList.get(0));
            this.x = this.v.getUrl_short();
            this.w = this.v.getUrl_long();
            h.a("url_short ", this.x);
            h.a("url_long ", this.w);
            return;
          }
        case 5:
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      h.a("加密url异常");
      return;
      this.G = ((RspSco)localGson.fromJson(paramString1, RspSco.class));
      if (this.G != null)
      {
        this.I.sendEmptyMessage(5);
        return;
      }
    }
    else
    {
      h.a(paramString1);
    }
  }

  protected void setContentView()
  {
    setContentView(2130903108);
  }

  private class a extends BroadcastReceiver
  {
    private a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle = paramIntent.getExtras();
      ActivitySimuResult.a(ActivitySimuResult.this, (MockPushState)localBundle.getSerializable("mockPushState"));
      ActivitySimuResult.e(ActivitySimuResult.this).b();
      if ((ActivitySimuResult.f(ActivitySimuResult.this) != null) && (ActivitySimuResult.this.n != 0))
      {
        h.a("doneCount!=0");
        Scholarship localScholarship = ActivitySimuResult.f(ActivitySimuResult.this).getScholarship();
        if (localScholarship != null)
        {
          ActivitySimuResult.this.q = localScholarship.getActivityId();
          ActivitySimuResult.this.r = localScholarship.getAmount();
          FragmentTransaction localFragmentTransaction2 = ActivitySimuResult.this.getSupportFragmentManager().beginTransaction();
          localFragmentTransaction2.add(2131296691, new ScoFragment());
          localFragmentTransaction2.commit();
        }
      }
      else
      {
        return;
      }
      FragmentTransaction localFragmentTransaction1 = ActivitySimuResult.this.getSupportFragmentManager().beginTransaction();
      localFragmentTransaction1.add(2131296691, new SimuFragment());
      localFragmentTransaction1.commit();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ActivitySimuResult
 * JD-Core Version:    0.6.0
 */