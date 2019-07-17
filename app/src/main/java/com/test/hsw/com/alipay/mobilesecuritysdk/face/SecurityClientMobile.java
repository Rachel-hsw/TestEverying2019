package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.d;
import com.alipay.apmobilesecuritysdk.a.e;
import com.alipay.apmobilesecuritysdk.a.i;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

public class SecurityClientMobile
{
  public static String GetApdid(Context paramContext, Map<String, String> paramMap)
  {
    monitorenter;
    try
    {
      Object localObject2 = i.a();
      boolean bool = com.alipay.security.mobile.module.a.a.a((String)localObject2);
      if (!bool);
      while (true)
      {
        return localObject2;
        e locale = d.a(paramContext);
        if ((locale != null) && (!com.alipay.security.mobile.module.a.a.a(locale.a())))
        {
          localObject2 = locale.a();
          continue;
        }
        localObject2 = com.alipay.apmobilesecuritysdk.a.a.a.a(paramContext);
        if (!com.alipay.security.mobile.module.a.a.a((String)localObject2))
          continue;
        HashMap localHashMap = new HashMap();
        localHashMap.put("utdid", com.alipay.security.mobile.module.a.a.a(paramMap, "utdid", ""));
        localHashMap.put("tid", com.alipay.security.mobile.module.a.a.a(paramMap, "tid", ""));
        localHashMap.put("userId", com.alipay.security.mobile.module.a.a.a(paramMap, "userId", ""));
        APSecuritySdk.getInstance(paramContext).initToken(0, localHashMap, null);
        String str = b.a(paramContext);
        localObject2 = str;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.mobilesecuritysdk.face.SecurityClientMobile
 * JD-Core Version:    0.6.0
 */