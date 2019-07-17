package com.withustudy.koudaizikao;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.view.Display;
import android.view.WindowManager;
import com.a.a.b.a.g;
import com.a.a.b.e.a;
import com.android.http.n;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.umeng.message.PushAgent;
import com.withustudy.koudaizikao.g.h;
import com.xiaomi.mipush.MiPushReceiver.a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import koudai.db.c.a;
import koudai.db.c.b;

public class MyApplication extends Application
{
  public static final String APP_ID = "2882303761517394560";
  public static final String APP_KEY = "5201739449560";
  private static final String TAG;
  private static koudai.db.c daoMaster;
  private static koudai.db.d daoSession;
  private static MiPushReceiver.a handler = null;
  private static MyApplication instance;
  public static boolean isRunning = false;
  private final int connectTimeout = 10000;
  private final int discCacheFileCount = 100;
  private final int discCacheSize = 52428800;
  public long endTime = 0L;
  private Context mContext;
  public LocationClient mLocationClient;
  public a mMyLocationListener;
  private PushAgent mPushAgent;
  private final int memoryCacheSize = 2097152;
  private final int readTimeout = 40000;
  public long startTime = 0L;
  private final int threadPoolSize = 2;

  static
  {
    TAG = MyApplication.class.getName();
  }

  private File getCachePath()
  {
    File localFile = new File(com.withustudy.koudaizikao.g.f.a(this.mContext).b() + "Cache");
    if (!localFile.exists())
      localFile.mkdirs();
    return localFile;
  }

  public static koudai.db.c getDaoMaster(Context paramContext)
  {
    if (daoMaster == null)
      daoMaster = new koudai.db.c(new c.a(paramContext, com.withustudy.koudaizikao.d.a.a, null).getWritableDatabase());
    return daoMaster;
  }

  public static koudai.db.d getDaoSession(Context paramContext)
  {
    if (daoSession == null)
    {
      if (daoMaster == null)
        daoMaster = getDaoMaster(paramContext);
      daoSession = daoMaster.d();
    }
    return daoSession;
  }

  public static MiPushReceiver.a getHandler()
  {
    return handler;
  }

  public static MyApplication getInstance()
  {
    return instance;
  }

  private int getScreenHeight()
  {
    return ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }

  private int getScreenWidth()
  {
    return ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }

  private void initImageLoader()
  {
    com.a.a.b.e locale = new e.a(this.mContext).a(getScreenWidth(), getScreenHeight()).a(2).b(3).a().c(2097152).e(52428800).a(new com.a.a.a.a.b.c()).a(g.b).g(100).a(new com.a.a.a.a.a.c(getCachePath())).a(com.a.a.b.c.t()).a(new com.a.a.b.d.a(this.mContext, 10000, 40000)).b().c();
    com.a.a.b.d.a().a(locale);
  }

  private void initUmengPush()
  {
    this.mPushAgent = PushAgent.getInstance(this);
    this.mPushAgent.setDebugMode(true);
    this.mPushAgent.setMergeNotificaiton(false);
    c localc = new c(this);
    this.mPushAgent.setMessageHandler(localc);
    e locale = new e(this);
    this.mPushAgent.setNotificationClickHandler(locale);
  }

  private void initXiaoMiPush()
  {
    if (shouldInit())
      com.xiaomi.mipush.sdk.d.a(this, "2882303761517394560", "5201739449560");
    com.xiaomi.mipush.sdk.c.a(this, new f(this));
    if (handler == null)
      handler = new MiPushReceiver.a(getApplicationContext());
  }

  private boolean shouldInit()
  {
    List localList = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
    String str = getPackageName();
    int i = Process.myPid();
    Iterator localIterator = localList.iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext())
        return false;
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    }
    while ((localRunningAppProcessInfo.pid != i) || (!str.equals(localRunningAppProcessInfo.processName)));
    return true;
  }

  public void onCreate()
  {
    super.onCreate();
    instance = this;
    initUmengPush();
    initXiaoMiPush();
    this.mContext = getApplicationContext();
    n.a().a(this);
    initImageLoader();
    this.mLocationClient = new LocationClient(getApplicationContext());
    this.mMyLocationListener = new a();
    this.mLocationClient.registerLocationListener(this.mMyLocationListener);
  }

  public class a
    implements BDLocationListener
  {
    public a()
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      com.withustudy.koudaizikao.d.f.a(MyApplication.this).f(paramBDLocation.getLongitude());
      com.withustudy.koudaizikao.d.f.a(MyApplication.this).h(paramBDLocation.getLatitude());
      com.withustudy.koudaizikao.d.f.a(MyApplication.this).g(paramBDLocation.getCity());
      h.a("百度定位经度：" + paramBDLocation.getLongitude() + ";纬度：" + paramBDLocation.getLatitude());
      h.a("百度定位城市：" + paramBDLocation.getCity());
      h.a("百度定位省份：" + paramBDLocation.getProvince());
      h.a("百度定位地址：" + paramBDLocation.getAddrStr());
      h.a("百度定位网络类型：" + paramBDLocation.getNetworkLocationType());
      String str = paramBDLocation.getCity();
      if ((str != null) && (!str.equals("")))
        MyApplication.this.mLocationClient.stop();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.MyApplication
 * JD-Core Version:    0.6.0
 */