package com.xiaomi.d;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an.b;
import com.xiaomi.push.service.ap;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  public static boolean a;
  private static final AtomicInteger n = new AtomicInteger(0);
  protected int b = 0;
  protected long c = -1L;
  protected int d;
  protected final Map<f, a> e = new ConcurrentHashMap();
  protected final Map<f, a> f = new ConcurrentHashMap();
  protected com.xiaomi.d.a.a g = null;
  protected Reader h;
  protected Writer i;
  protected String j = "";
  protected final int k = n.getAndIncrement();
  protected b l;
  protected XMPushService m;
  private LinkedList<Pair<Integer, Long>> o = new LinkedList();
  private final Collection<d> p = new CopyOnWriteArrayList();
  private int q = 2;
  private long r = 0L;

  static
  {
    a = false;
    try
    {
      a = Boolean.getBoolean("smack.debugEnabled");
      label23: j.a();
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }

  protected a(XMPushService paramXMPushService, b paramb)
  {
    this.l = paramb;
    this.m = paramXMPushService;
  }

  private String a(int paramInt)
  {
    if (paramInt == 1)
      return "connected";
    if (paramInt == 0)
      return "connecting";
    if (paramInt == 2)
      return "disconnected";
    return "unknown";
  }

  private void b(int paramInt)
  {
    LinkedList localLinkedList = this.o;
    monitorenter;
    if (paramInt == 1);
    try
    {
      this.o.clear();
      while (true)
      {
        return;
        this.o.add(new Pair(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis())));
        if (this.o.size() <= 6)
          continue;
        this.o.remove(0);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public b a()
  {
    return this.l;
  }

  public void a(int paramInt1, int paramInt2, Exception paramException)
  {
    if (paramInt1 != this.q)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = a(this.q);
      arrayOfObject[1] = a(paramInt1);
      arrayOfObject[2] = ap.a(paramInt2);
      com.xiaomi.a.a.c.c.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", arrayOfObject));
    }
    if (com.xiaomi.a.a.e.d.d(this.m))
      b(paramInt1);
    if (paramInt1 == 1)
    {
      this.m.a(10);
      if (this.q != 0)
        com.xiaomi.a.a.c.c.a("try set connected while not connecting.");
      this.q = paramInt1;
      Iterator localIterator4 = this.p.iterator();
      while (localIterator4.hasNext())
        ((d)localIterator4.next()).a(this);
    }
    if (paramInt1 == 0)
    {
      this.m.h();
      if (this.q != 2)
        com.xiaomi.a.a.c.c.a("try set connecting while not disconnected.");
      this.q = paramInt1;
      Iterator localIterator3 = this.p.iterator();
      while (localIterator3.hasNext())
        ((d)localIterator3.next()).b(this);
    }
    if (paramInt1 == 2)
    {
      this.m.a(10);
      if (this.q == 0)
      {
        Iterator localIterator2 = this.p.iterator();
        if (localIterator2.hasNext())
        {
          d locald = (d)localIterator2.next();
          if (paramException == null);
          for (Object localObject = new CancellationException("disconnect while connecting"); ; localObject = paramException)
          {
            locald.a(this, (Exception)localObject);
            break;
          }
        }
      }
      else if (this.q == 1)
      {
        Iterator localIterator1 = this.p.iterator();
        while (localIterator1.hasNext())
          ((d)localIterator1.next()).a(this, paramInt2, paramException);
      }
      this.q = paramInt1;
    }
  }

  public abstract void a(com.xiaomi.d.c.d paramd);

  public abstract void a(com.xiaomi.d.c.f paramf, int paramInt, Exception paramException);

  public void a(d paramd)
  {
    if (paramd == null);
    do
      return;
    while (this.p.contains(paramd));
    this.p.add(paramd);
  }

  public void a(f paramf, com.xiaomi.d.b.a parama)
  {
    if (paramf == null)
      throw new NullPointerException("Packet listener is null.");
    a locala = new a(paramf, parama);
    this.e.put(paramf, locala);
  }

  public abstract void a(an.b paramb);

  public void a(String paramString)
  {
    com.xiaomi.a.a.c.c.a("setChallenge hash = " + com.xiaomi.a.a.g.c.a(paramString).substring(0, 8));
    this.j = paramString;
    a(1, 0, null);
  }

  public abstract void a(String paramString1, String paramString2);

  public abstract void a(com.xiaomi.d.c.d[] paramArrayOfd);

  public boolean a(long paramLong)
  {
    return this.r >= paramLong;
  }

  public String b()
  {
    return this.l.c();
  }

  protected void b(com.xiaomi.d.c.d paramd)
  {
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(paramd);
  }

  public void b(d paramd)
  {
    this.p.remove(paramd);
  }

  public void b(f paramf, com.xiaomi.d.b.a parama)
  {
    if (paramf == null)
      throw new NullPointerException("Packet listener is null.");
    a locala = new a(paramf, parama);
    this.f.put(paramf, locala);
  }

  public String c()
  {
    return this.l.f();
  }

  public String d()
  {
    return this.l.d();
  }

  public int e()
  {
    return this.d;
  }

  protected void f()
  {
    if ((this.h == null) || (this.i == null));
    do
      return;
    while (!this.l.g());
    if (this.g == null)
      try
      {
        String str2 = System.getProperty("smack.debuggerClass");
        str1 = str2;
        localObject = null;
        if (str1 == null);
      }
      catch (Throwable localThrowable)
      {
        try
        {
          String str1;
          Class localClass = Class.forName(str1);
          localObject = localClass;
          if (localObject == null)
          {
            this.g = new com.xiaomi.c.a.a(this, this.i, this.h);
            this.h = this.g.a();
            this.i = this.g.b();
            return;
            localThrowable = localThrowable;
            str1 = null;
          }
        }
        catch (Exception localException2)
        {
          Object localObject;
          while (true)
          {
            localException2.printStackTrace();
            localObject = null;
          }
          try
          {
            Constructor localConstructor = localObject.getConstructor(new Class[] { a.class, Writer.class, Reader.class });
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = this;
            arrayOfObject[1] = this.i;
            arrayOfObject[2] = this.h;
            this.g = ((com.xiaomi.d.a.a)localConstructor.newInstance(arrayOfObject));
            this.h = this.g.a();
            this.i = this.g.b();
            return;
          }
          catch (Exception localException1)
          {
            throw new IllegalArgumentException("Can't initialize the configured debugger!", localException1);
          }
        }
      }
    this.h = this.g.a(this.h);
    this.i = this.g.a(this.i);
  }

  public boolean g()
  {
    return this.q == 0;
  }

  public boolean h()
  {
    return this.q == 1;
  }

  public int i()
  {
    return this.b;
  }

  public void j()
  {
    this.b = 0;
  }

  public long k()
  {
    return this.c;
  }

  public void l()
  {
    this.c = -1L;
  }

  public abstract void m();

  public int n()
  {
    return this.q;
  }

  public void o()
  {
    this.r = System.currentTimeMillis();
  }

  public boolean p()
  {
    return System.currentTimeMillis() - this.r < j.b();
  }

  public void q()
  {
    synchronized (this.o)
    {
      this.o.clear();
      return;
    }
  }

  protected static class a
  {
    private f a;
    private com.xiaomi.d.b.a b;

    public a(f paramf, com.xiaomi.d.b.a parama)
    {
      this.a = paramf;
      this.b = parama;
    }

    public void a(com.xiaomi.d.c.d paramd)
    {
      if ((this.b == null) || (this.b.a(paramd)))
        this.a.a(paramd);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.a
 * JD-Core Version:    0.6.0
 */