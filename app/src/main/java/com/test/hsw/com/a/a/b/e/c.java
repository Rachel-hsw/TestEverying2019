package com.a.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.a.a.b.a.e;
import com.a.a.b.a.h;

public class c
  implements a
{
  protected final String a;
  protected final e b;
  protected final h c;

  public c(e parame, h paramh)
  {
    this(null, parame, paramh);
  }

  public c(String paramString, e parame, h paramh)
  {
    if (parame == null)
      throw new IllegalArgumentException("imageSize must not be null");
    if (paramh == null)
      throw new IllegalArgumentException("scaleType must not be null");
    this.a = paramString;
    this.b = parame;
    this.c = paramh;
  }

  public int a()
  {
    return this.b.a();
  }

  public boolean a(Bitmap paramBitmap)
  {
    return true;
  }

  public boolean a(Drawable paramDrawable)
  {
    return true;
  }

  public int b()
  {
    return this.b.b();
  }

  public h c()
  {
    return this.c;
  }

  public View d()
  {
    return null;
  }

  public boolean e()
  {
    return false;
  }

  public int f()
  {
    if (TextUtils.isEmpty(this.a))
      return super.hashCode();
    return this.a.hashCode();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.e.c
 * JD-Core Version:    0.6.0
 */