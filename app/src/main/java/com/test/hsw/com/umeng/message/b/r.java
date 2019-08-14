package com.umeng.message.b;

import java.io.IOException;
import java.io.InputStream;

final class r
  implements ab
{
  r(ac paramac, InputStream paramInputStream)
  {
  }

  public long c(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    this.a.g();
    y localy = parame.f(1);
    int i = (int)Math.min(paramLong, 2048 - localy.d);
    int j = this.b.read(localy.b, localy.d, i);
    if (j == -1)
      return -1L;
    localy.d = (j + localy.d);
    parame.b += j;
    return j;
  }

  public void close()
    throws IOException
  {
    this.b.close();
  }

  public ac t()
  {
    return this.a;
  }

  public String toString()
  {
    return "source(" + this.b + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.r
 * JD-Core Version:    0.6.0
 */