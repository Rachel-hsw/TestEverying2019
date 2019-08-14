package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.e.d;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.mipush.sdk.n;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver
{
  private static int a = 1;
  private static int b = 1;
  private static int c = 2;
  private static BlockingQueue<Runnable> d = new LinkedBlockingQueue();
  private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, d);

  private void a(Context paramContext)
  {
    if ((!n.a(paramContext).b()) && (h.a(paramContext).i()) && (!h.a(paramContext).n()));
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(paramContext, "com.xiaomi.push.service.XMPushService"));
      localIntent.setAction("com.xiaomi.push.network_status_changed");
      paramContext.startService(localIntent);
      if ((d.d(paramContext)) && (n.a(paramContext).f()))
        n.a(paramContext).c();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        c.a(localException);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    e.execute(new a(this, paramContext));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.receivers.NetworkStatusReceiver
 * JD-Core Version:    0.6.0
 */