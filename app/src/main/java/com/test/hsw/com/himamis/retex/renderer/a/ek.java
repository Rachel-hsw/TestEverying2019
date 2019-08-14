package com.himamis.retex.renderer.a;

public class ek extends d
{
  private float a;
  private float b;
  private int f;

  public ek(int paramInt)
  {
    this.f = paramInt;
  }

  public i a(dp paramdp)
  {
    if (this.f != 0)
    {
      float f1 = paramdp.m().h(paramdp.j());
      au localau = new au(this.a, f1, this.b);
      dk localdk = new dk(f1 * 2.0F, 0.0F, 0.0F, 0.0F);
      at localat = new at();
      for (int i = 0; ; i++)
      {
        if (i >= -1 + this.f)
        {
          if (this.f > 0)
            localat.a(localau);
          return localat;
        }
        localat.a(localau);
        localat.a(localdk);
      }
    }
    return new dk(0.0F, 0.0F, 0.0F, 0.0F);
  }

  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }

  public float b(dp paramdp)
  {
    if (this.f != 0)
      return paramdp.m().h(paramdp.j()) * (-2 + 3 * this.f);
    return 0.0F;
  }

  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ek
 * JD-Core Version:    0.6.0
 */