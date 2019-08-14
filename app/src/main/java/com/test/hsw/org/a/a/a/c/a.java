package org.a.a.a.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.a.a.a.x;

public class a<L>
  implements Serializable
{
  private static final long a = 3593265990380473632L;
  private List<L> b = new CopyOnWriteArrayList();
  private transient L c;
  private transient L[] d;

  private a()
  {
  }

  public a(Class<L> paramClass)
  {
    this(paramClass, Thread.currentThread().getContextClassLoader());
  }

  public a(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    this();
    x.a(paramClass, "Listener interface cannot be null.", new Object[0]);
    x.a(paramClassLoader, "ClassLoader cannot be null.", new Object[0]);
    boolean bool = paramClass.isInterface();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramClass.getName();
    x.a(bool, "Class {0} is not an interface", arrayOfObject);
    a(paramClass, paramClassLoader);
  }

  public static <T> a<T> a(Class<T> paramClass)
  {
    return new a(paramClass);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    Object[] arrayOfObject = (Object[])(Object[])paramObjectInputStream.readObject();
    this.b = new CopyOnWriteArrayList(arrayOfObject);
    a(arrayOfObject.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      try
      {
        localObjectOutputStream.writeObject(localObject);
        localArrayList.add(localObject);
      }
      catch (IOException localIOException)
      {
        localObjectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
      }
    }
    paramObjectOutputStream.writeObject(localArrayList.toArray(this.d));
  }

  private void a(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    this.d = ((Object[])(Object[])Array.newInstance(paramClass, 0));
    b(paramClass, paramClassLoader);
  }

  private void b(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    this.c = paramClass.cast(Proxy.newProxyInstance(paramClassLoader, new Class[] { paramClass }, d()));
  }

  public L a()
  {
    return this.c;
  }

  public void a(L paramL)
  {
    x.a(paramL, "Listener object cannot be null.", new Object[0]);
    this.b.add(paramL);
  }

  int b()
  {
    return this.b.size();
  }

  public void b(L paramL)
  {
    x.a(paramL, "Listener object cannot be null.", new Object[0]);
    this.b.remove(paramL);
  }

  public L[] c()
  {
    return this.b.toArray(this.d);
  }

  protected InvocationHandler d()
  {
    return new a();
  }

  protected class a
    implements InvocationHandler
  {
    private static final long b = 1L;

    protected a()
    {
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      Iterator localIterator = a.a(a.this).iterator();
      while (localIterator.hasNext())
        paramMethod.invoke(localIterator.next(), paramArrayOfObject);
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.c.a
 * JD-Core Version:    0.6.0
 */