package com.xiaomi.e;

import android.text.TextUtils;
import com.xiaomi.a.a.f.a.a;
import com.xiaomi.d.e.h;
import com.xiaomi.d.l;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.g;
import com.xiaomi.push.service.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.a.c.b.l.a;

public class e
{
  private String a;
  private boolean b = false;
  private int c;
  private long d;
  private d e;
  private com.xiaomi.a.a.f.a f = com.xiaomi.a.a.f.a.a();

  public static e a()
  {
    return a.a;
  }

  private com.xiaomi.push.d.b a(a.a parama)
  {
    if (parama.a == 0)
    {
      boolean bool = parama.c instanceof com.xiaomi.push.d.b;
      com.xiaomi.push.d.b localb2 = null;
      if (bool)
        localb2 = (com.xiaomi.push.d.b)parama.c;
      return localb2;
    }
    com.xiaomi.push.d.b localb1 = f();
    localb1.a(com.xiaomi.push.d.a.ab.a());
    localb1.c(parama.a);
    localb1.c(parama.b);
    return localb1;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    com.xiaomi.push.d.b localb = new com.xiaomi.push.d.b();
    localb.a = (byte)paramInt1;
    localb.b = paramInt2;
    localb.c = paramInt3;
    localb.d = paramString2;
    localb.e = paramString1;
    localb.i = ((int)System.currentTimeMillis() / 1000);
    if (this.e.b != null)
      localb.e(this.e.b.e());
    this.f.a(localb);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    arrayOfObject[3] = paramString2;
    com.xiaomi.a.a.c.c.c(String.format(localLocale, "add stats: chid = %s, type =%d, value = %d, connpt = %s", arrayOfObject));
  }

  static d b()
  {
    return a.a.e;
  }

  private com.xiaomi.push.d.c b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    com.xiaomi.push.d.c localc = new com.xiaomi.push.d.c(this.a, localArrayList);
    if (!com.xiaomi.a.a.e.d.e(this.e.a))
      localc.a(w.d(this.e.a));
    org.a.c.c.b localb = new org.a.c.c.b(paramInt);
    org.a.c.b.f localf = new l.a().a(localb);
    try
    {
      localc.b(localf);
      localLinkedList = this.f.c();
    }
    catch (org.a.c.f localf1)
    {
      try
      {
        while (true)
        {
          LinkedList localLinkedList;
          com.xiaomi.push.d.b localb1;
          if (localLinkedList.size() > 0)
          {
            localb1 = a((a.a)localLinkedList.getLast());
            if (localb1 != null)
              localb1.b(localf);
            int i = localb.g_();
            if (i <= paramInt);
          }
          else
          {
            label135: com.xiaomi.a.a.c.c.a("stat approximate size = " + localb.g_());
            return localc;
          }
          if (localb1 != null)
            localArrayList.add(localb1);
          localLinkedList.removeLast();
        }
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        break label135;
        localf1 = localf1;
      }
      catch (org.a.c.f localf2)
      {
        break label135;
      }
    }
  }

  private void g()
  {
    if (this.d == 0L)
      this.d = System.currentTimeMillis();
  }

  private void h()
  {
    if ((this.b) && (System.currentTimeMillis() - this.d > this.c))
    {
      this.b = false;
      this.d = 0L;
    }
  }

  public void a(int paramInt)
  {
    int i = 604800000;
    int j;
    if (paramInt > 0)
    {
      this.b = true;
      j = paramInt * 1000;
      if (j <= i)
        break label41;
    }
    while (true)
    {
      if (this.c != i)
      {
        this.c = i;
        g();
      }
      return;
      label41: i = j;
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    monitorenter;
    try
    {
      if (this.a == null)
        com.xiaomi.a.a.c.c.c(String.format(Locale.US, "StatsHandler.add() Should initialized before add", new Object[0]));
      while (true)
      {
        return;
        String str = com.xiaomi.a.a.e.d.f(this.e.a);
        if (TextUtils.isEmpty(str))
          continue;
        a(paramInt1, paramInt2, paramInt3, paramString, str, System.currentTimeMillis());
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(com.xiaomi.push.d.b paramb)
  {
    monitorenter;
    try
    {
      this.f.a(paramb);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(XMPushService paramXMPushService, l paraml)
  {
    monitorenter;
    try
    {
      this.e = new d(paramXMPushService);
      this.a = "";
      if (paraml != null)
        paraml.a(this.e);
      g.a().a(new f(this));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean c()
  {
    return this.b;
  }

  boolean d()
  {
    h();
    return (this.b) && (this.f.b() > 0);
  }

  com.xiaomi.push.d.c e()
  {
    monitorenter;
    try
    {
      boolean bool = d();
      Object localObject2 = null;
      if (bool)
      {
        int i = 750;
        if (!com.xiaomi.a.a.e.d.e(h.a()))
          i = 375;
        com.xiaomi.push.d.c localc = b(i);
        localObject2 = localc;
      }
      return localObject2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  com.xiaomi.push.d.b f()
  {
    com.xiaomi.push.d.b localb = new com.xiaomi.push.d.b();
    localb.a(com.xiaomi.a.a.e.d.f(this.e.a));
    localb.a = 0;
    localb.c = 1;
    localb.d((int)(System.currentTimeMillis() / 1000L));
    if (this.e.b != null)
      localb.e(this.e.b.e());
    return localb;
  }

  static class a
  {
    static final e a = new e();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.e.e
 * JD-Core Version:    0.6.0
 */