package com.tencent.connect.auth;

import android.app.Activity;
import com.tencent.open.utils.SystemUtils;
import com.tencent.tauth.IUiListener;

class AuthAgent$1
  implements Runnable
{
  public void run()
  {
    SystemUtils.extractSecureLib("libwbsafeedit", "libwbsafeedit.so", 2);
    AuthAgent.e(this.c).runOnUiThread(new AuthAgent.1.1(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthAgent.1
 * JD-Core Version:    0.6.0
 */