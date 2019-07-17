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

public class be
  implements cl<be, e>, Serializable, Cloneable
{
  public static final Map<e, cz> c;
  private static final ds d = new ds("Resolution");
  private static final di e = new di("height", 8, 1);
  private static final di f = new di("width", 8, 2);
  private static final Map<Class<? extends dv>, dw> g = new HashMap();
  private static final int h = 0;
  private static final int i = 1;
  public int a;
  public int b;
  private byte j = 0;

  static
  {
    g.put(dx.class, new b(null));
    g.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("height", 1, new da(8)));
    localEnumMap.put(e.b, new cz("width", 1, new da(8)));
    c = Collections.unmodifiableMap(localEnumMap);
    cz.a(be.class, c);
  }

  public be()
  {
  }

  public be(int paramInt1, int paramInt2)
  {
    this();
    this.a = paramInt1;
    a(true);
    this.b = paramInt2;
    b(true);
  }

  public be(be parambe)
  {
    this.j = parambe.j;
    this.a = parambe.a;
    this.b = parambe.b;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.j = 0;
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

  public be a()
  {
    return new be(this);
  }

  public be a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)g.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    this.j = ci.a(this.j, 0, paramBoolean);
  }

  public void b()
  {
    a(false);
    this.a = 0;
    b(false);
    this.b = 0;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)g.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.j = ci.a(this.j, 1, paramBoolean);
  }

  public int c()
  {
    return this.a;
  }

  public be c(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }

  public e d(int paramInt)
  {
    return e.a(paramInt);
  }

  public void d()
  {
    this.j = ci.b(this.j, 0);
  }

  public boolean e()
  {
    return ci.a(this.j, 0);
  }

  public int f()
  {
    return this.b;
  }

  public void h()
  {
    this.j = ci.b(this.j, 1);
  }

  public boolean i()
  {
    return ci.a(this.j, 1);
  }

  public void j()
    throws cs
  {
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Resolution(");
    localStringBuilder.append("height:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("width:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  private static class a extends dx<be>
  {
    public void a(dn paramdn, be parambe)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!parambe.e())
          throw new do("Required field 'height' was not found in serialized data! Struct: " + toString());
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
          if (localdi.b == 8)
          {
            parambe.a = paramdn.w();
            parambe.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            parambe.b = paramdn.w();
            parambe.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!parambe.i())
        throw new do("Required field 'width' was not found in serialized data! Struct: " + toString());
      parambe.j();
    }

    public void b(dn paramdn, be parambe)
      throws cs
    {
      parambe.j();
      paramdn.a(be.k());
      paramdn.a(be.l());
      paramdn.a(parambe.a);
      paramdn.c();
      paramdn.a(be.m());
      paramdn.a(parambe.b);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public be.a a()
    {
      return new be.a(null);
    }
  }

  private static class c extends dy<be>
  {
    public void a(dn paramdn, be parambe)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(parambe.a);
      localdt.a(parambe.b);
    }

    public void b(dn paramdn, be parambe)
      throws cs
    {
      dt localdt = (dt)paramdn;
      parambe.a = localdt.w();
      parambe.a(true);
      parambe.b = localdt.w();
      parambe.b(true);
    }
  }

  private static class d
    implements dw
  {
    public be.c a()
    {
      return new be.c(null);
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
 * Qualified Name:     c.a.be
 * JD-Core Version:    0.6.0
 */