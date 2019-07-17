package com.xiaomi.b.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.a.c.b.f;
import org.a.c.b.i;
import org.a.c.b.k;

public class e
  implements Serializable, Cloneable, org.a.c.b<e, a>
{
  public static final Map<a, org.a.c.a.b> a;
  private static final k b = new k("Location");
  private static final org.a.c.b.c c = new org.a.c.b.c("contry", 11, 1);
  private static final org.a.c.b.c d = new org.a.c.b.c("province", 11, 2);
  private static final org.a.c.b.c e = new org.a.c.b.c("city", 11, 3);
  private static final org.a.c.b.c f = new org.a.c.b.c("isp", 11, 4);
  private String g;
  private String h;
  private String i;
  private String j;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("contry", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("province", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("city", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("isp", 2, new org.a.c.a.c(11)));
    a = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(e.class, a);
  }

  public e a(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public void a(f paramf)
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
      if (localc.b == 11)
      {
        this.g = paramf.w();
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
      if (localc.b == 11)
      {
        this.i = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.j = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public boolean a()
  {
    return this.g != null;
  }

  public boolean a(e parame)
  {
    if (parame == null);
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
            bool2 = parame.a();
          }
          while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(parame.g))));
          bool3 = b();
          bool4 = parame.b();
        }
        while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.h.equals(parame.h))));
        bool5 = c();
        bool6 = parame.c();
      }
      while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.i.equals(parame.i))));
      bool7 = d();
      bool8 = parame.d();
    }
    while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.j.equals(parame.j))));
    return true;
  }

  public int b(e parame)
  {
    int k;
    if (!getClass().equals(parame.getClass()))
      k = getClass().getName().compareTo(parame.getClass().getName());
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
                    k = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parame.a()));
                  }
                  while (k != 0);
                  if (!a())
                    break;
                  k = org.a.c.c.a(this.g, parame.g);
                }
                while (k != 0);
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parame.b()));
              }
              while (k != 0);
              if (!b())
                break;
              k = org.a.c.c.a(this.h, parame.h);
            }
            while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parame.c()));
          }
          while (k != 0);
          if (!c())
            break;
          k = org.a.c.c.a(this.i, parame.i);
        }
        while (k != 0);
        k = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parame.d()));
      }
      while (k != 0);
      if (!d())
        break;
      k = org.a.c.c.a(this.j, parame.j);
    }
    while (k != 0);
    return 0;
  }

  public e b(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public void b(f paramf)
  {
    e();
    paramf.a(b);
    if ((this.g != null) && (a()))
    {
      paramf.a(c);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (b()))
    {
      paramf.a(d);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (c()))
    {
      paramf.a(e);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (d()))
    {
      paramf.a(f);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.h != null;
  }

  public e c(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public boolean c()
  {
    return this.i != null;
  }

  public e d(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public boolean d()
  {
    return this.j != null;
  }

  public void e()
  {
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof e));
    return a((e)paramObject);
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    int k = 0;
    StringBuilder localStringBuilder = new StringBuilder("Location(");
    int m = 1;
    if (a())
    {
      localStringBuilder.append("contry:");
      if (this.g == null)
      {
        localStringBuilder.append("null");
        m = 0;
      }
    }
    else
    {
      if (b())
      {
        if (m == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("province:");
        if (this.h != null)
          break label187;
        localStringBuilder.append("null");
        label83: m = 0;
      }
      if (!c())
        break label225;
      if (m == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("city:");
      if (this.i != null)
        break label199;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label124: if (d())
      {
        if (k == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("isp:");
        if (this.j != null)
          break label213;
        localStringBuilder.append("null");
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.g);
        break;
        label187: localStringBuilder.append(this.h);
        break label83;
        label199: localStringBuilder.append(this.i);
        k = 0;
        break label124;
        label213: localStringBuilder.append(this.j);
      }
      label225: k = m;
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
 * Qualified Name:     com.xiaomi.b.a.a.a.e
 * JD-Core Version:    0.6.0
 */