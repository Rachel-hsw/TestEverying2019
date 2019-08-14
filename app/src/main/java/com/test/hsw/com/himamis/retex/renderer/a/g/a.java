package com.himamis.retex.renderer.a.g;

import com.himamis.retex.renderer.a.g.c.d;
import com.himamis.retex.renderer.a.g.d.h;

public abstract class a
{
  public static a a;
  private com.himamis.retex.renderer.a.g.b.a b;
  private com.himamis.retex.renderer.a.g.a.b c;
  private d d;
  private h e;
  private com.himamis.retex.renderer.a.g.e.b f;

  protected abstract com.himamis.retex.renderer.a.g.b.a a();

  protected abstract com.himamis.retex.renderer.a.g.a.b b();

  protected abstract d c();

  protected abstract h d();

  protected abstract com.himamis.retex.renderer.a.g.e.b e();

  public com.himamis.retex.renderer.a.g.b.a f()
  {
    if (this.b == null)
      this.b = a();
    return this.b;
  }

  public com.himamis.retex.renderer.a.g.a.b g()
  {
    if (this.c == null)
      this.c = b();
    return this.c;
  }

  public d h()
  {
    if (this.d == null)
      this.d = c();
    return this.d;
  }

  public h i()
  {
    if (this.e == null)
      this.e = d();
    return this.e;
  }

  public com.himamis.retex.renderer.a.g.e.b j()
  {
    if (this.f == null)
      this.f = e();
    return this.f;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.g.a
 * JD-Core Version:    0.6.0
 */