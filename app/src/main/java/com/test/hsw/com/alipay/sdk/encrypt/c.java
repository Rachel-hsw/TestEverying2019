package com.alipay.sdk.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  private static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = b(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      String str = b(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  private static String b(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(2 * paramArrayOfByte.length);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      localStringBuffer.append(Character.forDigit((0xF0 & paramArrayOfByte[i]) >> 4, 16));
      localStringBuffer.append(Character.forDigit(0xF & paramArrayOfByte[i], 16));
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.encrypt.c
 * JD-Core Version:    0.6.0
 */