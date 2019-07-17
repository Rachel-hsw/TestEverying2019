package com.xiaomi.b.a.a.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.a.c.b.f;
import org.a.c.b.g;
import org.a.c.b.i;
import org.a.c.b.k;

public class h
  implements Serializable, Cloneable, org.a.c.b<h, a>
{
  public static final Map<a, org.a.c.a.b> a;
  private static final k b = new k("PassportLandNodeInfo");
  private static final org.a.c.b.c c = new org.a.c.b.c("ip", 8, 1);
  private static final org.a.c.b.c d = new org.a.c.b.c("eid", 8, 2);
  private static final org.a.c.b.c e = new org.a.c.b.c("rt", 8, 3);
  private int f;
  private int g;
  private int h;
  private BitSet i = new BitSet(3);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("ip", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.b, new org.a.c.a.b("eid", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.c, new org.a.c.a.b("rt", 1, new org.a.c.a.c(8)));
    a = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(h.class, a);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!a())
        throw new g("Required field 'ip' was not found in serialized data! Struct: " + toString());
    }
    else
    {
      switch (localc.c)
      {
      default:
        i.a(paramf, localc.b);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        paramf.j();
        break;
        if (localc.b == 8)
        {
          this.f = paramf.t();
          a(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.g = paramf.t();
          b(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.h = paramf.t();
          c(true);
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    if (!b())
      throw new g("Required field 'eid' was not found in serialized data! Struct: " + toString());
    if (!c())
      throw new g("Required field 'rt' was not found in serialized data! Struct: " + toString());
    d();
  }

  public void a(boolean paramBoolean)
  {
    this.i.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.i.get(0);
  }

  public boolean a(h paramh)
  {
    if (paramh == null);
    do
      return false;
    while ((this.f != paramh.f) || (this.g != paramh.g) || (this.h != paramh.h));
    return true;
  }

  public int b(h paramh)
  {
    int j;
    if (!getClass().equals(paramh.getClass()))
      j = getClass().getName().compareTo(paramh.getClass().getName());
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return j;
                j = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramh.a()));
              }
              while (j != 0);
              if (!a())
                break;
              j = org.a.c.c.a(this.f, paramh.f);
            }
            while (j != 0);
            j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramh.b()));
          }
          while (j != 0);
          if (!b())
            break;
          j = org.a.c.c.a(this.g, paramh.g);
        }
        while (j != 0);
        j = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramh.c()));
      }
      while (j != 0);
      if (!c())
        break;
      j = org.a.c.c.a(this.h, paramh.h);
    }
    while (j != 0);
    return 0;
  }

  public void b(f paramf)
  {
    d();
    paramf.a(b);
    paramf.a(c);
    paramf.a(this.f);
    paramf.b();
    paramf.a(d);
    paramf.a(this.g);
    paramf.b();
    paramf.a(e);
    paramf.a(this.h);
    paramf.b();
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.i.set(1, paramBoolean);
  }

  public boolean b()
  {
    return this.i.get(1);
  }

  public void c(boolean paramBoolean)
  {
    this.i.set(2, paramBoolean);
  }

  public boolean c()
  {
    return this.i.get(2);
  }

  public void d()
  {
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof h));
    return a((h)paramObject);
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PassportLandNodeInfo(");
    localStringBuilder.append("ip:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("eid:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append("rt:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public static enum a
  {
    private static final Map<String, a> d;
    private final short e;
    private final String f;

    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      g = arrayOfa;
      d = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        d.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.e = paramShort;
      this.f = paramString;
    }

    public String a()
    {
      return this.f;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.b.a.a.a.h
 * JD-Core Version:    0.6.0
 */