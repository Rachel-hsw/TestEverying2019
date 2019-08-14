package com.umeng.message.b;

import android.content.Context;
import android.util.Log;
import org.android.agoo.service.ElectionReceiverService;

class as
  implements Runnable
{
  as(ar.c paramc)
  {
  }

  public void run()
  {
    try
    {
      Log.d("ElectionService", "onConnected running tid:" + Thread.currentThread().getId());
      ar.c.b(this.a).sendElectionResult(ar.c.a(this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ElectionService", "send error", localThrowable);
      return;
    }
    finally
    {
      ar.a().unbindService(ar.c.c(this.a));
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.as
 * JD-Core Version:    0.6.0
 */