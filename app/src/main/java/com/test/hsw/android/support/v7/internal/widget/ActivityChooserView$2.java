package android.support.v7.internal.widget;

import android.support.v4.view.ActionProvider;
import android.support.v7.widget.ListPopupWindow;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    if (this.this$0.isShowingPopup())
    {
      if (this.this$0.isShown())
        break label31;
      ActivityChooserView.access$100(this.this$0).dismiss();
    }
    label31: 
    do
    {
      return;
      ActivityChooserView.access$100(this.this$0).show();
    }
    while (this.this$0.mProvider == null);
    this.this$0.mProvider.subUiVisibilityChanged(true);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.2
 * JD-Core Version:    0.6.0
 */