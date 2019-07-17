package a.a.a.c;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class c<K, T>
  implements a<K, T>
{
  private final HashMap<K, Reference<T>> a = new HashMap();
  private final ReentrantLock b = new ReentrantLock();

  public T a(K paramK)
  {
    this.b.lock();
    try
    {
      Reference localReference = (Reference)this.a.get(paramK);
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

  public void a()
  {
    this.b.lock();
    try
    {
      this.a.clear();
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
  }

  public void a(Iterable<K> paramIterable)
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
        Object localObject2 = (Object)localIterator.next();
        this.a.remove(localObject2);
      }
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject1;
  }

  public void a(K paramK, T paramT)
  {
    this.b.lock();
    try
    {
      this.a.put(paramK, new WeakReference(paramT));
      return;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public T b(K paramK)
  {
    Reference localReference = (Reference)this.a.get(paramK);
    if (localReference != null)
      return localReference.get();
    return null;
  }

  public void b()
  {
    this.b.lock();
  }

  public void b(K paramK, T paramT)
  {
    this.a.put(paramK, new WeakReference(paramT));
  }

  public void c()
  {
    this.b.unlock();
  }

  public void c(K paramK)
  {
    this.b.lock();
    try
    {
      this.a.remove(paramK);
      return;
    }
    finally
    {
      this.b.unlock();
    }
    throw localObject;
  }

  public boolean c(K paramK, T paramT)
  {
    this.b.lock();
    try
    {
      if ((a(paramK) == paramT) && (paramT != null))
      {
        c(paramK);
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
 * Qualified Name:     a.a.a.c.c
 * JD-Core Version:    0.6.0
 */