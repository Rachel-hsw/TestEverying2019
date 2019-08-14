package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.k;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.w;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.AddImageView;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.entity.LocalImage;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.PostReply;
import com.withustudy.koudaizikao.entity.SimpleResult;
import com.withustudy.koudaizikao.entity.content.PostSingleContent;
import com.withustudy.koudaizikao.entity.content.PublishPostReplyResult;
import com.withustudy.koudaizikao.entity.content.ReplyContent;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostDetailActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 17;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 9;
  private LinearLayout A;
  private Button B;
  private EditText C;
  private Button D;
  private RelativeLayout E;
  private LinearLayout F;
  private TextView G;
  private int H;
  private boolean I = true;
  private int J;
  private Post K;
  private LoadingView L;
  private PullToRefreshListView M;
  private w N;
  private List<PostReply> O;
  private a P;
  private b Q;
  private InputMethodManager R;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private boolean V = true;
  private boolean W = true;
  private boolean X = false;
  private boolean Y = false;
  private List<Integer> Z;
  private int aa = 0;
  private List<AddImageView> ab;
  private List<File> ac;
  private String[] ad;
  private int ae;
  private String[] af;
  private final int ag = 10;
  private int ah;
  private com.withustudy.koudaizikao.custom.a.a ai;
  private LinearLayout s;
  private Button t;
  private TextView u;
  private Button v;
  private Button w;
  private SwipeRefreshLayout x;
  private LinearLayout y;
  private Button z;

  private void a()
  {
    if ((this.Z.size() == 2) && (!this.X) && (((Integer)this.Z.get(0)).intValue() != 0) && (((Integer)this.Z.get(1)).intValue() != 0))
    {
      this.aa = (((Integer)this.Z.get(0)).intValue() - ((Integer)this.Z.get(1)).intValue());
      if (this.aa <= 0)
        this.aa = (0 - this.aa);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.aa);
      this.E.setLayoutParams(localLayoutParams);
      this.aa /= 2;
      b();
      this.X = true;
    }
  }

  private void b()
  {
    if (this.ab != null)
      this.ab.clear();
    if (this.F != null)
      this.F.removeAllViews();
    c();
    int i1 = 0;
    if (i1 >= 9)
      return;
    AddImageView localAddImageView = new AddImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.aa, this.aa);
    if (i1 != 8)
      localLayoutParams.setMargins(0, 0, 69 * (this.mSP.y() / 720), 0);
    localAddImageView.setLayoutParams(localLayoutParams);
    localAddImageView.setIndex(i1);
    localAddImageView.setmHandler(this.Q);
    if (i1 == 0)
      localAddImageView.setVisibility(0);
    while (true)
    {
      this.ab.add(localAddImageView);
      this.F.addView(localAddImageView);
      i1++;
      break;
      localAddImageView.setVisibility(8);
    }
  }

  private void c()
  {
    if ((this.ae < 0) || (this.ae > 9))
      return;
    this.G.setText(getResources().getString(2131165512) + this.ae + getResources().getString(2131165513) + (9 - this.ae) + getResources().getString(2131165514));
  }

  private void d()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.ac.size())
        return;
      this.mFileTools.a((File)this.ac.get(i1));
    }
  }

  private void e()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.mSP.i();
    arrayOfString[1] = String.valueOf(this.H);
    c.b().A().a(this, arrayOfString, 10, this.mContext);
  }

  private void f()
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.mSP.i();
    arrayOfString[1] = String.valueOf(this.H);
    arrayOfString[2] = String.valueOf(this.ah);
    arrayOfString[3] = String.valueOf(10);
    if (this.ah == 1)
    {
      c.b().G().a(this, arrayOfString, 12, this.mContext);
      return;
    }
    c.b().G().a(this, arrayOfString, 13, this.mContext);
  }

  private void g()
  {
    this.W = false;
    this.B.setBackgroundResource(2130837682);
    if (this.E.getVisibility() == 0)
      this.E.setVisibility(8);
    this.R.toggleSoftInput(0, 2);
  }

  private void h()
  {
    finish();
    if ((this.Y) && (!MyApplication.isRunning))
      startNewActivity(WelcomeActivity.class, false, null);
  }

  protected void bindData()
  {
    this.N = new w(this.mContext, this.K, this.O, this.Q);
    n.a("PULL_FROM_END", this.M, this.mContext);
    this.M.setAdapter(this.N);
    this.C.setHint(getResources().getString(2131165510) + getResources().getString(2131165509));
    if (this.mSP.i().equals(""))
    {
      this.A.setVisibility(8);
      this.y.setVisibility(8);
    }
    this.L.setVisibility(0);
    this.M.setVisibility(8);
    e();
  }

  public void finish()
  {
    super.finish();
    d();
  }

  public void finish(int paramInt1, int paramInt2)
  {
    super.finish(paramInt1, paramInt2);
    d();
  }

  protected void initData()
  {
    this.P = new a();
    this.Q = new b(this);
    this.H = getIntent().getExtras().getInt("id");
    this.Y = getIntent().getExtras().getBoolean("push");
    if (this.Y)
      com.withustudy.koudaizikao.g.m.d(this.mContext);
    this.R = ((InputMethodManager)getSystemService("input_method"));
    this.O = new ArrayList();
    if (this.ab == null)
    {
      this.ab = new ArrayList();
      this.ac = new ArrayList();
      return;
    }
    this.ab.clear();
    d();
    this.ac.clear();
  }

  protected void initListener()
  {
    this.t.setOnClickListener(this.P);
    this.v.setOnClickListener(this.P);
    this.w.setOnClickListener(this.P);
    this.x.setOnRefreshListener(this.P);
    this.M.setOnRefreshListener(this.P);
    this.M.setOnScrollListener(this.P);
    this.z.setOnClickListener(this.P);
    this.B.setOnClickListener(this.P);
    this.C.setOnTouchListener(this.P);
    this.D.setOnClickListener(this.P);
    this.s.getViewTreeObserver().addOnGlobalLayoutListener(this.P);
  }

  protected void initView()
  {
    this.s = ((LinearLayout)findViewById(2131296616));
    this.t = ((Button)findViewById(2131296617));
    this.u = ((TextView)findViewById(2131296618));
    this.v = ((Button)findViewById(2131296619));
    this.w = ((Button)findViewById(2131296620));
    this.x = ((SwipeRefreshLayout)findViewById(2131296621));
    this.L = ((LoadingView)findViewById(2131296623));
    this.M = ((PullToRefreshListView)findViewById(2131296622));
    this.y = ((LinearLayout)findViewById(2131296624));
    this.z = ((Button)findViewById(2131296626));
    this.A = ((LinearLayout)findViewById(2131296627));
    this.B = ((Button)findViewById(2131296628));
    this.C = ((EditText)findViewById(2131296629));
    this.D = ((Button)findViewById(2131296630));
    this.E = ((RelativeLayout)findViewById(2131296631));
    this.F = ((LinearLayout)findViewById(2131296633));
    this.G = ((TextView)findViewById(2131296634));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 11) && (paramIntent != null));
    try
    {
      ArrayList localArrayList = paramIntent.getExtras().getParcelableArrayList("result");
      int i1 = this.ae;
      int i4;
      for (int i2 = 0; ; i2 = i4)
      {
        if (i1 < this.ab.size())
        {
          int i3 = localArrayList.size();
          if (i2 < i3);
        }
        else
        {
          super.onActivityResult(paramInt1, paramInt2, paramIntent);
          return;
        }
        h.a(((LocalImage)localArrayList.get(i2)).getPath());
        ((AddImageView)this.ab.get(i1)).setImage(((LocalImage)localArrayList.get(i2)).getPath());
        ((AddImageView)this.ab.get(i1)).setDeleteVisibility(0);
        if (i1 != 8)
          ((AddImageView)this.ab.get(i1 + 1)).setVisibility(0);
        this.ae = (1 + this.ae);
        c();
        File localFile = this.mFileTools.a(System.currentTimeMillis() + ".JPEG");
        h.a(localFile.getAbsolutePath());
        if (this.mFileTools.a(localFile, ((LocalImage)localArrayList.get(i2)).getPath()) != null)
          this.ac.add(localFile);
        i4 = i2 + 1;
        i1++;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        Toast.makeText(this.mContext, "图片过大，小袋内存不够用啦!", 0).show();
        localOutOfMemoryError.printStackTrace();
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.ai != null)
      {
        this.ai.c();
        this.ai = null;
      }
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
    case 12:
      this.x.setRefreshing(false);
      return;
    case 13:
    }
    this.U = false;
    this.M.f();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      h();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    this.L.setVisibility(8);
    this.M.setVisibility(0);
    switch (paramInt)
    {
    default:
    case 10:
    case 14:
    case 15:
    case 11:
    case 12:
    case 13:
    case 16:
    }
    label300: label615: 
    do
      while (true)
      {
        return;
        if (paramString1 == null)
          continue;
        while (true)
        {
          try
          {
            PostSingleContent localPostSingleContent = (PostSingleContent)c.a().fromJson(paramString1, PostSingleContent.class);
            if ((localPostSingleContent == null) || (!localPostSingleContent.getResult().equals("true")))
              break;
            this.K = localPostSingleContent.getTopic();
            this.ah = 1;
            f();
            if ((this.K.getTopic_title() == null) || (this.K.getTopic_title().equals("")))
              continue;
            this.u.setText(this.K.getTopic_title());
            if (this.mSP.i().equals(""))
              continue;
            if (this.K.getTopic_isfollow() == 1)
            {
              this.S = true;
              this.v.setBackgroundResource(2130837677);
              if (this.K.getTopic_ispraise() != 1)
                break label300;
              this.T = true;
              this.B.setBackgroundResource(2130837683);
              this.N.a(this.K);
              this.N.notifyDataSetChanged();
              return;
            }
          }
          catch (Exception localException7)
          {
            localException7.printStackTrace();
            Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
            return;
          }
          this.S = false;
          this.v.setBackgroundResource(2130837688);
          continue;
          this.T = false;
          this.B.setBackgroundResource(2130837760);
        }
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
        if (paramString1 == null)
          continue;
        while (true)
        {
          try
          {
            SimpleResult localSimpleResult3 = (SimpleResult)c.a().fromJson(paramString1, SimpleResult.class);
            if ((localSimpleResult3 == null) || (!localSimpleResult3.getResult().equals("true")))
              break;
            if (this.T)
            {
              this.T = false;
              this.K.setTopic_praise(-1 + Integer.valueOf(this.K.getTopic_praise()).intValue());
              this.N.notifyDataSetChanged();
              Intent localIntent2 = new Intent();
              Bundle localBundle2 = new Bundle();
              localBundle2.putSerializable("change", this.K);
              localIntent2.putExtra("result", localBundle2);
              setResult(24, localIntent2);
              return;
            }
          }
          catch (Exception localException6)
          {
            localException6.printStackTrace();
            Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
            return;
          }
          this.T = true;
          this.K.setTopic_praise(1 + Integer.valueOf(this.K.getTopic_praise()).intValue());
          this.N.notifyDataSetChanged();
        }
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
        if (paramString1 == null)
          continue;
        try
        {
          SimpleResult localSimpleResult2 = (SimpleResult)c.a().fromJson(paramString1, SimpleResult.class);
          if ((localSimpleResult2 == null) || (!localSimpleResult2.getResult().equals("true")))
            break label615;
          if (this.S)
          {
            this.S = false;
            return;
          }
        }
        catch (Exception localException5)
        {
          localException5.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        this.S = true;
        return;
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
        if (paramString1 == null)
          continue;
        try
        {
          SimpleResult localSimpleResult1 = (SimpleResult)c.a().fromJson(paramString1, SimpleResult.class);
          if ((localSimpleResult1 != null) && (localSimpleResult1.getResult().equals("true")))
          {
            Toast.makeText(this.mContext, "删除成功", 0).show();
            setResult(21);
            finish(2130968588, 2130968592);
            return;
          }
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
        this.M.setVisibility(0);
        this.x.setRefreshing(false);
        if (paramString1 == null)
          continue;
        try
        {
          ReplyContent localReplyContent2 = (ReplyContent)c.a().fromJson(paramString1, ReplyContent.class);
          if ((localReplyContent2 == null) || (!localReplyContent2.getResult().equals("true")))
            continue;
          this.Q.sendMessage(this.Q.obtainMessage(1, localReplyContent2.getPosts()));
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        this.U = false;
        this.M.f();
        if (paramString1 == null)
          continue;
        try
        {
          ReplyContent localReplyContent1 = (ReplyContent)c.a().fromJson(paramString1, ReplyContent.class);
          if ((localReplyContent1 == null) || (!localReplyContent1.getResult().equals("true")))
            continue;
          this.Q.sendMessage(this.Q.obtainMessage(2, localReplyContent1.getPosts()));
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
      }
    while (paramString1 == null);
    try
    {
      PublishPostReplyResult localPublishPostReplyResult = (PublishPostReplyResult)c.a().fromJson(paramString1, PublishPostReplyResult.class);
      if ((localPublishPostReplyResult != null) && (localPublishPostReplyResult.getResult().equals("true")))
      {
        Toast.makeText(this.mContext, "发表成功", 0).show();
        this.K.setTopic_replies(1 + Integer.valueOf(this.K.getTopic_replies()).intValue());
        this.N.notifyDataSetChanged();
        d();
        this.ac.clear();
        this.ae = 0;
        b();
        this.E.setVisibility(8);
        this.Q.sendEmptyMessage(3);
        this.Q.sendMessage(this.Q.obtainMessage(9, localPublishPostReplyResult.getPost()));
        Intent localIntent1 = new Intent();
        Bundle localBundle1 = new Bundle();
        localBundle1.putSerializable("change", this.K);
        localIntent1.putExtra("result", localBundle1);
        setResult(24, localIntent1);
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
    setContentView(2130903098);
  }

  class a
    implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, AbsListView.OnScrollListener, PullToRefreshBase.e<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!PostDetailActivity.E(PostDetailActivity.this))
      {
        PostDetailActivity.d(PostDetailActivity.this, true);
        PostDetailActivity localPostDetailActivity = PostDetailActivity.this;
        PostDetailActivity.c(localPostDetailActivity, 1 + PostDetailActivity.F(localPostDetailActivity));
        PostDetailActivity.G(PostDetailActivity.this);
      }
    }

    public void onClick(View paramView)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296617:
          PostDetailActivity.r(PostDetailActivity.this);
          return;
        case 2131296619:
          if (PostDetailActivity.p(PostDetailActivity.this).i().equals(""))
          {
            Toast.makeText(PostDetailActivity.s(PostDetailActivity.this), "请先登录", 0).show();
            return;
          }
          String[] arrayOfString2 = new String[3];
          arrayOfString2[0] = PostDetailActivity.p(PostDetailActivity.this).i();
          arrayOfString2[1] = String.valueOf(PostDetailActivity.q(PostDetailActivity.this));
          if (PostDetailActivity.t(PostDetailActivity.this))
          {
            arrayOfString2[2] = "unfollow";
            PostDetailActivity.u(PostDetailActivity.this).setBackgroundResource(2130837688);
            c.b().D().a(PostDetailActivity.this, arrayOfString2, 15, PostDetailActivity.s(PostDetailActivity.this));
            return;
          }
          g.b(PostDetailActivity.s(PostDetailActivity.this), "bbs_collect");
          Toast.makeText(PostDetailActivity.s(PostDetailActivity.this), "收藏成功", 0).show();
          arrayOfString2[2] = "follow";
          PostDetailActivity.u(PostDetailActivity.this).setBackgroundResource(2130837677);
          c.b().D().a(PostDetailActivity.this, arrayOfString2, 15, PostDetailActivity.s(PostDetailActivity.this));
          return;
        case 2131296620:
          g.b(PostDetailActivity.s(PostDetailActivity.this), "bbs_share");
          if (PostDetailActivity.v(PostDetailActivity.this) == null)
            PostDetailActivity.a(PostDetailActivity.this, new com.withustudy.koudaizikao.custom.a.a(PostDetailActivity.this, PostDetailActivity.g(PostDetailActivity.this), "http://share.kdzikao.com/bbs/share.page?topic_id=" + PostDetailActivity.q(PostDetailActivity.this), PostDetailActivity.w(PostDetailActivity.this).getTopic_title(), PostDetailActivity.w(PostDetailActivity.this).getTopic_sub_desc()));
          PostDetailActivity.v(PostDetailActivity.this).b();
          return;
        case 2131296626:
          PostDetailActivity.d(PostDetailActivity.this).setVisibility(8);
          PostDetailActivity.c(PostDetailActivity.this, false);
          return;
        case 2131296628:
          if (PostDetailActivity.x(PostDetailActivity.this))
          {
            String[] arrayOfString1 = new String[3];
            arrayOfString1[0] = PostDetailActivity.p(PostDetailActivity.this).i();
            arrayOfString1[1] = String.valueOf(PostDetailActivity.q(PostDetailActivity.this));
            if (PostDetailActivity.y(PostDetailActivity.this))
            {
              arrayOfString1[2] = "cancel";
              PostDetailActivity.f(PostDetailActivity.this).setBackgroundResource(2130837760);
              c.b().C().a(PostDetailActivity.this, arrayOfString1, 14, PostDetailActivity.s(PostDetailActivity.this));
              return;
            }
            arrayOfString1[2] = "add";
            PostDetailActivity.f(PostDetailActivity.this).setBackgroundResource(2130837683);
            c.b().C().a(PostDetailActivity.this, arrayOfString1, 14, PostDetailActivity.s(PostDetailActivity.this));
            return;
          }
          PostDetailActivity.z(PostDetailActivity.this);
          if (PostDetailActivity.e(PostDetailActivity.this).getVisibility() == 0)
          {
            PostDetailActivity.e(PostDetailActivity.this).setVisibility(8);
            PostDetailActivity.c(PostDetailActivity.this).toggleSoftInput(0, 2);
            return;
          }
          if (PostDetailActivity.e(PostDetailActivity.this).getVisibility() != 8)
            break;
          PostDetailActivity.c(PostDetailActivity.this).hideSoftInputFromWindow(PostDetailActivity.this.getCurrentFocus().getWindowToken(), 2);
          PostDetailActivity.e(PostDetailActivity.this).setVisibility(0);
          return;
        case 2131296630:
          if (PostDetailActivity.g(PostDetailActivity.this).getText().toString().equals(""))
          {
            Toast.makeText(PostDetailActivity.s(PostDetailActivity.this), "回复内容不能为空", 0).show();
            return;
          }
          PostDetailActivity.b(PostDetailActivity.this, new String[5]);
          if (PostDetailActivity.A(PostDetailActivity.this))
          {
            g.b(PostDetailActivity.s(PostDetailActivity.this), "bbs_publish");
            PostDetailActivity.o(PostDetailActivity.this)[0] = String.valueOf(PostDetailActivity.q(PostDetailActivity.this));
            PostDetailActivity.o(PostDetailActivity.this)[1] = "0";
            PostDetailActivity.o(PostDetailActivity.this)[2] = PostDetailActivity.p(PostDetailActivity.this).i();
            PostDetailActivity.o(PostDetailActivity.this)[3] = URLEncoder.encode(PostDetailActivity.g(PostDetailActivity.this).getText().toString());
            PostDetailActivity.o(PostDetailActivity.this)[4] = "";
            if (PostDetailActivity.i(PostDetailActivity.this).size() == 0)
              break label905;
            new k(PostDetailActivity.i(PostDetailActivity.this), new String[] { "bbs" }, PostDetailActivity.C(PostDetailActivity.this)).start();
          }
          while (true)
          {
            PostDetailActivity.D(PostDetailActivity.this).a("努力发表中");
            return;
            g.b(PostDetailActivity.s(PostDetailActivity.this), "bbs_reply");
            PostDetailActivity.o(PostDetailActivity.this)[0] = String.valueOf(PostDetailActivity.B(PostDetailActivity.this));
            PostDetailActivity.o(PostDetailActivity.this)[1] = "1";
            break;
            label905: c.b().H().a(PostDetailActivity.this, PostDetailActivity.o(PostDetailActivity.this), 16, PostDetailActivity.s(PostDetailActivity.this));
          }
        case 2131296618:
        case 2131296621:
        case 2131296622:
        case 2131296623:
        case 2131296624:
        case 2131296625:
        case 2131296627:
        case 2131296629:
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onGlobalLayout()
    {
      Rect localRect = new Rect();
      PostDetailActivity.J(PostDetailActivity.this).getWindowVisibleDisplayFrame(localRect);
      int i = PostDetailActivity.p(PostDetailActivity.this).x() - (localRect.bottom - localRect.top);
      if (PostDetailActivity.K(PostDetailActivity.this) == null)
      {
        PostDetailActivity.a(PostDetailActivity.this, new ArrayList());
        PostDetailActivity.K(PostDetailActivity.this).add(Integer.valueOf(i));
      }
      do
        return;
      while (PostDetailActivity.K(PostDetailActivity.this).contains(Integer.valueOf(i)));
      PostDetailActivity.K(PostDetailActivity.this).add(Integer.valueOf(i));
    }

    public void onRefresh()
    {
      PostDetailActivity.H(PostDetailActivity.this).setRefreshing(true);
      PostDetailActivity.c(PostDetailActivity.this, 1);
      PostDetailActivity.G(PostDetailActivity.this);
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0)
      {
        PostDetailActivity.H(PostDetailActivity.this).setEnabled(true);
        return;
      }
      PostDetailActivity.H(PostDetailActivity.this).setEnabled(false);
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      PostDetailActivity.C(PostDetailActivity.this).sendEmptyMessage(3);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramView.getId())
      {
      default:
      case 2131296629:
      }
      do
      {
        return false;
        PostDetailActivity.a(PostDetailActivity.this, false);
        PostDetailActivity.f(PostDetailActivity.this).setBackgroundResource(2130837682);
      }
      while (PostDetailActivity.e(PostDetailActivity.this).getVisibility() != 0);
      PostDetailActivity.e(PostDetailActivity.this).setVisibility(8);
      return false;
    }
  }

  public static class b extends com.withustudy.koudaizikao.base.m<PostDetailActivity>
  {
    public b(PostDetailActivity paramPostDetailActivity)
    {
      super();
    }

    protected void a(PostDetailActivity paramPostDetailActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        int j;
        do
        {
          return;
          PostDetailActivity.a(paramPostDetailActivity).clear();
          PostDetailActivity.a(paramPostDetailActivity).addAll((List)paramMessage.obj);
          PostDetailActivity.b(paramPostDetailActivity).notifyDataSetChanged();
          return;
          PostDetailActivity.a(paramPostDetailActivity).addAll((List)paramMessage.obj);
          PostDetailActivity.b(paramPostDetailActivity).notifyDataSetChanged();
          return;
          try
          {
            PostDetailActivity.c(paramPostDetailActivity).hideSoftInputFromWindow(paramPostDetailActivity.getCurrentFocus().getWindowToken(), 2);
            PostDetailActivity.a(paramPostDetailActivity, true);
            PostDetailActivity.d(paramPostDetailActivity).setVisibility(8);
            PostDetailActivity.e(paramPostDetailActivity).setVisibility(8);
            PostDetailActivity.f(paramPostDetailActivity).setBackgroundResource(2130837760);
            PostDetailActivity.g(paramPostDetailActivity).setText("");
            PostDetailActivity.g(paramPostDetailActivity).setHint(paramPostDetailActivity.getResources().getString(2131165510) + paramPostDetailActivity.getResources().getString(2131165509));
            PostDetailActivity.b(paramPostDetailActivity, true);
            return;
          }
          catch (Exception localException)
          {
            return;
          }
          PostDetailActivity.g(paramPostDetailActivity).setText("");
          PostDetailActivity.g(paramPostDetailActivity).setHint(paramPostDetailActivity.getResources().getString(2131165510) + (1 + ((Integer)paramMessage.obj).intValue()) + "楼");
          PostDetailActivity.b(paramPostDetailActivity, false);
          PostDetailActivity.a(paramPostDetailActivity, ((PostReply)PostDetailActivity.a(paramPostDetailActivity).get(((Integer)paramMessage.obj).intValue())).getPost_id());
          PostDetailActivity.h(paramPostDetailActivity);
          return;
          int m = ((Integer)paramMessage.obj).intValue();
          int n = -1 + PostDetailActivity.i(paramPostDetailActivity).size();
          int i1 = m;
          if (i1 >= PostDetailActivity.j(paramPostDetailActivity).size())
          {
            PostDetailActivity.b(paramPostDetailActivity, m);
            PostDetailActivity.l(paramPostDetailActivity);
            return;
          }
          if (n >= m)
          {
            PostDetailActivity.k(paramPostDetailActivity).a((File)PostDetailActivity.i(paramPostDetailActivity).get(n));
            PostDetailActivity.i(paramPostDetailActivity).remove(n);
            n--;
          }
          if (i1 == m)
            ((AddImageView)PostDetailActivity.j(paramPostDetailActivity).get(i1)).a(false);
          while (true)
          {
            i1++;
            break;
            ((AddImageView)PostDetailActivity.j(paramPostDetailActivity).get(i1)).a(true);
          }
          Bundle localBundle2 = new Bundle();
          localBundle2.putInt("currImage", PostDetailActivity.m(paramPostDetailActivity));
          paramPostDetailActivity.startNewActivityForResult(ImageSelectorActivity.class, PostDetailActivity.m(paramPostDetailActivity), localBundle2);
          return;
          PostDetailActivity.a(paramPostDetailActivity, (String[])paramMessage.obj);
          int k = 0;
          if (k >= PostDetailActivity.n(paramPostDetailActivity).length)
          {
            c.b().H().a(paramPostDetailActivity, PostDetailActivity.o(paramPostDetailActivity), 16, paramPostDetailActivity);
            return;
          }
          if (k != -1 + PostDetailActivity.n(paramPostDetailActivity).length)
            PostDetailActivity.o(paramPostDetailActivity)[4] = (PostDetailActivity.o(paramPostDetailActivity)[4] + PostDetailActivity.n(paramPostDetailActivity)[k] + ",");
          while (true)
          {
            k++;
            break;
            PostDetailActivity.o(paramPostDetailActivity)[4] = (PostDetailActivity.o(paramPostDetailActivity)[4] + PostDetailActivity.n(paramPostDetailActivity)[k]);
          }
          String[] arrayOfString = new String[2];
          arrayOfString[0] = PostDetailActivity.p(paramPostDetailActivity).i();
          arrayOfString[1] = String.valueOf(PostDetailActivity.q(paramPostDetailActivity));
          c.b().E().a(paramPostDetailActivity, arrayOfString, 11, paramPostDetailActivity);
          return;
          j = PostDetailActivity.a(paramPostDetailActivity).size();
          paramPostDetailActivity.getClass();
        }
        while ((j % 10 == 0) && (PostDetailActivity.a(paramPostDetailActivity).size() != 0));
        PostDetailActivity.a(paramPostDetailActivity).add((PostReply)paramMessage.obj);
        PostDetailActivity.b(paramPostDetailActivity).notifyDataSetChanged();
        return;
      case 17:
      }
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; ; i++)
      {
        if (i >= PostDetailActivity.i(paramPostDetailActivity).size())
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putInt("currentitem_key", ((Integer)paramMessage.obj).intValue());
          localBundle1.putString("type", "offline");
          localBundle1.putSerializable("image_name", (Serializable)localArrayList);
          paramPostDetailActivity.startNewActivity(ShowPictureActivity.class, false, localBundle1);
          return;
        }
        localArrayList.add(((File)PostDetailActivity.i(paramPostDetailActivity).get(i)).getAbsolutePath());
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.PostDetailActivity
 * JD-Core Version:    0.6.0
 */