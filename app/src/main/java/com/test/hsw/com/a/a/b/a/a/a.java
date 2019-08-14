package com.a.a.b.a.a;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract interface a<E> extends b<E>, BlockingQueue<E>
{
  public abstract E a()
    throws InterruptedException;

  public abstract E a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract void a(E paramE);

  public abstract boolean a(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract boolean add(E paramE);

  public abstract E b()
    throws InterruptedException;

  public abstract E b(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract void b(E paramE);

  public abstract boolean b(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract boolean c(E paramE);

  public abstract boolean contains(Object paramObject);

  public abstract boolean d(E paramE);

  public abstract void e(E paramE)
    throws InterruptedException;

  public abstract E element();

  public abstract void f(E paramE)
    throws InterruptedException;

  public abstract boolean g(Object paramObject);

  public abstract boolean h(Object paramObject);

  public abstract void i(E paramE);

  public abstract Iterator<E> iterator();

  public abstract boolean offer(E paramE);

  public abstract boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract E peek();

  public abstract E poll();

  public abstract E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  public abstract void put(E paramE)
    throws InterruptedException;

  public abstract E remove();

  public abstract boolean remove(Object paramObject);

  public abstract int size();

  public abstract E take()
    throws InterruptedException;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.a.a.a
 * JD-Core Version:    0.6.0
 */