package com.squareup.wire;

import java.io.IOException;

public final class WireOutput
{
  private final byte[] a;
  private final int b;
  private int c;

  private WireOutput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }

  public static int a(int paramInt)
  {
    return b(makeTag(paramInt, WireType.VARINT));
  }

  public static int a(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  static WireOutput a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  static WireOutput a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new WireOutput(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int b(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  static long d(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  static int g(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public static int int32Size(int paramInt)
  {
    if (paramInt >= 0)
      return b(paramInt);
    return 10;
  }

  public static int int64Size(long paramLong)
  {
    if (paramLong >= 0L)
      return a(paramLong);
    return 10;
  }

  public static int makeTag(int paramInt, WireType paramWireType)
  {
    return paramInt << 3 | paramWireType.value();
  }

  public static int messageHeaderSize(int paramInt1, int paramInt2)
  {
    return tagSize(paramInt1, WireType.LENGTH_DELIMITED) + int32Size(paramInt2);
  }

  public static int messageSize(int paramInt1, int paramInt2)
  {
    return paramInt2 + (tagSize(paramInt1, WireType.LENGTH_DELIMITED) + int32Size(paramInt2));
  }

  public static int tagSize(int paramInt, WireType paramWireType)
  {
    return int32Size(makeTag(paramInt, paramWireType));
  }

  public static int writeMessageHeader(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2 + writeTag(paramInt1, WireType.LENGTH_DELIMITED, paramArrayOfByte, paramInt2);
    return i + writeVarint(paramInt3, paramArrayOfByte, i) - paramInt2;
  }

  public static int writeTag(int paramInt1, WireType paramWireType, byte[] paramArrayOfByte, int paramInt2)
  {
    return writeVarint(makeTag(paramInt1, paramWireType), paramArrayOfByte, paramInt2);
  }

  public static int writeVarint(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int j;
    for (int i = paramInt; ; i = j)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        int k = i + 1;
        paramArrayOfByte[i] = (byte)(int)paramLong;
        return k - paramInt;
      }
      j = i + 1;
      paramArrayOfByte[i] = (byte)(int)(0x80 | 0x7F & paramLong);
      paramLong >>>= 7;
    }
  }

  void a(byte paramByte)
    throws IOException
  {
    if (this.c == this.b)
      throw new IOException("Out of space: position=" + this.c + ", limit=" + this.b);
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(int paramInt, WireType paramWireType)
    throws IOException
  {
    e(makeTag(paramInt, paramWireType));
  }

  public void b(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        c((int)paramLong);
        return;
      }
      c(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void b(byte[] paramArrayOfByte)
    throws IOException
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    throw new IOException("Out of space: position=" + this.c + ", limit=" + this.b);
  }

  void c(int paramInt)
    throws IOException
  {
    a((byte)paramInt);
  }

  public void c(long paramLong)
    throws IOException
  {
    c(0xFF & (int)paramLong);
    c(0xFF & (int)(paramLong >> 8));
    c(0xFF & (int)(paramLong >> 16));
    c(0xFF & (int)(paramLong >> 24));
    c(0xFF & (int)(paramLong >> 32));
    c(0xFF & (int)(paramLong >> 40));
    c(0xFF & (int)(paramLong >> 48));
    c(0xFF & (int)(paramLong >> 56));
  }

  void d(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      e(paramInt);
      return;
    }
    b(paramInt);
  }

  public void e(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        c(paramInt);
        return;
      }
      c(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public void f(int paramInt)
    throws IOException
  {
    c(paramInt & 0xFF);
    c(0xFF & paramInt >> 8);
    c(0xFF & paramInt >> 16);
    c(0xFF & paramInt >> 24);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.WireOutput
 * JD-Core Version:    0.6.0
 */