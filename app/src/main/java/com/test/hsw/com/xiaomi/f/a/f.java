package com.xiaomi.f.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.a.c.b.i;
import org.a.c.b.k;

public class f
  implements Serializable, Cloneable, org.a.c.b<f, a>
{
  public static final Map<a, org.a.c.a.b> i;
  private static final k j = new k("XmPushActionCommand");
  private static final org.a.c.b.c k = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c l = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c m = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c n = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c o = new org.a.c.b.c("cmdName", 11, 5);
  private static final org.a.c.b.c p = new org.a.c.b.c("cmdArgs", 15, 6);
  private static final org.a.c.b.c q = new org.a.c.b.c("packageName", 11, 7);
  private static final org.a.c.b.c r = new org.a.c.b.c("category", 11, 9);
  public String a;
  public d b;
  public String c;
  public String d;
  public String e;
  public List<String> f;
  public String g;
  public String h;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("cmdName", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("cmdArgs", 2, new org.a.c.a.d(15, new org.a.c.a.c(11))));
    localEnumMap.put(a.g, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(f.class, i);
  }

  public f a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void a(org.a.c.b.f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      i();
      return;
    }
    switch (localc.c)
    {
    case 8:
    default:
      i.a(paramf, localc.b);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 9:
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
      if (localc.b == 15)
      {
        org.a.c.b.d locald = paramf.m();
        this.f = new ArrayList(locald.b);
        for (int i1 = 0; i1 < locald.b; i1++)
        {
          String str = paramf.w();
          this.f.add(str);
        }
        paramf.n();
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

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(f paramf)
  {
    if (paramf == null);
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
                    bool2 = paramf.a();
                  }
                  while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramf.a))));
                  bool3 = b();
                  bool4 = paramf.b();
                }
                while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramf.b))));
                bool5 = c();
                bool6 = paramf.c();
              }
              while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramf.c))));
              bool7 = d();
              bool8 = paramf.d();
            }
            while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramf.d))));
            bool9 = e();
            bool10 = paramf.e();
          }
          while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramf.e))));
          bool11 = f();
          bool12 = paramf.f();
        }
        while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramf.f))));
        bool13 = g();
        bool14 = paramf.g();
      }
      while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramf.g))));
      bool15 = h();
      bool16 = paramf.h();
    }
    while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramf.h))));
    return true;
  }

  public int b(f paramf)
  {
    int i1;
    if (!getClass().equals(paramf.getClass()))
      i1 = getClass().getName().compareTo(paramf.getClass().getName());
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
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramf.a()));
                                  }
                                  while (i1 != 0);
                                  if (!a())
                                    break;
                                  i1 = org.a.c.c.a(this.a, paramf.a);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramf.b()));
                              }
                              while (i1 != 0);
                              if (!b())
                                break;
                              i1 = org.a.c.c.a(this.b, paramf.b);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramf.c()));
                          }
                          while (i1 != 0);
                          if (!c())
                            break;
                          i1 = org.a.c.c.a(this.c, paramf.c);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramf.d()));
                      }
                      while (i1 != 0);
                      if (!d())
                        break;
                      i1 = org.a.c.c.a(this.d, paramf.d);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramf.e()));
                  }
                  while (i1 != 0);
                  if (!e())
                    break;
                  i1 = org.a.c.c.a(this.e, paramf.e);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramf.f()));
              }
              while (i1 != 0);
              if (!f())
                break;
              i1 = org.a.c.c.a(this.f, paramf.f);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramf.g()));
          }
          while (i1 != 0);
          if (!g())
            break;
          i1 = org.a.c.c.a(this.g, paramf.g);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramf.h()));
      }
      while (i1 != 0);
      if (!h())
        break;
      i1 = org.a.c.c.a(this.h, paramf.h);
    }
    while (i1 != 0);
    return 0;
  }

  public f b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void b(org.a.c.b.f paramf)
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
    if (this.e != null)
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(p);
      paramf.a(new org.a.c.b.d(11, this.f.size()));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
        paramf.a((String)localIterator.next());
      paramf.e();
      paramf.b();
    }
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

  public f c(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public boolean c()
  {
    return this.c != null;
  }

  public void d(String paramString)
  {
    if (this.f == null)
      this.f = new ArrayList();
    this.f.add(paramString);
  }

  public boolean d()
  {
    return this.d != null;
  }

  public f e(String paramString)
  {
    this.g = paramString;
    return this;
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
    while (!(paramObject instanceof f));
    return a((f)paramObject);
  }

  public f f(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public boolean f()
  {
    return this.f != null;
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
    if (this.e == null)
      throw new org.a.c.b.g("Required field 'cmdName' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCommand(");
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
        break label411;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label325;
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
          break label351;
        localStringBuilder.append("null");
        label155: localStringBuilder.append(", ");
        localStringBuilder.append("cmdName:");
        if (this.e != null)
          break label363;
        localStringBuilder.append("null");
        label186: if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cmdArgs:");
          if (this.f != null)
            break label375;
          localStringBuilder.append("null");
        }
        label224: if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.g != null)
            break label387;
          localStringBuilder.append("null");
        }
        label262: if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.h != null)
            break label399;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label325: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label351: localStringBuilder.append(this.d);
        break label155;
        label363: localStringBuilder.append(this.e);
        break label186;
        label375: localStringBuilder.append(this.f);
        break label224;
        label387: localStringBuilder.append(this.g);
        break label262;
        label399: localStringBuilder.append(this.h);
      }
      label411: i1 = i2;
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
 * Qualified Name:     com.xiaomi.f.a.f
 * JD-Core Version:    0.6.0
 */