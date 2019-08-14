package com.umeng.message.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.b.a;

public final class ap
{
  private static final String a = "ServiceUtil";

  public static final void a(Context paramContext)
  {
    try
    {
      ay.c("ServiceUtil", "command --->[" + paramContext.getPackageName() + ".service]:[" + "stop" + "]");
      String str = a.c(paramContext);
      Intent localIntent = new Intent();
      localIntent.setAction(str);
      localIntent.putExtra("method", "stop");
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, String paramString)
  {
    ay.c("ServiceUtil", "command --->[" + paramContext.getPackageName() + ".service]:[" + "start" + "]");
    Intent localIntent = new Intent();
    localIntent.setAction(a.c(paramContext));
    localIntent.putExtra("method", "start");
    localIntent.putExtra("eventId", paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.startService(localIntent);
  }

  public static final void b(Context paramContext)
  {
    while (true)
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        int i = Process.myPid();
        j = 0;
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext())
          continue;
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
        if (localRunningServiceInfo.pid == i)
        {
          ay.c("ServiceUtil", "runningService --->[" + localRunningServiceInfo.process + "]");
          k = j + 1;
          break label149;
          if (j >= 1)
            continue;
          ay.c("ServiceUtil", "killRunningService --->[" + i + "]");
          Process.killProcess(i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      int k = j;
      label149: int j = k;
    }
  }

  public static boolean c(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    return (!localList.isEmpty()) && (!((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equals(paramContext.getPackageName()));
  }

  public static boolean d(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))
        return localRunningAppProcessInfo.importance == 400;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ap
 * JD-Core Version:    0.6.0
 */