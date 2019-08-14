package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class m extends FutureTask<u>
{
  m(l paraml, Callable paramCallable, q paramq)
  {
    super(paramCallable);
  }

  protected final void done()
  {
    o localo = this.a.a();
    if (localo.f() == null)
      super.done();
    while (true)
    {
      return;
      try
      {
        get();
        if ((!isCancelled()) && (!localo.h()))
          continue;
        localo.g();
        if ((isCancelled()) && (isDone()))
          continue;
        cancel(false);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        new StringBuilder().append(localInterruptedException);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        if ((localExecutionException.getCause() != null) && ((localExecutionException.getCause() instanceof HttpException)))
        {
          HttpException localHttpException = (HttpException)localExecutionException.getCause();
          localHttpException.getCode();
          localHttpException.getMsg();
          return;
        }
        new StringBuilder().append(localExecutionException);
        return;
      }
      catch (CancellationException localCancellationException)
      {
        localo.g();
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
    throw new RuntimeException("An error occured while executing http request", localThrowable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.m
 * JD-Core Version:    0.6.0
 */