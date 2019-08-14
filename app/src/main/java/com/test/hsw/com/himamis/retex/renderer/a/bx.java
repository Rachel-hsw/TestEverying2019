package com.himamis.retex.renderer.a;

public class bx extends d
  implements ck
{
  private cl a;
  private boolean b = true;
  private boolean f = true;
  private boolean g = true;

  public bx(d paramd)
  {
    if (paramd == null)
    {
      this.a = new cl();
      return;
    }
    this.a = new cl(paramd);
  }

  public bx(d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramd);
    this.b = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
  }

  public int a()
  {
    return this.a.a();
  }

  public i a(dp paramdp)
  {
    i locali = this.a.a(paramdp);
    float f1;
    float f2;
    if (this.b)
    {
      f1 = locali.c();
      if (!this.f)
        break label76;
      f2 = locali.e();
    }
    while (true)
    {
      boolean bool = this.g;
      float f3 = 0.0F;
      if (bool)
        f3 = locali.f();
      return new dk(f1, f2, f3, locali.g());
      f1 = 0.0F;
      break;
      label76: f2 = 0.0F;
    }
  }

  public void a(z paramz)
  {
    this.a.a(paramz);
  }

  public int b()
  {
    return this.a.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bx
 * JD-Core Version:    0.6.0
 */