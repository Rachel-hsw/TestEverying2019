package com.withustudy.koudaizikao.activity;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.b.z;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;

public class QuestionDiscussActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  private Button c;
  private TextView d;
  private PullToRefreshListView e;
  private z f;
  private List<Integer> g;
  private boolean h = false;
  private boolean i = false;
  private a j;
  private b k;

  private void a()
  {
    this.e.setAdapter(this.f);
    n.a(true, this.e, this.mContext);
    this.e.setOnRefreshListener(this.j);
  }

  protected void bindData()
  {
    this.d.setText(getResources().getString(2131165449) + "1203" + getResources().getString(2131165450));
    a();
  }

  protected void initData()
  {
    this.j = new a();
    this.k = new b();
    this.g = new ArrayList();
    this.g.add(Integer.valueOf(0));
    this.g.add(Integer.valueOf(0));
    this.g.add(Integer.valueOf(0));
    this.g.add(Integer.valueOf(1));
    this.g.add(Integer.valueOf(0));
    this.f = new z(this.mContext, this.g);
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this.j);
    h.a("QuestionDiscussActivity list=" + this.g.hashCode());
  }

  protected void initView()
  {
    this.c = ((Button)findViewById(2131296653));
    this.d = ((TextView)findViewById(2131296654));
    this.e = ((PullToRefreshListView)findViewById(2131296655));
  }

  protected void setContentView()
  {
    setContentView(2130903101);
  }

  class a
    implements View.OnClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!QuestionDiscussActivity.d(QuestionDiscussActivity.this))
      {
        QuestionDiscussActivity.a(QuestionDiscussActivity.this, true);
        QuestionDiscussActivity.e(QuestionDiscussActivity.this).sendEmptyMessage(1);
      }
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!QuestionDiscussActivity.f(QuestionDiscussActivity.this))
      {
        QuestionDiscussActivity.b(QuestionDiscussActivity.this, true);
        QuestionDiscussActivity.e(QuestionDiscussActivity.this).sendEmptyMessage(2);
      }
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296653:
      }
      QuestionDiscussActivity.this.finish(2130968588, 2130968592);
    }
  }

  class b extends Handler
  {
    b()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).clear();
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(1));
        QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
        QuestionDiscussActivity.b(QuestionDiscussActivity.this).notifyDataSetChanged();
        QuestionDiscussActivity.c(QuestionDiscussActivity.this).f();
        QuestionDiscussActivity.a(QuestionDiscussActivity.this, false);
        return;
      case 2:
      }
      QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
      QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(1));
      QuestionDiscussActivity.a(QuestionDiscussActivity.this).add(Integer.valueOf(0));
      QuestionDiscussActivity.b(QuestionDiscussActivity.this).notifyDataSetChanged();
      QuestionDiscussActivity.c(QuestionDiscussActivity.this).f();
      QuestionDiscussActivity.b(QuestionDiscussActivity.this, false);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.QuestionDiscussActivity
 * JD-Core Version:    0.6.0
 */