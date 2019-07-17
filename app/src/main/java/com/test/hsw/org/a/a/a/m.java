package org.a.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class m
{
  public static <E extends Enum<E>> long a(Class<E> paramClass, Iterable<E> paramIterable)
  {
    c(paramClass);
    x.a(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    long l = 0L;
    while (localIterator.hasNext())
      l |= 1 << ((Enum)localIterator.next()).ordinal();
    return l;
  }

  public static <E extends Enum<E>> long a(Class<E> paramClass, E[] paramArrayOfE)
  {
    x.b(paramArrayOfE);
    return a(paramClass, Arrays.asList(paramArrayOfE));
  }

  public static <E extends Enum<E>> EnumSet<E> a(Class<E> paramClass, long paramLong)
  {
    Enum[] arrayOfEnum = (Enum[])c(paramClass).getEnumConstants();
    EnumSet localEnumSet = EnumSet.noneOf(paramClass);
    int i = arrayOfEnum.length;
    for (int j = 0; j < i; j++)
    {
      Enum localEnum = arrayOfEnum[j];
      if ((paramLong & 1 << localEnum.ordinal()) == 0L)
        continue;
      localEnumSet.add(localEnum);
    }
    return localEnumSet;
  }

  public static <E extends Enum<E>> Map<String, E> a(Class<E> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    for (Enum localEnum : (Enum[])paramClass.getEnumConstants())
      localLinkedHashMap.put(localEnum.name(), localEnum);
    return localLinkedHashMap;
  }

  public static <E extends Enum<E>> boolean a(Class<E> paramClass, String paramString)
  {
    if (paramString == null)
      return false;
    try
    {
      Enum.valueOf(paramClass, paramString);
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return false;
  }

  public static <E extends Enum<E>> E b(Class<E> paramClass, String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      Enum localEnum = Enum.valueOf(paramClass, paramString);
      return localEnum;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return null;
  }

  public static <E extends Enum<E>> List<E> b(Class<E> paramClass)
  {
    return new ArrayList(Arrays.asList(paramClass.getEnumConstants()));
  }

  private static <E extends Enum<E>> Class<E> c(Class<E> paramClass)
  {
    x.a(paramClass, "EnumClass must be defined.", new Object[0]);
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    boolean bool1;
    if (arrayOfEnum != null)
    {
      bool1 = true;
      x.a(bool1, "%s does not seem to be an Enum type", new Object[] { paramClass });
      if (arrayOfEnum.length > 64)
        break label97;
    }
    label97: for (boolean bool2 = true; ; bool2 = false)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(arrayOfEnum.length);
      arrayOfObject[1] = paramClass.getSimpleName();
      arrayOfObject[2] = Integer.valueOf(64);
      x.a(bool2, "Cannot store %s %s values in %s bits", arrayOfObject);
      return paramClass;
      bool1 = false;
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.m
 * JD-Core Version:    0.6.0
 */