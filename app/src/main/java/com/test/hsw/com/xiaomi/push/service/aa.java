package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.p;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;

public class aa extends XMPushService.e
{
  private XMPushService a;
  private byte[] b;
  private String c;
  private String e;
  private String f;

  public aa(XMPushService paramXMPushService, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super(9);
    this.a = paramXMPushService;
    this.c = paramString1;
    this.b = paramArrayOfByte;
    this.e = paramString2;
    this.f = paramString3;
  }

  public void a()
  {
    x localx1 = y.a(this.a);
    if (localx1 == null);
    an.b localb;
    do
    {
      x localx2;
      while (true)
      {
        try
        {
          x localx3 = y.a(this.a, this.c, this.e, this.f);
          localx2 = localx3;
          if (localx2 != null)
            break;
          c.d("no account for mipush");
          ab.a(this.a, 70000002, "no account.");
          return;
        }
        catch (IOException localIOException)
        {
          c.a(localIOException);
          localx2 = localx1;
          continue;
        }
        catch (JSONException localJSONException)
        {
          c.a(localJSONException);
        }
        localx2 = localx1;
      }
      Collection localCollection = an.a().c("5");
      if (localCollection.isEmpty())
      {
        localb = localx2.a(this.a);
        this.a.a(localb);
        an.a().a(localb);
      }
      while (true)
      {
        if (!this.a.e())
          break label247;
        try
        {
          if (localb.m != an.c.c)
            break;
          this.a.a(this.c, this.b);
          return;
        }
        catch (p localp)
        {
          c.a(localp);
          this.a.a(10, localp);
          return;
        }
        localb = (an.b)localCollection.iterator().next();
      }
    }
    while (localb.m != an.c.a);
    XMPushService localXMPushService1 = this.a;
    XMPushService localXMPushService2 = this.a;
    localXMPushService2.getClass();
    localXMPushService1.a(new XMPushService.a(localXMPushService2, localb));
    return;
    label247: this.a.a(true);
  }

  public String b()
  {
    return "register app";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.aa
 * JD-Core Version:    0.6.0
 */