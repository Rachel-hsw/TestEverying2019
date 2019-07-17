package com.ta.utdid2.b.a;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte2 = a(paramString1.getBytes());
      byte[] arrayOfByte3 = paramString2.getBytes();
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(new byte[localCipher.getBlockSize()]));
      byte[] arrayOfByte4 = localCipher.doFinal(arrayOfByte3);
      arrayOfByte1 = arrayOfByte4;
      String str = null;
      if (arrayOfByte1 != null)
        str = b(arrayOfByte1);
      return str;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        byte[] arrayOfByte1 = null;
      }
    }
  }

  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }

  public static String b(String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte1 = a(paramString1.getBytes());
      int i = paramString2.length() / 2;
      byte[] arrayOfByte2 = new byte[i];
      for (int j = 0; j < i; j++)
        arrayOfByte2[j] = Integer.valueOf(paramString2.substring(j * 2, 2 + j * 2), 16).byteValue();
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, localSecretKeySpec, new IvParameterSpec(new byte[localCipher.getBlockSize()]));
      String str = new String(localCipher.doFinal(arrayOfByte2));
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer(2 * paramArrayOfByte.length);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i];
      localStringBuffer.append("0123456789ABCDEF".charAt(0xF & j >> 4)).append("0123456789ABCDEF".charAt(j & 0xF));
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.a
 * JD-Core Version:    0.6.0
 */