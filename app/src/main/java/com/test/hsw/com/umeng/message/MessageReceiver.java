package com.umeng.message;

import android.content.Context;
import com.umeng.b.a.a;
import com.umeng.message.b.dl;
import com.umeng.message.local.UmengLocalNotificationManager;
import com.umeng.message.local.UmengLocalNotificationService;
import org.android.agoo.client.BaseBroadcastReceiver;

public class MessageReceiver extends BaseBroadcastReceiver
{
  private static final String a = MessageReceiver.class.getName();

  protected String a(Context paramContext)
  {
    a.c(a, "MessageReceiver");
    if (!dl.c(paramContext, UmengLocalNotificationService.class.getName()))
      UmengLocalNotificationManager.getInstance(paramContext).resetLocalNotifications();
    return PushAgent.getInstance(paramContext).getPushIntentServiceClass();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MessageReceiver
 * JD-Core Version:    0.6.0
 */