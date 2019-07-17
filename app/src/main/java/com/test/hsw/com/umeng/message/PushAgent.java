package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.b.a.b;
import com.umeng.message.b.af;
import com.umeng.message.b.dl;
import com.umeng.message.b.ep.e;
import com.umeng.message.local.UmengLocalNotification;
import com.umeng.message.local.UmengLocalNotificationManager;
import com.umeng.message.local.UmengLocalNotificationService;
import java.util.List;
import java.util.Random;
import org.json.JSONException;

public class PushAgent
{
  public static boolean DEBUG;
  private static PushAgent a;
  private static boolean d = false;
  private static final String e;
  private com.umeng.message.c.a b;
  private Context c;
  private UHandler f;
  private UHandler g;
  private boolean h = false;
  private boolean i = true;
  private Handler j;
  private IUmengRegisterCallback k;
  private IUmengUnregisterCallback l;

  static
  {
    DEBUG = false;
    e = PushAgent.class.getName();
  }

  private PushAgent(Context paramContext)
  {
    try
    {
      this.c = paramContext;
      this.b = com.umeng.message.c.a.a(paramContext);
      this.f = new UmengMessageHandler();
      this.g = new UmengNotificationClickHandler();
      this.j = new PushAgent.1(this, paramContext.getMainLooper());
      return;
    }
    catch (Exception localException)
    {
      while (true)
        com.umeng.b.a.a.b(e, localException.getMessage());
    }
  }

  private void a(int paramInt)
    throws Exception
  {
    String str1 = MessageSharedPrefs.getInstance(this.c).getFailAliasType(paramInt);
    if (str1.equals(""));
    String[] arrayOfString;
    int m;
    do
    {
      do
      {
        return;
        arrayOfString = str1.split(";");
      }
      while ((arrayOfString == null) || (arrayOfString.length <= 0));
      m = 0;
    }
    while (m >= arrayOfString.length);
    String str2 = MessageSharedPrefs.getInstance(this.c).getFailAlias(arrayOfString[m], paramInt);
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      m++;
      break;
      addAlias(str2, arrayOfString[m]);
      continue;
      addExclusiveAlias(str2, arrayOfString[m]);
    }
  }

  public static PushAgent getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new PushAgent(paramContext.getApplicationContext());
      PushAgent localPushAgent = a;
      return localPushAgent;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static boolean isAppLaunchByMessage()
  {
    return d;
  }

  public static void sendSoTimeout(Context paramContext, int paramInt)
  {
    if (paramInt > 0)
    {
      Intent localIntent = org.android.agoo.b.a.a(paramContext, "so_manager");
      if (localIntent != null)
      {
        localIntent.putExtra("soTimeout", paramInt);
        paramContext.sendBroadcast(localIntent);
      }
    }
  }

  public static void setAppLaunchByMessage()
  {
    d = true;
  }

  public boolean addAlias(String paramString1, String paramString2)
    throws ep.e, JSONException, Exception
  {
    return UTrack.getInstance(this.c).addAlias(paramString1, paramString2);
  }

  public boolean addExclusiveAlias(String paramString1, String paramString2)
    throws ep.e, JSONException, Exception
  {
    return UTrack.getInstance(this.c).addExclusiveAlias(paramString1, paramString2);
  }

  public boolean addLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    return UmengLocalNotificationManager.getInstance(this.c).addLocalNotification(paramUmengLocalNotification);
  }

  public boolean clearLocalNotifications()
  {
    return UmengLocalNotificationManager.getInstance(this.c).deleteAllLocalNotifications();
  }

  public boolean deleteLocalNotification(String paramString)
  {
    return UmengLocalNotificationManager.getInstance(this.c).deleteLocalNotification(paramString);
  }

  public void disable()
  {
    try
    {
      String str = dl.a(this.c, Process.myPid());
      com.umeng.b.a.a.c(e, "processName=" + str);
      if (!this.c.getPackageName().equals(str))
        return;
      MessageSharedPrefs.getInstance(this.c).f();
      if (UmengRegistrar.isRegistered(this.c))
      {
        UmengRegistrar.unregister(this.c);
        return;
      }
    }
    catch (Exception localException)
    {
      com.umeng.b.a.a.b(e, localException.getMessage());
    }
  }

  public void disable(IUmengUnregisterCallback paramIUmengUnregisterCallback)
  {
    setUnregisterCallback(paramIUmengUnregisterCallback);
    disable();
  }

  public void enable()
  {
    try
    {
      if (!dl.c(this.c, UmengLocalNotificationService.class.getName()))
        UmengLocalNotificationManager.getInstance(this.c).resetLocalNotifications();
      String str = dl.a(this.c, Process.myPid());
      com.umeng.b.a.a.c(e, "processName=" + str);
      if (!this.c.getPackageName().equals(str))
        return;
      if (Build.VERSION.SDK_INT < 8)
      {
        com.umeng.b.a.a.b(e, "Push SDK does not work for Android Verion < 8");
        return;
      }
    }
    catch (Exception localException)
    {
      com.umeng.b.a.a.b(e, localException.getMessage());
      return;
    }
    if (!dl.a(this.c, this.j))
    {
      com.umeng.b.a.a.b(e, "Need to correct AndroidManifest config according to instruction from http://dev.umeng.com/push/android/integration");
      return;
    }
    com.umeng.b.a.a.c(e, "The AndroidManifest config is right");
    dl.a(this.c, UmengMessageCallbackHandlerService.class);
    MessageSharedPrefs.getInstance(this.c).e();
    com.umeng.b.a.a.c(e, "enable(): register");
    UmengRegistrar.register(this.c, getMessageAppkey(), getMessageSecret());
    sendSoTimeout(this.c, 600);
  }

  public void enable(IUmengRegisterCallback paramIUmengRegisterCallback)
  {
    setRegisterCallback(paramIUmengRegisterCallback);
    enable();
  }

  public List<UmengLocalNotification> findAllLocalNotifications()
  {
    return UmengLocalNotificationManager.getInstance(this.c).findAllLocalNotifications();
  }

  public UmengLocalNotification findLocalNotification(String paramString)
  {
    return UmengLocalNotificationManager.getInstance(this.c).findLocalNotification(paramString);
  }

  public List<UmengLocalNotification> findLocalNotifications(String paramString)
  {
    return UmengLocalNotificationManager.getInstance(this.c).findLocalNotifications(paramString);
  }

  public boolean getLocalNotificationIntervalLimit()
  {
    return MessageSharedPrefs.getInstance(this.c).l();
  }

  public boolean getMergeNotificaiton()
  {
    return MessageSharedPrefs.getInstance(this.c).getMergeNotificaiton();
  }

  public String getMessageAppkey()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageAppKey();
    if (TextUtils.isEmpty(str))
      str = b.r(this.c);
    return str;
  }

  public String getMessageChannel()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageChannel();
    if (TextUtils.isEmpty(str))
      str = b.v(this.c);
    return str;
  }

  public UHandler getMessageHandler()
  {
    return this.f;
  }

  public String getMessageSecret()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageAppSecret();
    if (TextUtils.isEmpty(str))
      str = b.b(this.c, "UMENG_MESSAGE_SECRET");
    return str;
  }

  public int getMuteDurationSeconds()
  {
    return MessageSharedPrefs.getInstance(this.c).k();
  }

  public int getNoDisturbEndHour()
  {
    return MessageSharedPrefs.getInstance(this.c).c();
  }

  public int getNoDisturbEndMinute()
  {
    return MessageSharedPrefs.getInstance(this.c).d();
  }

  public int getNoDisturbStartHour()
  {
    return MessageSharedPrefs.getInstance(this.c).a();
  }

  public int getNoDisturbStartMinute()
  {
    return MessageSharedPrefs.getInstance(this.c).b();
  }

  public UHandler getNotificationClickHandler()
  {
    return this.g;
  }

  public boolean getNotificationOnForeground()
  {
    return MessageSharedPrefs.getInstance(this.c).getNotificaitonOnForeground();
  }

  public int getNotificationPlayLights()
  {
    return MessageSharedPrefs.getInstance(this.c).getNotificationPlayLights();
  }

  public int getNotificationPlaySound()
  {
    return MessageSharedPrefs.getInstance(this.c).getNotificationPlaySound();
  }

  public int getNotificationPlayVibrate()
  {
    return MessageSharedPrefs.getInstance(this.c).getNotificationPlayVibrate();
  }

  public String getPushIntentServiceClass()
  {
    return MessageSharedPrefs.getInstance(this.c).getPushIntentServiceClass();
  }

  public IUmengRegisterCallback getRegisterCallback()
  {
    return this.k;
  }

  public String getRegistrationId()
  {
    return UmengRegistrar.getRegistrationId(this.c);
  }

  public String getResourcePackageName()
  {
    return MessageSharedPrefs.getInstance(this.c).getResourcePackageName();
  }

  public com.umeng.message.c.a getTagManager()
  {
    return this.b;
  }

  public IUmengUnregisterCallback getUnregisterCallback()
  {
    return this.l;
  }

  public boolean isEnabled()
  {
    try
    {
      boolean bool = MessageSharedPrefs.getInstance(this.c).g();
      return bool;
    }
    catch (Exception localException)
    {
      com.umeng.b.a.a.b(e, localException.getMessage());
    }
    return false;
  }

  public boolean isIncludesUmengUpdateSDK()
  {
    try
    {
      Class localClass2 = Class.forName("com.umeng.update.UmengUpdateAgent");
      localClass1 = localClass2;
      if (localClass1 != null)
        return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        localClassNotFoundException.printStackTrace();
        Class localClass1 = null;
      }
    }
    return false;
  }

  public boolean isPushCheck()
  {
    return this.h;
  }

  public boolean isRegistered()
  {
    return UmengRegistrar.isRegistered(this.c);
  }

  public void onAppStart()
  {
    new Thread(new PushAgent.2(this)).start();
    UmengRegistrar.checkRegisteredToUmeng(this.c);
    if (!UmengRegistrar.isRegistered(this.c))
      return;
    if (MessageSharedPrefs.getInstance(this.c).getAppLaunchLogSendPolicy() == 1)
      com.umeng.b.a.a.c(e, "launch_policy=1, skip sending app launch info.");
    while (true)
    {
      long l1 = 0L;
      if (isAppLaunchByMessage())
        l1 = Math.abs(new Random().nextLong() % MsgConstant.a);
      UTrack.getInstance(this.c).sendCachedMsgLog(l1);
      return;
      if (MessageSharedPrefs.getInstance(this.c).hasAppLaunchLogSentToday())
        continue;
      UTrack.getInstance(this.c).trackAppLaunch(10000L);
    }
  }

  public boolean removeAlias(String paramString1, String paramString2)
    throws ep.e, JSONException, Exception
  {
    return UTrack.getInstance(this.c).removeAlias(paramString1, paramString2);
  }

  public void setAppkeyAndSecret(String paramString1, String paramString2)
  {
    MessageSharedPrefs.getInstance(this.c).setMessageAppKey(paramString1);
    MessageSharedPrefs.getInstance(this.c).setMessageAppSecret(paramString2);
  }

  public void setDebugMode(boolean paramBoolean)
  {
    com.umeng.b.a.a.a = paramBoolean;
    af.a(this.c, paramBoolean, false);
  }

  public void setLocalNotificationIntervalLimit(boolean paramBoolean)
  {
    MessageSharedPrefs.getInstance(this.c).a(paramBoolean);
  }

  public void setMergeNotificaiton(boolean paramBoolean)
  {
    MessageSharedPrefs.getInstance(this.c).setMergeNotificaiton(paramBoolean);
  }

  public void setMessageChannel(String paramString)
  {
    MessageSharedPrefs.getInstance(this.c).setMessageChannel(paramString);
  }

  public void setMessageHandler(UHandler paramUHandler)
  {
    this.f = paramUHandler;
  }

  public void setMuteDurationSeconds(int paramInt)
  {
    MessageSharedPrefs.getInstance(this.c).a(paramInt);
  }

  public void setNoDisturbMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MessageSharedPrefs.getInstance(this.c).a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setNotificaitonOnForeground(boolean paramBoolean)
  {
    MessageSharedPrefs.getInstance(this.c).setNotificaitonOnForeground(paramBoolean);
  }

  public void setNotificationClickHandler(UHandler paramUHandler)
  {
    this.g = paramUHandler;
  }

  public void setNotificationPlayLights(int paramInt)
  {
    MessageSharedPrefs.getInstance(this.c).setNotificationPlayLights(paramInt);
  }

  public void setNotificationPlaySound(int paramInt)
  {
    MessageSharedPrefs.getInstance(this.c).setNotificationPlaySound(paramInt);
  }

  public void setNotificationPlayVibrate(int paramInt)
  {
    MessageSharedPrefs.getInstance(this.c).setNotificationPlayVibrate(paramInt);
  }

  public void setPushCheck(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> paramClass)
  {
    MessageSharedPrefs.getInstance(this.c).setPushIntentServiceClass(paramClass);
  }

  public void setRegisterCallback(IUmengRegisterCallback paramIUmengRegisterCallback)
  {
    this.k = paramIUmengRegisterCallback;
  }

  public void setResourcePackageName(String paramString)
  {
    MessageSharedPrefs.getInstance(this.c).setResourcePackageName(paramString);
  }

  public void setUnregisterCallback(IUmengUnregisterCallback paramIUmengUnregisterCallback)
  {
    this.l = paramIUmengUnregisterCallback;
  }

  public boolean updateLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    return UmengLocalNotificationManager.getInstance(this.c).updateLocalNotification(paramUmengLocalNotification);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.PushAgent
 * JD-Core Version:    0.6.0
 */