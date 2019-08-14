package com.android.http;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.a.a.b.f.d;

class h extends d
{
  h(e parame, ImageView paramImageView, int paramInt)
  {
  }

  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    super.a(paramString, paramView, paramBitmap);
    if ((this.b.getTag() != null) && (this.c == ((Integer)this.b.getTag()).intValue()))
      this.b.setImageBitmap(paramBitmap);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.h
 * JD-Core Version:    0.6.0
 */