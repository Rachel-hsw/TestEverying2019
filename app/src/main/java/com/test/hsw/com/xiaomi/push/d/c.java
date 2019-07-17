package com.xiaomi.push.d;

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

public class c
  implements Serializable, Cloneable, org.a.c.b<c, a>
{
  public static final Map<a, org.a.c.a.b> d;
  private static final k e = new k("StatsEvents");
  private static final org.a.c.b.c f = new org.a.c.b.c("uuid", 11, 1);
  private static final org.a.c.b.c g = new org.a.c.b.c("operator", 11, 2);
  private static final org.a.c.b.c h = new org.a.c.b.c("events", 15, 3);
  public String a;
  public String b;
  public List<b> c;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("uuid", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("operator", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("events", 1, new org.a.c.a.d(15, new org.a.c.a.g(12, b.class))));
    d = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(c.class, d);
  }

  public c()
  {
  }

  public c(String paramString, List<b> paramList)
  {
    this();
    this.a = paramString;
    this.c = paramList;
  }

  public c a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      d();
      return;
    }
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
      if (localc.b == 11)
      {
        this.a = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.b = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 15)
      {
        org.a.c.b.d locald = paramf.m();
        this.c = new ArrayList(locald.b);
        for (int i = 0; i < locald.b; i++)
        {
          b localb = new b();
          localb.a(paramf);
          this.c.add(localb);
        }
        paramf.n();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(c paramc)
  {
    if (paramc == null);
    boolean bool5;
    boolean bool6;
    do
    {
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
          bool2 = paramc.a();
        }
        while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramc.a))));
        bool3 = b();
        bool4 = paramc.b();
      }
      while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(paramc.b))));
      bool5 = c();
      bool6 = paramc.c();
    }
    while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramc.c))));
    return true;
  }

  public int b(c paramc)
  {
    int i;
    if (!getClass().equals(paramc.getClass()))
      i = getClass().getName().compareTo(paramc.getClass().getName());
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
                return i;
                i = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramc.a()));
              }
              while (i != 0);
              if (!a())
                break;
              i = org.a.c.c.a(this.a, paramc.a);
            }
            while (i != 0);
            i = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramc.b()));
          }
          while (i != 0);
          if (!b())
            break;
          i = org.a.c.c.a(this.b, paramc.b);
        }
        while (i != 0);
        i = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
      }
      while (i != 0);
      if (!c())
        break;
      i = org.a.c.c.a(this.c, paramc.c);
    }
    while (i != 0);
    return 0;
  }

  public void b(f paramf)
  {
    d();
    paramf.a(e);
    if (this.a != null)
    {
      paramf.a(f);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(g);
      paramf.a(this.b);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(h);
      paramf.a(new org.a.c.b.d(12, this.c.size()));
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).b(paramf);
      paramf.e();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.b != null;
  }

  public boolean c()
  {
    return this.c != null;
  }

  public void d()
  {
    if (this.a == null)
      throw new org.a.c.b.g("Required field 'uuid' was not present! Struct: " + toString());
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'events' was not present! Struct: " + toString());
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof c));
    return a((c)paramObject);
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvents(");
    localStringBuilder.append("uuid:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("operator:");
        if (this.b != null)
          break label128;
        localStringBuilder.append("null");
      }
      label72: localStringBuilder.append(", ");
      localStringBuilder.append("events:");
      if (this.c != null)
        break label140;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label128: localStringBuilder.append(this.b);
      break label72;
      label140: localStringBuilder.append(this.c);
    }
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
 * Qualified Name:     com.xiaomi.push.d.c
 * JD-Core Version:    0.6.0
 */