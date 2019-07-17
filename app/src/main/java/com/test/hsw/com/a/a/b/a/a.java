package com.a.a.b.a;

import java.io.IOException;
import java.io.InputStream;

public class a extends InputStream
{
  private final InputStream a;
  private final int b;

  public a(InputStream paramInputStream, int paramInt)
  {
    this.a = paramInputStream;
    this.b = paramInt;
  }

  public int available()
  {
    return this.b;
  }

  public void close()
    throws IOException
  {
    this.a.close();
  }

  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }

  public boolean markSupported()
  {
    return this.a.markSupported();
  }

  public int read()
    throws IOException
  {
    return this.a.read();
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.a.read(paramArrayOfByte);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void reset()
    throws IOException
  {
    this.a.reset();
  }

  public long skip(long paramLong)
    throws IOException
  {
    return this.a.skip(paramLong);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.a.a
 * JD-Core Version:    0.6.0
 */