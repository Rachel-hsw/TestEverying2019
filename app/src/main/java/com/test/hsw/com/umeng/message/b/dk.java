package com.umeng.message.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class dk
{
  public static int a;

  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException, DataFormatException
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return null;
    Inflater localInflater = new Inflater();
    byte[] arrayOfByte = new byte[100];
    localInflater.setInput(paramArrayOfByte, 0, paramArrayOfByte.length);
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      if (localInflater.needsInput())
      {
        localInflater.end();
        return localStringBuilder.toString();
      }
      localStringBuilder.append(new String(arrayOfByte, 0, localInflater.inflate(arrayOfByte), paramString));
    }
  }

  public static byte[] a(String paramString1, String paramString2)
    throws IOException
  {
    if (dl.d(paramString1))
      return null;
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramString1.getBytes(paramString2));
    localDeflater.finish();
    byte[] arrayOfByte = new byte[8192];
    a = 0;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        while (true)
        {
          if (localDeflater.finished())
          {
            localDeflater.end();
            if (localByteArrayOutputStream != null)
              localByteArrayOutputStream.close();
            return localByteArrayOutputStream.toByteArray();
          }
          int i = localDeflater.deflate(arrayOfByte);
          a = i + a;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
      }
      finally
      {
      }
      if (localByteArrayOutputStream != null)
        localByteArrayOutputStream.close();
      throw localObject1;
    }
    finally
    {
      Object localObject2 = localObject3;
      ByteArrayOutputStream localByteArrayOutputStream = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dk
 * JD-Core Version:    0.6.0
 */