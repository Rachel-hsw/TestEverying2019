package org.a.b.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f extends a
{
  private final InputStream a;
  private final String b;

  public f(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, "application/octet-stream", paramString);
  }

  public f(InputStream paramInputStream, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramInputStream == null)
      throw new IllegalArgumentException("Input stream may not be null");
    this.a = paramInputStream;
    this.b = paramString2;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = this.a.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      this.a.close();
    }
    paramOutputStream.flush();
    this.a.close();
  }

  @Deprecated
  public void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    a(paramOutputStream);
  }

  public String d()
  {
    return this.b;
  }

  public String e()
  {
    return null;
  }

  public String f()
  {
    return "binary";
  }

  public long g()
  {
    return -1L;
  }

  public InputStream h()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a.f
 * JD-Core Version:    0.6.0
 */