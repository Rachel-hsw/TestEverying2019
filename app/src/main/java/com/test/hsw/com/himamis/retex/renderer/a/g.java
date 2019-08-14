package com.himamis.retex.renderer.a;

public class g
{
  private int a = 0;

  public void a(int paramInt)
  {
    this.a |= 1 << paramInt;
  }

  public boolean b(int paramInt)
  {
    return (0x1 & this.a >> paramInt) == 1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.g
 * JD-Core Version:    0.6.0
 */