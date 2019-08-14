package com.xiaomi.push.service;

import com.xiaomi.d.p;

public class a extends XMPushService.e
{
  private XMPushService a = null;
  private com.xiaomi.d.c.c[] b;

  public a(XMPushService paramXMPushService, com.xiaomi.d.c.c[] paramArrayOfc)
  {
    super(4);
    this.a = paramXMPushService;
    this.b = paramArrayOfc;
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
      com.xiaomi.a.a.c.c.a(localp);
      this.a.a(10, localp);
    }
  }

  public String b()
  {
    return "batch send message.";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.a
 * JD-Core Version:    0.6.0
 */