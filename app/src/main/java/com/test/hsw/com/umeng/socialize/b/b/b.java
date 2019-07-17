package com.umeng.socialize.b.b;

public class b extends c
{
  static final byte[] a = { 13, 10 };
  private static final int l = 6;
  private static final int m = 3;
  private static final int n = 4;
  private static final byte[] o = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] p = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] q = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private static final int r = 63;
  private final byte[] s;
  private final byte[] t;
  private final byte[] u;
  private final int v;
  private final int w;
  private int x;

  public b()
  {
    this(0);
  }

  public b(int paramInt)
  {
    this(paramInt, a);
  }

  public b(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }

  public b(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
  }

  public b(boolean paramBoolean)
  {
    this(76, a, paramBoolean);
  }

  public static String a(byte[] paramArrayOfByte)
  {
    return a.a(a(paramArrayOfByte, false));
  }

  public static byte[] a(String paramString)
  {
    return new b().b(paramString);
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
    for (b localb = new b(paramBoolean2); ; localb = new b(0, a, paramBoolean2))
    {
      long l1 = localb.g(paramArrayOfByte);
      if (l1 <= paramInt)
        break;
      throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l1 + ") than the specified maximum size of " + paramInt);
    }
    return localb.d(paramArrayOfByte);
  }

  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.i);
    while (true)
    {
      return;
      if (paramInt2 < 0)
      {
        this.i = true;
        if ((this.k == 0) && (this.f == 0))
          continue;
        a(this.w);
        int i5 = this.h;
        switch (this.k)
        {
        default:
        case 1:
        case 2:
        }
        while (true)
        {
          this.j += this.h - i5;
          if ((this.f <= 0) || (this.j <= 0))
            break;
          System.arraycopy(this.u, 0, this.g, this.h, this.u.length);
          this.h += this.u.length;
          return;
          byte[] arrayOfByte9 = this.g;
          int i10 = this.h;
          this.h = (i10 + 1);
          arrayOfByte9[i10] = this.s[(0x3F & this.x >> 2)];
          byte[] arrayOfByte10 = this.g;
          int i11 = this.h;
          this.h = (i11 + 1);
          arrayOfByte10[i11] = this.s[(0x3F & this.x << 4)];
          if (this.s != o)
            continue;
          byte[] arrayOfByte11 = this.g;
          int i12 = this.h;
          this.h = (i12 + 1);
          arrayOfByte11[i12] = 61;
          byte[] arrayOfByte12 = this.g;
          int i13 = this.h;
          this.h = (i13 + 1);
          arrayOfByte12[i13] = 61;
          continue;
          byte[] arrayOfByte5 = this.g;
          int i6 = this.h;
          this.h = (i6 + 1);
          arrayOfByte5[i6] = this.s[(0x3F & this.x >> 10)];
          byte[] arrayOfByte6 = this.g;
          int i7 = this.h;
          this.h = (i7 + 1);
          arrayOfByte6[i7] = this.s[(0x3F & this.x >> 4)];
          byte[] arrayOfByte7 = this.g;
          int i8 = this.h;
          this.h = (i8 + 1);
          arrayOfByte7[i8] = this.s[(0x3F & this.x << 2)];
          if (this.s != o)
            continue;
          byte[] arrayOfByte8 = this.g;
          int i9 = this.h;
          this.h = (i9 + 1);
          arrayOfByte8[i9] = 61;
        }
      }
      int i = 0;
      while (i < paramInt2)
      {
        a(this.w);
        this.k = ((1 + this.k) % 3);
        int j = paramInt1 + 1;
        int k = paramArrayOfByte[paramInt1];
        if (k < 0)
          k += 256;
        this.x = (k + (this.x << 8));
        if (this.k == 0)
        {
          byte[] arrayOfByte1 = this.g;
          int i1 = this.h;
          this.h = (i1 + 1);
          arrayOfByte1[i1] = this.s[(0x3F & this.x >> 18)];
          byte[] arrayOfByte2 = this.g;
          int i2 = this.h;
          this.h = (i2 + 1);
          arrayOfByte2[i2] = this.s[(0x3F & this.x >> 12)];
          byte[] arrayOfByte3 = this.g;
          int i3 = this.h;
          this.h = (i3 + 1);
          arrayOfByte3[i3] = this.s[(0x3F & this.x >> 6)];
          byte[] arrayOfByte4 = this.g;
          int i4 = this.h;
          this.h = (i4 + 1);
          arrayOfByte4[i4] = this.s[(0x3F & this.x)];
          this.j = (4 + this.j);
          if ((this.f > 0) && (this.f <= this.j))
          {
            System.arraycopy(this.u, 0, this.g, this.h, this.u.length);
            this.h += this.u.length;
            this.j = 0;
          }
        }
        i++;
        paramInt1 = j;
      }
    }
  }

  protected boolean a(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.t.length) && (this.t[paramByte] != -1);
  }

  void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.i)
      return;
    if (paramInt2 < 0)
      this.i = true;
    int i = 0;
    while (true)
    {
      int i2;
      int i3;
      if (i < paramInt2)
      {
        a(this.v);
        i2 = paramInt1 + 1;
        i3 = paramArrayOfByte[paramInt1];
        if (i3 == 61)
          this.i = true;
      }
      else
      {
        if ((!this.i) || (this.k == 0))
          break;
        a(this.v);
      }
      switch (this.k)
      {
      default:
        return;
      case 2:
        this.x >>= 4;
        byte[] arrayOfByte3 = this.g;
        int i1 = this.h;
        this.h = (i1 + 1);
        arrayOfByte3[i1] = (byte)(0xFF & this.x);
        return;
        if ((i3 >= 0) && (i3 < q.length))
        {
          int i4 = q[i3];
          if (i4 >= 0)
          {
            this.k = ((1 + this.k) % 4);
            this.x = (i4 + (this.x << 6));
            if (this.k == 0)
            {
              byte[] arrayOfByte4 = this.g;
              int i5 = this.h;
              this.h = (i5 + 1);
              arrayOfByte4[i5] = (byte)(0xFF & this.x >> 16);
              byte[] arrayOfByte5 = this.g;
              int i6 = this.h;
              this.h = (i6 + 1);
              arrayOfByte5[i6] = (byte)(0xFF & this.x >> 8);
              byte[] arrayOfByte6 = this.g;
              int i7 = this.h;
              this.h = (i7 + 1);
              arrayOfByte6[i7] = (byte)(0xFF & this.x);
            }
          }
        }
        i++;
        paramInt1 = i2;
      case 3:
      }
    }
    this.x >>= 2;
    byte[] arrayOfByte1 = this.g;
    int j = this.h;
    this.h = (j + 1);
    arrayOfByte1[j] = (byte)(0xFF & this.x >> 8);
    byte[] arrayOfByte2 = this.g;
    int k = this.h;
    this.h = (k + 1);
    arrayOfByte2[k] = (byte)(0xFF & this.x);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.b
 * JD-Core Version:    0.6.0
 */