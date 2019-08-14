package c.a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bc extends cw<bc, a>
{
  public static final Map<a, cz> a;
  private static final ds d = new ds("PropertyValue");
  private static final di e = new di("string_value", 11, 1);
  private static final di f = new di("long_value", 10, 2);

  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new cz("string_value", 3, new da(11)));
    localEnumMap.put(a.b, new cz("long_value", 3, new da(10)));
    a = Collections.unmodifiableMap(localEnumMap);
    cz.a(bc.class, a);
  }

  public bc()
  {
  }

  public bc(a parama, Object paramObject)
  {
    super(parama, paramObject);
  }

  public bc(bc parambc)
  {
    super(parambc);
  }

  public static bc a(long paramLong)
  {
    bc localbc = new bc();
    localbc.b(paramLong);
    return localbc;
  }

  public static bc a(String paramString)
  {
    bc localbc = new bc();
    localbc.b(paramString);
    return localbc;
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

  public a a(int paramInt)
  {
    return a.a(paramInt);
  }

  protected a a(short paramShort)
  {
    return a.b(paramShort);
  }

  public bc a()
  {
    return new bc(this);
  }

  protected di a(a parama)
  {
    switch (bd.a[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown field id " + parama);
    case 1:
      return e;
    case 2:
    }
    return f;
  }

  protected Object a(dn paramdn, di paramdi)
    throws cs
  {
    a locala = a.a(paramdi.c);
    String str = null;
    if (locala != null);
    switch (bd.a[locala.ordinal()])
    {
    default:
      throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
    case 1:
      if (paramdi.b == e.b)
      {
        str = paramdn.z();
        return str;
      }
      dq.a(paramdn, paramdi.b);
      return null;
    case 2:
    }
    if (paramdi.b == f.b)
      return Long.valueOf(paramdn.x());
    dq.a(paramdn, paramdi.b);
    return null;
  }

  protected Object a(dn paramdn, short paramShort)
    throws cs
  {
    a locala = a.a(paramShort);
    if (locala != null)
    {
      switch (bd.a[locala.ordinal()])
      {
      default:
        throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      case 1:
        return paramdn.z();
      case 2:
      }
      return Long.valueOf(paramdn.x());
    }
    throw new do("Couldn't find a field with field id " + paramShort);
  }

  protected void a(a parama, Object paramObject)
    throws ClassCastException
  {
    switch (bd.a[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown field id " + parama);
    case 1:
      if (!(paramObject instanceof String))
        break;
    case 2:
    }
    do
    {
      return;
      throw new ClassCastException("Was expecting value of type String for field 'string_value', but got " + paramObject.getClass().getSimpleName());
    }
    while ((paramObject instanceof Long));
    throw new ClassCastException("Was expecting value of type Long for field 'long_value', but got " + paramObject.getClass().getSimpleName());
  }

  public boolean a(bc parambc)
  {
    return (parambc != null) && (i() == parambc.i()) && (j().equals(parambc.j()));
  }

  public int b(bc parambc)
  {
    int i = cm.a((Comparable)i(), (Comparable)parambc.i());
    if (i == 0)
      i = cm.a(j(), parambc.j());
    return i;
  }

  public void b(long paramLong)
  {
    this.c = a.b;
    this.b = Long.valueOf(paramLong);
  }

  public void b(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.c = a.a;
    this.b = paramString;
  }

  protected ds c()
  {
    return d;
  }

  protected void c(dn paramdn)
    throws cs
  {
    switch (bd.a[((a)this.c).ordinal()])
    {
    default:
      throw new IllegalStateException("Cannot write union with unknown field " + this.c);
    case 1:
      paramdn.a((String)this.b);
      return;
    case 2:
    }
    paramdn.a(((Long)this.b).longValue());
  }

  public String d()
  {
    if (i() == a.a)
      return (String)j();
    throw new RuntimeException("Cannot get field 'string_value' because union is currently set to " + a((a)i()).a);
  }

  protected void d(dn paramdn)
    throws cs
  {
    switch (bd.a[((a)this.c).ordinal()])
    {
    default:
      throw new IllegalStateException("Cannot write union with unknown field " + this.c);
    case 1:
      paramdn.a((String)this.b);
      return;
    case 2:
    }
    paramdn.a(((Long)this.b).longValue());
  }

  public long e()
  {
    if (i() == a.b)
      return ((Long)j()).longValue();
    throw new RuntimeException("Cannot get field 'long_value' because union is currently set to " + a((a)i()).a);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof bc))
      return a((bc)paramObject);
    return false;
  }

  public boolean f()
  {
    return this.c == a.a;
  }

  public boolean h()
  {
    return this.c == a.b;
  }

  public int hashCode()
  {
    return 0;
  }

  public static enum a
    implements ct
  {
    private static final Map<String, a> c;
    private final short d;
    private final String e;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      f = arrayOfa;
      c = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        c.put(locala.b(), locala);
      }
    }

    private a(short paramShort, String paramString)
    {
      this.d = paramShort;
      this.e = paramString;
    }

    public static a a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        return a;
      case 2:
      }
      return b;
    }

    public static a a(String paramString)
    {
      return (a)c.get(paramString);
    }

    public static a b(int paramInt)
    {
      a locala = a(paramInt);
      if (locala == null)
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      return locala;
    }

    public short a()
    {
      return this.d;
    }

    public String b()
    {
      return this.e;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.bc
 * JD-Core Version:    0.6.0
 */