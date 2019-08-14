package org.android.agoo.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.umeng.message.b.cs;
import com.umeng.message.b.cs.a;
import org.json.JSONObject;

class ControlService$2
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      cs localcs = cs.a.a(paramIBinder);
      long l = System.currentTimeMillis();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packageName", ControlService.a(this.a).getPackageName());
      localJSONObject.put("data", "");
      localJSONObject.put("from", "agoo");
      localcs.a(localJSONObject.toString());
      Log.d("ControlService", "ippConnection target time[" + (System.currentTimeMillis() - l) + "]");
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        while (true)
        {
          if (ControlService.a(this.a) != null)
          {
            Log.d("ControlService", "ippConnection [unbind]");
            ControlService.a(this.a).unbindService(ControlService.c(this.a));
          }
          return;
          localThrowable1 = localThrowable1;
          Log.d("ControlService", "ippConnection", localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        Log.w("ControlService", "ippConnection", localThrowable2);
      }
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d("ControlService", "ippConnection onServiceDisconnected  ");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.ControlService.2
 * JD-Core Version:    0.6.0
 */