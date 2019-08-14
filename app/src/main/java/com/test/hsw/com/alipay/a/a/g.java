package com.alipay.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;
import org.json.alipay.b;

public final class g
  implements i, j
{
  public final Object a(Object paramObject)
  {
    TreeMap localTreeMap = new TreeMap();
    Class localClass = paramObject.getClass();
    for (Field[] arrayOfField = localClass.getDeclaredFields(); !localClass.equals(Object.class); arrayOfField = localClass.getDeclaredFields())
    {
      if ((arrayOfField != null) && (arrayOfField.length > 0))
      {
        int i = arrayOfField.length;
        int j = 0;
        if (j < i)
        {
          Field localField = arrayOfField[j];
          Object localObject1;
          if ((localField == null) || (paramObject == null))
            localObject1 = null;
          while (true)
          {
            if (localObject1 != null)
              localTreeMap.put(localField.getName(), localObject1);
            j++;
            break;
            if ("this$0".equals(localField.getName()))
            {
              localObject1 = null;
              continue;
            }
            boolean bool = localField.isAccessible();
            localField.setAccessible(true);
            Object localObject2 = localField.get(paramObject);
            if (localObject2 == null)
            {
              localObject1 = null;
              continue;
            }
            localField.setAccessible(bool);
            localObject1 = f.b(localObject2);
          }
        }
      }
      localClass = localClass.getSuperclass();
    }
    return localTreeMap;
  }

  public final Object a(Object paramObject, Type paramType)
  {
    Object localObject;
    if (!paramObject.getClass().equals(b.class))
      localObject = null;
    while (true)
    {
      return localObject;
      b localb = (b)paramObject;
      Class localClass = (Class)paramType;
      localObject = localClass.newInstance();
      while (!localClass.equals(Object.class))
      {
        Field[] arrayOfField = localClass.getDeclaredFields();
        if ((arrayOfField != null) && (arrayOfField.length > 0))
        {
          int i = arrayOfField.length;
          for (int j = 0; j < i; j++)
          {
            Field localField = arrayOfField[j];
            String str = localField.getName();
            Type localType = localField.getGenericType();
            if (!localb.b(str))
              continue;
            localField.setAccessible(true);
            localField.set(localObject, e.a(localb.a(str), localType));
          }
        }
        localClass = localClass.getSuperclass();
      }
    }
  }

  public final boolean a(Class<?> paramClass)
  {
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.g
 * JD-Core Version:    0.6.0
 */