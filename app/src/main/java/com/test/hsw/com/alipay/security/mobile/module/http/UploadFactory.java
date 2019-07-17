package com.alipay.security.mobile.module.http;

import android.content.Context;

public class UploadFactory
{
  public static IUpload create(Context paramContext, Mode paramMode)
  {
    if (paramContext == null)
      return null;
    return RPCUploadImpl.getInstance(paramContext);
  }

  public static enum Mode
  {
    static
    {
      RPC_MPASS = new Mode("RPC_MPASS", 2);
      Mode[] arrayOfMode = new Mode[3];
      arrayOfMode[0] = RPC;
      arrayOfMode[1] = RPC_WALLET;
      arrayOfMode[2] = RPC_MPASS;
      $VALUES = arrayOfMode;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.http.UploadFactory
 * JD-Core Version:    0.6.0
 */