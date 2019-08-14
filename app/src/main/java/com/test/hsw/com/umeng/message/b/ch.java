package com.umeng.message.b;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ch
{
  public static final int a = 128;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  private static final String e = "AES/CBC/PKCS5Padding";
  private static byte[] f = { 82, 22, 50, 44, -16, 124, -40, -114, -87, -40, 37, 23, -56, 23, -33, 75 };
  private static ThreadLocal<Cipher> g = new ThreadLocal();
  private static final AlgorithmParameterSpec h = new IvParameterSpec(f);
  private static final SecureRandom i = new SecureRandom();
  private static final String j = "HmacSHA1";

  public static final String a(String paramString1, String paramString2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString1.getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(localSecretKeySpec);
      String str = cd.a(localMac.doFinal(paramString2.getBytes()));
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = a(paramString1.getBytes(), paramInt);
      String str = cd.a(a(paramString2.getBytes("utf-8"), localSecretKeySpec), 8);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static final Cipher a()
  {
    Object localObject = (Cipher)g.get();
    if (localObject == null);
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localObject = localCipher;
      g.set(localObject);
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("get Chipher error:" + localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException);
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
    }
    throw new RuntimeException("get Chipher error:" + localNoSuchPaddingException.getMessage(), localNoSuchPaddingException);
  }

  private static final Cipher a(SecretKeySpec paramSecretKeySpec, int paramInt)
  {
    Cipher localCipher = a();
    try
    {
      localCipher.init(paramInt, paramSecretKeySpec, h, i);
      return localCipher;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new RuntimeException("init Chipher error:" + localInvalidKeyException.getMessage(), localInvalidKeyException);
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      throw new RuntimeException("init Chipher error:" + localInvalidAlgorithmParameterException.getMessage(), localInvalidAlgorithmParameterException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    throw new RuntimeException("init Chipher error:" + localIllegalArgumentException.getMessage(), localIllegalArgumentException);
  }

  private static final SecretKeySpec a(byte[] paramArrayOfByte, int paramInt)
    throws IllegalArgumentException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("secret key can not be null");
    byte[] arrayOfByte = new byte[16];
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return new SecretKeySpec(arrayOfByte, "AES");
      if (128 == 8 * paramArrayOfByte.length)
        continue;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 16);
      continue;
      System.arraycopy(b(paramArrayOfByte), 0, arrayOfByte, 0, 16);
      continue;
      arrayOfByte = a(paramArrayOfByte);
    }
  }

  private static final byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte = localMessageDigest.digest();
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
    }
    throw new RuntimeException("md5 value Throwable", localThrowable);
  }

  private static final byte[] a(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec)
    throws IllegalArgumentException
  {
    try
    {
      byte[] arrayOfByte = a(paramSecretKeySpec, 1).doFinal(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new IllegalArgumentException("AES decrypt error:" + localIllegalBlockSizeException.getMessage(), localIllegalBlockSizeException);
    }
    catch (BadPaddingException localBadPaddingException)
    {
    }
    throw new IllegalArgumentException("AES decrypt error:" + localBadPaddingException.getMessage(), localBadPaddingException);
  }

  public static final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = b(paramArrayOfByte1, a(paramArrayOfByte2, paramInt));
      return arrayOfByte;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    throw new IllegalArgumentException("AES encrypt error:" + localIllegalArgumentException.getMessage(), localIllegalArgumentException);
  }

  public static final String b(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = a(paramString1.getBytes(), paramInt);
      String str = new String(b(cd.a(paramString2, 8), localSecretKeySpec), "utf-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static final byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    for (int k = 0; k < paramArrayOfByte.length; k++)
      arrayOfByte[k] = paramArrayOfByte[(-1 + paramArrayOfByte.length - k)];
    return arrayOfByte;
  }

  private static final byte[] b(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec)
    throws IllegalArgumentException
  {
    try
    {
      byte[] arrayOfByte = a(paramSecretKeySpec, 2).doFinal(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new IllegalArgumentException("AES decrypt error:" + localIllegalBlockSizeException.getMessage(), localIllegalBlockSizeException);
    }
    catch (BadPaddingException localBadPaddingException)
    {
    }
    throw new IllegalArgumentException("AES decrypt error:" + localBadPaddingException.getMessage(), localBadPaddingException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ch
 * JD-Core Version:    0.6.0
 */