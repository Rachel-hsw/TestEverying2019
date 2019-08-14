package com.umeng.a.b;

import android.util.Log;

public class o
{
  public static void a(String paramString1, String paramString2)
  {
    if (r.v)
      Log.i(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (r.v)
      Log.i(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void b(String paramString1, String paramString2)
  {
    if (r.v)
      Log.e(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Exception paramException)
  {
    if (r.v)
    {
      Log.e(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
        Log.e(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (r.v)
      Log.d(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Exception paramException)
  {
    if (r.v)
      Log.d(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void d(String paramString1, String paramString2)
  {
    if (r.v)
      Log.v(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Exception paramException)
  {
    if (r.v)
      Log.v(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void e(String paramString1, String paramString2)
  {
    if (r.v)
      Log.w(paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Exception paramException)
  {
    if (r.v)
    {
      Log.w(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
        Log.w(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.b.o
 * JD-Core Version:    0.6.0
 */