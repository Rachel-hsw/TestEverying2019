package com.alipay.apmobilesecuritysdk.a.a;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.e;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  public static String a()
  {
    monitorenter;
    try
    {
      String str = b();
      boolean bool = com.alipay.security.mobile.module.a.a.a(str);
      Object localObject2 = null;
      if (bool);
      while (true)
      {
        return localObject2;
        String[] arrayOfString = str.split("`");
        localObject2 = null;
        if (arrayOfString == null)
          continue;
        int i = arrayOfString.length;
        localObject2 = null;
        if (i < 2)
          continue;
        localObject2 = arrayOfString[0];
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public static String a(Context paramContext)
  {
    monitorenter;
    try
    {
      Object localObject2 = a();
      if (com.alipay.security.mobile.module.a.a.a((String)localObject2))
      {
        String str = b(paramContext);
        localObject2 = str;
      }
      monitorexit;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      monitorexit;
    }
    throw localObject1;
  }

  public static void a(e parame)
  {
    monitorenter;
    try
    {
      boolean bool = com.alipay.security.mobile.module.a.a.a(parame.a());
      if (bool);
      while (true)
      {
        return;
        if (parame.a().equals(a()))
          continue;
        String str1 = parame.a() + "`" + parame.d();
        if (str1 == null)
          continue;
        try
        {
          String str2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("device", str2);
          com.alipay.security.mobile.module.c.a.a("deviceid_v2", localJSONObject.toString());
        }
        catch (Exception localException)
        {
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String b()
  {
    String str1 = com.alipay.security.mobile.module.c.a.a("deviceid_v2");
    try
    {
      String str2 = new JSONObject(str1).getString("device");
      String str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str2);
      return str3;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String b(Context paramContext)
  {
    monitorenter;
    try
    {
      String str2 = com.alipay.security.mobile.module.c.c.a(paramContext, "profiles", "deviceid", "");
      String str3;
      if (com.alipay.security.mobile.module.a.a.a(str2))
      {
        str3 = null;
        boolean bool = com.alipay.security.mobile.module.a.a.a(str3);
        str1 = null;
        if (!bool)
          break label58;
      }
      while (true)
      {
        return str1;
        str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str2);
        break;
        label58: new b();
        Map localMap = b.a(str3);
        if (localMap == null)
          break label95;
        str1 = (String)localMap.get("deviceId");
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        label95: String str1 = "";
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.a.a
 * JD-Core Version:    0.6.0
 */