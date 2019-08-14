package b;

import java.io.IOException;
import java.io.InputStream;

class x extends InputStream
{
  x(w paramw)
  {
  }

  public int available()
    throws IOException
  {
    if (w.a(this.a))
      throw new IOException("closed");
    return (int)Math.min(this.a.a.b, 2147483647L);
  }

  public void close()
    throws IOException
  {
    this.a.close();
  }

  public int read()
    throws IOException
  {
    if (w.a(this.a))
      throw new IOException("closed");
    if ((this.a.a.b == 0L) && (this.a.b.b(this.a.a, 2048L) == -1L))
      return -1;
    return 0xFF & this.a.a.j();
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (w.a(this.a))
      throw new IOException("closed");
    ae.a(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.a.a.b == 0L) && (this.a.b.b(this.a.a, 2048L) == -1L))
      return -1;
    return this.a.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }

  public String toString()
  {
    return this.a + ".inputStream()";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.x
 * JD-Core Version:    0.6.0
 */