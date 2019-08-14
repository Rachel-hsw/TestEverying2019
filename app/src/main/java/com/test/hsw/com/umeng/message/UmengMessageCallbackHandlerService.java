package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.umeng.message.a.a;
import com.umeng.message.b.dl;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class UmengMessageCallbackHandlerService extends Service
{
  public static final String TAG = UmengMessageCallbackHandlerService.class.getName();
  private Context a = this;

  public UmengMessageCallbackHandlerService()
  {
  }

  public UmengMessageCallbackHandlerService(String paramString)
  {
  }

  private void a(Context paramContext, a parama)
  {
    if ((PushAgent.getInstance(paramContext).isIncludesUmengUpdateSDK()) && ((!dl.c(paramContext)) || (!dl.b(paramContext)) || (PushAgent.getInstance(paramContext).getNotificationOnForeground())))
    {
      UpdateActionReceiver localUpdateActionReceiver = new UpdateActionReceiver(parama);
      IntentFilter localIntentFilter = new IntentFilter("com.umeng.message.action.autoupdate");
      LocalBroadcastManager.getInstance(paramContext).registerReceiver(localUpdateActionReceiver, localIntentFilter);
      try
      {
        Class localClass = Class.forName("com.umeng.update.UmengUpdateAgent");
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = Boolean.TYPE;
        Method localMethod1 = localClass.getMethod("setUpdateAutoPopup", arrayOfClass1);
        Method localMethod2 = localClass.getMethod("update", new Class[] { Context.class });
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = Boolean.TYPE;
        Method localMethod3 = localClass.getMethod("setUpdateFromPushMessage", arrayOfClass2);
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Boolean.valueOf(false);
        localMethod1.invoke(localClass, arrayOfObject1);
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Boolean.valueOf(true);
        localMethod3.invoke(localClass, arrayOfObject2);
        localMethod2.invoke(localClass, new Object[] { paramContext });
        Log.d(TAG, "autoUpdate");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Log.d(TAG, localException.toString());
        return;
      }
    }
    UTrack.getInstance(paramContext).setClearPrevMessage(false);
    UTrack.getInstance(paramContext).trackMsgDismissed(parama);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str = dl.a(this.a, Process.myPid());
    Log.d(TAG, "processName=" + str);
    if (paramIntent.getAction().equals("com.umeng.messge.registercallback.action"));
    while (true)
    {
      try
      {
        IUmengRegisterCallback localIUmengRegisterCallback = PushAgent.getInstance(this.a).getRegisterCallback();
        if (localIUmengRegisterCallback == null)
          continue;
        localIUmengRegisterCallback.onRegistered(paramIntent.getStringExtra("registration_id"));
        stopSelf();
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      if (paramIntent.getAction().equals("com.umeng.message.unregistercallback.action"))
      {
        try
        {
          IUmengUnregisterCallback localIUmengUnregisterCallback = PushAgent.getInstance(this.a).getUnregisterCallback();
          if (localIUmengUnregisterCallback == null)
            continue;
          localIUmengUnregisterCallback.onUnregistered(paramIntent.getStringExtra("registration_id"));
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
        continue;
      }
      if (paramIntent.getAction().equals("com.umeng.message.message.handler.action"))
      {
        try
        {
          UHandler localUHandler = PushAgent.getInstance(this.a).getMessageHandler();
          Log.d(TAG, "messageHandler=" + localUHandler);
          if (localUHandler == null)
            continue;
          a locala2 = new a(new JSONObject(paramIntent.getStringExtra("body")));
          locala2.i = paramIntent.getStringExtra("id");
          locala2.j = paramIntent.getStringExtra("task_id");
          localUHandler.handleMessage(this.a, locala2);
        }
        catch (Exception localException2)
        {
          Log.d(TAG, localException2.toString());
        }
        continue;
      }
      if (!paramIntent.getAction().equals("com.umeng.message.autoupdate.handler.action"))
        continue;
      try
      {
        a locala1 = new a(new JSONObject(paramIntent.getStringExtra("body")));
        locala1.i = paramIntent.getStringExtra("id");
        locala1.j = paramIntent.getStringExtra("task_id");
        a(this.a, locala1);
      }
      catch (Exception localException1)
      {
        Log.d(TAG, localException1.toString());
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengMessageCallbackHandlerService
 * JD-Core Version:    0.6.0
 */