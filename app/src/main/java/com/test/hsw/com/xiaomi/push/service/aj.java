package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.f.a.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aj
{
  public static long a = 0L;
  private static LinkedList<Pair<Integer, String>> b = new LinkedList();

  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equals(paramContext.getPackageName()))
      return paramContext.getResources().getIdentifier(paramString2, "drawable", paramString1);
    return 0;
  }

  private static Notification a(Notification paramNotification, String paramString)
  {
    try
    {
      Field localField = Notification.class.getDeclaredField("extraNotification");
      localField.setAccessible(true);
      Object localObject = localField.get(paramNotification);
      Method localMethod = localObject.getClass().getDeclaredMethod("setTargetPkg", new Class[] { CharSequence.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, new Object[] { paramString });
      return paramNotification;
    }
    catch (Exception localException)
    {
      com.xiaomi.a.a.c.c.a(localException);
    }
    return paramNotification;
  }

  @SuppressLint({"NewApi"})
  private static Notification a(Context paramContext, h paramh, byte[] paramArrayOfByte, RemoteViews paramRemoteViews, PendingIntent paramPendingIntent)
  {
    com.xiaomi.f.a.c localc = paramh.m();
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    String[] arrayOfString = a(paramContext, localc);
    localBuilder.setContentTitle(arrayOfString[0]);
    localBuilder.setContentText(arrayOfString[1]);
    label126: Map localMap;
    int k;
    if (paramRemoteViews != null)
    {
      localBuilder.setContent(paramRemoteViews);
      localBuilder.setWhen(System.currentTimeMillis());
      localBuilder.setContentIntent(paramPendingIntent);
      int i = a(paramContext, a(paramh), "mipush_notification");
      int j = a(paramContext, a(paramh), "mipush_small_notification");
      if ((i <= 0) || (j <= 0))
        break label356;
      localBuilder.setLargeIcon(a(paramContext, i));
      localBuilder.setSmallIcon(j);
      localBuilder.setAutoCancel(true);
      long l = System.currentTimeMillis();
      localMap = localc.s();
      if ((localMap != null) && (localMap.containsKey("ticker")))
        localBuilder.setTicker((CharSequence)localMap.get("ticker"));
      if (l - a > 10000L)
      {
        a = l;
        k = localc.f;
        if (!e(paramContext, a(paramh)))
          break label373;
      }
    }
    label356: label373: for (int m = c(paramContext, a(paramh)); ; m = k)
    {
      localBuilder.setDefaults(m);
      if ((localMap != null) && ((m & 0x1) != 0))
      {
        String str = (String)localMap.get("sound_uri");
        if ((!TextUtils.isEmpty(str)) && (str.startsWith("android.resource://" + a(paramh))))
        {
          localBuilder.setDefaults(m ^ 0x1);
          localBuilder.setSound(Uri.parse(str));
        }
      }
      return localBuilder.getNotification();
      if (Build.VERSION.SDK_INT < 16)
        break;
      localBuilder.setStyle(new Notification.BigTextStyle().bigText(arrayOfString[1]));
      break;
      localBuilder.setSmallIcon(f(paramContext, a(paramh)));
      break label126;
    }
  }

  private static PendingIntent a(Context paramContext, h paramh, com.xiaomi.f.a.c paramc, byte[] paramArrayOfByte)
  {
    if ((paramc != null) && (!TextUtils.isEmpty(paramc.g)))
    {
      Intent localIntent3 = new Intent("android.intent.action.VIEW");
      localIntent3.setData(Uri.parse(paramc.g));
      localIntent3.addFlags(268435456);
      return PendingIntent.getActivity(paramContext, 0, localIntent3, 134217728);
    }
    if (b(paramh))
    {
      Intent localIntent1 = new Intent();
      localIntent1.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
      localIntent1.putExtra("mipush_payload", paramArrayOfByte);
      localIntent1.putExtra("mipush_notified", true);
      localIntent1.addCategory(String.valueOf(paramc.q()));
      return PendingIntent.getService(paramContext, 0, localIntent1, 134217728);
    }
    Intent localIntent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent2.setComponent(new ComponentName(paramh.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
    localIntent2.putExtra("mipush_payload", paramArrayOfByte);
    localIntent2.putExtra("mipush_notified", true);
    localIntent2.addCategory(String.valueOf(paramc.q()));
    return PendingIntent.getService(paramContext, 0, localIntent2, 134217728);
  }

  private static Bitmap a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDrawable(paramInt));
  }

  public static Bitmap a(Drawable paramDrawable)
  {
    int i = 1;
    if ((paramDrawable instanceof BitmapDrawable))
      return ((BitmapDrawable)paramDrawable).getBitmap();
    int j = paramDrawable.getIntrinsicWidth();
    if (j > 0);
    while (true)
    {
      int k = paramDrawable.getIntrinsicHeight();
      if (k > 0)
        i = k;
      Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      j = i;
    }
  }

  static String a(h paramh)
  {
    if ("com.xiaomi.xmsf".equals(paramh.f))
    {
      com.xiaomi.f.a.c localc = paramh.m();
      if ((localc != null) && (localc.s() != null))
      {
        String str = (String)localc.s().get("miui_package_name");
        if (!TextUtils.isEmpty(str))
          return str;
      }
    }
    return paramh.f;
  }

  public static void a(Context paramContext, h paramh, byte[] paramArrayOfByte)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    com.xiaomi.f.a.c localc = paramh.m();
    RemoteViews localRemoteViews = b(paramContext, paramh, paramArrayOfByte);
    PendingIntent localPendingIntent = a(paramContext, paramh, localc, paramArrayOfByte);
    if (localPendingIntent == null)
    {
      com.xiaomi.a.a.c.c.a("The click PendingIntent is null. ");
      return;
    }
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 11)
      localObject1 = a(paramContext, paramh, paramArrayOfByte, localRemoteViews, localPendingIntent);
    while (true)
    {
      if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
        a((Notification)localObject1, a(paramh));
      int i = localc.q() + 10 * (a(paramh).hashCode() / 10);
      localNotificationManager.notify(i, (Notification)localObject1);
      Pair localPair = new Pair(Integer.valueOf(i), a(paramh));
      synchronized (b)
      {
        b.add(localPair);
        if (b.size() > 100)
          b.remove();
        return;
      }
      Notification localNotification = new Notification(f(paramContext, a(paramh)), null, System.currentTimeMillis());
      String[] arrayOfString = a(paramContext, localc);
      try
      {
        Method localMethod = localNotification.getClass().getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class });
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramContext;
        arrayOfObject[1] = arrayOfString[0];
        arrayOfObject[2] = arrayOfString[1];
        arrayOfObject[3] = localPendingIntent;
        localMethod.invoke(localNotification, arrayOfObject);
        Map localMap = localc.s();
        if ((localMap != null) && (localMap.containsKey("ticker")))
          localNotification.tickerText = ((CharSequence)localMap.get("ticker"));
        long l = System.currentTimeMillis();
        if (l - a > 10000L)
        {
          a = l;
          j = localc.f;
          if (!e(paramContext, a(paramh)))
            break label548;
          k = c(paramContext, a(paramh));
          localNotification.defaults = k;
          if ((localMap != null) && ((k & 0x1) != 0))
          {
            String str = (String)localMap.get("sound_uri");
            if ((!TextUtils.isEmpty(str)) && (str.startsWith("android.resource://" + a(paramh))))
            {
              localNotification.defaults = (k ^ 0x1);
              localNotification.sound = Uri.parse(str);
            }
          }
        }
        localNotification.flags = (0x10 | localNotification.flags);
        if (localRemoteViews != null)
          localNotification.contentView = localRemoteViews;
        localObject1 = localNotification;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        while (true)
          com.xiaomi.a.a.c.c.a(localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        while (true)
          com.xiaomi.a.a.c.c.a(localIllegalAccessException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          com.xiaomi.a.a.c.c.a(localIllegalArgumentException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        while (true)
        {
          int j;
          com.xiaomi.a.a.c.c.a(localInvocationTargetException);
          continue;
          label548: int k = j;
        }
      }
    }
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    int i = paramInt + 10 * (paramString.hashCode() / 10);
    localNotificationManager.cancel(i);
    synchronized (b)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if ((i != ((Integer)localPair.first).intValue()) || (!TextUtils.equals(paramString, (CharSequence)localPair.second)))
          continue;
        b.remove(localPair);
      }
      return;
    }
  }

  public static boolean a(Context paramContext, String paramString)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if ((localRunningAppProcessInfo.importance == 100) && (Arrays.asList(localRunningAppProcessInfo.pkgList).contains(paramString)))
          return true;
      }
    }
    return false;
  }

  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (!paramMap.containsKey("notify_foreground")))
      return true;
    return "1".equals((String)paramMap.get("notify_foreground"));
  }

  private static String[] a(Context paramContext, com.xiaomi.f.a.c paramc)
  {
    Object localObject1 = paramc.h();
    Object localObject2 = paramc.j();
    Map localMap = paramc.s();
    int j;
    Object localObject3;
    if (localMap != null)
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      float f = paramContext.getResources().getDisplayMetrics().density;
      j = Float.valueOf(0.5F + i / f).intValue();
      if (j > 320)
        break label136;
      String str3 = (String)localMap.get("title_short");
      if (!TextUtils.isEmpty(str3))
        localObject1 = str3;
      localObject3 = (String)localMap.get("description_short");
      if (TextUtils.isEmpty((CharSequence)localObject3))
        break label199;
    }
    while (true)
    {
      localObject2 = localObject3;
      while (true)
      {
        return new String[] { localObject1, localObject2 };
        label136: if (j <= 360)
          continue;
        String str1 = (String)localMap.get("title_long");
        if (!TextUtils.isEmpty(str1))
          localObject1 = str1;
        String str2 = (String)localMap.get("description_long");
        if (TextUtils.isEmpty(str2))
          continue;
        localObject2 = str2;
      }
      label199: localObject3 = localObject2;
    }
  }

  private static RemoteViews b(Context paramContext, h paramh, byte[] paramArrayOfByte)
  {
    com.xiaomi.f.a.c localc = paramh.m();
    String str1 = a(paramh);
    Map localMap = localc.s();
    if (localMap == null)
      return null;
    String str2 = (String)localMap.get("layout_name");
    String str3 = (String)localMap.get("layout_value");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
      return null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    Resources localResources;
    int i;
    try
    {
      localResources = localPackageManager.getResourcesForApplication(str1);
      i = localResources.getIdentifier(str2, "layout", str1);
      if (i == 0)
        return null;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      com.xiaomi.a.a.c.c.a(localNameNotFoundException);
      return null;
    }
    RemoteViews localRemoteViews = new RemoteViews(str1, i);
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject(str3);
      if (localJSONObject1.has("text"))
      {
        JSONObject localJSONObject4 = localJSONObject1.getJSONObject("text");
        Iterator localIterator3 = localJSONObject4.keys();
        while (localIterator3.hasNext())
        {
          String str8 = (String)localIterator3.next();
          String str9 = localJSONObject4.getString(str8);
          int n = localResources.getIdentifier(str8, "id", str1);
          if (n <= 0)
            continue;
          localRemoteViews.setTextViewText(n, str9);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      com.xiaomi.a.a.c.c.a(localJSONException);
      return null;
    }
    if (localJSONObject1.has("image"))
    {
      JSONObject localJSONObject3 = localJSONObject1.getJSONObject("image");
      Iterator localIterator2 = localJSONObject3.keys();
      while (localIterator2.hasNext())
      {
        String str6 = (String)localIterator2.next();
        String str7 = localJSONObject3.getString(str6);
        int k = localResources.getIdentifier(str6, "id", str1);
        int m = localResources.getIdentifier(str7, "drawable", str1);
        if (k <= 0)
          continue;
        localRemoteViews.setImageViewResource(k, m);
      }
    }
    if (localJSONObject1.has("time"))
    {
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("time");
      Iterator localIterator1 = localJSONObject2.keys();
      while (localIterator1.hasNext())
      {
        String str4 = (String)localIterator1.next();
        String str5 = localJSONObject2.getString(str4);
        if (str5.length() == 0)
          str5 = "yy-MM-dd hh:mm";
        int j = localResources.getIdentifier(str4, "id", str1);
        if (j <= 0)
          continue;
        long l = System.currentTimeMillis();
        localRemoteViews.setTextViewText(j, new SimpleDateFormat(str5).format(new Date(l)));
      }
    }
    return localRemoteViews;
  }

  public static void b(Context paramContext, String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    synchronized (b)
    {
      Iterator localIterator = ((LinkedList)b.clone()).iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (!TextUtils.equals((CharSequence)localPair.second, paramString))
          continue;
        localNotificationManager.cancel(((Integer)localPair.first).intValue());
        b.remove(localPair);
      }
    }
    monitorexit;
  }

  static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().putInt(paramString, paramInt).commit();
  }

  public static boolean b(h paramh)
  {
    com.xiaomi.f.a.c localc = paramh.m();
    return (localc != null) && (localc.v());
  }

  static int c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).getInt(paramString, 2147483647);
  }

  static void d(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().remove(paramString).commit();
  }

  static boolean e(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).contains(paramString);
  }

  private static int f(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "mipush_notification");
    int j = a(paramContext, paramString, "mipush_small_notification");
    if (i > 0);
    while (true)
    {
      if ((i == 0) && (Build.VERSION.SDK_INT >= 9))
        i = paramContext.getApplicationInfo().logo;
      return i;
      if (j > 0)
      {
        i = j;
        continue;
      }
      i = paramContext.getApplicationInfo().icon;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.aj
 * JD-Core Version:    0.6.0
 */