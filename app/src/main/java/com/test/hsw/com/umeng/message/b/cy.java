package com.umeng.message.b;

import com.squareup.wire.WireOutput;
import com.squareup.wire.WireType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class cy
{
  public Map<Integer, List<a>> a;

  public cy()
  {
  }

  public cy(cy paramcy)
  {
    if (paramcy.a != null)
      b().putAll(paramcy.a);
  }

  private <T> void a(Map<Integer, List<a>> paramMap, int paramInt, T paramT, WireType paramWireType)
    throws IOException
  {
    List localList = (List)paramMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList;
    if (localList == null)
    {
      localArrayList = new ArrayList();
      paramMap.put(Integer.valueOf(paramInt), localArrayList);
    }
    for (Object localObject1 = localArrayList; ; localObject1 = localList)
    {
      Object localObject2;
      switch (cz.a[paramWireType.ordinal()])
      {
      default:
        throw new IllegalArgumentException("Unsupported wireType = " + paramWireType);
      case 1:
        localObject2 = a.a(paramInt, (Long)paramT);
      case 2:
      case 3:
      case 4:
      }
      while ((((List)localObject1).size() > 0) && (((a)((List)localObject1).get(0)).c() != ((a)localObject2).c()))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = ((a)localObject2).c();
        arrayOfObject[1] = ((a)((List)localObject1).get(0)).c();
        arrayOfObject[2] = Integer.valueOf(paramInt);
        throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", arrayOfObject));
        localObject2 = a.a(paramInt, (Integer)paramT);
        continue;
        localObject2 = a.b(paramInt, (Long)paramT);
        continue;
        localObject2 = a.a(paramInt, (j)paramT);
      }
      ((List)localObject1).add(localObject2);
      return;
    }
  }

  private Map<Integer, List<a>> b()
  {
    if (this.a == null)
      this.a = new TreeMap();
    return this.a;
  }

  public int a()
  {
    if (this.a != null)
    {
      Iterator localIterator1 = this.a.entrySet().iterator();
      int j;
      for (i = 0; localIterator1.hasNext(); i = j)
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        j = i + WireOutput.a(((Integer)localEntry.getKey()).intValue());
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
          j += ((a)localIterator2.next()).a();
      }
    }
    int i = 0;
    return i;
  }

  public void a(int paramInt, j paramj)
    throws IOException
  {
    a(b(), paramInt, paramj, WireType.LENGTH_DELIMITED);
  }

  public void a(int paramInt, Integer paramInteger)
    throws IOException
  {
    a(b(), paramInt, paramInteger, WireType.FIXED32);
  }

  public void a(int paramInt, Long paramLong)
    throws IOException
  {
    a(b(), paramInt, paramLong, WireType.VARINT);
  }

  public void a(WireOutput paramWireOutput)
    throws IOException
  {
    if (this.a != null)
    {
      Iterator localIterator1 = this.a.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        int i = ((Integer)localEntry.getKey()).intValue();
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
          ((a)localIterator2.next()).a(i, paramWireOutput);
      }
    }
  }

  public void b(int paramInt, Long paramLong)
    throws IOException
  {
    a(b(), paramInt, paramLong, WireType.FIXED64);
  }

  public static abstract class a
  {
    private final int a;
    private final WireType b;

    public a(int paramInt, WireType paramWireType)
    {
      this.a = paramInt;
      this.b = paramWireType;
    }

    public static cy.b a(int paramInt, Integer paramInteger)
    {
      return new cy.b(paramInt, paramInteger);
    }

    public static cy.d a(int paramInt, j paramj)
    {
      return new cy.d(paramInt, paramj);
    }

    public static cy.f a(int paramInt, Long paramLong)
    {
      return new cy.f(paramInt, paramLong);
    }

    public static cy.c b(int paramInt, Long paramLong)
    {
      return new cy.c(paramInt, paramLong);
    }

    public abstract int a();

    public abstract void a(int paramInt, WireOutput paramWireOutput)
      throws IOException;

    public int b()
    {
      return this.a;
    }

    public WireType c()
    {
      return this.b;
    }

    public Integer d()
    {
      throw new IllegalStateException();
    }

    public Long e()
    {
      throw new IllegalStateException();
    }

    public j f()
    {
      throw new IllegalStateException();
    }
  }

  static final class b extends cy.a
  {
    private final Integer a;

    public b(int paramInt, Integer paramInteger)
    {
      super(WireType.FIXED32);
      this.a = paramInteger;
    }

    public int a()
    {
      return 4;
    }

    public void a(int paramInt, WireOutput paramWireOutput)
      throws IOException
    {
      paramWireOutput.a(paramInt, WireType.FIXED32);
      paramWireOutput.f(this.a.intValue());
    }

    public Integer d()
    {
      return this.a;
    }
  }

  static final class c extends cy.a
  {
    private final Long a;

    public c(int paramInt, Long paramLong)
    {
      super(WireType.FIXED64);
      this.a = paramLong;
    }

    public int a()
    {
      return 8;
    }

    public void a(int paramInt, WireOutput paramWireOutput)
      throws IOException
    {
      paramWireOutput.a(paramInt, WireType.FIXED64);
      paramWireOutput.c(this.a.longValue());
    }

    public Long e()
    {
      return this.a;
    }
  }

  static final class d extends cy.a
  {
    private final j a;

    public d(int paramInt, j paramj)
    {
      super(WireType.LENGTH_DELIMITED);
      this.a = paramj;
    }

    public int a()
    {
      return WireOutput.b(this.a.f()) + this.a.f();
    }

    public void a(int paramInt, WireOutput paramWireOutput)
      throws IOException
    {
      paramWireOutput.a(paramInt, WireType.LENGTH_DELIMITED);
      paramWireOutput.e(this.a.f());
      paramWireOutput.b(this.a.g());
    }

    public j f()
    {
      return this.a;
    }
  }

  static enum e
  {
    static
    {
      e[] arrayOfe = new e[4];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      e = arrayOfe;
    }

    public static e a(String paramString)
    {
      if ("varint".equals(paramString))
        return a;
      if ("fixed32".equals(paramString))
        return b;
      if ("fixed64".equals(paramString))
        return c;
      if ("length-delimited".equals(paramString))
        return d;
      throw new IllegalArgumentException("Unknown type " + paramString);
    }
  }

  static final class f extends cy.a
  {
    private final Long a;

    public f(int paramInt, Long paramLong)
    {
      super(WireType.VARINT);
      this.a = paramLong;
    }

    public int a()
    {
      return WireOutput.a(this.a.longValue());
    }

    public void a(int paramInt, WireOutput paramWireOutput)
      throws IOException
    {
      paramWireOutput.a(paramInt, WireType.VARINT);
      paramWireOutput.b(this.a.longValue());
    }

    public Long e()
    {
      return this.a;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cy
 * JD-Core Version:    0.6.0
 */