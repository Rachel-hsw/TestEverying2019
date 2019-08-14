package com.xiaomi.f.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.a.c.b.f;
import org.a.c.b.i;
import org.a.c.b.k;

public class r
  implements Serializable, Cloneable, org.a.c.b<r, a>
{
  public static final Map<a, org.a.c.a.b> i;
  private static final k j = new k("XmPushActionUnRegistrationResult");
  private static final org.a.c.b.c k = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c l = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c m = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c n = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c o = new org.a.c.b.c("request", 12, 5);
  private static final org.a.c.b.c p = new org.a.c.b.c("errorCode", 10, 6);
  private static final org.a.c.b.c q = new org.a.c.b.c("reason", 11, 7);
  private static final org.a.c.b.c r = new org.a.c.b.c("packageName", 11, 8);
  public String a;
  public d b;
  public String c;
  public String d;
  public q e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(1);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("request", 2, new org.a.c.a.g(12, q.class)));
    localEnumMap.put(a.f, new org.a.c.a.b("errorCode", 1, new org.a.c.a.c(10)));
    localEnumMap.put(a.g, new org.a.c.a.b("reason", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(r.class, i);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!f())
        throw new org.a.c.b.g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
        if (localc.b == 12)
        {
          this.b = new d();
          this.b.a(paramf);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.c = paramf.w();
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
        if (localc.b == 12)
        {
          this.e = new q();
          this.e.a(paramf);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 10)
        {
          this.f = paramf.u();
          a(true);
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
      }
    }
    i();
  }

  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(r paramr)
  {
    if (paramr == null);
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
                  return false;
                  bool1 = a();
                  bool2 = paramr.a();
                }
                while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramr.a))));
                bool3 = b();
                bool4 = paramr.b();
              }
              while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramr.b))));
              bool5 = c();
              bool6 = paramr.c();
            }
            while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramr.c))));
            bool7 = d();
            bool8 = paramr.d();
          }
          while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramr.d))));
          bool9 = e();
          bool10 = paramr.e();
        }
        while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.a(paramr.e)) || (this.f != paramr.f)));
        bool11 = g();
        bool12 = paramr.g();
      }
      while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramr.g))));
      bool13 = h();
      bool14 = paramr.h();
    }
    while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(paramr.h))));
    return true;
  }

  public int b(r paramr)
  {
    int i1;
    if (!getClass().equals(paramr.getClass()))
      i1 = getClass().getName().compareTo(paramr.getClass().getName());
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
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramr.a()));
                                  }
                                  while (i1 != 0);
                                  if (!a())
                                    break;
                                  i1 = org.a.c.c.a(this.a, paramr.a);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramr.b()));
                              }
                              while (i1 != 0);
                              if (!b())
                                break;
                              i1 = org.a.c.c.a(this.b, paramr.b);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramr.c()));
                          }
                          while (i1 != 0);
                          if (!c())
                            break;
                          i1 = org.a.c.c.a(this.c, paramr.c);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramr.d()));
                      }
                      while (i1 != 0);
                      if (!d())
                        break;
                      i1 = org.a.c.c.a(this.d, paramr.d);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramr.e()));
                  }
                  while (i1 != 0);
                  if (!e())
                    break;
                  i1 = org.a.c.c.a(this.e, paramr.e);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramr.f()));
              }
              while (i1 != 0);
              if (!f())
                break;
              i1 = org.a.c.c.a(this.f, paramr.f);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramr.g()));
          }
          while (i1 != 0);
          if (!g())
            break;
          i1 = org.a.c.c.a(this.g, paramr.g);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramr.h()));
      }
      while (i1 != 0);
      if (!h())
        break;
      i1 = org.a.c.c.a(this.h, paramr.h);
    }
    while (i1 != 0);
    return 0;
  }

  public void b(f paramf)
  {
    i();
    paramf.a(j);
    if ((this.a != null) && (a()))
    {
      paramf.a(k);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(l);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(m);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(n);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(o);
      this.e.b(paramf);
      paramf.b();
    }
    paramf.a(p);
    paramf.a(this.f);
    paramf.b();
    if ((this.g != null) && (g()))
    {
      paramf.a(q);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (h()))
    {
      paramf.a(r);
      paramf.a(this.h);
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

  public boolean d()
  {
    return this.d != null;
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
    while (!(paramObject instanceof r));
    return a((r)paramObject);
  }

  public boolean f()
  {
    return this.s.get(0);
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

  public void i()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnRegistrationResult(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("debug:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (!b())
        break label393;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label319;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label89: if (i1 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        label124: localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        if (this.d != null)
          break label345;
        localStringBuilder.append("null");
        label155: if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null)
            break label357;
          localStringBuilder.append("null");
        }
        label193: localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null)
            break label369;
          localStringBuilder.append("null");
        }
        label256: if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.h != null)
            break label381;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label319: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label345: localStringBuilder.append(this.d);
        break label155;
        label357: localStringBuilder.append(this.e);
        break label193;
        label369: localStringBuilder.append(this.g);
        break label256;
        label381: localStringBuilder.append(this.h);
      }
      label393: i1 = i2;
    }
  }

  public static enum a
  {
    private static final Map<String, a> i;
    private final short j;
    private final String k;

    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      l = arrayOfa;
      i = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.j = paramShort;
      this.k = paramString;
    }

    public String a()
    {
      return this.k;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.f.a.r
 * JD-Core Version:    0.6.0
 */