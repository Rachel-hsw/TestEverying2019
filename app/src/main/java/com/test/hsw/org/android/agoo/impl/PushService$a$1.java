package org.android.agoo.impl;

import android.content.Context;
import android.os.RemoteException;
import com.umeng.message.b.ay;
import com.umeng.message.b.bh;
import org.android.agoo.service.SendMessage;

class PushService$a$1
  implements Runnable
{
  public void run()
  {
    try
    {
      ay.c("PushService", "onConnected running tid:" + Thread.currentThread().getId());
      PushService.a.b(this.a).doSend(PushService.a.a(this.a));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ay.e("PushService", "send error", localRemoteException);
      bh localbh = PushService.a.d(this.a);
      String str = PushService.a.c(this.a);
      PushService.a.d(this.a);
      localbh.a(str, null, "14");
      return;
    }
    finally
    {
      ay.c("PushService", "send finish. close this connection");
      PushService.a.a(this.a, null);
      PushService.a(this.a.a).unbindService(PushService.a.e(this.a));
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.PushService.a.1
 * JD-Core Version:    0.6.0
 */