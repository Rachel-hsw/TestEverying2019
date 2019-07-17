package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.alipay.sdk.data.c;
import com.alipay.sdk.data.e;
import com.alipay.sdk.widget.a;
import org.json.JSONObject;

public final class h
{
  private static final String a = "com.eg.android.AlipayGphone";
  private static final int b = 65;
  private static a c = null;
  private static String d = null;

  public static void a(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    if (a(paramActivity))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("alipayauth://platformapi/startapp");
      localStringBuilder1.append("?appId=20000122");
      localStringBuilder1.append("&approveType=005");
      localStringBuilder1.append("&scope=kuaijie");
      localStringBuilder1.append("&productId=");
      localStringBuilder1.append(paramAPAuthInfo.getProductId());
      localStringBuilder1.append("&thirdpartyId=");
      localStringBuilder1.append(paramAPAuthInfo.getAppId());
      localStringBuilder1.append("&redirectUri=");
      localStringBuilder1.append(paramAPAuthInfo.getRedirectUri());
      a(paramActivity, localStringBuilder1.toString());
      return;
    }
    if (paramActivity != null);
    try
    {
      if (!paramActivity.isFinishing())
      {
        a locala = new a(paramActivity);
        c = locala;
        locala.b();
        com.alipay.sdk.sys.b.a().a(paramActivity, com.alipay.sdk.data.d.a());
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("app_id=");
      localStringBuilder2.append(paramAPAuthInfo.getAppId());
      localStringBuilder2.append("&partner=");
      localStringBuilder2.append(paramAPAuthInfo.getPid());
      localStringBuilder2.append("&scope=kuaijie");
      localStringBuilder2.append("&login_goal=auth");
      localStringBuilder2.append("&redirect_url=");
      localStringBuilder2.append(paramAPAuthInfo.getRedirectUri());
      localStringBuilder2.append("&view=wap");
      localStringBuilder2.append("&prod_code=");
      localStringBuilder2.append(paramAPAuthInfo.getProductId());
      e locale = com.alipay.sdk.data.b.a(new c(), localStringBuilder2.toString(), new JSONObject());
      locale.a.b = "com.alipay.mobilecashier";
      locale.a.e = "com.alipay.mcpay";
      locale.a.d = "4.0.0";
      locale.a.c = "/cashier/main";
      new Thread(new i(new com.alipay.sdk.net.d(new c()), paramActivity, locale, paramAPAuthInfo)).start();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        c = null;
    }
  }

  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
  }

  private static boolean a(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (localPackageInfo == null)
        return false;
      int i = localPackageInfo.versionCode;
      if (i >= 65)
        return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static void b(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alipayauth://platformapi/startapp");
    localStringBuilder.append("?appId=20000122");
    localStringBuilder.append("&approveType=005");
    localStringBuilder.append("&scope=kuaijie");
    localStringBuilder.append("&productId=");
    localStringBuilder.append(paramAPAuthInfo.getProductId());
    localStringBuilder.append("&thirdpartyId=");
    localStringBuilder.append(paramAPAuthInfo.getAppId());
    localStringBuilder.append("&redirectUri=");
    localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
    a(paramActivity, localStringBuilder.toString());
  }

  private static void c(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    if (paramActivity != null);
    try
    {
      if (!paramActivity.isFinishing())
      {
        a locala = new a(paramActivity);
        c = locala;
        locala.b();
        com.alipay.sdk.sys.b.a().a(paramActivity, com.alipay.sdk.data.d.a());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("app_id=");
      localStringBuilder.append(paramAPAuthInfo.getAppId());
      localStringBuilder.append("&partner=");
      localStringBuilder.append(paramAPAuthInfo.getPid());
      localStringBuilder.append("&scope=kuaijie");
      localStringBuilder.append("&login_goal=auth");
      localStringBuilder.append("&redirect_url=");
      localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
      localStringBuilder.append("&view=wap");
      localStringBuilder.append("&prod_code=");
      localStringBuilder.append(paramAPAuthInfo.getProductId());
      e locale = com.alipay.sdk.data.b.a(new c(), localStringBuilder.toString(), new JSONObject());
      locale.a.b = "com.alipay.mobilecashier";
      locale.a.e = "com.alipay.mcpay";
      locale.a.d = "4.0.0";
      locale.a.c = "/cashier/main";
      new Thread(new i(new com.alipay.sdk.net.d(new c()), paramActivity, locale, paramAPAuthInfo)).start();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        c = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.auth.h
 * JD-Core Version:    0.6.0
 */