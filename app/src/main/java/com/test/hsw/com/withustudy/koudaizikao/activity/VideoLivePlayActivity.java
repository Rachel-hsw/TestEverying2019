package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.gensee.common.ServiceType;
import com.gensee.entity.InitParam;
import com.gensee.entity.UserInfo;
import com.gensee.holder.chat.ExpressionResource;
import com.gensee.player.OnPlayListener;
import com.gensee.player.Player;
import com.gensee.view.GSDocViewGx;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimple;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.fragment.VideoChatFragment;
import com.withustudy.koudaizikao.fragment.VideoNoteFragment;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.k;
import com.withustudy.koudaizikao.g.p;
import java.util.Timer;

public class VideoLivePlayActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 7;
  public static final int g = 50;
  private int A;
  private double B;
  private int C;
  private b D;
  private a E;
  private c F;
  private LinearLayout G;
  private VideoCourse H;
  private Button I;
  private a J;
  private RelativeLayout h;
  private Button i;
  private Button j;
  private LinearLayout k;
  private VideoChatFragment l;
  private VideoNoteFragment m;
  private Player n;
  private InitParam o;
  private GSDocViewGx p;
  private RelativeLayout q;
  private ProgressBar r;
  private Button s;
  private Button t;
  private boolean u = false;
  private boolean v = true;
  private boolean w = false;
  private boolean x = false;
  private Video y;
  private Timer z;

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.i.setBackgroundResource(2130837898);
      this.i.setTextColor(Color.parseColor("#00b8e5"));
      this.j.setBackgroundResource(2130838003);
      this.j.setTextColor(Color.parseColor("#999999"));
      b(paramInt);
      return;
    }
    this.j.setBackgroundResource(2130838002);
    this.j.setTextColor(Color.parseColor("#00b8e5"));
    this.i.setBackgroundResource(2130837899);
    this.i.setTextColor(Color.parseColor("#999999"));
    b(paramInt);
  }

  private void b()
  {
    if (this.w)
    {
      this.w = false;
      setRequestedOrientation(1);
    }
    do
    {
      return;
      finish();
    }
    while ((!this.x) || (MyApplication.isRunning));
    startNewActivity(WelcomeActivity.class, false, null);
  }

  private void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    if (this.l != null)
      localFragmentTransaction.hide(this.l);
    if (this.m != null)
      localFragmentTransaction.hide(this.m);
    if (paramInt == 0)
      if (this.l == null)
      {
        this.l = new VideoChatFragment(this.n, this.A);
        localFragmentTransaction.add(2131296778, this.l);
      }
    while (true)
    {
      localFragmentTransaction.commit();
      return;
      localFragmentTransaction.show(this.l);
      continue;
      if (this.m == null)
      {
        this.m = new VideoNoteFragment();
        this.m.a(this.y);
        localFragmentTransaction.add(2131296778, this.m);
        continue;
      }
      localFragmentTransaction.show(this.m);
    }
  }

  private void c()
  {
    this.o = new InitParam();
    this.o.setDomain("withustudy.gensee.com");
    this.o.setServiceType(ServiceType.ST_TRAINING);
    this.o.setNumber(this.y.getVideo_number());
    this.o.setVodPwd(this.y.getWatch_passwd());
    this.o.setNickName(this.mSP.v());
    this.o.setUserId(this.A);
    this.n = new Player();
    this.n.setGSDocViewGx(this.p);
  }

  private void d()
  {
    if (this.n != null)
      this.n.release(this.mContext);
  }

  private void e()
  {
    this.v = true;
    this.q.setVisibility(0);
  }

  private void f()
  {
    this.v = false;
    this.q.setVisibility(8);
  }

  private void g()
  {
    if (this.H != null)
    {
      if (this.J == null)
        this.J = new a(this, this.G, "http://share.kdzikao.com/course/share.page?course_id=" + this.H.getCourse_id(), this.H.getCourse_name(), this.H.getTag());
      this.J.b();
      return;
    }
    Toast.makeText(this.mContext, "正在加载课程，请稍后", 0).show();
  }

  public int a()
  {
    int i1 = getResources().getIdentifier("status_bar_height", "dimen", "android");
    int i2 = 0;
    if (i1 > 0)
      i2 = getResources().getDimensionPixelSize(i1);
    return i2;
  }

  protected void bindData()
  {
    ExpressionResource.initExpressionResource(this.mContext);
    this.C = (int)(0.5625D * this.mSP.y());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mSP.y(), this.C);
    this.h.setLayoutParams(localLayoutParams);
    this.p.setLayoutParams(p.a(this.w, this.B, this.C, this.mSP.y(), this.mSP.x()));
    this.p.forbidZoomGestrue(true);
    c();
    a(0);
    if (!k.c(this.mContext))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("content", "您当前处于非WIFI环境下\n是否继续播放");
      startNewActivityForResult(DialogActivitySimpleChoice.class, 50, localBundle);
      return;
    }
    this.n.join(this.mContext, this.o, this.F);
    this.D.sendEmptyMessage(1);
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
    try
    {
      this.x = getIntent().getExtras().getBoolean("push", false);
      this.y = ((Video)getIntent().getExtras().getSerializable("video"));
      this.A = getIntent().getExtras().getInt("uid");
      this.B = getIntent().getExtras().getDouble("scale");
      this.H = ((VideoCourse)getIntent().getExtras().getSerializable("mClass"));
      this.D = new b(this);
      this.E = new a();
      this.F = new c();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.i.setOnClickListener(this.E);
    this.s.setOnClickListener(this.E);
    this.j.setOnClickListener(this.E);
    this.t.setOnClickListener(this.E);
    this.p.setOnClickListener(this.E);
    this.I.setOnClickListener(this.E);
  }

  protected void initView()
  {
    this.G = ((LinearLayout)findViewById(2131296767));
    this.h = ((RelativeLayout)findViewById(2131296768));
    this.i = ((Button)findViewById(2131296776));
    this.j = ((Button)findViewById(2131296777));
    this.I = ((Button)findViewById(2131296772));
    this.k = ((LinearLayout)findViewById(2131296775));
    this.r = ((ProgressBar)findViewById(2131296774));
    this.p = ((GSDocViewGx)findViewById(2131296769));
    this.s = ((Button)findViewById(2131296771));
    this.t = ((Button)findViewById(2131296773));
    this.q = ((RelativeLayout)findViewById(2131296770));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 50) && (paramInt2 != 0))
    {
      this.n.join(this.mContext, this.o, this.F);
      this.D.sendEmptyMessage(1);
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      this.k.setVisibility(8);
      this.I.setVisibility(8);
      this.t.setBackgroundResource(2130837821);
      this.p.setLayoutParams(p.a(true, this.B, this.C, this.mSP.y(), this.mSP.x()));
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(this.mSP.x(), this.mSP.y() - a());
      this.h.setLayoutParams(localLayoutParams2);
      return;
    }
    this.k.setVisibility(0);
    this.I.setVisibility(0);
    this.t.setBackgroundResource(2130837820);
    this.p.setLayoutParams(p.a(false, this.B, this.C, this.mSP.y(), this.mSP.x()));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(this.mSP.y(), this.C);
    this.h.setLayoutParams(localLayoutParams1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.J != null)
    {
      this.J.c();
      this.J = null;
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

  protected void setContentView()
  {
    getWindow().setFlags(128, 128);
    setContentView(2130903119);
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
      case 2131296770:
      case 2131296774:
      case 2131296775:
      default:
      case 2131296772:
      case 2131296771:
      case 2131296776:
      case 2131296777:
      case 2131296773:
      case 2131296769:
      }
      do
      {
        return;
        h.a(VideoLivePlayActivity.this.getApplicationContext(), "课程分享");
        VideoLivePlayActivity.g(VideoLivePlayActivity.this);
        return;
        VideoLivePlayActivity.h(VideoLivePlayActivity.this);
        return;
        VideoLivePlayActivity.a(VideoLivePlayActivity.this, 0);
        return;
        VideoLivePlayActivity.a(VideoLivePlayActivity.this, 1);
        return;
        if (VideoLivePlayActivity.i(VideoLivePlayActivity.this))
        {
          VideoLivePlayActivity.b(VideoLivePlayActivity.this, false);
          VideoLivePlayActivity.this.setRequestedOrientation(1);
          return;
        }
        VideoLivePlayActivity.b(VideoLivePlayActivity.this, true);
        VideoLivePlayActivity.this.setRequestedOrientation(0);
        return;
      }
      while (!VideoLivePlayActivity.f(VideoLivePlayActivity.this));
      if (!VideoLivePlayActivity.j(VideoLivePlayActivity.this))
      {
        if (VideoLivePlayActivity.k(VideoLivePlayActivity.this) != null)
        {
          VideoLivePlayActivity.k(VideoLivePlayActivity.this).cancel();
          VideoLivePlayActivity.a(VideoLivePlayActivity.this, null);
        }
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(4);
        VideoLivePlayActivity.a(VideoLivePlayActivity.this, new Timer());
        VideoLivePlayActivity.k(VideoLivePlayActivity.this).schedule(new bl(this), 5000L);
        return;
      }
      if (VideoLivePlayActivity.k(VideoLivePlayActivity.this) != null)
      {
        VideoLivePlayActivity.k(VideoLivePlayActivity.this).cancel();
        VideoLivePlayActivity.a(VideoLivePlayActivity.this, null);
      }
      VideoLivePlayActivity.a(VideoLivePlayActivity.this, new Timer());
      VideoLivePlayActivity.k(VideoLivePlayActivity.this).schedule(new bm(this), 5000L);
    }
  }

  private static class b extends m<VideoLivePlayActivity>
  {
    public b(VideoLivePlayActivity paramVideoLivePlayActivity)
    {
      super();
    }

    protected void a(VideoLivePlayActivity paramVideoLivePlayActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 6:
      default:
        return;
      case 1:
        VideoLivePlayActivity.a(paramVideoLivePlayActivity).setVisibility(0);
        return;
      case 2:
        VideoLivePlayActivity.a(paramVideoLivePlayActivity).setVisibility(8);
        return;
      case 3:
        VideoLivePlayActivity.b(paramVideoLivePlayActivity);
        return;
      case 4:
        VideoLivePlayActivity.c(paramVideoLivePlayActivity);
        return;
      case 7:
        Toast.makeText(paramVideoLivePlayActivity, (String)paramMessage.obj, 0).show();
        return;
      case 5:
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("content", "本场直播还未开始");
      paramVideoLivePlayActivity.startNewActivity(DialogActivitySimple.class, 0, 0, false, localBundle);
    }
  }

  class c
    implements OnPlayListener
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
        h.a("开始缓冲");
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(1);
        return;
      }
      h.a("缓冲结束");
      VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(2);
    }

    public void onDocSwitch(int paramInt, String paramString)
    {
      h.a("文档名称", paramString);
    }

    public void onErr(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        h.a("直播编号不存在");
        return;
      case 4:
        h.a("口令错误");
        return;
      case 5:
        h.a("用户名或密码错误");
        return;
      case 3:
        h.a("直播id不正确");
        return;
      case -100:
        h.a("domain不正确");
        return;
      case -101:
        h.a("超时");
        return;
      case -102:
        h.a("未知错误");
        return;
      case -103:
        h.a("站点不可用");
        return;
      case -104:
        h.a("无网络");
        return;
      case -106:
        h.a("服务不正确");
        return;
      case -107:
        h.a("参数不正确");
        return;
      case -108:
      }
      h.a("第三方用户权限校验");
    }

    public void onJoin(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 6:
        h.a("加入成功");
        VideoLivePlayActivity.a(VideoLivePlayActivity.this, true);
        if (VideoLivePlayActivity.e(VideoLivePlayActivity.this) != null)
          VideoLivePlayActivity.e(VideoLivePlayActivity.this).a(VideoLivePlayActivity.f(VideoLivePlayActivity.this));
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(2);
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(3);
        h.a("播放开始");
        return;
      case 7:
        h.a("正在加入");
        return;
      case 8:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "连接失败，请检查网络"));
        return;
      case 9:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "连接服务器超时"));
        return;
      case 10:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "连接服务器失败"));
        return;
      case 11:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(5);
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(2);
        return;
      case 12:
      }
      VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "直播间人数已满"));
    }

    public void onLeave(int paramInt)
    {
      VideoLivePlayActivity.a(VideoLivePlayActivity.this, false);
      if (VideoLivePlayActivity.e(VideoLivePlayActivity.this) != null)
        VideoLivePlayActivity.e(VideoLivePlayActivity.this).a(VideoLivePlayActivity.f(VideoLivePlayActivity.this));
      VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendEmptyMessage(4);
      switch (paramInt)
      {
      default:
        return;
      case 1:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "您已离开直播间"));
        return;
      case 2:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "您已被管理员请出房间"));
        return;
      case 3:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "连接超时，请稍后再试"));
        return;
      case 4:
        VideoLivePlayActivity.d(VideoLivePlayActivity.this).sendMessage(VideoLivePlayActivity.d(VideoLivePlayActivity.this).obtainMessage(7, "直播已结束，感谢您的观看"));
        return;
      case 5:
      }
      h.a("未知错误导致离开直播");
    }

    public void onPageSize(int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onPublicMsg(long paramLong, String paramString)
    {
      h.a("onPublicMsg");
    }

    public void onPublish(boolean paramBoolean)
    {
      h.a("onPublish");
    }

    public void onReconnecting()
    {
      h.a("onReconnecting");
    }

    public void onRosterTotal(int paramInt)
    {
      h.a("当前在线人数：", Integer.valueOf(paramInt));
    }

    public void onSubject(String paramString)
    {
    }

    public void onUserJoin(UserInfo paramUserInfo)
    {
      String str = "";
      if ((0x1 & paramUserInfo.getRole()) == 1)
        str = str + "_组织者";
      if ((0x2 & paramUserInfo.getRole()) == 2)
        str = str + "_主讲人";
      if ((0x4 & paramUserInfo.getRole()) == 4)
        str = str + "_嘉宾";
      if ((0x8 & paramUserInfo.getRole()) == 8)
        str = str + "_学员";
      if ((0x10 & paramUserInfo.getRole()) == 16)
        str = str + "_学员";
      h.a("进入直播间", paramUserInfo.getName() + "_" + str, Long.valueOf(paramUserInfo.getUserId()));
    }

    public void onUserLeave(UserInfo paramUserInfo)
    {
      h.a("onUserLeave");
    }

    public void onUserUpdate(UserInfo paramUserInfo)
    {
      h.a("onUserUpdate");
    }

    public void onVideoBegin()
    {
      h.a("onVideoBegin");
    }

    public void onVideoEnd()
    {
      h.a("onVideoEnd");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoLivePlayActivity
 * JD-Core Version:    0.6.0
 */