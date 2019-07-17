package com.a.a.a.a.b;

import com.a.a.c.d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
  implements a
{
  private static final String a = "MD5";
  private static final int b = 36;

  private byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte = localMessageDigest.digest();
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      d.a(localNoSuchAlgorithmException);
    }
    return null;
  }

  public String a(String paramString)
  {
    return new BigInteger(a(paramString.getBytes())).abs().toString(36);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.b.c
 * JD-Core Version:    0.6.0
 */