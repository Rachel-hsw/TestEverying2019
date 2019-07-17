package com.xiaomi.e;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an.b;
import com.xiaomi.push.service.an.b.a;
import com.xiaomi.push.service.an.c;

class a
  implements an.b.a
{
  private XMPushService a;
  private an.b b;
  private com.xiaomi.d.a c;
  private an.c d;
  private int e;
  private boolean f = false;

  a(XMPushService paramXMPushService, an.b paramb)
  {
    this.a = paramXMPushService;
    this.d = an.c.b;
    this.b = paramb;
  }

  private void b()
  {
    this.b.b(this);
  }

  private void c()
  {
    b();
    if (!this.f);
    do
      return;
    while (this.e == 11);
    com.xiaomi.push.d.b localb = e.a().f();
    switch (1.a[this.d.ordinal()])
    {
    case 2:
    default:
    case 1:
    case 3:
    }
    while (localb != null)
    {
      localb.b(this.c.c());
      localb.d(this.b.b);
      localb.c = 1;
      try
      {
        localb.a((byte)Integer.parseInt(this.b.h));
        label113: e.a().a(localb);
        return;
        if (this.e == 17)
        {
          localb.b = com.xiaomi.push.d.a.H.a();
          continue;
        }
        if (this.e == 21)
        {
          localb.b = com.xiaomi.push.d.a.O.a();
          continue;
        }
        try
        {
          c.a locala = c.c(e.b().a());
          localb.b = locala.a.a();
          localb.c(locala.b);
        }
        catch (NullPointerException localNullPointerException)
        {
          localb = null;
        }
        continue;
        localb.b = com.xiaomi.push.d.a.D.a();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label113;
      }
    }
  }

  void a()
  {
    this.b.a(this);
    this.c = this.a.g();
  }

  public void a(an.c paramc1, an.c paramc2, int paramInt)
  {
    if ((!this.f) && (paramc1 == an.c.b))
    {
      this.d = paramc2;
      this.e = paramInt;
      this.f = true;
    }
    this.a.a(new b(this, 4));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.e.a
 * JD-Core Version:    0.6.0
 */