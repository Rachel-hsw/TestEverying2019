package com.pingplusplus.android;

import com.baidu.android.pay.PayCallBack;

class b
  implements PayCallBack
{
  b(PaymentActivity paramPaymentActivity)
  {
  }

  public boolean isHideLoadingDialog()
  {
    return false;
  }

  public void onPayResult(int paramInt, String paramString)
  {
    PaymentActivity.a(this.a, 0);
    PaymentActivity.a(this.a, paramInt, paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.b
 * JD-Core Version:    0.6.0
 */