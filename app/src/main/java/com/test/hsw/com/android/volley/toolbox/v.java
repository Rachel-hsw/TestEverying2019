package com.android.volley.toolbox;

import com.android.volley.o;
import com.android.volley.s.a;
import com.android.volley.s.b;
import com.android.volley.x;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class v<T>
  implements s.a, s.b<T>, Future<T>
{
  private o<?> a;
  private boolean b = false;
  private T c;
  private x d;

  public static <E> v<E> a()
  {
    return new v();
  }

  private T a(Long paramLong)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    monitorenter;
    try
    {
      if (this.d != null)
        throw new ExecutionException(this.d);
    }
    finally
    {
      monitorexit;
    }
    if (this.b);
    for (Object localObject2 = this.c; ; localObject2 = this.c)
    {
      monitorexit;
      return localObject2;
      if (paramLong == null)
        wait(0L);
      while (this.d != null)
      {
        throw new ExecutionException(this.d);
        if (paramLong.longValue() <= 0L)
          continue;
        wait(paramLong.longValue());
      }
      if (this.b)
        continue;
      throw new TimeoutException();
    }
  }

  public void a(o<?> paramo)
  {
    this.a = paramo;
  }

  public void a(x paramx)
  {
    monitorenter;
    try
    {
      this.d = paramx;
      notifyAll();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(T paramT)
  {
    monitorenter;
    try
    {
      this.b = true;
      this.c = paramT;
      notifyAll();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean cancel(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      o localo = this.a;
      int i = 0;
      if (localo == null);
      while (true)
      {
        return i;
        boolean bool = isDone();
        i = 0;
        if (bool)
          continue;
        this.a.o();
        i = 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
    }
    throw new AssertionError(localTimeoutException);
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }

  public boolean isCancelled()
  {
    if (this.a == null)
      return false;
    return this.a.p();
  }

  public boolean isDone()
  {
    monitorenter;
    try
    {
      if ((!this.b) && (this.d == null))
      {
        boolean bool = isCancelled();
        if (!bool)
        {
          i = 0;
          return i;
        }
      }
      int i = 1;
    }
    finally
    {
      monitorexit;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.v
 * JD-Core Version:    0.6.0
 */