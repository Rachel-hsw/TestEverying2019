package com.xiaomi.push.service;

import com.xiaomi.d.a;
import com.xiaomi.d.c.f;
import com.xiaomi.d.c.f.b;

class q extends XMPushService.e
{
  q(XMPushService paramXMPushService, int paramInt)
  {
    super(paramInt);
  }

  public void a()
  {
    if (XMPushService.e(this.a) != null)
    {
      XMPushService.e(this.a).a(new f(f.b.b), 15, null);
      XMPushService.a(this.a, null);
    }
  }

  public String b()
  {
    return "disconnect for service destroy.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.q
 * JD-Core Version:    0.6.0
 */