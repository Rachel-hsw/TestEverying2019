package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ao
  implements cl<ao, e>, Serializable, Cloneable
{
  public static final Map<e, cz> d;
  private static final ds e = new ds("Imprint");
  private static final di f = new di("property", 13, 1);
  private static final di g = new di("version", 8, 2);
  private static final di h = new di("checksum", 11, 3);
  private static final Map<Class<? extends dv>, dw> i = new HashMap();
  private static final int j;
  public Map<String, aq> a;
  public int b;
  public String c;
  private byte k = 0;

  static
  {
    i.put(dx.class, new b(null));
    i.put(dy.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cz("property", 1, new dc(13, new da(11), new de(12, aq.class))));
    localEnumMap.put(e.b, new cz("version", 1, new da(8)));
    localEnumMap.put(e.c, new cz("checksum", 1, new da(11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cz.a(ao.class, d);
  }

  public ao()
  {
  }

  public ao(ao paramao)
  {
    this.k = paramao.k;
    if (paramao.f())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramao.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), new aq((aq)localEntry.getValue()));
      }
      this.a = localHashMap;
    }
    this.b = paramao.b;
    if (paramao.m())
      this.c = paramao.c;
  }

  public ao(Map<String, aq> paramMap, int paramInt, String paramString)
  {
    this();
    this.a = paramMap;
    this.b = paramInt;
    b(true);
    this.c = paramString;
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

  public ao a()
  {
    return new ao(this);
  }

  public ao a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }

  public ao a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public ao a(Map<String, aq> paramMap)
  {
    this.a = paramMap;
    return this;
  }

  public void a(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().b(paramdn, this);
  }

  public void a(String paramString, aq paramaq)
  {
    if (this.a == null)
      this.a = new HashMap();
    this.a.put(paramString, paramaq);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0;
    this.c = null;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)i.get(paramdn.D())).b().a(paramdn, this);
  }

  public void b(boolean paramBoolean)
  {
    this.k = ci.a(this.k, 0, paramBoolean);
  }

  public int c()
  {
    if (this.a == null)
      return 0;
    return this.a.size();
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

  public Map<String, aq> d()
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
    return this.b;
  }

  public void i()
  {
    this.k = ci.b(this.k, 0);
  }

  public boolean j()
  {
    return ci.a(this.k, 0);
  }

  public String k()
  {
    return this.c;
  }

  public void l()
  {
    this.c = null;
  }

  public boolean m()
  {
    return this.c != null;
  }

  public void n()
    throws cs
  {
    if (this.a == null)
      throw new do("Required field 'property' was not present! Struct: " + toString());
    if (this.c == null)
      throw new do("Required field 'checksum' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Imprint(");
    localStringBuilder.append("property:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.c != null)
        break label115;
      localStringBuilder.append("null");
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label115: localStringBuilder.append(this.c);
    }
  }

  private static class a extends dx<ao>
  {
    public void a(dn paramdn, ao paramao)
      throws cs
    {
      paramdn.j();
      di localdi = paramdn.l();
      if (localdi.b == 0)
      {
        paramdn.k();
        if (!paramao.j())
          throw new do("Required field 'version' was not found in serialized data! Struct: " + toString());
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
          if (localdi.b == 13)
          {
            dk localdk = paramdn.n();
            paramao.a = new HashMap(2 * localdk.c);
            for (int i = 0; i < localdk.c; i++)
            {
              String str = paramdn.z();
              aq localaq = new aq();
              localaq.a(paramdn);
              paramao.a.put(str, localaq);
            }
            paramdn.o();
            paramao.a(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 8)
          {
            paramao.b = paramdn.w();
            paramao.b(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
          continue;
          if (localdi.b == 11)
          {
            paramao.c = paramdn.z();
            paramao.c(true);
            continue;
          }
          dq.a(paramdn, localdi.b);
        }
      }
      paramao.n();
    }

    public void b(dn paramdn, ao paramao)
      throws cs
    {
      paramao.n();
      paramdn.a(ao.o());
      if (paramao.a != null)
      {
        paramdn.a(ao.p());
        paramdn.a(new dk(11, 12, paramao.a.size()));
        Iterator localIterator = paramao.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramdn.a((String)localEntry.getKey());
          ((aq)localEntry.getValue()).b(paramdn);
        }
        paramdn.e();
        paramdn.c();
      }
      paramdn.a(ao.q());
      paramdn.a(paramao.b);
      paramdn.c();
      if (paramao.c != null)
      {
        paramdn.a(ao.r());
        paramdn.a(paramao.c);
        paramdn.c();
      }
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public ao.a a()
    {
      return new ao.a(null);
    }
  }

  private static class c extends dy<ao>
  {
    public void a(dn paramdn, ao paramao)
      throws cs
    {
      dt localdt = (dt)paramdn;
      localdt.a(paramao.a.size());
      Iterator localIterator = paramao.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localdt.a((String)localEntry.getKey());
        ((aq)localEntry.getValue()).b(localdt);
      }
      localdt.a(paramao.b);
      localdt.a(paramao.c);
    }

    public void b(dn paramdn, ao paramao)
      throws cs
    {
      dt localdt = (dt)paramdn;
      dk localdk = new dk(11, 12, localdt.w());
      paramao.a = new HashMap(2 * localdk.c);
      for (int i = 0; i < localdk.c; i++)
      {
        String str = localdt.z();
        aq localaq = new aq();
        localaq.a(localdt);
        paramao.a.put(str, localaq);
      }
      paramao.a(true);
      paramao.b = localdt.w();
      paramao.b(true);
      paramao.c = localdt.z();
      paramao.c(true);
    }
  }

  private static class d
    implements dw
  {
    public ao.c a()
    {
      return new ao.c(null);
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
 * Qualified Name:     c.a.ao
 * JD-Core Version:    0.6.0
 */