package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class ae extends XMPushService.e
{
  ae(int paramInt, XMPushService paramXMPushService, h paramh)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      h localh = ac.a(this.a, this.b);
      this.a.b(localh);
      return;
    }
    catch (p localp)
    {
      c.a(localp);
      this.a.a(10, localp);
    }
  }

  public String b()
  {
    return "send ack message for message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ae
 * JD-Core Version:    0.6.0
 */