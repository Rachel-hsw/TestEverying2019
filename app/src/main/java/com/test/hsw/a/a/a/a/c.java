package a.a.a.a;

import a.a.a.a;
import a.a.a.e;
import a.a.a.e.h;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class c
  implements Handler.Callback, Runnable
{
  private static ExecutorService a = Executors.newCachedThreadPool();
  private final BlockingQueue<b> b = new LinkedBlockingQueue();
  private volatile boolean c;
  private volatile int d = 50;
  private volatile d e;
  private volatile d f;
  private volatile int g = 50;
  private int h;
  private int i;
  private Handler j;
  private int k;

  private void a(b paramb1, b paramb2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramb1);
    localArrayList.add(paramb2);
    SQLiteDatabase localSQLiteDatabase = paramb1.f();
    localSQLiteDatabase.beginTransaction();
    int m = 0;
    while (true)
      try
      {
        int n = localArrayList.size();
        if (m < n)
          continue;
        bool = false;
      }
      finally
      {
        try
        {
          localSQLiteDatabase.endTransaction();
          if (!bool)
            continue;
          i1 = localArrayList.size();
          localIterator2 = localArrayList.iterator();
          if (!localIterator2.hasNext())
          {
            return;
            b localb1 = (b)localArrayList.get(m);
            d(localb1);
            if (!localb1.j())
              continue;
            bool = false;
            continue;
            if (m != -1 + localArrayList.size())
              continue;
            b localb4 = (b)this.b.peek();
            if ((m >= this.d) || (!localb1.a(localb4)))
              continue;
            b localb5 = (b)this.b.remove();
            if (localb5 == localb4)
              continue;
            throw new a.a.a.d("Internal error: peeked op did not match removed op");
            localObject = finally;
            try
            {
              localSQLiteDatabase.endTransaction();
              throw localObject;
              localArrayList.add(localb5);
              continue;
              localSQLiteDatabase.setTransactionSuccessful();
              bool = true;
            }
            catch (RuntimeException localRuntimeException1)
            {
              e.c("Async transaction could not be ended, success so far was: " + false, localRuntimeException1);
              continue;
            }
          }
        }
        catch (RuntimeException localRuntimeException2)
        {
          int i1;
          Iterator localIterator2;
          e.c("Async transaction could not be ended, success so far was: " + bool, localRuntimeException2);
          boolean bool = false;
          continue;
          b localb3 = (b)localIterator2.next();
          localb3.m = i1;
          b(localb3);
          continue;
          e.c("Reverted merged transaction because one of the operations failed. Executing operations one by one instead...");
          Iterator localIterator1 = localArrayList.iterator();
          if (!localIterator1.hasNext())
            continue;
          b localb2 = (b)localIterator1.next();
          localb2.q();
          c(localb2);
          continue;
          m++;
        }
      }
  }

  private void b(b paramb)
  {
    paramb.m();
    d locald = this.e;
    if (locald != null)
      locald.a(paramb);
    if (this.f != null)
    {
      if (this.j == null)
        this.j = new Handler(Looper.getMainLooper(), this);
      Message localMessage = this.j.obtainMessage(1, paramb);
      this.j.sendMessage(localMessage);
    }
    monitorenter;
    try
    {
      this.i = (1 + this.i);
      if (this.i == this.h)
        notifyAll();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void c(b paramb)
  {
    d(paramb);
    b(paramb);
  }

  private void d(b paramb)
  {
    paramb.h = System.currentTimeMillis();
    try
    {
      switch (g()[paramb.d.ordinal()])
      {
      default:
        throw new a.a.a.d("Unsupported operation: " + paramb.d);
      case 10:
      case 11:
      case 12:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 15:
      case 16:
      case 17:
      case 18:
      case 13:
      case 14:
      case 19:
      case 20:
      case 21:
      case 22:
      }
    }
    catch (Throwable localThrowable)
    {
      paramb.j = localThrowable;
    }
    while (true)
    {
      paramb.i = System.currentTimeMillis();
      return;
      paramb.e.f(paramb.f);
      continue;
      paramb.e.c((Iterable)paramb.f);
      continue;
      paramb.e.c((Object[])paramb.f);
      continue;
      paramb.e.c(paramb.f);
      continue;
      paramb.e.a((Iterable)paramb.f);
      continue;
      paramb.e.a((Object[])paramb.f);
      continue;
      paramb.e.e(paramb.f);
      continue;
      paramb.e.b((Iterable)paramb.f);
      continue;
      paramb.e.b((Object[])paramb.f);
      continue;
      paramb.e.i(paramb.f);
      continue;
      paramb.e.e((Iterable)paramb.f);
      continue;
      paramb.e.e((Object[])paramb.f);
      continue;
      e(paramb);
      continue;
      f(paramb);
      continue;
      paramb.l = ((h)paramb.f).c();
      continue;
      paramb.l = ((h)paramb.f).g();
      continue;
      paramb.e.g(paramb.f);
      continue;
      paramb.e.j();
      continue;
      paramb.l = paramb.e.a(paramb.f);
      continue;
      paramb.l = paramb.e.i();
      continue;
      paramb.l = Long.valueOf(paramb.e.m());
      continue;
      paramb.e.h(paramb.f);
    }
  }

  private void e(b paramb)
  {
    SQLiteDatabase localSQLiteDatabase = paramb.f();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ((Runnable)paramb.f).run();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private void f(b paramb)
    throws Exception
  {
    SQLiteDatabase localSQLiteDatabase = paramb.f();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramb.l = ((Callable)paramb.f).call();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  public int a()
  {
    return this.d;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(b paramb)
  {
    monitorenter;
    try
    {
      int m = 1 + this.k;
      this.k = m;
      paramb.n = m;
      this.b.add(paramb);
      this.h = (1 + this.h);
      if (!this.c)
      {
        this.c = true;
        a.execute(this);
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(d paramd)
  {
    this.e = paramd;
  }

  public int b()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(d paramd)
  {
    this.f = paramd;
  }

  public d c()
  {
    return this.e;
  }

  public boolean c(int paramInt)
  {
    monitorenter;
    try
    {
      boolean bool1 = e();
      long l1;
      if (!bool1)
        l1 = paramInt;
      try
      {
        wait(l1);
        boolean bool2 = e();
        monitorexit;
        return bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new a.a.a.d("Interrupted while waiting for all operations to complete", localInterruptedException);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public d d()
  {
    return this.f;
  }

  public boolean e()
  {
    monitorenter;
    try
    {
      int m = this.h;
      int n = this.i;
      if (m == n)
      {
        i1 = 1;
        return i1;
      }
      int i1 = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public void f()
  {
    monitorenter;
    try
    {
      while (true)
      {
        boolean bool = e();
        if (bool)
          return;
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new a.a.a.d("Interrupted while waiting for all operations to complete", localInterruptedException);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean handleMessage(Message paramMessage)
  {
    d locald = this.f;
    if (locald != null)
      locald.a((b)paramMessage.obj);
    return false;
  }

  public void run()
  {
    while (true)
    {
      b localb1;
      b localb4;
      try
      {
        localb1 = (b)this.b.poll(1L, TimeUnit.SECONDS);
        if (localb1 != null)
          break label195;
        monitorenter;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      finally
      {
        b localb2;
        this.c = false;
      }
      c(localb3);
      c(localb4);
      continue;
      c(localb3);
      continue;
      label195: b localb3 = localb1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.a.c
 * JD-Core Version:    0.6.0
 */