package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.d;

public class MiPushRegistar
{
  private static final String a = "MiPushRegistar";
  private static final String b = "com.xiaomi.xmsf";
  private static final String c = "Xiaomi".toLowerCase();
  private static String d = Build.BRAND;

  private static void b(String paramString1, String paramString2, Context paramContext)
  {
    try
    {
      d.a(paramContext, paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("MiPushRegistar", "registerMiPush handleRegistrar error=" + localThrowable);
    }
  }

  public static boolean checkDevice(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      boolean bool = TextUtils.equals(c, d.toLowerCase());
      int i = 0;
      if (bool)
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
        i = 0;
        if (localPackageInfo != null)
        {
          int j = localPackageInfo.versionCode;
          i = 0;
          if (j >= 105)
            i = 1;
        }
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.d("MiPushRegistar", "MiPushRegistar checkDevice error=" + localThrowable);
    }
    return false;
  }

  public static boolean hasMiPushDeviceToken(Context paramContext)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramContext.getSharedPreferences("pref_xiaomi", 4).getString("xiaomi_regid", ""));
      if (!bool)
        return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static void register(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      new Thread(new MiPushRegistar.1(paramString1, paramString2, paramContext)).start();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void unregister(Context paramContext)
  {
    try
    {
      new Thread(new MiPushRegistar.2(paramContext)).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("MiPushRegistar", "MiPush unregister error=" + localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MiPushRegistar
 * JD-Core Version:    0.6.0
 */