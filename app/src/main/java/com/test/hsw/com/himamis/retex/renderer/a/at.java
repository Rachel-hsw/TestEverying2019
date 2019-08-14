package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class at extends i
{
  protected List<Integer> o;

  public at()
  {
  }

  public at(b paramb1, b paramb2)
  {
    super(paramb1, paramb2);
  }

  public at(i parami)
  {
    a(parami);
  }

  public at(i parami, float paramFloat, int paramInt)
  {
    if (paramFloat != (1.0F / 1.0F))
    {
      float f = paramFloat - parami.c();
      if (f > 0.0F)
      {
        if ((paramInt == 2) || (paramInt == 5))
        {
          dk localdk = new dk(f / 2.0F, 0.0F, 0.0F, 0.0F);
          a(localdk);
          a(parami);
          a(localdk);
          return;
        }
        if (paramInt == 0)
        {
          a(parami);
          a(new dk(f, 0.0F, 0.0F, 0.0F));
          return;
        }
        if (paramInt == 1)
        {
          a(new dk(f, 0.0F, 0.0F, 0.0F));
          a(parami);
          return;
        }
        a(parami);
        return;
      }
      a(parami);
      return;
    }
    a(parami);
  }

  private at[] a(int paramInt1, int paramInt2)
  {
    at localat1 = i();
    at localat2 = i();
    int i = 0;
    int j;
    if (i > paramInt1)
    {
      j = paramInt1 + paramInt2;
      label25: if (j < this.k.size())
        break label97;
      if (this.o == null);
    }
    for (int k = 0; ; k++)
    {
      if (k >= this.o.size())
      {
        return new at[] { localat1, localat2 };
        localat1.a((i)this.k.get(i));
        i++;
        break;
        label97: localat2.a((i)this.k.get(j));
        j++;
        break label25;
      }
      if (((Integer)this.o.get(k)).intValue() <= paramInt1 + 1)
        continue;
      localat2.a(-1 + (((Integer)this.o.get(k)).intValue() - paramInt1));
    }
  }

  private void d(i parami)
  {
    float f1 = (1.0F / -1.0F);
    this.f += parami.c();
    float f2;
    if (this.k.size() == 0)
    {
      f2 = f1;
      this.g = Math.max(f2, parami.g - parami.i);
      if (this.k.size() != 0)
        break label81;
    }
    while (true)
    {
      this.h = Math.max(f1, parami.h + parami.i);
      return;
      f2 = this.g;
      break;
      label81: f1 = this.h;
    }
  }

  public void a(int paramInt)
  {
    if (this.o == null)
      this.o = new ArrayList();
    this.o.add(Integer.valueOf(paramInt));
  }

  public final void a(int paramInt, i parami)
  {
    d(parami);
    super.a(paramInt, parami);
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    b(paramc, paramFloat1, paramFloat2);
    Iterator localIterator = this.k.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        a(paramc);
        return;
      }
      i locali = (i)localIterator.next();
      locali.a(paramc, paramFloat1, paramFloat2 + locali.i);
      paramFloat1 += locali.c();
    }
  }

  public final void a(i parami)
  {
    d(parami);
    super.a(parami);
  }

  protected at[] b(int paramInt)
  {
    return a(paramInt, 1);
  }

  protected at[] c(int paramInt)
  {
    return a(paramInt, 2);
  }

  public int h()
  {
    ListIterator localListIterator = this.k.listIterator(this.k.size());
    for (int i = -1; ; i = ((i)localListIterator.previous()).h())
      if ((i != -1) || (!localListIterator.hasPrevious()))
        return i;
  }

  public at i()
  {
    at localat = new at(this.d, this.e);
    localat.i = this.i;
    return localat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.at
 * JD-Core Version:    0.6.0
 */