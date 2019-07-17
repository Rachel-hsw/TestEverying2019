package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.OpenConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a
{
  private static Class<?> a = null;
  private static Class<?> b = null;
  private static Method c = null;
  private static Method d = null;
  private static Method e = null;
  private static Method f = null;
  private static boolean g = false;

  public static void a(Context paramContext, QQToken paramQQToken, String paramString, String[] paramArrayOfString)
  {
    if (!g)
      return;
    b(paramContext, paramQQToken);
    try
    {
      d.invoke(b, new Object[] { paramContext, paramString, paramArrayOfString });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static boolean a(Context paramContext, QQToken paramQQToken)
  {
    return OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getBoolean("Common_ta_enable");
  }

  public static void b(Context paramContext, QQToken paramQQToken)
  {
    try
    {
      if (a(paramContext, paramQQToken))
      {
        Method localMethod2 = f;
        Class localClass2 = a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Boolean.valueOf(true);
        localMethod2.invoke(localClass2, arrayOfObject2);
        return;
      }
      Method localMethod1 = f;
      Class localClass1 = a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(false);
      localMethod1.invoke(localClass1, arrayOfObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void c(Context paramContext, QQToken paramQQToken)
  {
    String str1 = paramQQToken.getAppId();
    String str2 = "Aqc" + str1;
    try
    {
      a = Class.forName("com.tencent.stat.StatConfig");
      b = Class.forName("com.tencent.stat.StatService");
      c = b.getMethod("reportQQ", new Class[0]);
      d = b.getMethod("trackCustomEvent", new Class[0]);
      e = b.getMethod("commitEvents", new Class[0]);
      f = a.getMethod("setEnableStatService", new Class[0]);
      b(paramContext, paramQQToken);
      Method localMethod1 = a.getMethod("setAutoExceptionCaught", new Class[0]);
      Class localClass1 = a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(false);
      localMethod1.invoke(localClass1, arrayOfObject1);
      Method localMethod2 = a.getMethod("setEnableSmartReporting", new Class[0]);
      Class localClass2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Boolean.valueOf(true);
      localMethod2.invoke(localClass2, arrayOfObject2);
      Method localMethod3 = a.getMethod("setSendPeriodMinutes", new Class[0]);
      Class localClass3 = a;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(1440);
      localMethod3.invoke(localClass3, arrayOfObject3);
      Method localMethod4 = a.getMethod("setStatSendStrategy", new Class[0]);
      Class localClass4 = a;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(Class.forName("com.tencent.stat.StatReportStrategy").getField("PERIOD").getInt(null));
      localMethod4.invoke(localClass4, arrayOfObject4);
      a.getMethod("setStatReportUrl", new Class[0]).invoke(a, new Object[] { "http://cgi.connect.qq.com/qqconnectutil/sdk" });
      Method localMethod5 = b.getMethod("startStatService", new Class[0]);
      Class localClass5 = b;
      Object[] arrayOfObject5 = new Object[3];
      arrayOfObject5[0] = paramContext;
      arrayOfObject5[1] = str2;
      arrayOfObject5[2] = Integer.valueOf(Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").getInt(null));
      localMethod5.invoke(localClass5, arrayOfObject5);
      g = true;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void d(Context paramContext, QQToken paramQQToken)
  {
    if (!g);
    do
    {
      return;
      b(paramContext, paramQQToken);
    }
    while (paramQQToken.getOpenId() == null);
    try
    {
      Method localMethod = c;
      Class localClass = b;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramContext;
      arrayOfObject[1] = paramQQToken.getOpenId();
      localMethod.invoke(localClass, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.a.a
 * JD-Core Version:    0.6.0
 */