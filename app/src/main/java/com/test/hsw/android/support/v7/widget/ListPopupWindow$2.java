package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$2
  implements Runnable
{
  public void run()
  {
    View localView = this.this$0.getAnchorView();
    if ((localView != null) && (localView.getWindowToken() != null))
      this.this$0.show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.2
 * JD-Core Version:    0.6.0
 */