package com.umeng.socialize.view;

import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class ag extends WebChromeClient
{
  ag(aa paramaa)
  {
  }

  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt < 90)
    {
      aa.a(this.a).setVisibility(0);
      return;
    }
    aa.d(this.a).sendEmptyMessage(1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ag
 * JD-Core Version:    0.6.0
 */