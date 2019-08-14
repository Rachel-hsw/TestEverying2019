package com.withustudy.koudaizikao.activity;

import a.a.a.e.k;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.common.ServiceType;
import com.gensee.download.VodDownLoadEntity;
import com.gensee.download.VodDownLoader;
import com.gensee.download.VodDownLoader.OnDownloadListener;
import com.gensee.entity.ChatMsg;
import com.gensee.entity.InitParam;
import com.gensee.entity.QAMsg;
import com.gensee.entity.VodObject;
import com.gensee.vod.VodSite;
import com.gensee.vod.VodSite.OnVodListener;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleSucceed;
import com.withustudy.koudaizikao.b.r;
import com.withustudy.koudaizikao.b.s;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.a.b;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoListLive;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import koudai.db.VideoInfroDao;
import koudai.db.VideoInfroDao.Properties;

public class VideoBoughtDetailActivity extends AbsBaseActivity
{
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 50;
  public static final int n = 51;
  private List<Video> A;
  private s B;
  private List<VodDownLoadEntity> C;
  private b D;
  private VodSite E;
  private boolean F = false;
  private VideoCourse G;
  private Video H;
  private int I;
  private double J;
  private c K;
  private b L;
  private a M;
  public VodDownLoader a;
  public boolean b = false;
  private Button o;
  private TextView p;
  private Button q;
  private Button r;
  private LinearLayout s;
  private TextView t;
  private Button u;
  private LinearLayout v;
  private TextView w;
  private ListView x;
  private List<Video> y;
  private r z;

  private void a()
  {
    this.a.stop(this.H.getVideo_id());
    this.a.delete(this.H.getVideo_id());
    h.a("删除", this.H.getVideo_id());
    VideoInfroDao localVideoInfroDao = com.withustudy.koudaizikao.e.a.a(this.mContext).e();
    List localList = localVideoInfroDao.k().a(VideoInfroDao.Properties.b.a(this.H.getVideo_id()), new k[0]).d();
    if (localList.size() != 0)
      localVideoInfroDao.f((koudai.db.i)localList.get(0));
    this.K.sendEmptyMessage(7);
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.q.setBackgroundResource(2130837898);
      this.q.setTextColor(Color.parseColor("#00b8e5"));
      this.r.setBackgroundResource(2130838003);
      this.r.setTextColor(Color.parseColor("#999999"));
      b(paramInt);
      return;
    }
    this.r.setBackgroundResource(2130838002);
    this.r.setTextColor(Color.parseColor("#00b8e5"));
    this.q.setBackgroundResource(2130837899);
    this.q.setTextColor(Color.parseColor("#999999"));
    b(paramInt);
  }

  private void a(Video paramVideo)
  {
    InitParam localInitParam = new InitParam();
    localInitParam.setDomain("withustudy.gensee.com");
    localInitParam.setLiveId(paramVideo.getVideo_id());
    localInitParam.setNumber(paramVideo.getVideo_number());
    localInitParam.setServiceType(ServiceType.ST_TRAINING);
    localInitParam.setVodPwd(paramVideo.getWatch_passwd());
    localInitParam.setNickName(this.mSP.v());
    this.E.getVodObject(localInitParam);
  }

  private void b()
  {
    finish();
    if ((this.F) && (!MyApplication.isRunning))
      startNewActivity(WelcomeActivity.class, false, null);
  }

  private void b(int paramInt)
  {
    if (paramInt == 0)
      if (this.y != null)
      {
        if (this.y.size() != 0)
          break label60;
        this.s.setVisibility(8);
        this.v.setVisibility(0);
        this.w.setText("直播已结束，去回放列表看看吧！");
        this.x.setVisibility(8);
      }
    label60: 
    do
    {
      return;
      this.s.setVisibility(0);
      this.v.setVisibility(8);
      this.t.setText(String.valueOf(this.y.size()) + "堂直播课");
      this.x.setVisibility(0);
      this.x.setAdapter(this.z);
      return;
    }
    while (this.A == null);
    if (this.A.size() == 0)
    {
      this.s.setVisibility(8);
      this.v.setVisibility(0);
      this.w.setText("目前还没有回放课程");
      this.x.setVisibility(8);
      return;
    }
    this.s.setVisibility(0);
    this.v.setVisibility(8);
    this.t.setText(String.valueOf(this.A.size()) + "个回放视频");
    this.x.setVisibility(0);
    this.x.setAdapter(this.B);
  }

  protected void bindData()
  {
    this.x.setSelector(2131034189);
    this.p.setText(this.G.getCourse_name());
    com.withustudy.koudaizikao.a.a locala = c.b().az();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.mSP.i();
    arrayOfString[1] = this.G.getCourse_id();
    arrayOfString[2] = String.valueOf(this.G.getCategory());
    locala.a(this, arrayOfString, 10, this.mContext);
    this.E = new VodSite(this.mContext);
    this.E.setVodListener(this.L);
    this.a = VodDownLoader.instance(this.mContext, this.L, com.withustudy.koudaizikao.g.f.d);
    this.a.setAutoDownloadNext(true);
  }

  protected void initData()
  {
    this.F = getIntent().getExtras().getBoolean("push", false);
    this.G = ((VideoCourse)getIntent().getExtras().getSerializable("class"));
    this.L = new b();
    this.M = new a();
    this.K = new c(this);
  }

  protected void initListener()
  {
    this.o.setOnClickListener(this.M);
    this.q.setOnClickListener(this.M);
    this.r.setOnClickListener(this.M);
    this.u.setOnClickListener(this.M);
    this.x.setOnItemClickListener(this.M);
  }

  protected void initView()
  {
    this.o = ((Button)findViewById(2131296725));
    this.p = ((TextView)findViewById(2131296726));
    this.q = ((Button)findViewById(2131296727));
    this.r = ((Button)findViewById(2131296728));
    this.s = ((LinearLayout)findViewById(2131296729));
    this.t = ((TextView)findViewById(2131296730));
    this.u = ((Button)findViewById(2131296731));
    this.v = ((LinearLayout)findViewById(2131296732));
    this.w = ((TextView)findViewById(2131296733));
    this.x = ((ListView)findViewById(2131296734));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 50)
    {
      if (paramInt2 != 0)
        break label87;
      this.b = false;
      if (this.B != null)
        this.B.a(this.b);
    }
    while (true)
    {
      if ((paramInt1 == 51) && (paramInt2 != 0))
      {
        a();
        Bundle localBundle = new Bundle();
        localBundle.putString("content", "删除成功");
        startNewActivity(DialogActivitySimpleSucceed.class, 0, 0, false, localBundle);
      }
      return;
      label87: this.b = true;
      if (this.B != null)
        this.B.a(this.b);
      if (this.a == null)
        continue;
      this.a.download();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.D != null)
    {
      this.D.b();
      this.D = null;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
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

  public void onResume()
  {
    super.onResume();
    this.C = this.a.getDownloadList();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    if (paramString1 != null)
      try
      {
        VideoListLive localVideoListLive = (VideoListLive)c.a().fromJson(paramString1, VideoListLive.class);
        if ((localVideoListLive != null) && (localVideoListLive.getResult().equals("true")))
        {
          this.I = localVideoListLive.getGensee_uid();
          String[] arrayOfString = localVideoListLive.getAspect_ratio().split(":");
          this.J = (Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue());
          this.y = new ArrayList();
          this.y.addAll(localVideoListLive.getLiving_list());
          h.a("Bought", Integer.valueOf(this.y.size()));
          this.z = new r(this.y, this.mContext);
          this.A = new ArrayList();
          this.A.addAll(localVideoListLive.getPlayback_list());
          h.a("Replay", Integer.valueOf(this.A.size()));
          this.B = new s(this.A, this.C, this.K, this.mContext);
          this.B.a(this.b);
          this.K.sendEmptyMessage(1);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  protected void setContentView()
  {
    setContentView(2130903116);
  }

  class a
    implements View.OnClickListener, AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296726:
      case 2131296729:
      case 2131296730:
      default:
        return;
      case 2131296725:
        VideoBoughtDetailActivity.h(VideoBoughtDetailActivity.this);
        return;
      case 2131296727:
        VideoBoughtDetailActivity.a(VideoBoughtDetailActivity.this, 0);
        return;
      case 2131296728:
        VideoBoughtDetailActivity.a(VideoBoughtDetailActivity.this, 1);
        return;
      case 2131296731:
      }
      if (VideoBoughtDetailActivity.i(VideoBoughtDetailActivity.this) == null)
        VideoBoughtDetailActivity.a(VideoBoughtDetailActivity.this, new b(VideoBoughtDetailActivity.this, VideoBoughtDetailActivity.j(VideoBoughtDetailActivity.this), "批量下载", "批量删除"));
      VideoBoughtDetailActivity.i(VideoBoughtDetailActivity.this).a();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("video", (Serializable)VideoBoughtDetailActivity.k(VideoBoughtDetailActivity.this).get(paramInt));
      localBundle.putInt("uid", VideoBoughtDetailActivity.d(VideoBoughtDetailActivity.this));
      localBundle.putDouble("scale", VideoBoughtDetailActivity.e(VideoBoughtDetailActivity.this));
      localBundle.putSerializable("mClass", VideoBoughtDetailActivity.c(VideoBoughtDetailActivity.this));
      VideoBoughtDetailActivity.this.startNewActivity(VideoLivePlayActivity.class, false, localBundle);
    }
  }

  class b
    implements VodDownLoader.OnDownloadListener, VodSite.OnVodListener
  {
    b()
    {
    }

    public void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean)
    {
    }

    public void onDLError(String paramString, int paramInt)
    {
      h.a("下载错误的视频", paramString);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
      if (p.d(paramInt) != null)
        VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendMessage(VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).obtainMessage(2, p.d(paramInt)));
    }

    public void onDLFinish(String paramString1, String paramString2)
    {
      h.a("完成下载", paramString1);
      h.a("保存路径", paramString2);
      koudai.db.i locali = new koudai.db.i();
      locali.a(paramString1);
      locali.b(paramString2);
      com.withustudy.koudaizikao.e.a.a(VideoBoughtDetailActivity.g(VideoBoughtDetailActivity.this)).e().c(locali);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
    }

    public void onDLPosition(String paramString, int paramInt)
    {
      h.a("进度", Integer.valueOf(paramInt));
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
    }

    public void onDLPrepare(String paramString)
    {
      h.a("onDLPrepare", paramString);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
    }

    public void onDLStart(String paramString)
    {
      h.a("开始下载", paramString);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
    }

    public void onDLStop(String paramString)
    {
      h.a("停止下载", paramString);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendEmptyMessage(7);
    }

    public void onQaHistory(String paramString, List<QAMsg> paramList, int paramInt, boolean paramBoolean)
    {
    }

    public void onVodDetail(VodObject paramVodObject)
    {
    }

    public void onVodErr(int paramInt)
    {
      h.a("error", p.b(paramInt));
    }

    public void onVodObject(String paramString)
    {
      h.a("下载id", paramString);
      VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).sendMessage(VideoBoughtDetailActivity.f(VideoBoughtDetailActivity.this).obtainMessage(4, paramString));
    }
  }

  public static class c extends m<VideoBoughtDetailActivity>
  {
    public c(VideoBoughtDetailActivity paramVideoBoughtDetailActivity)
    {
      super();
    }

    protected void a(VideoBoughtDetailActivity paramVideoBoughtDetailActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        VideoBoughtDetailActivity.a(paramVideoBoughtDetailActivity, 0);
        return;
      case 2:
        Toast.makeText(paramVideoBoughtDetailActivity, (String)paramMessage.obj, 0).show();
        return;
      case 5:
        Bundle localBundle3 = new Bundle();
        localBundle3.putString("content", "是否接受在非WIFI环境下下载");
        paramVideoBoughtDetailActivity.startNewActivityForResult(DialogActivitySimpleChoice.class, 50, localBundle3);
        return;
      case 3:
        VideoBoughtDetailActivity.a(paramVideoBoughtDetailActivity, (Video)paramMessage.obj);
        return;
      case 4:
        paramVideoBoughtDetailActivity.a.download((String)paramMessage.obj);
        return;
      case 6:
        paramVideoBoughtDetailActivity.a.stop((String)paramMessage.obj);
        return;
      case 7:
        VideoBoughtDetailActivity.a(paramVideoBoughtDetailActivity).clear();
        VideoBoughtDetailActivity.a(paramVideoBoughtDetailActivity).addAll(paramVideoBoughtDetailActivity.a.getDownloadList());
        VideoBoughtDetailActivity.b(paramVideoBoughtDetailActivity).a(VideoBoughtDetailActivity.a(paramVideoBoughtDetailActivity));
        VideoBoughtDetailActivity.b(paramVideoBoughtDetailActivity).notifyDataSetChanged();
        return;
      case 8:
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("class", VideoBoughtDetailActivity.c(paramVideoBoughtDetailActivity).getCourse_id());
        localBundle2.putSerializable("video", (Video)paramMessage.obj);
        localBundle2.putInt("uid", VideoBoughtDetailActivity.d(paramVideoBoughtDetailActivity));
        localBundle2.putDouble("scale", VideoBoughtDetailActivity.e(paramVideoBoughtDetailActivity));
        localBundle2.putSerializable("mClass", VideoBoughtDetailActivity.c(paramVideoBoughtDetailActivity));
        paramVideoBoughtDetailActivity.startNewActivity(VideoLiveReplayActivity.class, false, localBundle2);
        return;
      case 9:
      }
      VideoBoughtDetailActivity.b(paramVideoBoughtDetailActivity, (Video)paramMessage.obj);
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("content", "确定删除？");
      paramVideoBoughtDetailActivity.startNewActivityForResult(DialogActivitySimpleChoice.class, 0, 0, 51, localBundle1);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity
 * JD-Core Version:    0.6.0
 */