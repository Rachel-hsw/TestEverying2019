package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class ag extends TimerTask
{
  ag(af paramaf)
  {
  }

  public final void run()
  {
    if (c.k())
      l.av().b("TimerTask run");
    e.q(af.a(this.de));
    cancel();
    this.de.ah();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.ag
 * JD-Core Version:    0.6.0
 */