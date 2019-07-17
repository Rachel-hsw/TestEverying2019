package b;

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
    if (paramab == null)
      throw new IllegalArgumentException("source == null");
    long l1 = 0L;
    while (true)
    {
      long l2 = paramab.b(this.a, 2048L);
      if (l2 == -1L)
        break;
      l1 += l2;
      y();
    }
    return l1;
  }

  public ac a()
  {
    return this.b.a();
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(parame, paramLong);
    y();
  }

  public h b(j paramj)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramj);
    return y();
  }

  public h b(String paramString)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramString);
    return y();
  }

  public h b(String paramString, Charset paramCharset)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramString, paramCharset);
    return y();
  }

  public h b(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramArrayOfByte);
    return y();
  }

  public void b()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    if (this.a.b > 0L)
      this.b.a(this.a, this.a.b);
    this.b.b();
  }

  public h c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return y();
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
          this.b.a(this.a, this.a.b);
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

  public e d()
  {
    return this.a;
  }

  public OutputStream e()
  {
    return new v(this);
  }

  public h g(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.e(paramInt);
    return y();
  }

  public h h(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.d(paramInt);
    return y();
  }

  public h i(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.c(paramInt);
    return y();
  }

  public h j(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramInt);
    return y();
  }

  public h j(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.i(paramLong);
    return y();
  }

  public h k(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramInt);
    return y();
  }

  public h k(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.h(paramLong);
    return y();
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }

  public h y()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    long l = this.a.i();
    if (l > 0L)
      this.b.a(this.a, l);
    return this;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.u
 * JD-Core Version:    0.6.0
 */