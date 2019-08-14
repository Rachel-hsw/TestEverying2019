package com.squareup.a.a.b;

import b.j;

public final class d
{
  public static final j a = j.a(":status");
  public static final j b = j.a(":method");
  public static final j c = j.a(":path");
  public static final j d = j.a(":scheme");
  public static final j e = j.a(":authority");
  public static final j f = j.a(":host");
  public static final j g = j.a(":version");
  public final j h;
  public final j i;
  final int j;

  public d(j paramj1, j paramj2)
  {
    this.h = paramj1;
    this.i = paramj2;
    this.j = (32 + paramj1.f() + paramj2.f());
  }

  public d(j paramj, String paramString)
  {
    this(paramj, j.a(paramString));
  }

  public d(String paramString1, String paramString2)
  {
    this(j.a(paramString1), j.a(paramString2));
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    int k = 0;
    if (bool1)
    {
      d locald = (d)paramObject;
      boolean bool2 = this.h.equals(locald.h);
      k = 0;
      if (bool2)
      {
        boolean bool3 = this.i.equals(locald.i);
        k = 0;
        if (bool3)
          k = 1;
      }
    }
    return k;
  }

  public int hashCode()
  {
    return 31 * (527 + this.h.hashCode()) + this.i.hashCode();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.h.a();
    arrayOfObject[1] = this.i.a();
    return String.format("%s: %s", arrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.d
 * JD-Core Version:    0.6.0
 */