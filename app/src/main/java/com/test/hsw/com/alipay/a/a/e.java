package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static List<i> a;

  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new k());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }

  public static final <T> T a(Object paramObject, Type paramType)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (!locali.a(com.alipay.a.b.a.a(paramType)))
        continue;
      Object localObject = locali.a(paramObject, paramType);
      if (localObject != null)
        return localObject;
    }
    return null;
  }

  public static final Object a(String paramString, Type paramType)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    String str = paramString.trim();
    if ((str.startsWith("[")) && (str.endsWith("]")))
      return a(new org.json.alipay.a(str), paramType);
    if ((str.startsWith("{")) && (str.endsWith("}")))
      return a(new org.json.alipay.b(str), paramType);
    return a(str, paramType);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.e
 * JD-Core Version:    0.6.0
 */