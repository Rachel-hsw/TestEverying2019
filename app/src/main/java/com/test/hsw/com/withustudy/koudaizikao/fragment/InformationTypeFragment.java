package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.b.p;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.entity.content.NewsListContent;
import com.withustudy.koudaizikao.g.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InformationTypeFragment extends AbsBaseFragment
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 10;
  public static final int d = 11;
  private LoadingView e;
  private PullToRefreshListView f;
  private p g;
  private List<News> h;
  private boolean i = false;
  private boolean j = false;
  private a k;
  private int l;
  private String[] m;

  public InformationTypeFragment()
  {
    this.l = 0;
  }

  public InformationTypeFragment(int paramInt)
  {
    this.l = paramInt;
  }

  private void a(int paramInt)
  {
    this.h.clear();
    if (this.g != null)
      this.g.notifyDataSetChanged();
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.m[0] = "DAILY_CHEESE";
      return;
    case 1:
      this.m[0] = "EXAMINATION_ROAD";
      return;
    case 2:
      this.m[0] = "SIGN_UP_INFO";
      return;
    case 3:
      this.m[0] = "OFFICIAL_NEWS";
      return;
    case 4:
    }
    this.m[0] = "COMMEN_QUESTION";
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903160, null);
  }

  public void a()
  {
    this.k = new a();
    this.m = new String[5];
    for (int n = 0; ; n++)
    {
      if (n >= 5)
      {
        this.h = new ArrayList();
        a(this.l);
        this.m[1] = String.valueOf(this.h.size());
        this.m[2] = this.E.q();
        this.m[3] = this.E.s();
        this.m[4] = this.E.i();
        return;
      }
      this.m[n] = "";
    }
  }

  public void a(View paramView)
  {
    this.f = ((PullToRefreshListView)paramView.findViewById(2131296982));
    this.e = ((LoadingView)paramView.findViewById(2131296981));
  }

  public void a(String paramString)
  {
    if ((this.h != null) && (this.g != null));
    for (int n = 0; ; n++)
    {
      if (n >= this.h.size())
      {
        this.g.notifyDataSetChanged();
        return;
      }
      if (!((News)this.h.get(n)).getArticleId().equals(paramString))
        continue;
      ((News)this.h.get(n)).setCommentNum(String.valueOf(1 + Integer.valueOf(((News)this.h.get(n)).getCommentNum()).intValue()));
    }
  }

  public void a(String paramString, int paramInt)
  {
    int n;
    if (this.h != null)
    {
      n = 0;
      if (n < this.h.size());
    }
    else
    {
      return;
    }
    if (((News)this.h.get(n)).getArticleId().equals(paramString))
      switch (paramInt)
      {
      case 21:
      default:
      case 24:
      case 22:
      case 23:
      }
    while (true)
    {
      n++;
      break;
      if (((News)this.h.get(n)).getFavoriteTag().equals("0"))
        ((News)this.h.get(n)).setFavoriteTag("1");
      while (true)
      {
        if (!((News)this.h.get(n)).getThumbTag().equals("0"))
          break label190;
        ((News)this.h.get(n)).setThumbTag("1");
        break;
        ((News)this.h.get(n)).setFavoriteTag("0");
      }
      label190: ((News)this.h.get(n)).setThumbTag("0");
      continue;
      if (((News)this.h.get(n)).getFavoriteTag().equals("0"))
      {
        ((News)this.h.get(n)).setFavoriteTag("1");
        continue;
      }
      ((News)this.h.get(n)).setFavoriteTag("0");
      continue;
      if (((News)this.h.get(n)).getThumbTag().equals("0"))
      {
        ((News)this.h.get(n)).setThumbTag("1");
        continue;
      }
      ((News)this.h.get(n)).setThumbTag("0");
    }
  }

  public void b()
  {
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    n.a(true, this.f, this.y);
  }

  public void c()
  {
    this.f.setOnRefreshListener(this.k);
    this.f.setOnItemClickListener(this.k);
  }

  public void d()
  {
    if ((this.h != null) && (this.h.size() == 0))
      c.b().Q().a(this, this.m, 10, this.y);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.f.f();
      this.i = false;
      return;
    case 11:
    }
    this.f.f();
    this.j = false;
  }

  public void onResume()
  {
    super.onResume();
    this.m[2] = this.E.q();
    this.m[3] = this.E.s();
    this.m[4] = this.E.i();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    do
    {
      do
      {
        return;
        this.f.f();
        this.i = false;
      }
      while (paramString1 == null);
      try
      {
        NewsListContent localNewsListContent2 = (NewsListContent)c.a().fromJson(paramString1, NewsListContent.class);
        if ((localNewsListContent2 != null) && (localNewsListContent2.getBasicNewsList() != null))
        {
          this.h.clear();
          this.h.addAll(localNewsListContent2.getBasicNewsList());
          this.g = new p(this.y, this.h);
          this.f.setAdapter(this.g);
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.e.setVisibility(8);
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      this.e.setVisibility(8);
      return;
      this.f.f();
      this.j = false;
    }
    while (paramString1 == null);
    try
    {
      NewsListContent localNewsListContent1 = (NewsListContent)c.a().fromJson(paramString1, NewsListContent.class);
      if ((localNewsListContent1 != null) && (localNewsListContent1.getBasicNewsList() != null))
      {
        this.h.addAll(localNewsListContent1.getBasicNewsList());
        this.g.notifyDataSetChanged();
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    Toast.makeText(this.y, "已经没有更多资讯了哦", 0).show();
  }

  class a
    implements AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!InformationTypeFragment.a(InformationTypeFragment.this))
      {
        InformationTypeFragment.a(InformationTypeFragment.this, true);
        InformationTypeFragment.b(InformationTypeFragment.this)[1] = "0";
        c.b().Q().a(InformationTypeFragment.this, InformationTypeFragment.b(InformationTypeFragment.this), 10, InformationTypeFragment.c(InformationTypeFragment.this));
      }
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!InformationTypeFragment.d(InformationTypeFragment.this))
      {
        InformationTypeFragment.b(InformationTypeFragment.this, true);
        InformationTypeFragment.b(InformationTypeFragment.this)[1] = String.valueOf(InformationTypeFragment.e(InformationTypeFragment.this).size());
        c.b().Q().a(InformationTypeFragment.this, InformationTypeFragment.b(InformationTypeFragment.this), 11, InformationTypeFragment.c(InformationTypeFragment.this));
      }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("content", (Serializable)InformationTypeFragment.e(InformationTypeFragment.this).get(paramInt - 1));
      InformationTypeFragment.a(InformationTypeFragment.this, InformationDetailActivity.class, 20, localBundle);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.InformationTypeFragment
 * JD-Core Version:    0.6.0
 */