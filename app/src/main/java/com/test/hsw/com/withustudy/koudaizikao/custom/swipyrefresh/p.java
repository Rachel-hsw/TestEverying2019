package com.withustudy.koudaizikao.custom.swipyrefresh;

public enum p
{
  private int d;

  static
  {
    p[] arrayOfp = new p[3];
    arrayOfp[0] = a;
    arrayOfp[1] = b;
    arrayOfp[2] = c;
    e = arrayOfp;
  }

  private p(int arg3)
  {
    int j;
    this.d = j;
  }

  public static p a(int paramInt)
  {
    p[] arrayOfp = values();
    int i = arrayOfp.length;
    for (int j = 0; ; j++)
    {
      p localp;
      if (j >= i)
        localp = c;
      do
      {
        return localp;
        localp = arrayOfp[j];
      }
      while (localp.d == paramInt);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.p
 * JD-Core Version:    0.6.0
 */