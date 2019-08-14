package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements i, j
{
  public final Object a(Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    ArrayList localArrayList = new ArrayList();
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(f.b(arrayOfObject[j]));
    return localArrayList;
  }

  public final Object a(Object paramObject, Type paramType)
  {
    Object localObject;
    if (!paramObject.getClass().equals(org.json.alipay.a.class))
      localObject = null;
    while (true)
    {
      return localObject;
      org.json.alipay.a locala = (org.json.alipay.a)paramObject;
      if ((paramType instanceof GenericArrayType))
        throw new IllegalArgumentException("Does not support generic array!");
      Class localClass = ((Class)paramType).getComponentType();
      int i = locala.a();
      localObject = Array.newInstance(localClass, i);
      for (int j = 0; j < i; j++)
        Array.set(localObject, j, e.a(locala.a(j), localClass));
    }
  }

  public final boolean a(Class<?> paramClass)
  {
    return paramClass.isArray();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.a
 * JD-Core Version:    0.6.0
 */