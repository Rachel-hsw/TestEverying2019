package org.a.a.a.g;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.l;

public class b
{
  public static Object a(Object paramObject, String paramString)
    throws IllegalAccessException
  {
    return a(paramObject, paramString, false);
  }

  public static Object a(Object paramObject, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramObject == null)
      throw new IllegalArgumentException("target object must not be null");
    Class localClass = paramObject.getClass();
    Field localField = a(localClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + localClass);
    return a(localField, paramObject);
  }

  public static Object a(Field paramField)
    throws IllegalAccessException
  {
    return a(paramField, false);
  }

  public static Object a(Field paramField, Object paramObject)
    throws IllegalAccessException
  {
    return a(paramField, paramObject, false);
  }

  public static Object a(Field paramField, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField == null)
      throw new IllegalArgumentException("The field must not be null");
    if ((paramBoolean) && (!paramField.isAccessible()))
      paramField.setAccessible(true);
    while (true)
    {
      return paramField.get(paramObject);
      c.a(paramField);
    }
  }

  public static Object a(Field paramField, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField == null)
      throw new IllegalArgumentException("The field must not be null");
    if (!Modifier.isStatic(paramField.getModifiers()))
      throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
    return a(paramField, (Object)null, paramBoolean);
  }

  public static Field a(Class<?> paramClass, String paramString)
  {
    Field localField = a(paramClass, paramString, false);
    c.a(localField);
    return localField;
  }

  public static Field a(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("The class must not be null");
    if (paramString == null)
      throw new IllegalArgumentException("The field name must not be null");
    Object localObject1 = paramClass;
    if (localObject1 != null);
    while (true)
    {
      try
      {
        localObject2 = ((Class)localObject1).getDeclaredField(paramString);
        if (Modifier.isPublic(((Field)localObject2).getModifiers()))
          continue;
        if (!paramBoolean)
          continue;
        ((Field)localObject2).setAccessible(true);
        return localObject2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localObject1 = ((Class)localObject1).getSuperclass();
      }
      break;
      Object localObject2 = null;
      Iterator localIterator = l.e(paramClass).iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          localObject3 = localClass.getField(paramString);
          if (localObject2 != null)
            throw new IllegalArgumentException("Reference to field " + paramString + " is ambiguous relative to " + paramClass + "; a matching field exists on two or more implemented interfaces.");
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          Object localObject3 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
  }

  public static void a(Class<?> paramClass, String paramString, Object paramObject)
    throws IllegalAccessException
  {
    a(paramClass, paramString, paramObject, false);
  }

  public static void a(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = a(paramClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
    b(localField, paramObject);
  }

  public static void a(Object paramObject1, String paramString, Object paramObject2)
    throws IllegalAccessException
  {
    a(paramObject1, paramString, paramObject2, false);
  }

  public static void a(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramObject1 == null)
      throw new IllegalArgumentException("target object must not be null");
    Class localClass = paramObject1.getClass();
    Field localField = a(localClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
    a(localField, paramObject1, paramObject2);
  }

  public static void a(Field paramField, Object paramObject1, Object paramObject2)
    throws IllegalAccessException
  {
    a(paramField, paramObject1, paramObject2, false);
  }

  public static void a(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField == null)
      throw new IllegalArgumentException("The field must not be null");
    if ((paramBoolean) && (!paramField.isAccessible()))
      paramField.setAccessible(true);
    while (true)
    {
      paramField.set(paramObject1, paramObject2);
      return;
      c.a(paramField);
    }
  }

  public static Object b(Object paramObject, String paramString)
    throws IllegalAccessException
  {
    return b(paramObject, paramString, false);
  }

  public static Object b(Object paramObject, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramObject == null)
      throw new IllegalArgumentException("target object must not be null");
    Class localClass = paramObject.getClass();
    Field localField = b(localClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
    return a(localField, paramObject);
  }

  public static Field b(Class<?> paramClass, String paramString)
  {
    return b(paramClass, paramString, false);
  }

  public static Field b(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("The class must not be null");
    if (paramString == null)
      throw new IllegalArgumentException("The field name must not be null");
    try
    {
      Field localField1 = paramClass.getDeclaredField(paramString);
      Field localField2;
      if (!c.a(localField1))
      {
        localField2 = null;
        if (paramBoolean)
          localField1.setAccessible(true);
      }
      else
      {
        localField2 = localField1;
      }
      return localField2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    return null;
  }

  public static void b(Class<?> paramClass, String paramString, Object paramObject)
    throws IllegalAccessException
  {
    b(paramClass, paramString, paramObject, false);
  }

  public static void b(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = b(paramClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
    a(localField, (Object)null, paramObject);
  }

  public static void b(Object paramObject1, String paramString, Object paramObject2)
    throws IllegalAccessException
  {
    b(paramObject1, paramString, paramObject2, false);
  }

  public static void b(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramObject1 == null)
      throw new IllegalArgumentException("target object must not be null");
    Class localClass = paramObject1.getClass();
    Field localField = b(localClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
    a(localField, paramObject1, paramObject2);
  }

  public static void b(Field paramField, Object paramObject)
    throws IllegalAccessException
  {
    b(paramField, paramObject, false);
  }

  public static void b(Field paramField, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField == null)
      throw new IllegalArgumentException("The field must not be null");
    if (!Modifier.isStatic(paramField.getModifiers()))
      throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
    a(paramField, (Object)null, paramObject, paramBoolean);
  }

  public static Object c(Class<?> paramClass, String paramString)
    throws IllegalAccessException
  {
    return c(paramClass, paramString, false);
  }

  public static Object c(Class<?> paramClass, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = a(paramClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
    return a(localField, false);
  }

  public static Object d(Class<?> paramClass, String paramString)
    throws IllegalAccessException
  {
    return d(paramClass, paramString, false);
  }

  public static Object d(Class<?> paramClass, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = b(paramClass, paramString, paramBoolean);
    if (localField == null)
      throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
    return a(localField, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g.b
 * JD-Core Version:    0.6.0
 */