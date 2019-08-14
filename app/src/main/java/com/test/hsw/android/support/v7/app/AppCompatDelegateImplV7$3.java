package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class AppCompatDelegateImplV7$3
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  public void onFitSystemWindows(Rect paramRect)
  {
    paramRect.top = AppCompatDelegateImplV7.access$300(this.this$0, paramRect.top);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.3
 * JD-Core Version:    0.6.0
 */