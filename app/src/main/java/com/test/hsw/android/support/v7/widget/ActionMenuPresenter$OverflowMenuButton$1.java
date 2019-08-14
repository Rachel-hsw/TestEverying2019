package android.support.v7.widget;

import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1 extends ListPopupWindow.ForwardingListener
{
  public ListPopupWindow getPopup()
  {
    if (ActionMenuPresenter.access$200(this.this$1.this$0) == null)
      return null;
    return ActionMenuPresenter.access$200(this.this$1.this$0).getPopup();
  }

  public boolean onForwardingStarted()
  {
    this.this$1.this$0.showOverflowMenu();
    return true;
  }

  public boolean onForwardingStopped()
  {
    if (ActionMenuPresenter.access$300(this.this$1.this$0) != null)
      return false;
    this.this$1.this$0.hideOverflowMenu();
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
 * JD-Core Version:    0.6.0
 */