package android.support.v7.internal.widget;

import android.view.View;

class ScrollingTabContainerView$1
  implements Runnable
{
  public void run()
  {
    int i = this.val$tabView.getLeft() - (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2;
    this.this$0.smoothScrollTo(i, 0);
    this.this$0.mTabSelector = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.1
 * JD-Core Version:    0.6.0
 */