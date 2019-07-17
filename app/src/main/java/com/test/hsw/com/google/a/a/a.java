package com.google.a.a;

import java.io.InputStream;
import java.util.Vector;

public final class a
{
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private final InputStream e;
  private int f;
  private int g;
  private int h = 2147483647;
  private int i = 64;
  private int j = 67108864;

  private a(InputStream paramInputStream)
  {
    this.a = new byte[4096];
    this.b = 0;
    this.d = 0;
    this.e = paramInputStream;
  }

  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = (paramInt1 + paramInt2);
    this.d = paramInt1;
    this.e = null;
  }

  public static a a(InputStream paramInputStream)
  {
    return new a(paramInputStream);
  }

  public static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new a(paramArrayOfByte, paramInt1, paramInt2);
  }

  private boolean a(boolean paramBoolean)
  {
    if (this.d < this.b)
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    if (this.g + this.b == this.h)
    {
      if (paramBoolean)
        throw c.a();
      return false;
    }
    this.g += this.b;
    this.d = 0;
    if (this.e == null);
    for (int k = -1; ; k = this.e.read(this.a))
    {
      this.b = k;
      if ((this.b != 0) && (this.b >= -1))
        break;
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
    }
    if (this.b == -1)
    {
      this.b = 0;
      if (paramBoolean)
        throw c.a();
      return false;
    }
    l();
    int m = this.g + this.b + this.c;
    if ((m > this.j) || (m < 0))
      throw c.g();
    return true;
  }

  private void l()
  {
    this.b += this.c;
    int k = this.g + this.b;
    if (k > this.h)
    {
      this.c = (k - this.h);
      this.b -= this.c;
      return;
    }
    this.c = 0;
  }

  public int a()
  {
    if (j())
    {
      this.f = 0;
      return 0;
    }
    this.f = g();
    if (this.f == 0)
      throw c.d();
    return this.f;
  }

  public void a(int paramInt)
  {
    if (this.f != paramInt)
      throw c.e();
  }

  public void b()
  {
    int k;
    do
      k = a();
    while ((k != 0) && (b(k)));
  }

  public boolean b(int paramInt)
  {
    switch (e.a(paramInt))
    {
    default:
      throw c.f();
    case 0:
      c();
      return true;
    case 1:
      i();
      return true;
    case 2:
      d(g());
      return true;
    case 3:
      b();
      a(e.a(e.b(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    h();
    return true;
  }

  public int c()
  {
    return g();
  }

  public byte[] c(int paramInt)
  {
    if (paramInt < 0)
      throw c.b();
    if (paramInt + (this.g + this.d) > this.h)
    {
      d(this.h - this.g - this.d);
      throw c.a();
    }
    if (paramInt <= this.b - this.d)
    {
      byte[] arrayOfByte5 = new byte[paramInt];
      System.arraycopy(this.a, this.d, arrayOfByte5, 0, paramInt);
      this.d = (paramInt + this.d);
      return arrayOfByte5;
    }
    if (paramInt < 4096)
    {
      byte[] arrayOfByte4 = new byte[paramInt];
      int i8 = this.b - this.d;
      System.arraycopy(this.a, this.d, arrayOfByte4, 0, i8);
      this.d = this.b;
      a(true);
      while (paramInt - i8 > this.b)
      {
        System.arraycopy(this.a, 0, arrayOfByte4, i8, this.b);
        i8 += this.b;
        this.d = this.b;
        a(true);
      }
      System.arraycopy(this.a, 0, arrayOfByte4, i8, paramInt - i8);
      this.d = (paramInt - i8);
      return arrayOfByte4;
    }
    int k = this.d;
    int m = this.b;
    this.g += this.b;
    this.d = 0;
    this.b = 0;
    int n = paramInt - (m - k);
    Vector localVector = new Vector();
    int i6;
    for (int i1 = n; i1 > 0; i1 = i6)
    {
      byte[] arrayOfByte3 = new byte[Math.min(i1, 4096)];
      int i5 = 0;
      while (i5 < arrayOfByte3.length)
      {
        if (this.e == null);
        for (int i7 = -1; i7 == -1; i7 = this.e.read(arrayOfByte3, i5, arrayOfByte3.length - i5))
          throw c.a();
        this.g = (i7 + this.g);
        i5 += i7;
      }
      i6 = i1 - arrayOfByte3.length;
      localVector.addElement(arrayOfByte3);
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    int i2 = m - k;
    System.arraycopy(this.a, k, arrayOfByte1, 0, i2);
    int i3 = 0;
    int i4 = i2;
    while (i3 < localVector.size())
    {
      byte[] arrayOfByte2 = (byte[])(byte[])localVector.elementAt(i3);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i4, arrayOfByte2.length);
      i4 += arrayOfByte2.length;
      i3++;
    }
    return arrayOfByte1;
  }

  public void d(int paramInt)
  {
    if (paramInt < 0)
      throw c.b();
    if (paramInt + (this.g + this.d) > this.h)
    {
      d(this.h - this.g - this.d);
      throw c.a();
    }
    if (paramInt <= this.b - this.d)
      this.d = (paramInt + this.d);
    while (true)
    {
      return;
      int k = this.b - this.d;
      this.g += this.b;
      this.d = 0;
      this.b = 0;
      int m = k;
      while (m < paramInt)
      {
        if (this.e == null);
        for (int n = -1; n <= 0; n = (int)this.e.skip(paramInt - m))
          throw c.a();
        m += n;
        this.g = (n + this.g);
      }
    }
  }

  public boolean d()
  {
    return g() != 0;
  }

  public String e()
  {
    int k = g();
    if ((k <= this.b - this.d) && (k > 0))
    {
      String str = new String(this.a, this.d, k, "UTF-8");
      this.d = (k + this.d);
      return str;
    }
    return new String(c(k), "UTF-8");
  }

  public int f()
  {
    return g();
  }

  public int g()
  {
    int k = k();
    if (k >= 0);
    int i6;
    do
    {
      return k;
      int m = k & 0x7F;
      int n = k();
      if (n >= 0)
        return m | n << 7;
      int i1 = m | (n & 0x7F) << 7;
      int i2 = k();
      if (i2 >= 0)
        return i1 | i2 << 14;
      int i3 = i1 | (i2 & 0x7F) << 14;
      int i4 = k();
      if (i4 >= 0)
        return i3 | i4 << 21;
      int i5 = i3 | (i4 & 0x7F) << 21;
      i6 = k();
      k = i5 | i6 << 28;
    }
    while (i6 >= 0);
    for (int i7 = 0; ; i7++)
    {
      if (i7 >= 5)
        break label151;
      if (k() >= 0)
        break;
    }
    label151: throw c.c();
  }

  public int h()
  {
    int k = k();
    int m = k();
    int n = k();
    int i1 = k();
    return k & 0xFF | (m & 0xFF) << 8 | (n & 0xFF) << 16 | (i1 & 0xFF) << 24;
  }

  public long i()
  {
    int k = k();
    int m = k();
    int n = k();
    int i1 = k();
    int i2 = k();
    int i3 = k();
    int i4 = k();
    int i5 = k();
    return 0xFF & k | (0xFF & m) << 8 | (0xFF & n) << 16 | (0xFF & i1) << 24 | (0xFF & i2) << 32 | (0xFF & i3) << 40 | (0xFF & i4) << 48 | (0xFF & i5) << 56;
  }

  public boolean j()
  {
    int k = this.d;
    int m = this.b;
    int n = 0;
    if (k == m)
    {
      boolean bool = a(false);
      n = 0;
      if (!bool)
        n = 1;
    }
    return n;
  }

  public byte k()
  {
    if (this.d == this.b)
      a(true);
    byte[] arrayOfByte = this.a;
    int k = this.d;
    this.d = (k + 1);
    return arrayOfByte[k];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.a.a.a
 * JD-Core Version:    0.6.0
 */