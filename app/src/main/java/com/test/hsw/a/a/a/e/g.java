package a.a.a.e;

import a.a.a.d;
import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class g<E>
  implements Closeable, List<E>
{
  private final a.a.a.g<E> a;
  private final Cursor b;
  private final List<E> c;
  private final int d;
  private final ReentrantLock e;
  private volatile int f;

  g(a.a.a.g<E> paramg, Cursor paramCursor, boolean paramBoolean)
  {
    this.b = paramCursor;
    this.a = paramg;
    this.d = paramCursor.getCount();
    int i;
    if (paramBoolean)
    {
      this.c = new ArrayList(this.d);
      i = 0;
      if (i < this.d);
    }
    while (true)
    {
      if (this.d == 0)
        paramCursor.close();
      this.e = new ReentrantLock();
      return;
      this.c.add(null);
      i++;
      break;
      this.c = null;
    }
  }

  public E a(int paramInt)
  {
    if (this.c != null)
      return this.c.get(paramInt);
    return null;
  }

  public void a()
  {
    b();
    int i = this.c.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      get(j);
    }
  }

  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  protected E b(int paramInt)
  {
    if (!this.b.moveToPosition(paramInt))
      throw new d("Could not move to cursor location " + paramInt);
    Object localObject = this.a.a(this.b, 0, true);
    if (localObject == null)
      throw new d("Loading of entity failed (null) at position " + paramInt);
    return localObject;
  }

  protected void b()
  {
    if (this.c == null)
      throw new d("This operation only works with cached lazy lists");
  }

  public boolean c()
  {
    return this.b.isClosed();
  }

  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  public void close()
  {
    this.b.close();
  }

  public boolean contains(Object paramObject)
  {
    a();
    return this.c.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    a();
    return this.c.containsAll(paramCollection);
  }

  public int d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.f == this.d;
  }

  public c<E> f()
  {
    return new a(0, false);
  }

  public c<E> g()
  {
    return new a(0, true);
  }

  public E get(int paramInt)
  {
    if (this.c != null)
    {
      Object localObject3 = this.c.get(paramInt);
      if (localObject3 == null)
        this.e.lock();
      try
      {
        localObject3 = this.c.get(paramInt);
        if (localObject3 == null)
        {
          localObject3 = b(paramInt);
          this.c.set(paramInt, localObject3);
          this.f = (1 + this.f);
          if (this.f == this.d)
            this.b.close();
        }
        return localObject3;
      }
      finally
      {
        this.e.unlock();
      }
    }
    this.e.lock();
    try
    {
      Object localObject2 = b(paramInt);
      return localObject2;
    }
    finally
    {
      this.e.unlock();
    }
    throw localObject1;
  }

  public int indexOf(Object paramObject)
  {
    a();
    return this.c.indexOf(paramObject);
  }

  public boolean isEmpty()
  {
    return this.d == 0;
  }

  public Iterator<E> iterator()
  {
    return new a(0, false);
  }

  public int lastIndexOf(Object paramObject)
  {
    a();
    return this.c.lastIndexOf(paramObject);
  }

  public ListIterator<E> listIterator(int paramInt)
  {
    return new a(paramInt, false);
  }

  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.d;
  }

  public List<E> subList(int paramInt1, int paramInt2)
  {
    b();
    for (int i = paramInt1; ; i++)
    {
      if (i >= paramInt2)
        return this.c.subList(paramInt1, paramInt2);
      get(i);
    }
  }

  public Object[] toArray()
  {
    a();
    return this.c.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    a();
    return this.c.toArray(paramArrayOfT);
  }

  protected class a
    implements c<E>
  {
    private int b;
    private final boolean c;

    public a(int paramBoolean, boolean arg3)
    {
      this.b = paramBoolean;
      boolean bool;
      this.c = bool;
    }

    public void add(E paramE)
    {
      throw new UnsupportedOperationException();
    }

    public void close()
    {
      g.this.close();
    }

    public boolean hasNext()
    {
      return this.b < g.a(g.this);
    }

    public boolean hasPrevious()
    {
      return this.b > 0;
    }

    public E next()
    {
      if (this.b >= g.a(g.this))
        throw new NoSuchElementException();
      Object localObject = g.this.get(this.b);
      this.b = (1 + this.b);
      if ((this.b == g.a(g.this)) && (this.c))
        close();
      return localObject;
    }

    public int nextIndex()
    {
      return this.b;
    }

    public E previous()
    {
      if (this.b <= 0)
        throw new NoSuchElementException();
      this.b = (-1 + this.b);
      return g.this.get(this.b);
    }

    public int previousIndex()
    {
      return -1 + this.b;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }

    public void set(E paramE)
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.g
 * JD-Core Version:    0.6.0
 */