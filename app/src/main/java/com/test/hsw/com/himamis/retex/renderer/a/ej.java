package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class ej extends i
{
  private float o = 3.4028235E+38F;
  private float p = 1.4E-45F;

  public ej()
  {
  }

  public ej(i parami, float paramFloat, int paramInt)
  {
    this();
    a(parami);
    if (paramInt == 2)
    {
      dk localdk = new dk(0.0F, paramFloat / 2.0F, 0.0F, 0.0F);
      super.a(0, localdk);
      this.g += paramFloat / 2.0F;
      this.h += paramFloat / 2.0F;
      super.a(localdk);
    }
    do
    {
      return;
      if (paramInt != 3)
        continue;
      this.h = (paramFloat + this.h);
      super.a(new dk(0.0F, paramFloat, 0.0F, 0.0F));
      return;
    }
    while (paramInt != 4);
    this.g = (paramFloat + this.g);
    super.a(0, new dk(0.0F, paramFloat, 0.0F, 0.0F));
  }

  private void d(i parami)
  {
    this.o = Math.min(this.o, parami.i);
    float f1 = this.p;
    float f2 = parami.i;
    boolean bool = parami.f < 0.0F;
    float f3 = 0.0F;
    if (bool)
      f3 = parami.f;
    this.p = Math.max(f1, f3 + f2);
    this.f = (this.p - this.o);
  }

  public void a(int paramInt, i parami)
  {
    super.a(paramInt, parami);
    if (paramInt == 0)
    {
      this.h += parami.h + this.g;
      this.g = parami.g;
    }
    while (true)
    {
      d(parami);
      return;
      this.h += parami.g + parami.h;
    }
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat2 - this.g;
    Iterator localIterator = this.k.iterator();
    float f2 = f1;
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      i locali = (i)localIterator.next();
      float f3 = f2 + locali.e();
      locali.a(paramc, paramFloat1 + locali.g() - this.o, f3);
      f2 = f3 + locali.f();
    }
  }

  public final void a(i parami)
  {
    super.a(parami);
    if (this.k.size() == 1)
    {
      this.g = parami.g;
      this.h = parami.h;
    }
    while (true)
    {
      d(parami);
      return;
      this.h += parami.g + parami.h;
    }
  }

  public final void a(i parami, float paramFloat)
  {
    if (this.k.size() >= 1)
      a(new dk(0.0F, paramFloat, 0.0F, 0.0F));
    a(parami);
  }

  public int h()
  {
    ListIterator localListIterator = this.k.listIterator(this.k.size());
    for (int i = -1; ; i = ((i)localListIterator.previous()).h())
      if ((i != -1) || (!localListIterator.hasPrevious()))
        return i;
  }

  public int i()
  {
    return this.k.size();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ej
 * JD-Core Version:    0.6.0
 */