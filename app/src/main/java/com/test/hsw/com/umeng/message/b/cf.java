package com.umeng.message.b;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class cf
{
  private static final String a = "SHA-1";
  private static final String b = "MD5";
  private static final String c = "SHA-256";

  public static final String a(InputStream paramInputStream)
  {
    try
    {
      String str = a(paramInputStream, "MD5");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static String a(InputStream paramInputStream, String paramString)
    throws IOException
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte[1024];
      for (int i = paramInputStream.read(arrayOfByte, 0, 1024); i > -1; i = paramInputStream.read(arrayOfByte, 0, 1024))
        localMessageDigest.update(arrayOfByte, 0, i);
      String str = ck.a(localMessageDigest.digest());
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      String str = a(paramString.getBytes("UTF-8"), "MD5");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, "SHA-256");
  }

  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      String str = ck.a(localMessageDigest.digest());
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String b(InputStream paramInputStream)
  {
    try
    {
      String str = a(paramInputStream, "SHA-1");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      String str = a(paramString.getBytes("UTF-8"), "SHA-1");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String c(InputStream paramInputStream)
  {
    try
    {
      String str = a(paramInputStream, "SHA-256");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      String str = a(paramString.getBytes("UTF-8"), "SHA-256");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cf
 * JD-Core Version:    0.6.0
 */