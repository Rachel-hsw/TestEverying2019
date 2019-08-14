package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.entity.content.NewsListContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FavoriteNewsFragment extends AbsBaseFragment
{
  public static final int a = 10;
  private SwipyRefreshLayout b;
  private LinearLayout c;
  private ListView d;
  private List<News> e;
  private com.withustudy.koudaizikao.b.p f;
  private a g;

  private void d()
  {
    a locala = c.b().ac();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.E.i();
    locala.a(this, arrayOfString, 10, this.y);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903156, null);
  }

  public void a()
  {
    this.g = new a();
    this.e = new ArrayList();
    this.f = new com.withustudy.koudaizikao.b.p(this.y, this.e);
  }

  public void a(View paramView)
  {
    this.b = ((SwipyRefreshLayout)paramView.findViewById(2131296960));
    this.d = ((ListView)paramView.findViewById(2131296961));
    this.c = ((LinearLayout)paramView.findViewById(2131296959));
  }

  public void a(String paramString, int paramInt)
  {
    int i = 0;
    if (i >= this.e.size())
      return;
    if (((News)this.e.get(i)).getArticleId().equals(paramString))
      switch (paramInt)
      {
      case 21:
      default:
      case 22:
      case 24:
      case 23:
      }
    while (true)
    {
      i++;
      break;
      d();
      continue;
      if (((News)this.e.get(i)).getThumbTag().equals("0"))
      {
        ((News)this.e.get(i)).setThumbTag("1");
        continue;
      }
      ((News)this.e.get(i)).setThumbTag("0");
    }
  }

  public void b()
  {
    this.d.setAdapter(this.f);
    d();
  }

  public void c()
  {
    this.d.setOnItemClickListener(this.g);
    this.d.setOnScrollListener(this.g);
    this.b.setOnRefreshListener(this.g);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.b.setRefreshing(false);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.b.setRefreshing(false);
    switch (paramInt)
    {
    default:
    case 10:
    }
    do
      return;
    while (paramString1 == null);
    NewsListContent localNewsListContent;
    try
    {
      localNewsListContent = (NewsListContent)c.a().fromJson(paramString1, NewsListContent.class);
      if ((localNewsListContent == null) || (localNewsListContent.getBasicNewsList() == null))
        break label169;
      if (localNewsListContent.getBasicNewsList().size() == 0)
      {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.e.clear();
    this.e.addAll(localNewsListContent.getBasicNewsList());
    this.f.notifyDataSetChanged();
    return;
    label169: this.c.setVisibility(0);
    this.d.setVisibility(8);
  }

  class a
    implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, SwipyRefreshLayout.a
  {
    a()
    {
    }

    public void a(com.withustudy.koudaizikao.custom.swipyrefresh.p paramp)
    {
      FavoriteNewsFragment.b(FavoriteNewsFragment.this).setRefreshing(true);
      FavoriteNewsFragment.c(FavoriteNewsFragment.this);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("content", (Serializable)FavoriteNewsFragment.a(FavoriteNewsFragment.this).get(paramInt));
      FavoriteNewsFragment.a(FavoriteNewsFragment.this, InformationDetailActivity.class, 20, localBundle);
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0)
      {
        FavoriteNewsFragment.b(FavoriteNewsFragment.this).setEnabled(true);
        return;
      }
      FavoriteNewsFragment.b(FavoriteNewsFragment.this).setEnabled(false);
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.FavoriteNewsFragment
 * JD-Core Version:    0.6.0
 */