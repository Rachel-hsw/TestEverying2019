package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class e
  implements Animation.AnimationListener
{
  e(b paramb, b.c paramc)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a();
    this.b.l();
    this.b.a(false);
    b.a(this.a).startAnimation(b.b(this.a));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.e
 * JD-Core Version:    0.6.0
 */