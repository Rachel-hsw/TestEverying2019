package com.a.a.b.a;

public class e
{
  private static final int a = 9;
  private static final String b = "x";
  private final int c;
  private final int d;

  public e(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % 180 == 0)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    }
    this.c = paramInt2;
    this.d = paramInt1;
  }

  public int a()
  {
    return this.c;
  }

  public e a(float paramFloat)
  {
    return new e((int)(paramFloat * this.c), (int)(paramFloat * this.d));
  }

  public e a(int paramInt)
  {
    return new e(this.c / paramInt, this.d / paramInt);
  }

  public int b()
  {
    return this.d;
  }

  public String toString()
  {
    return 9 + this.c + "x" + this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.a.e
 * JD-Core Version:    0.6.0
 */