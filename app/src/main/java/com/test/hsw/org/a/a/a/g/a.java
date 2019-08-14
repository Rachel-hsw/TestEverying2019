package org.a.a.a.g;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.a.a.a.l;

public class a
{
  public static <T> T a(Class<T> paramClass, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    for (int i = 0; i < paramArrayOfObject.length; i++)
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
    return a(paramClass, paramArrayOfObject, arrayOfClass);
  }

  public static <T> T a(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    Constructor localConstructor = b(paramClass, paramArrayOfClass);
    if (localConstructor == null)
      throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
    return localConstructor.newInstance(paramArrayOfObject);
  }

  public static <T> Constructor<T> a(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Constructor localConstructor = a(paramClass.getConstructor(paramArrayOfClass));
      return localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public static <T> Constructor<T> a(Constructor<T> paramConstructor)
  {
    if ((c.a(paramConstructor)) && (Modifier.isPublic(paramConstructor.getDeclaringClass().getModifiers())))
      return paramConstructor;
    return null;
  }

  public static <T> T b(Class<T> paramClass, Object[] paramArrayOfObject)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    int i = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[i];
    for (int j = 0; j < i; j++)
      arrayOfClass[j] = paramArrayOfObject[j].getClass();
    return b(paramClass, paramArrayOfObject, arrayOfClass);
  }

  public static <T> T b(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = org.a.a.a.c.a;
    if (paramArrayOfClass == null)
      paramArrayOfClass = org.a.a.a.c.b;
    Constructor localConstructor = a(paramClass, paramArrayOfClass);
    if (localConstructor == null)
      throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
    return localConstructor.newInstance(paramArrayOfObject);
  }

  public static <T> Constructor<T> b(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    Object localObject;
    Constructor[] arrayOfConstructor;
    int i;
    int j;
    try
    {
      localObject = paramClass.getConstructor(paramArrayOfClass);
      c.a((AccessibleObject)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      arrayOfConstructor = paramClass.getConstructors();
      i = arrayOfConstructor.length;
      j = 0;
      localObject = null;
    }
    while (j < i)
    {
      Constructor localConstructor1 = arrayOfConstructor[j];
      if (l.a(paramArrayOfClass, localConstructor1.getParameterTypes(), true))
      {
        Constructor localConstructor2 = a(localConstructor1);
        if (localConstructor2 != null)
        {
          c.a(localConstructor2);
          if ((localObject == null) || (c.a(localConstructor2.getParameterTypes(), ((Constructor)localObject).getParameterTypes(), paramArrayOfClass) < 0))
            localObject = localConstructor2;
        }
      }
      j++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g.a
 * JD-Core Version:    0.6.0
 */