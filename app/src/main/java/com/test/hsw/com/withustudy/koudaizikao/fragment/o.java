package com.withustudy.koudaizikao.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.PopupWindow;

class o
  implements View.OnKeyListener
{
  o(FragmentKPoint paramFragmentKPoint)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FragmentKPoint.b(this.a).dismiss();
      FragmentKPoint.a(this.a, null);
      this.a.a(1.0F);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.o
 * JD-Core Version:    0.6.0
 */