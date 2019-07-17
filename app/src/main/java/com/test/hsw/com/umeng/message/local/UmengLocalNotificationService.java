package com.umeng.message.local;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class UmengLocalNotificationService extends IntentService
{
  private static final String a = UmengLocalNotificationService.class.getName();
  private Context b;

  public UmengLocalNotificationService()
  {
    super("UmengLocalNotificationService");
  }

  public UmengLocalNotificationService(String paramString)
  {
    super(paramString);
  }

  private void a(String paramString)
  {
    try
    {
      Log.d(a, "displayLocalNotification");
      UmengLocalNotification localUmengLocalNotification = UmengLocalNotificationStore.getInstance(this.b).findLocalNotification(paramString);
      if (localUmengLocalNotification != null)
      {
        if (localUmengLocalNotification.getRepeatingNum() == 0)
          return;
        Notification localNotification = localUmengLocalNotification.getNotificationBuilder().builder(this.b, localUmengLocalNotification.getTitle(), localUmengLocalNotification.getContent(), localUmengLocalNotification.getTicker());
        localUmengLocalNotification.getNotificationBuilder().showNotification(this.b, localNotification);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.d(a, localException.toString());
      localException.printStackTrace();
    }
  }

  private void a(String paramString1, String paramString2)
  {
    long l;
    try
    {
      UmengLocalNotification localUmengLocalNotification = UmengLocalNotificationStore.getInstance(this.b).findLocalNotification(paramString1);
      if (localUmengLocalNotification == null)
        return;
      l = UmengLocalNotificationHelper.getTimeAndUpdateLocalNotification(this.b, localUmengLocalNotification);
      Log.d(a, "time=" + UmengLocalNotificationHelper.getDateFromTime(l));
      int i = localUmengLocalNotification.getRepeatingNum();
      if (i == 0)
        try
        {
          UmengLocalNotificationManager.getInstance(this.b).deleteLocalNotification(paramString1);
          b(paramString1, paramString2);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Log.d(a, localException2.toString());
          return;
        }
    }
    catch (Exception localException1)
    {
      Log.d(a, localException1.toString());
      localException1.printStackTrace();
      return;
    }
    PendingIntent localPendingIntent = d(paramString1, paramString2);
    ((AlarmManager)getSystemService("alarm")).set(0, l, localPendingIntent);
  }

  private void b(String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = d(paramString1, paramString2);
    ((AlarmManager)getSystemService("alarm")).cancel(localPendingIntent);
  }

  private void c(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString1.split(";");
    int i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      b(arrayOfString[j], paramString2);
    }
  }

  private PendingIntent d(String paramString1, String paramString2)
  {
    int i = paramString1.hashCode();
    Intent localIntent = new Intent(this.b, UmengLocalNotificationService.class);
    localIntent.putExtra("local_notification_id", paramString1);
    localIntent.putExtra("local_notification_type", paramString2);
    return PendingIntent.getService(this.b, i, localIntent, 134217728);
  }

  public void onCreate()
  {
    Log.d(a, "onCreate");
    super.onCreate();
  }

  public void onDestroy()
  {
    Log.d(a, "onDestory");
    super.onDestroy();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("local_notification_id");
    String str2 = paramIntent.getStringExtra("local_notification_type");
    if (TextUtils.equals(str2, "add_local_notification"))
      a(str1, "display_local_notification");
    do
    {
      return;
      if (TextUtils.equals(str2, "update_local_notification"))
      {
        b(str1, "display_local_notification");
        a(str1, "display_local_notification");
        return;
      }
      if (TextUtils.equals(str2, "delete_local_notification"))
      {
        b(str1, "display_local_notification");
        return;
      }
      if (!TextUtils.equals(str2, "clear_local_notification"))
        continue;
      c(str1, "display_local_notification");
      return;
    }
    while (!TextUtils.equals(str2, "display_local_notification"));
    a(str1);
    b(str1, "display_local_notification");
    a(str1, "display_local_notification");
  }

  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.b = this;
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengLocalNotificationService
 * JD-Core Version:    0.6.0
 */