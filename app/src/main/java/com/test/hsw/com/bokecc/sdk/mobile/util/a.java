package com.bokecc.sdk.mobile.util;

class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(0xFF & paramArrayOfByte[i]);
      if (str.length() == 1)
        localStringBuilder.append("0" + str);
      while (true)
      {
        i++;
        break;
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString().toUpperCase();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.util.a
 * JD-Core Version:    0.6.0
 */