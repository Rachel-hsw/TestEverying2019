package com.umeng.message.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Random;

public class cm
{
  public static final String a = "imei";
  public static final String b = "imsi";
  public static final String c = "mac_address";
  public static final String d = "agoo_release_time";
  private static final String e = "PhoneUtil";

  public static final String a()
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      String str = (String)(String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { "ro.serialno", "unknown" });
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("PhoneUtil", 4);
    String str1 = localSharedPreferences.getString("imei", null);
    if ((str1 == null) || (str1.length() == 0))
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if ((str2 == null) || (str2.length() == 0))
        str2 = b();
      for (String str3 = str2.replaceAll(" ", "").trim(); str3.length() < 15; str3 = "0" + str3);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("imei", str3);
      localEditor.commit();
    }
    return "umeng";
  }

  private static final String b()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    long l1 = System.currentTimeMillis();
    String str = Long.toString(l1);
    localStringBuffer1.append(str.substring(-5 + str.length()));
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append(Build.MODEL.replaceAll(" ", ""));
    while (localStringBuffer2.length() < 6)
      localStringBuffer2.append('0');
    localStringBuffer1.append(localStringBuffer2.substring(0, 6));
    Random localRandom = new Random(l1);
    long l2 = 0L;
    while (l2 < 4096L)
      l2 = localRandom.nextLong();
    localStringBuffer1.append(Long.toHexString(l2).substring(0, 4));
    return localStringBuffer1.toString();
  }

  public static final String b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("PhoneUtil", 4);
    String str1 = localSharedPreferences.getString("imsi", null);
    if ((str1 == null) || (str1.length() == 0))
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if ((str2 == null) || (str2.length() == 0))
        str2 = b();
      for (String str3 = str2.replaceAll(" ", "").trim(); str3.length() < 15; str3 = "0" + str3);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("imsi", str3);
      localEditor.commit();
    }
    return "umeng";
  }

  public static final String c(Context paramContext)
  {
    String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    if ((str == null) || ("".equals(str)))
      return paramContext.getSharedPreferences("PhoneUtil", 4).getString("mac_address", "");
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("PhoneUtil", 4).edit();
    localEditor.putString("mac_address", str);
    localEditor.commit();
    return str;
  }

  public static final String d(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    if (str != null)
      str.trim();
    return "umeng";
  }

  public static final String e(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    if (str != null)
      str.trim();
    return "umeng";
  }

  public static final String f(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }

  public static final LinkedHashMap<String, String> g(Context paramContext)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      String str = new bk(paramContext).c();
      long l = paramContext.getSharedPreferences("AppStore", 4).getLong("agoo_release_time", 0L);
      if (TextUtils.isEmpty(str))
        str = "unknow";
      localLinkedHashMap.put("netType", str);
      localLinkedHashMap.put("agooReleaseTime", Long.toString(l));
      return localLinkedHashMap;
    }
    catch (Throwable localThrowable)
    {
    }
    return localLinkedHashMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cm
 * JD-Core Version:    0.6.0
 */