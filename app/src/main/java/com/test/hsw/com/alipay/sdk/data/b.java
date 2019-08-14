package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.k;
import com.ta.utdid2.device.UTDevice;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final String a = "Msp-Param";

  public static e a()
  {
    a locala = new a();
    locala.a = com.alipay.sdk.cons.a.b;
    locala.b = "com.alipay.mobilecashier";
    locala.c = "/device/findAccount";
    locala.d = "3.0.0";
    com.alipay.sdk.sys.b localb = com.alipay.sdk.sys.b.a();
    com.alipay.sdk.tid.b localb1 = com.alipay.sdk.tid.b.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(localb1.a))
        localJSONObject.put("tid", localb1.a);
      localJSONObject.put("utdid", UTDevice.getUtdid(localb.a));
      localJSONObject.put("app_key", "2014052600006128");
      localJSONObject.put("new_client_key", localb1.b);
      localJSONObject.put("imei", com.alipay.sdk.util.b.a(localb.a).b());
      localJSONObject.put("imsi", com.alipay.sdk.util.b.a(localb.a).a());
      label138: return new e(locala, localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      break label138;
    }
  }

  public static e a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    com.alipay.sdk.sys.b localb = com.alipay.sdk.sys.b.a();
    com.alipay.sdk.tid.b localb1 = com.alipay.sdk.tid.b.a();
    JSONObject localJSONObject = com.alipay.sdk.util.c.a(null, paramJSONObject);
    try
    {
      localJSONObject.put("tid", localb1.a);
      d locald = localb.b;
      Context localContext1 = com.alipay.sdk.sys.b.a().a;
      com.alipay.sdk.util.b localb2 = com.alipay.sdk.util.b.a(localContext1);
      if (TextUtils.isEmpty(locald.a))
      {
        String str15 = k.a();
        String str16 = k.b();
        String str17 = k.d(localContext1);
        String str18 = com.alipay.sdk.cons.a.b;
        String str19 = str18.substring(0, str18.indexOf("://"));
        String str20 = k.e(localContext1);
        String str21 = Float.toString(new TextView(localContext1).getTextSize());
        locald.a = ("Msp/15.0.0" + " (" + str15 + ";" + str16 + ";" + str17 + ";" + str19 + ";" + str20 + ";" + str21);
      }
      String str1 = com.alipay.sdk.util.b.b(localContext1).a();
      String str2 = localb2.a();
      String str3 = localb2.b();
      Context localContext2 = com.alipay.sdk.sys.b.a().a;
      SharedPreferences localSharedPreferences1 = localContext2.getSharedPreferences("virtualImeiAndImsi", 0);
      String str4 = localSharedPreferences1.getString("virtual_imsi", null);
      String str14;
      String str5;
      Context localContext3;
      String str6;
      label381: String str7;
      String str8;
      String str9;
      boolean bool;
      String str10;
      WifiInfo localWifiInfo2;
      if (TextUtils.isEmpty(str4))
      {
        if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a))
          break label971;
        str14 = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
        if (TextUtils.isEmpty(str14))
        {
          str4 = d.b();
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
            break label984;
          str6 = d.b();
          localSharedPreferences2.edit().putString("virtual_imei", str6).commit();
        }
        str7 = str6;
        if (localb1 != null)
          locald.c = localb1.b;
        str8 = Build.MANUFACTURER.replace(";", " ");
        str9 = Build.MODEL.replace(";", " ");
        bool = com.alipay.sdk.sys.b.b();
        str10 = localb2.c();
        WifiInfo localWifiInfo1 = ((WifiManager)localContext1.getSystemService("wifi")).getConnectionInfo();
        if (localWifiInfo1 == null)
          break label1010;
        str11 = localWifiInfo1.getSSID();
        localWifiInfo2 = ((WifiManager)localContext1.getSystemService("wifi")).getConnectionInfo();
        if (localWifiInfo2 == null)
          break label997;
      }
      label971: label984: label997: for (String str12 = localWifiInfo2.getBSSID(); ; str12 = "00")
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(locald.a).append(";").append(str1).append(";").append("-1;-1").append(";").append("1").append(";").append(str2).append(";").append(str3).append(";").append(locald.c).append(";").append(str8).append(";").append(str9).append(";").append(bool).append(";").append(str10).append(";").append(com.alipay.sdk.sys.c.a()).append(";").append(locald.b).append(";").append(str5).append(";").append(str7).append(";").append(str11).append(";").append(str12);
        if (localb1 != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("tid", localb1.a);
          localHashMap.put("utdid", UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a));
          String str13 = d.a(localContext1, localHashMap);
          if (!TextUtils.isEmpty(str13))
            localStringBuilder.append(";").append(str13);
        }
        localStringBuilder.append(")");
        localJSONObject.put("user_agent", localStringBuilder.toString());
        localJSONObject.put("has_alipay", k.b(localb.a));
        localJSONObject.put("has_msp_app", k.a(localb.a));
        localJSONObject.put("external_info", paramString);
        localJSONObject.put("app_key", "2014052600006128");
        localJSONObject.put("utdid", UTDevice.getUtdid(localb.a));
        localJSONObject.put("new_client_key", localb1.b);
        a locala = new a();
        locala.a = com.alipay.sdk.cons.a.b;
        locala.b = "com.alipay.mobilecashier";
        locala.c = "/cashier/main";
        locala.d = "4.0.2";
        e locale = null;
        if (localJSONObject != null)
        {
          locale = new e(locala, localJSONObject);
          locale.d = true;
        }
        if (locale != null)
          a(paramc, locale, paramString);
        return locale;
        str4 = str14.substring(3, 18);
        break;
        str4 = com.alipay.sdk.util.b.a(localContext2).a();
        break;
        str6 = com.alipay.sdk.util.b.a(localContext3).b();
        break label381;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        continue;
        label1010: String str11 = "-1";
      }
    }
  }

  private static e a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    a locala = new a();
    locala.a = com.alipay.sdk.cons.a.b;
    locala.b = "com.alipay.mobilecashier";
    locala.c = "/cashier/main";
    locala.d = "4.0.2";
    e locale = null;
    if (paramJSONObject != null)
    {
      locale = new e(locala, paramJSONObject);
      locale.d = paramBoolean;
    }
    return locale;
  }

  private static String a(String paramString)
  {
    if (!paramString.contains("biz_type"))
      return null;
    return d(paramString);
  }

  private static void a(c paramc, e parame, String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    label75: label97: StringBuilder localStringBuilder;
    label130: label168: label178: label188: 
    do
    {
      String[] arrayOfString;
      do
      {
        return;
        arrayOfString = paramString.split("&");
      }
      while (arrayOfString.length == 0);
      int i = arrayOfString.length;
      int j = 0;
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      if (j < i)
      {
        String str2 = arrayOfString[j];
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (!str2.contains("biz_type"))
            localObject4 = null;
        }
        else
        {
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (str2.contains("biz_no"))
              break label168;
            localObject3 = null;
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if ((str2.contains("trade_no")) && (!str2.startsWith("out_trade_no")))
              break label178;
            localObject2 = null;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1))
            if (str2.contains("app_userid"))
              break label188;
        }
        for (localObject1 = null; ; localObject1 = d(str2))
        {
          j++;
          break;
          localObject4 = d(str2);
          break label75;
          localObject3 = d(str2);
          break label97;
          localObject2 = d(str2);
          break label130;
        }
      }
      localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty((CharSequence)localObject4))
        localStringBuilder.append("biz_type=" + (String)localObject4 + ";");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
        localStringBuilder.append("biz_no=" + (String)localObject3 + ";");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
        localStringBuilder.append("trade_no=" + (String)localObject2 + ";");
      if (TextUtils.isEmpty((CharSequence)localObject1))
        continue;
      localStringBuilder.append("app_userid=" + (String)localObject1 + ";");
    }
    while (localStringBuilder.length() == 0);
    String str1 = localStringBuilder.toString();
    if (str1.endsWith(";"))
      str1 = str1.substring(0, -1 + str1.length());
    Header[] arrayOfHeader = new Header[1];
    arrayOfHeader[0] = new BasicHeader("Msp-Param", str1);
    paramc.b = arrayOfHeader;
    parame.b = new WeakReference(paramc);
  }

  private static void a(c paramc, HttpResponse paramHttpResponse)
  {
    Header[] arrayOfHeader = paramHttpResponse.getHeaders("Msp-Param");
    if ((paramc != null) && (arrayOfHeader.length > 0))
      paramc.b = arrayOfHeader;
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = null;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      byte[] arrayOfByte2 = new byte[4096];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      while (true)
      {
        int i = localGZIPInputStream.read(arrayOfByte2, 0, arrayOfByte2.length);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte2, 0, i);
      }
      arrayOfByte1 = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      localGZIPInputStream.close();
      localByteArrayInputStream.close();
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
    }
    return arrayOfByte1;
  }

  private static String b(String paramString)
  {
    if (!paramString.contains("biz_no"))
      return null;
    return d(paramString);
  }

  private static String c(String paramString)
  {
    if ((!paramString.contains("trade_no")) || (paramString.startsWith("out_trade_no")))
      return null;
    return d(paramString);
  }

  private static String d(String paramString)
  {
    String[] arrayOfString = paramString.split("=");
    int i = arrayOfString.length;
    String str = null;
    if (i > 1)
    {
      str = arrayOfString[1];
      if (str.contains("\""))
        str = str.replaceAll("\"", "");
    }
    return str;
  }

  private static String e(String paramString)
  {
    if (!paramString.contains("app_userid"))
      return null;
    return d(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.data.b
 * JD-Core Version:    0.6.0
 */