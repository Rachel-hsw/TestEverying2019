package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;

final class ar
  implements Runnable
{
  ar(Context paramContext, com.tencent.wxop.stat.a.b paramb)
  {
  }

  public final void run()
  {
    try
    {
      a locala = new a(this.e, e.a(this.e, false, this.bN), this.jdField_do.a, this.bN);
      locala.ab().bm = this.jdField_do.bm;
      new p(locala).ah();
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
 * Qualified Name:     com.tencent.wxop.stat.ar
 * JD-Core Version:    0.6.0
 */