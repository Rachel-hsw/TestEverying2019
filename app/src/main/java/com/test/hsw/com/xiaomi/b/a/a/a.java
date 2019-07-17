package com.xiaomi.b.a.a;

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

public class a
  implements Serializable, Cloneable, org.a.c.b<a, a>
{
  public static final Map<a, org.a.c.a.b> f;
  private static final k g = new k("Common");
  private static final org.a.c.b.c h = new org.a.c.b.c("uuid", 10, 1);
  private static final org.a.c.b.c i = new org.a.c.b.c("time", 11, 2);
  private static final org.a.c.b.c j = new org.a.c.b.c("clientIp", 11, 3);
  private static final org.a.c.b.c k = new org.a.c.b.c("serverIp", 11, 4);
  private static final org.a.c.b.c l = new org.a.c.b.c("serverHost", 11, 5);
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  private BitSet m = new BitSet(1);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("uuid", 2, new org.a.c.a.c(10)));
    localEnumMap.put(a.b, new org.a.c.a.b("time", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("clientIp", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("serverIp", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("serverHost", 2, new org.a.c.a.c(11)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(a.class, f);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      f();
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
    }
    while (true)
    {
      paramf.j();
      break;
      if (localc.b == 10)
      {
        this.a = paramf.u();
        a(true);
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
      if (localc.b == 11)
      {
        this.e = paramf.w();
        continue;
      }
      i.a(paramf, localc.b);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.m.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.m.get(0);
  }

  public boolean a(a parama)
  {
    if (parama == null);
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
              bool2 = parama.a();
            }
            while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.a != parama.a)));
            bool3 = b();
            bool4 = parama.b();
          }
          while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(parama.b))));
          bool5 = c();
          bool6 = parama.c();
        }
        while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(parama.c))));
        bool7 = d();
        bool8 = parama.d();
      }
      while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(parama.d))));
      bool9 = e();
      bool10 = parama.e();
    }
    while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(parama.e))));
    return true;
  }

  public int b(a parama)
  {
    int n;
    if (!getClass().equals(parama.getClass()))
      n = getClass().getName().compareTo(parama.getClass().getName());
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
                        return n;
                        n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parama.a()));
                      }
                      while (n != 0);
                      if (!a())
                        break;
                      n = org.a.c.c.a(this.a, parama.a);
                    }
                    while (n != 0);
                    n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parama.b()));
                  }
                  while (n != 0);
                  if (!b())
                    break;
                  n = org.a.c.c.a(this.b, parama.b);
                }
                while (n != 0);
                n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parama.c()));
              }
              while (n != 0);
              if (!c())
                break;
              n = org.a.c.c.a(this.c, parama.c);
            }
            while (n != 0);
            n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parama.d()));
          }
          while (n != 0);
          if (!d())
            break;
          n = org.a.c.c.a(this.d, parama.d);
        }
        while (n != 0);
        n = Boolean.valueOf(e()).compareTo(Boolean.valueOf(parama.e()));
      }
      while (n != 0);
      if (!e())
        break;
      n = org.a.c.c.a(this.e, parama.e);
    }
    while (n != 0);
    return 0;
  }

  public void b(f paramf)
  {
    f();
    paramf.a(g);
    if (a())
    {
      paramf.a(h);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(i);
      paramf.a(this.b);
      paramf.b();
    }
    if ((this.c != null) && (c()))
    {
      paramf.a(j);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (d()))
    {
      paramf.a(k);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(l);
      paramf.a(this.e);
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
    while (!(paramObject instanceof a));
    return a((a)paramObject);
  }

  public void f()
  {
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    int n = 0;
    StringBuilder localStringBuilder = new StringBuilder("Common(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("uuid:");
      localStringBuilder.append(this.a);
      i1 = 0;
    }
    if (b())
    {
      if (i1 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("time:");
      if (this.b == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (c())
      {
        if (i1 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("clientIp:");
        if (this.c != null)
          break label238;
        localStringBuilder.append("null");
        label127: i1 = 0;
      }
      if (!d())
        break label276;
      if (i1 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("serverIp:");
      if (this.d != null)
        break label250;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label171: if (e())
      {
        if (n == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("serverHost:");
        if (this.e != null)
          break label264;
        localStringBuilder.append("null");
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.b);
        break;
        label238: localStringBuilder.append(this.c);
        break label127;
        label250: localStringBuilder.append(this.d);
        n = 0;
        break label171;
        label264: localStringBuilder.append(this.e);
      }
      label276: n = i1;
    }
  }

  public static enum a
  {
    private static final Map<String, a> f;
    private final short g;
    private final String h;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      i = arrayOfa;
      f = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.g = paramShort;
      this.h = paramString;
    }

    public String a()
    {
      return this.h;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.b.a.a.a
 * JD-Core Version:    0.6.0
 */