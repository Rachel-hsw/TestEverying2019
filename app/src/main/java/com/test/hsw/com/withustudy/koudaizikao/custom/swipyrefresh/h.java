package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class h
  implements Animation.AnimationListener
{
  h(SwipyRefreshLayout paramSwipyRefreshLayout)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SwipyRefreshLayout.a(this.a))
    {
      SwipyRefreshLayout.b(this.a).setAlpha(255);
      SwipyRefreshLayout.b(this.a).start();
      if ((SwipyRefreshLayout.c(this.a)) && (SwipyRefreshLayout.d(this.a) != null))
        SwipyRefreshLayout.d(this.a).a(SwipyRefreshLayout.e(this.a));
    }
    while (true)
    {
      SwipyRefreshLayout.b(this.a, SwipyRefreshLayout.f(this.a).getTop());
      return;
      SwipyRefreshLayout.b(this.a).stop();
      SwipyRefreshLayout.f(this.a).setVisibility(8);
      SwipyRefreshLayout.a(this.a, 255);
      if (SwipyRefreshLayout.g(this.a))
      {
        SwipyRefreshLayout.a(this.a, 0.0F);
        continue;
      }
      SwipyRefreshLayout.a(this.a, this.a.d - SwipyRefreshLayout.h(this.a), true);
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.h
 * JD-Core Version:    0.6.0
 */