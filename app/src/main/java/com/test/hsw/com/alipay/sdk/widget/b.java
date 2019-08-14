package com.alipay.sdk.widget;

import android.app.ProgressDialog;

final class b
  implements Runnable
{
  b(a parama, CharSequence paramCharSequence)
  {
  }

  public final void run()
  {
    if (this.d.b == null)
      this.d.b = new ProgressDialog(this.d.a);
    this.d.b.setCancelable(this.a);
    this.d.b.setOnCancelListener(this.b);
    this.d.b.setMessage(this.c);
    try
    {
      this.d.b.show();
      return;
    }
    catch (Exception localException)
    {
      this.d.b = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.widget.b
 * JD-Core Version:    0.6.0
 */