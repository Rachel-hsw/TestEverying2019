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

public class ah
  implements cl<ah, e>, Serializable, Cloneable
{
  public static final Map<e, cz> e;
  private static final ds f = new ds("IdJournal");
  private static final di g = new di("domain", 11, 1);
  private static final di h = new di("old_id", 11, 2);
  private static final di i = new di("new_id", 11, 3);
  private static final di j = new di("ts", 10, 4);
  private static final Map<Class<? extends dv>, dw> k = new HashMap();
  private static final int l;
  public String a;
  public String b;
  public String c;
  public long d;
  private byte m = 0;
  private e[] n;

  static
  {
    k.put(dx.class, new b(null));
    k.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("domain", 1, new da(11)));
    localEnumMap.put(e.b, new cz("old_id", 2, new da(11)));
    localEnumMap.put(e.c, new cz("new_id", 1, new da(11)));
    localEnumMap.put(e.d, new cz("ts", 1, new da(10)));
    e = Collections.unmodifiableMap(localEnumMap);
    cz.a(ah.class, e);
  }

  public ah()
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.b;
    this.n = arrayOfe;
  }

  public ah(ah paramah)
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = e.b;
    this.n = arrayOfe;
    this.m = paramah.m;
    if (paramah.e())
      this.a = paramah.a;
    if (paramah.i())
      this.b = paramah.b;
    if (paramah.l())
      this.c = paramah.c;
    this.d = paramah.d;
  }

  public ah(String paramString1, String paramString2, long paramLong)
  {
    this();
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    d(true);
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

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public ah a()
  {
    return new ah(this);
  }

  public ah a(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }

  public ah a(String paramString)
  {
    this.a = paramString;
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

  public ah b(String paramString)
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
    this.d = 0L;
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

  public ah c(String paramString)
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

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    this.m = ci.a(this.m, 0, paramBoolean);
  }

  public boolean e()
  {
    return this.a != null;
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

  public long m()
  {
    return this.d;
  }

  public void n()
  {
    this.m = ci.b(this.m, 0);
  }

  public boolean o()
  {
    return ci.a(this.m, 0);
  }

  public void p()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'domain' was not present! Struct: " + toString());
    if (this.c == null)
      throw new do("Required field 'new_id' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
    localStringBuilder.append("domain:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("old_id:");
        if (this.b != null)
          break label153;
        localStringBuilder.append("null");
      }
      label72: localStringBuilder.append(", ");
      localStringBuilder.append("new_id:");
      if (this.c != null)
        break label165;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label153: localStringBuilder.append(this.b);
      break label72;
      label165: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<ah>
  {
    public void a(dn paramdn, ah paramah)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramah.o())
          throw new do("Required field 'ts' was not found in serialized data! Struct: " + toString());
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
        }
        while (true)
        {
          paramdn.m();
          break;
          if (localdi.b == 11)
          {
            paramah.a = paramdn.z();
            paramah.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramah.b = paramdn.z();
            paramah.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramah.c = paramdn.z();
            paramah.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 10)
          {
            paramah.d = paramdn.x();
            paramah.d(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramah.p();
    }

    public void b(dn paramdn, ah paramah)
      throws cs
    {
      paramah.p();
      paramdn.a(ah.q());
      if (paramah.a != null)
      {
        paramdn.a(ah.r());
        paramdn.a(paramah.a);
        paramdn.c();
      }
      if ((paramah.b != null) && (paramah.i()))
      {
        paramdn.a(ah.s());
        paramdn.a(paramah.b);
        paramdn.c();
      }
      if (paramah.c != null)
      {
        paramdn.a(ah.t());
        paramdn.a(paramah.c);
        paramdn.c();
      }
      paramdn.a(ah.u());
      paramdn.a(paramah.d);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ah.a a()
    {
      return new ah.a(null);
    }
  }

  private static class c extends dy<ah>
  {
    public void a(dn paramdn, ah paramah)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramah.a);
      localdt.a(paramah.c);
      localdt.a(paramah.d);
      BitSet localBitSet = new BitSet();
      if (paramah.i())
        localBitSet.set(0);
      localdt.a(localBitSet, 1);
      if (paramah.i())
        localdt.a(paramah.b);
    }

    public void b(dn paramdn, ah paramah)
      throws cs
    {
      dt localdt = (dt)paramdn;
      paramah.a = localdt.z();
      paramah.a(true);
      paramah.c = localdt.z();
      paramah.c(true);
      paramah.d = localdt.x();
      paramah.d(true);
      if (localdt.b(1).get(0))
      {
        paramah.b = localdt.z();
        paramah.b(true);
      }
    }
  }

  private static class d
    implements dw
  {
    public ah.c a()
    {
      return new ah.c(null);
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
 * Qualified Name:     c.a.ah
 * JD-Core Version:    0.6.0
 */