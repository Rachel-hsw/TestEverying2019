package com.squareup.a;

import b.h;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class x
{
  public static x a(s params, File paramFile)
  {
    if (params == null)
      throw new NullPointerException("contentType == null");
    if (paramFile == null)
      throw new NullPointerException("content == null");
    return new z(params, paramFile);
  }

  public static x a(s params, String paramString)
  {
    if (params.c() != null);
    try
    {
      while (true)
      {
        x localx = a(params, paramString.getBytes(params.c().name()));
        return localx;
        params = s.a(params + "; charset=utf-8");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError();
  }

  public static x a(s params, byte[] paramArrayOfByte)
  {
    if (params == null)
      throw new NullPointerException("contentType == null");
    if (paramArrayOfByte == null)
      throw new NullPointerException("content == null");
    return new y(params, paramArrayOfByte);
  }

  public abstract s a();

  public abstract void a(h paramh)
    throws IOException;

  public long b()
  {
    return -1L;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.x
 * JD-Core Version:    0.6.0
 */