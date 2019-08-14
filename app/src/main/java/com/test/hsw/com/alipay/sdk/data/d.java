package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.cons.a;
import com.alipay.sdk.sys.c;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.k;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import java.util.Random;

public final class d
{
  private static final String d = "virtualImeiAndImsi";
  private static final String e = "virtual_imei";
  private static final String f = "virtual_imsi";
  private static d g;
  String a;
  String b = "sdk-and-lite";
  String c;

  public static d a()
  {
    monitorenter;
    try
    {
      if (g == null)
        g = new d();
      d locald = g;
      return locald;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String a(Context paramContext)
  {
    return Float.toString(new TextView(paramContext).getTextSize());
  }

  static String a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Object localObject = "";
    try
    {
      String str = SecurityClientMobile.GetApdid(paramContext, paramHashMap);
      localObject = str;
      label13: new StringBuilder("apdid:").append((String)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }

  private String a(com.alipay.sdk.tid.b paramb)
  {
    Context localContext1 = com.alipay.sdk.sys.b.a().a;
    com.alipay.sdk.util.b localb = com.alipay.sdk.util.b.a(localContext1);
    if (TextUtils.isEmpty(this.a))
    {
      String str15 = k.a();
      String str16 = k.b();
      String str17 = k.d(localContext1);
      String str18 = a.b;
      String str19 = str18.substring(0, str18.indexOf("://"));
      String str20 = k.e(localContext1);
      String str21 = Float.toString(new TextView(localContext1).getTextSize());
      this.a = ("Msp/15.0.0" + " (" + str15 + ";" + str16 + ";" + str17 + ";" + str19 + ";" + str20 + ";" + str21);
    }
    String str1 = com.alipay.sdk.util.b.b(localContext1).a();
    String str2 = localb.a();
    String str3 = localb.b();
    Context localContext2 = com.alipay.sdk.sys.b.a().a;
    SharedPreferences localSharedPreferences1 = localContext2.getSharedPreferences("virtualImeiAndImsi", 0);
    String str4 = localSharedPreferences1.getString("virtual_imsi", null);
    String str14;
    String str5;
    Context localContext3;
    String str6;
    label335: String str7;
    String str8;
    String str9;
    boolean bool;
    String str10;
    String str11;
    label434: WifiInfo localWifiInfo2;
    if (TextUtils.isEmpty(str4))
    {
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a))
        break label742;
      str14 = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
      if (TextUtils.isEmpty(str14))
      {
        str4 = b();
        localSharedPreferences1.edit().putString("virtual_imsi", str4).commit();
      }
    }
    else
    {
      str5 = str4;
      localContext3 = com.alipay.sdk.sys.b.a().a;
      SharedPreferences localSharedPreferences2 = localContext3.getSharedPreferences("virtualImeiAndImsi", 0);
      str6 = localSharedPreferences2.getString("virtual_imei", null);
      if (TextUtils.isEmpty(str6))
      {
        if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a))
          break label755;
        str6 = b();
        localSharedPreferences2.edit().putString("virtual_imei", str6).commit();
      }
      str7 = str6;
      if (paramb != null)
        this.c = paramb.b;
      str8 = Build.MANUFACTURER.replace(";", " ");
      str9 = Build.MODEL.replace(";", " ");
      bool = com.alipay.sdk.sys.b.b();
      str10 = localb.c();
      WifiInfo localWifiInfo1 = ((WifiManager)localContext1.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo1 == null)
        break label768;
      str11 = localWifiInfo1.getSSID();
      localWifiInfo2 = ((WifiManager)localContext1.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo2 == null)
        break label775;
    }
    label768: label775: for (String str12 = localWifiInfo2.getBSSID(); ; str12 = "00")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a).append(";").append(str1).append(";").append("-1;-1").append(";").append("1").append(";").append(str2).append(";").append(str3).append(";").append(this.c).append(";").append(str8).append(";").append(str9).append(";").append(bool).append(";").append(str10).append(";").append(c.a()).append(";").append(this.b).append(";").append(str5).append(";").append(str7).append(";").append(str11).append(";").append(str12);
      if (paramb != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("tid", paramb.a);
        localHashMap.put("utdid", UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a));
        String str13 = a(localContext1, localHashMap);
        if (!TextUtils.isEmpty(str13))
          localStringBuilder.append(";").append(str13);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str4 = str14.substring(3, 18);
      break;
      label742: str4 = com.alipay.sdk.util.b.a(localContext2).a();
      break;
      label755: str6 = com.alipay.sdk.util.b.a(localContext3).b();
      break label335;
      str11 = "-1";
      break label434;
    }
  }

  static String b()
  {
    String str = Long.toHexString(System.currentTimeMillis());
    Random localRandom = new Random();
    return str + (1000 + localRandom.nextInt(9000));
  }

  private static String b(Context paramContext)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
      return localWifiInfo.getSSID();
    return "-1";
  }

  private String c()
  {
    return this.c;
  }

  private static String c(Context paramContext)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
      return localWifiInfo.getBSSID();
    return "00";
  }

  private static String d()
  {
    return "1";
  }

  private static String e()
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("virtualImeiAndImsi", 0);
    String str = localSharedPreferences.getString("virtual_imei", null);
    if (TextUtils.isEmpty(str))
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a))
        break label70;
    label70: for (str = b(); ; str = com.alipay.sdk.util.b.a(localContext).b())
    {
      localSharedPreferences.edit().putString("virtual_imei", str).commit();
      return str;
    }
  }

  private static String f()
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("virtualImeiAndImsi", 0);
    String str1 = localSharedPreferences.getString("virtual_imsi", null);
    String str2;
    if (TextUtils.isEmpty(str1))
    {
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a))
        break label101;
      str2 = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
      if (!TextUtils.isEmpty(str2))
        break label89;
      str1 = b();
    }
    while (true)
    {
      localSharedPreferences.edit().putString("virtual_imsi", str1).commit();
      return str1;
      label89: str1 = str2.substring(3, 18);
      continue;
      label101: str1 = com.alipay.sdk.util.b.a(localContext).a();
    }
  }

  public final void a(String paramString)
  {
    monitorenter;
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool);
      while (true)
      {
        return;
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().a).edit().putString("trideskey", paramString).commit();
        a.c = paramString;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.data.d
 * JD-Core Version:    0.6.0
 */