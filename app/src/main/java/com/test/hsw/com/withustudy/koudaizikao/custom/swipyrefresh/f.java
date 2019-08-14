package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class f extends Animation
{
  f(b paramb, b.c paramc)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = (float)Math.toRadians(this.b.c() / (6.283185307179586D * this.b.j()));
    float f2 = this.b.f();
    float f3 = this.b.e();
    float f4 = this.b.k();
    float f5 = f2 + (0.8F - f1) * b.a().getInterpolation(paramFloat);
    this.b.c(f5);
    float f6 = f3 + 0.8F * b.b().getInterpolation(paramFloat);
    this.b.b(f6);
    float f7 = f4 + 0.25F * paramFloat;
    this.b.d(f7);
    float f8 = 144.0F * paramFloat + 720.0F * (b.c(this.a) / 5.0F);
    this.a.c(f8);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.f
 * JD-Core Version:    0.6.0
 */