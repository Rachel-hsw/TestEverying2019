package org.a.b.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class g extends a
{
  private final byte[] a;
  private final Charset b;

  public g(String paramString)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", null);
  }

  public g(String paramString1, String paramString2, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    super(paramString2);
    if (paramString1 == null)
      throw new IllegalArgumentException("Text may not be null");
    if (paramCharset == null)
      paramCharset = Charset.forName("US-ASCII");
    this.a = paramString1.getBytes(paramCharset.name());
    this.b = paramCharset;
  }

  public g(String paramString, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", paramCharset);
  }

  public static g a(String paramString)
    throws IllegalArgumentException
  {
    return a(paramString, null, null);
  }

  public static g a(String paramString1, String paramString2, Charset paramCharset)
    throws IllegalArgumentException
  {
    try
    {
      g localg = new g(paramString1, paramString2, paramCharset);
      return localg;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new IllegalArgumentException("Charset " + paramCharset + " is not supported", localUnsupportedEncodingException);
  }

  public static g a(String paramString, Charset paramCharset)
    throws IllegalArgumentException
  {
    return a(paramString, null, paramCharset);
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.a);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i = localByteArrayInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
  }

  @Deprecated
  public void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    a(paramOutputStream);
  }

  public String d()
  {
    return null;
  }

  public String e()
  {
    return this.b.name();
  }

  public String f()
  {
    return "8bit";
  }

  public long g()
  {
    return this.a.length;
  }

  public Reader h()
  {
    return new InputStreamReader(new ByteArrayInputStream(this.a), this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a.g
 * JD-Core Version:    0.6.0
 */