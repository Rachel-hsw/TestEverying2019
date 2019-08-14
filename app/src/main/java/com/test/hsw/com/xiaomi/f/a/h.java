package com.xiaomi.f.a;

import java.io.Serializable;
import java.nio.ByteBuffer;
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

public class h
  implements Serializable, Cloneable, org.a.c.b<h, a>
{
  public static final Map<a, org.a.c.a.b> i;
  private static final k j = new k("XmPushActionContainer");
  private static final org.a.c.b.c k = new org.a.c.b.c("action", 8, 1);
  private static final org.a.c.b.c l = new org.a.c.b.c("encryptAction", 2, 2);
  private static final org.a.c.b.c m = new org.a.c.b.c("isRequest", 2, 3);
  private static final org.a.c.b.c n = new org.a.c.b.c("pushAction", 11, 4);
  private static final org.a.c.b.c o = new org.a.c.b.c("appid", 11, 5);
  private static final org.a.c.b.c p = new org.a.c.b.c("packageName", 11, 6);
  private static final org.a.c.b.c q = new org.a.c.b.c("target", 12, 7);
  private static final org.a.c.b.c r = new org.a.c.b.c("metaInfo", 12, 8);
  public a a;
  public boolean b = true;
  public boolean c = true;
  public ByteBuffer d;
  public String e;
  public String f;
  public d g;
  public c h;
  private BitSet s = new BitSet(2);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.a.c.a.b("action", 1, new org.a.c.a.a(16, a.class)));
    localEnumMap.put(a.b, new org.a.c.a.b("encryptAction", 1, new org.a.c.a.c(2)));
    localEnumMap.put(a.c, new org.a.c.a.b("isRequest", 1, new org.a.c.a.c(2)));
    localEnumMap.put(a.d, new org.a.c.a.b("pushAction", 1, new org.a.c.a.c(11)));
    localEnumMap.put(a.e, new org.a.c.a.b("appid", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.f, new org.a.c.a.b("packageName", 2, new org.a.c.a.c(11)));
    localEnumMap.put(a.g, new org.a.c.a.b("target", 1, new org.a.c.a.g(12, d.class)));
    localEnumMap.put(a.h, new org.a.c.a.b("metaInfo", 2, new org.a.c.a.g(12, c.class)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.a.c.a.b.a(h.class, i);
  }

  public a a()
  {
    return this.a;
  }

  public h a(a parama)
  {
    this.a = parama;
    return this;
  }

  public h a(c paramc)
  {
    this.h = paramc;
    return this;
  }

  public h a(d paramd)
  {
    this.g = paramd;
    return this;
  }

  public h a(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public h a(ByteBuffer paramByteBuffer)
  {
    this.d = paramByteBuffer;
    return this;
  }

  public h a(boolean paramBoolean)
  {
    this.b = paramBoolean;
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
      if (!d())
        throw new org.a.c.b.g("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
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
      }
      while (true)
      {
        paramf.j();
        break;
        if (localc.b == 8)
        {
          this.a = a.a(paramf.t());
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 2)
        {
          this.b = paramf.q();
          b(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 2)
        {
          this.c = paramf.q();
          d(true);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.d = paramf.x();
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
        if (localc.b == 12)
        {
          this.g = new d();
          this.g.a(paramf);
          continue;
        }
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 12)
        {
          this.h = new c();
          this.h.a(paramf);
          continue;
        }
        i.a(paramf, localc.b);
      }
    }
    if (!e())
      throw new org.a.c.b.g("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
    o();
  }

  public boolean a(h paramh)
  {
    if (paramh == null);
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
                bool1 = b();
                bool2 = paramh.b();
              }
              while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramh.a)) || (this.b != paramh.b) || (this.c != paramh.c)));
              bool3 = g();
              bool4 = paramh.g();
            }
            while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.d.equals(paramh.d))));
            bool5 = i();
            bool6 = paramh.i();
          }
          while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.e.equals(paramh.e))));
          bool7 = k();
          bool8 = paramh.k();
        }
        while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.f.equals(paramh.f))));
        bool9 = l();
        bool10 = paramh.l();
      }
      while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.g.a(paramh.g))));
      bool11 = n();
      bool12 = paramh.n();
    }
    while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.h.a(paramh.h))));
    return true;
  }

  public int b(h paramh)
  {
    int i1;
    if (!getClass().equals(paramh.getClass()))
      i1 = getClass().getName().compareTo(paramh.getClass().getName());
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
                                    i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramh.b()));
                                  }
                                  while (i1 != 0);
                                  if (!b())
                                    break;
                                  i1 = org.a.c.c.a(this.a, paramh.a);
                                }
                                while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramh.d()));
                              }
                              while (i1 != 0);
                              if (!d())
                                break;
                              i1 = org.a.c.c.a(this.b, paramh.b);
                            }
                            while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramh.e()));
                          }
                          while (i1 != 0);
                          if (!e())
                            break;
                          i1 = org.a.c.c.a(this.c, paramh.c);
                        }
                        while (i1 != 0);
                        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramh.g()));
                      }
                      while (i1 != 0);
                      if (!g())
                        break;
                      i1 = org.a.c.c.a(this.d, paramh.d);
                    }
                    while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramh.i()));
                  }
                  while (i1 != 0);
                  if (!i())
                    break;
                  i1 = org.a.c.c.a(this.e, paramh.e);
                }
                while (i1 != 0);
                i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramh.k()));
              }
              while (i1 != 0);
              if (!k())
                break;
              i1 = org.a.c.c.a(this.f, paramh.f);
            }
            while (i1 != 0);
            i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramh.l()));
          }
          while (i1 != 0);
          if (!l())
            break;
          i1 = org.a.c.c.a(this.g, paramh.g);
        }
        while (i1 != 0);
        i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramh.n()));
      }
      while (i1 != 0);
      if (!n())
        break;
      i1 = org.a.c.c.a(this.h, paramh.h);
    }
    while (i1 != 0);
    return 0;
  }

  public h b(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public void b(f paramf)
  {
    o();
    paramf.a(j);
    if (this.a != null)
    {
      paramf.a(k);
      paramf.a(this.a.a());
      paramf.b();
    }
    paramf.a(l);
    paramf.a(this.b);
    paramf.b();
    paramf.a(m);
    paramf.a(this.c);
    paramf.b();
    if (this.d != null)
    {
      paramf.a(n);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (i()))
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (k()))
    {
      paramf.a(p);
      paramf.a(this.f);
      paramf.b();
    }
    if (this.g != null)
    {
      paramf.a(q);
      this.g.b(paramf);
      paramf.b();
    }
    if ((this.h != null) && (n()))
    {
      paramf.a(r);
      this.h.b(paramf);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }

  public void b(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }

  public boolean b()
  {
    return this.a != null;
  }

  public h c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    d(true);
    return this;
  }

  public boolean c()
  {
    return this.b;
  }

  public void d(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }

  public boolean d()
  {
    return this.s.get(0);
  }

  public boolean e()
  {
    return this.s.get(1);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
      return false;
    while (!(paramObject instanceof h));
    return a((h)paramObject);
  }

  public byte[] f()
  {
    a(org.a.c.c.c(this.d));
    return this.d.array();
  }

  public boolean g()
  {
    return this.d != null;
  }

  public String h()
  {
    return this.e;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean i()
  {
    return this.e != null;
  }

  public String j()
  {
    return this.f;
  }

  public boolean k()
  {
    return this.f != null;
  }

  public boolean l()
  {
    return this.g != null;
  }

  public c m()
  {
    return this.h;
  }

  public boolean n()
  {
    return this.h != null;
  }

  public void o()
  {
    if (this.a == null)
      throw new org.a.c.b.g("Required field 'action' was not present! Struct: " + toString());
    if (this.d == null)
      throw new org.a.c.b.g("Required field 'pushAction' was not present! Struct: " + toString());
    if (this.g == null)
      throw new org.a.c.b.g("Required field 'target' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionContainer(");
    localStringBuilder.append("action:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("encryptAction:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("isRequest:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("pushAction:");
      if (this.d != null)
        break label285;
      localStringBuilder.append("null");
      label115: if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("appid:");
        if (this.e != null)
          break label296;
        localStringBuilder.append("null");
      }
      label153: if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.f != null)
          break label308;
        localStringBuilder.append("null");
      }
      label191: localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.g != null)
        break label320;
      localStringBuilder.append("null");
      label222: if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("metaInfo:");
        if (this.h != null)
          break label332;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label285: org.a.c.c.a(this.d, localStringBuilder);
      break label115;
      label296: localStringBuilder.append(this.e);
      break label153;
      label308: localStringBuilder.append(this.f);
      break label191;
      label320: localStringBuilder.append(this.g);
      break label222;
      label332: localStringBuilder.append(this.h);
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
 * Qualified Name:     com.xiaomi.f.a.h
 * JD-Core Version:    0.6.0
 */