package com.tencent.open.utils;

public class DataConvert
{
  public static byte[] intToBytes2(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    for (int i = 0; i < 4; i++)
      arrayOfByte[i] = (byte)(paramInt >> 24 - i * 8);
    return arrayOfByte;
  }

  public static int putBytes2Bytes(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    for (int i = 0; i < paramInt1; i++)
      paramArrayOfByte2[(paramInt2 + i)] = paramArrayOfByte1[i];
    return paramArrayOfByte1.length;
  }

  public static int putBytes2Bytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    for (int i = 0; i < paramArrayOfByte1.length; i++)
      paramArrayOfByte2[(paramInt + i)] = paramArrayOfByte1[i];
    return paramArrayOfByte1.length;
  }

  public static int putInt2Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    byte[] arrayOfByte = intToBytes2(paramInt1);
    for (int i = 0; i < arrayOfByte.length; i++)
      paramArrayOfByte[(paramInt2 + i)] = arrayOfByte[i];
    return arrayOfByte.length;
  }

  public static int putShort2Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    byte[] arrayOfByte = intToBytes2(paramInt1);
    paramArrayOfByte[(paramInt2 + 0)] = arrayOfByte[2];
    paramArrayOfByte[(paramInt2 + 1)] = arrayOfByte[3];
    return 2;
  }

  public static int putString2Bytes(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = string2bytes(paramString);
    for (int i = 0; i < arrayOfByte.length; i++)
      paramArrayOfByte[(paramInt + i)] = arrayOfByte[i];
    return arrayOfByte.length;
  }

  public static byte[] string2bytes(String paramString)
  {
    String str = paramString.replace(" ", "");
    int i = str.length();
    int j = i / 2;
    if (i % 2 == 1)
    {
      str = "0" + str;
      (i + 1);
      j++;
    }
    byte[] arrayOfByte = new byte[j];
    for (int k = 0; k < j; k++)
      arrayOfByte[k] = (byte)Integer.parseInt(str.substring(k * 2, 2 + k * 2), 16);
    return arrayOfByte;
  }

  public static String toHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfByte.length);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      String str = Integer.toString(0xFF & paramArrayOfByte[i], 16);
      if (str.length() == 1)
        str = "0" + str;
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.DataConvert
 * JD-Core Version:    0.6.0
 */