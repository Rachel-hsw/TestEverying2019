package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.e.d;
import com.xiaomi.d.e.h;
import com.xiaomi.network.e;
import com.xiaomi.network.f;
import com.xiaomi.network.f.a;
import com.xiaomi.network.f.b;
import com.xiaomi.push.b.a.a;
import com.xiaomi.push.b.b.a;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class aq extends g.a
  implements f.a
{
  private XMPushService a;
  private long b;

  aq(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }

  public static void a(XMPushService paramXMPushService)
  {
    aq localaq = new aq(paramXMPushService);
    g.a().a(localaq);
    a.a locala = g.a().d();
    boolean bool = true;
    if ((locala != null) && (locala.f()))
      bool = locala.f();
    if (bool)
      f.a(localaq);
    f.a(paramXMPushService, null, new a(), "0", "push", "2.2");
  }

  public f a(Context paramContext, e parame, f.b paramb, String paramString)
  {
    return new b(paramContext, parame, paramb, paramString);
  }

  public void a(a.a parama)
  {
    if (parama.f())
    {
      c.a("Switch to BucketV2 :" + parama.e());
      f localf = f.a();
      monitorenter;
      try
      {
        if (parama.e())
          if (!(localf instanceof com.xiaomi.network.g))
          {
            f.a(this);
            f.a(this.a, null, new a(), "0", "push", "2.2");
          }
        while (true)
        {
          return;
          if (!(f.a() instanceof com.xiaomi.network.g))
            continue;
          f.a(null);
          f.a(this.a, null, new a(), "0", "push", "2.2");
        }
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public void a(b.a parama)
  {
    ArrayList localArrayList;
    if ((parama.d()) && (System.currentTimeMillis() - this.b > 3600000L))
    {
      c.a("fetch bucket :" + parama.c());
      this.b = System.currentTimeMillis();
      f localf = f.a();
      localf.d();
      localf.e();
      com.xiaomi.d.a locala = this.a.g();
      if (locala != null)
      {
        com.xiaomi.network.b localb = localf.b(locala.a().f());
        if (localb != null)
        {
          localArrayList = localb.d();
          Iterator localIterator = localArrayList.iterator();
          do
            if (!localIterator.hasNext())
              break;
          while (!((String)localIterator.next()).equals(locala.c()));
        }
      }
    }
    for (int i = 0; ; i = 1)
    {
      if ((i != 0) && (!localArrayList.isEmpty()))
      {
        c.a("bucket changed, force reconnect");
        this.a.a(0, null);
        this.a.a(false);
      }
      return;
    }
  }

  static class a
    implements f.b
  {
    public String a(String paramString)
    {
      URL localURL = new URL(paramString);
      int i;
      if (localURL.getPort() == -1)
        i = 80;
      try
      {
        while (true)
        {
          long l1 = System.currentTimeMillis();
          String str = d.a(h.a(), localURL);
          long l2 = System.currentTimeMillis() - l1;
          com.xiaomi.e.g.a(localURL.getHost() + ":" + i, (int)l2, null);
          return str;
          i = localURL.getPort();
        }
      }
      catch (IOException localIOException)
      {
        com.xiaomi.e.g.a(localURL.getHost() + ":" + i, -1, localIOException);
      }
      throw localIOException;
    }
  }

  static class b extends com.xiaomi.network.g
  {
    protected b(Context paramContext, e parame, f.b paramb, String paramString)
    {
      super(parame, paramb, paramString);
    }

    protected String a(ArrayList<String> paramArrayList, String paramString1, String paramString2)
    {
      try
      {
        String str = super.a(paramArrayList, paramString1, paramString2);
        return str;
      }
      catch (IOException localIOException)
      {
        com.xiaomi.e.g.a(0, com.xiaomi.push.d.a.q.a(), 1, null);
      }
      throw localIOException;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.aq
 * JD-Core Version:    0.6.0
 */