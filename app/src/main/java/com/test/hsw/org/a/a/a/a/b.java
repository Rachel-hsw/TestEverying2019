package org.a.a.a.a;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.a.a.a.c;

public class b
  implements a<Integer>
{
  private int a = 0;

  public static int a(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2, false, null, new String[0]);
  }

  public static int a(Object paramObject1, Object paramObject2, Collection<String> paramCollection)
  {
    return a(paramObject1, paramObject2, f.a(paramCollection));
  }

  public static int a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    return a(paramObject1, paramObject2, paramBoolean, null, new String[0]);
  }

  public static int a(Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass, String[] paramArrayOfString)
  {
    if (paramObject1 == paramObject2)
      return 0;
    if ((paramObject1 == null) || (paramObject2 == null))
      throw new NullPointerException();
    Class localClass = paramObject1.getClass();
    if (!localClass.isInstance(paramObject2))
      throw new ClassCastException();
    b localb = new b();
    a(paramObject1, paramObject2, localClass, localb, paramBoolean, paramArrayOfString);
    while ((localClass.getSuperclass() != null) && (localClass != paramClass))
    {
      localClass = localClass.getSuperclass();
      a(paramObject1, paramObject2, localClass, localb, paramBoolean, paramArrayOfString);
    }
    return localb.b();
  }

  public static int a(Object paramObject1, Object paramObject2, String[] paramArrayOfString)
  {
    return a(paramObject1, paramObject2, false, null, paramArrayOfString);
  }

  private static void a(Object paramObject1, Object paramObject2, Class<?> paramClass, b paramb, boolean paramBoolean, String[] paramArrayOfString)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    AccessibleObject.setAccessible(arrayOfField, true);
    int i = 0;
    while ((i < arrayOfField.length) && (paramb.a == 0))
    {
      Field localField = arrayOfField[i];
      if ((!c.c(paramArrayOfString, localField.getName())) && (localField.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localField.getModifiers()))) && (!Modifier.isStatic(localField.getModifiers())));
      try
      {
        paramb.b(localField.get(paramObject1), localField.get(paramObject2));
        i++;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new InternalError("Unexpected IllegalAccessException");
      }
    }
  }

  public b a(byte paramByte1, byte paramByte2)
  {
    if (this.a != 0)
      return this;
    int i;
    if (paramByte1 < paramByte2)
      i = -1;
    while (true)
    {
      this.a = i;
      return this;
      if (paramByte1 > paramByte2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public b a(char paramChar1, char paramChar2)
  {
    if (this.a != 0)
      return this;
    int i;
    if (paramChar1 < paramChar2)
      i = -1;
    while (true)
    {
      this.a = i;
      return this;
      if (paramChar1 > paramChar2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public b a(double paramDouble1, double paramDouble2)
  {
    if (this.a != 0)
      return this;
    this.a = Double.compare(paramDouble1, paramDouble2);
    return this;
  }

  public b a(float paramFloat1, float paramFloat2)
  {
    if (this.a != 0)
      return this;
    this.a = Float.compare(paramFloat1, paramFloat2);
    return this;
  }

  public b a(int paramInt)
  {
    if (this.a != 0)
      return this;
    this.a = paramInt;
    return this;
  }

  public b a(int paramInt1, int paramInt2)
  {
    if (this.a != 0)
      return this;
    int i;
    if (paramInt1 < paramInt2)
      i = -1;
    while (true)
    {
      this.a = i;
      return this;
      if (paramInt1 > paramInt2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public b a(long paramLong1, long paramLong2)
  {
    if (this.a != 0)
      return this;
    int i;
    if (paramLong1 < paramLong2)
      i = -1;
    while (true)
    {
      this.a = i;
      return this;
      if (paramLong1 > paramLong2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public b a(Object paramObject1, Object paramObject2, Comparator<?> paramComparator)
  {
    if (this.a != 0);
    do
      return this;
    while (paramObject1 == paramObject2);
    if (paramObject1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramObject2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramObject1.getClass().isArray())
    {
      if ((paramObject1 instanceof long[]))
      {
        a((long[])(long[])paramObject1, (long[])(long[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof int[]))
      {
        a((int[])(int[])paramObject1, (int[])(int[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof short[]))
      {
        a((short[])(short[])paramObject1, (short[])(short[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof char[]))
      {
        a((char[])(char[])paramObject1, (char[])(char[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof byte[]))
      {
        a((byte[])(byte[])paramObject1, (byte[])(byte[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof double[]))
      {
        a((double[])(double[])paramObject1, (double[])(double[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof float[]))
      {
        a((float[])(float[])paramObject1, (float[])(float[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof boolean[]))
      {
        a((boolean[])(boolean[])paramObject1, (boolean[])(boolean[])paramObject2);
        return this;
      }
      a((Object[])(Object[])paramObject1, (Object[])(Object[])paramObject2, paramComparator);
      return this;
    }
    if (paramComparator == null)
    {
      this.a = ((Comparable)paramObject1).compareTo(paramObject2);
      return this;
    }
    this.a = paramComparator.compare(paramObject1, paramObject2);
    return this;
  }

  public b a(short paramShort1, short paramShort2)
  {
    if (this.a != 0)
      return this;
    int i;
    if (paramShort1 < paramShort2)
      i = -1;
    while (true)
    {
      this.a = i;
      return this;
      if (paramShort1 > paramShort2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public b a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a != 0);
    do
      return this;
    while (paramBoolean1 == paramBoolean2);
    if (!paramBoolean1)
    {
      this.a = -1;
      return this;
    }
    this.a = 1;
    return this;
  }

  public b a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfByte1 == paramArrayOfByte2)
        continue;
      if (paramArrayOfByte1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfByte2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1.length < paramArrayOfByte2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfByte1.length) && (this.a == 0); j++)
        a(paramArrayOfByte1[j], paramArrayOfByte2[j]);
    }
  }

  public b a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfChar1 == paramArrayOfChar2)
        continue;
      if (paramArrayOfChar1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfChar2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfChar1.length != paramArrayOfChar2.length)
      {
        if (paramArrayOfChar1.length < paramArrayOfChar2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfChar1.length) && (this.a == 0); j++)
        a(paramArrayOfChar1[j], paramArrayOfChar2[j]);
    }
  }

  public b a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfDouble1 == paramArrayOfDouble2)
        continue;
      if (paramArrayOfDouble1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfDouble2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfDouble1.length != paramArrayOfDouble2.length)
      {
        if (paramArrayOfDouble1.length < paramArrayOfDouble2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfDouble1.length) && (this.a == 0); j++)
        a(paramArrayOfDouble1[j], paramArrayOfDouble2[j]);
    }
  }

  public b a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfFloat1 == paramArrayOfFloat2)
        continue;
      if (paramArrayOfFloat1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfFloat2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfFloat1.length != paramArrayOfFloat2.length)
      {
        if (paramArrayOfFloat1.length < paramArrayOfFloat2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfFloat1.length) && (this.a == 0); j++)
        a(paramArrayOfFloat1[j], paramArrayOfFloat2[j]);
    }
  }

  public b a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfInt1 == paramArrayOfInt2)
        continue;
      if (paramArrayOfInt1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfInt2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfInt1.length != paramArrayOfInt2.length)
      {
        if (paramArrayOfInt1.length < paramArrayOfInt2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfInt1.length) && (this.a == 0); j++)
        a(paramArrayOfInt1[j], paramArrayOfInt2[j]);
    }
  }

  public b a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfLong1 == paramArrayOfLong2)
        continue;
      if (paramArrayOfLong1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfLong2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfLong1.length != paramArrayOfLong2.length)
      {
        if (paramArrayOfLong1.length < paramArrayOfLong2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfLong1.length) && (this.a == 0); j++)
        a(paramArrayOfLong1[j], paramArrayOfLong2[j]);
    }
  }

  public b a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return a(paramArrayOfObject1, paramArrayOfObject2, null);
  }

  public b a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Comparator<?> paramComparator)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfObject1 == paramArrayOfObject2)
        continue;
      if (paramArrayOfObject1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfObject2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfObject1.length != paramArrayOfObject2.length)
      {
        if (paramArrayOfObject1.length < paramArrayOfObject2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfObject1.length) && (this.a == 0); j++)
        a(paramArrayOfObject1[j], paramArrayOfObject2[j], paramComparator);
    }
  }

  public b a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfShort1 == paramArrayOfShort2)
        continue;
      if (paramArrayOfShort1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfShort2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfShort1.length != paramArrayOfShort2.length)
      {
        if (paramArrayOfShort1.length < paramArrayOfShort2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfShort1.length) && (this.a == 0); j++)
        a(paramArrayOfShort1[j], paramArrayOfShort2[j]);
    }
  }

  public b a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    int i = -1;
    if (this.a != 0);
    while (true)
    {
      return this;
      if (paramArrayOfBoolean1 == paramArrayOfBoolean2)
        continue;
      if (paramArrayOfBoolean1 == null)
      {
        this.a = i;
        return this;
      }
      if (paramArrayOfBoolean2 == null)
      {
        this.a = 1;
        return this;
      }
      if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length)
      {
        if (paramArrayOfBoolean1.length < paramArrayOfBoolean2.length);
        while (true)
        {
          this.a = i;
          return this;
          i = 1;
        }
      }
      for (int j = 0; (j < paramArrayOfBoolean1.length) && (this.a == 0); j++)
        a(paramArrayOfBoolean1[j], paramArrayOfBoolean2[j]);
    }
  }

  public int b()
  {
    return this.a;
  }

  public b b(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2, null);
  }

  public Integer c()
  {
    return Integer.valueOf(b());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.b
 * JD-Core Version:    0.6.0
 */