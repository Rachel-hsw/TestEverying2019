package com.xiaomi.b.a.a.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.a.c.b.f;
import org.a.c.b.g;
import org.a.c.b.i;
import org.a.c.b.k;

public class d
  implements Serializable, Cloneable, org.a.c.b<d, a>
{
  public static final Map<a, org.a.c.a.b> a;
  private static final k b = new k("LandNodeInfo");
  private static final org.a.c.b.c c = new org.a.c.b.c("ip", 11, 1);
  private static final org.a.c.b.c d = new org.a.c.b.c("failed_count", 8, 2);
  private static final org.a.c.b.c e = new org.a.c.b.c("success_count", 8, 3);
  private static final org.a.c.b.c f = new org.a.c.b.c("duration", 10, 4);
  private static final org.a.c.b.c g = new org.a.c.b.c("size", 8, 5);
  private static final org.a.c.b.c h = new org.a.c.b.c("exp_info", 13, 6);
  private static final org.a.c.b.c i = new org.a.c.b.c("http_info", 13, 7);
  private String j;
  private int k;
  private int l;
  private long m;
  private int n;
  private Map<String, Integer> o;
  private Map<Integer, Integer> p;
  private BitSet q = new BitSet(4);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("ip", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("failed_count", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.c, new org.a.c.a.b("success_count", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.d, new org.a.c.a.b("duration", 1, new org.a.c.a.c(10)));
    localEnumMap.put(a.e, new org.a.c.a.b("size", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.f, new org.a.c.a.b("exp_info", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(8))));
    localEnumMap.put(a.g, new org.a.c.a.b("http_info", 2, new org.a.c.a.e(13, new org.a.c.a.c(8), new org.a.c.a.c(8))));
    a = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(d.class, a);
  }

  public d a(int paramInt)
  {
    this.k = paramInt;
    a(true);
    return this;
  }

  public d a(long paramLong)
  {
    this.m = paramLong;
    c(true);
    return this;
  }

  public d a(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public d a(Map<String, Integer> paramMap)
  {
    this.o = paramMap;
    return this;
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!b())
        throw new g("Required field 'failed_count' was not found in serialized data! Struct: " + toString());
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
      case 4:
      case 5:
      case 6:
      case 7:
      }
      while (true)
      {
        paramf.j();
        break;
        if (localc.b == 11)
        {
          this.j = paramf.w();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.k = paramf.t();
          a(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.l = paramf.t();
          b(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 10)
        {
          this.m = paramf.u();
          c(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.n = paramf.t();
          d(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 13)
        {
          org.a.c.b.e locale2 = paramf.k();
          this.o = new HashMap(2 * locale2.c);
          for (int i4 = 0; i4 < locale2.c; i4++)
          {
            String str = paramf.w();
            int i5 = paramf.t();
            this.o.put(str, Integer.valueOf(i5));
          }
          paramf.l();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 13)
        {
          org.a.c.b.e locale1 = paramf.k();
          this.p = new HashMap(2 * locale1.c);
          for (int i1 = 0; i1 < locale1.c; i1++)
          {
            int i2 = paramf.t();
            int i3 = paramf.t();
            this.p.put(Integer.valueOf(i2), Integer.valueOf(i3));
          }
          paramf.l();
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    if (!c())
      throw new g("Required field 'success_count' was not found in serialized data! Struct: " + toString());
    if (!d())
      throw new g("Required field 'duration' was not found in serialized data! Struct: " + toString());
    if (!e())
      throw new g("Required field 'size' was not found in serialized data! Struct: " + toString());
    h();
  }

  public void a(boolean paramBoolean)
  {
    this.q.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.j != null;
  }

  public boolean a(d paramd)
  {
    if (paramd == null);
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
          bool2 = paramd.a();
        }
        while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramd.j)) || (this.k != paramd.k) || (this.l != paramd.l) || (this.m != paramd.m) || (this.n != paramd.n)));
        bool3 = f();
        bool4 = paramd.f();
      }
      while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.o.equals(paramd.o))));
      bool5 = g();
      bool6 = paramd.g();
    }
    while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.p.equals(paramd.p))));
    return true;
  }

  public int b(d paramd)
  {
    int i1;
    if (!getClass().equals(paramd.getClass()))
      i1 = getClass().getName().compareTo(paramd.getClass().getName());
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
                                return i1;
                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramd.a()));
                              }
                              while (i1 != 0);
                              if (!a())
                                break;
                              i1 = org.a.c.c.a(this.j, paramd.j);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramd.b()));
                          }
                          while (i1 != 0);
                          if (!b())
                            break;
                          i1 = org.a.c.c.a(this.k, paramd.k);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramd.c()));
                      }
                      while (i1 != 0);
                      if (!c())
                        break;
                      i1 = org.a.c.c.a(this.l, paramd.l);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramd.d()));
                  }
                  while (i1 != 0);
                  if (!d())
                    break;
                  i1 = org.a.c.c.a(this.m, paramd.m);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramd.e()));
              }
              while (i1 != 0);
              if (!e())
                break;
              i1 = org.a.c.c.a(this.n, paramd.n);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramd.f()));
          }
          while (i1 != 0);
          if (!f())
            break;
          i1 = org.a.c.c.a(this.o, paramd.o);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramd.g()));
      }
      while (i1 != 0);
      if (!g())
        break;
      i1 = org.a.c.c.a(this.p, paramd.p);
    }
    while (i1 != 0);
    return 0;
  }

  public d b(int paramInt)
  {
    this.l = paramInt;
    b(true);
    return this;
  }

  public void b(f paramf)
  {
    h();
    paramf.a(b);
    if (this.j != null)
    {
      paramf.a(c);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.a(d);
    paramf.a(this.k);
    paramf.b();
    paramf.a(e);
    paramf.a(this.l);
    paramf.b();
    paramf.a(f);
    paramf.a(this.m);
    paramf.b();
    paramf.a(g);
    paramf.a(this.n);
    paramf.b();
    if ((this.o != null) && (f()))
    {
      paramf.a(h);
      paramf.a(new org.a.c.b.e(11, 8, this.o.size()));
      Iterator localIterator2 = this.o.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        paramf.a((String)localEntry2.getKey());
        paramf.a(((Integer)localEntry2.getValue()).intValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.p != null) && (g()))
    {
      paramf.a(i);
      paramf.a(new org.a.c.b.e(8, 8, this.p.size()));
      Iterator localIterator1 = this.p.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        paramf.a(((Integer)localEntry1.getKey()).intValue());
        paramf.a(((Integer)localEntry1.getValue()).intValue());
      }
      paramf.d();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.q.set(1, paramBoolean);
  }

  public boolean b()
  {
    return this.q.get(0);
  }

  public d c(int paramInt)
  {
    this.n = paramInt;
    d(true);
    return this;
  }

  public void c(boolean paramBoolean)
  {
    this.q.set(2, paramBoolean);
  }

  public boolean c()
  {
    return this.q.get(1);
  }

  public void d(boolean paramBoolean)
  {
    this.q.set(3, paramBoolean);
  }

  public boolean d()
  {
    return this.q.get(2);
  }

  public boolean e()
  {
    return this.q.get(3);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof d));
    return a((d)paramObject);
  }

  public boolean f()
  {
    return this.o != null;
  }

  public boolean g()
  {
    return this.p != null;
  }

  public void h()
  {
    if (this.j == null)
      throw new g("Required field 'ip' was not present! Struct: " + toString());
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LandNodeInfo(");
    localStringBuilder.append("ip:");
    if (this.j == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("failed_count:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", ");
      localStringBuilder.append("success_count:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(", ");
      localStringBuilder.append("size:");
      localStringBuilder.append(this.n);
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("exp_info:");
        if (this.o != null)
          break label235;
        localStringBuilder.append("null");
      }
      label172: if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("http_info:");
        if (this.p != null)
          break label247;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.j);
      break;
      label235: localStringBuilder.append(this.o);
      break label172;
      label247: localStringBuilder.append(this.p);
    }
  }

  public static enum a
  {
    private static final Map<String, a> h;
    private final short i;
    private final String j;

    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      k = arrayOfa;
      h = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        h.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.i = paramShort;
      this.j = paramString;
    }

    public String a()
    {
      return this.j;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.b.a.a.a.d
 * JD-Core Version:    0.6.0
 */