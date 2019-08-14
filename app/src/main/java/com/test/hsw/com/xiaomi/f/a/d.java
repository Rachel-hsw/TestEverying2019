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
import org.a.c.b.g;
import org.a.c.b.i;
import org.a.c.b.k;

public class d
  implements Serializable, Cloneable, org.a.c.b<d, a>
{
  public static final Map<a, org.a.c.a.b> f;
  private static final k g = new k("Target");
  private static final org.a.c.b.c h = new org.a.c.b.c("channelId", 10, 1);
  private static final org.a.c.b.c i = new org.a.c.b.c("userId", 11, 2);
  private static final org.a.c.b.c j = new org.a.c.b.c("server", 11, 3);
  private static final org.a.c.b.c k = new org.a.c.b.c("resource", 11, 4);
  private static final org.a.c.b.c l = new org.a.c.b.c("isPreview", 2, 5);
  public long a = 5L;
  public String b;
  public String c = "xiaomi.com";
  public String d = "";
  public boolean e = false;
  private BitSet m = new BitSet(2);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("channelId", 1, new org.a.c.a.c(10)));
    localEnumMap.put(a.b, new org.a.c.a.b("userId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.c, new org.a.c.a.b("server", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("resource", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("isPreview", 2, new org.a.c.a.c(2)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(d.class, f);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!a())
        throw new g("Required field 'channelId' was not found in serialized data! Struct: " + toString());
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
        if (localc.b == 2)
        {
          this.e = paramf.q();
          b(true);
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    f();
  }

  public void a(boolean paramBoolean)
  {
    this.m.set(0, paramBoolean);
  }

  public boolean a()
  {
    return this.m.get(0);
  }

  public boolean a(d paramd)
  {
    if (paramd == null);
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
            do
              return false;
            while (this.a != paramd.a);
            bool1 = b();
            bool2 = paramd.b();
          }
          while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramd.b))));
          bool3 = c();
          bool4 = paramd.c();
        }
        while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.c.equals(paramd.c))));
        bool5 = d();
        bool6 = paramd.d();
      }
      while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.d.equals(paramd.d))));
      bool7 = e();
      bool8 = paramd.e();
    }
    while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (this.e != paramd.e)));
    return true;
  }

  public int b(d paramd)
  {
    int n;
    if (!getClass().equals(paramd.getClass()))
      n = getClass().getName().compareTo(paramd.getClass().getName());
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
                        n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramd.a()));
                      }
                      while (n != 0);
                      if (!a())
                        break;
                      n = org.a.c.c.a(this.a, paramd.a);
                    }
                    while (n != 0);
                    n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramd.b()));
                  }
                  while (n != 0);
                  if (!b())
                    break;
                  n = org.a.c.c.a(this.b, paramd.b);
                }
                while (n != 0);
                n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramd.c()));
              }
              while (n != 0);
              if (!c())
                break;
              n = org.a.c.c.a(this.c, paramd.c);
            }
            while (n != 0);
            n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramd.d()));
          }
          while (n != 0);
          if (!d())
            break;
          n = org.a.c.c.a(this.d, paramd.d);
        }
        while (n != 0);
        n = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramd.e()));
      }
      while (n != 0);
      if (!e())
        break;
      n = org.a.c.c.a(this.e, paramd.e);
    }
    while (n != 0);
    return 0;
  }

  public void b(f paramf)
  {
    f();
    paramf.a(g);
    paramf.a(h);
    paramf.a(this.a);
    paramf.b();
    if (this.b != null)
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
    if (e())
    {
      paramf.a(l);
      paramf.a(this.e);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.m.set(1, paramBoolean);
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
    return this.m.get(1);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof d));
    return a((d)paramObject);
  }

  public void f()
  {
    if (this.b == null)
      throw new g("Required field 'userId' was not present! Struct: " + toString());
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Target(");
    localStringBuilder.append("channelId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("userId:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("server:");
        if (this.c != null)
          break label192;
        localStringBuilder.append("null");
      }
      label97: if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("resource:");
        if (this.d != null)
          break label204;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("isPreview:");
        localStringBuilder.append(this.e);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label192: localStringBuilder.append(this.c);
      break label97;
      label204: localStringBuilder.append(this.d);
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
 * Qualified Name:     com.xiaomi.f.a.d
 * JD-Core Version:    0.6.0
 */