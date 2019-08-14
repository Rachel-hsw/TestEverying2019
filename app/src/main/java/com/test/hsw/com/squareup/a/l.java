package com.squareup.a;

import com.squareup.a.a.j;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l
{
  private static final int a = 2;
  private static final long b = 300000L;
  private static final l c;
  private final int d;
  private final long e;
  private final LinkedList<k> f = new LinkedList();
  private final ExecutorService g = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.squareup.a.a.l.a("OkHttp ConnectionPool", true));
  private final Runnable h = new m(this);

  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    long l;
    if (str2 != null)
      l = Long.parseLong(str2);
    while ((str1 != null) && (!Boolean.parseBoolean(str1)))
    {
      c = new l(0, l);
      return;
      l = 300000L;
    }
    if (str3 != null)
    {
      c = new l(Integer.parseInt(str3), l);
      return;
    }
    c = new l(5, l);
  }

  public l(int paramInt, long paramLong)
  {
    this.d = paramInt;
    this.e = (1000L * (paramLong * 1000L));
  }

  public static l b()
  {
    return c;
  }

  private void g()
  {
    try
    {
      this.g.submit(new n(this)).get();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new AssertionError();
  }

  public k a(a parama)
  {
    monitorenter;
    while (true)
    {
      try
      {
        ListIterator localListIterator = this.f.listIterator(this.f.size());
        if (localListIterator.hasPrevious())
        {
          localk = (k)localListIterator.previous();
          if ((!localk.d().a().equals(parama)) || (!localk.f()) || (System.nanoTime() - localk.j() >= this.e))
            continue;
          localListIterator.remove();
          boolean bool = localk.l();
          if (bool)
            continue;
          try
          {
            j.a().a(localk.e());
            if ((localk == null) || (!localk.l()))
              continue;
            this.f.addFirst(localk);
            this.g.execute(this.h);
            monitorexit;
            return localk;
          }
          catch (SocketException localSocketException)
          {
            com.squareup.a.a.l.a(localk.e());
            j.a().a("Unable to tagSocket(): " + localSocketException);
          }
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      k localk = null;
    }
  }

  List<k> a()
  {
    g();
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.f);
      return localArrayList;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  void a(k paramk)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 180	com/squareup/a/k:l	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 230	com/squareup/a/k:b	()Z
    //   12: ifeq -5 -> 7
    //   15: aload_1
    //   16: invokevirtual 167	com/squareup/a/k:f	()Z
    //   19: ifne +11 -> 30
    //   22: aload_1
    //   23: invokevirtual 188	com/squareup/a/k:e	()Ljava/net/Socket;
    //   26: invokestatic 200	com/squareup/a/a/l:a	(Ljava/net/Socket;)V
    //   29: return
    //   30: invokestatic 185	com/squareup/a/a/j:a	()Lcom/squareup/a/a/j;
    //   33: aload_1
    //   34: invokevirtual 188	com/squareup/a/k:e	()Ljava/net/Socket;
    //   37: invokevirtual 232	com/squareup/a/a/j:b	(Ljava/net/Socket;)V
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 67	com/squareup/a/l:f	Ljava/util/LinkedList;
    //   46: aload_1
    //   47: invokevirtual 195	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   50: aload_1
    //   51: invokevirtual 235	com/squareup/a/k:n	()V
    //   54: aload_1
    //   55: invokevirtual 237	com/squareup/a/k:h	()V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 92	com/squareup/a/l:g	Ljava/util/concurrent/ExecutorService;
    //   64: aload_0
    //   65: getfield 99	com/squareup/a/l:h	Ljava/lang/Runnable;
    //   68: invokeinterface 199 2 0
    //   73: return
    //   74: astore_2
    //   75: invokestatic 185	com/squareup/a/a/j:a	()Lcom/squareup/a/a/j;
    //   78: new 202	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   85: ldc 239
    //   87: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokevirtual 219	com/squareup/a/a/j:a	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 188	com/squareup/a/k:e	()Ljava/net/Socket;
    //   104: invokestatic 200	com/squareup/a/a/l:a	(Ljava/net/Socket;)V
    //   107: return
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   30	40	74	java/net/SocketException
    //   42	60	108	finally
    //   109	111	108	finally
  }

  void b(k paramk)
  {
    if (!paramk.l())
      throw new IllegalArgumentException();
    this.g.execute(this.h);
    if (paramk.f())
    {
      monitorenter;
      try
      {
        this.f.addFirst(paramk);
        return;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public int c()
  {
    monitorenter;
    try
    {
      int i = this.f.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int d()
  {
    monitorenter;
    int i = 0;
    while (true)
    {
      try
      {
        Iterator localIterator = this.f.iterator();
        if (!localIterator.hasNext())
          continue;
        boolean bool = ((k)localIterator.next()).l();
        if (bool)
        {
          j = i + 1;
          i = j;
          continue;
          return i;
        }
      }
      finally
      {
        monitorexit;
      }
      int j = i;
    }
  }

  public int e()
  {
    monitorenter;
    int i = 0;
    while (true)
    {
      try
      {
        Iterator localIterator = this.f.iterator();
        if (!localIterator.hasNext())
          continue;
        boolean bool = ((k)localIterator.next()).l();
        if (!bool)
        {
          j = i + 1;
          i = j;
          continue;
          return i;
        }
      }
      finally
      {
        monitorexit;
      }
      int j = i;
    }
  }

  public void f()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.f);
      this.f.clear();
      monitorexit;
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
        com.squareup.a.a.l.a(((k)localArrayList.get(j)).e());
    }
    finally
    {
      monitorexit;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.l
 * JD-Core Version:    0.6.0
 */