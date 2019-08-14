package com.umeng.socialize.sso;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;

class e
  implements IUiListener
{
  e(c paramc)
  {
  }

  public void onCancel()
  {
    i.c("### Tencent Sso Authorize --> onCancel", "Authorize Cancel");
    this.a.f.a(p.f);
  }

  public void onComplete(Object paramObject)
  {
    i.c(c.c(), "oauth complete...");
    v.B.b(this.a.D, p.f, 1);
    this.a.a(this.a.D, paramObject, this.a.f);
  }

  public void onError(UiError paramUiError)
  {
    i.c("Tencent SSo Authorize --> onError:", paramUiError.toString());
    this.a.f.a(new a(paramUiError.errorCode, paramUiError.errorMessage), p.f);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.e
 * JD-Core Version:    0.6.0
 */