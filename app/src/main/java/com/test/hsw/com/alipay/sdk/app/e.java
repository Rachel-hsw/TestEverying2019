package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class e
  implements DialogInterface.OnClickListener
{
  e(c paramc)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    H5AuthActivity.a(this.a.b.a, false);
    l.a = l.a();
    this.a.b.a.finish();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.e
 * JD-Core Version:    0.6.0
 */