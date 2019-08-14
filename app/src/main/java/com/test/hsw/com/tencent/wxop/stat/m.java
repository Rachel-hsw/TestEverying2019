package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class m
  implements Runnable
{
  m(Context paramContext)
  {
  }

  public final void run()
  {
    try
    {
      e.a(this.e, false, this.bN);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.K().b(localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.m
 * JD-Core Version:    0.6.0
 */