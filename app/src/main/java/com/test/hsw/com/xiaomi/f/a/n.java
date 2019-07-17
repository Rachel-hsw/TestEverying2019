package com.xiaomi.f.a;

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
import org.a.c.b.i;
import org.a.c.b.k;

public class n
  implements Serializable, Cloneable, org.a.c.b<n, a>
{
  public static final Map<a, org.a.c.a.b> m;
  private static final k n = new k("XmPushActionSendMessage");
  private static final org.a.c.b.c o = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c p = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c q = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c r = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c s = new org.a.c.b.c("packageName", 11, 5);
  private static final org.a.c.b.c t = new org.a.c.b.c("topic", 11, 6);
  private static final org.a.c.b.c u = new org.a.c.b.c("aliasName", 11, 7);
  private static final org.a.c.b.c v = new org.a.c.b.c("message", 12, 8);
  private static final org.a.c.b.c w = new org.a.c.b.c("needAck", 2, 9);
  private static final org.a.c.b.c x = new org.a.c.b.c("params", 13, 10);
  private static final org.a.c.b.c y = new org.a.c.b.c("category", 11, 11);
  private static final org.a.c.b.c z = new org.a.c.b.c("userAccount", 11, 12);
  private BitSet A = new BitSet(1);
  public String a;
  public d b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public b h;
  public boolean i = true;
  public Map<String, String> j;
  public String k;
  public String l;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("topic", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.g, new org.a.c.a.b("aliasName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("message", 2, new org.a.c.a.g(12, b.class)));
    localEnumMap.put(a.i, new org.a.c.a.b("needAck", 2, new org.a.c.a.c(2)));
    localEnumMap.put(a.j, new org.a.c.a.b("params", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(11))));
    localEnumMap.put(a.k, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.l, new org.a.c.a.b("userAccount", 2, new org.a.c.a.c(11)));
    m = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(n.class, m);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      t();
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
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
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
      if (localc.b == 11)
      {
        this.e = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.f = paramf.w();
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
      if (localc.b == 12)
      {
        this.h = new b();
        this.h.a(paramf);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 2)
      {
        this.i = paramf.q();
        a(true);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 13)
      {
        org.a.c.b.e locale = paramf.k();
        this.j = new HashMap(2 * locale.c);
        for (int i1 = 0; i1 < locale.c; i1++)
        {
          String str1 = paramf.w();
          String str2 = paramf.w();
          this.j.put(str1, str2);
        }
        paramf.l();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.k = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.l = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.A.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(n paramn)
  {
    if (paramn == null);
    boolean bool23;
    boolean bool24;
    do
    {
      boolean bool21;
      boolean bool22;
      do
      {
        boolean bool19;
        boolean bool20;
        do
        {
          boolean bool17;
          boolean bool18;
          do
          {
            boolean bool15;
            boolean bool16;
            do
            {
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
                            bool2 = paramn.a();
                          }
                          while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramn.a))));
                          bool3 = b();
                          bool4 = paramn.b();
                        }
                        while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramn.b))));
                        bool5 = d();
                        bool6 = paramn.d();
                      }
                      while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramn.c))));
                      bool7 = f();
                      bool8 = paramn.f();
                    }
                    while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramn.d))));
                    bool9 = g();
                    bool10 = paramn.g();
                  }
                  while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramn.e))));
                  bool11 = i();
                  bool12 = paramn.i();
                }
                while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramn.f))));
                bool13 = k();
                bool14 = paramn.k();
              }
              while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramn.g))));
              bool15 = m();
              bool16 = paramn.m();
            }
            while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.a(paramn.h))));
            bool17 = n();
            bool18 = paramn.n();
          }
          while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (this.i != paramn.i)));
          bool19 = o();
          bool20 = paramn.o();
        }
        while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramn.j))));
        bool21 = q();
        bool22 = paramn.q();
      }
      while (((bool21) || (bool22)) && ((!bool21) || (!bool22) || (!this.k.equals(paramn.k))));
      bool23 = s();
      bool24 = paramn.s();
    }
    while (((bool23) || (bool24)) && ((!bool23) || (!bool24) || (!this.l.equals(paramn.l))));
    return true;
  }

  public int b(n paramn)
  {
    int i1;
    if (!getClass().equals(paramn.getClass()))
      i1 = getClass().getName().compareTo(paramn.getClass().getName());
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
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    return i1;
                                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramn.a()));
                                                  }
                                                  while (i1 != 0);
                                                  if (!a())
                                                    break;
                                                  i1 = org.a.c.c.a(this.a, paramn.a);
                                                }
                                                while (i1 != 0);
                                                i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramn.b()));
                                              }
                                              while (i1 != 0);
                                              if (!b())
                                                break;
                                              i1 = org.a.c.c.a(this.b, paramn.b);
                                            }
                                            while (i1 != 0);
                                            i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramn.d()));
                                          }
                                          while (i1 != 0);
                                          if (!d())
                                            break;
                                          i1 = org.a.c.c.a(this.c, paramn.c);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramn.f()));
                                      }
                                      while (i1 != 0);
                                      if (!f())
                                        break;
                                      i1 = org.a.c.c.a(this.d, paramn.d);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramn.g()));
                                  }
                                  while (i1 != 0);
                                  if (!g())
                                    break;
                                  i1 = org.a.c.c.a(this.e, paramn.e);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramn.i()));
                              }
                              while (i1 != 0);
                              if (!i())
                                break;
                              i1 = org.a.c.c.a(this.f, paramn.f);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramn.k()));
                          }
                          while (i1 != 0);
                          if (!k())
                            break;
                          i1 = org.a.c.c.a(this.g, paramn.g);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramn.m()));
                      }
                      while (i1 != 0);
                      if (!m())
                        break;
                      i1 = org.a.c.c.a(this.h, paramn.h);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramn.n()));
                  }
                  while (i1 != 0);
                  if (!n())
                    break;
                  i1 = org.a.c.c.a(this.i, paramn.i);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(paramn.o()));
              }
              while (i1 != 0);
              if (!o())
                break;
              i1 = org.a.c.c.a(this.j, paramn.j);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(paramn.q()));
          }
          while (i1 != 0);
          if (!q())
            break;
          i1 = org.a.c.c.a(this.k, paramn.k);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(paramn.s()));
      }
      while (i1 != 0);
      if (!s())
        break;
      i1 = org.a.c.c.a(this.l, paramn.l);
    }
    while (i1 != 0);
    return 0;
  }

  public void b(f paramf)
  {
    t();
    paramf.a(n);
    if ((this.a != null) && (a()))
    {
      paramf.a(o);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(p);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(q);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(r);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (g()))
    {
      paramf.a(s);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (i()))
    {
      paramf.a(t);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (k()))
    {
      paramf.a(u);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (m()))
    {
      paramf.a(v);
      this.h.b(paramf);
      paramf.b();
    }
    if (n())
    {
      paramf.a(w);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (o()))
    {
      paramf.a(x);
      paramf.a(new org.a.c.b.e(11, 11, this.j.size()));
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.k != null) && (q()))
    {
      paramf.a(y);
      paramf.a(this.k);
      paramf.b();
    }
    if ((this.l != null) && (s()))
    {
      paramf.a(z);
      paramf.a(this.l);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.b != null;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.c != null;
  }

  public String e()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof n));
    return a((n)paramObject);
  }

  public boolean f()
  {
    return this.d != null;
  }

  public boolean g()
  {
    return this.e != null;
  }

  public String h()
  {
    return this.f;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.f != null;
  }

  public String j()
  {
    return this.g;
  }

  public boolean k()
  {
    return this.g != null;
  }

  public b l()
  {
    return this.h;
  }

  public boolean m()
  {
    return this.h != null;
  }

  public boolean n()
  {
    return this.A.get(0);
  }

  public boolean o()
  {
    return this.j != null;
  }

  public String p()
  {
    return this.k;
  }

  public boolean q()
  {
    return this.k != null;
  }

  public String r()
  {
    return this.l;
  }

  public boolean s()
  {
    return this.l != null;
  }

  public void t()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendMessage(");
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
        break label600;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label478;
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
          break label504;
        localStringBuilder.append("null");
        label155: if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.e != null)
            break label516;
          localStringBuilder.append("null");
        }
        label193: if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.f != null)
            break label528;
          localStringBuilder.append("null");
        }
        label231: if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.g != null)
            break label540;
          localStringBuilder.append("null");
        }
        label269: if (m())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("message:");
          if (this.h != null)
            break label552;
          localStringBuilder.append("null");
        }
        label307: if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("needAck:");
          localStringBuilder.append(this.i);
        }
        if (o())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("params:");
          if (this.j != null)
            break label564;
          localStringBuilder.append("null");
        }
        label377: if (q())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null)
            break label576;
          localStringBuilder.append("null");
        }
        label415: if (s())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("userAccount:");
          if (this.l != null)
            break label588;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label478: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label504: localStringBuilder.append(this.d);
        break label155;
        label516: localStringBuilder.append(this.e);
        break label193;
        label528: localStringBuilder.append(this.f);
        break label231;
        label540: localStringBuilder.append(this.g);
        break label269;
        label552: localStringBuilder.append(this.h);
        break label307;
        label564: localStringBuilder.append(this.j);
        break label377;
        label576: localStringBuilder.append(this.k);
        break label415;
        label588: localStringBuilder.append(this.l);
      }
      label600: i1 = i2;
    }
  }

  public static enum a
  {
    private static final Map<String, a> m;
    private final short n;
    private final String o;

    static
    {
      a[] arrayOfa = new a[12];
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
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      p = arrayOfa;
      m = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        m.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.n = paramShort;
      this.o = paramString;
    }

    public String a()
    {
      return this.o;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.f.a.n
 * JD-Core Version:    0.6.0
 */