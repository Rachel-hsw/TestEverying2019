package com.a.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.a.a.b.g.a;
import com.a.a.c.d;

final class m
  implements Runnable
{
  private static final String a = "PostProcess image before displaying [%s]";
  private final f b;
  private final Bitmap c;
  private final h d;
  private final Handler e;

  public m(f paramf, Bitmap paramBitmap, h paramh, Handler paramHandler)
  {
    this.b = paramf;
    this.c = paramBitmap;
    this.d = paramh;
    this.e = paramHandler;
  }

  public void run()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d.b;
    d.a("PostProcess image before displaying [%s]", arrayOfObject);
    i.a(new b(this.d.e.p().a(this.c), this.d, this.b, com.a.a.b.a.f.c), this.d.e.s(), this.e, this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.m
 * JD-Core Version:    0.6.0
 */