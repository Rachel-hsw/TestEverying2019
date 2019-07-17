package com.withustudy.koudaizikao.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.koudai.test.BrushExcerciseDetailActivity;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.MarqueeTextView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Chapter;
import com.withustudy.koudaizikao.entity.ChapterSectionListBean;
import com.withustudy.koudaizikao.entity.ChapterSummary;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionSummary;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.req.ReqSubjectState;
import com.withustudy.koudaizikao.g.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"ShowToast"})
public class ChapterSectionListActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  public static final int a = 9;
  public static final int b = 12;
  private static final int c = 101;
  private static final int s = 102;
  private ImageButton A;
  private ImageButton B;
  private Button C;
  private ImageView D;
  private TextView E;
  private TextView F;
  private UrlShortBean G;

  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Boolean> H = new HashMap();
  private a I;
  private List<ChapterSummary> J = new ArrayList();
  private com.withustudy.koudaizikao.custom.a.a K;
  private Handler L = new l(this);
  private boolean M = false;
  private ListView d;
  private com.android.http.l e = null;
  private ChapterSectionListBean f;
  private com.withustudy.koudaizikao.c.a<ChapterSummary> g;
  private ImageButton h;
  private RelativeLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private PopupWindow l;
  private Button m;
  private Button n;
  private ImageButton o;
  private MarqueeTextView p;
  private String q = "";
  private String r = "";
  private GetSnReceiver t;
  private boolean u;
  private boolean v = true;
  private RelativeLayout w;
  private LinearLayout x;
  private LinearLayout y;
  private ImageButton z;

  private double a(String paramString)
  {
    try
    {
      double d1 = Math.ceil(Double.parseDouble(paramString) / 10.0D);
      double d2 = Double.parseDouble(new DecimalFormat("#.#").format(d1));
      return d2;
    }
    catch (Exception localException)
    {
    }
    return 0.0D;
  }

  private void a()
  {
  }

  private void a(int paramInt)
  {
    try
    {
      if (this.v)
      {
        m localm = new m(this, paramInt);
        this.L.post(localm);
        this.v = false;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void b()
  {
    if (this.l != null)
    {
      this.l.dismiss();
      this.l = null;
    }
    a(1.0F);
    this.M = false;
  }

  private void b(int paramInt)
  {
    try
    {
      if (this.l != null)
      {
        this.l.dismiss();
        this.l = null;
      }
      View localView = getLayoutInflater().inflate(2130903125, null);
      this.w = ((RelativeLayout)localView.findViewById(2131296836));
      this.y = ((LinearLayout)localView.findViewById(2131296843));
      this.x = ((LinearLayout)localView.findViewById(2131296840));
      this.D = ((ImageView)localView.findViewById(2131296837));
      this.E = ((TextView)localView.findViewById(2131296838));
      this.F = ((TextView)localView.findViewById(2131296839));
      if (this.M)
      {
        this.y.setVisibility(0);
        this.x.setVisibility(8);
        this.z = ((ImageButton)localView.findViewById(2131296844));
        this.A = ((ImageButton)localView.findViewById(2131296845));
        this.B = ((ImageButton)localView.findViewById(2131296846));
        this.C = ((Button)localView.findViewById(2131296847));
        this.B.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.E.setVisibility(8);
        this.F.setText("号召更多的小伙伴来学习吧~");
        this.F.setVisibility(0);
        this.D.setBackgroundResource(2130837908);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
        if (!this.M)
          break label493;
      }
      label493: for (this.l = new PopupWindow(localView, this.mSP.y(), com.withustudy.koudaizikao.g.n.a(this, 650.0F)); ; this.l = new PopupWindow(localView, this.mSP.y(), com.withustudy.koudaizikao.g.n.a(this, 450.0F)))
      {
        this.l.setAnimationStyle(2131231021);
        this.l.setFocusable(true);
        localView.setOnKeyListener(new n(this));
        this.l.showAtLocation(this.d, 80, 0, 0);
        a(0.3F);
        return;
        this.x.setVisibility(0);
        this.y.setVisibility(8);
        this.E.setVisibility(0);
        this.E.setText("学霸你好~");
        this.F.setText("你已经做了" + paramInt + "道题");
        this.F.setVisibility(0);
        this.D.setBackgroundResource(2130838226);
        this.m = ((Button)localView.findViewById(2131296841));
        this.n = ((Button)localView.findViewById(2131296842));
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.w.setOnClickListener(this);
        break;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getWindow().setAttributes(localLayoutParams);
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.t = new GetSnReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.getSnReceiver");
    registerReceiver(this.t, localIntentFilter);
    boolean bool = com.withustudy.koudaizikao.g.n.a(this);
    try
    {
      Bundle localBundle = getIntent().getExtras();
      this.q = localBundle.getString("subjectId");
      this.r = localBundle.getString("subjectName");
      label75: this.p.setText(this.r);
      this.M = false;
      if (bool)
      {
        this.mProTools.a();
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        String str = this.mSP.i();
        ReqSubjectState localReqSubjectState = new ReqSubjectState();
        localReqSubjectState.setVersionName(this.mSP.p());
        localReqSubjectState.setClientType(com.withustudy.koudaizikao.g.n.a());
        localReqSubjectState.setImei(com.withustudy.koudaizikao.g.n.d(this.mContext));
        localReqSubjectState.setNet(com.withustudy.koudaizikao.g.n.c(this.mContext));
        localReqSubjectState.setUid(str);
        localReqSubjectState.setSubjectId(this.q);
        c.b().f().a(this, localReqSubjectState, 102);
        return;
      }
      this.j.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label75;
    }
  }

  protected void initListener()
  {
    this.k.setOnClickListener(this);
    this.o.setOnClickListener(this);
  }

  protected void initView()
  {
    this.d = ((ListView)findViewById(2131296441));
    this.j = ((LinearLayout)findViewById(2131296438));
    this.i = ((RelativeLayout)findViewById(2131296443));
    this.k = ((LinearLayout)findViewById(2131296439));
    this.o = ((ImageButton)findViewById(2131296440));
    this.p = ((MarqueeTextView)findViewById(2131296401));
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296836:
        b();
        return;
      case 2131296439:
        finish();
        return;
      case 2131296841:
        g.b(this.mContext, "brush_c_from_start");
        b();
        return;
      case 2131296842:
        g.b(this.mContext, "brush_c_continue");
        b();
        Bundle localBundle = new Bundle();
        localBundle.putString("subjectName", this.r);
        localBundle.putString("subjectId", this.q);
        localBundle.putInt("BrushPageFrom", 12);
        startNewActivity(BrushExcerciseDetailActivity.class, 2130968591, 2130968589, false, localBundle);
        return;
      case 2131296440:
        String str = "?subjectid=" + this.q;
        com.withustudy.koudaizikao.a.a locala = c.b().at();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
        locala.a(this, arrayOfString, 101, this);
        return;
      case 2131296847:
        b();
        return;
      case 2131296844:
        share(com.umeng.socialize.bean.p.e, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131296845:
        share(com.umeng.socialize.bean.p.j, "http://share.kdzikao.com/app/share.page");
        return;
      case 2131296846:
        share(com.umeng.socialize.bean.p.i, "http://share.kdzikao.com/app/share.page");
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.t != null)
      {
        unregisterReceiver(this.t);
        this.t = null;
      }
      if (this.l != null)
      {
        this.l.dismiss();
        this.l = null;
      }
      if (this.K != null)
      {
        this.K.c();
        this.K = null;
      }
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onRestart()
  {
    super.onRestart();
    this.mProTools.a();
    this.j.setVisibility(0);
    this.i.setVisibility(8);
    String str = this.mSP.i();
    ReqSubjectState localReqSubjectState = new ReqSubjectState();
    localReqSubjectState.setVersionName(this.mSP.p());
    localReqSubjectState.setClientType(com.withustudy.koudaizikao.g.n.a());
    localReqSubjectState.setImei(com.withustudy.koudaizikao.g.n.d(this.mContext));
    localReqSubjectState.setNet(com.withustudy.koudaizikao.g.n.c(this.mContext));
    localReqSubjectState.setUid(str);
    localReqSubjectState.setSubjectId(this.q);
    c.b().f().a(this, localReqSubjectState, 102);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    Gson localGson;
    if (paramString1 != null)
      localGson = c.a();
    switch (paramInt)
    {
    default:
      return;
    case 102:
      try
      {
        this.f = ((ChapterSectionListBean)localGson.fromJson(paramString1, ChapterSectionListBean.class));
        if (this.f != null)
        {
          this.L.sendEmptyMessage(102);
          return;
        }
      }
      catch (Exception localException)
      {
        h.a("章节列表解析异常:" + localException.getMessage());
        return;
      }
      h.a("章节列表数据解析实体bean为null");
      return;
    case 101:
    }
    this.G = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
    if (this.G != null)
    {
      this.L.sendEmptyMessage(101);
      return;
    }
    h.a("加密url异常");
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.u = paramBoolean;
  }

  protected void setContentView()
  {
    setContentView(2130903072);
  }

  public class GetSnReceiver extends BroadcastReceiver
  {
    public GetSnReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        h.a("刷新科目列表  getSnReceiver");
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle != null)
        {
          String str = localBundle.getString("mCurreSn");
          String[] arrayOfString = str.split("\\.");
          h.a("mCurreSn=" + str);
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            Integer localInteger = Integer.valueOf(arrayOfString[0]);
            ChapterSectionListActivity.g(ChapterSectionListActivity.this).put(Integer.valueOf(-1 + localInteger.intValue()), Boolean.valueOf(true));
          }
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  class a extends BaseAdapter
  {
    private List<ChapterSummary> b;

    public a()
    {
      Object localObject;
      this.b = localObject;
    }

    public int getCount()
    {
      if (this.b == null)
        return 0;
      return this.b.size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ChapterSectionListActivity.b localb1;
      if (paramView == null)
      {
        paramView = View.inflate(ChapterSectionListActivity.this.getApplicationContext(), 2130903124, null);
        ChapterSectionListActivity.b localb2 = new ChapterSectionListActivity.b(ChapterSectionListActivity.this);
        ChapterSectionListActivity.b.a(localb2, (ImageView)paramView.findViewById(2131296825));
        ChapterSectionListActivity.b.b(localb2, (ImageView)paramView.findViewById(2131296830));
        ChapterSectionListActivity.b.c(localb2, (ImageView)paramView.findViewById(2131296831));
        ChapterSectionListActivity.b.d(localb2, (ImageView)paramView.findViewById(2131296832));
        ChapterSectionListActivity.b.e(localb2, (ImageView)paramView.findViewById(2131296833));
        ChapterSectionListActivity.b.f(localb2, (ImageView)paramView.findViewById(2131296834));
        ChapterSectionListActivity.b.a(localb2, (LinearLayout)paramView.findViewById(2131296829));
        ChapterSectionListActivity.b.a(localb2, paramView.findViewById(2131296829));
        ChapterSectionListActivity.b.a(localb2, (TextView)paramView.findViewById(2131296827));
        ChapterSectionListActivity.b.b(localb2, (TextView)paramView.findViewById(2131296824));
        ChapterSectionListActivity.b.c(localb2, (TextView)paramView.findViewById(2131296826));
        ChapterSectionListActivity.b.b(localb2, (LinearLayout)paramView.findViewById(2131296823));
        ChapterSectionListActivity.b.c(localb2, (LinearLayout)paramView.findViewById(2131296835));
        paramView.setTag(localb2);
        localb1 = localb2;
      }
      while (true)
      {
        ChapterSectionListActivity.b.a(localb1).setVisibility(8);
        ChapterSummary localChapterSummary = (ChapterSummary)this.b.get(paramInt);
        ChapterSectionListActivity.b.b(localb1).setVisibility(0);
        String str1 = localChapterSummary.getGraspLevel();
        try
        {
          double d2 = Math.ceil(Double.parseDouble(str1));
          if (d2 == 0.0D)
          {
            ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837506);
            ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837506);
            ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837506);
            ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
            ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
          }
          List localList;
          while (true)
          {
            String str2 = localChapterSummary.getChapter().getSn();
            ChapterSectionListActivity.b.h(localb1).setText(str2);
            ChapterSectionListActivity.b.i(localb1).setText(localChapterSummary.getChapter().getName());
            ChapterSectionListActivity.b.j(localb1).setText(localChapterSummary.getDoneExerciseNum() + "题/" + localChapterSummary.getTotalExerciseNum() + "题");
            Boolean localBoolean = (Boolean)ChapterSectionListActivity.g(ChapterSectionListActivity.this).get(Integer.valueOf(paramInt));
            if ((localBoolean == null) || (!localBoolean.booleanValue()))
              break label2167;
            ChapterSectionListActivity.b.k(localb1).setVisibility(0);
            ChapterSectionListActivity.b.b(localb1).setVisibility(8);
            ChapterSectionListActivity.b.a(localb1).setVisibility(0);
            if ((ChapterSectionListActivity.b.k(localb1) != null) && (ChapterSectionListActivity.b.k(localb1).getChildCount() > 0))
              ChapterSectionListActivity.b.k(localb1).removeAllViews();
            localList = localChapterSummary.getSectionSummary();
            i = 0;
            if (i < localList.size())
              break label1300;
            ChapterSectionListActivity.g(ChapterSectionListActivity.this).put(Integer.valueOf(paramInt), Boolean.valueOf(true));
            ChapterSectionListActivity.b.l(localb1).setOnClickListener(new p(this, paramInt, localb1, localChapterSummary));
            return paramView;
            localb1 = (ChapterSectionListActivity.b)paramView.getTag();
            break;
            if ((d2 > 0.0D) && (d2 < 10.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837577);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 10.0D) && (d2 < 20.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 20.0D) && (d2 < 30.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837577);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 30.0D) && (d2 < 40.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 40.0D) && (d2 < 50.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837577);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 50.0D) && (d2 < 60.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837506);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 60.0D) && (d2 < 70.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837577);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 70.0D) && (d2 < 80.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837506);
              continue;
            }
            if ((d2 >= 80.0D) && (d2 < 90.0D))
            {
              ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837710);
              ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837577);
              continue;
            }
            if (d2 < 90.0D)
              continue;
            ChapterSectionListActivity.b.c(localb1).setBackgroundResource(2130837710);
            ChapterSectionListActivity.b.d(localb1).setBackgroundResource(2130837710);
            ChapterSectionListActivity.b.e(localb1).setBackgroundResource(2130837710);
            ChapterSectionListActivity.b.f(localb1).setBackgroundResource(2130837710);
            ChapterSectionListActivity.b.g(localb1).setBackgroundResource(2130837710);
          }
          label1300: localSectionSummary = (SectionSummary)localList.get(i);
          localLinearLayout = (LinearLayout)View.inflate(ChapterSectionListActivity.this.getApplicationContext(), 2130903262, null);
          localLinearLayout.setOnClickListener(new o(this, localSectionSummary));
          localTextView = (TextView)localLinearLayout.findViewById(2131297490);
          ((TextView)localLinearLayout.findViewById(2131297155));
          localImageView1 = (ImageView)localLinearLayout.findViewById(2131297493);
          localImageView2 = (ImageView)localLinearLayout.findViewById(2131297494);
          localImageView3 = (ImageView)localLinearLayout.findViewById(2131297495);
          localImageView4 = (ImageView)localLinearLayout.findViewById(2131297496);
          localImageView5 = (ImageView)localLinearLayout.findViewById(2131297497);
          str3 = localSectionSummary.getGraspLevel();
        }
        catch (Exception localException1)
        {
          try
          {
            while (true)
            {
              int i;
              SectionSummary localSectionSummary;
              LinearLayout localLinearLayout;
              TextView localTextView;
              ImageView localImageView1;
              ImageView localImageView2;
              ImageView localImageView3;
              ImageView localImageView4;
              ImageView localImageView5;
              String str3;
              double d1 = Math.ceil(Double.parseDouble(str3));
              if (d1 == 0.0D)
              {
                localImageView1.setBackgroundResource(2130837506);
                localImageView2.setBackgroundResource(2130837506);
                localImageView3.setBackgroundResource(2130837506);
                localImageView4.setBackgroundResource(2130837506);
                localImageView5.setBackgroundResource(2130837506);
              }
              while (true)
              {
                label1497: localTextView.setText(localSectionSummary.getDoneExerciseNum() + "题/" + localSectionSummary.getTotalExerciseNum() + "题");
                ((RelativeLayout)localLinearLayout.findViewById(2131297491));
                ((TextView)localLinearLayout.findViewById(2131297489)).setText(localSectionSummary.getSection().getName());
                ChapterSectionListActivity.b.k(localb1).addView(localLinearLayout);
                i++;
                break;
                if ((d1 > 0.0D) && (d1 < 10.0D))
                {
                  localImageView1.setBackgroundResource(2130837577);
                  localImageView2.setBackgroundResource(2130837506);
                  localImageView3.setBackgroundResource(2130837506);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 10.0D) && (d1 < 20.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837506);
                  localImageView3.setBackgroundResource(2130837506);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 20.0D) && (d1 < 30.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837577);
                  localImageView3.setBackgroundResource(2130837506);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 30.0D) && (d1 < 40.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837506);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 40.0D) && (d1 < 50.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837577);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 50.0D) && (d1 < 60.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837710);
                  localImageView4.setBackgroundResource(2130837506);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 60.0D) && (d1 < 70.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837710);
                  localImageView4.setBackgroundResource(2130837577);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 70.0D) && (d1 < 80.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837710);
                  localImageView4.setBackgroundResource(2130837710);
                  localImageView5.setBackgroundResource(2130837506);
                  continue;
                }
                if ((d1 >= 80.0D) && (d1 < 90.0D))
                {
                  localImageView1.setBackgroundResource(2130837710);
                  localImageView2.setBackgroundResource(2130837710);
                  localImageView3.setBackgroundResource(2130837710);
                  localImageView4.setBackgroundResource(2130837710);
                  localImageView5.setBackgroundResource(2130837577);
                  continue;
                }
                if (d1 < 90.0D)
                  continue;
                localImageView1.setBackgroundResource(2130837710);
                localImageView2.setBackgroundResource(2130837710);
                localImageView3.setBackgroundResource(2130837710);
                localImageView4.setBackgroundResource(2130837710);
                localImageView5.setBackgroundResource(2130837710);
              }
              label2167: ChapterSectionListActivity.b.b(localb1).setVisibility(0);
              ChapterSectionListActivity.b.a(localb1).setVisibility(8);
              if ((ChapterSectionListActivity.b.k(localb1) != null) && (ChapterSectionListActivity.b.k(localb1).getChildCount() > 0))
                ChapterSectionListActivity.b.k(localb1).removeAllViews();
              ChapterSectionListActivity.b.k(localb1).setVisibility(8);
              ChapterSectionListActivity.g(ChapterSectionListActivity.this).put(Integer.valueOf(paramInt), Boolean.valueOf(false));
            }
            localException1 = localException1;
          }
          catch (Exception localException2)
          {
            break label1497;
          }
        }
      }
    }
  }

  class b
  {
    private LinearLayout b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private LinearLayout q;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ChapterSectionListActivity
 * JD-Core Version:    0.6.0
 */