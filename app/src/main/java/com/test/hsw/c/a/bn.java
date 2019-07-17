package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bn
  implements cl<bn, e>, Serializable, Cloneable
{
  public static final Map<e, cz> l;
  private static final ds m = new ds("UALogEntry");
  private static final di n = new di("client_stats", 12, 1);
  private static final di o = new di("app_info", 12, 2);
  private static final di p = new di("device_info", 12, 3);
  private static final di q = new di("misc_info", 12, 4);
  private static final di r = new di("activate_msg", 12, 5);
  private static final di s = new di("instant_msgs", 15, 6);
  private static final di t = new di("sessions", 15, 7);
  private static final di u = new di("imprint", 12, 8);
  private static final di v = new di("id_tracking", 12, 9);
  private static final di w = new di("active_user", 12, 10);
  private static final di x = new di("control_policy", 12, 11);
  private static final Map<Class<? extends dv>, dw> y = new HashMap();
  public t a;
  public r b;
  public x c;
  public ay d;
  public n e;
  public List<as> f;
  public List<bj> g;
  public ao h;
  public al i;
  public p j;
  public v k;
  private e[] z;

  static
  {
    y.put(dx.class, new b(null));
    y.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("client_stats", 1, new de(12, t.class)));
    localEnumMap.put(e.b, new cz("app_info", 1, new de(12, r.class)));
    localEnumMap.put(e.c, new cz("device_info", 1, new de(12, x.class)));
    localEnumMap.put(e.d, new cz("misc_info", 1, new de(12, ay.class)));
    localEnumMap.put(e.e, new cz("activate_msg", 2, new de(12, n.class)));
    localEnumMap.put(e.f, new cz("instant_msgs", 2, new db(15, new de(12, as.class))));
    localEnumMap.put(e.g, new cz("sessions", 2, new db(15, new de(12, bj.class))));
    localEnumMap.put(e.h, new cz("imprint", 2, new de(12, ao.class)));
    localEnumMap.put(e.i, new cz("id_tracking", 2, new de(12, al.class)));
    localEnumMap.put(e.j, new cz("active_user", 2, new de(12, p.class)));
    localEnumMap.put(e.k, new cz("control_policy", 2, new de(12, v.class)));
    l = Collections.unmodifiableMap(localEnumMap);
    cz.a(bn.class, l);
  }

  public bn()
  {
    e[] arrayOfe = new e[7];
    arrayOfe[0] = e.e;
    arrayOfe[1] = e.f;
    arrayOfe[2] = e.g;
    arrayOfe[3] = e.h;
    arrayOfe[4] = e.i;
    arrayOfe[5] = e.j;
    arrayOfe[6] = e.k;
    this.z = arrayOfe;
  }

  public bn(bn parambn)
  {
    e[] arrayOfe = new e[7];
    arrayOfe[0] = e.e;
    arrayOfe[1] = e.f;
    arrayOfe[2] = e.g;
    arrayOfe[3] = e.h;
    arrayOfe[4] = e.i;
    arrayOfe[5] = e.j;
    arrayOfe[6] = e.k;
    this.z = arrayOfe;
    if (parambn.e())
      this.a = new t(parambn.a);
    if (parambn.i())
      this.b = new r(parambn.b);
    if (parambn.l())
      this.c = new x(parambn.c);
    if (parambn.o())
      this.d = new ay(parambn.d);
    if (parambn.r())
      this.e = new n(parambn.e);
    if (parambn.w())
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator1 = parambn.f.iterator();
      while (localIterator1.hasNext())
        localArrayList1.add(new as((as)localIterator1.next()));
      this.f = localArrayList1;
    }
    if (parambn.B())
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator2 = parambn.g.iterator();
      while (localIterator2.hasNext())
        localArrayList2.add(new bj((bj)localIterator2.next()));
      this.g = localArrayList2;
    }
    if (parambn.E())
      this.h = new ao(parambn.h);
    if (parambn.H())
      this.i = new al(parambn.i);
    if (parambn.K())
      this.j = new p(parambn.j);
    if (parambn.N())
      this.k = new v(parambn.k);
  }

  public bn(t paramt, r paramr, x paramx, ay paramay)
  {
    this();
    this.a = paramt;
    this.b = paramr;
    this.c = paramx;
    this.d = paramay;
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

  public void A()
  {
    this.g = null;
  }

  public boolean B()
  {
    return this.g != null;
  }

  public ao C()
  {
    return this.h;
  }

  public void D()
  {
    this.h = null;
  }

  public boolean E()
  {
    return this.h != null;
  }

  public al F()
  {
    return this.i;
  }

  public void G()
  {
    this.i = null;
  }

  public boolean H()
  {
    return this.i != null;
  }

  public p I()
  {
    return this.j;
  }

  public void J()
  {
    this.j = null;
  }

  public boolean K()
  {
    return this.j != null;
  }

  public v L()
  {
    return this.k;
  }

  public void M()
  {
    this.k = null;
  }

  public boolean N()
  {
    return this.k != null;
  }

  public void O()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'client_stats' was not present! Struct: " + toString());
    if (this.b == null)
      throw new do("Required field 'app_info' was not present! Struct: " + toString());
    if (this.c == null)
      throw new do("Required field 'device_info' was not present! Struct: " + toString());
    if (this.d == null)
      throw new do("Required field 'misc_info' was not present! Struct: " + toString());
    if (this.a != null)
      this.a.m();
    if (this.b != null)
      this.b.H();
    if (this.c != null)
      this.c.ac();
    if (this.d != null)
      this.d.H();
    if (this.e != null)
      this.e.f();
    if (this.h != null)
      this.h.n();
    if (this.i != null)
      this.i.p();
    if (this.j != null)
      this.j.j();
    if (this.k != null)
      this.k.f();
  }

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public bn a()
  {
    return new bn(this);
  }

  public bn a(al paramal)
  {
    this.i = paramal;
    return this;
  }

  public bn a(ao paramao)
  {
    this.h = paramao;
    return this;
  }

  public bn a(ay paramay)
  {
    this.d = paramay;
    return this;
  }

  public bn a(n paramn)
  {
    this.e = paramn;
    return this;
  }

  public bn a(p paramp)
  {
    this.j = paramp;
    return this;
  }

  public bn a(r paramr)
  {
    this.b = paramr;
    return this;
  }

  public bn a(t paramt)
  {
    this.a = paramt;
    return this;
  }

  public bn a(v paramv)
  {
    this.k = paramv;
    return this;
  }

  public bn a(x paramx)
  {
    this.c = paramx;
    return this;
  }

  public bn a(List<as> paramList)
  {
    this.f = paramList;
    return this;
  }

  public void a(as paramas)
  {
    if (this.f == null)
      this.f = new ArrayList();
    this.f.add(paramas);
  }

  public void a(bj parambj)
  {
    if (this.g == null)
      this.g = new ArrayList();
    this.g.add(parambj);
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)y.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public bn b(List<bj> paramList)
  {
    this.g = paramList;
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
    this.j = null;
    this.k = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)y.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public t c()
  {
    return this.a;
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

  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.e = null;
  }

  public boolean e()
  {
    return this.a != null;
  }

  public r f()
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

  public x j()
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

  public void k(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.k = null;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public ay m()
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

  public n p()
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

  public int s()
  {
    if (this.f == null)
      return 0;
    return this.f.size();
  }

  public Iterator<as> t()
  {
    if (this.f == null)
      return null;
    return this.f.iterator();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UALogEntry(");
    localStringBuilder.append("client_stats:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("app_info:");
      if (this.b != null)
        break label418;
      localStringBuilder.append("null");
      label65: localStringBuilder.append(", ");
      localStringBuilder.append("device_info:");
      if (this.c != null)
        break label430;
      localStringBuilder.append("null");
      label96: localStringBuilder.append(", ");
      localStringBuilder.append("misc_info:");
      if (this.d != null)
        break label442;
      localStringBuilder.append("null");
      label127: if (r())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("activate_msg:");
        if (this.e != null)
          break label454;
        localStringBuilder.append("null");
      }
      label165: if (w())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("instant_msgs:");
        if (this.f != null)
          break label466;
        localStringBuilder.append("null");
      }
      label203: if (B())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("sessions:");
        if (this.g != null)
          break label478;
        localStringBuilder.append("null");
      }
      label241: if (E())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("imprint:");
        if (this.h != null)
          break label490;
        localStringBuilder.append("null");
      }
      label279: if (H())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("id_tracking:");
        if (this.i != null)
          break label502;
        localStringBuilder.append("null");
      }
      label317: if (K())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("active_user:");
        if (this.j != null)
          break label514;
        localStringBuilder.append("null");
      }
      label355: if (N())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("control_policy:");
        if (this.k != null)
          break label526;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label418: localStringBuilder.append(this.b);
      break label65;
      label430: localStringBuilder.append(this.c);
      break label96;
      label442: localStringBuilder.append(this.d);
      break label127;
      label454: localStringBuilder.append(this.e);
      break label165;
      label466: localStringBuilder.append(this.f);
      break label203;
      label478: localStringBuilder.append(this.g);
      break label241;
      label490: localStringBuilder.append(this.h);
      break label279;
      label502: localStringBuilder.append(this.i);
      break label317;
      label514: localStringBuilder.append(this.j);
      break label355;
      label526: localStringBuilder.append(this.k);
    }
  }

  public List<as> u()
  {
    return this.f;
  }

  public void v()
  {
    this.f = null;
  }

  public boolean w()
  {
    return this.f != null;
  }

  public int x()
  {
    if (this.g == null)
      return 0;
    return this.g.size();
  }

  public Iterator<bj> y()
  {
    if (this.g == null)
      return null;
    return this.g.iterator();
  }

  public List<bj> z()
  {
    return this.g;
  }

  private static class a extends dx<bn>
  {
    public void a(dn paramdn, bn parambn)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        parambn.O();
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
      }
      while (true)
      {
        paramdn.m();
        break;
        if (localdi.b == 12)
        {
          parambn.a = new t();
          parambn.a.a(paramdn);
          parambn.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.b = new r();
          parambn.b.a(paramdn);
          parambn.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.c = new x();
          parambn.c.a(paramdn);
          parambn.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.d = new ay();
          parambn.d.a(paramdn);
          parambn.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.e = new n();
          parambn.e.a(paramdn);
          parambn.e(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj2 = paramdn.p();
          parambn.f = new ArrayList(localdj2.b);
          for (int j = 0; j < localdj2.b; j++)
          {
            as localas = new as();
            localas.a(paramdn);
            parambn.f.add(localas);
          }
          paramdn.q();
          parambn.f(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj1 = paramdn.p();
          parambn.g = new ArrayList(localdj1.b);
          for (int i = 0; i < localdj1.b; i++)
          {
            bj localbj = new bj();
            localbj.a(paramdn);
            parambn.g.add(localbj);
          }
          paramdn.q();
          parambn.g(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.h = new ao();
          parambn.h.a(paramdn);
          parambn.h(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.i = new al();
          parambn.i.a(paramdn);
          parambn.i(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.j = new p();
          parambn.j.a(paramdn);
          parambn.j(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 12)
        {
          parambn.k = new v();
          parambn.k.a(paramdn);
          parambn.k(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, bn parambn)
      throws cs
    {
      parambn.O();
      paramdn.a(bn.P());
      if (parambn.a != null)
      {
        paramdn.a(bn.Q());
        parambn.a.b(paramdn);
        paramdn.c();
      }
      if (parambn.b != null)
      {
        paramdn.a(bn.R());
        parambn.b.b(paramdn);
        paramdn.c();
      }
      if (parambn.c != null)
      {
        paramdn.a(bn.S());
        parambn.c.b(paramdn);
        paramdn.c();
      }
      if (parambn.d != null)
      {
        paramdn.a(bn.T());
        parambn.d.b(paramdn);
        paramdn.c();
      }
      if ((parambn.e != null) && (parambn.r()))
      {
        paramdn.a(bn.U());
        parambn.e.b(paramdn);
        paramdn.c();
      }
      if ((parambn.f != null) && (parambn.w()))
      {
        paramdn.a(bn.V());
        paramdn.a(new dj(12, parambn.f.size()));
        Iterator localIterator2 = parambn.f.iterator();
        while (localIterator2.hasNext())
          ((as)localIterator2.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((parambn.g != null) && (parambn.B()))
      {
        paramdn.a(bn.W());
        paramdn.a(new dj(12, parambn.g.size()));
        Iterator localIterator1 = parambn.g.iterator();
        while (localIterator1.hasNext())
          ((bj)localIterator1.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((parambn.h != null) && (parambn.E()))
      {
        paramdn.a(bn.X());
        parambn.h.b(paramdn);
        paramdn.c();
      }
      if ((parambn.i != null) && (parambn.H()))
      {
        paramdn.a(bn.Y());
        parambn.i.b(paramdn);
        paramdn.c();
      }
      if ((parambn.j != null) && (parambn.K()))
      {
        paramdn.a(bn.Z());
        parambn.j.b(paramdn);
        paramdn.c();
      }
      if ((parambn.k != null) && (parambn.N()))
      {
        paramdn.a(bn.aa());
        parambn.k.b(paramdn);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public bn.a a()
    {
      return new bn.a(null);
    }
  }

  private static class c extends dy<bn>
  {
    public void a(dn paramdn, bn parambn)
      throws cs
    {
      dt localdt = (dt)paramdn;
      parambn.a.b(localdt);
      parambn.b.b(localdt);
      parambn.c.b(localdt);
      parambn.d.b(localdt);
      BitSet localBitSet = new BitSet();
      if (parambn.r())
        localBitSet.set(0);
      if (parambn.w())
        localBitSet.set(1);
      if (parambn.B())
        localBitSet.set(2);
      if (parambn.E())
        localBitSet.set(3);
      if (parambn.H())
        localBitSet.set(4);
      if (parambn.K())
        localBitSet.set(5);
      if (parambn.N())
        localBitSet.set(6);
      localdt.a(localBitSet, 7);
      if (parambn.r())
        parambn.e.b(localdt);
      if (parambn.w())
      {
        localdt.a(parambn.f.size());
        Iterator localIterator2 = parambn.f.iterator();
        while (localIterator2.hasNext())
          ((as)localIterator2.next()).b(localdt);
      }
      if (parambn.B())
      {
        localdt.a(parambn.g.size());
        Iterator localIterator1 = parambn.g.iterator();
        while (localIterator1.hasNext())
          ((bj)localIterator1.next()).b(localdt);
      }
      if (parambn.E())
        parambn.h.b(localdt);
      if (parambn.H())
        parambn.i.b(localdt);
      if (parambn.K())
        parambn.j.b(localdt);
      if (parambn.N())
        parambn.k.b(localdt);
    }

    public void b(dn paramdn, bn parambn)
      throws cs
    {
      int i = 0;
      dt localdt = (dt)paramdn;
      parambn.a = new t();
      parambn.a.a(localdt);
      parambn.a(true);
      parambn.b = new r();
      parambn.b.a(localdt);
      parambn.b(true);
      parambn.c = new x();
      parambn.c.a(localdt);
      parambn.c(true);
      parambn.d = new ay();
      parambn.d.a(localdt);
      parambn.d(true);
      BitSet localBitSet = localdt.b(7);
      if (localBitSet.get(0))
      {
        parambn.e = new n();
        parambn.e.a(localdt);
        parambn.e(true);
      }
      if (localBitSet.get(1))
      {
        dj localdj1 = new dj(12, localdt.w());
        parambn.f = new ArrayList(localdj1.b);
        for (int j = 0; j < localdj1.b; j++)
        {
          as localas = new as();
          localas.a(localdt);
          parambn.f.add(localas);
        }
        parambn.f(true);
      }
      if (localBitSet.get(2))
      {
        dj localdj2 = new dj(12, localdt.w());
        parambn.g = new ArrayList(localdj2.b);
        while (i < localdj2.b)
        {
          bj localbj = new bj();
          localbj.a(localdt);
          parambn.g.add(localbj);
          i++;
        }
        parambn.g(true);
      }
      if (localBitSet.get(3))
      {
        parambn.h = new ao();
        parambn.h.a(localdt);
        parambn.h(true);
      }
      if (localBitSet.get(4))
      {
        parambn.i = new al();
        parambn.i.a(localdt);
        parambn.i(true);
      }
      if (localBitSet.get(5))
      {
        parambn.j = new p();
        parambn.j.a(localdt);
        parambn.j(true);
      }
      if (localBitSet.get(6))
      {
        parambn.k = new v();
        parambn.k.a(localdt);
        parambn.k(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public bn.c a()
    {
      return new bn.c(null);
    }
  }

  public static enum e
    implements ct
  {
    private static final Map<String, e> l;
    private final short m;
    private final String n;

    static
    {
      e[] arrayOfe = new e[11];
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
      o = arrayOfe;
      l = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        l.put(locale.b(), locale);
      }
    }

    private e(short paramShort, String paramString)
    {
      this.m = paramShort;
      this.n = paramString;
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
      }
      return k;
    }

    public static e a(String paramString)
    {
      return (e)l.get(paramString);
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
      return this.m;
    }

    public String b()
    {
      return this.n;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.bn
 * JD-Core Version:    0.6.0
 */