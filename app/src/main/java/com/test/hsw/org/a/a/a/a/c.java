package org.a.a.a.a;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class c
  implements a<Boolean>
{
  private static final ThreadLocal<Set<org.a.a.a.j.c<e, e>>> a = new ThreadLocal();
  private boolean b = true;

  static org.a.a.a.j.c<e, e> a(Object paramObject1, Object paramObject2)
  {
    return org.a.a.a.j.c.b(new e(paramObject1), new e(paramObject2));
  }

  private static void a(Object paramObject1, Object paramObject2, Class<?> paramClass, c paramc, boolean paramBoolean, String[] paramArrayOfString)
  {
    if (b(paramObject1, paramObject2))
      return;
    try
    {
      c(paramObject1, paramObject2);
      Field[] arrayOfField = paramClass.getDeclaredFields();
      AccessibleObject.setAccessible(arrayOfField, true);
      int i = 0;
      while (true)
        if ((i < arrayOfField.length) && (paramc.b))
        {
          Field localField = arrayOfField[i];
          if ((!org.a.a.a.c.c(paramArrayOfString, localField.getName())) && (localField.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localField.getModifiers()))))
          {
            boolean bool = Modifier.isStatic(localField.getModifiers());
            if (bool);
          }
          try
          {
            paramc.e(localField.get(paramObject1), localField.get(paramObject2));
            i++;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new InternalError("Unexpected IllegalAccessException");
          }
        }
    }
    finally
    {
      d(paramObject1, paramObject2);
    }
    d(paramObject1, paramObject2);
  }

  public static boolean a(Object paramObject1, Object paramObject2, Collection<String> paramCollection)
  {
    return a(paramObject1, paramObject2, f.a(paramCollection));
  }

  public static boolean a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    return a(paramObject1, paramObject2, paramBoolean, null, new String[0]);
  }

  public static boolean a(Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass, String[] paramArrayOfString)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    Class localClass1 = paramObject1.getClass();
    Class localClass2 = paramObject2.getClass();
    if (localClass1.isInstance(paramObject2))
      if (localClass2.isInstance(paramObject1))
        break label141;
    while (true)
    {
      c localc = new c();
      try
      {
        a(paramObject1, paramObject2, localClass2, localc, paramBoolean, paramArrayOfString);
        while ((localClass2.getSuperclass() != null) && (localClass2 != paramClass))
        {
          localClass2 = localClass2.getSuperclass();
          a(paramObject1, paramObject2, localClass2, localc, paramBoolean, paramArrayOfString);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return false;
      }
      if (localClass2.isInstance(paramObject1))
      {
        if (localClass1.isInstance(paramObject2))
          continue;
        localClass2 = localClass1;
        continue;
      }
      return false;
      return localc.c();
      label141: localClass2 = localClass1;
    }
  }

  public static boolean a(Object paramObject1, Object paramObject2, String[] paramArrayOfString)
  {
    return a(paramObject1, paramObject2, false, null, paramArrayOfString);
  }

  static Set<org.a.a.a.j.c<e, e>> b()
  {
    return (Set)a.get();
  }

  static boolean b(Object paramObject1, Object paramObject2)
  {
    Set localSet = b();
    org.a.a.a.j.c localc1 = a(paramObject1, paramObject2);
    org.a.a.a.j.c localc2 = org.a.a.a.j.c.b(localc1.a(), localc1.b());
    return (localSet != null) && ((localSet.contains(localc1)) || (localSet.contains(localc2)));
  }

  static void c(Object paramObject1, Object paramObject2)
  {
    monitorenter;
    try
    {
      if (b() == null)
        a.set(new HashSet());
      monitorexit;
      b().add(a(paramObject1, paramObject2));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  static void d(Object paramObject1, Object paramObject2)
  {
    Set localSet1 = b();
    if (localSet1 != null)
    {
      localSet1.remove(a(paramObject1, paramObject2));
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

  public c a(byte paramByte1, byte paramByte2)
  {
    if (!this.b)
      return this;
    if (paramByte1 == paramByte2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(char paramChar1, char paramChar2)
  {
    if (!this.b)
      return this;
    if (paramChar1 == paramChar2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(double paramDouble1, double paramDouble2)
  {
    if (!this.b)
      return this;
    return a(Double.doubleToLongBits(paramDouble1), Double.doubleToLongBits(paramDouble2));
  }

  public c a(float paramFloat1, float paramFloat2)
  {
    if (!this.b)
      return this;
    return a(Float.floatToIntBits(paramFloat1), Float.floatToIntBits(paramFloat2));
  }

  public c a(int paramInt1, int paramInt2)
  {
    if (!this.b)
      return this;
    if (paramInt1 == paramInt2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(long paramLong1, long paramLong2)
  {
    if (!this.b)
      return this;
    if (paramLong1 == paramLong2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(short paramShort1, short paramShort2)
  {
    if (!this.b)
      return this;
    if (paramShort1 == paramShort2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(boolean paramBoolean)
  {
    if (!this.b)
      return this;
    this.b = paramBoolean;
    return this;
  }

  public c a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.b)
      return this;
    if (paramBoolean1 == paramBoolean2);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return this;
    }
  }

  public c a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfByte1 == paramArrayOfByte2)
        continue;
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfByte1.length;
      int j = paramArrayOfByte2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfByte1.length) && (this.b))
      {
        a(paramArrayOfByte1[k], paramArrayOfByte2[k]);
        k++;
      }
    }
  }

  public c a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfChar1 == paramArrayOfChar2)
        continue;
      if ((paramArrayOfChar1 == null) || (paramArrayOfChar2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfChar1.length;
      int j = paramArrayOfChar2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfChar1.length) && (this.b))
      {
        a(paramArrayOfChar1[k], paramArrayOfChar2[k]);
        k++;
      }
    }
  }

  public c a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfDouble1 == paramArrayOfDouble2)
        continue;
      if ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfDouble1.length;
      int j = paramArrayOfDouble2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfDouble1.length) && (this.b))
      {
        a(paramArrayOfDouble1[k], paramArrayOfDouble2[k]);
        k++;
      }
    }
  }

  public c a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfFloat1 == paramArrayOfFloat2)
        continue;
      if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfFloat1.length;
      int j = paramArrayOfFloat2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfFloat1.length) && (this.b))
      {
        a(paramArrayOfFloat1[k], paramArrayOfFloat2[k]);
        k++;
      }
    }
  }

  public c a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfInt1 == paramArrayOfInt2)
        continue;
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfInt1.length;
      int j = paramArrayOfInt2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfInt1.length) && (this.b))
      {
        a(paramArrayOfInt1[k], paramArrayOfInt2[k]);
        k++;
      }
    }
  }

  public c a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfLong1 == paramArrayOfLong2)
        continue;
      if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfLong1.length;
      int j = paramArrayOfLong2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfLong1.length) && (this.b))
      {
        a(paramArrayOfLong1[k], paramArrayOfLong2[k]);
        k++;
      }
    }
  }

  public c a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfObject1 == paramArrayOfObject2)
        continue;
      if ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfObject1.length;
      int j = paramArrayOfObject2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfObject1.length) && (this.b))
      {
        e(paramArrayOfObject1[k], paramArrayOfObject2[k]);
        k++;
      }
    }
  }

  public c a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfShort1 == paramArrayOfShort2)
        continue;
      if ((paramArrayOfShort1 == null) || (paramArrayOfShort2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfShort1.length;
      int j = paramArrayOfShort2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfShort1.length) && (this.b))
      {
        a(paramArrayOfShort1[k], paramArrayOfShort2[k]);
        k++;
      }
    }
  }

  public c a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (!this.b);
    while (true)
    {
      return this;
      if (paramArrayOfBoolean1 == paramArrayOfBoolean2)
        continue;
      if ((paramArrayOfBoolean1 == null) || (paramArrayOfBoolean2 == null))
      {
        b(false);
        return this;
      }
      int i = paramArrayOfBoolean1.length;
      int j = paramArrayOfBoolean2.length;
      int k = 0;
      if (i != j)
      {
        b(false);
        return this;
      }
      while ((k < paramArrayOfBoolean1.length) && (this.b))
      {
        a(paramArrayOfBoolean1[k], paramArrayOfBoolean2[k]);
        k++;
      }
    }
  }

  protected void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean c()
  {
    return this.b;
  }

  public Boolean d()
  {
    return Boolean.valueOf(c());
  }

  public c e(Object paramObject1, Object paramObject2)
  {
    if (!this.b);
    do
      return this;
    while (paramObject1 == paramObject2);
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      b(false);
      return this;
    }
    if (!paramObject1.getClass().isArray())
    {
      this.b = paramObject1.equals(paramObject2);
      return this;
    }
    if (paramObject1.getClass() != paramObject2.getClass())
    {
      b(false);
      return this;
    }
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
    a((Object[])(Object[])paramObject1, (Object[])(Object[])paramObject2);
    return this;
  }

  public void e()
  {
    this.b = true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.c
 * JD-Core Version:    0.6.0
 */