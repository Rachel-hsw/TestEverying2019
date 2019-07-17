package com.xiaomi.b.a.a.a;

import com.xiaomi.b.a.a.a;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.a.c.b.i;
import org.a.c.b.k;

public class c
  implements Serializable, Cloneable, org.a.c.b<c, a>
{
  public static final Map<a, org.a.c.a.b> a;
  private static final k b = new k("HttpLog");
  private static final org.a.c.b.c c = new org.a.c.b.c("common", 12, 1);
  private static final org.a.c.b.c d = new org.a.c.b.c("category", 11, 2);
  private static final org.a.c.b.c e = new org.a.c.b.c("httpApi", 12, 3);
  private static final org.a.c.b.c f = new org.a.c.b.c("passport", 12, 4);
  private a g;
  private String h = "";
  private b i;
  private f j;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("common", 1, new org.a.c.a.g(12, a.class)));
    localEnumMap.put(a.b, new org.a.c.a.b("category", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("httpApi", 2, new org.a.c.a.g(12, b.class)));
    localEnumMap.put(a.d, new org.a.c.a.b("passport", 2, new org.a.c.a.g(12, f.class)));
    a = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(c.class, a);
  }

  public c a(b paramb)
  {
    this.i = paramb;
    return this;
  }

  public c a(a parama)
  {
    this.g = parama;
    return this;
  }

  public c a(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public void a(org.a.c.b.f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      e();
      return;
    }
    switch (localc.c)
    {
    default:
      i.a(paramf, localc.b);
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramf.j();
      break;
      if (localc.b == 12)
      {
        this.g = new a();
        this.g.a(paramf);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.h = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 12)
      {
        this.i = new b();
        this.i.a(paramf);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 12)
      {
        this.j = new f();
        this.j.a(paramf);
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public boolean a()
  {
    return this.g != null;
  }

  public boolean a(c paramc)
  {
    if (paramc == null);
    boolean bool7;
    boolean bool8;
    do
    {
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
          while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.a(paramc.g))));
          bool3 = b();
          bool4 = paramc.b();
        }
        while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.h.equals(paramc.h))));
        bool5 = c();
        bool6 = paramc.c();
      }
      while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.i.a(paramc.i))));
      bool7 = d();
      bool8 = paramc.d();
    }
    while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.j.a(paramc.j))));
    return true;
  }

  public int b(c paramc)
  {
    int k;
    if (!getClass().equals(paramc.getClass()))
      k = getClass().getName().compareTo(paramc.getClass().getName());
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
                do
                {
                  do
                  {
                    return k;
                    k = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramc.a()));
                  }
                  while (k != 0);
                  if (!a())
                    break;
                  k = org.a.c.c.a(this.g, paramc.g);
                }
                while (k != 0);
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramc.b()));
              }
              while (k != 0);
              if (!b())
                break;
              k = org.a.c.c.a(this.h, paramc.h);
            }
            while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
          }
          while (k != 0);
          if (!c())
            break;
          k = org.a.c.c.a(this.i, paramc.i);
        }
        while (k != 0);
        k = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramc.d()));
      }
      while (k != 0);
      if (!d())
        break;
      k = org.a.c.c.a(this.j, paramc.j);
    }
    while (k != 0);
    return 0;
  }

  public void b(org.a.c.b.f paramf)
  {
    e();
    paramf.a(b);
    if (this.g != null)
    {
      paramf.a(c);
      this.g.b(paramf);
      paramf.b();
    }
    if (this.h != null)
    {
      paramf.a(d);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (c()))
    {
      paramf.a(e);
      this.i.b(paramf);
      paramf.b();
    }
    if ((this.j != null) && (d()))
    {
      paramf.a(f);
      this.j.b(paramf);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.h != null;
  }

  public boolean c()
  {
    return this.i != null;
  }

  public boolean d()
  {
    return this.j != null;
  }

  public void e()
  {
    if (this.g == null)
      throw new org.a.c.b.g("Required field 'common' was not present! Struct: " + toString());
    if (this.h == null)
      throw new org.a.c.b.g("Required field 'category' was not present! Struct: " + toString());
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
    StringBuilder localStringBuilder = new StringBuilder("HttpLog(");
    localStringBuilder.append("common:");
    if (this.g == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("category:");
      if (this.h != null)
        break label166;
      localStringBuilder.append("null");
      label65: if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("httpApi:");
        if (this.i != null)
          break label178;
        localStringBuilder.append("null");
      }
      label103: if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("passport:");
        if (this.j != null)
          break label190;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.g);
      break;
      label166: localStringBuilder.append(this.h);
      break label65;
      label178: localStringBuilder.append(this.i);
      break label103;
      label190: localStringBuilder.append(this.j);
    }
  }

  public static enum a
  {
    private static final Map<String, a> e;
    private final short f;
    private final String g;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      h = arrayOfa;
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        e.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
    }

    public String a()
    {
      return this.g;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.b.a.a.a.c
 * JD-Core Version:    0.6.0
 */