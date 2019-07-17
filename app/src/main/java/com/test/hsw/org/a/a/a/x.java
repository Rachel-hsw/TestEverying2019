package org.a.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class x
{
  private static final String a = "The value %s is not in the specified exclusive range of %s to %s";
  private static final String b = "The value %s is not in the specified inclusive range of %s to %s";
  private static final String c = "The string %s does not match the pattern %s";
  private static final String d = "The validated object is null";
  private static final String e = "The validated expression is false";
  private static final String f = "The validated array contains null element at index: %d";
  private static final String g = "The validated collection contains null element at index: %d";
  private static final String h = "The validated character sequence is blank";
  private static final String i = "The validated array is empty";
  private static final String j = "The validated character sequence is empty";
  private static final String k = "The validated collection is empty";
  private static final String l = "The validated map is empty";
  private static final String m = "The validated array index is invalid: %d";
  private static final String n = "The validated character sequence index is invalid: %d";
  private static final String o = "The validated collection index is invalid: %d";
  private static final String p = "The validated state is false";
  private static final String q = "Cannot assign a %s to a %s";
  private static final String r = "Expected type: %s, actual: %s";

  public static <T extends CharSequence> T a(T paramT)
  {
    return a(paramT, "The validated character sequence is empty", new Object[0]);
  }

  public static <T extends CharSequence> T a(T paramT, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return a(paramT, paramInt, "The validated character sequence index is invalid: %d", arrayOfObject);
  }

  public static <T extends CharSequence> T a(T paramT, int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    a(paramT);
    if ((paramInt < 0) || (paramInt >= paramT.length()))
      throw new IndexOutOfBoundsException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T extends CharSequence> T a(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    if (paramT.length() == 0)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T extends Iterable<?>> T a(T paramT)
  {
    return a(paramT, "The validated collection contains null element at index: %d", new Object[0]);
  }

  public static <T extends Iterable<?>> T a(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    a(paramT);
    Iterator localIterator = paramT.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1++)
    {
      if (localIterator.next() != null)
        continue;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      throw new IllegalArgumentException(String.format(paramString, c.b(paramArrayOfObject, arrayOfObject)));
    }
    return paramT;
  }

  public static <T> T a(T paramT)
  {
    return a(paramT, "The validated object is null", new Object[0]);
  }

  public static <T> T a(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T extends Collection<?>> T a(T paramT)
  {
    return a(paramT, "The validated collection is empty", new Object[0]);
  }

  public static <T extends Collection<?>> T a(T paramT, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return a(paramT, paramInt, "The validated collection index is invalid: %d", arrayOfObject);
  }

  public static <T extends Collection<?>> T a(T paramT, int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    a(paramT);
    if ((paramInt < 0) || (paramInt >= paramT.size()))
      throw new IndexOutOfBoundsException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T extends Collection<?>> T a(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    if (paramT.isEmpty())
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T extends Map<?, ?>> T a(T paramT)
  {
    return a(paramT, "The validated map is empty", new Object[0]);
  }

  public static <T extends Map<?, ?>> T a(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    if (paramT.isEmpty())
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static void a(CharSequence paramCharSequence, String paramString)
  {
    if (!Pattern.matches(paramString, paramCharSequence))
      throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", new Object[] { paramCharSequence, paramString }));
  }

  public static void a(CharSequence paramCharSequence, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (!Pattern.matches(paramString1, paramCharSequence))
      throw new IllegalArgumentException(String.format(paramString2, paramArrayOfObject));
  }

  public static void a(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass1.isAssignableFrom(paramClass2))
    {
      Object[] arrayOfObject = new Object[2];
      if (paramClass2 == null);
      for (String str = "null"; ; str = paramClass2.getName())
      {
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramClass1.getName();
        throw new IllegalArgumentException(String.format("Cannot assign a %s to a %s", arrayOfObject));
      }
    }
  }

  public static void a(Class<?> paramClass1, Class<?> paramClass2, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramClass1.isAssignableFrom(paramClass2))
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static void a(Class<?> paramClass, Object paramObject)
  {
    if (!paramClass.isInstance(paramObject))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramClass.getName();
      if (paramObject == null);
      for (String str = "null"; ; str = paramObject.getClass().getName())
      {
        arrayOfObject[1] = str;
        throw new IllegalArgumentException(String.format("Expected type: %s, actual: %s", arrayOfObject));
      }
    }
  }

  public static void a(Class<?> paramClass, Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramClass.isInstance(paramObject))
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static <T> void a(T paramT1, T paramT2, Comparable<T> paramComparable)
  {
    if ((paramComparable.compareTo(paramT1) < 0) || (paramComparable.compareTo(paramT2) > 0))
      throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
  }

  public static <T> void a(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object[] paramArrayOfObject)
  {
    if ((paramComparable.compareTo(paramT1) < 0) || (paramComparable.compareTo(paramT2) > 0))
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException("The validated expression is false");
  }

  public static void a(boolean paramBoolean, String paramString, double paramDouble)
  {
    if (!paramBoolean)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(paramDouble);
      throw new IllegalArgumentException(String.format(paramString, arrayOfObject));
    }
  }

  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (!paramBoolean)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      throw new IllegalArgumentException(String.format(paramString, arrayOfObject));
    }
  }

  public static void a(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static <T> T[] a(T[] paramArrayOfT)
  {
    return a(paramArrayOfT, "The validated array is empty", new Object[0]);
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return a(paramArrayOfT, paramInt, "The validated array index is invalid: %d", arrayOfObject);
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    a(paramArrayOfT);
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length))
      throw new IndexOutOfBoundsException(String.format(paramString, paramArrayOfObject));
    return paramArrayOfT;
  }

  public static <T> T[] a(T[] paramArrayOfT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    if (paramArrayOfT.length == 0)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
    return paramArrayOfT;
  }

  public static <T extends CharSequence> T b(T paramT)
  {
    return b(paramT, "The validated character sequence is blank", new Object[0]);
  }

  public static <T extends CharSequence> T b(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.format(paramString, paramArrayOfObject));
    if (v.c(paramT))
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static <T> void b(T paramT1, T paramT2, Comparable<T> paramComparable)
  {
    if ((paramComparable.compareTo(paramT1) <= 0) || (paramComparable.compareTo(paramT2) >= 0))
      throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
  }

  public static <T> void b(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object[] paramArrayOfObject)
  {
    if ((paramComparable.compareTo(paramT1) <= 0) || (paramComparable.compareTo(paramT2) >= 0))
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException("The validated state is false");
  }

  public static void b(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.format(paramString, paramArrayOfObject));
  }

  public static <T> T[] b(T[] paramArrayOfT)
  {
    return b(paramArrayOfT, "The validated array contains null element at index: %d", new Object[0]);
  }

  public static <T> T[] b(T[] paramArrayOfT, String paramString, Object[] paramArrayOfObject)
  {
    a(paramArrayOfT);
    for (int i1 = 0; i1 < paramArrayOfT.length; i1++)
    {
      if (paramArrayOfT[i1] != null)
        continue;
      throw new IllegalArgumentException(String.format(paramString, c.d(paramArrayOfObject, Integer.valueOf(i1))));
    }
    return paramArrayOfT;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.x
 * JD-Core Version:    0.6.0
 */