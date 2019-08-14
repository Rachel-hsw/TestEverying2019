package com.umeng.message.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public abstract class cw<T>
{
  private static final int b = 64;
  private static final float c = 0.75F;
  private static final Comparator<? super Map.Entry<Integer, ?>> d = new cx();
  List<T> a;

  protected cw(Map<Integer, T> paramMap)
  {
    this.a = c(paramMap);
  }

  public static <T> cw<T> a(Map<Integer, T> paramMap)
  {
    int i = b(paramMap);
    if (a(paramMap.size(), i))
      return a.a(paramMap, i);
    return b.b(paramMap);
  }

  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 <= 64) || (paramInt1 / paramInt2 > 0.75F);
  }

  private static <T> int b(Map<Integer, T> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    int i = -1;
    int j;
    if (localIterator.hasNext())
    {
      j = ((Integer)localIterator.next()).intValue();
      if (j <= i)
        break label48;
    }
    while (true)
    {
      i = j;
      break;
      return i;
      label48: j = i;
    }
  }

  private static <T> List<T> c(Map<Integer, T> paramMap)
  {
    TreeSet localTreeSet = new TreeSet(d);
    localTreeSet.addAll(paramMap.entrySet());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localTreeSet.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    return localArrayList;
  }

  public abstract T a(int paramInt);

  public Collection<T> a()
  {
    return this.a;
  }

  public abstract boolean b(int paramInt);

  static final class a<T> extends cw<T>
  {
    Object[] b;
    int c = -1;

    private a(Map<Integer, T> paramMap, int paramInt)
    {
      super();
      this.c = paramInt;
      this.b = new Object[paramInt + 1];
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Integer localInteger = (Integer)localEntry.getKey();
        if (localInteger.intValue() <= 0)
          throw new IllegalArgumentException("Input map key is negative or zero");
        this.b[localInteger.intValue()] = localEntry.getValue();
      }
    }

    public static <T> a<T> a(Map<Integer, T> paramMap, int paramInt)
    {
      return new a(paramMap, paramInt);
    }

    public T a(int paramInt)
    {
      if (paramInt > this.c)
        return null;
      return this.b[paramInt];
    }

    public boolean b(int paramInt)
    {
      if (paramInt > this.c);
      do
        return false;
      while (this.b[paramInt] == null);
      return true;
    }
  }

  static final class b<T> extends cw<T>
  {
    Map<Integer, T> b;

    private b(Map<Integer, T> paramMap)
    {
      super();
      this.b = paramMap;
    }

    public static <T> b<T> b(Map<Integer, T> paramMap)
    {
      return new b(paramMap);
    }

    public T a(int paramInt)
    {
      return this.b.get(Integer.valueOf(paramInt));
    }

    public boolean b(int paramInt)
    {
      return this.b.containsKey(Integer.valueOf(paramInt));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cw
 * JD-Core Version:    0.6.0
 */