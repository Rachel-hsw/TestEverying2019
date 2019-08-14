package a.a.a.f;

import a.a.a.b;
import a.a.a.c;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class a<T extends b, S extends c> extends f
{
  protected T a;
  protected S b;
  private final Class<T> c;

  public a(Class<T> paramClass)
  {
    this(paramClass, true);
  }

  public a(Class<T> paramClass, boolean paramBoolean)
  {
    super(paramBoolean);
    this.c = paramClass;
  }

  protected void setUp()
    throws Exception
  {
    super.setUp();
    try
    {
      Constructor localConstructor = this.c.getConstructor(new Class[] { SQLiteDatabase.class });
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.j;
      this.a = ((b)localConstructor.newInstance(arrayOfObject1));
      Class localClass = this.c;
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = SQLiteDatabase.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("createAllTables", arrayOfClass);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = this.j;
      arrayOfObject2[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject2);
      this.b = this.a.c();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException("Could not prepare DAO session test", localException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.a
 * JD-Core Version:    0.6.0
 */