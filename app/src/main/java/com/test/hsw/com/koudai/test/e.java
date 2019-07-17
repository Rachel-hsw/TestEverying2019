package com.koudai.test;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.withustudy.koudaizikao.d.f;

class e
  implements View.OnTouchListener
{
  e(BrushExcerciseDetailFragment paramBrushExcerciseDetailFragment)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BrushExcerciseDetailFragment.n(this.a).c(false);
    BrushExcerciseDetailFragment.v(this.a).setVisibility(8);
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.e
 * JD-Core Version:    0.6.0
 */