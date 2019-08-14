package c.a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cw<T extends cw<?, ?>, F extends ct>
  implements cl<T, F>
{
  private static final Map<Class<? extends dv>, dw> a = new HashMap();
  protected Object b;
  protected F c;

  static
  {
    a.put(dx.class, new b(null));
    a.put(dy.class, new d(null));
  }

  protected cw()
  {
    this.c = null;
    this.b = null;
  }

  protected cw(F paramF, Object paramObject)
  {
    b(paramF, paramObject);
  }

  protected cw(cw<T, F> paramcw)
  {
    if (!paramcw.getClass().equals(getClass()))
      throw new ClassCastException();
    this.c = paramcw.c;
    this.b = a(paramcw.b);
  }

  private static Object a(Object paramObject)
  {
    if ((paramObject instanceof cl))
      paramObject = ((cl)paramObject).g();
    do
    {
      return paramObject;
      if ((paramObject instanceof ByteBuffer))
        return cm.d((ByteBuffer)paramObject);
      if ((paramObject instanceof List))
        return a((List)paramObject);
      if ((paramObject instanceof Set))
        return a((Set)paramObject);
    }
    while (!(paramObject instanceof Map));
    return a((Map)paramObject);
  }

  private static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(a(localIterator.next()));
    return localArrayList;
  }

  private static Map a(Map<Object, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(a(localEntry.getKey()), a(localEntry.getValue()));
    }
    return localHashMap;
  }

  private static Set a(Set paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localHashSet.add(a(localIterator.next()));
    return localHashSet;
  }

  protected abstract di a(F paramF);

  protected abstract Object a(dn paramdn, di paramdi)
    throws cs;

  protected abstract Object a(dn paramdn, short paramShort)
    throws cs;

  public void a(int paramInt, Object paramObject)
  {
    b(b((short)paramInt), paramObject);
  }

  protected abstract void a(F paramF, Object paramObject)
    throws ClassCastException;

  public void a(dn paramdn)
    throws cs
  {
    ((dw)a.get(paramdn.D())).b().b(paramdn, this);
  }

  protected abstract F b(short paramShort);

  public Object b(F paramF)
  {
    if (paramF != this.c)
      throw new IllegalArgumentException("Cannot get the value of field " + paramF + " because union's set field is " + this.c);
    return j();
  }

  public final void b()
  {
    this.c = null;
    this.b = null;
  }

  public void b(F paramF, Object paramObject)
  {
    a(paramF, paramObject);
    this.c = paramF;
    this.b = paramObject;
  }

  public void b(dn paramdn)
    throws cs
  {
    ((dw)a.get(paramdn.D())).b().a(paramdn, this);
  }

  protected abstract ds c();

  public Object c(int paramInt)
  {
    return b(b((short)paramInt));
  }

  protected abstract void c(dn paramdn)
    throws cs;

  public boolean c(F paramF)
  {
    return this.c == paramF;
  }

  protected abstract void d(dn paramdn)
    throws cs;

  public boolean d(int paramInt)
  {
    return c(b((short)paramInt));
  }

  public F i()
  {
    return this.c;
  }

  public Object j()
  {
    return this.b;
  }

  public boolean k()
  {
    return this.c != null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" ");
    Object localObject;
    if (i() != null)
    {
      localObject = j();
      localStringBuilder.append(a(i()).a);
      localStringBuilder.append(":");
      if (!(localObject instanceof ByteBuffer))
        break label99;
      cm.a((ByteBuffer)localObject, localStringBuilder);
    }
    while (true)
    {
      localStringBuilder.append(">");
      return localStringBuilder.toString();
      label99: localStringBuilder.append(localObject.toString());
    }
  }

  private static class a extends dx<cw>
  {
    public void a(dn paramdn, cw paramcw)
      throws cs
    {
      paramcw.c = null;
      paramcw.b = null;
      paramdn.j();
      di localdi = paramdn.l();
      paramcw.b = paramcw.a(paramdn, localdi);
      if (paramcw.b != null)
        paramcw.c = paramcw.b(localdi.c);
      paramdn.m();
      paramdn.l();
      paramdn.k();
    }

    public void b(dn paramdn, cw paramcw)
      throws cs
    {
      if ((paramcw.i() == null) || (paramcw.j() == null))
        throw new do("Cannot write a TUnion with no set value!");
      paramdn.a(paramcw.c());
      paramdn.a(paramcw.a(paramcw.c));
      paramcw.c(paramdn);
      paramdn.c();
      paramdn.d();
      paramdn.b();
    }
  }

  private static class b
    implements dw
  {
    public cw.a a()
    {
      return new cw.a(null);
    }
  }

  private static class c extends dy<cw>
  {
    public void a(dn paramdn, cw paramcw)
      throws cs
    {
      paramcw.c = null;
      paramcw.b = null;
      short s = paramdn.v();
      paramcw.b = paramcw.a(paramdn, s);
      if (paramcw.b != null)
        paramcw.c = paramcw.b(s);
    }

    public void b(dn paramdn, cw paramcw)
      throws cs
    {
      if ((paramcw.i() == null) || (paramcw.j() == null))
        throw new do("Cannot write a TUnion with no set value!");
      paramdn.a(paramcw.c.a());
      paramcw.d(paramdn);
    }
  }

  private static class d
    implements dw
  {
    public cw.c a()
    {
      return new cw.c(null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cw
 * JD-Core Version:    0.6.0
 */