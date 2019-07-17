package com.himamis.retex.editor.a.b;

import com.himamis.retex.editor.a.f.d;
import com.himamis.retex.editor.a.f.e;
import com.himamis.retex.editor.a.f.f;
import com.himamis.retex.editor.a.f.g;
import com.himamis.retex.editor.a.f.h;

abstract class a
{
  protected f b = null;
  protected h c = null;
  protected int d = 0;

  private void c(e parame)
  {
    e locale = parame.a_();
    int i = parame.s();
    if (locale == null)
      return;
    if ((locale instanceof h))
    {
      this.c = ((h)locale);
      this.d = (1 + parame.s());
      return;
    }
    if (locale.e(i))
    {
      a((e)locale.c(locale.f(i)));
      return;
    }
    c(locale);
  }

  private void d(e parame)
  {
    e locale = parame.a_();
    int i = parame.s();
    if (locale == null)
      return;
    if ((locale instanceof h))
    {
      this.c = ((h)locale);
      this.d = parame.s();
      return;
    }
    if (locale.g(i))
    {
      b((e)locale.c(locale.h(i)));
      return;
    }
    d(locale);
  }

  private boolean e(e parame)
  {
    if (((parame instanceof h)) && ((parame.a_() instanceof g)))
    {
      g localg = (g)parame.a_();
      int i = localg.b(parame.s());
      if (i >= 0)
      {
        this.c = localg.a(i);
        this.d = 0;
        return true;
      }
    }
    if (parame.a_() != null)
      return e(parame.a_());
    return false;
  }

  private boolean f(e parame)
  {
    if (((parame instanceof h)) && ((parame.a_() instanceof g)))
    {
      g localg = (g)parame.a_();
      int i = localg.i(parame.s());
      if (i >= 0)
      {
        this.c = localg.a(i);
        this.d = 0;
        return true;
      }
    }
    if (parame.a_() != null)
      return f(parame.a_());
    return false;
  }

  public f a()
  {
    return this.b;
  }

  protected void a(e parame)
  {
    for (e locale = parame; ; locale = (e)locale.c(locale.u()))
    {
      if (!(locale instanceof h))
        continue;
      this.c = ((h)locale);
      this.d = 0;
      return;
    }
  }

  public void a(f paramf)
  {
    this.b = paramf;
    if ((paramf.b() instanceof h))
    {
      this.c = paramf.b();
      this.d = this.c.t();
      return;
    }
    f();
  }

  public f b()
  {
    f localf1 = f.a(this.b.a());
    f localf2 = this.b;
    a(localf1);
    return localf2;
  }

  protected void b(e parame)
  {
    for (e locale = parame; ; locale = (e)locale.c(locale.v()))
    {
      if (!(locale instanceof h))
        continue;
      this.c = ((h)locale);
      this.d = this.c.t();
      return;
    }
  }

  public void b(f paramf)
  {
    h localh = (h)paramf.b().a(this.b);
    int i = localh.t();
    while (true)
    {
      if (localh.t() <= 0)
      {
        this.d = (i + this.d);
        return;
      }
      d locald = localh.c(-1 + localh.t());
      localh.a(-1 + localh.t());
      this.c.b(this.d, locald);
    }
  }

  public void c()
  {
    if ((this.d < this.c.t()) && (this.c.c(this.d) != null) && ((this.c.c(this.d) instanceof e)) && (((e)this.c.c(this.d)).w()))
    {
      a((e)this.c.c(this.d));
      return;
    }
    if (this.d < this.c.t())
    {
      this.d = (1 + this.d);
      return;
    }
    g();
  }

  public void d()
  {
    if ((-1 + this.d >= 0) && (this.c.c(-1 + this.d) != null) && ((this.c.c(-1 + this.d) instanceof e)) && (((e)this.c.c(-1 + this.d)).w()))
    {
      b((e)this.c.c(-1 + this.d));
      return;
    }
    if (this.d > 0)
    {
      this.d = (-1 + this.d);
      return;
    }
    h();
  }

  public void e()
  {
    a(this.b.b());
  }

  public void f()
  {
    b(this.b.b());
  }

  public void g()
  {
    c(this.c);
  }

  public void h()
  {
    d(this.c);
  }

  public boolean i()
  {
    return e(this.c);
  }

  public boolean j()
  {
    return f(this.c);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.b.a
 * JD-Core Version:    0.6.0
 */