package com.umeng.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.a.bt;
import c.a.bu;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class g
{
  private static final String a = "input map is null";
  private static final m b = new m();

  public static m a()
  {
    return b;
  }

  public static void a(long paramLong)
  {
    a.l = paramLong;
  }

  public static void a(Context paramContext)
  {
    b.c(paramContext);
  }

  public static void a(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString);
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    b.a(paramContext, paramString, null, -1L, paramInt);
  }

  public static void a(Context paramContext, String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      bu.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    b.a(paramContext, paramString, null, paramLong, 1);
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      bu.b("MobclickAgent", "unexpected empty appkey in onResume");
      return;
    }
    a.a(paramString1);
    a.b(paramString2);
    b.b(paramContext);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bu.a("MobclickAgent", "label is null or empty");
      return;
    }
    b.a(paramContext, paramString1, paramString2, -1L, paramInt);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bu.a("MobclickAgent", "label is null or empty");
      return;
    }
    if (paramLong <= 0L)
    {
      bu.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    b.a(paramContext, paramString1, paramString2, paramLong, 1);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, b paramb, int paramInt)
  {
  }

  public static void a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      bu.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString, new HashMap(paramMap), -1L);
  }

  public static void a(Context paramContext, String paramString, Map<String, String> paramMap, int paramInt)
  {
    if (paramMap == null);
    for (HashMap localHashMap = new HashMap(); ; localHashMap = new HashMap(paramMap))
    {
      localHashMap.put("__ct__", Integer.valueOf(paramInt));
      b.a(paramContext, paramString, localHashMap, -1L);
      return;
    }
  }

  public static void a(Context paramContext, String paramString, Map<String, String> paramMap, long paramLong)
  {
    if (paramLong <= 0L)
    {
      bu.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    if (paramMap == null)
    {
      bu.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString, new HashMap(paramMap), paramLong);
  }

  public static void a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    if (paramMap == null)
    {
      bu.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString1, new HashMap(paramMap), paramString2);
  }

  public static void a(Context paramContext, String paramString, com.umeng.a.b.a[] paramArrayOfa)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "context is null in onShareEvent");
      return;
    }
    com.umeng.a.b.r.e = "3";
    com.umeng.a.b.m.a(paramContext, paramString, paramArrayOfa);
  }

  public static void a(Context paramContext, Throwable paramThrowable)
  {
    b.a(paramContext, paramThrowable);
  }

  public static void a(Context paramContext, com.umeng.a.b.a[] paramArrayOfa)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "context is null in onShareEvent");
      return;
    }
    com.umeng.a.b.r.e = "3";
    com.umeng.a.b.m.a(paramContext, paramArrayOfa);
  }

  public static void a(com.umeng.a.a.a parama)
  {
    b.a(parama);
  }

  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b.a(paramString);
      return;
    }
    bu.b("MobclickAgent", "pageName is null or empty");
  }

  public static void a(String paramString1, String paramString2)
  {
    b.a(paramString1, paramString2);
  }

  public static void a(GL10 paramGL10)
  {
    if (paramGL10 != null)
    {
      String[] arrayOfString = bt.a(paramGL10);
      if (arrayOfString.length == 2)
      {
        a.d = arrayOfString[0];
        a.e = arrayOfString[1];
      }
    }
  }

  public static void a(boolean paramBoolean)
  {
  }

  public static void b(Context paramContext)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    b.b(paramContext);
  }

  public static void b(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, null, -1L, 1);
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bu.a("MobclickAgent", "label is null or empty");
      return;
    }
    b.a(paramContext, paramString1, paramString2, -1L, 1);
  }

  public static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b.b(paramString);
      return;
    }
    bu.b("MobclickAgent", "pageName is null or empty");
  }

  public static void b(boolean paramBoolean)
  {
    a.k = paramBoolean;
  }

  public static void c(Context paramContext)
  {
  }

  public static void c(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, null);
  }

  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    b.a(paramContext, paramString1, paramString2);
  }

  public static void c(boolean paramBoolean)
  {
    a.j = paramBoolean;
  }

  public static void d(Context paramContext)
  {
    b.a(paramContext);
  }

  public static void d(Context paramContext, String paramString)
  {
    b.b(paramContext, paramString, null);
  }

  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    b.b(paramContext, paramString1, paramString2);
  }

  public static void d(boolean paramBoolean)
  {
    a.h = paramBoolean;
  }

  public static String e(Context paramContext, String paramString)
  {
    return w.a(paramContext).j().getString(paramString, "");
  }

  public static void e(Context paramContext)
  {
    b.e(paramContext);
  }

  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    b.c(paramContext, paramString1, paramString2);
  }

  public static void e(boolean paramBoolean)
  {
    bu.a = paramBoolean;
    com.umeng.a.b.r.v = paramBoolean;
  }

  public static void f(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      bu.b("MobclickAgent", "unexpected empty appkey in onResume");
      return;
    }
    a.a(paramString1);
    a.b(paramString2);
    b.a(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.g
 * JD-Core Version:    0.6.0
 */