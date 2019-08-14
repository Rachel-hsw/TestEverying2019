package a.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Constructor;

public class h<T, K>
{
  private final a<T, K> a;

  public h(SQLiteDatabase paramSQLiteDatabase, Class<a<T, K>> paramClass, a.a.a.c.a<?, ?> parama)
    throws Exception
  {
    a.a.a.d.a locala = new a.a.a.d.a(paramSQLiteDatabase, paramClass);
    locala.a(parama);
    this.a = ((a)paramClass.getConstructor(new Class[] { a.a.a.d.a.class }).newInstance(new Object[] { locala }));
  }

  public T a(Cursor paramCursor, int paramInt)
  {
    return this.a.a(paramCursor, paramInt);
  }

  public K a(T paramT)
  {
    return this.a.l(paramT);
  }

  public i[] a()
  {
    return this.a.d();
  }

  public K b(Cursor paramCursor, int paramInt)
  {
    return this.a.b(paramCursor, paramInt);
  }

  public boolean b()
  {
    return this.a.o();
  }

  public a<T, K> c()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.h
 * JD-Core Version:    0.6.0
 */