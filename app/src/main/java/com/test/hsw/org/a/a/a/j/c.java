package org.a.a.a.j;

import java.io.Serializable;
import java.util.Map.Entry;
import org.a.a.a.a.b;
import org.a.a.a.p;

public abstract class c<L, R>
  implements Serializable, Comparable<c<L, R>>, Map.Entry<L, R>
{
  private static final long a = 4954918890077093841L;

  public static <L, R> c<L, R> b(L paramL, R paramR)
  {
    return new a(paramL, paramR);
  }

  public int a(c<L, R> paramc)
  {
    return new b().b(a(), paramc.a()).b(b(), paramc.b()).b();
  }

  public abstract L a();

  public String a(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    return String.format(paramString, arrayOfObject);
  }

  public abstract R b();

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof Map.Entry))
        break;
      Map.Entry localEntry = (Map.Entry)paramObject;
      if ((!p.b(getKey(), localEntry.getKey())) || (!p.b(getValue(), localEntry.getValue())))
        return false;
    }
    return false;
  }

  public final L getKey()
  {
    return a();
  }

  public R getValue()
  {
    return b();
  }

  public int hashCode()
  {
    int i;
    int j;
    if (getKey() == null)
    {
      i = 0;
      Object localObject = getValue();
      j = 0;
      if (localObject != null)
        break label35;
    }
    while (true)
    {
      return i ^ j;
      i = getKey().hashCode();
      break;
      label35: j = getValue().hashCode();
    }
  }

  public String toString()
  {
    return '(' + a() + ',' + b() + ')';
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.j.c
 * JD-Core Version:    0.6.0
 */