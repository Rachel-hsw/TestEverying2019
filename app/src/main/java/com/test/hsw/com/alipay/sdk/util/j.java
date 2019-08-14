package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback.Stub;
import java.lang.ref.WeakReference;

final class j extends IRemoteServiceCallback.Stub
{
  j(h paramh)
  {
  }

  public final boolean isHideLoadingScreen()
    throws RemoteException
  {
    return false;
  }

  public final void payEnd(boolean paramBoolean, String paramString)
    throws RemoteException
  {
  }

  public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
    throws RemoteException
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    if (paramBundle == null)
      paramBundle = new Bundle();
    try
    {
      paramBundle.putInt("CallingPid", paramInt);
      localIntent.putExtras(paramBundle);
      label42: localIntent.setClassName(paramString1, paramString2);
      ((Activity)h.b(this.a).get()).startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.j
 * JD-Core Version:    0.6.0
 */