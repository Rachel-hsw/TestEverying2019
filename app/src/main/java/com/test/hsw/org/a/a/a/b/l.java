package org.a.a.a.b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class l extends c<a>
{
  private final Map<String, c<?>> a = new HashMap();

  public l()
  {
  }

  public l(ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
  }

  public void a(String paramString, c<?> paramc)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Name of child initializer must not be null!");
    if (paramc == null)
      throw new IllegalArgumentException("Child initializer must not be null!");
    monitorenter;
    try
    {
      if (c())
        throw new IllegalStateException("addInitializer() must not be called after start()!");
    }
    finally
    {
      monitorexit;
    }
    this.a.put(paramString, paramc);
    monitorexit;
  }

  protected int g()
  {
    Iterator localIterator = this.a.values().iterator();
    int i = 1;
    while (localIterator.hasNext())
      i += ((c)localIterator.next()).g();
    return i;
  }

  protected a i()
    throws Exception
  {
    monitorenter;
    HashMap localHashMap1;
    try
    {
      localHashMap1 = new HashMap(this.a);
      monitorexit;
      ExecutorService localExecutorService = f();
      Iterator localIterator1 = localHashMap1.values().iterator();
      while (localIterator1.hasNext())
      {
        c localc = (c)localIterator1.next();
        if (localc.b() == null)
          localc.a(localExecutorService);
        localc.d();
      }
    }
    finally
    {
      monitorexit;
    }
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    Iterator localIterator2 = localHashMap1.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      try
      {
        localHashMap2.put(localEntry.getKey(), ((c)localEntry.getValue()).a());
      }
      catch (f localf)
      {
        localHashMap3.put(localEntry.getKey(), localf);
      }
    }
    return new a(localHashMap1, localHashMap2, localHashMap3, null);
  }

  public static class a
  {
    private final Map<String, c<?>> a;
    private final Map<String, Object> b;
    private final Map<String, f> c;

    private a(Map<String, c<?>> paramMap, Map<String, Object> paramMap1, Map<String, f> paramMap2)
    {
      this.a = paramMap;
      this.b = paramMap1;
      this.c = paramMap2;
    }

    private c<?> e(String paramString)
    {
      c localc = (c)this.a.get(paramString);
      if (localc == null)
        throw new NoSuchElementException("No child initializer with name " + paramString);
      return localc;
    }

    public Set<String> a()
    {
      return Collections.unmodifiableSet(this.a.keySet());
    }

    public c<?> a(String paramString)
    {
      return e(paramString);
    }

    public Object b(String paramString)
    {
      e(paramString);
      return this.b.get(paramString);
    }

    public boolean b()
    {
      return this.c.isEmpty();
    }

    public boolean c(String paramString)
    {
      e(paramString);
      return this.c.containsKey(paramString);
    }

    public f d(String paramString)
    {
      e(paramString);
      return (f)this.c.get(paramString);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.l
 * JD-Core Version:    0.6.0
 */