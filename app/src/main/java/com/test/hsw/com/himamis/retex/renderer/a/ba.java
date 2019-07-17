package com.himamis.retex.renderer.a;

public class ba extends d
{
  private boolean a;

  public ba(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public i a(dp paramdp)
  {
    o localo = new o(paramdp.m().a("textapos", paramdp.j()));
    dq localdq = paramdp.m();
    char c;
    at localat;
    if (this.a)
    {
      c = 'L';
      localat = new at(new o(localdq.a(c, "mathnormal", paramdp.j())));
      if (!this.a)
        break label113;
      localat.a(new cu(0, -0.3F, 0.0F, 0.0F).a(paramdp));
    }
    while (true)
    {
      localat.a(localo);
      return localat;
      c = 'l';
      break;
      label113: localat.a(new cu(0, -0.13F, 0.0F, 0.0F).a(paramdp));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ba
 * JD-Core Version:    0.6.0
 */