package com.android.volley;

public class e
  implements u
{
  public static final int a = 2500;
  public static final int b = 0;
  public static final float c = 1.0F;
  private int d;
  private int e;
  private final int f;
  private final float g;

  public e()
  {
    this(2500, 0, 1.0F);
  }

  public e(int paramInt1, int paramInt2, float paramFloat)
  {
    this.d = paramInt1;
    this.f = paramInt2;
    this.g = paramFloat;
  }

  public int a()
  {
    return this.d;
  }

  public void a(x paramx)
    throws x
  {
    this.e = (1 + this.e);
    this.d = (int)(this.d + this.d * this.g);
    if (!d())
      throw paramx;
  }

  public int b()
  {
    return this.e;
  }

  public float c()
  {
    return this.g;
  }

  protected boolean d()
  {
    return this.e <= this.f;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.e
 * JD-Core Version:    0.6.0
 */