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

public class n
  implements cl<n, e>, Serializable, Cloneable
{
  public static final Map<e, cz> b;
  private static final ds c = new ds("ActivateMsg");
  private static final di d = new di("ts", 10, 1);
  private static final Map<Class<? extends dv>, dw> e = new HashMap();
  private static final int f;
  public long a;
  private byte g = 0;

  static
  {
    e.put(dx.class, new b(null));
    e.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("ts", 1, new da(10)));
    b = Collections.unmodifiableMap(localEnumMap);
    cz.a(n.class, b);
  }

  public n()
  {
  }

  public n(long paramLong)
  {
    this();
    this.a = paramLong;
    a(true);
  }

  public n(n paramn)
  {
    this.g = paramn.g;
    this.a = paramn.a;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.g = 0;
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

  public n a()
  {
    return new n(this);
  }

  public n a(long paramLong)
  {
    this.a = paramLong;
    a(true);
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)e.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    this.g = ci.a(this.g, 0, paramBoolean);
  }

  public void b()
  {
    a(false);
    this.a = 0L;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)e.get(paramdn.D())).b().a(paramdn, this);
  }

  public long c()
  {
    return this.a;
  }

  public void d()
  {
    this.g = ci.b(this.g, 0);
  }

  public boolean e()
  {
    return ci.a(this.g, 0);
  }

  public void f()
    throws cs
  {
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ActivateMsg(");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  private static class a extends dx<n>
  {
    public void a(dn paramdn, n paramn)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramn.e())
          throw new do("Required field 'ts' was not found in serialized data! Struct: " + toString());
      }
      else
      {
        switch (localdi.c)
        {
        default:
          dq.a(paramdn, localdi.b);
        case 1:
        }
        while (true)
        {
          paramdn.m();
          break;
          if (localdi.b == 10)
          {
            paramn.a = paramdn.x();
            paramn.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramn.f();
    }

    public void b(dn paramdn, n paramn)
      throws cs
    {
      paramn.f();
      paramdn.a(n.h());
      paramdn.a(n.i());
      paramdn.a(paramn.a);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public n.a a()
    {
      return new n.a(null);
    }
  }

  private static class c extends dy<n>
  {
    public void a(dn paramdn, n paramn)
      throws cs
    {
      ((dt)paramdn).a(paramn.a);
    }

    public void b(dn paramdn, n paramn)
      throws cs
    {
      paramn.a = ((dt)paramdn).x();
      paramn.a(true);
    }
  }

  private static class d
    implements dw
  {
    public n.c a()
    {
      return new n.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> b;
    private final short c;
    private final String d;

    static
    {
      e[] arrayOfe = new e[1];
      arrayOfe[0] = a;
      e = arrayOfe;
      b = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        b.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.c = paramShort;
      this.d = paramString;
    }

    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
      }
      return a;
    }

    public static e a(String paramString)
    {
      return (e)b.get(paramString);
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
      return this.c;
    }

    public String b()
    {
      return this.d;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.n
 * JD-Core Version:    0.6.0
 */