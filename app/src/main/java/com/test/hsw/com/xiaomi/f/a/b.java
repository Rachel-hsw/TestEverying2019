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

public class b
  implements Serializable, Cloneable, org.a.c.b<b, a>
{
  public static final Map<a, org.a.c.a.b> i;
  private static final k j = new k("PushMessage");
  private static final org.a.c.b.c k = new org.a.c.b.c("to", 12, 1);
  private static final org.a.c.b.c l = new org.a.c.b.c("id", 11, 2);
  private static final org.a.c.b.c m = new org.a.c.b.c("appId", 11, 3);
  private static final org.a.c.b.c n = new org.a.c.b.c("payload", 11, 4);
  private static final org.a.c.b.c o = new org.a.c.b.c("createAt", 10, 5);
  private static final org.a.c.b.c p = new org.a.c.b.c("ttl", 10, 6);
  private static final org.a.c.b.c q = new org.a.c.b.c("collapseKey", 11, 7);
  private static final org.a.c.b.c r = new org.a.c.b.c("packageName", 11, 8);
  public d a;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(2);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("to", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.b, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("payload", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("createAt", 2, new org.a.c.a.c(10)));
    localEnumMap.put(a.f, new org.a.c.a.b("ttl", 2, new org.a.c.a.c(10)));
    localEnumMap.put(a.g, new org.a.c.a.b("collapseKey", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.h, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(b.class, i);
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
    }
    while (true)
    {
      paramf.j();
      break;
      if (localc.b == 12)
      {
        this.a = new d();
        this.a.a(paramf);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 11)
      {
        this.b = paramf.w();
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
      if (localc.b == 10)
      {
        this.e = paramf.u();
        a(true);
        continue;
      }
      i.a(paramf, localc.b);
      continue;
      if (localc.b == 10)
      {
        this.f = paramf.u();
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
      if (localc.b == 11)
      {
        this.h = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(b paramb)
  {
    if (paramb == null);
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
                    bool2 = paramb.a();
                  }
                  while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.a(paramb.a))));
                  bool3 = c();
                  bool4 = paramb.c();
                }
                while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(paramb.b))));
                bool5 = e();
                bool6 = paramb.e();
              }
              while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramb.c))));
              bool7 = g();
              bool8 = paramb.g();
            }
            while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramb.d))));
            bool9 = i();
            bool10 = paramb.i();
          }
          while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (this.e != paramb.e)));
          bool11 = j();
          bool12 = paramb.j();
        }
        while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (this.f != paramb.f)));
        bool13 = k();
        bool14 = paramb.k();
      }
      while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramb.g))));
      bool15 = l();
      bool16 = paramb.l();
    }
    while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramb.h))));
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
                                    return i1;
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramb.a()));
                                  }
                                  while (i1 != 0);
                                  if (!a())
                                    break;
                                  i1 = org.a.c.c.a(this.a, paramb.a);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramb.c()));
                              }
                              while (i1 != 0);
                              if (!c())
                                break;
                              i1 = org.a.c.c.a(this.b, paramb.b);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramb.e()));
                          }
                          while (i1 != 0);
                          if (!e())
                            break;
                          i1 = org.a.c.c.a(this.c, paramb.c);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramb.g()));
                      }
                      while (i1 != 0);
                      if (!g())
                        break;
                      i1 = org.a.c.c.a(this.d, paramb.d);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramb.i()));
                  }
                  while (i1 != 0);
                  if (!i())
                    break;
                  i1 = org.a.c.c.a(this.e, paramb.e);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramb.j()));
              }
              while (i1 != 0);
              if (!j())
                break;
              i1 = org.a.c.c.a(this.f, paramb.f);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramb.k()));
          }
          while (i1 != 0);
          if (!k())
            break;
          i1 = org.a.c.c.a(this.g, paramb.g);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramb.l()));
      }
      while (i1 != 0);
      if (!l())
        break;
      i1 = org.a.c.c.a(this.h, paramb.h);
    }
    while (i1 != 0);
    return 0;
  }

  public String b()
  {
    return this.b;
  }

  public void b(f paramf)
  {
    m();
    paramf.a(j);
    if ((this.a != null) && (a()))
    {
      paramf.a(k);
      this.a.b(paramf);
      paramf.b();
    }
    if (this.b != null)
    {
      paramf.a(l);
      paramf.a(this.b);
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
    if (i())
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if (j())
    {
      paramf.a(p);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (k()))
    {
      paramf.a(q);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (l()))
    {
      paramf.a(r);
      paramf.a(this.h);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }

  public boolean c()
  {
    return this.b != null;
  }

  public String d()
  {
    return this.c;
  }

  public boolean e()
  {
    return this.c != null;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof b));
    return a((b)paramObject);
  }

  public String f()
  {
    return this.d;
  }

  public boolean g()
  {
    return this.d != null;
  }

  public long h()
  {
    return this.e;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.s.get(0);
  }

  public boolean j()
  {
    return this.s.get(1);
  }

  public boolean k()
  {
    return this.g != null;
  }

  public boolean l()
  {
    return this.h != null;
  }

  public void m()
  {
    if (this.b == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'payload' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMessage(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("to:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (i1 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("id:");
      if (this.b != null)
        break label307;
      localStringBuilder.append("null");
      label80: localStringBuilder.append(", ");
      localStringBuilder.append("appId:");
      if (this.c != null)
        break label319;
      localStringBuilder.append("null");
      label111: localStringBuilder.append(", ");
      localStringBuilder.append("payload:");
      if (this.d != null)
        break label331;
      localStringBuilder.append("null");
      label142: if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("createAt:");
        localStringBuilder.append(this.e);
      }
      if (j())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ttl:");
        localStringBuilder.append(this.f);
      }
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("collapseKey:");
        if (this.g != null)
          break label343;
        localStringBuilder.append("null");
      }
      label244: if (l())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.h != null)
          break label355;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label307: localStringBuilder.append(this.b);
      break label80;
      label319: localStringBuilder.append(this.c);
      break label111;
      label331: localStringBuilder.append(this.d);
      break label142;
      label343: localStringBuilder.append(this.g);
      break label244;
      label355: localStringBuilder.append(this.h);
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
 * Qualified Name:     com.xiaomi.f.a.b
 * JD-Core Version:    0.6.0
 */