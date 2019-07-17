package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import java.util.Timer;

public class af
{
  private static volatile af dd = null;
  private Timer dc = null;
  private Context h = null;

  private af(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.dc = new Timer(false);
  }

  public static af Y(Context paramContext)
  {
    if (dd == null)
      monitorenter;
    try
    {
      if (dd == null)
        dd = new af(paramContext);
      return dd;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final void ah()
  {
    if (c.j() == d.aG)
    {
      long l = 1000 * (60 * c.u());
      if (c.k())
        l.av().b("setupPeriodTimer delay:" + l);
      ag localag = new ag(this);
      if (this.dc == null)
        break label103;
      if (c.k())
        l.av().b("setupPeriodTimer schedule delay:" + l);
      this.dc.schedule(localag, l);
    }
    label103: 
    do
      return;
    while (!c.k());
    l.av().c("setupPeriodTimer schedule timer == null");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.af
 * JD-Core Version:    0.6.0
 */