package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  private static String a = "";

  private static WifiInfo T(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (localWifiManager != null)
        return localWifiManager.getConnectionInfo();
    }
    return null;
  }

  public static String U(Context paramContext)
  {
    try
    {
      WifiInfo localWifiInfo = T(paramContext);
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getBSSID();
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "encode error", localThrowable);
    }
    return null;
  }

  public static String V(Context paramContext)
  {
    try
    {
      WifiInfo localWifiInfo = T(paramContext);
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getSSID();
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "encode error", localThrowable);
    }
    return null;
  }

  public static boolean W(Context paramContext)
  {
    try
    {
      if ((a(paramContext, "android.permission.INTERNET")) && (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localConnectivityManager != null)
        {
          NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
          if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
            return true;
          Log.w("MtaSDK", "Network error");
          return false;
        }
      }
      else
      {
        Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.e("MtaSDK", "isNetworkAvailable error", localThrowable);
    }
  }

  public static JSONArray X(Context paramContext)
  {
    JSONArray localJSONArray;
    try
    {
      if ((a(paramContext, "android.permission.INTERNET")) && (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (localWifiManager != null)
        {
          List localList = localWifiManager.getScanResults();
          if ((localList != null) && (localList.size() > 0))
          {
            Collections.sort(localList, new s());
            localJSONArray = new JSONArray();
            for (int i = 0; (i < localList.size()) && (i < 10); i++)
            {
              ScanResult localScanResult = (ScanResult)localList.get(i);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("bs", localScanResult.BSSID);
              localJSONObject.put("ss", localScanResult.SSID);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      else
      {
        Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.e("MtaSDK", "isWifiNet error", localThrowable);
    }
    return localJSONArray;
  }

  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramString2 != null);
    try
    {
      if (paramString2.length() > 0)
        paramJSONObject.put(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "jsonPut error", localThrowable);
    }
  }

  public static boolean a(Context paramContext, String paramString)
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
      Log.e("MtaSDK", "checkPermission error", localThrowable);
    }
    return false;
  }

  public static String b(Context paramContext)
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
        Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.e("MtaSDK", "get device id error", localThrowable);
    }
  }

  public static String c(Context paramContext)
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
        Log.e("MtaSDK", "get wifi address error", localException);
        return "";
      }
    Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }

  public static String q(String paramString)
  {
    if (paramString == null)
      paramString = null;
    do
      return paramString;
    while (Build.VERSION.SDK_INT < 8);
    try
    {
      String str = new String(h.e(g.b(paramString.getBytes("UTF-8"))), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "encode error", localThrowable);
    }
    return paramString;
  }

  public static String t(String paramString)
  {
    if (paramString == null)
      paramString = null;
    do
      return paramString;
    while (Build.VERSION.SDK_INT < 8);
    try
    {
      String str = new String(g.c(h.d(paramString.getBytes("UTF-8"))), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "decode error", localThrowable);
    }
    return paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.r
 * JD-Core Version:    0.6.0
 */