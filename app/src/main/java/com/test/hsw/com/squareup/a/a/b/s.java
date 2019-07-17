package com.squareup.a.a.b;

import b.j;
import com.squareup.a.a.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class s
  implements Closeable
{
  private static final ExecutorService m;
  final com.squareup.a.v a;
  final boolean b;
  long c = 0L;
  long d;
  final q e = new q();
  final q f = new q();
  final ad g;
  final Socket h;
  final c i;
  final long j;
  final b k;
  private final i n;
  private final Map<Integer, ac> o = new HashMap();
  private final String p;
  private int q;
  private int r;
  private boolean s;
  private long t = System.nanoTime();
  private final ExecutorService u;
  private Map<Integer, n> v;
  private final o w;
  private int x;
  private boolean y = false;
  private final Set<Integer> z = new LinkedHashSet();

  static
  {
    if (!s.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      l = bool;
      m = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), l.a("OkHttp SpdyConnection", true));
      return;
    }
  }

  private s(a parama)
    throws IOException
  {
    this.a = a.a(parama);
    this.w = a.b(parama);
    this.b = a.c(parama);
    this.n = a.d(parama);
    int i2;
    TimeUnit localTimeUnit;
    LinkedBlockingQueue localLinkedBlockingQueue;
    Object[] arrayOfObject;
    if (a.c(parama))
    {
      i2 = 3;
      this.r = i2;
      if (a.c(parama))
        i1 = 1;
      this.x = i1;
      if (a.c(parama))
        this.e.a(7, 0, 16777216);
      this.p = a.e(parama);
      if (this.a != com.squareup.a.v.d)
        break label329;
      this.g = new g();
      localTimeUnit = TimeUnit.MILLISECONDS;
      localLinkedBlockingQueue = new LinkedBlockingQueue();
      arrayOfObject = new Object[1];
      arrayOfObject[0] = this.p;
    }
    for (this.u = new ThreadPoolExecutor(0, 1, 0L, localTimeUnit, localLinkedBlockingQueue, l.a(String.format("OkHttp %s Push Observer", arrayOfObject), true)); ; this.u = null)
    {
      this.d = this.f.j(65536);
      this.h = a.f(parama);
      this.i = this.g.a(b.q.a(b.q.a(a.f(parama))), this.b);
      this.j = this.g.b();
      this.k = new b(null);
      new Thread(this.k).start();
      return;
      i2 = i1;
      break;
      label329: if (this.a != com.squareup.a.v.c)
        break label358;
      this.g = new r();
    }
    label358: throw new AssertionError(this.a);
  }

  private ac a(int paramInt, List<d> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    boolean bool1 = true;
    boolean bool2;
    if (!paramBoolean1)
    {
      bool2 = bool1;
      if (paramBoolean2)
        break label65;
    }
    while (true)
    {
      synchronized (this.i)
      {
        monitorenter;
        try
        {
          if (!this.s)
            break label71;
          throw new IOException("shutdown");
        }
        finally
        {
          monitorexit;
        }
      }
      bool2 = false;
      break;
      label65: bool1 = false;
    }
    label71: int i1 = this.r;
    this.r = (2 + this.r);
    ac localac = new ac(i1, this, bool2, bool1, paramList);
    if (localac.b())
    {
      this.o.put(Integer.valueOf(i1), localac);
      a(false);
    }
    monitorexit;
    if (paramInt == 0)
      this.i.a(bool2, bool1, i1, paramInt, paramList);
    while (true)
    {
      monitorexit;
      if (!paramBoolean1)
        this.i.c();
      return localac;
      if (this.b)
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      this.i.a(paramInt, i1, paramList);
    }
  }

  private void a(int paramInt1, b.i parami, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    b.e locale = new b.e();
    parami.a(paramInt2);
    parami.b(locale, paramInt2);
    if (locale.c() != paramInt2)
      throw new IOException(locale.c() + " != " + paramInt2);
    ExecutorService localExecutorService = this.u;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    localExecutorService.submit(new y(this, "OkHttp %s Push Data[%s]", arrayOfObject, paramInt1, locale, paramInt2, paramBoolean));
  }

  private void a(int paramInt, List<d> paramList)
  {
    monitorenter;
    try
    {
      if (this.z.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, a.b);
        return;
      }
      this.z.add(Integer.valueOf(paramInt));
      monitorexit;
      ExecutorService localExecutorService = this.u;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.p;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localExecutorService.submit(new w(this, "OkHttp %s Push Request[%s]", arrayOfObject, paramInt, paramList));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void a(a parama1, a parama2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 60	com/squareup/a/a/b/s:l	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 361	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 234	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 362	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 365	com/squareup/a/a/b/s:a	(Lcom/squareup/a/a/b/a;)V
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 97	com/squareup/a/a/b/s:o	Ljava/util/Map;
    //   35: invokeinterface 368 1 0
    //   40: ifne +264 -> 304
    //   43: aload_0
    //   44: getfield 97	com/squareup/a/a/b/s:o	Ljava/util/Map;
    //   47: invokeinterface 372 1 0
    //   52: aload_0
    //   53: getfield 97	com/squareup/a/a/b/s:o	Ljava/util/Map;
    //   56: invokeinterface 375 1 0
    //   61: anewarray 250	com/squareup/a/a/b/ac
    //   64: invokeinterface 381 2 0
    //   69: checkcast 383	[Lcom/squareup/a/a/b/ac;
    //   72: astore 17
    //   74: aload_0
    //   75: getfield 97	com/squareup/a/a/b/s:o	Ljava/util/Map;
    //   78: invokeinterface 386 1 0
    //   83: aload_0
    //   84: iconst_0
    //   85: invokespecial 270	com/squareup/a/a/b/s:a	(Z)V
    //   88: aload 17
    //   90: astore 6
    //   92: aload_0
    //   93: getfield 388	com/squareup/a/a/b/s:v	Ljava/util/Map;
    //   96: ifnull +202 -> 298
    //   99: aload_0
    //   100: getfield 388	com/squareup/a/a/b/s:v	Ljava/util/Map;
    //   103: invokeinterface 372 1 0
    //   108: aload_0
    //   109: getfield 388	com/squareup/a/a/b/s:v	Ljava/util/Map;
    //   112: invokeinterface 375 1 0
    //   117: anewarray 390	com/squareup/a/a/b/n
    //   120: invokeinterface 381 2 0
    //   125: checkcast 392	[Lcom/squareup/a/a/b/n;
    //   128: astore 16
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 388	com/squareup/a/a/b/s:v	Ljava/util/Map;
    //   135: aload 16
    //   137: astore 7
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 6
    //   143: ifnull +73 -> 216
    //   146: aload 6
    //   148: arraylength
    //   149: istore 11
    //   151: iconst_0
    //   152: istore 12
    //   154: aload 4
    //   156: astore 13
    //   158: iload 12
    //   160: iload 11
    //   162: if_icmpge +50 -> 212
    //   165: aload 6
    //   167: iload 12
    //   169: aaload
    //   170: astore 14
    //   172: aload 14
    //   174: aload_2
    //   175: invokevirtual 393	com/squareup/a/a/b/ac:a	(Lcom/squareup/a/a/b/a;)V
    //   178: iinc 12 1
    //   181: goto -23 -> 158
    //   184: astore_3
    //   185: aload_3
    //   186: astore 4
    //   188: goto -159 -> 29
    //   191: astore 5
    //   193: aload_0
    //   194: monitorexit
    //   195: aload 5
    //   197: athrow
    //   198: astore 15
    //   200: aload 13
    //   202: ifnull -24 -> 178
    //   205: aload 15
    //   207: astore 13
    //   209: goto -31 -> 178
    //   212: aload 13
    //   214: astore 4
    //   216: aload 7
    //   218: ifnull +32 -> 250
    //   221: aload 7
    //   223: arraylength
    //   224: istore 9
    //   226: iconst_0
    //   227: istore 10
    //   229: iload 10
    //   231: iload 9
    //   233: if_icmpge +17 -> 250
    //   236: aload 7
    //   238: iload 10
    //   240: aaload
    //   241: invokevirtual 394	com/squareup/a/a/b/n:c	()V
    //   244: iinc 10 1
    //   247: goto -18 -> 229
    //   250: aload_0
    //   251: getfield 207	com/squareup/a/a/b/s:i	Lcom/squareup/a/a/b/c;
    //   254: invokeinterface 397 1 0
    //   259: aload 4
    //   261: astore 8
    //   263: aload_0
    //   264: getfield 192	com/squareup/a/a/b/s:h	Ljava/net/Socket;
    //   267: invokevirtual 400	java/net/Socket:close	()V
    //   270: aload 8
    //   272: ifnull +20 -> 292
    //   275: aload 8
    //   277: athrow
    //   278: astore 8
    //   280: aload 4
    //   282: ifnull -19 -> 263
    //   285: aload 4
    //   287: astore 8
    //   289: goto -26 -> 263
    //   292: return
    //   293: astore 8
    //   295: goto -25 -> 270
    //   298: aconst_null
    //   299: astore 7
    //   301: goto -162 -> 139
    //   304: aconst_null
    //   305: astore 6
    //   307: goto -215 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   21	26	184	java/io/IOException
    //   31	88	191	finally
    //   92	135	191	finally
    //   139	141	191	finally
    //   193	195	191	finally
    //   172	178	198	java/io/IOException
    //   250	259	278	java/io/IOException
    //   263	270	293	java/io/IOException
  }

  private void a(boolean paramBoolean)
  {
    monitorenter;
    if (paramBoolean);
    try
    {
      long l1 = System.nanoTime();
      while (true)
      {
        this.t = l1;
        return;
        l1 = 9223372036854775807L;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(boolean paramBoolean, int paramInt1, int paramInt2, n paramn)
  {
    ExecutorService localExecutorService = m;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    localExecutorService.submit(new v(this, "OkHttp %s ping %08x%08x", arrayOfObject, paramBoolean, paramInt1, paramInt2, paramn));
  }

  private void b(int paramInt, List<d> paramList, boolean paramBoolean)
  {
    ExecutorService localExecutorService = this.u;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new x(this, "OkHttp %s Push Headers[%s]", arrayOfObject, paramInt, paramList, paramBoolean));
  }

  private void b(boolean paramBoolean, int paramInt1, int paramInt2, n paramn)
    throws IOException
  {
    c localc = this.i;
    monitorenter;
    if (paramn != null);
    try
    {
      paramn.a();
      this.i.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private n c(int paramInt)
  {
    monitorenter;
    try
    {
      if (this.v != null)
      {
        localn = (n)this.v.remove(Integer.valueOf(paramInt));
        return localn;
      }
      n localn = null;
    }
    finally
    {
      monitorexit;
    }
  }

  private void c(int paramInt, a parama)
  {
    ExecutorService localExecutorService = this.u;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new z(this, "OkHttp %s Push Reset[%s]", arrayOfObject, paramInt, parama));
  }

  private boolean d(int paramInt)
  {
    return (this.a == com.squareup.a.v.d) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }

  ac a(int paramInt)
  {
    monitorenter;
    try
    {
      ac localac = (ac)this.o.get(Integer.valueOf(paramInt));
      monitorexit;
      return localac;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ac a(int paramInt, List<d> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.b)
      throw new IllegalStateException("Client cannot push requests.");
    if (this.a != com.squareup.a.v.d)
      throw new IllegalStateException("protocol != HTTP_2");
    return a(paramInt, paramList, paramBoolean, false);
  }

  public ac a(List<d> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return a(0, paramList, paramBoolean1, paramBoolean2);
  }

  public com.squareup.a.v a()
  {
    return this.a;
  }

  void a(int paramInt, long paramLong)
  {
    ExecutorService localExecutorService = m;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new u(this, "OkHttp Window Update %s stream %d", arrayOfObject, paramInt, paramLong));
  }

  void a(int paramInt, a parama)
  {
    ExecutorService localExecutorService = m;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new t(this, "OkHttp %s stream %d", arrayOfObject, paramInt, parama));
  }

  public void a(int paramInt, boolean paramBoolean, b.e parame, long paramLong)
    throws IOException
  {
    if (paramLong == 0L)
    {
      this.i.a(paramBoolean, paramInt, parame, 0);
      return;
    }
    while (true)
    {
      try
      {
        int i1 = (int)Math.min(Math.min(paramLong, this.d), this.j);
        this.d -= i1;
        monitorexit;
        paramLong -= i1;
        c localc = this.i;
        if ((paramBoolean) && (paramLong == 0L))
        {
          bool = true;
          localc.a(bool, paramInt, parame, i1);
          if (paramLong <= 0L)
            break;
          monitorenter;
          try
          {
            if (this.d > 0L)
              continue;
            wait();
            continue;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new InterruptedIOException();
          }
        }
      }
      finally
      {
        monitorexit;
      }
      boolean bool = false;
    }
  }

  void a(int paramInt, boolean paramBoolean, List<d> paramList)
    throws IOException
  {
    this.i.a(paramBoolean, paramInt, paramList);
  }

  void a(long paramLong)
  {
    this.d = (paramLong + this.d);
    if (paramLong > 0L)
      notifyAll();
  }

  public void a(a parama)
    throws IOException
  {
    synchronized (this.i)
    {
      monitorenter;
    }
    try
    {
      if (this.s)
      {
        monitorexit;
        return;
      }
      this.s = true;
      int i1 = this.q;
      monitorexit;
      this.i.a(i1, parama, l.a);
      return;
      localObject1 = finally;
      throw localObject1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public int b()
  {
    monitorenter;
    try
    {
      int i1 = this.o.size();
      monitorexit;
      return i1;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  ac b(int paramInt)
  {
    monitorenter;
    try
    {
      ac localac = (ac)this.o.remove(Integer.valueOf(paramInt));
      if ((localac != null) && (this.o.isEmpty()))
        a(true);
      return localac;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void b(int paramInt, a parama)
    throws IOException
  {
    this.i.a(paramInt, parama);
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      long l1 = this.t;
      if (l1 != 9223372036854775807L)
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

  public void close()
    throws IOException
  {
    a(a.a, a.l);
  }

  public long d()
  {
    monitorenter;
    try
    {
      long l1 = this.t;
      monitorexit;
      return l1;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public n e()
    throws IOException
  {
    n localn = new n();
    monitorenter;
    try
    {
      if (this.s)
        throw new IOException("shutdown");
    }
    finally
    {
      monitorexit;
    }
    int i1 = this.x;
    this.x = (2 + this.x);
    if (this.v == null)
      this.v = new HashMap();
    this.v.put(Integer.valueOf(i1), localn);
    monitorexit;
    b(false, i1, 1330343787, localn);
    return localn;
  }

  public void f()
    throws IOException
  {
    this.i.c();
  }

  public void g()
    throws IOException
  {
    this.i.a();
    this.i.a(this.e);
  }

  public static class a
  {
    private String a;
    private Socket b;
    private i c = i.a;
    private com.squareup.a.v d = com.squareup.a.v.c;
    private o e = o.a;
    private boolean f;

    public a(String paramString, boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this.a = paramString;
      this.f = paramBoolean;
      this.b = paramSocket;
    }

    public a(boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this(((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), paramBoolean, paramSocket);
    }

    public a a(i parami)
    {
      this.c = parami;
      return this;
    }

    public a a(o paramo)
    {
      this.e = paramo;
      return this;
    }

    public a a(com.squareup.a.v paramv)
    {
      this.d = paramv;
      return this;
    }

    public s a()
      throws IOException
    {
      return new s(this, null);
    }
  }

  class b extends com.squareup.a.a.i
    implements b.a
  {
    b a;

    private b()
    {
      super(arrayOfObject);
    }

    private void b()
    {
      ExecutorService localExecutorService = s.h();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = s.a(s.this);
      localExecutorService.submit(new ab(this, "OkHttp %s ACK Settings", arrayOfObject));
    }

    public void a()
    {
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
    }

    public void a(int paramInt1, int paramInt2, List<d> paramList)
    {
      s.a(s.this, paramInt2, paramList);
    }

    public void a(int paramInt, long paramLong)
    {
      if (paramInt == 0)
        synchronized (s.this)
        {
          s locals2 = s.this;
          locals2.d = (paramLong + locals2.d);
          s.this.notifyAll();
          return;
        }
      ac localac = s.this.a(paramInt);
      if (localac != null)
      {
        monitorenter;
        try
        {
          localac.a(paramLong);
          return;
        }
        finally
        {
          monitorexit;
        }
      }
    }

    public void a(int paramInt, a parama)
    {
      if (s.a(s.this, paramInt))
        s.a(s.this, paramInt, parama);
      ac localac;
      do
      {
        return;
        localac = s.this.b(paramInt);
      }
      while (localac == null);
      localac.c(parama);
    }

    public void a(int paramInt, a parama, j paramj)
    {
      if (paramj.f() > 0);
      synchronized (s.this)
      {
        s.b(s.this, true);
        Iterator localIterator = s.e(s.this).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if ((((Integer)localEntry.getKey()).intValue() <= paramInt) || (!((ac)localEntry.getValue()).c()))
            continue;
          ((ac)localEntry.getValue()).c(a.k);
          localIterator.remove();
        }
      }
      monitorexit;
    }

    public void a(int paramInt1, String paramString1, j paramj, String paramString2, int paramInt2, long paramLong)
    {
    }

    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        n localn = s.c(s.this, paramInt1);
        if (localn != null)
          localn.b();
        return;
      }
      s.b(s.this, true, paramInt1, paramInt2, null);
    }

    public void a(boolean paramBoolean, int paramInt1, b.i parami, int paramInt2)
      throws IOException
    {
      if (s.a(s.this, paramInt1))
        s.a(s.this, paramInt1, parami, paramInt2, paramBoolean);
      ac localac;
      do
      {
        return;
        localac = s.this.a(paramInt1);
        if (localac == null)
        {
          s.this.a(paramInt1, a.c);
          parami.g(paramInt2);
          return;
        }
        localac.a(parami, paramInt2);
      }
      while (!paramBoolean);
      localac.l();
    }

    public void a(boolean paramBoolean, q paramq)
    {
      while (true)
      {
        synchronized (s.this)
        {
          int i = s.this.f.j(65536);
          if (!paramBoolean)
            continue;
          s.this.f.a();
          s.this.f.a(paramq);
          if (s.this.a() != com.squareup.a.v.d)
            continue;
          b();
          int j = s.this.f.j(65536);
          if ((j == -1) || (j == i))
            break label272;
          l = j - i;
          if (s.g(s.this))
            continue;
          s.this.a(l);
          s.a(s.this, true);
          boolean bool = s.e(s.this).isEmpty();
          arrayOfac = null;
          if (bool)
            continue;
          arrayOfac = (ac[])s.e(s.this).values().toArray(new ac[s.e(s.this).size()]);
          if ((arrayOfac != null) && (l != 0L))
          {
            Iterator localIterator = s.e(s.this).values().iterator();
            if (localIterator.hasNext())
              synchronized ((ac)localIterator.next())
              {
                ???.a(l);
              }
          }
        }
        return;
        label272: long l = 0L;
        ac[] arrayOfac = null;
      }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<d> paramList, e parame)
    {
      if (s.a(s.this, paramInt1))
        s.a(s.this, paramInt1, paramList, paramBoolean2);
      ac localac1;
      do
      {
        return;
        synchronized (s.this)
        {
          if (s.b(s.this))
            return;
        }
        localac1 = s.this.a(paramInt1);
        if (localac1 == null)
        {
          if (parame.a())
          {
            s.this.a(paramInt1, a.c);
            monitorexit;
            return;
          }
          if (paramInt1 <= s.c(s.this))
          {
            monitorexit;
            return;
          }
          if (paramInt1 % 2 == s.d(s.this) % 2)
          {
            monitorexit;
            return;
          }
          ac localac2 = new ac(paramInt1, s.this, paramBoolean1, paramBoolean2, paramList);
          s.b(s.this, paramInt1);
          s.e(s.this).put(Integer.valueOf(paramInt1), localac2);
          ExecutorService localExecutorService = s.h();
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = s.a(s.this);
          arrayOfObject[1] = Integer.valueOf(paramInt1);
          localExecutorService.submit(new aa(this, "OkHttp %s stream %d", arrayOfObject, localac2));
          monitorexit;
          return;
        }
        monitorexit;
        if (parame.b())
        {
          localac1.b(a.b);
          s.this.b(paramInt1);
          return;
        }
        localac1.a(paramList, parame);
      }
      while (!paramBoolean2);
      localac1.l();
    }

    // ERROR //
    protected void e()
    {
      // Byte code:
      //   0: getstatic 271	com/squareup/a/a/b/a:g	Lcom/squareup/a/a/b/a;
      //   3: astore_1
      //   4: getstatic 271	com/squareup/a/a/b/a:g	Lcom/squareup/a/a/b/a;
      //   7: astore_2
      //   8: aload_0
      //   9: aload_0
      //   10: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   13: getfield 274	com/squareup/a/a/b/s:g	Lcom/squareup/a/a/b/ad;
      //   16: aload_0
      //   17: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   20: getfield 277	com/squareup/a/a/b/s:h	Ljava/net/Socket;
      //   23: invokestatic 282	b/q:b	(Ljava/net/Socket;)Lb/ab;
      //   26: invokestatic 285	b/q:a	(Lb/ab;)Lb/i;
      //   29: aload_0
      //   30: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   33: getfield 288	com/squareup/a/a/b/s:b	Z
      //   36: invokeinterface 293 3 0
      //   41: putfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   44: aload_0
      //   45: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   48: getfield 288	com/squareup/a/a/b/s:b	Z
      //   51: ifne +12 -> 63
      //   54: aload_0
      //   55: getfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   58: invokeinterface 298 1 0
      //   63: aload_0
      //   64: getfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   67: aload_0
      //   68: invokeinterface 301 2 0
      //   73: ifne -10 -> 63
      //   76: getstatic 303	com/squareup/a/a/b/a:a	Lcom/squareup/a/a/b/a;
      //   79: astore_1
      //   80: getstatic 305	com/squareup/a/a/b/a:l	Lcom/squareup/a/a/b/a;
      //   83: astore 10
      //   85: aload_0
      //   86: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   89: aload_1
      //   90: aload 10
      //   92: invokestatic 308	com/squareup/a/a/b/s:a	(Lcom/squareup/a/a/b/s;Lcom/squareup/a/a/b/a;Lcom/squareup/a/a/b/a;)V
      //   95: aload_0
      //   96: getfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   99: invokestatic 313	com/squareup/a/a/l:a	(Ljava/io/Closeable;)V
      //   102: return
      //   103: astore 7
      //   105: getstatic 264	com/squareup/a/a/b/a:b	Lcom/squareup/a/a/b/a;
      //   108: astore 4
      //   110: getstatic 264	com/squareup/a/a/b/a:b	Lcom/squareup/a/a/b/a;
      //   113: astore 8
      //   115: aload_0
      //   116: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   119: aload 4
      //   121: aload 8
      //   123: invokestatic 308	com/squareup/a/a/b/s:a	(Lcom/squareup/a/a/b/s;Lcom/squareup/a/a/b/a;Lcom/squareup/a/a/b/a;)V
      //   126: aload_0
      //   127: getfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   130: invokestatic 313	com/squareup/a/a/l:a	(Ljava/io/Closeable;)V
      //   133: return
      //   134: astore_3
      //   135: aload_1
      //   136: astore 4
      //   138: aload_3
      //   139: astore 5
      //   141: aload_0
      //   142: getfield 14	com/squareup/a/a/b/s$b:b	Lcom/squareup/a/a/b/s;
      //   145: aload 4
      //   147: aload_2
      //   148: invokestatic 308	com/squareup/a/a/b/s:a	(Lcom/squareup/a/a/b/s;Lcom/squareup/a/a/b/a;Lcom/squareup/a/a/b/a;)V
      //   151: aload_0
      //   152: getfield 295	com/squareup/a/a/b/s$b:a	Lcom/squareup/a/a/b/b;
      //   155: invokestatic 313	com/squareup/a/a/l:a	(Ljava/io/Closeable;)V
      //   158: aload 5
      //   160: athrow
      //   161: astore 6
      //   163: goto -12 -> 151
      //   166: astore 5
      //   168: goto -27 -> 141
      //   171: astore 9
      //   173: goto -47 -> 126
      //   176: astore 11
      //   178: goto -83 -> 95
      //
      // Exception table:
      //   from	to	target	type
      //   8	63	103	java/io/IOException
      //   63	85	103	java/io/IOException
      //   8	63	134	finally
      //   63	85	134	finally
      //   105	110	134	finally
      //   141	151	161	java/io/IOException
      //   110	115	166	finally
      //   115	126	171	java/io/IOException
      //   85	95	176	java/io/IOException
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.s
 * JD-Core Version:    0.6.0
 */