package com.umeng.message.b;

import java.math.BigInteger;

public class dh extends di
{
  static final byte[] a = { 13, 10 };
  private static final int m = 6;
  private static final int n = 3;
  private static final int o = 4;
  private static final byte[] p = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] q = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] r;
  private static final int s = 63;
  private final byte[] t;
  private final byte[] u;
  private final byte[] v;
  private final int w;
  private final int x;
  private int y;

  static
  {
    byte[] arrayOfByte = new byte[123];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = -1;
    arrayOfByte[2] = -1;
    arrayOfByte[3] = -1;
    arrayOfByte[4] = -1;
    arrayOfByte[5] = -1;
    arrayOfByte[6] = -1;
    arrayOfByte[7] = -1;
    arrayOfByte[8] = -1;
    arrayOfByte[9] = -1;
    arrayOfByte[10] = -1;
    arrayOfByte[11] = -1;
    arrayOfByte[12] = -1;
    arrayOfByte[13] = -1;
    arrayOfByte[14] = -1;
    arrayOfByte[15] = -1;
    arrayOfByte[16] = -1;
    arrayOfByte[17] = -1;
    arrayOfByte[18] = -1;
    arrayOfByte[19] = -1;
    arrayOfByte[20] = -1;
    arrayOfByte[21] = -1;
    arrayOfByte[22] = -1;
    arrayOfByte[23] = -1;
    arrayOfByte[24] = -1;
    arrayOfByte[25] = -1;
    arrayOfByte[26] = -1;
    arrayOfByte[27] = -1;
    arrayOfByte[28] = -1;
    arrayOfByte[29] = -1;
    arrayOfByte[30] = -1;
    arrayOfByte[31] = -1;
    arrayOfByte[32] = -1;
    arrayOfByte[33] = -1;
    arrayOfByte[34] = -1;
    arrayOfByte[35] = -1;
    arrayOfByte[36] = -1;
    arrayOfByte[37] = -1;
    arrayOfByte[38] = -1;
    arrayOfByte[39] = -1;
    arrayOfByte[40] = -1;
    arrayOfByte[41] = -1;
    arrayOfByte[42] = -1;
    arrayOfByte[43] = 62;
    arrayOfByte[44] = -1;
    arrayOfByte[45] = 62;
    arrayOfByte[46] = -1;
    arrayOfByte[47] = 63;
    arrayOfByte[48] = 52;
    arrayOfByte[49] = 53;
    arrayOfByte[50] = 54;
    arrayOfByte[51] = 55;
    arrayOfByte[52] = 56;
    arrayOfByte[53] = 57;
    arrayOfByte[54] = 58;
    arrayOfByte[55] = 59;
    arrayOfByte[56] = 60;
    arrayOfByte[57] = 61;
    arrayOfByte[58] = -1;
    arrayOfByte[59] = -1;
    arrayOfByte[60] = -1;
    arrayOfByte[61] = -1;
    arrayOfByte[62] = -1;
    arrayOfByte[63] = -1;
    arrayOfByte[64] = -1;
    arrayOfByte[66] = 1;
    arrayOfByte[67] = 2;
    arrayOfByte[68] = 3;
    arrayOfByte[69] = 4;
    arrayOfByte[70] = 5;
    arrayOfByte[71] = 6;
    arrayOfByte[72] = 7;
    arrayOfByte[73] = 8;
    arrayOfByte[74] = 9;
    arrayOfByte[75] = 10;
    arrayOfByte[76] = 11;
    arrayOfByte[77] = 12;
    arrayOfByte[78] = 13;
    arrayOfByte[79] = 14;
    arrayOfByte[80] = 15;
    arrayOfByte[81] = 16;
    arrayOfByte[82] = 17;
    arrayOfByte[83] = 18;
    arrayOfByte[84] = 19;
    arrayOfByte[85] = 20;
    arrayOfByte[86] = 21;
    arrayOfByte[87] = 22;
    arrayOfByte[88] = 23;
    arrayOfByte[89] = 24;
    arrayOfByte[90] = 25;
    arrayOfByte[91] = -1;
    arrayOfByte[92] = -1;
    arrayOfByte[93] = -1;
    arrayOfByte[94] = -1;
    arrayOfByte[95] = 63;
    arrayOfByte[96] = -1;
    arrayOfByte[97] = 26;
    arrayOfByte[98] = 27;
    arrayOfByte[99] = 28;
    arrayOfByte[100] = 29;
    arrayOfByte[101] = 30;
    arrayOfByte[102] = 31;
    arrayOfByte[103] = 32;
    arrayOfByte[104] = 33;
    arrayOfByte[105] = 34;
    arrayOfByte[106] = 35;
    arrayOfByte[107] = 36;
    arrayOfByte[108] = 37;
    arrayOfByte[109] = 38;
    arrayOfByte[110] = 39;
    arrayOfByte[111] = 40;
    arrayOfByte[112] = 41;
    arrayOfByte[113] = 42;
    arrayOfByte[114] = 43;
    arrayOfByte[115] = 44;
    arrayOfByte[116] = 45;
    arrayOfByte[117] = 46;
    arrayOfByte[118] = 47;
    arrayOfByte[119] = 48;
    arrayOfByte[120] = 49;
    arrayOfByte[121] = 50;
    arrayOfByte[122] = 51;
    r = arrayOfByte;
  }

  public dh()
  {
    this(0);
  }

  public dh(int paramInt)
  {
    this(paramInt, a);
  }

  public dh(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }

  public dh(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
  }

  public dh(boolean paramBoolean)
  {
    this(76, a, paramBoolean);
  }

  public static boolean a(byte paramByte)
  {
    return (paramByte == 61) || ((paramByte >= 0) && (paramByte < r.length) && (r[paramByte] != -1));
  }

  public static boolean a(String paramString)
  {
    return b(df.f(paramString));
  }

  public static boolean a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte);
  }

  public static byte[] a(BigInteger paramBigInteger)
  {
    if (paramBigInteger == null)
      throw new NullPointerException("encodeInteger called with null parameter");
    return a(b(paramBigInteger), false);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return a(paramArrayOfByte, paramBoolean, false);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramArrayOfByte, paramBoolean1, paramBoolean2, 2147483647);
  }

  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    if (paramBoolean1);
    for (dh localdh = new dh(paramBoolean2); ; localdh = new dh(0, a, paramBoolean2))
    {
      long l = localdh.o(paramArrayOfByte);
      if (l <= paramInt)
        break;
      throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt);
    }
    return localdh.l(paramArrayOfByte);
  }

  public static boolean b(byte[] paramArrayOfByte)
  {
    for (int i = 0; ; i++)
    {
      int j;
      if (i >= paramArrayOfByte.length)
        j = 1;
      boolean bool;
      do
      {
        return j;
        if (a(paramArrayOfByte[i]))
          break;
        bool = c(paramArrayOfByte[i]);
        j = 0;
      }
      while (!bool);
    }
  }

  public static byte[] b(String paramString)
  {
    return new dh().c(paramString);
  }

  static byte[] b(BigInteger paramBigInteger)
  {
    int i = 7 + paramBigInteger.bitLength() >> 3 << 3;
    byte[] arrayOfByte1 = paramBigInteger.toByteArray();
    if ((paramBigInteger.bitLength() % 8 != 0) && (1 + paramBigInteger.bitLength() / 8 == i / 8))
      return arrayOfByte1;
    int j = arrayOfByte1.length;
    int k = paramBigInteger.bitLength() % 8;
    int i1 = 0;
    if (k == 0)
    {
      i1 = 1;
      j--;
    }
    int i2 = i / 8 - j;
    byte[] arrayOfByte2 = new byte[i / 8];
    System.arraycopy(arrayOfByte1, i1, arrayOfByte2, i2, j);
    return arrayOfByte2;
  }

  public static byte[] c(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, false);
  }

  public static String d(byte[] paramArrayOfByte)
  {
    return df.f(a(paramArrayOfByte, false));
  }

  public static byte[] e(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, false, true);
  }

  public static String f(byte[] paramArrayOfByte)
  {
    return df.f(a(paramArrayOfByte, false, true));
  }

  public static byte[] g(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, true);
  }

  public static byte[] h(byte[] paramArrayOfByte)
  {
    return new dh().k(paramArrayOfByte);
  }

  public static BigInteger i(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, h(paramArrayOfByte));
  }

  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.j);
    while (true)
    {
      return;
      if (paramInt2 < 0)
      {
        this.j = true;
        if ((this.l == 0) && (this.g == 0))
          continue;
        a(this.x);
        int i5 = this.i;
        switch (this.l)
        {
        default:
        case 1:
        case 2:
        }
        while (true)
        {
          this.k += this.i - i5;
          if ((this.g <= 0) || (this.k <= 0))
            break;
          System.arraycopy(this.v, 0, this.h, this.i, this.v.length);
          this.i += this.v.length;
          return;
          byte[] arrayOfByte9 = this.h;
          int i10 = this.i;
          this.i = (i10 + 1);
          arrayOfByte9[i10] = this.t[(0x3F & this.y >> 2)];
          byte[] arrayOfByte10 = this.h;
          int i11 = this.i;
          this.i = (i11 + 1);
          arrayOfByte10[i11] = this.t[(0x3F & this.y << 4)];
          if (this.t != p)
            continue;
          byte[] arrayOfByte11 = this.h;
          int i12 = this.i;
          this.i = (i12 + 1);
          arrayOfByte11[i12] = 61;
          byte[] arrayOfByte12 = this.h;
          int i13 = this.i;
          this.i = (i13 + 1);
          arrayOfByte12[i13] = 61;
          continue;
          byte[] arrayOfByte5 = this.h;
          int i6 = this.i;
          this.i = (i6 + 1);
          arrayOfByte5[i6] = this.t[(0x3F & this.y >> 10)];
          byte[] arrayOfByte6 = this.h;
          int i7 = this.i;
          this.i = (i7 + 1);
          arrayOfByte6[i7] = this.t[(0x3F & this.y >> 4)];
          byte[] arrayOfByte7 = this.h;
          int i8 = this.i;
          this.i = (i8 + 1);
          arrayOfByte7[i8] = this.t[(0x3F & this.y << 2)];
          if (this.t != p)
            continue;
          byte[] arrayOfByte8 = this.h;
          int i9 = this.i;
          this.i = (i9 + 1);
          arrayOfByte8[i9] = 61;
        }
      }
      int i = 0;
      while (i < paramInt2)
      {
        a(this.x);
        this.l = ((1 + this.l) % 3);
        int j = paramInt1 + 1;
        int k = paramArrayOfByte[paramInt1];
        if (k < 0)
          k += 256;
        this.y = (k + (this.y << 8));
        if (this.l == 0)
        {
          byte[] arrayOfByte1 = this.h;
          int i1 = this.i;
          this.i = (i1 + 1);
          arrayOfByte1[i1] = this.t[(0x3F & this.y >> 18)];
          byte[] arrayOfByte2 = this.h;
          int i2 = this.i;
          this.i = (i2 + 1);
          arrayOfByte2[i2] = this.t[(0x3F & this.y >> 12)];
          byte[] arrayOfByte3 = this.h;
          int i3 = this.i;
          this.i = (i3 + 1);
          arrayOfByte3[i3] = this.t[(0x3F & this.y >> 6)];
          byte[] arrayOfByte4 = this.h;
          int i4 = this.i;
          this.i = (i4 + 1);
          arrayOfByte4[i4] = this.t[(0x3F & this.y)];
          this.k = (4 + this.k);
          if ((this.g > 0) && (this.g <= this.k))
          {
            System.arraycopy(this.v, 0, this.h, this.i, this.v.length);
            this.i += this.v.length;
            this.k = 0;
          }
        }
        i++;
        paramInt1 = j;
      }
    }
  }

  public boolean a()
  {
    return this.t == q;
  }

  void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.j)
      return;
    if (paramInt2 < 0)
      this.j = true;
    int i = 0;
    while (true)
    {
      if (i >= paramInt2);
      int j;
      int k;
      while ((this.j) && (this.l != 0))
      {
        a(this.w);
        switch (this.l)
        {
        default:
          return;
        case 2:
          this.y >>= 4;
          byte[] arrayOfByte6 = this.h;
          int i7 = this.i;
          this.i = (i7 + 1);
          arrayOfByte6[i7] = (byte)(0xFF & this.y);
          return;
          a(this.w);
          j = paramInt1 + 1;
          k = paramArrayOfByte[paramInt1];
          if (k != 61)
            break label155;
          this.j = true;
        case 3:
        }
      }
      label155: if ((k >= 0) && (k < r.length))
      {
        int i1 = r[k];
        if (i1 >= 0)
        {
          this.l = ((1 + this.l) % 4);
          this.y = (i1 + (this.y << 6));
          if (this.l == 0)
          {
            byte[] arrayOfByte1 = this.h;
            int i2 = this.i;
            this.i = (i2 + 1);
            arrayOfByte1[i2] = (byte)(0xFF & this.y >> 16);
            byte[] arrayOfByte2 = this.h;
            int i3 = this.i;
            this.i = (i3 + 1);
            arrayOfByte2[i3] = (byte)(0xFF & this.y >> 8);
            byte[] arrayOfByte3 = this.h;
            int i4 = this.i;
            this.i = (i4 + 1);
            arrayOfByte3[i4] = (byte)(0xFF & this.y);
          }
        }
      }
      i++;
      paramInt1 = j;
    }
    this.y >>= 2;
    byte[] arrayOfByte4 = this.h;
    int i5 = this.i;
    this.i = (i5 + 1);
    arrayOfByte4[i5] = (byte)(0xFF & this.y >> 8);
    byte[] arrayOfByte5 = this.h;
    int i6 = this.i;
    this.i = (i6 + 1);
    arrayOfByte5[i6] = (byte)(0xFF & this.y);
  }

  protected boolean b(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.u.length) && (this.u[paramByte] != -1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dh
 * JD-Core Version:    0.6.0
 */