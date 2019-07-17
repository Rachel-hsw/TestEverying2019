package com.xiaomi.push.b;

import com.google.a.a.a;
import com.google.a.a.d;

public final class b
{
  public static final class a extends d
  {
    private boolean a;
    private boolean b = false;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private int i = -1;

    public static a b(byte[] paramArrayOfByte)
    {
      return (a)(a)new a().a(paramArrayOfByte);
    }

    public int a()
    {
      boolean bool = d();
      int j = 0;
      if (bool)
        j = 0 + com.google.a.a.b.b(1, c());
      if (f())
        j += com.google.a.a.b.c(3, e());
      if (h())
        j += com.google.a.a.b.c(4, g());
      if (j())
        j += com.google.a.a.b.c(5, i());
      this.i = j;
      return j;
    }

    public a a(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }

    public void a(com.google.a.a.b paramb)
    {
      if (d())
        paramb.a(1, c());
      if (f())
        paramb.a(3, e());
      if (h())
        paramb.a(4, g());
      if (j())
        paramb.a(5, i());
    }

    public a b(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }

    public a b(a parama)
    {
      while (true)
      {
        int j = parama.a();
        switch (j)
        {
        default:
          if (a(parama, j))
            continue;
        case 0:
          return this;
        case 8:
          a(parama.d());
          break;
        case 24:
          a(parama.c());
          break;
        case 32:
          b(parama.c());
          break;
        case 40:
        }
        c(parama.c());
      }
    }

    public a c(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }

    public boolean c()
    {
      return this.b;
    }

    public boolean d()
    {
      return this.a;
    }

    public int e()
    {
      return this.d;
    }

    public boolean f()
    {
      return this.c;
    }

    public int g()
    {
      return this.f;
    }

    public boolean h()
    {
      return this.e;
    }

    public int i()
    {
      return this.h;
    }

    public boolean j()
    {
      return this.g;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.b.b
 * JD-Core Version:    0.6.0
 */