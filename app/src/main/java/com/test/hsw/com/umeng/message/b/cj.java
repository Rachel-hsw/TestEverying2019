package com.umeng.message.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cj
{
  protected static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest b = null;

  static
  {
    try
    {
      b = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
  }

  public static final String a(File paramFile)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    MappedByteBuffer localMappedByteBuffer = localFileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramFile.length());
    b.update(localMappedByteBuffer);
    byte[] arrayOfByte = b.digest();
    localFileInputStream.close();
    return a(arrayOfByte);
  }

  private static final String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  private static final String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      a(paramArrayOfByte[paramInt1], localStringBuffer);
      paramInt1++;
    }
    return localStringBuffer.toString();
  }

  private static final void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = a[((paramByte & 0xF0) >> 4)];
    char c2 = a[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cj
 * JD-Core Version:    0.6.0
 */