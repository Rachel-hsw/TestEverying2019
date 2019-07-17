package com.tencent.wxop.stat.b;

final class j extends i
{
  private static final int[] cJ = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] cK = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int bf;
  private final int[] cL;
  private int cu;

  public j(byte[] paramArrayOfByte)
  {
    this.cI = paramArrayOfByte;
    this.cL = cJ;
    this.cu = 0;
    this.bf = 0;
  }

  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.cu == 6)
      return false;
    int i = paramInt + 0;
    int j = this.cu;
    int k = this.bf;
    byte[] arrayOfByte = this.cI;
    int[] arrayOfInt = this.cL;
    int m = 0;
    int n = j;
    int i1 = 0;
    if (m < i)
      if (n == 0)
      {
        while (m + 4 <= i)
        {
          k = arrayOfInt[(0xFF & paramArrayOfByte[m])] << 18 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 1)])] << 12 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 2)])] << 6 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 3)])];
          if (k < 0)
            break;
          arrayOfByte[(i1 + 2)] = (byte)k;
          arrayOfByte[(i1 + 1)] = (byte)(k >> 8);
          arrayOfByte[i1] = (byte)(k >> 16);
          i1 += 3;
          m += 4;
        }
        if (m >= i);
      }
      else
      {
        int i5 = m + 1;
        int i6 = arrayOfInt[(0xFF & paramArrayOfByte[m])];
        switch (n)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    m = i5;
                    break;
                    if (i6 < 0)
                      continue;
                    n++;
                    k = i6;
                    m = i5;
                    break;
                  }
                  while (i6 == -1);
                  this.cu = 6;
                  return false;
                  if (i6 < 0)
                    continue;
                  k = i6 | k << 6;
                  n++;
                  m = i5;
                  break;
                }
                while (i6 == -1);
                this.cu = 6;
                return false;
                if (i6 >= 0)
                {
                  k = i6 | k << 6;
                  n++;
                  m = i5;
                  break;
                }
                if (i6 != -2)
                  continue;
                int i7 = i1 + 1;
                arrayOfByte[i1] = (byte)(k >> 4);
                n = 4;
                i1 = i7;
                m = i5;
                break;
              }
              while (i6 == -1);
              this.cu = 6;
              return false;
              if (i6 >= 0)
              {
                k = i6 | k << 6;
                arrayOfByte[(i1 + 2)] = (byte)k;
                arrayOfByte[(i1 + 1)] = (byte)(k >> 8);
                arrayOfByte[i1] = (byte)(k >> 16);
                i1 += 3;
                m = i5;
                n = 0;
                break;
              }
              if (i6 != -2)
                continue;
              arrayOfByte[(i1 + 1)] = (byte)(k >> 2);
              arrayOfByte[i1] = (byte)(k >> 10);
              i1 += 2;
              n = 5;
              m = i5;
              break;
            }
            while (i6 == -1);
            this.cu = 6;
            return false;
            if (i6 != -2)
              continue;
            n++;
            m = i5;
            break;
          }
          while (i6 == -1);
          this.cu = 6;
          return false;
        }
        while (i6 == -1);
        this.cu = 6;
        return false;
      }
    int i2 = k;
    switch (n)
    {
    case 0:
    default:
    case 1:
    case 2:
    case 3:
      while (true)
      {
        this.cu = n;
        this.g = i1;
        return true;
        this.cu = 6;
        return false;
        int i4 = i1 + 1;
        arrayOfByte[i1] = (byte)(i2 >> 4);
        i1 = i4;
        continue;
        int i3 = i1 + 1;
        arrayOfByte[i1] = (byte)(i2 >> 10);
        i1 = i3 + 1;
        arrayOfByte[i3] = (byte)(i2 >> 2);
      }
    case 4:
    }
    this.cu = 6;
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.j
 * JD-Core Version:    0.6.0
 */