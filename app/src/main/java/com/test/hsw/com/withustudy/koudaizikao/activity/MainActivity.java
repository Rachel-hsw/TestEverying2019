package com.withustudy.koudaizikao.activity;

import a.a.a.e.i;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.vod.VodSite;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.dialog.DialogActivityUpdateNew;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.a.b;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.MockPushState;
import com.withustudy.koudaizikao.entity.New_course_ids;
import com.withustudy.koudaizikao.entity.PersonalInfo;
import com.withustudy.koudaizikao.entity.ResponseStatus;
import com.withustudy.koudaizikao.entity.RspNewCource;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.SequencePushState;
import com.withustudy.koudaizikao.entity.SmartPushState;
import com.withustudy.koudaizikao.entity.Version;
import com.withustudy.koudaizikao.entity.content.CheckCourseContent;
import com.withustudy.koudaizikao.entity.content.NewReplyContent;
import com.withustudy.koudaizikao.entity.req.push.UserAnswers;
import com.withustudy.koudaizikao.fragment.BBSFragment;
import com.withustudy.koudaizikao.fragment.BrushMainFragment;
import com.withustudy.koudaizikao.fragment.InformationFragment;
import com.withustudy.koudaizikao.fragment.PersonalFragment;
import com.withustudy.koudaizikao.fragment.VideoAllFragment;
import com.withustudy.koudaizikao.fragment.VideoAllFragment.b;
import com.withustudy.koudaizikao.fragment.VideoMainFragment;
import com.withustudy.koudaizikao.g.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import koudai.db.BrushExcerciseBatchDao;
import koudai.db.CourseJiangYiInforDao;
import koudai.db.UserAnsDao;
import koudai.db.b;

public class MainActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  public static final int ACTION_CHECK_COURSE = 13;
  public static final int ACTION_GET_USER_INFO = 10;
  public static final int ACTION_REMIND_MY_POST = 12;
  public static final int ACTION_UPDATE = 11;
  public static final int CHECK_COURSE_RED_DOT = 101;
  public static final int CHECK_PERSONAL_RED_DOT = 100;
  public static final int HIDE_COURSE = 103;
  public static final int SERVICE_EXCEPTION_ERROR = 105;
  public static final int SHOW_COURSE = 102;
  public static final int SHOW_RED_DOT = 99;
  public static final int action_get_new_cource = 15;
  public static final int action_get_user_sco = 14;
  public static final int action_lunxun_new_cource = 16;
  private static final int push_anser = 100;
  private final int action_show_persion_red_dot = 5;
  private BrushExcerciseBatchDao brushExcerciseBatchsDao;
  private int currentTabIndex = -1;
  private UserAnsDao dao;
  private com.withustudy.koudaizikao.e.a dbService;
  private String excerciseBrushId;
  private long exitTime;
  private Handler handler = new an(this);
  private ImageView imageBBS;
  private ImageView imageBrush;
  private ImageView imageClass;
  private ImageView imageNews;
  private ImageView imagePersonal;
  private boolean isFresh = false;
  private boolean isShowRedDot;
  private boolean isShowScoRedDot = false;
  private ImageView iv_red_dot_new_cource;
  private LinearLayout layoutBBS;
  private LinearLayout layoutClass;
  private LinearLayout layoutNews;
  private LinearLayout layoutPersonal;
  private BBSFragment mBbsFragment;
  private BrushMainFragment mBrushFragment;
  private VideoMainFragment mClassVideoFragment;
  private PersonalFragment mMyselfFragment;
  private InformationFragment mNewsFragment;
  private a mPollIfNewCourseOrNotTask;
  private b mRedDotPersonalTimeTask;
  private MockPushState mockPushState;
  private long mockTime;
  public Hashtable<String, Boolean> newCourseIsClick = new Hashtable();
  private ArrayList<New_course_ids> new_course_ids;
  private Timer pollNewCourseTimer;
  private PushRec pushRec;
  private String pushSujectId;
  private c reListener;
  private TextView redDotCourse;
  private ImageView redDotPersonal;
  private Timer redDotPersonalTimer;
  private RefreshReceiver refershReceiver;
  private ScoReceiver scoReceiver;
  private SequencePushState sequencePushState;
  private SmartPushState smartPushState;
  private TextView textBBS;
  private TextView textClass;
  private TextView textNews;
  private TextView textPersonal;
  private int tryCount = 0;
  private String type = "";
  List<UserAnswers> userList = new ArrayList();

  private void cacheBrushExcerciseId()
  {
    koudai.db.a locala = new koudai.db.a();
    locala.a(this.excerciseBrushId);
    locala.b(this.type);
    locala.b(Long.valueOf(this.mockTime));
    this.brushExcerciseBatchsDao.c(locala);
  }

  private void clearFile()
  {
    CourseJiangYiInforDao localCourseJiangYiInforDao = this.dbService.f();
    List localList = localCourseJiangYiInforDao.k().d();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1;
    Iterator localIterator2;
    if ((localList != null) && (localList.size() > 0))
    {
      localIterator1 = localList.iterator();
      if (localIterator1.hasNext())
        break label74;
      localIterator2 = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        return;
        label74: b localb1 = (b)localIterator1.next();
        Boolean localBoolean = localb1.d();
        if ((localBoolean != null) && (localBoolean.booleanValue()))
          break;
        localArrayList.add(localb1);
        break;
      }
      b localb2 = (b)localIterator2.next();
      try
      {
        new File(localb2.b()).delete();
        label146: localCourseJiangYiInforDao.f(localb2);
      }
      catch (Exception localException)
      {
        break label146;
      }
    }
  }

  private void deleteCache()
  {
    new Thread(new ao(this)).start();
  }

  private List<String> getUserAnsStr(UserAnswers paramUserAnswers, String paramString)
  {
    String[] arrayOfString = paramString.split("%%%%");
    List localList = paramUserAnswers.getUserAnswer();
    int i;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localList;
      String str = arrayOfString[j];
      h.a("string=" + str);
      localList.add(str);
    }
  }

  private void hideFragment(FragmentTransaction paramFragmentTransaction)
  {
    if (this.mNewsFragment != null)
      paramFragmentTransaction.hide(this.mNewsFragment);
    if (this.mClassVideoFragment != null)
      paramFragmentTransaction.hide(this.mClassVideoFragment);
    if (this.mBrushFragment != null)
      paramFragmentTransaction.hide(this.mBrushFragment);
    if (this.mBbsFragment != null)
      paramFragmentTransaction.hide(this.mBbsFragment);
    if (this.mMyselfFragment != null)
      paramFragmentTransaction.hide(this.mMyselfFragment);
  }

  private void initPushAns()
  {
    this.pushRec = new PushRec();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.pushAnsers");
    registerReceiver(this.pushRec, localIntentFilter);
    this.dbService = com.withustudy.koudaizikao.e.a.a(this.mContext);
    this.dao = this.dbService.a();
    this.brushExcerciseBatchsDao = this.dbService.b();
  }

  private void initRefresh()
  {
    this.refershReceiver = new RefreshReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.refresh_subject");
    registerReceiver(this.refershReceiver, localIntentFilter);
  }

  private void initUpdateSco()
  {
    this.scoReceiver = new ScoReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.update_sco");
    registerReceiver(this.scoReceiver, localIntentFilter);
  }

  private void pushOneBatch(String paramString1, String paramString2, long paramLong)
  {
    new Thread(new ap(this, paramString1, paramString2, paramLong)).start();
  }

  private void setImage(int paramInt)
  {
    int i = 0;
    if (i >= 5)
      return;
    if (i == paramInt)
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    while (true)
    {
      i++;
      break;
      this.imageNews.setBackgroundResource(2130838059);
      this.textNews.setTextColor(getResources().getColor(2131034212));
      continue;
      this.imageClass.setBackgroundResource(2130838065);
      this.textClass.setTextColor(getResources().getColor(2131034212));
      continue;
      this.imageBrush.setBackgroundResource(2130838057);
      continue;
      this.imageBBS.setBackgroundResource(2130838061);
      this.textBBS.setTextColor(getResources().getColor(2131034212));
      continue;
      this.imagePersonal.setBackgroundResource(2130838063);
      this.textPersonal.setTextColor(getResources().getColor(2131034212));
      continue;
      switch (i)
      {
      default:
        break;
      case 0:
        this.imageNews.setBackgroundResource(2130838060);
        this.textNews.setTextColor(Color.parseColor("#666666"));
        break;
      case 1:
        this.imageClass.setBackgroundResource(2130838066);
        this.textClass.setTextColor(Color.parseColor("#666666"));
        break;
      case 2:
        this.imageBrush.setBackgroundResource(2130838058);
        break;
      case 3:
        this.imageBBS.setBackgroundResource(2130838062);
        this.textBBS.setTextColor(Color.parseColor("#666666"));
        break;
      case 4:
        this.imagePersonal.setBackgroundResource(2130838064);
        this.textPersonal.setTextColor(Color.parseColor("#666666"));
      }
    }
  }

  private void setSelect(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    hideFragment(localFragmentTransaction);
    switch (paramInt)
    {
    default:
      localFragmentTransaction.commit();
      return;
    case 0:
      g.b(this.mContext, "tab_main_2");
      if (this.mNewsFragment == null)
      {
        this.mNewsFragment = new InformationFragment();
        localFragmentTransaction.add(2131296571, this.mNewsFragment);
      }
      while (true)
      {
        setImage(paramInt);
        break;
        localFragmentTransaction.show(this.mNewsFragment);
      }
    case 1:
      g.b(this.mContext, "course_tab");
      if (this.mClassVideoFragment == null)
      {
        this.mClassVideoFragment = new VideoMainFragment();
        localFragmentTransaction.add(2131296571, this.mClassVideoFragment);
      }
      while (true)
      {
        this.mClassVideoFragment.a(this.new_course_ids);
        setImage(paramInt);
        break;
        localFragmentTransaction.show(this.mClassVideoFragment);
      }
    case 2:
      g.b(this.mContext, "tab_main_1");
      if (this.mBrushFragment == null)
      {
        this.mBrushFragment = new BrushMainFragment();
        localFragmentTransaction.add(2131296571, this.mBrushFragment);
      }
      while (true)
      {
        setImage(paramInt);
        break;
        localFragmentTransaction.show(this.mBrushFragment);
      }
    case 3:
      g.b(this.mContext, "tab_main_3");
      if (this.mBbsFragment == null)
      {
        this.mBbsFragment = new BBSFragment();
        localFragmentTransaction.add(2131296571, this.mBbsFragment);
      }
      while (true)
      {
        setImage(paramInt);
        break;
        localFragmentTransaction.show(this.mBbsFragment);
      }
    case 4:
    }
    g.b(this.mContext, "tab_main_4");
    if (this.mMyselfFragment == null)
    {
      this.mMyselfFragment = new PersonalFragment();
      this.mMyselfFragment.a(this.isShowRedDot);
      if (this.isShowScoRedDot)
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isShowScoRedDot", this.isShowScoRedDot);
        this.mMyselfFragment.setArguments(localBundle);
      }
      localFragmentTransaction.add(2131296571, this.mMyselfFragment);
    }
    while (true)
    {
      setImage(paramInt);
      this.isShowRedDot = false;
      this.isShowScoRedDot = false;
      break;
      this.mMyselfFragment.a(this.isShowRedDot);
      if (this.isShowScoRedDot)
        this.mMyselfFragment.b(this.isShowScoRedDot);
      if (this.isFresh)
        this.mMyselfFragment.f();
      localFragmentTransaction.show(this.mMyselfFragment);
    }
  }

  protected void bindData()
  {
    com.withustudy.koudaizikao.MyApplication.isRunning = true;
    if (!this.mSP.i().equals(""))
    {
      com.withustudy.koudaizikao.a.a locala1 = c.b().J();
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = this.mSP.i();
      locala1.a(this, arrayOfString1, 10, this.mContext);
      com.withustudy.koudaizikao.a.a locala2 = c.b().O();
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = this.mSP.i();
      arrayOfString2[1] = this.mSP.p();
      locala2.a(this, arrayOfString2, 11, this.mContext);
      this.redDotPersonalTimer.schedule(this.mRedDotPersonalTimeTask, 5000L, 600000L);
      this.handler.sendMessageDelayed(this.handler.obtainMessage(101, "0"), 2000L);
      com.withustudy.koudaizikao.a.a locala3 = c.b().aD();
      String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = this.mSP.i();
      locala3.a(this, arrayOfString3, 14, this.mContext);
      this.pollNewCourseTimer.schedule(this.mPollIfNewCourseOrNotTask, 0L, 120000L);
    }
  }

  public BrushMainFragment getBrushMainFragment()
  {
    return this.mBrushFragment;
  }

  protected void initData()
  {
    if (!this.mSP.i().equals(""))
      setSelect(2);
    for (this.currentTabIndex = 2; ; this.currentTabIndex = 0)
    {
      initRefresh();
      initPushAns();
      initUpdateSco();
      this.redDotPersonalTimer = new Timer();
      this.mRedDotPersonalTimeTask = new b();
      this.pollNewCourseTimer = new Timer();
      this.mPollIfNewCourseOrNotTask = new a();
      clearFile();
      return;
      setSelect(0);
    }
  }

  protected void initListener()
  {
    this.layoutNews.setOnClickListener(this);
    this.layoutClass.setOnClickListener(this);
    this.imageBrush.setOnClickListener(this);
    this.layoutBBS.setOnClickListener(this);
    this.layoutPersonal.setOnClickListener(this);
  }

  protected void initView()
  {
    this.layoutNews = ((LinearLayout)findViewById(2131296572));
    this.layoutClass = ((LinearLayout)findViewById(2131296575));
    this.imageBrush = ((ImageView)findViewById(2131296587));
    this.layoutBBS = ((LinearLayout)findViewById(2131296580));
    this.layoutPersonal = ((LinearLayout)findViewById(2131296583));
    this.imageNews = ((ImageView)findViewById(2131296573));
    this.imageClass = ((ImageView)findViewById(2131296576));
    this.imageBBS = ((ImageView)findViewById(2131296581));
    this.imagePersonal = ((ImageView)findViewById(2131296584));
    this.textNews = ((TextView)findViewById(2131296574));
    this.textClass = ((TextView)findViewById(2131296579));
    this.redDotCourse = ((TextView)findViewById(2131296577));
    this.textBBS = ((TextView)findViewById(2131296582));
    this.textPersonal = ((TextView)findViewById(2131296586));
    this.redDotPersonal = ((ImageView)findViewById(2131296585));
    this.iv_red_dot_new_cource = ((ImageView)findViewById(2131296578));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296587:
      if (this.mSP.i().equals(""))
      {
        Toast.makeText(this.mContext, "请先登录", 0).show();
        Intent localIntent = new Intent(this.mContext.getApplicationContext(), LoginActivity.class);
        localIntent.putExtra("flag", "0");
        startActivity(localIntent);
        return;
      }
      setSelect(2);
      this.currentTabIndex = 2;
      return;
    case 2131296572:
      setSelect(0);
      this.currentTabIndex = 0;
      return;
    case 2131296575:
      this.handler.sendEmptyMessage(103);
      this.handler.sendMessage(this.handler.obtainMessage(101, "1"));
      if (VideoAllFragment.a != null)
        VideoAllFragment.a.sendEmptyMessage(3);
      setSelect(1);
      this.currentTabIndex = 1;
      return;
    case 2131296580:
      setSelect(3);
      this.currentTabIndex = 3;
      return;
    case 2131296583:
    }
    this.redDotPersonal.setVisibility(8);
    setSelect(4);
    this.currentTabIndex = 4;
  }

  protected void onDestroy()
  {
    try
    {
      if (this.pushRec != null)
      {
        unregisterReceiver(this.pushRec);
        this.pushRec = null;
      }
      if (this.refershReceiver != null)
      {
        unregisterReceiver(this.refershReceiver);
        this.refershReceiver = null;
      }
      if (this.pollNewCourseTimer != null)
      {
        this.pollNewCourseTimer.cancel();
        this.pollNewCourseTimer = null;
      }
      if (this.mPollIfNewCourseOrNotTask != null)
      {
        this.mPollIfNewCourseOrNotTask.cancel();
        this.mPollIfNewCourseOrNotTask = null;
      }
      if (this.scoReceiver != null)
      {
        unregisterReceiver(this.scoReceiver);
        this.scoReceiver = null;
      }
      clearFile();
      label103: super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label103;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.handler.sendEmptyMessage(105);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (System.currentTimeMillis() - this.exitTime > 2000L)
      {
        Toast.makeText(getApplicationContext(), "再按一次退出程序", 0).show();
        this.exitTime = System.currentTimeMillis();
      }
      while (true)
      {
        return true;
        finish();
        g.e(this.mContext);
        VodSite.release();
        System.exit(0);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onStart()
  {
    super.onStart();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    case 100:
    case 12:
    case 13:
    case 14:
    case 15:
    }
    while (true)
    {
      return;
      if (paramString1 == null)
        continue;
      try
      {
        PersonalInfo localPersonalInfo = (PersonalInfo)c.a().fromJson(paramString1, PersonalInfo.class);
        if (localPersonalInfo != null)
        {
          this.mSP.r(localPersonalInfo.getNickname());
          this.mSP.q(localPersonalInfo.getProfileUrl());
          return;
        }
      }
      catch (Exception localException9)
      {
        localException9.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "获取用户信息失败", 0).show();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        Version localVersion = (Version)c.a().fromJson(paramString1, Version.class);
        if (localVersion != null)
        {
          if (!localVersion.getStatus().equals("STATUS_OK"))
            continue;
          Bundle localBundle6 = new Bundle();
          localBundle6.putSerializable("update", localVersion);
          startNewActivity(DialogActivityUpdateNew.class, 0, 0, false, localBundle6);
          return;
        }
      }
      catch (Exception localException8)
      {
        localException8.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
      return;
      if (paramString1 == null)
        continue;
      Gson localGson = c.a();
      if (a.b.b.equals(this.type))
      {
        try
        {
          this.smartPushState = ((SmartPushState)localGson.fromJson(paramString1, SmartPushState.class));
          if (this.smartPushState == null)
            continue;
          ResponseStatus localResponseStatus4 = this.smartPushState.getResponseStatus();
          if ((localResponseStatus4 != null) && ("OK".equals(localResponseStatus4.getStatus())))
          {
            this.handler.sendEmptyMessage(0);
            deleteCache();
            Intent localIntent5 = new Intent();
            localIntent5.setAction("com.koudai.update_smart_ui");
            Bundle localBundle5 = new Bundle();
            localBundle5.putSerializable("smartPushState", this.smartPushState);
            localIntent5.putExtras(localBundle5);
            sendBroadcast(localIntent5);
            return;
          }
        }
        catch (Exception localException7)
        {
          localException7.printStackTrace();
          return;
        }
        cacheBrushExcerciseId();
        pushOneBatch(this.excerciseBrushId, this.type, this.mockTime);
        this.tryCount = (1 + this.tryCount);
        if (this.tryCount != 1)
          continue;
        cacheBrushExcerciseId();
        return;
      }
      if (a.b.c.equals(this.type))
      {
        try
        {
          this.mockPushState = ((MockPushState)localGson.fromJson(paramString1, MockPushState.class));
          if (this.mockPushState == null)
            continue;
          ResponseStatus localResponseStatus3 = this.mockPushState.getResponseStatus();
          if ((localResponseStatus3 != null) && ("OK".equals(localResponseStatus3.getStatus())))
          {
            this.handler.sendEmptyMessage(0);
            deleteCache();
            Intent localIntent4 = new Intent();
            localIntent4.setAction("com.koudai.update_simu_ui");
            Bundle localBundle4 = new Bundle();
            localBundle4.putSerializable("mockPushState", this.mockPushState);
            localIntent4.putExtras(localBundle4);
            sendBroadcast(localIntent4);
            return;
          }
        }
        catch (Exception localException6)
        {
          localException6.printStackTrace();
          return;
        }
        cacheBrushExcerciseId();
        pushOneBatch(this.excerciseBrushId, this.type, this.mockTime);
        this.tryCount = (1 + this.tryCount);
        if (this.tryCount != 1)
          continue;
        cacheBrushExcerciseId();
        return;
      }
      if (a.b.a.equals(this.type))
      {
        try
        {
          this.sequencePushState = ((SequencePushState)localGson.fromJson(paramString1, SequencePushState.class));
          if (this.sequencePushState == null)
            continue;
          ResponseStatus localResponseStatus2 = this.sequencePushState.getResponseStatus();
          if ((localResponseStatus2 != null) && ("OK".equals(localResponseStatus2.getStatus())))
          {
            this.handler.sendEmptyMessage(0);
            deleteCache();
            Intent localIntent3 = new Intent();
            localIntent3.setAction("com.koudai.update_sequence_ui");
            Bundle localBundle3 = new Bundle();
            localBundle3.putSerializable("sequencePushState", this.sequencePushState);
            localIntent3.putExtras(localBundle3);
            sendBroadcast(localIntent3);
            return;
          }
        }
        catch (Exception localException5)
        {
          localException5.printStackTrace();
          return;
        }
        cacheBrushExcerciseId();
        pushOneBatch(this.excerciseBrushId, this.type, this.mockTime);
        this.tryCount = (1 + this.tryCount);
        if (this.tryCount != 1)
          continue;
        cacheBrushExcerciseId();
        return;
      }
      if (!a.b.d.equals(this.type))
        continue;
      try
      {
        this.mockPushState = ((MockPushState)localGson.fromJson(paramString1, MockPushState.class));
        if (this.mockPushState == null)
          continue;
        ResponseStatus localResponseStatus1 = this.mockPushState.getResponseStatus();
        if ((localResponseStatus1 != null) && ("OK".equals(localResponseStatus1.getStatus())))
        {
          this.handler.sendEmptyMessage(0);
          deleteCache();
          Intent localIntent2 = new Intent();
          localIntent2.setAction("com.koudai.update_simu_ui");
          Bundle localBundle2 = new Bundle();
          localBundle2.putSerializable("mockPushState", this.mockPushState);
          localIntent2.putExtras(localBundle2);
          sendBroadcast(localIntent2);
          return;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        return;
      }
      cacheBrushExcerciseId();
      pushOneBatch(this.excerciseBrushId, this.type, this.mockTime);
      this.tryCount = (1 + this.tryCount);
      if (this.tryCount != 1)
        continue;
      cacheBrushExcerciseId();
      return;
      if (paramString1 == null)
        continue;
      try
      {
        NewReplyContent localNewReplyContent = (NewReplyContent)c.a().fromJson(paramString1, NewReplyContent.class);
        if (localNewReplyContent != null)
        {
          if (localNewReplyContent.getNew_reply_num() == 0)
            continue;
          this.handler.sendEmptyMessage(99);
          return;
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "获取用户信息失败", 0).show();
      return;
      if (paramString1 != null)
      {
        int j;
        int k;
        try
        {
          CheckCourseContent localCheckCourseContent = (CheckCourseContent)c.a().fromJson(paramString1, CheckCourseContent.class);
          if ((localCheckCourseContent == null) || (!localCheckCourseContent.getResult().equals("true")))
            break label1353;
          j = localCheckCourseContent.getStart_time();
          k = localCheckCourseContent.getEnd_time();
          if (j < 0)
          {
            this.handler.sendEmptyMessage(103);
            this.handler.sendMessageDelayed(this.handler.obtainMessage(101, "0"), 600000L);
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        if (j == 0)
        {
          this.handler.sendEmptyMessage(102);
          this.handler.sendMessageDelayed(this.handler.obtainMessage(103), k * 1000);
          this.handler.sendMessageDelayed(this.handler.obtainMessage(101, "0"), k * 1000);
          return;
        }
        this.handler.sendEmptyMessage(103);
        this.handler.sendMessageDelayed(this.handler.obtainMessage(102), j * 1000);
        this.handler.sendMessageDelayed(this.handler.obtainMessage(103), k * 1000);
        this.handler.sendMessageDelayed(this.handler.obtainMessage(101, "0"), k * 1000);
        return;
        label1353: Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      return;
      RspSco localRspSco = (RspSco)c.a().fromJson(paramString1, RspSco.class);
      if ((localRspSco == null) || (!localRspSco.getStatus().equals("STATUS_OK")))
        continue;
      int i = localRspSco.getAmount();
      this.mSP.a(i);
      return;
      try
      {
        RspNewCource localRspNewCource = (RspNewCource)c.a().fromJson(paramString1, RspNewCource.class);
        h.a(paramString1);
        if ((localRspNewCource == null) || (!"true".equals(localRspNewCource.getResult())))
          continue;
        if (localRspNewCource.getNew_course_num() > 0)
          this.handler.sendEmptyMessage(15);
        if (localRspNewCource.getNew_course_ids() == null)
          continue;
        this.new_course_ids = ((ArrayList)localRspNewCource.getNew_course_ids());
        Iterator localIterator = this.new_course_ids.iterator();
        while (true)
        {
          if (!localIterator.hasNext())
          {
            if (this.currentTabIndex != 1)
              break;
            Intent localIntent1 = new Intent();
            localIntent1.setAction("com.koudai.poll_new_course");
            Bundle localBundle1 = new Bundle();
            localBundle1.putSerializable("new_course_ids", this.new_course_ids);
            localIntent1.putExtras(localBundle1);
            sendBroadcast(localIntent1);
            return;
          }
          New_course_ids localNew_course_ids = (New_course_ids)localIterator.next();
          this.newCourseIsClick.put(localNew_course_ids.getCourse_id(), Boolean.valueOf(false));
        }
      }
      catch (Exception localException1)
      {
      }
    }
  }

  protected void setContentView()
  {
    setContentView(2130903092);
  }

  public void setReListener(c paramc)
  {
    this.reListener = paramc;
  }

  public class PushRec extends BroadcastReceiver
  {
    public PushRec()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle = paramIntent.getExtras();
      MainActivity.this.excerciseBrushId = ((String)localBundle.getSerializable("excerciseBrushId"));
      h.a("主界面收到广播  推送题目到服务器  excerciseBrushId=" + MainActivity.this.excerciseBrushId);
      MainActivity.this.type = localBundle.getString("type");
      MainActivity.this.pushSujectId = localBundle.getString("subjectId");
      MainActivity.this.mockTime = localBundle.getLong("mockTime");
      MainActivity.this.pushOneBatch(MainActivity.this.excerciseBrushId, MainActivity.this.type, MainActivity.this.mockTime);
    }
  }

  public class RefreshReceiver extends BroadcastReceiver
  {
    public RefreshReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      h.a("刷新科目列表  RefreshReceiver");
      if (MainActivity.this.mBrushFragment != null)
        MainActivity.this.mBrushFragment.e();
    }
  }

  public class ScoReceiver extends BroadcastReceiver
  {
    public ScoReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      h.a("更新奖学金  RefreshReceiver");
      Bundle localBundle = paramIntent.getExtras();
      MainActivity.this.isShowScoRedDot = localBundle.getBoolean("isShowScoRedDot", false);
      if (MainActivity.this.isShowScoRedDot)
        MainActivity.this.handler.sendEmptyMessage(5);
      MainActivity.this.isFresh = localBundle.getBoolean("isFresh", false);
    }
  }

  class a extends TimerTask
  {
    a()
    {
    }

    public void run()
    {
      h.a("轮询课程PollIfNewCourseTask= ");
      com.withustudy.koudaizikao.a.a locala = c.b().av();
      MainActivity localMainActivity = MainActivity.this;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = MainActivity.access$1(MainActivity.this).i();
      arrayOfString[1] = MainActivity.access$1(MainActivity.this).s();
      locala.a(localMainActivity, arrayOfString, 15, MainActivity.this.mContext);
    }
  }

  class b extends TimerTask
  {
    b()
    {
    }

    public void run()
    {
      MainActivity.this.handler.sendEmptyMessage(100);
    }
  }

  public static abstract interface c
  {
    public abstract void d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.MainActivity
 * JD-Core Version:    0.6.0
 */