package com.a.a.b;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.a.a.b.a.d;

public final class c
{
  private final int a;
  private final int b;
  private final int c;
  private final Drawable d;
  private final Drawable e;
  private final Drawable f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final d j;
  private final BitmapFactory.Options k;
  private final int l;
  private final boolean m;
  private final Object n;
  private final com.a.a.b.g.a o;
  private final com.a.a.b.g.a p;
  private final com.a.a.b.c.a q;
  private final Handler r;
  private final boolean s;

  private c(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
    this.k = a.k(parama);
    this.l = a.l(parama);
    this.m = a.m(parama);
    this.n = a.n(parama);
    this.o = a.o(parama);
    this.p = a.p(parama);
    this.q = a.q(parama);
    this.r = a.r(parama);
    this.s = a.s(parama);
  }

  public static c t()
  {
    return new a().d();
  }

  public Drawable a(Resources paramResources)
  {
    if (this.a != 0)
      return paramResources.getDrawable(this.a);
    return this.d;
  }

  public boolean a()
  {
    return (this.d != null) || (this.a != 0);
  }

  public Drawable b(Resources paramResources)
  {
    if (this.b != 0)
      return paramResources.getDrawable(this.b);
    return this.e;
  }

  public boolean b()
  {
    return (this.e != null) || (this.b != 0);
  }

  public Drawable c(Resources paramResources)
  {
    if (this.c != 0)
      return paramResources.getDrawable(this.c);
    return this.f;
  }

  public boolean c()
  {
    return (this.f != null) || (this.c != 0);
  }

  public boolean d()
  {
    return this.o != null;
  }

  public boolean e()
  {
    return this.p != null;
  }

  public boolean f()
  {
    return this.l > 0;
  }

  public boolean g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.i;
  }

  public d j()
  {
    return this.j;
  }

  public BitmapFactory.Options k()
  {
    return this.k;
  }

  public int l()
  {
    return this.l;
  }

  public boolean m()
  {
    return this.m;
  }

  public Object n()
  {
    return this.n;
  }

  public com.a.a.b.g.a o()
  {
    return this.o;
  }

  public com.a.a.b.g.a p()
  {
    return this.p;
  }

  public com.a.a.b.c.a q()
  {
    return this.q;
  }

  public Handler r()
  {
    return this.r;
  }

  boolean s()
  {
    return this.s;
  }

  public static class a
  {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private Drawable d = null;
    private Drawable e = null;
    private Drawable f = null;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private d j = d.c;
    private BitmapFactory.Options k = new BitmapFactory.Options();
    private int l = 0;
    private boolean m = false;
    private Object n = null;
    private com.a.a.b.g.a o = null;
    private com.a.a.b.g.a p = null;
    private com.a.a.b.c.a q = a.c();
    private Handler r = null;
    private boolean s = false;

    public a()
    {
      this.k.inPurgeable = true;
      this.k.inInputShareable = true;
    }

    public a a()
    {
      this.g = true;
      return this;
    }

    @Deprecated
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public a a(Bitmap.Config paramConfig)
    {
      if (paramConfig == null)
        throw new IllegalArgumentException("bitmapConfig can't be null");
      this.k.inPreferredConfig = paramConfig;
      return this;
    }

    public a a(BitmapFactory.Options paramOptions)
    {
      if (paramOptions == null)
        throw new IllegalArgumentException("decodingOptions can't be null");
      this.k = paramOptions;
      return this;
    }

    public a a(Drawable paramDrawable)
    {
      this.d = paramDrawable;
      return this;
    }

    public a a(Handler paramHandler)
    {
      this.r = paramHandler;
      return this;
    }

    public a a(d paramd)
    {
      this.j = paramd;
      return this;
    }

    public a a(com.a.a.b.c.a parama)
    {
      if (parama == null)
        throw new IllegalArgumentException("displayer can't be null");
      this.q = parama;
      return this;
    }

    public a a(c paramc)
    {
      this.a = c.a(paramc);
      this.b = c.b(paramc);
      this.c = c.c(paramc);
      this.d = c.d(paramc);
      this.e = c.e(paramc);
      this.f = c.f(paramc);
      this.g = c.g(paramc);
      this.h = c.h(paramc);
      this.i = c.i(paramc);
      this.j = c.j(paramc);
      this.k = c.k(paramc);
      this.l = c.l(paramc);
      this.m = c.m(paramc);
      this.n = c.n(paramc);
      this.o = c.o(paramc);
      this.p = c.p(paramc);
      this.q = c.q(paramc);
      this.r = c.r(paramc);
      this.s = c.s(paramc);
      return this;
    }

    public a a(com.a.a.b.g.a parama)
    {
      this.o = parama;
      return this;
    }

    public a a(Object paramObject)
    {
      this.n = paramObject;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }

    @Deprecated
    public a b()
    {
      this.h = true;
      return this;
    }

    public a b(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public a b(Drawable paramDrawable)
    {
      this.e = paramDrawable;
      return this;
    }

    public a b(com.a.a.b.g.a parama)
    {
      this.p = parama;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }

    @Deprecated
    public a c()
    {
      return d(true);
    }

    public a c(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public a c(Drawable paramDrawable)
    {
      this.f = paramDrawable;
      return this;
    }

    @Deprecated
    public a c(boolean paramBoolean)
    {
      return d(paramBoolean);
    }

    public a d(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public a d(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }

    public c d()
    {
      return new c(this, null);
    }

    public a e(int paramInt)
    {
      this.l = paramInt;
      return this;
    }

    public a e(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }

    a f(boolean paramBoolean)
    {
      this.s = paramBoolean;
      return this;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.c
 * JD-Core Version:    0.6.0
 */