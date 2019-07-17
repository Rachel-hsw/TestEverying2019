package com.tencent.wxop.stat;

public enum d
{
  int aI;

  static
  {
    d[] arrayOfd = new d[7];
    arrayOfd[0] = aB;
    arrayOfd[1] = aC;
    arrayOfd[2] = aD;
    arrayOfd[3] = aE;
    arrayOfd[4] = aF;
    arrayOfd[5] = aG;
    arrayOfd[6] = aH;
    aJ = arrayOfd;
  }

  private d(int paramInt)
  {
    this.aI = paramInt;
  }

  public static d a(int paramInt)
  {
    for (d locald : values())
      if (paramInt == locald.aI)
        return locald;
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.d
 * JD-Core Version:    0.6.0
 */