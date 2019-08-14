package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.d.a;
import com.xiaomi.a.a.e.b;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class y
{
  private static x a;

  public static x a(Context paramContext)
  {
    monitorenter;
    while (true)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      int i;
      try
      {
        if (a == null)
          continue;
        localx = a;
        return localx;
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_account", 0);
        str1 = localSharedPreferences.getString("uuid", null);
        str2 = localSharedPreferences.getString("token", null);
        str3 = localSharedPreferences.getString("security", null);
        str4 = localSharedPreferences.getString("app_id", null);
        str5 = localSharedPreferences.getString("app_token", null);
        str6 = localSharedPreferences.getString("package_name", null);
        String str7 = localSharedPreferences.getString("device_id", null);
        i = localSharedPreferences.getInt("env_type", 1);
        if ((TextUtils.isEmpty(str7)) || (!str7.startsWith("a-")))
          continue;
        str7 = w.c(paramContext);
        localSharedPreferences.edit().putString("device_id", str7).commit();
        boolean bool1 = TextUtils.isEmpty(str1);
        localx = null;
        if (bool1)
          continue;
        boolean bool2 = TextUtils.isEmpty(str2);
        localx = null;
        if (bool2)
          continue;
        boolean bool3 = TextUtils.isEmpty(str3);
        localx = null;
        if (bool3)
          continue;
        String str8 = w.c(paramContext);
        if ((!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str7)) && (!str7.equals(str8)))
        {
          c.d("erase the old account.");
          b(paramContext);
          localx = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      a = new x(str1, str2, str3, str4, str5, str6, i);
      x localx = a;
    }
  }

  public static x a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    monitorenter;
    while (true)
    {
      try
      {
        TreeMap localTreeMap = new TreeMap();
        localTreeMap.put("devid", w.a(paramContext));
        if (!c(paramContext))
          continue;
        String str1 = "1000271";
        if (!c(paramContext))
          continue;
        String str2 = "420100086271";
        if (!c(paramContext))
          continue;
        String str3 = "com.xiaomi.xmsf";
        localTreeMap.put("appid", str1);
        localTreeMap.put("apptoken", str2);
        try
        {
          PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(str3, 16384);
          localPackageInfo1 = localPackageInfo2;
          if (localPackageInfo1 != null)
          {
            str4 = String.valueOf(localPackageInfo1.versionCode);
            localTreeMap.put("appversion", str4);
            localTreeMap.put("'sdkversion", Integer.toString(7));
            localTreeMap.put("packagename", str3);
            localTreeMap.put("model", Build.MODEL);
            localTreeMap.put("imei_md5", com.xiaomi.a.a.g.d.a(w.b(paramContext)));
            localTreeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            b localb = com.xiaomi.a.a.e.d.a(paramContext, a(), localTreeMap);
            str5 = "";
            if (localb == null)
              continue;
            str5 = localb.a();
            boolean bool = TextUtils.isEmpty(str5);
            localx = null;
            if (bool)
              continue;
            localJSONObject1 = new JSONObject(str5);
            if (localJSONObject1.getInt("code") != 0)
              continue;
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
            String str6 = localJSONObject2.getString("ssecurity");
            String str7 = localJSONObject2.getString("token");
            String str8 = localJSONObject2.getString("userId");
            localx = new x(str8 + "@xiaomi.com/an" + com.xiaomi.a.a.g.d.a(6), str7, str6, str1, str2, str3, a.c());
            a(paramContext, localx);
            a = localx;
            monitorexit;
            return localx;
            str1 = paramString2;
            continue;
            str2 = paramString3;
            continue;
            str3 = paramString1;
          }
        }
        catch (Exception localException)
        {
          String str5;
          JSONObject localJSONObject1;
          c.a(localException);
          PackageInfo localPackageInfo1 = null;
          continue;
          ab.a(paramContext, localJSONObject1.getInt("code"), localJSONObject1.optString("description"));
          c.a(str5);
          x localx = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      String str4 = "0";
    }
  }

  public static String a()
  {
    if (a.b())
      return "http://10.237.12.17:9085/pass/register";
    StringBuilder localStringBuilder = new StringBuilder().append("https://");
    if (a.a());
    for (String str = "sandbox.xmpush.xiaomi.com"; ; str = "register.xmpush.xiaomi.com")
      return str + "/pass/register";
  }

  private static void a(Context paramContext, x paramx)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("mipush_account", 0).edit();
    localEditor.putString("uuid", paramx.a);
    localEditor.putString("security", paramx.c);
    localEditor.putString("token", paramx.b);
    localEditor.putString("app_id", paramx.d);
    localEditor.putString("package_name", paramx.f);
    localEditor.putString("app_token", paramx.e);
    localEditor.putString("device_id", w.c(paramContext));
    localEditor.putInt("env_type", paramx.g);
    localEditor.commit();
  }

  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_account", 0).edit().clear().commit();
    a = null;
  }

  private static boolean c(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.y
 * JD-Core Version:    0.6.0
 */