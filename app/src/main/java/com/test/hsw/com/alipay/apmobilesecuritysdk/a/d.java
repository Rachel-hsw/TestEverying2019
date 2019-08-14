package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import org.json.JSONObject;

public final class d
{
  public static e a()
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
        try
        {
          JSONObject localJSONObject = new JSONObject(str);
          e locale = new e(localJSONObject.optString("apdid"), localJSONObject.optString("deviceInfoHash"), localJSONObject.optString("token"), localJSONObject.optString("timestamp"));
          localObject2 = locale;
        }
        catch (Exception localException)
        {
          com.alipay.security.mobile.module.a.c.a(localException);
          localObject2 = null;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public static e a(Context paramContext)
  {
    monitorenter;
    try
    {
      String str = c(paramContext);
      if (com.alipay.security.mobile.module.a.a.a(str))
        str = b();
      boolean bool = com.alipay.security.mobile.module.a.a.a(str);
      Object localObject2 = null;
      if (bool);
      while (true)
      {
        return localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject(str);
          e locale = new e(localJSONObject.optString("apdid"), localJSONObject.optString("deviceInfoHash"), localJSONObject.optString("token"), localJSONObject.optString("timestamp"));
          localObject2 = locale;
        }
        catch (Exception localException)
        {
          com.alipay.security.mobile.module.a.c.a(localException);
          localObject2 = null;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  // ERROR //
  public static void a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 19	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 56	org/json/JSONObject:<init>	()V
    //   10: astore_2
    //   11: aload_2
    //   12: ldc 27
    //   14: aload_1
    //   15: invokevirtual 58	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   18: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_2
    //   23: ldc 33
    //   25: aload_1
    //   26: invokevirtual 63	com/alipay/apmobilesecuritysdk/a/e:b	()Ljava/lang/String;
    //   29: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload_2
    //   34: ldc 35
    //   36: aload_1
    //   37: invokevirtual 65	com/alipay/apmobilesecuritysdk/a/e:c	()Ljava/lang/String;
    //   40: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_2
    //   45: ldc 37
    //   47: aload_1
    //   48: invokevirtual 68	com/alipay/apmobilesecuritysdk/a/e:d	()Ljava/lang/String;
    //   51: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 71	org/json/JSONObject:toString	()Ljava/lang/String;
    //   59: astore 9
    //   61: invokestatic 74	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   64: aload 9
    //   66: invokestatic 77	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 10
    //   71: aload 10
    //   73: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   76: ifne +32 -> 108
    //   79: new 79	java/util/HashMap
    //   82: dup
    //   83: invokespecial 80	java/util/HashMap:<init>	()V
    //   86: astore 11
    //   88: aload 11
    //   90: ldc 82
    //   92: aload 10
    //   94: invokeinterface 87 3 0
    //   99: pop
    //   100: aload_0
    //   101: ldc 89
    //   103: aload 11
    //   105: invokestatic 94	com/alipay/security/mobile/module/c/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    //   108: aload 9
    //   110: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   113: istore 13
    //   115: iload 13
    //   117: ifne +42 -> 159
    //   120: invokestatic 74	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   123: aload 9
    //   125: invokestatic 77	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 15
    //   130: new 19	org/json/JSONObject
    //   133: dup
    //   134: invokespecial 56	org/json/JSONObject:<init>	()V
    //   137: astore 16
    //   139: aload 16
    //   141: ldc 96
    //   143: aload 15
    //   145: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: ldc 98
    //   151: aload 16
    //   153: invokevirtual 71	org/json/JSONObject:toString	()Ljava/lang/String;
    //   156: invokestatic 103	com/alipay/security/mobile/module/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: ldc 2
    //   161: monitorexit
    //   162: return
    //   163: astore 4
    //   165: aload 4
    //   167: invokestatic 45	com/alipay/security/mobile/module/a/c:a	(Ljava/lang/Throwable;)V
    //   170: goto -11 -> 159
    //   173: astore_3
    //   174: ldc 2
    //   176: monitorexit
    //   177: aload_3
    //   178: athrow
    //   179: astore 14
    //   181: goto -22 -> 159
    //
    // Exception table:
    //   from	to	target	type
    //   3	108	163	org/json/JSONException
    //   108	115	163	org/json/JSONException
    //   120	159	163	org/json/JSONException
    //   3	108	173	finally
    //   108	115	173	finally
    //   120	159	173	finally
    //   165	170	173	finally
    //   120	159	179	java/lang/Exception
  }

  public static e b(Context paramContext)
  {
    monitorenter;
    try
    {
      String str = c(paramContext);
      boolean bool = com.alipay.security.mobile.module.a.a.a(str);
      Object localObject2 = null;
      if (bool);
      while (true)
      {
        return localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject(str);
          e locale = new e(localJSONObject.optString("apdid"), localJSONObject.optString("deviceInfoHash"), localJSONObject.optString("token"), localJSONObject.optString("timestamp"));
          localObject2 = locale;
        }
        catch (Exception localException)
        {
          com.alipay.security.mobile.module.a.c.a(localException);
          localObject2 = null;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  private static String b()
  {
    String str1 = com.alipay.security.mobile.module.c.a.a("wxcasxx_v3");
    try
    {
      String str2 = new JSONObject(str1).getString("wxcasxx");
      String str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str2);
      return str3;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String c(Context paramContext)
  {
    String str = com.alipay.security.mobile.module.c.c.a(paramContext, "vkeyid_profiles_v3", "deviceid", "");
    if (com.alipay.security.mobile.module.a.a.a(str))
      return null;
    return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.d
 * JD-Core Version:    0.6.0
 */