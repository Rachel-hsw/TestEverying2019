package com.umeng.socialize.sso;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.utils.i;

class p
  implements IUiListener
{
  p(l paraml)
  {
  }

  public void onCancel()
  {
    this.a.a.a(SocializeListeners.SnsPostListener.class, com.umeng.socialize.bean.p.g, 40000, v.B);
  }

  public void onComplete(Object paramObject)
  {
    int i = 40002;
    if (this.a.c(paramObject) == 0)
      i = 200;
    this.a.a.a(SocializeListeners.SnsPostListener.class, com.umeng.socialize.bean.p.g, i, v.B);
    this.a.b(true);
  }

  public void onError(UiError paramUiError)
  {
    i.b("UMQQSsoHandler", "分享失败! ==> errorCode = " + paramUiError.errorCode + ", errorMsg = " + paramUiError.errorMessage + ", detail = " + paramUiError.errorDetail);
    this.a.a.a(SocializeListeners.SnsPostListener.class, com.umeng.socialize.bean.p.g, 40002, v.B);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.p
 * JD-Core Version:    0.6.0
 */