package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.h;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class k
  implements Runnable
{
  k(Context paramContext, String paramString, f paramf)
  {
  }

  public final void run()
  {
    try
    {
      e.p(this.e);
      synchronized (e.M())
      {
        Long localLong1 = (Long)e.M().remove(this.b);
        if (localLong1 != null)
        {
          Long localLong2 = Long.valueOf((System.currentTimeMillis() - localLong1.longValue()) / 1000L);
          if (localLong2.longValue() <= 0L)
            localLong2 = Long.valueOf(1L);
          String str = e.O();
          if ((str != null) && (str.equals(this.b) == true))
            str = "-";
          h localh = new h(this.e, str, this.b, e.a(this.e, false, this.bM), localLong2, this.bM);
          if (!this.b.equals(e.N()))
            e.K().warn("Invalid invocation since previous onResume on diff page.");
          new p(localh).ah();
          e.r(this.b);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      e.K().b(localThrowable);
      e.a(this.e, localThrowable);
      return;
    }
    e.K().d("Starttime for PageID:" + this.b + " not found, lost onResume()?");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.k
 * JD-Core Version:    0.6.0
 */