package com.android.http;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.a.a.b.f.d;
import com.withustudy.koudaizikao.d.f;

class i extends d
{
  i(e parame, Context paramContext, ImageView paramImageView)
  {
  }

  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    super.a(paramString, paramView, paramBitmap);
    double d = paramBitmap.getHeight() / paramBitmap.getWidth();
    int i = f.a(this.b).y();
    float f = f.a(null).z();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(i - 2.0F * (12.0F * f / 160.0F)), (int)(d * (i - 2.0F * (f * 12.0F / 160.0F))));
    this.c.setLayoutParams(localLayoutParams);
    this.c.setImageBitmap(paramBitmap);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.i
 * JD-Core Version:    0.6.0
 */