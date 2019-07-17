package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.b;

public final class h
  implements i, j
{
  private static Map<Object, Object> a(Type paramType)
  {
    for (Type localType = paramType; ; localType = ((ParameterizedType)localType).getRawType())
    {
      if (localType == Properties.class)
        return new Properties();
      if (localType == Hashtable.class)
        return new Hashtable();
      if (localType == IdentityHashMap.class)
        return new IdentityHashMap();
      if ((localType == SortedMap.class) || (localType == TreeMap.class))
        return new TreeMap();
      if ((localType == ConcurrentMap.class) || (localType == ConcurrentHashMap.class))
        return new ConcurrentHashMap();
      if ((localType == Map.class) || (localType == HashMap.class))
        return new HashMap();
      if (localType == LinkedHashMap.class)
        return new LinkedHashMap();
      if (!(localType instanceof ParameterizedType))
        break;
    }
    Class localClass = (Class)localType;
    if (localClass.isInterface())
      throw new IllegalArgumentException("unsupport type " + localType);
    try
    {
      Map localMap = (Map)localClass.newInstance();
      return localMap;
    }
    catch (Exception localException)
    {
    }
    throw new IllegalArgumentException("unsupport type " + localType, localException);
  }

  public final Object a(Object paramObject)
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = ((Map)paramObject).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!(localEntry.getKey() instanceof String))
        throw new IllegalArgumentException("Map key must be String!");
      localTreeMap.put((String)localEntry.getKey(), f.b(localEntry.getValue()));
    }
    return localTreeMap;
  }

  public final Object a(Object paramObject, Type paramType)
  {
    if (!paramObject.getClass().equals(b.class))
      return null;
    b localb = (b)paramObject;
    Map localMap = a(paramType);
    if ((paramType instanceof ParameterizedType))
    {
      ParameterizedType localParameterizedType = (ParameterizedType)paramType;
      Type localType1 = localParameterizedType.getActualTypeArguments()[0];
      Type localType2 = localParameterizedType.getActualTypeArguments()[1];
      if (String.class == localType1)
      {
        Iterator localIterator = localb.a();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (a.a((Class)localType2))
          {
            localMap.put(str, localb.a(str));
            continue;
          }
          localMap.put(str, e.a(localb.a(str), localType2));
        }
      }
      throw new IllegalArgumentException("Deserialize Map Key must be String.class");
    }
    throw new IllegalArgumentException("Deserialize Map must be Generics!");
    return localMap;
  }

  public final boolean a(Class<?> paramClass)
  {
    return Map.class.isAssignableFrom(paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.h
 * JD-Core Version:    0.6.0
 */