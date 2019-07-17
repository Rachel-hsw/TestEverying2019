package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ae
  implements cl<ae, e>, Serializable, Cloneable
{
  public static final Map<e, cz> f;
  private static final ds g = new ds("Event");
  private static final di h = new di("name", 11, 1);
  private static final di i = new di("properties", 13, 2);
  private static final di j = new di("duration", 10, 3);
  private static final di k = new di("acc", 8, 4);
  private static final di l = new di("ts", 10, 5);
  private static final Map<Class<? extends dv>, dw> m = new HashMap();
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  public String a;
  public Map<String, bc> b;
  public long c;
  public int d;
  public long e;
  private byte q = 0;
  private e[] r;

  static
  {
    m.put(dx.class, new b(null));
    m.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("name", 1, new da(11)));
    localEnumMap.put(e.b, new cz("properties", 1, new dc(13, new da(11), new de(12, bc.class))));
    localEnumMap.put(e.c, new cz("duration", 2, new da(10)));
    localEnumMap.put(e.d, new cz("acc", 2, new da(8)));
    localEnumMap.put(e.e, new cz("ts", 1, new da(10)));
    f = Collections.unmodifiableMap(localEnumMap);
    cz.a(ae.class, f);
  }

  public ae()
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.c;
    arrayOfe[1] = e.d;
    this.r = arrayOfe;
  }

  public ae(ae paramae)
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.c;
    arrayOfe[1] = e.d;
    this.r = arrayOfe;
    this.q = paramae.q;
    if (paramae.e())
      this.a = paramae.a;
    if (paramae.j())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramae.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), new bc((bc)localEntry.getValue()));
      }
      this.b = localHashMap;
    }
    this.c = paramae.c;
    this.d = paramae.d;
    this.e = paramae.e;
  }

  public ae(String paramString, Map<String, bc> paramMap, long paramLong)
  {
    this();
    this.a = paramString;
    this.b = paramMap;
    this.e = paramLong;
    e(true);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.q = 0;
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

  public ae a()
  {
    return new ae(this);
  }

  public ae a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }

  public ae a(long paramLong)
  {
    this.c = paramLong;
    c(true);
    return this;
  }

  public ae a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public ae a(Map<String, bc> paramMap)
  {
    this.b = paramMap;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)m.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(String paramString, bc parambc)
  {
    if (this.b == null)
      this.b = new HashMap();
    this.b.put(paramString, parambc);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public ae b(long paramLong)
  {
    this.e = paramLong;
    e(true);
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    c(false);
    this.c = 0L;
    d(false);
    this.d = 0;
    e(false);
    this.e = 0L;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)m.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public e c(int paramInt)
  {
    return e.a(paramInt);
  }

  public String c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    this.q = ci.a(this.q, 0, paramBoolean);
  }

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    this.q = ci.a(this.q, 1, paramBoolean);
  }

  public void e(boolean paramBoolean)
  {
    this.q = ci.a(this.q, 2, paramBoolean);
  }

  public boolean e()
  {
    return this.a != null;
  }

  public int f()
  {
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public Map<String, bc> h()
  {
    return this.b;
  }

  public void i()
  {
    this.b = null;
  }

  public boolean j()
  {
    return this.b != null;
  }

  public long k()
  {
    return this.c;
  }

  public void l()
  {
    this.q = ci.b(this.q, 0);
  }

  public boolean m()
  {
    return ci.a(this.q, 0);
  }

  public int n()
  {
    return this.d;
  }

  public void o()
  {
    this.q = ci.b(this.q, 1);
  }

  public boolean p()
  {
    return ci.a(this.q, 1);
  }

  public long q()
  {
    return this.e;
  }

  public void r()
  {
    this.q = ci.b(this.q, 2);
  }

  public boolean s()
  {
    return ci.a(this.q, 2);
  }

  public void t()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'name' was not present! Struct: " + toString());
    if (this.b == null)
      throw new do("Required field 'properties' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Event(");
    localStringBuilder.append("name:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("properties:");
      if (this.b != null)
        break label179;
      localStringBuilder.append("null");
    }
    while (true)
    {
      if (m())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("duration:");
        localStringBuilder.append(this.c);
      }
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("acc:");
        localStringBuilder.append(this.d);
      }
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label179: localStringBuilder.append(this.b);
    }
  }

  private static class a extends dx<ae>
  {
    public void a(dn paramdn, ae paramae)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramae.s())
          throw new do("Required field 'ts' was not found in serialized data! Struct: " + toString());
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
        }
        while (true)
        {
          paramdn.m();
          break;
          if (localdi.b == 11)
          {
            paramae.a = paramdn.z();
            paramae.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 13)
          {
            dk localdk = paramdn.n();
            paramae.b = new HashMap(2 * localdk.c);
            for (int i = 0; i < localdk.c; i++)
            {
              String str = paramdn.z();
              bc localbc = new bc();
              localbc.a(paramdn);
              paramae.b.put(str, localbc);
            }
            paramdn.o();
            paramae.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramae.c = paramdn.x();
            paramae.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramae.d = paramdn.w();
            paramae.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramae.e = paramdn.x();
            paramae.e(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramae.t();
    }

    public void b(dn paramdn, ae paramae)
      throws cs
    {
      paramae.t();
      paramdn.a(ae.u());
      if (paramae.a != null)
      {
        paramdn.a(ae.v());
        paramdn.a(paramae.a);
        paramdn.c();
      }
      if (paramae.b != null)
      {
        paramdn.a(ae.w());
        paramdn.a(new dk(11, 12, paramae.b.size()));
        Iterator localIterator = paramae.b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramdn.a((String)localEntry.getKey());
          ((bc)localEntry.getValue()).b(paramdn);
        }
        paramdn.e();
        paramdn.c();
      }
      if (paramae.m())
      {
        paramdn.a(ae.x());
        paramdn.a(paramae.c);
        paramdn.c();
      }
      if (paramae.p())
      {
        paramdn.a(ae.y());
        paramdn.a(paramae.d);
        paramdn.c();
      }
      paramdn.a(ae.z());
      paramdn.a(paramae.e);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ae.a a()
    {
      return new ae.a(null);
    }
  }

  private static class c extends dy<ae>
  {
    public void a(dn paramdn, ae paramae)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramae.a);
      localdt.a(paramae.b.size());
      Iterator localIterator = paramae.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localdt.a((String)localEntry.getKey());
        ((bc)localEntry.getValue()).b(localdt);
      }
      localdt.a(paramae.e);
      BitSet localBitSet = new BitSet();
      if (paramae.m())
        localBitSet.set(0);
      if (paramae.p())
        localBitSet.set(1);
      localdt.a(localBitSet, 2);
      if (paramae.m())
        localdt.a(paramae.c);
      if (paramae.p())
        localdt.a(paramae.d);
    }

    public void b(dn paramdn, ae paramae)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramae.a = localdt.z();
      paramae.a(true);
      dk localdk = new dk(11, 12, localdt.w());
      paramae.b = new HashMap(2 * localdk.c);
      for (int i = 0; i < localdk.c; i++)
      {
        String str = localdt.z();
        bc localbc = new bc();
        localbc.a(localdt);
        paramae.b.put(str, localbc);
      }
      paramae.b(true);
      paramae.e = localdt.x();
      paramae.e(true);
      BitSet localBitSet = localdt.b(2);
      if (localBitSet.get(0))
      {
        paramae.c = localdt.x();
        paramae.c(true);
      }
      if (localBitSet.get(1))
      {
        paramae.d = localdt.w();
        paramae.d(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public ae.c a()
    {
      return new ae.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> f;
    private final short g;
    private final String h;

    static
    {
      e[] arrayOfe = new e[5];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      i = arrayOfe;
      f = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        f.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.g = paramShort;
      this.h = paramString;
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
      }
      return e;
    }

    public static e a(String paramString)
    {
      return (e)f.get(paramString);
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
      return this.g;
    }

    public String b()
    {
      return this.h;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ae
 * JD-Core Version:    0.6.0
 */