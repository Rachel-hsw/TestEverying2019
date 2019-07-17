package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.l;

public class ai extends d
{
  private boolean a = false;
  private int b;
  private int f = 2;
  private int g = 2;
  private d h;
  private d i;
  private float j;
  private float k;
  private boolean l = false;

  public ai(d paramd1, d paramd2)
  {
    this(paramd1, paramd2, true);
  }

  public ai(d paramd1, d paramd2, float paramFloat, int paramInt1, int paramInt2)
  {
    this(paramd1, paramd2, true, paramInt1, paramInt2);
    this.k = paramFloat;
    this.l = true;
  }

  public ai(d paramd1, d paramd2, int paramInt, float paramFloat)
  {
    this(paramd1, paramd2, true, paramInt, paramFloat);
  }

  public ai(d paramd1, d paramd2, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    this(paramd1, paramd2, paramInt1, paramFloat);
    this.f = a(paramInt2);
    this.g = a(paramInt3);
  }

  public ai(d paramd1, d paramd2, boolean paramBoolean)
  {
  }

  public ai(d paramd1, d paramd2, boolean paramBoolean, int paramInt, float paramFloat)
    throws l
  {
    cu.a(paramInt);
    this.h = paramd1;
    this.i = paramd2;
    this.a = paramBoolean;
    this.j = paramFloat;
    this.b = paramInt;
    this.c = 7;
  }

  public ai(d paramd1, d paramd2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(paramd1, paramd2, paramBoolean);
    this.f = a(paramInt1);
    this.g = a(paramInt2);
  }

  private int a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
      return paramInt;
    return 2;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int m = paramdp.j();
    float f1 = localdq.h(m);
    Object localObject1;
    label63: Object localObject2;
    label83: Object localObject3;
    Object localObject4;
    label125: float f4;
    float f3;
    label148: ej localej;
    float f12;
    label196: float f14;
    float f15;
    float f9;
    float f18;
    if (this.a)
    {
      this.j *= cu.a(this.b, paramdp);
      if (this.h != null)
        break label455;
      localObject1 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      if (this.i != null)
        break label471;
      localObject2 = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      if (((i)localObject1).c() >= ((i)localObject2).c())
        break label487;
      at localat = new at((i)localObject1, ((i)localObject2).c(), this.f);
      localObject3 = localObject2;
      localObject4 = localat;
      if (m >= 2)
        break label514;
      f4 = localdq.k(m);
      f3 = localdq.i(m);
      localej = new ej();
      localej.a((i)localObject4);
      float f5 = localdq.b(m);
      if (this.j <= 0.0F)
        break label565;
      if (m >= 2)
        break label556;
      f12 = 3.0F * this.j;
      float f13 = this.j / 2.0F;
      f14 = f4 - ((i)localObject4).f() - (f5 + f13);
      f15 = f5 - f13 - (((i)localObject3).e() - f3);
      float f16 = f12 - f14;
      float f17 = f12 - f15;
      if (f16 > 0.0F)
      {
        f4 += f16;
        f14 += f16;
      }
      if (f17 <= 0.0F)
        break label676;
      f9 = f3 + f17;
      f18 = f15 + f17;
    }
    while (true)
    {
      localej.a(new dk(0.0F, f14, 0.0F, 0.0F));
      localej.a(new au(this.j, ((i)localObject4).c(), 0.0F));
      localej.a(new dk(0.0F, f18, 0.0F, 0.0F));
      localej.a((i)localObject3);
      localej.c(f4 + ((i)localObject4).e());
      localej.b(f9 + ((i)localObject3).f());
      float f11 = new cu(0, 0.12F, 0.0F, 0.0F).a(paramdp).c();
      return new at(localej, localej.c() + f11 * 2.0F, 2);
      float f2;
      if (this.l)
        f2 = f1 * this.k;
      while (true)
      {
        this.j = f2;
        break;
        f2 = f1;
      }
      label455: localObject1 = this.h.a(paramdp.n());
      break label63;
      label471: localObject2 = this.i.a(paramdp.f());
      break label83;
      label487: localObject3 = new at((i)localObject2, ((i)localObject1).c(), this.g);
      localObject4 = localObject1;
      break label125;
      label514: f3 = localdq.j(m);
      if (this.j > 0.0F)
      {
        f4 = localdq.l(m);
        break label148;
      }
      f4 = localdq.m(m);
      break label148;
      label556: f12 = this.j;
      break label196;
      label565: float f6;
      label577: float f7;
      float f10;
      if (m < 2)
      {
        f6 = f1 * 7.0F;
        f7 = f4 - ((i)localObject4).f() - (((i)localObject3).e() - f3);
        float f8 = (f6 - f7) / 2.0F;
        if (f8 <= 0.0F)
          break label665;
        f4 += f8;
        f9 = f3 + f8;
        f10 = f7 + 2.0F * f8;
      }
      while (true)
      {
        localej.a(new dk(0.0F, f10, 0.0F, 0.0F));
        break;
        f6 = f1 * 3.0F;
        break label577;
        label665: f9 = f3;
        f10 = f7;
      }
      label676: f9 = f3;
      f18 = f15;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ai
 * JD-Core Version:    0.6.0
 */