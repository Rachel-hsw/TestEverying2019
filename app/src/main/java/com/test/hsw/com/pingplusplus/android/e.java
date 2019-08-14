package com.pingplusplus.android;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONException;
import org.json.JSONObject;

class e extends WebViewClient
{
  e(PaymentActivity paramPaymentActivity)
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
    try
    {
      String str1 = PaymentActivity.c(this.a).getString("channel");
      JSONObject localJSONObject = PaymentActivity.c(this.a).getJSONObject("extra");
      String str2 = localJSONObject.getString("success_url");
      String str3 = localJSONObject.getString("fail_url");
      PingppLog.d("jdPay url: " + paramString);
      PingppLog.d("jdPay successUrl: " + str2);
      PingppLog.d("jdPay fail_url : " + str3);
      if ("jdpay_wap".equals(str1))
      {
        if (!paramString.contains(str2))
          break label155;
        PaymentActivity.b(this.a, "success");
        PingppLog.d("jdPay success");
      }
      while (true)
      {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
        label155: if (!paramString.contains(str3))
          continue;
        PaymentActivity.b(this.a, "fail");
        PingppLog.d("jdPay fail");
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        PaymentActivity.b(this.a, "fail");
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.e
 * JD-Core Version:    0.6.0
 */