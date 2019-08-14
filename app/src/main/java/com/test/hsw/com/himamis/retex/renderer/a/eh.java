package com.himamis.retex.renderer.a;

import java.util.LinkedList;
import java.util.ListIterator;

public class eh extends d
{
  protected LinkedList<d> a = new LinkedList();
  protected boolean b = false;
  private cu f = new cu(1, 0.0F, 0.0F, 0.0F);

  public eh()
  {
  }

  public eh(d paramd)
  {
    if (paramd != null)
    {
      if ((paramd instanceof eh))
        this.a.addAll(((eh)paramd).a);
    }
    else
      return;
    this.a.add(paramd);
  }

  public i a(dp paramdp)
  {
    ej localej = new ej();
    dk localdk = new dk(0.0F, paramdp.a(), 0.0F, 0.0F);
    ListIterator localListIterator = this.a.listIterator();
    float f1;
    if (!localListIterator.hasNext())
    {
      localej.d(-this.f.a(paramdp).c());
      if (localej.i() != 0)
        break label135;
      f1 = 0.0F;
    }
    while (true)
    {
      localej.c(localej.f() + localej.e() - f1);
      localej.b(f1);
      return localej;
      localej.a(((d)localListIterator.next()).a(paramdp));
      if ((!this.b) || (!localListIterator.hasNext()))
        break;
      localej.a(localdk);
      break;
      label135: f1 = ((i)localej.k.getLast()).f();
    }
  }

  public void a(int paramInt, float paramFloat)
  {
    this.f = new cu(paramInt, paramFloat, 0.0F, 0.0F);
  }

  public final void a(d paramd)
  {
    if (paramd != null)
      this.a.add(0, paramd);
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final void b(d paramd)
  {
    if (paramd != null)
      this.a.add(paramd);
  }

  public boolean d()
  {
    return this.b;
  }

  public d e()
  {
    return (d)this.a.removeLast();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.eh
 * JD-Core Version:    0.6.0
 */