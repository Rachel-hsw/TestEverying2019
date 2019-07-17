package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.ab;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.SimpleResult;
import com.withustudy.koudaizikao.entity.content.PostContent;
import com.withustudy.koudaizikao.fragment.BBSFragment;
import com.withustudy.koudaizikao.fragment.BBSFragment.a;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SectionDetailActivity extends AbsBaseActivity
{
  public static final String a = "all";
  public static final String b = "elite";
  public static final String c = "receive_code";
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 10;
  public static final int i = 11;
  public static final int j = 12;
  public static final int k = 20;
  public static final int l = 21;
  public static final int m = 22;
  public static final int n = 23;
  public static final int o = 24;
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private LoadingView E;
  private PullToRefreshListView F;
  private List<Post> G;
  private int H;
  private List<Post> I;
  private ab J;
  private a K;
  private b L;
  private Forum M;
  private String N;
  private boolean O = false;
  private final int P = 8;
  private int Q = 1;
  private String[] R;
  private SwipeRefreshLayout p;
  private Button q;
  private LinearLayout r;
  private LinearLayout s;
  private Button t;
  private Button u;
  private ImageView v;
  private ImageView w;
  private Button x;
  private ImageView y;
  private TextView z;

  private void a()
  {
    this.R = new String[6];
    this.R[0] = this.mSP.i();
    this.R[1] = String.valueOf(this.M.getForum_id());
    this.R[2] = String.valueOf(this.Q);
    this.R[3] = String.valueOf(8);
    this.R[4] = "3";
    if (this.N.equals("all"))
    {
      this.R[5] = "0";
      return;
    }
    this.R[5] = "1";
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.t.setTextColor(Color.parseColor("#ffffff"));
      this.v.setVisibility(0);
      this.u.setTextColor(Color.parseColor("#DCDCDC"));
      this.w.setVisibility(4);
    }
    for (this.N = "all"; ; this.N = "elite")
    {
      this.Q = 1;
      a();
      c.b().z().a(this, this.R, 10, this.mContext);
      return;
      this.u.setTextColor(Color.parseColor("#ffffff"));
      this.w.setVisibility(0);
      this.t.setTextColor(Color.parseColor("#DCDCDC"));
      this.v.setVisibility(4);
    }
  }

  protected void bindData()
  {
    if ((this.M.getForum_img() != null) && (!this.M.getForum_img().equals("")))
      this.mFileDownLoad.a(this.M.getForum_img(), this.y);
    n.a("PULL_FROM_END", this.F, this.mContext);
    this.E.setVisibility(0);
    a(0);
  }

  protected void initData()
  {
    this.M = ((Forum)getIntent().getExtras().getSerializable("receive_code"));
    this.K = new a();
    this.L = new b(this);
    this.G = new ArrayList();
    this.I = new ArrayList();
  }

  protected void initListener()
  {
    this.q.setOnClickListener(this.K);
    this.r.setOnClickListener(this.K);
    this.s.setOnClickListener(this.K);
    this.p.setOnRefreshListener(this.K);
    this.F.setOnScrollListener(this.K);
    this.F.setOnRefreshListener(this.K);
    this.x.setOnClickListener(this.K);
    this.D.setOnClickListener(this.K);
  }

  protected void initView()
  {
    this.p = ((SwipeRefreshLayout)findViewById(2131296678));
    this.q = ((Button)findViewById(2131296664));
    this.r = ((LinearLayout)findViewById(2131296665));
    this.s = ((LinearLayout)findViewById(2131296668));
    this.t = ((Button)findViewById(2131296666));
    this.u = ((Button)findViewById(2131296669));
    this.v = ((ImageView)findViewById(2131296667));
    this.w = ((ImageView)findViewById(2131296670));
    this.x = ((Button)findViewById(2131296671));
    this.y = ((ImageView)findViewById(2131296672));
    this.z = ((TextView)findViewById(2131296674));
    this.A = ((TextView)findViewById(2131296675));
    this.B = ((TextView)findViewById(2131296676));
    this.C = ((TextView)findViewById(2131296677));
    this.D = ((TextView)findViewById(2131296673));
    this.E = ((LoadingView)findViewById(2131296680));
    this.F = ((PullToRefreshListView)findViewById(2131296679));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 21) || (paramInt2 == 23))
    {
      this.mProTools.a(true);
      this.Q = 1;
      a();
      c.b().z().a(this, this.R, 10, this.mContext);
      if (paramInt2 == 21)
        this.M.setForum_topics(-1 + this.M.getForum_topics());
    }
    do
    {
      return;
      this.M.setForum_topics(1 + this.M.getForum_topics());
      return;
    }
    while (paramInt2 != 24);
    Post localPost = (Post)paramIntent.getBundleExtra("result").getSerializable("change");
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.I.size())
      {
        this.J.notifyDataSetChanged();
        return;
      }
      if (((Post)this.I.get(i1)).getTopic_id() != localPost.getTopic_id())
        continue;
      this.I.remove(i1);
      this.I.add(i1, localPost);
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.p.setRefreshing(false);
      return;
    case 11:
    }
    this.O = false;
    this.F.f();
  }

  protected void onResume()
  {
    super.onResume();
    this.z.setText(this.M.getForum_name());
    this.A.setText(String.valueOf(this.M.getForum_user()));
    this.B.setText(String.valueOf(this.M.getForum_topics()));
    this.C.setText(String.valueOf(this.M.getForum_reply()));
    if (!this.mSP.i().equals(""))
    {
      this.D.setVisibility(0);
      if (this.M.getForum_isfollow() == 1)
      {
        this.D.setBackgroundResource(2130837581);
        this.D.setText(getResources().getString(2131165496));
        return;
      }
      this.D.setBackgroundResource(2130837587);
      this.D.setText(getResources().getString(2131165493));
      return;
    }
    this.D.setVisibility(8);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    this.E.setVisibility(8);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    case 12:
    }
    do
    {
      do
      {
        do
        {
          return;
          this.p.setRefreshing(false);
        }
        while (paramString1 == null);
        try
        {
          PostContent localPostContent2 = (PostContent)c.a().fromJson(paramString1, PostContent.class);
          if ((localPostContent2 != null) && (localPostContent2.getResult().equals("true")))
          {
            this.M = localPostContent2.getForum();
            this.G.clear();
            if (localPostContent2.getTopTopics() != null)
            {
              this.H = localPostContent2.getTopTopics().size();
              this.G.addAll(localPostContent2.getTopTopics());
            }
            if (localPostContent2.getTopics() != null)
              this.G.addAll(localPostContent2.getTopics());
            this.L.sendEmptyMessage(1);
            return;
          }
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        Toast.makeText(this.mContext, "这个模块还没有任何帖子", 0).show();
        return;
        this.O = false;
        this.F.f();
      }
      while (paramString1 == null);
      try
      {
        PostContent localPostContent1 = (PostContent)c.a().fromJson(paramString1, PostContent.class);
        if ((localPostContent1 != null) && (localPostContent1.getResult().equals("true")))
        {
          this.M = localPostContent1.getForum();
          if (localPostContent1.getTopics() != null)
            this.G.addAll(localPostContent1.getTopics());
          this.L.sendEmptyMessage(2);
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "这个模块还没有任何帖子", 0).show();
      return;
    }
    while (paramString1 == null);
    try
    {
      SimpleResult localSimpleResult = (SimpleResult)c.a().fromJson(paramString1, SimpleResult.class);
      if (localSimpleResult != null)
      {
        this.L.sendMessage(this.L.obtainMessage(3, localSimpleResult.getResult()));
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
  }

  protected void setContentView()
  {
    setContentView(2130903104);
  }

  class a
    implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, AbsListView.OnScrollListener, PullToRefreshBase.e<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!SectionDetailActivity.o(SectionDetailActivity.this))
      {
        SectionDetailActivity.a(SectionDetailActivity.this, true);
        SectionDetailActivity localSectionDetailActivity = SectionDetailActivity.this;
        SectionDetailActivity.a(localSectionDetailActivity, 1 + SectionDetailActivity.p(localSectionDetailActivity));
        SectionDetailActivity.k(SectionDetailActivity.this);
        c.b().z().a(SectionDetailActivity.this, SectionDetailActivity.l(SectionDetailActivity.this), 11, SectionDetailActivity.i(SectionDetailActivity.this));
      }
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296666:
      case 2131296667:
      case 2131296669:
      case 2131296670:
      case 2131296672:
      default:
        return;
      case 2131296673:
        if (SectionDetailActivity.m(SectionDetailActivity.this).i().equals(""))
        {
          Toast.makeText(SectionDetailActivity.i(SectionDetailActivity.this), "请先登录", 0).show();
          return;
        }
        String[] arrayOfString = new String[3];
        arrayOfString[0] = SectionDetailActivity.m(SectionDetailActivity.this).i();
        arrayOfString[1] = String.valueOf(SectionDetailActivity.g(SectionDetailActivity.this).getForum_id());
        if (SectionDetailActivity.g(SectionDetailActivity.this).getForum_isfollow() == 0)
        {
          g.b(SectionDetailActivity.i(SectionDetailActivity.this), "bbs_follow");
          h.a("关注");
          arrayOfString[2] = "follow";
          c.b().y().a(SectionDetailActivity.this, arrayOfString, 12, SectionDetailActivity.i(SectionDetailActivity.this));
        }
        while (true)
        {
          SectionDetailActivity.n(SectionDetailActivity.this).a(true);
          return;
          h.a("取消关注");
          arrayOfString[2] = "unfollow";
          c.b().y().a(SectionDetailActivity.this, arrayOfString, 12, SectionDetailActivity.i(SectionDetailActivity.this));
        }
      case 2131296664:
        SectionDetailActivity.this.finish();
        return;
      case 2131296665:
        SectionDetailActivity.b(SectionDetailActivity.this, 0);
        return;
      case 2131296668:
        SectionDetailActivity.b(SectionDetailActivity.this, 1);
        return;
      case 2131296671:
      }
      if (SectionDetailActivity.m(SectionDetailActivity.this).i().equals(""))
      {
        Toast.makeText(SectionDetailActivity.i(SectionDetailActivity.this), "请先登录", 0).show();
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", SectionDetailActivity.g(SectionDetailActivity.this).getForum_id());
      SectionDetailActivity.this.startNewActivityForResult(AddPostActivity.class, 22, localBundle);
    }

    public void onRefresh()
    {
      SectionDetailActivity.j(SectionDetailActivity.this).setRefreshing(true);
      SectionDetailActivity.a(SectionDetailActivity.this, 1);
      SectionDetailActivity.k(SectionDetailActivity.this);
      c.b().z().a(SectionDetailActivity.this, SectionDetailActivity.l(SectionDetailActivity.this), 10, SectionDetailActivity.i(SectionDetailActivity.this));
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0)
      {
        SectionDetailActivity.j(SectionDetailActivity.this).setEnabled(true);
        return;
      }
      SectionDetailActivity.j(SectionDetailActivity.this).setEnabled(false);
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }

  private static class b extends m<SectionDetailActivity>
  {
    public b(SectionDetailActivity paramSectionDetailActivity)
    {
      super();
    }

    protected void a(SectionDetailActivity paramSectionDetailActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 2:
      case 3:
        do
        {
          return;
          SectionDetailActivity.a(paramSectionDetailActivity, new ab(paramSectionDetailActivity, SectionDetailActivity.a(paramSectionDetailActivity), SectionDetailActivity.b(paramSectionDetailActivity), SectionDetailActivity.c(paramSectionDetailActivity)));
          SectionDetailActivity.d(paramSectionDetailActivity).setAdapter(SectionDetailActivity.e(paramSectionDetailActivity));
          SectionDetailActivity.b(paramSectionDetailActivity).clear();
          SectionDetailActivity.b(paramSectionDetailActivity).addAll(SectionDetailActivity.f(paramSectionDetailActivity));
          SectionDetailActivity.e(paramSectionDetailActivity).notifyDataSetChanged();
          return;
          SectionDetailActivity.b(paramSectionDetailActivity).clear();
          SectionDetailActivity.b(paramSectionDetailActivity).addAll(SectionDetailActivity.f(paramSectionDetailActivity));
          SectionDetailActivity.e(paramSectionDetailActivity).notifyDataSetChanged();
          return;
        }
        while (!((String)paramMessage.obj).equals("true"));
        if (SectionDetailActivity.g(paramSectionDetailActivity).getForum_isfollow() == 1)
        {
          SectionDetailActivity.h(paramSectionDetailActivity).setBackgroundResource(2130837587);
          SectionDetailActivity.h(paramSectionDetailActivity).setText(paramSectionDetailActivity.getResources().getString(2131165493));
          SectionDetailActivity.g(paramSectionDetailActivity).setForum_isfollow(0);
        }
        while (true)
        {
          if (BBSFragment.a != null)
            BBSFragment.a.sendEmptyMessage(1);
          Toast.makeText(SectionDetailActivity.i(paramSectionDetailActivity), "操作成功", 0).show();
          return;
          SectionDetailActivity.h(paramSectionDetailActivity).setBackgroundResource(2130837581);
          SectionDetailActivity.h(paramSectionDetailActivity).setText(paramSectionDetailActivity.getResources().getString(2131165496));
          SectionDetailActivity.g(paramSectionDetailActivity).setForum_isfollow(1);
        }
      case 4:
      }
      g.b(SectionDetailActivity.i(paramSectionDetailActivity), "bbs_into_post");
      paramSectionDetailActivity.startNewActivityForResult(PostDetailActivity.class, 20, (Bundle)paramMessage.obj);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SectionDetailActivity
 * JD-Core Version:    0.6.0
 */