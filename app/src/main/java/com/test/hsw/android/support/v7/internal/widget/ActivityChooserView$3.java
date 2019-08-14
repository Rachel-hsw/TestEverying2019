package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

class ActivityChooserView$3 extends ListPopupWindow.ForwardingListener
{
  public ListPopupWindow getPopup()
  {
    return ActivityChooserView.access$100(this.this$0);
  }

  protected boolean onForwardingStarted()
  {
    this.this$0.showPopup();
    return true;
  }

  protected boolean onForwardingStopped()
  {
    this.this$0.dismissPopup();
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.3
 * JD-Core Version:    0.6.0
 */