package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.t;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.content.PostContent;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyPostActivity extends AbsBaseActivity
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 10;
  public static final int g = 11;
  private Button h;
  private TextView i;
  private LinearLayout j;
  private PullToRefreshListView k;
  private List<Post> l;
  private t m;
  private b n;
  private a o;
  private final int p = 5;
  private int q;
  private String[] r;
  private boolean s = false;
  private boolean t = false;
  private int u;

  protected void bindData()
  {
    if (this.u == 100)
      this.i.setText(getResources().getString(2131165381));
    while (true)
    {
      n.a(true, this.k, this.mContext);
      this.s = true;
      this.q = 1;
      this.r[2] = String.valueOf(this.q);
      this.r[3] = String.valueOf(5);
      c.b().I().a(this, this.r, 10, this.mContext);
      this.mProTools.a();
      return;
      this.i.setText(getResources().getString(2131165382));
    }
  }

  protected void initData()
  {
    this.n = new b(this);
    this.o = new a();
    this.u = getIntent().getExtras().getInt("state");
    this.r = new String[4];
    if (this.u == 100)
      this.r[0] = "list";
    while (true)
    {
      this.r[1] = this.mSP.i();
      this.l = new ArrayList();
      return;
      this.r[0] = "replyList";
    }
  }

  protected void initListener()
  {
    this.h.setOnClickListener(this.o);
    this.k.setOnRefreshListener(this.o);
  }

  protected void initView()
  {
    this.h = ((Button)findViewById(2131296588));
    this.i = ((TextView)findViewById(2131296589));
    this.j = ((LinearLayout)findViewById(2131296591));
    this.k = ((PullToRefreshListView)findViewById(2131296590));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 21)
    {
      this.mProTools.a(true);
      this.s = true;
      this.q = 1;
      this.r[2] = String.valueOf(this.q);
      this.r[3] = String.valueOf(5);
      c.b().I().a(this, this.r, 10, this.mContext);
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
      this.s = false;
      this.k.f();
      return;
    case 11:
    }
    this.t = false;
    this.k.f();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
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
        this.s = false;
        this.k.f();
      }
      while (paramString1 == null);
      try
      {
        PostContent localPostContent2 = (PostContent)c.a().fromJson(paramString1, PostContent.class);
        if ((localPostContent2 != null) && (localPostContent2.getResult().equals("true")))
        {
          this.n.sendMessage(this.n.obtainMessage(1, localPostContent2.getTopics()));
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
      this.t = false;
      this.k.f();
    }
    while (paramString1 == null);
    try
    {
      PostContent localPostContent1 = (PostContent)c.a().fromJson(paramString1, PostContent.class);
      if ((localPostContent1 != null) && (localPostContent1.getResult().equals("true")))
      {
        this.n.sendMessage(this.n.obtainMessage(2, localPostContent1.getTopics()));
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
    setContentView(2130903093);
  }

  class a
    implements View.OnClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!MyPostActivity.f(MyPostActivity.this))
      {
        MyPostActivity.a(MyPostActivity.this, true);
        MyPostActivity.a(MyPostActivity.this, 1);
        MyPostActivity.g(MyPostActivity.this)[2] = String.valueOf(MyPostActivity.h(MyPostActivity.this));
        MyPostActivity.g(MyPostActivity.this)[3] = String.valueOf(5);
        c.b().I().a(MyPostActivity.this, MyPostActivity.g(MyPostActivity.this), 10, MyPostActivity.i(MyPostActivity.this));
      }
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!MyPostActivity.j(MyPostActivity.this))
      {
        MyPostActivity.b(MyPostActivity.this, true);
        MyPostActivity localMyPostActivity = MyPostActivity.this;
        MyPostActivity.a(localMyPostActivity, 1 + MyPostActivity.h(localMyPostActivity));
        MyPostActivity.g(MyPostActivity.this)[2] = String.valueOf(MyPostActivity.h(MyPostActivity.this));
        MyPostActivity.g(MyPostActivity.this)[3] = String.valueOf(5);
        c.b().I().a(MyPostActivity.this, MyPostActivity.g(MyPostActivity.this), 11, MyPostActivity.i(MyPostActivity.this));
      }
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296588:
      }
      MyPostActivity.this.finish(2130968588, 2130968592);
    }
  }

  public static class b extends m<MyPostActivity>
  {
    public b(MyPostActivity paramMyPostActivity)
    {
      super();
    }

    protected void a(MyPostActivity paramMyPostActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        MyPostActivity.a(paramMyPostActivity).clear();
        MyPostActivity.a(paramMyPostActivity).addAll((List)paramMessage.obj);
        if (MyPostActivity.a(paramMyPostActivity).size() == 0)
          MyPostActivity.b(paramMyPostActivity).setVisibility(0);
        while (true)
        {
          MyPostActivity.a(paramMyPostActivity, new t(paramMyPostActivity, MyPostActivity.a(paramMyPostActivity), MyPostActivity.c(paramMyPostActivity)));
          MyPostActivity.d(paramMyPostActivity).setAdapter(MyPostActivity.e(paramMyPostActivity));
          return;
          MyPostActivity.b(paramMyPostActivity).setVisibility(8);
        }
      case 2:
        MyPostActivity.a(paramMyPostActivity).addAll((List)paramMessage.obj);
        MyPostActivity.e(paramMyPostActivity).notifyDataSetChanged();
        return;
      case 3:
      }
      paramMyPostActivity.startNewActivityForResult(PostDetailActivity.class, 20, (Bundle)paramMessage.obj);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.MyPostActivity
 * JD-Core Version:    0.6.0
 */