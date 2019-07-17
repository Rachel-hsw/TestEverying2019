package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static Map<String, String> a(Context paramContext)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("AA1", paramContext.getPackageName());
      localHashMap.put("AA2", b(paramContext));
      localHashMap.put("AA3", "security-sdk-token");
      localHashMap.put("AA4", "3.0.2.20150525");
      monitorexit;
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionName;
      return str;
    }
    catch (Exception localException)
    {
    }
    return "0.0.0";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.d.a
 * JD-Core Version:    0.6.0
 */