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

public class as
  implements cl<as, e>, Serializable, Cloneable
{
  public static final Map<e, cz> e;
  private static final ds f = new ds("InstantMsg");
  private static final di g = new di("id", 11, 1);
  private static final di h = new di("errors", 15, 2);
  private static final di i = new di("events", 15, 3);
  private static final di j = new di("game_events", 15, 4);
  private static final Map<Class<? extends dv>, dw> k = new HashMap();
  public String a;
  public List<ab> b;
  public List<ae> c;
  public List<ae> d;
  private e[] l;

  static
  {
    k.put(dx.class, new b(null));
    k.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("id", 1, new da(11)));
    localEnumMap.put(e.b, new cz("errors", 2, new db(15, new de(12, ab.class))));
    localEnumMap.put(e.c, new cz("events", 2, new db(15, new de(12, ae.class))));
    localEnumMap.put(e.d, new cz("game_events", 2, new db(15, new de(12, ae.class))));
    e = Collections.unmodifiableMap(localEnumMap);
    cz.a(as.class, e);
  }

  public as()
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    this.l = arrayOfe;
  }

  public as(as paramas)
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    this.l = arrayOfe;
    if (paramas.e())
      this.a = paramas.a;
    if (paramas.k())
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator1 = paramas.b.iterator();
      while (localIterator1.hasNext())
        localArrayList1.add(new ab((ab)localIterator1.next()));
      this.b = localArrayList1;
    }
    if (paramas.p())
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator2 = paramas.c.iterator();
      while (localIterator2.hasNext())
        localArrayList2.add(new ae((ae)localIterator2.next()));
      this.c = localArrayList2;
    }
    if (paramas.u())
    {
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator3 = paramas.d.iterator();
      while (localIterator3.hasNext())
        localArrayList3.add(new ae((ae)localIterator3.next()));
      this.d = localArrayList3;
    }
  }

  public as(String paramString)
  {
    this();
    this.a = paramString;
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

  public as a()
  {
    return new as(this);
  }

  public as a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public as a(List<ab> paramList)
  {
    this.b = paramList;
    return this;
  }

  public void a(ab paramab)
  {
    if (this.b == null)
      this.b = new ArrayList();
    this.b.add(paramab);
  }

  public void a(ae paramae)
  {
    if (this.c == null)
      this.c = new ArrayList();
    this.c.add(paramae);
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

  public as b(List<ae> paramList)
  {
    this.c = paramList;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }

  public void b(ae paramae)
  {
    if (this.d == null)
      this.d = new ArrayList();
    this.d.add(paramae);
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)k.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public as c(List<ae> paramList)
  {
    this.d = paramList;
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
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public Iterator<ab> h()
  {
    if (this.b == null)
      return null;
    return this.b.iterator();
  }

  public List<ab> i()
  {
    return this.b;
  }

  public void j()
  {
    this.b = null;
  }

  public boolean k()
  {
    return this.b != null;
  }

  public int l()
  {
    if (this.c == null)
      return 0;
    return this.c.size();
  }

  public Iterator<ae> m()
  {
    if (this.c == null)
      return null;
    return this.c.iterator();
  }

  public List<ae> n()
  {
    return this.c;
  }

  public void o()
  {
    this.c = null;
  }

  public boolean p()
  {
    return this.c != null;
  }

  public int q()
  {
    if (this.d == null)
      return 0;
    return this.d.size();
  }

  public Iterator<ae> r()
  {
    if (this.d == null)
      return null;
    return this.d.iterator();
  }

  public List<ae> s()
  {
    return this.d;
  }

  public void t()
  {
    this.d = null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InstantMsg(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("errors:");
        if (this.b != null)
          break label173;
        localStringBuilder.append("null");
      }
      label72: if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("events:");
        if (this.c != null)
          break label185;
        localStringBuilder.append("null");
      }
      label110: if (u())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("game_events:");
        if (this.d != null)
          break label197;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label173: localStringBuilder.append(this.b);
      break label72;
      label185: localStringBuilder.append(this.c);
      break label110;
      label197: localStringBuilder.append(this.d);
    }
  }

  public boolean u()
  {
    return this.d != null;
  }

  public void v()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'id' was not present! Struct: " + toString());
  }

  private static class a extends dx<as>
  {
    public void a(dn paramdn, as paramas)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramas.v();
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
        if (localdi.b == 11)
        {
          paramas.a = paramdn.z();
          paramas.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj3 = paramdn.p();
          paramas.b = new ArrayList(localdj3.b);
          for (int k = 0; k < localdj3.b; k++)
          {
            ab localab = new ab();
            localab.a(paramdn);
            paramas.b.add(localab);
          }
          paramdn.q();
          paramas.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj2 = paramdn.p();
          paramas.c = new ArrayList(localdj2.b);
          for (int j = 0; j < localdj2.b; j++)
          {
            ae localae2 = new ae();
            localae2.a(paramdn);
            paramas.c.add(localae2);
          }
          paramdn.q();
          paramas.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj1 = paramdn.p();
          paramas.d = new ArrayList(localdj1.b);
          for (int i = 0; i < localdj1.b; i++)
          {
            ae localae1 = new ae();
            localae1.a(paramdn);
            paramas.d.add(localae1);
          }
          paramdn.q();
          paramas.d(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, as paramas)
      throws cs
    {
      paramas.v();
      paramdn.a(as.w());
      if (paramas.a != null)
      {
        paramdn.a(as.x());
        paramdn.a(paramas.a);
        paramdn.c();
      }
      if ((paramas.b != null) && (paramas.k()))
      {
        paramdn.a(as.y());
        paramdn.a(new dj(12, paramas.b.size()));
        Iterator localIterator3 = paramas.b.iterator();
        while (localIterator3.hasNext())
          ((ab)localIterator3.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((paramas.c != null) && (paramas.p()))
      {
        paramdn.a(as.z());
        paramdn.a(new dj(12, paramas.c.size()));
        Iterator localIterator2 = paramas.c.iterator();
        while (localIterator2.hasNext())
          ((ae)localIterator2.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((paramas.d != null) && (paramas.u()))
      {
        paramdn.a(as.A());
        paramdn.a(new dj(12, paramas.d.size()));
        Iterator localIterator1 = paramas.d.iterator();
        while (localIterator1.hasNext())
          ((ae)localIterator1.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public as.a a()
    {
      return new as.a(null);
    }
  }

  private static class c extends dy<as>
  {
    public void a(dn paramdn, as paramas)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramas.a);
      BitSet localBitSet = new BitSet();
      if (paramas.k())
        localBitSet.set(0);
      if (paramas.p())
        localBitSet.set(1);
      if (paramas.u())
        localBitSet.set(2);
      localdt.a(localBitSet, 3);
      if (paramas.k())
      {
        localdt.a(paramas.b.size());
        Iterator localIterator3 = paramas.b.iterator();
        while (localIterator3.hasNext())
          ((ab)localIterator3.next()).b(localdt);
      }
      if (paramas.p())
      {
        localdt.a(paramas.c.size());
        Iterator localIterator2 = paramas.c.iterator();
        while (localIterator2.hasNext())
          ((ae)localIterator2.next()).b(localdt);
      }
      if (paramas.u())
      {
        localdt.a(paramas.d.size());
        Iterator localIterator1 = paramas.d.iterator();
        while (localIterator1.hasNext())
          ((ae)localIterator1.next()).b(localdt);
      }
    }

    public void b(dn paramdn, as paramas)
      throws cs
    {
      int i = 0;
      dt localdt = (dt)paramdn;
      paramas.a = localdt.z();
      paramas.a(true);
      BitSet localBitSet = localdt.b(3);
      if (localBitSet.get(0))
      {
        dj localdj1 = new dj(12, localdt.w());
        paramas.b = new ArrayList(localdj1.b);
        for (int j = 0; j < localdj1.b; j++)
        {
          ab localab = new ab();
          localab.a(localdt);
          paramas.b.add(localab);
        }
        paramas.b(true);
      }
      if (localBitSet.get(1))
      {
        dj localdj2 = new dj(12, localdt.w());
        paramas.c = new ArrayList(localdj2.b);
        for (int k = 0; k < localdj2.b; k++)
        {
          ae localae1 = new ae();
          localae1.a(localdt);
          paramas.c.add(localae1);
        }
        paramas.c(true);
      }
      if (localBitSet.get(2))
      {
        dj localdj3 = new dj(12, localdt.w());
        paramas.d = new ArrayList(localdj3.b);
        while (i < localdj3.b)
        {
          ae localae2 = new ae();
          localae2.a(localdt);
          paramas.d.add(localae2);
          i++;
        }
        paramas.d(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public as.c a()
    {
      return new as.c(null);
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
 * Qualified Name:     c.a.as
 * JD-Core Version:    0.6.0
 */