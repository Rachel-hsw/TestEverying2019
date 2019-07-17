package com.withustudy.koudaizikao.custom.test;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class b
  implements Animation.AnimationListener
{
  b(MasterLayout paramMasterLayout)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.e = false;
    MasterLayout.a(this.a).startAnimation(MasterLayout.b(this.a));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.test.b
 * JD-Core Version:    0.6.0
 */