package org.a.a.a.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class c<T>
  implements g<T>
{
  private ExecutorService a;
  private ExecutorService b;
  private Future<T> c;

  protected c()
  {
    this(null);
  }

  protected c(ExecutorService paramExecutorService)
  {
    a(paramExecutorService);
  }

  private Callable<T> b(ExecutorService paramExecutorService)
  {
    return new a(paramExecutorService);
  }

  private ExecutorService i()
  {
    return Executors.newFixedThreadPool(g());
  }

  public T a()
    throws f
  {
    try
    {
      Object localObject = e().get();
      return localObject;
    }
    catch (ExecutionException localExecutionException)
    {
      i.c(localExecutionException);
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
    throw new f(localInterruptedException);
  }

  public final void a(ExecutorService paramExecutorService)
  {
    monitorenter;
    try
    {
      if (c())
        throw new IllegalStateException("Cannot set ExecutorService after start()!");
    }
    finally
    {
      monitorexit;
    }
    this.a = paramExecutorService;
    monitorexit;
  }

  public final ExecutorService b()
  {
    monitorenter;
    try
    {
      ExecutorService localExecutorService = this.a;
      monitorexit;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      Future localFuture = this.c;
      if (localFuture != null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean d()
  {
    monitorenter;
    try
    {
      ExecutorService localExecutorService;
      if (!c())
      {
        this.b = b();
        if (this.b == null)
        {
          localExecutorService = i();
          this.b = localExecutorService;
          this.c = this.b.submit(b(localExecutorService));
        }
      }
      for (int i = 1; ; i = 0)
      {
        return i;
        localExecutorService = null;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Future<T> e()
  {
    monitorenter;
    try
    {
      if (this.c == null)
        throw new IllegalStateException("start() must be called first!");
    }
    finally
    {
      monitorexit;
    }
    Future localFuture = this.c;
    monitorexit;
    return localFuture;
  }

  protected final ExecutorService f()
  {
    monitorenter;
    try
    {
      ExecutorService localExecutorService = this.b;
      monitorexit;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  protected int g()
  {
    return 1;
  }

  protected abstract T h()
    throws Exception;

  private class a
    implements Callable<T>
  {
    private final ExecutorService b;

    public a(ExecutorService arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public T call()
      throws Exception
    {
      try
      {
        Object localObject2 = c.this.h();
        return localObject2;
      }
      finally
      {
        if (this.b != null)
          this.b.shutdown();
      }
      throw localObject1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.c
 * JD-Core Version:    0.6.0
 */