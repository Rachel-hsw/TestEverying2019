package com.xiaomi.push.service;

import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class af extends XMPushService.e
{
  af(int paramInt, XMPushService paramXMPushService, h paramh)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      h localh = ac.a(this.a, this.b);
      localh.m().a("message_obsleted", "1");
      this.a.b(localh);
      return;
    }
    catch (p localp)
    {
      com.xiaomi.a.a.c.c.a(localp);
      this.a.a(10, localp);
    }
  }

  public String b()
  {
    return "send ack message for obsleted message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.af
 * JD-Core Version:    0.6.0
 */