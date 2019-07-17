package com.umeng.message.b;

import java.io.IOException;
import java.io.OutputStream;

final class p
  implements aa
{
  p(ac paramac, OutputStream paramOutputStream)
  {
  }

  public void b(e parame, long paramLong)
    throws IOException
  {
    ae.a(parame.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.g();
      y localy = parame.a;
      int i = (int)Math.min(paramLong, localy.d - localy.c);
      this.b.write(localy.b, localy.c, i);
      localy.c = (i + localy.c);
      paramLong -= i;
      parame.b -= i;
      if (localy.c != localy.d)
        continue;
      parame.a = localy.a();
      z.a.a(localy);
    }
  }

  public void close()
    throws IOException
  {
    this.b.close();
  }

  public void s()
    throws IOException
  {
    this.b.flush();
  }

  public ac t()
  {
    return this.a;
  }

  public String toString()
  {
    return "sink(" + this.b + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.p
 * JD-Core Version:    0.6.0
 */