package org.a.a.a;

import B;
import C;
import D;
import F;
import I;
import J;
import S;
import Z;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.a.a.a.a.d;
import org.a.a.a.a.h;
import org.a.a.a.a.i;
import org.a.a.a.f.f;

public class c
{
  public static final Object[] a = new Object[0];
  public static final Class<?>[] b = new Class[0];
  public static final String[] c = new String[0];
  public static final long[] d = new long[0];
  public static final Long[] e = new Long[0];
  public static final int[] f = new int[0];
  public static final Integer[] g = new Integer[0];
  public static final short[] h = new short[0];
  public static final Short[] i = new Short[0];
  public static final byte[] j = new byte[0];
  public static final Byte[] k = new Byte[0];
  public static final double[] l = new double[0];
  public static final Double[] m = new Double[0];
  public static final float[] n = new float[0];
  public static final Float[] o = new Float[0];
  public static final boolean[] p = new boolean[0];
  public static final Boolean[] q = new Boolean[0];
  public static final char[] r = new char[0];
  public static final Character[] s = new Character[0];
  public static final int t = -1;

  public static int a(byte[] paramArrayOfByte, byte paramByte)
  {
    return a(paramArrayOfByte, paramByte, 0);
  }

  public static int a(byte[] paramArrayOfByte, byte paramByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfByte.length)
        break label33;
      if (paramByte == paramArrayOfByte[paramInt])
        break;
    }
    label33: return -1;
  }

  public static int a(char[] paramArrayOfChar, char paramChar)
  {
    return a(paramArrayOfChar, paramChar, 0);
  }

  public static int a(char[] paramArrayOfChar, char paramChar, int paramInt)
  {
    if (paramArrayOfChar == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfChar.length)
        break label33;
      if (paramChar == paramArrayOfChar[paramInt])
        break;
    }
    label33: return -1;
  }

  public static int a(double[] paramArrayOfDouble, double paramDouble)
  {
    return a(paramArrayOfDouble, paramDouble, 0);
  }

  public static int a(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    return a(paramArrayOfDouble, paramDouble1, 0, paramDouble2);
  }

  public static int a(double[] paramArrayOfDouble, double paramDouble, int paramInt)
  {
    if (e(paramArrayOfDouble))
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfDouble.length)
        break label37;
      if (paramDouble == paramArrayOfDouble[paramInt])
        break;
    }
    label37: return -1;
  }

  public static int a(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2)
  {
    if (e(paramArrayOfDouble))
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0)
      paramInt = 0;
    double d1 = paramDouble1 - paramDouble2;
    double d2 = paramDouble1 + paramDouble2;
    while (true)
    {
      if (paramInt >= paramArrayOfDouble.length)
        break label59;
      if ((paramArrayOfDouble[paramInt] >= d1) && (paramArrayOfDouble[paramInt] <= d2))
        break;
      paramInt++;
    }
    label59: return -1;
  }

  public static int a(float[] paramArrayOfFloat, float paramFloat)
  {
    return a(paramArrayOfFloat, paramFloat, 0);
  }

  public static int a(float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (e(paramArrayOfFloat))
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfFloat.length)
        break label37;
      if (paramFloat == paramArrayOfFloat[paramInt])
        break;
    }
    label37: return -1;
  }

  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    return b(paramArrayOfInt, paramInt, 0);
  }

  public static int a(long[] paramArrayOfLong, long paramLong)
  {
    return a(paramArrayOfLong, paramLong, 0);
  }

  public static int a(long[] paramArrayOfLong, long paramLong, int paramInt)
  {
    if (paramArrayOfLong == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfLong.length)
        break label34;
      if (paramLong == paramArrayOfLong[paramInt])
        break;
    }
    label34: return -1;
  }

  public static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject, 0);
  }

  public static int a(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      i1 = -1;
      return i1;
    }
    if (paramInt < 0);
    for (int i1 = 0; ; i1 = paramInt)
    {
      if (paramObject == null)
        while (true)
        {
          if (i1 >= paramArrayOfObject.length)
            break label72;
          if (paramArrayOfObject[i1] == null)
            break;
          i1++;
        }
      if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
        while (true)
        {
          if (i1 >= paramArrayOfObject.length)
            break label72;
          if (paramObject.equals(paramArrayOfObject[i1]))
            break;
          i1++;
        }
      label72: return -1;
    }
  }

  public static int a(short[] paramArrayOfShort, short paramShort)
  {
    return a(paramArrayOfShort, paramShort, 0);
  }

  public static int a(short[] paramArrayOfShort, short paramShort, int paramInt)
  {
    if (paramArrayOfShort == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfShort.length)
        break label33;
      if (paramShort == paramArrayOfShort[paramInt])
        break;
    }
    label33: return -1;
  }

  public static int a(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return a(paramArrayOfBoolean, paramBoolean, 0);
  }

  public static int a(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt)
  {
    if (e(paramArrayOfBoolean))
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0);
    for (paramInt = 0; ; paramInt++)
    {
      if (paramInt >= paramArrayOfBoolean.length)
        break label36;
      if (paramBoolean == paramArrayOfBoolean[paramInt])
        break;
    }
    label36: return -1;
  }

  private static Object a(Object paramObject, int paramInt)
  {
    int i1 = c(paramObject);
    if ((paramInt < 0) || (paramInt >= i1))
      throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i1);
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i1 - 1);
    System.arraycopy(paramObject, 0, localObject, 0, paramInt);
    if (paramInt < i1 - 1)
      System.arraycopy(paramObject, paramInt + 1, localObject, paramInt, -1 + (i1 - paramInt));
    return localObject;
  }

  private static Object a(Object paramObject1, int paramInt, Object paramObject2, Class<?> paramClass)
  {
    Object localObject;
    if (paramObject1 == null)
    {
      if (paramInt != 0)
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
      localObject = Array.newInstance(paramClass, 1);
      Array.set(localObject, 0, paramObject2);
    }
    int i1;
    do
    {
      return localObject;
      i1 = Array.getLength(paramObject1);
      if ((paramInt > i1) || (paramInt < 0))
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i1);
      localObject = Array.newInstance(paramClass, i1 + 1);
      System.arraycopy(paramObject1, 0, localObject, 0, paramInt);
      Array.set(localObject, paramInt, paramObject2);
    }
    while (paramInt >= i1);
    System.arraycopy(paramObject1, paramInt, localObject, paramInt + 1, i1 - paramInt);
    return localObject;
  }

  private static Object a(Object paramObject, Class<?> paramClass)
  {
    if (paramObject != null)
    {
      int i1 = Array.getLength(paramObject);
      Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i1 + 1);
      System.arraycopy(paramObject, 0, localObject, 0, i1);
      return localObject;
    }
    return Array.newInstance(paramClass, 1);
  }

  private static Object a(Object paramObject, int[] paramArrayOfInt)
  {
    int i1 = c(paramObject);
    if (f(paramArrayOfInt))
    {
      Arrays.sort(paramArrayOfInt);
      int i9 = paramArrayOfInt.length;
      int i10 = i1;
      int i11 = i9;
      i2 = 0;
      while (true)
      {
        int i12 = i11 - 1;
        if (i12 < 0)
          break;
        int i13 = paramArrayOfInt[i12];
        if ((i13 < 0) || (i13 >= i1))
          throw new IndexOutOfBoundsException("Index: " + i13 + ", Length: " + i1);
        if (i13 >= i10)
        {
          i11 = i12;
          continue;
        }
        i2++;
        i10 = i13;
        i11 = i12;
      }
    }
    int i2 = 0;
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i1 - i2);
    if (i2 < i1)
    {
      int i3 = i1 - i2;
      int i4 = -1 + paramArrayOfInt.length;
      int i5 = i3;
      int i6 = i4;
      while (i6 >= 0)
      {
        int i7 = paramArrayOfInt[i6];
        if (i1 - i7 > 1)
        {
          int i8 = -1 + (i1 - i7);
          i5 -= i8;
          System.arraycopy(paramObject, i7 + 1, localObject, i5, i8);
        }
        i6--;
        i1 = i7;
      }
      if (i1 > 0)
        System.arraycopy(paramObject, 0, localObject, 0, i1);
    }
    return localObject;
  }

  public static String a(Object paramObject)
  {
    return a(paramObject, "{}");
  }

  public static String a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      return paramString;
    return new h(paramObject, i.e).d(paramObject).toString();
  }

  public static Map<Object, Object> a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      return null;
    HashMap localHashMap = new HashMap((int)(1.5D * paramArrayOfObject.length));
    int i1 = 0;
    if (i1 < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i1];
      if ((localObject instanceof Map.Entry))
      {
        Map.Entry localEntry = (Map.Entry)localObject;
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      while (true)
      {
        i1++;
        break;
        if (!(localObject instanceof Object[]))
          break label159;
        Object[] arrayOfObject = (Object[])(Object[])localObject;
        if (arrayOfObject.length < 2)
          throw new IllegalArgumentException("Array element " + i1 + ", '" + localObject + "', has a length less than 2");
        localHashMap.put(arrayOfObject[0], arrayOfObject[1]);
      }
      label159: throw new IllegalArgumentException("Array element " + i1 + ", '" + localObject + "', is neither of type Map.Entry nor an Array");
    }
    return localHashMap;
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return new org.a.a.a.a.c().e(paramObject1, paramObject2).c();
  }

  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return ((paramArrayOfByte1 != null) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) && ((paramArrayOfByte2 != null) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) && ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == paramArrayOfByte2.length));
  }

  public static boolean a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return ((paramArrayOfChar1 != null) || (paramArrayOfChar2 == null) || (paramArrayOfChar2.length <= 0)) && ((paramArrayOfChar2 != null) || (paramArrayOfChar1 == null) || (paramArrayOfChar1.length <= 0)) && ((paramArrayOfChar1 == null) || (paramArrayOfChar2 == null) || (paramArrayOfChar1.length == paramArrayOfChar2.length));
  }

  public static boolean a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return ((paramArrayOfDouble1 != null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble2.length <= 0)) && ((paramArrayOfDouble2 != null) || (paramArrayOfDouble1 == null) || (paramArrayOfDouble1.length <= 0)) && ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble1.length == paramArrayOfDouble2.length));
  }

  public static boolean a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return ((paramArrayOfFloat1 != null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length <= 0)) && ((paramArrayOfFloat2 != null) || (paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length <= 0)) && ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat1.length == paramArrayOfFloat2.length));
  }

  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return ((paramArrayOfInt1 != null) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) && ((paramArrayOfInt2 != null) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) && ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null) || (paramArrayOfInt1.length == paramArrayOfInt2.length));
  }

  public static boolean a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    return ((paramArrayOfLong1 != null) || (paramArrayOfLong2 == null) || (paramArrayOfLong2.length <= 0)) && ((paramArrayOfLong2 != null) || (paramArrayOfLong1 == null) || (paramArrayOfLong1.length <= 0)) && ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length == paramArrayOfLong2.length));
  }

  public static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return ((paramArrayOfObject1 != null) || (paramArrayOfObject2 == null) || (paramArrayOfObject2.length <= 0)) && ((paramArrayOfObject2 != null) || (paramArrayOfObject1 == null) || (paramArrayOfObject1.length <= 0)) && ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length == paramArrayOfObject2.length));
  }

  public static boolean a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    return ((paramArrayOfShort1 != null) || (paramArrayOfShort2 == null) || (paramArrayOfShort2.length <= 0)) && ((paramArrayOfShort2 != null) || (paramArrayOfShort1 == null) || (paramArrayOfShort1.length <= 0)) && ((paramArrayOfShort1 == null) || (paramArrayOfShort2 == null) || (paramArrayOfShort1.length == paramArrayOfShort2.length));
  }

  public static boolean a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    return ((paramArrayOfBoolean1 != null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean2.length <= 0)) && ((paramArrayOfBoolean2 != null) || (paramArrayOfBoolean1 == null) || (paramArrayOfBoolean1.length <= 0)) && ((paramArrayOfBoolean1 == null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean1.length == paramArrayOfBoolean2.length));
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return (byte[])paramArrayOfByte.clone();
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return (byte[])(byte[])a(paramArrayOfByte, paramInt);
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    return (byte[])(byte[])a(paramArrayOfByte, paramInt, Byte.valueOf(paramByte), Byte.TYPE);
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfByte.length)
      paramInt2 = paramArrayOfByte.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return j;
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i1);
    return arrayOfByte;
  }

  public static byte[] a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    return (byte[])(byte[])a(paramArrayOfByte, a(paramArrayOfInt));
  }

  public static byte[] a(Byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null)
      return null;
    if (paramArrayOfByte.length == 0)
      return j;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i1 = 0;
    if (i1 < paramArrayOfByte.length)
    {
      Byte localByte = paramArrayOfByte[i1];
      if (localByte == null);
      for (int i2 = paramByte; ; i2 = localByte.byteValue())
      {
        arrayOfByte[i1] = i2;
        i1++;
        break;
      }
    }
    return arrayOfByte;
  }

  public static char[] a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      return null;
    return (char[])paramArrayOfChar.clone();
  }

  public static char[] a(char[] paramArrayOfChar, int paramInt)
  {
    return (char[])(char[])a(paramArrayOfChar, paramInt);
  }

  public static char[] a(char[] paramArrayOfChar, int paramInt, char paramChar)
  {
    return (char[])(char[])a(paramArrayOfChar, paramInt, Character.valueOf(paramChar), Character.TYPE);
  }

  public static char[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfChar.length)
      paramInt2 = paramArrayOfChar.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return r;
    char[] arrayOfChar = new char[i1];
    System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, 0, i1);
    return arrayOfChar;
  }

  public static char[] a(char[] paramArrayOfChar, int[] paramArrayOfInt)
  {
    return (char[])(char[])a(paramArrayOfChar, a(paramArrayOfInt));
  }

  public static char[] a(Character[] paramArrayOfCharacter, char paramChar)
  {
    if (paramArrayOfCharacter == null)
      return null;
    if (paramArrayOfCharacter.length == 0)
      return r;
    char[] arrayOfChar = new char[paramArrayOfCharacter.length];
    int i1 = 0;
    if (i1 < paramArrayOfCharacter.length)
    {
      Character localCharacter = paramArrayOfCharacter[i1];
      if (localCharacter == null);
      for (int i2 = paramChar; ; i2 = localCharacter.charValue())
      {
        arrayOfChar[i1] = i2;
        i1++;
        break;
      }
    }
    return arrayOfChar;
  }

  public static double[] a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      return null;
    return (double[])paramArrayOfDouble.clone();
  }

  public static double[] a(double[] paramArrayOfDouble, int paramInt)
  {
    return (double[])(double[])a(paramArrayOfDouble, paramInt);
  }

  public static double[] a(double[] paramArrayOfDouble, int paramInt, double paramDouble)
  {
    return (double[])(double[])a(paramArrayOfDouble, paramInt, Double.valueOf(paramDouble), Double.TYPE);
  }

  public static double[] a(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramArrayOfDouble == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfDouble.length)
      paramInt2 = paramArrayOfDouble.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return l;
    double[] arrayOfDouble = new double[i1];
    System.arraycopy(paramArrayOfDouble, paramInt1, arrayOfDouble, 0, i1);
    return arrayOfDouble;
  }

  public static double[] a(double[] paramArrayOfDouble, int[] paramArrayOfInt)
  {
    return (double[])(double[])a(paramArrayOfDouble, a(paramArrayOfInt));
  }

  public static double[] a(Double[] paramArrayOfDouble, double paramDouble)
  {
    if (paramArrayOfDouble == null)
      return null;
    if (paramArrayOfDouble.length == 0)
      return l;
    double[] arrayOfDouble = new double[paramArrayOfDouble.length];
    int i1 = 0;
    if (i1 < paramArrayOfDouble.length)
    {
      Double localDouble = paramArrayOfDouble[i1];
      double d1;
      if (localDouble == null)
        d1 = paramDouble;
      while (true)
      {
        arrayOfDouble[i1] = d1;
        i1++;
        break;
        d1 = localDouble.doubleValue();
      }
    }
    return arrayOfDouble;
  }

  public static float[] a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      return null;
    return (float[])paramArrayOfFloat.clone();
  }

  public static float[] a(float[] paramArrayOfFloat, int paramInt)
  {
    return (float[])(float[])a(paramArrayOfFloat, paramInt);
  }

  public static float[] a(float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    return (float[])(float[])a(paramArrayOfFloat, paramInt, Float.valueOf(paramFloat), Float.TYPE);
  }

  public static float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramArrayOfFloat == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfFloat.length)
      paramInt2 = paramArrayOfFloat.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return n;
    float[] arrayOfFloat = new float[i1];
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i1);
    return arrayOfFloat;
  }

  public static float[] a(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    return (float[])(float[])a(paramArrayOfFloat, a(paramArrayOfInt));
  }

  public static float[] a(Float[] paramArrayOfFloat, float paramFloat)
  {
    if (paramArrayOfFloat == null)
      return null;
    if (paramArrayOfFloat.length == 0)
      return n;
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i1 = 0;
    if (i1 < paramArrayOfFloat.length)
    {
      Float localFloat = paramArrayOfFloat[i1];
      float f1;
      if (localFloat == null)
        f1 = paramFloat;
      while (true)
      {
        arrayOfFloat[i1] = f1;
        i1++;
        break;
        f1 = localFloat.floatValue();
      }
    }
    return arrayOfFloat;
  }

  private static int[] a(HashSet<Integer> paramHashSet)
  {
    int[] arrayOfInt = new int[paramHashSet.size()];
    Iterator localIterator = paramHashSet.iterator();
    int i2;
    for (int i1 = 0; localIterator.hasNext(); i1 = i2)
    {
      Integer localInteger = (Integer)localIterator.next();
      i2 = i1 + 1;
      arrayOfInt[i1] = localInteger.intValue();
    }
    return arrayOfInt;
  }

  public static int[] a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return null;
    return (int[])paramArrayOfInt.clone();
  }

  public static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfInt.length)
      paramInt2 = paramArrayOfInt.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return f;
    int[] arrayOfInt = new int[i1];
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, i1);
    return arrayOfInt;
  }

  public static int[] a(Integer[] paramArrayOfInteger, int paramInt)
  {
    if (paramArrayOfInteger == null)
      return null;
    if (paramArrayOfInteger.length == 0)
      return f;
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    int i1 = 0;
    if (i1 < paramArrayOfInteger.length)
    {
      Integer localInteger = paramArrayOfInteger[i1];
      if (localInteger == null);
      for (int i2 = paramInt; ; i2 = localInteger.intValue())
      {
        arrayOfInt[i1] = i2;
        i1++;
        break;
      }
    }
    return arrayOfInt;
  }

  public static long[] a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      return null;
    return (long[])paramArrayOfLong.clone();
  }

  public static long[] a(long[] paramArrayOfLong, int paramInt)
  {
    return (long[])(long[])a(paramArrayOfLong, paramInt);
  }

  public static long[] a(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramArrayOfLong == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfLong.length)
      paramInt2 = paramArrayOfLong.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return d;
    long[] arrayOfLong = new long[i1];
    System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, i1);
    return arrayOfLong;
  }

  public static long[] a(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    return (long[])(long[])a(paramArrayOfLong, paramInt, Long.valueOf(paramLong), Long.TYPE);
  }

  public static long[] a(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    return (long[])(long[])a(paramArrayOfLong, a(paramArrayOfInt));
  }

  public static long[] a(Long[] paramArrayOfLong, long paramLong)
  {
    if (paramArrayOfLong == null)
      return null;
    if (paramArrayOfLong.length == 0)
      return d;
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i1 = 0;
    if (i1 < paramArrayOfLong.length)
    {
      Long localLong = paramArrayOfLong[i1];
      long l1;
      if (localLong == null)
        l1 = paramLong;
      while (true)
      {
        arrayOfLong[i1] = l1;
        i1++;
        break;
        l1 = localLong.longValue();
      }
    }
    return arrayOfLong;
  }

  public static Boolean[] a(Boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0))
      paramArrayOfBoolean = q;
    return paramArrayOfBoolean;
  }

  public static Byte[] a(Byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      paramArrayOfByte = k;
    return paramArrayOfByte;
  }

  public static Character[] a(Character[] paramArrayOfCharacter)
  {
    if ((paramArrayOfCharacter == null) || (paramArrayOfCharacter.length == 0))
      paramArrayOfCharacter = s;
    return paramArrayOfCharacter;
  }

  public static Double[] a(Double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
      paramArrayOfDouble = m;
    return paramArrayOfDouble;
  }

  public static Float[] a(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
      paramArrayOfFloat = o;
    return paramArrayOfFloat;
  }

  public static Integer[] a(Integer[] paramArrayOfInteger)
  {
    if ((paramArrayOfInteger == null) || (paramArrayOfInteger.length == 0))
      paramArrayOfInteger = g;
    return paramArrayOfInteger;
  }

  public static Long[] a(Long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
      paramArrayOfLong = e;
    return paramArrayOfLong;
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    return (Object[])(Object[])a(paramArrayOfT, paramInt);
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    if (paramArrayOfT == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfT.length)
      paramInt2 = paramArrayOfT.length;
    int i1 = paramInt2 - paramInt1;
    Class localClass = paramArrayOfT.getClass().getComponentType();
    if (i1 <= 0)
      return (Object[])(Object[])Array.newInstance(localClass, 0);
    Object[] arrayOfObject = (Object[])(Object[])Array.newInstance(localClass, i1);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i1);
    return arrayOfObject;
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt, T paramT)
  {
    if (paramArrayOfT != null);
    for (Class localClass = paramArrayOfT.getClass().getComponentType(); ; localClass = paramT.getClass())
    {
      return (Object[])(Object[])a(paramArrayOfT, paramInt, paramT, localClass);
      if (paramT == null)
        break;
    }
    throw new IllegalArgumentException("Array and element cannot both be null");
  }

  public static <T> T[] a(T[] paramArrayOfT, int[] paramArrayOfInt)
  {
    return (Object[])(Object[])a(paramArrayOfT, a(paramArrayOfInt));
  }

  public static Short[] a(Short[] paramArrayOfShort)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
      paramArrayOfShort = i;
    return paramArrayOfShort;
  }

  public static String[] a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      paramArrayOfString = c;
    return paramArrayOfString;
  }

  public static short[] a(Short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null)
      return null;
    if (paramArrayOfShort.length == 0)
      return h;
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    int i1 = 0;
    if (i1 < paramArrayOfShort.length)
    {
      Short localShort = paramArrayOfShort[i1];
      if (localShort == null);
      for (int i2 = paramShort; ; i2 = localShort.shortValue())
      {
        arrayOfShort[i1] = i2;
        i1++;
        break;
      }
    }
    return arrayOfShort;
  }

  public static short[] a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      return null;
    return (short[])paramArrayOfShort.clone();
  }

  public static short[] a(short[] paramArrayOfShort, int paramInt)
  {
    return (short[])(short[])a(paramArrayOfShort, paramInt);
  }

  public static short[] a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramArrayOfShort == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfShort.length)
      paramInt2 = paramArrayOfShort.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return h;
    short[] arrayOfShort = new short[i1];
    System.arraycopy(paramArrayOfShort, paramInt1, arrayOfShort, 0, i1);
    return arrayOfShort;
  }

  public static short[] a(short[] paramArrayOfShort, int paramInt, short paramShort)
  {
    return (short[])(short[])a(paramArrayOfShort, paramInt, Short.valueOf(paramShort), Short.TYPE);
  }

  public static short[] a(short[] paramArrayOfShort, int[] paramArrayOfInt)
  {
    return (short[])(short[])a(paramArrayOfShort, a(paramArrayOfInt));
  }

  public static boolean[] a(Boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null)
      return null;
    if (paramArrayOfBoolean.length == 0)
      return p;
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
    int i1 = 0;
    if (i1 < paramArrayOfBoolean.length)
    {
      Boolean localBoolean = paramArrayOfBoolean[i1];
      if (localBoolean == null);
      for (boolean bool = paramBoolean; ; bool = localBoolean.booleanValue())
      {
        arrayOfBoolean[i1] = bool;
        i1++;
        break;
      }
    }
    return arrayOfBoolean;
  }

  public static boolean[] a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      return null;
    return (boolean[])paramArrayOfBoolean.clone();
  }

  public static boolean[] a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    return (boolean[])(boolean[])a(paramArrayOfBoolean, paramInt);
  }

  public static boolean[] a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfBoolean == null)
      return null;
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > paramArrayOfBoolean.length)
      paramInt2 = paramArrayOfBoolean.length;
    int i1 = paramInt2 - paramInt1;
    if (i1 <= 0)
      return p;
    boolean[] arrayOfBoolean = new boolean[i1];
    System.arraycopy(paramArrayOfBoolean, paramInt1, arrayOfBoolean, 0, i1);
    return arrayOfBoolean;
  }

  public static boolean[] a(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    return (boolean[])(boolean[])a(paramArrayOfBoolean, paramInt, Boolean.valueOf(paramBoolean), Boolean.TYPE);
  }

  public static boolean[] a(boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    return (boolean[])(boolean[])a(paramArrayOfBoolean, a(paramArrayOfInt));
  }

  public static int b(Object paramObject)
  {
    return new d().d(paramObject).c();
  }

  public static int b(byte[] paramArrayOfByte, byte paramByte)
  {
    return b(paramArrayOfByte, paramByte, 2147483647);
  }

  public static int b(byte[] paramArrayOfByte, byte paramByte, int paramInt)
  {
    if (paramArrayOfByte == null);
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfByte.length)
        paramInt = -1 + paramArrayOfByte.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramByte == paramArrayOfByte[i1])
          return i1;
    }
  }

  public static int b(char[] paramArrayOfChar, char paramChar)
  {
    return b(paramArrayOfChar, paramChar, 2147483647);
  }

  public static int b(char[] paramArrayOfChar, char paramChar, int paramInt)
  {
    if (paramArrayOfChar == null);
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfChar.length)
        paramInt = -1 + paramArrayOfChar.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramChar == paramArrayOfChar[i1])
          return i1;
    }
  }

  public static int b(double[] paramArrayOfDouble, double paramDouble)
  {
    return b(paramArrayOfDouble, paramDouble, 2147483647);
  }

  public static int b(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    return b(paramArrayOfDouble, paramDouble1, 2147483647, paramDouble2);
  }

  public static int b(double[] paramArrayOfDouble, double paramDouble, int paramInt)
  {
    if (e(paramArrayOfDouble));
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfDouble.length)
        paramInt = -1 + paramArrayOfDouble.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramDouble == paramArrayOfDouble[i1])
          return i1;
    }
  }

  public static int b(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2)
  {
    if (e(paramArrayOfDouble));
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfDouble.length)
        paramInt = -1 + paramArrayOfDouble.length;
      double d1 = paramDouble1 - paramDouble2;
      double d2 = paramDouble1 + paramDouble2;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if ((paramArrayOfDouble[i1] >= d1) && (paramArrayOfDouble[i1] <= d2))
          return i1;
    }
  }

  public static int b(float[] paramArrayOfFloat, float paramFloat)
  {
    return b(paramArrayOfFloat, paramFloat, 2147483647);
  }

  public static int b(float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (e(paramArrayOfFloat));
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfFloat.length)
        paramInt = -1 + paramArrayOfFloat.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramFloat == paramArrayOfFloat[i1])
          return i1;
    }
  }

  public static int b(int[] paramArrayOfInt, int paramInt)
  {
    return c(paramArrayOfInt, paramInt, 2147483647);
  }

  public static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    if (paramInt2 < 0);
    for (paramInt2 = 0; ; paramInt2++)
    {
      if (paramInt2 >= paramArrayOfInt.length)
        break label33;
      if (paramInt1 == paramArrayOfInt[paramInt2])
        break;
    }
    label33: return -1;
  }

  public static int b(long[] paramArrayOfLong, long paramLong)
  {
    return b(paramArrayOfLong, paramLong, 2147483647);
  }

  public static int b(long[] paramArrayOfLong, long paramLong, int paramInt)
  {
    if (paramArrayOfLong == null);
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfLong.length)
        paramInt = -1 + paramArrayOfLong.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramLong == paramArrayOfLong[i1])
          return i1;
    }
  }

  public static int b(Object[] paramArrayOfObject, Object paramObject)
  {
    return b(paramArrayOfObject, paramObject, 2147483647);
  }

  public static int b(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null);
    do
      return -1;
    while (paramInt < 0);
    if (paramInt >= paramArrayOfObject.length);
    for (int i1 = -1 + paramArrayOfObject.length; ; i1 = paramInt)
    {
      if (paramObject == null)
      {
        while (i1 >= 0)
        {
          if (paramArrayOfObject[i1] == null)
            return i1;
          i1--;
        }
        break;
      }
      if (!paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
        break;
      while (i1 >= 0)
      {
        if (paramObject.equals(paramArrayOfObject[i1]))
          return i1;
        i1--;
      }
      break;
    }
  }

  public static int b(short[] paramArrayOfShort, short paramShort)
  {
    return b(paramArrayOfShort, paramShort, 2147483647);
  }

  public static int b(short[] paramArrayOfShort, short paramShort, int paramInt)
  {
    if (paramArrayOfShort == null);
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfShort.length)
        paramInt = -1 + paramArrayOfShort.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramShort == paramArrayOfShort[i1])
          return i1;
    }
  }

  public static int b(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return b(paramArrayOfBoolean, paramBoolean, 2147483647);
  }

  public static int b(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt)
  {
    if (e(paramArrayOfBoolean));
    while (true)
    {
      return -1;
      if (paramInt < 0)
        continue;
      if (paramInt >= paramArrayOfBoolean.length)
        paramInt = -1 + paramArrayOfBoolean.length;
      for (int i1 = paramInt; i1 >= 0; i1--)
        if (paramBoolean == paramArrayOfBoolean[i1])
          return i1;
    }
  }

  public static boolean b(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
      throw new IllegalArgumentException("The Array must not be null");
    return paramObject1.getClass().getName().equals(paramObject2.getClass().getName());
  }

  public static byte[] b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      paramArrayOfByte = j;
    return paramArrayOfByte;
  }

  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null)
      return a(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
      return a(paramArrayOfByte1);
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }

  public static byte[] b(Byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    if (paramArrayOfByte.length == 0)
      return j;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
      arrayOfByte[i1] = paramArrayOfByte[i1].byteValue();
    return arrayOfByte;
  }

  public static char[] b(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
      paramArrayOfChar = r;
    return paramArrayOfChar;
  }

  public static char[] b(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1 == null)
      return a(paramArrayOfChar2);
    if (paramArrayOfChar2 == null)
      return a(paramArrayOfChar1);
    char[] arrayOfChar = new char[paramArrayOfChar1.length + paramArrayOfChar2.length];
    System.arraycopy(paramArrayOfChar1, 0, arrayOfChar, 0, paramArrayOfChar1.length);
    System.arraycopy(paramArrayOfChar2, 0, arrayOfChar, paramArrayOfChar1.length, paramArrayOfChar2.length);
    return arrayOfChar;
  }

  public static char[] b(Character[] paramArrayOfCharacter)
  {
    if (paramArrayOfCharacter == null)
      return null;
    if (paramArrayOfCharacter.length == 0)
      return r;
    char[] arrayOfChar = new char[paramArrayOfCharacter.length];
    for (int i1 = 0; i1 < paramArrayOfCharacter.length; i1++)
      arrayOfChar[i1] = paramArrayOfCharacter[i1].charValue();
    return arrayOfChar;
  }

  public static double[] b(double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
      paramArrayOfDouble = l;
    return paramArrayOfDouble;
  }

  public static double[] b(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (paramArrayOfDouble1 == null)
      return a(paramArrayOfDouble2);
    if (paramArrayOfDouble2 == null)
      return a(paramArrayOfDouble1);
    double[] arrayOfDouble = new double[paramArrayOfDouble1.length + paramArrayOfDouble2.length];
    System.arraycopy(paramArrayOfDouble1, 0, arrayOfDouble, 0, paramArrayOfDouble1.length);
    System.arraycopy(paramArrayOfDouble2, 0, arrayOfDouble, paramArrayOfDouble1.length, paramArrayOfDouble2.length);
    return arrayOfDouble;
  }

  public static double[] b(Double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      return null;
    if (paramArrayOfDouble.length == 0)
      return l;
    double[] arrayOfDouble = new double[paramArrayOfDouble.length];
    for (int i1 = 0; i1 < paramArrayOfDouble.length; i1++)
      arrayOfDouble[i1] = paramArrayOfDouble[i1].doubleValue();
    return arrayOfDouble;
  }

  public static float[] b(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
      paramArrayOfFloat = n;
    return paramArrayOfFloat;
  }

  public static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1 == null)
      return a(paramArrayOfFloat2);
    if (paramArrayOfFloat2 == null)
      return a(paramArrayOfFloat1);
    float[] arrayOfFloat = new float[paramArrayOfFloat1.length + paramArrayOfFloat2.length];
    System.arraycopy(paramArrayOfFloat1, 0, arrayOfFloat, 0, paramArrayOfFloat1.length);
    System.arraycopy(paramArrayOfFloat2, 0, arrayOfFloat, paramArrayOfFloat1.length, paramArrayOfFloat2.length);
    return arrayOfFloat;
  }

  public static float[] b(Float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      return null;
    if (paramArrayOfFloat.length == 0)
      return n;
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    for (int i1 = 0; i1 < paramArrayOfFloat.length; i1++)
      arrayOfFloat[i1] = paramArrayOfFloat[i1].floatValue();
    return arrayOfFloat;
  }

  public static int[] b(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      paramArrayOfInt = f;
    return paramArrayOfInt;
  }

  public static int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == null)
      return a(paramArrayOfInt2);
    if (paramArrayOfInt2 == null)
      return a(paramArrayOfInt1);
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
    System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, paramArrayOfInt1.length, paramArrayOfInt2.length);
    return arrayOfInt;
  }

  public static int[] b(Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger == null)
      return null;
    if (paramArrayOfInteger.length == 0)
      return f;
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    for (int i1 = 0; i1 < paramArrayOfInteger.length; i1++)
      arrayOfInt[i1] = paramArrayOfInteger[i1].intValue();
    return arrayOfInt;
  }

  public static long[] b(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
      paramArrayOfLong = d;
    return paramArrayOfLong;
  }

  public static long[] b(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == null)
      return a(paramArrayOfLong2);
    if (paramArrayOfLong2 == null)
      return a(paramArrayOfLong1);
    long[] arrayOfLong = new long[paramArrayOfLong1.length + paramArrayOfLong2.length];
    System.arraycopy(paramArrayOfLong1, 0, arrayOfLong, 0, paramArrayOfLong1.length);
    System.arraycopy(paramArrayOfLong2, 0, arrayOfLong, paramArrayOfLong1.length, paramArrayOfLong2.length);
    return arrayOfLong;
  }

  public static long[] b(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      return null;
    if (paramArrayOfLong.length == 0)
      return d;
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    for (int i1 = 0; i1 < paramArrayOfLong.length; i1++)
      arrayOfLong[i1] = paramArrayOfLong[i1].longValue();
    return arrayOfLong;
  }

  public static <T> T[] b(T[] paramArrayOfT)
  {
    return paramArrayOfT;
  }

  public static <T> T[] b(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    if (paramArrayOfT1 == null)
      return c(paramArrayOfT2);
    if (paramArrayOfT2 == null)
      return c(paramArrayOfT1);
    Class localClass1 = paramArrayOfT1.getClass().getComponentType();
    Object[] arrayOfObject = (Object[])(Object[])Array.newInstance(localClass1, paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    try
    {
      System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
      return arrayOfObject;
    }
    catch (ArrayStoreException localArrayStoreException)
    {
      Class localClass2 = paramArrayOfT2.getClass().getComponentType();
      if (!localClass1.isAssignableFrom(localClass2))
        throw new IllegalArgumentException("Cannot store " + localClass2.getName() + " in an array of " + localClass1.getName(), localArrayStoreException);
    }
    throw localArrayStoreException;
  }

  public static short[] b(Short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      return null;
    if (paramArrayOfShort.length == 0)
      return h;
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    for (int i1 = 0; i1 < paramArrayOfShort.length; i1++)
      arrayOfShort[i1] = paramArrayOfShort[i1].shortValue();
    return arrayOfShort;
  }

  public static short[] b(short[] paramArrayOfShort)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
      paramArrayOfShort = h;
    return paramArrayOfShort;
  }

  public static short[] b(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1 == null)
      return a(paramArrayOfShort2);
    if (paramArrayOfShort2 == null)
      return a(paramArrayOfShort1);
    short[] arrayOfShort = new short[paramArrayOfShort1.length + paramArrayOfShort2.length];
    System.arraycopy(paramArrayOfShort1, 0, arrayOfShort, 0, paramArrayOfShort1.length);
    System.arraycopy(paramArrayOfShort2, 0, arrayOfShort, paramArrayOfShort1.length, paramArrayOfShort2.length);
    return arrayOfShort;
  }

  public static boolean[] b(Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      return null;
    if (paramArrayOfBoolean.length == 0)
      return p;
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
    for (int i1 = 0; i1 < paramArrayOfBoolean.length; i1++)
      arrayOfBoolean[i1] = paramArrayOfBoolean[i1].booleanValue();
    return arrayOfBoolean;
  }

  public static boolean[] b(boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0))
      paramArrayOfBoolean = p;
    return paramArrayOfBoolean;
  }

  public static boolean[] b(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (paramArrayOfBoolean1 == null)
      return a(paramArrayOfBoolean2);
    if (paramArrayOfBoolean2 == null)
      return a(paramArrayOfBoolean1);
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean1.length + paramArrayOfBoolean2.length];
    System.arraycopy(paramArrayOfBoolean1, 0, arrayOfBoolean, 0, paramArrayOfBoolean1.length);
    System.arraycopy(paramArrayOfBoolean2, 0, arrayOfBoolean, paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
    return arrayOfBoolean;
  }

  public static int c(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return Array.getLength(paramObject);
  }

  public static int c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return -1;
      if (paramInt2 < 0)
        continue;
      if (paramInt2 >= paramArrayOfInt.length)
        paramInt2 = -1 + paramArrayOfInt.length;
      for (int i1 = paramInt2; i1 >= 0; i1--)
        if (paramInt1 == paramArrayOfInt[i1])
          return i1;
    }
  }

  public static void c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfByte.length;
      while (i2 > i1)
      {
        int i3 = paramArrayOfByte[i2];
        paramArrayOfByte[i2] = paramArrayOfByte[i1];
        paramArrayOfByte[i1] = i3;
        i2--;
        i1++;
      }
    }
  }

  public static void c(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfChar.length;
      while (i2 > i1)
      {
        int i3 = paramArrayOfChar[i2];
        paramArrayOfChar[i2] = paramArrayOfChar[i1];
        paramArrayOfChar[i1] = i3;
        i2--;
        i1++;
      }
    }
  }

  public static void c(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfDouble.length;
      while (i2 > i1)
      {
        double d1 = paramArrayOfDouble[i2];
        paramArrayOfDouble[i2] = paramArrayOfDouble[i1];
        paramArrayOfDouble[i1] = d1;
        i2--;
        i1++;
      }
    }
  }

  public static void c(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfFloat.length;
      while (i2 > i1)
      {
        float f1 = paramArrayOfFloat[i2];
        paramArrayOfFloat[i2] = paramArrayOfFloat[i1];
        paramArrayOfFloat[i1] = f1;
        i2--;
        i1++;
      }
    }
  }

  public static void c(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfInt.length;
      while (i2 > i1)
      {
        int i3 = paramArrayOfInt[i2];
        paramArrayOfInt[i2] = paramArrayOfInt[i1];
        paramArrayOfInt[i1] = i3;
        i2--;
        i1++;
      }
    }
  }

  public static void c(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfLong.length;
      while (i2 > i1)
      {
        long l1 = paramArrayOfLong[i2];
        paramArrayOfLong[i2] = paramArrayOfLong[i1];
        paramArrayOfLong[i1] = l1;
        i2--;
        i1++;
      }
    }
  }

  public static void c(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfShort.length;
      while (i2 > i1)
      {
        int i3 = paramArrayOfShort[i2];
        paramArrayOfShort[i2] = paramArrayOfShort[i1];
        paramArrayOfShort[i1] = i3;
        i2--;
        i1++;
      }
    }
  }

  public static void c(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfBoolean.length;
      while (i2 > i1)
      {
        int i3 = paramArrayOfBoolean[i2];
        paramArrayOfBoolean[i2] = paramArrayOfBoolean[i1];
        paramArrayOfBoolean[i1] = i3;
        i2--;
        i1++;
      }
    }
  }

  public static boolean c(byte[] paramArrayOfByte, byte paramByte)
  {
    return a(paramArrayOfByte, paramByte) != -1;
  }

  public static boolean c(char[] paramArrayOfChar, char paramChar)
  {
    return a(paramArrayOfChar, paramChar) != -1;
  }

  public static boolean c(double[] paramArrayOfDouble, double paramDouble)
  {
    return a(paramArrayOfDouble, paramDouble) != -1;
  }

  public static boolean c(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    int i1 = a(paramArrayOfDouble, paramDouble1, 0, paramDouble2);
    int i2 = 0;
    if (i1 != -1)
      i2 = 1;
    return i2;
  }

  public static boolean c(float[] paramArrayOfFloat, float paramFloat)
  {
    return a(paramArrayOfFloat, paramFloat) != -1;
  }

  public static boolean c(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt) != -1;
  }

  public static boolean c(long[] paramArrayOfLong, long paramLong)
  {
    return a(paramArrayOfLong, paramLong) != -1;
  }

  public static boolean c(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject) != -1;
  }

  public static boolean c(short[] paramArrayOfShort, short paramShort)
  {
    return a(paramArrayOfShort, paramShort) != -1;
  }

  public static boolean c(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return a(paramArrayOfBoolean, paramBoolean) != -1;
  }

  public static byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((e(paramArrayOfByte1)) || (e(paramArrayOfByte2)))
      return a(paramArrayOfByte1);
    HashMap localHashMap = new HashMap(paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Byte localByte2 = Byte.valueOf(paramArrayOfByte2[i2]);
      f localf = (f)localHashMap.get(localByte2);
      if (localf == null)
        localHashMap.put(localByte2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Byte localByte1 = (Byte)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfByte1, localByte1.byteValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfByte1, a(localHashSet));
  }

  public static char[] c(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if ((e(paramArrayOfChar1)) || (e(paramArrayOfChar2)))
      return a(paramArrayOfChar1);
    HashMap localHashMap = new HashMap(paramArrayOfChar2.length);
    int i1 = paramArrayOfChar2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Character localCharacter2 = Character.valueOf(paramArrayOfChar2[i2]);
      f localf = (f)localHashMap.get(localCharacter2);
      if (localf == null)
        localHashMap.put(localCharacter2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Character localCharacter1 = (Character)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfChar1, localCharacter1.charValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfChar1, a(localHashSet));
  }

  public static double[] c(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if ((e(paramArrayOfDouble1)) || (e(paramArrayOfDouble2)))
      return a(paramArrayOfDouble1);
    HashMap localHashMap = new HashMap(paramArrayOfDouble2.length);
    int i1 = paramArrayOfDouble2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Double localDouble2 = Double.valueOf(paramArrayOfDouble2[i2]);
      f localf = (f)localHashMap.get(localDouble2);
      if (localf == null)
        localHashMap.put(localDouble2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Double localDouble1 = (Double)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfDouble1, localDouble1.doubleValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfDouble1, a(localHashSet));
  }

  public static float[] c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((e(paramArrayOfFloat1)) || (e(paramArrayOfFloat2)))
      return a(paramArrayOfFloat1);
    HashMap localHashMap = new HashMap(paramArrayOfFloat2.length);
    int i1 = paramArrayOfFloat2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Float localFloat2 = Float.valueOf(paramArrayOfFloat2[i2]);
      f localf = (f)localHashMap.get(localFloat2);
      if (localf == null)
        localHashMap.put(localFloat2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Float localFloat1 = (Float)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfFloat1, localFloat1.floatValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfFloat1, a(localHashSet));
  }

  public static int[] c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return (int[])(int[])a(paramArrayOfInt1, a(paramArrayOfInt2));
  }

  public static long[] c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((e(paramArrayOfLong1)) || (e(paramArrayOfLong2)))
      return a(paramArrayOfLong1);
    HashMap localHashMap = new HashMap(paramArrayOfLong2.length);
    int i1 = paramArrayOfLong2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Long localLong2 = Long.valueOf(paramArrayOfLong2[i2]);
      f localf = (f)localHashMap.get(localLong2);
      if (localf == null)
        localHashMap.put(localLong2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong1 = (Long)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfLong1, localLong1.longValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfLong1, a(localHashSet));
  }

  public static <T> T[] c(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null)
      return null;
    return (Object[])paramArrayOfT.clone();
  }

  public static <T> T[] c(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    if ((f(paramArrayOfT1)) || (f(paramArrayOfT2)))
      return c(paramArrayOfT1);
    HashMap localHashMap = new HashMap(paramArrayOfT2.length);
    int i1 = paramArrayOfT2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      T ? = paramArrayOfT2[i2];
      f localf = (f)localHashMap.get(?);
      if (localf == null)
        localHashMap.put(?, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label207: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label207;
        int i6 = a(paramArrayOfT1, localObject, i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfT1, a(localHashSet));
  }

  public static short[] c(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if ((e(paramArrayOfShort1)) || (e(paramArrayOfShort2)))
      return a(paramArrayOfShort1);
    HashMap localHashMap = new HashMap(paramArrayOfShort2.length);
    int i1 = paramArrayOfShort2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Short localShort2 = Short.valueOf(paramArrayOfShort2[i2]);
      f localf = (f)localHashMap.get(localShort2);
      if (localf == null)
        localHashMap.put(localShort2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Short localShort1 = (Short)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfShort1, localShort1.shortValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfShort1, a(localHashSet));
  }

  public static boolean[] c(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if ((e(paramArrayOfBoolean1)) || (e(paramArrayOfBoolean2)))
      return a(paramArrayOfBoolean1);
    HashMap localHashMap = new HashMap(paramArrayOfBoolean2.length);
    int i1 = paramArrayOfBoolean2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Boolean localBoolean2 = Boolean.valueOf(paramArrayOfBoolean2[i2]);
      f localf = (f)localHashMap.get(localBoolean2);
      if (localf == null)
        localHashMap.put(localBoolean2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Boolean localBoolean1 = (Boolean)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = a(paramArrayOfBoolean1, localBoolean1.booleanValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return a(paramArrayOfBoolean1, a(localHashSet));
  }

  public static byte[] d(byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte = (byte[])(byte[])a(paramArrayOfByte, Byte.TYPE);
    arrayOfByte[(-1 + arrayOfByte.length)] = paramByte;
    return arrayOfByte;
  }

  public static char[] d(char[] paramArrayOfChar, char paramChar)
  {
    char[] arrayOfChar = (char[])(char[])a(paramArrayOfChar, Character.TYPE);
    arrayOfChar[(-1 + arrayOfChar.length)] = paramChar;
    return arrayOfChar;
  }

  public static double[] d(double[] paramArrayOfDouble, double paramDouble)
  {
    double[] arrayOfDouble = (double[])(double[])a(paramArrayOfDouble, Double.TYPE);
    arrayOfDouble[(-1 + arrayOfDouble.length)] = paramDouble;
    return arrayOfDouble;
  }

  public static float[] d(float[] paramArrayOfFloat, float paramFloat)
  {
    float[] arrayOfFloat = (float[])(float[])a(paramArrayOfFloat, Float.TYPE);
    arrayOfFloat[(-1 + arrayOfFloat.length)] = paramFloat;
    return arrayOfFloat;
  }

  public static int[] d(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = (int[])(int[])a(paramArrayOfInt, Integer.TYPE);
    arrayOfInt[(-1 + arrayOfInt.length)] = paramInt;
    return arrayOfInt;
  }

  public static int[] d(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return (int[])(int[])a(paramArrayOfInt, paramInt1, Integer.valueOf(paramInt2), Integer.TYPE);
  }

  public static int[] d(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((e(paramArrayOfInt1)) || (e(paramArrayOfInt2)))
      return a(paramArrayOfInt1);
    HashMap localHashMap = new HashMap(paramArrayOfInt2.length);
    int i1 = paramArrayOfInt2.length;
    int i2 = 0;
    if (i2 < i1)
    {
      Integer localInteger2 = Integer.valueOf(paramArrayOfInt2[i2]);
      f localf = (f)localHashMap.get(localInteger2);
      if (localf == null)
        localHashMap.put(localInteger2, new f(1));
      while (true)
      {
        i2++;
        break;
        localf.c();
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localHashMap.entrySet().iterator();
    label216: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Integer localInteger1 = (Integer)localEntry.getKey();
      int i3 = ((f)localEntry.getValue()).intValue();
      int i4 = 0;
      int i5 = 0;
      while (true)
      {
        if (i4 >= i3)
          break label216;
        int i6 = b(paramArrayOfInt1, localInteger1.intValue(), i5);
        if (i6 < 0)
          break;
        i5 = i6 + 1;
        localHashSet.add(Integer.valueOf(i6));
        i4++;
      }
    }
    return c(paramArrayOfInt1, a(localHashSet));
  }

  public static long[] d(long[] paramArrayOfLong, long paramLong)
  {
    long[] arrayOfLong = (long[])(long[])a(paramArrayOfLong, Long.TYPE);
    arrayOfLong[(-1 + arrayOfLong.length)] = paramLong;
    return arrayOfLong;
  }

  public static Boolean[] d(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      return null;
    if (paramArrayOfBoolean.length == 0)
      return q;
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    int i1 = 0;
    if (i1 < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[i1] != 0);
      for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
      {
        arrayOfBoolean[i1] = localBoolean;
        i1++;
        break;
      }
    }
    return arrayOfBoolean;
  }

  public static Byte[] d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    if (paramArrayOfByte.length == 0)
      return k;
    Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
      arrayOfByte[i1] = Byte.valueOf(paramArrayOfByte[i1]);
    return arrayOfByte;
  }

  public static Character[] d(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      return null;
    if (paramArrayOfChar.length == 0)
      return s;
    Character[] arrayOfCharacter = new Character[paramArrayOfChar.length];
    for (int i1 = 0; i1 < paramArrayOfChar.length; i1++)
      arrayOfCharacter[i1] = Character.valueOf(paramArrayOfChar[i1]);
    return arrayOfCharacter;
  }

  public static Double[] d(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      return null;
    if (paramArrayOfDouble.length == 0)
      return m;
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    for (int i1 = 0; i1 < paramArrayOfDouble.length; i1++)
      arrayOfDouble[i1] = Double.valueOf(paramArrayOfDouble[i1]);
    return arrayOfDouble;
  }

  public static Float[] d(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      return null;
    if (paramArrayOfFloat.length == 0)
      return o;
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    for (int i1 = 0; i1 < paramArrayOfFloat.length; i1++)
      arrayOfFloat[i1] = Float.valueOf(paramArrayOfFloat[i1]);
    return arrayOfFloat;
  }

  public static Integer[] d(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return null;
    if (paramArrayOfInt.length == 0)
      return g;
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    for (int i1 = 0; i1 < paramArrayOfInt.length; i1++)
      arrayOfInteger[i1] = Integer.valueOf(paramArrayOfInt[i1]);
    return arrayOfInteger;
  }

  public static Long[] d(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      return null;
    if (paramArrayOfLong.length == 0)
      return e;
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    for (int i1 = 0; i1 < paramArrayOfLong.length; i1++)
      arrayOfLong[i1] = Long.valueOf(paramArrayOfLong[i1]);
    return arrayOfLong;
  }

  public static Object[] d(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
      paramArrayOfObject = a;
    return paramArrayOfObject;
  }

  public static <T> T[] d(T[] paramArrayOfT, T paramT)
  {
    if (paramArrayOfT != null);
    for (Class localClass = paramArrayOfT.getClass(); ; localClass = paramT.getClass())
    {
      Object[] arrayOfObject = (Object[])(Object[])a(paramArrayOfT, localClass);
      arrayOfObject[(-1 + arrayOfObject.length)] = paramT;
      return arrayOfObject;
      if (paramT == null)
        break;
    }
    throw new IllegalArgumentException("Arguments cannot both be null");
  }

  public static Short[] d(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      return null;
    if (paramArrayOfShort.length == 0)
      return i;
    Short[] arrayOfShort = new Short[paramArrayOfShort.length];
    for (int i1 = 0; i1 < paramArrayOfShort.length; i1++)
      arrayOfShort[i1] = Short.valueOf(paramArrayOfShort[i1]);
    return arrayOfShort;
  }

  public static short[] d(short[] paramArrayOfShort, short paramShort)
  {
    short[] arrayOfShort = (short[])(short[])a(paramArrayOfShort, Short.TYPE);
    arrayOfShort[(-1 + arrayOfShort.length)] = paramShort;
    return arrayOfShort;
  }

  public static boolean[] d(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    boolean[] arrayOfBoolean = (boolean[])(boolean[])a(paramArrayOfBoolean, Boolean.TYPE);
    arrayOfBoolean[(-1 + arrayOfBoolean.length)] = paramBoolean;
    return arrayOfBoolean;
  }

  public static void e(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null);
    while (true)
    {
      return;
      int i1 = 0;
      int i2 = -1 + paramArrayOfObject.length;
      while (i2 > i1)
      {
        Object localObject = paramArrayOfObject[i2];
        paramArrayOfObject[i2] = paramArrayOfObject[i1];
        paramArrayOfObject[i1] = localObject;
        i2--;
        i1++;
      }
    }
  }

  public static boolean e(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }

  public static boolean e(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }

  public static boolean e(double[] paramArrayOfDouble)
  {
    return (paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0);
  }

  public static boolean e(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
  }

  public static boolean e(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }

  public static boolean e(long[] paramArrayOfLong)
  {
    return (paramArrayOfLong == null) || (paramArrayOfLong.length == 0);
  }

  public static boolean e(short[] paramArrayOfShort)
  {
    return (paramArrayOfShort == null) || (paramArrayOfShort.length == 0);
  }

  public static boolean e(boolean[] paramArrayOfBoolean)
  {
    return (paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0);
  }

  public static byte[] e(byte[] paramArrayOfByte, byte paramByte)
  {
    int i1 = a(paramArrayOfByte, paramByte);
    if (i1 == -1)
      return a(paramArrayOfByte);
    return a(paramArrayOfByte, i1);
  }

  public static char[] e(char[] paramArrayOfChar, char paramChar)
  {
    int i1 = a(paramArrayOfChar, paramChar);
    if (i1 == -1)
      return a(paramArrayOfChar);
    return a(paramArrayOfChar, i1);
  }

  public static double[] e(double[] paramArrayOfDouble, double paramDouble)
  {
    int i1 = a(paramArrayOfDouble, paramDouble);
    if (i1 == -1)
      return a(paramArrayOfDouble);
    return a(paramArrayOfDouble, i1);
  }

  public static float[] e(float[] paramArrayOfFloat, float paramFloat)
  {
    int i1 = a(paramArrayOfFloat, paramFloat);
    if (i1 == -1)
      return a(paramArrayOfFloat);
    return a(paramArrayOfFloat, i1);
  }

  public static int[] e(int[] paramArrayOfInt, int paramInt)
  {
    return (int[])(int[])a(paramArrayOfInt, paramInt);
  }

  public static long[] e(long[] paramArrayOfLong, long paramLong)
  {
    int i1 = a(paramArrayOfLong, paramLong);
    if (i1 == -1)
      return a(paramArrayOfLong);
    return a(paramArrayOfLong, i1);
  }

  public static <T> T[] e(T[] paramArrayOfT, Object paramObject)
  {
    int i1 = a(paramArrayOfT, paramObject);
    if (i1 == -1)
      return c(paramArrayOfT);
    return a(paramArrayOfT, i1);
  }

  public static short[] e(short[] paramArrayOfShort, short paramShort)
  {
    int i1 = a(paramArrayOfShort, paramShort);
    if (i1 == -1)
      return a(paramArrayOfShort);
    return a(paramArrayOfShort, i1);
  }

  public static boolean[] e(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int i1 = a(paramArrayOfBoolean, paramBoolean);
    if (i1 == -1)
      return a(paramArrayOfBoolean);
    return a(paramArrayOfBoolean, i1);
  }

  public static boolean f(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length != 0);
  }

  public static boolean f(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar != null) && (paramArrayOfChar.length != 0);
  }

  public static boolean f(double[] paramArrayOfDouble)
  {
    return (paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0);
  }

  public static boolean f(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0);
  }

  public static boolean f(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length != 0);
  }

  public static boolean f(long[] paramArrayOfLong)
  {
    return (paramArrayOfLong != null) && (paramArrayOfLong.length != 0);
  }

  public static boolean f(Object[] paramArrayOfObject)
  {
    return (paramArrayOfObject == null) || (paramArrayOfObject.length == 0);
  }

  public static boolean f(short[] paramArrayOfShort)
  {
    return (paramArrayOfShort != null) && (paramArrayOfShort.length != 0);
  }

  public static boolean f(boolean[] paramArrayOfBoolean)
  {
    return (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length != 0);
  }

  public static int[] f(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = a(paramArrayOfInt, paramInt);
    if (i1 == -1)
      return a(paramArrayOfInt);
    return e(paramArrayOfInt, i1);
  }

  public static <T> boolean g(T[] paramArrayOfT)
  {
    return (paramArrayOfT != null) && (paramArrayOfT.length != 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.c
 * JD-Core Version:    0.6.0
 */