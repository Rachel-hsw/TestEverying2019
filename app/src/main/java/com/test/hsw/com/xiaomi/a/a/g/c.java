package com.xiaomi.a.a.g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  private static String a(byte paramByte)
  {
    int i = paramByte & 0x7F;
    int j;
    int k;
    StringBuilder localStringBuilder;
    if (paramByte < 0)
    {
      j = 128;
      k = i + j;
      localStringBuilder = new StringBuilder();
      if (k >= 16)
        break label62;
    }
    label62: for (String str = "0"; ; str = "")
    {
      return str + Integer.toHexString(k).toLowerCase();
      j = 0;
      break;
    }
  }

  public static String a(String paramString)
  {
    int i = 0;
    StringBuffer localStringBuffer;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localStringBuffer = new StringBuffer();
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      byte[] arrayOfByte = localMessageDigest.digest();
      while (i < arrayOfByte.length)
      {
        localStringBuffer.append(a(arrayOfByte[i]));
        i++;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    return localStringBuffer.toString();
  }

  public static String b(String paramString)
  {
    return a(paramString).subSequence(8, 24).toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.g.c
 * JD-Core Version:    0.6.0
 */