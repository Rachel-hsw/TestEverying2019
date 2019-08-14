package com.alipay.security.mobile.module.a.a;

import com.alipay.security.mobile.module.a.a;
import java.security.MessageDigest;

public final class b
{
  public static String a(String paramString)
  {
    int i = 0;
    try
    {
      if (a.a(paramString))
        return null;
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < arrayOfByte.length)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte[i]);
        localStringBuilder.append(String.format("%02x", arrayOfObject));
        i++;
      }
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.a.a.b
 * JD-Core Version:    0.6.0
 */