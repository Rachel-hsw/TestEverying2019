package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.f.a.o;
import com.xiaomi.f.a.q;
import com.xiaomi.f.a.s;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public abstract class d
{
  public static final String a = "register";
  public static final String b = "set-alias";
  public static final String c = "unset-alias";
  public static final String d = "set-account";
  public static final String e = "unset-account";
  public static final String f = "subscribe-topic";
  public static final String g = "unsubscibe-topic";
  public static final String h = "accept-time";
  public static final String i = ",";
  private static boolean j = true;
  private static Context k;
  private static long l = System.currentTimeMillis();

  protected static String a()
  {
    monitorenter;
    try
    {
      String str = com.xiaomi.a.a.g.d.a(4) + l;
      l = 1L + l;
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void a(Context paramContext, int paramInt)
  {
    int m = paramInt & 0xFFFFFFFF;
    n.a(paramContext).b(m);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 24) || (paramInt3 < 0) || (paramInt3 >= 24) || (paramInt2 < 0) || (paramInt2 >= 60) || (paramInt4 < 0) || (paramInt4 >= 60))
      throw new IllegalArgumentException("the input parameter is not valid.");
    TimeZone localTimeZone1 = TimeZone.getTimeZone("GMT+08");
    TimeZone localTimeZone2 = TimeZone.getDefault();
    long l1 = (localTimeZone1.getRawOffset() - localTimeZone2.getRawOffset()) / 1000 / 60;
    long l2 = (1440L + (l1 + (paramInt2 + paramInt1 * 60))) % 1440L;
    long l3 = (1440L + (l1 + (paramInt4 + paramInt3 * 60))) % 1440L;
    ArrayList localArrayList1 = new ArrayList();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Long.valueOf(l2 / 60L);
    arrayOfObject1[1] = Long.valueOf(l2 % 60L);
    localArrayList1.add(String.format("%1$02d:%2$02d", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Long.valueOf(l3 / 60L);
    arrayOfObject2[1] = Long.valueOf(l3 % 60L);
    localArrayList1.add(String.format("%1$02d:%2$02d", arrayOfObject2));
    ArrayList localArrayList2 = new ArrayList();
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Integer.valueOf(paramInt1);
    arrayOfObject3[1] = Integer.valueOf(paramInt2);
    localArrayList2.add(String.format("%1$02d:%2$02d", arrayOfObject3));
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Integer.valueOf(paramInt3);
    arrayOfObject4[1] = Integer.valueOf(paramInt4);
    localArrayList2.add(String.format("%1$02d:%2$02d", arrayOfObject4));
    if (i(paramContext, (String)localArrayList1.get(0), (String)localArrayList1.get(1)))
    {
      if (1 == g.a(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString, "accept-time", 0L, null, localArrayList2);
        return;
      }
      g.a(paramContext, g.a("accept-time", localArrayList2, 0L, null, null));
      return;
    }
    a(paramContext, "accept-time", localArrayList1, paramString);
  }

  private static void a(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashSet localHashSet = new HashSet();
    String str1 = paramContext.getPackageName() + ".permission.MIPUSH_RECEIVE";
    localHashSet.addAll(Arrays.asList(new String[] { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str1, "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.GET_TASKS", "android.permission.VIBRATE" }));
    int i3;
    if (paramPackageInfo.permissions != null)
    {
      PermissionInfo[] arrayOfPermissionInfo = paramPackageInfo.permissions;
      int i2 = arrayOfPermissionInfo.length;
      i3 = 0;
      if (i3 < i2)
        if (!str1.equals(arrayOfPermissionInfo[i3].name));
    }
    for (int m = 1; ; m = 0)
    {
      if (m == 0)
      {
        throw new b(String.format("<permission android:name=\"%1$s\" /> is undefined.", new Object[] { str1 }), null);
        i3++;
        break;
      }
      String[] arrayOfString;
      int n;
      if (paramPackageInfo.requestedPermissions != null)
      {
        arrayOfString = paramPackageInfo.requestedPermissions;
        n = arrayOfString.length;
      }
      for (int i1 = 0; ; i1++)
      {
        if (i1 < n)
        {
          String str2 = arrayOfString[i1];
          if ((TextUtils.isEmpty(str2)) || (!localHashSet.contains(str2)))
            continue;
          localHashSet.remove(str2);
          if (!localHashSet.isEmpty())
            continue;
        }
        if (localHashSet.isEmpty())
          break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localHashSet.iterator().next();
        throw new b(String.format("<use-permission android:name=\"%1$s\" /> is missing.", arrayOfObject), null);
      }
      return;
    }
  }

  public static void a(Context paramContext, f paramf)
  {
    com.xiaomi.f.a.c localc = new com.xiaomi.f.a.c();
    localc.a(paramf.a());
    localc.b(paramf.g());
    localc.d(paramf.k());
    localc.c(paramf.l());
    localc.c(paramf.i());
    localc.a(paramf.h());
    localc.b(paramf.n());
    localc.a(paramf.o());
    a(paramContext, paramf.a(), localc, null);
  }

  @Deprecated
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null);
  }

  static void a(Context paramContext, String paramString1, com.xiaomi.f.a.c paramc, String paramString2)
  {
    com.xiaomi.f.a.i locali = new com.xiaomi.f.a.i();
    if (TextUtils.isEmpty(paramString2))
      if (h.a(paramContext).b())
        locali.b(h.a(paramContext).c());
    while (true)
    {
      locali.c("bar:click");
      locali.a(paramString1);
      locali.a(false);
      n.a(paramContext).a(locali, com.xiaomi.f.a.a.i, false, paramc);
      return;
      com.xiaomi.a.a.c.c.d("do not report clicked message");
      return;
      locali.b(paramString2);
    }
  }

  static void a(Context paramContext, String paramString1, com.xiaomi.f.a.c paramc, String paramString2, String paramString3)
  {
    com.xiaomi.f.a.i locali = new com.xiaomi.f.a.i();
    if (TextUtils.isEmpty(paramString3))
    {
      com.xiaomi.a.a.c.c.d("do not report clicked message");
      return;
    }
    locali.b(paramString3);
    locali.c("bar:click");
    locali.a(paramString1);
    locali.a(false);
    n.a(paramContext).a(locali, com.xiaomi.f.a.a.i, false, true, paramc, true, paramString2, paramString3);
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    new Thread(new i(paramContext, paramString1, paramString2)).start();
  }

  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, a parama)
  {
    a(paramContext, "context");
    a(paramString1, "appID");
    a(paramString2, "appToken");
    while (true)
    {
      boolean bool;
      try
      {
        k = paramContext.getApplicationContext();
        if (k != null)
          continue;
        k = paramContext;
        if (parama == null)
          continue;
        PushMessageHandler.a(parama);
        int m = h.a(k).m();
        int n = a.a();
        bool = false;
        if (m == n)
          continue;
        bool = true;
        if ((bool) || (q(k)))
          continue;
        n.a(paramContext).a();
        com.xiaomi.a.a.c.c.a("Could not send  register message within 5s repeatly .");
        return;
        if ((bool) || (!h.a(k).a(paramString1, paramString2)) || (h.a(k).n()))
          break label498;
        if (1 == g.a(paramContext))
        {
          a(parama, "callback");
          parama.a(0L, null, h.a(paramContext).e());
          n.a(paramContext).a();
          if (!h.a(k).a())
            continue;
          com.xiaomi.f.a.i locali1 = new com.xiaomi.f.a.i();
          locali1.b(h.a(paramContext).c());
          locali1.c("client_info_update");
          locali1.a(a());
          locali1.h = new HashMap();
          locali1.h.put("app_version", h.a(k, k.getPackageName()));
          String str2 = h.a(k).g();
          if (TextUtils.isEmpty(str2))
            continue;
          locali1.h.put("deviceid", str2);
          n.a(paramContext).a(locali1, com.xiaomi.f.a.a.i, false, null);
          if (com.xiaomi.a.a.a.a.a(k, "update_devId", false))
            continue;
          c();
          com.xiaomi.a.a.a.a.b(k, "update_devId", true);
          if ((!a(k)) || (!o(k)))
            continue;
          com.xiaomi.f.a.i locali2 = new com.xiaomi.f.a.i();
          locali2.b(h.a(k).c());
          locali2.c("pull");
          locali2.a(a());
          locali2.a(false);
          n.a(k).a(locali2, com.xiaomi.f.a.a.i, false, null, false);
          n(k);
          if (!j)
            continue;
          l(k);
          p(k);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.xiaomi.a.a.c.c.a(localThrowable);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(h.a(paramContext).e());
      e locale = g.a("register", localArrayList, 0L, null, null);
      g.a(k, locale);
      continue;
      label498: String str1 = com.xiaomi.a.a.g.d.a(6);
      h.a(k).h();
      h.a(k).a(a.a());
      h.a(k).a(paramString1, paramString2, str1);
      e(k);
      com.xiaomi.f.a.j localj = new com.xiaomi.f.a.j();
      localj.a(a());
      localj.b(paramString1);
      localj.e(paramString2);
      localj.d(paramContext.getPackageName());
      localj.f(str1);
      localj.c(h.a(paramContext, paramContext.getPackageName()));
      n.a(k).a(localj, bool);
    }
  }

  protected static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2))
      localArrayList.add(paramString2);
    if (("set-alias".equalsIgnoreCase(paramString1)) && (System.currentTimeMillis() - l(paramContext, paramString2) < 3600000L))
    {
      if (1 == g.a(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString3, paramString1, 0L, null, localArrayList);
        return;
      }
      g.a(paramContext, g.a("set-alias", localArrayList, 0L, null, null));
      return;
    }
    if (("unset-alias".equalsIgnoreCase(paramString1)) && (l(paramContext, paramString2) < 0L))
    {
      com.xiaomi.a.a.c.c.a("Don't cancel alias for " + localArrayList + " is unseted");
      return;
    }
    if (("set-account".equalsIgnoreCase(paramString1)) && (System.currentTimeMillis() - k(paramContext, paramString2) < 3600000L))
    {
      if (1 == g.a(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString3, paramString1, 0L, null, localArrayList);
        return;
      }
      g.a(paramContext, g.a("set-account", localArrayList, 0L, null, null));
      return;
    }
    if (("unset-account".equalsIgnoreCase(paramString1)) && (k(paramContext, paramString2) < 0L))
    {
      com.xiaomi.a.a.c.c.a("Don't cancel account for " + localArrayList + " is unseted");
      return;
    }
    a(paramContext, paramString1, localArrayList, paramString3);
  }

  protected static void a(Context paramContext, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    if (TextUtils.isEmpty(h.a(paramContext).c()))
      return;
    com.xiaomi.f.a.f localf = new com.xiaomi.f.a.f();
    localf.a(a());
    localf.b(h.a(paramContext).c());
    localf.c(paramString1);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      localf.d((String)localIterator.next());
    localf.f(paramString2);
    localf.e(paramContext.getPackageName());
    n.a(paramContext).a(localf, com.xiaomi.f.a.a.j, null);
  }

  private static void a(PackageManager paramPackageManager, Intent paramIntent, Class<?> paramClass, Boolean[] paramArrayOfBoolean)
  {
    Iterator localIterator = paramPackageManager.queryBroadcastReceivers(paramIntent, 16384).iterator();
    while (true)
      if (localIterator.hasNext())
      {
        ActivityInfo localActivityInfo = ((ResolveInfo)localIterator.next()).activityInfo;
        if ((localActivityInfo == null) || (!paramClass.getCanonicalName().equals(localActivityInfo.name)))
          continue;
        if (paramArrayOfBoolean[0].booleanValue() != localActivityInfo.enabled)
        {
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localActivityInfo.name;
          arrayOfObject3[1] = paramArrayOfBoolean[0];
          throw new b(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:enabled should be %<b.", arrayOfObject3), localActivityInfo);
        }
        if (paramArrayOfBoolean[1].booleanValue() == localActivityInfo.exported)
          break;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = localActivityInfo.name;
        arrayOfObject2[1] = paramArrayOfBoolean[1];
        throw new b(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:exported should be %<b.", arrayOfObject2), localActivityInfo);
      }
    for (int m = 1; ; m = 0)
    {
      if (m == 0)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramClass.getCanonicalName();
        throw new b(String.format("<receiver android:name=\"%1$s\" /> is missing or disabled.", arrayOfObject1), null);
      }
      return;
    }
  }

  private static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("param " + paramString + " is not nullable");
  }

  public static boolean a(Context paramContext)
  {
    return n.a(paramContext).b();
  }

  public static List<String> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith("alias_"))
        continue;
      localArrayList.add(str.substring("alias_".length()));
    }
    return localArrayList;
  }

  public static void b(Context paramContext, int paramInt)
  {
    n.a(paramContext).a(paramInt);
  }

  private static void b(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashMap localHashMap = new HashMap();
    Boolean[] arrayOfBoolean1 = new Boolean[2];
    arrayOfBoolean1[0] = Boolean.valueOf(true);
    arrayOfBoolean1[1] = Boolean.valueOf(false);
    localHashMap.put("com.xiaomi.push.service.XMPushService", arrayOfBoolean1);
    String str1 = PushMessageHandler.class.getCanonicalName();
    Boolean[] arrayOfBoolean2 = new Boolean[2];
    arrayOfBoolean2[0] = Boolean.valueOf(true);
    arrayOfBoolean2[1] = Boolean.valueOf(true);
    localHashMap.put(str1, arrayOfBoolean2);
    String str2 = MessageHandleService.class.getCanonicalName();
    Boolean[] arrayOfBoolean3 = new Boolean[2];
    arrayOfBoolean3[0] = Boolean.valueOf(true);
    arrayOfBoolean3[1] = Boolean.valueOf(false);
    localHashMap.put(str2, arrayOfBoolean3);
    ServiceInfo[] arrayOfServiceInfo;
    int m;
    if (paramPackageInfo.services != null)
    {
      arrayOfServiceInfo = paramPackageInfo.services;
      m = arrayOfServiceInfo.length;
    }
    for (int n = 0; ; n++)
    {
      if (n < m)
      {
        ServiceInfo localServiceInfo = arrayOfServiceInfo[n];
        if ((TextUtils.isEmpty(localServiceInfo.name)) || (!localHashMap.containsKey(localServiceInfo.name)))
          continue;
        Boolean[] arrayOfBoolean4 = (Boolean[])localHashMap.remove(localServiceInfo.name);
        if (arrayOfBoolean4[0].booleanValue() != localServiceInfo.enabled)
        {
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localServiceInfo.name;
          arrayOfObject3[1] = arrayOfBoolean4[0];
          throw new b(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:enabled should be %<b.", arrayOfObject3), localServiceInfo);
        }
        if (arrayOfBoolean4[1].booleanValue() != localServiceInfo.exported)
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = localServiceInfo.name;
          arrayOfObject2[1] = arrayOfBoolean4[1];
          throw new b(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:exported should be %<b.", arrayOfObject2), localServiceInfo);
        }
        if (!localHashMap.isEmpty())
          continue;
      }
      if (localHashMap.isEmpty())
        break;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localHashMap.keySet().iterator().next();
      throw new b(String.format("<service android:name=\"%1$s\" /> is missing or disabled.", arrayOfObject1), null);
    }
  }

  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, 0, 0, 0, 0, paramString);
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
      a(paramContext, "set-alias", paramString1, paramString2);
  }

  public static List<String> c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!str.startsWith("topic_")) || (str.contains("**ALL**")))
        continue;
      localArrayList.add(str.substring("topic_".length()));
    }
    return localArrayList;
  }

  private static void c()
  {
    new Thread(new j()).start();
  }

  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, 0, 0, 23, 59, paramString);
  }

  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, "unset-alias", paramString1, paramString2);
  }

  public static List<String> d(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith("account_"))
        continue;
      localArrayList.add(str.substring("account_".length()));
    }
    return localArrayList;
  }

  static void d(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + paramString, System.currentTimeMillis()).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
      a(paramContext, "set-account", paramString1, paramString2);
  }

  protected static void e(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    long l1 = localSharedPreferences.getLong("wake_up", 0L);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.clear();
    if (l1 > 0L)
      localEditor.putLong("wake_up", l1);
    localEditor.commit();
  }

  static void e(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + paramString).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, "unset-account", paramString1, paramString2);
  }

  static void f(Context paramContext)
  {
    if (!h.a(paramContext).i())
      return;
    String str1 = com.xiaomi.a.a.g.d.a(6);
    String str2 = h.a(paramContext).c();
    String str3 = h.a(paramContext).d();
    h.a(paramContext).h();
    h.a(paramContext).a(str2, str3, str1);
    com.xiaomi.f.a.j localj = new com.xiaomi.f.a.j();
    localj.a(a());
    localj.b(str2);
    localj.e(str3);
    localj.f(str1);
    localj.d(paramContext.getPackageName());
    localj.c(h.a(paramContext, paramContext.getPackageName()));
    n.a(paramContext).a(localj, false);
  }

  static void f(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + paramString, System.currentTimeMillis()).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void f(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(h.a(paramContext).c())) || (TextUtils.isEmpty(paramString1)))
      return;
    if (System.currentTimeMillis() - j(paramContext, paramString1) > 86400000L)
    {
      o localo = new o();
      localo.a(a());
      localo.b(h.a(paramContext).c());
      localo.c(paramString1);
      localo.d(paramContext.getPackageName());
      localo.e(paramString2);
      n.a(paramContext).a(localo, com.xiaomi.f.a.a.c, null);
      return;
    }
    if (1 == g.a(paramContext))
    {
      PushMessageHandler.a(paramContext, paramString2, 0L, null, paramString1);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    g.a(paramContext, g.a("subscribe-topic", localArrayList, 0L, null, null));
  }

  public static void g(Context paramContext)
  {
    n.a(paramContext).e();
  }

  static void g(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + paramString).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void g(Context paramContext, String paramString1, String paramString2)
  {
    if (!h.a(paramContext).b())
      return;
    if (j(paramContext, paramString1) < 0L)
    {
      com.xiaomi.a.a.c.c.a("Don't cancel subscribe for " + paramString1 + " is unsubscribed");
      return;
    }
    s locals = new s();
    locals.a(a());
    locals.b(h.a(paramContext).c());
    locals.c(paramString1);
    locals.d(paramContext.getPackageName());
    locals.e(paramString2);
    n.a(paramContext).a(locals, com.xiaomi.f.a.a.d, null);
  }

  public static void h(Context paramContext)
  {
    if (!h.a(paramContext).b())
      return;
    q localq = new q();
    localq.a(a());
    localq.b(h.a(paramContext).c());
    localq.c(h.a(paramContext).e());
    localq.e(h.a(paramContext).d());
    localq.d(paramContext.getPackageName());
    n.a(paramContext).a(localq);
    PushMessageHandler.a();
    h.a(paramContext).k();
    e(paramContext);
    g(paramContext);
    i(paramContext);
  }

  static void h(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + paramString, System.currentTimeMillis()).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  static void h(Context paramContext, String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putString("accept_time", paramString1 + "," + paramString2).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void i(Context paramContext)
  {
    n.a(paramContext).a(-1);
  }

  static void i(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + paramString).commit();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static boolean i(Context paramContext, String paramString1, String paramString2)
  {
    return TextUtils.equals(paramContext.getSharedPreferences("mipush_extra", 0).getString("accept_time", ""), paramString1 + "," + paramString2);
  }

  public static long j(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("topic_" + paramString, -1L);
  }

  public static String j(Context paramContext)
  {
    if (h.a(paramContext).i())
      return h.a(paramContext).e();
    return null;
  }

  public static long k(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("account_" + paramString, -1L);
  }

  public static void k(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4100);
      m(paramContext);
      b(paramContext, localPackageInfo);
      a(paramContext, localPackageInfo);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      com.xiaomi.a.a.c.c.a(localNameNotFoundException);
    }
  }

  public static long l(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("alias_" + paramString, -1L);
  }

  private static void l(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    if (System.currentTimeMillis() - 86400000L < localSharedPreferences.getLong("wake_up", 0L))
      return;
    localSharedPreferences.edit().putLong("wake_up", System.currentTimeMillis()).commit();
    new Thread(new k(paramContext)).start();
  }

  private static void m(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    Intent localIntent1 = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
    localIntent1.setPackage(str);
    Boolean[] arrayOfBoolean1 = new Boolean[2];
    arrayOfBoolean1[0] = Boolean.valueOf(true);
    arrayOfBoolean1[1] = Boolean.valueOf(true);
    a(localPackageManager, localIntent1, NetworkStatusReceiver.class, arrayOfBoolean1);
    Intent localIntent2 = new Intent(ap.o);
    localIntent2.setPackage(str);
    while (true)
    {
      int m;
      try
      {
        Class localClass = Class.forName("com.xiaomi.push.service.receivers.PingReceiver");
        Boolean[] arrayOfBoolean2 = new Boolean[2];
        arrayOfBoolean2[0] = Boolean.valueOf(true);
        arrayOfBoolean2[1] = Boolean.valueOf(false);
        a(localPackageManager, localIntent2, localClass, arrayOfBoolean2);
        Intent localIntent3 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        localIntent3.setPackage(str);
        Iterator localIterator = localPackageManager.queryBroadcastReceivers(localIntent3, 16384).iterator();
        m = 0;
        if (!localIterator.hasNext())
          break label286;
        localActivityInfo = ((ResolveInfo)localIterator.next()).activityInfo;
        if (localActivityInfo == null)
          continue;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          ActivityInfo localActivityInfo;
          if ((TextUtils.isEmpty(localActivityInfo.name)) || (!PushMessageReceiver.class.isAssignableFrom(Class.forName(localActivityInfo.name))))
            continue;
          boolean bool = localActivityInfo.enabled;
          if (!bool)
            continue;
          n = 1;
          if (n == 0)
            continue;
          if (n != 0)
            break label285;
          throw new b("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.", null);
          localClassNotFoundException1 = localClassNotFoundException1;
          com.xiaomi.a.a.c.c.a(localClassNotFoundException1);
          continue;
          n = 0;
          continue;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          com.xiaomi.a.a.c.c.a(localClassNotFoundException2);
          n = m;
          m = n;
        }
        continue;
      }
      label285: return;
      label286: int n = m;
    }
  }

  private static void n(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
  }

  private static boolean o(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    boolean bool = System.currentTimeMillis() - localSharedPreferences.getLong("last_pull_notification", -1L) < 300000L;
    int m = 0;
    if (bool)
      m = 1;
    return m;
  }

  private static void p(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
  }

  private static boolean q(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    boolean bool = System.currentTimeMillis() - localSharedPreferences.getLong("last_reg_request", -1L) < 5000L;
    int m = 0;
    if (bool)
      m = 1;
    return m;
  }

  @Deprecated
  public static abstract class a
  {
    private String a;

    protected String a()
    {
      return this.a;
    }

    public void a(long paramLong, String paramString1, String paramString2)
    {
    }

    public void a(f paramf)
    {
    }

    protected void a(String paramString)
    {
      this.a = paramString;
    }

    public void a(String paramString1, long paramLong, String paramString2, List<String> paramList)
    {
    }

    public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
    }

    public void b(long paramLong, String paramString1, String paramString2)
    {
    }

    public void c(long paramLong, String paramString1, String paramString2)
    {
    }
  }

  public static class b extends Exception
  {
    private PackageItemInfo a;

    public b(String paramString, PackageItemInfo paramPackageItemInfo)
    {
      super();
      this.a = paramPackageItemInfo;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.d
 * JD-Core Version:    0.6.0
 */