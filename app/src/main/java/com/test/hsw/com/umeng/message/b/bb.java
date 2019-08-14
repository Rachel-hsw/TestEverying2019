package com.umeng.message.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class bb
{
  protected static final String a = "CONNECT_STATE";
  private static final Lock g = new ReentrantLock();
  private static final String h = "AbsMessage";
  protected volatile be b;
  protected volatile Context c;
  protected volatile String d;
  protected volatile String e;
  protected volatile String f;
  private volatile String i;
  private volatile a j = null;
  private volatile IntentFilter k = null;
  private volatile AlarmManager l = null;
  private final BroadcastReceiver m = new bc(this);
  private volatile boolean n = false;

  protected bb(Context paramContext, be parambe)
  {
    try
    {
      this.c = paramContext;
      this.b = parambe;
      this.l = ((AlarmManager)paramContext.getSystemService("alarm"));
      HandlerThread localHandlerThread = new HandlerThread("IntentService[timeThread]");
      localHandlerThread.start();
      this.j = new a(localHandlerThread.getLooper());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected String a()
  {
    return this.e;
  }

  public abstract void a(Context paramContext, Intent paramIntent);

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(String paramString, long paramLong)
  {
    a(paramString, null, paramLong);
  }

  protected void a(String paramString, Bundle paramBundle)
  {
    this.b.onHandleMessage(paramString, paramBundle);
  }

  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    try
    {
      g.lock();
      Intent localIntent;
      if (!TextUtils.isEmpty(paramString))
      {
        localIntent = new Intent(paramString);
        if (paramBundle == null)
          break label145;
        String str = paramBundle.getString("CONNECT_STATE");
        if (!TextUtils.isEmpty(str))
          ay.c("AbsMessage", "startTaskAtDelayed[" + paramString + "][" + str + "]");
        localIntent.putExtras(paramBundle);
      }
      while (true)
      {
        localIntent.setPackage(this.c.getPackageName());
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.c, paramString.hashCode(), localIntent, 268435456);
        this.l.set(1, paramLong + System.currentTimeMillis(), localPendingIntent);
        return;
        label145: ay.c("AbsMessage", "startTaskAtDelayed[" + paramString + "]");
      }
    }
    catch (Throwable localThrowable)
    {
      return;
    }
    finally
    {
      g.unlock();
    }
    throw localObject;
  }

  protected void a(String[] paramArrayOfString)
  {
    if ((this.c != null) && (!this.n));
    while (true)
    {
      int i2;
      try
      {
        this.k = new IntentFilter();
        this.k.setPriority(-1000);
        int i1 = paramArrayOfString.length;
        i2 = 0;
        if (i2 >= i1)
          continue;
        String str = paramArrayOfString[i2];
        if (!TextUtils.isEmpty(str))
        {
          this.k.addAction(str);
          break label97;
          this.c.registerReceiver(this.m, this.k);
          this.n = true;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label97: i2++;
    }
  }

  protected String b()
  {
    return this.d;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public void b(String paramString, long paramLong)
  {
    b(paramString, null, paramLong);
  }

  public void b(String paramString, Bundle paramBundle, long paramLong)
  {
    try
    {
      g.lock();
      if (!TextUtils.isEmpty(paramString))
      {
        ay.c("AbsMessage", "startTaskRepeating[" + paramString + "]");
        Intent localIntent = new Intent(paramString);
        if (paramBundle != null)
          localIntent.putExtras(paramBundle);
        localIntent.setPackage(this.c.getPackageName());
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.c, paramString.hashCode(), localIntent, 268435456);
        this.l.setRepeating(1, paramLong + System.currentTimeMillis(), paramLong, localPendingIntent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("AbsMessage", "onStartRepeating", localThrowable);
      return;
    }
    finally
    {
      g.unlock();
    }
    throw localObject;
  }

  public String c()
  {
    return this.f;
  }

  public void c(String paramString)
  {
    this.f = paramString;
  }

  public String d()
  {
    return this.i;
  }

  public void d(String paramString)
  {
    this.i = paramString;
  }

  public abstract void e();

  public void e(String paramString)
  {
    while (true)
    {
      String str;
      try
      {
        if (TextUtils.isEmpty(paramString))
          return;
        Intent localIntent = new Intent(paramString);
        localIntent.setPackage(this.c.getPackageName());
        str = localIntent.getStringExtra("CONNECT_STATE");
        if (TextUtils.isEmpty(str))
        {
          ay.a("AbsMessage", "stopTask action[" + paramString + "]");
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.c, paramString.hashCode(), localIntent, 268435456);
          this.l.cancel(localPendingIntent);
          localPendingIntent.cancel();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ay.d("AbsMessage", "stopTask", localThrowable);
        return;
      }
      ay.a("AbsMessage", "stopTask action[" + paramString + "][" + str + "]");
    }
  }

  public abstract boolean f();

  protected void g()
  {
    try
    {
      if ((this.c != null) && (this.n))
        this.c.unregisterReceiver(this.m);
      if (this.j != null)
        this.j = null;
      this.n = false;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  final class a extends Handler
  {
    public a(Looper arg2)
    {
      super();
    }

    // ERROR //
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: invokestatic 23	com/umeng/message/b/bb:h	()Ljava/util/concurrent/locks/Lock;
      //   3: invokeinterface 29 1 0
      //   8: aload_1
      //   9: getfield 35	android/os/Message:obj	Ljava/lang/Object;
      //   12: checkcast 37	android/content/Intent
      //   15: astore 4
      //   17: aload_0
      //   18: getfield 10	com/umeng/message/b/bb$a:a	Lcom/umeng/message/b/bb;
      //   21: aload_0
      //   22: getfield 10	com/umeng/message/b/bb$a:a	Lcom/umeng/message/b/bb;
      //   25: getfield 41	com/umeng/message/b/bb:c	Landroid/content/Context;
      //   28: aload 4
      //   30: invokevirtual 44	com/umeng/message/b/bb:a	(Landroid/content/Context;Landroid/content/Intent;)V
      //   33: invokestatic 23	com/umeng/message/b/bb:h	()Ljava/util/concurrent/locks/Lock;
      //   36: invokeinterface 47 1 0
      //   41: return
      //   42: astore_3
      //   43: invokestatic 23	com/umeng/message/b/bb:h	()Ljava/util/concurrent/locks/Lock;
      //   46: invokeinterface 47 1 0
      //   51: return
      //   52: astore_2
      //   53: invokestatic 23	com/umeng/message/b/bb:h	()Ljava/util/concurrent/locks/Lock;
      //   56: invokeinterface 47 1 0
      //   61: aload_2
      //   62: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   0	33	42	java/lang/Throwable
      //   0	33	52	finally
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bb
 * JD-Core Version:    0.6.0
 */