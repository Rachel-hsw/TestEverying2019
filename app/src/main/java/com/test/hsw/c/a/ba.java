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

public class ba
  implements cl<ba, e>, Serializable, Cloneable
{
  public static final Map<e, cz> c;
  private static final ds d = new ds("Page");
  private static final di e = new di("page_name", 11, 1);
  private static final di f = new di("duration", 10, 2);
  private static final Map<Class<? extends dv>, dw> g = new HashMap();
  private static final int h;
  public String a;
  public long b;
  private byte i = 0;

  static
  {
    g.put(dx.class, new b(null));
    g.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("page_name", 1, new da(11)));
    localEnumMap.put(e.b, new cz("duration", 1, new da(10)));
    c = Collections.unmodifiableMap(localEnumMap);
    cz.a(ba.class, c);
  }

  public ba()
  {
  }

  public ba(ba paramba)
  {
    this.i = paramba.i;
    if (paramba.e())
      this.a = paramba.a;
    this.b = paramba.b;
  }

  public ba(String paramString, long paramLong)
  {
    this();
    this.a = paramString;
    this.b = paramLong;
    b(true);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.i = 0;
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

  public ba a()
  {
    return new ba(this);
  }

  public ba a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }

  public ba a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)g.get(paramdn.D())).b().b(paramdn, this);
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
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)g.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.i = ci.a(this.i, 0, paramBoolean);
  }

  public String c()
  {
    return this.a;
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
    this.i = ci.b(this.i, 0);
  }

  public boolean i()
  {
    return ci.a(this.i, 0);
  }

  public void j()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'page_name' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Page(");
    localStringBuilder.append("page_name:");
    if (this.a == null)
      localStringBuilder.append("null");
    while (true)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }

  private static class a extends dx<ba>
  {
    public void a(dn paramdn, ba paramba)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramba.i())
          throw new do("Required field 'duration' was not found in serialized data! Struct: " + toString());
      }
      else
      {
        switch (localdi.c)
        {
        default:
          dq.a(paramdn, localdi.b);
        case 1:
        case 2:
        }
        while (true)
        {
          paramdn.m();
          break;
          if (localdi.b == 11)
          {
            paramba.a = paramdn.z();
            paramba.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramba.b = paramdn.x();
            paramba.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramba.j();
    }

    public void b(dn paramdn, ba paramba)
      throws cs
    {
      paramba.j();
      paramdn.a(ba.k());
      if (paramba.a != null)
      {
        paramdn.a(ba.l());
        paramdn.a(paramba.a);
        paramdn.c();
      }
      paramdn.a(ba.m());
      paramdn.a(paramba.b);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ba.a a()
    {
      return new ba.a(null);
    }
  }

  private static class c extends dy<ba>
  {
    public void a(dn paramdn, ba paramba)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramba.a);
      localdt.a(paramba.b);
    }

    public void b(dn paramdn, ba paramba)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramba.a = localdt.z();
      paramba.a(true);
      paramba.b = localdt.x();
      paramba.b(true);
    }
  }

  private static class d
    implements dw
  {
    public ba.c a()
    {
      return new ba.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> c;
    private final short d;
    private final String e;

    static
    {
      e[] arrayOfe = new e[2];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      f = arrayOfe;
      c = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        c.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.d = paramShort;
      this.e = paramString;
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
      }
      return b;
    }

    public static e a(String paramString)
    {
      return (e)c.get(paramString);
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
      return this.d;
    }

    public String b()
    {
      return this.e;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ba
 * JD-Core Version:    0.6.0
 */