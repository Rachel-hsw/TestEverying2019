package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;
import com.himamis.retex.renderer.a.g.c.g;

public class aq extends i
{
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  private g r;
  private float s;
  private int t;

  public aq(g paramg, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.r = paramg;
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.s = (1.0F / paramFloat3);
    this.h = 0.0F;
    this.i = 0.0F;
    switch (paramInt)
    {
    default:
      this.t = -1;
      return;
    case 0:
      this.t = 4;
      return;
    case 1:
      this.t = 5;
      return;
    case 2:
    }
    this.t = 6;
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    paramc.g();
    int i;
    if (this.t != -1)
    {
      i = paramc.a(4);
      paramc.a(4, this.t);
    }
    while (true)
    {
      paramc.a(paramFloat1, paramFloat2 - this.g);
      paramc.b(this.s, this.s);
      paramc.a(this.r, 0, 0);
      paramc.h();
      if (i != -1)
        paramc.a(4, i);
      return;
      i = -1;
    }
  }

  public int h()
  {
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.aq
 * JD-Core Version:    0.6.0
 */