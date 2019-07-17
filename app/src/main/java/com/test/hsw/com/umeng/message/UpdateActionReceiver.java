package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import java.io.Serializable;

public class UpdateActionReceiver extends BroadcastReceiver
{
  private static final String a = UpdateActionReceiver.class.getName();
  private com.umeng.message.a.a b;

  public UpdateActionReceiver(com.umeng.message.a.a parama)
  {
    this.b = parama;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (PushAgent.getInstance(paramContext).isIncludesUmengUpdateSDK())
      {
        Bundle localBundle = paramIntent.getBundleExtra("UpdateListener");
        if (localBundle.getInt("UpdateStatus") == 0)
        {
          Serializable localSerializable = localBundle.getSerializable("UpdateResponse");
          MsgLogStore.getInstance(paramContext).setMsgConfigInfo_UpdateResponse(localSerializable);
          UmengMessageHandler localUmengMessageHandler = (UmengMessageHandler)PushAgent.getInstance(paramContext).getMessageHandler();
          if (localUmengMessageHandler != null)
            localUmengMessageHandler.dealWithNotificationMessage(paramContext, this.b);
        }
        while (true)
        {
          LocalBroadcastManager.getInstance(paramContext).unregisterReceiver(this);
          return;
          UTrack.getInstance(paramContext).setClearPrevMessage(false);
          UTrack.getInstance(paramContext).trackMsgDismissed(this.b);
        }
      }
    }
    catch (Exception localException)
    {
      com.umeng.b.a.a.c(a, localException.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UpdateActionReceiver
 * JD-Core Version:    0.6.0
 */