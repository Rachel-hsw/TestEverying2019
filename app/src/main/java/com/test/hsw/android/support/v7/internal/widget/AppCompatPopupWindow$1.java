package android.support.v7.internal.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class AppCompatPopupWindow$1
  implements ViewTreeObserver.OnScrollChangedListener
{
  public void onScrollChanged()
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)this.val$fieldAnchor.get(this.val$popup);
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null)
          return;
        this.val$originalListener.onScrollChanged();
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AppCompatPopupWindow.1
 * JD-Core Version:    0.6.0
 */