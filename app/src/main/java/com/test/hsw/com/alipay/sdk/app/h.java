package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.d;

final class h
  implements Runnable
{
  h(H5PayActivity.a parama, SslErrorHandler paramSslErrorHandler)
  {
  }

  public final void run()
  {
    d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new i(this), "退出", new j(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.h
 * JD-Core Version:    0.6.0
 */