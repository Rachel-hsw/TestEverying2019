package com.withustudy.koudaizikao.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.a.a.b.c.a;
import com.a.a.b.d;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.gensee.vod.VodSite;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.withustudy.koudaizikao.MyApplication;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.LoginBean;
import com.withustudy.koudaizikao.entity.RspSplashBean;
import com.withustudy.koudaizikao.g.h;
import java.lang.reflect.Field;
import java.util.Map;

public class WelcomeActivity extends AbsBaseActivity
{
  public static final int ACTION_LOGIN = 11;
  public static final int ACTION_PUSH = 13;
  public static final int ACTION_THIRD_LOGIN = 12;
  private static final int Action_get_splah_data = 14;
  public static final int CHECK = 1;
  private static double SCALE = 0.0D;
  private static double SCALE1 = 0.0D;
  private static double SCREEN_SCALE = 0.0D;
  private static double SCREEN_SCALE1 = 0.0D;
  public static final int TO_MAIN = 2;
  public static final int TO_SKIP = 3;
  private LinearLayout activity_welcome_bg;
  private int height;
  private ImageView image;
  private ImageView image1;
  private boolean isPushed = false;
  private a mHandler;
  private d mImageLoader;
  private ImageView mImageViewBg;
  private LocationClient mLocationClient;
  public PushAgent mPushAgent;
  public IUmengRegisterCallback mRegisterCallback = new bu(this);
  private int sbar;
  private int width;

  static
  {
    SCALE = 0.144D;
    SCREEN_SCALE1 = 0.158D;
    SCALE1 = 0.263D;
  }

  private void initBaiDu()
  {
    this.mLocationClient = ((MyApplication)getApplication()).mLocationClient;
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(300000);
    localLocationClientOption.setIsNeedAddress(true);
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setLocationNotify(true);
    localLocationClientOption.setIgnoreKillProcess(true);
    localLocationClientOption.setEnableSimulateGps(false);
    localLocationClientOption.setIsNeedLocationDescribe(true);
    localLocationClientOption.setIsNeedLocationPoiList(true);
    this.mLocationClient.setLocOption(localLocationClientOption);
    this.mLocationClient.start();
  }

  private boolean isShowGuide()
  {
    try
    {
      String str = this.mSP.o();
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      this.mSP.k(String.valueOf(localPackageInfo.versionCode));
      this.mSP.l(localPackageInfo.versionName);
      if (str.equals(""))
      {
        h.a("之前没有安装过，进入引导页");
        return true;
      }
      if (Integer.valueOf(str).intValue() < Integer.valueOf(this.mSP.o()).intValue())
      {
        h.a("版本升级，进入引导页");
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      h.a("获取版本号出错，不进入引导页");
      return true;
    }
    h.a("不进入引导页");
    return false;
  }

  private void loadSplah()
  {
    String str = this.mSP.c();
    if (str.equals(""))
    {
      this.mImageViewBg.setVisibility(8);
      h.a(getApplicationContext(), "没有");
      com.withustudy.koudaizikao.a.c.b().u().a(this, new String[0], 14, this.mContext);
      return;
    }
    h.a(getApplicationContext(), "加载上次");
    this.mImageViewBg.setVisibility(0);
    setDrawable(d.a().a(str), this.mImageViewBg);
    com.withustudy.koudaizikao.a.c.b().u().a(this, new String[0], 14, this.mContext);
  }

  private void measureTitleBar()
  {
    this.sbar = 0;
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      this.sbar = getResources().getDimensionPixelSize(i);
      h.a("sbar=" + this.sbar);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void pushClientId(Context paramContext, String paramString)
  {
    if (this.isPushed)
      return;
    this.isPushed = true;
    com.withustudy.koudaizikao.a.a locala = com.withustudy.koudaizikao.a.c.b().aq();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = (paramString + ";" + "Umeng");
    arrayOfString[1] = f.a(paramContext).i();
    locala.a(this, arrayOfString, 13, paramContext);
  }

  private void setDrawable(Bitmap paramBitmap, ImageView paramImageView)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels - this.sbar;
      h.a("展示的空间宽franco-width", "width = " + i);
      h.a("展示的空间高franco-height", "height = " + j);
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      h.a("加载图片franco-widthDrawable", "widthDrawable = " + k);
      h.a("加载图片franco-heightDrawable", "heightDrawable = " + m);
      h.a("加载图片franco-heightDrawable比例", "widthDrawable/heightDrawable = " + k / m);
      if ((float)(1.0D * paramBitmap.getHeight() / paramBitmap.getWidth()) >= (float)(1.0D * j / i))
      {
        float f2 = i / k;
        h.a("宽的比franco", "scaleWidth = " + f2);
        Matrix localMatrix2 = new Matrix();
        localMatrix2.postScale(f2, f2);
        Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, k, (int)(float)(1.0D * (j * k) / i), localMatrix2, true);
        paramImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap2));
        int i2 = localBitmap2.getWidth();
        int i3 = localBitmap2.getHeight();
        h.a("截取后的宽" + i2);
        h.a("截取后的高" + i3);
        h.a("截取后的宽/长" + i2 / i3);
        return;
      }
      float f1 = j / m;
      h.a("宽的比franco", "scaleHeight = " + f1);
      Matrix localMatrix1 = new Matrix();
      localMatrix1.postScale(f1, f1);
      Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, (int)(float)(1.0D * (i * m) / j), m, localMatrix1, true);
      paramImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap1));
      int n = localBitmap1.getWidth();
      int i1 = localBitmap1.getHeight();
      h.a("截取后的宽" + n);
      h.a("截取后的高" + i1);
      h.a("截取后的宽/长" + n / i1);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setImage()
  {
    int i = (int)(this.mSP.y() * SCREEN_SCALE);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(i, (int)(i * SCALE));
    this.image.setLayoutParams(localLayoutParams1);
    this.image.setBackgroundResource(2130838221);
    int j = (int)(this.mSP.y() * SCREEN_SCALE1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(j, (int)(j * SCALE1));
    this.image1.setLayoutParams(localLayoutParams2);
    this.image1.setBackgroundResource(2130838222);
  }

  protected void bindData()
  {
    setImage();
    g.d(false);
    com.umeng.a.a.a(true);
    g.d(this.mContext);
    com.withustudy.koudaizikao.d.a.e = "baidu";
    com.umeng.a.a.b(com.withustudy.koudaizikao.d.a.e);
    initBaiDu();
    initUmeng();
    com.withustudy.koudaizikao.g.m.d(this.mContext);
    VodSite.init(this.mContext, null);
    this.mHandler.sendEmptyMessage(1);
  }

  protected void initData()
  {
    this.mHandler = new a(this);
    MyApplication.isRunning = true;
    measureTitleBar();
  }

  protected void initListener()
  {
  }

  public void initUmeng()
  {
    try
    {
      this.mPushAgent = PushAgent.getInstance(this);
      this.mPushAgent.setNotificationPlaySound(1);
      this.mPushAgent.onAppStart();
      this.mPushAgent.enable(this.mRegisterCallback);
      PushAgent.sendSoTimeout(this, 600);
      updateStatus();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initView()
  {
    this.image = ((ImageView)findViewById(2131296800));
    this.image1 = ((ImageView)findViewById(2131296801));
    this.mImageViewBg = ((ImageView)findViewById(2131296802));
    this.activity_welcome_bg = ((LinearLayout)findViewById(2131296799));
    this.activity_welcome_bg.getViewTreeObserver().addOnGlobalLayoutListener(new bw(this));
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    switch (paramInt)
    {
    default:
      return;
    case 11:
    case 12:
    }
    this.mHandler.sendEmptyMessage(3);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    case 13:
    default:
    case 11:
    case 12:
    case 14:
    }
    do
    {
      do
        return;
      while (paramString1 == null);
      try
      {
        LoginBean localLoginBean = (LoginBean)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, LoginBean.class);
        if ((localLoginBean != null) && (localLoginBean.getState().equals("STATE_OK")))
        {
          this.mHandler.sendEmptyMessage(2);
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.mHandler.sendEmptyMessage(3);
        return;
      }
      this.mHandler.sendEmptyMessage(3);
      return;
    }
    while (paramString1 == null);
    try
    {
      RspSplashBean localRspSplashBean = (RspSplashBean)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, RspSplashBean.class);
      if ((localRspSplashBean != null) && (localRspSplashBean.getResult().equals("true")))
      {
        String str1 = localRspSplashBean.getImage_url();
        String str2 = this.mSP.c();
        if (str2.equals(""))
        {
          com.a.a.b.c localc2 = new c.a().b(false).d(true).a(Bitmap.Config.RGB_565).d();
          d.a().a(str1, localc2, new bx(this, str1));
          return;
        }
        if (str1.equals(str2))
        {
          this.mHandler.sendEmptyMessage(23);
          return;
        }
        this.mHandler.sendEmptyMessage(24);
        com.a.a.b.c localc1 = new c.a().b(false).d(true).a(Bitmap.Config.RGB_565).d();
        d.a().a(str1, localc1, new by(this, str1));
        return;
      }
      h.a("启动屏数据解析异常");
      return;
    }
    catch (Exception localException1)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903121);
    MyApplication.getInstance().startTime = System.currentTimeMillis();
  }

  public void updateStatus()
  {
    String str = this.mPushAgent.getRegistrationId();
    h.a("友盟----:" + str);
    pushClientId(this.mContext, str);
  }

  private static class a extends com.withustudy.koudaizikao.base.m<WelcomeActivity>
  {
    private WelcomeActivity a;

    public a(WelcomeActivity paramWelcomeActivity)
    {
      super();
      this.a = paramWelcomeActivity;
    }

    protected void a(WelcomeActivity paramWelcomeActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        h.a("进入登录逻辑");
        this.a.loadSplah();
        if (paramWelcomeActivity.isShowGuide())
        {
          paramWelcomeActivity.startNewActivity(GuideActivity.class, true, null);
          return;
        }
        new bz(this, paramWelcomeActivity).start();
        return;
      case 2:
        MyApplication.getInstance().endTime = System.currentTimeMillis();
        paramWelcomeActivity.startNewActivity(MainActivity.class, true, null);
        return;
      case 3:
        Bundle localBundle = new Bundle();
        localBundle.putString("flag", "0");
        paramWelcomeActivity.startNewActivity(LoginActivity.class, true, localBundle);
        return;
      case 22:
        h.a(this.a, "下载完成");
        return;
      case 23:
        h.a(this.a, "图片链接未变");
        return;
      case 24:
        h.a(this.a, "图片变了");
        return;
      case 25:
      }
      h.a(this.a, "新图下载完成");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.WelcomeActivity
 * JD-Core Version:    0.6.0
 */