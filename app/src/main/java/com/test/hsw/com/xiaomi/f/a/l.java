package com.xiaomi.f.a;

import java.io.Serializable;
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

public class l
  implements Serializable, Cloneable, org.a.c.b<l, a>
{
  public static final Map<a, org.a.c.a.b> g;
  private static final k h = new k("XmPushActionSendFeedback");
  private static final org.a.c.b.c i = new org.a.c.b.c("debug", 11, 1);
  private static final org.a.c.b.c j = new org.a.c.b.c("target", 12, 2);
  private static final org.a.c.b.c k = new org.a.c.b.c("id", 11, 3);
  private static final org.a.c.b.c l = new org.a.c.b.c("appId", 11, 4);
  private static final org.a.c.b.c m = new org.a.c.b.c("feedbacks", 13, 5);
  private static final org.a.c.b.c n = new org.a.c.b.c("category", 11, 6);
  public String a;
  public d b;
  public String c;
  public String d;
  public Map<String, String> e;
  public String f;

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("debug", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.b, new org.a.c.a.b("target", 2, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.c, new org.a.c.a.b("id", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.d, new org.a.c.a.b("appId", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("feedbacks", 2, new org.a.c.a.e(13, new org.a.c.a.c(11), new org.a.c.a.c(11))));
    localEnumMap.put(a.f, new org.a.c.a.b("category", 2, new org.a.c.a.c(11)));
    g = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(l.class, g);
  }

  public void a(f paramf)
  {
    paramf.g();
    org.a.c.b.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      g();
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
      if (localc.b == 13)
      {
        org.a.c.b.e locale = paramf.k();
        this.e = new HashMap(2 * locale.c);
        for (int i1 = 0; i1 < locale.c; i1++)
        {
          String str1 = paramf.w();
          String str2 = paramf.w();
          this.e.put(str1, str2);
        }
        paramf.l();
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
    }
  }

  public boolean a()
  {
    return this.a != null;
  }

  public boolean a(l paraml)
  {
    if (paraml == null);
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
                bool2 = paraml.a();
              }
              while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paraml.a))));
              bool3 = b();
              bool4 = paraml.b();
            }
            while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paraml.b))));
            bool5 = c();
            bool6 = paraml.c();
          }
          while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paraml.c))));
          bool7 = d();
          bool8 = paraml.d();
        }
        while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paraml.d))));
        bool9 = e();
        bool10 = paraml.e();
      }
      while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paraml.e))));
      bool11 = f();
      bool12 = paraml.f();
    }
    while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paraml.f))));
    return true;
  }

  public int b(l paraml)
  {
    int i1;
    if (!getClass().equals(paraml.getClass()))
      i1 = getClass().getName().compareTo(paraml.getClass().getName());
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
                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paraml.a()));
                          }
                          while (i1 != 0);
                          if (!a())
                            break;
                          i1 = org.a.c.c.a(this.a, paraml.a);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paraml.b()));
                      }
                      while (i1 != 0);
                      if (!b())
                        break;
                      i1 = org.a.c.c.a(this.b, paraml.b);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paraml.c()));
                  }
                  while (i1 != 0);
                  if (!c())
                    break;
                  i1 = org.a.c.c.a(this.c, paraml.c);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paraml.d()));
              }
              while (i1 != 0);
              if (!d())
                break;
              i1 = org.a.c.c.a(this.d, paraml.d);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paraml.e()));
          }
          while (i1 != 0);
          if (!e())
            break;
          i1 = org.a.c.c.a(this.e, paraml.e);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paraml.f()));
      }
      while (i1 != 0);
      if (!f())
        break;
      i1 = org.a.c.c.a(this.f, paraml.f);
    }
    while (i1 != 0);
    return 0;
  }

  public void b(f paramf)
  {
    g();
    paramf.a(h);
    if ((this.a != null) && (a()))
    {
      paramf.a(i);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(j);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(k);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(l);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(m);
      paramf.a(new org.a.c.b.e(11, 11, this.e.size()));
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(n);
      paramf.a(this.f);
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
    while (!(paramObject instanceof l));
    return a((l)paramObject);
  }

  public boolean f()
  {
    return this.f != null;
  }

  public void g()
  {
    if (this.c == null)
      throw new org.a.c.b.g("Required field 'id' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'appId' was not present! Struct: " + toString());
  }

  public int hashCode()
  {
    return 0;
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendFeedback(");
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
        break label318;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.b != null)
        break label256;
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
          break label282;
        localStringBuilder.append("null");
        label155: if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("feedbacks:");
          if (this.e != null)
            break label294;
          localStringBuilder.append("null");
        }
        label193: if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.f != null)
            break label306;
          localStringBuilder.append("null");
        }
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label256: localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label282: localStringBuilder.append(this.d);
        break label155;
        label294: localStringBuilder.append(this.e);
        break label193;
        label306: localStringBuilder.append(this.f);
      }
      label318: i1 = i2;
    }
  }

  public static enum a
  {
    private static final Map<String, a> g;
    private final short h;
    private final String i;

    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      j = arrayOfa;
      g = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        g.put(locala.a(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.h = paramShort;
      this.i = paramString;
    }

    public String a()
    {
      return this.i;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.f.a.l
 * JD-Core Version:    0.6.0
 */