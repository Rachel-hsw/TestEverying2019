package b;

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
      if (this.b.b(this.a, 2048L) != -1L)
        continue;
      l2 = -1L;
    }
    return l2;
  }

  public long a(aa paramaa)
    throws IOException
  {
    if (paramaa == null)
      throw new IllegalArgumentException("sink == null");
    long l1 = 0L;
    while (this.b.b(this.a, 2048L) != -1L)
    {
      long l2 = this.a.i();
      if (l2 <= 0L)
        continue;
      l1 += l2;
      paramaa.a(this.a, l2);
    }
    if (this.a.c() > 0L)
    {
      l1 += this.a.c();
      paramaa.a(this.a, this.a.c());
    }
    return l1;
  }

  public ac a()
  {
    return this.b.a();
  }

  public String a(long paramLong, Charset paramCharset)
    throws IOException
  {
    a(paramLong);
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    return this.a.a(paramLong, paramCharset);
  }

  public String a(Charset paramCharset)
    throws IOException
  {
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    this.a.a(this.b);
    return this.a.a(paramCharset);
  }

  public void a(long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.c)
      throw new IllegalStateException("closed");
    while (this.a.b < paramLong)
    {
      if (this.b.b(this.a, 2048L) != -1L)
        continue;
      throw new EOFException();
    }
  }

  public long b(e parame, long paramLong)
    throws IOException
  {
    if (parame == null)
      throw new IllegalArgumentException("sink == null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.c)
      throw new IllegalStateException("closed");
    if ((this.a.b == 0L) && (this.b.b(this.a, 2048L) == -1L))
      return -1L;
    long l = Math.min(paramLong, this.a.b);
    return this.a.b(parame, l);
  }

  public j c(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.c(paramLong);
  }

  public void c(e parame, long paramLong)
    throws IOException
  {
    a(paramLong);
    this.a.c(parame, paramLong);
  }

  public void close()
    throws IOException
  {
    if (this.c)
      return;
    this.c = true;
    this.b.close();
    this.a.v();
  }

  public e d()
  {
    return this.a;
  }

  public String d(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.d(paramLong);
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
      long l = Math.min(paramLong, this.a.c());
      this.a.g(l);
      paramLong -= l;
      if (paramLong <= 0L)
        break;
      if ((this.a.b != 0L) || (this.b.b(this.a, 2048L) != -1L))
        continue;
      throw new EOFException();
    }
  }

  public boolean g()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    return (this.a.g()) && (this.b.b(this.a, 2048L) == -1L);
  }

  public InputStream h()
  {
    return new x(this);
  }

  public byte j()
    throws IOException
  {
    a(1L);
    return this.a.j();
  }

  public short k()
    throws IOException
  {
    a(2L);
    return this.a.k();
  }

  public int l()
    throws IOException
  {
    a(4L);
    return this.a.l();
  }

  public long m()
    throws IOException
  {
    a(8L);
    return this.a.m();
  }

  public short n()
    throws IOException
  {
    a(2L);
    return this.a.n();
  }

  public int o()
    throws IOException
  {
    a(4L);
    return this.a.o();
  }

  public long p()
    throws IOException
  {
    a(8L);
    return this.a.p();
  }

  public j q()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.q();
  }

  public String r()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.r();
  }

  public String s()
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

  public String t()
    throws IOException
  {
    long l = a(10);
    if (l == -1L)
      throw new EOFException();
    return this.a.e(l);
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }

  public byte[] u()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.u();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.w
 * JD-Core Version:    0.6.0
 */