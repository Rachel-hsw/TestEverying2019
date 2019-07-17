package org.a.a.a.g;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.a.a.a.l;

public class d
{
  public static Object a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    int i = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[i];
    for (int j = 0; j < i; j++)
      arrayOfClass[j] = paramArrayOfObject[j].getClass();
    return b(paramClass, paramString, paramArrayOfObject, arrayOfClass);
  }

  public static Object a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    Method localMethod = a(paramClass, paramString, paramArrayOfClass);
    if (localMethod == null)
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
    return localMethod.invoke(null, paramArrayOfObject);
  }

  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    int i = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[i];
    for (int j = 0; j < i; j++)
      arrayOfClass[j] = paramArrayOfObject[j].getClass();
    return a(paramObject, paramString, paramArrayOfObject, arrayOfClass);
  }

  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    Method localMethod = b(paramObject.getClass(), paramString, paramArrayOfClass);
    if (localMethod == null)
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
    return localMethod.invoke(paramObject, paramArrayOfObject);
  }

  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = a(paramClass.getMethod(paramString, paramArrayOfClass));
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public static Method a(Method paramMethod)
  {
    if (!c.a(paramMethod))
      paramMethod = null;
    Class localClass;
    do
    {
      return paramMethod;
      localClass = paramMethod.getDeclaringClass();
    }
    while (Modifier.isPublic(localClass.getModifiers()));
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Method localMethod = d(localClass, str, arrayOfClass);
    if (localMethod == null)
      localMethod = c(localClass, str, arrayOfClass);
    return localMethod;
  }

  public static Object b(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    int i = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[i];
    for (int j = 0; j < i; j++)
      arrayOfClass[j] = paramArrayOfObject[j].getClass();
    return a(paramClass, paramString, paramArrayOfObject, arrayOfClass);
  }

  public static Object b(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    Method localMethod = b(paramClass, paramString, paramArrayOfClass);
    if (localMethod == null)
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
    return localMethod.invoke(null, paramArrayOfObject);
  }

  public static Object b(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    int i = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[i];
    for (int j = 0; j < i; j++)
      arrayOfClass[j] = paramArrayOfObject[j].getClass();
    return b(paramObject, paramString, paramArrayOfObject, arrayOfClass);
  }

  public static Object b(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    Method localMethod = a(paramObject.getClass(), paramString, paramArrayOfClass);
    if (localMethod == null)
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
    return localMethod.invoke(paramObject, paramArrayOfObject);
  }

  public static Method b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject;
    try
    {
      localObject = paramClass.getMethod(paramString, paramArrayOfClass);
      c.a((AccessibleObject)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      do
      {
        Method[] arrayOfMethod = paramClass.getMethods();
        int i = arrayOfMethod.length;
        int j = 0;
        localObject = null;
        while (j < i)
        {
          Method localMethod1 = arrayOfMethod[j];
          if ((localMethod1.getName().equals(paramString)) && (l.a(paramArrayOfClass, localMethod1.getParameterTypes(), true)))
          {
            Method localMethod2 = a(localMethod1);
            if ((localMethod2 != null) && ((localObject == null) || (c.a(localMethod2.getParameterTypes(), ((Method)localObject).getParameterTypes(), paramArrayOfClass) < 0)))
              localObject = localMethod2;
          }
          j++;
        }
      }
      while (localObject == null);
      c.a((AccessibleObject)localObject);
    }
    return (Method)localObject;
  }

  private static Method c(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    Class localClass = paramClass.getSuperclass();
    while (true)
    {
      Object localObject = null;
      if ((localClass == null) || (Modifier.isPublic(localClass.getModifiers())));
      try
      {
        Method localMethod = localClass.getMethod(paramString, paramArrayOfClass);
        localObject = localMethod;
        return localObject;
        localClass = localClass.getSuperclass();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
      }
    }
    return null;
  }

  private static Method d(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject1 = null;
    while (true)
    {
      Class[] arrayOfClass;
      Object localObject2;
      int i;
      if (paramClass != null)
      {
        arrayOfClass = paramClass.getInterfaces();
        localObject2 = localObject1;
        label40: for (i = 0; ; i++)
        {
          if (i >= arrayOfClass.length)
            break label67;
          if (Modifier.isPublic(arrayOfClass[i].getModifiers()))
            break;
        }
      }
      try
      {
        Method localMethod = arrayOfClass[i].getDeclaredMethod(paramString, paramArrayOfClass);
        localObject2 = localMethod;
        label62: if (localObject2 != null);
        while (true)
        {
          label67: paramClass = paramClass.getSuperclass();
          localObject1 = localObject2;
          break;
          localObject2 = d(arrayOfClass[i], paramString, paramArrayOfClass);
          if (localObject2 == null)
            break label40;
        }
        return localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label62;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g.d
 * JD-Core Version:    0.6.0
 */