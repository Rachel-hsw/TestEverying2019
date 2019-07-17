package com.handmark.pulltorefresh.library;

import android.webkit.WebView;

class h
  implements PullToRefreshBase.e<WebView>
{
  public void a(PullToRefreshBase<WebView> paramPullToRefreshBase)
  {
    ((WebView)paramPullToRefreshBase.getRefreshableView()).reload();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.h
 * JD-Core Version:    0.6.0
 */