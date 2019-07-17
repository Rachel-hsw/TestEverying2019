package com.pingplusplus.android;

import android.util.Log;

public class PingppLog
{
  public static boolean DEBUG = false;
  private static String a = "PING++";

  public static void d(String paramString)
  {
    if (DEBUG)
      Log.d(a, paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.PingppLog
 * JD-Core Version:    0.6.0
 */