package com.umeng.message;

import android.content.Context;
import org.android.agoo.client.MessageReceiverService;

public class UmengMessageIntentReceiverService extends MessageReceiverService
{
  public String getIntentServiceClassName(Context paramContext)
  {
    return PushAgent.getInstance(paramContext).getPushIntentServiceClass();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengMessageIntentReceiverService
 * JD-Core Version:    0.6.0
 */