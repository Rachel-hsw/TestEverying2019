package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b
{
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "DES");
      Cipher localCipher = Cipher.getInstance("DES");
      localCipher.init(paramInt, localSecretKeySpec);
      if (paramInt == 2);
      byte[] arrayOfByte2;
      for (byte[] arrayOfByte1 = a.a(paramString1); ; arrayOfByte1 = paramString1.getBytes("UTF-8"))
      {
        arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
        if (paramInt != 2)
          break;
        return new String(arrayOfByte2);
      }
      String str = a.a(arrayOfByte2);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String a(String paramString1, String paramString2)
  {
    return a(1, paramString1, paramString2);
  }

  private static String b(String paramString1, String paramString2)
  {
    return a(2, paramString1, paramString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.encrypt.b
 * JD-Core Version:    0.6.0
 */