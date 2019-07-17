package org.a.a.a.f;

import java.io.Serializable;

public class h<T>
  implements Serializable, a<T>
{
  private static final long a = 86241875189L;
  private T b;

  public h()
  {
  }

  public h(T paramT)
  {
    this.b = paramT;
  }

  public T a()
  {
    return this.b;
  }

  public void a(T paramT)
  {
    this.b = paramT;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      return false;
      if (this == paramObject)
        return true;
    }
    while (getClass() != paramObject.getClass());
    h localh = (h)paramObject;
    return this.b.equals(localh.b);
  }

  public int hashCode()
  {
    if (this.b == null)
      return 0;
    return this.b.hashCode();
  }

  public String toString()
  {
    if (this.b == null)
      return "null";
    return this.b.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.h
 * JD-Core Version:    0.6.0
 */