package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class j extends a
{
  private g g;

  public j(g paramg, Method paramMethod, int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(paramMethod, paramInt, paramString, paramArrayOfByte, "application/x-www-form-urlencoded", paramBoolean);
    this.g = paramg;
  }

  public final Object a()
  {
    o localo = new o(this.g.a());
    localo.a(this.b);
    localo.a(this.e);
    localo.a(this.f);
    localo.a("id", String.valueOf(this.d));
    localo.a("operationType", this.c);
    localo.a("gzip", String.valueOf(this.g.d()));
    localo.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
    List localList = this.g.c().b();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localo.a((Header)localIterator.next());
    }
    new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(localo.toString());
    try
    {
      localu = (u)this.g.b().a(localo).get();
      if (localu == null)
        throw new RpcException(Integer.valueOf(9), "response is null");
    }
    catch (InterruptedException localInterruptedException)
    {
      u localu;
      throw new RpcException(Integer.valueOf(13), "", localInterruptedException);
      byte[] arrayOfByte = localu.b();
      return arrayOfByte;
    }
    catch (ExecutionException localExecutionException)
    {
      Throwable localThrowable = localExecutionException.getCause();
      if ((localThrowable != null) && ((localThrowable instanceof HttpException)))
      {
        HttpException localHttpException = (HttpException)localThrowable;
        int i = localHttpException.getCode();
        switch (i)
        {
        default:
        case 3:
        case 6:
        case 7:
        case 5:
        case 4:
        case 2:
        case 1:
        case 9:
        case 8:
        }
        while (true)
        {
          throw new RpcException(Integer.valueOf(i), localHttpException.getMsg());
          i = 4;
          continue;
          i = 7;
          continue;
          i = 8;
          continue;
          i = 6;
          continue;
          i = 5;
          continue;
          i = 3;
          continue;
          i = 2;
          continue;
          i = 16;
          continue;
          i = 15;
        }
      }
      throw new RpcException(Integer.valueOf(9), "", localExecutionException);
    }
    catch (CancellationException localCancellationException)
    {
    }
    throw new RpcException(Integer.valueOf(13), "", localCancellationException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.j
 * JD-Core Version:    0.6.0
 */