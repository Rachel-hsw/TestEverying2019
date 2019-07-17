package com.umeng.socialize.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class k
{
  private int a;
  private String b = "";
  private Map<p, Integer> c;
  private Map<String, Integer> d;

  public k(int paramInt)
  {
    this(paramInt, "");
  }

  public k(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = new HashMap();
    this.d = new HashMap();
  }

  public int a()
  {
    return this.a;
  }

  public int a(p paramp)
  {
    if (this.c.containsKey(paramp))
      return ((Integer)this.c.get(paramp)).intValue();
    return -102;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(Map<p, Integer> paramMap)
  {
    this.c.putAll(paramMap);
  }

  public int b(String paramString)
  {
    if (this.d.containsKey(paramString))
      return ((Integer)this.d.get(paramString)).intValue();
    p localp = p.a(paramString);
    if ((localp != null) && (this.c.containsKey(localp)))
      return ((Integer)this.c.get(localp)).intValue();
    return -103;
  }

  public String b()
  {
    return this.b;
  }

  public void b(Map<String, Integer> paramMap)
  {
    this.d.putAll(paramMap);
  }

  public Map<p, Integer> c()
  {
    return this.c;
  }

  public Map<String, Integer> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.d);
    Set localSet = this.c.keySet();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        Integer localInteger = (Integer)this.c.get(localp);
        localHashMap.put(localp.toString(), localInteger);
      }
    }
    return localHashMap;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("status=" + this.a + "{");
    if ((this.c != null) && (this.c.keySet() != null))
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        Integer localInteger = (Integer)this.c.get(localp);
        localStringBuilder.append("[" + localp.toString() + "=" + localInteger + "]");
      }
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.k
 * JD-Core Version:    0.6.0
 */