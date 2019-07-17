package org.a.a.a.g;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.reflect.TypeVariable<*>;Ljava.lang.reflect.Type;>;
import java.util.Set;
import org.a.a.a.l;

public class e
{
  private static Type a(Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject1;
    int j;
    Object localObject2;
    Class localClass;
    if (paramClass2.isInterface())
    {
      Type[] arrayOfType = paramClass1.getGenericInterfaces();
      localObject1 = null;
      int i = arrayOfType.length;
      j = 0;
      if (j < i)
      {
        localObject2 = arrayOfType[j];
        if ((localObject2 instanceof ParameterizedType))
        {
          localClass = b((ParameterizedType)localObject2);
          label52: if ((!b(localClass, paramClass2)) || (!a((Type)localObject1, localClass)))
            break label136;
        }
      }
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      if ((localObject2 instanceof Class))
      {
        localClass = (Class)localObject2;
        break label52;
      }
      throw new IllegalStateException("Unexpected generic interface type found: " + localObject2);
      if (localObject1 != null)
        return localObject1;
      return paramClass1.getGenericSuperclass();
      label136: localObject2 = localObject1;
    }
  }

  private static Type a(Type paramType, Map<TypeVariable<?>, Type> paramMap)
  {
    Type localType;
    if (((paramType instanceof TypeVariable)) && (paramMap != null))
    {
      localType = (Type)paramMap.get(paramType);
      if (localType == null)
        throw new IllegalArgumentException("missing assignment type for type variable " + paramType);
    }
    else
    {
      localType = paramType;
    }
    return localType;
  }

  private static Map<TypeVariable<?>, Type> a(Class<?> paramClass1, Class<?> paramClass2, Map<TypeVariable<?>, Type> paramMap)
  {
    HashMap localHashMap;
    if (!b(paramClass1, paramClass2))
      localHashMap = null;
    while (true)
    {
      return localHashMap;
      if (paramClass1.isPrimitive())
      {
        if (paramClass2.isPrimitive())
          return new HashMap();
        paramClass1 = l.h(paramClass1);
      }
      if (paramMap == null);
      for (localHashMap = new HashMap(); (paramClass1.getTypeParameters().length <= 0) && (!paramClass2.equals(paramClass1)); localHashMap = new HashMap(paramMap))
        return a(a(paramClass1, paramClass2), paramClass2, localHashMap);
    }
  }

  public static Map<TypeVariable<?>, Type> a(Class<?> paramClass, ParameterizedType paramParameterizedType)
  {
    Class localClass = b(paramParameterizedType);
    if (!b(paramClass, localClass))
      return null;
    if (paramClass.equals(localClass))
      return a(paramParameterizedType, localClass, null);
    Type localType = a(paramClass, localClass);
    if ((localType instanceof Class))
      return a((Class)localType, paramParameterizedType);
    ParameterizedType localParameterizedType = (ParameterizedType)localType;
    Map localMap = a(b(localParameterizedType), paramParameterizedType);
    a(paramClass, localParameterizedType, localMap);
    return localMap;
  }

  public static Map<TypeVariable<?>, Type> a(ParameterizedType paramParameterizedType)
  {
    return a(paramParameterizedType, b(paramParameterizedType), null);
  }

  private static Map<TypeVariable<?>, Type> a(ParameterizedType paramParameterizedType, Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap)
  {
    Class localClass = b(paramParameterizedType);
    Object localObject;
    if (!b(localClass, paramClass))
      localObject = null;
    do
    {
      return localObject;
      Type localType1 = paramParameterizedType.getOwnerType();
      if ((localType1 instanceof ParameterizedType))
      {
        ParameterizedType localParameterizedType = (ParameterizedType)localType1;
        localObject = a(localParameterizedType, b(localParameterizedType), paramMap);
        Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
        TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
        for (int i = 0; i < arrayOfTypeVariable.length; i++)
        {
          Type localType2 = arrayOfType[i];
          TypeVariable localTypeVariable = arrayOfTypeVariable[i];
          if (((Map)localObject).containsKey(localType2))
            localType2 = (Type)((Map)localObject).get(localType2);
          ((Map)localObject).put(localTypeVariable, localType2);
        }
      }
      if (paramMap == null);
      for (HashMap localHashMap = new HashMap(); ; localHashMap = new HashMap(paramMap))
      {
        localObject = localHashMap;
        break;
      }
    }
    while (paramClass.equals(localClass));
    return (Map<TypeVariable<?>, Type>)a(a(localClass, paramClass), paramClass, (Map)localObject);
  }

  public static Map<TypeVariable<?>, Type> a(Type paramType, Class<?> paramClass)
  {
    return a(paramType, paramClass, null);
  }

  private static Map<TypeVariable<?>, Type> a(Type paramType, Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap)
  {
    int i = 0;
    Map localMap;
    if ((paramType instanceof Class))
    {
      localMap = a((Class)paramType, paramClass, paramMap);
      return localMap;
    }
    if ((paramType instanceof ParameterizedType))
      return a((ParameterizedType)paramType, paramClass, paramMap);
    if ((paramType instanceof GenericArrayType))
    {
      Type localType3 = ((GenericArrayType)paramType).getGenericComponentType();
      if (paramClass.isArray())
        paramClass = paramClass.getComponentType();
      return a(localType3, paramClass, paramMap);
    }
    if ((paramType instanceof WildcardType))
    {
      Type[] arrayOfType2 = a((WildcardType)paramType);
      int k = arrayOfType2.length;
      while (true)
      {
        localMap = null;
        if (i >= k)
          break;
        Type localType2 = arrayOfType2[i];
        if (b(localType2, paramClass))
          return a(localType2, paramClass, paramMap);
        i++;
      }
    }
    if ((paramType instanceof TypeVariable))
    {
      Type[] arrayOfType1 = a((TypeVariable)paramType);
      int j = arrayOfType1.length;
      while (true)
      {
        localMap = null;
        if (i >= j)
          break;
        Type localType1 = arrayOfType1[i];
        if (b(localType1, paramClass))
          return a(localType1, paramClass, paramMap);
        i++;
      }
    }
    throw new IllegalStateException("found an unhandled type: " + paramType);
  }

  private static <T> void a(Class<T> paramClass, ParameterizedType paramParameterizedType, Map<TypeVariable<?>, Type> paramMap)
  {
    Type localType1 = paramParameterizedType.getOwnerType();
    if ((localType1 instanceof ParameterizedType))
      a(paramClass, (ParameterizedType)localType1, paramMap);
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    TypeVariable[] arrayOfTypeVariable = b(paramParameterizedType).getTypeParameters();
    List localList = Arrays.asList(paramClass.getTypeParameters());
    for (int i = 0; i < arrayOfType.length; i++)
    {
      TypeVariable localTypeVariable = arrayOfTypeVariable[i];
      Type localType2 = arrayOfType[i];
      if ((!localList.contains(localType2)) || (!paramMap.containsKey(localTypeVariable)))
        continue;
      paramMap.put((TypeVariable)localType2, paramMap.get(localTypeVariable));
    }
  }

  public static boolean a(Object paramObject, Type paramType)
  {
    if (paramType == null);
    while (true)
    {
      return false;
      if (paramObject != null)
        break;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive()))
        return true;
    }
    return a(paramObject.getClass(), paramType, null);
  }

  public static boolean a(Type paramType)
  {
    return ((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray()));
  }

  private static boolean a(Type paramType, GenericArrayType paramGenericArrayType, Map<TypeVariable<?>, Type> paramMap)
  {
    if (paramType == null);
    Type localType;
    while (true)
    {
      return true;
      if (paramGenericArrayType == null)
        return false;
      if (paramGenericArrayType.equals(paramType))
        continue;
      localType = paramGenericArrayType.getGenericComponentType();
      if (!(paramType instanceof Class))
        break;
      Class localClass = (Class)paramType;
      if ((!localClass.isArray()) || (!a(localClass.getComponentType(), localType, paramMap)))
        return false;
    }
    if ((paramType instanceof GenericArrayType))
      return a(((GenericArrayType)paramType).getGenericComponentType(), localType, paramMap);
    if ((paramType instanceof WildcardType))
    {
      Type[] arrayOfType2 = a((WildcardType)paramType);
      int k = arrayOfType2.length;
      for (int m = 0; ; m++)
      {
        if (m >= k)
          break label134;
        if (a(arrayOfType2[m], paramGenericArrayType))
          break;
      }
      label134: return false;
    }
    if ((paramType instanceof TypeVariable))
    {
      Type[] arrayOfType1 = a((TypeVariable)paramType);
      int i = arrayOfType1.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label185;
        if (a(arrayOfType1[j], paramGenericArrayType))
          break;
      }
      label185: return false;
    }
    if ((paramType instanceof ParameterizedType))
      return false;
    throw new IllegalStateException("found an unhandled type: " + paramType);
  }

  private static boolean a(Type paramType, ParameterizedType paramParameterizedType, Map<TypeVariable<?>, Type> paramMap)
  {
    if (paramType == null)
      return true;
    if (paramParameterizedType == null)
      return false;
    if (paramParameterizedType.equals(paramType))
      return true;
    Class localClass = b(paramParameterizedType);
    Map localMap = a(paramType, localClass, null);
    if (localMap == null)
      return false;
    if (localMap.isEmpty())
      return true;
    Iterator localIterator = a(paramParameterizedType, localClass, paramMap).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Type localType1 = (Type)localEntry.getValue();
      Type localType2 = (Type)localMap.get(localEntry.getKey());
      if ((localType2 != null) && (!localType1.equals(localType2)) && ((!(localType1 instanceof WildcardType)) || (!a(localType2, localType1, paramMap))))
        return false;
    }
    return true;
  }

  public static boolean a(Type paramType1, Type paramType2)
  {
    return a(paramType1, paramType2, null);
  }

  private static boolean a(Type paramType1, Type paramType2, Map<TypeVariable<?>, Type> paramMap)
  {
    if ((paramType2 == null) || ((paramType2 instanceof Class)))
      return b(paramType1, (Class)paramType2);
    if ((paramType2 instanceof ParameterizedType))
      return a(paramType1, (ParameterizedType)paramType2, paramMap);
    if ((paramType2 instanceof GenericArrayType))
      return a(paramType1, (GenericArrayType)paramType2, paramMap);
    if ((paramType2 instanceof WildcardType))
      return a(paramType1, (WildcardType)paramType2, paramMap);
    if ((paramType2 instanceof TypeVariable))
      return a(paramType1, (TypeVariable)paramType2, paramMap);
    throw new IllegalStateException("found an unhandled type: " + paramType2);
  }

  private static boolean a(Type paramType, TypeVariable<?> paramTypeVariable, Map<TypeVariable<?>, Type> paramMap)
  {
    if (paramType == null)
      return true;
    if (paramTypeVariable == null)
      return false;
    if (paramTypeVariable.equals(paramType))
      return true;
    if ((paramType instanceof TypeVariable))
    {
      Type[] arrayOfType = a((TypeVariable)paramType);
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
        if (a(arrayOfType[j], paramTypeVariable, paramMap))
          return true;
    }
    if (((paramType instanceof Class)) || ((paramType instanceof ParameterizedType)) || ((paramType instanceof GenericArrayType)) || ((paramType instanceof WildcardType)))
      return false;
    throw new IllegalStateException("found an unhandled type: " + paramType);
  }

  private static boolean a(Type paramType, WildcardType paramWildcardType, Map<TypeVariable<?>, Type> paramMap)
  {
    if (paramType == null);
    while (true)
    {
      return true;
      if (paramWildcardType == null)
        return false;
      if (paramWildcardType.equals(paramType))
        continue;
      Type[] arrayOfType1 = a(paramWildcardType);
      Type[] arrayOfType2 = b(paramWildcardType);
      if ((paramType instanceof WildcardType))
      {
        WildcardType localWildcardType = (WildcardType)paramType;
        Type[] arrayOfType3 = a(localWildcardType);
        Type[] arrayOfType4 = b(localWildcardType);
        int n = arrayOfType1.length;
        for (int i1 = 0; i1 < n; i1++)
        {
          Type localType2 = a(arrayOfType1[i1], paramMap);
          int i6 = arrayOfType3.length;
          for (int i7 = 0; i7 < i6; i7++)
            if (!a(arrayOfType3[i7], localType2, paramMap))
              return false;
        }
        int i2 = arrayOfType2.length;
        for (int i3 = 0; i3 < i2; i3++)
        {
          Type localType1 = a(arrayOfType2[i3], paramMap);
          int i4 = arrayOfType4.length;
          for (int i5 = 0; i5 < i4; i5++)
            if (!a(localType1, arrayOfType4[i5], paramMap))
              return false;
        }
        continue;
      }
      int i = arrayOfType1.length;
      for (int j = 0; j < i; j++)
        if (!a(paramType, a(arrayOfType1[j], paramMap), paramMap))
          return false;
      int k = arrayOfType2.length;
      for (int m = 0; m < k; m++)
        if (!a(a(arrayOfType2[m], paramMap), paramType, paramMap))
          return false;
    }
  }

  public static boolean a(Map<TypeVariable<?>, Type> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      TypeVariable localTypeVariable = (TypeVariable)localEntry.getKey();
      Type localType = (Type)localEntry.getValue();
      Type[] arrayOfType = a(localTypeVariable);
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
        if (!a(localType, a(arrayOfType[j], paramMap), paramMap))
          return false;
    }
    return true;
  }

  public static Type[] a(TypeVariable<?> paramTypeVariable)
  {
    Type[] arrayOfType = paramTypeVariable.getBounds();
    if (arrayOfType.length == 0)
      return new Type[] { Object.class };
    return a(arrayOfType);
  }

  public static Type[] a(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getUpperBounds();
    if (arrayOfType.length == 0)
      return new Type[] { Object.class };
    return a(arrayOfType);
  }

  public static Type[] a(Type[] paramArrayOfType)
  {
    if (paramArrayOfType.length < 2)
      return paramArrayOfType;
    HashSet localHashSet = new HashSet(paramArrayOfType.length);
    int i = paramArrayOfType.length;
    int j = 0;
    Type localType1;
    int m;
    if (j < i)
    {
      localType1 = paramArrayOfType[j];
      int k = paramArrayOfType.length;
      m = 0;
      label40: if (m >= k)
        break label119;
      Type localType2 = paramArrayOfType[m];
      if ((localType1 == localType2) || (!a(localType2, localType1, null)));
    }
    label119: for (int n = 1; ; n = 0)
    {
      if (n == 0)
        localHashSet.add(localType1);
      j++;
      break;
      m++;
      break label40;
      return (Type[])localHashSet.toArray(new Type[localHashSet.size()]);
    }
  }

  private static Class<?> b(ParameterizedType paramParameterizedType)
  {
    Type localType = paramParameterizedType.getRawType();
    if (!(localType instanceof Class))
      throw new IllegalStateException("Wait... What!? Type of rawType: " + localType);
    return (Class)localType;
  }

  public static Class<?> b(Type paramType1, Type paramType2)
  {
    if ((paramType1 instanceof Class))
      return (Class)paramType1;
    if ((paramType1 instanceof ParameterizedType))
      return b((ParameterizedType)paramType1);
    if ((paramType1 instanceof TypeVariable))
    {
      if (paramType2 == null)
        return null;
      GenericDeclaration localGenericDeclaration = ((TypeVariable)paramType1).getGenericDeclaration();
      if (!(localGenericDeclaration instanceof Class))
        return null;
      Map localMap = a(paramType2, (Class)localGenericDeclaration);
      if (localMap == null)
        return null;
      Type localType = (Type)localMap.get(paramType1);
      if (localType == null)
        return null;
      return b(localType, paramType2);
    }
    if ((paramType1 instanceof GenericArrayType))
      return Array.newInstance(b(((GenericArrayType)paramType1).getGenericComponentType(), paramType2), 0).getClass();
    if ((paramType1 instanceof WildcardType))
      return null;
    throw new IllegalArgumentException("unknown type: " + paramType1);
  }

  public static Type b(Type paramType)
  {
    Class localClass1;
    if ((paramType instanceof Class))
    {
      Class localClass2 = (Class)paramType;
      boolean bool2 = localClass2.isArray();
      localClass1 = null;
      if (bool2)
        localClass1 = localClass2.getComponentType();
    }
    boolean bool1;
    do
    {
      return localClass1;
      bool1 = paramType instanceof GenericArrayType;
      localClass1 = null;
    }
    while (!bool1);
    return ((GenericArrayType)paramType).getGenericComponentType();
  }

  private static boolean b(Type paramType, Class<?> paramClass)
  {
    int i;
    if (paramType == null)
      if (paramClass != null)
      {
        boolean bool4 = paramClass.isPrimitive();
        i = 0;
        if (bool4);
      }
      else
      {
        i = 1;
      }
    boolean bool1;
    do
    {
      while (true)
      {
        return i;
        i = 0;
        if (paramClass == null)
          continue;
        if (paramClass.equals(paramType))
          return true;
        if ((paramType instanceof Class))
          return l.a((Class)paramType, paramClass);
        if ((paramType instanceof ParameterizedType))
          return b(b((ParameterizedType)paramType), paramClass);
        if ((paramType instanceof TypeVariable))
        {
          Type[] arrayOfType = ((TypeVariable)paramType).getBounds();
          int j = arrayOfType.length;
          for (int k = 0; ; k++)
          {
            i = 0;
            if (k >= j)
              break;
            if (b(arrayOfType[k], paramClass))
              return true;
          }
        }
        if (!(paramType instanceof GenericArrayType))
          break;
        if (!paramClass.equals(Object.class))
        {
          boolean bool2 = paramClass.isArray();
          i = 0;
          if (!bool2)
            continue;
          boolean bool3 = b(((GenericArrayType)paramType).getGenericComponentType(), paramClass.getComponentType());
          i = 0;
          if (!bool3)
            continue;
        }
        return true;
      }
      bool1 = paramType instanceof WildcardType;
      i = 0;
    }
    while (bool1);
    throw new IllegalStateException("found an unhandled type: " + paramType);
  }

  public static Type[] b(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    if (arrayOfType.length == 0)
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = null;
    }
    return arrayOfType;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g.e
 * JD-Core Version:    0.6.0
 */