package com.himamis.retex.renderer.android.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.himamis.retex.renderer.a.g.c.g;

public class e
  implements g
{
  private Bitmap c;

  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }

  public int a()
  {
    return this.c.getWidth();
  }

  public int b()
  {
    return this.c.getWidth();
  }

  public com.himamis.retex.renderer.a.g.c.c c()
  {
    return new c(new Canvas(this.c));
  }

  public Bitmap d()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.e
 * JD-Core Version:    0.6.0
 */