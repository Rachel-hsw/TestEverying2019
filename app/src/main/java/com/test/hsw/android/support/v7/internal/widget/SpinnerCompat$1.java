package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

class SpinnerCompat$1 extends ListPopupWindow.ForwardingListener
{
  public ListPopupWindow getPopup()
  {
    return this.val$popup;
  }

  public boolean onForwardingStarted()
  {
    if (!SpinnerCompat.access$100(this.this$0).isShowing())
      SpinnerCompat.access$100(this.this$0).show();
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.1
 * JD-Core Version:    0.6.0
 */