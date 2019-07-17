package com.umeng.message;

import android.content.Context;
import com.umeng.b.a.a;
import org.android.agoo.client.BaseBroadcastReceiver;

public class RegistrationReceiver extends BaseBroadcastReceiver
{
  private static final String a = RegistrationReceiver.class.getName();

  protected String a(Context paramContext)
  {
    a.c(a, "RegistrationReceiver");
    return PushAgent.getInstance(paramContext).getPushIntentServiceClass();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.RegistrationReceiver
 * JD-Core Version:    0.6.0
 */