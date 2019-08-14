package com.umeng.socialize.b.b;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static byte[] a = null;
  private static byte[] b = "nmeug.f9/Om+L823".getBytes();
  private static final String c = "UTF-8";

  private static IllegalStateException a(String paramString, UnsupportedEncodingException paramUnsupportedEncodingException)
  {
    return new IllegalStateException(paramString + ": " + paramUnsupportedEncodingException);
  }

  public static String a(String paramString1, String paramString2)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
    int i = localCipher.getBlockSize();
    byte[] arrayOfByte1 = paramString1.getBytes(paramString2);
    int j = arrayOfByte1.length;
    if (j % i != 0)
      j += i - j % i;
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    localCipher.init(1, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
    return b.a(localCipher.doFinal(arrayOfByte2));
  }

  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, "UTF-8");
  }

  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null)
      return null;
    try
    {
      String str = new String(paramArrayOfByte, paramString);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw a(paramString, localUnsupportedEncodingException);
  }

  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = c(paramString);
      if (str.length() >= 16)
        str = str.substring(0, 16);
      a = str.getBytes();
    }
  }

  public static String b(String paramString1, String paramString2)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
    localCipher.init(2, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
    return new String(localCipher.doFinal(b.a(paramString1)), paramString2);
  }

  public static byte[] b(String paramString)
  {
    return c(paramString, "UTF-8");
  }

  public static String c(String paramString)
  {
    int i = 0;
    if (paramString == null)
      return null;
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      while (i < arrayOfByte2.length)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte2[i]);
        localStringBuffer.append(String.format("%02X", arrayOfObject));
        i++;
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
  }

  public static byte[] c(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return null;
    try
    {
      byte[] arrayOfByte = paramString1.getBytes(paramString2);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw a(paramString2, localUnsupportedEncodingException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.a
 * JD-Core Version:    0.6.0
 */