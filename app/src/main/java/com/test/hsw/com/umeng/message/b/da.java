package com.umeng.message.b;

import com.squareup.wire.WireType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class da
{
  public static final int a = 64;
  private static final Charset c = Charset.forName("UTF-8");
  private static final String d = "Encountered a negative size";
  private static final String e = "The input ended unexpectedly in the middle of a field";
  private static final String f = "Protocol message contained an invalid tag (zero).";
  private static final String g = "Protocol message end-group tag did not match expected tag.";
  private static final String h = "WireInput encountered a malformed varint.";
  public int b;
  private final i i;
  private int j = 0;
  private int k = 2147483647;
  private int l;

  private da(i parami)
  {
    this.i = parami;
  }

  public static long a(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }

  public static da a(ab paramab)
  {
    return new da(o.a(paramab));
  }

  public static da a(InputStream paramInputStream)
  {
    return new da(o.a(o.a(paramInputStream)));
  }

  public static da a(byte[] paramArrayOfByte)
  {
    return new da(new e().a(paramArrayOfByte));
  }

  public static da a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new da(new e().b(paramArrayOfByte, paramInt1, paramInt2));
  }

  private void b(long paramLong)
    throws IOException
  {
    this.j = (int)(paramLong + this.j);
    this.i.g(paramLong);
  }

  public static int c(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }

  private boolean f(int paramInt)
    throws IOException
  {
    switch (db.a[WireType.valueOf(paramInt).ordinal()])
    {
    default:
      throw new AssertionError();
    case 1:
      e();
      return false;
    case 2:
      f();
      return false;
    case 3:
      g();
      return false;
    case 4:
      b(d());
      return false;
    case 5:
      i();
      a(paramInt & 0xFFFFFFF8 | WireType.END_GROUP.value());
      return false;
    case 6:
    }
    return true;
  }

  private boolean j()
    throws IOException
  {
    if (h() == this.k)
      return true;
    return this.i.e();
  }

  public int a()
    throws IOException
  {
    if (j())
    {
      this.l = 0;
      return 0;
    }
    this.l = d();
    if (this.l == 0)
      throw new IOException("Protocol message contained an invalid tag (zero).");
    return this.l;
  }

  public void a(int paramInt)
    throws IOException
  {
    if (this.l != paramInt)
      throw new IOException("Protocol message end-group tag did not match expected tag.");
  }

  public j b(int paramInt)
    throws IOException
  {
    this.j = (paramInt + this.j);
    this.i.a(paramInt);
    return this.i.c(paramInt);
  }

  public String b()
    throws IOException
  {
    int m = d();
    this.j = (m + this.j);
    return this.i.a(m, c);
  }

  public j c()
    throws IOException
  {
    return b(d());
  }

  public int d()
    throws IOException
  {
    this.j = (1 + this.j);
    int m = this.i.h();
    if (m >= 0);
    int i7;
    do
    {
      return m;
      int n = m & 0x7F;
      this.j = (1 + this.j);
      int i1 = this.i.h();
      if (i1 >= 0)
        return n | i1 << 7;
      int i2 = n | (i1 & 0x7F) << 7;
      this.j = (1 + this.j);
      int i3 = this.i.h();
      if (i3 >= 0)
        return i2 | i3 << 14;
      int i4 = i2 | (i3 & 0x7F) << 14;
      this.j = (1 + this.j);
      int i5 = this.i.h();
      if (i5 >= 0)
        return i4 | i5 << 21;
      int i6 = i4 | (i5 & 0x7F) << 21;
      this.j = (1 + this.j);
      i7 = this.i.h();
      m = i6 | i7 << 28;
    }
    while (i7 >= 0);
    for (int i8 = 0; ; i8++)
    {
      if (i8 >= 5)
        break label241;
      this.j = (1 + this.j);
      if (this.i.h() >= 0)
        break;
    }
    label241: throw new IOException("WireInput encountered a malformed varint.");
  }

  public int d(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw new IOException("Encountered a negative size");
    int m = paramInt + this.j;
    int n = this.k;
    if (m > n)
      throw new EOFException("The input ended unexpectedly in the middle of a field");
    this.k = m;
    return n;
  }

  public long e()
    throws IOException
  {
    int m = 0;
    long l1 = 0L;
    while (m < 64)
    {
      this.j = (1 + this.j);
      int n = this.i.h();
      l1 |= (n & 0x7F) << m;
      if ((n & 0x80) == 0)
        return l1;
      m += 7;
    }
    throw new IOException("WireInput encountered a malformed varint.");
  }

  public void e(int paramInt)
  {
    this.k = paramInt;
  }

  public int f()
    throws IOException
  {
    this.j = (4 + this.j);
    return this.i.m();
  }

  public long g()
    throws IOException
  {
    this.j = (8 + this.j);
    return this.i.n();
  }

  public long h()
  {
    return this.j;
  }

  public void i()
    throws IOException
  {
    int m;
    do
      m = a();
    while ((m != 0) && (!f(m)));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.da
 * JD-Core Version:    0.6.0
 */