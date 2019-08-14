package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public static Map<String, String> a(Context paramContext)
  {
    monitorenter;
    try
    {
      com.alipay.security.mobile.module.b.c.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("AE1", com.alipay.security.mobile.module.b.c.b());
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1;
      StringBuilder localStringBuilder2;
      if (com.alipay.security.mobile.module.b.c.c())
      {
        str1 = "1";
        localHashMap.put("AE2", str1);
        localStringBuilder2 = new StringBuilder();
        if (!com.alipay.security.mobile.module.b.c.a(paramContext))
          break label260;
      }
      label260: for (String str2 = "1"; ; str2 = "0")
      {
        localHashMap.put("AE3", str2);
        localHashMap.put("AE4", com.alipay.security.mobile.module.b.c.d());
        localHashMap.put("AE5", com.alipay.security.mobile.module.b.c.e());
        localHashMap.put("AE6", com.alipay.security.mobile.module.b.c.f());
        localHashMap.put("AE7", com.alipay.security.mobile.module.b.c.g());
        localHashMap.put("AE8", com.alipay.security.mobile.module.b.c.h());
        localHashMap.put("AE9", com.alipay.security.mobile.module.b.c.i());
        localHashMap.put("AE10", com.alipay.security.mobile.module.b.c.j());
        localHashMap.put("AE11", com.alipay.security.mobile.module.b.c.k());
        localHashMap.put("AE12", com.alipay.security.mobile.module.b.c.l());
        localHashMap.put("AE13", com.alipay.security.mobile.module.b.c.m());
        localHashMap.put("AE14", com.alipay.security.mobile.module.b.c.n());
        localHashMap.put("AE15", com.alipay.security.mobile.module.b.c.o());
        return localHashMap;
        str1 = "0";
        break;
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
 * Qualified Name:     com.alipay.apmobilesecuritysdk.d.c
 * JD-Core Version:    0.6.0
 */