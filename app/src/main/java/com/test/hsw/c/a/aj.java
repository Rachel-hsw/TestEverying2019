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

public class aj
  implements cl<aj, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("IdSnapshot");
  private static final di f = new di("identity", 11, 1);
  private static final di g = new di("ts", 10, 2);
  private static final di h = new di("version", 8, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j = 0;
  private static final int k = 1;
  public String a;
  public long b;
  public int c;
  private byte l = 0;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("identity", 1, new da(11)));
    localEnumMap.put(e.b, new cz("ts", 1, new da(10)));
    localEnumMap.put(e.c, new cz("version", 1, new da(8)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(aj.class, d);
  }

  public aj()
  {
  }

  public aj(aj paramaj)
  {
    this.l = paramaj.l;
    if (paramaj.e())
      this.a = paramaj.a;
    this.b = paramaj.b;
    this.c = paramaj.c;
  }

  public aj(String paramString, long paramLong, int paramInt)
  {
    this();
    this.a = paramString;
    this.b = paramLong;
    b(true);
    this.c = paramInt;
    c(true);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.l = 0;
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

  public aj a()
  {
    return new aj(this);
  }

  public aj a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }

  public aj a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }

  public aj a(String paramString)
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

  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0L;
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
    this.l = ci.a(this.l, 0, paramBoolean);
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
    this.l = ci.a(this.l, 1, paramBoolean);
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
    this.l = ci.b(this.l, 0);
  }

  public boolean i()
  {
    return ci.a(this.l, 0);
  }

  public int j()
  {
    return this.c;
  }

  public void k()
  {
    this.l = ci.b(this.l, 1);
  }

  public boolean l()
  {
    return ci.a(this.l, 1);
  }

  public void m()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'identity' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdSnapshot(");
    localStringBuilder.append("identity:");
    if (this.a == null)
      localStringBuilder.append("null");
    while (true)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }

  private static class a extends dx<aj>
  {
    public void a(dn paramdn, aj paramaj)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramaj.i())
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
            paramaj.a = paramdn.z();
            paramaj.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramaj.b = paramdn.x();
            paramaj.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramaj.c = paramdn.w();
            paramaj.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!paramaj.l())
        throw new do("Required field 'version' was not found in serialized data! Struct: " + toString());
      paramaj.m();
    }

    public void b(dn paramdn, aj paramaj)
      throws cs
    {
      paramaj.m();
      paramdn.a(aj.n());
      if (paramaj.a != null)
      {
        paramdn.a(aj.o());
        paramdn.a(paramaj.a);
        paramdn.c();
      }
      paramdn.a(aj.p());
      paramdn.a(paramaj.b);
      paramdn.c();
      paramdn.a(aj.q());
      paramdn.a(paramaj.c);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public aj.a a()
    {
      return new aj.a(null);
    }
  }

  private static class c extends dy<aj>
  {
    public void a(dn paramdn, aj paramaj)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramaj.a);
      localdt.a(paramaj.b);
      localdt.a(paramaj.c);
    }

    public void b(dn paramdn, aj paramaj)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramaj.a = localdt.z();
      paramaj.a(true);
      paramaj.b = localdt.x();
      paramaj.b(true);
      paramaj.c = localdt.w();
      paramaj.c(true);
    }
  }

  private static class d
    implements dw
  {
    public aj.c a()
    {
      return new aj.c(null);
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
 * Qualified Name:     c.a.aj
 * JD-Core Version:    0.6.0
 */