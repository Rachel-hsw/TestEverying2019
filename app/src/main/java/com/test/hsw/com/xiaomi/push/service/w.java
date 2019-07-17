package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.g.d;

public class w
{
  private static String a = null;
  private static String b = null;
  private static String c = null;

  public static String a(Context paramContext)
  {
    String str1;
    if (b == null)
      str1 = b(paramContext);
    try
    {
      String str4 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      str2 = str4;
      int i = Build.VERSION.SDK_INT;
      String str3 = null;
      if (i > 8)
        str3 = Build.SERIAL;
      b = "a-" + d.b(new StringBuilder().append(str1).append(str2).append(str3).toString());
      return b;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        c.a(localThrowable);
        String str2 = null;
      }
    }
  }

  // ERROR //
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 12	com/xiaomi/push/service/w:a	Ljava/lang/String;
    //   3: ifnull +7 -> 10
    //   6: getstatic 12	com/xiaomi/push/service/w:a	Ljava/lang/String;
    //   9: areturn
    //   10: aload_0
    //   11: ldc 75
    //   13: invokevirtual 79	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 81	android/telephony/TelephonyManager
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 84	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   24: astore_3
    //   25: aload_3
    //   26: astore 4
    //   28: bipush 10
    //   30: istore 5
    //   32: aload 4
    //   34: ifnonnull +33 -> 67
    //   37: iload 5
    //   39: iconst_1
    //   40: isub
    //   41: istore 6
    //   43: iload 5
    //   45: ifle +22 -> 67
    //   48: ldc2_w 85
    //   51: invokestatic 92	java/lang/Thread:sleep	(J)V
    //   54: aload_2
    //   55: invokevirtual 84	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   58: astore 4
    //   60: iload 6
    //   62: istore 5
    //   64: goto -32 -> 32
    //   67: aload 4
    //   69: ifnull +8 -> 77
    //   72: aload 4
    //   74: putstatic 12	com/xiaomi/push/service/w:a	Ljava/lang/String;
    //   77: aload 4
    //   79: areturn
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic 71	com/xiaomi/a/a/c/c:a	(Ljava/lang/Throwable;)V
    //   85: aconst_null
    //   86: areturn
    //   87: astore 7
    //   89: goto -35 -> 54
    //
    // Exception table:
    //   from	to	target	type
    //   10	25	80	java/lang/Throwable
    //   48	54	80	java/lang/Throwable
    //   54	60	80	java/lang/Throwable
    //   72	77	80	java/lang/Throwable
    //   48	54	87	java/lang/InterruptedException
  }

  public static String c(Context paramContext)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (c == null)
          continue;
        String str3 = c;
        return str3;
        try
        {
          String str4 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
          str1 = str4;
          if (Build.VERSION.SDK_INT > 8)
          {
            str2 = Build.SERIAL;
            c = d.b(str1 + str2);
            str3 = c;
          }
        }
        catch (Throwable localThrowable)
        {
          c.a(localThrowable);
          String str1 = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      String str2 = null;
    }
  }

  public static String d(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.w
 * JD-Core Version:    0.6.0
 */