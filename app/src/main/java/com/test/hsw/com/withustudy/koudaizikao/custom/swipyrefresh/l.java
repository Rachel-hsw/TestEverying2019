package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class l extends Animation
{
  l(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipyRefreshLayout.a(this.a, 1.0F - paramFloat);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.l
 * JD-Core Version:    0.6.0
 */