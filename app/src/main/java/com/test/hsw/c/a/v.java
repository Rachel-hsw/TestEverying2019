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

public class v
  implements cl<v, e>, Serializable, Cloneable
{
  public static final Map<e, cz> b;
  private static final ds c = new ds("ControlPolicy");
  private static final di d = new di("latent", 12, 1);
  private static final Map<Class<? extends dv>, dw> e = new HashMap();
  public au a;
  private e[] f;

  static
  {
    e.put(dx.class, new b(null));
    e.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("latent", 2, new de(12, au.class)));
    b = Collections.unmodifiableMap(localEnumMap);
    cz.a(v.class, b);
  }

  public v()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.a;
    this.f = arrayOfe;
  }

  public v(v paramv)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.a;
    this.f = arrayOfe;
    if (paramv.e())
      this.a = new au(paramv.a);
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

  public v a()
  {
    return new v(this);
  }

  public v a(au paramau)
  {
    this.a = paramau;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)e.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public void b()
  {
    this.a = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)e.get(paramdn.D())).b().a(paramdn, this);
  }

  public au c()
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

  public void f()
    throws cs
  {
    if (this.a != null)
      this.a.j();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ControlPolicy(");
    if (e())
    {
      localStringBuilder.append("latent:");
      if (this.a != null)
        break label50;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      label50: localStringBuilder.append(this.a);
    }
  }

  private static class a extends dx<v>
  {
    public void a(dn paramdn, v paramv)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramv.f();
        return;
      }
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
        if (localdi.b == 12)
        {
          paramv.a = new au();
          paramv.a.a(paramdn);
          paramv.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, v paramv)
      throws cs
    {
      paramv.f();
      paramdn.a(v.h());
      if ((paramv.a != null) && (paramv.e()))
      {
        paramdn.a(v.i());
        paramv.a.b(paramdn);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public v.a a()
    {
      return new v.a(null);
    }
  }

  private static class c extends dy<v>
  {
    public void a(dn paramdn, v paramv)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = new BitSet();
      if (paramv.e())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (paramv.e())
        paramv.a.b(localdt);
    }

    public void b(dn paramdn, v paramv)
      throws cs
    {
      dt localdt = (dt)paramdn;
      if (localdt.b(1).get(0))
      {
        paramv.a = new au();
        paramv.a.a(localdt);
        paramv.a(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public v.c a()
    {
      return new v.c(null);
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
 * Qualified Name:     c.a.v
 * JD-Core Version:    0.6.0
 */