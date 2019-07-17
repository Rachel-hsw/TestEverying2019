package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class g
  implements Animation.AnimationListener
{
  g(b paramb, b.c paramc)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.b.l();
    this.b.a();
    this.b.b(this.b.g());
    b.a(this.a, (1.0F + b.c(this.a)) % 5.0F);
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    b.a(this.a, 0.0F);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.g
 * JD-Core Version:    0.6.0
 */