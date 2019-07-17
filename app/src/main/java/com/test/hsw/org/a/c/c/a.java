package org.a.c.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a extends d
{
  protected InputStream a = null;
  protected OutputStream b = null;

  protected a()
  {
  }

  public a(OutputStream paramOutputStream)
  {
    this.b = paramOutputStream;
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a == null)
      throw new e(1, "Cannot read from null inputStream");
    int i;
    try
    {
      i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i < 0)
        throw new e(4);
    }
    catch (IOException localIOException)
    {
      throw new e(0, localIOException);
    }
    return i;
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b == null)
      throw new e(1, "Cannot write to null outputStream");
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(0, localIOException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.c.a
 * JD-Core Version:    0.6.0
 */