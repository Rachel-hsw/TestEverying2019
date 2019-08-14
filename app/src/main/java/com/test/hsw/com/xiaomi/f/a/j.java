package com.xiaomi.f.a;

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

public class j
  implements Serializable, Cloneable, org.a.c.b<j, a>
{
  public static final Map<a, org.a.c.a.b> k;
  private static final k l = new k("XmPushActionRegistration");
  private static final org.a.c.b.c m = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c n = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c o = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c p = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c q = new org.a.c.b.c("appVersion", 11, 5);
  private static final org.a.c.b.c r = new org.a.c.b.c("packageName", 11, 6);
  private static final org.a.c.b.c s = new org.a.c.b.c("token", 11, 7);
  private static final org.a.c.b.c t = new org.a.c.b.c("deviceId", 11, 8);
  private static final org.a.c.b.c u = new org.a.c.b.c("aliasName", 11, 9);
  private static final org.a.c.b.c v = new org.a.c.b.c("sdkVersion", 11, 10);
  public String a;
  public d b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("appVersion", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.g, new org.a.c.a.b("token", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("deviceId", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.i, new org.a.c.a.b("aliasName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.j, new org.a.c.a.b("sdkVersion", 2, new org.a.c.a.c(11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(j.class, k);
  }

  public j a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      m();
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
    return this.a != null;
  }

  public boolean a(j paramj)
  {
    if (paramj == null);
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
                        bool2 = paramj.a();
                      }
                      while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramj.a))));
                      bool3 = b();
                      bool4 = paramj.b();
                    }
                    while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramj.b))));
                    bool5 = c();
                    bool6 = paramj.c();
                  }
                  while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramj.c))));
                  bool7 = e();
                  bool8 = paramj.e();
                }
                while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramj.d))));
                bool9 = f();
                bool10 = paramj.f();
              }
              while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramj.e))));
              bool11 = g();
              bool12 = paramj.g();
            }
            while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramj.f))));
            bool13 = i();
            bool14 = paramj.i();
          }
          while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramj.g))));
          bool15 = j();
          bool16 = paramj.j();
        }
        while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramj.h))));
        bool17 = k();
        bool18 = paramj.k();
      }
      while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.i.equals(paramj.i))));
      bool19 = l();
      bool20 = paramj.l();
    }
    while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramj.j))));
    return true;
  }

  public int b(j paramj)
  {
    int i1;
    if (!getClass().equals(paramj.getClass()))
      i1 = getClass().getName().compareTo(paramj.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramj.a()));
                                          }
                                          while (i1 != 0);
                                          if (!a())
                                            break;
                                          i1 = org.a.c.c.a(this.a, paramj.a);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramj.b()));
                                      }
                                      while (i1 != 0);
                                      if (!b())
                                        break;
                                      i1 = org.a.c.c.a(this.b, paramj.b);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramj.c()));
                                  }
                                  while (i1 != 0);
                                  if (!c())
                                    break;
                                  i1 = org.a.c.c.a(this.c, paramj.c);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramj.e()));
                              }
                              while (i1 != 0);
                              if (!e())
                                break;
                              i1 = org.a.c.c.a(this.d, paramj.d);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramj.f()));
                          }
                          while (i1 != 0);
                          if (!f())
                            break;
                          i1 = org.a.c.c.a(this.e, paramj.e);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramj.g()));
                      }
                      while (i1 != 0);
                      if (!g())
                        break;
                      i1 = org.a.c.c.a(this.f, paramj.f);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramj.i()));
                  }
                  while (i1 != 0);
                  if (!i())
                    break;
                  i1 = org.a.c.c.a(this.g, paramj.g);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramj.j()));
              }
              while (i1 != 0);
              if (!j())
                break;
              i1 = org.a.c.c.a(this.h, paramj.h);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramj.k()));
          }
          while (i1 != 0);
          if (!k())
            break;
          i1 = org.a.c.c.a(this.i, paramj.i);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramj.l()));
      }
      while (i1 != 0);
      if (!l())
        break;
      i1 = org.a.c.c.a(this.j, paramj.j);
    }
    while (i1 != 0);
    return 0;
  }

  public j b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void b(f paramf)
  {
    m();
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
    if (this.d != null)
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (f()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (g()))
    {
      paramf.a(r);
      paramf.a(this.f);
      paramf.b();
    }
    if (this.g != null)
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (j()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (k()))
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (l()))
    {
      paramf.a(v);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.b != null;
  }

  public j c(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public boolean c()
  {
    return this.c != null;
  }

  public j d(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public String d()
  {
    return this.d;
  }

  public j e(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public boolean e()
  {
    return this.d != null;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof j));
    return a((j)paramObject);
  }

  public j f(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public boolean f()
  {
    return this.e != null;
  }

  public boolean g()
  {
    return this.f != null;
  }

  public String h()
  {
    return this.g;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.g != null;
  }

  public boolean j()
  {
    return this.h != null;
  }

  public boolean k()
  {
    return this.i != null;
  }

  public boolean l()
  {
    return this.j != null;
  }

  public void m()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
    if (this.g == null)
      throw new org.a.c.b.g("Required field 'token' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionRegistration(");
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
        break label511;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label401;
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
          break label427;
        localStringBuilder.append("null");
        label155: if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersion:");
          if (this.e != null)
            break label439;
          localStringBuilder.append("null");
        }
        label193: if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null)
            break label451;
          localStringBuilder.append("null");
        }
        label231: localStringBuilder.append(", ");
        localStringBuilder.append("token:");
        if (this.g != null)
          break label463;
        localStringBuilder.append("null");
        label262: if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.h != null)
            break label475;
          localStringBuilder.append("null");
        }
        label300: if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.i != null)
            break label487;
          localStringBuilder.append("null");
        }
        label338: if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("sdkVersion:");
          if (this.j != null)
            break label499;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label401: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label427: localStringBuilder.append(this.d);
        break label155;
        label439: localStringBuilder.append(this.e);
        break label193;
        label451: localStringBuilder.append(this.f);
        break label231;
        label463: localStringBuilder.append(this.g);
        break label262;
        label475: localStringBuilder.append(this.h);
        break label300;
        label487: localStringBuilder.append(this.i);
        break label338;
        label499: localStringBuilder.append(this.j);
      }
      label511: i1 = i2;
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
 * Qualified Name:     com.xiaomi.f.a.j
 * JD-Core Version:    0.6.0
 */