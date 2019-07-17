package com.handmark.pulltorefresh.library;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class i extends WebChromeClient
{
  i(PullToRefreshWebView paramPullToRefreshWebView)
  {
  }

  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100)
      this.a.f();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.i
 * JD-Core Version:    0.6.0
 */