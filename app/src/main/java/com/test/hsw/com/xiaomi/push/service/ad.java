package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.p;
import com.xiaomi.f.a.h;

final class ad extends XMPushService.e
{
  ad(int paramInt, XMPushService paramXMPushService, h paramh)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      this.a.b(this.a.a(this.b.j(), this.b.h()));
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
    return "send app absent message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ad
 * JD-Core Version:    0.6.0
 */