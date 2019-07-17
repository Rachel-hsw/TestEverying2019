package com.umeng.message.b;

import java.io.IOException;
import java.net.Socket;

final class s
  implements ab
{
  s(c paramc, ab paramab, Socket paramSocket)
  {
  }

  public long c(e parame, long paramLong)
    throws IOException
  {
    this.a.a();
    try
    {
      long l = this.b.c(parame, paramLong);
      this.a.a(true);
      return l;
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

  public ac t()
  {
    return this.a;
  }

  public String toString()
  {
    return "source(" + this.c + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.s
 * JD-Core Version:    0.6.0
 */