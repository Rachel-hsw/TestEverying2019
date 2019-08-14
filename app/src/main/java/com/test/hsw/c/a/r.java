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

public class r
  implements cl<r, e>, Serializable, Cloneable
{
  public static final Map<e, cz> k;
  private static final ds l = new ds("AppInfo");
  private static final di m = new di("key", 11, 1);
  private static final di n = new di("version", 11, 2);
  private static final di o = new di("version_index", 8, 3);
  private static final di p = new di("package_name", 11, 4);
  private static final di q = new di("sdk_type", 8, 5);
  private static final di r = new di("sdk_version", 11, 6);
  private static final di s = new di("channel", 11, 7);
  private static final di t = new di("wrapper_type", 11, 8);
  private static final di u = new di("wrapper_version", 11, 9);
  private static final di v = new di("vertical_type", 8, 10);
  private static final Map<Class<? extends dv>, dw> w = new HashMap();
  private static final int x = 0;
  private static final int y = 1;
  private e[] A;
  public String a;
  public String b;
  public int c;
  public String d;
  public bi e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  private byte z = 0;

  static
  {
    w.put(dx.class, new b(null));
    w.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("key", 1, new da(11)));
    localEnumMap.put(e.b, new cz("version", 2, new da(11)));
    localEnumMap.put(e.c, new cz("version_index", 2, new da(8)));
    localEnumMap.put(e.d, new cz("package_name", 2, new da(11)));
    localEnumMap.put(e.e, new cz("sdk_type", 1, new cy(16, bi.class)));
    localEnumMap.put(e.f, new cz("sdk_version", 1, new da(11)));
    localEnumMap.put(e.g, new cz("channel", 1, new da(11)));
    localEnumMap.put(e.h, new cz("wrapper_type", 2, new da(11)));
    localEnumMap.put(e.i, new cz("wrapper_version", 2, new da(11)));
    localEnumMap.put(e.j, new cz("vertical_type", 2, new da(8)));
    k = Collections.unmodifiableMap(localEnumMap);
    cz.a(r.class, k);
  }

  public r()
  {
    e[] arrayOfe = new e[6];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    arrayOfe[3] = e.h;
    arrayOfe[4] = e.i;
    arrayOfe[5] = e.j;
    this.A = arrayOfe;
  }

  public r(r paramr)
  {
    e[] arrayOfe = new e[6];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    arrayOfe[3] = e.h;
    arrayOfe[4] = e.i;
    arrayOfe[5] = e.j;
    this.A = arrayOfe;
    this.z = paramr.z;
    if (paramr.e())
      this.a = paramr.a;
    if (paramr.i())
      this.b = paramr.b;
    this.c = paramr.c;
    if (paramr.o())
      this.d = paramr.d;
    if (paramr.r())
      this.e = paramr.e;
    if (paramr.u())
      this.f = paramr.f;
    if (paramr.x())
      this.g = paramr.g;
    if (paramr.A())
      this.h = paramr.h;
    if (paramr.D())
      this.i = paramr.i;
    this.j = paramr.j;
  }

  public r(String paramString1, bi parambi, String paramString2, String paramString3)
  {
    this();
    this.a = paramString1;
    this.e = parambi;
    this.f = paramString2;
    this.g = paramString3;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.z = 0;
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

  public String B()
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

  public int E()
  {
    return this.j;
  }

  public void F()
  {
    this.z = ci.b(this.z, 1);
  }

  public boolean G()
  {
    return ci.a(this.z, 1);
  }

  public void H()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'key' was not present! Struct: " + toString());
    if (this.e == null)
      throw new do("Required field 'sdk_type' was not present! Struct: " + toString());
    if (this.f == null)
      throw new do("Required field 'sdk_version' was not present! Struct: " + toString());
    if (this.g == null)
      throw new do("Required field 'channel' was not present! Struct: " + toString());
  }

  public r a()
  {
    return new r(this);
  }

  public r a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }

  public r a(bi parambi)
  {
    this.e = parambi;
    return this;
  }

  public r a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)w.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public r b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    c(false);
    this.c = 0;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    j(false);
    this.j = 0;
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

  public r c(int paramInt)
  {
    this.j = paramInt;
    j(true);
    return this;
  }

  public r c(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public String c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    this.z = ci.a(this.z, 0, paramBoolean);
  }

  public e d(int paramInt)
  {
    return e.a(paramInt);
  }

  public r d(String paramString)
  {
    this.f = paramString;
    return this;
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

  public r e(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.e = null;
  }

  public boolean e()
  {
    return this.a != null;
  }

  public r f(String paramString)
  {
    this.h = paramString;
    return this;
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

  public r g(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public void g(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.g = null;
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

  public int j()
  {
    return this.c;
  }

  public void j(boolean paramBoolean)
  {
    this.z = ci.a(this.z, 1, paramBoolean);
  }

  public void k()
  {
    this.z = ci.b(this.z, 0);
  }

  public boolean l()
  {
    return ci.a(this.z, 0);
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

  public bi p()
  {
    return this.e;
  }

  public void q()
  {
    this.e = null;
  }

  public boolean r()
  {
    return this.e != null;
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
    StringBuilder localStringBuilder = new StringBuilder("AppInfo(");
    localStringBuilder.append("key:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("version:");
        if (this.b != null)
          break label368;
        localStringBuilder.append("null");
      }
      label72: if (l())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("version_index:");
        localStringBuilder.append(this.c);
      }
      if (o())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("package_name:");
        if (this.d != null)
          break label380;
        localStringBuilder.append("null");
      }
      label142: localStringBuilder.append(", ");
      localStringBuilder.append("sdk_type:");
      if (this.e != null)
        break label392;
      localStringBuilder.append("null");
      label173: localStringBuilder.append(", ");
      localStringBuilder.append("sdk_version:");
      if (this.f != null)
        break label404;
      localStringBuilder.append("null");
      label204: localStringBuilder.append(", ");
      localStringBuilder.append("channel:");
      if (this.g != null)
        break label416;
      localStringBuilder.append("null");
      label235: if (A())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("wrapper_type:");
        if (this.h != null)
          break label428;
        localStringBuilder.append("null");
      }
      label273: if (D())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("wrapper_version:");
        if (this.i != null)
          break label440;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      if (G())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("vertical_type:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label368: localStringBuilder.append(this.b);
      break label72;
      label380: localStringBuilder.append(this.d);
      break label142;
      label392: localStringBuilder.append(this.e);
      break label173;
      label404: localStringBuilder.append(this.f);
      break label204;
      label416: localStringBuilder.append(this.g);
      break label235;
      label428: localStringBuilder.append(this.h);
      break label273;
      label440: localStringBuilder.append(this.i);
    }
  }

  public boolean u()
  {
    return this.f != null;
  }

  public String v()
  {
    return this.g;
  }

  public void w()
  {
    this.g = null;
  }

  public boolean x()
  {
    return this.g != null;
  }

  public String y()
  {
    return this.h;
  }

  public void z()
  {
    this.h = null;
  }

  private static class a extends dx<r>
  {
    public void a(dn paramdn, r paramr)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramr.H();
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
        if (localdi.b == 11)
        {
          paramr.a = paramdn.z();
          paramr.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.b = paramdn.z();
          paramr.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          paramr.c = paramdn.w();
          paramr.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.d = paramdn.z();
          paramr.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          paramr.e = bi.a(paramdn.w());
          paramr.e(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.f = paramdn.z();
          paramr.f(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.g = paramdn.z();
          paramr.g(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.h = paramdn.z();
          paramr.h(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramr.i = paramdn.z();
          paramr.i(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 8)
        {
          paramr.j = paramdn.w();
          paramr.j(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, r paramr)
      throws cs
    {
      paramr.H();
      paramdn.a(r.I());
      if (paramr.a != null)
      {
        paramdn.a(r.J());
        paramdn.a(paramr.a);
        paramdn.c();
      }
      if ((paramr.b != null) && (paramr.i()))
      {
        paramdn.a(r.K());
        paramdn.a(paramr.b);
        paramdn.c();
      }
      if (paramr.l())
      {
        paramdn.a(r.L());
        paramdn.a(paramr.c);
        paramdn.c();
      }
      if ((paramr.d != null) && (paramr.o()))
      {
        paramdn.a(r.M());
        paramdn.a(paramr.d);
        paramdn.c();
      }
      if (paramr.e != null)
      {
        paramdn.a(r.N());
        paramdn.a(paramr.e.a());
        paramdn.c();
      }
      if (paramr.f != null)
      {
        paramdn.a(r.O());
        paramdn.a(paramr.f);
        paramdn.c();
      }
      if (paramr.g != null)
      {
        paramdn.a(r.P());
        paramdn.a(paramr.g);
        paramdn.c();
      }
      if ((paramr.h != null) && (paramr.A()))
      {
        paramdn.a(r.Q());
        paramdn.a(paramr.h);
        paramdn.c();
      }
      if ((paramr.i != null) && (paramr.D()))
      {
        paramdn.a(r.R());
        paramdn.a(paramr.i);
        paramdn.c();
      }
      if (paramr.G())
      {
        paramdn.a(r.S());
        paramdn.a(paramr.j);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public r.a a()
    {
      return new r.a(null);
    }
  }

  private static class c extends dy<r>
  {
    public void a(dn paramdn, r paramr)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramr.a);
      localdt.a(paramr.e.a());
      localdt.a(paramr.f);
      localdt.a(paramr.g);
      BitSet localBitSet = new BitSet();
      if (paramr.i())
        localBitSet.set(0);
      if (paramr.l())
        localBitSet.set(1);
      if (paramr.o())
        localBitSet.set(2);
      if (paramr.A())
        localBitSet.set(3);
      if (paramr.D())
        localBitSet.set(4);
      if (paramr.G())
        localBitSet.set(5);
      localdt.a(localBitSet, 6);
      if (paramr.i())
        localdt.a(paramr.b);
      if (paramr.l())
        localdt.a(paramr.c);
      if (paramr.o())
        localdt.a(paramr.d);
      if (paramr.A())
        localdt.a(paramr.h);
      if (paramr.D())
        localdt.a(paramr.i);
      if (paramr.G())
        localdt.a(paramr.j);
    }

    public void b(dn paramdn, r paramr)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramr.a = localdt.z();
      paramr.a(true);
      paramr.e = bi.a(localdt.w());
      paramr.e(true);
      paramr.f = localdt.z();
      paramr.f(true);
      paramr.g = localdt.z();
      paramr.g(true);
      BitSet localBitSet = localdt.b(6);
      if (localBitSet.get(0))
      {
        paramr.b = localdt.z();
        paramr.b(true);
      }
      if (localBitSet.get(1))
      {
        paramr.c = localdt.w();
        paramr.c(true);
      }
      if (localBitSet.get(2))
      {
        paramr.d = localdt.z();
        paramr.d(true);
      }
      if (localBitSet.get(3))
      {
        paramr.h = localdt.z();
        paramr.h(true);
      }
      if (localBitSet.get(4))
      {
        paramr.i = localdt.z();
        paramr.i(true);
      }
      if (localBitSet.get(5))
      {
        paramr.j = localdt.w();
        paramr.j(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public r.c a()
    {
      return new r.c(null);
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
 * Qualified Name:     c.a.r
 * JD-Core Version:    0.6.0
 */