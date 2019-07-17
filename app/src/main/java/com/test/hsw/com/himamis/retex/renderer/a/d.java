package com.himamis.retex.renderer.a;

public abstract class d
  implements Cloneable
{
  public int c = 0;
  public int d = 1;
  public int e = -1;

  public int a()
  {
    return this.c;
  }

  public abstract i a(dp paramdp);

  public int b()
  {
    return this.c;
  }

  public d c()
  {
    try
    {
      d locald = (d)super.clone();
      return locald;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.d
 * JD-Core Version:    0.6.0
 */