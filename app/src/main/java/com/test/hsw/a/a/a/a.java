package a.a.a;

import a.a.a.e.h;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class a<T, K>
{
  protected final SQLiteDatabase a;
  protected final a.a.a.d.a b;
  protected a.a.a.c.a<K, T> c;
  protected a.a.a.c.b<T> d;
  protected a.a.a.d.e e;
  protected final c f;
  protected final int g;

  public a(a.a.a.d.a parama)
  {
    this(parama, null);
  }

  public a(a.a.a.d.a parama, c paramc)
  {
    this.b = parama;
    this.f = paramc;
    this.a = parama.a;
    this.c = parama.b();
    if ((this.c instanceof a.a.a.c.b))
      this.d = ((a.a.a.c.b)this.c);
    this.e = parama.i;
    if (parama.g != null);
    for (int i = parama.g.a; ; i = -1)
    {
      this.g = i;
      return;
    }
  }

  private long a(T paramT, SQLiteStatement paramSQLiteStatement)
  {
    if (this.a.isDbLockedByCurrentThread())
      monitorenter;
    while (true)
    {
      long l;
      try
      {
        a(paramSQLiteStatement, paramT);
        l = paramSQLiteStatement.executeInsert();
        monitorexit;
        a(paramT, l, true);
        return l;
      }
      finally
      {
        monitorexit;
      }
      this.a.beginTransaction();
      try
      {
        monitorenter;
        try
        {
          a(paramSQLiteStatement, paramT);
          l = paramSQLiteStatement.executeInsert();
          monitorexit;
          this.a.setTransactionSuccessful();
          this.a.endTransaction();
          continue;
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        this.a.endTransaction();
      }
    }
    throw localObject1;
  }

  private void a(SQLiteStatement paramSQLiteStatement, Iterable<T> paramIterable, boolean paramBoolean)
  {
    this.a.beginTransaction();
    while (true)
    {
      try
      {
        monitorenter;
        try
        {
          if (this.c == null)
            continue;
          this.c.b();
          try
          {
            Iterator localIterator = paramIterable.iterator();
            boolean bool = localIterator.hasNext();
            if (bool)
              continue;
            if (this.c == null)
              continue;
            this.c.c();
            monitorexit;
            this.a.setTransactionSuccessful();
            this.a.endTransaction();
            return;
            Object localObject4 = (Object)localIterator.next();
            a(paramSQLiteStatement, localObject4);
            if (paramBoolean)
            {
              a(localObject4, paramSQLiteStatement.executeInsert(), false);
              continue;
            }
          }
          finally
          {
            if (this.c == null)
              continue;
            this.c.c();
          }
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        this.a.endTransaction();
      }
      paramSQLiteStatement.execute();
    }
  }

  private void a(Iterable<T> paramIterable, Iterable<K> paramIterable1)
  {
    l();
    SQLiteStatement localSQLiteStatement = this.e.c();
    this.a.beginTransaction();
    while (true)
    {
      Iterator localIterator1;
      try
      {
        monitorenter;
        try
        {
          if (this.c == null)
            break label272;
          this.c.b();
          ArrayList localArrayList2 = new ArrayList();
          localArrayList1 = localArrayList2;
          if (paramIterable == null)
            continue;
          try
          {
            Iterator localIterator2 = paramIterable.iterator();
            if (localIterator2.hasNext())
              continue;
            if (paramIterable1 == null)
              continue;
            localIterator1 = paramIterable1.iterator();
            boolean bool = localIterator1.hasNext();
            if (!bool)
            {
              if (this.c == null)
                continue;
              this.c.c();
              monitorexit;
              this.a.setTransactionSuccessful();
              if ((localArrayList1 == null) || (this.c == null))
                continue;
              this.c.a(localArrayList1);
              this.a.endTransaction();
              return;
              Object localObject5 = k((Object)localIterator2.next());
              b(localObject5, localSQLiteStatement);
              if (localArrayList1 == null)
                continue;
              localArrayList1.add(localObject5);
              continue;
            }
          }
          finally
          {
            if (this.c == null)
              continue;
            this.c.c();
          }
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        this.a.endTransaction();
      }
      Object localObject4 = (Object)localIterator1.next();
      b(localObject4, localSQLiteStatement);
      if (localArrayList1 == null)
        continue;
      localArrayList1.add(localObject4);
      continue;
      label272: ArrayList localArrayList1 = null;
    }
  }

  private void b(K paramK, SQLiteStatement paramSQLiteStatement)
  {
    if ((paramK instanceof Long))
      paramSQLiteStatement.bindLong(1, ((Long)paramK).longValue());
    while (true)
    {
      paramSQLiteStatement.execute();
      return;
      if (paramK == null)
        throw new d("Cannot delete entity, key is null");
      paramSQLiteStatement.bindString(1, paramK.toString());
    }
  }

  public c a()
  {
    return this.f;
  }

  public h<T> a(String paramString, Collection<Object> paramCollection)
  {
    return h.a(this, this.e.e() + paramString, paramCollection.toArray());
  }

  public h<T> a(String paramString, Object[] paramArrayOfObject)
  {
    return a(paramString, Arrays.asList(paramArrayOfObject));
  }

  public T a(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    return a(this.a.rawQuery(this.e.h(), arrayOfString));
  }

  protected final <O> O a(a<O, ?> parama, Cursor paramCursor, int paramInt)
  {
    return parama.a(paramCursor, paramInt, true);
  }

  protected T a(Cursor paramCursor)
  {
    try
    {
      Object localObject2 = b(paramCursor);
      return localObject2;
    }
    finally
    {
      paramCursor.close();
    }
    throw localObject1;
  }

  protected abstract T a(Cursor paramCursor, int paramInt);

  protected final T a(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    Object localObject3;
    if (this.d != null)
      if (paramInt != 0)
      {
        boolean bool = paramCursor.isNull(paramInt + this.g);
        localObject3 = null;
        if (!bool);
      }
    Object localObject2;
    do
    {
      while (true)
      {
        return localObject3;
        long l = paramCursor.getLong(paramInt + this.g);
        if (paramBoolean)
          localObject3 = this.d.a(l);
        Object localObject6;
        while (true)
          if (localObject3 == null)
          {
            localObject6 = a(paramCursor, paramInt);
            j(localObject6);
            if (paramBoolean)
            {
              this.d.a(l, localObject6);
              return localObject6;
              localObject3 = this.d.b(l);
              continue;
            }
          }
          else
          {
            break;
          }
        this.d.b(l, localObject6);
        return localObject6;
        if (this.c == null)
          break;
        Object localObject4 = b(paramCursor, paramInt);
        if (paramInt != 0)
        {
          localObject3 = null;
          if (localObject4 == null)
            continue;
        }
        if (paramBoolean);
        for (localObject3 = this.c.a(localObject4); localObject3 == null; localObject3 = this.c.b(localObject4))
        {
          Object localObject5 = a(paramCursor, paramInt);
          a(localObject4, localObject5, paramBoolean);
          return localObject5;
        }
      }
      if (paramInt == 0)
        break;
      localObject2 = b(paramCursor, paramInt);
      localObject3 = null;
    }
    while (localObject2 == null);
    Object localObject1 = a(paramCursor, paramInt);
    j(localObject1);
    return localObject1;
  }

  public T a(K paramK)
  {
    l();
    Object localObject;
    if (paramK == null)
      localObject = null;
    do
    {
      return localObject;
      if (this.c == null)
        break;
      localObject = this.c.a(paramK);
    }
    while (localObject != null);
    String str = this.e.g();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramK.toString();
    return a(this.a.rawQuery(str, arrayOfString));
  }

  protected abstract K a(T paramT, long paramLong);

  public List<T> a(String paramString, String[] paramArrayOfString)
  {
    return c(this.a.rawQuery(this.e.e() + paramString, paramArrayOfString));
  }

  protected abstract void a(Cursor paramCursor, T paramT, int paramInt);

  protected abstract void a(SQLiteStatement paramSQLiteStatement, T paramT);

  public void a(Iterable<T> paramIterable)
  {
    a(paramIterable, o());
  }

  public void a(Iterable<T> paramIterable, boolean paramBoolean)
  {
    a(this.e.a(), paramIterable, paramBoolean);
  }

  protected void a(T paramT, long paramLong, boolean paramBoolean)
  {
    if (paramLong != -1L)
    {
      a(a(paramT, paramLong), paramT, paramBoolean);
      return;
    }
    e.d("Could not insert row (executeInsert returned -1)");
  }

  protected void a(T paramT, SQLiteStatement paramSQLiteStatement, boolean paramBoolean)
  {
    a(paramSQLiteStatement, paramT);
    int i = 1 + this.b.d.length;
    Object localObject = l(paramT);
    if ((localObject instanceof Long))
      paramSQLiteStatement.bindLong(i, ((Long)localObject).longValue());
    while (true)
    {
      paramSQLiteStatement.execute();
      a(localObject, paramT, paramBoolean);
      return;
      if (localObject == null)
        throw new d("Cannot update entity without key - was it inserted before?");
      paramSQLiteStatement.bindString(i, localObject.toString());
    }
  }

  protected final void a(K paramK, T paramT, boolean paramBoolean)
  {
    j(paramT);
    if ((this.c != null) && (paramK != null))
    {
      if (paramBoolean)
        this.c.a(paramK, paramT);
    }
    else
      return;
    this.c.b(paramK, paramT);
  }

  public void a(T[] paramArrayOfT)
  {
    a(Arrays.asList(paramArrayOfT), o());
  }

  a.a.a.d.e b()
  {
    return this.b.i;
  }

  protected T b(Cursor paramCursor)
  {
    if (!paramCursor.moveToFirst())
      return null;
    if (!paramCursor.isLast())
      throw new d("Expected unique result, but count was " + paramCursor.getCount());
    return a(paramCursor, 0, true);
  }

  protected abstract K b(Cursor paramCursor, int paramInt);

  public void b(Iterable<T> paramIterable)
  {
    b(paramIterable, o());
  }

  public void b(Iterable<T> paramIterable, boolean paramBoolean)
  {
    a(this.e.b(), paramIterable, paramBoolean);
  }

  public void b(T[] paramArrayOfT)
  {
    b(Arrays.asList(paramArrayOfT), o());
  }

  public boolean b(T paramT)
  {
    if (this.c != null)
    {
      Object localObject = k(paramT);
      return this.c.c(localObject, paramT);
    }
    return false;
  }

  public long c(T paramT)
  {
    return a(paramT, this.e.a());
  }

  public String c()
  {
    return this.b.b;
  }

  protected List<T> c(Cursor paramCursor)
  {
    try
    {
      List localList = d(paramCursor);
      return localList;
    }
    finally
    {
      paramCursor.close();
    }
    throw localObject;
  }

  public void c(Iterable<T> paramIterable)
  {
    a(paramIterable, null);
  }

  public void c(T[] paramArrayOfT)
  {
    a(Arrays.asList(paramArrayOfT), null);
  }

  public long d(T paramT)
  {
    SQLiteStatement localSQLiteStatement = this.e.a();
    if (this.a.isDbLockedByCurrentThread())
    {
      monitorenter;
      try
      {
        a(localSQLiteStatement, paramT);
        long l2 = localSQLiteStatement.executeInsert();
        return l2;
      }
      finally
      {
        monitorexit;
      }
    }
    this.a.beginTransaction();
    try
    {
      monitorenter;
      try
      {
        a(localSQLiteStatement, paramT);
        long l1 = localSQLiteStatement.executeInsert();
        monitorexit;
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
        return l1;
      }
      finally
      {
        monitorexit;
      }
    }
    finally
    {
      this.a.endTransaction();
    }
    throw localObject1;
  }

  protected List<T> d(Cursor paramCursor)
  {
    int i = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    CursorWindow localCursorWindow;
    if ((paramCursor instanceof CrossProcessCursor))
    {
      localCursorWindow = ((CrossProcessCursor)paramCursor).getWindow();
      if (localCursorWindow != null)
      {
        if (localCursorWindow.getNumRows() != i)
          break label138;
        paramCursor = new a.a.a.d.b(localCursorWindow);
      }
    }
    while (true)
    {
      if (paramCursor.moveToFirst())
        if (this.c != null)
        {
          this.c.b();
          this.c.a(i);
        }
      try
      {
        boolean bool;
        do
        {
          localArrayList.add(a(paramCursor, 0, false));
          bool = paramCursor.moveToNext();
        }
        while (bool);
        return localArrayList;
        label138: e.b("Window vs. result size: " + localCursorWindow.getNumRows() + "/" + i);
      }
      finally
      {
        if (this.c != null)
          this.c.c();
      }
    }
  }

  public void d(Iterable<K> paramIterable)
  {
    a(null, paramIterable);
  }

  public void d(K[] paramArrayOfK)
  {
    a(null, Arrays.asList(paramArrayOfK));
  }

  public i[] d()
  {
    return this.b.c;
  }

  public long e(T paramT)
  {
    return a(paramT, this.e.b());
  }

  public i e()
  {
    return this.b.g;
  }

  // ERROR //
  public void e(Iterable<T> paramIterable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	a/a/a/a:e	La/a/a/d/e;
    //   4: invokevirtual 377	a/a/a/d/e:d	()Landroid/database/sqlite/SQLiteStatement;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 38	a/a/a/a:a	Landroid/database/sqlite/SQLiteDatabase;
    //   12: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   15: aload_2
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   21: ifnull +12 -> 33
    //   24: aload_0
    //   25: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   28: invokeinterface 94 1 0
    //   33: aload_1
    //   34: invokeinterface 100 1 0
    //   39: astore 11
    //   41: aload 11
    //   43: invokeinterface 105 1 0
    //   48: istore 12
    //   50: iload 12
    //   52: ifne +36 -> 88
    //   55: aload_0
    //   56: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   66: invokeinterface 107 1 0
    //   71: aload_2
    //   72: monitorexit
    //   73: aload_0
    //   74: getfield 38	a/a/a/a:a	Landroid/database/sqlite/SQLiteDatabase;
    //   77: invokevirtual 86	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   80: aload_0
    //   81: getfield 38	a/a/a/a:a	Landroid/database/sqlite/SQLiteDatabase;
    //   84: invokevirtual 89	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: return
    //   88: aload_0
    //   89: aload 11
    //   91: invokeinterface 111 1 0
    //   96: checkcast 5	java/lang/Object
    //   99: aload_2
    //   100: iconst_0
    //   101: invokevirtual 379	a/a/a/a:a	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   104: goto -63 -> 41
    //   107: astore 10
    //   109: aload_0
    //   110: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   113: ifnull +12 -> 125
    //   116: aload_0
    //   117: getfield 43	a/a/a/a:c	La/a/a/c/a;
    //   120: invokeinterface 107 1 0
    //   125: aload 10
    //   127: athrow
    //   128: astore 9
    //   130: aload_2
    //   131: monitorexit
    //   132: aload 9
    //   134: athrow
    //   135: astore 6
    //   137: aload_0
    //   138: getfield 38	a/a/a/a:a	Landroid/database/sqlite/SQLiteDatabase;
    //   141: invokevirtual 89	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   144: return
    //   145: astore 7
    //   147: aload 6
    //   149: ifnull +15 -> 164
    //   152: ldc_w 381
    //   155: aload 7
    //   157: invokestatic 384	a/a/a/e:d	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   160: pop
    //   161: aload 6
    //   163: athrow
    //   164: aload 7
    //   166: athrow
    //   167: astore_3
    //   168: aload_0
    //   169: getfield 38	a/a/a/a:a	Landroid/database/sqlite/SQLiteDatabase;
    //   172: invokevirtual 89	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   175: aload_3
    //   176: athrow
    //   177: astore 4
    //   179: iconst_0
    //   180: ifeq +14 -> 194
    //   183: ldc_w 381
    //   186: aload 4
    //   188: invokestatic 384	a/a/a/e:d	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   191: pop
    //   192: aconst_null
    //   193: athrow
    //   194: aload 4
    //   196: athrow
    //   197: astore 13
    //   199: iconst_0
    //   200: ifeq +14 -> 214
    //   203: ldc_w 381
    //   206: aload 13
    //   208: invokestatic 384	a/a/a/e:d	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: aconst_null
    //   213: athrow
    //   214: aload 13
    //   216: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   33	41	107	finally
    //   41	50	107	finally
    //   88	104	107	finally
    //   17	33	128	finally
    //   55	71	128	finally
    //   71	73	128	finally
    //   109	125	128	finally
    //   125	128	128	finally
    //   130	132	128	finally
    //   15	17	135	java/lang/RuntimeException
    //   73	80	135	java/lang/RuntimeException
    //   132	135	135	java/lang/RuntimeException
    //   137	144	145	java/lang/RuntimeException
    //   15	17	167	finally
    //   73	80	167	finally
    //   132	135	167	finally
    //   168	175	177	java/lang/RuntimeException
    //   80	87	197	java/lang/RuntimeException
  }

  public void e(T[] paramArrayOfT)
  {
    e(Arrays.asList(paramArrayOfT));
  }

  public void f(T paramT)
  {
    l();
    g(k(paramT));
  }

  public String[] f()
  {
    return this.b.d;
  }

  public void g(K paramK)
  {
    l();
    SQLiteStatement localSQLiteStatement = this.e.c();
    if (this.a.isDbLockedByCurrentThread())
      monitorenter;
    while (true)
    {
      try
      {
        b(paramK, localSQLiteStatement);
        monitorexit;
        if (this.c == null)
          continue;
        this.c.c(paramK);
        return;
      }
      finally
      {
        monitorexit;
      }
      this.a.beginTransaction();
      try
      {
        monitorenter;
        try
        {
          b(paramK, localSQLiteStatement);
          monitorexit;
          this.a.setTransactionSuccessful();
          this.a.endTransaction();
          continue;
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        this.a.endTransaction();
      }
    }
    throw localObject1;
  }

  public String[] g()
  {
    return this.b.e;
  }

  public void h(T paramT)
  {
    l();
    Object localObject1 = k(paramT);
    String str = this.e.g();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject1.toString();
    Cursor localCursor = this.a.rawQuery(str, arrayOfString);
    try
    {
      if (!localCursor.moveToFirst())
        throw new d("Entity does not exist in the database anymore: " + paramT.getClass() + " with key " + localObject1);
    }
    finally
    {
      localCursor.close();
    }
    if (!localCursor.isLast())
      throw new d("Expected unique result, but count was " + localCursor.getCount());
    a(localCursor, paramT, 0);
    a(localObject1, paramT, true);
    localCursor.close();
  }

  public String[] h()
  {
    return this.b.f;
  }

  public List<T> i()
  {
    return c(this.a.rawQuery(this.e.e(), null));
  }

  public void i(T paramT)
  {
    l();
    SQLiteStatement localSQLiteStatement = this.e.d();
    if (this.a.isDbLockedByCurrentThread())
    {
      monitorenter;
      try
      {
        a(paramT, localSQLiteStatement, true);
        return;
      }
      finally
      {
        monitorexit;
      }
    }
    this.a.beginTransaction();
    try
    {
      monitorenter;
      try
      {
        a(paramT, localSQLiteStatement, true);
        monitorexit;
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
        return;
      }
      finally
      {
        monitorexit;
      }
    }
    finally
    {
      this.a.endTransaction();
    }
    throw localObject1;
  }

  public void j()
  {
    this.a.execSQL("DELETE FROM '" + this.b.b + "'");
    if (this.c != null)
      this.c.a();
  }

  protected void j(T paramT)
  {
  }

  public a.a.a.e.i<T> k()
  {
    return a.a.a.e.i.a(this);
  }

  protected K k(T paramT)
  {
    Object localObject = l(paramT);
    if (localObject == null)
    {
      if (paramT == null)
        throw new NullPointerException("Entity may not be null");
      throw new d("Entity has no key");
    }
    return localObject;
  }

  protected abstract K l(T paramT);

  protected void l()
  {
    if (this.b.e.length != 1)
      throw new d(this + " (" + this.b.b + ") does not have a single-column primary key");
  }

  public long m()
  {
    return DatabaseUtils.queryNumEntries(this.a, '\'' + this.b.b + '\'');
  }

  public SQLiteDatabase n()
  {
    return this.a;
  }

  protected abstract boolean o();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.a
 * JD-Core Version:    0.6.0
 */