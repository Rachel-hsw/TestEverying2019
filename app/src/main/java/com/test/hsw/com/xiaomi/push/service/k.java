package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.b;
import com.xiaomi.d.e;
import com.xiaomi.push.b.b.a;
import java.util.Map;

class k extends b
{
  k(XMPushService paramXMPushService, Map paramMap, int paramInt, String paramString, e parame)
  {
    super(paramMap, paramInt, paramString, parame);
  }

  public byte[] a()
  {
    try
    {
      b.a locala = new b.a();
      locala.a(g.a().c());
      byte[] arrayOfByte = locala.b();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      c.a("getOBBString err: " + localException.toString());
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.k
 * JD-Core Version:    0.6.0
 */