package com.android.http;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.widget.ImageView;
import com.a.a.b.c.a;

class j extends com.a.a.b.f.d
{
  j(e parame, ImageView paramImageView, int paramInt)
  {
  }

  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    super.a(paramString, paramView, paramBitmap);
    if ((this.b.getTag() != null) && (this.c == ((Integer)this.b.getTag()).intValue()))
    {
      com.a.a.b.c localc = new c.a().b(2130837854).c(2130837854).d(2130837854).b(true).d(true).e(true).a(new com.a.a.b.c.c(100)).a(Bitmap.Config.RGB_565).d();
      com.a.a.b.d.a().a(paramString, this.b, localc);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.j
 * JD-Core Version:    0.6.0
 */