package a.a.a.f;

import a.a.a.e;
import a.a.a.h;
import a.a.a.i;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Method;

public abstract class b<D extends a.a.a.a<T, K>, T, K> extends f
{
  protected final Class<D> a;
  protected D b;
  protected h<T, K> c;
  protected i d;
  protected a.a.a.c.a<K, T> e;

  public b(Class<D> paramClass)
  {
    this(paramClass, true);
  }

  public b(Class<D> paramClass, boolean paramBoolean)
  {
    super(paramBoolean);
    this.a = paramClass;
  }

  protected void a()
    throws Exception
  {
    try
    {
      Class localClass = this.a;
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = SQLiteDatabase.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("createTable", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.j;
      arrayOfObject[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      e.c("No createTable method");
    }
  }

  public void a(a.a.a.c.a<K, T> parama)
  {
    this.e = parama;
  }

  protected void b()
  {
    if (this.e != null)
    {
      this.e.a();
      e.b("Identity scope cleared");
      return;
    }
    e.b("No identity scope to clear");
  }

  protected void c()
  {
    a(this.b.c());
  }

  protected void setUp()
    throws Exception
  {
    super.setUp();
    try
    {
      a();
      this.c = new h(this.j, this.a, this.e);
      this.b = this.c.c();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException("Could not prepare DAO Test", localException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.b
 * JD-Core Version:    0.6.0
 */