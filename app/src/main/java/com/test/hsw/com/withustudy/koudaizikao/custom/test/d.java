package com.withustudy.koudaizikao.custom.test;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class d
  implements Animation.AnimationListener
{
  d(MasterLayout paramMasterLayout)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    MasterLayout.a(this.a).setVisibility(0);
    MasterLayout.a(this.a).setImageBitmap(MasterLayout.g(this.a));
    this.a.d = 3;
    MasterLayout.a(this.a).startAnimation(MasterLayout.d(this.a));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.test.d
 * JD-Core Version:    0.6.0
 */