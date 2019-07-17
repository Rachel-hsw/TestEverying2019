package b;

import java.io.IOException;
import java.io.OutputStream;

final class r
  implements aa
{
  r(ac paramac, OutputStream paramOutputStream)
  {
  }

  public ac a()
  {
    return this.a;
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    ae.a(parame.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.k();
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

  public void b()
    throws IOException
  {
    this.b.flush();
  }

  public void close()
    throws IOException
  {
    this.b.close();
  }

  public String toString()
  {
    return "sink(" + this.b + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.r
 * JD-Core Version:    0.6.0
 */