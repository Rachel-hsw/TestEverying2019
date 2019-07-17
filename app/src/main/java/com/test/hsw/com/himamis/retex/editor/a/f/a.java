package com.himamis.retex.editor.a.f;

import com.himamis.retex.editor.a.e.c;
import java.util.ArrayList;

public class a extends e
{
  private int a;
  private int b;
  private c c;

  public a(f paramf, c paramc, int paramInt)
  {
    super(paramf, paramInt);
    this.c = paramc;
    this.a = paramInt;
    this.b = 1;
  }

  public a(f paramf, c paramc, int paramInt1, int paramInt2)
  {
    super(paramf, paramInt1 * paramInt2);
    this.c = paramc;
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public e a(f paramf)
  {
    a locala = new a(paramf, this.c, this.a, this.b);
    locala.a(0, 0, this);
    return locala;
  }

  public h a(int paramInt)
  {
    return (h)super.c(paramInt);
  }

  public h a(int paramInt1, int paramInt2)
  {
    return a(paramInt2 + paramInt1 * this.a);
  }

  public void a()
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.a)
      {
        this.b = (1 + this.b);
        return;
      }
      h localh = new h(this.e);
      localh.a(this);
      this.f.add(localh);
    }
  }

  public void a(int paramInt1, int paramInt2, a parama)
  {
    int i = 0;
    if ((i >= paramInt2 + this.b) && (i >= parama.b))
      return;
    for (int j = 0; ; j++)
    {
      if ((j >= paramInt1 + this.a) && (j >= parama.a))
      {
        i++;
        break;
      }
      h localh = (h)parama.a(i, j).a(this.e);
      a(i + paramInt1, j + paramInt2, localh);
    }
  }

  public void a(int paramInt1, int paramInt2, h paramh)
  {
    a(paramInt2 + paramInt1 * this.a, paramh);
  }

  public void a(int paramInt, h paramh)
  {
    super.a(paramInt, paramh);
  }

  public void a(h paramh)
  {
    if (paramh != null)
      paramh.a(this);
    this.f.add(paramh);
    this.a = (1 + this.a);
  }

  public void b()
  {
    h localh = new h(this.e);
    localh.a(this);
    this.f.add(localh);
    this.a = (1 + this.a);
  }

  public void b(int paramInt)
  {
    this.f.remove(paramInt);
    this.a = (-1 + this.a);
  }

  public void b(int paramInt, h paramh)
  {
    if (paramh != null)
      paramh.a(this);
    this.f.add(paramInt, paramh);
    this.a = (1 + this.a);
  }

  public String c()
  {
    return this.c.a();
  }

  public com.himamis.retex.editor.a.e.e d()
  {
    return this.c.d();
  }

  public char e()
  {
    return this.c.e();
  }

  public com.himamis.retex.editor.a.e.e f()
  {
    return this.c.f();
  }

  public char g()
  {
    return this.c.g();
  }

  public com.himamis.retex.editor.a.e.e h()
  {
    return this.c.h();
  }

  public char i()
  {
    return this.c.i();
  }

  public com.himamis.retex.editor.a.e.e j()
  {
    return this.c.j();
  }

  public char k()
  {
    return this.c.k();
  }

  public boolean l()
  {
    return (q() == 1) && ("Array".equals(c()));
  }

  public boolean m()
  {
    return "Array".equals(c());
  }

  public boolean n()
  {
    return (q() == 1) && ("Matrix".equals(c()));
  }

  public boolean o()
  {
    return "Matrix".equals(c());
  }

  public int p()
  {
    return this.a;
  }

  public int q()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.f.a
 * JD-Core Version:    0.6.0
 */