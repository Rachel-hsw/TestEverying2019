package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;

final class c
  implements Runnable
{
  c(H5AuthActivity.a parama, SslErrorHandler paramSslErrorHandler)
  {
  }

  public final void run()
  {
    com.alipay.sdk.widget.d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.c
 * JD-Core Version:    0.6.0
 */