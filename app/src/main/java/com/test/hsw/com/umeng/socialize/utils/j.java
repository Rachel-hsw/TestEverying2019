package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.socialize.bean.p;

public class j
{
  private static final String a = "socialize_identity_info";
  private static final String b = "socialize_identity_unshow";

  public static void a(Context paramContext)
  {
    monitorenter;
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize", 0).edit();
      localEditor.remove("socialize_identity_info");
      localEditor.commit();
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

  public static void a(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize", 0).edit();
      localEditor.putString("socialize_identity_info", paramString);
      localEditor.commit();
      if ((e(paramContext)) && (!TextUtils.isEmpty(paramString)))
        a(paramContext, false);
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

  public static void a(Context paramContext, boolean paramBoolean)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      localEditor.putBoolean("socialize_identity_unshow", paramBoolean);
      localEditor.commit();
      return;
    }
  }

  public static p b(Context paramContext)
  {
    return p.a(paramContext.getSharedPreferences("umeng_socialize", 0).getString("socialize_identity_info", ""));
  }

  public static boolean c(Context paramContext)
  {
    return b(paramContext) != null;
  }

  public static boolean d(Context paramContext)
  {
    boolean bool = "custom".equals(paramContext.getSharedPreferences("umeng_socialize", 0).getString("socialize_identity_info", ""));
    int i = 0;
    if (bool)
      i = 1;
    return i;
  }

  public static boolean e(Context paramContext)
  {
    boolean bool = c(paramContext);
    if (!bool)
      bool = paramContext.getSharedPreferences("umeng_socialize", 0).getBoolean("socialize_identity_unshow", false);
    return bool;
  }

  public static boolean f(Context paramContext)
  {
    boolean bool = c(paramContext);
    if (bool);
    while (bool)
    {
      return bool;
      bool = e(paramContext);
    }
    return d(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.j
 * JD-Core Version:    0.6.0
 */