package com.umeng.socialize.sso;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.utils.i;

class f
  implements IUiListener
{
  f(c paramc)
  {
  }

  public void onCancel()
  {
    this.a.a.a(SocializeListeners.SnsPostListener.class, p.f, 40000, v.B);
  }

  public void onComplete(Object paramObject)
  {
    int i = this.a.c(paramObject);
    int j = 200;
    if (i != 0)
      j = 40002;
    this.a.a.a(SocializeListeners.SnsPostListener.class, p.f, j, v.B);
    this.a.b(true);
  }

  public void onError(UiError paramUiError)
  {
    i.b("IUiListener", "error code : " + paramUiError.errorCode + "       error message:" + paramUiError.errorMessage);
    this.a.a.a(SocializeListeners.SnsPostListener.class, p.f, 40002, v.B);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.f
 * JD-Core Version:    0.6.0
 */