package com.xiaomi.push.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class v extends Handler
{
  v(u paramu, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    u.a(this.a, true);
    u.a(this.a, System.currentTimeMillis());
    if ((paramMessage.obj instanceof XMPushService.e))
      ((XMPushService.e)paramMessage.obj).c();
    u.a(this.a, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.v
 * JD-Core Version:    0.6.0
 */