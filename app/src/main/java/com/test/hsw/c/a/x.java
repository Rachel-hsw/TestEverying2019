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

public class x
  implements cl<x, e>, Serializable, Cloneable
{
  private static final di A;
  private static final di B;
  private static final di C;
  private static final di D;
  private static final di E;
  private static final di F;
  private static final di G;
  private static final di H;
  private static final di I;
  private static final di J;
  private static final Map<Class<? extends dv>, dw> K;
  private static final int L = 0;
  private static final int M = 1;
  private static final int N = 2;
  public static final Map<e, cz> r;
  private static final ds s = new ds("DeviceInfo");
  private static final di t = new di("device_id", 11, 1);
  private static final di u = new di("idmd5", 11, 2);
  private static final di v = new di("mac_address", 11, 3);
  private static final di w = new di("open_udid", 11, 4);
  private static final di x = new di("model", 11, 5);
  private static final di y = new di("cpu", 11, 6);
  private static final di z = new di("os", 11, 7);
  private byte O = 0;
  private e[] P;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public be i;
  public boolean j;
  public boolean k;
  public String l;
  public String m;
  public long n;
  public String o;
  public String p;
  public String q;

  static
  {
    A = new di("os_version", 11, 8);
    B = new di("resolution", 12, 9);
    C = new di("is_jailbroken", 2, 10);
    D = new di("is_pirated", 2, 11);
    E = new di("device_board", 11, 12);
    F = new di("device_brand", 11, 13);
    G = new di("device_manutime", 10, 14);
    H = new di("device_manufacturer", 11, 15);
    I = new di("device_manuid", 11, 16);
    J = new di("device_name", 11, 17);
    K = new HashMap();
    K.put(dx.class, new b(null));
    K.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("device_id", 2, new da(11)));
    localEnumMap.put(e.b, new cz("idmd5", 2, new da(11)));
    localEnumMap.put(e.c, new cz("mac_address", 2, new da(11)));
    localEnumMap.put(e.d, new cz("open_udid", 2, new da(11)));
    localEnumMap.put(e.e, new cz("model", 2, new da(11)));
    localEnumMap.put(e.f, new cz("cpu", 2, new da(11)));
    localEnumMap.put(e.g, new cz("os", 2, new da(11)));
    localEnumMap.put(e.h, new cz("os_version", 2, new da(11)));
    localEnumMap.put(e.i, new cz("resolution", 2, new de(12, be.class)));
    localEnumMap.put(e.j, new cz("is_jailbroken", 2, new da(2)));
    localEnumMap.put(e.k, new cz("is_pirated", 2, new da(2)));
    localEnumMap.put(e.l, new cz("device_board", 2, new da(11)));
    localEnumMap.put(e.m, new cz("device_brand", 2, new da(11)));
    localEnumMap.put(e.n, new cz("device_manutime", 2, new da(10)));
    localEnumMap.put(e.o, new cz("device_manufacturer", 2, new da(11)));
    localEnumMap.put(e.p, new cz("device_manuid", 2, new da(11)));
    localEnumMap.put(e.q, new cz("device_name", 2, new da(11)));
    r = Collections.unmodifiableMap(localEnumMap);
    cz.a(x.class, r);
  }

  public x()
  {
    e[] arrayOfe = new e[17];
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
    arrayOfe[10] = e.k;
    arrayOfe[11] = e.l;
    arrayOfe[12] = e.m;
    arrayOfe[13] = e.n;
    arrayOfe[14] = e.o;
    arrayOfe[15] = e.p;
    arrayOfe[16] = e.q;
    this.P = arrayOfe;
  }

  public x(x paramx)
  {
    e[] arrayOfe = new e[17];
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
    arrayOfe[10] = e.k;
    arrayOfe[11] = e.l;
    arrayOfe[12] = e.m;
    arrayOfe[13] = e.n;
    arrayOfe[14] = e.o;
    arrayOfe[15] = e.p;
    arrayOfe[16] = e.q;
    this.P = arrayOfe;
    this.O = paramx.O;
    if (paramx.e())
      this.a = paramx.a;
    if (paramx.i())
      this.b = paramx.b;
    if (paramx.l())
      this.c = paramx.c;
    if (paramx.o())
      this.d = paramx.d;
    if (paramx.r())
      this.e = paramx.e;
    if (paramx.u())
      this.f = paramx.f;
    if (paramx.x())
      this.g = paramx.g;
    if (paramx.A())
      this.h = paramx.h;
    if (paramx.D())
      this.i = new be(paramx.i);
    this.j = paramx.j;
    this.k = paramx.k;
    if (paramx.M())
      this.l = paramx.l;
    if (paramx.P())
      this.m = paramx.m;
    this.n = paramx.n;
    if (paramx.V())
      this.o = paramx.o;
    if (paramx.Y())
      this.p = paramx.p;
    if (paramx.ab())
      this.q = paramx.q;
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.O = 0;
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

  public be B()
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

  public boolean E()
  {
    return this.j;
  }

  public void F()
  {
    this.O = ci.b(this.O, 0);
  }

  public boolean G()
  {
    return ci.a(this.O, 0);
  }

  public boolean H()
  {
    return this.k;
  }

  public void I()
  {
    this.O = ci.b(this.O, 1);
  }

  public boolean J()
  {
    return ci.a(this.O, 1);
  }

  public String K()
  {
    return this.l;
  }

  public void L()
  {
    this.l = null;
  }

  public boolean M()
  {
    return this.l != null;
  }

  public String N()
  {
    return this.m;
  }

  public void O()
  {
    this.m = null;
  }

  public boolean P()
  {
    return this.m != null;
  }

  public long Q()
  {
    return this.n;
  }

  public void R()
  {
    this.O = ci.b(this.O, 2);
  }

  public boolean S()
  {
    return ci.a(this.O, 2);
  }

  public String T()
  {
    return this.o;
  }

  public void U()
  {
    this.o = null;
  }

  public boolean V()
  {
    return this.o != null;
  }

  public String W()
  {
    return this.p;
  }

  public void X()
  {
    this.p = null;
  }

  public boolean Y()
  {
    return this.p != null;
  }

  public String Z()
  {
    return this.q;
  }

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public x a()
  {
    return new x(this);
  }

  public x a(long paramLong)
  {
    this.n = paramLong;
    p(true);
    return this;
  }

  public x a(be parambe)
  {
    this.i = parambe;
    return this;
  }

  public x a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)K.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public void aa()
  {
    this.q = null;
  }

  public boolean ab()
  {
    return this.q != null;
  }

  public void ac()
    throws cs
  {
    if (this.i != null)
      this.i.j();
  }

  public x b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    k(false);
    this.j = false;
    m(false);
    this.k = false;
    this.l = null;
    this.m = null;
    p(false);
    this.n = 0L;
    this.o = null;
    this.p = null;
    this.q = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)K.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public x c(String paramString)
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

  public x d(String paramString)
  {
    this.d = paramString;
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

  public x e(String paramString)
  {
    this.e = paramString;
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

  public x f(String paramString)
  {
    this.f = paramString;
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

  public x g(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public void g(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.g = null;
  }

  public x h(String paramString)
  {
    this.h = paramString;
    return this;
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

  public x i(String paramString)
  {
    this.l = paramString;
    return this;
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

  public x j(String paramString)
  {
    this.m = paramString;
    return this;
  }

  public x j(boolean paramBoolean)
  {
    this.j = paramBoolean;
    k(true);
    return this;
  }

  public String j()
  {
    return this.c;
  }

  public x k(String paramString)
  {
    this.o = paramString;
    return this;
  }

  public void k()
  {
    this.c = null;
  }

  public void k(boolean paramBoolean)
  {
    this.O = ci.a(this.O, 0, paramBoolean);
  }

  public x l(String paramString)
  {
    this.p = paramString;
    return this;
  }

  public x l(boolean paramBoolean)
  {
    this.k = paramBoolean;
    m(true);
    return this;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public x m(String paramString)
  {
    this.q = paramString;
    return this;
  }

  public String m()
  {
    return this.d;
  }

  public void m(boolean paramBoolean)
  {
    this.O = ci.a(this.O, 1, paramBoolean);
  }

  public void n()
  {
    this.d = null;
  }

  public void n(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.l = null;
  }

  public void o(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.m = null;
  }

  public boolean o()
  {
    return this.d != null;
  }

  public String p()
  {
    return this.e;
  }

  public void p(boolean paramBoolean)
  {
    this.O = ci.a(this.O, 2, paramBoolean);
  }

  public void q()
  {
    this.e = null;
  }

  public void q(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.o = null;
  }

  public void r(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.p = null;
  }

  public boolean r()
  {
    return this.e != null;
  }

  public String s()
  {
    return this.f;
  }

  public void s(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.q = null;
  }

  public void t()
  {
    this.f = null;
  }

  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("DeviceInfo(");
    int i2 = 1;
    if (e())
    {
      localStringBuilder.append("device_id:");
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
        localStringBuilder.append("idmd5:");
        if (this.b != null)
          break label754;
        localStringBuilder.append("null");
        label89: i2 = 0;
      }
      if (l())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("mac_address:");
        if (this.c != null)
          break label766;
        localStringBuilder.append("null");
        label133: i2 = 0;
      }
      if (o())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("open_udid:");
        if (this.d != null)
          break label778;
        localStringBuilder.append("null");
        label177: i2 = 0;
      }
      if (r())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("model:");
        if (this.e != null)
          break label790;
        localStringBuilder.append("null");
        label221: i2 = 0;
      }
      if (u())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("cpu:");
        if (this.f != null)
          break label802;
        localStringBuilder.append("null");
        label265: i2 = 0;
      }
      if (x())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("os:");
        if (this.g != null)
          break label814;
        localStringBuilder.append("null");
        label309: i2 = 0;
      }
      if (A())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("os_version:");
        if (this.h != null)
          break label826;
        localStringBuilder.append("null");
        label353: i2 = 0;
      }
      if (D())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("resolution:");
        if (this.i != null)
          break label838;
        localStringBuilder.append("null");
        label397: i2 = 0;
      }
      if (G())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("is_jailbroken:");
        localStringBuilder.append(this.j);
        i2 = 0;
      }
      if (J())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("is_pirated:");
        localStringBuilder.append(this.k);
        i2 = 0;
      }
      if (M())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("device_board:");
        if (this.l != null)
          break label850;
        localStringBuilder.append("null");
        label517: i2 = 0;
      }
      if (P())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("device_brand:");
        if (this.m != null)
          break label862;
        localStringBuilder.append("null");
        label561: i2 = 0;
      }
      if (S())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("device_manutime:");
        localStringBuilder.append(this.n);
        i2 = 0;
      }
      if (V())
      {
        if (i2 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("device_manufacturer:");
        if (this.o != null)
          break label874;
        localStringBuilder.append("null");
        label643: i2 = 0;
      }
      if (!Y())
        break label912;
      if (i2 == 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("device_manuid:");
      if (this.p != null)
        break label886;
      localStringBuilder.append("null");
    }
    while (true)
    {
      label687: if (ab())
      {
        if (i1 == 0)
          localStringBuilder.append(", ");
        localStringBuilder.append("device_name:");
        if (this.q != null)
          break label900;
        localStringBuilder.append("null");
      }
      while (true)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label754: localStringBuilder.append(this.b);
        break label89;
        label766: localStringBuilder.append(this.c);
        break label133;
        label778: localStringBuilder.append(this.d);
        break label177;
        label790: localStringBuilder.append(this.e);
        break label221;
        label802: localStringBuilder.append(this.f);
        break label265;
        label814: localStringBuilder.append(this.g);
        break label309;
        label826: localStringBuilder.append(this.h);
        break label353;
        label838: localStringBuilder.append(this.i);
        break label397;
        label850: localStringBuilder.append(this.l);
        break label517;
        label862: localStringBuilder.append(this.m);
        break label561;
        label874: localStringBuilder.append(this.o);
        break label643;
        label886: localStringBuilder.append(this.p);
        i1 = 0;
        break label687;
        label900: localStringBuilder.append(this.q);
      }
      label912: i1 = i2;
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

  private static class a extends dx<x>
  {
    public void a(dn paramdn, x paramx)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramx.ac();
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
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      }
      while (true)
      {
        paramdn.m();
        break;
        if (localdi.b == 11)
        {
          paramx.a = paramdn.z();
          paramx.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.b = paramdn.z();
          paramx.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.c = paramdn.z();
          paramx.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.d = paramdn.z();
          paramx.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.e = paramdn.z();
          paramx.e(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.f = paramdn.z();
          paramx.f(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.g = paramdn.z();
          paramx.g(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.h = paramdn.z();
          paramx.h(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          paramx.i = new be();
          paramx.i.a(paramdn);
          paramx.i(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 2)
        {
          paramx.j = paramdn.t();
          paramx.k(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 2)
        {
          paramx.k = paramdn.t();
          paramx.m(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.l = paramdn.z();
          paramx.n(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.m = paramdn.z();
          paramx.o(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 10)
        {
          paramx.n = paramdn.x();
          paramx.p(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.o = paramdn.z();
          paramx.q(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.p = paramdn.z();
          paramx.r(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramx.q = paramdn.z();
          paramx.s(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, x paramx)
      throws cs
    {
      paramx.ac();
      paramdn.a(x.ad());
      if ((paramx.a != null) && (paramx.e()))
      {
        paramdn.a(x.ae());
        paramdn.a(paramx.a);
        paramdn.c();
      }
      if ((paramx.b != null) && (paramx.i()))
      {
        paramdn.a(x.af());
        paramdn.a(paramx.b);
        paramdn.c();
      }
      if ((paramx.c != null) && (paramx.l()))
      {
        paramdn.a(x.ag());
        paramdn.a(paramx.c);
        paramdn.c();
      }
      if ((paramx.d != null) && (paramx.o()))
      {
        paramdn.a(x.ah());
        paramdn.a(paramx.d);
        paramdn.c();
      }
      if ((paramx.e != null) && (paramx.r()))
      {
        paramdn.a(x.ai());
        paramdn.a(paramx.e);
        paramdn.c();
      }
      if ((paramx.f != null) && (paramx.u()))
      {
        paramdn.a(x.aj());
        paramdn.a(paramx.f);
        paramdn.c();
      }
      if ((paramx.g != null) && (paramx.x()))
      {
        paramdn.a(x.ak());
        paramdn.a(paramx.g);
        paramdn.c();
      }
      if ((paramx.h != null) && (paramx.A()))
      {
        paramdn.a(x.al());
        paramdn.a(paramx.h);
        paramdn.c();
      }
      if ((paramx.i != null) && (paramx.D()))
      {
        paramdn.a(x.am());
        paramx.i.b(paramdn);
        paramdn.c();
      }
      if (paramx.G())
      {
        paramdn.a(x.an());
        paramdn.a(paramx.j);
        paramdn.c();
      }
      if (paramx.J())
      {
        paramdn.a(x.ao());
        paramdn.a(paramx.k);
        paramdn.c();
      }
      if ((paramx.l != null) && (paramx.M()))
      {
        paramdn.a(x.ap());
        paramdn.a(paramx.l);
        paramdn.c();
      }
      if ((paramx.m != null) && (paramx.P()))
      {
        paramdn.a(x.aq());
        paramdn.a(paramx.m);
        paramdn.c();
      }
      if (paramx.S())
      {
        paramdn.a(x.ar());
        paramdn.a(paramx.n);
        paramdn.c();
      }
      if ((paramx.o != null) && (paramx.V()))
      {
        paramdn.a(x.as());
        paramdn.a(paramx.o);
        paramdn.c();
      }
      if ((paramx.p != null) && (paramx.Y()))
      {
        paramdn.a(x.at());
        paramdn.a(paramx.p);
        paramdn.c();
      }
      if ((paramx.q != null) && (paramx.ab()))
      {
        paramdn.a(x.au());
        paramdn.a(paramx.q);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public x.a a()
    {
      return new x.a(null);
    }
  }

  private static class c extends dy<x>
  {
    public void a(dn paramdn, x paramx)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = new BitSet();
      if (paramx.e())
        localBitSet.set(0);
      if (paramx.i())
        localBitSet.set(1);
      if (paramx.l())
        localBitSet.set(2);
      if (paramx.o())
        localBitSet.set(3);
      if (paramx.r())
        localBitSet.set(4);
      if (paramx.u())
        localBitSet.set(5);
      if (paramx.x())
        localBitSet.set(6);
      if (paramx.A())
        localBitSet.set(7);
      if (paramx.D())
        localBitSet.set(8);
      if (paramx.G())
        localBitSet.set(9);
      if (paramx.J())
        localBitSet.set(10);
      if (paramx.M())
        localBitSet.set(11);
      if (paramx.P())
        localBitSet.set(12);
      if (paramx.S())
        localBitSet.set(13);
      if (paramx.V())
        localBitSet.set(14);
      if (paramx.Y())
        localBitSet.set(15);
      if (paramx.ab())
        localBitSet.set(16);
      localdt.a(localBitSet, 17);
      if (paramx.e())
        localdt.a(paramx.a);
      if (paramx.i())
        localdt.a(paramx.b);
      if (paramx.l())
        localdt.a(paramx.c);
      if (paramx.o())
        localdt.a(paramx.d);
      if (paramx.r())
        localdt.a(paramx.e);
      if (paramx.u())
        localdt.a(paramx.f);
      if (paramx.x())
        localdt.a(paramx.g);
      if (paramx.A())
        localdt.a(paramx.h);
      if (paramx.D())
        paramx.i.b(localdt);
      if (paramx.G())
        localdt.a(paramx.j);
      if (paramx.J())
        localdt.a(paramx.k);
      if (paramx.M())
        localdt.a(paramx.l);
      if (paramx.P())
        localdt.a(paramx.m);
      if (paramx.S())
        localdt.a(paramx.n);
      if (paramx.V())
        localdt.a(paramx.o);
      if (paramx.Y())
        localdt.a(paramx.p);
      if (paramx.ab())
        localdt.a(paramx.q);
    }

    public void b(dn paramdn, x paramx)
      throws cs
    {
      dt localdt = (dt)paramdn;
      BitSet localBitSet = localdt.b(17);
      if (localBitSet.get(0))
      {
        paramx.a = localdt.z();
        paramx.a(true);
      }
      if (localBitSet.get(1))
      {
        paramx.b = localdt.z();
        paramx.b(true);
      }
      if (localBitSet.get(2))
      {
        paramx.c = localdt.z();
        paramx.c(true);
      }
      if (localBitSet.get(3))
      {
        paramx.d = localdt.z();
        paramx.d(true);
      }
      if (localBitSet.get(4))
      {
        paramx.e = localdt.z();
        paramx.e(true);
      }
      if (localBitSet.get(5))
      {
        paramx.f = localdt.z();
        paramx.f(true);
      }
      if (localBitSet.get(6))
      {
        paramx.g = localdt.z();
        paramx.g(true);
      }
      if (localBitSet.get(7))
      {
        paramx.h = localdt.z();
        paramx.h(true);
      }
      if (localBitSet.get(8))
      {
        paramx.i = new be();
        paramx.i.a(localdt);
        paramx.i(true);
      }
      if (localBitSet.get(9))
      {
        paramx.j = localdt.t();
        paramx.k(true);
      }
      if (localBitSet.get(10))
      {
        paramx.k = localdt.t();
        paramx.m(true);
      }
      if (localBitSet.get(11))
      {
        paramx.l = localdt.z();
        paramx.n(true);
      }
      if (localBitSet.get(12))
      {
        paramx.m = localdt.z();
        paramx.o(true);
      }
      if (localBitSet.get(13))
      {
        paramx.n = localdt.x();
        paramx.p(true);
      }
      if (localBitSet.get(14))
      {
        paramx.o = localdt.z();
        paramx.q(true);
      }
      if (localBitSet.get(15))
      {
        paramx.p = localdt.z();
        paramx.r(true);
      }
      if (localBitSet.get(16))
      {
        paramx.q = localdt.z();
        paramx.s(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public x.c a()
    {
      return new x.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> r;
    private final short s;
    private final String t;

    static
    {
      e[] arrayOfe = new e[17];
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
      arrayOfe[10] = k;
      arrayOfe[11] = l;
      arrayOfe[12] = m;
      arrayOfe[13] = n;
      arrayOfe[14] = o;
      arrayOfe[15] = p;
      arrayOfe[16] = q;
      u = arrayOfe;
      r = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        r.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.s = paramShort;
      this.t = paramString;
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
        return j;
      case 11:
        return k;
      case 12:
        return l;
      case 13:
        return m;
      case 14:
        return n;
      case 15:
        return o;
      case 16:
        return p;
      case 17:
      }
      return q;
    }

    public static e a(String paramString)
    {
      return (e)r.get(paramString);
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
      return this.s;
    }

    public String b()
    {
      return this.t;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.x
 * JD-Core Version:    0.6.0
 */