package com.xiaomi.push.service.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.a.a;
import com.xiaomi.push.service.ap;

public class PingReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new a(paramContext).a(false);
    c.c(paramIntent.getPackage() + " is the package name");
    if (ap.o.equals(paramIntent.getAction()))
    {
      if (TextUtils.equals(paramContext.getPackageName(), paramIntent.getPackage()))
        c.c("Ping XMChannelService on timer");
      try
      {
        Intent localIntent = new Intent(paramContext, XMPushService.class);
        localIntent.putExtra("time_stamp", System.currentTimeMillis());
        localIntent.setAction("com.xiaomi.push.timer");
        paramContext.startService(localIntent);
        return;
      }
      catch (Exception localException)
      {
        c.a(localException);
        return;
      }
    }
    c.a("cancel the old ping timer");
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, PingReceiver.class), 0));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.receivers.PingReceiver
 * JD-Core Version:    0.6.0
 */