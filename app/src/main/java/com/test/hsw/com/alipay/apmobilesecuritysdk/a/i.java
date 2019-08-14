package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import com.alipay.security.mobile.module.a.c;

public final class i
{
  private static String a = "";
  private static String b = "";

  public static String a()
  {
    return a;
  }

  public static void a(e parame)
  {
    a = parame.a();
    b = parame.c();
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      long l = Math.abs(System.currentTimeMillis() - h.b(paramContext));
      if (l < 86400000L)
        return true;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return false;
  }

  public static String b()
  {
    return b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.i
 * JD-Core Version:    0.6.0
 */