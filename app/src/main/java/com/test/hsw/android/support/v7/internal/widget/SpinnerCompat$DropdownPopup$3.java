package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class SpinnerCompat$DropdownPopup$3
  implements PopupWindow.OnDismissListener
{
  public void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = this.this$1.this$0.getViewTreeObserver();
    if (localViewTreeObserver != null)
      localViewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.3
 * JD-Core Version:    0.6.0
 */