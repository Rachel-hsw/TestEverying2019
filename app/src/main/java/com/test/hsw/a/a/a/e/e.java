package a.a.a.e;

import android.database.sqlite.SQLiteDatabase;

public class e<T> extends a<T>
{
  private final a<T> f;

  private e(a<T> parama, a.a.a.a<T, ?> parama1, String paramString, String[] paramArrayOfString)
  {
    super(parama1, paramString, paramArrayOfString);
    this.f = parama;
  }

  static <T2> e<T2> a(a.a.a.a<T2, ?> parama, String paramString, Object[] paramArrayOfObject)
  {
    return (e)new a(parama, paramString, a(paramArrayOfObject), null).a();
  }

  public e<T> b()
  {
    return (e)this.f.a(this);
  }

  public void c()
  {
    a();
    SQLiteDatabase localSQLiteDatabase = this.a.n();
    if (localSQLiteDatabase.isDbLockedByCurrentThread())
    {
      this.a.n().execSQL(this.c, this.d);
      return;
    }
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.a.n().execSQL(this.c, this.d);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private static final class a<T2> extends b<T2, e<T2>>
  {
    private a(a.a.a.a<T2, ?> parama, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }

    protected e<T2> d()
    {
      return new e(this, this.b, this.a, (String[])this.c.clone(), null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.e
 * JD-Core Version:    0.6.0
 */