package com.tencent.connect.auth;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.IUiListener;

class AuthAgent$FeedConfirmListener$1 extends AuthAgent.FeedConfirmListener.ButtonListener
{
  public void onClick(View paramView)
  {
    this.c.a();
    if ((this.d != null) && (this.d.isShowing()))
      this.d.dismiss();
    if (this.a != null)
      this.a.onComplete(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthAgent.FeedConfirmListener.1
 * JD-Core Version:    0.6.0
 */