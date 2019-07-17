package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = new HashMap();
      String str1 = a.a(paramMap, "tid", "");
      String str2 = a.a(paramMap, "utdid", "");
      String str3 = com.alipay.apmobilesecuritysdk.e.b.a(paramContext);
      String str4 = a.a(paramMap, "userId", "");
      localHashMap.put("AC1", str1);
      localHashMap.put("AC2", str2);
      localHashMap.put("AC3", "");
      localHashMap.put("AC4", str3);
      localHashMap.put("AC5", str4);
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
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.d.b
 * JD-Core Version:    0.6.0
 */