package com.withustudy.koudaizikao.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.activity.InformationTypeActivity;
import com.withustudy.koudaizikao.b.o;
import com.withustudy.koudaizikao.b.q;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.AdaptiveListView;
import com.withustudy.koudaizikao.custom.AotuViewPager;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.entity.content.NewsListContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InformationFragment extends AbsBaseFragment
{
  public static final int a = 10;
  private boolean F = false;
  private a G;
  private final double b = 0.52D;
  private LoadingView c;
  private ScrollView d;
  private AotuViewPager e;
  private q f;
  private List<ImageView> g;
  private ImageView h;
  private ImageView[] i;
  private LinearLayout[] j;
  private TextView k;
  private TextView l;
  private TextView m;
  private AdaptiveListView n;
  private o o;
  private List<News> p;
  private List<News> q;
  private List<News> r;
  private List<News> s;
  private List<News> t;
  private List<News> u;
  private List<News> v;
  private News w;

  private void a(List<News> paramList)
  {
    b(paramList);
    this.f = new q(this.y, this.g, paramList);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = (int)(0.52D * this.E.y());
    this.e.setLayoutParams(localLayoutParams);
    this.e.setAdapter(this.f);
    this.e.setCurrentItem(100 * this.f.a());
    this.e.a();
  }

  private void b(List<News> paramList)
  {
    if (this.g == null)
    {
      this.g = new ArrayList();
      this.i = new ImageView[paramList.size()];
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramList.size())
      {
        return;
        this.g.clear();
        break;
      }
      this.i[i1] = new ImageView(this.y);
      this.i[i1].setBackgroundColor(Color.parseColor("#00000000"));
      this.i[i1].setImageResource(2130838068);
      this.i[i1].setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      this.i[i1].setScaleType(ImageView.ScaleType.FIT_XY);
      this.i[i1].setTag(Integer.valueOf(i1));
      this.i[i1].setOnClickListener(this.G);
      this.g.add(this.i[i1]);
    }
  }

  private void d()
  {
    this.q.clear();
    this.r.clear();
    this.s.clear();
    this.t.clear();
    this.u.clear();
    this.v.clear();
    int i1 = 0;
    int i2 = this.p.size();
    int i3 = 0;
    if (i1 >= i2);
    while (true)
    {
      if ((i3 >= this.p.size()) || (this.v.size() >= 3))
      {
        return;
        if (((News)this.p.get(i1)).getArticleType().equals("DAILY_CHEESE"))
          this.q.add((News)this.p.get(i1));
        while (true)
        {
          i1++;
          break;
          if ((((News)this.p.get(i1)).getArticleType().equals("EXAMINATION_ROAD")) && (this.r.size() < 3))
          {
            this.r.add((News)this.p.get(i1));
            continue;
          }
          if ((((News)this.p.get(i1)).getArticleType().equals("SIGN_UP_INFO")) && (this.s.size() < 3))
          {
            this.s.add((News)this.p.get(i1));
            continue;
          }
          if ((((News)this.p.get(i1)).getArticleType().equals("OFFICIAL_NEWS")) && (this.t.size() < 3))
          {
            this.t.add((News)this.p.get(i1));
            continue;
          }
          if ((!((News)this.p.get(i1)).getArticleType().equals("COMMEN_QUESTION")) || (this.u.size() >= 3))
            continue;
          this.u.add((News)this.p.get(i1));
        }
      }
      if (((News)this.p.get(i3)).getHandpickedTag().equals("1"))
        this.v.add((News)this.p.get(i3));
      i3++;
    }
  }

  private void e()
  {
    this.w = ((News)this.q.get(0));
    this.m.setText(this.w.getBriefText());
    this.k.setText(this.w.getThumbNum());
    this.l.setText(this.w.getTransmitNum());
  }

  private void f()
  {
    if (this.v.size() == 0)
    {
      this.h.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    if (this.v.size() == 1)
    {
      this.h.setVisibility(0);
      this.h.setTag(Integer.valueOf(0));
      this.e.setVisibility(8);
      this.D.a(((News)this.v.get(0)).getAttachUrl(), this.h);
      return;
    }
    this.h.setVisibility(8);
    this.e.setVisibility(0);
    a(this.v);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903159, null);
  }

  public void a()
  {
    this.G = new a();
    this.p = new ArrayList();
    this.q = new ArrayList();
    this.r = new ArrayList();
    this.s = new ArrayList();
    this.t = new ArrayList();
    this.u = new ArrayList();
    this.v = new ArrayList();
  }

  public void a(View paramView)
  {
    this.c = ((LoadingView)paramView.findViewById(2131296966));
    this.d = ((ScrollView)paramView.findViewById(2131296967));
    this.e = ((AotuViewPager)paramView.findViewById(2131296969));
    this.h = ((ImageView)paramView.findViewById(2131296968));
    this.j = new LinearLayout[5];
    this.j[0] = ((LinearLayout)paramView.findViewById(2131296970));
    this.j[1] = ((LinearLayout)paramView.findViewById(2131296971));
    this.j[2] = ((LinearLayout)paramView.findViewById(2131296972));
    this.j[3] = ((LinearLayout)paramView.findViewById(2131296973));
    this.j[4] = ((LinearLayout)paramView.findViewById(2131296974));
    this.k = ((TextView)paramView.findViewById(2131296976));
    this.l = ((TextView)paramView.findViewById(2131296978));
    this.m = ((TextView)paramView.findViewById(2131296979));
    this.n = ((AdaptiveListView)paramView.findViewById(2131296980));
  }

  public void b()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = (int)(0.52D * this.E.y());
    this.h.setLayoutParams(localLayoutParams);
  }

  public void c()
  {
    this.e.setOnPageChangeListener(this.G);
    this.h.setOnClickListener(this.G);
    this.n.setOnItemClickListener(this.G);
    this.m.setOnClickListener(this.G);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.j.length)
        return;
      this.j[i1].setOnClickListener(this.G);
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
  }

  public void onResume()
  {
    super.onResume();
    String[] arrayOfString = new String[3];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfString.length)
      {
        if (!this.E.i().equals(""))
          arrayOfString[0] = this.E.i();
        if (!this.E.q().equals(""))
          arrayOfString[1] = this.E.q();
        if (!this.E.s().equals(""))
          arrayOfString[2] = this.E.s();
        c.b().ab().a(this, arrayOfString, 10, this.y);
        return;
      }
      arrayOfString[i1] = "";
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    }
    while (true)
    {
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewsListContent localNewsListContent = (NewsListContent)c.a().fromJson(paramString1, NewsListContent.class);
        if ((localNewsListContent == null) || (localNewsListContent.getBasicNewsList() == null))
          continue;
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.p.clear();
        this.p.addAll(localNewsListContent.getBasicNewsList());
        d();
        this.o = new o(this.r, this.s, this.t, this.u, this.y);
        this.n.setFocusable(false);
        this.n.setSelector(2131034189);
        this.n.setAdapter(this.o);
        e();
        if (this.F)
          continue;
        f();
        this.F = true;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  class a
    implements ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      try
      {
        if ((paramView instanceof ImageView))
        {
          if (InformationFragment.b(InformationFragment.this).size() != 0)
          {
            g.b(InformationFragment.c(InformationFragment.this), "news_main_top");
            Bundle localBundle7 = new Bundle();
            localBundle7.putSerializable("content", (Serializable)InformationFragment.b(InformationFragment.this).get(((Integer)paramView.getTag()).intValue()));
            InformationFragment.a(InformationFragment.this, InformationDetailActivity.class, false, localBundle7);
            return;
          }
          Toast.makeText(InformationFragment.c(InformationFragment.this), "还没有推荐新闻哦", 0).show();
          return;
        }
        switch (paramView.getId())
        {
        case 2131296970:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_daily");
          Bundle localBundle6 = new Bundle();
          localBundle6.putInt("information_type", 0);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle6);
          return;
        case 2131296979:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_content_daily");
          Bundle localBundle5 = new Bundle();
          localBundle5.putSerializable("content", InformationFragment.d(InformationFragment.this));
          InformationFragment.a(InformationFragment.this, InformationDetailActivity.class, false, localBundle5);
          return;
        case 2131296971:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_road");
          Bundle localBundle4 = new Bundle();
          localBundle4.putInt("information_type", 1);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle4);
          return;
        case 2131296972:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_sign");
          Bundle localBundle3 = new Bundle();
          localBundle3.putInt("information_type", 6);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle3);
          return;
        case 2131296973:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_office");
          Bundle localBundle2 = new Bundle();
          localBundle2.putInt("information_type", 11);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle2);
          return;
        case 2131296974:
          g.b(InformationFragment.c(InformationFragment.this), "news_main_question");
          Bundle localBundle1 = new Bundle();
          localBundle1.putInt("information_type", 16);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle1);
          return;
        case 2131296975:
        case 2131296976:
        case 2131296977:
        case 2131296978:
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      try
      {
        News localNews = (News)InformationFragment.e(InformationFragment.this).getItem(paramInt);
        if ((!localNews.getArticleId().equals("-2")) && (!localNews.getArticleId().equals("-1")))
        {
          if (localNews.getArticleType().equals("EXAMINATION_ROAD"))
            g.b(InformationFragment.c(InformationFragment.this), "news_main_content_road");
          while (true)
          {
            Bundle localBundle5 = new Bundle();
            localBundle5.putSerializable("content", localNews);
            InformationFragment.a(InformationFragment.this, InformationDetailActivity.class, false, localBundle5);
            return;
            if (localNews.getArticleType().equals("SIGN_UP_INFO"))
            {
              g.b(InformationFragment.c(InformationFragment.this), "news_main_content_sign");
              continue;
            }
            if (localNews.getArticleType().equals("OFFICIAL_NEWS"))
            {
              g.b(InformationFragment.c(InformationFragment.this), "news_main_content_office");
              continue;
            }
            if (!localNews.getArticleType().equals("COMMEN_QUESTION"))
              continue;
            g.b(InformationFragment.c(InformationFragment.this), "news_main_content_question");
          }
        }
        if (localNews.getInstruction().equals("EXAMINATION_ROAD"))
        {
          g.b(InformationFragment.c(InformationFragment.this), "news_main_list_road");
          Bundle localBundle4 = new Bundle();
          localBundle4.putInt("information_type", 1);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle4);
          return;
        }
        if (localNews.getInstruction().equals("SIGN_UP_INFO"))
        {
          g.b(InformationFragment.c(InformationFragment.this), "news_main_list_sign");
          Bundle localBundle3 = new Bundle();
          localBundle3.putInt("information_type", 6);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle3);
          return;
        }
        if (localNews.getInstruction().equals("OFFICIAL_NEWS"))
        {
          g.b(InformationFragment.c(InformationFragment.this), "news_main_list_office");
          Bundle localBundle2 = new Bundle();
          localBundle2.putInt("information_type", 11);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle2);
          return;
        }
        if (localNews.getInstruction().equals("COMMEN_QUESTION"))
        {
          g.b(InformationFragment.c(InformationFragment.this), "news_main_list_question");
          Bundle localBundle1 = new Bundle();
          localBundle1.putInt("information_type", 16);
          InformationFragment.a(InformationFragment.this, InformationTypeActivity.class, false, localBundle1);
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      int i = paramInt % InformationFragment.a(InformationFragment.this).a();
      if (i < 0)
        (i + InformationFragment.a(InformationFragment.this).a());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.InformationFragment
 * JD-Core Version:    0.6.0
 */