package com.umeng.message.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class n
  implements ab
{
  private final i a;
  private final Inflater b;
  private int c;
  private boolean d;

  public n(ab paramab, Inflater paramInflater)
  {
    this(o.a(paramab), paramInflater);
  }

  n(i parami, Inflater paramInflater)
  {
    if (parami == null)
      throw new IllegalArgumentException("source == null");
    if (paramInflater == null)
      throw new IllegalArgumentException("inflater == null");
    this.a = parami;
    this.b = paramInflater;
  }

  private void b()
    throws IOException
  {
    if (this.c == 0)
      return;
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.g(i);
  }

  public boolean a()
    throws IOException
  {
    if (!this.b.needsInput())
      return false;
    b();
    if (this.b.getRemaining() != 0)
      throw new IllegalStateException("?");
    if (this.a.e())
      return true;
    y localy = this.a.b().a;
    this.c = (localy.d - localy.c);
    this.b.setInput(localy.b, localy.c, this.c);
    return false;
  }

  public long c(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.d)
      throw new IllegalStateException("closed");
    if (paramLong == 0L)
      return 0L;
    while (true)
    {
      boolean bool = a();
      try
      {
        y localy = parame.f(1);
        int i = this.b.inflate(localy.b, localy.d, 2048 - localy.d);
        if (i > 0)
        {
          localy.d = (i + localy.d);
          parame.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          b();
          return -1L;
        }
        if (!bool)
          continue;
        throw new EOFException("source exhausted prematurely");
      }
      catch (DataFormatException localDataFormatException)
      {
      }
    }
    throw new IOException(localDataFormatException);
  }

  public void close()
    throws IOException
  {
    if (this.d)
      return;
    this.b.end();
    this.d = true;
    this.a.close();
  }

  public ac t()
  {
    return this.a.t();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.n
 * JD-Core Version:    0.6.0
 */