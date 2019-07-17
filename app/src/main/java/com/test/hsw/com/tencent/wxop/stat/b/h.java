package com.tencent.wxop.stat.b;

public class h
{
  static
  {
    if (!h.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      cH = bool;
      return;
    }
  }

  public static byte[] d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    j localj = new j(new byte[i * 3 / 4]);
    if (!localj.a(paramArrayOfByte, i))
      throw new IllegalArgumentException("bad base-64");
    if (localj.g == localj.cI.length)
      return localj.cI;
    byte[] arrayOfByte = new byte[localj.g];
    System.arraycopy(localj.cI, 0, arrayOfByte, 0, localj.g);
    return arrayOfByte;
  }

  public static byte[] e(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    k localk = new k();
    int j = 4 * (i / 3);
    int k;
    if (localk.ba)
    {
      if (i % 3 > 0)
        j += 4;
      if ((localk.bb) && (i > 0))
      {
        k = 1 + (i - 1) / 57;
        if (!localk.cP)
          break label151;
      }
    }
    label151: for (int m = 2; ; m = 1)
    {
      j += m * k;
      localk.cI = new byte[j];
      localk.a(paramArrayOfByte, i);
      if ((cH) || (localk.g == j))
        break label157;
      throw new AssertionError();
      switch (i % 3)
      {
      case 0:
      default:
        break;
      case 1:
        j += 2;
        break;
      case 2:
        j += 3;
        break;
      }
    }
    label157: return localk.cI;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.h
 * JD-Core Version:    0.6.0
 */