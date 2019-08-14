package com.squareup.a.a.a;

import b.aa;
import b.ac;
import b.e;
import b.h;
import com.squareup.a.a.l;
import java.io.IOException;
import java.net.ProtocolException;

public final class n
  implements aa
{
  private boolean a;
  private final int b;
  private final e c = new e();

  public n()
  {
    this(-1);
  }

  public n(int paramInt)
  {
    this.b = paramInt;
  }

  public ac a()
  {
    return ac.b;
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    if (this.a)
      throw new IllegalStateException("closed");
    l.a(parame.c(), 0L, paramLong);
    if ((this.b != -1) && (this.c.c() > this.b - paramLong))
      throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    this.c.a(parame, paramLong);
  }

  public void a(h paramh)
    throws IOException
  {
    paramh.a(this.c.x());
  }

  public void b()
    throws IOException
  {
  }

  public long c()
    throws IOException
  {
    return this.c.c();
  }

  public void close()
    throws IOException
  {
    if (this.a);
    do
    {
      return;
      this.a = true;
    }
    while (this.c.c() >= this.b);
    throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.c());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.n
 * JD-Core Version:    0.6.0
 */