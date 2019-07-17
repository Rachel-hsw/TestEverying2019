package com.xiaomi.e;

import com.xiaomi.push.service.XMPushService;

public class d
  implements com.xiaomi.d.d
{
  XMPushService a;
  com.xiaomi.d.a b;
  private int c;
  private Exception d;

  d(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }

  Exception a()
  {
    return this.d;
  }

  public void a(com.xiaomi.d.a parama)
  {
    g.a(0, com.xiaomi.push.d.a.r.a(), parama.c(), parama.i());
  }

  public void a(com.xiaomi.d.a parama, int paramInt, Exception paramException)
  {
    if ((this.c == 0) && (this.d == null))
    {
      this.c = paramInt;
      this.d = paramException;
      g.b(parama.c(), paramException);
    }
  }

  public void a(com.xiaomi.d.a parama, Exception paramException)
  {
    g.a(0, com.xiaomi.push.d.a.d.a(), 1, parama.c());
  }

  public void b(com.xiaomi.d.a parama)
  {
    this.c = 0;
    this.d = null;
    this.b = parama;
    g.a(0, com.xiaomi.push.d.a.r.a());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.e.d
 * JD-Core Version:    0.6.0
 */