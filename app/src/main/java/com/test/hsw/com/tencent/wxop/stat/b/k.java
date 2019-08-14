package com.tencent.wxop.stat.b;

final class k extends i
{
  private static final byte[] cM;
  private static final byte[] cN;
  public final boolean ba = true;
  public final boolean bb = true;
  private final byte[] cO = new byte[2];
  public final boolean cP = false;
  private final byte[] cQ = cM;
  private int cc;
  int cp = 0;

  static
  {
    if (!h.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      ad = bool;
      cM = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      cN = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      return;
    }
  }

  public k()
  {
    this.cI = null;
    if (this.bb);
    for (int i = 19; ; i = -1)
    {
      this.cc = i;
      return;
    }
  }

  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = this.cQ;
    byte[] arrayOfByte2 = this.cI;
    int i = this.cc;
    int j = paramInt + 0;
    int m;
    int n;
    label58: int i32;
    int i33;
    int i2;
    int i1;
    switch (this.cp)
    {
    default:
      m = -1;
      n = 0;
      if (m != -1)
      {
        arrayOfByte2[0] = arrayOfByte1[(0x3F & m >> 18)];
        arrayOfByte2[1] = arrayOfByte1[(0x3F & m >> 12)];
        arrayOfByte2[2] = arrayOfByte1[(0x3F & m >> 6)];
        i32 = 4;
        arrayOfByte2[3] = arrayOfByte1[(m & 0x3F)];
        i33 = i - 1;
        if (i33 != 0)
          break;
        if (this.cP)
        {
          i32 = 5;
          arrayOfByte2[4] = 13;
        }
        i2 = i32 + 1;
        arrayOfByte2[i32] = 10;
        i1 = 19;
      }
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      label164: int i28;
      int i29;
      int i30;
      int i31;
      if (n + 3 <= j)
      {
        int i27 = (0xFF & paramArrayOfByte[n]) << 16 | (0xFF & paramArrayOfByte[(n + 1)]) << 8 | 0xFF & paramArrayOfByte[(n + 2)];
        arrayOfByte2[i2] = arrayOfByte1[(0x3F & i27 >> 18)];
        arrayOfByte2[(i2 + 1)] = arrayOfByte1[(0x3F & i27 >> 12)];
        arrayOfByte2[(i2 + 2)] = arrayOfByte1[(0x3F & i27 >> 6)];
        arrayOfByte2[(i2 + 3)] = arrayOfByte1[(i27 & 0x3F)];
        i28 = n + 3;
        i29 = i2 + 4;
        i30 = i1 - 1;
        if (i30 != 0)
          break label1067;
        if (!this.cP)
          break label1060;
        i31 = i29 + 1;
        arrayOfByte2[i29] = 13;
      }
      while (true)
      {
        i2 = i31 + 1;
        arrayOfByte2[i31] = 10;
        n = i28;
        i1 = 19;
        break label164;
        m = -1;
        n = 0;
        break label58;
        if (2 > j)
          break;
        int i34 = (0xFF & this.cO[0]) << 16 | (0xFF & paramArrayOfByte[0]) << 8 | 0xFF & paramArrayOfByte[1];
        this.cp = 0;
        m = i34;
        n = 2;
        break label58;
        if (j <= 0)
          break;
        int k = (0xFF & this.cO[0]) << 16 | (0xFF & this.cO[1]) << 8 | 0xFF & paramArrayOfByte[0];
        this.cp = 0;
        m = k;
        n = 1;
        break label58;
        if (n - this.cp == j - 1)
        {
          int i19;
          if (this.cp > 0)
            i19 = this.cO[0];
          for (int i20 = 1; ; i20 = 0)
          {
            int i21 = (i19 & 0xFF) << 4;
            this.cp -= i20;
            int i22 = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(0x3F & i21 >> 6)];
            int i23 = i22 + 1;
            arrayOfByte2[i22] = arrayOfByte1[(i21 & 0x3F)];
            if (this.ba)
            {
              int i26 = i23 + 1;
              arrayOfByte2[i23] = 61;
              i23 = i26 + 1;
              arrayOfByte2[i26] = 61;
            }
            if (this.bb)
            {
              if (this.cP)
              {
                int i25 = i23 + 1;
                arrayOfByte2[i23] = 13;
                i23 = i25;
              }
              int i24 = i23 + 1;
              arrayOfByte2[i23] = 10;
              i23 = i24;
            }
            i2 = i23;
            if ((ad) || (this.cp == 0))
              break;
            throw new AssertionError();
            int i18 = n + 1;
            i19 = paramArrayOfByte[n];
            n = i18;
          }
        }
        int i5;
        int i6;
        label715: int i9;
        label756: int i13;
        int i14;
        if (n - this.cp == j - 2)
          if (this.cp > 1)
          {
            i5 = this.cO[0];
            i6 = 1;
            int i7 = (i5 & 0xFF) << 10;
            if (this.cp <= 0)
              break label937;
            byte[] arrayOfByte3 = this.cO;
            int i17 = i6 + 1;
            i9 = arrayOfByte3[i6];
            i6 = i17;
            int i10 = i7 | (i9 & 0xFF) << 2;
            this.cp -= i6;
            int i11 = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(0x3F & i10 >> 12)];
            int i12 = i11 + 1;
            arrayOfByte2[i11] = arrayOfByte1[(0x3F & i10 >> 6)];
            i13 = i12 + 1;
            arrayOfByte2[i12] = arrayOfByte1[(i10 & 0x3F)];
            if (!this.ba)
              break label1053;
            i14 = i13 + 1;
            arrayOfByte2[i13] = 61;
          }
        while (true)
        {
          if (this.bb)
          {
            if (this.cP)
            {
              int i16 = i14 + 1;
              arrayOfByte2[i14] = 13;
              i14 = i16;
            }
            int i15 = i14 + 1;
            arrayOfByte2[i14] = 10;
            i14 = i15;
          }
          i2 = i14;
          break;
          int i4 = n + 1;
          i5 = paramArrayOfByte[n];
          n = i4;
          i6 = 0;
          break label715;
          label937: int i8 = n + 1;
          i9 = paramArrayOfByte[n];
          n = i8;
          break label756;
          if ((!this.bb) || (i2 <= 0) || (i1 == 19))
            break;
          int i3;
          if (this.cP)
          {
            i3 = i2 + 1;
            arrayOfByte2[i2] = 13;
          }
          while (true)
          {
            i2 = i3 + 1;
            arrayOfByte2[i3] = 10;
            break;
            if ((!ad) && (n != j))
              throw new AssertionError();
            this.g = i2;
            this.cc = i1;
            return true;
            i3 = i2;
          }
          label1053: i14 = i13;
        }
        label1060: i31 = i29;
      }
      label1067: i1 = i30;
      i2 = i29;
      n = i28;
      continue;
      i1 = i33;
      i2 = i32;
      continue;
      i1 = i;
      i2 = 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.k
 * JD-Core Version:    0.6.0
 */