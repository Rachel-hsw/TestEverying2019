package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class PushMessageReceiver extends BroadcastReceiver
{
  public void onCommandResult(Context paramContext, e parame)
  {
  }

  public void onNotificationMessageArrived(Context paramContext, f paramf)
  {
  }

  public void onNotificationMessageClicked(Context paramContext, f paramf)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    MessageHandleService.a(new MessageHandleService.a(paramIntent, this));
    Intent localIntent = new Intent(paramContext, MessageHandleService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  @Deprecated
  public void onReceiveMessage(Context paramContext, f paramf)
  {
  }

  public void onReceivePassThroughMessage(Context paramContext, f paramf)
  {
  }

  public void onReceiveRegisterResult(Context paramContext, e parame)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.PushMessageReceiver
 * JD-Core Version:    0.6.0
 */