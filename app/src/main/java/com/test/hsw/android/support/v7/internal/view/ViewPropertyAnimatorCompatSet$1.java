package android.support.v7.internal.view;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import java.util.ArrayList;

class ViewPropertyAnimatorCompatSet$1 extends ViewPropertyAnimatorListenerAdapter
{
  private int mProxyEndCount = 0;
  private boolean mProxyStarted = false;

  public void onAnimationEnd(View paramView)
  {
    int i = 1 + this.mProxyEndCount;
    this.mProxyEndCount = i;
    if (i == ViewPropertyAnimatorCompatSet.access$200(this.this$0).size())
    {
      if (ViewPropertyAnimatorCompatSet.access$000(this.this$0) != null)
        ViewPropertyAnimatorCompatSet.access$000(this.this$0).onAnimationEnd(null);
      onEnd();
    }
  }

  public void onAnimationStart(View paramView)
  {
    if (this.mProxyStarted);
    do
    {
      return;
      this.mProxyStarted = true;
    }
    while (ViewPropertyAnimatorCompatSet.access$000(this.this$0) == null);
    ViewPropertyAnimatorCompatSet.access$000(this.this$0).onAnimationStart(null);
  }

  void onEnd()
  {
    this.mProxyEndCount = 0;
    this.mProxyStarted = false;
    ViewPropertyAnimatorCompatSet.access$100(this.this$0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.ViewPropertyAnimatorCompatSet.1
 * JD-Core Version:    0.6.0
 */