package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

final class i
  implements ServiceConnection
{
  i(h paramh)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (h.a(this.a))
    {
      h.a(this.a, IAlixPay.Stub.asInterface(paramIBinder));
      h.a(this.a).notify();
      return;
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    h.a(this.a, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.i
 * JD-Core Version:    0.6.0
 */