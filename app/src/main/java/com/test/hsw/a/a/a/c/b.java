package a.a.a.c;

import a.a.a.d.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class b<T>
  implements a<Long, T>
{
  private final c<Reference<T>> a = new c();
  private final ReentrantLock b = new ReentrantLock();

  public T a(long paramLong)
  {
    this.b.lock();
    try
    {
      Reference localReference = (Reference)this.a.b(paramLong);
      this.b.unlock();
      if (localReference != null)
        return localReference.get();
    }
    finally
    {
      this.b.unlock();
    }
    return null;
  }

  public T a(Long paramLong)
  {
    return a(paramLong.longValue());
  }

  public void a()
  {
    this.b.lock();
    try
    {
      this.a.a();
      return;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public void a(int paramInt)
  {
    this.a.b(paramInt);
  }

  public void a(long paramLong, T paramT)
  {
    this.b.lock();
    try
    {
      this.a.a(paramLong, new WeakReference(paramT));
      return;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public void a(Iterable<Long> paramIterable)
  {
    this.b.lock();
    try
    {
      Iterator localIterator = paramIterable.iterator();
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
          return;
        Long localLong = (Long)localIterator.next();
        this.a.c(localLong.longValue());
      }
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public void a(Long paramLong, T paramT)
  {
    a(paramLong.longValue(), paramT);
  }

  public T b(long paramLong)
  {
    Reference localReference = (Reference)this.a.b(paramLong);
    if (localReference != null)
      return localReference.get();
    return null;
  }

  public T b(Long paramLong)
  {
    return b(paramLong.longValue());
  }

  public void b()
  {
    this.b.lock();
  }

  public void b(long paramLong, T paramT)
  {
    this.a.a(paramLong, new WeakReference(paramT));
  }

  public void b(Long paramLong, T paramT)
  {
    b(paramLong.longValue(), paramT);
  }

  public void c()
  {
    this.b.unlock();
  }

  public void c(Long paramLong)
  {
    this.b.lock();
    try
    {
      this.a.c(paramLong.longValue());
      return;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public boolean c(Long paramLong, T paramT)
  {
    this.b.lock();
    try
    {
      if ((a(paramLong) == paramT) && (paramT != null))
      {
        c(paramLong);
        return true;
      }
      return false;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.c.b
 * JD-Core Version:    0.6.0
 */