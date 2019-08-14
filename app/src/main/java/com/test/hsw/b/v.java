package b;

import java.io.IOException;
import java.io.OutputStream;

class v extends OutputStream
{
  v(u paramu)
  {
  }

  public void close()
    throws IOException
  {
    this.a.close();
  }

  public void flush()
    throws IOException
  {
    if (!u.a(this.a))
      this.a.b();
  }

  public String toString()
  {
    return this.a + ".outputStream()";
  }

  public void write(int paramInt)
    throws IOException
  {
    if (u.a(this.a))
      throw new IOException("closed");
    this.a.a.a((byte)paramInt);
    this.a.y();
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (u.a(this.a))
      throw new IOException("closed");
    this.a.a.b(paramArrayOfByte, paramInt1, paramInt2);
    this.a.y();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.v
 * JD-Core Version:    0.6.0
 */