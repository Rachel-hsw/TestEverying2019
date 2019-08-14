package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.tencent.wxop.stat.b.g;
import org.json.JSONObject;

public final class h
{
  private static void a(String paramString, Throwable paramThrowable)
  {
    Log.e("MID", paramString, paramThrowable);
  }

  static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (d(paramString2))
      paramJSONObject.put(paramString1, paramString2);
  }

  static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      int j = 0;
      if (i == 0)
        j = 1;
      return j;
    }
    catch (Throwable localThrowable)
    {
      a("checkPermission error", localThrowable);
    }
    return false;
  }

  static String b(Context paramContext)
  {
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (str != null)
          return str;
      }
      else
      {
        Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.w("MID", localThrowable);
    }
  }

  static String c(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      try
      {
        WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (localWifiManager == null)
          return "";
        String str = localWifiManager.getConnectionInfo().getMacAddress();
        return str;
      }
      catch (Exception localException)
      {
        Log.i("MID", "get wifi address error" + localException);
        return "";
      }
    Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }

  static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }

  public static boolean e(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() >= 40);
  }

  static String f(String paramString)
  {
    if (paramString == null)
      paramString = null;
    do
      return paramString;
    while (Build.VERSION.SDK_INT < 8);
    try
    {
      String str = new String(g.c(Base64.decode(paramString.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
      a("decode error", localThrowable);
    }
    return paramString;
  }

  static String g(String paramString)
  {
    if (paramString == null)
      paramString = null;
    do
      return paramString;
    while (Build.VERSION.SDK_INT < 8);
    try
    {
      String str = new String(Base64.encode(g.b(paramString.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
      a("decode error", localThrowable);
    }
    return paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.h
 * JD-Core Version:    0.6.0
 */