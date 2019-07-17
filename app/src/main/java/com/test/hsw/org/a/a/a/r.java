package org.a.a.a;

import java.io.Serializable;
import java.util.Comparator;

public final class r<T>
  implements Serializable
{
  private static final long a = 1L;
  private final Comparator<T> b;
  private final T c;
  private final T d;
  private transient int e;
  private transient String f;

  private r(T paramT1, T paramT2, Comparator<T> paramComparator)
  {
    if ((paramT1 == null) || (paramT2 == null))
      throw new IllegalArgumentException("Elements in a range must not be null: element1=" + paramT1 + ", element2=" + paramT2);
    if (paramComparator == null)
      paramComparator = a.a;
    if (paramComparator.compare(paramT1, paramT2) < 1)
      this.c = paramT1;
    for (this.d = paramT2; ; this.d = paramT1)
    {
      this.b = paramComparator;
      return;
      this.c = paramT2;
    }
  }

  public static <T extends Comparable<T>> r<T> a(T paramT)
  {
    return a(paramT, paramT, null);
  }

  public static <T extends Comparable<T>> r<T> a(T paramT1, T paramT2)
  {
    return a(paramT1, paramT2, null);
  }

  public static <T> r<T> a(T paramT1, T paramT2, Comparator<T> paramComparator)
  {
    return new r(paramT1, paramT2, paramComparator);
  }

  public static <T> r<T> a(T paramT, Comparator<T> paramComparator)
  {
    return a(paramT, paramT, paramComparator);
  }

  public T a()
  {
    return this.c;
  }

  public String a(String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.d;
    arrayOfObject[2] = this.b;
    return String.format(paramString, arrayOfObject);
  }

  public boolean a(T paramT)
  {
    int i = 1;
    if (paramT == null)
      return false;
    if ((this.b.compare(paramT, this.c) > -1) && (this.b.compare(paramT, this.d) < i));
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public boolean a(r<T> paramr)
  {
    if (paramr == null);
    do
      return false;
    while ((!a(paramr.c)) || (!a(paramr.d)));
    return true;
  }

  public T b()
  {
    return this.d;
  }

  public boolean b(T paramT)
  {
    if (paramT == null);
    do
      return false;
    while (this.b.compare(paramT, this.c) >= 0);
    return true;
  }

  public boolean b(r<T> paramr)
  {
    if (paramr == null)
      return false;
    return b(paramr.d);
  }

  public Comparator<T> c()
  {
    return this.b;
  }

  public boolean c(T paramT)
  {
    if (paramT == null);
    do
      return false;
    while (this.b.compare(paramT, this.c) != 0);
    return true;
  }

  public boolean c(r<T> paramr)
  {
    if (paramr == null);
    do
      return false;
    while ((!paramr.a(this.c)) && (!paramr.a(this.d)) && (!a(paramr.c)));
    return true;
  }

  public boolean d()
  {
    return this.b == a.a;
  }

  public boolean d(T paramT)
  {
    if (paramT == null);
    do
      return false;
    while (this.b.compare(paramT, this.d) != 0);
    return true;
  }

  public boolean d(r<T> paramr)
  {
    if (paramr == null)
      return false;
    return e(paramr.c);
  }

  public r<T> e(r<T> paramr)
  {
    if (!c(paramr))
      throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[] { paramr }));
    if (equals(paramr))
      return this;
    Object localObject1;
    if (c().compare(this.c, paramr.c) < 0)
    {
      localObject1 = paramr.c;
      if (c().compare(this.d, paramr.d) >= 0)
        break label107;
    }
    label107: for (Object localObject2 = this.d; ; localObject2 = paramr.d)
    {
      return a(localObject1, localObject2, c());
      localObject1 = this.c;
      break;
    }
  }

  public boolean e(T paramT)
  {
    if (paramT == null);
    do
      return false;
    while (this.b.compare(paramT, this.d) <= 0);
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    r localr;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localr = (r)paramObject;
    }
    while ((this.c.equals(localr.c)) && (this.d.equals(localr.d)));
    return false;
  }

  public int f(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException("Element is null");
    if (b(paramT))
      return -1;
    if (e(paramT))
      return 1;
    return 0;
  }

  public int hashCode()
  {
    int i = this.e;
    if (this.e == 0)
    {
      i = 37 * (37 * (629 + getClass().hashCode()) + this.c.hashCode()) + this.d.hashCode();
      this.e = i;
    }
    return i;
  }

  public String toString()
  {
    String str = this.f;
    if (str == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append('[');
      localStringBuilder.append(this.c);
      localStringBuilder.append("..");
      localStringBuilder.append(this.d);
      localStringBuilder.append(']');
      str = localStringBuilder.toString();
      this.f = str;
    }
    return str;
  }

  private static enum a
    implements Comparator
  {
    static
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = a;
      b = arrayOfa;
    }

    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.r
 * JD-Core Version:    0.6.0
 */