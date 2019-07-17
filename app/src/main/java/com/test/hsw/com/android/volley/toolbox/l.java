package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.s.a;
import com.android.volley.x;
import java.util.HashMap;
import java.util.LinkedList;

public class l
{
  private final com.android.volley.q a;
  private int b = 100;
  private final b c;
  private final HashMap<String, a> d = new HashMap();
  private final HashMap<String, a> e = new HashMap();
  private final Handler f = new Handler(Looper.getMainLooper());
  private Runnable g;

  public l(com.android.volley.q paramq, b paramb)
  {
    this.a = paramq;
    this.c = paramb;
  }

  public static d a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    return new m(paramInt2, paramImageView, paramInt1);
  }

  private void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
  }

  private void a(String paramString, a parama)
  {
    this.e.put(paramString, parama);
    if (this.g == null)
    {
      this.g = new p(this);
      this.f.postDelayed(this.g, this.b);
    }
  }

  private static String b(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    return 12 + paramString.length() + "#W" + paramInt1 + "#H" + paramInt2 + "#S" + paramScaleType.ordinal() + paramString;
  }

  protected com.android.volley.o<Bitmap> a(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, String paramString2)
  {
    return new q(paramString1, new n(this, paramString2), paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565, new o(this, paramString2));
  }

  public c a(String paramString, d paramd)
  {
    return a(paramString, paramd, 0, 0);
  }

  public c a(String paramString, d paramd, int paramInt1, int paramInt2)
  {
    return a(paramString, paramd, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }

  public c a(String paramString, d paramd, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    a();
    String str = b(paramString, paramInt1, paramInt2, paramScaleType);
    Bitmap localBitmap = this.c.a(str);
    if (localBitmap != null)
    {
      c localc1 = new c(localBitmap, paramString, null, null);
      paramd.a(localc1, true);
      return localc1;
    }
    c localc2 = new c(null, paramString, str, paramd);
    paramd.a(localc2, true);
    a locala = (a)this.d.get(str);
    if (locala != null)
    {
      locala.a(localc2);
      return localc2;
    }
    com.android.volley.o localo = a(paramString, paramInt1, paramInt2, paramScaleType, str);
    this.a.a(localo);
    this.d.put(str, new a(localo, localc2));
    return localc2;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  protected void a(String paramString, Bitmap paramBitmap)
  {
    this.c.a(paramString, paramBitmap);
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      a.a(locala, paramBitmap);
      a(paramString, locala);
    }
  }

  protected void a(String paramString, x paramx)
  {
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      locala.a(paramx);
      a(paramString, locala);
    }
  }

  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }

  public boolean a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    a();
    String str = b(paramString, paramInt1, paramInt2, paramScaleType);
    return this.c.a(str) != null;
  }

  private class a
  {
    private final com.android.volley.o<?> b;
    private Bitmap c;
    private x d;
    private final LinkedList<l.c> e = new LinkedList();

    public a(l.c arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.e.add(localObject2);
    }

    public x a()
    {
      return this.d;
    }

    public void a(l.c paramc)
    {
      this.e.add(paramc);
    }

    public void a(x paramx)
    {
      this.d = paramx;
    }

    public boolean b(l.c paramc)
    {
      this.e.remove(paramc);
      if (this.e.size() == 0)
      {
        this.b.o();
        return true;
      }
      return false;
    }
  }

  public static abstract interface b
  {
    public abstract Bitmap a(String paramString);

    public abstract void a(String paramString, Bitmap paramBitmap);
  }

  public class c
  {
    private Bitmap b;
    private final l.d c;
    private final String d;
    private final String e;

    public c(Bitmap paramString1, String paramString2, String paramd, l.d arg5)
    {
      this.b = paramString1;
      this.e = paramString2;
      this.d = paramd;
      Object localObject;
      this.c = localObject;
    }

    public void a()
    {
      if (this.c == null);
      l.a locala2;
      do
      {
        do
        {
          while (true)
          {
            return;
            l.a locala1 = (l.a)l.a(l.this).get(this.d);
            if (locala1 == null)
              break;
            if (!locala1.b(this))
              continue;
            l.a(l.this).remove(this.d);
            return;
          }
          locala2 = (l.a)l.b(l.this).get(this.d);
        }
        while (locala2 == null);
        locala2.b(this);
      }
      while (l.a.a(locala2).size() != 0);
      l.b(l.this).remove(this.d);
    }

    public Bitmap b()
    {
      return this.b;
    }

    public String c()
    {
      return this.e;
    }
  }

  public static abstract interface d extends s.a
  {
    public abstract void a(l.c paramc, boolean paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.l
 * JD-Core Version:    0.6.0
 */