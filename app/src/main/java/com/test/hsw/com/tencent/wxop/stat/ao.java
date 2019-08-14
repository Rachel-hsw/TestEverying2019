package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;

final class ao
  implements Runnable
{
  ao(Context paramContext)
  {
  }

  public final void run()
  {
    if (this.e == null)
    {
      e.K().error("The Context of StatService.onPause() can not be null!");
      return;
    }
    e.b(this.e, l.B(this.e), this.bN);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.ao
 * JD-Core Version:    0.6.0
 */