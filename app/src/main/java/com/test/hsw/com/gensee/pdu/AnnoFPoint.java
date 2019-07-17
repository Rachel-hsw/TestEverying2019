package com.gensee.pdu;

public class AnnoFPoint
{
  public int x;
  public int y;

  public AnnoFPoint()
  {
  }

  public AnnoFPoint(float paramFloat1, float paramFloat2)
  {
    this.x = (int)paramFloat1;
    this.y = (int)paramFloat2;
  }

  public AnnoFPoint(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }

  public String toString()
  {
    return "AnnoFPoint [x=" + this.x + ", y=" + this.y + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoFPoint
 * JD-Core Version:    0.6.0
 */