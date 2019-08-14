package a.a.a;

import a.a.a.d.d;
import a.a.a.e.k;
import a.a.a.e.k.b;
import java.util.Collection;

public class i
{
  public final int a;
  public final Class<?> b;
  public final String c;
  public final boolean d;
  public final String e;

  public i(int paramInt, Class<?> paramClass, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a = paramInt;
    this.b = paramClass;
    this.c = paramString1;
    this.d = paramBoolean;
    this.e = paramString2;
  }

  public k a()
  {
    return new k.b(this, " IS NULL");
  }

  public k a(Object paramObject)
  {
    return new k.b(this, "=?", paramObject);
  }

  public k a(Object paramObject1, Object paramObject2)
  {
    return new k.b(this, " BETWEEN ? AND ?", new Object[] { paramObject1, paramObject2 });
  }

  public k a(String paramString)
  {
    return new k.b(this, " LIKE ?", paramString);
  }

  public k a(Collection<?> paramCollection)
  {
    return a(paramCollection.toArray());
  }

  public k a(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(" IN (");
    d.a(localStringBuilder, paramArrayOfObject.length).append(')');
    return new k.b(this, localStringBuilder.toString(), paramArrayOfObject);
  }

  public k b()
  {
    return new k.b(this, " IS NOT NULL");
  }

  public k b(Object paramObject)
  {
    return new k.b(this, "<>?", paramObject);
  }

  public k b(Collection<?> paramCollection)
  {
    return b(paramCollection.toArray());
  }

  public k b(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(" NOT IN (");
    d.a(localStringBuilder, paramArrayOfObject.length).append(')');
    return new k.b(this, localStringBuilder.toString(), paramArrayOfObject);
  }

  public k c(Object paramObject)
  {
    return new k.b(this, ">?", paramObject);
  }

  public k d(Object paramObject)
  {
    return new k.b(this, "<?", paramObject);
  }

  public k e(Object paramObject)
  {
    return new k.b(this, ">=?", paramObject);
  }

  public k f(Object paramObject)
  {
    return new k.b(this, "<=?", paramObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.i
 * JD-Core Version:    0.6.0
 */