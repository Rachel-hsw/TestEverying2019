package a.a.a.f;

import a.a.a.a;
import a.a.a.h;
import a.a.a.i;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class d<D extends a<T, K>, T, K> extends b<D, T, K>
{
  protected Set<K> f = new HashSet();
  private i k;

  public d(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected Cursor a(int paramInt, String paramString, K paramK)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    int j = 0;
    while (true)
    {
      Cursor localCursor;
      if (j >= paramInt)
      {
        a.a.a.d.d.a(localStringBuilder, "T", this.b.f()).append(" FROM ");
        localStringBuilder.append('"').append(this.b.c()).append('"').append(" T");
        if (paramK != null)
        {
          localStringBuilder.append(" WHERE ");
          assertEquals(1, this.b.g().length);
          localStringBuilder.append(this.b.g()[0]).append("=");
          DatabaseUtils.appendValueToSql(localStringBuilder, paramK);
        }
        String str = localStringBuilder.toString();
        localCursor = this.j.rawQuery(str, null);
        assertTrue(localCursor.moveToFirst());
        if ((i >= paramInt) && (paramK == null));
      }
      try
      {
        assertEquals(1, localCursor.getCount());
        return localCursor;
        localStringBuilder.append(paramString).append(",");
        j++;
        continue;
        assertEquals(paramString, localCursor.getString(i));
        i++;
      }
      catch (RuntimeException localRuntimeException)
      {
        localCursor.close();
      }
    }
    throw localRuntimeException;
  }

  protected abstract T a(K paramK);

  protected void a(int paramInt)
  {
    Object localObject1 = x();
    Object localObject2 = a(localObject1);
    this.b.c(localObject2);
    Cursor localCursor = a(paramInt, "42", localObject1);
    try
    {
      assertEquals(localObject1, this.c.b(localCursor, paramInt));
      return;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject3;
  }

  protected abstract K f();

  public void g()
  {
    Object localObject1 = x();
    Object localObject2 = a(localObject1);
    this.b.c(localObject2);
    assertEquals(localObject1, this.c.a(localObject2));
    Object localObject3 = this.b.a(localObject1);
    assertNotNull(localObject3);
    assertEquals(this.c.a(localObject2), this.c.a(localObject3));
  }

  public void h()
  {
    this.b.j();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= 20)
      {
        this.b.a(localArrayList);
        assertEquals(localArrayList.size(), this.b.m());
        return;
      }
      localArrayList.add(y());
    }
  }

  public void i()
  {
    this.b.j();
    assertEquals(0L, this.b.m());
    this.b.c(y());
    assertEquals(1L, this.b.m());
    this.b.c(y());
    assertEquals(2L, this.b.m());
  }

  public void j()
  {
    Object localObject = a(x());
    this.b.c(localObject);
    try
    {
      this.b.c(localObject);
      fail("Inserting twice should not work");
      return;
    }
    catch (SQLException localSQLException)
    {
    }
  }

  public void k()
  {
    Object localObject = y();
    long l1 = this.b.c(localObject);
    long l2 = this.b.e(localObject);
    if (this.b.e().b == Long.class)
      assertEquals(l1, l2);
  }

  public void l()
  {
    this.b.j();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= 20)
      {
        this.b.b(localArrayList1);
        this.b.b(localArrayList2);
        assertEquals(localArrayList2.size(), this.b.m());
        return;
      }
      Object localObject = y();
      if (i % 2 == 0)
        localArrayList1.add(localObject);
      localArrayList2.add(localObject);
    }
  }

  public void m()
  {
    Object localObject1 = x();
    this.b.g(localObject1);
    Object localObject2 = a(localObject1);
    this.b.c(localObject2);
    assertNotNull(this.b.a(localObject1));
    this.b.g(localObject1);
    assertNull(this.b.a(localObject1));
  }

  public void n()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Iterator localIterator;
    if (i >= 10)
    {
      this.b.a(localArrayList);
      this.b.j();
      assertEquals(0L, this.b.m());
      localIterator = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return;
        localArrayList.add(y());
        i++;
        break;
      }
      Object localObject1 = (Object)localIterator.next();
      Object localObject2 = this.c.a(localObject1);
      assertNotNull(localObject2);
      assertNull(this.b.a(localObject2));
    }
  }

  public void o()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Iterator localIterator;
    if (i >= 10)
    {
      this.b.a(localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(localArrayList1.get(0));
      localArrayList2.add(localArrayList1.get(3));
      localArrayList2.add(localArrayList1.get(4));
      localArrayList2.add(localArrayList1.get(8));
      this.b.c(localArrayList2);
      assertEquals(localArrayList1.size() - localArrayList2.size(), this.b.m());
      localIterator = localArrayList2.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return;
        localArrayList1.add(y());
        i++;
        break;
      }
      Object localObject1 = (Object)localIterator.next();
      Object localObject2 = this.c.a(localObject1);
      assertNotNull(localObject2);
      assertNull(this.b.a(localObject2));
    }
  }

  public void p()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Iterator localIterator;
    if (i >= 10)
    {
      this.b.a(localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(this.c.a(localArrayList1.get(0)));
      localArrayList2.add(this.c.a(localArrayList1.get(3)));
      localArrayList2.add(this.c.a(localArrayList1.get(4)));
      localArrayList2.add(this.c.a(localArrayList1.get(8)));
      this.b.d(localArrayList2);
      assertEquals(localArrayList1.size() - localArrayList2.size(), this.b.m());
      localIterator = localArrayList2.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return;
        localArrayList1.add(y());
        i++;
        break;
      }
      Object localObject = (Object)localIterator.next();
      assertNotNull(localObject);
      assertNull(this.b.a(localObject));
    }
  }

  public void q()
  {
    Object localObject1 = y();
    Object localObject2 = y();
    if (this.b.c(localObject1) != this.b.c(localObject2));
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(bool);
      return;
    }
  }

  public void r()
  {
    this.b.j();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= 15)
      {
        this.b.a(localArrayList);
        List localList = this.b.i();
        assertEquals(localArrayList.size(), localList.size());
        return;
      }
      localArrayList.add(a(x()));
    }
  }

  public void s()
  {
    this.b.c(y());
    Object localObject = x();
    this.b.c(a(localObject));
    this.b.c(y());
    String str = "WHERE " + this.b.g()[0] + "=?";
    a locala = this.b;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject.toString();
    List localList = locala.a(str, arrayOfString);
    assertEquals(1, localList.size());
    assertEquals(localObject, this.c.a(localList.get(0)));
  }

  protected void setUp()
    throws Exception
  {
    super.setUp();
    i[] arrayOfi = this.c.a();
    int i = arrayOfi.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        if (this.k != null)
          break;
        throw new RuntimeException("Test does not work without a PK column");
      }
      i locali = arrayOfi[j];
      if (!locali.d)
        continue;
      if (this.k != null)
        throw new RuntimeException("Test does not work with multiple PK columns");
      this.k = locali;
    }
  }

  public void t()
  {
    this.b.j();
    Object localObject = y();
    this.b.c(localObject);
    this.b.i(localObject);
    assertEquals(1L, this.b.m());
  }

  public void u()
  {
    Object localObject1 = x();
    Object localObject2 = a(localObject1);
    this.b.c(localObject2);
    Cursor localCursor = a(5, "42", localObject1);
    try
    {
      Object localObject4 = this.c.a(localCursor, 5);
      assertEquals(localObject1, this.c.a(localObject4));
      return;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject3;
  }

  public void v()
  {
    a(10);
  }

  public void w()
  {
    a(0);
  }

  protected K x()
  {
    for (int i = 0; ; i++)
    {
      if (i >= 100000)
        throw new IllegalStateException("Could not find a new PK");
      Object localObject = f();
      if (this.f.add(localObject))
        return localObject;
    }
  }

  protected T y()
  {
    return a(x());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.d
 * JD-Core Version:    0.6.0
 */