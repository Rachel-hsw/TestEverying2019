package com.umeng.message.local;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.umeng.b.a.a;
import com.umeng.message.NotificationProxyBroadcastReceiver;
import com.umeng.message.PushAgent;
import com.umeng.message.b.de;
import com.umeng.message.b.dl;
import com.umeng.message.b.el;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

public class UmengNotificationBuilder
  implements Serializable
{
  private static final long a = -2293674780748522096L;
  private static String b = UmengNotificationBuilder.class.getName();
  private static final int c = 64;
  private static final String d = "umeng_push_notification_default_large_icon";
  private static final String e = "umeng_push_notification_default_small_icon";
  private static final String f = "umeng_push_notification_default_sound";
  private static final String g = "id";
  private static final String h = "localnotification_id";
  private static final String i = "flags";
  private static final String j = "defaults";
  private static final String k = "smallicon_drawable";
  private static final String l = "largeicon_drawable";
  private static final String m = "sound_drawable";
  private static final String n = "play_vibrate";
  private static final String o = "play_lights";
  private static final String p = "play_sound";
  private static final String q = "screen_on";
  private static final String r = "layout_id";
  private static final String s = "layout_title_id";
  private static final String t = "layout_content_id";
  private static final String u = "layout_icon_id";
  private static final String v = "layout_icon_drawable_id";
  private String A;
  private String B;
  private String C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private String w;
  private String x;
  private int y;
  private int z;

  public UmengNotificationBuilder()
  {
    this.w = dl.b();
    this.y = 16;
    this.D = true;
    this.E = true;
    this.F = true;
    this.G = true;
    this.L = -1;
    this.K = -1;
    this.J = -1;
    this.I = -1;
    this.H = -1;
  }

  UmengNotificationBuilder(Cursor paramCursor)
  {
    int i2;
    int i3;
    label182: int i4;
    if (paramCursor != null)
    {
      this.w = paramCursor.getString(paramCursor.getColumnIndex("id"));
      this.x = paramCursor.getString(paramCursor.getColumnIndex("localnotification_id"));
      this.y = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      this.z = paramCursor.getInt(paramCursor.getColumnIndex("defaults"));
      this.A = paramCursor.getString(paramCursor.getColumnIndex("smallicon_drawable"));
      this.B = paramCursor.getString(paramCursor.getColumnIndex("largeicon_drawable"));
      this.C = paramCursor.getString(paramCursor.getColumnIndex("sound_drawable"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("play_vibrate")) != i1)
        break label329;
      i2 = i1;
      this.D = i2;
      if (paramCursor.getInt(paramCursor.getColumnIndex("play_lights")) != i1)
        break label334;
      i3 = i1;
      this.E = i3;
      if (paramCursor.getInt(paramCursor.getColumnIndex("play_sound")) != i1)
        break label340;
      i4 = i1;
      label209: this.F = i4;
      if (paramCursor.getInt(paramCursor.getColumnIndex("screen_on")) != i1)
        break label346;
    }
    while (true)
    {
      this.G = i1;
      this.H = paramCursor.getInt(paramCursor.getColumnIndex("layout_id"));
      this.I = paramCursor.getInt(paramCursor.getColumnIndex("layout_title_id"));
      this.J = paramCursor.getInt(paramCursor.getColumnIndex("layout_content_id"));
      this.K = paramCursor.getInt(paramCursor.getColumnIndex("layout_icon_id"));
      this.L = paramCursor.getInt(paramCursor.getColumnIndex("layout_icon_drawable_id"));
      return;
      label329: i2 = 0;
      break;
      label334: i3 = 0;
      break label182;
      label340: i4 = 0;
      break label209;
      label346: i1 = 0;
    }
  }

  UmengNotificationBuilder(String paramString)
  {
    this.w = dl.b();
    this.y = 16;
    this.D = true;
    this.E = true;
    this.F = true;
    this.G = true;
    this.L = -1;
    this.K = -1;
    this.J = -1;
    this.I = -1;
    this.H = -1;
    if (!TextUtils.isEmpty(paramString))
    {
      this.x = paramString;
      return;
    }
    this.x = "";
    a.b(b, "localNotificationId is null");
  }

  private PendingIntent a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, NotificationProxyBroadcastReceiver.class);
    localIntent.putExtra("ACTION", 12);
    return PendingIntent.getBroadcast(paramContext, (int)System.currentTimeMillis(), localIntent, 268435456);
  }

  private int b(Context paramContext)
  {
    boolean bool1 = f(paramContext);
    int i1 = 0;
    if (bool1);
    do
    {
      return i1;
      boolean bool2 = this.D;
      i1 = 0;
      if (bool2)
        i1 = 0x0 | (0x2 | this.z);
      if (this.E)
        i1 |= 0x4 | this.z;
      if (!this.F)
        continue;
      i1 |= 0x1 | this.z;
    }
    while (!this.G);
    g(paramContext);
    return i1;
  }

  // ERROR //
  private int c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 147	com/umeng/message/local/UmengNotificationBuilder:A	Ljava/lang/String;
    //   6: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +15 -> 24
    //   12: aload_1
    //   13: invokestatic 210	com/umeng/message/b/de:a	(Landroid/content/Context;)Lcom/umeng/message/b/de;
    //   16: aload_0
    //   17: getfield 147	com/umeng/message/local/UmengNotificationBuilder:A	Ljava/lang/String;
    //   20: invokevirtual 212	com/umeng/message/b/de:c	(Ljava/lang/String;)I
    //   23: istore_2
    //   24: iload_2
    //   25: ifge +13 -> 38
    //   28: aload_1
    //   29: invokestatic 210	com/umeng/message/b/de:a	(Landroid/content/Context;)Lcom/umeng/message/b/de;
    //   32: ldc 21
    //   34: invokevirtual 212	com/umeng/message/b/de:c	(Ljava/lang/String;)I
    //   37: istore_2
    //   38: iload_2
    //   39: ifge +67 -> 106
    //   42: getstatic 97	com/umeng/message/local/UmengNotificationBuilder:b	Ljava/lang/String;
    //   45: ldc 214
    //   47: invokestatic 216	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 222	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   54: aload_1
    //   55: invokevirtual 225	android/content/Context:getPackageName	()Ljava/lang/String;
    //   58: iconst_0
    //   59: invokevirtual 231	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   62: getfield 237	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   65: getfield 242	android/content/pm/ApplicationInfo:icon	I
    //   68: istore 4
    //   70: iload 4
    //   72: ifge +11 -> 83
    //   75: getstatic 97	com/umeng/message/local/UmengNotificationBuilder:b	Ljava/lang/String;
    //   78: ldc 244
    //   80: invokestatic 167	com/umeng/b/a/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: iload 4
    //   85: ireturn
    //   86: astore_3
    //   87: iload_2
    //   88: istore 4
    //   90: aload_3
    //   91: astore 5
    //   93: aload 5
    //   95: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   98: iload 4
    //   100: ireturn
    //   101: astore 5
    //   103: goto -10 -> 93
    //   106: iload_2
    //   107: istore 4
    //   109: goto -39 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	86	java/lang/Exception
    //   28	38	86	java/lang/Exception
    //   42	70	86	java/lang/Exception
    //   75	83	101	java/lang/Exception
  }

  private Bitmap d(Context paramContext)
  {
    int i3;
    if (0 == 0)
      i3 = -1;
    while (true)
    {
      try
      {
        if (TextUtils.isEmpty(this.B))
          continue;
        i3 = de.a(paramContext).c(this.B);
        if (i3 >= 0)
          continue;
        i3 = de.a(paramContext).c("umeng_push_notification_default_large_icon");
        if (i3 > 0)
        {
          localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), i3);
          if (localBitmap == null)
            break;
          if (Build.VERSION.SDK_INT < 11)
            continue;
          int i2 = (int)paramContext.getResources().getDimension(17104902);
          return Bitmap.createScaledBitmap(localBitmap, i2, i2, true);
          int i1 = el.a(64.0F);
          i2 = i1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      Bitmap localBitmap = null;
    }
    return null;
  }

  private Uri e(Context paramContext)
  {
    int i1 = -1;
    while (true)
    {
      try
      {
        if (TextUtils.isEmpty(this.C))
          continue;
        i1 = de.a(paramContext).c(this.C);
        if (i1 >= 0)
          continue;
        i1 = de.a(paramContext).h("umeng_push_notification_default_sound");
        if (i1 > 0)
        {
          str = "android.resource://" + paramContext.getPackageName() + "/" + i1;
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

  private boolean f(Context paramContext)
  {
    int i1 = Calendar.getInstance().get(11);
    int i2 = Calendar.getInstance().get(12);
    int i3;
    int i4;
    label78: int i5;
    if (i2 + i1 * 60 >= 60 * PushAgent.getInstance(paramContext).getNoDisturbStartHour() + PushAgent.getInstance(paramContext).getNoDisturbStartMinute())
    {
      i3 = 1;
      if (i2 + i1 * 60 > 60 * PushAgent.getInstance(paramContext).getNoDisturbEndHour() + PushAgent.getInstance(paramContext).getNoDisturbEndMinute())
        break label143;
      i4 = 1;
      if (60 * PushAgent.getInstance(paramContext).getNoDisturbEndHour() + PushAgent.getInstance(paramContext).getNoDisturbEndMinute() < 60 * PushAgent.getInstance(paramContext).getNoDisturbStartHour() + PushAgent.getInstance(paramContext).getNoDisturbStartMinute())
        break label149;
      i5 = 1;
      label120: if (i5 == 0)
        break label157;
      if ((i3 == 0) || (i4 == 0))
        break label155;
    }
    label143: label149: label155: label157: 
    do
    {
      return true;
      i3 = 0;
      break;
      i4 = 0;
      break label78;
      i5 = 0;
      break label120;
      return false;
    }
    while ((i3 != 0) || (i4 != 0));
    return false;
  }

  @SuppressLint({"NewApi", "Wakelock"})
  private void g(Context paramContext)
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 7);
      for (boolean bool = new UmengNotificationBuilder.1(this, localPowerManager).a(); ; bool = false)
      {
        a.c(b, "screen on................................." + bool);
        if (bool)
          break;
        localPowerManager.newWakeLock(805306374, "MyLock").acquire(10000L);
        return;
        a.c(b, "android os version < 7, skip checking screen on status");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public Notification builder(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    int i1 = c(paramContext);
    a.c(b, "title=" + paramString1);
    a.c(b, "smallIconId=" + i1);
    Object localObject = null;
    Bitmap localBitmap;
    boolean bool;
    if (i1 > 0)
    {
      localBuilder.setSmallIcon(i1);
      localBitmap = d(paramContext);
      if ((0x10 & this.y) == 0)
        break label325;
      bool = true;
      a.c(b, "flags=" + this.y);
      a.c(b, "isAutoCancel=" + bool);
      if ((this.H > 0) && (this.I > 0) && (this.J > 0) && (this.K > 0) && (this.L > 0))
        break label331;
      if (localBitmap != null)
        localBuilder.setLargeIcon(localBitmap);
      localBuilder.setContentTitle(paramString1).setContentText(paramString2).setTicker(paramString3).setAutoCancel(bool);
      NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
      localBigTextStyle.setBigContentTitle(paramString1);
      localBigTextStyle.bigText(paramString2);
      localBuilder.setStyle(localBigTextStyle);
      Notification localNotification = localBuilder.build();
      int i2 = b(paramContext);
      if ((i2 & 0x1) != 0)
      {
        Uri localUri = e(paramContext);
        if (localUri != null)
          localNotification.sound = localUri;
        if (localUri != null)
          i2 ^= 1;
      }
      localNotification.defaults = i2;
      localObject = localNotification;
    }
    while (true)
    {
      ((Notification)localObject).contentIntent = a(paramContext);
      return localObject;
      label325: bool = false;
      break;
      label331: RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.H);
      localRemoteViews.setTextViewText(this.I, paramString1);
      localRemoteViews.setTextViewText(this.J, paramString2);
      localRemoteViews.setImageViewBitmap(this.L, localBitmap);
      localRemoteViews.setImageViewResource(this.K, i1);
      localBuilder.setContent(localRemoteViews);
      localBuilder.setAutoCancel(bool);
      localObject = localBuilder.build();
      ((Notification)localObject).contentView = localRemoteViews;
    }
  }

  public ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", this.w);
    localContentValues.put("localnotification_id", this.x);
    localContentValues.put("flags", Integer.valueOf(this.y));
    localContentValues.put("defaults", Integer.valueOf(this.z));
    localContentValues.put("smallicon_drawable", this.A);
    localContentValues.put("largeicon_drawable", this.B);
    localContentValues.put("sound_drawable", this.C);
    localContentValues.put("play_vibrate", Boolean.valueOf(this.D));
    localContentValues.put("play_lights", Boolean.valueOf(this.E));
    localContentValues.put("play_sound", Boolean.valueOf(this.F));
    localContentValues.put("screen_on", Boolean.valueOf(this.G));
    localContentValues.put("layout_id", Integer.valueOf(this.H));
    localContentValues.put("layout_title_id", Integer.valueOf(this.I));
    localContentValues.put("layout_content_id", Integer.valueOf(this.J));
    localContentValues.put("layout_icon_id", Integer.valueOf(this.K));
    localContentValues.put("layout_icon_drawable_id", Integer.valueOf(this.L));
    return localContentValues;
  }

  public int getDefaults()
  {
    return this.z;
  }

  public int getFlags()
  {
    return this.y;
  }

  public String getId()
  {
    return this.w;
  }

  public String getLargeIconDrawable()
  {
    return this.B;
  }

  public int getLayoutContentId()
  {
    return this.J;
  }

  public int getLayoutIconDrawableId()
  {
    return this.L;
  }

  public int getLayoutIconId()
  {
    return this.K;
  }

  public int getLayoutId()
  {
    return this.H;
  }

  public int getLayoutTitleId()
  {
    return this.I;
  }

  public String getLocalNotificationId()
  {
    return this.x;
  }

  public String getSmallIconDrawable()
  {
    return this.A;
  }

  public String getSoundDrawable()
  {
    return this.C;
  }

  public boolean isPlayLights()
  {
    return this.E;
  }

  public boolean isPlaySound()
  {
    return this.F;
  }

  public boolean isPlayVibrate()
  {
    return this.D;
  }

  public boolean isScreenOn()
  {
    return this.G;
  }

  public void setDefaults(int paramInt)
  {
    this.z = paramInt;
  }

  public void setFlags(int paramInt)
  {
    this.y = paramInt;
  }

  public void setId(String paramString)
  {
    this.w = paramString;
  }

  public void setLargeIconDrawable(String paramString)
  {
    this.B = paramString;
  }

  public void setLayoutContentId(int paramInt)
  {
    this.J = paramInt;
  }

  public void setLayoutIconDrawableId(int paramInt)
  {
    this.L = paramInt;
  }

  public void setLayoutIconId(int paramInt)
  {
    this.K = paramInt;
  }

  public void setLayoutId(int paramInt)
  {
    this.H = paramInt;
  }

  public void setLayoutTitleId(int paramInt)
  {
    this.I = paramInt;
  }

  public void setLocalNotificationId(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.x = paramString;
      return;
    }
    this.x = "";
    a.b(b, "localNotificationId is null");
  }

  public void setPlayLights(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }

  public void setPlaySound(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }

  public void setPlayVibrate(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }

  public void setScreenOn(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void setSmallIconDrawable(String paramString)
  {
    this.A = paramString;
  }

  public void setSoundDrawable(String paramString)
  {
    this.C = paramString;
  }

  public void showNotification(Context paramContext, Notification paramNotification)
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      try
      {
        int i2;
        if (!PushAgent.getInstance(paramContext).getMergeNotificaiton())
          i2 = new Random().nextInt();
        for (i1 = i2; ; i1 = 20100401)
        {
          if ((!dl.c(paramContext)) || (!dl.b(paramContext)) || (PushAgent.getInstance(paramContext).getNotificationOnForeground()))
            localNotificationManager.notify(i1, paramNotification);
          return;
          if ((dl.c(paramContext)) && (dl.b(paramContext)) && (!PushAgent.getInstance(paramContext).getNotificationOnForeground()))
            break;
          localNotificationManager.cancel(20100401);
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          localException2.printStackTrace();
          int i1 = 20100401;
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengNotificationBuilder
 * JD-Core Version:    0.6.0
 */