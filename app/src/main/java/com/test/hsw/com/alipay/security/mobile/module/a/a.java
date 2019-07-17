package com.alipay.security.mobile.module.a;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class a
{
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null);
    String str;
    do
    {
      return paramString2;
      str = (String)paramMap.get(paramString1);
    }
    while (str == null);
    return str;
  }

  public static boolean a(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0);
    }
    else
    {
      i = 1;
      return i;
    }
    for (int k = 0; ; k++)
    {
      if (k >= j)
        break label47;
      boolean bool = Character.isWhitespace(paramString.charAt(k));
      i = 0;
      if (!bool)
        break;
    }
    label47: return true;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2 == null;
    return paramString1.equals(paramString2);
  }

  public static String b(String paramString)
  {
    int i = 0;
    try
    {
      if (a(paramString))
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

  public static String c(String paramString)
  {
    try
    {
      byte[] arrayOfByte1 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramString.length()).array();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      byte[] arrayOfByte2 = new byte[4 + localByteArrayOutputStream.toByteArray().length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
      System.arraycopy(localByteArrayOutputStream.toByteArray(), 0, arrayOfByte2, 4, localByteArrayOutputStream.toByteArray().length);
      String str = Base64.encodeToString(arrayOfByte2, 8);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.a.a
 * JD-Core Version:    0.6.0
 */