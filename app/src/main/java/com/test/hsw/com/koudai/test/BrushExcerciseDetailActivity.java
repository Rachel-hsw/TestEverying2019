package com.koudai.test;

import a.a.a.e.k;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.n.a;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.IntellWecomeActivity;
import com.withustudy.koudaizikao.activity.ShowCardActivity;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.a.b;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.BrushExcerciseBean;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.entity.KpointDetail;
import com.withustudy.koudaizikao.entity.OpreationState;
import com.withustudy.koudaizikao.entity.RspCollectExcerBean;
import com.withustudy.koudaizikao.entity.Stem;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.req.BeginSection;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import com.withustudy.koudaizikao.entity.req.IntellBrush;
import com.withustudy.koudaizikao.entity.req.ReqBrushChapterGoNext;
import com.withustudy.koudaizikao.entity.req.ReqBrushLast;
import com.withustudy.koudaizikao.entity.req.ReqChapterBrush;
import com.withustudy.koudaizikao.entity.req.ReqDeleFavor;
import com.withustudy.koudaizikao.entity.req.ReqFavoriteExercise;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import koudai.db.UserAnsDao;
import koudai.db.UserAnsDao.Properties;

public class BrushExcerciseDetailActivity extends AbsBaseActivity
  implements View.OnClickListener, n.a
{
  private static final int r = 0;
  private static final int s = 101;
  private static final int t = 8;
  private static final int u = 5;
  private static final int v = 9;
  private ImageView A;
  private TextView B;
  private LinearLayout C;
  private BrushExcerciseBean D;
  private UrlShortBean E;
  private boolean F;
  private Handler G = new a(this);
  private String H;
  private HashMap<Integer, Boolean> I = new HashMap();
  private com.withustudy.koudaizikao.custom.a.a J;
  public boolean a = false;
  public TextView b;
  public String c;
  public HashMap<Integer, String> d = new HashMap();
  public HashMap<Integer, Boolean> e = new HashMap();
  public ArrayList<Exercises> f = new ArrayList();
  public boolean g;
  public String h;
  private boolean i;
  private ViewPager j;
  private l k;
  private int l;
  private String m = "";
  private String n;
  private String o = "0";
  private int p;
  private String q;
  private Bundle w;
  private LinearLayout x;
  private ImageView y;
  private LinearLayout z;

  private String a(HashMap<Integer, String> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str2;
    for (String str1 = ""; ; str1 = str1 + str2 + "%%%%")
      do
      {
        if (!localIterator.hasNext())
          return str1;
        str2 = (String)paramHashMap.get((Integer)localIterator.next());
      }
      while ((str2 == null) || (str2.equals("")));
  }

  private String a(List<String> paramList)
  {
    Object localObject1 = "";
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
      localIterator = paramList.iterator();
    String str;
    for (Object localObject2 = localObject1; ; localObject2 = localObject2 + str + "%%%%")
    {
      if (!localIterator.hasNext())
      {
        localObject1 = localObject2;
        return localObject1;
      }
      str = (String)localIterator.next();
    }
  }

  private void a(String paramString, double paramDouble)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.pushAnsers");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("excerciseBrushId", this.h);
    localBundle.putString("type", paramString);
    localBundle.putString("subjectId", this.c);
    localBundle.putLong("mockTime", ()paramDouble);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
  }

  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.collect");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("excerciseId", paramString1);
    localBundle.putString("type", paramString2);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (Integer.valueOf(this.o).intValue() == 0)
      {
        Toast.makeText(getApplicationContext(), "休息一下，赶快去刷别的题吧!", 0).show();
        return;
      }
      ReqChapterBrush localReqChapterBrush = new ReqChapterBrush();
      localReqChapterBrush.setVersionName(this.mSP.p());
      localReqChapterBrush.setClientType(n.a());
      localReqChapterBrush.setImei(n.d(this));
      localReqChapterBrush.setNet(n.c(this));
      BeginSection localBeginSection = new BeginSection();
      localBeginSection.setId(paramString1);
      localBeginSection.setName(paramString2);
      localBeginSection.setSn(paramString3);
      localReqChapterBrush.setBeginSection(localBeginSection);
      new UserSubject();
      UserSubject localUserSubject = new UserSubject();
      localUserSubject.setUid(this.mSP.i());
      localUserSubject.setSubjectId(this.c);
      localReqChapterBrush.setUserSubject(localUserSubject);
      this.mProTools.a();
      com.withustudy.koudaizikao.a.c.b().l().a(this, localReqChapterBrush, 0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void g()
  {
    try
    {
      this.w = getIntent().getExtras();
      this.l = this.w.getInt("BrushPageFrom");
      switch (this.l)
      {
      case 9:
        this.o = this.w.getString("totalExerciseNum");
        this.m = this.w.getString("subjectName");
        this.c = this.w.getString("subjectId");
        a(this.w.getString("section_id"), this.w.getString("section_name"), this.w.getString("section_sn"));
        return;
      case 12:
        this.m = this.w.getString("subjectName");
        this.c = this.w.getString("subjectId");
        i();
        return;
      case 888:
        this.m = this.w.getString("subjectName");
        this.c = this.w.getString("subjectId");
        this.o = "10";
        h();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void h()
  {
    this.mProTools.a();
    IntellBrush localIntellBrush = new IntellBrush();
    localIntellBrush.setVersionName(this.mSP.p());
    localIntellBrush.setClientType(n.a());
    localIntellBrush.setImei(n.d(this.mContext));
    localIntellBrush.setNet(n.c(this.mContext));
    new UserSubject();
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setUid(this.mSP.i());
    localUserSubject.setSubjectId(this.c);
    localIntellBrush.setUserSubject(localUserSubject);
    com.withustudy.koudaizikao.a.c.b().v().a(this, localIntellBrush, 0);
  }

  private void i()
  {
    ReqBrushLast localReqBrushLast = new ReqBrushLast();
    localReqBrushLast.setVersionName(this.mSP.p());
    localReqBrushLast.setClientType(n.a());
    localReqBrushLast.setImei(n.d(this.mContext));
    localReqBrushLast.setNet(n.c(this.mContext));
    localReqBrushLast.setContinueLastFlag(true);
    new UserSubject();
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setUid(this.mSP.i());
    localUserSubject.setSubjectId(this.c);
    localReqBrushLast.setUserSubject(localUserSubject);
    this.mProTools.a();
    com.withustudy.koudaizikao.a.c.b().l().a(this, localReqBrushLast, 0);
  }

  private void j()
  {
    if ((this.f != null) && (this.f.size() > 0))
      switch (this.l)
      {
      default:
        this.mProTools.a();
        Boolean localBoolean = (Boolean)this.I.get(Integer.valueOf(this.p));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
          break;
        ReqDeleFavor localReqDeleFavor = new ReqDeleFavor();
        localReqDeleFavor.setVersionName(this.mSP.p());
        localReqDeleFavor.setClientType(n.a());
        localReqDeleFavor.setImei(n.d(this.mContext));
        localReqDeleFavor.setNet(n.c(this.mContext));
        UserSubject localUserSubject2 = new UserSubject();
        localUserSubject2.setUid(this.mSP.i());
        localUserSubject2.setSubjectId(this.c);
        localReqDeleFavor.setUserSubject(localUserSubject2);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((Exercises)this.f.get(this.p)).getExerciseId());
        localReqDeleFavor.setExerciseId(localArrayList);
        com.withustudy.koudaizikao.a.c.b().ao().a(this, localReqDeleFavor, 8);
      case 9:
      case 12:
      case 888:
      }
    ReqFavoriteExercise localReqFavoriteExercise;
    FavoriteExercise localFavoriteExercise;
    Exercises localExercises;
    do
    {
      return;
      g.b(this.mContext, "brush_c_collect");
      break;
      g.b(this.mContext, "brush_i_collect");
      break;
      localReqFavoriteExercise = new ReqFavoriteExercise();
      localReqFavoriteExercise.setVersionName(this.mSP.p());
      localReqFavoriteExercise.setClientType(n.a());
      localReqFavoriteExercise.setImei(n.d(this.mContext));
      localReqFavoriteExercise.setNet(n.c(this.mContext));
      UserSubject localUserSubject1 = new UserSubject();
      localUserSubject1.setUid(this.mSP.i());
      localUserSubject1.setSubjectId(this.c);
      localReqFavoriteExercise.setUserSubject(localUserSubject1);
      localFavoriteExercise = new FavoriteExercise();
      localExercises = (Exercises)this.f.get(this.p);
      localFavoriteExercise.setStemText(localExercises.getStem().getText());
    }
    while (localExercises == null);
    String str = localExercises.getCategory();
    localFavoriteExercise.setTime(System.currentTimeMillis());
    localFavoriteExercise.setCategory(str);
    localFavoriteExercise.setExerciseId(localExercises.getExerciseId());
    KpointDetail localKpointDetail = localExercises.getKpointDetail();
    if (localKpointDetail != null)
      localFavoriteExercise.setKpoint(localKpointDetail.getKpoint());
    while (true)
    {
      localReqFavoriteExercise.setFavoriteExercise(localFavoriteExercise);
      com.withustudy.koudaizikao.a.c.b().ad().a(this, localReqFavoriteExercise, 5);
      return;
      com.withustudy.koudaizikao.g.h.a("知识点KpointDetail字段为null");
    }
  }

  private void k()
  {
    if ((this.f != null) && (this.f.size() > 0))
      switch (this.l)
      {
      default:
      case 9:
      case 12:
      case 888:
      }
    while (true)
    {
      String str = "?subjectid=" + this.c;
      com.withustudy.koudaizikao.a.a locala = com.withustudy.koudaizikao.a.c.b().at();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
      locala.a(this, arrayOfString, 101, this);
      return;
      g.b(this.mContext, "brush_c_share");
      continue;
      g.b(this.mContext, "brush_i_share");
    }
  }

  private void l()
  {
    new Thread(new c(this)).start();
  }

  protected void a()
  {
    Toast.makeText(getApplicationContext(), "取消成功!", 0).show();
    this.I.put(Integer.valueOf(this.p), Boolean.valueOf(false));
    a(((Exercises)this.f.get(this.p)).getExerciseId(), "1");
    this.A.setImageResource(2130837688);
  }

  protected void a(Message paramMessage)
  {
    RspCollectExcerBean localRspCollectExcerBean = (RspCollectExcerBean)paramMessage.obj;
    if (localRspCollectExcerBean != null)
    {
      if ("OK".equals(localRspCollectExcerBean.getStatus()))
      {
        Toast.makeText(getApplicationContext(), "收藏成功!", 0).show();
        this.I.put(Integer.valueOf(this.p), Boolean.valueOf(true));
        a(((Exercises)this.f.get(this.p)).getExerciseId(), "0");
        this.A.setImageResource(2130837677);
      }
    }
    else
      return;
    Toast.makeText(getApplicationContext(), "收藏失败!", 0).show();
  }

  public void a(Exercises paramExercises, HashMap<Integer, String> paramHashMap, boolean paramBoolean1, boolean paramBoolean2, double paramDouble1, double paramDouble2)
  {
    com.withustudy.koudaizikao.g.h.a("------------------insertToDb--------------------------------------");
    com.withustudy.koudaizikao.g.h.a("insertToDb 批次=" + this.h);
    Iterator localIterator = paramHashMap.keySet().iterator();
    UserAnsDao localUserAnsDao;
    String str1;
    String str4;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localUserAnsDao = com.withustudy.koudaizikao.e.a.a(this).a();
        a.a.a.e.i locali = localUserAnsDao.k();
        str1 = paramExercises.getExerciseId();
        KpointDetail localKpointDetail1 = paramExercises.getKpointDetail();
        String str2 = "";
        if (localKpointDetail1 != null)
        {
          Kpoint localKpoint2 = localKpointDetail1.getKpoint();
          if (localKpoint2 != null)
            str2 = localKpoint2.getId();
        }
        String str3 = str2 + str1;
        List localList = locali.a(UserAnsDao.Properties.c.a(str3), new k[0]).d();
        str4 = a(paramHashMap);
        if ((localList == null) || (localList.size() <= 0))
          break;
        koudai.db.h localh2 = (koudai.db.h)localList.get(0);
        String str7 = localh2.g();
        com.withustudy.koudaizikao.g.h.a("insertToDb 数据库的brushId=" + str7);
        localh2.d(str4);
        localh2.b(Boolean.valueOf(paramBoolean1));
        localh2.a(Double.valueOf(paramDouble1));
        localh2.a(Boolean.valueOf(paramBoolean2));
        localh2.b(Long.valueOf(System.currentTimeMillis()));
        localUserAnsDao.i(localh2);
        return;
      }
      Integer localInteger = (Integer)localIterator.next();
      com.withustudy.koudaizikao.g.h.a("insertToDb opEdit.get(" + localInteger + ")=" + (String)paramHashMap.get(localInteger));
    }
    koudai.db.h localh1 = new koudai.db.h();
    localh1.b(Long.valueOf(System.currentTimeMillis()));
    localh1.c(a(paramExercises.getCorrectAnswer()));
    KpointDetail localKpointDetail2 = paramExercises.getKpointDetail();
    String str5 = "";
    if (localKpointDetail2 != null)
    {
      Kpoint localKpoint1 = localKpointDetail2.getKpoint();
      if (localKpoint1 != null)
      {
        str5 = localKpoint1.getId();
        localh1.f(str5);
      }
    }
    String str6 = str5 + str1;
    com.withustudy.koudaizikao.g.h.a("存入的数据excerId_mKpointId", str6);
    localh1.a(str6);
    localh1.a(Double.valueOf(paramDouble1));
    localh1.a(Boolean.valueOf(paramBoolean2));
    localh1.b(Boolean.valueOf(paramBoolean1));
    localh1.e(str1);
    localh1.g(this.c);
    localh1.d(str4);
    localh1.b(this.h);
    localUserAnsDao.c(localh1);
  }

  protected void b()
  {
    if (this.E != null)
    {
      List localList = this.E.getUrls();
      if ((localList != null) && (localList.size() > 0))
      {
        Urls localUrls = (Urls)localList.get(0);
        String str1 = localUrls.getUrl_short();
        String str2 = localUrls.getUrl_long();
        com.withustudy.koudaizikao.g.h.a("url_short ", str1);
        com.withustudy.koudaizikao.g.h.a("url_long ", str2);
        this.J = new com.withustudy.koudaizikao.custom.a.a(this, this.j);
        this.J.c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        this.J.a(str2);
        this.J.d(str1);
        this.J.b("口袋自考");
        this.J.b();
      }
    }
  }

  protected void bindData()
  {
    this.B.setText(this.m);
  }

  protected void c()
  {
    List localList = this.D.getExercises();
    Boolean localBoolean = Boolean.valueOf(this.D.isEnd());
    if ((localBoolean != null) && (localBoolean.booleanValue()))
      this.F = true;
    if ((localList != null) && (localList.size() > 0))
      switch (this.l)
      {
      default:
      case 12:
      }
    while (true)
    {
      this.f.addAll(localList);
      if (this.k != null)
        break;
      this.k = new l(getSupportFragmentManager(), this.f);
      this.j.setAdapter(this.k);
      return;
      Exercises localExercises = (Exercises)localList.get(0);
      this.o = localExercises.getTotalNum();
      this.H = localExercises.getKpointDetail().getKpoint().getSn();
    }
    this.k.notifyDataSetChanged();
  }

  protected void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subjectId", this.c);
    localBundle.putSerializable("currRight", this.d);
    localBundle.putString("subjectName", this.m);
    switch (this.l)
    {
    default:
      return;
    case 12:
      localBundle.putString("mCurreSn", this.H);
      localBundle.putInt("mBrushPageFrom", 12);
      Intent localIntent3 = new Intent(getApplicationContext(), ShowCardActivity.class);
      localIntent3.putExtras(localBundle);
      startActivity(localIntent3);
      finish(0, 0);
      return;
    case 9:
      localBundle.putInt("mBrushPageFrom", 12);
      Intent localIntent2 = new Intent(getApplicationContext(), ShowCardActivity.class);
      localIntent2.putExtras(localBundle);
      startActivity(localIntent2);
      finish(0, 0);
      return;
    case 888:
    }
    localBundle.putInt("mBrushPageFrom", 888);
    Intent localIntent1 = new Intent(getApplicationContext(), IntellWecomeActivity.class);
    localIntent1.putExtras(localBundle);
    startActivity(localIntent1);
    finish(0, 0);
  }

  protected void e()
  {
    switch (this.l)
    {
    case 10:
    case 11:
    default:
    case 9:
    case 12:
    }
    do
      return;
    while ((this.f == null) || (this.p != -1 + this.f.size()));
    ReqBrushChapterGoNext localReqBrushChapterGoNext = new ReqBrushChapterGoNext();
    localReqBrushChapterGoNext.setVersionName(this.mSP.p());
    localReqBrushChapterGoNext.setClientType(n.a());
    localReqBrushChapterGoNext.setImei(n.d(this.mContext));
    localReqBrushChapterGoNext.setNet(n.c(this.mContext));
    localReqBrushChapterGoNext.setGetNextFlag(true);
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setUid(this.mSP.i());
    localUserSubject.setSubjectId(this.c);
    localReqBrushChapterGoNext.setUserSubject(localUserSubject);
    com.withustudy.koudaizikao.a.c.b().l().a(this, localReqBrushChapterGoNext, 0);
  }

  public void f()
  {
    try
    {
      int i1 = Integer.parseInt(this.o);
      if (1 + this.p < i1)
      {
        switch (this.l)
        {
        default:
        case 12:
        }
        while (1 + this.p <= -1 + this.f.size())
        {
          this.j.setCurrentItem(1 + this.p, true);
          return;
          int i2 = Integer.parseInt(((Exercises)this.D.getExercises().get(this.p)).getExerciseNo());
          if ((!this.F) || (i2 != i1))
            continue;
          d();
          return;
        }
        Toast.makeText(getApplicationContext(), "小袋努力加载中...", 0).show();
        return;
      }
      Toast.makeText(getApplicationContext(), "已经是最后一题", 0);
      d();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initData()
  {
    l();
    g();
    this.h = (this.c + System.currentTimeMillis());
  }

  protected void initListener()
  {
    try
    {
      this.z.setOnClickListener(this);
      this.C.setOnClickListener(this);
      this.b.setOnClickListener(this);
      this.x.setOnClickListener(this);
      this.j.addOnPageChangeListener(new b(this));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initView()
  {
    this.j = ((ViewPager)findViewById(2131296810));
    this.b = ((TextView)findViewById(2131296805));
    this.x = ((LinearLayout)findViewById(2131296636));
    this.z = ((LinearLayout)findViewById(2131296806));
    this.C = ((LinearLayout)findViewById(2131296808));
    this.A = ((ImageView)findViewById(2131296807));
    this.B = ((TextView)findViewById(2131296804));
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    switch (this.l)
    {
    default:
      return;
    case 12:
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.getSnReceiver");
    Bundle localBundle = new Bundle();
    localBundle.putString("mCurreSn", this.H);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
    finish();
  }

  public void onClick(View paramView)
  {
    while (true)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296805:
          switch (this.l)
          {
          default:
            if (!this.a)
              break label374;
            bool = false;
            this.a = bool;
            Intent localIntent2 = new Intent("android.intent.action.refresh");
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent2);
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_show_answer");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_show_answer");
          break;
        case 2131296636:
          switch (this.l)
          {
          default:
            finish();
            return;
          case 12:
          }
          Intent localIntent1 = new Intent();
          localIntent1.setAction("com.koudai.getSnReceiver");
          Bundle localBundle = new Bundle();
          localBundle.putString("mCurreSn", this.H);
          localIntent1.putExtras(localBundle);
          sendBroadcast(localIntent1);
          break;
        case 2131296808:
          switch (this.l)
          {
          default:
            k();
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_share");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_share");
          break;
        case 2131296806:
          switch (this.l)
          {
          default:
            j();
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_collect");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_collect");
          break;
        default:
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label374: boolean bool = true;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.J != null)
        this.J.c();
      switch (this.l)
      {
      case 888:
        a(a.b.b, 0.0D);
        return;
      case 12:
        a(a.b.a, 0.0D);
        return;
      case 9:
        a(a.b.a, 0.0D);
      case 1:
      case 3:
      case 10:
      case 17:
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
    this.mProTools.b();
    if (paramString1 != null);
    try
    {
      Gson localGson = com.withustudy.koudaizikao.a.c.a();
      switch (paramInt)
      {
      case 0:
        this.D = ((BrushExcerciseBean)localGson.fromJson(paramString1, BrushExcerciseBean.class));
        if (this.D != null)
        {
          this.G.sendEmptyMessage(0);
          return;
        }
        com.withustudy.koudaizikao.g.h.a("onSuccess 题目返回的数据=" + this.D);
        return;
      case 101:
        this.E = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
        if (this.E != null)
        {
          this.G.sendEmptyMessage(101);
          return;
        }
        com.withustudy.koudaizikao.g.h.a("加密url异常");
        return;
      case 8:
        OpreationState localOpreationState = (OpreationState)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, OpreationState.class);
        if (localOpreationState == null)
          break;
        if (localOpreationState.getStatus().equals("OK"))
        {
          this.G.sendEmptyMessage(8);
          return;
        }
        this.G.sendEmptyMessage(9);
        return;
      case 5:
        RspCollectExcerBean localRspCollectExcerBean = (RspCollectExcerBean)localGson.fromJson(paramString1, RspCollectExcerBean.class);
        if (localRspCollectExcerBean == null)
          break;
        Message localMessage = this.G.obtainMessage(5, localRspCollectExcerBean);
        this.G.sendMessage(localMessage);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903122);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.BrushExcerciseDetailActivity
 * JD-Core Version:    0.6.0
 */