package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class i
  implements Runnable
{
  i(Context paramContext)
  {
  }

  public final void run()
  {
    try
    {
      new Thread(new o(this.e), "NetworkMonitorTask").start();
      return;
    }
    catch (Throwable localThrowable)
    {
      e.K().b(localThrowable);
      e.a(this.e, localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.i
 * JD-Core Version:    0.6.0
 */