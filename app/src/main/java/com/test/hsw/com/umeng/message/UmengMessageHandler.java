package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.umeng.message.b.de;
import com.umeng.message.b.dl;
import com.umeng.message.b.el;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.json.JSONObject;

public class UmengMessageHandler
  implements UHandler
{
  private static int a = 0;
  private static final String b = UmengMessageHandler.class.getName();
  private static Date c;
  private static String d = "9999999999999";
  private static final String f = "umeng_push_notification_default_large_icon";
  private static final String g = "umeng_push_notification_default_small_icon";
  private static final String h = "umeng_push_notification_default_sound";
  private com.umeng.message.a.a e = null;

  @SuppressLint({"NewApi", "Wakelock"})
  private void a(Context paramContext)
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 7);
      for (boolean bool = new UmengMessageHandler.1(this, localPowerManager).a(); ; bool = false)
      {
        com.umeng.b.a.a.c(b, "screen on................................." + bool);
        if (bool)
          break;
        localPowerManager.newWakeLock(805306374, "MyLock").acquire(10000L);
        return;
        com.umeng.b.a.a.c(b, "android os version < 7, skip checking screen on status");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void a(Context paramContext, Notification paramNotification, boolean paramBoolean, com.umeng.message.a.a parama)
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      try
      {
        if (!PushAgent.getInstance(paramContext).getMergeNotificaiton())
        {
          int j = new Random().nextInt();
          i = j;
        }
        while (true)
        {
          if (((paramBoolean) || (!PushAgent.getInstance(paramContext).getMergeNotificaiton())) && ((!dl.c(paramContext)) || (!dl.b(paramContext)) || (PushAgent.getInstance(paramContext).getNotificationOnForeground())))
            localNotificationManager.notify(i, paramNotification);
          if (((paramBoolean) || (!PushAgent.getInstance(paramContext).getMergeNotificaiton())) && (dl.c(paramContext)) && (dl.b(paramContext)) && (!PushAgent.getInstance(paramContext).getNotificationOnForeground()))
          {
            UTrack.getInstance(paramContext).setClearPrevMessage(false);
            UTrack.getInstance(paramContext).trackMsgDismissed(parama);
          }
          return;
          if (paramBoolean)
          {
            if ((dl.c(paramContext)) && (dl.b(paramContext)) && (!PushAgent.getInstance(paramContext).getNotificationOnForeground()))
              break;
            localNotificationManager.cancel(20100401);
            com.umeng.b.a.a.c(b, "prevMessage=" + this.e);
            UTrack.getInstance(paramContext).setClearPrevMessage(false);
            UTrack.getInstance(paramContext).trackMsgDismissed(this.e);
            this.e = parama;
            i = 20100401;
            continue;
          }
          UTrack.getInstance(paramContext).setClearPrevMessage(false);
          UTrack.getInstance(paramContext).trackMsgDismissed(parama);
          i = 20100401;
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          localException2.printStackTrace();
          int i = 20100401;
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }

  private boolean a(Context paramContext, NotificationCompat.Builder paramBuilder, com.umeng.message.a.a parama)
  {
    int i = getSmallIconId(paramContext, parama);
    Bitmap localBitmap = getLargeIcon(paramContext, parama);
    if (i < 0)
      return false;
    paramBuilder.setSmallIcon(i);
    if (localBitmap != null)
      paramBuilder.setLargeIcon(localBitmap);
    return true;
  }

  public void dealWithCustomMessage(Context paramContext, com.umeng.message.a.a parama)
  {
  }

  public void dealWithNotificationMessage(Context paramContext, com.umeng.message.a.a parama)
  {
    com.umeng.b.a.a.c(b, "notify: " + parama.a().toString());
    if ((parama.b()) && (!MessageSharedPrefs.getInstance(paramContext).b(parama.h)) && (startDownloadResourceService(paramContext, parama)))
      return;
    String str1 = MessageSharedPrefs.getInstance(paramContext).j();
    String str2;
    label80: String str3;
    label135: boolean bool;
    if ("".equals(str1))
    {
      str2 = "";
      if ((parama.h == null) || (22 != parama.h.length()) || (!parama.h.startsWith("u")))
        break label405;
      MessageSharedPrefs.getInstance(paramContext).e(parama.h);
      str3 = parama.h.substring(7, 20);
      if (!"".equals(str2))
        break label413;
      bool = true;
    }
    while (true)
    {
      MessageSharedPrefs.getInstance(paramContext).d(parama.h);
      Notification localNotification = getNotification(paramContext, parama);
      if ((localNotification != null) && (localNotification.icon == 0))
      {
        int j = getSmallIconId(paramContext, parama);
        if (j <= 0)
          break;
        localNotification.icon = j;
      }
      if (localNotification == null)
      {
        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
        if (!a(paramContext, localBuilder, parama))
          break;
        localBuilder.setContentTitle(parama.n).setContentText(parama.o).setTicker(parama.m).setAutoCancel(true);
        NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
        localBigTextStyle.setBigContentTitle(parama.n);
        localBigTextStyle.bigText(parama.o);
        localBuilder.setStyle(localBigTextStyle);
        localNotification = localBuilder.build();
      }
      PendingIntent localPendingIntent = getClickPendingIntent(paramContext, parama);
      localNotification.deleteIntent = getDismissPendingIntent(paramContext, parama);
      localNotification.contentIntent = localPendingIntent;
      int i = getNotificationDefaults(paramContext, parama);
      if ((i & 0x1) != 0)
      {
        Uri localUri = getSound(paramContext, parama);
        if (localUri != null)
          localNotification.sound = getSound(paramContext, parama);
        if (localUri != null)
          i ^= 1;
      }
      localNotification.defaults = i;
      a(paramContext, localNotification, bool, parama);
      return;
      str2 = str1.substring(7, 20);
      break label80;
      label405: str3 = d;
      break label135;
      label413: if (str3.compareToIgnoreCase(str2) >= 0)
      {
        bool = true;
        continue;
      }
      bool = false;
    }
  }

  public PendingIntent getClickPendingIntent(Context paramContext, com.umeng.message.a.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, NotificationProxyBroadcastReceiver.class);
    localIntent.putExtra("MSG", parama.a().toString());
    localIntent.putExtra("ACTION", 10);
    localIntent.putExtra("MESSAGE_ID", parama.i);
    localIntent.putExtra("TASK_ID", parama.j);
    return PendingIntent.getBroadcast(paramContext, (int)System.currentTimeMillis(), localIntent, 268435456);
  }

  public PendingIntent getDismissPendingIntent(Context paramContext, com.umeng.message.a.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, NotificationProxyBroadcastReceiver.class);
    localIntent.putExtra("MSG", parama.a().toString());
    localIntent.putExtra("ACTION", 11);
    localIntent.putExtra("MESSAGE_ID", parama.i);
    localIntent.putExtra("TASK_ID", parama.j);
    return PendingIntent.getBroadcast(paramContext, (int)(1L + System.currentTimeMillis()), localIntent, 268435456);
  }

  public Bitmap getLargeIcon(Context paramContext, com.umeng.message.a.a parama)
  {
    while (true)
    {
      try
      {
        if (!parama.c())
          break label170;
        localBitmap1 = BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(paramContext, parama) + parama.x.hashCode());
        if (localBitmap1 == null)
        {
          int k = -1;
          if (TextUtils.isEmpty(parama.C))
            continue;
          k = de.a(paramContext).c(parama.C);
          if (k >= 0)
            continue;
          k = de.a(paramContext).c("umeng_push_notification_default_large_icon");
          if (k > 0)
          {
            localBitmap2 = BitmapFactory.decodeResource(paramContext.getResources(), k);
            if (localBitmap2 == null)
              break;
            if (Build.VERSION.SDK_INT < 11)
              continue;
            int j = (int)paramContext.getResources().getDimension(17104902);
            return Bitmap.createScaledBitmap(localBitmap2, j, j, true);
            int i = el.a(a);
            j = i;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      Bitmap localBitmap2 = localBitmap1;
      continue;
      label170: Bitmap localBitmap1 = null;
    }
    return null;
  }

  public Notification getNotification(Context paramContext, com.umeng.message.a.a parama)
  {
    return null;
  }

  public int getNotificationDefaults(Context paramContext, com.umeng.message.a.a parama)
  {
    int i = 2;
    boolean bool = isInNoDisturbTime(paramContext);
    long l = 1000L * (1L * MessageSharedPrefs.getInstance(paramContext).k());
    if (bool);
    do
      return 0;
    while ((c != null) && (Calendar.getInstance().getTimeInMillis() - c.getTime() < l));
    int j = MessageSharedPrefs.getInstance(paramContext).getNotificationPlayVibrate();
    com.umeng.b.a.a.c(b, "playVibrate:" + j);
    if (j == 1)
    {
      int k = MessageSharedPrefs.getInstance(paramContext).getNotificationPlayLights();
      com.umeng.b.a.a.c(b, "playLights:" + k);
      if (k != 1)
        break label217;
      i |= 4;
      label139: int m = MessageSharedPrefs.getInstance(paramContext).getNotificationPlaySound();
      com.umeng.b.a.a.c(b, "playSound:" + m);
      if (m != 1)
        break label231;
      i |= 1;
    }
    while (true)
    {
      c = Calendar.getInstance().getTime();
      if (parama.s)
        a(paramContext);
      return i;
      if (parama.p)
        break;
      i = 0;
      break;
      label217: if (!parama.q)
        break label139;
      i |= 4;
      break label139;
      label231: if (!parama.r)
        continue;
      i |= 1;
    }
  }

  // ERROR //
  public int getSmallIconId(Context paramContext, com.umeng.message.a.a parama)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_2
    //   3: getfield 509	com/umeng/message/a/a:y	Ljava/lang/String;
    //   6: invokestatic 417	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +15 -> 24
    //   12: aload_1
    //   13: invokestatic 422	com/umeng/message/b/de:a	(Landroid/content/Context;)Lcom/umeng/message/b/de;
    //   16: aload_2
    //   17: getfield 509	com/umeng/message/a/a:y	Ljava/lang/String;
    //   20: invokevirtual 424	com/umeng/message/b/de:c	(Ljava/lang/String;)I
    //   23: istore_3
    //   24: iload_3
    //   25: ifge +13 -> 38
    //   28: aload_1
    //   29: invokestatic 422	com/umeng/message/b/de:a	(Landroid/content/Context;)Lcom/umeng/message/b/de;
    //   32: ldc 20
    //   34: invokevirtual 424	com/umeng/message/b/de:c	(Ljava/lang/String;)I
    //   37: istore_3
    //   38: iload_3
    //   39: ifge +71 -> 110
    //   42: getstatic 37	com/umeng/message/UmengMessageHandler:b	Ljava/lang/String;
    //   45: ldc_w 511
    //   48: invokestatic 95	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 515	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   55: aload_1
    //   56: invokevirtual 518	android/content/Context:getPackageName	()Ljava/lang/String;
    //   59: iconst_0
    //   60: invokevirtual 524	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   63: getfield 530	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   66: getfield 533	android/content/pm/ApplicationInfo:icon	I
    //   69: istore 5
    //   71: iload 5
    //   73: ifge +12 -> 85
    //   76: getstatic 37	com/umeng/message/UmengMessageHandler:b	Ljava/lang/String;
    //   79: ldc_w 535
    //   82: invokestatic 537	com/umeng/b/a/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: iload 5
    //   87: ireturn
    //   88: astore 4
    //   90: iload_3
    //   91: istore 5
    //   93: aload 4
    //   95: astore 6
    //   97: aload 6
    //   99: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   102: iload 5
    //   104: ireturn
    //   105: astore 6
    //   107: goto -10 -> 97
    //   110: iload_3
    //   111: istore 5
    //   113: goto -42 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	88	java/lang/Exception
    //   28	38	88	java/lang/Exception
    //   42	71	88	java/lang/Exception
    //   76	85	105	java/lang/Exception
  }

  public Uri getSound(Context paramContext, com.umeng.message.a.a parama)
  {
    while (true)
    {
      try
      {
        if (parama.d())
        {
          str = UmengDownloadResourceService.getMessageResourceFolder(paramContext, parama) + parama.w.hashCode();
          if (new File(str).exists())
            continue;
          str = null;
          if (str != null)
            continue;
          int i = -1;
          if (TextUtils.isEmpty(parama.w))
            continue;
          i = de.a(paramContext).h(parama.w);
          if (i >= 0)
            continue;
          i = de.a(paramContext).h("umeng_push_notification_default_sound");
          if (i <= 0)
            continue;
          str = "android.resource://" + paramContext.getPackageName() + "/" + i;
          Object localObject = null;
          if (str == null)
            continue;
          Uri localUri = Uri.parse(str);
          localObject = localUri;
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      String str = null;
    }
  }

  public void handleMessage(Context paramContext, com.umeng.message.a.a parama)
  {
    if ("notification".equals(parama.k))
      dealWithNotificationMessage(paramContext, parama);
    do
      return;
    while (!"custom".equals(parama.k));
    UTrack.getInstance(paramContext).setClearPrevMessage(false);
    dealWithCustomMessage(paramContext, parama);
  }

  public boolean isInNoDisturbTime(Context paramContext)
  {
    int i = Calendar.getInstance().get(11);
    int j = Calendar.getInstance().get(12);
    int k;
    int m;
    label78: int n;
    if (j + i * 60 >= 60 * PushAgent.getInstance(paramContext).getNoDisturbStartHour() + PushAgent.getInstance(paramContext).getNoDisturbStartMinute())
    {
      k = 1;
      if (j + i * 60 > 60 * PushAgent.getInstance(paramContext).getNoDisturbEndHour() + PushAgent.getInstance(paramContext).getNoDisturbEndMinute())
        break label143;
      m = 1;
      if (60 * PushAgent.getInstance(paramContext).getNoDisturbEndHour() + PushAgent.getInstance(paramContext).getNoDisturbEndMinute() < 60 * PushAgent.getInstance(paramContext).getNoDisturbStartHour() + PushAgent.getInstance(paramContext).getNoDisturbStartMinute())
        break label149;
      n = 1;
      label120: if (n == 0)
        break label157;
      if ((k == 0) || (m == 0))
        break label155;
    }
    label143: label149: label155: label157: 
    do
    {
      return true;
      k = 0;
      break;
      m = 0;
      break label78;
      n = 0;
      break label120;
      return false;
    }
    while ((k != 0) || (m != 0));
    return false;
  }

  public void setPrevMessage(com.umeng.message.a.a parama)
  {
    this.e = parama;
  }

  public boolean startDownloadResourceService(Context paramContext, com.umeng.message.a.a parama)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, UmengDownloadResourceService.class);
      localIntent.putExtra("body", parama.a().toString());
      localIntent.putExtra("id", parama.i);
      localIntent.putExtra("task_id", parama.j);
      paramContext.startService(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengMessageHandler
 * JD-Core Version:    0.6.0
 */