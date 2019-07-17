package com.umeng.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ta.utdid2.device.UTDevice;
import com.umeng.message.b.dl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import javax.microedition.khronos.opengles.GL10;

public class b
{
  protected static final String a = b.class.getName();
  protected static final String b = "Unknown";
  public static final int c = 8;
  private static final String d = "2G/3G";
  private static final String e = "Wi-Fi";

  private static Locale A(Context paramContext)
  {
    try
    {
      Configuration localConfiguration = new Configuration();
      Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
      localLocale = null;
      if (localConfiguration != null)
        localLocale = localConfiguration.locale;
      if (localLocale == null)
        localLocale = Locale.getDefault();
      return localLocale;
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.b(a, "fail to read user config locale");
        Locale localLocale = null;
      }
    }
  }

  private static int a(Object paramObject, String paramString)
  {
    try
    {
      Field localField = DisplayMetrics.class.getDeclaredField(paramString);
      if (localField != null)
      {
        localField.setAccessible(true);
        int i = localField.getInt(paramObject);
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }

  public static int a(Date paramDate1, Date paramDate2)
  {
    if (paramDate1.after(paramDate2));
    while (true)
    {
      long l = paramDate2.getTime();
      return (int)((paramDate1.getTime() - l) / 1000L);
      Date localDate = paramDate2;
      paramDate2 = paramDate1;
      paramDate1 = localDate;
    }
  }

  public static String a()
  {
    String str1 = null;
    try
    {
      FileReader localFileReader = new FileReader("/proc/cpuinfo");
      if (localFileReader != null)
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(localFileReader, 1024);
          str1 = localBufferedReader.readLine();
          localBufferedReader.close();
          localFileReader.close();
          str2 = str1;
          if (str2 != null)
            str2 = str2.substring(1 + str2.indexOf(':')).trim();
          return str2;
        }
        catch (IOException localIOException)
        {
          while (true)
          {
            a.b(a, "Could not read from file /proc/cpuinfo", localIOException);
            str2 = str1;
          }
        }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
      {
        a.b(a, "Could not open file /proc/cpuinfo", localFileNotFoundException);
        String str2 = str1;
        continue;
        str2 = null;
      }
    }
  }

  public static String a(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
  }

  public static Date a(String paramString)
  {
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      return localDate;
    }
    catch (Exception localException)
    {
    }
    return null;
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
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static String[] a(GL10 paramGL10)
  {
    try
    {
      String[] arrayOfString = new String[2];
      String str1 = paramGL10.glGetString(7936);
      String str2 = paramGL10.glGetString(7937);
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      return arrayOfString;
    }
    catch (Exception localException)
    {
      a.b(a, "Could not read gpu infor:", localException);
    }
    return new String[0];
  }

  public static String b(Context paramContext, String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str1 = localApplicationInfo.metaData.getString(paramString);
        if (str1 != null)
        {
          String str2 = str1.trim();
          return str2;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a.b(a, String.format("Could not read meta-data %s from AndroidManifest.xml.", new Object[] { paramString }));
    }
    return null;
  }

  public static Set<String> b(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    List localList = paramContext.getPackageManager().getInstalledPackages(0);
    for (int i = 0; ; i++)
    {
      if (i >= localList.size())
        return localHashSet;
      localHashSet.add(((PackageInfo)localList.get(i)).packageName);
    }
  }

  public static boolean b()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public static String c()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(localDate);
  }

  public static boolean c(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 1;
  }

  public static String d(Context paramContext)
  {
    try
    {
      String str = String.valueOf(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "Unknown";
  }

  public static String e(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "Unknown";
  }

  public static String f(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo1 = localApplicationInfo2;
      if (localApplicationInfo1 != null)
      {
        localObject = localPackageManager.getApplicationLabel(localApplicationInfo1);
        return (String)localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        ApplicationInfo localApplicationInfo1 = null;
        continue;
        Object localObject = "";
      }
    }
  }

  public static String g(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null)
      a.e(a, "No IMEI.");
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str2 = localTelephonyManager.getDeviceId();
        str1 = str2;
        if (TextUtils.isEmpty(str1))
        {
          a.e(a, "No IMEI.");
          str1 = s(paramContext);
          if (TextUtils.isEmpty(str1))
          {
            a.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
            str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            a.a(a, "getDeviceId: Secure.ANDROID_ID: " + str1);
          }
        }
        return str1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.e(a, "No IMEI.", localException);
        String str1 = "";
      }
    }
  }

  public static String h(Context paramContext)
  {
    return dl.b(g(paramContext));
  }

  public static String i(Context paramContext)
  {
    return dl.a(g(paramContext));
  }

  public static String j(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager == null)
        return "Unknown";
      String str = localTelephonyManager.getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "Unknown";
  }

  public static String k(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      String str = String.valueOf(localDisplayMetrics.heightPixels) + "*" + String.valueOf(i);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "Unknown";
  }

  public static String[] l(Context paramContext)
  {
    String[] arrayOfString = { "Unknown", "Unknown" };
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return arrayOfString;
      NetworkInfo localNetworkInfo1 = localConnectivityManager.getNetworkInfo(1);
      if ((localNetworkInfo1 != null) && (localNetworkInfo1.getState() == NetworkInfo.State.CONNECTED))
      {
        arrayOfString[0] = "Wi-Fi";
        return arrayOfString;
      }
      NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(0);
      if ((localNetworkInfo2 != null) && (localNetworkInfo2.getState() == NetworkInfo.State.CONNECTED))
      {
        arrayOfString[0] = "2G/3G";
        arrayOfString[1] = localNetworkInfo2.getSubtypeName();
        return arrayOfString;
      }
    }
    catch (Exception localException)
    {
    }
    return arrayOfString;
  }

  public static boolean m(Context paramContext)
  {
    return "Wi-Fi".equals(l(paramContext)[0]);
  }

  public static Location n(Context paramContext)
  {
    try
    {
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      if (a(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        Location localLocation2 = localLocationManager.getLastKnownLocation("gps");
        if (localLocation2 != null)
        {
          a.c(a, "get location from gps:" + localLocation2.getLatitude() + "," + localLocation2.getLongitude());
          return localLocation2;
        }
      }
      if (a(paramContext, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        Location localLocation1 = localLocationManager.getLastKnownLocation("network");
        if (localLocation1 != null)
        {
          a.c(a, "get location from network:" + localLocation1.getLatitude() + "," + localLocation1.getLongitude());
          return localLocation1;
        }
      }
    }
    catch (Exception localException)
    {
      a.b(a, localException.getMessage());
      return null;
    }
    a.c(a, "Could not get location from GPS or Cell-id, lack ACCESS_COARSE_LOCATION or ACCESS_COARSE_LOCATION permission?");
    return null;
  }

  public static boolean o(Context paramContext)
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

  public static int p(Context paramContext)
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance(A(paramContext));
      if (localCalendar != null)
      {
        int i = localCalendar.getTimeZone().getRawOffset() / 3600000;
        return i;
      }
    }
    catch (Exception localException)
    {
      a.a(a, "error in getTimeZone", localException);
    }
    return 8;
  }

  public static String[] q(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    try
    {
      Locale localLocale = A(paramContext);
      if (localLocale != null)
      {
        arrayOfString[0] = localLocale.getCountry();
        arrayOfString[1] = localLocale.getLanguage();
      }
      if (TextUtils.isEmpty(arrayOfString[0]))
        arrayOfString[0] = "Unknown";
      if (TextUtils.isEmpty(arrayOfString[1]))
        arrayOfString[1] = "Unknown";
      return arrayOfString;
    }
    catch (Exception localException)
    {
      a.b(a, "error in getLocaleInfo", localException);
    }
    return arrayOfString;
  }

  public static String r(Context paramContext)
  {
    return b(paramContext, "UMENG_APPKEY");
  }

  public static String s(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        return localWifiManager.getConnectionInfo().getMacAddress();
      a.e(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
      return "";
    }
    catch (Exception localException)
    {
      while (true)
        a.e(a, "Could not get mac address." + localException.toString());
    }
  }

  public static String t(Context paramContext)
  {
    while (true)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((0x2000 & paramContext.getApplicationInfo().flags) == 0)
        {
          j = a(localDisplayMetrics, "noncompatWidthPixels");
          i = a(localDisplayMetrics, "noncompatHeightPixels");
          break label134;
          j = localDisplayMetrics.widthPixels;
          i = localDisplayMetrics.heightPixels;
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(j);
          localStringBuffer.append("*");
          localStringBuffer.append(i);
          String str = localStringBuffer.toString();
          return str;
        }
      }
      catch (Exception localException)
      {
        a.b(a, "read resolution fail", localException);
        return "Unknown";
      }
      int i = -1;
      int j = -1;
      label134: if (j == -1)
        continue;
      if (i != -1)
        continue;
    }
  }

  public static String u(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
      a.a(a, "read carrier fail", localException);
    }
    return "Unknown";
  }

  public static String v(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
      {
        Object localObject = localApplicationInfo.metaData.get("UMENG_CHANNEL");
        if (localObject != null)
        {
          String str = localObject.toString();
          if (str != null)
            return str;
          a.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
          return "Unknown";
        }
      }
    }
    catch (Exception localException)
    {
      a.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
      localException.printStackTrace();
    }
    return "Unknown";
  }

  public static String w(Context paramContext)
  {
    return paramContext.getPackageName();
  }

  public static String x(Context paramContext)
  {
    return paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString();
  }

  public static boolean y(Context paramContext)
  {
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      int j = i & 0x2;
      int k = 0;
      if (j != 0)
        k = 1;
      return k;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static String z(Context paramContext)
  {
    try
    {
      String str = UTDevice.getUtdid(paramContext);
      return str;
    }
    catch (Throwable localThrowable)
    {
      a.b(a, "fail to get utdid. " + localThrowable.getMessage());
    }
    return "";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.b.a.b
 * JD-Core Version:    0.6.0
 */