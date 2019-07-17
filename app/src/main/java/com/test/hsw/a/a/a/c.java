package a.a.a;

import a.a.a.a.e;
import a.a.a.e.i;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class c
{
  private final SQLiteDatabase a;
  private final Map<Class<?>, a<?, ?>> b;

  public c(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
    this.b = new HashMap();
  }

  public <T> long a(T paramT)
  {
    return d(paramT.getClass()).c(paramT);
  }

  public SQLiteDatabase a()
  {
    return this.a;
  }

  public <T, K> T a(Class<T> paramClass, K paramK)
  {
    return d(paramClass).a(paramK);
  }

  public <V> V a(Callable<V> paramCallable)
    throws Exception
  {
    this.a.beginTransaction();
    try
    {
      Object localObject2 = paramCallable.call();
      this.a.setTransactionSuccessful();
      return localObject2;
    }
    finally
    {
      this.a.endTransaction();
    }
    throw localObject1;
  }

  public <T, K> List<T> a(Class<T> paramClass, String paramString, String[] paramArrayOfString)
  {
    return d(paramClass).a(paramString, paramArrayOfString);
  }

  public <T> void a(Class<T> paramClass)
  {
    d(paramClass).j();
  }

  protected <T> void a(Class<T> paramClass, a<T, ?> parama)
  {
    this.b.put(paramClass, parama);
  }

  public void a(Runnable paramRunnable)
  {
    this.a.beginTransaction();
    try
    {
      paramRunnable.run();
      this.a.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.a.endTransaction();
    }
    throw localObject;
  }

  public <T> long b(T paramT)
  {
    return d(paramT.getClass()).e(paramT);
  }

  public e b()
  {
    return new e(this);
  }

  public <V> V b(Callable<V> paramCallable)
  {
    this.a.beginTransaction();
    try
    {
      Object localObject2 = paramCallable.call();
      this.a.setTransactionSuccessful();
      return localObject2;
    }
    catch (Exception localException)
    {
      throw new d("Callable failed", localException);
    }
    finally
    {
      this.a.endTransaction();
    }
    throw localObject1;
  }

  public <T, K> List<T> b(Class<T> paramClass)
  {
    return d(paramClass).i();
  }

  public <T> i<T> c(Class<T> paramClass)
  {
    return d(paramClass).k();
  }

  public <T> void c(T paramT)
  {
    d(paramT.getClass()).h(paramT);
  }

  public a<?, ?> d(Class<? extends Object> paramClass)
  {
    a locala = (a)this.b.get(paramClass);
    if (locala == null)
      throw new d("No DAO registered for " + paramClass);
    return locala;
  }

  public <T> void d(T paramT)
  {
    d(paramT.getClass()).i(paramT);
  }

  public <T> void e(T paramT)
  {
    d(paramT.getClass()).f(paramT);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.c
 * JD-Core Version:    0.6.0
 */