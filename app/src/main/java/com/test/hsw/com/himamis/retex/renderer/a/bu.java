package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.l;

public class bu extends d
{
  private final d a;
  private d b;
  private final dm f;
  private final cu g;
  private final boolean h;

  public bu(d paramd1, d paramd2, dm paramdm, int paramInt, float paramFloat, boolean paramBoolean)
    throws l
  {
    this.c = 7;
    this.a = paramd1;
    this.b = paramd2;
    this.f = paramdm;
    this.g = new cu(paramInt, 0.0F, paramFloat, 0.0F);
    this.h = paramBoolean;
  }

  private static float a(i parami1, i parami2, i parami3)
  {
    float f1 = Math.max(parami1.c(), parami2.e() + parami2.f());
    if (parami3 != null)
      f1 = Math.max(f1, parami3.c());
    return f1;
  }

  public i a(dp paramdp)
  {
    Object localObject1;
    i locali;
    d locald;
    dp localdp;
    if (this.a == null)
    {
      localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      locali = x.a(this.f.i(), paramdp, ((i)localObject1).c());
      if (this.b == null)
        break label207;
      locald = this.b;
      if (!this.h)
        break label192;
      localdp = paramdp.r();
    }
    label61: label192: label207: for (Object localObject2 = locald.a(localdp); ; localObject2 = null)
    {
      float f1 = a((i)localObject1, locali, (i)localObject2);
      if (f1 - ((i)localObject1).c() > 1.0E-007F);
      for (Object localObject3 = new at((i)localObject1, f1, 2); ; localObject3 = localObject1)
      {
        ej localej = new ej(locali, f1, 2);
        if ((localObject2 != null) && (f1 - ((i)localObject2).c() > 1.0E-007F))
          localObject2 = new at((i)localObject2, f1, 2);
        return new bt((i)localObject3, localej, (i)localObject2, this.g.a(paramdp).e(), this.h);
        localObject1 = this.a.a(paramdp);
        break;
        localdp = paramdp.q();
        break label61;
      }
    }
  }

  public void a(d paramd)
  {
    this.b = paramd;
  }

  public boolean d()
  {
    return this.h;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bu
 * JD-Core Version:    0.6.0
 */