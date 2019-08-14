package com.withustudy.koudaizikao.fragment;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.withustudy.koudaizikao.g.h;
import krelve.view.Kanner;

class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  c(BrushMainFragment paramBrushMainFragment)
  {
  }

  public void onGlobalLayout()
  {
    BrushMainFragment.a(this.a, BrushMainFragment.b(this.a).getMeasuredHeight());
    BrushMainFragment.b(this.a, BrushMainFragment.b(this.a).getMeasuredWidth());
    BrushMainFragment.b(this.a).a(BrushMainFragment.h(this.a), BrushMainFragment.i(this.a));
    h.a("measuredHeight =" + BrushMainFragment.i(this.a));
    h.a("measuredWidth =" + BrushMainFragment.h(this.a));
    BrushMainFragment.b(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.c
 * JD-Core Version:    0.6.0
 */