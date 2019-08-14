package org.a.a.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import org.a.a.a.d.a;
import org.a.a.a.f.f;

public class p
{
  public static final a a = new a();

  public static <T extends Comparable<? super T>> int a(T paramT1, T paramT2)
  {
    return a(paramT1, paramT2, false);
  }

  public static <T extends Comparable<? super T>> int a(T paramT1, T paramT2, boolean paramBoolean)
  {
    int i = 1;
    int j = -1;
    if (paramT1 == paramT2)
      i = 0;
    while (true)
    {
      return i;
      if (paramT1 != null)
        break;
      if (!paramBoolean)
        return j;
    }
    if (paramT2 == null)
    {
      if (paramBoolean);
      while (true)
      {
        return j;
        j = i;
      }
    }
    return paramT1.compareTo(paramT2);
  }

  public static int a(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }

  public static <T extends Comparable<? super T>> T a(T[] paramArrayOfT)
  {
    Object localObject1 = null;
    int j;
    Object localObject2;
    if (paramArrayOfT != null)
    {
      int i = paramArrayOfT.length;
      j = 0;
      if (j < i)
      {
        localObject2 = paramArrayOfT[j];
        if (a((Comparable)localObject2, (Comparable)localObject1, true) >= 0)
          break label42;
      }
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      return localObject1;
      label42: localObject2 = localObject1;
    }
  }

  public static <T> T a(T paramT1, T paramT2)
  {
    if (paramT1 != null)
      return paramT1;
    return paramT2;
  }

  public static <T> T a(Comparator<T> paramComparator, T[] paramArrayOfT)
  {
    x.a(paramArrayOfT, "null/empty items", new Object[0]);
    x.b(paramArrayOfT);
    x.a(paramComparator, "null comparator", new Object[0]);
    TreeSet localTreeSet = new TreeSet(paramComparator);
    Collections.addAll(localTreeSet, paramArrayOfT);
    return localTreeSet.toArray()[((-1 + localTreeSet.size()) / 2)];
  }

  public static <T> T a(T[] paramArrayOfT)
  {
    if (paramArrayOfT != null)
    {
      int i = paramArrayOfT.length;
      for (int j = 0; j < i; j++)
      {
        T ? = paramArrayOfT[j];
        if (? != null)
          return ?;
      }
    }
    return null;
  }

  public static String a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return paramObject.toString();
  }

  public static void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("Cannot get the toString of a null identity");
    paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
  }

  public static int b(Object[] paramArrayOfObject)
  {
    int i = 1;
    if (paramArrayOfObject != null)
    {
      int j = paramArrayOfObject.length;
      int k = 0;
      while (k < j)
      {
        Object localObject = paramArrayOfObject[k];
        int m = i * 31 + a(localObject);
        k++;
        i = m;
      }
    }
    return i;
  }

  public static <T extends Comparable<? super T>> T b(T[] paramArrayOfT)
  {
    Object localObject1 = null;
    int j;
    Object localObject2;
    if (paramArrayOfT != null)
    {
      int i = paramArrayOfT.length;
      j = 0;
      if (j < i)
      {
        localObject2 = paramArrayOfT[j];
        if (a((Comparable)localObject2, (Comparable)localObject1, false) <= 0)
          break label42;
      }
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      return localObject1;
      label42: localObject2 = localObject1;
    }
  }

  public static String b(Object paramObject)
  {
    if (paramObject == null)
      return null;
    StringBuffer localStringBuffer = new StringBuffer();
    a(localStringBuffer, paramObject);
    return localStringBuffer.toString();
  }

  public static boolean b(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    return paramObject1.equals(paramObject2);
  }

  public static <T extends Comparable<? super T>> T c(T[] paramArrayOfT)
  {
    x.a(paramArrayOfT);
    x.b(paramArrayOfT);
    TreeSet localTreeSet = new TreeSet();
    Collections.addAll(localTreeSet, paramArrayOfT);
    return (Comparable)localTreeSet.toArray()[((-1 + localTreeSet.size()) / 2)];
  }

  public static <T> T c(T[] paramArrayOfT)
  {
    int i = 0;
    Object localObject1;
    Map.Entry localEntry;
    int m;
    int n;
    Object localObject2;
    if (c.g(paramArrayOfT))
    {
      HashMap localHashMap = new HashMap(paramArrayOfT.length);
      int j = paramArrayOfT.length;
      int k = 0;
      if (k < j)
      {
        T ? = paramArrayOfT[k];
        f localf = (f)localHashMap.get(?);
        if (localf == null)
          localHashMap.put(?, new f(1));
        while (true)
        {
          k++;
          break;
          localf.c();
        }
      }
      Iterator localIterator = localHashMap.entrySet().iterator();
      localObject1 = null;
      if (!localIterator.hasNext())
        break label180;
      localEntry = (Map.Entry)localIterator.next();
      m = ((f)localEntry.getValue()).intValue();
      if (m == i)
      {
        n = i;
        localObject2 = null;
      }
    }
    while (true)
    {
      i = n;
      localObject1 = localObject2;
      break;
      if (m > i)
      {
        localObject2 = localEntry.getKey();
        n = m;
        continue;
        localObject1 = null;
        label180: return localObject1;
      }
      n = i;
      localObject2 = localObject1;
    }
  }

  public static String c(Object paramObject)
  {
    if (paramObject == null)
      return "";
    return paramObject.toString();
  }

  public static boolean c(Object paramObject1, Object paramObject2)
  {
    return !b(paramObject1, paramObject2);
  }

  public static <T> T d(T paramT)
  {
    if ((paramT instanceof Cloneable))
    {
      if (paramT.getClass().isArray())
      {
        Class localClass = paramT.getClass().getComponentType();
        if (!localClass.isPrimitive())
        {
          localObject2 = ((Object[])(Object[])paramT).clone();
          return localObject2;
        }
        int i = Array.getLength(paramT);
        Object localObject2 = Array.newInstance(localClass, i);
        while (true)
        {
          int j = i - 1;
          if (i <= 0)
            break;
          Array.set(localObject2, j, Array.get(paramT, j));
          i = j;
        }
      }
      try
      {
        Object localObject1 = paramT.getClass().getMethod("clone", new Class[0]).invoke(paramT, new Object[0]);
        return localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new a("Cloneable type " + paramT.getClass().getName() + " has no clone method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new a("Cannot clone Cloneable type " + paramT.getClass().getName(), localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new a("Exception cloning Cloneable type " + paramT.getClass().getName(), localInvocationTargetException.getCause());
      }
    }
    return null;
  }

  public static <T> T e(T paramT)
  {
    Object localObject = d(paramT);
    if (localObject == null)
      return paramT;
    return localObject;
  }

  public static class a
    implements Serializable
  {
    private static final long a = 7092611880189329093L;

    private Object a()
    {
      return p.a;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.p
 * JD-Core Version:    0.6.0
 */