package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.common.ServiceType;
import com.gensee.entity.ChatMsg;
import com.gensee.entity.DocInfo;
import com.gensee.entity.InitParam;
import com.gensee.entity.QAMsg;
import com.gensee.entity.VodObject;
import com.gensee.media.VODPlayer;
import com.gensee.media.VODPlayer.OnVodPlayListener;
import com.gensee.view.GSDocViewGx;
import com.gensee.vod.VodSite;
import com.gensee.vod.VodSite.OnVodListener;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.a.b;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.fragment.VideoChatFragment;
import com.withustudy.koudaizikao.fragment.VideoNoteFragment;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.p;
import java.util.List;
import java.util.Timer;
import koudai.db.VideoInfroDao;
import koudai.db.VideoInfroDao.Properties;

public class VideoLiveReplayActivity extends AbsBaseActivity
{
  private static RelativeLayout B;
  public static b b;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 20;
  public static final int l = 50;
  private LinearLayout A;
  private GSDocViewGx C;
  private VodSite D;
  private VODPlayer E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = true;
  private boolean J = false;
  private Video K;
  private String L;
  private int M;
  private Timer N;
  private Timer O;
  private float P;
  private float Q;
  private final int R = 75;
  private final int S = 5000;
  private double T;
  private int U;
  private VideoChatFragment V;
  private VideoNoteFragment W;
  private c X;
  private a Y;
  private VideoCourse Z;
  public boolean a = false;
  private com.withustudy.koudaizikao.custom.a.a aa;
  private RelativeLayout m;
  private LinearLayout n;
  private Button o;
  private Button p;
  private b q;
  private ProgressBar r;
  private RelativeLayout s;
  private Button t;
  private Button u;
  private TextView v;
  private TextView w;
  private SeekBar x;
  private Button y;
  private Button z;

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.o.setBackgroundResource(2130837898);
      this.o.setTextColor(Color.parseColor("#00b8e5"));
      this.p.setBackgroundResource(2130838003);
      this.p.setTextColor(Color.parseColor("#999999"));
      b(paramInt);
      return;
    }
    this.p.setBackgroundResource(2130838002);
    this.p.setTextColor(Color.parseColor("#00b8e5"));
    this.o.setBackgroundResource(2130837899);
    this.o.setTextColor(Color.parseColor("#999999"));
    b(paramInt);
  }

  private void b()
  {
    if (this.J)
    {
      this.J = false;
      setRequestedOrientation(1);
      return;
    }
    finish();
  }

  private void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    if (this.V != null)
      localFragmentTransaction.hide(this.V);
    if (this.W != null)
      localFragmentTransaction.hide(this.W);
    if (paramInt == 0)
      if (this.V == null)
      {
        this.V = new VideoChatFragment(this.E);
        localFragmentTransaction.add(2131296766, this.V);
      }
    while (true)
    {
      localFragmentTransaction.commit();
      return;
      localFragmentTransaction.show(this.V);
      continue;
      if (this.W == null)
      {
        this.W = new VideoNoteFragment();
        this.W.a(this.K);
        localFragmentTransaction.add(2131296766, this.W);
        continue;
      }
      localFragmentTransaction.show(this.W);
    }
  }

  private void c()
  {
    InitParam localInitParam = new InitParam();
    localInitParam.setDomain("withustudy.gensee.com");
    localInitParam.setLiveId(this.K.getVideo_id());
    localInitParam.setNumber(this.K.getVideo_number());
    localInitParam.setServiceType(ServiceType.ST_TRAINING);
    localInitParam.setVodPwd(this.K.getWatch_passwd());
    localInitParam.setNickName(this.mSP.v());
    localInitParam.setUserId(this.M);
    this.D.getVodObject(localInitParam);
  }

  private void c(int paramInt)
  {
    int i1 = this.x.getProgress();
    if (paramInt == 0)
    {
      int i3 = i1 - 5000;
      if (i3 >= 0)
      {
        this.E.seekTo(i3);
        this.v.setText(p.a(i3));
      }
    }
    int i2;
    do
    {
      return;
      i2 = i1 + 5000;
    }
    while (i2 > this.x.getMax());
    this.E.seekTo(i2);
    this.v.setText(p.a(i2));
  }

  private void d()
  {
    this.H = false;
    this.v.setText("00:00");
    this.x.setProgress(0);
    this.u.setBackgroundResource(2130837705);
    i();
    this.r.setVisibility(0);
  }

  private void e()
  {
    VideoInfroDao localVideoInfroDao = com.withustudy.koudaizikao.e.a.a(this.mContext).e();
    List localList = localVideoInfroDao.k().a(VideoInfroDao.Properties.b.a(this.K.getVideo_id()), new a.a.a.e.k[0]).d();
    koudai.db.i locali;
    if (localList.size() != 0)
    {
      locali = (koudai.db.i)localList.get(0);
      if (this.mFileTools.d(locali.c()))
        this.E.play(locali.c(), this.X, com.withustudy.koudaizikao.g.f.d);
    }
    while (true)
    {
      d();
      return;
      localVideoInfroDao.f(locali);
      this.E.play(this.K.getVideo_id(), this.X, com.withustudy.koudaizikao.g.f.d);
      continue;
      this.E.play(this.K.getVideo_id(), this.X, com.withustudy.koudaizikao.g.f.d);
    }
  }

  private void f()
  {
    this.E.release();
    this.G = false;
    this.H = false;
    this.v.setText("00:00");
    this.x.setProgress(0);
    this.u.setBackgroundResource(2130837706);
    if (this.r.getVisibility() == 0)
      this.r.setVisibility(8);
    h();
  }

  private void g()
  {
    if (this.O != null)
      this.O.cancel();
    if (this.E != null)
    {
      this.E.stop();
      this.E.release();
    }
  }

  private void h()
  {
    this.I = true;
    this.s.setVisibility(0);
  }

  private void i()
  {
    this.I = false;
    this.s.setVisibility(8);
  }

  private void j()
  {
    this.O = new Timer();
    this.O.schedule(new bn(this), 5000L, 5000L);
  }

  private void k()
  {
    if (this.Z != null)
    {
      if (this.aa == null)
        this.aa = new com.withustudy.koudaizikao.custom.a.a(this, this.A, "http://share.kdzikao.com/course/share.page?course_id=" + this.Z.getCourse_id(), this.Z.getCourse_name(), this.Z.getTag());
      this.aa.b();
      return;
    }
    Toast.makeText(this.mContext, "正在加载课程，请稍后", 0).show();
  }

  public void a()
  {
    B.setVisibility(8);
  }

  protected void bindData()
  {
    this.U = (int)(0.5625D * this.mSP.y());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mSP.y(), this.U);
    this.m.setLayoutParams(localLayoutParams);
    this.C.setLayoutParams(p.a(this.J, this.T, this.U, this.mSP.y(), this.mSP.x()));
    this.v.setText("00:00");
    this.D = new VodSite(this.mContext);
    c();
    j();
    this.E = new VODPlayer();
    this.E.setGSDocViewGx(this.C);
    this.C.forbidZoomGestrue(true);
    a(1);
  }

  public void finish()
  {
    g();
    super.finish();
  }

  public void finish(int paramInt1, int paramInt2)
  {
    g();
    super.finish(paramInt1, paramInt2);
  }

  protected void initData()
  {
    try
    {
      this.L = getIntent().getExtras().getString("class");
      this.K = ((Video)getIntent().getExtras().getSerializable("video"));
      this.M = getIntent().getExtras().getInt("uid");
      this.T = getIntent().getExtras().getDouble("scale");
      b = new b(this);
      this.X = new c();
      this.Y = new a();
      this.Z = ((VideoCourse)getIntent().getExtras().getSerializable("mClass"));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.t.setOnClickListener(this.Y);
    this.u.setOnClickListener(this.Y);
    this.o.setOnClickListener(this.Y);
    this.p.setOnClickListener(this.Y);
    this.y.setOnClickListener(this.Y);
    this.C.setOnClickListener(this.Y);
    this.z.setOnClickListener(this.Y);
    this.C.setOnTouchListener(this.Y);
    this.x.setOnSeekBarChangeListener(this.Y);
    this.D.setVodListener(this.X);
  }

  protected void initView()
  {
    this.A = ((LinearLayout)findViewById(2131296750));
    this.m = ((RelativeLayout)findViewById(2131296751));
    B = (RelativeLayout)findViewById(2131296753);
    this.s = ((RelativeLayout)findViewById(2131296754));
    this.t = ((Button)findViewById(2131296756));
    this.u = ((Button)findViewById(2131296755));
    this.v = ((TextView)findViewById(2131296758));
    this.w = ((TextView)findViewById(2131296760));
    this.x = ((SeekBar)findViewById(2131296759));
    this.n = ((LinearLayout)findViewById(2131296763));
    this.y = ((Button)findViewById(2131296761));
    this.o = ((Button)findViewById(2131296764));
    this.p = ((Button)findViewById(2131296765));
    this.z = ((Button)findViewById(2131296757));
    this.r = ((ProgressBar)findViewById(2131296762));
    this.C = ((GSDocViewGx)findViewById(2131296752));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 50)
    {
      if (paramInt2 == 0)
        this.a = false;
    }
    else
      return;
    this.a = true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      if (this.q != null)
        this.q.b();
      this.n.setVisibility(8);
      this.z.setVisibility(8);
      this.y.setBackgroundResource(2130837821);
      this.C.setLayoutParams(p.a(true, this.T, this.U, this.mSP.y(), this.mSP.x()));
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(this.mSP.x(), this.mSP.y());
      this.m.setLayoutParams(localLayoutParams2);
      return;
    }
    if (this.q != null)
      this.q.b();
    this.n.setVisibility(0);
    this.z.setVisibility(0);
    this.y.setBackgroundResource(2130837820);
    this.C.setLayoutParams(p.a(false, this.T, this.U, this.mSP.y(), this.mSP.x()));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(this.mSP.y(), this.U);
    this.m.setLayoutParams(localLayoutParams1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.aa != null)
    {
      this.aa.c();
      this.aa = null;
    }
    if (this.q != null)
    {
      this.q.b();
      this.q = null;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onStop()
  {
    super.onStop();
    if ((this.G) && (!this.H))
    {
      h();
      this.H = true;
      this.E.pause();
      this.u.setBackgroundResource(2130837706);
    }
  }

  protected void setContentView()
  {
    getWindow().setFlags(128, 128);
    setContentView(2130903118);
  }

  class a
    implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296753:
      case 2131296754:
      case 2131296758:
      case 2131296759:
      case 2131296760:
      case 2131296762:
      case 2131296763:
      default:
      case 2131296757:
      case 2131296756:
      case 2131296764:
      case 2131296765:
      case 2131296755:
      case 2131296761:
      case 2131296752:
      }
      label406: 
      do
      {
        return;
        VideoLiveReplayActivity.i(VideoLiveReplayActivity.this);
        return;
        VideoLiveReplayActivity.j(VideoLiveReplayActivity.this);
        return;
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, 0);
        return;
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, 1);
        return;
        List localList = com.withustudy.koudaizikao.e.a.a(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this)).e().k().a(VideoInfroDao.Properties.b.a(VideoLiveReplayActivity.g(VideoLiveReplayActivity.this).getVideo_id()), new a.a.a.e.k[0]).d();
        int i;
        if ((localList != null) && (localList.size() > 0))
          i = 1;
        while (true)
        {
          if (VideoLiveReplayActivity.l(VideoLiveReplayActivity.this))
            break label406;
          if (i != 0)
            break;
          Boolean.valueOf(false);
          if (!Boolean.valueOf(com.withustudy.koudaizikao.g.k.a(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this))).booleanValue())
          {
            Toast.makeText(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this), "当前没有网络!", 0).show();
            return;
            i = 0;
            continue;
          }
          if (com.withustudy.koudaizikao.g.k.c(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this)))
          {
            if (!VideoLiveReplayActivity.m(VideoLiveReplayActivity.this))
            {
              Toast.makeText(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this), "正在获取视频信息", 0).show();
              try
              {
                VideoLiveReplayActivity.n(VideoLiveReplayActivity.this);
                return;
              }
              catch (Exception localException2)
              {
                return;
              }
            }
            VideoLiveReplayActivity.this.a = false;
            VideoLiveReplayActivity.o(VideoLiveReplayActivity.this);
            return;
          }
          if (!VideoLiveReplayActivity.this.a)
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("content", "您当前处于非WIFI环境下\n是否继续播放");
            VideoLiveReplayActivity.this.startNewActivityForResult(DialogActivitySimpleChoice.class, 50, localBundle);
            return;
          }
          if (!VideoLiveReplayActivity.m(VideoLiveReplayActivity.this))
          {
            Toast.makeText(VideoLiveReplayActivity.k(VideoLiveReplayActivity.this), "正在获取视频信息", 0).show();
            try
            {
              VideoLiveReplayActivity.n(VideoLiveReplayActivity.this);
              return;
            }
            catch (Exception localException1)
            {
              return;
            }
          }
          VideoLiveReplayActivity.this.a = true;
          VideoLiveReplayActivity.o(VideoLiveReplayActivity.this);
          return;
        }
        VideoLiveReplayActivity.this.a = false;
        VideoLiveReplayActivity.o(VideoLiveReplayActivity.this);
        return;
        if (!VideoLiveReplayActivity.p(VideoLiveReplayActivity.this))
        {
          VideoLiveReplayActivity.c(VideoLiveReplayActivity.this, true);
          VideoLiveReplayActivity.h(VideoLiveReplayActivity.this).pause();
          VideoLiveReplayActivity.q(VideoLiveReplayActivity.this).setBackgroundResource(2130837706);
          return;
        }
        VideoLiveReplayActivity.c(VideoLiveReplayActivity.this, false);
        VideoLiveReplayActivity.h(VideoLiveReplayActivity.this).resume();
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this);
        VideoLiveReplayActivity.q(VideoLiveReplayActivity.this).setBackgroundResource(2130837705);
        return;
        if (VideoLiveReplayActivity.r(VideoLiveReplayActivity.this))
        {
          VideoLiveReplayActivity.d(VideoLiveReplayActivity.this, false);
          VideoLiveReplayActivity.this.setRequestedOrientation(1);
          return;
        }
        VideoLiveReplayActivity.d(VideoLiveReplayActivity.this, true);
        VideoLiveReplayActivity.this.setRequestedOrientation(0);
        return;
      }
      while ((!VideoLiveReplayActivity.l(VideoLiveReplayActivity.this)) || (VideoLiveReplayActivity.b(VideoLiveReplayActivity.this).getVisibility() != 8));
      if (!VideoLiveReplayActivity.s(VideoLiveReplayActivity.this))
      {
        VideoLiveReplayActivity.t(VideoLiveReplayActivity.this);
        if (VideoLiveReplayActivity.u(VideoLiveReplayActivity.this) != null)
        {
          VideoLiveReplayActivity.u(VideoLiveReplayActivity.this).cancel();
          VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, null);
        }
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, new Timer());
        VideoLiveReplayActivity.u(VideoLiveReplayActivity.this).schedule(new bo(this), 5000L);
        return;
      }
      if (VideoLiveReplayActivity.u(VideoLiveReplayActivity.this) != null)
      {
        VideoLiveReplayActivity.u(VideoLiveReplayActivity.this).cancel();
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, null);
      }
      VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, new Timer());
      VideoLiveReplayActivity.u(VideoLiveReplayActivity.this).schedule(new bp(this), 5000L);
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if ((VideoLiveReplayActivity.l(VideoLiveReplayActivity.this)) && (paramBoolean))
      {
        VideoLiveReplayActivity.h(VideoLiveReplayActivity.this).seekTo(paramInt);
        VideoLiveReplayActivity.e(VideoLiveReplayActivity.this).setText(p.a(paramInt));
      }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((VideoLiveReplayActivity.l(VideoLiveReplayActivity.this)) && (!VideoLiveReplayActivity.p(VideoLiveReplayActivity.this)))
      {
        if (paramMotionEvent.getAction() != 0)
          break label40;
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, paramMotionEvent.getX());
      }
      label40: 
      do
      {
        do
        {
          do
            return false;
          while (paramMotionEvent.getAction() != 1);
          VideoLiveReplayActivity.b(VideoLiveReplayActivity.this, paramMotionEvent.getX());
        }
        while ((VideoLiveReplayActivity.v(VideoLiveReplayActivity.this) == 0.0F) || (VideoLiveReplayActivity.w(VideoLiveReplayActivity.this) == 0.0F));
        if (VideoLiveReplayActivity.v(VideoLiveReplayActivity.this) - VideoLiveReplayActivity.w(VideoLiveReplayActivity.this) <= 75.0F)
          continue;
        VideoLiveReplayActivity.b(VideoLiveReplayActivity.this, 1);
        return false;
      }
      while (VideoLiveReplayActivity.w(VideoLiveReplayActivity.this) - VideoLiveReplayActivity.v(VideoLiveReplayActivity.this) <= 75.0F);
      VideoLiveReplayActivity.b(VideoLiveReplayActivity.this, 0);
      return false;
    }
  }

  public static class b extends m<VideoLiveReplayActivity>
  {
    public b(VideoLiveReplayActivity paramVideoLiveReplayActivity)
    {
      super();
    }

    protected void a(VideoLiveReplayActivity paramVideoLiveReplayActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 8:
        paramVideoLiveReplayActivity.a();
        return;
      case 1:
        VideoLiveReplayActivity.a(paramVideoLiveReplayActivity);
        return;
      case 2:
        VideoLiveReplayActivity.b(paramVideoLiveReplayActivity).setVisibility(8);
        return;
      case 3:
        VideoLiveReplayActivity.b(paramVideoLiveReplayActivity).setVisibility(0);
        return;
      case 4:
        int j = ((Integer)paramMessage.obj).intValue();
        VideoLiveReplayActivity.c(paramVideoLiveReplayActivity).setMax(j);
        VideoLiveReplayActivity.d(paramVideoLiveReplayActivity).setText(p.a(j));
        return;
      case 5:
        int i = ((Integer)paramMessage.obj).intValue();
        VideoLiveReplayActivity.e(paramVideoLiveReplayActivity).setText(p.a(i));
        VideoLiveReplayActivity.c(paramVideoLiveReplayActivity).setProgress(i);
        return;
      case 6:
        VideoLiveReplayActivity.f(paramVideoLiveReplayActivity);
        return;
      case 7:
      }
      Toast.makeText(paramVideoLiveReplayActivity, (String)paramMessage.obj, 0).show();
    }
  }

  class c
    implements VODPlayer.OnVodPlayListener, VodSite.OnVodListener
  {
    c()
    {
    }

    public void onAudioLevel(int paramInt)
    {
    }

    public void onCaching(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        VideoLiveReplayActivity.b.sendEmptyMessage(3);
        return;
      }
      VideoLiveReplayActivity.b.sendEmptyMessage(2);
    }

    public void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean)
    {
      h.a("聊天记录");
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
          return;
        h.a(((ChatMsg)paramList.get(i)).getContent());
      }
    }

    public void onError(int paramInt)
    {
      h.a("播放视频出错");
      if ((p.c(paramInt) != null) && (!p.c(paramInt).equals("")))
        VideoLiveReplayActivity.b.sendMessage(VideoLiveReplayActivity.b.obtainMessage(7, p.c(paramInt)));
    }

    public void onInit(int paramInt1, boolean paramBoolean, int paramInt2, List<DocInfo> paramList)
    {
      if (paramInt1 == 0)
      {
        h.a("onInit", "视频数据获取完毕");
        VideoLiveReplayActivity.a(VideoLiveReplayActivity.this, true);
        VideoLiveReplayActivity.b.sendMessage(VideoLiveReplayActivity.b.obtainMessage(4, Integer.valueOf(paramInt2)));
      }
    }

    public void onPageSize(int paramInt1, int paramInt2, int paramInt3)
    {
      h.a("onPageSize");
    }

    public void onPlayPause()
    {
      h.a("播放暂停");
    }

    public void onPlayResume()
    {
      h.a("恢复播放");
    }

    public void onPlayStop()
    {
      h.a("播放停止");
      VideoLiveReplayActivity.b.sendEmptyMessage(6);
    }

    public void onPosition(int paramInt)
    {
      if (VideoLiveReplayActivity.b(VideoLiveReplayActivity.this).getVisibility() == 0)
        VideoLiveReplayActivity.b.sendEmptyMessage(2);
      VideoLiveReplayActivity.b.sendMessage(VideoLiveReplayActivity.b.obtainMessage(5, Integer.valueOf(paramInt)));
    }

    public void onQaHistory(String paramString, List<QAMsg> paramList, int paramInt, boolean paramBoolean)
    {
    }

    public void onSeek(int paramInt)
    {
    }

    public void onVideoSize(int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onVideoStart()
    {
      h.a("onVideoStart", "播放开始");
      if (VideoLiveReplayActivity.g(VideoLiveReplayActivity.this).getWatch_progress() != 0)
        VideoLiveReplayActivity.h(VideoLiveReplayActivity.this).seekTo(VideoLiveReplayActivity.g(VideoLiveReplayActivity.this).getWatch_progress());
      VideoLiveReplayActivity.b.sendMessage(VideoLiveReplayActivity.b.obtainMessage(5, Integer.valueOf(VideoLiveReplayActivity.g(VideoLiveReplayActivity.this).getWatch_progress())));
      VideoLiveReplayActivity.b.sendEmptyMessage(2);
    }

    public void onVodDetail(VodObject paramVodObject)
    {
      h.a("视频详情");
      h.a(paramVodObject);
    }

    public void onVodErr(int paramInt)
    {
      h.a("加载视频出错", p.b(paramInt));
      VideoLiveReplayActivity.b.sendMessage(VideoLiveReplayActivity.b.obtainMessage(7, p.b(paramInt)));
    }

    public void onVodObject(String paramString)
    {
      h.a("onVodObject", "播放id", paramString);
      VideoLiveReplayActivity.b(VideoLiveReplayActivity.this, true);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoLiveReplayActivity
 * JD-Core Version:    0.6.0
 */