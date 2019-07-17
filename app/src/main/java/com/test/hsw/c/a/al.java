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
import java.util.Map.Entry;
import java.util.Set;

public class al
  implements cl<al, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("IdTracking");
  private static final di f = new di("snapshots", 13, 1);
  private static final di g = new di("journals", 15, 2);
  private static final di h = new di("checksum", 11, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  public Map<String, aj> a;
  public List<ah> b;
  public String c;
  private e[] j;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("snapshots", 1, new dc(13, new da(11), new de(12, aj.class))));
    localEnumMap.put(e.b, new cz("journals", 2, new db(15, new de(12, ah.class))));
    localEnumMap.put(e.c, new cz("checksum", 2, new da(11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(al.class, d);
  }

  public al()
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    this.j = arrayOfe;
  }

  public al(al paramal)
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    this.j = arrayOfe;
    if (paramal.f())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator1 = paramal.a.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localHashMap.put((String)localEntry.getKey(), new aj((aj)localEntry.getValue()));
      }
      this.a = localHashMap;
    }
    if (paramal.l())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator2 = paramal.b.iterator();
      while (localIterator2.hasNext())
        localArrayList.add(new ah((ah)localIterator2.next()));
      this.b = localArrayList;
    }
    if (paramal.o())
      this.c = paramal.c;
  }

  public al(Map<String, aj> paramMap)
  {
    this();
    this.a = paramMap;
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

  public al a()
  {
    return new al(this);
  }

  public al a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public al a(List<ah> paramList)
  {
    this.b = paramList;
    return this;
  }

  public al a(Map<String, aj> paramMap)
  {
    this.a = paramMap;
    return this;
  }

  public void a(ah paramah)
  {
    if (this.b == null)
      this.b = new ArrayList();
    this.b.add(paramah);
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(String paramString, aj paramaj)
  {
    if (this.a == null)
      this.a = new HashMap();
    this.a.put(paramString, paramaj);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public void b()
  {
    this.a = null;
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
    if (this.a == null)
      return 0;
    return this.a.size();
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public Map<String, aj> d()
  {
    return this.a;
  }

  public void e()
  {
    this.a = null;
  }

  public boolean f()
  {
    return this.a != null;
  }

  public int h()
  {
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public Iterator<ah> i()
  {
    if (this.b == null)
      return null;
    return this.b.iterator();
  }

  public List<ah> j()
  {
    return this.b;
  }

  public void k()
  {
    this.b = null;
  }

  public boolean l()
  {
    return this.b != null;
  }

  public String m()
  {
    return this.c;
  }

  public void n()
  {
    this.c = null;
  }

  public boolean o()
  {
    return this.c != null;
  }

  public void p()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'snapshots' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdTracking(");
    localStringBuilder.append("snapshots:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (l())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("journals:");
        if (this.b != null)
          break label135;
        localStringBuilder.append("null");
      }
      label72: if (o())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("checksum:");
        if (this.c != null)
          break label147;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label135: localStringBuilder.append(this.b);
      break label72;
      label147: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<al>
  {
    public void a(dn paramdn, al paramal)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        paramal.p();
        return;
      }
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
        if (localdi.b == 13)
        {
          dk localdk = paramdn.n();
          paramal.a = new HashMap(2 * localdk.c);
          for (int j = 0; j < localdk.c; j++)
          {
            String str = paramdn.z();
            aj localaj = new aj();
            localaj.a(paramdn);
            paramal.a.put(str, localaj);
          }
          paramdn.o();
          paramal.a(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 15)
        {
          dj localdj = paramdn.p();
          paramal.b = new ArrayList(localdj.b);
          for (int i = 0; i < localdj.b; i++)
          {
            ah localah = new ah();
            localah.a(paramdn);
            paramal.b.add(localah);
          }
          paramdn.q();
          paramal.b(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
        continue;
        if (localdi.b == 11)
        {
          paramal.c = paramdn.z();
          paramal.c(true);
          continue;
        }
        dq.a(paramdn, localdi.b);
      }
    }

    public void b(dn paramdn, al paramal)
      throws cs
    {
      paramal.p();
      paramdn.a(al.q());
      if (paramal.a != null)
      {
        paramdn.a(al.r());
        paramdn.a(new dk(11, 12, paramal.a.size()));
        Iterator localIterator2 = paramal.a.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          paramdn.a((String)localEntry.getKey());
          ((aj)localEntry.getValue()).b(paramdn);
        }
        paramdn.e();
        paramdn.c();
      }
      if ((paramal.b != null) && (paramal.l()))
      {
        paramdn.a(al.s());
        paramdn.a(new dj(12, paramal.b.size()));
        Iterator localIterator1 = paramal.b.iterator();
        while (localIterator1.hasNext())
          ((ah)localIterator1.next()).b(paramdn);
        paramdn.f();
        paramdn.c();
      }
      if ((paramal.c != null) && (paramal.o()))
      {
        paramdn.a(al.t());
        paramdn.a(paramal.c);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public al.a a()
    {
      return new al.a(null);
    }
  }

  private static class c extends dy<al>
  {
    public void a(dn paramdn, al paramal)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramal.a.size());
      Iterator localIterator1 = paramal.a.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localdt.a((String)localEntry.getKey());
        ((aj)localEntry.getValue()).b(localdt);
      }
      BitSet localBitSet = new BitSet();
      if (paramal.l())
        localBitSet.set(0);
      if (paramal.o())
        localBitSet.set(1);
      localdt.a(localBitSet, 2);
      if (paramal.l())
      {
        localdt.a(paramal.b.size());
        Iterator localIterator2 = paramal.b.iterator();
        while (localIterator2.hasNext())
          ((ah)localIterator2.next()).b(localdt);
      }
      if (paramal.o())
        localdt.a(paramal.c);
    }

    public void b(dn paramdn, al paramal)
      throws cs
    {
      int i = 0;
      dt localdt = (dt)paramdn;
      dk localdk = new dk(11, 12, localdt.w());
      paramal.a = new HashMap(2 * localdk.c);
      for (int j = 0; j < localdk.c; j++)
      {
        String str = localdt.z();
        aj localaj = new aj();
        localaj.a(localdt);
        paramal.a.put(str, localaj);
      }
      paramal.a(true);
      BitSet localBitSet = localdt.b(2);
      if (localBitSet.get(0))
      {
        dj localdj = new dj(12, localdt.w());
        paramal.b = new ArrayList(localdj.b);
        while (i < localdj.b)
        {
          ah localah = new ah();
          localah.a(localdt);
          paramal.b.add(localah);
          i++;
        }
        paramal.b(true);
      }
      if (localBitSet.get(1))
      {
        paramal.c = localdt.z();
        paramal.c(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public al.c a()
    {
      return new al.c(null);
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
 * Qualified Name:     c.a.al
 * JD-Core Version:    0.6.0
 */