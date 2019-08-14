package org.a.b.a.a.a;

import java.io.IOException;
import java.io.OutputStream;

public class b extends a
{
  private final byte[] a;
  private final String b;

  public b(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, "application/octet-stream", paramString);
  }

  public b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("byte[] may not be null");
    this.a = paramArrayOfByte;
    this.b = paramString2;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.a);
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
    return this.a.length;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a.b
 * JD-Core Version:    0.6.0
 */