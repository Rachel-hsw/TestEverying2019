package com.ta.utdid2.b.a;

public final class d
{
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[3] = (byte)(paramInt % 256);
    int i = paramInt >> 8;
    arrayOfByte[2] = (byte)(i % 256);
    int j = i >> 8;
    arrayOfByte[1] = (byte)(j % 256);
    arrayOfByte[0] = (byte)((j >> 8) % 256);
    return arrayOfByte;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.d
 * JD-Core Version:    0.6.0
 */