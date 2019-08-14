package com.xiaomi.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.a.a.e.d;

public class NetworkStatusChangeReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (d.e(paramContext))
      paramContext.startService(new Intent(paramContext, HostRefreshService.class));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.NetworkStatusChangeReceiver
 * JD-Core Version:    0.6.0
 */