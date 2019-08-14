package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.b.a.a;

public class UmengMessageBootReceiver extends BroadcastReceiver
{
  private static final String b = UmengMessageBootReceiver.class.getName();
  private static final String c = "android.intent.action.BOOT_COMPLETED";
  Runnable a = new UmengMessageBootReceiver.1(this);
  private Context d;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a.c(b, "Boot this system , UmengMessageBootReceiver onReceive()");
      String str = paramIntent.getAction();
      if (str != null)
      {
        if (str.equals(""))
          return;
        a.c(b, "action=" + paramIntent.getAction());
        if (TextUtils.equals(paramIntent.getAction(), "android.intent.action.BOOT_COMPLETED"))
        {
          this.d = paramContext;
          new Thread(this.a).start();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      a.c(b, localException.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengMessageBootReceiver
 * JD-Core Version:    0.6.0
 */