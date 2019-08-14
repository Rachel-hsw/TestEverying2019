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

public class ay
  implements cl<ay, e>, Serializable, Cloneable
{
  private static final int A = 3;
  public static final Map<e, cz> k;
  private static final ds l = new ds("MiscInfo");
  private static final di m = new di("time_zone", 8, 1);
  private static final di n = new di("language", 11, 2);
  private static final di o = new di("country", 11, 3);
  private static final di p = new di("latitude", 4, 4);
  private static final di q = new di("longitude", 4, 5);
  private static final di r = new di("carrier", 11, 6);
  private static final di s = new di("latency", 8, 7);
  private static final di t = new di("display_name", 11, 8);
  private static final di u = new di("access_type", 8, 9);
  private static final di v = new di("access_subtype", 11, 10);
  private static final Map<Class<? extends dv>, dw> w = new HashMap();
  private static final int x = 0;
  private static final int y = 1;
  private static final int z = 2;
  private byte B = 0;
  private e[] C;
  public int a;
  public String b;
  public String c;
  public double d;
  public double e;
  public String f;
  public int g;
  public String h;
  public m i;
  public String j;

  static
  {
    w.put(dx.class, new b(null));
    w.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("time_zone", 2, new da(8)));
    localEnumMap.put(e.b, new cz("language", 2, new da(11)));
    localEnumMap.put(e.c, new cz("country", 2, new da(11)));
    localEnumMap.put(e.d, new cz("latitude", 2, new da(4)));
    localEnumMap.put(e.e, new cz("longitude", 2, new da(4)));
    localEnumMap.put(e.f, new cz("carrier", 2, new da(11)));
    localEnumMap.put(e.g, new cz("latency", 2, new da(8)));
    localEnumMap.put(e.h, new cz("display_name", 2, new da(11)));
    localEnumMap.put(e.i, new cz("access_type", 2, new cy(16, m.class)));
    localEnumMap.put(e.j, new cz("access_subtype", 2, new da(11)));
    k = Collections.unmodifiableMap(localEnumMap);
    cz.a(ay.class, k);
  }

  public ay()
  {
    e[] arrayOfe = new e[10];
    arrayOfe[0] = e.a;
    arrayOfe[1] = e.b;
    arrayOfe[2] = e.c;
    arrayOfe[3] = e.d;
    arrayOfe[4] = e.e;
    arrayOfe[5] = e.f;
    arrayOfe[6] = e.g;
    arrayOfe[7] = e.h;
    arrayOfe[8] = e.i;
    arrayOfe[9] = e.j;
    this.C = arrayOfe;
  }

  public ay(ay paramay)
  {
    e[] arrayOfe = new e[10];
    arrayOfe[0] = e.a;
    arrayOfe[1] = e.b;
    arrayOfe[2] = e.c;
    arrayOfe[3] = e.d;
    arrayOfe[4] = e.e;
    arrayOfe[5] = e.f;
    arrayOfe[6] = e.g;
    arrayOfe[7] = e.h;
    arrayOfe[8] = e.i;
    arrayOfe[9] = e.j;
    this.C = arrayOfe;
    this.B = paramay.B;
    this.a = paramay.a;
    if (paramay.i())
      this.b = paramay.b;
    if (paramay.l())
      this.c = paramay.c;
    this.d = paramay.d;
    this.e = paramay.e;
    if (paramay.u())
      this.f = paramay.f;
    this.g = paramay.g;
    if (paramay.A())
      this.h = paramay.h;
    if (paramay.D())
      this.i = paramay.i;
    if (paramay.G())
      this.j = paramay.j;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.B = 0;
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

  public boolean A()
  {
    return this.h != null;
  }

  public m B()
  {
    return this.i;
  }

  public void C()
  {
    this.i = null;
  }

  public boolean D()
  {
    return this.i != null;
  }

  public String E()
  {
    return this.j;
  }

  public void F()
  {
    this.j = null;
  }

  public boolean G()
  {
    return this.j != null;
  }

  public void H()
    throws cs
  {
  }

  public ay a()
  {
    return new ay(this);
  }

  public ay a(double paramDouble)
  {
    this.d = paramDouble;
    d(true);
    return this;
  }

  public ay a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }

  public ay a(m paramm)
  {
    this.i = paramm;
    return this;
  }

  public ay a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)w.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 0, paramBoolean);
  }

  public ay b(double paramDouble)
  {
    this.e = paramDouble;
    e(true);
    return this;
  }

  public ay b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void b()
  {
    a(false);
    this.a = 0;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0.0D;
    e(false);
    this.e = 0.0D;
    this.f = null;
    g(false);
    this.g = 0;
    this.h = null;
    this.i = null;
    this.j = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)w.get(paramdn.D())).b().a(paramdn, this);
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

  public ay c(int paramInt)
  {
    this.g = paramInt;
    g(true);
    return this;
  }

  public ay c(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public e d(int paramInt)
  {
    return e.a(paramInt);
  }

  public ay d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public void d()
  {
    this.B = ci.b(this.B, 0);
  }

  public void d(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 1, paramBoolean);
  }

  public ay e(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public void e(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 2, paramBoolean);
  }

  public boolean e()
  {
    return ci.a(this.B, 0);
  }

  public String f()
  {
    return this.b;
  }

  public void f(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.f = null;
  }

  public void g(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 3, paramBoolean);
  }

  public void h()
  {
    this.b = null;
  }

  public void h(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.h = null;
  }

  public void i(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.i = null;
  }

  public boolean i()
  {
    return this.b != null;
  }

  public String j()
  {
    return this.c;
  }

  public void j(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.j = null;
  }

  public void k()
  {
    this.c = null;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public double m()
  {
    return this.d;
  }

  public void n()
  {
    this.B = ci.b(this.B, 1);
  }

  public boolean o()
  {
    return ci.a(this.B, 1);
  }

  public double p()
  {
    return this.e;
  }

  public void q()
  {
    this.B = ci.b(this.B, 2);
  }

  public boolean r()
  {
    return ci.a(this.B, 2);
  }

  public String s()
  {
    return this.f;
  }

  public void t()
  {
    this.f = null;
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("MiscInfo(");
    int i2 = 1;
    if (e())
    {
      localStringBuilder.append("time_zone:");
      localStringBuilder.append(this.a);
      i2 = 0;
    }
    if (i())
    {
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("language:");
      if (this.b == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (l())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("country:");
        if (this.c != null)
          break label440;
        localStringBuilder.append("null");
        label127: i2 = 0;
      }
      if (o())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("latitude:");
        localStringBuilder.append(this.d);
        i2 = 0;
      }
      if (r())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("longitude:");
        localStringBuilder.append(this.e);
        i2 = 0;
      }
      if (u())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("carrier:");
        if (this.f != null)
          break label452;
        localStringBuilder.append("null");
        label247: i2 = 0;
      }
      if (x())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("latency:");
        localStringBuilder.append(this.g);
        i2 = 0;
      }
      if (A())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("display_name:");
        if (this.h != null)
          break label464;
        localStringBuilder.append("null");
        label329: i2 = 0;
      }
      if (!D())
        break label502;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("access_type:");
      if (this.i != null)
        break label476;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label373: if (G())
      {
        if (i1 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("access_subtype:");
        if (this.j != null)
          break label490;
        localStringBuilder.append("null");
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.b);
        break;
        label440: localStringBuilder.append(this.c);
        break label127;
        label452: localStringBuilder.append(this.f);
        break label247;
        label464: localStringBuilder.append(this.h);
        break label329;
        label476: localStringBuilder.append(this.i);
        i1 = 0;
        break label373;
        label490: localStringBuilder.append(this.j);
      }
      label502: i1 = i2;
    }
  }

  public boolean u()
  {
    return this.f != null;
  }

  public int v()
  {
    return this.g;
  }

  public void w()
  {
    this.B = ci.b(this.B, 3);
  }

  public boolean x()
  {
    return ci.a(this.B, 3);
  }

  public String y()
  {
    return this.h;
  }

  public void z()
  {
    this.h = null;
  }

  private static class a extends dx<ay>
  {
    public void a(dn paramdn, ay paramay)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramay.H();
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
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      }
      while (true)
      {
        paramdn.m();
        break;
        if (localdi.b == 8)
        {
          paramay.a = paramdn.w();
          paramay.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramay.b = paramdn.z();
          paramay.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramay.c = paramdn.z();
          paramay.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 4)
        {
          paramay.d = paramdn.y();
          paramay.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 4)
        {
          paramay.e = paramdn.y();
          paramay.e(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramay.f = paramdn.z();
          paramay.f(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          paramay.g = paramdn.w();
          paramay.g(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramay.h = paramdn.z();
          paramay.h(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          paramay.i = m.a(paramdn.w());
          paramay.i(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramay.j = paramdn.z();
          paramay.j(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, ay paramay)
      throws cs
    {
      paramay.H();
      paramdn.a(ay.I());
      if (paramay.e())
      {
        paramdn.a(ay.J());
        paramdn.a(paramay.a);
        paramdn.c();
      }
      if ((paramay.b != null) && (paramay.i()))
      {
        paramdn.a(ay.K());
        paramdn.a(paramay.b);
        paramdn.c();
      }
      if ((paramay.c != null) && (paramay.l()))
      {
        paramdn.a(ay.L());
        paramdn.a(paramay.c);
        paramdn.c();
      }
      if (paramay.o())
      {
        paramdn.a(ay.M());
        paramdn.a(paramay.d);
        paramdn.c();
      }
      if (paramay.r())
      {
        paramdn.a(ay.N());
        paramdn.a(paramay.e);
        paramdn.c();
      }
      if ((paramay.f != null) && (paramay.u()))
      {
        paramdn.a(ay.O());
        paramdn.a(paramay.f);
        paramdn.c();
      }
      if (paramay.x())
      {
        paramdn.a(ay.P());
        paramdn.a(paramay.g);
        paramdn.c();
      }
      if ((paramay.h != null) && (paramay.A()))
      {
        paramdn.a(ay.Q());
        paramdn.a(paramay.h);
        paramdn.c();
      }
      if ((paramay.i != null) && (paramay.D()))
      {
        paramdn.a(ay.R());
        paramdn.a(paramay.i.a());
        paramdn.c();
      }
      if ((paramay.j != null) && (paramay.G()))
      {
        paramdn.a(ay.S());
        paramdn.a(paramay.j);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ay.a a()
    {
      return new ay.a(null);
    }
  }

  private static class c extends dy<ay>
  {
    public void a(dn paramdn, ay paramay)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = new BitSet();
      if (paramay.e())
        localBitSet.set(0);
      if (paramay.i())
        localBitSet.set(1);
      if (paramay.l())
        localBitSet.set(2);
      if (paramay.o())
        localBitSet.set(3);
      if (paramay.r())
        localBitSet.set(4);
      if (paramay.u())
        localBitSet.set(5);
      if (paramay.x())
        localBitSet.set(6);
      if (paramay.A())
        localBitSet.set(7);
      if (paramay.D())
        localBitSet.set(8);
      if (paramay.G())
        localBitSet.set(9);
      localdt.a(localBitSet, 10);
      if (paramay.e())
        localdt.a(paramay.a);
      if (paramay.i())
        localdt.a(paramay.b);
      if (paramay.l())
        localdt.a(paramay.c);
      if (paramay.o())
        localdt.a(paramay.d);
      if (paramay.r())
        localdt.a(paramay.e);
      if (paramay.u())
        localdt.a(paramay.f);
      if (paramay.x())
        localdt.a(paramay.g);
      if (paramay.A())
        localdt.a(paramay.h);
      if (paramay.D())
        localdt.a(paramay.i.a());
      if (paramay.G())
        localdt.a(paramay.j);
    }

    public void b(dn paramdn, ay paramay)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = localdt.b(10);
      if (localBitSet.get(0))
      {
        paramay.a = localdt.w();
        paramay.a(true);
      }
      if (localBitSet.get(1))
      {
        paramay.b = localdt.z();
        paramay.b(true);
      }
      if (localBitSet.get(2))
      {
        paramay.c = localdt.z();
        paramay.c(true);
      }
      if (localBitSet.get(3))
      {
        paramay.d = localdt.y();
        paramay.d(true);
      }
      if (localBitSet.get(4))
      {
        paramay.e = localdt.y();
        paramay.e(true);
      }
      if (localBitSet.get(5))
      {
        paramay.f = localdt.z();
        paramay.f(true);
      }
      if (localBitSet.get(6))
      {
        paramay.g = localdt.w();
        paramay.g(true);
      }
      if (localBitSet.get(7))
      {
        paramay.h = localdt.z();
        paramay.h(true);
      }
      if (localBitSet.get(8))
      {
        paramay.i = m.a(localdt.w());
        paramay.i(true);
      }
      if (localBitSet.get(9))
      {
        paramay.j = localdt.z();
        paramay.j(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public ay.c a()
    {
      return new ay.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> k;
    private final short l;
    private final String m;

    static
    {
      e[] arrayOfe = new e[10];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      arrayOfe[5] = f;
      arrayOfe[6] = g;
      arrayOfe[7] = h;
      arrayOfe[8] = i;
      arrayOfe[9] = j;
      n = arrayOfe;
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        k.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
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
        return d;
      case 5:
        return e;
      case 6:
        return f;
      case 7:
        return g;
      case 8:
        return h;
      case 9:
        return i;
      case 10:
      }
      return j;
    }

    public static e a(String paramString)
    {
      return (e)k.get(paramString);
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
      return this.l;
    }

    public String b()
    {
      return this.m;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ay
 * JD-Core Version:    0.6.0
 */