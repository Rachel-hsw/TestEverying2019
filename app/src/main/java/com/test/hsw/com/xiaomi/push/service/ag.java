package com.xiaomi.push.service;

import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class ag extends XMPushService.e
{
  ag(int paramInt, XMPushService paramXMPushService, h paramh)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      h localh = ac.a(this.a, this.b);
      localh.m().a("miui_message_unrecognized", "1");
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
    return "send ack message for unrecognized new miui message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ag
 * JD-Core Version:    0.6.0
 */