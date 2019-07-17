package com.squareup.a.a.b;

import b.aa;
import b.ab;
import b.i;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public final class ac
{
  long a = 0L;
  long b;
  final a c;
  private final int e;
  private final s f;
  private long g = 0L;
  private final List<d> h;
  private List<d> i;
  private final b j;
  private final c k = new c();
  private final c l = new c();
  private a m = null;

  static
  {
    if (!ac.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      d = bool;
      return;
    }
  }

  ac(int paramInt, s params, boolean paramBoolean1, boolean paramBoolean2, List<d> paramList)
  {
    if (params == null)
      throw new NullPointerException("connection == null");
    if (paramList == null)
      throw new NullPointerException("requestHeaders == null");
    this.e = paramInt;
    this.f = params;
    this.b = params.f.j(65536);
    this.j = new b(params.e.j(65536), null);
    this.c = new a();
    b.a(this.j, paramBoolean2);
    a.a(this.c, paramBoolean1);
    this.h = paramList;
  }

  private boolean d(a parama)
  {
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    monitorenter;
    try
    {
      if (this.m != null)
        return false;
      if ((b.a(this.j)) && (a.a(this.c)))
        return false;
    }
    finally
    {
      monitorexit;
    }
    this.m = parama;
    notifyAll();
    monitorexit;
    this.f.b(this.e);
    return true;
  }

  private void m()
    throws IOException
  {
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    monitorenter;
    while (true)
    {
      boolean bool;
      try
      {
        if ((b.a(this.j)) || (!b.b(this.j)))
          continue;
        if (a.a(this.c))
          break label112;
        if (!a.b(this.c))
          continue;
        break label112;
        bool = b();
        monitorexit;
        if (n != 0)
        {
          a(a.l);
          return;
          n = 0;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (bool)
        continue;
      this.f.b(this.e);
      return;
      label112: int n = 1;
    }
  }

  private void n()
    throws IOException
  {
    if (a.b(this.c))
      throw new IOException("stream closed");
    if (a.a(this.c))
      throw new IOException("stream finished");
    if (this.m != null)
      throw new IOException("stream was reset: " + this.m);
  }

  private void o()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new InterruptedIOException();
  }

  public int a()
  {
    return this.e;
  }

  void a(long paramLong)
  {
    this.b = (paramLong + this.b);
    if (paramLong > 0L)
      notifyAll();
  }

  void a(i parami, int paramInt)
    throws IOException
  {
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    this.j.a(parami, paramInt);
  }

  public void a(a parama)
    throws IOException
  {
    if (!d(parama))
      return;
    this.f.b(this.e, parama);
  }

  void a(List<d> paramList, e parame)
  {
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    boolean bool = true;
    monitorenter;
    do
      while (true)
      {
        try
        {
          if (this.i == null)
          {
            if (!parame.c())
              continue;
            locala = a.b;
            monitorexit;
            if (locala == null)
              break;
            b(locala);
            return;
            this.i = paramList;
            bool = b();
            notifyAll();
            locala = null;
            continue;
          }
        }
        finally
        {
          monitorexit;
        }
        if (parame.d())
        {
          locala = a.e;
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.i);
        localArrayList.addAll(paramList);
        this.i = localArrayList;
        a locala = null;
      }
    while (bool);
    this.f.b(this.e);
  }

  public void a(List<d> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = true;
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    monitorenter;
    if (paramList == null)
      try
      {
        throw new NullPointerException("responseHeaders == null");
      }
      finally
      {
        monitorexit;
      }
    if (this.i != null)
      throw new IllegalStateException("reply already sent");
    this.i = paramList;
    if (!paramBoolean)
      a.a(this.c, true);
    while (true)
    {
      monitorexit;
      this.f.a(this.e, bool, paramList);
      if (bool)
        this.f.f();
      return;
      bool = false;
    }
  }

  public void b(a parama)
  {
    if (!d(parama))
      return;
    this.f.a(this.e, parama);
  }

  public boolean b()
  {
    monitorenter;
    try
    {
      a locala = this.m;
      int n = 0;
      if (locala != null);
      while (true)
      {
        return n;
        if (((b.a(this.j)) || (b.b(this.j))) && ((a.a(this.c)) || (a.b(this.c))))
        {
          List localList = this.i;
          n = 0;
          if (localList != null)
            continue;
        }
        n = 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void c(a parama)
  {
    monitorenter;
    try
    {
      if (this.m == null)
      {
        this.m = parama;
        notifyAll();
      }
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

  public boolean c()
  {
    if ((0x1 & this.e) == 1);
    for (int n = 1; this.f.b == n; n = 0)
      return true;
    return false;
  }

  public s d()
  {
    return this.f;
  }

  public List<d> e()
  {
    return this.h;
  }

  public List<d> f()
    throws IOException
  {
    monitorenter;
    try
    {
      this.k.c();
    }
    finally
    {
      try
      {
        if ((this.i != null) || (this.m != null))
          break label45;
        o();
      }
      finally
      {
        this.k.b();
      }
      monitorexit;
    }
    label45: this.k.b();
    if (this.i != null)
    {
      List localList = this.i;
      monitorexit;
      return localList;
    }
    throw new IOException("stream was reset: " + this.m);
  }

  public a g()
  {
    monitorenter;
    try
    {
      a locala = this.m;
      monitorexit;
      return locala;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public b.ac h()
  {
    return this.k;
  }

  public b.ac i()
  {
    return this.l;
  }

  public ab j()
  {
    return this.j;
  }

  public aa k()
  {
    monitorenter;
    try
    {
      if ((this.i == null) && (!c()))
        throw new IllegalStateException("reply before requesting the sink");
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return this.c;
  }

  void l()
  {
    if ((!d) && (Thread.holdsLock(this)))
      throw new AssertionError();
    monitorenter;
    try
    {
      b.a(this.j, true);
      boolean bool = b();
      notifyAll();
      monitorexit;
      if (!bool)
        this.f.b(this.e);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  final class a
    implements aa
  {
    private boolean c;
    private boolean d;

    static
    {
      if (!ac.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        a = bool;
        return;
      }
    }

    a()
    {
    }

    public b.ac a()
    {
      return ac.g(ac.this);
    }

    public void a(b.e parame, long paramLong)
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(ac.this)))
        throw new AssertionError();
      try
      {
        ac.g(ac.this).b();
        ac.h(ac.this);
        long l = Math.min(ac.this.b, paramLong);
        ac localac2 = ac.this;
        localac2.b -= l;
        monitorexit;
        paramLong -= l;
        ac.a(ac.this).a(ac.b(ac.this), false, parame, l);
        if (paramLong > 0L)
        {
          localac1 = ac.this;
          monitorenter;
          ac.g(ac.this).c();
        }
      }
      finally
      {
        ac localac1;
        try
        {
          while ((ac.this.b > 0L) || (this.d) || (this.c) || (ac.d(ac.this) != null));
          ac.e(ac.this);
        }
        finally
        {
          ac.g(ac.this).b();
        }
        monitorexit;
      }
    }

    public void b()
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(ac.this)))
        throw new AssertionError();
      synchronized (ac.this)
      {
        ac.h(ac.this);
        ac.a(ac.this).f();
        return;
      }
    }

    public void close()
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(ac.this)))
        throw new AssertionError();
      synchronized (ac.this)
      {
        if (this.c)
          return;
        if (!ac.this.c.d)
          ac.a(ac.this).a(ac.b(ac.this), true, null, 0L);
      }
      synchronized (ac.this)
      {
        this.c = true;
        ac.a(ac.this).f();
        ac.f(ac.this);
        return;
        localObject1 = finally;
        monitorexit;
        throw localObject1;
      }
    }
  }

  private final class b
    implements ab
  {
    private final b.e c = new b.e();
    private final b.e d = new b.e();
    private final long e;
    private boolean f;
    private boolean g;

    static
    {
      if (!ac.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        a = bool;
        return;
      }
    }

    private b(long arg2)
    {
      Object localObject;
      this.e = localObject;
    }

    private void b()
      throws IOException
    {
      ac.c(ac.this).c();
      try
      {
        if (this.d.c() == 0L)
          if ((!this.g) && (!this.f) && (ac.d(ac.this) == null))
            ac.e(ac.this);
      }
      finally
      {
        ac.c(ac.this).b();
      }
    }

    private void c()
      throws IOException
    {
      if (this.f)
        throw new IOException("stream closed");
      if (ac.d(ac.this) != null)
        throw new IOException("stream was reset: " + ac.d(ac.this));
    }

    public b.ac a()
    {
      return ac.c(ac.this);
    }

    void a(i parami, long paramLong)
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(ac.this)))
        throw new AssertionError();
      while (true)
      {
        Object localObject2;
        paramLong -= localObject2;
        synchronized (ac.this)
        {
          if (this.d.c() == 0L)
          {
            j = 1;
            this.d.a(this.c);
            if (j != 0)
              ac.this.notifyAll();
            if (paramLong > 0L);
            boolean bool;
            synchronized (ac.this)
            {
              bool = this.g;
              int i;
              if (paramLong + this.d.c() > this.e)
              {
                i = 1;
                if (i != 0)
                {
                  parami.g(paramLong);
                  ac.this.b(a.h);
                  return;
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              parami.g(paramLong);
              return;
            }
            long l = parami.b(this.c, paramLong);
            if (l != -1L)
              continue;
            throw new EOFException();
          }
          int j = 0;
        }
      }
    }

    public long b(b.e parame, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      synchronized (ac.this)
      {
        b();
        c();
        if (this.d.c() == 0L)
          return -1L;
        long l = this.d.b(parame, Math.min(paramLong, this.d.c()));
        ac localac2 = ac.this;
        localac2.a = (l + localac2.a);
        if (ac.this.a >= ac.a(ac.this).f.j(65536) / 2)
        {
          ac.a(ac.this).a(ac.b(ac.this), ac.this.a);
          ac.this.a = 0L;
        }
        synchronized (ac.a(ac.this))
        {
          s locals2 = ac.a(ac.this);
          locals2.c = (l + locals2.c);
          if (ac.a(ac.this).c >= ac.a(ac.this).f.j(65536) / 2)
          {
            ac.a(ac.this).a(0, ac.a(ac.this).c);
            ac.a(ac.this).c = 0L;
          }
          return l;
        }
      }
    }

    public void close()
      throws IOException
    {
      synchronized (ac.this)
      {
        this.f = true;
        this.d.v();
        ac.this.notifyAll();
        ac.f(ac.this);
        return;
      }
    }
  }

  class c extends b.a
  {
    c()
    {
    }

    protected void a()
    {
      ac.this.b(a.l);
    }

    public void b()
      throws InterruptedIOException
    {
      if (d())
        throw new InterruptedIOException("timeout");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.ac
 * JD-Core Version:    0.6.0
 */