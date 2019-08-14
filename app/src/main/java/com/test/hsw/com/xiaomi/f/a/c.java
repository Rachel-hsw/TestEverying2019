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
import org.a.c.b.g;
import org.a.c.b.i;
import org.a.c.b.k;

public class c
  implements Serializable, Cloneable, org.a.c.b<c, a>
{
  public static final Map<a, org.a.c.a.b> m;
  private static final k n = new k("PushMetaInfo");
  private static final org.a.c.b.c o = new org.a.c.b.c("id", 11, 1);
  private static final org.a.c.b.c p = new org.a.c.b.c("messageTs", 10, 2);
  private static final org.a.c.b.c q = new org.a.c.b.c("topic", 11, 3);
  private static final org.a.c.b.c r = new org.a.c.b.c("title", 11, 4);
  private static final org.a.c.b.c s = new org.a.c.b.c("description", 11, 5);
  private static final org.a.c.b.c t = new org.a.c.b.c("notifyType", 8, 6);
  private static final org.a.c.b.c u = new org.a.c.b.c("url", 11, 7);
  private static final org.a.c.b.c v = new org.a.c.b.c("passThrough", 8, 8);
  private static final org.a.c.b.c w = new org.a.c.b.c("notifyId", 8, 9);
  private static final org.a.c.b.c x = new org.a.c.b.c("extra", 13, 10);
  private static final org.a.c.b.c y = new org.a.c.b.c("internal", 13, 11);
  private static final org.a.c.b.c z = new org.a.c.b.c("ignoreRegInfo", 2, 12);
  private BitSet A = new BitSet(5);
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public int h;
  public int i;
  public Map<String, String> j;
  public Map<String, String> k;
  public boolean l;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("messageTs", 1, new org.a.c.a.c(10)));
    localEnumMap.put(a.c, new org.a.c.a.b("topic", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("title", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("description", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("notifyType", 2, new org.a.c.a.c(8)));
    localEnumMap.put(a.g, new org.a.c.a.b("url", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("passThrough", 2, new org.a.c.a.c(8)));
    localEnumMap.put(a.i, new org.a.c.a.b("notifyId", 2, new org.a.c.a.c(8)));
    localEnumMap.put(a.j, new org.a.c.a.b("extra", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(11))));
    localEnumMap.put(a.k, new org.a.c.a.b("internal", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(11))));
    localEnumMap.put(a.l, new org.a.c.a.b("ignoreRegInfo", 2, new org.a.c.a.c(2)));
    m = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(c.class, m);
  }

  public c()
  {
    this.l = false;
  }

  public c(c paramc)
  {
    this.A.clear();
    this.A.or(paramc.A);
    if (paramc.c())
      this.a = paramc.a;
    this.b = paramc.b;
    if (paramc.g())
      this.c = paramc.c;
    if (paramc.i())
      this.d = paramc.d;
    if (paramc.k())
      this.e = paramc.e;
    this.f = paramc.f;
    if (paramc.n())
      this.g = paramc.g;
    this.h = paramc.h;
    this.i = paramc.i;
    if (paramc.t())
    {
      HashMap localHashMap1 = new HashMap();
      Iterator localIterator1 = paramc.j.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        localHashMap1.put((String)localEntry2.getKey(), (String)localEntry2.getValue());
      }
      this.j = localHashMap1;
    }
    if (paramc.u())
    {
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = paramc.k.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
        localHashMap2.put((String)localEntry1.getKey(), (String)localEntry1.getValue());
      }
      this.k = localHashMap2;
    }
    this.l = paramc.l;
  }

  public c a()
  {
    return new c(this);
  }

  public c a(int paramInt)
  {
    this.f = paramInt;
    b(true);
    return this;
  }

  public c a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public c a(Map<String, String> paramMap)
  {
    this.j = paramMap;
    return this;
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.j == null)
      this.j = new HashMap();
    this.j.put(paramString1, paramString2);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!e())
        throw new g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
        if (localc.b == 10)
        {
          this.b = paramf.u();
          a(true);
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
        if (localc.b == 8)
        {
          this.f = paramf.t();
          b(true);
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
        if (localc.b == 8)
        {
          this.h = paramf.t();
          c(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 8)
        {
          this.i = paramf.t();
          d(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 13)
        {
          org.a.c.b.e locale2 = paramf.k();
          this.j = new HashMap(2 * locale2.c);
          for (int i2 = 0; i2 < locale2.c; i2++)
          {
            String str3 = paramf.w();
            String str4 = paramf.w();
            this.j.put(str3, str4);
          }
          paramf.l();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 13)
        {
          org.a.c.b.e locale1 = paramf.k();
          this.k = new HashMap(2 * locale1.c);
          for (int i1 = 0; i1 < locale1.c; i1++)
          {
            String str1 = paramf.w();
            String str2 = paramf.w();
            this.k.put(str1, str2);
          }
          paramf.l();
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 2)
        {
          this.l = paramf.q();
          e(true);
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    x();
  }

  public void a(boolean paramBoolean)
  {
    this.A.set(0, paramBoolean);
  }

  public boolean a(c paramc)
  {
    if (paramc == null);
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
                          bool1 = c();
                          bool2 = paramc.c();
                        }
                        while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramc.a)) || (this.b != paramc.b)));
                        bool3 = g();
                        bool4 = paramc.g();
                      }
                      while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.c.equals(paramc.c))));
                      bool5 = i();
                      bool6 = paramc.i();
                    }
                    while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.d.equals(paramc.d))));
                    bool7 = k();
                    bool8 = paramc.k();
                  }
                  while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.e.equals(paramc.e))));
                  bool9 = m();
                  bool10 = paramc.m();
                }
                while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (this.f != paramc.f)));
                bool11 = n();
                bool12 = paramc.n();
              }
              while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramc.g))));
              bool13 = p();
              bool14 = paramc.p();
            }
            while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (this.h != paramc.h)));
            bool15 = r();
            bool16 = paramc.r();
          }
          while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (this.i != paramc.i)));
          bool17 = t();
          bool18 = paramc.t();
        }
        while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paramc.j))));
        bool19 = u();
        bool20 = paramc.u();
      }
      while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.k.equals(paramc.k))));
      bool21 = w();
      bool22 = paramc.w();
    }
    while (((bool21) || (bool22)) && ((!bool21) || (!bool22) || (this.l != paramc.l)));
    return true;
  }

  public int b(c paramc)
  {
    int i1;
    if (!getClass().equals(paramc.getClass()))
      i1 = getClass().getName().compareTo(paramc.getClass().getName());
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
                                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
                                                  }
                                                  while (i1 != 0);
                                                  if (!c())
                                                    break;
                                                  i1 = org.a.c.c.a(this.a, paramc.a);
                                                }
                                                while (i1 != 0);
                                                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramc.e()));
                                              }
                                              while (i1 != 0);
                                              if (!e())
                                                break;
                                              i1 = org.a.c.c.a(this.b, paramc.b);
                                            }
                                            while (i1 != 0);
                                            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramc.g()));
                                          }
                                          while (i1 != 0);
                                          if (!g())
                                            break;
                                          i1 = org.a.c.c.a(this.c, paramc.c);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramc.i()));
                                      }
                                      while (i1 != 0);
                                      if (!i())
                                        break;
                                      i1 = org.a.c.c.a(this.d, paramc.d);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramc.k()));
                                  }
                                  while (i1 != 0);
                                  if (!k())
                                    break;
                                  i1 = org.a.c.c.a(this.e, paramc.e);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramc.m()));
                              }
                              while (i1 != 0);
                              if (!m())
                                break;
                              i1 = org.a.c.c.a(this.f, paramc.f);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramc.n()));
                          }
                          while (i1 != 0);
                          if (!n())
                            break;
                          i1 = org.a.c.c.a(this.g, paramc.g);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramc.p()));
                      }
                      while (i1 != 0);
                      if (!p())
                        break;
                      i1 = org.a.c.c.a(this.h, paramc.h);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramc.r()));
                  }
                  while (i1 != 0);
                  if (!r())
                    break;
                  i1 = org.a.c.c.a(this.i, paramc.i);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramc.t()));
              }
              while (i1 != 0);
              if (!t())
                break;
              i1 = org.a.c.c.a(this.j, paramc.j);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(paramc.u()));
          }
          while (i1 != 0);
          if (!u())
            break;
          i1 = org.a.c.c.a(this.k, paramc.k);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(paramc.w()));
      }
      while (i1 != 0);
      if (!w())
        break;
      i1 = org.a.c.c.a(this.l, paramc.l);
    }
    while (i1 != 0);
    return 0;
  }

  public c b(int paramInt)
  {
    this.h = paramInt;
    c(true);
    return this;
  }

  public c b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String b()
  {
    return this.a;
  }

  public void b(f paramf)
  {
    x();
    paramf.a(n);
    if (this.a != null)
    {
      paramf.a(o);
      paramf.a(this.a);
      paramf.b();
    }
    paramf.a(p);
    paramf.a(this.b);
    paramf.b();
    if ((this.c != null) && (g()))
    {
      paramf.a(q);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (i()))
    {
      paramf.a(r);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (k()))
    {
      paramf.a(s);
      paramf.a(this.e);
      paramf.b();
    }
    if (m())
    {
      paramf.a(t);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (n()))
    {
      paramf.a(u);
      paramf.a(this.g);
      paramf.b();
    }
    if (p())
    {
      paramf.a(v);
      paramf.a(this.h);
      paramf.b();
    }
    if (r())
    {
      paramf.a(w);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (t()))
    {
      paramf.a(x);
      paramf.a(new org.a.c.b.e(11, 11, this.j.size()));
      Iterator localIterator2 = this.j.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        paramf.a((String)localEntry2.getKey());
        paramf.a((String)localEntry2.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.k != null) && (u()))
    {
      paramf.a(y);
      paramf.a(new org.a.c.b.e(11, 11, this.k.size()));
      Iterator localIterator1 = this.k.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        paramf.a((String)localEntry1.getKey());
        paramf.a((String)localEntry1.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if (w())
    {
      paramf.a(z);
      paramf.a(this.l);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.A.set(1, paramBoolean);
  }

  public c c(int paramInt)
  {
    this.i = paramInt;
    d(true);
    return this;
  }

  public c c(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void c(boolean paramBoolean)
  {
    this.A.set(2, paramBoolean);
  }

  public boolean c()
  {
    return this.a != null;
  }

  public long d()
  {
    return this.b;
  }

  public c d(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public void d(boolean paramBoolean)
  {
    this.A.set(3, paramBoolean);
  }

  public void e(boolean paramBoolean)
  {
    this.A.set(4, paramBoolean);
  }

  public boolean e()
  {
    return this.A.get(0);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof c));
    return a((c)paramObject);
  }

  public String f()
  {
    return this.c;
  }

  public boolean g()
  {
    return this.c != null;
  }

  public String h()
  {
    return this.d;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.d != null;
  }

  public String j()
  {
    return this.e;
  }

  public boolean k()
  {
    return this.e != null;
  }

  public int l()
  {
    return this.f;
  }

  public boolean m()
  {
    return this.A.get(1);
  }

  public boolean n()
  {
    return this.g != null;
  }

  public int o()
  {
    return this.h;
  }

  public boolean p()
  {
    return this.A.get(2);
  }

  public int q()
  {
    return this.i;
  }

  public boolean r()
  {
    return this.A.get(3);
  }

  public Map<String, String> s()
  {
    return this.j;
  }

  public boolean t()
  {
    return this.j != null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMetaInfo(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("messageTs:");
      localStringBuilder.append(this.b);
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.c != null)
          break label440;
        localStringBuilder.append("null");
      }
      label97: if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("title:");
        if (this.d != null)
          break label452;
        localStringBuilder.append("null");
      }
      label135: if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("description:");
        if (this.e != null)
          break label464;
        localStringBuilder.append("null");
      }
      label173: if (m())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyType:");
        localStringBuilder.append(this.f);
      }
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("url:");
        if (this.g != null)
          break label476;
        localStringBuilder.append("null");
      }
      label243: if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("passThrough:");
        localStringBuilder.append(this.h);
      }
      if (r())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyId:");
        localStringBuilder.append(this.i);
      }
      if (t())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("extra:");
        if (this.j != null)
          break label488;
        localStringBuilder.append("null");
      }
      label345: if (u())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("internal:");
        if (this.k != null)
          break label500;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      if (w())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ignoreRegInfo:");
        localStringBuilder.append(this.l);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label440: localStringBuilder.append(this.c);
      break label97;
      label452: localStringBuilder.append(this.d);
      break label135;
      label464: localStringBuilder.append(this.e);
      break label173;
      label476: localStringBuilder.append(this.g);
      break label243;
      label488: localStringBuilder.append(this.j);
      break label345;
      label500: localStringBuilder.append(this.k);
    }
  }

  public boolean u()
  {
    return this.k != null;
  }

  public boolean v()
  {
    return this.l;
  }

  public boolean w()
  {
    return this.A.get(4);
  }

  public void x()
  {
    if (this.a == null)
      throw new g("Required field 'id' was not present! Struct: " + toString());
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
 * Qualified Name:     com.xiaomi.f.a.c
 * JD-Core Version:    0.6.0
 */