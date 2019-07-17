package com.withustudy.koudaizikao.custom.test;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import java.io.PrintStream;

class c
  implements Animation.AnimationListener
{
  c(MasterLayout paramMasterLayout)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    MasterLayout.a(this.a).setVisibility(8);
    MasterLayout.a(this.a).setImageBitmap(MasterLayout.c(this.a));
    MasterLayout.a(this.a).setVisibility(0);
    MasterLayout.a(this.a).startAnimation(MasterLayout.d(this.a));
    MasterLayout.e(this.a).setVisibility(8);
    MasterLayout.f(this.a).setVisibility(0);
    this.a.a.setVisibility(0);
    this.a.d = 2;
    System.out.println("flg_frmwrk_mode" + this.a.d);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    System.out.println("print this");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.test.c
 * JD-Core Version:    0.6.0
 */