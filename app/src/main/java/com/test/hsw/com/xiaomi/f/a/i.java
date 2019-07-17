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
import org.a.c.b.k;

public class i
  implements Serializable, Cloneable, org.a.c.b<i, a>
{
  public static final Map<a, org.a.c.a.b> k;
  private static final k l = new k("XmPushActionNotification");
  private static final org.a.c.b.c m = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c n = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c o = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c p = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c q = new org.a.c.b.c("type", 11, 5);
  private static final org.a.c.b.c r = new org.a.c.b.c("requireAck", 2, 6);
  private static final org.a.c.b.c s = new org.a.c.b.c("payload", 11, 7);
  private static final org.a.c.b.c t = new org.a.c.b.c("extra", 13, 8);
  private static final org.a.c.b.c u = new org.a.c.b.c("packageName", 11, 9);
  private static final org.a.c.b.c v = new org.a.c.b.c("category", 11, 10);
  public String a;
  public d b;
  public String c;
  public String d;
  public String e;
  public boolean f = true;
  public String g;
  public Map<String, String> h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("type", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("requireAck", 1, new org.a.c.a.c(2)));
    localEnumMap.put(a.g, new org.a.c.a.b("payload", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("extra", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(11))));
    localEnumMap.put(a.i, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.j, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(i.class, k);
  }

  public i a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public i a(Map<String, String> paramMap)
  {
    this.h = paramMap;
    return this;
  }

  public i a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    b(true);
    return this;
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!f())
        throw new org.a.c.b.g("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
    }
    else
    {
      switch (localc.c)
      {
      default:
        org.a.c.b.i.a(paramf, localc.b);
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
        if (localc.b == 11)
        {
          this.a = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 12)
        {
          this.b = new d();
          this.b.a(paramf);
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.c = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.d = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.e = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 2)
        {
          this.f = paramf.q();
          b(true);
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.g = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 13)
        {
          org.a.c.b.e locale = paramf.k();
          this.h = new HashMap(2 * locale.c);
          for (int i1 = 0; i1 < locale.c; i1++)
          {
            String str1 = paramf.w();
            String str2 = paramf.w();
            this.h.put(str1, str2);
          }
          paramf.l();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.i = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.j = paramf.w();
          continue;
        }
        org.a.c.b.i.a(paramf, localc.b);
      }
    }
    l();
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(i parami)
  {
    if (parami == null);
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
                      bool2 = parami.a();
                    }
                    while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(parami.a))));
                    bool3 = b();
                    bool4 = parami.b();
                  }
                  while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(parami.b))));
                  bool5 = c();
                  bool6 = parami.c();
                }
                while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(parami.c))));
                bool7 = d();
                bool8 = parami.d();
              }
              while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(parami.d))));
              bool9 = e();
              bool10 = parami.e();
            }
            while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(parami.e)) || (this.f != parami.f)));
            bool11 = g();
            bool12 = parami.g();
          }
          while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(parami.g))));
          bool13 = i();
          bool14 = parami.i();
        }
        while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(parami.h))));
        bool15 = j();
        bool16 = parami.j();
      }
      while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.i.equals(parami.i))));
      bool17 = k();
      bool18 = parami.k();
    }
    while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(parami.j))));
    return true;
  }

  public int b(i parami)
  {
    int i1;
    if (!getClass().equals(parami.getClass()))
      i1 = getClass().getName().compareTo(parami.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parami.a()));
                                          }
                                          while (i1 != 0);
                                          if (!a())
                                            break;
                                          i1 = org.a.c.c.a(this.a, parami.a);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parami.b()));
                                      }
                                      while (i1 != 0);
                                      if (!b())
                                        break;
                                      i1 = org.a.c.c.a(this.b, parami.b);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parami.c()));
                                  }
                                  while (i1 != 0);
                                  if (!c())
                                    break;
                                  i1 = org.a.c.c.a(this.c, parami.c);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parami.d()));
                              }
                              while (i1 != 0);
                              if (!d())
                                break;
                              i1 = org.a.c.c.a(this.d, parami.d);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(parami.e()));
                          }
                          while (i1 != 0);
                          if (!e())
                            break;
                          i1 = org.a.c.c.a(this.e, parami.e);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(parami.f()));
                      }
                      while (i1 != 0);
                      if (!f())
                        break;
                      i1 = org.a.c.c.a(this.f, parami.f);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(parami.g()));
                  }
                  while (i1 != 0);
                  if (!g())
                    break;
                  i1 = org.a.c.c.a(this.g, parami.g);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(parami.i()));
              }
              while (i1 != 0);
              if (!i())
                break;
              i1 = org.a.c.c.a(this.h, parami.h);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(parami.j()));
          }
          while (i1 != 0);
          if (!j())
            break;
          i1 = org.a.c.c.a(this.i, parami.i);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(parami.k()));
      }
      while (i1 != 0);
      if (!k())
        break;
      i1 = org.a.c.c.a(this.j, parami.j);
    }
    while (i1 != 0);
    return 0;
  }

  public i b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void b(f paramf)
  {
    l();
    paramf.a(l);
    if ((this.a != null) && (a()))
    {
      paramf.a(m);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(n);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(o);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (d()))
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
    paramf.a(r);
    paramf.a(this.f);
    paramf.b();
    if ((this.g != null) && (g()))
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (i()))
    {
      paramf.a(t);
      paramf.a(new org.a.c.b.e(11, 11, this.h.size()));
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.i != null) && (j()))
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (k()))
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
    this.w.set(0, paramBoolean);
  }

  public boolean b()
  {
    return this.b != null;
  }

  public i c(String paramString)
  {
    this.e = paramString;
    return this;
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
    while (!(paramObject instanceof i));
    return a((i)paramObject);
  }

  public boolean f()
  {
    return this.w.get(0);
  }

  public boolean g()
  {
    return this.g != null;
  }

  public Map<String, String> h()
  {
    return this.h;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.h != null;
  }

  public boolean j()
  {
    return this.i != null;
  }

  public boolean k()
  {
    return this.j != null;
  }

  public void l()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionNotification(");
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
        break label500;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label402;
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
        label124: if (d())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appId:");
          if (this.d != null)
            break label428;
          localStringBuilder.append("null");
        }
        label162: if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("type:");
          if (this.e != null)
            break label440;
          localStringBuilder.append("null");
        }
        label200: localStringBuilder.append(", ");
        localStringBuilder.append("requireAck:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("payload:");
          if (this.g != null)
            break label452;
          localStringBuilder.append("null");
        }
        label263: if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("extra:");
          if (this.h != null)
            break label464;
          localStringBuilder.append("null");
        }
        label301: if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null)
            break label476;
          localStringBuilder.append("null");
        }
        label339: if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null)
            break label488;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label402: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label428: localStringBuilder.append(this.d);
        break label162;
        label440: localStringBuilder.append(this.e);
        break label200;
        label452: localStringBuilder.append(this.g);
        break label263;
        label464: localStringBuilder.append(this.h);
        break label301;
        label476: localStringBuilder.append(this.i);
        break label339;
        label488: localStringBuilder.append(this.j);
      }
      label500: i1 = i2;
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
 * Qualified Name:     com.xiaomi.f.a.i
 * JD-Core Version:    0.6.0
 */