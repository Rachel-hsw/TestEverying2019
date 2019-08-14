package com.umeng.socialize.sso;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.b.a.a.a;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class k
  implements ServiceConnection
{
  k(j paramj, SocializeListeners.UMAuthListener paramUMAuthListener, Activity paramActivity)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    j.a(this.c, true);
    com.b.a.a locala = a.a.a(paramIBinder);
    try
    {
      j.a(locala.a());
      j.b(locala.b());
      if ((!j.a(this.c, this.b, j.b(this.c), new String[0], 5668)) && (this.a != null))
        this.a.a(new com.umeng.socialize.a.a("can`t start singel sign on. "), j.a(this.c));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a != null)
      this.a.a(new com.umeng.socialize.a.a("无法连接新浪客户端"), j.a(this.c));
    j.a(this.c, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.k
 * JD-Core Version:    0.6.0
 */