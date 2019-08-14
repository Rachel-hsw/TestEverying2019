package com.himamis.retex.renderer.a;

public class ec extends d
{
  private d a;
  private String b;
  private boolean f;
  private boolean g = false;
  private boolean h = false;

  public ec(d paramd, boolean paramBoolean)
  {
    this.a = paramd;
    this.f = paramBoolean;
    this.h = true;
  }

  public ec(d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramd;
    if (paramBoolean1);
    for (String str = "leftarrow"; ; str = "rightarrow")
    {
      this.b = str;
      this.g = paramBoolean1;
      this.f = paramBoolean2;
      return;
    }
  }

  public i a(dp paramdp)
  {
    paramdp.m();
    paramdp.j();
    Object localObject;
    float f1;
    i locali;
    float f2;
    if (this.a != null)
    {
      localObject = this.a.a(paramdp);
      f1 = new cu(3, 1.0F, 0.0F, 0.0F).a(paramdp).c();
      if (!this.h)
        break label170;
      locali = en.a(paramdp, ((i)localObject).c());
      f2 = f1 * 4.0F;
    }
    ej localej;
    while (true)
    {
      localej = new ej();
      if (!this.f)
        break label193;
      localej.a(locali);
      localej.a(new at((i)localObject, locali.c(), 2));
      float f3 = localej.f() + localej.e();
      localej.b(((i)localObject).f());
      localej.c(f3 - ((i)localObject).f());
      return localej;
      localObject = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      break;
      label170: locali = en.a(this.g, paramdp, ((i)localObject).c());
      f2 = -f1;
    }
    label193: localej.a(new at((i)localObject, locali.c(), 2));
    localej.a(new dk(0.0F, f2, 0.0F, 0.0F));
    localej.a(locali);
    localej.b(localej.f() + localej.e() - ((i)localObject).e());
    localej.c(((i)localObject).e());
    return (i)localej;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ec
 * JD-Core Version:    0.6.0
 */