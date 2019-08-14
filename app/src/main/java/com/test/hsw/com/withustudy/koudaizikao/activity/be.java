package com.withustudy.koudaizikao.activity;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.withustudy.koudaizikao.g.h;

class be
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  be(ShowCardActivity paramShowCardActivity)
  {
  }

  public void onGlobalLayout()
  {
    ShowCardActivity.a(this.a, ShowCardActivity.t(this.a).getHeight());
    h.a(this.a.getApplicationContext(), "h=" + ShowCardActivity.u(this.a));
    ShowCardActivity.t(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.be
 * JD-Core Version:    0.6.0
 */