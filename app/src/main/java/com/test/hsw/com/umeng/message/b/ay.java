package com.umeng.message.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.reflect.Field;

public final class ay
{
  private static volatile az a = null;
  private static final String b = "app_debug";
  private static final String c = "app_log_to_file";
  private static final String d = "AppStore";

  public static final void a(Context paramContext)
  {
    if (a == null);
    while (true)
    {
      try
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("AppStore", 4);
        if (!localSharedPreferences.getBoolean("app_debug", true))
        {
          boolean bool2 = b(paramContext);
          bool1 = false;
          if (!bool2)
          {
            a = new ba(bool1, localSharedPreferences.getBoolean("app_log_to_file", false));
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Log.d("AgooLog", "startlog", localThrowable);
        return;
      }
      boolean bool1 = true;
    }
  }

  public static final void a(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.c(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }

  public static final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.c(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }

  public static final void a(String paramString, Object[] paramArrayOfObject)
  {
    if (a != null)
      a.a(paramString, paramArrayOfObject);
  }

  public static final void b(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.b(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }

  public static final void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.b(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }

  private static boolean b(Context paramContext)
  {
    try
    {
      boolean bool = Class.forName(paramContext.getPackageName() + ".BuildConfig").getField("DEBUG").getBoolean("false");
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static final void c(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.a(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }

  public static final void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.a(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }

  public static final void d(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }

  public static final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }

  public static final void e(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }

  public static final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ay
 * JD-Core Version:    0.6.0
 */