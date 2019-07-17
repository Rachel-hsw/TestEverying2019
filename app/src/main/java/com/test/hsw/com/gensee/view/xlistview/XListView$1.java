package com.gensee.view.xlistview;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

class XListView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    XListView.access$1(this.this$0, XListView.access$0(this.this$0).getHeight());
    this.this$0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.xlistview.XListView.1
 * JD-Core Version:    0.6.0
 */