package com.umeng.socialize.view;

import com.umeng.socialize.utils.i;
import com.umeng.socialize.view.wigets.KeyboardListenRelativeLayout.IOnKeyboardStateChangedListener;

class k
  implements KeyboardListenRelativeLayout.IOnKeyboardStateChangedListener
{
  k(ShareActivity paramShareActivity)
  {
  }

  public void a(int paramInt)
  {
    ShareActivity.a(this.a, paramInt);
    i.c(ShareActivity.b(), "onKeyboardStateChanged  now state is " + paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.k
 * JD-Core Version:    0.6.0
 */