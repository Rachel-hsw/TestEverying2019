package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.activity.ChooseProvinceActivity;
import com.withustudy.koudaizikao.activity.ChooseSubjectActivity;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.activity.MainActivity.c;
import com.withustudy.koudaizikao.activity.PostDetailActivity;
import com.withustudy.koudaizikao.activity.VideoPushLoadingActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.AotuViewPager;
import com.withustudy.koudaizikao.custom.SlidingTabLayout;
import com.withustudy.koudaizikao.custom.j;
import com.withustudy.koudaizikao.custom.j.a;
import com.withustudy.koudaizikao.entity.Carousel_list;
import com.withustudy.koudaizikao.entity.ChooseProToChooseSub;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.entity.RspBrushBannerBean;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectW;
import com.withustudy.koudaizikao.entity.content.MajorContent;
import com.withustudy.koudaizikao.entity.req.MajorUpLoad;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import krelve.view.Kanner;
import krelve.view.Kanner.c;

public class BrushMainFragment extends AbsBaseFragment
  implements MainActivity.c, j.a, Kanner.c
{
  public static final int c = 17;
  private static final int q = 100;
  private static final int r = 101;
  private List<Subject> F;
  public List<String> a;
  public List<SubjectFragment> b = new ArrayList();
  public int d;
  public List<Subject> e = new ArrayList();
  public boolean f = false;
  private ViewPager g;
  private SlidingTabLayout h;
  private AotuViewPager i;
  private ImageView j;
  private List<News> k;
  private List<ImageView> l;
  private ImageView[] m;
  private Kanner n;
  private int o;
  private int p;
  private SubjectW s;
  private MajorContent t;
  private j u;
  private List<Carousel_list> v;
  private Handler w = new a(this);

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2130903166, null);
  }

  public void a()
  {
    this.B.a(true);
    String str = this.E.i();
    com.withustudy.koudaizikao.a.c.b().N().a(this, new String[] { str }, 101, this.y);
    com.withustudy.koudaizikao.a.a locala = com.withustudy.koudaizikao.a.c.b().aE();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = this.E.s();
    locala.a(this, arrayOfString, 17, this.y);
  }

  public void a(int paramInt)
  {
    ((SubjectFragment)this.b.get(paramInt)).a(paramInt, (Subject)this.e.get(paramInt));
  }

  public void a(View paramView)
  {
    this.g = ((ViewPager)paramView.findViewById(2131296861));
    this.h = ((SlidingTabLayout)paramView.findViewById(2131297093));
    this.n = ((Kanner)paramView.findViewById(2131297095));
    this.n.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
    this.n.setOnBanerItemClickListener(this);
  }

  public void b()
  {
  }

  public void b(int paramInt)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    String[] arrayOfString;
    Intent localIntent;
    if ((this.v != null) && (this.v.size() > 0))
    {
      Carousel_list localCarousel_list = (Carousel_list)this.v.get(paramInt - 1);
      str1 = localCarousel_list.getCategory();
      str2 = localCarousel_list.getType();
      str3 = localCarousel_list.getItem();
      if ((!str1.equals("资讯")) && (!str1.equals("社区")))
        break label218;
      str4 = str1 + ";口袋自考;标题;" + str3 + ";";
      if ((str4 != null) && (!str4.equals("")))
      {
        arrayOfString = str4.split(";");
        localIntent = new Intent();
        if (!arrayOfString[0].equals("资讯"))
          break label280;
        localIntent.setClass(getActivity(), InformationDetailActivity.class);
        Bundle localBundle3 = new Bundle();
        localBundle3.putInt("id", Integer.valueOf(arrayOfString[3]).intValue());
        localBundle3.putBoolean("push", true);
        localIntent.setFlags(268435456);
        localIntent.putExtras(localBundle3);
        startActivity(localIntent);
      }
    }
    label218: 
    do
    {
      return;
      if (str1.equals("课堂"))
      {
        str4 = str1 + ";" + str2 + ";口袋自考;标题;" + str3 + ";";
        break;
      }
      str4 = "其他;";
      break;
      if (!arrayOfString[0].equals("社区"))
        continue;
      localIntent.setClass(getActivity(), PostDetailActivity.class);
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("id", Integer.valueOf(arrayOfString[3]).intValue());
      localBundle2.putBoolean("push", true);
      localIntent.setFlags(268435456);
      localIntent.putExtras(localBundle2);
      startActivity(localIntent);
      return;
    }
    while (!arrayOfString[0].equals("课堂"));
    label280: localIntent.setClass(getActivity(), VideoPushLoadingActivity.class);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("data", str4);
    localIntent.setFlags(268435456);
    localIntent.putExtras(localBundle1);
    startActivity(localIntent);
  }

  public void c()
  {
    this.h.setOnPageChangeListener(new d(this));
    this.g.setOnPageChangeListener(new e(this));
  }

  public void d()
  {
  }

  public void e()
  {
    this.e.clear();
    if (this.a == null)
      this.a = new ArrayList();
    this.a.clear();
    this.b = new ArrayList();
    this.b.clear();
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.g.setOffscreenPageLimit(1);
        h.a("BrushSubjectIndex", Integer.valueOf(this.E.g()));
        this.u = new f(this, getChildFragmentManager());
        this.u.a(this);
        this.g.setAdapter(this.u);
        this.h.setViewPager(this.g);
        this.f = true;
        return;
      }
      String str = ((Subject)localIterator.next()).getName().replace("（", "(").replace("）", ")");
      this.a.add(str);
      SubjectFragment localSubjectFragment = new SubjectFragment();
      new Bundle();
      this.b.add(localSubjectFragment);
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ((MainActivity)paramActivity).setReListener(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.E.d(false);
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if ((!paramBoolean) && (this.f))
    {
      if (this.E.w())
      {
        this.E.a(0);
        this.B.a(true);
        String str = this.E.i();
        com.withustudy.koudaizikao.a.c.b().N().a(this, new String[] { str }, 101, this.y);
        this.E.d(false);
      }
      this.f = false;
    }
  }

  public void onResume()
  {
    System.out.println("onResume ");
    super.onResume();
    if (com.withustudy.koudaizikao.d.f.a(getActivity()).e())
    {
      if (this.f)
      {
        if (this.E.w())
        {
          this.E.a(0);
          this.B.a(true);
          String str = this.E.i();
          com.withustudy.koudaizikao.a.c.b().N().a(this, new String[] { str }, 101, this.y);
          this.E.d(false);
        }
        this.f = false;
      }
      com.withustudy.koudaizikao.d.f.a(getActivity()).b(false);
    }
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    if (paramString1 != null);
    try
    {
      Gson localGson = com.withustudy.koudaizikao.a.c.a();
      switch (paramInt)
      {
      case 17:
        h.a("rsp=" + paramString1);
        RspBrushBannerBean localRspBrushBannerBean = (RspBrushBannerBean)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, RspBrushBannerBean.class);
        if (localRspBrushBannerBean == null)
          break;
        Message localMessage = this.w.obtainMessage();
        localMessage.obj = localRspBrushBannerBean;
        localMessage.what = 17;
        this.w.sendMessage(localMessage);
        return;
      case 100:
        this.s = ((SubjectW)localGson.fromJson(paramString1, SubjectW.class));
        if (this.s != null)
        {
          h.a(this.s);
          this.w.sendEmptyMessage(100);
          return;
        }
        h.a("科目id解析异常");
        return;
      case 101:
        this.t = ((MajorContent)localGson.fromJson(paramString1, MajorContent.class));
        if (this.t != null)
        {
          MajorUpLoad localMajorUpLoad = this.t.getMajor();
          if ((localMajorUpLoad == null) || (localMajorUpLoad.getProvId().equals("")) || (localMajorUpLoad.getProvName().equals("")) || (localMajorUpLoad.getMajorId().equals("")) || (localMajorUpLoad.getMajorName().equals("")))
          {
            Toast.makeText(getActivity(), "请先选择专业信息", 0).show();
            this.E.b(true);
            a(ChooseProvinceActivity.class, false, null);
            return;
          }
          this.E.p(localMajorUpLoad.getMajorName());
          this.E.n(localMajorUpLoad.getProvName());
          this.E.o(localMajorUpLoad.getMajorId());
          this.E.m(localMajorUpLoad.getProvId());
          this.F = this.t.getSubject();
          if ((this.F != null) && (this.F.size() > 0))
          {
            this.w.sendEmptyMessage(100);
            return;
          }
          Toast.makeText(getActivity(), "请填报科目", 0).show();
          ChooseProToChooseSub localChooseProToChooseSub = new ChooseProToChooseSub();
          localChooseProToChooseSub.setProId(this.E.q());
          localChooseProToChooseSub.setProvName(this.E.r());
          localChooseProToChooseSub.setMajorId(this.E.s());
          localChooseProToChooseSub.setMajorName(this.E.t());
          Bundle localBundle = new Bundle();
          localBundle.putSerializable("Major", localChooseProToChooseSub);
          a(ChooseSubjectActivity.class, false, localBundle);
          return;
        }
        h.a("解析用户的专业信息异常");
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.BrushMainFragment
 * JD-Core Version:    0.6.0
 */