package com.umeng.message.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.List;

public final class ao
{
  private static final String a = "ReceiverUtil";

  public static final void a(Context paramContext, Class<?> paramClass)
  {
    if ((paramContext != null) && (paramClass != null))
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
          return;
        if (localPackageManager.getApplicationEnabledSetting(paramContext.getPackageName()) > -1)
        {
          ComponentName localComponentName = new ComponentName(paramContext, paramClass);
          if (localPackageManager.getComponentEnabledSetting(localComponentName) != 2)
          {
            localPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
  }

  public static final void a(Context paramContext, Class<?>[] paramArrayOfClass)
  {
    if (paramContext != null)
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        int i = paramArrayOfClass.length;
        int j = 0;
        if (j < i)
        {
          Class<?> localClass = paramArrayOfClass[j];
          if (localClass == null);
          while (true)
          {
            j++;
            break;
            try
            {
              ComponentName localComponentName = new ComponentName(paramContext, localClass);
              if (localPackageManager.getComponentEnabledSetting(localComponentName) != 2)
                continue;
              ay.a("ReceiverUtil", "rebootReceiver[" + localComponentName.toString() + "]--->[ENABLED]");
              localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
            }
            catch (Throwable localThrowable2)
            {
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
      }
  }

  public static boolean a(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    int i = 0;
    if (localList != null)
    {
      boolean bool = localList.isEmpty();
      i = 0;
      if (!bool);
    }
    else
    {
      return i;
    }
    for (int j = 0; ; j++)
    {
      int k = localList.size();
      i = 0;
      if (j < k)
      {
        if (!((ActivityManager.RunningServiceInfo)localList.get(j)).service.getClassName().equals("com.taobao.agoo.PushService"))
          continue;
        i = 1;
        Log.d("ReceiverUtil", "PushService is running ....................");
      }
      if (i != 0)
        break;
      Log.d("ReceiverUtil", "PushService is failed ....................");
      return i;
    }
  }

  public static final boolean a(Context paramContext, String paramString)
  {
    try
    {
      if (paramContext.getPackageManager().getApplicationInfo(paramString, 0) != null)
        return true;
      aq.k(paramContext);
      return false;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static final void b(Context paramContext, Class<?> paramClass)
  {
    if ((paramContext != null) && (paramClass != null))
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
          return;
        if (localPackageManager.getApplicationEnabledSetting(paramContext.getPackageName()) > -1)
        {
          ComponentName localComponentName = new ComponentName(paramContext, paramClass);
          int i = localPackageManager.getComponentEnabledSetting(localComponentName);
          if ((i != 1) && (i != 0))
          {
            localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ao
 * JD-Core Version:    0.6.0
 */