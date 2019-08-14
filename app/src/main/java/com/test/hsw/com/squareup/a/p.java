package com.squareup.a;

import com.squareup.a.a.a.g;
import com.squareup.a.a.l;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class p
{
  private int a = 64;
  private int b = 5;
  private ExecutorService c;
  private final Deque<h.a> d = new ArrayDeque();
  private final Deque<h.a> e = new ArrayDeque();

  public p()
  {
  }

  public p(ExecutorService paramExecutorService)
  {
    this.c = paramExecutorService;
  }

  private int c(h.a parama)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    if (localIterator.hasNext())
      if (!((h.a)localIterator.next()).a().equals(parama.a()))
        break label56;
    label56: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  private void d()
  {
    if (this.e.size() >= this.a);
    label16: 
    do
    {
      Iterator localIterator;
      do
      {
        return;
        break label16;
        continue;
        while (this.d.isEmpty());
        localIterator = this.d.iterator();
      }
      while (!localIterator.hasNext());
      h.a locala = (h.a)localIterator.next();
      if (c(locala) >= this.b)
        continue;
      localIterator.remove();
      this.e.add(locala);
      a().execute(locala);
    }
    while (this.e.size() < this.a);
  }

  public ExecutorService a()
  {
    monitorenter;
    try
    {
      if (this.c == null)
        this.c = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), l.a("OkHttp Dispatcher", false));
      ExecutorService localExecutorService = this.c;
      return localExecutorService;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(int paramInt)
  {
    monitorenter;
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
        monitorexit;
      }
    this.a = paramInt;
    d();
    monitorexit;
  }

  void a(h.a parama)
  {
    monitorenter;
    try
    {
      if ((this.e.size() < this.a) && (c(parama) < this.b))
      {
        this.e.add(parama);
        a().execute(parama);
      }
      while (true)
      {
        return;
        this.d.add(parama);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(Object paramObject)
  {
    monitorenter;
    try
    {
      Iterator localIterator1 = this.d.iterator();
      while (localIterator1.hasNext())
      {
        if (!l.a(paramObject, ((h.a)localIterator1.next()).c()))
          continue;
        localIterator1.remove();
      }
    }
    finally
    {
      monitorexit;
    }
    Iterator localIterator2 = this.e.iterator();
    while (localIterator2.hasNext())
    {
      h.a locala = (h.a)localIterator2.next();
      if (!l.a(paramObject, locala.c()))
        continue;
      locala.d().a = true;
      g localg = locala.d().b;
      if (localg == null)
        continue;
      localg.n();
    }
    monitorexit;
  }

  public int b()
  {
    monitorenter;
    try
    {
      int i = this.a;
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

  public void b(int paramInt)
  {
    monitorenter;
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
        monitorexit;
      }
    this.b = paramInt;
    d();
    monitorexit;
  }

  void b(h.a parama)
  {
    monitorenter;
    try
    {
      if (!this.e.remove(parama))
        throw new AssertionError("AsyncCall wasn't running!");
    }
    finally
    {
      monitorexit;
    }
    d();
    monitorexit;
  }

  public int c()
  {
    monitorenter;
    try
    {
      int i = this.b;
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
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.p
 * JD-Core Version:    0.6.0
 */