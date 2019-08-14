package org.a.a.a.a;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.a.a.a.c;

public class d
  implements a<Integer>
{
  private static final ThreadLocal<Set<e>> a = new ThreadLocal();
  private final int b;
  private int c = 0;

  public d()
  {
    this.b = 37;
    this.c = 17;
  }

  public d(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
      throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
    if (paramInt1 % 2 == 0)
      throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
    if (paramInt2 == 0)
      throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
    if (paramInt2 % 2 == 0)
      throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
    this.b = paramInt2;
    this.c = paramInt1;
  }

  public static int a(int paramInt1, int paramInt2, Object paramObject)
  {
    return a(paramInt1, paramInt2, paramObject, false, null, new String[0]);
  }

  public static int a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramObject, paramBoolean, null, new String[0]);
  }

  public static <T> int a(int paramInt1, int paramInt2, T paramT, boolean paramBoolean, Class<? super T> paramClass, String[] paramArrayOfString)
  {
    if (paramT == null)
      throw new IllegalArgumentException("The object to build a hash code for must not be null");
    d locald = new d(paramInt1, paramInt2);
    Class localClass = paramT.getClass();
    a(paramT, localClass, locald, paramBoolean, paramArrayOfString);
    while ((localClass.getSuperclass() != null) && (localClass != paramClass))
    {
      localClass = localClass.getSuperclass();
      a(paramT, localClass, locald, paramBoolean, paramArrayOfString);
    }
    return locald.c();
  }

  public static int a(Object paramObject, Collection<String> paramCollection)
  {
    return a(paramObject, f.a(paramCollection));
  }

  public static int a(Object paramObject, boolean paramBoolean)
  {
    return a(17, 37, paramObject, paramBoolean, null, new String[0]);
  }

  public static int a(Object paramObject, String[] paramArrayOfString)
  {
    return a(17, 37, paramObject, false, null, paramArrayOfString);
  }

  private static void a(Object paramObject, Class<?> paramClass, d paramd, boolean paramBoolean, String[] paramArrayOfString)
  {
    if (a(paramObject))
      return;
    try
    {
      b(paramObject);
      Field[] arrayOfField = paramClass.getDeclaredFields();
      AccessibleObject.setAccessible(arrayOfField, true);
      int i = arrayOfField.length;
      int j = 0;
      while (true)
        if (j < i)
        {
          Field localField = arrayOfField[j];
          if ((!c.c(paramArrayOfString, localField.getName())) && (localField.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localField.getModifiers()))))
          {
            boolean bool = Modifier.isStatic(localField.getModifiers());
            if (bool);
          }
          try
          {
            paramd.d(localField.get(paramObject));
            j++;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new InternalError("Unexpected IllegalAccessException");
          }
        }
    }
    finally
    {
      c(paramObject);
    }
    c(paramObject);
  }

  static boolean a(Object paramObject)
  {
    Set localSet = b();
    return (localSet != null) && (localSet.contains(new e(paramObject)));
  }

  static Set<e> b()
  {
    return (Set)a.get();
  }

  static void b(Object paramObject)
  {
    monitorenter;
    try
    {
      if (b() == null)
        a.set(new HashSet());
      monitorexit;
      b().add(new e(paramObject));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  static void c(Object paramObject)
  {
    Set localSet1 = b();
    if (localSet1 != null)
    {
      localSet1.remove(new e(paramObject));
      monitorenter;
      try
      {
        Set localSet2 = b();
        if ((localSet2 != null) && (localSet2.isEmpty()))
          a.remove();
        return;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public d a(byte paramByte)
  {
    this.c = (paramByte + this.c * this.b);
    return this;
  }

  public d a(char paramChar)
  {
    this.c = (paramChar + this.c * this.b);
    return this;
  }

  public d a(double paramDouble)
  {
    return a(Double.doubleToLongBits(paramDouble));
  }

  public d a(float paramFloat)
  {
    this.c = (this.c * this.b + Float.floatToIntBits(paramFloat));
    return this;
  }

  public d a(int paramInt)
  {
    this.c = (paramInt + this.c * this.b);
    return this;
  }

  public d a(long paramLong)
  {
    this.c = (this.c * this.b + (int)(paramLong ^ paramLong >> 32));
    return this;
  }

  public d a(short paramShort)
  {
    this.c = (paramShort + this.c * this.b);
    return this;
  }

  public d a(boolean paramBoolean)
  {
    int i = this.c * this.b;
    if (paramBoolean);
    for (int j = 0; ; j = 1)
    {
      this.c = (j + i);
      return this;
    }
  }

  public d a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfByte.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfByte[j]);
    }
  }

  public d a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfChar.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfChar[j]);
    }
  }

  public d a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfDouble.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfDouble[j]);
    }
  }

  public d a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfFloat.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfFloat[j]);
    }
  }

  public d a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfInt[j]);
    }
  }

  public d a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfLong.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfLong[j]);
    }
  }

  public d a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
        d(paramArrayOfObject[j]);
    }
  }

  public d a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfShort.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfShort[j]);
    }
  }

  public d a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      this.c *= this.b;
    while (true)
    {
      return this;
      int i = paramArrayOfBoolean.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfBoolean[j]);
    }
  }

  public d b(int paramInt)
  {
    this.c = (paramInt + this.c * this.b);
    return this;
  }

  public int c()
  {
    return this.c;
  }

  public Integer d()
  {
    return Integer.valueOf(c());
  }

  public d d(Object paramObject)
  {
    if (paramObject == null)
    {
      this.c *= this.b;
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof long[]))
      {
        a((long[])(long[])paramObject);
        return this;
      }
      if ((paramObject instanceof int[]))
      {
        a((int[])(int[])paramObject);
        return this;
      }
      if ((paramObject instanceof short[]))
      {
        a((short[])(short[])paramObject);
        return this;
      }
      if ((paramObject instanceof char[]))
      {
        a((char[])(char[])paramObject);
        return this;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])(byte[])paramObject);
        return this;
      }
      if ((paramObject instanceof double[]))
      {
        a((double[])(double[])paramObject);
        return this;
      }
      if ((paramObject instanceof float[]))
      {
        a((float[])(float[])paramObject);
        return this;
      }
      if ((paramObject instanceof boolean[]))
      {
        a((boolean[])(boolean[])paramObject);
        return this;
      }
      a((Object[])(Object[])paramObject);
      return this;
    }
    this.c = (this.c * this.b + paramObject.hashCode());
    return this;
  }

  public int hashCode()
  {
    return c();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.d
 * JD-Core Version:    0.6.0
 */