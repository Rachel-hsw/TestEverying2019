package com.umeng.socialize.sso;

import android.os.Bundle;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;

class o
  implements IUiListener
{
  o(l paraml)
  {
  }

  public void onCancel()
  {
    i.c("UMQQSsoHandler", "cancel");
    m.a(this.a.b);
    this.a.f.a(p.g);
    if (v.B != null)
      v.B.b(this.a.D, p.g, 0);
  }

  public void onComplete(Object paramObject)
  {
    m.a(this.a.b);
    Bundle localBundle = this.a.a(paramObject);
    if ((localBundle != null) && (localBundle.getInt("ret") == 0))
    {
      if (v.B != null)
        v.B.b(this.a.D, p.g, 1);
      this.a.a(this.a.D, paramObject, this.a.f);
      return;
    }
    if (v.B != null)
      v.B.b(this.a.D, p.g, 0);
    this.a.f.a(null, p.g);
  }

  public void onError(UiError paramUiError)
  {
    if (paramUiError != null)
      i.c("UMQQSsoHandler", "授权失败! ==> errorCode = " + paramUiError.errorCode + ", errorMsg = " + paramUiError.errorMessage + ", detail = " + paramUiError.errorDetail);
    m.a(this.a.b);
    this.a.f.a(new a(paramUiError.errorCode, paramUiError.errorDetail), p.g);
    if (v.B != null)
      v.B.b(this.a.D, p.g, 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.o
 * JD-Core Version:    0.6.0
 */