package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.b.b;

final class ap
  implements Runnable
{
  ap(Context paramContext, Throwable paramThrowable)
  {
  }

  public final void run()
  {
    try
    {
      if (!c.l())
        return;
      new p(new com.tencent.wxop.stat.a.c(this.e, e.a(this.e, false, null), this.dn, f.bw)).ah();
      return;
    }
    catch (Throwable localThrowable)
    {
      e.K().d("reportSdkSelfException error: " + localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.ap
 * JD-Core Version:    0.6.0
 */