package com.a.a.b.a.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d<E> extends AbstractQueue<E>
  implements a<E>, Serializable
{
  private static final long d = -387911632671998426L;
  transient d<E> a;
  transient d<E> b;
  final ReentrantLock c = new ReentrantLock();
  private transient int e;
  private final int f;
  private final Condition g = this.c.newCondition();
  private final Condition h = this.c.newCondition();

  public d()
  {
    this(2147483647);
  }

  public d(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException();
    this.f = paramInt;
  }

  public d(Collection<? extends E> paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    while (true)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (!localIterator.hasNext())
          break;
        localObject2 = localIterator.next();
        if (localObject2 == null)
          throw new NullPointerException();
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (c(new d(localObject2)))
        continue;
      throw new IllegalStateException("Deque full");
    }
    localReentrantLock.unlock();
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.e = 0;
    this.a = null;
    this.b = null;
    while (true)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null)
        return;
      add(localObject);
    }
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (d locald = this.a; locald != null; locald = locald.c)
        paramObjectOutputStream.writeObject(locald.a);
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  private boolean b(d<E> paramd)
  {
    if (this.e >= this.f)
      return false;
    d locald = this.a;
    paramd.c = locald;
    this.a = paramd;
    if (this.b == null)
      this.b = paramd;
    while (true)
    {
      this.e = (1 + this.e);
      this.g.signal();
      return true;
      locald.b = paramd;
    }
  }

  private boolean c(d<E> paramd)
  {
    if (this.e >= this.f)
      return false;
    d locald = this.b;
    paramd.b = locald;
    this.b = paramd;
    if (this.a == null)
      this.a = paramd;
    while (true)
    {
      this.e = (1 + this.e);
      this.g.signal();
      return true;
      locald.c = paramd;
    }
  }

  private E m()
  {
    d locald1 = this.a;
    if (locald1 == null)
      return null;
    d locald2 = locald1.c;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.c = locald1;
    this.a = locald2;
    if (locald2 == null)
      this.b = null;
    while (true)
    {
      this.e = (-1 + this.e);
      this.h.signal();
      return localObject;
      locald2.b = null;
    }
  }

  private E n()
  {
    d locald1 = this.b;
    if (locald1 == null)
      return null;
    d locald2 = locald1.b;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.b = locald1;
    this.b = locald2;
    if (locald2 == null)
      this.a = null;
    while (true)
    {
      this.e = (-1 + this.e);
      this.h.signal();
      return localObject;
      locald2.c = null;
    }
  }

  public E a()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      while (true)
      {
        localObject2 = m();
        if (localObject2 != null)
          break;
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    localReentrantLock.unlock();
    return localObject2;
  }

  public E a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    long l2 = l1;
    try
    {
      Object localObject2;
      while (true)
      {
        localObject2 = m();
        if (localObject2 != null)
          break;
        if (l2 <= 0L)
          return null;
        long l3 = this.g.awaitNanos(l2);
        l2 = l3;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  void a(d<E> paramd)
  {
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    if (locald1 == null)
    {
      m();
      return;
    }
    if (locald2 == null)
    {
      n();
      return;
    }
    locald1.c = locald2;
    locald2.b = locald1;
    paramd.a = null;
    this.e = (-1 + this.e);
    this.h.signal();
  }

  public void a(E paramE)
  {
    if (!c(paramE))
      throw new IllegalStateException("Deque full");
  }

  public boolean a(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (true)
      {
        boolean bool = b(locald);
        if (bool)
          break;
        if (l1 <= 0L)
          return false;
        long l2 = this.h.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public boolean add(E paramE)
  {
    b(paramE);
    return true;
  }

  public E b()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      while (true)
      {
        localObject2 = n();
        if (localObject2 != null)
          break;
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    localReentrantLock.unlock();
    return localObject2;
  }

  public E b(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    long l2 = l1;
    try
    {
      Object localObject2;
      while (true)
      {
        localObject2 = n();
        if (localObject2 != null)
          break;
        if (l2 <= 0L)
          return null;
        long l3 = this.g.awaitNanos(l2);
        l2 = l3;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public void b(E paramE)
  {
    if (!d(paramE))
      throw new IllegalStateException("Deque full");
  }

  public boolean b(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (true)
      {
        boolean bool = c(locald);
        if (bool)
          break;
        if (l1 <= 0L)
          return false;
        long l2 = this.h.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E c()
  {
    Object localObject = e();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean c(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      boolean bool = b(locald);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public void clear()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      d locald;
      for (Object localObject2 = this.a; localObject2 != null; localObject2 = locald)
      {
        ((d)localObject2).a = null;
        locald = ((d)localObject2).c;
        ((d)localObject2).b = null;
        ((d)localObject2).c = null;
      }
      this.b = null;
      this.a = null;
      this.e = 0;
      this.h.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public boolean contains(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.a; locald != null; locald = locald.c)
      {
        boolean bool = paramObject.equals(locald.a);
        if (bool)
          return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E d()
  {
    Object localObject = f();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean d(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      boolean bool = c(locald);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }

  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null)
      throw new NullPointerException();
    if (paramCollection == this)
      throw new IllegalArgumentException();
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.e);
      for (int j = 0; j < i; j++)
      {
        paramCollection.add(this.a.a);
        m();
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E e()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = m();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public void e(E paramE)
    throws InterruptedException
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (!b(locald))
        this.h.await();
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E element()
  {
    return g();
  }

  public E f()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = n();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public void f(E paramE)
    throws InterruptedException
  {
    if (paramE == null)
      throw new NullPointerException();
    d locald = new d(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (!c(locald))
        this.h.await();
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E g()
  {
    Object localObject = i();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean g(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.a; locald != null; locald = locald.c)
      {
        if (!paramObject.equals(locald.a))
          continue;
        a(locald);
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E h()
  {
    Object localObject = j();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean h(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.b; locald != null; locald = locald.b)
      {
        if (!paramObject.equals(locald.a))
          continue;
        a(locald);
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E i()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      d locald = this.a;
      if (locald == null);
      for (Object localObject2 = null; ; localObject2 = this.a.a)
        return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public void i(E paramE)
  {
    a(paramE);
  }

  public Iterator<E> iterator()
  {
    return new c(null);
  }

  public E j()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      d locald = this.b;
      if (locald == null);
      for (Object localObject2 = null; ; localObject2 = this.b.a)
        return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  public E k()
  {
    return c();
  }

  public Iterator<E> l()
  {
    return new b(null);
  }

  public boolean offer(E paramE)
  {
    return d(paramE);
  }

  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return b(paramE, paramLong, paramTimeUnit);
  }

  public E peek()
  {
    return i();
  }

  public E poll()
  {
    return e();
  }

  public E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return a(paramLong, paramTimeUnit);
  }

  public void put(E paramE)
    throws InterruptedException
  {
    f(paramE);
  }

  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.f;
      int j = this.e;
      int k = i - j;
      return k;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E remove()
  {
    return c();
  }

  public boolean remove(Object paramObject)
  {
    return g(paramObject);
  }

  public int size()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public E take()
    throws InterruptedException
  {
    return a();
  }

  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.e];
      int i = 0;
      d locald = this.a;
      while (locald != null)
      {
        int j = i + 1;
        arrayOfObject[i] = locald.a;
        locald = locald.c;
        i = j;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (paramArrayOfT.length < this.e)
        paramArrayOfT = (Object[])(Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.e);
      int i = 0;
      d locald = this.a;
      while (locald != null)
      {
        int j = i + 1;
        paramArrayOfT[i] = locald.a;
        locald = locald.c;
        i = j;
      }
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
      return paramArrayOfT;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject;
  }

  public String toString()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      d locald1 = this.a;
      if (locald1 == null)
        return "[]";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      d locald2;
      for (Object localObject2 = locald1; ; localObject2 = locald2)
      {
        Object localObject3 = ((d)localObject2).a;
        if (localObject3 == this)
          localObject3 = "(this Collection)";
        localStringBuilder.append(localObject3);
        locald2 = ((d)localObject2).c;
        if (locald2 == null)
        {
          String str = ']';
          return str;
        }
        localStringBuilder.append(',').append(' ');
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  private abstract class a
    implements Iterator<E>
  {
    d.d<E> a;
    E b;
    private d.d<E> d;

    a()
    {
      ReentrantLock localReentrantLock = d.this.c;
      localReentrantLock.lock();
      try
      {
        this.a = a();
        if (this.a == null);
        for (Object localObject2 = null; ; localObject2 = this.a.a)
        {
          this.b = localObject2;
          return;
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      throw localObject1;
    }

    private d.d<E> b(d.d<E> paramd)
    {
      while (true)
      {
        d.d locald = a(paramd);
        if (locald == null)
          locald = null;
        do
          return locald;
        while (locald.a != null);
        if (locald == paramd)
          return a();
        paramd = locald;
      }
    }

    abstract d.d<E> a();

    abstract d.d<E> a(d.d<E> paramd);

    void b()
    {
      ReentrantLock localReentrantLock = d.this.c;
      localReentrantLock.lock();
      try
      {
        this.a = b(this.a);
        if (this.a == null);
        for (Object localObject2 = null; ; localObject2 = this.a.a)
        {
          this.b = localObject2;
          return;
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      throw localObject1;
    }

    public boolean hasNext()
    {
      return this.a != null;
    }

    public E next()
    {
      if (this.a == null)
        throw new NoSuchElementException();
      this.d = this.a;
      Object localObject = this.b;
      b();
      return localObject;
    }

    public void remove()
    {
      d.d locald = this.d;
      if (locald == null)
        throw new IllegalStateException();
      this.d = null;
      ReentrantLock localReentrantLock = d.this.c;
      localReentrantLock.lock();
      try
      {
        if (locald.a != null)
          d.this.a(locald);
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
      throw localObject;
    }
  }

  private class b extends d.a
  {
    private b()
    {
      super();
    }

    d.d<E> a()
    {
      return d.this.b;
    }

    d.d<E> a(d.d<E> paramd)
    {
      return paramd.b;
    }
  }

  private class c extends d.a
  {
    private c()
    {
      super();
    }

    d.d<E> a()
    {
      return d.this.a;
    }

    d.d<E> a(d.d<E> paramd)
    {
      return paramd.c;
    }
  }

  static final class d<E>
  {
    E a;
    d<E> b;
    d<E> c;

    d(E paramE)
    {
      this.a = paramE;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.a.a.d
 * JD-Core Version:    0.6.0
 */