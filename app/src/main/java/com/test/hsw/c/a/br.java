package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class br
  implements cl<br, e>, Serializable, Cloneable
{
  private static final int A = 3;
  public static final Map<e, cz> k;
  private static final ds l = new ds("UMEnvelope");
  private static final di m = new di("version", 11, 1);
  private static final di n = new di("address", 11, 2);
  private static final di o = new di("signature", 11, 3);
  private static final di p = new di("serial_num", 8, 4);
  private static final di q = new di("ts_secs", 8, 5);
  private static final di r = new di("length", 8, 6);
  private static final di s = new di("entity", 11, 7);
  private static final di t = new di("guid", 11, 8);
  private static final di u = new di("checksum", 11, 9);
  private static final di v = new di("codex", 8, 10);
  private static final Map<Class<? extends dv>, dw> w = new HashMap();
  private static final int x = 0;
  private static final int y = 1;
  private static final int z = 2;
  private byte B = 0;
  private e[] C;
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public ByteBuffer g;
  public String h;
  public String i;
  public int j;

  static
  {
    w.put(dx.class, new b(null));
    w.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("version", 1, new da(11)));
    localEnumMap.put(e.b, new cz("address", 1, new da(11)));
    localEnumMap.put(e.c, new cz("signature", 1, new da(11)));
    localEnumMap.put(e.d, new cz("serial_num", 1, new da(8)));
    localEnumMap.put(e.e, new cz("ts_secs", 1, new da(8)));
    localEnumMap.put(e.f, new cz("length", 1, new da(8)));
    localEnumMap.put(e.g, new cz("entity", 1, new da(11, true)));
    localEnumMap.put(e.h, new cz("guid", 1, new da(11)));
    localEnumMap.put(e.i, new cz("checksum", 1, new da(11)));
    localEnumMap.put(e.j, new cz("codex", 2, new da(8)));
    k = Collections.unmodifiableMap(localEnumMap);
    cz.a(br.class, k);
  }

  public br()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.j;
    this.C = arrayOfe;
  }

  public br(br parambr)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.j;
    this.C = arrayOfe;
    this.B = parambr.B;
    if (parambr.e())
      this.a = parambr.a;
    if (parambr.i())
      this.b = parambr.b;
    if (parambr.l())
      this.c = parambr.c;
    this.d = parambr.d;
    this.e = parambr.e;
    this.f = parambr.f;
    if (parambr.y())
      this.g = cm.d(parambr.g);
    if (parambr.B())
      this.h = parambr.h;
    if (parambr.E())
      this.i = parambr.i;
    this.j = parambr.j;
  }

  public br(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, String paramString4, String paramString5)
  {
    this();
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    d(true);
    this.e = paramInt2;
    e(true);
    this.f = paramInt3;
    f(true);
    this.g = paramByteBuffer;
    this.h = paramString4;
    this.i = paramString5;
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

  public void A()
  {
    this.h = null;
  }

  public boolean B()
  {
    return this.h != null;
  }

  public String C()
  {
    return this.i;
  }

  public void D()
  {
    this.i = null;
  }

  public boolean E()
  {
    return this.i != null;
  }

  public int F()
  {
    return this.j;
  }

  public void G()
  {
    this.B = ci.b(this.B, 3);
  }

  public boolean H()
  {
    return ci.a(this.B, 3);
  }

  public void I()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'version' was not present! Struct: " + toString());
    if (this.b == null)
      throw new do("Required field 'address' was not present! Struct: " + toString());
    if (this.c == null)
      throw new do("Required field 'signature' was not present! Struct: " + toString());
    if (this.g == null)
      throw new do("Required field 'entity' was not present! Struct: " + toString());
    if (this.h == null)
      throw new do("Required field 'guid' was not present! Struct: " + toString());
    if (this.i == null)
      throw new do("Required field 'checksum' was not present! Struct: " + toString());
  }

  public br a()
  {
    return new br(this);
  }

  public br a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }

  public br a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public br a(ByteBuffer paramByteBuffer)
  {
    this.g = paramByteBuffer;
    return this;
  }

  public br a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null);
    for (ByteBuffer localByteBuffer = (ByteBuffer)null; ; localByteBuffer = ByteBuffer.wrap(paramArrayOfByte))
    {
      a(localByteBuffer);
      return this;
    }
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

  public br b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0;
    e(false);
    this.e = 0;
    f(false);
    this.f = 0;
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

  public br c(int paramInt)
  {
    this.e = paramInt;
    e(true);
    return this;
  }

  public br c(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String c()
  {
    return this.a;
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public br d(int paramInt)
  {
    this.f = paramInt;
    f(true);
    return this;
  }

  public br d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 0, paramBoolean);
  }

  public br e(int paramInt)
  {
    this.j = paramInt;
    j(true);
    return this;
  }

  public br e(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public void e(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 1, paramBoolean);
  }

  public boolean e()
  {
    return this.a != null;
  }

  public e f(int paramInt)
  {
    return e.a(paramInt);
  }

  public String f()
  {
    return this.b;
  }

  public void f(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 2, paramBoolean);
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

  public String j()
  {
    return this.c;
  }

  public void j(boolean paramBoolean)
  {
    this.B = ci.a(this.B, 3, paramBoolean);
  }

  public void k()
  {
    this.c = null;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public int m()
  {
    return this.d;
  }

  public void n()
  {
    this.B = ci.b(this.B, 0);
  }

  public boolean o()
  {
    return ci.a(this.B, 0);
  }

  public int p()
  {
    return this.e;
  }

  public void q()
  {
    this.B = ci.b(this.B, 1);
  }

  public boolean r()
  {
    return ci.a(this.B, 1);
  }

  public int s()
  {
    return this.f;
  }

  public void t()
  {
    this.B = ci.b(this.B, 2);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UMEnvelope(");
    localStringBuilder.append("version:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("address:");
      if (this.b != null)
        break label321;
      localStringBuilder.append("null");
      label65: localStringBuilder.append(", ");
      localStringBuilder.append("signature:");
      if (this.c != null)
        break label333;
      localStringBuilder.append("null");
      label96: localStringBuilder.append(", ");
      localStringBuilder.append("serial_num:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", ");
      localStringBuilder.append("ts_secs:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append("length:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append("entity:");
      if (this.g != null)
        break label345;
      localStringBuilder.append("null");
      label202: localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.h != null)
        break label356;
      localStringBuilder.append("null");
      label233: localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.i != null)
        break label368;
      localStringBuilder.append("null");
    }
    while (true)
    {
      if (H())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("codex:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label321: localStringBuilder.append(this.b);
      break label65;
      label333: localStringBuilder.append(this.c);
      break label96;
      label345: cm.a(this.g, localStringBuilder);
      break label202;
      label356: localStringBuilder.append(this.h);
      break label233;
      label368: localStringBuilder.append(this.i);
    }
  }

  public boolean u()
  {
    return ci.a(this.B, 2);
  }

  public byte[] v()
  {
    a(cm.c(this.g));
    if (this.g == null)
      return null;
    return this.g.array();
  }

  public ByteBuffer w()
  {
    return this.g;
  }

  public void x()
  {
    this.g = null;
  }

  public boolean y()
  {
    return this.g != null;
  }

  public String z()
  {
    return this.h;
  }

  private static class a extends dx<br>
  {
    public void a(dn paramdn, br parambr)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!parambr.o())
          throw new do("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
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
            parambr.a = paramdn.z();
            parambr.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambr.b = paramdn.z();
            parambr.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambr.c = paramdn.z();
            parambr.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            parambr.d = paramdn.w();
            parambr.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            parambr.e = paramdn.w();
            parambr.e(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            parambr.f = paramdn.w();
            parambr.f(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambr.g = paramdn.A();
            parambr.g(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambr.h = paramdn.z();
            parambr.h(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            parambr.i = paramdn.z();
            parambr.i(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            parambr.j = paramdn.w();
            parambr.j(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      if (!parambr.r())
        throw new do("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
      if (!parambr.u())
        throw new do("Required field 'length' was not found in serialized data! Struct: " + toString());
      parambr.I();
    }

    public void b(dn paramdn, br parambr)
      throws cs
    {
      parambr.I();
      paramdn.a(br.J());
      if (parambr.a != null)
      {
        paramdn.a(br.K());
        paramdn.a(parambr.a);
        paramdn.c();
      }
      if (parambr.b != null)
      {
        paramdn.a(br.L());
        paramdn.a(parambr.b);
        paramdn.c();
      }
      if (parambr.c != null)
      {
        paramdn.a(br.M());
        paramdn.a(parambr.c);
        paramdn.c();
      }
      paramdn.a(br.N());
      paramdn.a(parambr.d);
      paramdn.c();
      paramdn.a(br.O());
      paramdn.a(parambr.e);
      paramdn.c();
      paramdn.a(br.P());
      paramdn.a(parambr.f);
      paramdn.c();
      if (parambr.g != null)
      {
        paramdn.a(br.Q());
        paramdn.a(parambr.g);
        paramdn.c();
      }
      if (parambr.h != null)
      {
        paramdn.a(br.R());
        paramdn.a(parambr.h);
        paramdn.c();
      }
      if (parambr.i != null)
      {
        paramdn.a(br.S());
        paramdn.a(parambr.i);
        paramdn.c();
      }
      if (parambr.H())
      {
        paramdn.a(br.T());
        paramdn.a(parambr.j);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public br.a a()
    {
      return new br.a(null);
    }
  }

  private static class c extends dy<br>
  {
    public void a(dn paramdn, br parambr)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(parambr.a);
      localdt.a(parambr.b);
      localdt.a(parambr.c);
      localdt.a(parambr.d);
      localdt.a(parambr.e);
      localdt.a(parambr.f);
      localdt.a(parambr.g);
      localdt.a(parambr.h);
      localdt.a(parambr.i);
      BitSet localBitSet = new BitSet();
      if (parambr.H())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (parambr.H())
        localdt.a(parambr.j);
    }

    public void b(dn paramdn, br parambr)
      throws cs
    {
      dt localdt = (dt)paramdn;
      parambr.a = localdt.z();
      parambr.a(true);
      parambr.b = localdt.z();
      parambr.b(true);
      parambr.c = localdt.z();
      parambr.c(true);
      parambr.d = localdt.w();
      parambr.d(true);
      parambr.e = localdt.w();
      parambr.e(true);
      parambr.f = localdt.w();
      parambr.f(true);
      parambr.g = localdt.A();
      parambr.g(true);
      parambr.h = localdt.z();
      parambr.h(true);
      parambr.i = localdt.z();
      parambr.i(true);
      if (localdt.b(1).get(0))
      {
        parambr.j = localdt.w();
        parambr.j(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public br.c a()
    {
      return new br.c(null);
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
 * Qualified Name:     c.a.br
 * JD-Core Version:    0.6.0
 */