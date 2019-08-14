package com.himamis.retex.editor.a.f;

import com.himamis.retex.editor.a.e.i;
import java.util.ArrayList;

public class g extends e
{
  private com.himamis.retex.editor.a.e.f a;

  public g(f paramf, com.himamis.retex.editor.a.e.f paramf1)
  {
    super(paramf, paramf1.h());
    this.a = paramf1;
  }

  public e a(f paramf)
  {
    g localg = new g(paramf, this.a);
    for (int i = 0; ; i++)
    {
      if (i >= this.f.size())
        return localg;
      localg.a(i, a(i).a(paramf));
    }
  }

  public h a()
  {
    return (h)super.a_();
  }

  public h a(int paramInt)
  {
    return (h)super.c(paramInt);
  }

  public void a(int paramInt, h paramh)
  {
    super.a(paramInt, paramh);
  }

  public int b(int paramInt)
  {
    return this.a.d(paramInt);
  }

  public String b()
  {
    return this.a.b();
  }

  public String d()
  {
    return this.a.c();
  }

  public String e()
  {
    return this.a.d();
  }

  public int i(int paramInt)
  {
    return this.a.e(paramInt);
  }

  public String j(int paramInt)
  {
    return this.a.a(paramInt).b();
  }

  public int x()
  {
    return this.a.i();
  }

  public int y()
  {
    return this.a.j();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.f.g
 * JD-Core Version:    0.6.0
 */