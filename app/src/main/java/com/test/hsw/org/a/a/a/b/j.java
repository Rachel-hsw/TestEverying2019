package org.a.a.a.b;

import org.a.a.a.p;

public class j<T>
  implements g<T>
{
  private static final String a = "ConstantInitializer@%d [ object = %s ]";
  private final T b;

  public j(T paramT)
  {
    this.b = paramT;
  }

  public T a()
    throws f
  {
    return b();
  }

  public final T b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof j))
      return false;
    j localj = (j)paramObject;
    return p.b(b(), localj.b());
  }

  public int hashCode()
  {
    if (b() != null)
      return b().hashCode();
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(System.identityHashCode(this));
    arrayOfObject[1] = String.valueOf(b());
    return String.format("ConstantInitializer@%d [ object = %s ]", arrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.j
 * JD-Core Version:    0.6.0
 */