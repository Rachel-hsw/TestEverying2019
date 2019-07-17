package com.xiaomi.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public abstract class a
{
  public static void a(Context paramContext)
  {
  }

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }

  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.a.a
 * JD-Core Version:    0.6.0
 */