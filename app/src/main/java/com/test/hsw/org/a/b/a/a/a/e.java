package org.a.b.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class e extends a
{
  private final File a;
  private final String b;
  private final String c;

  public e(File paramFile)
  {
    this(paramFile, "application/octet-stream");
  }

  public e(File paramFile, String paramString)
  {
    this(paramFile, paramString, null);
  }

  public e(File paramFile, String paramString1, String paramString2)
  {
    this(paramFile, null, paramString1, paramString2);
  }

  public e(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    if (paramFile == null)
      throw new IllegalArgumentException("File may not be null");
    this.a = paramFile;
    if (paramString1 != null);
    for (this.b = paramString1; ; this.b = paramFile.getName())
    {
      this.c = paramString3;
      return;
    }
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    FileInputStream localFileInputStream = new FileInputStream(this.a);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localFileInputStream.close();
    }
    paramOutputStream.flush();
    localFileInputStream.close();
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
    return this.c;
  }

  public String f()
  {
    return "binary";
  }

  public long g()
  {
    return this.a.length();
  }

  public InputStream h()
    throws IOException
  {
    return new FileInputStream(this.a);
  }

  public File i()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a.e
 * JD-Core Version:    0.6.0
 */