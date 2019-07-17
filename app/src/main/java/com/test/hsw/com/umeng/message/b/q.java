package com.umeng.message.b;

import java.io.IOException;
import java.net.Socket;

final class q
  implements aa
{
  q(c paramc, aa paramaa, Socket paramSocket)
  {
  }

  public void b(e parame, long paramLong)
    throws IOException
  {
    this.a.a();
    try
    {
      this.b.b(parame, paramLong);
      this.a.a(true);
      return;
    }
    finally
    {
      this.a.a(false);
    }
    throw localObject;
  }

  public void close()
    throws IOException
  {
    this.a.a();
    try
    {
      this.b.close();
      this.a.a(true);
      return;
    }
    finally
    {
      this.a.a(false);
    }
    throw localObject;
  }

  public void s()
    throws IOException
  {
    this.a.a();
    try
    {
      this.b.s();
      this.a.a(true);
      return;
    }
    finally
    {
      this.a.a(false);
    }
    throw localObject;
  }

  public ac t()
  {
    return this.a;
  }

  public String toString()
  {
    return "sink(" + this.c + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.q
 * JD-Core Version:    0.6.0
 */