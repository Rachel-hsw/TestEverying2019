package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class i extends Animation
{
  i(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i;
    if (!SwipyRefreshLayout.i(this.a))
      switch (a()[SwipyRefreshLayout.e(this.a).ordinal()])
      {
      default:
        i = (int)(SwipyRefreshLayout.j(this.a) - Math.abs(this.a.d));
      case 2:
      }
    while (true)
    {
      int j = this.a.c + (int)(paramFloat * (i - this.a.c)) - SwipyRefreshLayout.f(this.a).getTop();
      SwipyRefreshLayout.a(this.a, j, false);
      return;
      i = this.a.getMeasuredHeight() - (int)SwipyRefreshLayout.j(this.a);
      continue;
      i = (int)SwipyRefreshLayout.j(this.a);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.i
 * JD-Core Version:    0.6.0
 */