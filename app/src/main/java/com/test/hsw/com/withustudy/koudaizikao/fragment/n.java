package com.withustudy.koudaizikao.fragment;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageButton;

class n
  implements View.OnFocusChangeListener
{
  n(FragmentKPoint paramFragmentKPoint)
  {
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
      FragmentKPoint.c(this.a).setBackgroundResource(2130837884);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.n
 * JD-Core Version:    0.6.0
 */