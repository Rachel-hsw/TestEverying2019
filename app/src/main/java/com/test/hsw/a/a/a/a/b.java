package a.a.a.a;

import a.a.a.d;
import android.database.sqlite.SQLiteDatabase;

public class b
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  final a d;
  final a.a.a.a<Object, Object> e;
  final Object f;
  final int g;
  volatile long h;
  volatile long i;
  volatile Throwable j;
  final Exception k;
  volatile Object l;
  volatile int m;
  int n;
  private final SQLiteDatabase o;
  private volatile boolean p;

  b(a parama, a.a.a.a<?, ?> parama1, SQLiteDatabase paramSQLiteDatabase, Object paramObject, int paramInt)
  {
    this.d = parama;
    this.g = paramInt;
    this.e = parama1;
    this.o = paramSQLiteDatabase;
    this.f = paramObject;
    if ((paramInt & 0x4) != 0);
    for (Exception localException = new Exception("AsyncOperation was created here"); ; localException = null)
    {
      this.k = localException;
      return;
    }
  }

  public Throwable a()
  {
    return this.j;
  }

  public void a(Throwable paramThrowable)
  {
    this.j = paramThrowable;
  }

  public boolean a(int paramInt)
  {
    monitorenter;
    try
    {
      boolean bool1 = this.p;
      long l1;
      if (!bool1)
        l1 = paramInt;
      try
      {
        wait(l1);
        boolean bool2 = this.p;
        monitorexit;
        return bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new d("Interrupted while waiting for operation to complete", localInterruptedException);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  boolean a(b paramb)
  {
    return (paramb != null) && (e()) && (paramb.e()) && (f() == paramb.f());
  }

  public a b()
  {
    return this.d;
  }

  public Object c()
  {
    return this.f;
  }

  public Object d()
  {
    monitorenter;
    try
    {
      if (!this.p)
        l();
      if (this.j != null)
        throw new a(this, this.j);
    }
    finally
    {
      monitorexit;
    }
    Object localObject2 = this.l;
    monitorexit;
    return localObject2;
  }

  public boolean e()
  {
    return (0x1 & this.g) != 0;
  }

  SQLiteDatabase f()
  {
    if (this.o != null)
      return this.o;
    return this.e.n();
  }

  public long g()
  {
    return this.h;
  }

  public long h()
  {
    return this.i;
  }

  public long i()
  {
    if (this.i == 0L)
      throw new d("This operation did not yet complete");
    return this.i - this.h;
  }

  public boolean j()
  {
    return this.j != null;
  }

  public boolean k()
  {
    return this.p;
  }

  public Object l()
  {
    monitorenter;
    try
    {
      while (true)
      {
        if (this.p)
        {
          Object localObject2 = this.l;
          return localObject2;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new d("Interrupted while waiting for operation to complete", localInterruptedException);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  void m()
  {
    monitorenter;
    try
    {
      this.p = true;
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

  public boolean n()
  {
    return (this.p) && (this.j == null);
  }

  public int o()
  {
    return this.m;
  }

  public int p()
  {
    return this.n;
  }

  void q()
  {
    this.h = 0L;
    this.i = 0L;
    this.p = false;
    this.j = null;
    this.l = null;
    this.m = 0;
  }

  public Exception r()
  {
    return this.k;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[22];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      arrayOfa[12] = m;
      arrayOfa[13] = n;
      arrayOfa[14] = o;
      arrayOfa[15] = p;
      arrayOfa[16] = q;
      arrayOfa[17] = r;
      arrayOfa[18] = s;
      arrayOfa[19] = t;
      arrayOfa[20] = u;
      arrayOfa[21] = v;
      w = arrayOfa;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.a.b
 * JD-Core Version:    0.6.0
 */