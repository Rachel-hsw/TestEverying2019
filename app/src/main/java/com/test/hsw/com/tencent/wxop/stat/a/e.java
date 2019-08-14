package com.tencent.wxop.stat.a;

public enum e
{
  private int bG;

  static
  {
    bA = new e("CUSTOM", 3, 1000);
    bB = new e("ADDITION", 4, 1001);
    bC = new e("MONITOR_STAT", 5, 1002);
    bD = new e("MTA_GAME_USER", 6, 1003);
    bE = new e("NETWORK_MONITOR", 7, 1004);
    bF = new e("NETWORK_DETECTOR", 8, 1005);
    e[] arrayOfe = new e[9];
    arrayOfe[0] = bx;
    arrayOfe[1] = by;
    arrayOfe[2] = bz;
    arrayOfe[3] = bA;
    arrayOfe[4] = bB;
    arrayOfe[5] = bC;
    arrayOfe[6] = bD;
    arrayOfe[7] = bE;
    arrayOfe[8] = bF;
    bH = arrayOfe;
  }

  private e(int paramInt)
  {
    this.bG = paramInt;
  }

  public final int r()
  {
    return this.bG;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.a.e
 * JD-Core Version:    0.6.0
 */