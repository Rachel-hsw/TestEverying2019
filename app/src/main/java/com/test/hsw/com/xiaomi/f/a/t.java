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

public class t
  implements Serializable, Cloneable, org.a.c.b<t, a>
{
  public static final Map<a, org.a.c.a.b> k;
  private static final k l = new k("XmPushActionUnSubscriptionResult");
  private static final org.a.c.b.c m = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c n = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c o = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c p = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c q = new org.a.c.b.c("request", 12, 5);
  private static final org.a.c.b.c r = new org.a.c.b.c("errorCode", 10, 6);
  private static final org.a.c.b.c s = new org.a.c.b.c("reason", 11, 7);
  private static final org.a.c.b.c t = new org.a.c.b.c("topic", 11, 8);
  private static final org.a.c.b.c u = new org.a.c.b.c("packageName", 11, 9);
  private static final org.a.c.b.c v = new org.a.c.b.c("category", 11, 10);
  public String a;
  public d b;
  public String c;
  public String d;
  public s e;
  public long f;
  public String g;
  public String h;
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
    localEnumMap.put(a.e, new org.a.c.a.b("request", 2, new org.a.c.a.g(12, s.class)));
    localEnumMap.put(a.f, new org.a.c.a.b("errorCode", 2, new org.a.c.a.c(10)));
    localEnumMap.put(a.g, new org.a.c.a.b("reason", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("topic", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.i, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.j, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(t.class, k);
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
      if (localc.b == 12)
      {
        this.e = new s();
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

  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(t paramt)
  {
    if (paramt == null);
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
                        bool2 = paramt.a();
                      }
                      while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramt.a))));
                      bool3 = b();
                      bool4 = paramt.b();
                    }
                    while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramt.b))));
                    bool5 = c();
                    bool6 = paramt.c();
                  }
                  while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramt.c))));
                  bool7 = d();
                  bool8 = paramt.d();
                }
                while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramt.d))));
                bool9 = e();
                bool10 = paramt.e();
              }
              while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.a(paramt.e))));
              bool11 = f();
              bool12 = paramt.f();
            }
            while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (this.f != paramt.f)));
            bool13 = g();
            bool14 = paramt.g();
          }
          while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramt.g))));
          bool15 = i();
          bool16 = paramt.i();
        }
        while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramt.h))));
        bool17 = j();
        bool18 = paramt.j();
      }
      while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.i.equals(paramt.i))));
      bool19 = l();
      bool20 = paramt.l();
    }
    while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramt.j))));
    return true;
  }

  public int b(t paramt)
  {
    int i1;
    if (!getClass().equals(paramt.getClass()))
      i1 = getClass().getName().compareTo(paramt.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramt.a()));
                                          }
                                          while (i1 != 0);
                                          if (!a())
                                            break;
                                          i1 = org.a.c.c.a(this.a, paramt.a);
                                        }
                                        while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramt.b()));
                                      }
                                      while (i1 != 0);
                                      if (!b())
                                        break;
                                      i1 = org.a.c.c.a(this.b, paramt.b);
                                    }
                                    while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramt.c()));
                                  }
                                  while (i1 != 0);
                                  if (!c())
                                    break;
                                  i1 = org.a.c.c.a(this.c, paramt.c);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramt.d()));
                              }
                              while (i1 != 0);
                              if (!d())
                                break;
                              i1 = org.a.c.c.a(this.d, paramt.d);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramt.e()));
                          }
                          while (i1 != 0);
                          if (!e())
                            break;
                          i1 = org.a.c.c.a(this.e, paramt.e);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramt.f()));
                      }
                      while (i1 != 0);
                      if (!f())
                        break;
                      i1 = org.a.c.c.a(this.f, paramt.f);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramt.g()));
                  }
                  while (i1 != 0);
                  if (!g())
                    break;
                  i1 = org.a.c.c.a(this.g, paramt.g);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramt.i()));
              }
              while (i1 != 0);
              if (!i())
                break;
              i1 = org.a.c.c.a(this.h, paramt.h);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramt.j()));
          }
          while (i1 != 0);
          if (!j())
            break;
          i1 = org.a.c.c.a(this.i, paramt.i);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramt.l()));
      }
      while (i1 != 0);
      if (!l())
        break;
      i1 = org.a.c.c.a(this.j, paramt.j);
    }
    while (i1 != 0);
    return 0;
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
    if ((this.d != null) && (d()))
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(q);
      this.e.b(paramf);
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
    if ((this.h != null) && (i()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (j()))
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
    while (!(paramObject instanceof t));
    return a((t)paramObject);
  }

  public boolean f()
  {
    return this.w.get(0);
  }

  public boolean g()
  {
    return this.g != null;
  }

  public String h()
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

  public String k()
  {
    return this.j;
  }

  public boolean l()
  {
    return this.j != null;
  }

  public void m()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        break label507;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label409;
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
            break label435;
          localStringBuilder.append("null");
        }
        label162: if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null)
            break label447;
          localStringBuilder.append("null");
        }
        label200: if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("errorCode:");
          localStringBuilder.append(this.f);
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null)
            break label459;
          localStringBuilder.append("null");
        }
        label270: if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.h != null)
            break label471;
          localStringBuilder.append("null");
        }
        label308: if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null)
            break label483;
          localStringBuilder.append("null");
        }
        label346: if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null)
            break label495;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label409: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label435: localStringBuilder.append(this.d);
        break label162;
        label447: localStringBuilder.append(this.e);
        break label200;
        label459: localStringBuilder.append(this.g);
        break label270;
        label471: localStringBuilder.append(this.h);
        break label308;
        label483: localStringBuilder.append(this.i);
        break label346;
        label495: localStringBuilder.append(this.j);
      }
      label507: i1 = i2;
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
 * Qualified Name:     com.xiaomi.f.a.t
 * JD-Core Version:    0.6.0
 */