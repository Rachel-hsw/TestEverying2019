package com.umeng.socialize.view;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.umeng.socialize.common.s;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.a;

class q extends s<Bitmap>
{
  q(ShareActivity paramShareActivity, UMImage paramUMImage, int paramInt)
  {
  }

  protected void a(Bitmap paramBitmap)
  {
    super.a(paramBitmap);
    ShareActivity.s(this.c).setVisibility(4);
    this.c.a.setVisibility(0);
    ShareActivity.a(this.c, this.b, paramBitmap);
  }

  protected Bitmap d()
  {
    String str = this.a.k();
    if (TextUtils.isEmpty(str))
      str = this.a.a();
    return a.b(str, 150, 150);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.q
 * JD-Core Version:    0.6.0
 */