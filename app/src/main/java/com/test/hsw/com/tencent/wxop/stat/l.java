package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class l
  implements Runnable
{
  l(Context paramContext)
  {
  }

  public final void run()
  {
    if (this.e == null)
    {
      e.K().error("The Context of StatService.onResume() can not be null!");
      return;
    }
    e.a(this.e, com.tencent.wxop.stat.b.l.B(this.e), this.bN);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.l
 * JD-Core Version:    0.6.0
 */