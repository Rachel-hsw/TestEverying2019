package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.j;
import com.himamis.retex.renderer.a.e.k;

public class a extends d
{
  protected d a = null;
  protected d b = null;
  private final dm f;
  private boolean g = false;
  private boolean h = true;

  public a(d paramd1, d paramd2)
    throws j
  {
    this.a = paramd1;
    if ((paramd1 instanceof a));
    for (this.b = ((a)paramd1).b; !(paramd2 instanceof dm); this.b = paramd1)
      throw new j("Invalid accent");
    this.f = ((dm)paramd2);
    this.g = true;
  }

  public a(d paramd1, d paramd2, boolean paramBoolean)
    throws j
  {
    this(paramd1, paramd2);
    this.h = paramBoolean;
  }

  public a(d paramd, dr paramdr)
    throws k, j
  {
    if (paramdr == null)
      throw new k("The accent TeXFormula can't be null!");
    d locald = paramdr.u;
    if ((locald instanceof dm))
    {
      this.f = ((dm)locald);
      if (this.f.c == 10)
      {
        this.a = paramd;
        return;
      }
      throw new j("The accent TeXFormula represents a single symbol with the name '" + this.f.i() + "', but this symbol is not defined as an accent (" + "type" + "='acc') in '" + "TeXSymbols.xml" + "'!");
    }
    throw new k("The accent TeXFormula does not represent a single symbol!");
  }

  public a(d paramd, String paramString)
    throws j, com.himamis.retex.renderer.a.e.q
  {
    this.f = dm.b(paramString);
    if (this.f.c == 10)
    {
      this.a = paramd;
      if ((paramd instanceof a))
      {
        this.b = ((a)paramd).b;
        return;
      }
      this.b = paramd;
      return;
    }
    throw new j("The symbol with the name '" + paramString + "' is not defined as an accent (" + "type" + "='acc') in '" + "TeXSymbols.xml" + "'!");
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    Object localObject1;
    float f1;
    float f2;
    if (this.a == null)
    {
      localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      f1 = ((i)localObject1).c();
      if (!(this.b instanceof q))
        break label492;
      f2 = localdq.b(((q)this.b).a(localdq), i);
    }
    while (true)
    {
      Object localObject2 = localdq.a(this.f.i(), i);
      label83: label94: float f3;
      label109: ej localej;
      float f4;
      o localo;
      dm localdm;
      if (!localdq.a((m)localObject2))
      {
        f3 = -cu.a(5, paramdp);
        if (!this.g)
          break label440;
        localej = new ej();
        f4 = ((m)localObject2).f();
        localo = new o((m)localObject2);
        if (!this.g)
          break label485;
        localdm = this.f;
        if (this.h)
          paramdp = paramdp.q();
      }
      label440: label471: label482: label485: for (Object localObject3 = localdm.a(paramdp); ; localObject3 = localo)
      {
        if (Math.abs(f4) > 1.0E-007F)
        {
          at localat1 = new at(new dk(-f4, 0.0F, 0.0F, 0.0F));
          localat1.a((i)localObject3);
          localObject3 = localat1;
        }
        float f5 = (f1 - ((i)localObject3).c()) / 2.0F;
        float f6;
        label236: float f7;
        if (f5 > 0.0F)
        {
          f6 = f5;
          ((i)localObject3).d(f2 + f6);
          if (f5 < 0.0F)
            localObject1 = new at((i)localObject1, ((i)localObject3).c(), 2);
          localej.a((i)localObject3);
          if (!this.h)
            break label471;
          f7 = -f3;
        }
        while (true)
        {
          localej.a(new dk(0.0F, f7, 0.0F, 0.0F));
          localej.a((i)localObject1);
          float f8 = localej.e() + localej.f();
          float f9 = ((i)localObject1).f();
          localej.b(f9);
          localej.c(f8 - f9);
          if (f5 >= 0.0F)
            break label482;
          at localat2 = new at(new dk(f5, 0.0F, 0.0F, 0.0F));
          localat2.a(localej);
          localat2.a(f1);
          return localat2;
          localObject1 = this.a.a(paramdp.e());
          break;
          m localm = localdq.b((m)localObject2, i);
          if (localm.e() > f1)
            break label94;
          localObject2 = localm;
          break label83;
          f3 = Math.min(((i)localObject1).e(), localdq.b(i, ((m)localObject2).d()));
          break label109;
          f6 = 0.0F;
          break label236;
          f7 = -((i)localObject1).e();
        }
        return localej;
      }
      label492: f2 = 0.0F;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.a
 * JD-Core Version:    0.6.0
 */