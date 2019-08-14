package com.xiaomi.e;

import com.xiaomi.f.a.u;
import com.xiaomi.push.d.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an.b;
import java.util.Hashtable;

public class g
{
  private static final int a = com.xiaomi.push.d.a.c.a();

  public static void a()
  {
    a(0, a);
  }

  public static void a(int paramInt)
  {
    b localb = e.a().f();
    localb.a(com.xiaomi.push.d.a.ab.a());
    localb.c(paramInt);
    e.a().a(localb);
  }

  public static void a(int paramInt1, int paramInt2)
  {
    monitorenter;
    int i;
    if (paramInt2 < 16777215)
      i = paramInt2 | paramInt1 << 24;
    try
    {
      a.a.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
      while (true)
      {
        return;
        com.xiaomi.a.a.c.c.d("stats key should less than 16777215");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    e.a().a(paramInt1, paramInt2, paramInt3, paramString);
  }

  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    monitorenter;
    try
    {
      long l = System.currentTimeMillis();
      int i = paramInt2 | paramInt1 << 24;
      if (a.a.containsKey(Integer.valueOf(i)))
      {
        b localb = e.a().f();
        localb.a(paramInt2);
        localb.b((int)(l - ((Long)a.a.get(Integer.valueOf(i))).longValue()));
        localb.b(paramString);
        if (paramInt3 > -1)
          localb.c(paramInt3);
        e.a().a(localb);
        a.a.remove(Integer.valueOf(paramInt2));
      }
      while (true)
      {
        return;
        com.xiaomi.a.a.c.c.d("stats key not found");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void a(XMPushService paramXMPushService, an.b paramb)
  {
    new a(paramXMPushService, paramb).a();
  }

  public static void a(String paramString, int paramInt, Exception paramException)
  {
    b localb = e.a().f();
    if (paramInt > 0)
    {
      localb.a(com.xiaomi.push.d.a.h.a());
      localb.b(paramString);
      localb.b(paramInt);
      e.a().a(localb);
      return;
    }
    try
    {
      c.a locala = c.a(paramException);
      localb.a(locala.a.a());
      localb.c(locala.b);
      localb.b(paramString);
      e.a().a(localb);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public static void a(String paramString, Exception paramException)
  {
    try
    {
      c.a locala = c.b(paramException);
      b localb = e.a().f();
      localb.a(locala.a.a());
      localb.c(locala.b);
      localb.b(paramString);
      e.a().a(localb);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public static void b()
  {
    a(0, a, null, -1);
  }

  public static void b(String paramString, Exception paramException)
  {
    try
    {
      c.a locala = c.d(paramException);
      b localb = e.a().f();
      localb.a(locala.a.a());
      localb.c(locala.b);
      localb.b(paramString);
      e.a().a(localb);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public static String c()
  {
    com.xiaomi.push.d.c localc = e.a().e();
    String str = null;
    if (localc != null)
    {
      byte[] arrayOfByte = u.a(localc);
      str = null;
      if (arrayOfByte != null)
      {
        str = new String(com.xiaomi.a.a.g.a.a(arrayOfByte));
        com.xiaomi.a.a.c.c.a("stat encoded size = " + str.length());
        com.xiaomi.a.a.c.c.c(str);
      }
    }
    return str;
  }

  static class a
  {
    static Hashtable<Integer, Long> a = new Hashtable();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.e.g
 * JD-Core Version:    0.6.0
 */