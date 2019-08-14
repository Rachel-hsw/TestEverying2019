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

public class p
  implements cl<p, e>, Serializable, Cloneable
{
  public static final Map<e, cz> c;
  private static final ds d = new ds("ActiveUser");
  private static final di e = new di("provider", 11, 1);
  private static final di f = new di("puid", 11, 2);
  private static final Map<Class<? extends dv>, dw> g = new HashMap();
  public String a;
  public String b;

  static
  {
    g.put(dx.class, new b(null));
    g.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("provider", 1, new da(11)));
    localEnumMap.put(e.b, new cz("puid", 1, new da(11)));
    c = Collections.unmodifiableMap(localEnumMap);
    cz.a(p.class, c);
  }

  public p()
  {
  }

  public p(p paramp)
  {
    if (paramp.e())
      this.a = paramp.a;
    if (paramp.i())
      this.b = paramp.b;
  }

  public p(String paramString1, String paramString2)
  {
    this();
    this.a = paramString1;
    this.b = paramString2;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
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

  public p a()
  {
    return new p(this);
  }

  public p a(String paramString)
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

  public p b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)g.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
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

  public void j()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'provider' was not present! Struct: " + toString());
    if (this.b == null)
      throw new do("Required field 'puid' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ActiveUser(");
    localStringBuilder.append("provider:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("puid:");
      if (this.b != null)
        break label83;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label83: localStringBuilder.append(this.b);
    }
  }

  private static class a extends dx<p>
  {
    public void a(dn paramdn, p paramp)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramp.j();
        return;
      }
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
          paramp.a = paramdn.z();
          paramp.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramp.b = paramdn.z();
          paramp.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, p paramp)
      throws cs
    {
      paramp.j();
      paramdn.a(p.k());
      if (paramp.a != null)
      {
        paramdn.a(p.l());
        paramdn.a(paramp.a);
        paramdn.c();
      }
      if (paramp.b != null)
      {
        paramdn.a(p.m());
        paramdn.a(paramp.b);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public p.a a()
    {
      return new p.a(null);
    }
  }

  private static class c extends dy<p>
  {
    public void a(dn paramdn, p paramp)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramp.a);
      localdt.a(paramp.b);
    }

    public void b(dn paramdn, p paramp)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramp.a = localdt.z();
      paramp.a(true);
      paramp.b = localdt.z();
      paramp.b(true);
    }
  }

  private static class d
    implements dw
  {
    public p.c a()
    {
      return new p.c(null);
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
 * Qualified Name:     c.a.p
 * JD-Core Version:    0.6.0
 */