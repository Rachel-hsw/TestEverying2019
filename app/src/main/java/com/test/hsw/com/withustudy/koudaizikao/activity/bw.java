package com.withustudy.koudaizikao.activity;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.withustudy.koudaizikao.g.h;

class bw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bw(WelcomeActivity paramWelcomeActivity)
  {
  }

  public void onGlobalLayout()
  {
    WelcomeActivity.access$5(this.a, WelcomeActivity.access$4(this.a).getMeasuredHeight());
    WelcomeActivity.access$6(this.a, WelcomeActivity.access$4(this.a).getMeasuredWidth());
    h.a("height=" + WelcomeActivity.access$7(this.a));
    h.a("height=" + WelcomeActivity.access$7(this.a));
    h.a("height=" + WelcomeActivity.access$7(this.a));
    h.a("height=" + WelcomeActivity.access$7(this.a));
    h.a("width=" + WelcomeActivity.access$8(this.a));
    h.a("width=" + WelcomeActivity.access$8(this.a));
    h.a("width=" + WelcomeActivity.access$8(this.a));
    h.a("width=" + WelcomeActivity.access$8(this.a));
    h.a("width=" + WelcomeActivity.access$8(this.a));
    WelcomeActivity.access$4(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bw
 * JD-Core Version:    0.6.0
 */