package a.a.a.d;

import a.a.a.c.b;
import a.a.a.c.c;
import a.a.a.i;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Cloneable
{
  public final SQLiteDatabase a;
  public final String b;
  public final i[] c;
  public final String[] d;
  public final String[] e;
  public final String[] f;
  public final i g;
  public final boolean h;
  public final e i;
  private a.a.a.c.a<?, ?> j;

  public a(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f;
    this.g = parama.g;
    this.i = parama.i;
    this.h = parama.h;
  }

  public a(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>> paramClass)
  {
    this.a = paramSQLiteDatabase;
    while (true)
    {
      int k;
      Object localObject2;
      try
      {
        this.b = ((String)paramClass.getField("TABLENAME").get(null));
        i[] arrayOfi = a(paramClass);
        this.c = arrayOfi;
        this.d = new String[arrayOfi.length];
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        k = 0;
        localObject1 = null;
        if (k < arrayOfi.length)
          continue;
        this.f = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
        this.e = ((String[])localArrayList1.toArray(new String[localArrayList1.size()]));
        if (this.e.length != 1)
          break label366;
        this.g = localObject1;
        this.i = new e(paramSQLiteDatabase, this.b, this.d, this.e);
        if (this.g == null)
          continue;
        Class localClass = this.g.b;
        if ((localClass.equals(Long.TYPE)) || (localClass.equals(Long.class)) || (localClass.equals(Integer.TYPE)) || (localClass.equals(Integer.class)) || (localClass.equals(Short.TYPE)) || (localClass.equals(Short.class)) || (localClass.equals(Byte.TYPE)) || (localClass.equals(Byte.class)))
          break label372;
        bool = false;
        this.h = bool;
        return;
        localObject2 = arrayOfi[k];
        String str = ((i)localObject2).e;
        this.d[k] = str;
        if (!((i)localObject2).d)
          continue;
        localArrayList1.add(str);
        break label356;
        localArrayList2.add(str);
        localObject2 = localObject1;
        break label356;
        this.h = false;
        return;
      }
      catch (Exception localException)
      {
        throw new a.a.a.d("Could not init DAOConfig", localException);
      }
      label356: k++;
      Object localObject1 = localObject2;
      continue;
      label366: localObject1 = null;
      continue;
      label372: boolean bool = true;
    }
  }

  private static i[] a(Class<? extends a.a.a.a<?, ?>> paramClass)
    throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException
  {
    Field[] arrayOfField = Class.forName(paramClass.getName() + "$Properties").getDeclaredFields();
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfField.length;
    int m = 0;
    i[] arrayOfi;
    Iterator localIterator;
    if (m >= k)
    {
      arrayOfi = new i[localArrayList.size()];
      localIterator = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return arrayOfi;
        Field localField = arrayOfField[m];
        if ((0x9 & localField.getModifiers()) == 9)
        {
          Object localObject = localField.get(null);
          if ((localObject instanceof i))
            localArrayList.add((i)localObject);
        }
        m++;
        break;
      }
      i locali = (i)localIterator.next();
      if (arrayOfi[locali.a] != null)
        throw new a.a.a.d("Duplicate property ordinals");
      arrayOfi[locali.a] = locali;
    }
  }

  public a a()
  {
    return new a(this);
  }

  public void a(a.a.a.c.a<?, ?> parama)
  {
    this.j = parama;
  }

  public void a(a.a.a.c.d paramd)
  {
    if (paramd == a.a.a.c.d.b)
    {
      this.j = null;
      return;
    }
    if (paramd == a.a.a.c.d.a)
    {
      if (this.h)
      {
        this.j = new b();
        return;
      }
      this.j = new c();
      return;
    }
    throw new IllegalArgumentException("Unsupported type: " + paramd);
  }

  public a.a.a.c.a<?, ?> b()
  {
    return this.j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d.a
 * JD-Core Version:    0.6.0
 */