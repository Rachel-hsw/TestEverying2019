package com.alipay.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;

public final class k
  implements i
{
  public final Object a(Object paramObject, Type paramType)
  {
    int i = 0;
    if (!paramObject.getClass().equals(a.class))
      return null;
    a locala = (a)paramObject;
    HashSet localHashSet = new HashSet();
    Object localObject;
    if ((paramType instanceof ParameterizedType))
      localObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];
    while (i < locala.a())
    {
      localHashSet.add(e.a(locala.a(i), (Type)localObject));
      i++;
      continue;
      localObject = Object.class;
      i = 0;
    }
    return localHashSet;
  }

  public final boolean a(Class<?> paramClass)
  {
    return Set.class.isAssignableFrom(paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.k
 * JD-Core Version:    0.6.0
 */