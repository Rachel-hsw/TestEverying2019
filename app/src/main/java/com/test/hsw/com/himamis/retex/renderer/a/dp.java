package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;

public class dp
{
  public boolean a = false;
  private b b = null;
  private b c = null;
  private int d = 0;
  private dq e;
  private int f = -1;
  private float g = (1.0F / 1.0F);
  private String h;
  private boolean i;
  private float j = 1.0F;
  private int k;
  private float l;

  private dp(int paramInt, float paramFloat, dq paramdq, b paramb1, b paramb2, String paramString, boolean paramBoolean)
  {
    this.d = paramInt;
    this.j = paramFloat;
    this.e = paramdq;
    this.h = paramString;
    this.i = paramBoolean;
    this.b = paramb1;
    this.c = paramb2;
    a(1, 1.0F);
  }

  public dp(int paramInt, dq paramdq)
  {
    this(paramInt, paramdq, null, null);
  }

  public dp(int paramInt1, dq paramdq, int paramInt2, float paramFloat)
  {
    this(paramInt1, paramdq, null, null);
    this.g = (paramFloat * cu.a(paramInt2, this));
  }

  private dp(int paramInt, dq paramdq, b paramb1, b paramb2)
  {
    this.d = paramInt;
    this.e = paramdq;
    this.b = paramb1;
    this.c = paramb2;
    a(1, 1.0F);
  }

  public float a()
  {
    return this.l * cu.a(this.k, this);
  }

  protected dp a(dq paramdq)
  {
    dp localdp = new dp(this.d, this.j, paramdq, this.b, this.c, this.h, this.i);
    localdp.g = this.g;
    localdp.l = this.l;
    localdp.k = this.k;
    return localdp;
  }

  public void a(float paramFloat)
  {
    this.j = paramFloat;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(int paramInt, float paramFloat)
  {
    this.l = paramFloat;
    this.k = paramInt;
  }

  public void a(b paramb)
  {
    this.b = paramb;
  }

  public void a(String paramString)
  {
    this.h = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public float b()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    this.f = paramInt;
  }

  public void b(int paramInt, float paramFloat)
  {
    this.g = (paramFloat * cu.a(paramInt, this));
  }

  public void b(b paramb)
  {
    this.c = paramb;
  }

  public float c()
  {
    return this.j;
  }

  protected dp d()
  {
    return new dp(this.d, this.j, this.e, this.b, this.c, this.h, this.i);
  }

  public dp e()
  {
    dp localdp = d();
    if (this.d % 2 == 1);
    for (int m = this.d; ; m = 1 + this.d)
    {
      localdp.d = m;
      return localdp;
    }
  }

  public dp f()
  {
    dp localdp = d();
    localdp.d = (2 + (1 + 2 * (this.d / 2)) - 2 * (this.d / 6));
    return localdp;
  }

  public b g()
  {
    return this.b;
  }

  public b h()
  {
    return this.c;
  }

  public float i()
  {
    return this.e.d();
  }

  public int j()
  {
    return this.d;
  }

  public String k()
  {
    return this.h;
  }

  public boolean l()
  {
    return this.i;
  }

  public dq m()
  {
    return this.e;
  }

  public dp n()
  {
    dp localdp = d();
    localdp.d = (2 + this.d - 2 * (this.d / 6));
    return localdp;
  }

  public void o()
  {
    this.c = null;
    this.b = null;
  }

  public dp p()
  {
    dp localdp = d();
    localdp.d = 6;
    return localdp;
  }

  public dp q()
  {
    dp localdp = d();
    localdp.d = (1 + (4 + 2 * (this.d / 4)));
    return localdp;
  }

  public dp r()
  {
    dp localdp = d();
    localdp.d = (4 + 2 * (this.d / 4) + this.d % 2);
    return localdp;
  }

  public float s()
  {
    return this.e.n(this.d) * this.e.b();
  }

  public int t()
  {
    if (this.f == -1)
      return this.e.c();
    return this.f;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dp
 * JD-Core Version:    0.6.0
 */