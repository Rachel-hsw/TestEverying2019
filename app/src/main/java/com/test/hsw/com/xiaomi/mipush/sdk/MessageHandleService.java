package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService extends IntentService
{
  private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue();

  public MessageHandleService()
  {
    super("MessageHandleThread");
  }

  public static void a(a parama)
  {
    if (parama != null)
      a.add(parama);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    a locala;
    if (paramIntent != null)
    {
      locala = (a)a.poll();
      if (locala != null)
        break label19;
    }
    label19: PushMessageReceiver localPushMessageReceiver;
    label181: label207: e locale2;
    do
    {
      PushMessageHandler.a locala1;
      do
      {
        f localf;
        while (true)
        {
          return;
          Intent localIntent;
          try
          {
            localPushMessageReceiver = locala.a();
            localIntent = locala.b();
            switch (localIntent.getIntExtra("message_type", 1))
            {
            case 4:
            case 1:
              locala1 = m.a(this).a(localIntent);
              if (locala1 == null)
                continue;
              if (!(locala1 instanceof f))
                break label207;
              localf = (f)locala1;
              if (!localf.b())
                localPushMessageReceiver.onReceiveMessage(this, localf);
              if (localf.n() != 1)
                break label181;
              localPushMessageReceiver.onReceivePassThroughMessage(this, localf);
              return;
            case 3:
            case 2:
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            c.a(localRuntimeException);
            return;
          }
          e locale1 = (e)localIntent.getSerializableExtra("key_command");
          localPushMessageReceiver.onCommandResult(this, locale1);
          if (!TextUtils.equals(locale1.a(), "register"))
            continue;
          localPushMessageReceiver.onReceiveRegisterResult(this, locale1);
          return;
        }
        if (localf.j())
        {
          localPushMessageReceiver.onNotificationMessageClicked(this, localf);
          return;
        }
        localPushMessageReceiver.onNotificationMessageArrived(this, localf);
        return;
      }
      while (!(locala1 instanceof e));
      locale2 = (e)locala1;
      localPushMessageReceiver.onCommandResult(this, locale2);
    }
    while (!TextUtils.equals(locale2.a(), "register"));
    localPushMessageReceiver.onReceiveRegisterResult(this, locale2);
    return;
  }

  public static class a
  {
    private PushMessageReceiver a;
    private Intent b;

    public a(Intent paramIntent, PushMessageReceiver paramPushMessageReceiver)
    {
      this.a = paramPushMessageReceiver;
      this.b = paramIntent;
    }

    public PushMessageReceiver a()
    {
      return this.a;
    }

    public Intent b()
    {
      return this.b;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MessageHandleService
 * JD-Core Version:    0.6.0
 */