package org.android.agoo.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.message.b.ay;
import org.android.agoo.service.IMessageService;
import org.android.agoo.service.IMessageService.Stub;

class ControlService$1
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      IMessageService localIMessageService2 = IMessageService.Stub.asInterface(paramIBinder);
      localIMessageService1 = localIMessageService2;
      if (localIMessageService1 != null);
      try
      {
        ay.d("ControlService", "messageService.proble");
        localIMessageService1.probe();
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          while (true)
          {
            if (ControlService.a(this.a) != null)
            {
              ay.c("ControlService", "messageConnection [unbind]");
              ControlService.a(this.a).unbindService(ControlService.b(this.a));
            }
            return;
            localThrowable3 = localThrowable3;
            ay.d("ControlService", "messageConnection", localThrowable3);
          }
        }
        catch (Throwable localThrowable2)
        {
          ay.d("ControlService", "messageDisconnected", localThrowable2);
          return;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      while (true)
        IMessageService localIMessageService1 = null;
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    ay.c("ControlService", "messageDisconnectedon ServiceDisconnected");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.ControlService.1
 * JD-Core Version:    0.6.0
 */