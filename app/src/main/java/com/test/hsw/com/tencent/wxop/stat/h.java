package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class h
  implements Runnable
{
  h(Context paramContext)
  {
  }

  public final void run()
  {
    try
    {
      e.p(this.e);
      t.s(this.e).b(this.g);
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
 * Qualified Name:     com.tencent.wxop.stat.h
 * JD-Core Version:    0.6.0
 */