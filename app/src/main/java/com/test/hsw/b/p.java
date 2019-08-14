package b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class p
  implements ab
{
  private final i a;
  private final Inflater b;
  private int c;
  private boolean d;

  public p(ab paramab, Inflater paramInflater)
  {
    this(q.a(paramab), paramInflater);
  }

  p(i parami, Inflater paramInflater)
  {
    if (parami == null)
      throw new IllegalArgumentException("source == null");
    if (paramInflater == null)
      throw new IllegalArgumentException("inflater == null");
    this.a = parami;
    this.b = paramInflater;
  }

  private void c()
    throws IOException
  {
    if (this.c == 0)
      return;
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.g(i);
  }

  public ac a()
  {
    return this.a.a();
  }

  public long b(e parame, long paramLong)
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
      boolean bool = b();
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
          c();
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

  public boolean b()
    throws IOException
  {
    if (!this.b.needsInput())
      return false;
    c();
    if (this.b.getRemaining() != 0)
      throw new IllegalStateException("?");
    if (this.a.g())
      return true;
    y localy = this.a.d().a;
    this.c = (localy.d - localy.c);
    this.b.setInput(localy.b, localy.c, this.c);
    return false;
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
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.p
 * JD-Core Version:    0.6.0
 */