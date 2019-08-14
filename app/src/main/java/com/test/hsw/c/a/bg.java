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

public class bg
  implements cl<bg, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("Response");
  private static final di f = new di("resp_code", 8, 1);
  private static final di g = new di("msg", 11, 2);
  private static final di h = new di("imprint", 12, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j;
  public int a;
  public String b;
  public ao c;
  private byte k = 0;
  private e[] l;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("resp_code", 1, new da(8)));
    localEnumMap.put(e.b, new cz("msg", 2, new da(11)));
    localEnumMap.put(e.c, new cz("imprint", 2, new de(12, ao.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(bg.class, d);
  }

  public bg()
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    this.l = arrayOfe;
  }

  public bg(int paramInt)
  {
    this();
    this.a = paramInt;
    a(true);
  }

  public bg(bg parambg)
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    this.l = arrayOfe;
    this.k = parambg.k;
    this.a = parambg.a;
    if (parambg.i())
      this.b = parambg.b;
    if (parambg.l())
      this.c = new ao(parambg.c);
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

  public bg a()
  {
    return new bg(this);
  }

  public bg a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }

  public bg a(ao paramao)
  {
    this.c = paramao;
    return this;
  }

  public bg a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    this.k = ci.a(this.k, 0, paramBoolean);
  }

  public void b()
  {
    a(false);
    this.a = 0;
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
    if (!paramBoolean)
      this.b = null;
  }

  public int c()
  {
    return this.a;
  }

  public e c(int paramInt)
  {
    return e.a(paramInt);
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public void d()
  {
    this.k = ci.b(this.k, 0);
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

  public ao j()
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
    if (this.c != null)
      this.c.n();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response(");
    localStringBuilder.append("resp_code:");
    localStringBuilder.append(this.a);
    if (i())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("msg:");
      if (this.b == null)
        localStringBuilder.append("null");
    }
    else if (l())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("imprint:");
      if (this.c != null)
        break label127;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label127: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<bg>
  {
    public void a(dn paramdn, bg parambg)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!parambg.e())
          throw new do("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
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
            parambg.a = paramdn.w();
            parambg.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambg.b = paramdn.z();
            parambg.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 12)
          {
            parambg.c = new ao();
            parambg.c.a(paramdn);
            parambg.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      parambg.m();
    }

    public void b(dn paramdn, bg parambg)
      throws cs
    {
      parambg.m();
      paramdn.a(bg.n());
      paramdn.a(bg.o());
      paramdn.a(parambg.a);
      paramdn.c();
      if ((parambg.b != null) && (parambg.i()))
      {
        paramdn.a(bg.p());
        paramdn.a(parambg.b);
        paramdn.c();
      }
      if ((parambg.c != null) && (parambg.l()))
      {
        paramdn.a(bg.q());
        parambg.c.b(paramdn);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public bg.a a()
    {
      return new bg.a(null);
    }
  }

  private static class c extends dy<bg>
  {
    public void a(dn paramdn, bg parambg)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(parambg.a);
      BitSet localBitSet = new BitSet();
      if (parambg.i())
        localBitSet.set(0);
      if (parambg.l())
        localBitSet.set(1);
      localdt.a(localBitSet, 2);
      if (parambg.i())
        localdt.a(parambg.b);
      if (parambg.l())
        parambg.c.b(localdt);
    }

    public void b(dn paramdn, bg parambg)
      throws cs
    {
      dt localdt = (dt)paramdn;
      parambg.a = localdt.w();
      parambg.a(true);
      BitSet localBitSet = localdt.b(2);
      if (localBitSet.get(0))
      {
        parambg.b = localdt.z();
        parambg.b(true);
      }
      if (localBitSet.get(1))
      {
        parambg.c = new ao();
        parambg.c.a(localdt);
        parambg.c(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public bg.c a()
    {
      return new bg.c(null);
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
 * Qualified Name:     c.a.bg
 * JD-Core Version:    0.6.0
 */