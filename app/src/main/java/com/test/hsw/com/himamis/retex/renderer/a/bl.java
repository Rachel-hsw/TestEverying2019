package com.himamis.retex.renderer.a;

import java.util.LinkedList;

public class bl extends d
{
  public static cu a = new cu(1, 0.0F, 1.0F, 0.0F);
  public static final int b = 0;
  public static final int f = 1;
  public static final int g = 2;
  private c h;
  private int i;
  private boolean j;

  public bl(c paramc, int paramInt)
  {
    this(false, paramc, paramInt);
  }

  public bl(boolean paramBoolean, c paramc, int paramInt)
  {
    this.j = paramBoolean;
    this.h = paramc;
    this.i = paramInt;
  }

  public i a(dp paramdp)
  {
    int k = 2;
    float f1 = paramdp.b();
    if ((f1 == (1.0F / 1.0F)) || (this.i == k))
      return new bg(this.j, this.h, "").a(paramdp);
    ej localej = new ej();
    d locald1 = (d)((LinkedList)this.h.a.get(0)).get(0);
    int m;
    if (this.i == 1)
      m = k;
    i locali;
    int n;
    label200: d locald2;
    while (true)
    {
      if (locald1.e != -1)
        m = locald1.e;
      localej.a(new at(locald1.a(paramdp), f1, m));
      locali = a.a(paramdp);
      n = 1;
      if (n >= -1 + this.h.c)
      {
        if (this.h.c > 1)
        {
          d locald3 = (d)((LinkedList)this.h.a.get(-1 + this.h.c)).get(0);
          if (this.i != 1)
            break;
          if (locald3.e != -1)
            k = locald3.e;
          localej.a(locali);
          localej.a(new at(locald3.a(paramdp), f1, k));
        }
        else
        {
          float f2 = localej.e() + localej.f();
          localej.c(f2 / 2.0F);
          localej.b(f2 / 2.0F);
          return localej;
          m = 0;
          continue;
        }
      }
      else
      {
        locald2 = (d)((LinkedList)this.h.a.get(n)).get(0);
        if (locald2.e == -1)
          break label361;
      }
    }
    label361: for (int i1 = locald2.e; ; i1 = k)
    {
      localej.a(locali);
      localej.a(new at(locald2.a(paramdp), f1, i1));
      n++;
      break;
      k = 1;
      break label200;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bl
 * JD-Core Version:    0.6.0
 */