package org.a.a.a.b;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class i
{
  public static <K, V> V a(ConcurrentMap<K, V> paramConcurrentMap, K paramK, V paramV)
  {
    if (paramConcurrentMap == null)
      paramV = null;
    Object localObject;
    do
    {
      return paramV;
      localObject = paramConcurrentMap.putIfAbsent(paramK, paramV);
    }
    while (localObject == null);
    return localObject;
  }

  public static <K, V> V a(ConcurrentMap<K, V> paramConcurrentMap, K paramK, g<V> paramg)
    throws f
  {
    Object localObject;
    if ((paramConcurrentMap == null) || (paramg == null))
      localObject = null;
    do
    {
      return localObject;
      localObject = paramConcurrentMap.get(paramK);
    }
    while (localObject != null);
    return a(paramConcurrentMap, paramK, paramg.a());
  }

  public static <T> T a(g<T> paramg)
    throws f
  {
    if (paramg != null)
      return paramg.a();
    return null;
  }

  static Throwable a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (!(paramThrowable instanceof RuntimeException)) && (!(paramThrowable instanceof Error)))
      return paramThrowable;
    throw new IllegalArgumentException("Not a checked exception: " + paramThrowable);
  }

  public static <T> Future<T> a(T paramT)
  {
    return new a(paramT);
  }

  public static f a(ExecutionException paramExecutionException)
  {
    if ((paramExecutionException == null) || (paramExecutionException.getCause() == null))
      return null;
    e(paramExecutionException);
    return new f(paramExecutionException.getMessage(), paramExecutionException.getCause());
  }

  public static <K, V> V b(ConcurrentMap<K, V> paramConcurrentMap, K paramK, g<V> paramg)
  {
    try
    {
      Object localObject = a(paramConcurrentMap, paramK, paramg);
      return localObject;
    }
    catch (f localf)
    {
    }
    throw new h(localf.getCause());
  }

  public static <T> T b(g<T> paramg)
  {
    try
    {
      Object localObject = a(paramg);
      return localObject;
    }
    catch (f localf)
    {
    }
    throw new h(localf.getCause());
  }

  public static h b(ExecutionException paramExecutionException)
  {
    if ((paramExecutionException == null) || (paramExecutionException.getCause() == null))
      return null;
    e(paramExecutionException);
    return new h(paramExecutionException.getMessage(), paramExecutionException.getCause());
  }

  public static void c(ExecutionException paramExecutionException)
    throws f
  {
    f localf = a(paramExecutionException);
    if (localf != null)
      throw localf;
  }

  public static void d(ExecutionException paramExecutionException)
  {
    h localh = b(paramExecutionException);
    if (localh != null)
      throw localh;
  }

  private static void e(ExecutionException paramExecutionException)
  {
    if ((paramExecutionException.getCause() instanceof RuntimeException))
      throw ((RuntimeException)paramExecutionException.getCause());
    if ((paramExecutionException.getCause() instanceof Error))
      throw ((Error)paramExecutionException.getCause());
  }

  static final class a<T>
    implements Future<T>
  {
    private final T a;

    a(T paramT)
    {
      this.a = paramT;
    }

    public boolean cancel(boolean paramBoolean)
    {
      return false;
    }

    public T get()
    {
      return this.a;
    }

    public T get(long paramLong, TimeUnit paramTimeUnit)
    {
      return this.a;
    }

    public boolean isCancelled()
    {
      return false;
    }

    public boolean isDone()
    {
      return true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.i
 * JD-Core Version:    0.6.0
 */