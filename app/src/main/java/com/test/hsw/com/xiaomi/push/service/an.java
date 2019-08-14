package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class an
{
  private static an a;
  private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap();
  private List<a> c = new ArrayList();

  public static an a()
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new an();
      an localan = a;
      return localan;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = null;
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("@");
    }
    while (i <= 0);
    return paramString.substring(0, i);
  }

  public void a(Context paramContext)
  {
    monitorenter;
    try
    {
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext())
          ((b)localIterator2.next()).a(c.a, 1, 3, null, null);
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void a(Context paramContext, int paramInt)
  {
    monitorenter;
    try
    {
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext())
          ((b)localIterator2.next()).a(c.a, 2, paramInt, null, null);
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void a(a parama)
  {
    monitorenter;
    try
    {
      this.c.add(parama);
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

  public void a(b paramb)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramb.h);
      if (localHashMap == null)
      {
        localHashMap = new HashMap();
        this.b.put(paramb.h, localHashMap);
      }
      localHashMap.put(d(paramb.b), paramb);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a();
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void a(String paramString)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString);
      if (localHashMap != null)
      {
        localHashMap.clear();
        this.b.remove(paramString);
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a();
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void a(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString1);
      if (localHashMap != null)
      {
        localHashMap.remove(d(paramString2));
        if (localHashMap.isEmpty())
          this.b.remove(paramString1);
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a();
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public b b(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString1);
      if (localHashMap == null);
      for (b localb = null; ; localb = (b)localHashMap.get(d(paramString2)))
        return localb;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ArrayList<b> b()
  {
    monitorenter;
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
        localArrayList.addAll(((HashMap)localIterator.next()).values());
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localArrayList;
  }

  public List<String> b(String paramString)
  {
    monitorenter;
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext())
        {
          b localb = (b)localIterator2.next();
          if (!paramString.equals(localb.a))
            continue;
          localArrayList.add(localb.h);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localArrayList;
  }

  public int c()
  {
    monitorenter;
    try
    {
      int i = this.b.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Collection<b> c(String paramString)
  {
    monitorenter;
    try
    {
      if (!this.b.containsKey(paramString));
      Collection localCollection;
      for (Object localObject2 = new ArrayList(); ; localObject2 = localCollection)
      {
        return localObject2;
        localCollection = ((HashMap)((HashMap)this.b.get(paramString)).clone()).values();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void d()
  {
    monitorenter;
    try
    {
      this.b.clear();
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

  public void e()
  {
    monitorenter;
    try
    {
      this.c.clear();
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

  public static abstract interface a
  {
    public abstract void a();
  }

  public static class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public s k;
    public Context l;
    an.c m = an.c.a;
    private int n = 0;
    private List<a> o = new ArrayList();
    private XMPushService p;
    private XMPushService.b q = new XMPushService.b(this);

    public b(XMPushService paramXMPushService)
    {
      this.p = paramXMPushService;
      a(new ao(this));
    }

    public long a()
    {
      return 1000L * (()(20.0D * Math.random() - 10.0D) + 15 * (1 + this.n));
    }

    public String a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return "unknown";
      case 1:
        return "OPEN";
      case 2:
        return "CLOSE";
      case 3:
      }
      return "KICK";
    }

    public void a(a parama)
    {
      this.o.add(parama);
    }

    public void a(an.c paramc, int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      int i1 = 1;
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(this.m, paramc, paramInt2);
      if (this.m != paramc)
      {
        Object[] arrayOfObject = new Object[7];
        arrayOfObject[0] = this.m;
        arrayOfObject[i1] = paramc;
        arrayOfObject[2] = a(paramInt1);
        arrayOfObject[3] = ap.a(paramInt2);
        arrayOfObject[4] = paramString1;
        arrayOfObject[5] = paramString2;
        arrayOfObject[6] = this.h;
        c.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", arrayOfObject));
        this.m = paramc;
      }
      if (this.k == null)
        c.d("status changed while the client dispatcher is missing");
      do
      {
        return;
        if (paramInt1 == 2)
        {
          this.k.a(this.l, this, paramInt2);
          return;
        }
        if (paramInt1 != 3)
          continue;
        this.k.a(this.l, this, paramString2, paramString1);
        return;
      }
      while (paramInt1 != i1);
      if (paramc == an.c.c)
      {
        if ((i1 != 0) || (!"wait".equals(paramString2)))
          break label246;
        this.n = (1 + this.n);
      }
      while (true)
      {
        this.k.a(this.l, this, i1, paramInt2, paramString1);
        return;
        i1 = 0;
        break;
        label246: if (i1 == 0)
          continue;
        this.n = 0;
      }
    }

    public void b(a parama)
    {
      this.o.remove(parama);
    }

    public static abstract interface a
    {
      public abstract void a(an.c paramc1, an.c paramc2, int paramInt);
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      d = arrayOfc;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.an
 * JD-Core Version:    0.6.0
 */