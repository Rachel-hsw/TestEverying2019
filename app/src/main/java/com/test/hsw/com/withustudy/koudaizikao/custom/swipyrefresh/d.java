package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class d extends Animation
{
  d(b paramb, b.c paramc)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = (float)(1.0D + Math.floor(this.b.k() / 0.8F));
    float f2 = this.b.e() + paramFloat * (this.b.f() - this.b.e());
    this.b.b(f2);
    float f3 = this.b.k() + paramFloat * (f1 - this.b.k());
    this.b.d(f3);
    this.b.e(1.0F - paramFloat);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.d
 * JD-Core Version:    0.6.0
 */