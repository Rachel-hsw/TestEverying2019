package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import java.util.Locale;

public class c
{
  static String a = null;
  static String b = null;
  static String c = null;
  private static String d;
  private static String e = null;

  public static String a()
  {
    try
    {
      Context localContext = Global.getContext();
      if (localContext == null)
        return "";
      WifiManager localWifiManager = (WifiManager)localContext.getSystemService("wifi");
      if (localWifiManager == null)
        return "";
      WifiInfo localWifiInfo = localWifiManager.getConnectionInfo();
      if (localWifiInfo == null)
        return "";
      String str = localWifiInfo.getMacAddress();
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      f.b("MobileInfoUtil", "getLocalMacAddress>>>", localSecurityException);
    }
    return "";
  }

  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(d))
      return d;
    if (paramContext == null)
      return "";
    d = "";
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    if (localWindowManager != null)
    {
      int i = localWindowManager.getDefaultDisplay().getWidth();
      int j = localWindowManager.getDefaultDisplay().getHeight();
      d = i + "x" + j;
    }
    return d;
  }

  public static String b()
  {
    return Locale.getDefault().getLanguage();
  }

  public static String b(Context paramContext)
  {
    if ((a != null) && (a.length() > 0))
      return a;
    if (paramContext == null)
      return "";
    try
    {
      a = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      String str = a;
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String c(Context paramContext)
  {
    if ((b != null) && (b.length() > 0))
      return b;
    if (paramContext == null)
      return "";
    try
    {
      b = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      String str = b;
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String d(Context paramContext)
  {
    if ((c != null) && (c.length() > 0))
      return c;
    if (paramContext == null)
      return "";
    try
    {
      c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      String str = c;
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String e(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (e == null)
      {
        WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
        localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("imei=").append(b(paramContext)).append('&');
        localStringBuilder1.append("model=").append(Build.MODEL).append('&');
        localStringBuilder1.append("os=").append(Build.VERSION.RELEASE).append('&');
        localStringBuilder1.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
        String str2 = a.b(paramContext);
        if (str2 == null)
          str2 = "";
        localStringBuilder1.append("network=").append(str2).append('&');
        localStringBuilder2 = localStringBuilder1.append("sdcard=");
        if (!Environment.getExternalStorageState().equals("mounted"))
          break label273;
      }
      label273: for (int i = 1; ; i = 0)
      {
        localStringBuilder2.append(i).append('&');
        localStringBuilder1.append("display=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
        localStringBuilder1.append("manu=").append(Build.MANUFACTURER).append("&");
        localStringBuilder1.append("wifi=").append(a.e(paramContext));
        e = localStringBuilder1.toString();
        String str1 = e;
        return str1;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.c
 * JD-Core Version:    0.6.0
 */