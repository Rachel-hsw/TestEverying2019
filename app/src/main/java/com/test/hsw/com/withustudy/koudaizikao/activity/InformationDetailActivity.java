package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.umeng.socialize.bean.p;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.AdaptiveListView;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.InfoComment;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.entity.content.NewsCommentContent;
import com.withustudy.koudaizikao.entity.content.NewsCommentResult;
import com.withustudy.koudaizikao.entity.content.NewsDetailContent;
import com.withustudy.koudaizikao.entity.content.NewsPushContent;
import com.withustudy.koudaizikao.entity.content.ResultStatus;
import com.withustudy.koudaizikao.entity.req.NewsComment;
import com.withustudy.koudaizikao.g.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InformationDetailActivity extends AbsBaseActivity
{
  public static final int a = 10;
  public static final int b = 11;
  public static final int c = 12;
  public static final int d = 13;
  public static final int e = 14;
  public static final int f = 15;
  public static final int g = 16;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  private LinearLayout A;
  private EditText B;
  private Button C;
  private Button D;
  private News E;
  private int F;
  private String G;
  private int H = 0;
  private AdaptiveListView I;
  private List<InfoComment> J;
  private b K;
  private a L;
  private com.withustudy.koudaizikao.b.n M;
  private InputMethodManager N;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private boolean S = false;
  private Button k;
  private TextView l;
  private Button m;
  private Button n;
  private LoadingView o;
  private ScrollView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private LinearLayout t;
  private FrameLayout u;
  private ImageView v;
  private ImageView w;
  private ImageView x;
  private ImageView y;
  private FrameLayout z;

  private List<String> a(String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    if ((!paramString.contains("<$")) || (!paramString.contains("$>")))
    {
      localArrayList.add(paramString);
      return localArrayList;
    }
    int i2 = 0;
    int i3 = 0;
    while (true)
    {
      if (i1 >= paramString.length())
      {
        if ((!paramString.endsWith("$>")) && (paramString.contains("$>")))
          localArrayList.add(paramString.substring(2 + paramString.lastIndexOf("$>"), paramString.length()));
        return localArrayList;
      }
      if ((paramString.charAt(i1) == '<') && (paramString.charAt(i1 + 1) == '$'))
      {
        if ((paramString.substring(i2, i1) != null) && (!paramString.substring(i2, i1).equals("")))
          localArrayList.add(paramString.substring(i2, i1));
        i3 = i1;
      }
      if ((paramString.charAt(i1) == '$') && (paramString.charAt(i1 + 1) == '>'))
      {
        int i4 = i1 + 1;
        localArrayList.add(paramString.substring(i3, i4 + 1));
        i2 = i4 + 1;
      }
      i1++;
    }
  }

  private void a()
  {
    try
    {
      if (this.E.getArticleType().equals("DAILY_CHEESE"))
      {
        this.l.setText("每日芝士");
        this.q.setText(this.E.getCommentNum() + getResources().getString(2131165418));
        this.r.setText(this.E.getInstruction());
        if (!this.E.getFavoriteTag().equals("1"))
          break label315;
        this.O = true;
        this.m.setBackgroundResource(2130837677);
        label106: if (this.E.getArticleType().equals("DAILY_CHEESE"))
        {
          this.C.setVisibility(0);
          if (!this.E.getThumbTag().equals("1"))
            break label333;
          this.P = true;
          this.C.setBackgroundResource(2130837683);
        }
      }
      while (true)
      {
        this.I.setAdapter(this.M);
        this.I.setSelector(2131034189);
        this.I.setOnItemClickListener(this.L);
        this.p.setOnTouchListener(this.L);
        return;
        if (this.E.getArticleType().equals("EXAMINATION_ROAD"))
        {
          this.l.setText("自考路上");
          break;
        }
        if (this.E.getArticleType().equals("SIGN_UP_INFO"))
        {
          this.l.setText("报考讯息");
          break;
        }
        if (this.E.getArticleType().equals("OFFICIAL_NEWS"))
        {
          this.l.setText("新闻看点");
          break;
        }
        if (!this.E.getArticleType().equals("COMMEN_QUESTION"))
          break;
        this.l.setText("常见问题");
        break;
        label315: this.O = false;
        this.m.setBackgroundResource(2130837688);
        break label106;
        label333: this.P = false;
        this.C.setBackgroundResource(2130837760);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    List localList = a(this.G);
    int i1 = 0;
    if (i1 >= localList.size())
      return;
    if ((!((String)localList.get(i1)).contains("<$")) || (!((String)localList.get(i1)).contains("$>")))
    {
      TextView localTextView = new TextView(this.mContext);
      localTextView.setText((CharSequence)localList.get(i1));
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setTextColor(Color.parseColor("#333333"));
      localTextView.setTextSize(2, 16.0F);
      localTextView.setLineSpacing(0.0F, 1.4F);
      localTextView.setTextIsSelectable(true);
      this.t.addView(localTextView);
    }
    while (true)
    {
      i1++;
      break;
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localImageView.setImageResource(2130838068);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setTag(Integer.valueOf(i1));
      localImageView.setOnClickListener(new v(this, localList));
      this.mFileDownLoad.a(((String)localList.get(i1)).substring(2, -2 + ((String)localList.get(i1)).length()), localImageView, this.mContext);
      this.t.addView(localImageView);
    }
  }

  private void c()
  {
    try
    {
      this.N.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
      this.B.setHint(getResources().getString(2131165423));
      this.B.setText("");
      this.H = 0;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void d()
  {
    finish();
    if ((this.S) && (!MyApplication.isRunning))
      startNewActivity(WelcomeActivity.class, false, null);
  }

  private void e()
  {
    if (this.S)
    {
      a locala2 = c.b().aw();
      String[] arrayOfString2 = new String[3];
      arrayOfString2[0] = this.mSP.i();
      arrayOfString2[1] = this.E.getArticleType();
      arrayOfString2[2] = String.valueOf(this.F);
      locala2.a(this, arrayOfString2, 16, this.mContext);
      return;
    }
    a locala1 = c.b().aw();
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = this.mSP.i();
    arrayOfString1[1] = this.E.getArticleType();
    arrayOfString1[2] = this.E.getArticleId();
    locala1.a(this, arrayOfString1, 16, this.mContext);
  }

  protected void bindData()
  {
    if (!this.S)
    {
      a();
      a locala2 = c.b().W();
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = this.E.getArticleId();
      locala2.a(this, arrayOfString2, 10, this.mContext);
      return;
    }
    a locala1 = c.b().ar();
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = String.valueOf(this.F);
    locala1.a(this, arrayOfString1, 15, this.mContext);
  }

  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.E != null)
    {
      localIntent.putExtra("result", this.E.getArticleId());
      if ((!this.Q) || (!this.R))
        break label56;
      setResult(24, localIntent);
    }
    while (true)
    {
      super.finish();
      return;
      label56: if ((!this.Q) && (this.R))
      {
        setResult(23, localIntent);
        continue;
      }
      if ((this.Q) && (!this.R))
      {
        setResult(22, localIntent);
        continue;
      }
      if ((this.Q) || (this.R))
        continue;
      setResult(21, localIntent);
    }
  }

  protected void initData()
  {
    try
    {
      this.N = ((InputMethodManager)getSystemService("input_method"));
      this.L = new a();
      this.K = new b(this);
      this.J = new ArrayList();
      this.M = new com.withustudy.koudaizikao.b.n(this.mContext, this.J, this.K);
      this.E = ((News)getIntent().getExtras().getSerializable("content"));
      this.F = getIntent().getExtras().getInt("id");
      this.S = getIntent().getExtras().getBoolean("push");
      if (this.S)
        com.withustudy.koudaizikao.g.m.d(this.mContext);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.k.setOnClickListener(this.L);
    this.m.setOnClickListener(this.L);
    this.n.setOnClickListener(this.L);
    this.v.setOnClickListener(this.L);
    this.w.setOnClickListener(this.L);
    this.x.setOnClickListener(this.L);
    this.y.setOnClickListener(this.L);
    this.C.setOnClickListener(this.L);
    this.D.setOnClickListener(this.L);
  }

  protected void initView()
  {
    this.k = ((Button)findViewById(2131296525));
    this.l = ((TextView)findViewById(2131296526));
    this.m = ((Button)findViewById(2131296528));
    this.n = ((Button)findViewById(2131296529));
    this.q = ((TextView)findViewById(2131296527));
    this.r = ((TextView)findViewById(2131296532));
    this.s = ((TextView)findViewById(2131296533));
    this.t = ((LinearLayout)findViewById(2131296534));
    this.u = ((FrameLayout)findViewById(2131296535));
    this.o = ((LoadingView)findViewById(2131296530));
    this.p = ((ScrollView)findViewById(2131296531));
    this.v = ((ImageView)findViewById(2131296536));
    this.w = ((ImageView)findViewById(2131296537));
    this.x = ((ImageView)findViewById(2131296538));
    this.y = ((ImageView)findViewById(2131296539));
    this.z = ((FrameLayout)findViewById(2131296540));
    this.I = ((AdaptiveListView)findViewById(2131296541));
    this.A = ((LinearLayout)findViewById(2131296542));
    this.B = ((EditText)findViewById(2131296544));
    this.C = ((Button)findViewById(2131296543));
    this.D = ((Button)findViewById(2131296545));
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
    switch (paramInt)
    {
    default:
      return;
    case 11:
      this.mProTools.b();
      return;
    case 12:
    }
    this.mProTools.b();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      d();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.mSP.i().equals(""))
    {
      this.A.setVisibility(8);
      return;
    }
    this.A.setVisibility(0);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
    case 15:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    }
    while (true)
    {
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewsPushContent localNewsPushContent = (NewsPushContent)c.a().fromJson(paramString1, NewsPushContent.class);
        if (localNewsPushContent != null)
        {
          this.E = localNewsPushContent.getBasicNews();
          a();
          a locala = c.b().W();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = this.E.getArticleId();
          locala.a(this, arrayOfString, 10, this.mContext);
          return;
        }
      }
      catch (Exception localException6)
      {
        localException6.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewsDetailContent localNewsDetailContent = (NewsDetailContent)c.a().fromJson(paramString1, NewsDetailContent.class);
        if (localNewsDetailContent != null)
        {
          this.o.setVisibility(8);
          this.p.setVisibility(0);
          this.G = localNewsDetailContent.getContent();
          this.s.setText(localNewsDetailContent.getAuthor() + "  " + com.withustudy.koudaizikao.g.b.b(this.mContext, Long.valueOf(this.E.getCreatedTime()).longValue()));
          b();
          this.u.setVisibility(0);
          if ((localNewsDetailContent.getCommentList() == null) || (localNewsDetailContent.getCommentList().size() == 0))
            continue;
          this.z.setVisibility(0);
          this.J.clear();
          this.J.addAll(localNewsDetailContent.getCommentList());
          this.M.notifyDataSetChanged();
          return;
        }
      }
      catch (Exception localException5)
      {
        localException5.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewsCommentResult localNewsCommentResult = (NewsCommentResult)c.a().fromJson(paramString1, NewsCommentResult.class);
        if ((localNewsCommentResult != null) && (localNewsCommentResult.getNewsStatus().equals("NEWS_STATUS_OK")))
        {
          this.K.sendEmptyMessage(2);
          return;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        this.K.sendEmptyMessage(3);
        return;
      }
      this.K.sendEmptyMessage(3);
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewsCommentContent localNewsCommentContent = (NewsCommentContent)c.a().fromJson(paramString1, NewsCommentContent.class);
        if ((localNewsCommentContent != null) && (localNewsCommentContent.getComments() != null))
        {
          this.z.setVisibility(0);
          this.J.addAll(localNewsCommentContent.getComments());
          this.M.notifyDataSetChanged();
          return;
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "没有更多评论了", 0).show();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        ResultStatus localResultStatus2 = (ResultStatus)c.a().fromJson(paramString1, ResultStatus.class);
        if ((localResultStatus2 == null) || (!localResultStatus2.getStatus().equals("NEWS_STATUS_OK")))
          break label681;
        if (!this.O)
          break label654;
        if (this.E.getFavoriteTag().equals("1"))
        {
          this.Q = false;
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      this.Q = true;
      return;
      label654: if (this.E.getFavoriteTag().equals("1"))
      {
        this.Q = true;
        return;
      }
      this.Q = false;
      return;
      label681: Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        ResultStatus localResultStatus1 = (ResultStatus)c.a().fromJson(paramString1, ResultStatus.class);
        if ((localResultStatus1 == null) || (!localResultStatus1.getStatus().equals("NEWS_STATUS_OK")))
          continue;
        if (!this.P)
          break label790;
        if (!this.E.getThumbTag().equals("1"))
          break;
        this.R = false;
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
    }
    this.R = true;
    return;
    label790: if (this.E.getThumbTag().equals("1"))
    {
      this.R = true;
      return;
    }
    this.R = false;
  }

  protected void setContentView()
  {
    setContentView(2130903087);
  }

  class a
    implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296525:
          InformationDetailActivity.h(InformationDetailActivity.this);
          return;
        case 2131296528:
          if (InformationDetailActivity.i(InformationDetailActivity.this).i().equals(""))
          {
            Toast.makeText(InformationDetailActivity.g(InformationDetailActivity.this), "请先登录", 0).show();
            return;
          }
          if (!InformationDetailActivity.j(InformationDetailActivity.this))
          {
            g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_collect");
            Toast.makeText(InformationDetailActivity.g(InformationDetailActivity.this), "收藏成功", 0).show();
            InformationDetailActivity.k(InformationDetailActivity.this).setBackgroundResource(2130837677);
            InformationDetailActivity.a(InformationDetailActivity.this, true);
            a locala4 = c.b().aa();
            InformationDetailActivity localInformationDetailActivity4 = InformationDetailActivity.this;
            String[] arrayOfString4 = new String[3];
            arrayOfString4[0] = InformationDetailActivity.i(InformationDetailActivity.this).i();
            arrayOfString4[1] = InformationDetailActivity.c(InformationDetailActivity.this).getArticleId();
            arrayOfString4[2] = "ADD";
            locala4.a(localInformationDetailActivity4, arrayOfString4, 13, InformationDetailActivity.g(InformationDetailActivity.this));
            return;
          }
          InformationDetailActivity.k(InformationDetailActivity.this).setBackgroundResource(2130837688);
          InformationDetailActivity.a(InformationDetailActivity.this, false);
          a locala3 = c.b().aa();
          InformationDetailActivity localInformationDetailActivity3 = InformationDetailActivity.this;
          String[] arrayOfString3 = new String[3];
          arrayOfString3[0] = InformationDetailActivity.i(InformationDetailActivity.this).i();
          arrayOfString3[1] = InformationDetailActivity.c(InformationDetailActivity.this).getArticleId();
          arrayOfString3[2] = "DELETE";
          locala3.a(localInformationDetailActivity3, arrayOfString3, 13, InformationDetailActivity.g(InformationDetailActivity.this));
          return;
        case 2131296529:
          InformationDetailActivity.l(InformationDetailActivity.this).scrollTo(0, InformationDetailActivity.m(InformationDetailActivity.this).getHeight());
          return;
        case 2131296543:
          if (InformationDetailActivity.i(InformationDetailActivity.this).i().equals(""))
          {
            Toast.makeText(InformationDetailActivity.g(InformationDetailActivity.this), "请先登录", 0).show();
            return;
          }
          if (!InformationDetailActivity.n(InformationDetailActivity.this))
          {
            InformationDetailActivity.o(InformationDetailActivity.this).setBackgroundResource(2130837683);
            InformationDetailActivity.b(InformationDetailActivity.this, true);
            a locala2 = c.b().Z();
            InformationDetailActivity localInformationDetailActivity2 = InformationDetailActivity.this;
            String[] arrayOfString2 = new String[3];
            arrayOfString2[0] = InformationDetailActivity.i(InformationDetailActivity.this).i();
            arrayOfString2[1] = InformationDetailActivity.c(InformationDetailActivity.this).getArticleId();
            arrayOfString2[2] = "ADD";
            locala2.a(localInformationDetailActivity2, arrayOfString2, 14, InformationDetailActivity.g(InformationDetailActivity.this));
            return;
          }
          InformationDetailActivity.o(InformationDetailActivity.this).setBackgroundResource(2130837760);
          InformationDetailActivity.b(InformationDetailActivity.this, false);
          a locala1 = c.b().Z();
          InformationDetailActivity localInformationDetailActivity1 = InformationDetailActivity.this;
          String[] arrayOfString1 = new String[3];
          arrayOfString1[0] = InformationDetailActivity.i(InformationDetailActivity.this).i();
          arrayOfString1[1] = InformationDetailActivity.c(InformationDetailActivity.this).getArticleId();
          arrayOfString1[2] = "CANCEL";
          locala1.a(localInformationDetailActivity1, arrayOfString1, 14, InformationDetailActivity.g(InformationDetailActivity.this));
          return;
        case 2131296536:
          g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_share");
          InformationDetailActivity.p(InformationDetailActivity.this);
          InformationDetailActivity.this.share(p.i, "http://share.kdzikao.com/news/share.page?article_id=" + InformationDetailActivity.c(InformationDetailActivity.this).getArticleId(), InformationDetailActivity.c(InformationDetailActivity.this).getInstruction(), InformationDetailActivity.c(InformationDetailActivity.this).getBriefText());
          return;
        case 2131296537:
          g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_share");
          InformationDetailActivity.p(InformationDetailActivity.this);
          InformationDetailActivity.this.share(p.j, "http://share.kdzikao.com/news/share.page?article_id=" + InformationDetailActivity.c(InformationDetailActivity.this).getArticleId(), InformationDetailActivity.c(InformationDetailActivity.this).getInstruction(), InformationDetailActivity.c(InformationDetailActivity.this).getBriefText());
          return;
        case 2131296538:
          g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_share");
          InformationDetailActivity.p(InformationDetailActivity.this);
          InformationDetailActivity.this.share(p.g, "http://share.kdzikao.com/news/share.page?article_id=" + InformationDetailActivity.c(InformationDetailActivity.this).getArticleId(), InformationDetailActivity.c(InformationDetailActivity.this).getInstruction(), InformationDetailActivity.c(InformationDetailActivity.this).getBriefText());
          return;
        case 2131296539:
          g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_share");
          InformationDetailActivity.p(InformationDetailActivity.this);
          InformationDetailActivity.this.share(p.e, "http://share.kdzikao.com/news/share.page?article_id=" + InformationDetailActivity.c(InformationDetailActivity.this).getArticleId(), InformationDetailActivity.c(InformationDetailActivity.this).getInstruction(), InformationDetailActivity.c(InformationDetailActivity.this).getBriefText());
          return;
        case 2131296545:
          if (InformationDetailActivity.a(InformationDetailActivity.this).getText().toString().equals(""))
          {
            Toast.makeText(InformationDetailActivity.g(InformationDetailActivity.this), "评论内容不能为空", 0).show();
            return;
          }
          NewsComment localNewsComment = new NewsComment();
          localNewsComment.setVersionName(InformationDetailActivity.i(InformationDetailActivity.this).p());
          localNewsComment.setClientType(com.withustudy.koudaizikao.g.n.a());
          localNewsComment.setImei(com.withustudy.koudaizikao.g.n.d(InformationDetailActivity.g(InformationDetailActivity.this)));
          localNewsComment.setNet(com.withustudy.koudaizikao.g.n.c(InformationDetailActivity.g(InformationDetailActivity.this)));
          localNewsComment.setArticleId(InformationDetailActivity.c(InformationDetailActivity.this).getArticleId());
          localNewsComment.setUid(InformationDetailActivity.i(InformationDetailActivity.this).i());
          localNewsComment.setContent(InformationDetailActivity.a(InformationDetailActivity.this).getText().toString());
          localNewsComment.setParentId(String.valueOf(InformationDetailActivity.q(InformationDetailActivity.this)));
          if (InformationDetailActivity.q(InformationDetailActivity.this) == 0)
            g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_publish");
          while (true)
          {
            InformationDetailActivity.r(InformationDetailActivity.this).a("努力发表中");
            c.b().X().a(InformationDetailActivity.this, localNewsComment, 11);
            return;
            g.b(InformationDetailActivity.g(InformationDetailActivity.this), "news_reply");
          }
        case 2131296526:
        case 2131296527:
        case 2131296530:
        case 2131296531:
        case 2131296532:
        case 2131296533:
        case 2131296534:
        case 2131296535:
        case 2131296540:
        case 2131296541:
        case 2131296542:
        case 2131296544:
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramInt == InformationDetailActivity.f(InformationDetailActivity.this).size())
      {
        InformationDetailActivity.r(InformationDetailActivity.this).a();
        a locala = c.b().Y();
        InformationDetailActivity localInformationDetailActivity = InformationDetailActivity.this;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = InformationDetailActivity.c(InformationDetailActivity.this).getArticleId();
        arrayOfString[1] = String.valueOf(InformationDetailActivity.f(InformationDetailActivity.this).size());
        locala.a(localInformationDetailActivity, arrayOfString, 12, InformationDetailActivity.g(InformationDetailActivity.this));
      }
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      InformationDetailActivity.d(InformationDetailActivity.this);
      return false;
    }
  }

  private static class b extends com.withustudy.koudaizikao.base.m<InformationDetailActivity>
  {
    public b(InformationDetailActivity paramInformationDetailActivity)
    {
      super();
    }

    protected void a(InformationDetailActivity paramInformationDetailActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        InformationDetailActivity.a(paramInformationDetailActivity).requestFocus();
        InformationDetailActivity.a(paramInformationDetailActivity).setHint(paramInformationDetailActivity.getResources().getString(2131165510) + ((InfoComment)paramMessage.obj).getFloorId() + paramInformationDetailActivity.getResources().getString(2131165417));
        InformationDetailActivity.b(paramInformationDetailActivity).toggleSoftInput(0, 2);
        InformationDetailActivity.a(paramInformationDetailActivity, Integer.valueOf(((InfoComment)paramMessage.obj).getCommentId()).intValue());
        return;
      case 2:
        if (InformationTypeActivity.a != null)
          InformationTypeActivity.a.sendMessage(InformationTypeActivity.a.obtainMessage(3, InformationDetailActivity.c(paramInformationDetailActivity).getArticleId()));
        Toast.makeText(paramInformationDetailActivity, "评论成功", 0).show();
        InformationDetailActivity.d(paramInformationDetailActivity);
        InformationDetailActivity.e(paramInformationDetailActivity).setText(1 + Integer.valueOf(InformationDetailActivity.c(paramInformationDetailActivity).getCommentNum()).intValue() + paramInformationDetailActivity.getResources().getString(2131165418));
        a locala = c.b().Y();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = InformationDetailActivity.c(paramInformationDetailActivity).getArticleId();
        arrayOfString[1] = String.valueOf(InformationDetailActivity.f(paramInformationDetailActivity).size());
        locala.a(paramInformationDetailActivity, arrayOfString, 12, InformationDetailActivity.g(paramInformationDetailActivity));
        return;
      case 3:
      }
      Toast.makeText(paramInformationDetailActivity, "服务器未响应，请稍后再试", 0).show();
      InformationDetailActivity.d(paramInformationDetailActivity);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.InformationDetailActivity
 * JD-Core Version:    0.6.0
 */