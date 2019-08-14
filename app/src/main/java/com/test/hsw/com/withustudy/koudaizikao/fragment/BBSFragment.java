package com.withustudy.koudaizikao.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.activity.AllSectionActivity;
import com.withustudy.koudaizikao.activity.BbsHotActivity;
import com.withustudy.koudaizikao.activity.SectionDetailActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import com.withustudy.koudaizikao.entity.content.ForumsContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BBSFragment extends AbsBaseFragment
{
  public static a a;
  public static final String b = "type";
  public static final int c = 1;
  private Button d;
  private LinearLayout e;
  private LinearLayout f;
  private LoadingView g;
  private PullToRefreshListView h;
  private List<Forum> i;
  private com.withustudy.koudaizikao.b.c j;
  private b k;
  private String[] l;
  private boolean m = false;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903148, null);
  }

  public void a()
  {
    this.l = new String[3];
    this.l[0] = this.E.i();
    this.l[1] = this.E.q();
    this.l[2] = this.E.s();
    this.k = new b();
    a = new a(this);
    this.i = new ArrayList();
    this.j = new com.withustudy.koudaizikao.b.c(this.y, 1);
    this.j.a(this.i);
  }

  public void a(View paramView)
  {
    this.d = ((Button)paramView.findViewById(2131296937));
    this.e = ((LinearLayout)paramView.findViewById(2131296938));
    this.f = ((LinearLayout)paramView.findViewById(2131296939));
    this.g = ((LoadingView)paramView.findViewById(2131296941));
    this.h = ((PullToRefreshListView)paramView.findViewById(2131296940));
  }

  public void b()
  {
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    this.h.setAdapter(this.j);
    com.withustudy.koudaizikao.g.n.a("PULL_FROM_END", this.h, this.y);
    a.sendEmptyMessage(1);
  }

  public void c()
  {
    this.d.setOnClickListener(this.k);
    this.e.setOnClickListener(this.k);
    this.f.setOnClickListener(this.k);
    this.h.setOnItemClickListener(this.k);
    this.h.setOnRefreshListener(this.k);
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.m = false;
    this.h.f();
    Toast.makeText(this.y, getResources().getString(2131165528), 0).show();
  }

  public void onResume()
  {
    super.onResume();
    if (!this.l[0].equals(this.E.i()))
    {
      this.l[0] = this.E.i();
      this.l[1] = this.E.q();
      this.l[2] = this.E.s();
      a.sendEmptyMessage(1);
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.m = false;
    this.h.f();
    Gson localGson;
    if (paramString1 != null)
      localGson = new Gson();
    try
    {
      ForumsContent localForumsContent = (ForumsContent)localGson.fromJson(paramString1, ForumsContent.class);
      if (localForumsContent != null)
      {
        this.i.clear();
        this.i.addAll(localForumsContent.getForums());
        this.j.notifyDataSetChanged();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static class a extends com.withustudy.koudaizikao.base.n<BBSFragment>
  {
    public a(BBSFragment paramBBSFragment)
    {
      super();
    }

    protected void a(BBSFragment paramBBSFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
      }
      BBSFragment.a(paramBBSFragment, true);
      com.withustudy.koudaizikao.a.c.b().q().a(paramBBSFragment, BBSFragment.a(paramBBSFragment), 1, BBSFragment.b(paramBBSFragment));
    }
  }

  class b
    implements View.OnClickListener, AdapterView.OnItemClickListener, PullToRefreshBase.e<ListView>
  {
    b()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!BBSFragment.d(BBSFragment.this))
        BBSFragment.a.sendEmptyMessage(1);
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296937:
        g.b(BBSFragment.b(BBSFragment.this), "bbs_all");
        BBSFragment.a(BBSFragment.this, AllSectionActivity.class, false, null);
        return;
      case 2131296938:
        g.b(BBSFragment.b(BBSFragment.this), "bbs_hot_post");
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("type", 0);
        BBSFragment.a(BBSFragment.this, BbsHotActivity.class, false, localBundle2);
        return;
      case 2131296939:
      }
      g.b(BBSFragment.b(BBSFragment.this), "bbs_hot_section");
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("type", 1);
      BBSFragment.a(BBSFragment.this, BbsHotActivity.class, false, localBundle1);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      g.b(BBSFragment.b(BBSFragment.this), "bbs_into_followed_section");
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("receive_code", (Serializable)BBSFragment.c(BBSFragment.this).get(paramInt - 1));
      BBSFragment.a(BBSFragment.this, SectionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.BBSFragment
 * JD-Core Version:    0.6.0
 */