package a.a.a.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class d<T> extends a<T>
{
  private final a<T> f;

  private d(a<T> parama, a.a.a.a<T, ?> parama1, String paramString, String[] paramArrayOfString)
  {
    super(parama1, paramString, paramArrayOfString);
    this.f = parama;
  }

  static <T2> d<T2> a(a.a.a.a<T2, ?> parama, String paramString, Object[] paramArrayOfObject)
  {
    return (d)new a(parama, paramString, a(paramArrayOfObject), null).a();
  }

  public d<T> b()
  {
    return (d)this.f.a(this);
  }

  public long c()
  {
    a();
    Cursor localCursor = this.a.n().rawQuery(this.c, this.d);
    try
    {
      if (!localCursor.moveToNext())
        throw new a.a.a.d("No result for count");
    }
    finally
    {
      localCursor.close();
    }
    if (!localCursor.isLast())
      throw new a.a.a.d("Unexpected row count: " + localCursor.getCount());
    if (localCursor.getColumnCount() != 1)
      throw new a.a.a.d("Unexpected column count: " + localCursor.getColumnCount());
    long l = localCursor.getLong(0);
    localCursor.close();
    return l;
  }

  private static final class a<T2> extends b<T2, d<T2>>
  {
    private a(a.a.a.a<T2, ?> parama, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }

    protected d<T2> d()
    {
      return new d(this, this.b, this.a, (String[])this.c.clone(), null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.d
 * JD-Core Version:    0.6.0
 */