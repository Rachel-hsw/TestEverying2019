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

public class aq
  implements cl<aq, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("ImprintValue");
  private static final di f = new di("value", 11, 1);
  private static final di g = new di("ts", 10, 2);
  private static final di h = new di("guid", 11, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j;
  public String a;
  public long b;
  public String c;
  private byte k = 0;
  private e[] l;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("value", 2, new da(11)));
    localEnumMap.put(e.b, new cz("ts", 1, new da(10)));
    localEnumMap.put(e.c, new cz("guid", 1, new da(11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(aq.class, d);
  }

  public aq()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.a;
    this.l = arrayOfe;
  }

  public aq(long paramLong, String paramString)
  {
    this();
    this.b = paramLong;
    b(true);
    this.c = paramString;
  }

  public aq(aq paramaq)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.a;
    this.l = arrayOfe;
    this.k = paramaq.k;
    if (paramaq.e())
      this.a = paramaq.a;
    this.b = paramaq.b;
    if (paramaq.l())
      this.c = paramaq.c;
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

  public aq a()
  {
    return new aq(this);
  }

  public aq a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }

  public aq a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public aq b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0L;
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

  public String c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public void d()
  {
    this.a = null;
  }

  public boolean e()
  {
    return this.a != null;
  }

  public long f()
  {
    return this.b;
  }

  public void h()
  {
    this.k = ci.b(this.k, 0);
  }

  public boolean i()
  {
    return ci.a(this.k, 0);
  }

  public String j()
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
    if (this.c == null)
      throw new do("Required field 'guid' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ImprintValue(");
    int m = 1;
    if (e())
    {
      localStringBuilder.append("value:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        m = 0;
      }
    }
    else
    {
      if (m == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.c != null)
        break label123;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label123: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<aq>
  {
    public void a(dn paramdn, aq paramaq)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramaq.i())
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
          if (localdi.b == 11)
          {
            paramaq.a = paramdn.z();
            paramaq.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramaq.b = paramdn.x();
            paramaq.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramaq.c = paramdn.z();
            paramaq.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramaq.m();
    }

    public void b(dn paramdn, aq paramaq)
      throws cs
    {
      paramaq.m();
      paramdn.a(aq.n());
      if ((paramaq.a != null) && (paramaq.e()))
      {
        paramdn.a(aq.o());
        paramdn.a(paramaq.a);
        paramdn.c();
      }
      paramdn.a(aq.p());
      paramdn.a(paramaq.b);
      paramdn.c();
      if (paramaq.c != null)
      {
        paramdn.a(aq.q());
        paramdn.a(paramaq.c);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public aq.a a()
    {
      return new aq.a(null);
    }
  }

  private static class c extends dy<aq>
  {
    public void a(dn paramdn, aq paramaq)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramaq.b);
      localdt.a(paramaq.c);
      BitSet localBitSet = new BitSet();
      if (paramaq.e())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (paramaq.e())
        localdt.a(paramaq.a);
    }

    public void b(dn paramdn, aq paramaq)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramaq.b = localdt.x();
      paramaq.b(true);
      paramaq.c = localdt.z();
      paramaq.c(true);
      if (localdt.b(1).get(0))
      {
        paramaq.a = localdt.z();
        paramaq.a(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public aq.c a()
    {
      return new aq.c(null);
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
 * Qualified Name:     c.a.aq
 * JD-Core Version:    0.6.0
 */