package com.alipay.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static List<j> a;

  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }

  public static String a(Object paramObject)
  {
    if (paramObject == null)
      return null;
    Object localObject = b(paramObject);
    if (com.alipay.a.b.a.a(localObject.getClass()))
      return org.json.alipay.b.c(localObject.toString());
    if (Collection.class.isAssignableFrom(localObject.getClass()))
      return new org.json.alipay.a((List)localObject).toString();
    if (Map.class.isAssignableFrom(localObject.getClass()))
      return new org.json.alipay.b((Map)localObject).toString();
    throw new IllegalArgumentException("Unsupported Class : " + localObject.getClass());
  }

  public static Object b(Object paramObject)
  {
    if (paramObject == null)
      return null;
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (!localj.a(paramObject.getClass()))
        continue;
      Object localObject = localj.a(paramObject);
      if (localObject != null)
        return localObject;
    }
    throw new IllegalArgumentException("Unsupported Class : " + paramObject.getClass());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.f
 * JD-Core Version:    0.6.0
 */