package a.a.a;

import a.a.a.c.d;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public abstract class b
{
  protected final SQLiteDatabase a;
  protected final int b;
  protected final Map<Class<? extends a<?, ?>>, a.a.a.d.a> c;

  public b(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.a = paramSQLiteDatabase;
    this.b = paramInt;
    this.c = new HashMap();
  }

  public int a()
  {
    return this.b;
  }

  public abstract c a(d paramd);

  protected void a(Class<? extends a<?, ?>> paramClass)
  {
    a.a.a.d.a locala = new a.a.a.d.a(this.a, paramClass);
    this.c.put(paramClass, locala);
  }

  public SQLiteDatabase b()
  {
    return this.a;
  }

  public abstract c c();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.b
 * JD-Core Version:    0.6.0
 */