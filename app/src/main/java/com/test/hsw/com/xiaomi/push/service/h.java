package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.d.b.b;
import com.xiaomi.network.i;
import com.xiaomi.push.b.a.a;
import java.util.Iterator;
import java.util.List;

class h extends b.b
{
  boolean a = false;

  h(g paramg)
  {
  }

  public void b()
  {
    try
    {
      a.a locala = a.a.b(Base64.decode(i.a(com.xiaomi.d.e.h.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", null), 10));
      if (locala != null)
      {
        g.a(this.b, locala);
        this.a = true;
        g.a(this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      c.a("fetch config failure: " + localException.getMessage());
    }
  }

  public void c()
  {
    g.a(this.b, null);
    if (this.a)
    {
      Iterator localIterator = g.b(this.b).iterator();
      while (localIterator.hasNext())
        ((g.a)localIterator.next()).a(g.c(this.b));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.h
 * JD-Core Version:    0.6.0
 */