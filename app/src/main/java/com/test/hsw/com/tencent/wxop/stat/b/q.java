package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class q
{
  private static SharedPreferences db = null;

  private static SharedPreferences S(Context paramContext)
  {
    monitorenter;
    try
    {
      SharedPreferences localSharedPreferences1 = paramContext.getSharedPreferences(".mta-wxop", 0);
      db = localSharedPreferences1;
      if (localSharedPreferences1 == null)
        db = PreferenceManager.getDefaultSharedPreferences(paramContext);
      SharedPreferences localSharedPreferences2 = db;
      return localSharedPreferences2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static int a(Context paramContext, String paramString, int paramInt)
  {
    String str = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getInt(str, paramInt);
  }

  public static void a(Context paramContext, String paramString, long paramLong)
  {
    String str = l.e(paramContext, "wxop_" + paramString);
    SharedPreferences.Editor localEditor = S(paramContext).edit();
    localEditor.putLong(str, paramLong);
    localEditor.commit();
  }

  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    String str = l.e(paramContext, "wxop_" + paramString1);
    return S(paramContext).getString(str, paramString2);
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    String str = l.e(paramContext, "wxop_" + paramString);
    SharedPreferences.Editor localEditor = S(paramContext).edit();
    localEditor.putInt(str, paramInt);
    localEditor.commit();
  }

  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    String str = l.e(paramContext, "wxop_" + paramString1);
    SharedPreferences.Editor localEditor = S(paramContext).edit();
    localEditor.putString(str, paramString2);
    localEditor.commit();
  }

  public static long f(Context paramContext, String paramString)
  {
    String str = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getLong(str, 0L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.q
 * JD-Core Version:    0.6.0
 */