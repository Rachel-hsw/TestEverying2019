package org.android.agoo.client;

import android.content.Intent;
import android.os.RemoteException;
import org.android.agoo.service.SendMessage.Stub;

class c extends SendMessage.Stub
{
  c(MessageReceiverService paramMessageReceiverService)
  {
  }

  public int doSend(Intent paramIntent)
    throws RemoteException
  {
    BaseIntentService.a(this.a.getApplicationContext(), paramIntent, this.a.getIntentServiceClassName(this.a.getApplicationContext()));
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.c
 * JD-Core Version:    0.6.0
 */