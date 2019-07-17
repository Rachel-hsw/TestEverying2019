package org.a.a.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.a.a.a.a.h;
import org.a.a.a.a.i;

public class a
{
  private static final i a = new b();

  private static int a(Class<?> paramClass, Object paramObject)
  {
    if (paramClass.equals(Byte.TYPE))
      return Arrays.hashCode((byte[])(byte[])paramObject);
    if (paramClass.equals(Short.TYPE))
      return Arrays.hashCode((short[])(short[])paramObject);
    if (paramClass.equals(Integer.TYPE))
      return Arrays.hashCode((int[])(int[])paramObject);
    if (paramClass.equals(Character.TYPE))
      return Arrays.hashCode((char[])(char[])paramObject);
    if (paramClass.equals(Long.TYPE))
      return Arrays.hashCode((long[])(long[])paramObject);
    if (paramClass.equals(Float.TYPE))
      return Arrays.hashCode((float[])(float[])paramObject);
    if (paramClass.equals(Double.TYPE))
      return Arrays.hashCode((double[])(double[])paramObject);
    if (paramClass.equals(Boolean.TYPE))
      return Arrays.hashCode((boolean[])(boolean[])paramObject);
    return Arrays.hashCode((Object[])(Object[])paramObject);
  }

  private static int a(String paramString, Object paramObject)
  {
    int i = 127 * paramString.hashCode();
    if (paramObject.getClass().isArray())
      return i ^ a(paramObject.getClass().getComponentType(), paramObject);
    if ((paramObject instanceof Annotation))
      return i ^ a((Annotation)paramObject);
    return i ^ paramObject.hashCode();
  }

  public static int a(Annotation paramAnnotation)
  {
    int i = 0;
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int k = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      try
      {
        localObject = localMethod.invoke(paramAnnotation, new Object[0]);
        if (localObject == null)
          throw new IllegalStateException(String.format("Annotation method %s returned null", new Object[] { localMethod }));
      }
      catch (RuntimeException localRuntimeException)
      {
        Object localObject;
        throw localRuntimeException;
        int m = a(localMethod.getName(), localObject);
        k += m;
        i++;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    return k;
  }

  public static boolean a(Class<?> paramClass)
  {
    if (paramClass == null);
    do
    {
      return false;
      if (!paramClass.isArray())
        continue;
      paramClass = paramClass.getComponentType();
    }
    while ((!paramClass.isPrimitive()) && (!paramClass.isEnum()) && (!paramClass.isAnnotation()) && (!String.class.equals(paramClass)) && (!Class.class.equals(paramClass)));
    return true;
  }

  private static boolean a(Class<?> paramClass, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    if (paramClass.isArray())
      return b(paramClass.getComponentType(), paramObject1, paramObject2);
    if (paramClass.isAnnotation())
      return a((Annotation)paramObject1, (Annotation)paramObject2);
    return paramObject1.equals(paramObject2);
  }

  public static boolean a(Annotation paramAnnotation1, Annotation paramAnnotation2)
  {
    if (paramAnnotation1 == paramAnnotation2);
    while (true)
    {
      return true;
      if ((paramAnnotation1 == null) || (paramAnnotation2 == null))
        return false;
      Class localClass1 = paramAnnotation1.annotationType();
      Class localClass2 = paramAnnotation2.annotationType();
      x.a(localClass1, "Annotation %s with null annotationType()", new Object[] { paramAnnotation1 });
      x.a(localClass2, "Annotation %s with null annotationType()", new Object[] { paramAnnotation2 });
      if (!localClass1.equals(localClass2))
        return false;
      try
      {
        for (Method localMethod : localClass1.getDeclaredMethods())
        {
          if ((localMethod.getParameterTypes().length != 0) || (!a(localMethod.getReturnType())))
            continue;
          Object localObject1 = localMethod.invoke(paramAnnotation1, new Object[0]);
          Object localObject2 = localMethod.invoke(paramAnnotation2, new Object[0]);
          boolean bool = a(localMethod.getReturnType(), localObject1, localObject2);
          if (!bool)
            return false;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
      }
    }
    return false;
  }

  private static boolean a(Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    if (paramArrayOfAnnotation1.length != paramArrayOfAnnotation2.length)
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfAnnotation1.length)
        break label35;
      if (!a(paramArrayOfAnnotation1[i], paramArrayOfAnnotation2[i]))
        break;
    }
    label35: return true;
  }

  public static String b(Annotation paramAnnotation)
  {
    int i = 0;
    h localh = new h(paramAnnotation, a);
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    int j = arrayOfMethod.length;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getParameterTypes().length > 0);
      while (true)
      {
        i++;
        break;
        try
        {
          localh.a(localMethod.getName(), localMethod.invoke(paramAnnotation, new Object[0]));
        }
        catch (RuntimeException localRuntimeException)
        {
          throw localRuntimeException;
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
      }
    }
    return localh.j();
  }

  private static boolean b(Class<?> paramClass, Object paramObject1, Object paramObject2)
  {
    if (paramClass.isAnnotation())
      return a((Annotation[])(Annotation[])paramObject1, (Annotation[])(Annotation[])paramObject2);
    if (paramClass.equals(Byte.TYPE))
      return Arrays.equals((byte[])(byte[])paramObject1, (byte[])(byte[])paramObject2);
    if (paramClass.equals(Short.TYPE))
      return Arrays.equals((short[])(short[])paramObject1, (short[])(short[])paramObject2);
    if (paramClass.equals(Integer.TYPE))
      return Arrays.equals((int[])(int[])paramObject1, (int[])(int[])paramObject2);
    if (paramClass.equals(Character.TYPE))
      return Arrays.equals((char[])(char[])paramObject1, (char[])(char[])paramObject2);
    if (paramClass.equals(Long.TYPE))
      return Arrays.equals((long[])(long[])paramObject1, (long[])(long[])paramObject2);
    if (paramClass.equals(Float.TYPE))
      return Arrays.equals((float[])(float[])paramObject1, (float[])(float[])paramObject2);
    if (paramClass.equals(Double.TYPE))
      return Arrays.equals((double[])(double[])paramObject1, (double[])(double[])paramObject2);
    if (paramClass.equals(Boolean.TYPE))
      return Arrays.equals((boolean[])(boolean[])paramObject1, (boolean[])(boolean[])paramObject2);
    return Arrays.equals((Object[])(Object[])paramObject1, (Object[])(Object[])paramObject2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a
 * JD-Core Version:    0.6.0
 */