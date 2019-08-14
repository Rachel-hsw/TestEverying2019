package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.c.d;
import com.xiaomi.d.p;

public class f extends XMPushService.e
{
  private XMPushService a = null;
  private d b;

  public f(XMPushService paramXMPushService, d paramd)
  {
    super(4);
    this.a = paramXMPushService;
    this.b = paramd;
  }

  public void a()
  {
    try
    {
      this.a.a(this.b);
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
    return "send a message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.f
 * JD-Core Version:    0.6.0
 */