package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class LocationClient$1
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LocationClient.jdMethod_if(this.a, new Messenger(paramIBinder));
    if (LocationClient.h(this.a) == null);
    while (true)
    {
      return;
      LocationClient.jdMethod_for(this.a, true);
      Log.d("baidu_location_client", "baidu location connected ...");
      if (LocationClient.jdMethod_case(this.a))
      {
        LocationClient.jdMethod_new(this.a).obtainMessage(2).sendToTarget();
        return;
      }
      try
      {
        Message localMessage = Message.obtain(null, 11);
        localMessage.replyTo = LocationClient.jdMethod_try(this.a);
        localMessage.setData(LocationClient.jdMethod_do(this.a));
        LocationClient.h(this.a).send(localMessage);
        LocationClient.jdMethod_for(this.a, true);
        if (LocationClient.jdMethod_char(this.a) == null)
          continue;
        if (LocationClient.jdMethod_int(this.a).booleanValue());
        LocationClient.jdMethod_new(this.a).obtainMessage(4).sendToTarget();
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LocationClient.jdMethod_if(this.a, null);
    LocationClient.jdMethod_for(this.a, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.LocationClient.1
 * JD-Core Version:    0.6.0
 */