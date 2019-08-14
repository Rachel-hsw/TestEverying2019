package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushMessageHandler extends IntentService
{
  private static List<d.a> a = new ArrayList();

  public PushMessageHandler()
  {
    super("mipush message handler");
  }

  protected static void a()
  {
    synchronized (a)
    {
      a.clear();
      return;
    }
  }

  public static void a(long paramLong, String paramString1, String paramString2)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext())
        ((d.a)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
    monitorexit;
  }

  public static void a(Context paramContext, a parama)
  {
    if ((parama instanceof f))
      a(paramContext, (f)parama);
    e locale;
    String str1;
    do
    {
      do
        return;
      while (!(parama instanceof e));
      locale = (e)parama;
      str1 = locale.a();
      if ("register".equals(str1))
      {
        List localList3 = locale.b();
        String str4 = null;
        if (localList3 != null)
        {
          boolean bool = localList3.isEmpty();
          str4 = null;
          if (!bool)
            str4 = (String)localList3.get(0);
        }
        a(locale.c(), locale.d(), str4);
        return;
      }
      if (("set-alias".equals(str1)) || ("unset-alias".equals(str1)) || ("accept-time".equals(str1)))
      {
        a(paramContext, locale.e(), str1, locale.c(), locale.d(), locale.b());
        return;
      }
      if (!"subscribe-topic".equals(str1))
        continue;
      List localList2 = locale.b();
      if ((localList2 != null) && (!localList2.isEmpty()));
      for (String str3 = (String)localList2.get(0); ; str3 = null)
      {
        a(paramContext, locale.e(), locale.c(), locale.d(), str3);
        return;
      }
    }
    while (!"unsubscibe-topic".equals(str1));
    List localList1 = locale.b();
    if ((localList1 != null) && (!localList1.isEmpty()));
    for (String str2 = (String)localList1.get(0); ; str2 = null)
    {
      b(paramContext, locale.e(), locale.c(), locale.d(), str2);
      return;
    }
  }

  public static void a(Context paramContext, f paramf)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        if (!a(paramf.m(), locala.a()))
          continue;
        locala.a(paramf.d(), paramf.e(), paramf.g(), paramf.j());
        locala.a(paramf);
      }
    }
    monitorexit;
  }

  protected static void a(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        if (!a(paramString1, locala.a()))
          continue;
        locala.b(paramLong, paramString2, paramString3);
      }
    }
    monitorexit;
  }

  protected static void a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3, List<String> paramList)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        if (!a(paramString1, locala.a()))
          continue;
        locala.a(paramString2, paramLong, paramString3, paramList);
      }
    }
    monitorexit;
  }

  protected static void a(d.a parama)
  {
    synchronized (a)
    {
      if (!a.contains(parama))
        a.add(parama);
      return;
    }
  }

  protected static boolean a(String paramString1, String paramString2)
  {
    return ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.equals(paramString1, paramString2));
  }

  protected static void b(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        if (!a(paramString1, locala.a()))
          continue;
        locala.c(paramLong, paramString2, paramString3);
      }
    }
    monitorexit;
  }

  public static boolean b()
  {
    return a.isEmpty();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    try
    {
      if ("com.xiaomi.mipush.sdk.WAKEUP".equals(paramIntent.getAction()))
      {
        if (!h.a(this).i())
          return;
        n.a(this).a();
        return;
      }
      if (1 != g.a(this))
        break label78;
      if (b())
      {
        c.d("receive a message before application calling initialize");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
      return;
    }
    a locala = m.a(this).a(paramIntent);
    if (locala != null)
    {
      a(this, locala);
      return;
      label78: Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
      localIntent.setPackage(getPackageName());
      localIntent.putExtras(paramIntent);
      PackageManager localPackageManager = getPackageManager();
      while (true)
      {
        try
        {
          List localList = localPackageManager.queryBroadcastReceivers(localIntent, 32);
          if (localList == null)
            break label227;
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
            break label227;
          localResolveInfo = (ResolveInfo)localIterator.next();
          if ((localResolveInfo.activityInfo == null) || (!localResolveInfo.activityInfo.packageName.equals(getPackageName())))
            continue;
          if (localResolveInfo != null)
          {
            ((PushMessageReceiver)Class.forName(localResolveInfo.activityInfo.name).newInstance()).onReceive(getApplicationContext(), localIntent);
            return;
          }
        }
        catch (Exception localException)
        {
          c.a(localException);
          return;
        }
        c.d("cannot find the receiver to handler this message, check your manifest");
        return;
        label227: ResolveInfo localResolveInfo = null;
      }
    }
  }

  static abstract interface a extends Serializable
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.PushMessageHandler
 * JD-Core Version:    0.6.0
 */