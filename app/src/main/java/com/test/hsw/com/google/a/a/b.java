package com.google.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class b
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;

  private b(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }

  private b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.d = null;
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }

  public static b a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }

  public static b a(OutputStream paramOutputStream, int paramInt)
  {
    return new b(paramOutputStream, new byte[paramInt]);
  }

  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    return f(paramInt) + b(paramBoolean);
  }

  public static int b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = h(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported.");
  }

  public static int b(boolean paramBoolean)
  {
    return 1;
  }

  public static int c(int paramInt)
  {
    if (paramInt >= 0)
      return h(paramInt);
    return 10;
  }

  public static int c(int paramInt1, int paramInt2)
  {
    return f(paramInt1) + c(paramInt2);
  }

  public static int d(int paramInt)
  {
    return h(paramInt);
  }

  public static int d(int paramInt1, int paramInt2)
  {
    return f(paramInt1) + d(paramInt2);
  }

  private void d()
  {
    if (this.d == null)
      throw new a();
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }

  public static int f(int paramInt)
  {
    return h(e.a(paramInt, 0));
  }

  public static int h(int paramInt)
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

  public void a()
  {
    if (this.d != null)
      d();
  }

  public void a(byte paramByte)
  {
    if (this.c == this.b)
      d();
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      g(paramInt);
      return;
    }
    a(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    a(paramInt2);
  }

  public void a(int paramInt, String paramString)
  {
    e(paramInt, 2);
    a(paramString);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    e(paramInt, 0);
    a(paramBoolean);
  }

  public void a(long paramLong)
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        e((int)paramLong);
        return;
      }
      e(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    g(arrayOfByte.length);
    a(arrayOfByte);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      e(i);
      return;
    }
  }

  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int b()
  {
    if (this.d == null)
      return this.b - this.c;
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }

  public void b(int paramInt)
  {
    g(paramInt);
  }

  public void b(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    b(paramInt2);
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    int i = this.b - this.c;
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, i);
    int j = paramInt1 + i;
    int k = paramInt2 - i;
    this.c = this.b;
    d();
    if (k <= this.b)
    {
      System.arraycopy(paramArrayOfByte, j, this.a, 0, k);
      this.c = k;
      return;
    }
    this.d.write(paramArrayOfByte, j, k);
  }

  public void c()
  {
    if (b() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void e(int paramInt)
  {
    a((byte)paramInt);
  }

  public void e(int paramInt1, int paramInt2)
  {
    g(e.a(paramInt1, paramInt2));
  }

  public void g(int paramInt)
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        e(paramInt);
        return;
      }
      e(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public static class a extends IOException
  {
    a()
    {
      super();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.a.a.b
 * JD-Core Version:    0.6.0
 */