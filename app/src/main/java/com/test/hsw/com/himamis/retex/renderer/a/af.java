package com.himamis.retex.renderer.a;

import java.util.List;

public class af extends d
{
  private static final int a = 901;
  private static final float b = 5.0F;
  private final d f;
  private dm g = null;
  private dm h = null;
  private final List<bi> i;

  public af(d paramd, dm paramdm1, dm paramdm2)
  {
    this(paramd, paramdm1, null, paramdm2);
  }

  public af(d paramd, dm paramdm1, List paramList, dm paramdm2)
  {
    if (paramd == null);
    for (this.f = new cl(); ; this.f = paramd)
    {
      if ((paramdm1 == null) || (!paramdm1.i().equals("normaldot")))
        this.g = paramdm1;
      if ((paramdm2 == null) || (!paramdm2.i().equals("normaldot")))
        this.h = paramdm2;
      this.i = paramList;
      return;
    }
  }

  private static void a(i parami, float paramFloat)
  {
    float f1 = parami.e();
    parami.d(-((f1 + parami.f()) / 2.0F - f1) - paramFloat);
  }

  public int a()
  {
    return 7;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    i locali1 = this.f.a(paramdp);
    float f1 = 5.0F * cu.a(3, paramdp);
    float f2 = localdq.b(paramdp.j());
    float f3 = Math.max(locali1.e() - f2, f2 + locali1.f());
    float f4 = Math.max(901.0F * (f3 / 500.0F), f3 * 2.0F - f1);
    at localat = new at();
    int j;
    if (this.i != null)
    {
      j = 0;
      if (j >= this.i.size())
        if (this.i.size() == 0)
          break label332;
    }
    label332: for (i locali2 = this.f.a(paramdp); ; locali2 = locali1)
    {
      if (this.g != null)
      {
        i locali4 = x.a(this.g.i(), paramdp, f4);
        a(locali4, f2);
        localat.a(locali4);
      }
      if (!(this.f instanceof cu))
        localat.a(am.a(4, this.f.a(), paramdp));
      localat.a(locali2);
      if (!(this.f instanceof cu))
        localat.a(am.a(this.f.b(), 5, paramdp));
      if (this.h != null)
      {
        i locali3 = x.a(this.h.i(), paramdp, f4);
        a(locali3, f2);
        localat.a(locali3);
      }
      return localat;
      bi localbi = (bi)this.i.get(j);
      if ((localbi.a instanceof dm))
      {
        i locali5 = x.a(((dm)localbi.a).i(), paramdp, f4);
        a(locali5, f2);
        localbi.b = locali5;
      }
      j++;
      break;
    }
  }

  public int b()
  {
    return 7;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.af
 * JD-Core Version:    0.6.0
 */