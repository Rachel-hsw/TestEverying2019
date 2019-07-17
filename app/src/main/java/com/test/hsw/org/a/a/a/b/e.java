package org.a.a.a.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class e<T> extends c<T>
{
  private final Callable<T> a;

  public e(Callable<T> paramCallable)
  {
    a(paramCallable);
    this.a = paramCallable;
  }

  public e(Callable<T> paramCallable, ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
    a(paramCallable);
    this.a = paramCallable;
  }

  private void a(Callable<T> paramCallable)
  {
    if (paramCallable == null)
      throw new IllegalArgumentException("Callable must not be null!");
  }

  protected T h()
    throws Exception
  {
    return this.a.call();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.e
 * JD-Core Version:    0.6.0
 */