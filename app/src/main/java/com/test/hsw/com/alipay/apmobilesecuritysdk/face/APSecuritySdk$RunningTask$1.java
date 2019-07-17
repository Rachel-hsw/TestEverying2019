package com.alipay.apmobilesecuritysdk.face;

import com.alipay.security.mobile.module.a.a;
import com.taobao.dp.client.IInitResultListener;

class APSecuritySdk$RunningTask$1
  implements IInitResultListener
{
  public void onInitFinished(String paramString, int paramInt)
  {
    APSecuritySdk.b(this.a.a, true);
    if (!a.a(paramString))
      APSecuritySdk.a(this.a.a, paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.face.APSecuritySdk.RunningTask.1
 * JD-Core Version:    0.6.0
 */