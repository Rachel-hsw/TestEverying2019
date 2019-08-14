package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bj
  implements cl<bj, e>, Serializable, Cloneable
{
  public static final Map<e, cz> h;
  private static final ds i = new ds("Session");
  private static final di j = new di("id", 11, 1);
  private static final di k = new di("start_time", 10, 2);
  private static final di l = new di("end_time", 10, 3);
  private static final di m = new di("duration", 10, 4);
  private static final di n = new di("pages", 15, 5);
  private static final di o = new di("locations", 15, 6);
  private static final di p = new di("traffic", 12, 7);
  private static final Map<Class<? extends dv>, dw> q = new HashMap();
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  public String a;
  public long b;
  public long c;
  public long d;
  public List<ba> e;
  public List<aw> f;
  public bl g;
  private byte u = 0;
  private e[] v;

  static
  {
    q.put(dx.class, new b(null));
    q.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("id", 1, new da(11)));
    localEnumMap.put(e.b, new cz("start_time", 1, new da(10)));
    localEnumMap.put(e.c, new cz("end_time", 1, new da(10)));
    localEnumMap.put(e.d, new cz("duration", 1, new da(10)));
    localEnumMap.put(e.e, new cz("pages", 2, new db(15, new de(12, ba.class))));
    localEnumMap.put(e.f, new cz("locations", 2, new db(15, new de(12, aw.class))));
    localEnumMap.put(e.g, new cz("traffic", 2, new de(12, bl.class)));
    h = Collections.unmodifiableMap(localEnumMap);
    cz.a(bj.class, h);
  }

  public bj()
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.e;
    arrayOfe[1] = e.f;
    arrayOfe[2] = e.g;
    this.v = arrayOfe;
  }

  public bj(bj parambj)
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.e;
    arrayOfe[1] = e.f;
    arrayOfe[2] = e.g;
    this.v = arrayOfe;
    this.u = parambj.u;
    if (parambj.e())
      this.a = parambj.a;
    this.b = parambj.b;
    this.c = parambj.c;
    this.d = parambj.d;
    if (parambj.t())
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator1 = parambj.e.iterator();
      while (localIterator1.hasNext())
        localArrayList1.add(new ba((ba)localIterator1.next()));
      this.e = localArrayList1;
    }
    if (parambj.y())
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator2 = parambj.f.iterator();
      while (localIterator2.hasNext())
        localArrayList2.add(new aw((aw)localIterator2.next()));
      this.f = localArrayList2;
    }
    if (parambj.B())
      this.g = new bl(parambj.g);
  }

  public bj(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this();
    this.a = paramString;
    this.b = paramLong1;
    b(true);
    this.c = paramLong2;
    c(true);
    this.d = paramLong3;
    d(true);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.u = 0;
      a(new dh(new dz(paramObjectInputStream)));
      return;
    }
    catch (cs localcs)
    {
    }
    throw new IOException(localcs.getMessage());
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    try
    {
      b(new dh(new dz(paramObjectOutputStream)));
      return;
    }
    catch (cs localcs)
    {
    }
    throw new IOException(localcs.getMessage());
  }

  public void A()
  {
    this.g = null;
  }

  public boolean B()
  {
    return this.g != null;
  }

  public void C()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'id' was not present! Struct: " + toString());
    if (this.g != null)
      this.g.j();
  }

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public bj a()
  {
    return new bj(this);
  }

  public bj a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }

  public bj a(bl parambl)
  {
    this.g = parambl;
    return this;
  }

  public bj a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public bj a(List<ba> paramList)
  {
    this.e = paramList;
    return this;
  }

  public void a(aw paramaw)
  {
    if (this.f == null)
      this.f = new ArrayList();
    this.f.add(paramaw);
  }

  public void a(ba paramba)
  {
    if (this.e == null)
      this.e = new ArrayList();
    this.e.add(paramba);
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)q.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public bj b(long paramLong)
  {
    this.c = paramLong;
    c(true);
    return this;
  }

  public bj b(List<aw> paramList)
  {
    this.f = paramList;
    return this;
  }

  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0L;
    c(false);
    this.c = 0L;
    d(false);
    this.d = 0L;
    this.e = null;
    this.f = null;
    this.g = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)q.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.u = ci.a(this.u, 0, paramBoolean);
  }

  public bj c(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }

  public String c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    this.u = ci.a(this.u, 1, paramBoolean);
  }

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    this.u = ci.a(this.u, 2, paramBoolean);
  }

  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.e = null;
  }

  public boolean e()
  {
    return this.a != null;
  }

  public long f()
  {
    return this.b;
  }

  public void f(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.f = null;
  }

  public void g(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.g = null;
  }

  public void h()
  {
    this.u = ci.b(this.u, 0);
  }

  public boolean i()
  {
    return ci.a(this.u, 0);
  }

  public long j()
  {
    return this.c;
  }

  public void k()
  {
    this.u = ci.b(this.u, 1);
  }

  public boolean l()
  {
    return ci.a(this.u, 1);
  }

  public long m()
  {
    return this.d;
  }

  public void n()
  {
    this.u = ci.b(this.u, 2);
  }

  public boolean o()
  {
    return ci.a(this.u, 2);
  }

  public int p()
  {
    if (this.e == null)
      return 0;
    return this.e.size();
  }

  public Iterator<ba> q()
  {
    if (this.e == null)
      return null;
    return this.e.iterator();
  }

  public List<ba> r()
  {
    return this.e;
  }

  public void s()
  {
    this.e = null;
  }

  public boolean t()
  {
    return this.e != null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Session(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("start_time:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("end_time:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.d);
      if (t())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("pages:");
        if (this.e != null)
          break label248;
        localStringBuilder.append("null");
      }
      label147: if (y())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("locations:");
        if (this.f != null)
          break label260;
        localStringBuilder.append("null");
      }
      label185: if (B())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("traffic:");
        if (this.g != null)
          break label272;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label248: localStringBuilder.append(this.e);
      break label147;
      label260: localStringBuilder.append(this.f);
      break label185;
      label272: localStringBuilder.append(this.g);
    }
  }

  public int u()
  {
    if (this.f == null)
      return 0;
    return this.f.size();
  }

  public Iterator<aw> v()
  {
    if (this.f == null)
      return null;
    return this.f.iterator();
  }

  public List<aw> w()
  {
    return this.f;
  }

  public void x()
  {
    this.f = null;
  }

  public boolean y()
  {
    return this.f != null;
  }

  public bl z()
  {
    return this.g;
  }

  private static class a extends dx<bj>
  {
    public void a(dn paramdn, bj parambj)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!parambj.i())
          throw new do("Required field 'start_time' was not found in serialized data! Struct: " + toString());
      }
      else
      {
        switch (localdi.c)
        {
        default:
          dq.a(paramdn, localdi.b);
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
          paramdn.m();
          break;
          if (localdi.b == 11)
          {
            parambj.a = paramdn.z();
            parambj.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            parambj.b = paramdn.x();
            parambj.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            parambj.c = paramdn.x();
            parambj.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            parambj.d = paramdn.x();
            parambj.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 15)
          {
            dj localdj2 = paramdn.p();
            parambj.e = new ArrayList(localdj2.b);
            for (int j = 0; j < localdj2.b; j++)
            {
              ba localba = new ba();
              localba.a(paramdn);
              parambj.e.add(localba);
            }
            paramdn.q();
            parambj.e(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 15)
          {
            dj localdj1 = paramdn.p();
            parambj.f = new ArrayList(localdj1.b);
            for (int i = 0; i < localdj1.b; i++)
            {
              aw localaw = new aw();
              localaw.a(paramdn);
              parambj.f.add(localaw);
            }
            paramdn.q();
            parambj.f(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 12)
          {
            parambj.g = new bl();
            parambj.g.a(paramdn);
            parambj.g(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!parambj.l())
        throw new do("Required field 'end_time' was not found in serialized data! Struct: " + toString());
      if (!parambj.o())
        throw new do("Required field 'duration' was not found in serialized data! Struct: " + toString());
      parambj.C();
    }

    public void b(dn paramdn, bj parambj)
      throws cs
    {
      parambj.C();
      paramdn.a(bj.D());
      if (parambj.a != null)
      {
        paramdn.a(bj.E());
        paramdn.a(parambj.a);
        paramdn.c();
      }
      paramdn.a(bj.F());
      paramdn.a(parambj.b);
      paramdn.c();
      paramdn.a(bj.G());
      paramdn.a(parambj.c);
      paramdn.c();
      paramdn.a(bj.H());
      paramdn.a(parambj.d);
      paramdn.c();
      if ((parambj.e != null) && (parambj.t()))
      {
        paramdn.a(bj.I());
        paramdn.a(new dj(12, parambj.e.size()));
        Iterator localIterator2 = parambj.e.iterator();
        while (localIterator2.hasNext())
          ((ba)localIterator2.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((parambj.f != null) && (parambj.y()))
      {
        paramdn.a(bj.J());
        paramdn.a(new dj(12, parambj.f.size()));
        Iterator localIterator1 = parambj.f.iterator();
        while (localIterator1.hasNext())
          ((aw)localIterator1.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((parambj.g != null) && (parambj.B()))
      {
        paramdn.a(bj.K());
        parambj.g.b(paramdn);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public bj.a a()
    {
      return new bj.a(null);
    }
  }

  private static class c extends dy<bj>
  {
    public void a(dn paramdn, bj parambj)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(parambj.a);
      localdt.a(parambj.b);
      localdt.a(parambj.c);
      localdt.a(parambj.d);
      BitSet localBitSet = new BitSet();
      if (parambj.t())
        localBitSet.set(0);
      if (parambj.y())
        localBitSet.set(1);
      if (parambj.B())
        localBitSet.set(2);
      localdt.a(localBitSet, 3);
      if (parambj.t())
      {
        localdt.a(parambj.e.size());
        Iterator localIterator2 = parambj.e.iterator();
        while (localIterator2.hasNext())
          ((ba)localIterator2.next()).b(localdt);
      }
      if (parambj.y())
      {
        localdt.a(parambj.f.size());
        Iterator localIterator1 = parambj.f.iterator();
        while (localIterator1.hasNext())
          ((aw)localIterator1.next()).b(localdt);
      }
      if (parambj.B())
        parambj.g.b(localdt);
    }

    public void b(dn paramdn, bj parambj)
      throws cs
    {
      int i = 0;
      dt localdt = (dt)paramdn;
      parambj.a = localdt.z();
      parambj.a(true);
      parambj.b = localdt.x();
      parambj.b(true);
      parambj.c = localdt.x();
      parambj.c(true);
      parambj.d = localdt.x();
      parambj.d(true);
      BitSet localBitSet = localdt.b(3);
      if (localBitSet.get(0))
      {
        dj localdj1 = new dj(12, localdt.w());
        parambj.e = new ArrayList(localdj1.b);
        for (int j = 0; j < localdj1.b; j++)
        {
          ba localba = new ba();
          localba.a(localdt);
          parambj.e.add(localba);
        }
        parambj.e(true);
      }
      if (localBitSet.get(1))
      {
        dj localdj2 = new dj(12, localdt.w());
        parambj.f = new ArrayList(localdj2.b);
        while (i < localdj2.b)
        {
          aw localaw = new aw();
          localaw.a(localdt);
          parambj.f.add(localaw);
          i++;
        }
        parambj.f(true);
      }
      if (localBitSet.get(2))
      {
        parambj.g = new bl();
        parambj.g.a(localdt);
        parambj.g(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public bj.c a()
    {
      return new bj.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> h;
    private final short i;
    private final String j;

    static
    {
      e[] arrayOfe = new e[7];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      arrayOfe[5] = f;
      arrayOfe[6] = g;
      k = arrayOfe;
      h = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        h.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.i = paramShort;
      this.j = paramString;
    }

    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        return a;
      case 2:
        return b;
      case 3:
        return c;
      case 4:
        return d;
      case 5:
        return e;
      case 6:
        return f;
      case 7:
      }
      return g;
    }

    public static e a(String paramString)
    {
      return (e)h.get(paramString);
    }

    public static e b(int paramInt)
    {
      e locale = a(paramInt);
      if (locale == null)
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      return locale;
    }

    public short a()
    {
      return this.i;
    }

    public String b()
    {
      return this.j;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.bj
 * JD-Core Version:    0.6.0
 */