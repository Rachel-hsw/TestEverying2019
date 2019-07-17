package b;

import java.io.IOException;
import java.io.InputStream;

final class s
  implements ab
{
  s(ac paramac, InputStream paramInputStream)
  {
  }

  public ac a()
  {
    return this.a;
  }

  public long b(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    this.a.k();
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

  public String toString()
  {
    return "source(" + this.b + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.s
 * JD-Core Version:    0.6.0
 */