package com.xiaomi.push.service;

import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class ai extends XMPushService.e
{
  ai(int paramInt, XMPushService paramXMPushService, h paramh, String paramString1, String paramString2)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      h localh = ac.a(this.a, this.b);
      localh.h.a("error", this.c);
      localh.h.a("reason", this.e);
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
    return "send wrong message ack for message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ai
 * JD-Core Version:    0.6.0
 */