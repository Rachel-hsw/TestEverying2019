package com.a.a.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class f
{
  final e a;
  private Executor b;
  private Executor c;
  private Executor d;
  private final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
  private final Map<String, ReentrantLock> f = new WeakHashMap();
  private final AtomicBoolean g = new AtomicBoolean(false);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final Object j = new Object();

  f(e parame)
  {
    this.a = parame;
    this.b = parame.g;
    this.c = parame.h;
    this.d = a.a();
  }

  private void h()
  {
    if ((!this.a.i) && (((ExecutorService)this.b).isShutdown()))
      this.b = i();
    if ((!this.a.j) && (((ExecutorService)this.c).isShutdown()))
      this.c = i();
  }

  private Executor i()
  {
    return a.a(this.a.k, this.a.l, this.a.m);
  }

  String a(com.a.a.b.e.a parama)
  {
    return (String)this.e.get(Integer.valueOf(parama.f()));
  }

  ReentrantLock a(String paramString)
  {
    ReentrantLock localReentrantLock = (ReentrantLock)this.f.get(paramString);
    if (localReentrantLock == null)
    {
      localReentrantLock = new ReentrantLock();
      this.f.put(paramString, localReentrantLock);
    }
    return localReentrantLock;
  }

  void a()
  {
    this.g.set(true);
  }

  void a(com.a.a.b.e.a parama, String paramString)
  {
    this.e.put(Integer.valueOf(parama.f()), paramString);
  }

  void a(i parami)
  {
    this.d.execute(new g(this, parami));
  }

  void a(m paramm)
  {
    h();
    this.c.execute(paramm);
  }

  void a(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }

  void a(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }

  void b()
  {
    this.g.set(false);
    synchronized (this.j)
    {
      this.j.notifyAll();
      return;
    }
  }

  void b(com.a.a.b.e.a parama)
  {
    this.e.remove(Integer.valueOf(parama.f()));
  }

  void b(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }

  void c()
  {
    if (!this.a.i)
      ((ExecutorService)this.b).shutdownNow();
    if (!this.a.j)
      ((ExecutorService)this.c).shutdownNow();
    this.e.clear();
    this.f.clear();
  }

  AtomicBoolean d()
  {
    return this.g;
  }

  Object e()
  {
    return this.j;
  }

  boolean f()
  {
    return this.h.get();
  }

  boolean g()
  {
    return this.i.get();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.f
 * JD-Core Version:    0.6.0
 */