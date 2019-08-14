package com.gensee.view;

import android.widget.PopupWindow.OnDismissListener;

class AbsChatToPopView$1
  implements PopupWindow.OnDismissListener
{
  public void onDismiss()
  {
    AbsChatToPopView.access$3(this.this$0, false);
    if (AbsChatToPopView.access$1(this.this$0) != null)
      AbsChatToPopView.access$1(this.this$0).selectStatus(false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AbsChatToPopView.1
 * JD-Core Version:    0.6.0
 */