package com.umeng.message.b;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class ck
{
  private static final String a = "0123456789ABCDEF";

  private static final byte a(byte paramByte1, byte paramByte2)
  {
    return (byte)((byte)(Byte.decode("0x" + new String(new byte[] { paramByte1 })).byteValue() << 4) | Byte.decode("0x" + new String(new byte[] { paramByte2 })).byteValue());
  }

  private static final byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }

  public static final String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramString.length(); i++)
      localStringBuffer.append(Integer.toHexString(paramString.charAt(i)));
    return localStringBuffer.toString();
  }

  public static final String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      return null;
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      String str = Integer.toHexString(0xFF & paramArrayOfByte[i]);
      if (str.length() < 2)
        localStringBuilder.append(0);
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  public static final String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    byte[] arrayOfByte = paramString.getBytes();
    StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte.length);
    for (int i = 0; i < arrayOfByte.length; i++)
    {
      localStringBuilder.append("0123456789ABCDEF".charAt((0xF0 & arrayOfByte[i]) >> 4));
      localStringBuilder.append("0123456789ABCDEF".charAt((0xF & arrayOfByte[i]) >> 0));
    }
    return localStringBuilder.toString();
  }

  public static final String c(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length() / 2);
    for (int i = 0; i < paramString.length(); i += 2)
      localByteArrayOutputStream.write("0123456789ABCDEF".indexOf(paramString.charAt(i)) << 4 | "0123456789ABCDEF".indexOf(paramString.charAt(i + 1)));
    return new String(localByteArrayOutputStream.toByteArray());
  }

  public static final byte[] d(String paramString)
  {
    byte[] arrayOfByte1 = new byte[6];
    byte[] arrayOfByte2 = paramString.getBytes();
    for (int i = 0; i < 6; i++)
      arrayOfByte1[i] = a(arrayOfByte2[(i * 2)], arrayOfByte2[(1 + i * 2)]);
    return arrayOfByte1;
  }

  public static final byte[] e(String paramString)
  {
    byte[] arrayOfByte;
    if ((paramString == null) || (paramString.equals("")))
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      String str = paramString.toUpperCase();
      int i = str.length() / 2;
      char[] arrayOfChar = str.toCharArray();
      arrayOfByte = new byte[i];
      for (int j = 0; j < i; j++)
      {
        int k = j * 2;
        arrayOfByte[j] = (byte)(a(arrayOfChar[k]) << 4 | a(arrayOfChar[(k + 1)]));
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ck
 * JD-Core Version:    0.6.0
 */