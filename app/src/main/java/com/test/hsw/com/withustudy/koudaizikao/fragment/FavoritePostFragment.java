package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.PostDetailActivity;
import com.withustudy.koudaizikao.b.t;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.base.n;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.p;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.content.PostContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FavoritePostFragment extends AbsBaseFragment
{
  public static final int a = 1;
  public static final int b = 10;
  private SwipyRefreshLayout c;
  private LinearLayout d;
  private ListView e;
  private List<Post> f;
  private t g;
  private b h;
  private a i;
  private final int j = 1;
  private final int k = 500;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903157, null);
  }

  public void a()
  {
    this.i = new a();
    this.h = new b(this);
    this.f = new ArrayList();
    this.g = new t(this.y, this.f, this.h);
  }

  public void a(View paramView)
  {
    this.c = ((SwipyRefreshLayout)paramView.findViewById(2131296963));
    this.e = ((ListView)paramView.findViewById(2131296964));
    this.d = ((LinearLayout)paramView.findViewById(2131296962));
  }

  public void b()
  {
    this.e.setAdapter(this.g);
  }

  public void c()
  {
    this.c.setOnRefreshListener(this.i);
    this.e.setOnScrollListener(this.i);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.c.setRefreshing(false);
  }

  public void onResume()
  {
    super.onResume();
    a locala = c.b().ah();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = String.valueOf(1);
    arrayOfString[2] = String.valueOf(500);
    locala.a(this, arrayOfString, 10, this.y);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.c.setRefreshing(false);
    switch (paramInt)
    {
    default:
    case 10:
    }
    do
      return;
    while (paramString1 == null);
    try
    {
      PostContent localPostContent = (PostContent)c.a().fromJson(paramString1, PostContent.class);
      if ((localPostContent == null) || (!localPostContent.getResult().equals("true")))
        break label191;
      if (localPostContent.getTopics().size() != 0)
      {
        this.e.setVisibility(0);
        this.d.setVisibility(8);
        this.f.clear();
        this.f.addAll(localPostContent.getTopics());
        this.g.notifyDataSetChanged();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.e.setVisibility(8);
      this.d.setVisibility(0);
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    this.e.setVisibility(8);
    this.d.setVisibility(0);
    return;
    label191: this.e.setVisibility(8);
    this.d.setVisibility(0);
    Toast.makeText(this.y, "服务器未能返回数据，请稍后再试", 0).show();
  }

  class a
    implements AbsListView.OnScrollListener, SwipyRefreshLayout.a
  {
    a()
    {
    }

    public void a(p paramp)
    {
      FavoritePostFragment.a(FavoritePostFragment.this).setRefreshing(true);
      a locala = c.b().ah();
      FavoritePostFragment localFavoritePostFragment = FavoritePostFragment.this;
      String[] arrayOfString = new String[3];
      arrayOfString[0] = FavoritePostFragment.b(FavoritePostFragment.this).i();
      arrayOfString[1] = String.valueOf(1);
      arrayOfString[2] = String.valueOf(500);
      locala.a(localFavoritePostFragment, arrayOfString, 10, FavoritePostFragment.c(FavoritePostFragment.this));
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0)
      {
        FavoritePostFragment.a(FavoritePostFragment.this).setEnabled(true);
        return;
      }
      FavoritePostFragment.a(FavoritePostFragment.this).setEnabled(false);
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }

  public static class b extends n<FavoritePostFragment>
  {
    public b(FavoritePostFragment paramFavoritePostFragment)
    {
      super();
    }

    protected void a(FavoritePostFragment paramFavoritePostFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
      }
      FavoritePostFragment.a(paramFavoritePostFragment, PostDetailActivity.class, false, (Bundle)paramMessage.obj);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.FavoritePostFragment
 * JD-Core Version:    0.6.0
 */