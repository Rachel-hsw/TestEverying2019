package com.tencent.connect.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.open.web.security.JniInterface;

class AuthDialog$3
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    try
    {
      JniInterface.clearAllPWD();
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthDialog.3
 * JD-Core Version:    0.6.0
 */