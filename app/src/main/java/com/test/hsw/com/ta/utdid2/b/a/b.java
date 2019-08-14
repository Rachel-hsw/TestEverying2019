package com.ta.utdid2.b.a;

import java.io.UnsupportedEncodingException;

public class b
{
  static
  {
    if (!b.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int j;
    int k;
    int m;
    label73: int n;
    while (true)
    {
      int i;
      c localc;
      try
      {
        i = paramArrayOfByte.length;
        localc = new c(paramInt);
        j = 4 * (i / 3);
        if (localc.d)
        {
          if (i % 3 <= 0)
            continue;
          j += 4;
          if ((!localc.e) || (i <= 0))
            break label171;
          k = 1 + (i - 1) / 57;
          if (!localc.f)
            break label206;
          m = 2;
          break;
          localc.a = new byte[n];
          localc.a(paramArrayOfByte, i);
          if ((a) || (localc.b == n))
            break label152;
          throw new AssertionError();
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
      switch (i % 3)
      {
      case 0:
        label152: String str = new String(localc.a, "US-ASCII");
        return str;
        label171: n = j;
      default:
      case 1:
      case 2:
      }
    }
    while (true)
    {
      n = j + m * k;
      break label73;
      break;
      j += 2;
      break;
      j += 3;
      break;
      label206: m = 1;
    }
  }

  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes();
    int i = arrayOfByte1.length;
    b localb = new b(new byte[i * 3 / 4]);
    if (!localb.a(arrayOfByte1, i))
      throw new IllegalArgumentException("bad base-64");
    if (localb.b == localb.a.length)
      return localb.a;
    byte[] arrayOfByte2 = new byte[localb.b];
    System.arraycopy(localb.a, 0, arrayOfByte2, 0, localb.b);
    return arrayOfByte2;
  }

  static abstract class a
  {
    public byte[] a;
    public int b;
  }

  static final class b extends b.a
  {
    private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private int e;
    private int f;
    private final int[] g;

    public b(byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      this.g = c;
      this.e = 0;
      this.f = 0;
    }

    public final boolean a(byte[] paramArrayOfByte, int paramInt)
    {
      if (this.e == 6)
        return false;
      int i = paramInt + 0;
      int j = this.e;
      int k = this.f;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.g;
      int m = j;
      int n = 0;
      int i1 = 0;
      if (n < i)
        if (m == 0)
        {
          while (n + 4 <= i)
          {
            k = arrayOfInt[(0xFF & paramArrayOfByte[n])] << 18 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 1)])] << 12 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 2)])] << 6 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 3)])];
            if (k < 0)
              break;
            arrayOfByte[(i1 + 2)] = (byte)k;
            arrayOfByte[(i1 + 1)] = (byte)(k >> 8);
            arrayOfByte[i1] = (byte)(k >> 16);
            i1 += 3;
            n += 4;
          }
          if (n >= i);
        }
        else
        {
          int i5 = n + 1;
          int i6 = arrayOfInt[(0xFF & paramArrayOfByte[n])];
          switch (m)
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
                      n = i5;
                      break;
                      if (i6 < 0)
                        continue;
                      m++;
                      k = i6;
                      n = i5;
                      break;
                    }
                    while (i6 == -1);
                    this.e = 6;
                    return false;
                    if (i6 < 0)
                      continue;
                    k = i6 | k << 6;
                    m++;
                    n = i5;
                    break;
                  }
                  while (i6 == -1);
                  this.e = 6;
                  return false;
                  if (i6 >= 0)
                  {
                    k = i6 | k << 6;
                    m++;
                    n = i5;
                    break;
                  }
                  if (i6 != -2)
                    continue;
                  int i7 = i1 + 1;
                  arrayOfByte[i1] = (byte)(k >> 4);
                  m = 4;
                  i1 = i7;
                  n = i5;
                  break;
                }
                while (i6 == -1);
                this.e = 6;
                return false;
                if (i6 >= 0)
                {
                  k = i6 | k << 6;
                  arrayOfByte[(i1 + 2)] = (byte)k;
                  arrayOfByte[(i1 + 1)] = (byte)(k >> 8);
                  arrayOfByte[i1] = (byte)(k >> 16);
                  i1 += 3;
                  n = i5;
                  m = 0;
                  break;
                }
                if (i6 != -2)
                  continue;
                arrayOfByte[(i1 + 1)] = (byte)(k >> 2);
                arrayOfByte[i1] = (byte)(k >> 10);
                i1 += 2;
                m = 5;
                n = i5;
                break;
              }
              while (i6 == -1);
              this.e = 6;
              return false;
              if (i6 != -2)
                continue;
              m++;
              n = i5;
              break;
            }
            while (i6 == -1);
            this.e = 6;
            return false;
          }
          while (i6 == -1);
          this.e = 6;
          return false;
        }
      int i2 = k;
      switch (m)
      {
      case 0:
      default:
      case 1:
      case 2:
      case 3:
        while (true)
        {
          this.e = m;
          this.b = i1;
          return true;
          this.e = 6;
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
      this.e = 6;
      return false;
    }
  }

  static final class c extends b.a
  {
    private static final byte[] h;
    private static final byte[] i;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;

    static
    {
      if (!b.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        g = bool;
        h = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }

    public c(int paramInt)
    {
      this.a = null;
      boolean bool2;
      boolean bool3;
      label33: label45: byte[] arrayOfByte;
      if ((paramInt & 0x1) == 0)
      {
        bool2 = bool1;
        this.d = bool2;
        if ((paramInt & 0x2) != 0)
          break label103;
        bool3 = bool1;
        this.e = bool3;
        if ((paramInt & 0x4) == 0)
          break label109;
        this.f = bool1;
        if ((paramInt & 0x8) != 0)
          break label114;
        arrayOfByte = h;
        label62: this.l = arrayOfByte;
        this.j = new byte[2];
        this.c = 0;
        if (!this.e)
          break label122;
      }
      label103: label109: label114: label122: for (int m = 19; ; m = -1)
      {
        this.k = m;
        return;
        bool2 = false;
        break;
        bool3 = false;
        break label33;
        bool1 = false;
        break label45;
        arrayOfByte = i;
        break label62;
      }
    }

    public final boolean a(byte[] paramArrayOfByte, int paramInt)
    {
      byte[] arrayOfByte1 = this.l;
      byte[] arrayOfByte2 = this.a;
      int m = this.k;
      int n = paramInt + 0;
      int i2;
      int i3;
      label58: int i36;
      int i37;
      int i5;
      int i4;
      switch (this.c)
      {
      default:
        i2 = -1;
        i3 = 0;
        if (i2 != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(0x3F & i2 >> 18)];
          arrayOfByte2[1] = arrayOfByte1[(0x3F & i2 >> 12)];
          arrayOfByte2[2] = arrayOfByte1[(0x3F & i2 >> 6)];
          i36 = 4;
          arrayOfByte2[3] = arrayOfByte1[(i2 & 0x3F)];
          i37 = m - 1;
          if (i37 != 0)
            break;
          if (this.f)
          {
            i36 = 5;
            arrayOfByte2[4] = 13;
          }
          i5 = i36 + 1;
          arrayOfByte2[i36] = 10;
          i4 = 19;
        }
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        label164: int i32;
        int i33;
        int i34;
        int i35;
        if (i3 + 3 <= n)
        {
          int i31 = (0xFF & paramArrayOfByte[i3]) << 16 | (0xFF & paramArrayOfByte[(i3 + 1)]) << 8 | 0xFF & paramArrayOfByte[(i3 + 2)];
          arrayOfByte2[i5] = arrayOfByte1[(0x3F & i31 >> 18)];
          arrayOfByte2[(i5 + 1)] = arrayOfByte1[(0x3F & i31 >> 12)];
          arrayOfByte2[(i5 + 2)] = arrayOfByte1[(0x3F & i31 >> 6)];
          arrayOfByte2[(i5 + 3)] = arrayOfByte1[(i31 & 0x3F)];
          i32 = i3 + 3;
          i33 = i5 + 4;
          i34 = i4 - 1;
          if (i34 != 0)
            break label1075;
          if (!this.f)
            break label1068;
          i35 = i33 + 1;
          arrayOfByte2[i33] = 13;
        }
        while (true)
        {
          i5 = i35 + 1;
          arrayOfByte2[i35] = 10;
          i3 = i32;
          i4 = 19;
          break label164;
          i2 = -1;
          i3 = 0;
          break label58;
          if (2 > n)
            break;
          int i38 = (0xFF & this.j[0]) << 16 | (0xFF & paramArrayOfByte[0]) << 8 | 0xFF & paramArrayOfByte[1];
          this.c = 0;
          i2 = i38;
          i3 = 2;
          break label58;
          if (n <= 0)
            break;
          int i1 = (0xFF & this.j[0]) << 16 | (0xFF & this.j[1]) << 8 | 0xFF & paramArrayOfByte[0];
          this.c = 0;
          i2 = i1;
          i3 = 1;
          break label58;
          if (i3 - this.c == n - 1)
          {
            int i22;
            int i23;
            if (this.c > 0)
            {
              i22 = this.j[0];
              i23 = i3;
            }
            for (int i24 = 1; ; i24 = 0)
            {
              int i25 = (i22 & 0xFF) << 4;
              this.c -= i24;
              int i26 = i5 + 1;
              arrayOfByte2[i5] = arrayOfByte1[(0x3F & i25 >> 6)];
              int i27 = i26 + 1;
              arrayOfByte2[i26] = arrayOfByte1[(i25 & 0x3F)];
              if (this.d)
              {
                int i30 = i27 + 1;
                arrayOfByte2[i27] = 61;
                i27 = i30 + 1;
                arrayOfByte2[i30] = 61;
              }
              if (this.e)
              {
                if (this.f)
                {
                  int i29 = i27 + 1;
                  arrayOfByte2[i27] = 13;
                  i27 = i29;
                }
                int i28 = i27 + 1;
                arrayOfByte2[i27] = 10;
                i27 = i28;
              }
              i3 = i23;
              i5 = i27;
              if ((g) || (this.c == 0))
                break;
              throw new AssertionError();
              int i21 = i3 + 1;
              i22 = paramArrayOfByte[i3];
              i23 = i21;
            }
          }
          int i8;
          int i9;
          label723: int i12;
          label764: int i16;
          int i17;
          if (i3 - this.c == n - 2)
            if (this.c > 1)
            {
              i8 = this.j[0];
              i9 = 1;
              int i10 = (i8 & 0xFF) << 10;
              if (this.c <= 0)
                break label945;
              byte[] arrayOfByte3 = this.j;
              int i20 = i9 + 1;
              i12 = arrayOfByte3[i9];
              i9 = i20;
              int i13 = i10 | (i12 & 0xFF) << 2;
              this.c -= i9;
              int i14 = i5 + 1;
              arrayOfByte2[i5] = arrayOfByte1[(0x3F & i13 >> 12)];
              int i15 = i14 + 1;
              arrayOfByte2[i14] = arrayOfByte1[(0x3F & i13 >> 6)];
              i16 = i15 + 1;
              arrayOfByte2[i15] = arrayOfByte1[(i13 & 0x3F)];
              if (!this.d)
                break label1061;
              i17 = i16 + 1;
              arrayOfByte2[i16] = 61;
            }
          while (true)
          {
            if (this.e)
            {
              if (this.f)
              {
                int i19 = i17 + 1;
                arrayOfByte2[i17] = 13;
                i17 = i19;
              }
              int i18 = i17 + 1;
              arrayOfByte2[i17] = 10;
              i17 = i18;
            }
            i5 = i17;
            break;
            int i7 = i3 + 1;
            i8 = paramArrayOfByte[i3];
            i3 = i7;
            i9 = 0;
            break label723;
            label945: int i11 = i3 + 1;
            i12 = paramArrayOfByte[i3];
            i3 = i11;
            break label764;
            if ((!this.e) || (i5 <= 0) || (i4 == 19))
              break;
            int i6;
            if (this.f)
            {
              i6 = i5 + 1;
              arrayOfByte2[i5] = 13;
            }
            while (true)
            {
              i5 = i6 + 1;
              arrayOfByte2[i6] = 10;
              break;
              if ((!g) && (i3 != n))
                throw new AssertionError();
              this.b = i5;
              this.k = i4;
              return true;
              i6 = i5;
            }
            label1061: i17 = i16;
          }
          label1068: i35 = i33;
        }
        label1075: i4 = i34;
        i5 = i33;
        i3 = i32;
        continue;
        i4 = i37;
        i5 = i36;
        continue;
        i4 = m;
        i5 = 0;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.b
 * JD-Core Version:    0.6.0
 */