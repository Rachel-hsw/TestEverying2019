package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class q
{
  private static final int f = 4;
  private AtomicInteger a = new AtomicInteger();
  private final Map<String, Queue<o<?>>> b = new HashMap();
  private final Set<o<?>> c = new HashSet();
  private final PriorityBlockingQueue<o<?>> d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<o<?>> e = new PriorityBlockingQueue();
  private final b g;
  private final i h;
  private final t i;
  private j[] j;
  private c k;
  private List<b> l = new ArrayList();

  public q(b paramb, i parami)
  {
    this(paramb, parami, 4);
  }

  public q(b paramb, i parami, int paramInt)
  {
    this(paramb, parami, paramInt, new f(new Handler(Looper.getMainLooper())));
  }

  public q(b paramb, i parami, int paramInt, t paramt)
  {
    this.g = paramb;
    this.h = parami;
    this.j = new j[paramInt];
    this.i = paramt;
  }

  public <T> o<T> a(o<T> paramo)
  {
    paramo.a(this);
    synchronized (this.c)
    {
      this.c.add(paramo);
      paramo.a(c());
      paramo.a("add-to-queue");
      if (!paramo.v())
      {
        this.e.add(paramo);
        return paramo;
      }
    }
    while (true)
    {
      String str;
      synchronized (this.b)
      {
        str = paramo.m();
        if (this.b.containsKey(str))
        {
          Object localObject3 = (Queue)this.b.get(str);
          if (localObject3 != null)
            continue;
          localObject3 = new LinkedList();
          ((Queue)localObject3).add(paramo);
          this.b.put(str, localObject3);
          if (!y.b)
            continue;
          y.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          return paramo;
        }
      }
      this.b.put(str, null);
      this.d.add(paramo);
    }
  }

  public void a()
  {
    b();
    this.k = new c(this.d, this.e, this.g, this.i);
    this.k.start();
    for (int m = 0; ; m++)
    {
      if (m >= this.j.length)
        return;
      j localj = new j(this.e, this.h, this.g, this.i);
      this.j[m] = localj;
      localj.start();
    }
  }

  public void a(a parama)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      o localo;
      do
      {
        if (!localIterator.hasNext())
          return;
        localo = (o)localIterator.next();
      }
      while (!parama.a(localo));
      localo.o();
    }
  }

  public <T> void a(b<T> paramb)
  {
    synchronized (this.l)
    {
      this.l.add(paramb);
      return;
    }
  }

  public void a(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    a(new r(this, paramObject));
  }

  public void b()
  {
    if (this.k != null)
      this.k.a();
    for (int m = 0; ; m++)
    {
      if (m >= this.j.length)
        return;
      if (this.j[m] == null)
        continue;
      this.j[m].a();
    }
  }

  <T> void b(o<T> paramo)
  {
    while (true)
    {
      Iterator localIterator;
      synchronized (this.c)
      {
        this.c.remove(paramo);
        synchronized (this.l)
        {
          localIterator = this.l.iterator();
          if (!localIterator.hasNext())
            if (!paramo.v());
        }
      }
      synchronized (this.b)
      {
        String str = paramo.m();
        Queue localQueue = (Queue)this.b.remove(str);
        if (localQueue != null)
        {
          if (y.b)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(localQueue.size());
            arrayOfObject[1] = str;
            y.a("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
          }
          this.d.addAll(localQueue);
        }
        return;
        localObject1 = finally;
        monitorexit;
        throw localObject1;
        ((b)localIterator.next()).a(paramo);
        continue;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
    }
  }

  public <T> void b(b<T> paramb)
  {
    synchronized (this.l)
    {
      this.l.remove(paramb);
      return;
    }
  }

  public int c()
  {
    return this.a.incrementAndGet();
  }

  public b d()
  {
    return this.g;
  }

  public static abstract interface a
  {
    public abstract boolean a(o<?> paramo);
  }

  public static abstract interface b<T>
  {
    public abstract void a(o<T> paramo);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.q
 * JD-Core Version:    0.6.0
 */