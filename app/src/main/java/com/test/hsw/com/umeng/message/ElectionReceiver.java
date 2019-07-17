package com.umeng.message;

import android.content.Context;
import com.umeng.b.a.a;
import org.android.agoo.client.BaseBroadcastReceiver;

public class ElectionReceiver extends BaseBroadcastReceiver
{
  private static final String a = ElectionReceiver.class.getName();

  protected String a(Context paramContext)
  {
    a.c(a, "ElectionReceiver");
    return PushAgent.getInstance(paramContext).getPushIntentServiceClass();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.ElectionReceiver
 * JD-Core Version:    0.6.0
 */