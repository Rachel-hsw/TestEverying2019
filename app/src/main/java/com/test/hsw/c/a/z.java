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

public class z
  implements cl<z, e>, Serializable, Cloneable
{
  public static final Map<e, cz> f;
  private static final ds g = new ds("Ekv");
  private static final di h = new di("ts", 10, 1);
  private static final di i = new di("name", 11, 2);
  private static final di j = new di("ckv", 13, 3);
  private static final di k = new di("duration", 10, 4);
  private static final di l = new di("acc", 8, 5);
  private static final Map<Class<? extends dv>, dw> m = new HashMap();
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  public long a;
  public String b;
  public Map<String, String> c;
  public long d;
  public int e;
  private byte q = 0;
  private e[] r;

  static
  {
    m.put(dx.class, new b(null));
    m.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("ts", 1, new da(10)));
    localEnumMap.put(e.b, new cz("name", 1, new da(11)));
    localEnumMap.put(e.c, new cz("ckv", 1, new dc(13, new da(11), new da(11))));
    localEnumMap.put(e.d, new cz("duration", 2, new da(10)));
    localEnumMap.put(e.e, new cz("acc", 2, new da(8)));
    f = Collections.unmodifiableMap(localEnumMap);
    cz.a(z.class, f);
  }

  public z()
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.d;
    arrayOfe[1] = e.e;
    this.r = arrayOfe;
  }

  public z(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this();
    this.a = paramLong;
    a(true);
    this.b = paramString;
    this.c = paramMap;
  }

  public z(z paramz)
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.d;
    arrayOfe[1] = e.e;
    this.r = arrayOfe;
    this.q = paramz.q;
    this.a = paramz.a;
    if (paramz.i())
      this.b = paramz.b;
    if (paramz.m())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramz.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.c = localHashMap;
    }
    this.d = paramz.d;
    this.e = paramz.e;
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

  public z a()
  {
    return new z(this);
  }

  public z a(int paramInt)
  {
    this.e = paramInt;
    e(true);
    return this;
  }

  public z a(long paramLong)
  {
    this.a = paramLong;
    a(true);
    return this;
  }

  public z a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public z a(Map<String, String> paramMap)
  {
    this.c = paramMap;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)m.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.c == null)
      this.c = new HashMap();
    this.c.put(paramString1, paramString2);
  }

  public void a(boolean paramBoolean)
  {
    this.q = ci.a(this.q, 0, paramBoolean);
  }

  public z b(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }

  public void b()
  {
    a(false);
    this.a = 0L;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0L;
    e(false);
    this.e = 0;
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

  public long c()
  {
    return this.a;
  }

  public e c(int paramInt)
  {
    return e.a(paramInt);
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public void d()
  {
    this.q = ci.b(this.q, 0);
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
    return ci.a(this.q, 0);
  }

  public String f()
  {
    return this.b;
  }

  public void h()
  {
    this.b = null;
  }

  public boolean i()
  {
    return this.b != null;
  }

  public int j()
  {
    if (this.c == null)
      return 0;
    return this.c.size();
  }

  public Map<String, String> k()
  {
    return this.c;
  }

  public void l()
  {
    this.c = null;
  }

  public boolean m()
  {
    return this.c != null;
  }

  public long n()
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

  public int q()
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
    if (this.b == null)
      throw new do("Required field 'name' was not present! Struct: " + toString());
    if (this.c == null)
      throw new do("Required field 'ckv' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Ekv(");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("name:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("ckv:");
      if (this.c != null)
        break label179;
      localStringBuilder.append("null");
    }
    while (true)
    {
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("duration:");
        localStringBuilder.append(this.d);
      }
      if (s())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("acc:");
        localStringBuilder.append(this.e);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label179: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<z>
  {
    public void a(dn paramdn, z paramz)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramz.e())
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
          if (localdi.b == 10)
          {
            paramz.a = paramdn.x();
            paramz.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramz.b = paramdn.z();
            paramz.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 13)
          {
            dk localdk = paramdn.n();
            paramz.c = new HashMap(2 * localdk.c);
            for (int i = 0; i < localdk.c; i++)
            {
              String str1 = paramdn.z();
              String str2 = paramdn.z();
              paramz.c.put(str1, str2);
            }
            paramdn.o();
            paramz.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramz.d = paramdn.x();
            paramz.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramz.e = paramdn.w();
            paramz.e(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramz.t();
    }

    public void b(dn paramdn, z paramz)
      throws cs
    {
      paramz.t();
      paramdn.a(z.u());
      paramdn.a(z.v());
      paramdn.a(paramz.a);
      paramdn.c();
      if (paramz.b != null)
      {
        paramdn.a(z.w());
        paramdn.a(paramz.b);
        paramdn.c();
      }
      if (paramz.c != null)
      {
        paramdn.a(z.x());
        paramdn.a(new dk(11, 11, paramz.c.size()));
        Iterator localIterator = paramz.c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramdn.a((String)localEntry.getKey());
          paramdn.a((String)localEntry.getValue());
        }
        paramdn.e();
        paramdn.c();
      }
      if (paramz.p())
      {
        paramdn.a(z.y());
        paramdn.a(paramz.d);
        paramdn.c();
      }
      if (paramz.s())
      {
        paramdn.a(z.z());
        paramdn.a(paramz.e);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public z.a a()
    {
      return new z.a(null);
    }
  }

  private static class c extends dy<z>
  {
    public void a(dn paramdn, z paramz)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramz.a);
      localdt.a(paramz.b);
      localdt.a(paramz.c.size());
      Iterator localIterator = paramz.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localdt.a((String)localEntry.getKey());
        localdt.a((String)localEntry.getValue());
      }
      BitSet localBitSet = new BitSet();
      if (paramz.p())
        localBitSet.set(0);
      if (paramz.s())
        localBitSet.set(1);
      localdt.a(localBitSet, 2);
      if (paramz.p())
        localdt.a(paramz.d);
      if (paramz.s())
        localdt.a(paramz.e);
    }

    public void b(dn paramdn, z paramz)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramz.a = localdt.x();
      paramz.a(true);
      paramz.b = localdt.z();
      paramz.b(true);
      dk localdk = new dk(11, 11, localdt.w());
      paramz.c = new HashMap(2 * localdk.c);
      for (int i = 0; i < localdk.c; i++)
      {
        String str1 = localdt.z();
        String str2 = localdt.z();
        paramz.c.put(str1, str2);
      }
      paramz.c(true);
      BitSet localBitSet = localdt.b(2);
      if (localBitSet.get(0))
      {
        paramz.d = localdt.x();
        paramz.d(true);
      }
      if (localBitSet.get(1))
      {
        paramz.e = localdt.w();
        paramz.e(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public z.c a()
    {
      return new z.c(null);
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
 * Qualified Name:     c.a.z
 * JD-Core Version:    0.6.0
 */