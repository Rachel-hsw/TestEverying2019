package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.http.e;
import com.google.gson.Gson;
import com.koudai.test.BrushExcerciseDetailActivity;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.af;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.custom.a.a.b;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.Scholarship;
import com.withustudy.koudaizikao.entity.SmartPushState;
import com.withustudy.koudaizikao.entity.SmartStat;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.entity.req.ReqScoBean;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntellWecomeActivity extends AbsBaseActivity
  implements View.OnClickListener, a.b
{
  private static final int get_sina_short_url = 101;
  private static final int get_user_tui_jian_course = 2;
  private final int action_wtrite_sco_to_account = 5;
  private HashMap<Integer, String> currRight = new HashMap();
  private int donecount;
  private int errorcount;
  private Button go_next;
  private Button go_next1;
  private double graspLevel;
  private Handler handler = new w(this);
  private MyListView intell_course_lv;
  private ScrollView intell_scollview;
  private ImageButton intell_wecome_back;
  private ImageButton intell_wecome_back1;
  private boolean isHongbaoShare;
  private ImageView iv_level;
  private ImageView iv_level1;
  private View ll_hongbao_ui;
  private View ll_intell_w;
  private LinearLayout ll_loading;
  private VideoAllContent mResult;
  private double rate;
  private int rightcount;
  private RspSco rspSco;
  private Button sco_go_next;
  private ImageButton sco_ib_back;
  private TextView sco_my_tv;
  private Button sco_share;
  private TextView sco_tv_done;
  private TextView sco_tv_error;
  private TextView sco_tv_name;
  private TextView sco_tv_right;
  private Button share;
  private Button share1;
  private a sharePopWindow;
  private SmartPushState smartPushState;
  private SmartStat smartStat;
  private String subjectId;
  private String subjectName;
  private TextView tv_beat_other;
  private TextView tv_beat_other1;
  private TextView tv_done;
  private TextView tv_done1;
  private TextView tv_error;
  private TextView tv_error1;
  private TextView tv_level;
  private TextView tv_level1;
  private TextView tv_name;
  private TextView tv_name1;
  private TextView tv_rate;
  private TextView tv_rate1;
  private TextView tv_right;
  private TextView tv_right1;
  private UpdateReceive updateReceive;
  private Urls url;
  private UrlShortBean urlShortBean;
  private ImageView userImag;
  private ImageView userImag1;

  private void initIntellData()
  {
    this.ll_loading.setVisibility(8);
    this.intell_scollview.setVisibility(8);
    this.ll_hongbao_ui.setVisibility(8);
    this.ll_intell_w.setVisibility(0);
    String str1 = this.mSP.u();
    if ((str1 != null) && (!str1.equals("")))
      this.mFileDownLoad.a(str1, this.userImag, 1000);
    this.tv_beat_other.setText("恭喜你完成了本次刷题");
    this.tv_done.setText(this.donecount);
    this.tv_error.setText(this.errorcount);
    this.tv_right.setText(this.rightcount);
    this.tv_name.setText(this.subjectName);
    this.smartPushState.getSmartStat().getBeatRate();
    this.graspLevel = this.smartPushState.getSmartStat().getGraspLevel();
    this.ll_loading.setVisibility(8);
    this.ll_intell_w.setVisibility(0);
    this.mProTools.b();
    this.tv_beat_other.setText("恭喜你完成了本次刷题");
    if ((this.graspLevel >= 0.0D) && (this.graspLevel < 30.0D))
    {
      this.tv_level.setText("多刷题才可以过关哦");
      this.iv_level.setBackgroundResource(2130837665);
    }
    while (true)
    {
      String str2 = new DecimalFormat("0.0").format(this.graspLevel);
      this.tv_rate.setText(str2 + "%");
      new Thread(new z(this)).start();
      return;
      if ((this.graspLevel >= 30.0D) && (this.graspLevel < 45.0D))
      {
        this.tv_level.setText("进步很快咯，加油！");
        this.iv_level.setBackgroundResource(2130837666);
        continue;
      }
      if ((this.graspLevel >= 45.0D) && (this.graspLevel < 60.0D))
      {
        this.tv_level.setText("通过考试，就在前方~");
        this.iv_level.setBackgroundResource(2130837667);
        continue;
      }
      if ((this.graspLevel >= 60.0D) && (this.graspLevel < 75.0D))
      {
        this.tv_level.setText("越刷越轻松~");
        this.iv_level.setBackgroundResource(2130837668);
        continue;
      }
      if ((this.graspLevel >= 75.0D) && (this.graspLevel < 85.0D))
      {
        this.tv_level.setText("真棒! 分分钟秒杀考试了");
        this.iv_level.setBackgroundResource(2130837669);
        continue;
      }
      if (this.graspLevel < 85.0D)
        continue;
      this.tv_level.setText("抱大腿~小袋被你折服了！");
      this.iv_level.setBackgroundResource(2130837670);
    }
  }

  private void initReceiveNotify()
  {
    this.updateReceive = new UpdateReceive();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.update_smart_ui");
    registerReceiver(this.updateReceive, localIntentFilter);
  }

  private void popShare(boolean paramBoolean)
  {
    this.sharePopWindow = new a(this, this.ll_intell_w);
    this.sharePopWindow.a(this);
    if (paramBoolean)
    {
      this.sharePopWindow.a(2130838017);
      this.sharePopWindow.c("我今日完成了智能刷题任务，已获得奖学金！天天喜刷刷，过关就靠它~");
      this.sharePopWindow.b("口袋自考");
    }
    while (true)
    {
      this.sharePopWindow.a(this.url.getUrl_long());
      this.sharePopWindow.d(this.url.getUrl_short());
      this.sharePopWindow.b();
      return;
      this.sharePopWindow.c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
      this.sharePopWindow.b("口袋自考");
    }
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    try
    {
      this.mProTools.a(true);
      Bundle localBundle = getIntent().getExtras();
      try
      {
        this.subjectId = localBundle.getString("subjectId");
        this.subjectName = localBundle.getString("subjectName");
        this.currRight = ((HashMap)localBundle.getSerializable("currRight"));
        label52: if (this.currRight != null)
        {
          Iterator localIterator = this.currRight.keySet().iterator();
          while (true)
          {
            if (!localIterator.hasNext())
              return;
            Integer localInteger = (Integer)localIterator.next();
            String str = (String)this.currRight.get(localInteger);
            if ("true".equals(str))
            {
              this.rightcount = (1 + this.rightcount);
              this.donecount = (1 + this.donecount);
              continue;
            }
            if ("false".equals(str))
            {
              this.errorcount = (1 + this.errorcount);
              this.donecount = (1 + this.donecount);
              continue;
            }
            "##".equals(str);
          }
        }
      }
      catch (Exception localException2)
      {
        break label52;
      }
      return;
    }
    catch (Exception localException1)
    {
    }
  }

  protected void initIntellAndTuiJianData(List<VideoCourse> paramList)
  {
    this.ll_loading.setVisibility(8);
    this.intell_scollview.setVisibility(0);
    this.ll_hongbao_ui.setVisibility(8);
    this.ll_intell_w.setVisibility(8);
    af localaf = new af(this, paramList, 1);
    this.intell_course_lv.setAdapter(localaf);
    this.intell_course_lv.setVisibility(0);
    this.mSP.u();
    this.tv_done1.setText(this.donecount);
    this.tv_error1.setText(this.errorcount);
    this.tv_right1.setText(this.rightcount);
    this.tv_name1.setText(this.subjectName);
    this.graspLevel = this.smartPushState.getSmartStat().getGraspLevel();
    this.tv_beat_other1.setText("恭喜你完成了本次刷题");
    if ((this.graspLevel >= 0.0D) && (this.graspLevel < 30.0D))
    {
      this.tv_level1.setText("多刷题才可以过关哦");
      this.iv_level1.setBackgroundResource(2130837665);
    }
    while (true)
    {
      String str = new DecimalFormat("0.0").format(this.graspLevel);
      this.tv_rate1.setText(str + "%");
      new Thread(new y(this)).start();
      return;
      if ((this.graspLevel >= 30.0D) && (this.graspLevel < 45.0D))
      {
        this.tv_level1.setText("进步很快咯，加油！");
        this.iv_level1.setBackgroundResource(2130837666);
        continue;
      }
      if ((this.graspLevel >= 45.0D) && (this.graspLevel < 60.0D))
      {
        this.tv_level1.setText("通过考试，就在前方~");
        this.iv_level1.setBackgroundResource(2130837667);
        continue;
      }
      if ((this.graspLevel >= 60.0D) && (this.graspLevel < 75.0D))
      {
        this.tv_level1.setText("越刷越轻松~");
        this.iv_level1.setBackgroundResource(2130837668);
        continue;
      }
      if ((this.graspLevel >= 75.0D) && (this.graspLevel < 85.0D))
      {
        this.tv_level1.setText("真棒! 分分钟秒杀考试了");
        this.iv_level1.setBackgroundResource(2130837669);
        continue;
      }
      if (this.graspLevel < 85.0D)
        continue;
      this.tv_level1.setText("抱大腿~小袋被你折服了！");
      this.iv_level1.setBackgroundResource(2130837670);
    }
  }

  protected void initListener()
  {
    this.intell_wecome_back.setOnClickListener(this);
    this.intell_wecome_back1.setOnClickListener(this);
    this.sco_ib_back.setOnClickListener(this);
    this.go_next.setOnClickListener(this);
    this.go_next1.setOnClickListener(this);
    this.share.setOnClickListener(this);
    this.share1.setOnClickListener(this);
    this.sco_go_next.setOnClickListener(this);
    this.sco_share.setOnClickListener(this);
    this.intell_course_lv.setOnItemClickListener(new aa(this));
  }

  protected void initView()
  {
    this.mProTools.a(true);
    initReceiveNotify();
    this.ll_intell_w = ((LinearLayout)findViewById(2131297150));
    this.ll_hongbao_ui = ((LinearLayout)findViewById(2131297171));
    this.ll_loading = ((LinearLayout)findViewById(2131296415));
    this.intell_scollview = ((ScrollView)findViewById(2131297157));
    this.intell_course_lv = ((MyListView)findViewById(2131297168));
    this.share = ((Button)findViewById(2131296406));
    this.share1 = ((Button)findViewById(2131297169));
    this.intell_wecome_back = ((ImageButton)findViewById(2131297151));
    this.intell_wecome_back1 = ((ImageButton)findViewById(2131297159));
    this.go_next = ((Button)findViewById(2131297156));
    this.go_next1 = ((Button)findViewById(2131297170));
    this.tv_name = ((TextView)findViewById(2131296401));
    this.tv_name1 = ((TextView)findViewById(2131296867));
    this.tv_level = ((TextView)findViewById(2131297155));
    this.tv_level1 = ((TextView)findViewById(2131297167));
    this.tv_beat_other = ((TextView)findViewById(2131297152));
    this.tv_beat_other1 = ((TextView)findViewById(2131297161));
    this.tv_rate = ((TextView)findViewById(2131297153));
    this.tv_rate1 = ((TextView)findViewById(2131297165));
    this.tv_right = ((TextView)findViewById(2131296403));
    this.tv_right1 = ((TextView)findViewById(2131297163));
    this.tv_error = ((TextView)findViewById(2131296404));
    this.tv_error1 = ((TextView)findViewById(2131297164));
    this.tv_done = ((TextView)findViewById(2131296402));
    this.tv_done1 = ((TextView)findViewById(2131297162));
    this.userImag = ((ImageView)findViewById(2131296703));
    this.userImag1 = ((ImageView)findViewById(2131297160));
    this.iv_level = ((ImageView)findViewById(2131297154));
    this.iv_level1 = ((ImageView)findViewById(2131297166));
    this.sco_ib_back = ((ImageButton)findViewById(2131296408));
    this.sco_tv_done = ((TextView)findViewById(2131296410));
    this.sco_tv_right = ((TextView)findViewById(2131296411));
    this.sco_tv_error = ((TextView)findViewById(2131296412));
    this.sco_tv_name = ((TextView)findViewById(2131296409));
    this.sco_my_tv = ((TextView)findViewById(2131297172));
    this.sco_go_next = ((Button)findViewById(2131297173));
    this.sco_share = ((Button)findViewById(2131296414));
    this.ll_intell_w.setVisibility(8);
    this.intell_scollview.setVisibility(8);
    this.ll_hongbao_ui.setVisibility(8);
    this.ll_loading.setVisibility(0);
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296406:
      case 2131297169:
        popShare(false);
        return;
      case 2131296414:
        popShare(true);
        return;
      case 2131296408:
      case 2131297151:
      case 2131297159:
        g.b(this.mContext, "brush_i_close_con");
        finish();
        return;
      case 2131297156:
      case 2131297170:
      case 2131297173:
        g.b(this.mContext, "brush_i_con_continue");
        Bundle localBundle = new Bundle();
        localBundle.putString("subjectId", this.subjectId);
        localBundle.putString("subjectName", this.subjectName);
        localBundle.putInt("BrushPageFrom", 888);
        Intent localIntent = new Intent(getApplicationContext(), BrushExcerciseDetailActivity.class);
        localIntent.putExtras(localBundle);
        startActivity(localIntent);
        finish();
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
      if (this.updateReceive != null)
      {
        unregisterReceiver(this.updateReceive);
        this.updateReceive = null;
      }
      if (this.sharePopWindow != null)
      {
        this.sharePopWindow.c();
        this.sharePopWindow = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = c.a();
        switch (paramInt)
        {
        case 101:
          this.urlShortBean = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
          if (this.urlShortBean != null)
          {
            this.handler.sendEmptyMessage(101);
            return;
          }
        case 5:
        case 2:
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      h.a("加密url异常");
      return;
      this.rspSco = ((RspSco)localGson.fromJson(paramString1, RspSco.class));
      if (this.rspSco == null)
        return;
      this.handler.sendEmptyMessage(5);
      return;
      this.mProTools.b();
      h.a("response", paramString1);
      try
      {
        this.mResult = ((VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class));
        this.handler.sendEmptyMessage(2);
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
    }
    h.a(paramString1);
  }

  public void popOnItemListener(int paramInt)
  {
    try
    {
      if (this.isHongbaoShare)
      {
        ReqScoBean localReqScoBean = new ReqScoBean();
        localReqScoBean.setActivityId(this.smartPushState.getScholarship().getActivityId());
        localReqScoBean.setUid(this.mSP.i());
        localReqScoBean.setAmount(this.smartPushState.getScholarship().getAmount());
        c.b().m().a(this, localReqScoBean, 5);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903181);
  }

  // ERROR //
  protected void share(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 180	com/withustudy/koudaizikao/activity/IntellWecomeActivity:mContext	Landroid/content/Context;
    //   4: ldc_w 746
    //   7: invokestatic 617	com/umeng/a/g:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   10: aload_0
    //   11: iload_1
    //   12: putfield 184	com/withustudy/koudaizikao/activity/IntellWecomeActivity:isHongbaoShare	Z
    //   15: ldc 229
    //   17: astore_3
    //   18: ldc 229
    //   20: astore 4
    //   22: ldc 229
    //   24: astore 5
    //   26: ldc 229
    //   28: astore 6
    //   30: ldc 229
    //   32: astore 7
    //   34: aload_0
    //   35: getfield 148	com/withustudy/koudaizikao/activity/IntellWecomeActivity:subjectName	Ljava/lang/String;
    //   38: ldc_w 748
    //   41: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_3
    //   45: aload_0
    //   46: getfield 190	com/withustudy/koudaizikao/activity/IntellWecomeActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   49: invokevirtual 757	com/withustudy/koudaizikao/d/f:v	()Ljava/lang/String;
    //   52: ldc_w 748
    //   55: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 4
    //   60: new 261	java/lang/StringBuilder
    //   63: dup
    //   64: new 315	java/text/DecimalFormat
    //   67: dup
    //   68: ldc_w 317
    //   71: invokespecial 318	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 294	com/withustudy/koudaizikao/activity/IntellWecomeActivity:graspLevel	D
    //   78: invokevirtual 322	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   81: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   84: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: ldc_w 748
    //   93: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 5
    //   98: new 261	java/lang/StringBuilder
    //   101: dup
    //   102: aload_0
    //   103: getfield 129	com/withustudy/koudaizikao/activity/IntellWecomeActivity:donecount	I
    //   106: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   109: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: ldc_w 748
    //   118: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 6
    //   123: new 261	java/lang/StringBuilder
    //   126: dup
    //   127: aload_0
    //   128: getfield 141	com/withustudy/koudaizikao/activity/IntellWecomeActivity:rightcount	I
    //   131: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   134: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: ldc_w 748
    //   143: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 14
    //   148: aload 14
    //   150: astore 9
    //   152: new 261	java/lang/StringBuilder
    //   155: dup
    //   156: aload_0
    //   157: getfield 135	com/withustudy/koudaizikao/activity/IntellWecomeActivity:errorcount	I
    //   160: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   163: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: ldc_w 748
    //   172: invokestatic 754	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 15
    //   177: aload 15
    //   179: astore 7
    //   181: new 261	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 759
    //   188: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_3
    //   192: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 761
    //   198: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 4
    //   203: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 763
    //   209: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 5
    //   214: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 765
    //   220: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 6
    //   225: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 767
    //   231: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 9
    //   236: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 769
    //   242: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 7
    //   247: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 771
    //   253: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 190	com/withustudy/koudaizikao/activity/IntellWecomeActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   260: invokevirtual 718	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   263: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 773
    //   269: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: astore 11
    //   281: invokestatic 730	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   284: invokevirtual 777	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   287: astore 12
    //   289: iconst_1
    //   290: anewarray 231	java/lang/String
    //   293: astore 13
    //   295: aload 13
    //   297: iconst_0
    //   298: new 261	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 779
    //   305: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload 11
    //   313: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: aastore
    //   320: aload 12
    //   322: aload_0
    //   323: aload 13
    //   325: bipush 101
    //   327: aload_0
    //   328: invokevirtual 784	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   331: return
    //   332: astore 8
    //   334: ldc 229
    //   336: astore 9
    //   338: aload 8
    //   340: astore 10
    //   342: aload 10
    //   344: invokevirtual 683	java/lang/Exception:printStackTrace	()V
    //   347: goto -166 -> 181
    //   350: astore 10
    //   352: goto -10 -> 342
    //
    // Exception table:
    //   from	to	target	type
    //   34	148	332	java/lang/Exception
    //   152	177	350	java/lang/Exception
  }

  public class UpdateReceive extends BroadcastReceiver
  {
    public UpdateReceive()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle = paramIntent.getExtras();
      IntellWecomeActivity.this.smartPushState = ((SmartPushState)localBundle.getSerializable("smartPushState"));
      IntellWecomeActivity.this.handler.sendEmptyMessage(0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.IntellWecomeActivity
 * JD-Core Version:    0.6.0
 */