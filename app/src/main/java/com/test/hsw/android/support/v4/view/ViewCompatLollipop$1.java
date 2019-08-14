package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ViewCompatLollipop$1
  implements View.OnApplyWindowInsetsListener
{
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    WindowInsetsCompatApi21 localWindowInsetsCompatApi21 = new WindowInsetsCompatApi21(paramWindowInsets);
    return ((WindowInsetsCompatApi21)this.val$listener.onApplyWindowInsets(paramView, localWindowInsetsCompatApi21)).unwrap();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatLollipop.1
 * JD-Core Version:    0.6.0
 */