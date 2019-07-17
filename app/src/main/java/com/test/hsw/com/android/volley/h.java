package com.android.volley;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class h
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();

  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      localMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
      String str = a(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return new String(arrayOfChar);
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(1 + i * 2)] = a[(j & 0xF)];
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.h
 * JD-Core Version:    0.6.0
 */