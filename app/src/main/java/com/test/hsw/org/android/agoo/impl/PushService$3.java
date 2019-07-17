package org.android.agoo.impl;

import android.os.RemoteException;
import com.umeng.message.b.ay;
import com.umeng.message.b.cp;
import org.android.agoo.service.IMessageService.Stub;

class PushService$3 extends IMessageService.Stub
{
  public boolean ping()
    throws RemoteException
  {
    return true;
  }

  public void probe()
    throws RemoteException
  {
    ay.c("PushService", "messageServiceBinder [probe]");
    cp.a(new PushService.3.1(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.PushService.3
 * JD-Core Version:    0.6.0
 */