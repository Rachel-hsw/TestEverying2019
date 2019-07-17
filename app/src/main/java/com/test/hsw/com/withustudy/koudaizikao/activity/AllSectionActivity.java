package com.withustudy.koudaizikao.activity;

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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import com.withustudy.koudaizikao.entity.content.ForumsContent;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllSectionActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private Button e;
  private TextView f;
  private PullToRefreshListView g;
  private List<Forum> h;
  private com.withustudy.koudaizikao.b.a i;
  private b j;
  private a k;
  private int l;
  private final int m = 10;
  private boolean n = false;
  private boolean o = false;
  private String[] p = null;

  protected void bindData()
  {
    this.f.setText("全部版块");
    this.i = new com.withustudy.koudaizikao.b.a(this.mContext, this.h);
    this.g.setAdapter(this.i);
    n.a(true, this.g, this.mContext);
  }

  protected void initData()
  {
    this.j = new b();
    this.k = new a(this);
    this.h = new ArrayList();
    this.p = new String[5];
  }

  protected void initListener()
  {
    this.e.setOnClickListener(this.j);
    this.g.setOnRefreshListener(this.j);
    this.g.setOnItemClickListener(this.j);
  }

  protected void initView()
  {
    this.e = ((Button)findViewById(2131296390));
    this.f = ((TextView)findViewById(2131296391));
    this.g = ((PullToRefreshListView)findViewById(2131296392));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
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
    case 3:
      this.n = false;
      this.g.f();
      return;
    case 4:
    }
    this.o = false;
    this.g.f();
  }

  protected void onResume()
  {
    super.onResume();
    this.l = 1;
    this.n = true;
    this.p[0] = this.mSP.i();
    this.p[1] = this.mSP.q();
    this.p[2] = this.mSP.s();
    this.p[3] = String.valueOf(this.l);
    this.p[4] = String.valueOf(10);
    c.b().F().a(this, this.p, 3, this.mContext);
    this.mProTools.a(true);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        return;
        this.n = false;
        this.g.f();
      }
      while (paramString1 == null);
      try
      {
        ForumsContent localForumsContent2 = (ForumsContent)c.a().fromJson(paramString1, ForumsContent.class);
        if ((localForumsContent2 != null) && (localForumsContent2.getResult().equals("true")))
        {
          this.k.sendMessage(this.k.obtainMessage(1, localForumsContent2.getForums()));
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
      this.o = false;
      this.g.f();
    }
    while (paramString1 == null);
    try
    {
      ForumsContent localForumsContent1 = (ForumsContent)c.a().fromJson(paramString1, ForumsContent.class);
      if ((localForumsContent1 != null) && (localForumsContent1.getResult().equals("true")))
      {
        this.k.sendMessage(this.k.obtainMessage(2, localForumsContent1.getForums()));
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
    setContentView(2130903067);
  }

  private static class a extends m<AllSectionActivity>
  {
    public a(AllSectionActivity paramAllSectionActivity)
    {
      super();
    }

    protected void a(AllSectionActivity paramAllSectionActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        AllSectionActivity.a(paramAllSectionActivity).clear();
        AllSectionActivity.a(paramAllSectionActivity).addAll((List)paramMessage.obj);
        AllSectionActivity.b(paramAllSectionActivity).notifyDataSetChanged();
        return;
      case 2:
      }
      AllSectionActivity.a(paramAllSectionActivity).addAll((List)paramMessage.obj);
      AllSectionActivity.b(paramAllSectionActivity).notifyDataSetChanged();
    }
  }

  class b
    implements View.OnClickListener, AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    b()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!AllSectionActivity.c(AllSectionActivity.this))
      {
        AllSectionActivity.a(AllSectionActivity.this, 1);
        AllSectionActivity.d(AllSectionActivity.this)[0] = AllSectionActivity.e(AllSectionActivity.this).i();
        AllSectionActivity.d(AllSectionActivity.this)[1] = AllSectionActivity.e(AllSectionActivity.this).q();
        AllSectionActivity.d(AllSectionActivity.this)[2] = AllSectionActivity.e(AllSectionActivity.this).s();
        AllSectionActivity.d(AllSectionActivity.this)[3] = String.valueOf(AllSectionActivity.f(AllSectionActivity.this));
        AllSectionActivity.d(AllSectionActivity.this)[4] = String.valueOf(10);
        AllSectionActivity.a(AllSectionActivity.this, true);
        c.b().F().a(AllSectionActivity.this, AllSectionActivity.d(AllSectionActivity.this), 3, AllSectionActivity.g(AllSectionActivity.this));
      }
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!AllSectionActivity.h(AllSectionActivity.this))
      {
        AllSectionActivity localAllSectionActivity = AllSectionActivity.this;
        AllSectionActivity.a(localAllSectionActivity, 1 + AllSectionActivity.f(localAllSectionActivity));
        AllSectionActivity.d(AllSectionActivity.this)[0] = AllSectionActivity.e(AllSectionActivity.this).i();
        AllSectionActivity.d(AllSectionActivity.this)[1] = AllSectionActivity.e(AllSectionActivity.this).q();
        AllSectionActivity.d(AllSectionActivity.this)[2] = AllSectionActivity.e(AllSectionActivity.this).s();
        AllSectionActivity.d(AllSectionActivity.this)[3] = String.valueOf(AllSectionActivity.f(AllSectionActivity.this));
        AllSectionActivity.d(AllSectionActivity.this)[4] = String.valueOf(10);
        AllSectionActivity.b(AllSectionActivity.this, true);
        c.b().F().a(AllSectionActivity.this, AllSectionActivity.d(AllSectionActivity.this), 4, AllSectionActivity.g(AllSectionActivity.this));
      }
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296390:
      }
      AllSectionActivity.this.finish();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("receive_code", (Serializable)AllSectionActivity.a(AllSectionActivity.this).get(paramInt - 1));
      AllSectionActivity.this.startNewActivity(SectionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.AllSectionActivity
 * JD-Core Version:    0.6.0
 */