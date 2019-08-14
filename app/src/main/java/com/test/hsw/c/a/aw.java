package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class aw
  implements cl<aw, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("Location");
  private static final di f = new di("lat", 4, 1);
  private static final di g = new di("lng", 4, 2);
  private static final di h = new di("ts", 10, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j = 0;
  private static final int k = 1;
  private static final int l = 2;
  public double a;
  public double b;
  public long c;
  private byte m = 0;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("lat", 1, new da(4)));
    localEnumMap.put(e.b, new cz("lng", 1, new da(4)));
    localEnumMap.put(e.c, new cz("ts", 1, new da(10)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(aw.class, d);
  }

  public aw()
  {
  }

  public aw(double paramDouble1, double paramDouble2, long paramLong)
  {
    this();
    this.a = paramDouble1;
    a(true);
    this.b = paramDouble2;
    b(true);
    this.c = paramLong;
    c(true);
  }

  public aw(aw paramaw)
  {
    this.m = paramaw.m;
    this.a = paramaw.a;
    this.b = paramaw.b;
    this.c = paramaw.c;
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

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public aw a()
  {
    return new aw(this);
  }

  public aw a(double paramDouble)
  {
    this.a = paramDouble;
    a(true);
    return this;
  }

  public aw a(long paramLong)
  {
    this.c = paramLong;
    c(true);
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

  public aw b(double paramDouble)
  {
    this.b = paramDouble;
    b(true);
    return this;
  }

  public void b()
  {
    a(false);
    this.a = 0.0D;
    b(false);
    this.b = 0.0D;
    c(false);
    this.c = 0L;
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

  public double c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 2, paramBoolean);
  }

  public void d()
  {
    this.m = ci.b(this.m, 0);
  }

  public boolean e()
  {
    return ci.a(this.m, 0);
  }

  public double f()
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

  public long j()
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
    StringBuilder localStringBuilder = new StringBuilder("Location(");
    localStringBuilder.append("lat:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("lng:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  private static class a extends dx<aw>
  {
    public void a(dn paramdn, aw paramaw)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramaw.e())
          throw new do("Required field 'lat' was not found in serialized data! Struct: " + toString());
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
          if (localdi.b == 4)
          {
            paramaw.a = paramdn.y();
            paramaw.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 4)
          {
            paramaw.b = paramdn.y();
            paramaw.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramaw.c = paramdn.x();
            paramaw.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!paramaw.i())
        throw new do("Required field 'lng' was not found in serialized data! Struct: " + toString());
      if (!paramaw.l())
        throw new do("Required field 'ts' was not found in serialized data! Struct: " + toString());
      paramaw.m();
    }

    public void b(dn paramdn, aw paramaw)
      throws cs
    {
      paramaw.m();
      paramdn.a(aw.n());
      paramdn.a(aw.o());
      paramdn.a(paramaw.a);
      paramdn.c();
      paramdn.a(aw.p());
      paramdn.a(paramaw.b);
      paramdn.c();
      paramdn.a(aw.q());
      paramdn.a(paramaw.c);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public aw.a a()
    {
      return new aw.a(null);
    }
  }

  private static class c extends dy<aw>
  {
    public void a(dn paramdn, aw paramaw)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramaw.a);
      localdt.a(paramaw.b);
      localdt.a(paramaw.c);
    }

    public void b(dn paramdn, aw paramaw)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramaw.a = localdt.y();
      paramaw.a(true);
      paramaw.b = localdt.y();
      paramaw.b(true);
      paramaw.c = localdt.x();
      paramaw.c(true);
    }
  }

  private static class d
    implements dw
  {
    public aw.c a()
    {
      return new aw.c(null);
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
 * Qualified Name:     c.a.aw
 * JD-Core Version:    0.6.0
 */