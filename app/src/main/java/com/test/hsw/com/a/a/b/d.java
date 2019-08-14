package com.a.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

public class d
{
  public static final String a = d.class.getSimpleName();
  static final String b = "Initialize ImageLoader with configuration";
  static final String c = "Destroy ImageLoader";
  static final String d = "Load image from memory cache [%s]";
  private static final String e = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  private static final String f = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  private static final String g = "ImageLoader must be init with configuration before using";
  private static final String h = "ImageLoader configuration can not be initialized with null";
  private static volatile d l;
  private e i;
  private f j;
  private final com.a.a.b.f.a k = new com.a.a.b.f.d();

  private static Handler a(c paramc)
  {
    Handler localHandler = paramc.r();
    if (paramc.s())
      localHandler = null;
    do
      return localHandler;
    while ((localHandler != null) || (Looper.myLooper() != Looper.getMainLooper()));
    return new Handler();
  }

  public static d a()
  {
    if (l == null)
      monitorenter;
    try
    {
      if (l == null)
        l = new d();
      return l;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void m()
  {
    if (this.i == null)
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
  }

  public Bitmap a(String paramString)
  {
    return a(paramString, null, null);
  }

  public Bitmap a(String paramString, com.a.a.b.a.e parame)
  {
    return a(paramString, parame, null);
  }

  public Bitmap a(String paramString, com.a.a.b.a.e parame, c paramc)
  {
    if (paramc == null)
      paramc = this.i.r;
    c localc = new c.a().a(paramc).f(true).d();
    a locala = new a(null);
    a(paramString, parame, localc, locala);
    return locala.a();
  }

  public Bitmap a(String paramString, c paramc)
  {
    return a(paramString, null, paramc);
  }

  public String a(ImageView paramImageView)
  {
    return this.j.a(new com.a.a.b.e.b(paramImageView));
  }

  public String a(com.a.a.b.e.a parama)
  {
    return this.j.a(parama);
  }

  public void a(e parame)
  {
    monitorenter;
    if (parame == null)
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally
      {
        monitorexit;
      }
    if (this.i == null)
    {
      com.a.a.c.d.a("Initialize ImageLoader with configuration", new Object[0]);
      this.j = new f(parame);
      this.i = parame;
    }
    while (true)
    {
      monitorexit;
      return;
      com.a.a.c.d.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
    }
  }

  public void a(String paramString, ImageView paramImageView)
  {
    a(paramString, new com.a.a.b.e.b(paramImageView), null, null, null);
  }

  public void a(String paramString, ImageView paramImageView, c paramc)
  {
    a(paramString, new com.a.a.b.e.b(paramImageView), paramc, null, null);
  }

  public void a(String paramString, ImageView paramImageView, c paramc, com.a.a.b.f.a parama)
  {
    a(paramString, paramImageView, paramc, parama, null);
  }

  public void a(String paramString, ImageView paramImageView, c paramc, com.a.a.b.f.a parama, com.a.a.b.f.b paramb)
  {
    a(paramString, new com.a.a.b.e.b(paramImageView), paramc, parama, paramb);
  }

  public void a(String paramString, ImageView paramImageView, com.a.a.b.f.a parama)
  {
    a(paramString, new com.a.a.b.e.b(paramImageView), null, parama, null);
  }

  public void a(String paramString, com.a.a.b.a.e parame, c paramc, com.a.a.b.f.a parama)
  {
    a(paramString, parame, paramc, parama, null);
  }

  public void a(String paramString, com.a.a.b.a.e parame, c paramc, com.a.a.b.f.a parama, com.a.a.b.f.b paramb)
  {
    m();
    if (parame == null)
      parame = this.i.a();
    if (paramc == null);
    for (c localc = this.i.r; ; localc = paramc)
    {
      a(paramString, new com.a.a.b.e.c(paramString, parame, com.a.a.b.a.h.b), localc, parama, paramb);
      return;
    }
  }

  public void a(String paramString, com.a.a.b.a.e parame, com.a.a.b.f.a parama)
  {
    a(paramString, parame, null, parama, null);
  }

  public void a(String paramString, c paramc, com.a.a.b.f.a parama)
  {
    a(paramString, null, paramc, parama, null);
  }

  public void a(String paramString, com.a.a.b.e.a parama)
  {
    a(paramString, parama, null, null, null);
  }

  public void a(String paramString, com.a.a.b.e.a parama, c paramc)
  {
    a(paramString, parama, paramc, null, null);
  }

  public void a(String paramString, com.a.a.b.e.a parama, c paramc, com.a.a.b.f.a parama1)
  {
    a(paramString, parama, paramc, parama1, null);
  }

  public void a(String paramString, com.a.a.b.e.a parama, c paramc, com.a.a.b.f.a parama1, com.a.a.b.f.b paramb)
  {
    m();
    if (parama == null)
      throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    if (parama1 == null);
    for (com.a.a.b.f.a locala = this.k; ; locala = parama1)
    {
      if (paramc == null);
      for (c localc = this.i.r; ; localc = paramc)
      {
        if (TextUtils.isEmpty(paramString))
        {
          this.j.b(parama);
          locala.a(paramString, parama.d());
          if (localc.b())
            parama.a(localc.b(this.i.a));
          while (true)
          {
            locala.a(paramString, parama.d(), null);
            return;
            parama.a(null);
          }
        }
        com.a.a.b.a.e locale = com.a.a.c.b.a(parama, this.i.a());
        String str = com.a.a.c.e.a(paramString, locale);
        this.j.a(parama, str);
        locala.a(paramString, parama.d());
        Bitmap localBitmap = (Bitmap)this.i.n.b(str);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          com.a.a.c.d.a("Load image from memory cache [%s]", new Object[] { str });
          if (localc.e())
          {
            h localh2 = new h(paramString, parama, locale, str, localc, locala, paramb, this.j.a(paramString));
            m localm = new m(this.j, localBitmap, localh2, a(localc));
            if (localc.s())
            {
              localm.run();
              return;
            }
            this.j.a(localm);
            return;
          }
          localc.q().a(localBitmap, parama, com.a.a.b.a.f.c);
          locala.a(paramString, parama.d(), localBitmap);
          return;
        }
        if (localc.a())
          parama.a(localc.a(this.i.a));
        i locali;
        while (true)
        {
          h localh1 = new h(paramString, parama, locale, str, localc, locala, paramb, this.j.a(paramString));
          locali = new i(this.j, localh1, a(localc));
          if (!localc.s())
            break;
          locali.run();
          return;
          if (!localc.g())
            continue;
          parama.a(null);
        }
        this.j.a(locali);
        return;
      }
    }
  }

  public void a(String paramString, com.a.a.b.e.a parama, com.a.a.b.f.a parama1)
  {
    a(paramString, parama, null, parama1, null);
  }

  public void a(String paramString, com.a.a.b.f.a parama)
  {
    a(paramString, null, null, parama, null);
  }

  public void a(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
  }

  public void b(ImageView paramImageView)
  {
    this.j.b(new com.a.a.b.e.b(paramImageView));
  }

  public void b(com.a.a.b.e.a parama)
  {
    this.j.b(parama);
  }

  public void b(boolean paramBoolean)
  {
    this.j.b(paramBoolean);
  }

  public boolean b()
  {
    return this.i != null;
  }

  public com.a.a.a.b.c c()
  {
    m();
    return this.i.n;
  }

  public void d()
  {
    m();
    this.i.n.b();
  }

  @Deprecated
  public com.a.a.a.a.b e()
  {
    return f();
  }

  public com.a.a.a.a.b f()
  {
    m();
    return this.i.o;
  }

  @Deprecated
  public void g()
  {
    h();
  }

  public void h()
  {
    m();
    this.i.o.c();
  }

  public void i()
  {
    this.j.a();
  }

  public void j()
  {
    this.j.b();
  }

  public void k()
  {
    this.j.c();
  }

  public void l()
  {
    if (this.i != null)
      com.a.a.c.d.a("Destroy ImageLoader", new Object[0]);
    k();
    this.i.o.b();
    this.j = null;
    this.i = null;
  }

  private static class a extends com.a.a.b.f.d
  {
    private Bitmap a;

    public Bitmap a()
    {
      return this.a;
    }

    public void a(String paramString, View paramView, Bitmap paramBitmap)
    {
      this.a = paramBitmap;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.d
 * JD-Core Version:    0.6.0
 */