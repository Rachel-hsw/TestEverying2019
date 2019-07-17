package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class j extends Animation
{
  j(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipyRefreshLayout.b(this.a, paramFloat);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.j
 * JD-Core Version:    0.6.0
 */