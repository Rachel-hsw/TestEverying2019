package com.a.a.b;

import android.graphics.Bitmap;
import com.a.a.c.d;

final class b
  implements Runnable
{
  private static final String a = "Display image in ImageAware (loaded from %1$s) [%2$s]";
  private static final String b = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String c = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private final Bitmap d;
  private final String e;
  private final com.a.a.b.e.a f;
  private final String g;
  private final com.a.a.b.c.a h;
  private final com.a.a.b.f.a i;
  private final f j;
  private final com.a.a.b.a.f k;

  public b(Bitmap paramBitmap, h paramh, f paramf, com.a.a.b.a.f paramf1)
  {
    this.d = paramBitmap;
    this.e = paramh.a;
    this.f = paramh.c;
    this.g = paramh.b;
    this.h = paramh.e.q();
    this.i = paramh.f;
    this.j = paramf;
    this.k = paramf1;
  }

  private boolean a()
  {
    String str = this.j.a(this.f);
    return !this.g.equals(str);
  }

  public void run()
  {
    if (this.f.e())
    {
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.g;
      d.a("ImageAware was collected by GC. Task is cancelled. [%s]", arrayOfObject3);
      this.i.b(this.e, this.f.d());
      return;
    }
    if (a())
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.g;
      d.a("ImageAware is reused for another image. Task is cancelled. [%s]", arrayOfObject2);
      this.i.b(this.e, this.f.d());
      return;
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.k;
    arrayOfObject1[1] = this.g;
    d.a("Display image in ImageAware (loaded from %1$s) [%2$s]", arrayOfObject1);
    this.h.a(this.d, this.f, this.k);
    this.j.b(this.f);
    this.i.a(this.e, this.f.d(), this.d);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.b
 * JD-Core Version:    0.6.0
 */