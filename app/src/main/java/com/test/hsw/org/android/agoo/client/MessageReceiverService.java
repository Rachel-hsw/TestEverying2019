package org.android.agoo.client;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.umeng.message.b.ay;
import org.android.agoo.service.ElectionReceiverService.Stub;
import org.android.agoo.service.SendMessage.Stub;

public abstract class MessageReceiverService extends Service
{
  private static final String c = "MessageReceiverService";
  SendMessage.Stub a = new c(this);
  ElectionReceiverService.Stub b = new d(this);

  public abstract String getIntentServiceClassName(Context paramContext);

  public IBinder onBind(Intent paramIntent)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "Message receiver aidl was binded {}";
    arrayOfObject[1] = paramIntent.getAction();
    ay.a("MessageReceiverService", arrayOfObject);
    if ("org.android.agoo.client.ElectionReceiverService".equals(paramIntent.getAction()))
      return this.b;
    if ("org.android.agoo.client.MessageReceiverService".equals(paramIntent.getAction()))
      return this.a;
    return this.a;
  }

  public void onCreate()
  {
    super.onCreate();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.MessageReceiverService
 * JD-Core Version:    0.6.0
 */