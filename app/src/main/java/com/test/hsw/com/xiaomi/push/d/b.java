package com.xiaomi.push.d;

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

public class b
  implements Serializable, Cloneable, org.a.c.b<b, a>
{
  public static final Map<a, org.a.c.a.b> k;
  private static final k l = new k("StatsEvent");
  private static final org.a.c.b.c m = new org.a.c.b.c("chid", 3, 1);
  private static final org.a.c.b.c n = new org.a.c.b.c("type", 8, 2);
  private static final org.a.c.b.c o = new org.a.c.b.c("value", 8, 3);
  private static final org.a.c.b.c p = new org.a.c.b.c("connpt", 11, 4);
  private static final org.a.c.b.c q = new org.a.c.b.c("host", 11, 5);
  private static final org.a.c.b.c r = new org.a.c.b.c("subvalue", 8, 6);
  private static final org.a.c.b.c s = new org.a.c.b.c("annotation", 11, 7);
  private static final org.a.c.b.c t = new org.a.c.b.c("user", 11, 8);
  private static final org.a.c.b.c u = new org.a.c.b.c("time", 8, 9);
  private static final org.a.c.b.c v = new org.a.c.b.c("clientIp", 8, 10);
  public byte a;
  public int b;
  public int c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  public int i;
  public int j;
  private BitSet w = new BitSet(6);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("chid", 1, new org.a.c.a.c(3)));
    localEnumMap.put(a.b, new org.a.c.a.b("type", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.c, new org.a.c.a.b("value", 1, new org.a.c.a.c(8)));
    localEnumMap.put(a.d, new org.a.c.a.b("connpt", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("host", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("subvalue", 2, new org.a.c.a.c(8)));
    localEnumMap.put(a.g, new org.a.c.a.b("annotation", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("user", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.i, new org.a.c.a.b("time", 2, new org.a.c.a.c(8)));
    localEnumMap.put(a.j, new org.a.c.a.b("clientIp", 2, new org.a.c.a.c(8)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(b.class, k);
  }

  public b a(byte paramByte)
  {
    this.a = paramByte;
    a(true);
    return this;
  }

  public b a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }

  public b a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!a())
        throw new g("Required field 'chid' was not found in serialized data! Struct: " + toString());
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
      case 8:
      case 9:
      case 10:
      }
      while (true)
      {
        paramf.j();
        break;
        if (localc.b == 3)
        {
          this.a = paramf.r();
          a(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.b = paramf.t();
          b(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.c = paramf.t();
          c(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.d = paramf.w();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.e = paramf.w();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.f = paramf.t();
          d(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
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
        if (localc.b == 8)
        {
          this.i = paramf.t();
          e(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.j = paramf.t();
          f(true);
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    if (!b())
      throw new g("Required field 'type' was not found in serialized data! Struct: " + toString());
    if (!c())
      throw new g("Required field 'value' was not found in serialized data! Struct: " + toString());
    k();
  }

  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.w.get(0);
  }

  public boolean a(b paramb)
  {
    if (paramb == null);
    boolean bool13;
    boolean bool14;
    do
    {
      boolean bool11;
      boolean bool12;
      do
      {
        boolean bool9;
        boolean bool10;
        do
        {
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
                  do
                    return false;
                  while ((this.a != paramb.a) || (this.b != paramb.b) || (this.c != paramb.c));
                  bool1 = d();
                  bool2 = paramb.d();
                }
                while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramb.d))));
                bool3 = e();
                bool4 = paramb.e();
              }
              while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.e.equals(paramb.e))));
              bool5 = f();
              bool6 = paramb.f();
            }
            while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (this.f != paramb.f)));
            bool7 = g();
            bool8 = paramb.g();
          }
          while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.g.equals(paramb.g))));
          bool9 = h();
          bool10 = paramb.h();
        }
        while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.h.equals(paramb.h))));
        bool11 = i();
        bool12 = paramb.i();
      }
      while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (this.i != paramb.i)));
      bool13 = j();
      bool14 = paramb.j();
    }
    while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (this.j != paramb.j)));
    return true;
  }

  public int b(b paramb)
  {
    int i1;
    if (!getClass().equals(paramb.getClass()))
      i1 = getClass().getName().compareTo(paramb.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramb.a()));
                                          }
                                          while (i1 != 0);
                                          if (!a())
                                            break;
                                          i1 = org.a.c.c.a(this.a, paramb.a);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramb.b()));
                                      }
                                      while (i1 != 0);
                                      if (!b())
                                        break;
                                      i1 = org.a.c.c.a(this.b, paramb.b);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramb.c()));
                                  }
                                  while (i1 != 0);
                                  if (!c())
                                    break;
                                  i1 = org.a.c.c.a(this.c, paramb.c);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramb.d()));
                              }
                              while (i1 != 0);
                              if (!d())
                                break;
                              i1 = org.a.c.c.a(this.d, paramb.d);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramb.e()));
                          }
                          while (i1 != 0);
                          if (!e())
                            break;
                          i1 = org.a.c.c.a(this.e, paramb.e);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramb.f()));
                      }
                      while (i1 != 0);
                      if (!f())
                        break;
                      i1 = org.a.c.c.a(this.f, paramb.f);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramb.g()));
                  }
                  while (i1 != 0);
                  if (!g())
                    break;
                  i1 = org.a.c.c.a(this.g, paramb.g);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramb.h()));
              }
              while (i1 != 0);
              if (!h())
                break;
              i1 = org.a.c.c.a(this.h, paramb.h);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramb.i()));
          }
          while (i1 != 0);
          if (!i())
            break;
          i1 = org.a.c.c.a(this.i, paramb.i);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramb.j()));
      }
      while (i1 != 0);
      if (!j())
        break;
      i1 = org.a.c.c.a(this.j, paramb.j);
    }
    while (i1 != 0);
    return 0;
  }

  public b b(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }

  public b b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public void b(f paramf)
  {
    k();
    paramf.a(l);
    paramf.a(m);
    paramf.a(this.a);
    paramf.b();
    paramf.a(n);
    paramf.a(this.b);
    paramf.b();
    paramf.a(o);
    paramf.a(this.c);
    paramf.b();
    if (this.d != null)
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    if (f())
    {
      paramf.a(r);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (g()))
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (h()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if (i())
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if (j())
    {
      paramf.a(v);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.w.set(1, paramBoolean);
  }

  public boolean b()
  {
    return this.w.get(1);
  }

  public b c(int paramInt)
  {
    this.f = paramInt;
    d(true);
    return this;
  }

  public b c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public void c(boolean paramBoolean)
  {
    this.w.set(2, paramBoolean);
  }

  public boolean c()
  {
    return this.w.get(2);
  }

  public b d(int paramInt)
  {
    this.i = paramInt;
    e(true);
    return this;
  }

  public b d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public void d(boolean paramBoolean)
  {
    this.w.set(3, paramBoolean);
  }

  public boolean d()
  {
    return this.d != null;
  }

  public b e(int paramInt)
  {
    this.j = paramInt;
    f(true);
    return this;
  }

  public void e(boolean paramBoolean)
  {
    this.w.set(4, paramBoolean);
  }

  public boolean e()
  {
    return this.e != null;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof b));
    return a((b)paramObject);
  }

  public void f(boolean paramBoolean)
  {
    this.w.set(5, paramBoolean);
  }

  public boolean f()
  {
    return this.w.get(3);
  }

  public boolean g()
  {
    return this.g != null;
  }

  public boolean h()
  {
    return this.h != null;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.w.get(4);
  }

  public boolean j()
  {
    return this.w.get(5);
  }

  public void k()
  {
    if (this.d == null)
      throw new g("Required field 'connpt' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvent(");
    localStringBuilder.append("chid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("type:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("value:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("connpt:");
    if (this.d == null)
    {
      localStringBuilder.append("null");
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("host:");
        if (this.e != null)
          break label344;
        localStringBuilder.append("null");
      }
      label147: if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("subvalue:");
        localStringBuilder.append(this.f);
      }
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("annotation:");
        if (this.g != null)
          break label356;
        localStringBuilder.append("null");
      }
      label217: if (h())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("user:");
        if (this.h != null)
          break label368;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("time:");
        localStringBuilder.append(this.i);
      }
      if (j())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("clientIp:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.d);
      break;
      label344: localStringBuilder.append(this.e);
      break label147;
      label356: localStringBuilder.append(this.g);
      break label217;
      label368: localStringBuilder.append(this.h);
    }
  }

  public static enum a
  {
    private static final Map<String, a> k;
    private final short l;
    private final String m;

    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      n = arrayOfa;
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        k.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
    }

    public String a()
    {
      return this.m;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.d.b
 * JD-Core Version:    0.6.0
 */