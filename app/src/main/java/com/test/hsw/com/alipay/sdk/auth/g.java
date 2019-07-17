package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class g
  implements DialogInterface.OnClickListener
{
  g(e parame)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    AuthActivity.a(this.a.b.a, false);
    String str = AuthActivity.c(this.a.b.a) + "?resultCode=150";
    h.a(this.a.b.a, str);
    this.a.b.a.finish();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.auth.g
 * JD-Core Version:    0.6.0
 */