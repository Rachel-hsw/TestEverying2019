package com.umeng.message.b;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class dg
{
  private static byte[] a = "uLi4/f4+Pb39.T19".getBytes();
  private static byte[] b = "nmeug.f9/Om+L823".getBytes();

  public static String a(String paramString1, String paramString2)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
    return new String(localCipher.doFinal(dh.b(paramString1)), paramString2);
  }

  public static String a(String[] paramArrayOfString)
    throws Exception
  {
    String str1 = null;
    String str3;
    String str2;
    if (paramArrayOfString.length == 2)
    {
      str3 = paramArrayOfString[0];
      str2 = paramArrayOfString[1];
    }
    while (true)
    {
      if ((str1 != null) && (str1.length() == 16))
        a = str1.getBytes();
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
      return dh.d(localCipher.doFinal(str3.getBytes(str2)));
      if (paramArrayOfString.length == 3)
      {
        str3 = paramArrayOfString[0];
        str2 = paramArrayOfString[1];
        str1 = paramArrayOfString[2];
        continue;
      }
      str1 = null;
      str2 = null;
      str3 = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dg
 * JD-Core Version:    0.6.0
 */