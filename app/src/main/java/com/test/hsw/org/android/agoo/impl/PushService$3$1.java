package org.android.agoo.impl;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.b.af;
import com.umeng.message.b.ar;
import com.umeng.message.b.ay;
import com.umeng.message.b.bh;

class PushService$3$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!af.m(PushService.a(this.a.a)))
      {
        ay.c("PushService", "messageServiceBinder [probe][deviceToken==null]");
        return;
      }
      String str = ar.a(PushService.a(this.a.a));
      if ((TextUtils.isEmpty(str)) && (!TextUtils.equals(PushService.a(this.a.a).getPackageName(), str)))
      {
        this.a.a.onHandleError("ERROR_NEED_ELECTION");
        ay.c("PushService", "messageServiceBinder [probe][need_election]");
        return;
      }
      if ((PushService.d(this.a.a) == null) || (!PushService.d(this.a.a).f()))
      {
        this.a.a.onHandleCommand("command_restart_sudo");
        ay.c("PushService", "messageServiceBinder [probe][restart_sudo]");
        return;
      }
      ay.c("PushService", "messageServiceBinder [probe][successfully]");
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.PushService.3.1
 * JD-Core Version:    0.6.0
 */