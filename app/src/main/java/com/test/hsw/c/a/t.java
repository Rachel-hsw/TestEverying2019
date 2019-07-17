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

public class t
  implements cl<t, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("ClientStats");
  private static final di f = new di("successful_requests", 8, 1);
  private static final di g = new di("failed_requests", 8, 2);
  private static final di h = new di("last_request_spent_ms", 8, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j = 0;
  private static final int k = 1;
  private static final int l = 2;
  public int a;
  public int b;
  public int c;
  private byte m = 0;
  private e[] n;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("successful_requests", 1, new da(8)));
    localEnumMap.put(e.b, new cz("failed_requests", 1, new da(8)));
    localEnumMap.put(e.c, new cz("last_request_spent_ms", 2, new da(8)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(t.class, d);
  }

  public t()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.c;
    this.n = arrayOfe;
    this.a = 0;
    this.b = 0;
  }

  public t(int paramInt1, int paramInt2)
  {
    this();
    this.a = paramInt1;
    a(true);
    this.b = paramInt2;
    b(true);
  }

  public t(t paramt)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.c;
    this.n = arrayOfe;
    this.m = paramt.m;
    this.a = paramt.a;
    this.b = paramt.b;
    this.c = paramt.c;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.m = 0;
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

  public t a()
  {
    return new t(this);
  }

  public t a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 0, paramBoolean);
  }

  public void b()
  {
    this.a = 0;
    this.b = 0;
    c(false);
    this.c = 0;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 1, paramBoolean);
  }

  public int c()
  {
    return this.a;
  }

  public t c(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }

  public void c(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 2, paramBoolean);
  }

  public t d(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }

  public void d()
  {
    this.m = ci.b(this.m, 0);
  }

  public e e(int paramInt)
  {
    return e.a(paramInt);
  }

  public boolean e()
  {
    return ci.a(this.m, 0);
  }

  public int f()
  {
    return this.b;
  }

  public void h()
  {
    this.m = ci.b(this.m, 1);
  }

  public boolean i()
  {
    return ci.a(this.m, 1);
  }

  public int j()
  {
    return this.c;
  }

  public void k()
  {
    this.m = ci.b(this.m, 2);
  }

  public boolean l()
  {
    return ci.a(this.m, 2);
  }

  public void m()
    throws cs
  {
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ClientStats(");
    localStringBuilder.append("successful_requests:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("failed_requests:");
    localStringBuilder.append(this.b);
    if (l())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("last_request_spent_ms:");
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  private static class a extends dx<t>
  {
    public void a(dn paramdn, t paramt)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramt.e())
          throw new do("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
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
          if (localdi.b == 8)
          {
            paramt.a = paramdn.w();
            paramt.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramt.b = paramdn.w();
            paramt.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramt.c = paramdn.w();
            paramt.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!paramt.i())
        throw new do("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
      paramt.m();
    }

    public void b(dn paramdn, t paramt)
      throws cs
    {
      paramt.m();
      paramdn.a(t.n());
      paramdn.a(t.o());
      paramdn.a(paramt.a);
      paramdn.c();
      paramdn.a(t.p());
      paramdn.a(paramt.b);
      paramdn.c();
      if (paramt.l())
      {
        paramdn.a(t.q());
        paramdn.a(paramt.c);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public t.a a()
    {
      return new t.a(null);
    }
  }

  private static class c extends dy<t>
  {
    public void a(dn paramdn, t paramt)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramt.a);
      localdt.a(paramt.b);
      BitSet localBitSet = new BitSet();
      if (paramt.l())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (paramt.l())
        localdt.a(paramt.c);
    }

    public void b(dn paramdn, t paramt)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramt.a = localdt.w();
      paramt.a(true);
      paramt.b = localdt.w();
      paramt.b(true);
      if (localdt.b(1).get(0))
      {
        paramt.c = localdt.w();
        paramt.c(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public t.c a()
    {
      return new t.c(null);
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
 * Qualified Name:     c.a.t
 * JD-Core Version:    0.6.0
 */