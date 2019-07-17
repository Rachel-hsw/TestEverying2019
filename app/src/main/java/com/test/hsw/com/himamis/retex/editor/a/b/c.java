package com.himamis.retex.editor.a.b;

import com.himamis.retex.editor.a.e.d;
import com.himamis.retex.editor.a.e.e;
import com.himamis.retex.editor.a.f.h;

public abstract class c extends b
{
  public void a(e parame)
  {
    if ((parame instanceof d))
    {
      this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, (d)parame));
      this.d = (1 + this.d);
    }
    while (true)
    {
      p();
      return;
      if ((parame instanceof com.himamis.retex.editor.a.e.f))
      {
        if (("^".equals(parame.b())) || ("_".equals(parame.b())))
        {
          b(parame.b());
          continue;
        }
        a(parame.b());
        continue;
      }
      if (!(parame instanceof d))
        continue;
      a((d)parame);
    }
  }

  public abstract void a(boolean paramBoolean);

  public com.himamis.retex.editor.a.f.f b()
  {
    com.himamis.retex.editor.a.f.f localf = super.b();
    p();
    return localf;
  }

  public void b(com.himamis.retex.editor.a.f.f paramf)
  {
    super.b(paramf);
    p();
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 27:
      k();
      p();
      return true;
    case 36:
      e();
      p();
      return true;
    case 35:
      f();
      p();
      return true;
    case 37:
      d();
      p();
      return true;
    case 39:
      c();
      p();
      return true;
    case 38:
      i();
      p();
      return true;
    case 40:
      j();
      p();
      return true;
    case 127:
      o();
      p();
      return true;
    case 8:
    }
    n();
    p();
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.b.c
 * JD-Core Version:    0.6.0
 */