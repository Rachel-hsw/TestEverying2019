package com.pingplusplus.android;

import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;

class a extends Thread
{
  a(PaymentActivity paramPaymentActivity, String paramString)
  {
  }

  public void run()
  {
    String str = new PayTask(this.b).pay(this.a);
    PingppLog.d("PaymentActivity alipay result: " + str);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = str;
    PaymentActivity.a(this.b).sendMessage(localMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.a
 * JD-Core Version:    0.6.0
 */