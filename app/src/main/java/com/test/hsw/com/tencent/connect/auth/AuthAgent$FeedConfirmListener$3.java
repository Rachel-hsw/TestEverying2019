package com.tencent.connect.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tauth.IUiListener;

class AuthAgent$FeedConfirmListener$3
  implements DialogInterface.OnCancelListener
{
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a != null)
      this.a.onComplete(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthAgent.FeedConfirmListener.3
 * JD-Core Version:    0.6.0
 */