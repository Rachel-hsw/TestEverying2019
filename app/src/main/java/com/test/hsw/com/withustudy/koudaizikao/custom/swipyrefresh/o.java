package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class o extends Animation
{
  o(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f = SwipyRefreshLayout.k(this.a) + paramFloat * -SwipyRefreshLayout.k(this.a);
    SwipyRefreshLayout.a(this.a, f);
    SwipyRefreshLayout.b(this.a, paramFloat);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.o
 * JD-Core Version:    0.6.0
 */