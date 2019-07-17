package com.umeng.socialize.view;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

class ah extends aa.a
{
  ah(aa paramaa)
  {
    super(paramaa, null);
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ah
 * JD-Core Version:    0.6.0
 */