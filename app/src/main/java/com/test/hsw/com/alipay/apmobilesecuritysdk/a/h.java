package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.security.mobile.module.a.a;

public final class h
{
  // ERROR //
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 10
    //   6: iconst_0
    //   7: invokevirtual 16	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface 22 1 0
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +28 -> 47
    //   22: aload 4
    //   24: ldc 24
    //   26: invokestatic 29	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 32	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokeinterface 38 3 0
    //   38: pop
    //   39: aload 4
    //   41: invokeinterface 42 1 0
    //   46: pop
    //   47: ldc 2
    //   49: monitorexit
    //   50: return
    //   51: astore_3
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    //   57: astore_2
    //   58: goto -11 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   3	17	51	finally
    //   22	47	51	finally
    //   3	17	57	java/lang/Throwable
    //   22	47	57	java/lang/Throwable
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      String str1 = com.alipay.security.mobile.module.c.c.a(paramContext, "vkeyid_settings", "log_switch", "");
      if (a.a(str1))
        return true;
      String str2 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str1);
      if (!a.a(str2))
      {
        boolean bool = str2.equals("1");
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return true;
  }

  public static long b(Context paramContext)
  {
    try
    {
      String str1 = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_valid", "");
      if (a.a(str1))
        return 0L;
      String str2 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str1);
      if (!a.a(str2))
      {
        long l = Long.parseLong(str2);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return 0L;
  }

  // ERROR //
  public static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 10
    //   6: iconst_0
    //   7: invokevirtual 16	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface 22 1 0
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +28 -> 47
    //   22: aload 4
    //   24: ldc 82
    //   26: invokestatic 29	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 32	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokeinterface 38 3 0
    //   38: pop
    //   39: aload 4
    //   41: invokeinterface 42 1 0
    //   46: pop
    //   47: ldc 2
    //   49: monitorexit
    //   50: return
    //   51: astore_3
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    //   57: astore_2
    //   58: goto -11 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   3	17	51	finally
    //   22	47	51	finally
    //   3	17	57	java/lang/Throwable
    //   22	47	57	java/lang/Throwable
  }

  public static String c(Context paramContext)
  {
    monitorenter;
    try
    {
      String str2 = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist", "");
      if (a.a(str2))
        str1 = "";
      while (true)
      {
        return str1;
        str1 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str2);
        if (!a.a(str1))
          continue;
        str1 = "";
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        String str1 = "";
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String d(Context paramContext)
  {
    monitorenter;
    try
    {
      String str2 = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist_version", "");
      if (a.a(str2))
        str1 = "";
      while (true)
      {
        return str1;
        str1 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str2);
        if (!a.a(str1))
          continue;
        str1 = "";
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        String str1 = "";
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.h
 * JD-Core Version:    0.6.0
 */