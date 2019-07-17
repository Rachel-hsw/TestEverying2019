package a.a.a.e;

import a.a.a.d;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Date;
import java.util.List;

public class h<T> extends a<T>
{
  private final int f;
  private final int g;
  private final a<T> h;

  private h(a<T> parama, a.a.a.a<T, ?> parama1, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(parama1, paramString, paramArrayOfString);
    this.h = parama;
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public static <T2> h<T2> a(a.a.a.a<T2, ?> parama, String paramString, Object[] paramArrayOfObject)
  {
    return a(parama, paramString, paramArrayOfObject, -1, -1);
  }

  static <T2> h<T2> a(a.a.a.a<T2, ?> parama, String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (h)new a(parama, paramString, a(paramArrayOfObject), paramInt1, paramInt2).a();
  }

  public void a(int paramInt)
  {
    a();
    if (this.f == -1)
      throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    this.d[this.f] = Integer.toString(paramInt);
  }

  public void a(int paramInt, Boolean paramBoolean)
  {
    int i;
    if (paramBoolean != null)
      if (paramBoolean.booleanValue())
        i = 1;
    for (Integer localInteger = Integer.valueOf(i); ; localInteger = null)
    {
      a(paramInt, localInteger);
      return;
      i = 0;
      break;
    }
  }

  public void a(int paramInt, Object paramObject)
  {
    if ((paramInt >= 0) && ((paramInt == this.f) || (paramInt == this.g)))
      throw new IllegalArgumentException("Illegal parameter index: " + paramInt);
    super.a(paramInt, paramObject);
  }

  public void a(int paramInt, Date paramDate)
  {
    if (paramDate != null);
    for (Long localLong = Long.valueOf(paramDate.getTime()); ; localLong = null)
    {
      a(paramInt, localLong);
      return;
    }
  }

  public h<T> b()
  {
    return (h)this.h.a(this);
  }

  public void b(int paramInt)
  {
    a();
    if (this.g == -1)
      throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    this.d[this.g] = Integer.toString(paramInt);
  }

  public List<T> c()
  {
    a();
    Cursor localCursor = this.a.n().rawQuery(this.c, this.d);
    return this.b.a(localCursor);
  }

  public g<T> d()
  {
    a();
    Cursor localCursor = this.a.n().rawQuery(this.c, this.d);
    return new g(this.b, localCursor, true);
  }

  public g<T> e()
  {
    a();
    Cursor localCursor = this.a.n().rawQuery(this.c, this.d);
    return new g(this.b, localCursor, false);
  }

  public c<T> f()
  {
    return e().g();
  }

  public T g()
  {
    a();
    Cursor localCursor = this.a.n().rawQuery(this.c, this.d);
    return this.b.b(localCursor);
  }

  public T h()
  {
    Object localObject = g();
    if (localObject == null)
      throw new d("No entity found for query");
    return localObject;
  }

  private static final class a<T2> extends b<T2, h<T2>>
  {
    private final int e;
    private final int f;

    a(a.a.a.a<T2, ?> parama, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
    {
      super(paramString, paramArrayOfString);
      this.e = paramInt1;
      this.f = paramInt2;
    }

    protected h<T2> d()
    {
      return new h(this, this.b, this.a, (String[])this.c.clone(), this.e, this.f, null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.h
 * JD-Core Version:    0.6.0
 */