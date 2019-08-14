package org.android.agoo.client;

import android.content.Intent;
import org.android.agoo.service.ElectionReceiverService.Stub;

class d extends ElectionReceiverService.Stub
{
  d(MessageReceiverService paramMessageReceiverService)
  {
  }

  public boolean sendElectionResult(Intent paramIntent)
  {
    try
    {
      BaseIntentService.a(this.a.getApplicationContext(), paramIntent, this.a.getIntentServiceClassName(this.a.getApplicationContext()));
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.d
 * JD-Core Version:    0.6.0
 */