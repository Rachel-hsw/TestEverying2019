package com.umeng.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public abstract class s
{
  private static Map<String, String> a;

  protected static String a(Context paramContext)
  {
    String str1 = r.d;
    if (!TextUtils.isEmpty(str1))
    {
      o.b("MobclickAgent", "use usefully appkey from constant field.");
      return str1;
    }
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str2 = localApplicationInfo.metaData.getString("UMENG_APPKEY");
        if (str2 != null)
          return str2.trim();
        o.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
      }
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        o.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", localException);
    }
  }

  private static String a(List<NameValuePair> paramList)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      new UrlEncodedFormEntity(paramList, "UTF-8").writeTo(localByteArrayOutputStream);
      String str = localByteArrayOutputStream.toString();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private static List<NameValuePair> a(a[] paramArrayOfa)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      a locala = paramArrayOfa[j];
      localStringBuilder1.append(locala.b().toString());
      localStringBuilder1.append(',');
      localStringBuilder2.append(locala.c());
      localStringBuilder2.append(',');
      localStringBuilder3.append(locala.a());
      localStringBuilder3.append(',');
    }
    if (paramArrayOfa.length > 0)
    {
      localStringBuilder1.deleteCharAt(-1 + localStringBuilder1.length());
      localStringBuilder2.deleteCharAt(-1 + localStringBuilder2.length());
      localStringBuilder3.deleteCharAt(-1 + localStringBuilder3.length());
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("platform", localStringBuilder1.toString()));
    localArrayList.add(new BasicNameValuePair("usid", localStringBuilder2.toString()));
    if (localStringBuilder3.length() > 0)
      localArrayList.add(new BasicNameValuePair("weiboid", localStringBuilder3.toString()));
    return localArrayList;
  }

  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }

  protected static String[] a(Context paramContext, String paramString, a[] paramArrayOfa)
    throws n
  {
    if ((paramArrayOfa == null) || (paramArrayOfa.length == 0))
      throw new n("platform data is null");
    String str1 = a(paramContext);
    if (TextUtils.isEmpty(str1))
      throw new n("can`t get appkey.");
    ArrayList localArrayList = new ArrayList();
    String str2 = "http://log.umsns.com/share/api/" + str1 + "/";
    if ((a == null) || (a.isEmpty()))
      a = c(paramContext);
    if ((a != null) && (!a.isEmpty()))
    {
      Iterator localIterator = a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    localArrayList.add(new BasicNameValuePair("date", String.valueOf(System.currentTimeMillis())));
    localArrayList.add(new BasicNameValuePair("channel", r.e));
    if (!TextUtils.isEmpty(paramString))
      localArrayList.add(new BasicNameValuePair("topic", paramString));
    localArrayList.addAll(a(paramArrayOfa));
    String str3 = b(paramArrayOfa);
    if (str3 == null)
      str3 = "null";
    String str4 = str2 + "?" + a(localArrayList);
    o.c("MobclickAgent", "URL:" + str4);
    o.c("MobclickAgent", "BODY:" + str3);
    return new String[] { str4, str3 };
  }

  private static String b(a[] paramArrayOfa)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int i = paramArrayOfa.length;
    label132: label175: for (int j = 0; ; j++)
      if (j < i)
      {
        a locala = paramArrayOfa[j];
        a.a locala1 = locala.e();
        String str1 = locala.d();
        if (locala1 == null);
        try
        {
          if (TextUtils.isEmpty(str1))
            continue;
          JSONObject localJSONObject2 = new JSONObject();
          String str2;
          if (locala1 == null)
          {
            str2 = "";
            localJSONObject2.put("gender", str2);
            if (str1 != null)
              break label132;
          }
          String str3;
          for (Object localObject = ""; ; localObject = str3)
          {
            localJSONObject2.put("name", localObject);
            localJSONObject1.put(locala.b().toString(), localJSONObject2);
            break label175;
            str2 = String.valueOf(locala1.c);
            break;
            str3 = String.valueOf(str1);
          }
        }
        catch (Exception localException)
        {
          throw new n("build body exception", localException);
        }
      }
      else
      {
        if (localJSONObject1.length() == 0)
          return null;
        return localJSONObject1.toString();
      }
  }

  public static Map<String, String> b(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null)
      o.e("MobclickAgent", "No IMEI.");
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str4 = localTelephonyManager.getDeviceId();
        str1 = str4;
        String str2 = d(paramContext);
        String str3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(str2))
          localHashMap.put("mac", str2);
        if (!TextUtils.isEmpty(str1))
          localHashMap.put("imei", str1);
        if (!TextUtils.isEmpty(str3))
          localHashMap.put("android_id", str3);
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        o.e("MobclickAgent", "No IMEI.", localException);
        String str1 = null;
      }
    }
  }

  private static Map<String, String> c(Context paramContext)
    throws n
  {
    HashMap localHashMap = new HashMap();
    Map localMap = b(paramContext);
    if ((localMap != null) && (!localMap.isEmpty()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (TextUtils.isEmpty((CharSequence)localEntry.getValue()))
          continue;
        localStringBuilder2.append((String)localEntry.getKey()).append(",");
        localStringBuilder1.append((String)localEntry.getValue()).append(",");
      }
      if (localStringBuilder1.length() > 0)
      {
        localStringBuilder1.deleteCharAt(-1 + localStringBuilder1.length());
        localHashMap.put("deviceid", localStringBuilder1.toString());
      }
      if (localStringBuilder2.length() > 0)
      {
        localStringBuilder2.deleteCharAt(-1 + localStringBuilder2.length());
        localHashMap.put("idtype", localStringBuilder2.toString());
      }
      return localHashMap;
    }
    throw new n("can`t get device id.");
  }

  private static String d(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        return localWifiManager.getConnectionInfo().getMacAddress();
      o.e("MobclickAgent", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
      return "";
    }
    catch (Exception localException)
    {
      while (true)
        o.e("MobclickAgent", "Could not get mac address." + localException.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.b.s
 * JD-Core Version:    0.6.0
 */