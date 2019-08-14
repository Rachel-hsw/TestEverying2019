package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.i;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.p;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.PublishCommentBean;
import com.withustudy.koudaizikao.entity.RspQuestionComment;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.req.Comment;
import com.withustudy.koudaizikao.entity.req.ReqComment;
import com.withustudy.koudaizikao.entity.req.ReqQuestionMoreComment;
import com.withustudy.koudaizikao.entity.req.UserInfo;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionMoreComentActivity extends AbsBaseActivity
  implements View.OnClickListener, AbsListView.OnScrollListener, PullToRefreshBase.f<ListView>, SwipyRefreshLayout.a
{
  private static final int c = 101;
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final int h = 4;
  private PopupWindow A;
  private SwipyRefreshLayout a;
  private PullToRefreshListView b;
  private LinearLayout i;
  private LinearLayout j;
  private Button k;
  private EditText l;
  private String m;
  private String n;
  private boolean o = false;
  private InputMethodManager p;
  private LinearLayout q;
  private int r = 0;
  private PublishCommentBean s;
  private RspQuestionComment t;
  private UrlShortBean u;
  private List<Comment> v = new ArrayList();
  private i w;
  private i.b x;
  private com.withustudy.koudaizikao.custom.a.a y;
  private Handler z = new ba(this);

  private void a()
  {
    this.mProTools.a(true);
    ReqQuestionMoreComment localReqQuestionMoreComment = new ReqQuestionMoreComment();
    localReqQuestionMoreComment.setVersionName(this.mSP.p());
    localReqQuestionMoreComment.setClientType(n.a());
    localReqQuestionMoreComment.setImei(n.d(this.mContext));
    localReqQuestionMoreComment.setNet(n.c(this.mContext));
    this.r = 0;
    localReqQuestionMoreComment.setPageNo(this.r);
    localReqQuestionMoreComment.setExerciseId(this.m);
    c.b().ai().a(this, localReqQuestionMoreComment, 0);
  }

  private void b()
  {
    this.mProTools.a(true);
    ReqQuestionMoreComment localReqQuestionMoreComment = new ReqQuestionMoreComment();
    localReqQuestionMoreComment.setVersionName(this.mSP.p());
    localReqQuestionMoreComment.setClientType(n.a());
    localReqQuestionMoreComment.setImei(n.d(this.mContext));
    localReqQuestionMoreComment.setNet(n.c(this.mContext));
    localReqQuestionMoreComment.setPageNo(this.r);
    localReqQuestionMoreComment.setExerciseId(this.m);
    c.b().ai().a(this, localReqQuestionMoreComment, 1);
  }

  private void c()
  {
    String str = this.l.getText().toString().trim();
    if (str.equals(""))
    {
      Toast.makeText(getApplicationContext(), "内容不能为空", 0).show();
      return;
    }
    ReqComment localReqComment = new ReqComment();
    localReqComment.setVersionName(this.mSP.p());
    localReqComment.setClientType(n.a());
    localReqComment.setImei(n.d(this.mContext));
    localReqComment.setNet(n.c(this.mContext));
    localReqComment.setExerciseId(this.m);
    Comment localComment1 = new Comment();
    if (this.x != null)
    {
      int i1 = this.x.b;
      Comment localComment2 = this.x.c;
      Html.fromHtml("今日刷题" + n.a("", "#D6D6D6"));
      localComment1.setReplyFloorContent("回复" + (i1 + 1) + "楼" + localComment2.getLocation() + "学员: " + localComment2.getContent());
      this.x = null;
    }
    localComment1.setCommentTime(System.currentTimeMillis());
    localComment1.setContent(str);
    localComment1.setLocation(this.mSP.k());
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.setUid(this.mSP.i());
    localComment1.setUserInfo(localUserInfo);
    localReqComment.setComment(localComment1);
    this.mProTools.a(true);
    c.b().V().a(this, localReqComment, 2);
  }

  private void d()
  {
    if (this.A != null)
    {
      this.A.dismiss();
      this.A = null;
    }
    a(1.0F);
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getWindow().setAttributes(localLayoutParams);
  }

  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
  }

  public void a(p paramp)
  {
    if (paramp.equals(p.a(0)))
    {
      a();
      return;
    }
    if (paramp.equals(p.a(1)))
    {
      h.a("加载");
      return;
    }
    this.a.setRefreshing(false);
  }

  public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    if (!this.o)
    {
      this.r = (1 + this.r);
      this.o = true;
      b();
    }
  }

  protected void bindData()
  {
    a();
  }

  protected void initData()
  {
    Bundle localBundle = getIntent().getExtras();
    try
    {
      this.m = localBundle.getString("exerciseId");
      this.n = localBundle.getString("subjectId");
      label30: this.p = ((InputMethodManager)getSystemService("input_method"));
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }

  protected void initListener()
  {
    this.a.setRefreshing(true);
    this.a.setOnRefreshListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.b.setOnScrollListener(this);
    this.b.setOnRefreshListener(this);
  }

  protected void initView()
  {
    this.q = ((LinearLayout)findViewById(2131296933));
    this.b = ((PullToRefreshListView)findViewById(2131296932));
    this.a = ((SwipyRefreshLayout)findViewById(2131296931));
    this.i = ((LinearLayout)findViewById(2131296808));
    this.j = ((LinearLayout)findViewById(2131296930));
    this.l = ((EditText)findViewById(2131296934));
    this.k = ((Button)findViewById(2131296935));
    n.a("PULL_FROM_END", this.b, this.mContext);
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296935:
        c();
        return;
      case 2131296930:
        finish();
        return;
      case 2131296808:
        String str = "?subjectid=" + this.n;
        com.withustudy.koudaizikao.a.a locala = c.b().at();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
        locala.a(this, arrayOfString, 101, this);
        return;
      case 2131296836:
        Toast.makeText(getApplicationContext(), "隐藏", 0).show();
        d();
        return;
      case 2131296844:
        Toast.makeText(getApplicationContext(), "微博", 0).show();
        return;
      case 2131296845:
        Toast.makeText(getApplicationContext(), "朋友圈", 0).show();
        return;
      case 2131296846:
        Toast.makeText(getApplicationContext(), "微信", 0).show();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.A != null)
      {
        this.A.dismiss();
        this.A = null;
      }
      if (this.y != null)
      {
        this.y.c();
        this.y = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      this.a.setEnabled(true);
      return;
    }
    this.a.setEnabled(false);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = c.a();
        switch (paramInt)
        {
        case 2:
          this.s = ((PublishCommentBean)localGson.fromJson(paramString1, PublishCommentBean.class));
          if (this.s == null)
            break label135;
          if ("OK".equals(this.s.getStatus()))
          {
            this.z.sendEmptyMessage(3);
            return;
          }
        case 0:
        case 1:
        case 101:
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      this.z.sendEmptyMessage(4);
      return;
      label135: h.a("发布评论解析异常");
      return;
      this.t = ((RspQuestionComment)localGson.fromJson(paramString1, RspQuestionComment.class));
      if (this.t != null)
      {
        this.z.sendEmptyMessage(0);
        return;
      }
      h.a("刷新数据 解析评论为null");
      return;
      this.t = ((RspQuestionComment)localGson.fromJson(paramString1, RspQuestionComment.class));
      if (this.t != null)
      {
        this.z.sendEmptyMessage(1);
        return;
      }
      h.a("加载更多 解析评论为null");
      return;
      this.u = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
      if (this.u != null)
      {
        this.z.sendEmptyMessage(101);
        return;
      }
      h.a("加密url异常");
      return;
    }
    h.a("response::---------" + paramString1);
  }

  protected void setContentView()
  {
    setContentView(2130903145);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.QuestionMoreComentActivity
 * JD-Core Version:    0.6.0
 */