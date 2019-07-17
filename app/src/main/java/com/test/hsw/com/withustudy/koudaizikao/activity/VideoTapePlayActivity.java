package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.bokecc.sdk.mobile.play.DWMediaPlayer;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleSucceed;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.a.b;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoCourseContent;
import com.withustudy.koudaizikao.fragment.VideoListFragment;
import com.withustudy.koudaizikao.fragment.VideoNoteFragment;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.p;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import koudai.db.VideoInfroDao;
import koudai.db.VideoInfroDao.Properties;

public class VideoTapePlayActivity extends AbsBaseActivity
{
  public static b a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 20;
  public static final int j = 21;
  public static final int k = 50;
  public static final int l = 51;
  public static final int m = 52;
  private TextView A;
  private SeekBar B;
  private Button C;
  private DWMediaPlayer D;
  private SurfaceHolder E;
  private SurfaceView F;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = true;
  private boolean K = false;
  private boolean L = false;
  private Video M = null;
  private String N;
  private VideoCourse O;
  private Video P;
  private Timer Q;
  private Timer R;
  private Timer S;
  private float T;
  private float U;
  private final int V = 75;
  private final int W = 5000;
  private double X;
  private int Y;
  private VideoListFragment Z;
  private VideoNoteFragment aa;
  private c ab;
  private a ac;
  private Button ad;
  private LinearLayout ae;
  private com.withustudy.koudaizikao.custom.a.a af;
  private RelativeLayout n;
  private LinearLayout o;
  private Button p;
  private Button q;
  private LinearLayout r;
  private TextView s;
  private Button t;
  private b u;
  private ProgressBar v;
  private RelativeLayout w;
  private Button x;
  private Button y;
  private TextView z;

  private void a()
  {
    if (this.K)
    {
      this.K = false;
      setRequestedOrientation(1);
    }
    do
    {
      return;
      finish();
    }
    while ((!this.L) || (MyApplication.isRunning));
    startNewActivity(WelcomeActivity.class, false, null);
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.p.setBackgroundResource(2130837898);
      this.p.setTextColor(Color.parseColor("#00b8e5"));
      this.q.setBackgroundResource(2130838003);
      this.q.setTextColor(Color.parseColor("#999999"));
      if (this.O != null)
        b(paramInt);
    }
    do
    {
      return;
      this.q.setBackgroundResource(2130838002);
      this.q.setTextColor(Color.parseColor("#00b8e5"));
      this.p.setBackgroundResource(2130837899);
      this.p.setTextColor(Color.parseColor("#999999"));
    }
    while (this.O == null);
    b(paramInt);
  }

  private void a(boolean paramBoolean)
  {
    try
    {
      this.D.stop();
      this.D.reset();
      if (paramBoolean)
      {
        h.a("切换视频，重新构造播放器");
        i();
        this.v.setVisibility(0);
        this.D.release();
        this.D = null;
      }
      while (true)
      {
        this.F.setBackgroundResource(2131034195);
        this.H = false;
        this.I = false;
        this.z.setText("00:00");
        this.B.setProgress(0);
        this.y.setBackgroundResource(2130837706);
        return;
        h();
        this.v.setVisibility(8);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void b()
  {
    this.D = new DWMediaPlayer();
    this.E = this.F.getHolder();
    this.E.addCallback(this.ab);
  }

  private void b(int paramInt)
  {
    try
    {
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      if (this.aa != null)
        localFragmentTransaction.hide(this.aa);
      if (this.Z != null)
        localFragmentTransaction.hide(this.Z);
      if (paramInt == 0)
        if (this.Z == null)
        {
          this.Z = new VideoListFragment(this.O);
          localFragmentTransaction.add(2131296797, this.Z);
        }
      while (true)
      {
        localFragmentTransaction.commit();
        return;
        localFragmentTransaction.show(this.Z);
        continue;
        if (this.aa == null)
        {
          this.aa = new VideoNoteFragment();
          if (this.M != null)
            this.aa.a(this.M);
          localFragmentTransaction.add(2131296797, this.aa);
          continue;
        }
        localFragmentTransaction.show(this.aa);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void c()
  {
    while (true)
    {
      try
      {
        if (this.M == null)
          break;
        this.D.setDefaultDefinition(DWMediaPlayer.NORMAL_DEFINITION);
        VideoInfroDao localVideoInfroDao = com.withustudy.koudaizikao.e.a.a(this.mContext).e();
        List localList = localVideoInfroDao.k().a(VideoInfroDao.Properties.b.a(this.M.getVideo_id()), new a.a.a.e.k[0]).d();
        if (localList.size() == 0)
          break label217;
        koudai.db.i locali = (koudai.db.i)localList.get(0);
        if (!this.mFileTools.d(locali.c()))
          continue;
        h.a("播放本地视频", locali.c());
        this.D.setDataSource(locali.c());
        this.D.prepareAsync();
        d();
        return;
        h.a("文件已丢失，转为播放在线视频", this.M.getVideo_id());
        localVideoInfroDao.f(locali);
        if (!com.withustudy.koudaizikao.g.k.c(this.mContext))
        {
          h();
          this.v.setVisibility(8);
          k();
          return;
        }
      }
      catch (Exception localException)
      {
        Toast.makeText(getApplicationContext(), "视频加载失败,请退出页面重新播放!", 1).show();
        return;
      }
      this.D.setVideoPlayInfo(this.M.getVideo_id(), "362F26D4FF4ED1EC", "5PnpvX2oiXGNUe8POZQlolPJfe1zm80Q", this.mContext);
      continue;
      label217: h.a("播放在线视频", this.M.getVideo_id());
      if (!com.withustudy.koudaizikao.g.k.c(this.mContext))
      {
        h();
        this.v.setVisibility(8);
        k();
        return;
      }
      this.D.setVideoPlayInfo(this.M.getVideo_id(), "362F26D4FF4ED1EC", "5PnpvX2oiXGNUe8POZQlolPJfe1zm80Q", this.mContext);
    }
    Toast.makeText(getApplicationContext(), "视频加载失败,请退出页面重新播放!", 1).show();
  }

  private void c(int paramInt)
  {
    int i1 = this.D.getCurrentPosition();
    if (paramInt == 0)
    {
      int i3 = i1 - 5000;
      if (i3 >= 0)
      {
        this.D.seekTo(i3);
        this.z.setText(p.a(i3));
      }
    }
    int i2;
    do
    {
      return;
      i2 = i1 + 5000;
    }
    while (i2 > this.B.getMax());
    this.D.seekTo(i2);
    this.z.setText(p.a(i2));
  }

  private void d()
  {
    this.I = false;
    this.z.setText("00:00");
    this.y.setBackgroundResource(2130837705);
    i();
    this.v.setVisibility(0);
  }

  private void e()
  {
    this.D.start();
    this.F.setBackgroundResource(2131034189);
    this.A.setText(p.a(this.D.getDuration()));
    this.B.setMax(this.D.getDuration());
    this.B.setProgress(0);
    this.H = true;
    this.v.setVisibility(8);
    if (this.M.getWatch_progress() != 0)
    {
      this.D.seekTo(this.M.getWatch_progress());
      this.B.setProgress(this.M.getWatch_progress());
    }
  }

  private void f()
  {
    this.S = new Timer();
    this.S.schedule(new bq(this), 0L, 1000L);
  }

  private void g()
  {
    try
    {
      if (this.D != null)
      {
        if (this.D.isPlaying())
        {
          this.D.stop();
          a(false);
        }
        this.D.release();
      }
      if (this.R != null)
        this.R.cancel();
      if (this.S != null)
        this.S.cancel();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void h()
  {
    this.J = true;
    this.w.setVisibility(0);
  }

  private void i()
  {
    this.J = false;
    this.w.setVisibility(8);
  }

  private void j()
  {
    this.R = new Timer();
    this.R.schedule(new br(this), 5000L, 5000L);
  }

  private void k()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("content", "您当前处于非WIFI环境下\n是否继续播放");
    startNewActivityForResult(DialogActivitySimpleChoice.class, 50, localBundle);
  }

  private void l()
  {
    if (this.O != null)
    {
      if (this.af == null)
        this.af = new com.withustudy.koudaizikao.custom.a.a(this, this.ae, "http://share.kdzikao.com/course/share.page?course_id=" + this.O.getCourse_id(), this.O.getCourse_name(), this.O.getTag());
      this.af.b();
      return;
    }
    Toast.makeText(this.mContext, "正在加载课程，请稍后", 0).show();
  }

  protected void bindData()
  {
    this.Y = (int)(0.5625D * this.mSP.y());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mSP.y(), this.Y);
    this.n.setLayoutParams(localLayoutParams);
    j();
    b();
    com.withustudy.koudaizikao.a.a locala = c.b().aB();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.mSP.i();
    arrayOfString[1] = this.N;
    locala.a(this, arrayOfString, 21, this.mContext);
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
    this.L = getIntent().getExtras().getBoolean("push", false);
    this.N = getIntent().getExtras().getString("class");
    a = new b(this);
    this.ab = new c();
    this.ac = new a();
  }

  protected void initListener()
  {
    this.x.setOnClickListener(this.ac);
    this.ad.setOnClickListener(this.ac);
    this.y.setOnClickListener(this.ac);
    this.p.setOnClickListener(this.ac);
    this.q.setOnClickListener(this.ac);
    this.t.setOnClickListener(this.ac);
    this.C.setOnClickListener(this.ac);
    this.B.setOnSeekBarChangeListener(this.ac);
    this.F.setOnClickListener(this.ac);
    this.F.setOnTouchListener(this.ac);
  }

  protected void initView()
  {
    this.n = ((RelativeLayout)findViewById(2131296780));
    this.ae = ((LinearLayout)findViewById(2131296779));
    this.ad = ((Button)findViewById(2131296785));
    this.F = ((SurfaceView)findViewById(2131296781));
    this.w = ((RelativeLayout)findViewById(2131296782));
    this.x = ((Button)findViewById(2131296784));
    this.y = ((Button)findViewById(2131296783));
    this.z = ((TextView)findViewById(2131296786));
    this.A = ((TextView)findViewById(2131296788));
    this.B = ((SeekBar)findViewById(2131296787));
    this.o = ((LinearLayout)findViewById(2131296791));
    this.C = ((Button)findViewById(2131296789));
    this.p = ((Button)findViewById(2131296792));
    this.q = ((Button)findViewById(2131296793));
    this.v = ((ProgressBar)findViewById(2131296790));
    this.r = ((LinearLayout)findViewById(2131296794));
    this.s = ((TextView)findViewById(2131296795));
    this.t = ((Button)findViewById(2131296796));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default:
    case 50:
    case 51:
    case 52:
    }
    do
    {
      do
      {
        do
          return;
        while (paramInt2 == 0);
        this.D.setVideoPlayInfo(this.M.getVideo_id(), "362F26D4FF4ED1EC", "5PnpvX2oiXGNUe8POZQlolPJfe1zm80Q", this.mContext);
        this.D.prepareAsync();
        d();
        return;
      }
      while (this.Z == null);
      if (paramInt2 == 0)
      {
        this.Z.a(false);
        return;
      }
      this.Z.a(true);
      return;
    }
    while (paramInt2 == 0);
    h.a("删除", this.P.getVideo_name(), this.P.getVideo_id());
    VideoInfroDao localVideoInfroDao = com.withustudy.koudaizikao.e.a.a(this.mContext).e();
    List localList = localVideoInfroDao.k().a(VideoInfroDao.Properties.b.a(this.P.getVideo_id()), new a.a.a.e.k[0]).d();
    if (localList.size() != 0)
    {
      localVideoInfroDao.f((koudai.db.i)localList.get(0));
      File localFile = new File(((koudai.db.i)localList.get(0)).c());
      this.mFileTools.a(localFile);
    }
    if (this.Z != null)
      this.Z.e();
    Bundle localBundle = new Bundle();
    localBundle.putString("content", "删除成功");
    startNewActivity(DialogActivitySimpleSucceed.class, 0, 0, false, localBundle);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      if (this.u != null)
        this.u.b();
      this.o.setVisibility(8);
      this.ad.setVisibility(8);
      this.C.setBackgroundResource(2130837821);
      if (this.X != 0.0D)
        this.F.setLayoutParams(p.a(true, this.X, this.Y, this.mSP.y(), this.mSP.x()));
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(this.mSP.x(), this.mSP.y());
      this.n.setLayoutParams(localLayoutParams2);
      return;
    }
    if (this.u != null)
      this.u.b();
    this.o.setVisibility(0);
    this.ad.setVisibility(0);
    this.C.setBackgroundResource(2130837820);
    if (this.X != 0.0D)
      this.F.setLayoutParams(p.a(false, this.X, this.Y, this.mSP.y(), this.mSP.x()));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(this.mSP.y(), this.Y);
    this.n.setLayoutParams(localLayoutParams1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.af != null)
    {
      this.af.c();
      this.af = null;
    }
    if (this.u != null)
    {
      this.u.b();
      this.u = null;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    switch (paramInt)
    {
    default:
      return;
    case 21:
    }
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onStop()
  {
    super.onStop();
    if ((this.H) && (!this.I))
    {
      h();
      this.I = true;
      this.D.pause();
      this.y.setBackgroundResource(2130837706);
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 21:
    }
    while (true)
    {
      return;
      if (paramString1 == null)
        break;
      try
      {
        VideoCourseContent localVideoCourseContent = (VideoCourseContent)c.a().fromJson(paramString1, VideoCourseContent.class);
        if ((localVideoCourseContent == null) || (!localVideoCourseContent.getResult().equals("true")))
          continue;
        this.O = localVideoCourseContent.getCourse();
        a.sendEmptyMessage(6);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
    }
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  protected void setContentView()
  {
    getWindow().setFlags(128, 128);
    setContentView(2130903120);
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
      case 2131296782:
      case 2131296786:
      case 2131296787:
      case 2131296788:
      case 2131296790:
      case 2131296791:
      case 2131296794:
      case 2131296795:
      default:
      case 2131296785:
      case 2131296784:
      case 2131296792:
      case 2131296793:
      case 2131296783:
      case 2131296781:
        do
        {
          do
          {
            do
            {
              return;
              VideoTapePlayActivity.u(VideoTapePlayActivity.this);
              return;
              VideoTapePlayActivity.v(VideoTapePlayActivity.this);
              return;
              VideoTapePlayActivity.a(VideoTapePlayActivity.this, 0);
            }
            while ((VideoTapePlayActivity.a(VideoTapePlayActivity.this) == null) || (VideoTapePlayActivity.a(VideoTapePlayActivity.this).getCategory() != 1));
            VideoTapePlayActivity.b(VideoTapePlayActivity.this).setVisibility(0);
            return;
            VideoTapePlayActivity.a(VideoTapePlayActivity.this, 1);
          }
          while ((VideoTapePlayActivity.a(VideoTapePlayActivity.this) == null) || (VideoTapePlayActivity.a(VideoTapePlayActivity.this).getCategory() != 1));
          VideoTapePlayActivity.b(VideoTapePlayActivity.this).setVisibility(8);
          return;
          if (!VideoTapePlayActivity.w(VideoTapePlayActivity.this))
          {
            if (!VideoTapePlayActivity.x(VideoTapePlayActivity.this))
            {
              Toast.makeText(VideoTapePlayActivity.y(VideoTapePlayActivity.this), "正在初始化播放器，请稍后", 0).show();
              return;
            }
            VideoTapePlayActivity.p(VideoTapePlayActivity.this);
            return;
          }
          try
          {
            if (!VideoTapePlayActivity.z(VideoTapePlayActivity.this))
            {
              VideoTapePlayActivity.c(VideoTapePlayActivity.this, true);
              VideoTapePlayActivity.m(VideoTapePlayActivity.this).pause();
              VideoTapePlayActivity.A(VideoTapePlayActivity.this).setBackgroundResource(2130837706);
              return;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            localIllegalStateException.printStackTrace();
            return;
          }
          VideoTapePlayActivity.c(VideoTapePlayActivity.this, false);
          VideoTapePlayActivity.m(VideoTapePlayActivity.this).start();
          VideoTapePlayActivity.d(VideoTapePlayActivity.this);
          VideoTapePlayActivity.A(VideoTapePlayActivity.this).setBackgroundResource(2130837705);
          return;
        }
        while ((!VideoTapePlayActivity.w(VideoTapePlayActivity.this)) || (VideoTapePlayActivity.t(VideoTapePlayActivity.this) == null) || (VideoTapePlayActivity.t(VideoTapePlayActivity.this).getVisibility() != 8));
        if (!VideoTapePlayActivity.B(VideoTapePlayActivity.this))
        {
          if (VideoTapePlayActivity.C(VideoTapePlayActivity.this) != null)
          {
            VideoTapePlayActivity.C(VideoTapePlayActivity.this).cancel();
            VideoTapePlayActivity.a(VideoTapePlayActivity.this, null);
          }
          VideoTapePlayActivity.D(VideoTapePlayActivity.this);
          VideoTapePlayActivity.a(VideoTapePlayActivity.this, new Timer());
          VideoTapePlayActivity.C(VideoTapePlayActivity.this).schedule(new bs(this), 5000L);
          return;
        }
        if (VideoTapePlayActivity.C(VideoTapePlayActivity.this) != null)
        {
          VideoTapePlayActivity.C(VideoTapePlayActivity.this).cancel();
          VideoTapePlayActivity.a(VideoTapePlayActivity.this, null);
        }
        VideoTapePlayActivity.a(VideoTapePlayActivity.this, new Timer());
        VideoTapePlayActivity.C(VideoTapePlayActivity.this).schedule(new bt(this), 5000L);
        return;
      case 2131296796:
        if (VideoTapePlayActivity.E(VideoTapePlayActivity.this) == null)
          VideoTapePlayActivity.a(VideoTapePlayActivity.this, new b(VideoTapePlayActivity.this, VideoTapePlayActivity.F(VideoTapePlayActivity.this), "批量下载", "批量删除"));
        VideoTapePlayActivity.E(VideoTapePlayActivity.this).a();
        return;
      case 2131296789:
      }
      if (VideoTapePlayActivity.i(VideoTapePlayActivity.this))
      {
        VideoTapePlayActivity.d(VideoTapePlayActivity.this, false);
        VideoTapePlayActivity.this.setRequestedOrientation(1);
        return;
      }
      VideoTapePlayActivity.d(VideoTapePlayActivity.this, true);
      VideoTapePlayActivity.this.setRequestedOrientation(0);
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (VideoTapePlayActivity.w(VideoTapePlayActivity.this))
      {
        if (paramBoolean)
        {
          VideoTapePlayActivity.m(VideoTapePlayActivity.this).seekTo(paramInt);
          VideoTapePlayActivity.I(VideoTapePlayActivity.this).setText(p.a(paramInt));
        }
      }
      else
        return;
      VideoTapePlayActivity.I(VideoTapePlayActivity.this).setText(p.a(VideoTapePlayActivity.q(VideoTapePlayActivity.this).getProgress()));
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((VideoTapePlayActivity.w(VideoTapePlayActivity.this)) && (!VideoTapePlayActivity.z(VideoTapePlayActivity.this)))
      {
        if (paramMotionEvent.getAction() != 0)
          break label40;
        VideoTapePlayActivity.a(VideoTapePlayActivity.this, paramMotionEvent.getX());
      }
      label40: 
      do
      {
        do
        {
          do
            return false;
          while (paramMotionEvent.getAction() != 1);
          VideoTapePlayActivity.b(VideoTapePlayActivity.this, paramMotionEvent.getX());
        }
        while ((VideoTapePlayActivity.G(VideoTapePlayActivity.this) == 0.0F) || (VideoTapePlayActivity.H(VideoTapePlayActivity.this) == 0.0F));
        if (VideoTapePlayActivity.G(VideoTapePlayActivity.this) - VideoTapePlayActivity.H(VideoTapePlayActivity.this) <= 75.0F)
          continue;
        VideoTapePlayActivity.b(VideoTapePlayActivity.this, 1);
        return false;
      }
      while (VideoTapePlayActivity.H(VideoTapePlayActivity.this) - VideoTapePlayActivity.G(VideoTapePlayActivity.this) <= 75.0F);
      VideoTapePlayActivity.b(VideoTapePlayActivity.this, 0);
      return false;
    }
  }

  public static class b extends m<VideoTapePlayActivity>
  {
    public b(VideoTapePlayActivity paramVideoTapePlayActivity)
    {
      super();
    }

    protected void a(VideoTapePlayActivity paramVideoTapePlayActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 6:
      case 1:
      case 2:
      case 3:
        while (true)
        {
          return;
          if (VideoTapePlayActivity.a(paramVideoTapePlayActivity) == null)
            continue;
          VideoTapePlayActivity.b(paramVideoTapePlayActivity).setVisibility(0);
          VideoTapePlayActivity.c(paramVideoTapePlayActivity).setText(String.valueOf(VideoTapePlayActivity.a(paramVideoTapePlayActivity).getVideo_num()) + "个视频");
          VideoTapePlayActivity.a(paramVideoTapePlayActivity, 0);
          return;
          VideoTapePlayActivity.d(paramVideoTapePlayActivity);
          return;
          VideoTapePlayActivity.a(paramVideoTapePlayActivity, (Video)paramMessage.obj);
          if (VideoTapePlayActivity.e(paramVideoTapePlayActivity) != null)
            VideoTapePlayActivity.e(paramVideoTapePlayActivity).a(VideoTapePlayActivity.f(paramVideoTapePlayActivity));
          if (VideoTapePlayActivity.g(paramVideoTapePlayActivity) == null)
            continue;
          VideoTapePlayActivity.a(paramVideoTapePlayActivity, VideoTapePlayActivity.g(paramVideoTapePlayActivity).d());
          VideoTapePlayActivity.h(paramVideoTapePlayActivity).setLayoutParams(p.a(VideoTapePlayActivity.i(paramVideoTapePlayActivity), VideoTapePlayActivity.j(paramVideoTapePlayActivity), VideoTapePlayActivity.k(paramVideoTapePlayActivity), VideoTapePlayActivity.l(paramVideoTapePlayActivity).y(), VideoTapePlayActivity.l(paramVideoTapePlayActivity).x()));
          return;
          try
          {
            Video localVideo = (Video)paramMessage.obj;
            if (VideoTapePlayActivity.f(paramVideoTapePlayActivity).getVideo_id().equals(localVideo.getVideo_id()))
              continue;
            VideoTapePlayActivity.a(paramVideoTapePlayActivity, localVideo);
            if (VideoTapePlayActivity.e(paramVideoTapePlayActivity) != null)
              VideoTapePlayActivity.e(paramVideoTapePlayActivity).a(VideoTapePlayActivity.f(paramVideoTapePlayActivity));
            VideoTapePlayActivity.a(paramVideoTapePlayActivity, true);
            VideoTapePlayActivity.a(paramVideoTapePlayActivity, new DWMediaPlayer());
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setDisplay(VideoTapePlayActivity.n(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnPreparedListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnBufferingUpdateListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnInfoListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnVideoSizeChangedListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnErrorListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.m(paramVideoTapePlayActivity).setOnCompletionListener(VideoTapePlayActivity.o(paramVideoTapePlayActivity));
            VideoTapePlayActivity.p(paramVideoTapePlayActivity);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
        }
      case 4:
        VideoTapePlayActivity.q(paramVideoTapePlayActivity).setProgress(((Integer)paramMessage.obj).intValue());
        return;
      case 5:
        Toast.makeText(paramVideoTapePlayActivity, (String)paramMessage.obj, 0).show();
        return;
      case 7:
      }
      VideoTapePlayActivity.b(paramVideoTapePlayActivity, (Video)paramMessage.obj);
      Bundle localBundle = new Bundle();
      localBundle.putString("content", "确定删除？");
      paramVideoTapePlayActivity.startNewActivityForResult(DialogActivitySimpleChoice.class, 0, 0, 52, localBundle);
    }
  }

  class c
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback
  {
    c()
    {
    }

    public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
    }

    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      h.a("播放结束");
      VideoTapePlayActivity.a(VideoTapePlayActivity.this, false);
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      if (ErrorCode.INVALID_REQUEST.Value() == paramInt1)
      {
        h.a("播放错误，请检查视频状态");
        VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(5, "视频不存在"));
      }
      while (true)
      {
        return false;
        if (ErrorCode.NETWORK_ERROR.Value() == paramInt1)
        {
          h.a("播放错误，请检查网络状态");
          VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(5, "网络连接失败，请检查网络设置"));
          continue;
        }
        if (ErrorCode.PROCESS_FAIL.Value() == paramInt1)
        {
          h.a("播放错误，请检查账户信息");
          VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(5, "服务器出错鸟"));
          continue;
        }
        h.a("未知错误");
      }
    }

    public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default:
        return false;
      case 701:
        VideoTapePlayActivity.t(VideoTapePlayActivity.this).setVisibility(0);
        return false;
      case 702:
      }
      VideoTapePlayActivity.t(VideoTapePlayActivity.this).setVisibility(8);
      return false;
    }

    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      h.a("开始播放", VideoTapePlayActivity.f(VideoTapePlayActivity.this).getVideo_name());
      VideoTapePlayActivity.r(VideoTapePlayActivity.this);
      VideoTapePlayActivity.s(VideoTapePlayActivity.this);
    }

    public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
    }

    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      h.a("播放器准备就绪");
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setDisplay(VideoTapePlayActivity.n(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnPreparedListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnBufferingUpdateListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnInfoListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnVideoSizeChangedListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnErrorListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.m(VideoTapePlayActivity.this).setOnCompletionListener(VideoTapePlayActivity.o(VideoTapePlayActivity.this));
      VideoTapePlayActivity.b(VideoTapePlayActivity.this, true);
    }

    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoTapePlayActivity
 * JD-Core Version:    0.6.0
 */