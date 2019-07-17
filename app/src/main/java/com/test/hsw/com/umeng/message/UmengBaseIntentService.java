package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.message.b.dl;
import com.umeng.message.local.UmengLocalNotificationManager;
import com.umeng.message.local.UmengLocalNotificationService;
import org.android.agoo.client.BaseIntentService;
import org.json.JSONObject;

public abstract class UmengBaseIntentService extends BaseIntentService
{
  private static final String a = UmengBaseIntentService.class.getName();

  protected final Class<?> a()
  {
    com.umeng.b.a.a.c(a, "getAgooService");
    return UmengService.class.getClass();
  }

  protected void a(Context paramContext, String paramString)
  {
    com.umeng.b.a.a.c(a, "onError()[" + paramString + "]");
  }

  protected boolean a(Context paramContext, Intent paramIntent)
  {
    return PushAgent.getInstance(paramContext).isEnabled();
  }

  protected void b(Context paramContext, Intent paramIntent)
  {
    if (Process.getElapsedCpuTime() < 3000L)
    {
      com.umeng.b.a.a.a(a, "App is launched by push message");
      PushAgent.setAppLaunchByMessage();
    }
    String str1 = paramIntent.getStringExtra("body");
    com.umeng.b.a.a.c(a, "onMessage():[" + str1 + "]");
    try
    {
      com.umeng.message.a.a locala = new com.umeng.message.a.a(new JSONObject(str1));
      locala.i = paramIntent.getStringExtra("id");
      locala.j = paramIntent.getStringExtra("task_id");
      UTrack.getInstance(getApplicationContext()).a(locala);
      MsgLogStore.getInstance(paramContext).addLogIdType(locala.h, locala.k);
      MsgLogStore.getInstance(paramContext).addLogIdTypeForAgoo(locala.i, locala.j, locala.k);
      if (TextUtils.equals("autoupdate", locala.k))
      {
        String str2 = paramIntent.getStringExtra("id");
        String str3 = paramIntent.getStringExtra("task_id");
        Intent localIntent = new Intent();
        localIntent.setPackage(paramContext.getPackageName());
        localIntent.setAction("com.umeng.message.autoupdate.handler.action");
        localIntent.putExtra("body", str1);
        localIntent.putExtra("id", str2);
        localIntent.putExtra("task_id", str3);
        paramContext.startService(localIntent);
      }
      if (!dl.c(this, UmengLocalNotificationService.class.getName()))
        UmengLocalNotificationManager.getInstance(this).resetLocalNotifications();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.umeng.b.a.a.c(a, localException.toString());
    }
  }

  protected void b(Context paramContext, String paramString)
  {
    com.umeng.b.a.a.c(a, "onRegistered()[" + paramString + "]");
    try
    {
      UTrack.getInstance(getApplicationContext()).trackRegister();
      Intent localIntent = new Intent();
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.setAction("com.umeng.messge.registercallback.action");
      localIntent.putExtra("registration_id", paramString);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  protected void c(Context paramContext, String paramString)
  {
    com.umeng.b.a.a.c(a, "onUnregistered()[" + paramString + "]");
    Intent localIntent = new Intent();
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.setAction("com.umeng.message.unregistercallback.action");
    localIntent.putExtra("registration_id", paramString);
    paramContext.startService(localIntent);
  }

  public Class<?> callAgooElectionReceiver()
  {
    com.umeng.b.a.a.c(a, "callAgooElectionReceiver");
    return ElectionReceiver.class;
  }

  public Class<?> callAgooMessageReceiver()
  {
    com.umeng.b.a.a.c(a, "callAgooMessageReceiver");
    return MessageReceiver.class;
  }

  public Class<?> callAgooRegistrationReceiver()
  {
    com.umeng.b.a.a.c(a, "callAgooRegistrationReceiver");
    return RegistrationReceiver.class;
  }

  public Class<?> callAgooSystemReceiver()
  {
    com.umeng.b.a.a.c(a, "callAgooSystemReceiver");
    return SystemReceiver.class;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengBaseIntentService
 * JD-Core Version:    0.6.0
 */