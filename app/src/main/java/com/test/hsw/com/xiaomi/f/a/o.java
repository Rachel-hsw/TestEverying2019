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

public class o
  implements Serializable, Cloneable, org.a.c.b<o, a>
{
  public static final Map<a, org.a.c.a.b> h;
  private static final k i = new k("XmPushActionSubscription");
  private static final org.a.c.b.c j = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c k = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c l = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c m = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c n = new org.a.c.b.c("topic", 11, 5);
  private static final org.a.c.b.c o = new org.a.c.b.c("packageName", 11, 6);
  private static final org.a.c.b.c p = new org.a.c.b.c("category", 11, 7);
  public String a;
  public d b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("topic", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.g, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    h = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(o.class, h);
  }

  public o a(String paramString)
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
      h();
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
    }
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(o paramo)
  {
    if (paramo == null);
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
                  bool2 = paramo.a();
                }
                while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramo.a))));
                bool3 = b();
                bool4 = paramo.b();
              }
              while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramo.b))));
              bool5 = c();
              bool6 = paramo.c();
            }
            while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramo.c))));
            bool7 = d();
            bool8 = paramo.d();
          }
          while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramo.d))));
          bool9 = e();
          bool10 = paramo.e();
        }
        while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramo.e))));
        bool11 = f();
        bool12 = paramo.f();
      }
      while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramo.f))));
      bool13 = g();
      bool14 = paramo.g();
    }
    while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramo.g))));
    return true;
  }

  public int b(o paramo)
  {
    int i1;
    if (!getClass().equals(paramo.getClass()))
      i1 = getClass().getName().compareTo(paramo.getClass().getName());
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
                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramo.a()));
                              }
                              while (i1 != 0);
                              if (!a())
                                break;
                              i1 = org.a.c.c.a(this.a, paramo.a);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramo.b()));
                          }
                          while (i1 != 0);
                          if (!b())
                            break;
                          i1 = org.a.c.c.a(this.b, paramo.b);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramo.c()));
                      }
                      while (i1 != 0);
                      if (!c())
                        break;
                      i1 = org.a.c.c.a(this.c, paramo.c);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramo.d()));
                  }
                  while (i1 != 0);
                  if (!d())
                    break;
                  i1 = org.a.c.c.a(this.d, paramo.d);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramo.e()));
              }
              while (i1 != 0);
              if (!e())
                break;
              i1 = org.a.c.c.a(this.e, paramo.e);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramo.f()));
          }
          while (i1 != 0);
          if (!f())
            break;
          i1 = org.a.c.c.a(this.f, paramo.f);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramo.g()));
      }
      while (i1 != 0);
      if (!g())
        break;
      i1 = org.a.c.c.a(this.g, paramo.g);
    }
    while (i1 != 0);
    return 0;
  }

  public o b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void b(f paramf)
  {
    h();
    paramf.a(i);
    if ((this.a != null) && (a()))
    {
      paramf.a(j);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(k);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(l);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(m);
      paramf.a(this.d);
      paramf.b();
    }
    if (this.e != null)
    {
      paramf.a(n);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(o);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (g()))
    {
      paramf.a(p);
      paramf.a(this.g);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public boolean b()
  {
    return this.b != null;
  }

  public o c(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public boolean c()
  {
    return this.c != null;
  }

  public o d(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public boolean d()
  {
    return this.d != null;
  }

  public o e(String paramString)
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
    while (!(paramObject instanceof o));
    return a((o)paramObject);
  }

  public boolean f()
  {
    return this.f != null;
  }

  public boolean g()
  {
    return this.g != null;
  }

  public void h()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
    if (this.e == null)
      throw new org.a.c.b.g("Required field 'topic' was not present! Struct: " + toString());
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSubscription(");
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
        break label361;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label287;
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
          break label313;
        localStringBuilder.append("null");
        label155: localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.e != null)
          break label325;
        localStringBuilder.append("null");
        label186: if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null)
            break label337;
          localStringBuilder.append("null");
        }
        label224: if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.g != null)
            break label349;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label287: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label313: localStringBuilder.append(this.d);
        break label155;
        label325: localStringBuilder.append(this.e);
        break label186;
        label337: localStringBuilder.append(this.f);
        break label224;
        label349: localStringBuilder.append(this.g);
      }
      label361: i1 = i2;
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
 * Qualified Name:     com.xiaomi.f.a.o
 * JD-Core Version:    0.6.0
 */