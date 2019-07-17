package com.squareup.a;

import b.i;
import com.squareup.a.a.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ab
  implements Closeable
{
  private Reader a;

  private Charset h()
  {
    s locals = a();
    if (locals != null)
      return locals.a(l.d);
    return l.d;
  }

  public abstract s a();

  public abstract long b();

  public abstract i c();

  public void close()
    throws IOException
  {
    c().close();
  }

  public final InputStream d()
  {
    return c().h();
  }

  public final byte[] e()
    throws IOException
  {
    long l = b();
    if (l > 2147483647L)
      throw new IOException("Cannot buffer entire body for content length: " + l);
    i locali = c();
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = locali.u();
      l.a(locali);
      if ((l != -1L) && (l != arrayOfByte.length))
        throw new IOException("Content-Length and stream length disagree");
    }
    finally
    {
      l.a(locali);
    }
    return arrayOfByte;
  }

  public final Reader f()
  {
    Reader localReader = this.a;
    if (localReader != null)
      return localReader;
    InputStreamReader localInputStreamReader = new InputStreamReader(d(), h());
    this.a = localInputStreamReader;
    return localInputStreamReader;
  }

  public final String g()
    throws IOException
  {
    return new String(e(), h().name());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.ab
 * JD-Core Version:    0.6.0
 */