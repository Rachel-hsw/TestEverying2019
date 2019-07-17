package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.l;

public class ed extends d
{
  private final d a;
  private final d b;
  private final d f;
  private final float g;
  private final float h;
  private final int i;
  private final int j;
  private final boolean k;
  private final boolean l;

  public ed(d paramd1, d paramd2, int paramInt1, float paramFloat1, boolean paramBoolean1, d paramd3, int paramInt2, float paramFloat2, boolean paramBoolean2)
    throws l
  {
    cu.a(paramInt1);
    cu.a(paramInt2);
    this.a = paramd1;
    this.b = paramd2;
    this.i = paramInt1;
    this.g = paramFloat1;
    this.k = paramBoolean1;
    this.f = paramd3;
    this.j = paramInt2;
    this.h = paramFloat2;
    this.l = paramBoolean2;
  }

  public ed(d paramd1, d paramd2, int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    cu.a(paramInt);
    this.a = paramd1;
    this.c = this.c;
    if (paramBoolean2)
    {
      this.b = null;
      this.g = 0.0F;
      this.i = 0;
      this.k = false;
      this.f = paramd2;
      this.j = paramInt;
      this.h = paramFloat;
      this.l = paramBoolean1;
      return;
    }
    this.b = paramd2;
    this.i = paramInt;
    this.g = paramFloat;
    this.k = paramBoolean1;
    this.h = 0.0F;
    this.f = null;
    this.j = 0;
    this.l = false;
  }

  private static i a(i parami, float paramFloat)
  {
    if ((parami != null) && (Math.abs(paramFloat - parami.c()) > 1.0E-007F))
      parami = new at(parami, paramFloat, 2);
    return parami;
  }

  public int a()
  {
    return this.a.a();
  }

  public i a(dp paramdp)
  {
    Object localObject;
    float f1;
    dp localdp2;
    label50: i locali4;
    float f2;
    if (this.a == null)
    {
      localObject = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      f1 = ((i)localObject).c();
      if (this.f == null)
        break label322;
      d locald3 = this.f;
      if (!this.l)
        break label310;
      localdp2 = paramdp.q();
      locali4 = locald3.a(localdp2);
      f2 = Math.max(f1, locali4.c());
    }
    for (i locali1 = locali4; ; locali1 = null)
    {
      d locald1 = this.b;
      i locali2 = null;
      d locald2;
      if (locald1 != null)
      {
        locald2 = this.b;
        if (!this.k)
          break label316;
      }
      label310: label316: for (dp localdp1 = paramdp.q(); ; localdp1 = paramdp)
      {
        locali2 = locald2.a(localdp1);
        f2 = Math.max(f2, locali2.c());
        ej localej = new ej();
        paramdp.b(((i)localObject).h());
        if (this.f != null)
        {
          localej.a(a(locali1, f2));
          localej.a(new cu(this.j, 0.0F, this.h, 0.0F).a(paramdp));
        }
        i locali3 = a((i)localObject, f2);
        localej.a(locali3);
        float f3 = localej.e() + localej.f() - locali3.f();
        if (this.b != null)
        {
          localej.a(new cu(this.j, 0.0F, this.g, 0.0F).a(paramdp));
          localej.a(a(locali2, f2));
        }
        localej.b(localej.e() + localej.f() - f3);
        localej.c(f3);
        return localej;
        localObject = this.a.a(paramdp);
        break;
        localdp2 = paramdp;
        break label50;
      }
      label322: f2 = f1;
    }
  }

  public int b()
  {
    return this.a.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ed
 * JD-Core Version:    0.6.0
 */