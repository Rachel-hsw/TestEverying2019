package com.umeng.message.b;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class u
  implements h
{
  public final e a;
  public final aa b;
  private boolean c;

  public u(aa paramaa)
  {
    this(paramaa, new e());
  }

  public u(aa paramaa, e parame)
  {
    if (paramaa == null)
      throw new IllegalArgumentException("sink == null");
    this.a = parame;
    this.b = paramaa;
  }

  public long a(ab paramab)
    throws IOException
  {
    long l1 = 0L;
    while (true)
    {
      long l2 = paramab.c(this.a, 2048L);
      if (l2 == -1L)
        break;
      l1 += l2;
      w();
    }
    return l1;
  }

  public e b()
  {
    return this.a;
  }

  public h b(j paramj)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramj);
    return w();
  }

  public h b(String paramString)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramString);
    return w();
  }

  public h b(String paramString, Charset paramCharset)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramString, paramCharset);
    return w();
  }

  public h b(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramArrayOfByte);
    return w();
  }

  public void b(e parame, long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(parame, paramLong);
    w();
  }

  public h c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return w();
  }

  public OutputStream c()
  {
    return new v(this);
  }

  public void close()
    throws IOException
  {
    if (this.c);
    while (true)
    {
      return;
      try
      {
        boolean bool = this.a.b < 0L;
        Object localObject = null;
        if (bool)
          this.b.b(this.a, this.a.b);
        try
        {
          label44: this.b.close();
          this.c = true;
          if (localObject == null)
            continue;
          ae.a((Throwable)localObject);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (true)
          {
            if (localObject != null)
              continue;
            localObject = localThrowable2;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label44;
      }
    }
  }

  public h g(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.e(paramInt);
    return w();
  }

  public h h(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.d(paramInt);
    return w();
  }

  public h i(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.c(paramInt);
    return w();
  }

  public h j(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramInt);
    return w();
  }

  public h j(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.i(paramLong);
    return w();
  }

  public h k(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramInt);
    return w();
  }

  public h k(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.h(paramLong);
    return w();
  }

  public void s()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    if (this.a.b > 0L)
      this.b.b(this.a, this.a.b);
    this.b.s();
  }

  public ac t()
  {
    return this.b.t();
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }

  public h w()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    long l = this.a.g();
    if (l > 0L)
      this.b.b(this.a, l);
    return this;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.u
 * JD-Core Version:    0.6.0
 */