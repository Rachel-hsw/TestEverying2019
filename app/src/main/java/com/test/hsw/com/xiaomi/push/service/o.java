package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.p;

class o extends XMPushService.e
{
  o(XMPushService paramXMPushService, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    super(paramInt);
  }

  public void a()
  {
    try
    {
      this.c.a(this.a, this.b);
      return;
    }
    catch (p localp)
    {
      c.a(localp);
      this.c.a(10, localp);
    }
  }

  public String b()
  {
    return "send mi push message";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.o
 * JD-Core Version:    0.6.0
 */