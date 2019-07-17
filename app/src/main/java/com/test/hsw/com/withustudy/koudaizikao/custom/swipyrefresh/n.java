package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class n
  implements Animation.AnimationListener
{
  n(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!SwipyRefreshLayout.g(this.a))
      SwipyRefreshLayout.a(this.a, null);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.n
 * JD-Core Version:    0.6.0
 */