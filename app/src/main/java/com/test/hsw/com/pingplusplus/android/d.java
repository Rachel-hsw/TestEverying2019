package com.pingplusplus.android;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class d extends WebViewClient
{
  d(PaymentActivity paramPaymentActivity)
  {
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((PaymentActivity.b(this.a) != null) && (PaymentActivity.b(this.a).isShowing()))
      PaymentActivity.b(this.a).dismiss();
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    PingppLog.d("YEEPay open  url:" + paramString);
    if (paramString.contains("https://ok.yeepay.com/paymobile/query/pay/success?"))
    {
      PingppLog.d("YEEPay YEEPAY_WAP_SUCCESS_URL:https://ok.yeepay.com/paymobile/query/pay/success?");
      PaymentActivity.b(this.a, "success");
    }
    while (true)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
      if (!paramString.contains("http://mobiletest.yeepay.com/paymobile/query/pay/success?"))
        continue;
      PingppLog.d("YEEPay YEEPAY_WAP_TEST_SUCCESS_URL:http://mobiletest.yeepay.com/paymobile/query/pay/success?");
      PaymentActivity.b(this.a, "success");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.d
 * JD-Core Version:    0.6.0
 */