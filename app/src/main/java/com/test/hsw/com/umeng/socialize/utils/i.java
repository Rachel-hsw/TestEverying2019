package com.umeng.socialize.utils;

import android.util.Log;

public class i
{
  public static boolean a = false;
  public static final boolean b = false;
  private static final String c = "umengsocial";

  public static void a(String paramString)
  {
    if (a)
      Log.i("umengsocial", paramString);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (a)
      Log.i(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
      Log.i(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void b(String paramString)
  {
    Log.e("umengsocial", paramString);
  }

  public static void b(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Exception paramException)
  {
    Log.e(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
    for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
      Log.e(paramString1, "        at\t " + localStackTraceElement.toString());
  }

  public static void c(String paramString)
  {
    if (a)
      Log.d("umengsocial", paramString);
  }

  public static void c(String paramString1, String paramString2)
  {
    if (a)
      Log.d(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
      Log.d(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void d(String paramString)
  {
    if (a)
      Log.v("umengsocial", paramString);
  }

  public static void d(String paramString1, String paramString2)
  {
    if (a)
      Log.v(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
      Log.v(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void e(String paramString)
  {
    if (a)
      Log.w("umengsocial", paramString);
  }

  public static void e(String paramString1, String paramString2)
  {
    if (a)
      Log.w(paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
    {
      Log.w(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
        Log.w(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.i
 * JD-Core Version:    0.6.0
 */