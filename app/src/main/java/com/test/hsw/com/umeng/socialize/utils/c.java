package com.umeng.socialize.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public class c
{
  protected static final String a = c.class.getName();
  protected static final String b = "Unknown";
  public static final int c = 8;
  private static final String d = "2G/3G";
  private static final String e = "Wi-Fi";

  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
  }

  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }

  public static boolean a(String paramString, Context paramContext)
  {
    int i = 1;
    if (paramContext == null)
      return false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 1);
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        i = 0;
    }
  }

  public static String b(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null)
      i.e(a, "No IMEI.");
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str2 = localTelephonyManager.getDeviceId();
        str1 = str2;
        if (TextUtils.isEmpty(str1))
        {
          i.e(a, "No IMEI.");
          str1 = g(paramContext);
          if (TextUtils.isEmpty(str1))
          {
            i.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
            str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            i.e(a, "getDeviceId: Secure.ANDROID_ID: " + str1);
          }
        }
        return str1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        i.e(a, "No IMEI.", localException);
        String str1 = "";
      }
    }
  }

  public static String b(String paramString, Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String[] c(Context paramContext)
  {
    String[] arrayOfString = { "Unknown", "Unknown" };
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
    {
      arrayOfString[0] = "Unknown";
      return arrayOfString;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
    {
      arrayOfString[0] = "Unknown";
      return arrayOfString;
    }
    if (localConnectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)
    {
      arrayOfString[0] = "Wi-Fi";
      return arrayOfString;
    }
    NetworkInfo localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
    if (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED)
    {
      arrayOfString[0] = "2G/3G";
      arrayOfString[1] = localNetworkInfo.getSubtypeName();
      return arrayOfString;
    }
    return arrayOfString;
  }

  public static boolean d(Context paramContext)
  {
    return "Wi-Fi".equals(c(paramContext)[0]);
  }

  public static boolean e(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnectedOrConnecting();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return true;
  }

  public static boolean f(Context paramContext)
  {
    return (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) && (e(paramContext));
  }

  public static String g(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        return localWifiManager.getConnectionInfo().getMacAddress();
      i.e(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
      return "";
    }
    catch (Exception localException)
    {
      while (true)
        i.e(a, "Could not get mac address." + localException.toString());
    }
  }

  public static String h(Context paramContext)
  {
    return paramContext.getPackageName();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.c
 * JD-Core Version:    0.6.0
 */