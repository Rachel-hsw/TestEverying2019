package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.content.ForumsContent;
import com.withustudy.koudaizikao.entity.content.PostContent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BbsHotActivity extends AbsBaseActivity
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 10;
  private TextView g;
  private Button h;
  private LoadingView i;
  private ListView j;
  private com.withustudy.koudaizikao.b.c k;
  private List<Forum> l;
  private List<Post> m;
  private b n;
  private a o;
  private String[] p;
  private int q;

  protected void bindData()
  {
    if (this.q == 0)
    {
      this.g.setText(getResources().getString(2131165490));
      return;
    }
    this.g.setText(getResources().getString(2131165492));
  }

  protected void initData()
  {
    this.q = getIntent().getIntExtra("type", -1);
    this.n = new b();
    this.o = new a(this);
    this.p = new String[1];
    this.p[0] = this.mSP.i();
  }

  protected void initListener()
  {
    this.h.setOnClickListener(this.n);
    this.j.setOnItemClickListener(this.n);
  }

  protected void initView()
  {
    this.g = ((TextView)findViewById(2131296417));
    this.h = ((Button)findViewById(2131296416));
    this.j = ((ListView)findViewById(2131296419));
    this.i = ((LoadingView)findViewById(2131296418));
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    Toast.makeText(this.mContext, getResources().getString(2131165528), 0).show();
  }

  protected void onResume()
  {
    super.onResume();
    this.j.setVisibility(8);
    this.i.setVisibility(0);
    if (this.q == 1)
    {
      com.withustudy.koudaizikao.a.c.b().t().a(this, this.p, 1, this.mContext);
      return;
    }
    com.withustudy.koudaizikao.a.c.b().B().a(this, this.p, 2, this.mContext);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    do
    {
      do
        return;
      while (paramString1 == null);
      try
      {
        ForumsContent localForumsContent = (ForumsContent)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, ForumsContent.class);
        if (localForumsContent != null)
        {
          this.l = localForumsContent.getForums();
          this.o.sendEmptyMessage(10);
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
      return;
    }
    while (paramString1 == null);
    try
    {
      PostContent localPostContent = (PostContent)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, PostContent.class);
      if (localPostContent != null)
      {
        this.m = localPostContent.getTopics();
        this.o.sendEmptyMessage(10);
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
    setContentView(2130903069);
  }

  private static class a extends m<BbsHotActivity>
  {
    public a(BbsHotActivity paramBbsHotActivity)
    {
      super();
    }

    protected void a(BbsHotActivity paramBbsHotActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 10:
      }
      BbsHotActivity.a(paramBbsHotActivity, new com.withustudy.koudaizikao.b.c(BbsHotActivity.a(paramBbsHotActivity), BbsHotActivity.b(paramBbsHotActivity)));
      if (BbsHotActivity.b(paramBbsHotActivity) == 1)
        BbsHotActivity.c(paramBbsHotActivity).a(BbsHotActivity.d(paramBbsHotActivity));
      while (true)
      {
        BbsHotActivity.f(paramBbsHotActivity).setAdapter(BbsHotActivity.c(paramBbsHotActivity));
        return;
        BbsHotActivity.c(paramBbsHotActivity).b(BbsHotActivity.e(paramBbsHotActivity));
      }
    }
  }

  class b
    implements View.OnClickListener, AdapterView.OnItemClickListener
  {
    b()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296416:
      }
      BbsHotActivity.this.finish(2130968588, 2130968592);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (BbsHotActivity.b(BbsHotActivity.this) == 1)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putSerializable("receive_code", (Serializable)BbsHotActivity.d(BbsHotActivity.this).get(paramInt));
        BbsHotActivity.this.startNewActivity(SectionDetailActivity.class, false, localBundle1);
        return;
      }
      g.b(BbsHotActivity.a(BbsHotActivity.this), "bbs_into_hot_post");
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("id", ((Post)BbsHotActivity.e(BbsHotActivity.this).get(paramInt)).getTopic_id());
      BbsHotActivity.this.startNewActivity(PostDetailActivity.class, false, localBundle2);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.BbsHotActivity
 * JD-Core Version:    0.6.0
 */