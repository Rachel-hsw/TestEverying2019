package com.pingplusplus.android;

import android.webkit.JavascriptInterface;

public class h
{
  public h(PaymentActivity paramPaymentActivity)
  {
  }

  @JavascriptInterface
  public void setResult(String paramString)
  {
    if (paramString == null)
    {
      PaymentActivity.a(this.a, "fail", "unknown_error");
      return;
    }
    if (paramString.equals("success"))
    {
      PaymentActivity.a(this.a, "success");
      return;
    }
    PaymentActivity.a(this.a, "fail", "unknown_error");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.h
 * JD-Core Version:    0.6.0
 */