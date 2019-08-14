package org.a.a.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class l
{
  public static final char a = '.';
  public static final String b = String.valueOf('.');
  public static final char c = '$';
  public static final String d = String.valueOf('$');
  private static final Map<Class<?>, Class<?>> e = new HashMap();
  private static final Map<Class<?>, Class<?>> f;
  private static final Map<String, String> g;
  private static final Map<String, String> h;

  static
  {
    e.put(Boolean.TYPE, Boolean.class);
    e.put(Byte.TYPE, Byte.class);
    e.put(Character.TYPE, Character.class);
    e.put(Short.TYPE, Short.class);
    e.put(Integer.TYPE, Integer.class);
    e.put(Long.TYPE, Long.class);
    e.put(Double.TYPE, Double.class);
    e.put(Float.TYPE, Float.class);
    e.put(Void.TYPE, Void.TYPE);
    f = new HashMap();
    Iterator localIterator = e.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass1 = (Class)localIterator.next();
      Class localClass2 = (Class)e.get(localClass1);
      if (localClass1.equals(localClass2))
        continue;
      f.put(localClass2, localClass1);
    }
    g = new HashMap();
    h = new HashMap();
    a("int", "I");
    a("boolean", "Z");
    a("float", "F");
    a("long", "J");
    a("short", "S");
    a("byte", "B");
    a("double", "D");
    a("char", "C");
  }

  public static Class<?> a(ClassLoader paramClassLoader, String paramString)
    throws ClassNotFoundException
  {
    return a(paramClassLoader, paramString, true);
  }

  public static Class<?> a(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    try
    {
      if (g.containsKey(paramString))
        return Class.forName("[" + (String)g.get(paramString), paramBoolean, paramClassLoader).getComponentType();
      Class localClass2 = Class.forName(f(paramString), paramBoolean, paramClassLoader);
      return localClass2;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = paramString.lastIndexOf('.');
      if (i != -1)
        try
        {
          Class localClass1 = a(paramClassLoader, paramString.substring(0, i) + '$' + paramString.substring(i + 1), paramBoolean);
          return localClass1;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
        }
    }
    throw localClassNotFoundException1;
  }

  public static Class<?> a(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
    if (localClassLoader == null)
      localClassLoader = l.class.getClassLoader();
    return a(localClassLoader, paramString, paramBoolean);
  }

  public static String a(Class<?> paramClass)
  {
    if (paramClass == null)
      return "";
    return a(paramClass.getName());
  }

  public static String a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return a(paramObject.getClass());
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      return "";
    if (paramString.length() == 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.startsWith("["))
    {
      while (paramString.charAt(0) == '[')
      {
        paramString = paramString.substring(1);
        localStringBuilder.append("[]");
      }
      if ((paramString.charAt(0) == 'L') && (paramString.charAt(-1 + paramString.length()) == ';'))
        paramString = paramString.substring(1, -1 + paramString.length());
    }
    if (h.containsKey(paramString));
    for (String str1 = (String)h.get(paramString); ; str1 = paramString)
    {
      int i = str1.lastIndexOf('.');
      int j = 0;
      if (i == -1);
      while (true)
      {
        int k = str1.indexOf('$', j);
        String str2 = str1.substring(i + 1);
        if (k != -1)
          str2 = str2.replace('$', '.');
        return str2 + localStringBuilder;
        j = i + 1;
      }
    }
  }

  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
    throws SecurityException, NoSuchMethodException
  {
    Method localMethod1 = paramClass.getMethod(paramString, paramArrayOfClass);
    if (Modifier.isPublic(localMethod1.getDeclaringClass().getModifiers()))
      return localMethod1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(e(paramClass));
    localArrayList.addAll(d(paramClass));
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      Class localClass;
      if (localIterator.hasNext())
      {
        localClass = (Class)localIterator.next();
        if (!Modifier.isPublic(localClass.getModifiers()))
          continue;
      }
      try
      {
        Method localMethod2 = localClass.getMethod(paramString, paramArrayOfClass);
        if (Modifier.isPublic(localMethod2.getDeclaringClass().getModifiers()))
        {
          return localMethod2;
          throw new NoSuchMethodException("Can't find a public method for " + paramString + " " + c.a(paramArrayOfClass));
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
      }
    }
  }

  public static List<Class<?>> a(List<String> paramList)
  {
    if (paramList == null)
      return null;
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localArrayList.add(Class.forName(str));
      }
      catch (Exception localException)
      {
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }

  private static void a(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    while (paramClass != null)
    {
      for (Class localClass : paramClass.getInterfaces())
      {
        if (!paramHashSet.add(localClass))
          continue;
        a(localClass, paramHashSet);
      }
      paramClass = paramClass.getSuperclass();
    }
  }

  private static void a(String paramString1, String paramString2)
  {
    g.put(paramString1, paramString2);
    h.put(paramString2, paramString1);
  }

  public static boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return a(paramClass1, paramClass2, w.a(n.f));
  }

  public static boolean a(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean)
  {
    int i = 1;
    if (paramClass2 == null);
    while (true)
    {
      return false;
      if (paramClass1 == null)
      {
        if (!paramClass2.isPrimitive());
        while (true)
        {
          return i;
          i = 0;
        }
      }
      if (paramBoolean)
      {
        if ((paramClass1.isPrimitive()) && (!paramClass2.isPrimitive()))
        {
          paramClass1 = h(paramClass1);
          if (paramClass1 == null)
            continue;
        }
        if ((paramClass2.isPrimitive()) && (!paramClass1.isPrimitive()))
        {
          paramClass1 = i(paramClass1);
          if (paramClass1 == null)
            continue;
        }
      }
      if (paramClass1.equals(paramClass2))
        return i;
      if (!paramClass1.isPrimitive())
        break;
      if (!paramClass2.isPrimitive())
        continue;
      if (Integer.TYPE.equals(paramClass1))
        if ((Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
          return i;
      if (Long.TYPE.equals(paramClass1))
        if ((Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
          return i;
      if ((Boolean.TYPE.equals(paramClass1)) || (Double.TYPE.equals(paramClass1)))
        continue;
      if (Float.TYPE.equals(paramClass1))
        return Double.TYPE.equals(paramClass2);
      if (Character.TYPE.equals(paramClass1))
        if ((Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
          return i;
      if (Short.TYPE.equals(paramClass1))
        if ((Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
          return i;
      if ((Byte.TYPE.equals(paramClass1)) && ((Short.TYPE.equals(paramClass2)) || (Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2))))
        return i;
    }
    return paramClass2.isAssignableFrom(paramClass1);
  }

  public static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    return a(paramArrayOfClass1, paramArrayOfClass2, w.a(n.f));
  }

  public static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, boolean paramBoolean)
  {
    if (!c.a(paramArrayOfClass1, paramArrayOfClass2))
      return false;
    if (paramArrayOfClass1 == null)
      paramArrayOfClass1 = c.b;
    if (paramArrayOfClass2 == null)
      paramArrayOfClass2 = c.b;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfClass1.length)
        break label53;
      if (!a(paramArrayOfClass1[i], paramArrayOfClass2[i], paramBoolean))
        break;
    }
    label53: return true;
  }

  public static Class<?>[] a(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null)
      paramArrayOfClass = null;
    do
      return paramArrayOfClass;
    while (paramArrayOfClass.length == 0);
    Class[] arrayOfClass = new Class[paramArrayOfClass.length];
    for (int i = 0; i < paramArrayOfClass.length; i++)
      arrayOfClass[i] = h(paramArrayOfClass[i]);
    return arrayOfClass;
  }

  public static Class<?>[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      return null;
    if (paramArrayOfObject.length == 0)
      return c.b;
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null);
      for (Class localClass = null; ; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i++;
        break;
      }
    }
    return arrayOfClass;
  }

  public static String b(Class<?> paramClass)
  {
    if (paramClass == null)
      return "";
    return paramClass.getSimpleName();
  }

  public static String b(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return b(paramObject.getClass());
  }

  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    while (paramString.charAt(0) == '[')
      paramString = paramString.substring(1);
    if ((paramString.charAt(0) == 'L') && (paramString.charAt(-1 + paramString.length()) == ';'))
      paramString = paramString.substring(1);
    int i = paramString.lastIndexOf('.');
    if (i == -1)
      return "";
    return paramString.substring(0, i);
  }

  public static List<String> b(List<Class<?>> paramList)
  {
    if (paramList == null)
      return null;
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (localClass == null)
      {
        localArrayList.add(null);
        continue;
      }
      localArrayList.add(localClass.getName());
    }
    return localArrayList;
  }

  public static Class<?>[] b(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null)
      paramArrayOfClass = null;
    do
      return paramArrayOfClass;
    while (paramArrayOfClass.length == 0);
    Class[] arrayOfClass = new Class[paramArrayOfClass.length];
    for (int i = 0; i < paramArrayOfClass.length; i++)
      arrayOfClass[i] = i(paramArrayOfClass[i]);
    return arrayOfClass;
  }

  public static Class<?> c(String paramString)
    throws ClassNotFoundException
  {
    return a(paramString, true);
  }

  public static String c(Class<?> paramClass)
  {
    if (paramClass == null)
      return "";
    return b(paramClass.getName());
  }

  public static String c(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return c(paramObject.getClass());
  }

  public static String d(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return d(paramObject.getClass().getName());
  }

  public static String d(String paramString)
  {
    return a(g(paramString));
  }

  public static List<Class<?>> d(Class<?> paramClass)
  {
    ArrayList localArrayList;
    if (paramClass == null)
      localArrayList = null;
    while (true)
    {
      return localArrayList;
      localArrayList = new ArrayList();
      for (Class localClass = paramClass.getSuperclass(); localClass != null; localClass = localClass.getSuperclass())
        localArrayList.add(localClass);
    }
  }

  public static String e(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return e(paramObject.getClass().getName());
  }

  public static String e(String paramString)
  {
    return b(g(paramString));
  }

  public static List<Class<?>> e(Class<?> paramClass)
  {
    if (paramClass == null)
      return null;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramClass, localLinkedHashSet);
    return new ArrayList(localLinkedHashSet);
  }

  private static String f(String paramString)
  {
    String str1 = v.l(paramString);
    if (str1 == null)
      throw new NullPointerException("className must not be null.");
    StringBuilder localStringBuilder;
    Object localObject;
    if (str1.endsWith("[]"))
    {
      localStringBuilder = new StringBuilder();
      String str3;
      for (localObject = str1; ((String)localObject).endsWith("[]"); localObject = str3)
      {
        str3 = ((String)localObject).substring(0, -2 + ((String)localObject).length());
        localStringBuilder.append("[");
      }
      String str2 = (String)g.get(localObject);
      if (str2 == null)
        break label108;
      localStringBuilder.append(str2);
    }
    while (true)
    {
      str1 = localStringBuilder.toString();
      return str1;
      label108: localStringBuilder.append("L").append((String)localObject).append(";");
    }
  }

  public static boolean f(Class<?> paramClass)
  {
    if (paramClass == null);
    do
      return false;
    while ((!paramClass.isPrimitive()) && (!g(paramClass)));
    return true;
  }

  private static String g(String paramString)
  {
    int i = 0;
    String str1 = v.l(paramString);
    String str2;
    if (str1 == null)
      str2 = null;
    int j;
    do
    {
      return str2;
      j = 0;
      str2 = str1;
      while (str2.startsWith("["))
      {
        int m = j + 1;
        str2 = str2.substring(1);
        j = m;
      }
    }
    while (j < 1);
    int k;
    String str3;
    if (str2.startsWith("L"))
      if (str2.endsWith(";"))
      {
        k = -1 + str2.length();
        str3 = str2.substring(1, k);
      }
    while (true)
    {
      label97: StringBuilder localStringBuilder = new StringBuilder(str3);
      while (true)
        if (i < j)
        {
          localStringBuilder.append("[]");
          i++;
          continue;
          k = str2.length();
          break;
          if (str2.length() <= 0)
            break label174;
          str3 = (String)h.get(str2.substring(0, 1));
          break label97;
        }
      return localStringBuilder.toString();
      label174: str3 = str2;
    }
  }

  public static boolean g(Class<?> paramClass)
  {
    return f.containsKey(paramClass);
  }

  public static Class<?> h(Class<?> paramClass)
  {
    if ((paramClass != null) && (paramClass.isPrimitive()))
      paramClass = (Class)e.get(paramClass);
    return paramClass;
  }

  public static Class<?> i(Class<?> paramClass)
  {
    return (Class)f.get(paramClass);
  }

  public static boolean j(Class<?> paramClass)
  {
    return (paramClass != null) && (paramClass.getEnclosingClass() != null);
  }

  public static String k(Class<?> paramClass)
  {
    if (paramClass == null)
      return "";
    return d(paramClass.getName());
  }

  public static String l(Class<?> paramClass)
  {
    if (paramClass == null)
      return "";
    return e(paramClass.getName());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.l
 * JD-Core Version:    0.6.0
 */