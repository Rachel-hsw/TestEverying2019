package android.support.v4.util;

class ContainerHelpers
{
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];

  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = paramArrayOfInt[k];
      if (m < paramInt2)
      {
        i = k + 1;
        continue;
      }
      if (m > paramInt2)
      {
        j = k - 1;
        continue;
      }
      return k;
    }
    return i ^ 0xFFFFFFFF;
  }

  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = 0;
    int j = paramInt - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      long l = paramArrayOfLong[k];
      if (l < paramLong)
      {
        i = k + 1;
        continue;
      }
      if (l > paramLong)
      {
        j = k - 1;
        continue;
      }
      return k;
    }
    return i ^ 0xFFFFFFFF;
  }

  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int idealByteArraySize(int paramInt)
  {
    for (int i = 4; ; i++)
    {
      if (i < 32)
      {
        if (paramInt > -12 + (1 << i))
          continue;
        paramInt = -12 + (1 << i);
      }
      return paramInt;
    }
  }

  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }

  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.ContainerHelpers
 * JD-Core Version:    0.6.0
 */