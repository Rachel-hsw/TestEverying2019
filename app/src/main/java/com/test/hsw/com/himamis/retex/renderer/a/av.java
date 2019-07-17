package com.himamis.retex.renderer.a;

public class av extends d
{
  private boolean a;

  public av(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public i a(dp paramdp)
  {
    dq localdq1 = paramdp.m();
    char c1;
    o localo1;
    dq localdq2;
    if (this.a)
    {
      c1 = 'I';
      localo1 = new o(localdq1.a(c1, "mathnormal", paramdp.j()));
      localdq2 = paramdp.m();
      if (!this.a)
        break label126;
    }
    label126: for (char c2 = 'J'; ; c2 = 'j')
    {
      o localo2 = new o(localdq2.a(c2, "mathnormal", paramdp.j()));
      at localat = new at(localo1);
      localat.a(new cu(0, -0.065F, 0.0F, 0.0F).a(paramdp));
      localat.a(localo2);
      return localat;
      c1 = 'i';
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.av
 * JD-Core Version:    0.6.0
 */