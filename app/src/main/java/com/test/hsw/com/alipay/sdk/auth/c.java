package com.alipay.sdk.auth;

import android.webkit.WebView;

final class c
  implements Runnable
{
  c(AuthActivity paramAuthActivity, String paramString)
  {
  }

  public final void run()
  {
    try
    {
      AuthActivity.h(this.b).loadUrl("javascript:" + this.a);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.auth.c
 * JD-Core Version:    0.6.0
 */