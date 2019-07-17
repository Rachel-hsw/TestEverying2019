package com.withustudy.koudaizikao.custom;

import android.graphics.Bitmap;

public class g
  implements IrregularPercentRelativeLayout.a
{
  private Bitmap a;

  public g(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (this.a == null) || (this.a.getPixel(paramInt1, paramInt2) != 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.g
 * JD-Core Version:    0.6.0
 */