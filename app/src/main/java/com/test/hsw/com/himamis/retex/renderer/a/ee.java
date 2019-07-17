package com.himamis.retex.renderer.a;

class ee extends d
{
  private final d a;

  public ee(d paramd)
  {
    this.a = paramd;
    this.c = 0;
  }

  public i a(dp paramdp)
  {
    float f = paramdp.m().h(paramdp.j());
    if (this.a == null);
    for (Object localObject = new dk(0.0F, 0.0F, 0.0F, 0.0F); ; localObject = this.a.a(paramdp))
    {
      ej localej = new ej();
      localej.a((i)localObject);
      localej.a(new dk(0.0F, 3.0F * f, 0.0F, 0.0F));
      localej.a(new au(f, ((i)localObject).c(), 0.0F));
      localej.b(((i)localObject).f() + f * 5.0F);
      localej.c(((i)localObject).e());
      return localej;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ee
 * JD-Core Version:    0.6.0
 */