package com.xiaomi.push.service.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.xiaomi.a.a.c.c;
import com.xiaomi.d.j;
import com.xiaomi.push.service.ap;
import java.lang.reflect.Method;

public class a
{
  private static volatile long c = 0L;
  private PendingIntent a = null;
  private Context b = null;

  public a(Context paramContext)
  {
    this.b = paramContext;
  }

  private void a(AlarmManager paramAlarmManager, long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = Long.TYPE;
      arrayOfClass[2] = PendingIntent.class;
      Method localMethod = AlarmManager.class.getMethod("setExact", arrayOfClass);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(0);
      arrayOfObject[1] = Long.valueOf(paramLong);
      arrayOfObject[2] = paramPendingIntent;
      localMethod.invoke(paramAlarmManager, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
  }

  public void a()
  {
    monitorenter;
    try
    {
      if (this.a != null)
      {
        ((AlarmManager)this.b.getSystemService("alarm")).cancel(this.a);
        this.a = null;
        c.c("unregister timer");
        c = 0L;
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(Intent paramIntent, long paramLong)
  {
    monitorenter;
    while (true)
    {
      AlarmManager localAlarmManager;
      try
      {
        PendingIntent localPendingIntent = this.a;
        if (localPendingIntent != null)
          return;
        localAlarmManager = (AlarmManager)this.b.getSystemService("alarm");
        this.a = PendingIntent.getBroadcast(this.b, 0, paramIntent, 0);
        if (Build.VERSION.SDK_INT >= 19)
        {
          a(localAlarmManager, paramLong, this.a);
          c.c("register timer " + c);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localAlarmManager.set(0, paramLong, this.a);
    }
  }

  public void a(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      Intent localIntent = new Intent(ap.o);
      localIntent.setPackage(this.b.getPackageName());
      long l = j.c();
      if ((paramBoolean) || (c == 0L))
        c = System.currentTimeMillis() + (l - SystemClock.elapsedRealtime() % l);
      while (true)
      {
        a(localIntent, c);
        return;
        c = l + c;
        if (c >= System.currentTimeMillis())
          continue;
        c = l + System.currentTimeMillis();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean b()
  {
    monitorenter;
    try
    {
      PendingIntent localPendingIntent = this.a;
      if (localPendingIntent != null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.a.a
 * JD-Core Version:    0.6.0
 */