package com.withustudy.koudaizikao.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.dialog.DialogActivityPay;
import com.withustudy.koudaizikao.activity.dialog.DialogActivityPaySucceed;
import com.withustudy.koudaizikao.b.an;
import com.withustudy.koudaizikao.b.ao;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoChapter;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoCourseContent;
import com.withustudy.koudaizikao.entity.content.VideoListLive;
import com.withustudy.koudaizikao.entity.content.VideoListTape;
import com.withustudy.koudaizikao.fragment.VideoAllFragment;
import com.withustudy.koudaizikao.fragment.VideoAllFragment.b;
import com.withustudy.koudaizikao.fragment.VideoMineFragment;
import com.withustudy.koudaizikao.fragment.VideoMineFragment.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoSaleDetailActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 10;
  public static final int e = 11;
  public static final int f = 14;
  public static final int g = 12;
  public static final int h = 50;
  public static final int i = 51;
  private ao A;
  private List<Video> B;
  private an C;
  private String D;
  private VideoCourse E;
  private b F;
  private a G;
  private boolean H = false;
  private boolean I = false;
  private Button j;
  private LinearLayout k;
  private ImageView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private Button s;
  private Button t;
  private Button u;
  private Button v;
  private WebView w;
  private com.withustudy.koudaizikao.custom.a.a x;
  private ListView y;
  private List<VideoChapter> z;

  private void a()
  {
    WebSettings localWebSettings = this.w.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    localWebSettings.setLoadWithOverviewMode(true);
    this.w.loadUrl(this.E.getIntro());
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.u.setBackgroundResource(2130837898);
      this.u.setTextColor(Color.parseColor("#00b8e5"));
      this.v.setBackgroundResource(2130838003);
      this.v.setTextColor(Color.parseColor("#999999"));
      this.w.setVisibility(0);
      this.y.setVisibility(4);
      return;
    }
    this.v.setBackgroundResource(2130838002);
    this.v.setTextColor(Color.parseColor("#00b8e5"));
    this.u.setBackgroundResource(2130837899);
    this.u.setTextColor(Color.parseColor("#999999"));
    this.w.setVisibility(4);
    this.y.setVisibility(0);
  }

  private void b()
  {
    if ((this.I) && (this.mSP.i().equals("")))
    {
      e();
      return;
    }
    Bundle localBundle = new Bundle();
    if (!this.H)
    {
      if (this.E != null)
      {
        if (this.E.getPrice() != 0.0F)
        {
          localBundle.putSerializable("class", this.E);
          startNewActivityForResult(DialogActivityPay.class, 0, 0, 51, localBundle);
          return;
        }
        if (VideoAllFragment.a != null)
          VideoAllFragment.a.sendMessage(VideoAllFragment.a.obtainMessage(4, this.E.getCourse_id()));
        d();
        com.withustudy.koudaizikao.a.a locala = c.b().ax();
        String[] arrayOfString = new String[8];
        arrayOfString[0] = "";
        arrayOfString[1] = this.E.getCourse_name();
        arrayOfString[2] = "";
        arrayOfString[3] = "";
        arrayOfString[4] = "0";
        arrayOfString[5] = String.valueOf(System.currentTimeMillis());
        arrayOfString[6] = this.mSP.i();
        arrayOfString[7] = this.E.getCourse_id();
        locala.a(this, arrayOfString, 12, this.mContext);
        return;
      }
      Toast.makeText(this.mContext, "课程还在加载，请等待", 0).show();
      return;
    }
    if (this.E.getCategory() == 0)
    {
      localBundle.putSerializable("class", this.E);
      startNewActivity(VideoBoughtDetailActivity.class, true, localBundle);
      return;
    }
    localBundle.putString("class", this.E.getCourse_id());
    startNewActivity(VideoTapePlayActivity.class, true, localBundle);
  }

  private void c()
  {
    if ((this.E.getPic_url() != null) && (!this.E.getPic_url().equals("")))
      this.mFileDownLoad.a(this.E.getPic_url(), this.l);
    this.n.setText(this.E.getCourse_name());
    this.o.setText(this.E.getTag());
    if (this.E.getCategory() == 0)
    {
      this.p.setVisibility(0);
      this.p.setText(this.E.getLive_time());
      this.s.setVisibility(8);
      this.m.setText("直播课");
      this.m.setTextColor(Color.parseColor("#ed3d3d"));
      this.q.setText(String.valueOf(this.E.getCourse_hour()) + "个课时");
      if (this.E.getBuy_status() != 0)
        break label511;
      this.H = false;
      this.r.setText("￥" + String.valueOf(this.E.getPrice()));
      if ((this.E.getPrice() == 0.0F) && (this.E.getCategory() == 0))
        this.t.setText("参加");
    }
    while (true)
    {
      this.y.setSelector(2131034189);
      a(0);
      a();
      com.withustudy.koudaizikao.a.a locala = c.b().az();
      String[] arrayOfString = new String[3];
      arrayOfString[0] = this.mSP.i();
      arrayOfString[1] = this.E.getCourse_id();
      arrayOfString[2] = String.valueOf(this.E.getCategory());
      locala.a(this, arrayOfString, 10, this.mContext);
      return;
      if (this.E.getIs_trail() == 0)
      {
        this.p.setVisibility(8);
        this.s.setVisibility(8);
        this.m.setText("视频课");
        this.m.setTextColor(this.mContext.getResources().getColor(2131034212));
        this.q.setText(String.valueOf(this.E.getVideo_num()) + "个视频");
        break;
      }
      this.p.setVisibility(8);
      this.s.setVisibility(0);
      this.m.setText("视频课");
      this.m.setTextColor(this.mContext.getResources().getColor(2131034212));
      this.q.setText(String.valueOf(this.E.getVideo_num()) + "个视频");
      break;
      label511: this.H = true;
      this.r.setVisibility(8);
      this.E.setBuy_status(1);
      this.t.setText("播放");
      this.s.setVisibility(8);
    }
  }

  private void d()
  {
    this.H = true;
    if (VideoMineFragment.a != null)
      VideoMineFragment.a.sendEmptyMessage(3);
    Bundle localBundle = new Bundle();
    if (this.E.getCategory() == 0)
      localBundle.putString("content", "进入学习课堂");
    while (true)
    {
      if (this.E.getPrice() == 0.0F);
      startNewActivityForResult(DialogActivityPaySucceed.class, 0, 0, 50, localBundle);
      return;
      localBundle.putString("content", "进入视频播放");
    }
  }

  private void e()
  {
    finish();
    if ((this.I) && (!MyApplication.isRunning))
      startNewActivity(WelcomeActivity.class, false, null);
  }

  protected void bindData()
  {
    com.withustudy.koudaizikao.a.a locala1 = c.b().aD();
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = this.mSP.i();
    locala1.a(this, arrayOfString1, 14, this.mContext);
    com.withustudy.koudaizikao.a.a locala2 = c.b().aB();
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = this.mSP.i();
    arrayOfString2[1] = this.D;
    locala2.a(this, arrayOfString2, 11, this.mContext);
  }

  protected void initData()
  {
    this.G = new a();
    this.F = new b(this);
    this.I = getIntent().getExtras().getBoolean("push", false);
    this.D = getIntent().getExtras().getString("class");
  }

  protected void initListener()
  {
    this.j.setOnClickListener(this.G);
    this.k.setOnClickListener(this.G);
    this.t.setOnClickListener(this.G);
    this.s.setOnClickListener(this.G);
    this.v.setOnClickListener(this.G);
    this.u.setOnClickListener(this.G);
  }

  protected void initView()
  {
    this.j = ((Button)findViewById(2131296735));
    this.k = ((LinearLayout)findViewById(2131296736));
    this.l = ((ImageView)findViewById(2131296737));
    this.m = ((TextView)findViewById(2131296738));
    this.n = ((TextView)findViewById(2131296739));
    this.o = ((TextView)findViewById(2131296740));
    this.p = ((TextView)findViewById(2131296742));
    this.r = ((TextView)findViewById(2131296743));
    this.q = ((TextView)findViewById(2131296741));
    this.t = ((Button)findViewById(2131296744));
    this.s = ((Button)findViewById(2131296745));
    this.u = ((Button)findViewById(2131296746));
    this.v = ((Button)findViewById(2131296747));
    this.w = ((WebView)findViewById(2131296749));
    this.y = ((ListView)findViewById(2131296748));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 51)
    {
      if (paramInt2 == 0)
        break label113;
      if (VideoAllFragment.a != null)
        VideoAllFragment.a.sendEmptyMessage(3);
      d();
    }
    Bundle localBundle;
    while (true)
    {
      if (paramInt1 == 50)
      {
        this.E.setBuy_status(1);
        this.t.setText("播放");
        this.s.setVisibility(8);
        if (paramInt2 != 0)
        {
          localBundle = new Bundle();
          if (this.E.getCategory() != 0)
            break;
          localBundle.putSerializable("class", this.E);
          startNewActivity(VideoBoughtDetailActivity.class, true, localBundle);
        }
      }
      return;
      label113: Toast.makeText(this.mContext, "支付失败", 0).show();
    }
    localBundle.putString("class", this.E.getCourse_id());
    startNewActivity(VideoTapePlayActivity.class, true, localBundle);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.x != null)
    {
      this.x.c();
      this.x = null;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    switch (paramInt)
    {
    case 10:
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      e();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    case 12:
    case 13:
    default:
    case 10:
    case 11:
    case 14:
    }
    RspSco localRspSco;
    do
    {
      while (true)
      {
        return;
        if (this.E.getCategory() == 0)
        {
          if (paramString1 != null)
            try
            {
              VideoListLive localVideoListLive = (VideoListLive)c.a().fromJson(paramString1, VideoListLive.class);
              if ((localVideoListLive == null) || (!localVideoListLive.getResult().equals("true")))
                continue;
              this.B = new ArrayList();
              this.B.addAll(localVideoListLive.getPlayback_list());
              this.B.addAll(localVideoListLive.getLiving_list());
              this.F.sendEmptyMessage(2);
              return;
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
              Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
              return;
            }
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        if (paramString1 != null)
          try
          {
            VideoListTape localVideoListTape = (VideoListTape)c.a().fromJson(paramString1, VideoListTape.class);
            if ((localVideoListTape == null) || (!localVideoListTape.getResult().equals("true")))
              continue;
            this.z = new ArrayList();
            this.z.addAll(localVideoListTape.getCourse_dir());
            this.F.sendEmptyMessage(1);
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
            return;
          }
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
        if (paramString1 == null)
          break;
        try
        {
          VideoCourseContent localVideoCourseContent = (VideoCourseContent)c.a().fromJson(paramString1, VideoCourseContent.class);
          if ((localVideoCourseContent == null) || (!localVideoCourseContent.getResult().equals("true")))
            continue;
          this.E = localVideoCourseContent.getCourse();
          this.F.sendEmptyMessage(3);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
      }
      Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      return;
      localRspSco = (RspSco)c.a().fromJson(paramString1, RspSco.class);
    }
    while ((localRspSco == null) || (!localRspSco.getStatus().equals("STATUS_OK")));
    int i1 = localRspSco.getAmount();
    this.mSP.a(i1);
  }

  protected void setContentView()
  {
    setContentView(2130903117);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296737:
      case 2131296738:
      case 2131296739:
      case 2131296740:
      case 2131296741:
      case 2131296742:
      case 2131296743:
      default:
        return;
      case 2131296735:
        VideoSaleDetailActivity.g(VideoSaleDetailActivity.this);
        return;
      case 2131296736:
        if ((VideoSaleDetailActivity.h(VideoSaleDetailActivity.this)) && (VideoSaleDetailActivity.i(VideoSaleDetailActivity.this).i().equals("")))
        {
          VideoSaleDetailActivity.g(VideoSaleDetailActivity.this);
          return;
        }
        if (VideoSaleDetailActivity.j(VideoSaleDetailActivity.this) != null)
        {
          if (VideoSaleDetailActivity.k(VideoSaleDetailActivity.this) == null)
            VideoSaleDetailActivity.a(VideoSaleDetailActivity.this, new com.withustudy.koudaizikao.custom.a.a(VideoSaleDetailActivity.this, VideoSaleDetailActivity.b(VideoSaleDetailActivity.this), "http://share.kdzikao.com/course/share.page?course_id=" + VideoSaleDetailActivity.j(VideoSaleDetailActivity.this).getCourse_id(), VideoSaleDetailActivity.j(VideoSaleDetailActivity.this).getCourse_name(), VideoSaleDetailActivity.j(VideoSaleDetailActivity.this).getTag()));
          VideoSaleDetailActivity.k(VideoSaleDetailActivity.this).b();
          return;
        }
        Toast.makeText(VideoSaleDetailActivity.l(VideoSaleDetailActivity.this), "正在加载课程，请稍后", 0).show();
        return;
      case 2131296744:
        VideoSaleDetailActivity.m(VideoSaleDetailActivity.this);
        return;
      case 2131296745:
        if ((VideoSaleDetailActivity.h(VideoSaleDetailActivity.this)) && (VideoSaleDetailActivity.i(VideoSaleDetailActivity.this).i().equals("")))
        {
          VideoSaleDetailActivity.g(VideoSaleDetailActivity.this);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("class", VideoSaleDetailActivity.j(VideoSaleDetailActivity.this).getCourse_id());
        VideoSaleDetailActivity.this.startNewActivity(VideoTapePlayActivity.class, false, localBundle);
        return;
      case 2131296746:
        VideoSaleDetailActivity.a(VideoSaleDetailActivity.this, 0);
        return;
      case 2131296747:
      }
      VideoSaleDetailActivity.a(VideoSaleDetailActivity.this, 1);
    }
  }

  private static class b extends m<VideoSaleDetailActivity>
  {
    public b(VideoSaleDetailActivity paramVideoSaleDetailActivity)
    {
      super();
    }

    protected void a(VideoSaleDetailActivity paramVideoSaleDetailActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 2:
        VideoSaleDetailActivity.a(paramVideoSaleDetailActivity, new an(VideoSaleDetailActivity.a(paramVideoSaleDetailActivity), paramVideoSaleDetailActivity));
        VideoSaleDetailActivity.b(paramVideoSaleDetailActivity).setAdapter(VideoSaleDetailActivity.c(paramVideoSaleDetailActivity));
        return;
      case 1:
        VideoSaleDetailActivity.a(paramVideoSaleDetailActivity, new ao(VideoSaleDetailActivity.d(paramVideoSaleDetailActivity), paramVideoSaleDetailActivity));
        VideoSaleDetailActivity.b(paramVideoSaleDetailActivity).setAdapter(VideoSaleDetailActivity.e(paramVideoSaleDetailActivity));
        VideoSaleDetailActivity.b(paramVideoSaleDetailActivity).setDivider(null);
        return;
      case 3:
      }
      VideoSaleDetailActivity.f(paramVideoSaleDetailActivity);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoSaleDetailActivity
 * JD-Core Version:    0.6.0
 */