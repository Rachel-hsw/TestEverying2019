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

public class bp
  implements cl<bp, e>, Serializable, Cloneable
{
  public static final Map<e, cz> e;
  private static final ds f = new ds("UserInfo");
  private static final di g = new di("gender", 8, 1);
  private static final di h = new di("age", 8, 2);
  private static final di i = new di("id", 11, 3);
  private static final di j = new di("source", 11, 4);
  private static final Map<Class<? extends dv>, dw> k = new HashMap();
  private static final int l;
  public ag a;
  public int b;
  public String c;
  public String d;
  private byte m = 0;
  private e[] n;

  static
  {
    k.put(dx.class, new b(null));
    k.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("gender", 2, new cy(16, ag.class)));
    localEnumMap.put(e.b, new cz("age", 2, new da(8)));
    localEnumMap.put(e.c, new cz("id", 2, new da(11)));
    localEnumMap.put(e.d, new cz("source", 2, new da(11)));
    e = Collections.unmodifiableMap(localEnumMap);
    cz.a(bp.class, e);
  }

  public bp()
  {
    e[] arrayOfe = new e[4];
    arrayOfe[0] = e.a;
    arrayOfe[1] = e.b;
    arrayOfe[2] = e.c;
    arrayOfe[3] = e.d;
    this.n = arrayOfe;
  }

  public bp(bp parambp)
  {
    e[] arrayOfe = new e[4];
    arrayOfe[0] = e.a;
    arrayOfe[1] = e.b;
    arrayOfe[2] = e.c;
    arrayOfe[3] = e.d;
    this.n = arrayOfe;
    this.m = parambp.m;
    if (parambp.e())
      this.a = parambp.a;
    this.b = parambp.b;
    if (parambp.l())
      this.c = parambp.c;
    if (parambp.o())
      this.d = parambp.d;
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

  public bp a()
  {
    return new bp(this);
  }

  public bp a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }

  public bp a(ag paramag)
  {
    this.a = paramag;
    return this;
  }

  public bp a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)k.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public bp b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0;
    this.c = null;
    this.d = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)k.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 0, paramBoolean);
  }

  public ag c()
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
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.d = null;
  }

  public boolean e()
  {
    return this.a != null;
  }

  public int f()
  {
    return this.b;
  }

  public void h()
  {
    this.m = ci.b(this.m, 0);
  }

  public boolean i()
  {
    return ci.a(this.m, 0);
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

  public String m()
  {
    return this.d;
  }

  public void n()
  {
    this.d = null;
  }

  public boolean o()
  {
    return this.d != null;
  }

  public void p()
    throws cs
  {
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("UserInfo(");
    int i2 = 1;
    if (e())
    {
      localStringBuilder.append("gender:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (i())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("age:");
        localStringBuilder.append(this.b);
        i2 = 0;
      }
      if (!l())
        break label219;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("id:");
      if (this.c != null)
        break label193;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label126: if (o())
      {
        if (i1 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("source:");
        if (this.d != null)
          break label207;
        localStringBuilder.append("null");
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label193: localStringBuilder.append(this.c);
        i1 = 0;
        break label126;
        label207: localStringBuilder.append(this.d);
      }
      label219: i1 = i2;
    }
  }

  private static class a extends dx<bp>
  {
    public void a(dn paramdn, bp parambp)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        parambp.p();
        return;
      }
      switch (localdi.c)
      {
      default:
        dq.a(paramdn, localdi.b);
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        paramdn.m();
        break;
        if (localdi.b == 8)
        {
          parambp.a = ag.a(paramdn.w());
          parambp.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          parambp.b = paramdn.w();
          parambp.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          parambp.c = paramdn.z();
          parambp.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          parambp.d = paramdn.z();
          parambp.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, bp parambp)
      throws cs
    {
      parambp.p();
      paramdn.a(bp.q());
      if ((parambp.a != null) && (parambp.e()))
      {
        paramdn.a(bp.r());
        paramdn.a(parambp.a.a());
        paramdn.c();
      }
      if (parambp.i())
      {
        paramdn.a(bp.s());
        paramdn.a(parambp.b);
        paramdn.c();
      }
      if ((parambp.c != null) && (parambp.l()))
      {
        paramdn.a(bp.t());
        paramdn.a(parambp.c);
        paramdn.c();
      }
      if ((parambp.d != null) && (parambp.o()))
      {
        paramdn.a(bp.u());
        paramdn.a(parambp.d);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public bp.a a()
    {
      return new bp.a(null);
    }
  }

  private static class c extends dy<bp>
  {
    public void a(dn paramdn, bp parambp)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = new BitSet();
      if (parambp.e())
        localBitSet.set(0);
      if (parambp.i())
        localBitSet.set(1);
      if (parambp.l())
        localBitSet.set(2);
      if (parambp.o())
        localBitSet.set(3);
      localdt.a(localBitSet, 4);
      if (parambp.e())
        localdt.a(parambp.a.a());
      if (parambp.i())
        localdt.a(parambp.b);
      if (parambp.l())
        localdt.a(parambp.c);
      if (parambp.o())
        localdt.a(parambp.d);
    }

    public void b(dn paramdn, bp parambp)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = localdt.b(4);
      if (localBitSet.get(0))
      {
        parambp.a = ag.a(localdt.w());
        parambp.a(true);
      }
      if (localBitSet.get(1))
      {
        parambp.b = localdt.w();
        parambp.b(true);
      }
      if (localBitSet.get(2))
      {
        parambp.c = localdt.z();
        parambp.c(true);
      }
      if (localBitSet.get(3))
      {
        parambp.d = localdt.z();
        parambp.d(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public bp.c a()
    {
      return new bp.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> e;
    private final short f;
    private final String g;

    static
    {
      e[] arrayOfe = new e[4];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      h = arrayOfe;
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        e.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
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
        return c;
      case 4:
      }
      return d;
    }

    public static e a(String paramString)
    {
      return (e)e.get(paramString);
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
      return this.f;
    }

    public String b()
    {
      return this.g;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.bp
 * JD-Core Version:    0.6.0
 */