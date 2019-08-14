package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class k
{
  public static final String a = "appid";
  public static final String b = "appkey";
  private static final String c = k.class.getName();
  private static final String d = "qq_sso";

  public static Map<com.umeng.socialize.bean.p, String> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    while (true)
    {
      int j;
      try
      {
        com.umeng.socialize.bean.p[] arrayOfp = com.umeng.socialize.bean.p.d();
        int i = arrayOfp.length;
        j = 0;
        if (j < i)
        {
          com.umeng.socialize.bean.p localp = arrayOfp[j];
          if (!a(paramContext, localp))
            continue;
          String str = e(paramContext, localp);
          localHashMap.put(localp, str);
          i.a(c, "found platform " + localp.toString() + " usid=" + str);
          break label177;
          i.a(c, "No found oauthed platform " + localp.toString());
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        i.a(c, "no authenticated platform.......");
        return null;
      }
      i.a(c, "found platform count " + localHashMap.size());
      return localHashMap;
      label177: j++;
    }
  }

  public static void a(Context paramContext, Bundle paramBundle)
  {
    a(paramContext, paramBundle.getString("access_token"), paramBundle.getString("openid"), paramBundle.getString("expires_in"));
  }

  public static void a(Context paramContext, com.umeng.socialize.bean.p paramp, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_refresh_token_expires", 0);
    long l = paramLong + System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putLong(paramp.toString(), l);
    localEditor.commit();
  }

  public static void a(Context paramContext, com.umeng.socialize.bean.p paramp, String paramString)
  {
    if (paramContext == null)
      i.e(c, "context is null when save expires in");
    String str;
    do
    {
      return;
      str = com.umeng.socialize.common.p.a(paramp);
      if (!TextUtils.isEmpty(str))
        continue;
      i.e(c, "platform is null when save expires in ");
      return;
    }
    while (TextUtils.isEmpty(paramString));
    try
    {
      long l3 = Long.valueOf(paramString).longValue();
      l1 = l3;
      if (l1 <= 0L)
      {
        i.e(c, str + " expires in is " + l1);
        return;
      }
    }
    catch (Exception localException)
    {
      long l1;
      while (true)
        l1 = 0L;
      long l2 = l1 + System.currentTimeMillis() / 1000L;
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize_token_expire_in", 0).edit();
      localEditor.putLong(str, l2);
      localEditor.commit();
    }
  }

  public static void a(Context paramContext, com.umeng.socialize.bean.p paramp, String paramString1, String paramString2)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      String str = com.umeng.socialize.common.p.a(paramp);
      if (!TextUtils.isEmpty(str))
      {
        localEditor.putString(str + "_ak", paramString1);
        localEditor.putString(str + "_as", paramString2);
        localEditor.commit();
      }
      return;
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize_qq", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      localEditor.putString("appid", paramString1);
      localEditor.putString(paramString2, paramString2);
      localEditor.commit();
      return;
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize_qq", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)))
      {
        localEditor.putString("qq_sso_token", paramString1);
        localEditor.putString("qq_sso_openid", paramString2);
        localEditor.putString("qq_sso_expires_in", b(paramString3));
        localEditor.commit();
        i.c(c, "### Saved QQ Token.");
      }
      return;
    }
  }

  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    a(paramContext, paramJSONObject.optString("access_token", ""), paramJSONObject.optString("openid", ""), paramJSONObject.optString("expires_in", ""));
  }

  public static boolean a(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    if (paramContext == null)
      i.e(c, "context对象为空，请传递一个非空Context对象");
    do
    {
      return false;
      if ((paramp != null) && (paramp != com.umeng.socialize.bean.p.b))
        continue;
      i.e(c, "传递的检测授权平台无效");
      return false;
    }
    while (TextUtils.isEmpty(e(paramContext, paramp)));
    return true;
  }

  public static boolean a(String paramString)
  {
    return System.currentTimeMillis() / 1000L >= Long.parseLong(paramString);
  }

  private static String b(String paramString)
  {
    return String.valueOf(System.currentTimeMillis() / 1000L + Long.parseLong(paramString));
  }

  public static void b(Context paramContext, com.umeng.socialize.bean.p paramp, String paramString)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      String str = com.umeng.socialize.common.p.a(paramp);
      if (!TextUtils.isEmpty(str))
      {
        localEditor.putString(str, paramString);
        localEditor.commit();
        i.c(c, "Save platform " + str + "   " + paramString);
      }
      return;
    }
  }

  public static boolean b(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    if (!a(paramContext, paramp));
    long l;
    do
    {
      return false;
      l = c(paramContext, paramp);
    }
    while (System.currentTimeMillis() / 1000L >= l);
    return true;
  }

  public static String[] b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_qq", 0);
    String str1;
    String str2;
    String str3;
    if ((localSharedPreferences.contains("qq_sso_token")) && (localSharedPreferences.contains("qq_sso_openid")))
    {
      str1 = localSharedPreferences.getString("qq_sso_token", "");
      str2 = localSharedPreferences.getString("qq_sso_openid", "");
      str3 = localSharedPreferences.getString("qq_sso_expires_in", "");
      i.c(c, "get QQ Token." + str3);
      if (!a(str3));
    }
    else
    {
      return null;
    }
    return new String[] { str1, str2, str3 };
  }

  public static long c(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    if (paramContext == null)
    {
      i.e(c, "context is null when obtain expires in");
      return 0L;
    }
    String str = com.umeng.socialize.common.p.a(paramp);
    if (TextUtils.isEmpty(str))
    {
      i.e(c, "platform is null when save expires in ");
      return 0L;
    }
    return paramContext.getSharedPreferences("umeng_socialize_token_expire_in", 0).getLong(str, 0L);
  }

  public static Map<String, String> c(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_qq", 0);
    String str1 = localSharedPreferences.getString("appid", "");
    String str2 = localSharedPreferences.getString("appkey", "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", str1);
    localHashMap.put("appkey", str2);
    return localHashMap;
  }

  public static void c(Context paramContext, com.umeng.socialize.bean.p paramp, String paramString)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize_refresh_token", 0).edit();
    localEditor.putString(paramp.toString(), paramString);
    localEditor.commit();
  }

  public static void d(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    if (paramContext == null)
    {
      i.e(c, "context is null when removing expires in");
      return;
    }
    String str = com.umeng.socialize.common.p.a(paramp);
    if (TextUtils.isEmpty(str))
    {
      i.e(c, "platform is null when save expires in ");
      return;
    }
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize_token_expire_in", 0).edit();
    localEditor.remove(str);
    localEditor.commit();
  }

  public static String e(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    String str2;
    if (paramp == null)
      str2 = "";
    SharedPreferences localSharedPreferences;
    String str1;
    do
    {
      return str2;
      localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize", 0);
      str1 = com.umeng.socialize.common.p.a(paramp);
      str2 = "";
    }
    while (TextUtils.isEmpty(str1));
    return localSharedPreferences.getString(str1, "");
  }

  public static String[] f(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize", 0);
    String str1 = com.umeng.socialize.common.p.a(paramp);
    String str2 = str1 + "_ak";
    String str3 = str1 + "_as";
    if ((localSharedPreferences.contains(str2)) && (localSharedPreferences.contains(str3)))
      return new String[] { localSharedPreferences.getString(str2, ""), localSharedPreferences.getString(str3, "") };
    return new String[0];
  }

  public static void g(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    synchronized (paramContext.getSharedPreferences("umeng_socialize", 0))
    {
      SharedPreferences.Editor localEditor = ???.edit();
      localEditor.remove(paramp.toString());
      localEditor.remove(paramp.toString() + "_ak");
      localEditor.remove(paramp.toString() + "_as");
      localEditor.commit();
      i.c(c, "Remove platform " + paramp.toString());
      h(paramContext, paramp);
      return;
    }
  }

  public static void h(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    SharedPreferences.Editor localEditor1 = paramContext.getSharedPreferences("umeng_socialize_refresh_token", 0).edit();
    localEditor1.remove(paramp.toString());
    localEditor1.commit();
    SharedPreferences.Editor localEditor2 = paramContext.getSharedPreferences("umeng_socialize_refresh_token_expires", 0).edit();
    localEditor2.remove(paramp.toString());
    localEditor2.commit();
  }

  public static String i(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    return paramContext.getSharedPreferences("umeng_socialize_refresh_token", 0).getString(paramp.toString(), "");
  }

  public static boolean j(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_refresh_token_expires", 0);
    long l = System.currentTimeMillis() / 1000L;
    boolean bool = localSharedPreferences.getLong(paramp.toString(), 0L) < l;
    int i = 0;
    if (bool)
      i = 1;
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.k
 * JD-Core Version:    0.6.0
 */