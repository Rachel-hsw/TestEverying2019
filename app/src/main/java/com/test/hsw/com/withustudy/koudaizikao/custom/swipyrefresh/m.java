package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class m extends Animation
{
  m(SwipyRefreshLayout paramSwipyRefreshLayout, int paramInt1, int paramInt2)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipyRefreshLayout.b(this.a).setAlpha((int)(this.b + paramFloat * (this.c - this.b)));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.m
 * JD-Core Version:    0.6.0
 */