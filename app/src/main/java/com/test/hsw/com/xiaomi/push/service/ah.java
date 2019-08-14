package com.xiaomi.push.service;

import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class ah extends XMPushService.e
{
  ah(int paramInt, XMPushService paramXMPushService, h paramh, String paramString)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      h localh = ac.a(this.a, this.b);
      localh.m().a("absent_target_package", this.c);
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
    return "send app absent ack message for message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ah
 * JD-Core Version:    0.6.0
 */