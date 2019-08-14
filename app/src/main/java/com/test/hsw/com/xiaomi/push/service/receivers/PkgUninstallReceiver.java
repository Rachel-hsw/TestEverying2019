package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.c;

public class PkgUninstallReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction())))
    {
      Uri localUri = paramIntent.getData();
      if (localUri != null)
      {
        Intent localIntent = new Intent(paramContext, XMPushService.class);
        localIntent.setAction(c.a);
        localIntent.putExtra("uninstall_pkg_name", localUri.getEncodedSchemeSpecificPart());
        paramContext.startService(localIntent);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.receivers.PkgUninstallReceiver
 * JD-Core Version:    0.6.0
 */