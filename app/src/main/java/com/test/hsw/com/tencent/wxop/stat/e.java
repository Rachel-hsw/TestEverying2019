package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.q;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static volatile boolean S;
  static volatile int aI;
  private static com.tencent.wxop.stat.b.f aK;
  private static volatile Map<com.tencent.wxop.stat.a.b, Long> aL = new ConcurrentHashMap();
  private static volatile Map<String, Properties> aM = new ConcurrentHashMap();
  private static volatile Map<Integer, Integer> aN = new ConcurrentHashMap(10);
  private static volatile long aO = 0L;
  private static volatile long aP;
  private static volatile int aQ;
  private static volatile String aR;
  private static volatile String aS;
  private static Map<String, Long> aT;
  private static Map<String, Long> aU;
  private static com.tencent.wxop.stat.b.b aV;
  private static Thread.UncaughtExceptionHandler aW;
  static volatile long aX;
  private static Context aY;
  static volatile long aZ;
  private static volatile long af = 0L;
  private static String al;

  static
  {
    aP = 0L;
    al = "";
    aQ = 0;
    aR = "";
    aS = "";
    aT = new ConcurrentHashMap();
    aU = new ConcurrentHashMap();
    aV = com.tencent.wxop.stat.b.l.av();
    aW = null;
    S = true;
    aI = 0;
    aX = 0L;
    aY = null;
    aZ = 0L;
  }

  private static JSONObject G()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (c.P.L != 0)
        localJSONObject2.put("v", c.P.L);
      localJSONObject1.put(Integer.toString(c.P.aI), localJSONObject2);
      JSONObject localJSONObject3 = new JSONObject();
      if (c.O.L != 0)
        localJSONObject3.put("v", c.O.L);
      localJSONObject1.put(Integer.toString(c.O.aI), localJSONObject3);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      aV.b(localJSONException);
    }
    return localJSONObject1;
  }

  static void H()
  {
    aI = 0;
    aX = 0L;
  }

  static void I()
  {
    aI = 1 + aI;
    aX = System.currentTimeMillis();
    p(aY);
  }

  static int a(Context paramContext, boolean paramBoolean, f paramf)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - af >= c.m()));
    for (int j = i; ; j = 0)
    {
      af = l;
      if (aP == 0L)
        aP = com.tencent.wxop.stat.b.l.ad();
      if (l >= aP)
      {
        aP = com.tencent.wxop.stat.b.l.ad();
        if (t.s(paramContext).t(paramContext).as() != i)
          t.s(paramContext).t(paramContext).z();
        c.C();
        aI = 0;
        al = com.tencent.wxop.stat.b.l.aw();
        j = i;
      }
      String str = al;
      if (com.tencent.wxop.stat.b.l.a(paramf))
        str = paramf.S() + al;
      if (!aU.containsKey(str));
      while (true)
      {
        Context localContext;
        if (i != 0)
        {
          if (com.tencent.wxop.stat.b.l.a(paramf))
            break label248;
          if (c.D() < c.A())
          {
            com.tencent.wxop.stat.b.l.O(paramContext);
            a(paramContext, null);
            aU.put(str, Long.valueOf(1L));
          }
        }
        else if (S)
        {
          if (c.l())
          {
            localContext = i(paramContext);
            if (localContext != null)
              break label256;
            aV.error("The Context of StatService.testSpeed() can not be null!");
          }
        }
        while (true)
        {
          S = false;
          return aQ;
          aV.d("Exceed StatConfig.getMaxDaySessionNumbers().");
          break;
          label248: a(paramContext, paramf);
          break;
          label256: if (k(localContext) == null)
            continue;
          aK.a(new i(localContext));
        }
        i = j;
      }
    }
  }

  private static void a(Context paramContext, f paramf)
  {
    if (k(paramContext) != null)
    {
      if (c.k())
        aV.e("start new session.");
      if ((paramf == null) || (aQ == 0))
        aQ = com.tencent.wxop.stat.b.l.r();
      c.z();
      c.B();
      new p(new com.tencent.wxop.stat.a.i(paramContext, aQ, G(), paramf)).ah();
    }
  }

  public static void a(Context paramContext, String paramString, f paramf)
  {
    if (!c.l());
    Context localContext;
    String str;
    do
    {
      return;
      localContext = i(paramContext);
      if ((localContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        aV.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        return;
      }
      str = new String(paramString);
    }
    while (k(localContext) == null);
    aK.a(new as(str, localContext, paramf));
  }

  static void a(Context paramContext, Throwable paramThrowable)
  {
    if (!c.l());
    Context localContext;
    do
    {
      return;
      localContext = i(paramContext);
      if (localContext != null)
        continue;
      aV.error("The Context of StatService.reportSdkSelfException() can not be null!");
      return;
    }
    while (k(localContext) == null);
    aK.a(new ap(localContext, paramThrowable));
  }

  static boolean a()
  {
    if (aI >= 2)
    {
      aX = System.currentTimeMillis();
      return true;
    }
    return false;
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    while (true)
    {
      try
      {
        if (c.l())
          continue;
        aV.error("MTA StatService is disable.");
        return false;
        if (c.k())
        {
          aV.e("MTA SDK version, current: " + "2.0.3" + " ,required: " + paramString2);
          break label225;
          aV.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
          c.a(false);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        aV.b(localThrowable);
        return false;
      }
      label225: 
      do
      {
        if (com.tencent.wxop.stat.b.l.u("2.0.3") < com.tencent.wxop.stat.b.l.u(paramString2))
        {
          String str2 = "MTA SDK version conflicted, current: " + "2.0.3" + ",required: " + paramString2;
          String str3 = str2 + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
          aV.error(str3);
          c.a(false);
          return false;
        }
        String str1 = c.e(paramContext);
        if ((str1 == null) || (str1.length() == 0))
          c.n("-");
        if (paramString1 != null)
          c.b(paramContext, paramString1);
        if (k(paramContext) != null)
          aK.a(new m(paramContext));
        return true;
        if (paramContext == null)
          break;
      }
      while (paramString2 != null);
    }
  }

  public static void b(Context paramContext, String paramString, f paramf)
  {
    if (!c.l());
    Context localContext;
    String str;
    do
    {
      return;
      localContext = i(paramContext);
      if ((localContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        aV.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        return;
      }
      str = new String(paramString);
    }
    while (k(localContext) == null);
    aK.a(new k(localContext, str, paramf));
  }

  public static void d(Context paramContext, String paramString)
  {
    if (!c.l());
    Context localContext;
    com.tencent.wxop.stat.a.b localb;
    do
    {
      return;
      localContext = i(paramContext);
      if (localContext == null)
      {
        aV.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if ((paramString == null) || (paramString.length() == 0));
      for (int i = 1; i != 0; i = 0)
      {
        aV.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      localb = new com.tencent.wxop.stat.a.b(paramString);
    }
    while (k(localContext) == null);
    aK.a(new ar(localContext, localb));
  }

  private static Context i(Context paramContext)
  {
    if (paramContext != null)
      return paramContext;
    return aY;
  }

  private static void j(Context paramContext)
  {
    boolean bool1 = false;
    monitorenter;
    if (paramContext == null)
    {
      monitorexit;
      return;
    }
    while (true)
    {
      boolean bool2;
      try
      {
        if (aK != null)
          break;
        long l1 = q.f(paramContext, c.c);
        long l2 = com.tencent.wxop.stat.b.l.u("2.0.3");
        bool2 = true;
        if (l2 > l1)
          continue;
        aV.error("MTA is disable for current version:" + l2 + ",wakeup version:" + l1);
        bool2 = false;
        long l3 = q.f(paramContext, c.W);
        if (l3 > System.currentTimeMillis())
        {
          aV.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + l3);
          c.a(bool1);
          if (!bool1)
            break;
          Context localContext = paramContext.getApplicationContext();
          aY = localContext;
          aK = new com.tencent.wxop.stat.b.f();
          al = com.tencent.wxop.stat.b.l.aw();
          aO = System.currentTimeMillis() + c.af;
          aK.a(new an(localContext));
          break;
        }
      }
      finally
      {
        monitorexit;
      }
      bool1 = bool2;
    }
  }

  private static com.tencent.wxop.stat.b.f k(Context paramContext)
  {
    if (aK == null)
      monitorenter;
    try
    {
      com.tencent.wxop.stat.b.f localf = aK;
      if (localf == null);
      try
      {
        j(paramContext);
        monitorexit;
        return aK;
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          aV.a(localThrowable);
          c.a(false);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void l(Context paramContext)
  {
    if (!c.l());
    do
      return;
    while (k(paramContext) == null);
    aK.a(new l(paramContext));
  }

  public static void m(Context paramContext)
  {
    if (!c.l());
    do
      return;
    while (k(paramContext) == null);
    aK.a(new ao(paramContext));
  }

  static void n(Context paramContext)
  {
    if (!c.l())
      return;
    Context localContext = i(paramContext);
    if (localContext == null)
    {
      aV.error("The Context of StatService.sendNetworkDetector() can not be null!");
      return;
    }
    try
    {
      com.tencent.wxop.stat.a.f localf = new com.tencent.wxop.stat.a.f(localContext);
      ak.Z(localContext).a(localf, new aq());
      return;
    }
    catch (Throwable localThrowable)
    {
      aV.b(localThrowable);
    }
  }

  public static void o(Context paramContext)
  {
    if (!c.l());
    Context localContext;
    do
    {
      return;
      if (c.k())
        aV.b("commitEvents, maxNumber=-1");
      localContext = i(paramContext);
      if (localContext != null)
        continue;
      aV.error("The Context of StatService.commitEvents() can not be null!");
      return;
    }
    while ((!g.r(aY).X()) || (k(localContext) == null));
    aK.a(new h(localContext));
  }

  public static Properties p(String paramString)
  {
    return (Properties)aM.get(paramString);
  }

  public static void p(Context paramContext)
  {
    if (!c.l());
    do
      return;
    while (c.ay <= 0);
    Context localContext = i(paramContext);
    if (localContext == null)
    {
      aV.error("The Context of StatService.testSpeed() can not be null!");
      return;
    }
    t.s(localContext).H();
  }

  static void q(Context paramContext)
  {
    aZ = System.currentTimeMillis() + 60000 * c.u();
    q.a(paramContext, "last_period_ts", aZ);
    o(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.e
 * JD-Core Version:    0.6.0
 */