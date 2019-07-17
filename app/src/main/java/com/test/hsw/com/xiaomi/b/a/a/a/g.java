package com.xiaomi.b.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.a.c.b.f;
import org.a.c.b.i;
import org.a.c.b.k;

public class g
  implements Serializable, Cloneable, org.a.c.b<g, a>
{
  public static final Map<a, org.a.c.a.b> a;
  private static final k b = new k("PassportHostInfo");
  private static final org.a.c.b.c c = new org.a.c.b.c("host", 11, 1);
  private static final org.a.c.b.c d = new org.a.c.b.c("land_node_info", 15, 2);
  private String e;
  private List<h> f;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("host", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("land_node_info", 1, new org.a.c.a.d(15, new org.a.c.a.g(12, h.class))));
    a = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(g.class, a);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      c();
      return;
    }
    switch (localc.c)
    {
    default:
      i.a(paramf, localc.b);
    case 1:
    case 2:
    }
    while (true)
    {
      paramf.j();
      break;
      if (localc.b == 11)
      {
        this.e = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 15)
      {
        org.a.c.b.d locald = paramf.m();
        this.f = new ArrayList(locald.b);
        for (int i = 0; i < locald.b; i++)
        {
          h localh = new h();
          localh.a(paramf);
          this.f.add(localh);
        }
        paramf.n();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public boolean a()
  {
    return this.e != null;
  }

  public boolean a(g paramg)
  {
    if (paramg == null);
    boolean bool3;
    boolean bool4;
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return false;
        bool1 = a();
        bool2 = paramg.a();
      }
      while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramg.e))));
      bool3 = b();
      bool4 = paramg.b();
    }
    while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.f.equals(paramg.f))));
    return true;
  }

  public int b(g paramg)
  {
    int i;
    if (!getClass().equals(paramg.getClass()))
      i = getClass().getName().compareTo(paramg.getClass().getName());
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramg.a()));
          }
          while (i != 0);
          if (!a())
            break;
          i = org.a.c.c.a(this.e, paramg.e);
        }
        while (i != 0);
        i = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramg.b()));
      }
      while (i != 0);
      if (!b())
        break;
      i = org.a.c.c.a(this.f, paramg.f);
    }
    while (i != 0);
    return 0;
  }

  public void b(f paramf)
  {
    c();
    paramf.a(b);
    if (this.e != null)
    {
      paramf.a(c);
      paramf.a(this.e);
      paramf.b();
    }
    if (this.f != null)
    {
      paramf.a(d);
      paramf.a(new org.a.c.b.d(12, this.f.size()));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
        ((h)localIterator.next()).b(paramf);
      paramf.e();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.f != null;
  }

  public void c()
  {
    if (this.e == null)
      throw new org.a.c.b.g("Required field 'host' was not present! Struct: " + toString());
    if (this.f == null)
      throw new org.a.c.b.g("Required field 'land_node_info' was not present! Struct: " + toString());
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof g));
    return a((g)paramObject);
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PassportHostInfo(");
    localStringBuilder.append("host:");
    if (this.e == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("land_node_info:");
      if (this.f != null)
        break label90;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.e);
      break;
      label90: localStringBuilder.append(this.f);
    }
  }

  public static enum a
  {
    private static final Map<String, a> c;
    private final short d;
    private final String e;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      f = arrayOfa;
      c = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        c.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.d = paramShort;
      this.e = paramString;
    }

    public String a()
    {
      return this.e;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.b.a.a.a.g
 * JD-Core Version:    0.6.0
 */