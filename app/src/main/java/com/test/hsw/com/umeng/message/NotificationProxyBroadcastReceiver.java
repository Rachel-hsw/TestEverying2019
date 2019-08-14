package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationProxyBroadcastReceiver extends BroadcastReceiver
{
  public static final int EXTRA_ACTION_CLICK = 10;
  public static final int EXTRA_ACTION_DISMISS = 11;
  public static final int EXTRA_ACTION_NOT_EXIST = -1;
  public static final String EXTRA_KEY_ACTION = "ACTION";
  public static final String EXTRA_KEY_MESSAGE_ID = "MESSAGE_ID";
  public static final String EXTRA_KEY_MSG = "MSG";
  public static final String EXTRA_KEY_TASK_ID = "TASK_ID";
  public static final int LOCAL_ACTION_CLICK = 12;
  private static final String a = NotificationProxyBroadcastReceiver.class.getName();
  private UHandler b;

  private void a(Context paramContext)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    if (localIntent == null)
    {
      com.umeng.b.a.a.b(a, "handleMessage(): cannot find app: " + paramContext.getPackageName());
      return;
    }
    localIntent.setPackage(null);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    com.umeng.b.a.a.c(a, "handleMessage(): lunach app: " + paramContext.getPackageName());
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("MSG");
    try
    {
      int i = paramIntent.getIntExtra("ACTION", -1);
      String str2 = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = Integer.valueOf(i);
      com.umeng.b.a.a.c(str2, String.format("onReceive[msg=%s, action=%d]", arrayOfObject));
      if (i == 12)
      {
        a(paramContext);
        return;
      }
      locala = new com.umeng.message.a.a(new JSONObject(str1));
      locala.i = paramIntent.getStringExtra("MESSAGE_ID");
      locala.j = paramIntent.getStringExtra("TASK_ID");
      switch (i)
      {
      case 10:
        com.umeng.b.a.a.c(a, "click notification");
        UTrack.getInstance(paramContext).setClearPrevMessage(true);
        UTrack.getInstance(paramContext).trackMsgClick(locala);
        this.b = PushAgent.getInstance(paramContext).getNotificationClickHandler();
        if (this.b != null)
        {
          locala.E = true;
          this.b.handleMessage(paramContext, locala);
          return;
        }
      case 11:
      }
    }
    catch (JSONException localJSONException)
    {
      com.umeng.message.a.a locala;
      localJSONException.printStackTrace();
      return;
      com.umeng.b.a.a.c(a, "dismiss notification");
      UTrack.getInstance(paramContext).setClearPrevMessage(true);
      UTrack.getInstance(paramContext).trackMsgDismissed(locala);
      this.b = PushAgent.getInstance(paramContext).getNotificationClickHandler();
      if (this.b != null)
      {
        locala.E = false;
        this.b.handleMessage(paramContext, locala);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.NotificationProxyBroadcastReceiver
 * JD-Core Version:    0.6.0
 */