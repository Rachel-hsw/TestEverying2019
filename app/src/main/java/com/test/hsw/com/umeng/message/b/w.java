package com.umeng.message.b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class w
  implements i
{
  public final e a;
  public final ab b;
  private boolean c;

  public w(ab paramab)
  {
    this(paramab, new e());
  }

  public w(ab paramab, e parame)
  {
    if (paramab == null)
      throw new IllegalArgumentException("source == null");
    this.a = parame;
    this.b = paramab;
  }

  public long a(byte paramByte)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    long l1 = 0L;
    long l2;
    while (true)
    {
      l2 = this.a.a(paramByte, l1);
      if (l2 != -1L)
        break;
      l1 = this.a.b;
      if (this.b.c(this.a, 2048L) != -1L)
        continue;
      l2 = -1L;
    }
    return l2;
  }

  public long a(aa paramaa)
    throws IOException
  {
    long l1 = 0L;
    while (this.b.c(this.a, 2048L) != -1L)
    {
      long l2 = this.a.g();
      if (l2 <= 0L)
        continue;
      l1 += l2;
      paramaa.b(this.a, l2);
    }
    if (this.a.a() > 0L)
    {
      l1 += this.a.a();
      paramaa.b(this.a, this.a.a());
    }
    return l1;
  }

  public String a(long paramLong, Charset paramCharset)
    throws IOException
  {
    a(paramLong);
    return this.a.a(paramLong, paramCharset);
  }

  public String a(Charset paramCharset)
    throws IOException
  {
    while (this.b.c(this.a, 2048L) != -1L);
    return this.a.a(paramCharset);
  }

  public void a(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    while (this.a.b < paramLong)
    {
      if (this.b.c(this.a, 2048L) != -1L)
        continue;
      throw new EOFException();
    }
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    a(paramLong);
    this.a.a(parame, paramLong);
  }

  public e b()
  {
    return this.a;
  }

  public long c(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.c)
      throw new IllegalStateException("closed");
    if ((this.a.b == 0L) && (this.b.c(this.a, 2048L) == -1L))
      return -1L;
    long l = Math.min(paramLong, this.a.b);
    return this.a.c(parame, l);
  }

  public j c(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.c(paramLong);
  }

  public void close()
    throws IOException
  {
    if (this.c)
      return;
    this.c = true;
    this.b.close();
    this.a.r();
  }

  public String d(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.d(paramLong);
  }

  public boolean e()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    return (this.a.e()) && (this.b.c(this.a, 2048L) == -1L);
  }

  public InputStream f()
  {
    return new x(this);
  }

  public byte[] f(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.f(paramLong);
  }

  public void g(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    while (true)
    {
      long l = Math.min(paramLong, this.a.a());
      this.a.g(l);
      paramLong -= l;
      if (paramLong <= 0L)
        break;
      if ((this.a.b != 0L) || (this.b.c(this.a, 2048L) != -1L))
        continue;
      throw new EOFException();
    }
  }

  public byte h()
    throws IOException
  {
    a(1L);
    return this.a.h();
  }

  public short i()
    throws IOException
  {
    a(2L);
    return this.a.i();
  }

  public int j()
    throws IOException
  {
    a(4L);
    return this.a.j();
  }

  public long k()
    throws IOException
  {
    a(8L);
    return this.a.k();
  }

  public short l()
    throws IOException
  {
    a(2L);
    return this.a.l();
  }

  public int m()
    throws IOException
  {
    a(4L);
    return this.a.m();
  }

  public long n()
    throws IOException
  {
    a(8L);
    return this.a.n();
  }

  public String o()
    throws IOException
  {
    while (this.b.c(this.a, 2048L) != -1L);
    return this.a.o();
  }

  public String p()
    throws IOException
  {
    long l = a(10);
    if (l == -1L)
    {
      if (this.a.b != 0L)
        return d(this.a.b);
      return null;
    }
    return this.a.e(l);
  }

  public String q()
    throws IOException
  {
    long l = a(10);
    if (l == -1L)
      throw new EOFException();
    return this.a.e(l);
  }

  public ac t()
  {
    return this.b.t();
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.w
 * JD-Core Version:    0.6.0
 */