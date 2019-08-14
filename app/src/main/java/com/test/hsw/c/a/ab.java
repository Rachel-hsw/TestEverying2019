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

public class ab
  implements cl<ab, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("Error");
  private static final di f = new di("ts", 10, 1);
  private static final di g = new di("context", 11, 2);
  private static final di h = new di("source", 8, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j;
  public long a;
  public String b;
  public ad c;
  private byte k = 0;
  private e[] l;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("ts", 1, new da(10)));
    localEnumMap.put(e.b, new cz("context", 1, new da(11)));
    localEnumMap.put(e.c, new cz("source", 2, new cy(16, ad.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(ab.class, d);
  }

  public ab()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.c;
    this.l = arrayOfe;
  }

  public ab(long paramLong, String paramString)
  {
    this();
    this.a = paramLong;
    b(true);
    this.b = paramString;
  }

  public ab(ab paramab)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.c;
    this.l = arrayOfe;
    this.k = paramab.k;
    this.a = paramab.a;
    if (paramab.i())
      this.b = paramab.b;
    if (paramab.l())
      this.c = paramab.c;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.k = 0;
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

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public ab a()
  {
    return new ab(this);
  }

  public ab a(long paramLong)
  {
    this.a = paramLong;
    b(true);
    return this;
  }

  public ab a(ad paramad)
  {
    this.c = paramad;
    return this;
  }

  public ab a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void b()
  {
    b(false);
    this.a = 0L;
    this.b = null;
    this.c = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.k = ci.a(this.k, 0, paramBoolean);
  }

  public long c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public void d()
  {
    this.k = ci.b(this.k, 0);
  }

  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public boolean e()
  {
    return ci.a(this.k, 0);
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

  public ad j()
  {
    return this.c;
  }

  public void k()
  {
    this.c = null;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public void m()
    throws cs
  {
    if (this.b == null)
      throw new do("Required field 'context' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Error(");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("context:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      if (l())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("source:");
        if (this.c != null)
          break label122;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label122: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<ab>
  {
    public void a(dn paramdn, ab paramab)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramab.e())
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
        }
        while (true)
        {
          paramdn.m();
          break;
          if (localdi.b == 10)
          {
            paramab.a = paramdn.x();
            paramab.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramab.b = paramdn.z();
            paramab.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramab.c = ad.a(paramdn.w());
            paramab.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramab.m();
    }

    public void b(dn paramdn, ab paramab)
      throws cs
    {
      paramab.m();
      paramdn.a(ab.n());
      paramdn.a(ab.o());
      paramdn.a(paramab.a);
      paramdn.c();
      if (paramab.b != null)
      {
        paramdn.a(ab.p());
        paramdn.a(paramab.b);
        paramdn.c();
      }
      if ((paramab.c != null) && (paramab.l()))
      {
        paramdn.a(ab.q());
        paramdn.a(paramab.c.a());
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ab.a a()
    {
      return new ab.a(null);
    }
  }

  private static class c extends dy<ab>
  {
    public void a(dn paramdn, ab paramab)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramab.a);
      localdt.a(paramab.b);
      BitSet localBitSet = new BitSet();
      if (paramab.l())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (paramab.l())
        localdt.a(paramab.c.a());
    }

    public void b(dn paramdn, ab paramab)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramab.a = localdt.x();
      paramab.b(true);
      paramab.b = localdt.z();
      paramab.c(true);
      if (localdt.b(1).get(0))
      {
        paramab.c = ad.a(localdt.w());
        paramab.d(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public ab.c a()
    {
      return new ab.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> d;
    private final short e;
    private final String f;

    static
    {
      e[] arrayOfe = new e[3];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      g = arrayOfe;
      d = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        d.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.e = paramShort;
      this.f = paramString;
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
      }
      return c;
    }

    public static e a(String paramString)
    {
      return (e)d.get(paramString);
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
      return this.e;
    }

    public String b()
    {
      return this.f;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ab
 * JD-Core Version:    0.6.0
 */