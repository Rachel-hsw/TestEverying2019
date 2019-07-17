package org.android.agoo.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.umeng.message.b.ay;

class PushService$2 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (TextUtils.equals("agoo_action_re_election", paramIntent.getAction()))
        PushService.c(this.a).sendEmptyMessage(5);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e("PushService", "onReceive", localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.PushService.2
 * JD-Core Version:    0.6.0
 */