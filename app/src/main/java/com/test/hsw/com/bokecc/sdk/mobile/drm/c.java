package com.bokecc.sdk.mobile.drm;

class c
{
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(2048);
    for (int i = 0; i < paramArrayOfByte.length; i++)
      localStringBuffer.append((char)paramArrayOfByte[i]);
    return localStringBuffer.toString();
  }

  public static int b(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      j += (0xFF & paramArrayOfByte[i]);
      i++;
    }
    return j;
  }

  public static long c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 8)
      return 0L;
    return (0xFF & paramArrayOfByte[0]) << 56 | (0xFF & paramArrayOfByte[1]) << 48 | (0xFF & paramArrayOfByte[2]) << 40 | (0xFF & paramArrayOfByte[3]) << 32 | (0xFF & paramArrayOfByte[4]) << 24 | (0xFF & paramArrayOfByte[5]) << 16 | (0xFF & paramArrayOfByte[6]) << 8 | (0xFF & paramArrayOfByte[7]) << 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.c
 * JD-Core Version:    0.6.0
 */